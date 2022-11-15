package com.warehouse.app.beans.product;

import com.warehouse.app.structures.DataStructure;
import com.warehouse.app.beans.product.product.Product;

import java.util.Map;

public class FactoryCreateProduct {

    private Product product;

    private FactoryCreateProduct(Product product) {
        this.product = product;
    }

    private FactoryCreateProduct(DataStructure<String, Object> payload) {

    }

    private Product parsePayload(DataStructure<String, Object> payload){
        Product parseProduct = new Product();

        return parseProduct;
    }

}
