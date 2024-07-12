package com.keyin.aug2024.sem4.sprint2.team1.api.interfaces;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
@Controller
public interface Control {
    @DeleteMapping
    void delete(int pk);
}