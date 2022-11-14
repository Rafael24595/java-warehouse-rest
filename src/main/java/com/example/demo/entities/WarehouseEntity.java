package com.example.demo.entities;

public interface WarehouseEntity<T> {

    public T update(T entity);

    public T clone();

}
