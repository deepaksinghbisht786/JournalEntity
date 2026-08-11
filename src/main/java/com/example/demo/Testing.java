package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testing {
    @GetMapping("/test/{id}")
    public String test(@PathVariable int id){
        return "testing " +id;
    }
}
