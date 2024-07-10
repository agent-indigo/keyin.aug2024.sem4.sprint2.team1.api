package com.keyin.aug2024.finals.team1.api.classes.abstracts;
import org.springframework.stereotype.Controller;
@Controller
public abstract class RouteController {
    protected String collectionRoute;
    protected String entryRoute;
    public RouteController(String entity) {
        this.collectionRoute = "/" + entity.toLowerCase() + "s";
        this.entryRoute = "/" + entity.toLowerCase() + "s/{id}";
    }
}