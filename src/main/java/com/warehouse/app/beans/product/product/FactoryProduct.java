package com.warehouse.app.beans.product.product;

import com.warehouse.app.beans.WarehouseFactory;
import com.warehouse.app.beans.category.Category;
import com.warehouse.app.beans.platform.FactoryPlatform;
import com.warehouse.app.beans.platform.Platform;
import com.warehouse.app.beans.category.FactoryCategory;
import com.warehouse.app.beans.product.collection.Collection;
import com.warehouse.app.beans.product.collection.FactoryCollection;
import com.warehouse.app.beans.product.situation.FactoryProductSituation;
import com.warehouse.app.beans.user.FactoryUser;
import com.warehouse.app.beans.product.situation.ProductSituation;
import com.warehouse.app.beans.user.User;
import com.warehouse.app.structures.DataStructure;
import com.warehouse.app.structures.ExceptionMessages;
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

    public Product getInstance(DataStructure<Object> dataStructure){
        DataStructure situationStructure = dataStructure.getStructureHard(Product.SITUATION_FK);
        Product product = new Product();
        Platform platform = parsePlatform(dataStructure);
        Category category = parseCategory(dataStructure);
        User user = parseUser(dataStructure);
        ProductSituation situation = parseSituation(situationStructure);
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
            product.setSituation(situation);
            product.setCollection(collection);
        }catch (Exception e){
            String message = MessageBuilder.build(ExceptionMessages.REQUEST.BAD_JSON_FORMAT, e.getMessage());
            throw new IllegalArgumentException(message);
        }

        return product;
    }

    private Platform parsePlatform(DataStructure<Object> dataStructure) {
        Long id = dataStructure.getLongHard(Product.PLATFORM);
        return factoryPlatform.getInstance(id);
    }

    private Category parseCategory(DataStructure<Object> dataStructure) {
        Long id = dataStructure.getLongHard(Product.CATEGORY);
        return factoryCategory.getInstance(id);
    }

    private User parseUser(DataStructure<Object> dataStructure) {
        Long id = dataStructure.getLongHard(Product.USER_AUDIT);
        return factoryUser.getInstance(id);
    }

    private ProductSituation parseSituation(DataStructure<Object> dataStructure) {
        return factorySituation.getInstance(dataStructure);
    }

    private Collection parseCollection(DataStructure<Object> dataStructure) {
        Long id = dataStructure.getLongHard(Product.COLLECTION_FK);
        return factoryCollection.getInstance(id);
    }

}
