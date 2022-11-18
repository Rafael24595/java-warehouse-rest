package com.warehouse.app.beans;

import com.warehouse.app.structures.DataStructure;

public interface WarehouseFactory <T> {

    public T getInstance(Long id);

    public T getInstance(DataStructure<Object> dataStructure);

}
