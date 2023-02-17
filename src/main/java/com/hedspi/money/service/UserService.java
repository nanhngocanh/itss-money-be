package com.hedspi.money.service;

import com.hedspi.money.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void delete(int id) {
        userRepository.deleteById(id);
    }

}
