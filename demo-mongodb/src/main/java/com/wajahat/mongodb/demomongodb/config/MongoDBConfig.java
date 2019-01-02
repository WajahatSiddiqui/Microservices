package com.wajahat.mongodb.demomongodb.config;

import com.wajahat.mongodb.demomongodb.document.User;
import com.wajahat.mongodb.demomongodb.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Class Configuration for MongoDB
 * Created by wajahat
 */
@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            userRepository.save(User.builder().id(1L).name("Wajahat").email("wajahat.s@xyz.com").build());
            userRepository.save(User.builder().id(2L).name("Siddiqui").email("siddiqui.w@xyz.com").build());
        };
    }
}
