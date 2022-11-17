package com.warehouse.app.beans.product.product;

import com.warehouse.app.beans.category.Category;
import com.warehouse.app.beans.platform.FactoryPlatform;
import com.warehouse.app.beans.platform.Platform;
import com.warehouse.app.beans.category.FactoryCategory;
import com.warehouse.app.beans.product.situation.FactoryProductSituation;
import com.warehouse.app.beans.user.FactoryUser;
import com.warehouse.app.beans.product.situation.ProductSituation;
import com.warehouse.app.beans.user.User;
import com.warehouse.app.structures.DataStructure;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@AllArgsConstructor
@Component
public class FactoryProduct {

    @Autowired
    private ProductService service;
    @Autowired
    private FactoryPlatform factoryPlatform;
    @Autowired
    private FactoryCategory factoryCategory;
    @Autowired
    private FactoryUser factoryUser;
    @Autowired
    private FactoryProductSituation factorySituation;

    public Product getInstance(DataStructure<String, Object> dataStructure){
        Product product = new Product();
        Platform platform = parsePlatform(dataStructure);
        Category category = parseCategory(dataStructure);
        User user = parseUser(dataStructure);
        ProductSituation situation = parseSituation(dataStructure);

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
        }catch (Exception e){

        }

        return product;
    }

    private Platform parsePlatform(DataStructure<String, Object> dataStructure) {
        Long id_platform = dataStructure.getLongHard(Product.PLATFORM);
        return factoryPlatform.getInstance(id_platform);
    }

    private User parseUser(DataStructure<String, Object> dataStructure) {
        return null;
    }

    private Category parseCategory(DataStructure<String, Object> dataStructure) {
        return null;
    }

    private ProductSituation parseSituation(DataStructure<String, Object> dataStructure) {
        return null;
    }

}
