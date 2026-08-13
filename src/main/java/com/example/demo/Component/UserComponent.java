package com.example.demo.Component;

import com.example.demo.Entity.User;
import com.example.demo.Repo.UserRepo;
import com.example.demo.Service.JournalService;
import com.example.demo.Service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserComponent {
    @Autowired UserService userser;

    @GetMapping
    public List<User> getalluser(){
        return userser.findalluser();
    }
//    @GetMapping("/{username}")
    @PostMapping
    public String addUser(@RequestBody User user){
         return userser.Add(user);
    }

    @PutMapping("/{olduser}")
    public String updatevalue(@RequestBody User user, @PathVariable String olduser){
        return userser.updatevalue(user,olduser);
    }
    @DeleteMapping("/{deleteuser}")
    public String deleteuser(@PathVariable String deleteuser){
        return userser.deleteUser(deleteuser);
    }
}
