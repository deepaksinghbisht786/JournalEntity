package com.example.demo.Repo;

import com.example.demo.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends MongoRepository<User, ObjectId> {

    Optional<User> findByuserName(String username);

    @Query(value = "{}", fields = "{ 'userName' : 1, '_id' : 0 }")
    List<User> findAllUsernamesOnly();//primary or document entry and primary key
}
