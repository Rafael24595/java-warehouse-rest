package com.warehouse.app.factory.product.situation;

import com.warehouse.app.factory.WarehouseFactory;
import com.warehouse.app.domain.product.product.Product;
import com.warehouse.app.factory.user.FactoryUser;
import com.warehouse.app.domain.user.User;
import com.warehouse.app.domain.product.situation.ProductSituation;
import com.warehouse.app.repository.product.situation.ProductSituationRepository;
import com.warehouse.app.domain.DataMap;
import com.warehouse.app.constant.ExceptionMessages;
import com.warehouse.app.tools.MessageBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Component
public class FactoryProductSituation implements WarehouseFactory<ProductSituation> {

    @Autowired
    private ProductSituationRepository repository;
    @Autowired
    private FactoryUser factoryUser;

    @Override
    public ProductSituation getInstance(Long id) {
        Optional<ProductSituation> productSituation = repository.findById(id);
        if(productSituation.isEmpty()){
            String message = MessageBuilder.build(ExceptionMessages.REPOSITORY.NOT_FOUND_ID, "ProductSituation", id);
            throw new NoSuchElementException(message);
        }
        return productSituation.get();
    }

    public ProductSituation getInstance(DataMap<Object> dataStructure, Product product) {
        Long situationNumber = getNextSituationNumber(product);
        ProductSituation productSituation = getInstance(dataStructure);
        productSituation.setProduct(product);
        productSituation.setNumberSituation(situationNumber);

        return productSituation;
    }

    @Override
    public ProductSituation getInstance(DataMap<Object> dataStructure) {
        ProductSituation productSituation = new ProductSituation();
        User user = parseUser(dataStructure);

        try {
            productSituation.setNameAlternate(dataStructure.getStringHard(ProductSituation.NAME_ALTERNATE));
            productSituation.setDescription(dataStructure.getStringHard(ProductSituation.DESCRIPTION));
            productSituation.setExtra01(dataStructure.getStringHard(ProductSituation.EXTRA_01));
            productSituation.setExtra02(dataStructure.getStringHard(ProductSituation.EXTRA_02));
            productSituation.setExtra03(dataStructure.getStringHard(ProductSituation.EXTRA_03));
            productSituation.setReference(dataStructure.getStringHard(ProductSituation.REFERENCE));
            productSituation.setRating(dataStructure.getIntegerHard(ProductSituation.RATING));
            productSituation.setAmount(dataStructure.getLongHard(ProductSituation.AMOUNT));
            productSituation.setTags(dataStructure.getStringHard(ProductSituation.TAGS));
            productSituation.setLocation(dataStructure.getStringHard(ProductSituation.LOCATION));
            productSituation.setImage01(dataStructure.getStringHard(ProductSituation.IMAGE_01));
            productSituation.setImage02(dataStructure.getStringHard(ProductSituation.IMAGE_02));
            productSituation.setImage03(dataStructure.getStringHard(ProductSituation.IMAGE_03));
            productSituation.setDateSituation(new Date(System.currentTimeMillis()));
            productSituation.setUserSituation(user);
            productSituation.setComment(dataStructure.getStringHard(ProductSituation.COMMENT));
        }catch (Exception e){
            String message = MessageBuilder.build(ExceptionMessages.REQUEST.BAD_JSON_FORMAT, e.getMessage());
            throw new IllegalArgumentException(message);
        }

        return productSituation;
    }

    private Long getNextSituationNumber(Product product) {
        Optional<ProductSituation> lastSituation = repository.findFirstByProductOrderByNumberSituationDesc(product);
        if(lastSituation.isPresent())
            return lastSituation.get().getNumberSituation() + 1;
        return 1L;
    }
    private User parseUser(DataMap<Object> dataStructure) {
        Long id = dataStructure.getLongHard(Product.USER_AUDIT);
        return factoryUser.getInstance(id);
    }

}
