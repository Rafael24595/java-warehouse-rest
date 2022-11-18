package com.warehouse.app.beans.user;

import com.warehouse.app.beans.WarehouseService;
import com.warehouse.app.beans.product.product.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService implements WarehouseService<User> {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public Optional<User> get(Long id) {
        return Optional.empty();
    }

    @Override
    public User insert(User entity) {
        return null;
    }

    @Override
    public User update(Long id, Product productUpdate) throws Exception {
        return null;
    }

    @Override
    public void delete(Product product) {

    }

    @Override
    public void delete(Long id) {

    }
}
