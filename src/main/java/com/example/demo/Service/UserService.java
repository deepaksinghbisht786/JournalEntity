package com.example.demo.Service;

import com.example.demo.Entity.Entity;
import com.example.demo.Entity.User;
import com.example.demo.Repo.UserRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Optional;


@Service
public class UserService {


    @Autowired
    UserRepo repo;

    public List<User> findalluser() {
        return repo.findAll();
    }

    public String Add(User abc) {
        if (abc != null) {
            repo.save(abc);
            return "added";
        }
        return "not added";
    }

    public String updatevalue(User user, String olduser) {
        if (user != null && olduser != null) {
            Optional<User> exist = repo.findByuserName(olduser);
            if (exist.isPresent()) {
                User founduser = exist.get();
                founduser.setUserName(user.getUserName());
                founduser.setPassword(user.getPassword());
                repo.save(founduser);
                return "updated";
            }
//            } else {
////                repo.save(user);     //not right  because  we are direclty saving the user without varification in db
////                return " not found but saved ";
//            }
        }
        return "not found";

    }



    public String deleteUser(String user) {
        Optional<User> exist= repo.findByuserName(user);
        if(exist.isPresent()){
            User founduser= exist.get();
            repo.delete(founduser);
            return "deleted " +user;
        }
        return "no userfound";
    }
    }




