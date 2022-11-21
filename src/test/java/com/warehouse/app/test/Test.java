package com.warehouse.app.test;

import com.warehouse.app.beans.product.situation.ProductSituation;
import com.warehouse.app.beans.product.situation.ProductSituationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
public class Test {

    @Autowired
    ProductSituationRepository repository;

    @org.junit.jupiter.api.Test
    public void x() {
        Optional<ProductSituation> y = repository.findFirstByProductOrderByProductSituationNumberSituationDesc((long)1);
        y = y;
        String z = "";
    }

}
