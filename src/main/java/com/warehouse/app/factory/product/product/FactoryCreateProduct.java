package com.warehouse.app.factory.product.product;

import com.warehouse.app.factory.category.FactoryCategory;
import com.warehouse.app.factory.platform.FactoryPlatform;
import com.warehouse.app.factory.product.collection.FactoryCollection;
import com.warehouse.app.factory.product.situation.FactoryProductSituation;
import com.warehouse.app.repository.product.situation.ProductSituationRepository;
import com.warehouse.app.factory.user.FactoryUser;
import com.warehouse.app.domain.product.product.Product;
import com.warehouse.app.repository.product.product.ProductRepository;
import com.warehouse.app.domain.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FactoryCreateProduct extends FactoryProduct {

    @Autowired
    private ProductSituationRepository situationRepository;

    public FactoryCreateProduct(ProductRepository repository, FactoryPlatform factoryPlatform, FactoryCategory factoryCategory, FactoryUser factoryUser, FactoryProductSituation factorySituation, FactoryCollection factoryCollection) {
        super(repository, factoryPlatform, factoryCategory, factoryUser, factorySituation, factoryCollection);
    }

    public Product save(DataMap<Object> dataStructure) {
        ProductRepository repository = getRepository();
        Product product = getInstance(dataStructure);
        product = repository.save(product);
        product = getInstance(product.getId(), dataStructure);
        situationRepository.save(product.getSituation());
        return product;
    }

}