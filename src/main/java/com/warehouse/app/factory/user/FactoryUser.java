package com.warehouse.app.factory.user;

import com.warehouse.app.factory.WarehouseFactory;
import com.warehouse.app.domain.user.User;
import com.warehouse.app.repository.user.UserRepository;
import com.warehouse.app.domain.DataMap;
import com.warehouse.app.constant.ExceptionMessages;
import com.warehouse.app.tools.MessageBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@Component
public class FactoryUser implements WarehouseFactory<User> {

    @Autowired
    private UserRepository repository;

    public User getInstance(Long id){
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()){
            String message = MessageBuilder.build(ExceptionMessages.REPOSITORY.NOT_FOUND_ID, "User", id);
            throw new NoSuchElementException(message);
        }
        return user.get();
    }

    public User getInstance(DataMap<Object> dataStructure){
        User user = new User();

        try {
            user.setNickName(dataStructure.getStringHard(User.NICKNAME));
            user.setPassword("******"); //TODO: Encrypt
            user.setName(dataStructure.getStringHard(User.NAME));
            user.setSurname1(dataStructure.getStringHard(User.SURNAME_1));
            user.setSurname2(dataStructure.getStringHard(User.SURNAME_2));
            user.setDateOrigen(new Date(System.currentTimeMillis()));
            user.setDateModify(new Date(System.currentTimeMillis()));
            user.setLevel(dataStructure.getIntegerHard(User.LEVEL));
        }catch (Exception e){
            String message = MessageBuilder.build(ExceptionMessages.REQUEST.BAD_JSON_FORMAT, e.getMessage());
            throw new IllegalArgumentException(message);
        }

        return user;
    }

}
