package com.example.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@SpringBootApplication
@Configuration
public class Demo2Application {
    @Bean
    String string() {
        return "boo!";
    }
    @Bean
    String string2() {
        return "boo!!!";
    }
    @PostConstruct
    void setUp(){
        System.out.println("start Bean");
    }
    public static void main(String[] args) {

        var context = SpringApplication.run(Demo2Application.class, args);
        var bean1 = context.getBean(MyTestController.class);
        System.out.println(bean1);
        var bean2 = context.getBean("string");
//        var bean2 = context.getBean(String.class);
        System.out.println(bean2);
        var bean3 = context.getBean(ComponentBean.class);
        System.out.println(bean3);
        var bean4 = context.getBean(RepositoryBean.class);
        System.out.println(bean4);
        var bean5 = context.getBean(ServiceBean.class);
        System.out.println(bean5);
    }
}
