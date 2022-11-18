package com.warehouse.app.beans;

public interface WarehouseEntity<T> {

    public T update(T entity);

    public T clone();

}
