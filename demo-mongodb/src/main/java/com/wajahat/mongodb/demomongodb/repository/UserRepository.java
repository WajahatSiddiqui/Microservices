package com.wajahat.mongodb.demomongodb.repository;

import com.wajahat.mongodb.demomongodb.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Class Repository for User
 * Created by wajahat
 */
public interface UserRepository extends MongoRepository<User, Long> {
}
