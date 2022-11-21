package com.warehouse.app.beans;

import com.warehouse.app.beans.platform.Platform;
import com.warehouse.app.beans.product.product.Product;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface WarehouseService<T> {
    public List<T> getAll();
    public Optional<T> get(Long id);
    public T insert(T entity);
    public T update(Long id, T entity) throws Exception;
    public void delete(T entity);
    public void delete(Long id);
}
