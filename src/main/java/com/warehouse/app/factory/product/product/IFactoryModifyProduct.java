package com.warehouse.app.factory.product.product;

import com.warehouse.app.domain.DataMap;
import com.warehouse.app.domain.product.product.Product;

public interface IFactoryModifyProduct {

    public Product update(Long id, DataMap<Object> dataStructure);

}
