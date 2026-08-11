package com.example.demo.Repo;

import com.example.demo.Entity.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repo extends MongoRepository<Entity, ObjectId> {                      //primary or document entry and primary key

}
