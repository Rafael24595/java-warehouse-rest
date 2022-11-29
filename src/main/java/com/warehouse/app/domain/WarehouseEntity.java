package com.warehouse.app.domain;

public interface WarehouseEntity<T> {

    public T update(T entity);

    public T clone();

}
