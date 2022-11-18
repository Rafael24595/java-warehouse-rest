package com.warehouse.app.beans.product.situation;

import com.warehouse.app.beans.WarehouseFactory;
import com.warehouse.app.beans.category.Category;
import com.warehouse.app.beans.user.FactoryUser;
import com.warehouse.app.structures.DataStructure;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FactoryProductSituation implements WarehouseFactory<ProductSituation> {

    @Autowired
    private ProductSituationService productSituationService;
    @Autowired
    private FactoryUser factoryUser;

    @Override
    public ProductSituation getInstance(Long id) {
        return null;
    }

    @Override
    public ProductSituation getInstance(DataStructure<Object> dataStructure) {
        return null;
    }
}
