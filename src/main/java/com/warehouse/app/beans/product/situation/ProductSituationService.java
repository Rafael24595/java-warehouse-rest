package com.warehouse.app.beans.product.situation;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductSituationService {

    @Autowired
    private final ProductSituationRepository productSituationRepository;

}
