package com.example.demo.Service;


import com.example.demo.Entity.Entity;
import com.example.demo.Entity.User;
import com.example.demo.Repo.Journalrepo;
import com.example.demo.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Journal_Service {
    @Autowired private UserRepo repoo;


    @Autowired private Journalrepo journalrepo;

    public String createJournal(Entity abc, String username){
    Optional<User> exist= repoo.findByuserName(username);
    if(exist.isPresent()){
        journalrepo.save(abc);
        User user= exist.get();
        user.getJournals().add(abc);
        repoo.save(user);
        return "added to " + username;
    }
    return "user not found create one";
    }

    public ResponseEntity<List<Entity>> getuserJournals (String username) {
        Optional<User> exist = repoo.findByuserName(username);
        if (exist.isPresent()) {
            return ResponseEntity.ok(exist.get().getJournals());
        }
     return ResponseEntity.notFound().build();
    }

}
