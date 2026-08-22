package com.example.demo.Component;


import com.example.demo.Entity.Entity;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JournalComponent {
    @Autowired
    private JournalService service;
// finding all element
    @GetMapping("journal")
    public List<Entity> Testingget() {
        return service.findallin();
    }
//finding specific element
    @GetMapping("journal/{idd}")    //through pathvariable
    public ResponseEntity<Entity> specifjournal(@PathVariable ObjectId idd) {
        return service.findbyid(idd);
    }


    @PostMapping() //creating and eliment
    public String AddJournaleli(@RequestBody Entity abc) {
       return service.AddJournal(abc);

    }

//updating
//
    @PostMapping("/{idd}")
    public String Updatebody(@PathVariable ObjectId idd, @RequestBody Entity neww) {
//        //if exist nahi karti hai toh bana do
//        //agar exist karti hai toh update kar do
        //agar changes nahi hai toh same rahne do yeh optional ho sakta hai if can use when we have to optimize it
        return service.update(neww, idd);
    }
//
//    //delete
//
    @DeleteMapping("/del/{idd}")
    public String dell(@PathVariable ObjectId idd) {
    return service.delete(idd);
    }
}