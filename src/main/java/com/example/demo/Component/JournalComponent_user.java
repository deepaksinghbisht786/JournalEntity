package com.example.demo.Component;


import com.example.demo.Entity.User;
import com.example.demo.Service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userJournal")
public class JournalComponent_user {
    @Autowired
    private JournalService service;


}
