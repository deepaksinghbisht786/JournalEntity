package com.example.demo.Component;

import com.example.demo.Entity.User;
import com.example.demo.Repo.UserRepo;
import com.example.demo.Service.JournalService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserComponent {
    @Autowired
    UserService userser;

    @GetMapping
    public List<User> getalluser(){
        return UserService.findalluser();
    }
//    @GetMapping("/{username}")
    @PostMapping
    public String addUser(@RequestBody User user){

    }
}
