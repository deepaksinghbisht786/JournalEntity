package com.example.demo.Component;


import com.example.demo.Entity.Entity;
import com.example.demo.Service.Journal_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userJournal")
public class JournalComponent_user {
    @Autowired
    private Journal_Service service;

    @PostMapping("/{user}")
    public String createuserJournal(@RequestBody Entity entity, @PathVariable String user){
        return service.createJournal(entity,user);
    }

    @GetMapping("/{user}")
    public ResponseEntity<List<Entity>> getuserJour(@PathVariable String user){
        return service.getuserJournals(user);
    }

}
