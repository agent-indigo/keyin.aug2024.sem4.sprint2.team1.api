package com.keyin.aug2024.sem4.sprint2.team1.api.interfaces;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin
public interface Control {
    @DeleteMapping
    String delete(int pk);
}