package com.warehouse.app.factory;

import com.warehouse.app.domain.DataMap;

public interface WarehouseFactory <T> {

    public T getInstance(Long id);

    public T getInstance(DataMap<Object> dataStructure);

}
