package com.example.tcc_gym_management.repositories;

import com.example.tcc_gym_management.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public User findByUserName(String userName);
}
