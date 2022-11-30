package com.warehouse.app.factory.product.product;

import com.warehouse.app.domain.DataMap;
import com.warehouse.app.domain.product.product.Product;

public interface IFactoryCreateProduct {

    public Product save(DataMap<Object> dataStructure);

}
