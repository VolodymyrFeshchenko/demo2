package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class ServiceBean {
    private String serviceBean;
    @PostConstruct
    void setUp(){
        System.out.println("start ServiceBean");
    }
}
