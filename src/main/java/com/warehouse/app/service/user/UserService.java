package com.warehouse.app.service.user;

import com.warehouse.app.service.WarehouseService;
import com.warehouse.app.domain.user.User;
import com.warehouse.app.repository.user.UserRepository;
import com.warehouse.app.constant.ExceptionMessages;
import com.warehouse.app.tools.MessageBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService implements WarehouseService<User> {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> get(Long id) {
        return repository.findById(id);
    }

    @Override
    public User insert(User user) {
        return repository.save(user);
    }

    @Override
    public User update(Long id, User userUpdate) throws Exception {
        if(!repository.existsById(id)){
            String message = MessageBuilder.build(ExceptionMessages.REPOSITORY.NOT_FOUND_ID, "User", id);
            throw new NoSuchElementException(message);
        }
        User user = get(id).get();
        user.update(userUpdate);
        return repository.save(user);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
