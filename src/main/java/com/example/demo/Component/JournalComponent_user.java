package com.example.demo.Component;


import com.example.demo.Entity.Entity;
import com.example.demo.Service.Journal_Service;
import org.bson.types.ObjectId;
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
    public String createuserJournal(@RequestBody Entity entity, @PathVariable String user) {
        return service.createJournal(entity, user);
    }

    @GetMapping("/{user}")
    public ResponseEntity<List<Entity>> getuserJour(@PathVariable String user) {
        return service.getuserJournals(user);
    }

    @DeleteMapping("/{user}")
    public String delete(@PathVariable String user) {
        return service.getUserJournaldel(user);
    }

    @DeleteMapping("deleteall")
    public String deleteallthings() {
        return service.deltealll();
    }

    @PutMapping("/{userr}/{id}")
    public String updatejournal(@PathVariable String userr, @PathVariable ObjectId id, @RequestBody Entity abc) {
        return service.updateJournals(userr, id, abc);
    }

    @DeleteMapping("{user}/{id}")
    public String deleteJounalbyid(ObjectId id, String user) {
        return service.deletebyId(id, user);
    }
}
