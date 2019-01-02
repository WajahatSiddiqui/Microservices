package com.wajahat.mongodb.demomongodb.web;

import com.wajahat.mongodb.demomongodb.document.User;
import com.wajahat.mongodb.demomongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class Controller for User
 * Created by wajahat
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    List<User> getUsers() {
        return userRepository.findAll();
    }
}
