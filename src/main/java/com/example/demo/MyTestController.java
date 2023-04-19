package com.example.demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "test")
public class MyTestController {
@GetMapping("/test")
    public String test(){
        return "index.html";
    }

    @PostConstruct
    void setUp(){
    System.out.println("start MyTestController");
    }

    @PreDestroy
    void close(){
    System.out.println("are you killsng me?");
    }
}

// http://localhost:8080/test
