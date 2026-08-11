package com.example.demo.Repo;

import com.example.demo.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<User, ObjectId> {

    Optional<User> findByuserName(String username);
}
