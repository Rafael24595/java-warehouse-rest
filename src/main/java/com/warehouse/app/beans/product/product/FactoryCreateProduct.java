package com.warehouse.app.beans.product.product;

import com.warehouse.app.beans.category.FactoryCategory;
import com.warehouse.app.beans.platform.FactoryPlatform;
import com.warehouse.app.beans.product.collection.FactoryCollection;
import com.warehouse.app.beans.product.situation.FactoryProductSituation;
import com.warehouse.app.beans.product.situation.ProductSituationRepository;
import com.warehouse.app.beans.user.FactoryUser;
import com.warehouse.app.structures.DataStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FactoryCreateProduct extends FactoryProduct {

    @Autowired
    private ProductSituationRepository situationRepository;

    public FactoryCreateProduct(ProductRepository repository, FactoryPlatform factoryPlatform, FactoryCategory factoryCategory, FactoryUser factoryUser, FactoryProductSituation factorySituation, FactoryCollection factoryCollection) {
        super(repository, factoryPlatform, factoryCategory, factoryUser, factorySituation, factoryCollection);
    }

    public Product save(DataStructure<Object> dataStructure) {
        ProductRepository repository = getRepository();
        Product product = getInstance(dataStructure);
        product = repository.save(product);
        product = getInstance(product.getId(), dataStructure);
        situationRepository.save(product.getSituation());
        return product;
    }

}