package com.keyin.aug2024.sem4.sprint2.team1.api.classes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages = {
    "com.keyin.aug2024.finals.team1.api.classes.controllers",
    "com.keyin.aug2024.finals.team1.api.classes.entities",
    "com.keyin.aug2024.finals.team1.api.classes.services",
    "com.keyin.aug2024.finals.team1.api.interfaces.repositories"
})
public class App {
    public App() {}
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}