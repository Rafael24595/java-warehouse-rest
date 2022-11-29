package com.warehouse.app.factory.product.product;

import com.warehouse.app.factory.WarehouseFactory;
import com.warehouse.app.domain.category.Category;
import com.warehouse.app.factory.platform.FactoryPlatform;
import com.warehouse.app.domain.platform.Platform;
import com.warehouse.app.factory.category.FactoryCategory;
import com.warehouse.app.domain.product.collection.Collection;
import com.warehouse.app.factory.product.collection.FactoryCollection;
import com.warehouse.app.factory.product.situation.FactoryProductSituation;
import com.warehouse.app.factory.user.FactoryUser;
import com.warehouse.app.domain.product.situation.ProductSituation;
import com.warehouse.app.domain.user.User;
import com.warehouse.app.domain.product.product.Product;
import com.warehouse.app.repository.product.product.ProductRepository;
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
public class FactoryProduct implements WarehouseFactory<Product> {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private FactoryPlatform factoryPlatform;
    @Autowired
    private FactoryCategory factoryCategory;
    @Autowired
    private FactoryUser factoryUser;
    @Autowired
    private FactoryProductSituation factorySituation;
    @Autowired
    private FactoryCollection factoryCollection;

    @Override
    public Product getInstance(Long id) {
        Optional<Product> product = repository.findById(id);
        if(product.isEmpty()){
            String message = MessageBuilder.build(ExceptionMessages.REPOSITORY.NOT_FOUND_ID, "Product", id);
            throw new NoSuchElementException(message);
        }
        return product.get();
    }

    public Product getInstance(Long id, DataMap<Object> dataStructure) {
        Product product = getInstance(id);
        DataMap situationStructure = dataStructure.getStructureHard(Product.SITUATION_FK);
        ProductSituation situation = factorySituation.getInstance(situationStructure, product);

        try {
            product.setSituation(situation);
        }catch (Exception e){
            String message = MessageBuilder.build(ExceptionMessages.REQUEST.BAD_JSON_FORMAT, e.getMessage());
            throw new IllegalArgumentException(message);
        }

        return product;
    }

    public Product getInstance(DataMap<Object> dataStructure) {
        Product product = new Product();
        Platform platform = parsePlatform(dataStructure);
        Category category = parseCategory(dataStructure);
        User user = parseUser(dataStructure);
        Collection collection = parseCollection(dataStructure);

        try {
            product.setName(dataStructure.getStringHard(Product.NAME));
            product.setVersion(dataStructure.getStringHard(Product.VERSION));
            product.setPlatform(platform);
            product.setFormat(dataStructure.getStringHard(Product.FORMAT));
            product.setRegion(dataStructure.getStringHard(Product.REGION));
            product.setCategory(category);
            product.setDateOrigen(new Date(System.currentTimeMillis()));
            product.setUserAudit(user);
            product.setCollection(collection);
        }catch (Exception e){
            String message = MessageBuilder.build(ExceptionMessages.REQUEST.BAD_JSON_FORMAT, e.getMessage());
            throw new IllegalArgumentException(message);
        }

        return product;
    }

    private Platform parsePlatform(DataMap<Object> dataStructure) {
        Long id = dataStructure.getLongHard(Product.PLATFORM);
        return factoryPlatform.getInstance(id);
    }

    private Category parseCategory(DataMap<Object> dataStructure) {
        Long id = dataStructure.getLongHard(Product.CATEGORY);
        return factoryCategory.getInstance(id);
    }

    private User parseUser(DataMap<Object> dataStructure) {
        Long id = dataStructure.getLongHard(Product.USER_AUDIT);
        return factoryUser.getInstance(id);
    }

    private Collection parseCollection(DataMap<Object> dataStructure) {
        Long id = dataStructure.getLongHard(Product.COLLECTION_FK);
        return id == null ? null : factoryCollection.getInstance(id);
    }

    protected ProductRepository getRepository() {
        return this.repository;
    }

}
