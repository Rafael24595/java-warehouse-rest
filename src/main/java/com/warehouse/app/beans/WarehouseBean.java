package com.warehouse.app.beans;

public interface WarehouseBean<T> {

    public T update(T entity);

    public T clone();

}
