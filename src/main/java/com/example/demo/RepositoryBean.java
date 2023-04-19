package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository("test2")
public class RepositoryBean {

    private String RepositoryBean;
    @PostConstruct
    void setUp(){
        System.out.println("start RepositoryBean");
    }
}
