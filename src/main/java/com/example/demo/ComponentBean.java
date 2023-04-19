package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class ComponentBean {
private String component;

    @PostConstruct
    void setUp(){
        System.out.println("start ComponentBean");
    }
}
