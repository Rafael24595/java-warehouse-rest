package com.warehouse.app.beans.product.situation;

import com.warehouse.app.beans.user.FactoryUser;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class FactoryProductSituation {

    @Autowired
    private ProductSituationService productSituationService;
    @Autowired
    private FactoryUser factoryUser;

}
