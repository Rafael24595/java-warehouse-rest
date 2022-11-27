package com.warehouse.app.beans.product.product;

import com.warehouse.app.beans.category.FactoryCategory;
import com.warehouse.app.beans.platform.FactoryPlatform;
import com.warehouse.app.beans.product.collection.FactoryCollection;
import com.warehouse.app.beans.product.situation.FactoryProductSituation;
import com.warehouse.app.beans.product.situation.ProductSituation;
import com.warehouse.app.beans.product.situation.ProductSituationRepository;
import com.warehouse.app.beans.user.FactoryUser;
import com.warehouse.app.structures.DataStructure;
import com.warehouse.app.structures.ExceptionMessages;
import com.warehouse.app.tools.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FactoryManageProduct extends FactoryProduct {

    @Autowired
    private ProductSituationRepository situationRepository;

    public FactoryManageProduct(ProductRepository repository, FactoryPlatform factoryPlatform, FactoryCategory factoryCategory, FactoryUser factoryUser, FactoryProductSituation factorySituation, FactoryCollection factoryCollection) {
        super(repository, factoryPlatform, factoryCategory, factoryUser, factorySituation, factoryCollection);
    }

    public Product saveProduct(DataStructure<Object> dataStructure) {
        ProductRepository repository = getRepository();
        Product product = getInstance(dataStructure);
        product = repository.save(product);
        product = getInstance(product.getId(), dataStructure);
        situationRepository.save(product.getSituation());
        return product;
    }

    public Product updateProduct(Long id, DataStructure<Object> dataStructure) {
        Product oldProduct = getInstance(id);
        ProductSituation oldSituation = oldProduct.getSituation();
        Product newProduct = getInstance(id, dataStructure);
        ProductSituation newSituation = newProduct.getSituation();

        if (compareSituations(oldSituation, newSituation))
            return oldProduct;

        situationRepository.save(newProduct.getSituation());
        return newProduct;
    }

    public boolean compareSituations(ProductSituation situationA, ProductSituation situationB) {
        Long aProductFk = situationA.getProduct().getId();
        Long bProductFk = situationB.getProduct().getId();
        if(aProductFk != bProductFk){
            String message = MessageBuilder.build(ExceptionMessages.STRUCTURE.INVALID_SITUATION_FK, aProductFk, bProductFk);
            throw new IllegalArgumentException(message);
        }

        try {
            compareString(situationA.getNameAlternate(), situationB.getNameAlternate());
            compareString(situationA.getDescription(), situationB.getDescription());
            compareString(situationA.getExtra01(), situationB.getExtra01());
            compareString(situationA.getExtra02(), situationB.getExtra02());
            compareString(situationA.getExtra03(), situationB.getExtra03());
            compareString(situationA.getReference(), situationB.getReference());
            compareNumber(situationA.getRating(), situationB.getRating());
            compareString(situationA.getComment(), situationB.getComment());
            compareNumber(situationA.getAmount(), situationB.getAmount());
            compareString(situationA.getLocation(), situationB.getLocation());
            compareString(situationA.getImage01(), situationB.getImage01());
            compareString(situationA.getImage02(), situationB.getImage02());
            compareString(situationA.getImage03(), situationB.getImage03());
            compareString(situationA.getComment(), situationB.getComment());
        }catch (IllegalArgumentException e){
            return false;
        }
        return true;
    }

    private boolean compareString(String stringA, String stringB){
        if((stringA == null && stringB == null) || stringA.equals(stringB))
            return true;
        throw new IllegalArgumentException("");
    }

    private boolean compareNumber(Number numberA, Number numberB){
        if(numberA == numberB)
            return true;
        throw new IllegalArgumentException("");
    }

}