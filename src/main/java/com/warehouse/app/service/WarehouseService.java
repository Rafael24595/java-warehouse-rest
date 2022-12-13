package com.warehouse.app.service;

import com.warehouse.app.domain.DataMap;

import java.util.List;
import java.util.Optional;

public interface WarehouseService<T> {
    public List<T> getAll();
    public Optional<T> get(Long id);
    public T insert(DataMap<Object> payload);
    public T update(Long id, DataMap<Object> payload) throws Exception;
    public void delete(T entity);
    public void delete(Long id);
}
