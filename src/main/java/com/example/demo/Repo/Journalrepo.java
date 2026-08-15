package com.example.demo.Repo;

import com.example.demo.Entity.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface Journalrepo extends MongoRepository<Entity, ObjectId> {


}
