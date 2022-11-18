package com.warehouse.app.beans;

import com.warehouse.app.beans.product.product.Product;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface WarehouseService<T> {
    public List<T> getAll();
    public Optional<T> get(Long id);
    public T insert(T entity);
    public T update(Long id, Product productUpdate) throws Exception;
    public void delete(Product product);
    public void delete(Long id);
}
