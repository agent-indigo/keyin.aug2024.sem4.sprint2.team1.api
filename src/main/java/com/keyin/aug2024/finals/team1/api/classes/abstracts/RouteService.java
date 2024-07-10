package com.keyin.aug2024.finals.team1.api.classes.abstracts;
import org.springframework.stereotype.Service;
@Service
public abstract class RouteService {
    protected String error400message;
    protected String error401message;
    protected String error403message;
    protected String error404message;
    protected String error500message;
    protected String error502message;
    protected String status200message;
    protected String status201message;
    protected String status204message;
    public RouteService(String entity) {
        this.error400message = "Error: 404 - Bad Request";
        this.error401message = "Error: 401 - Unauthorized";
        this.error403message = "Error: 403 - Forbidden";
        this.error404message = "Error: 404 - " + entity + " not found";
        this.error500message = "Error: 500 - Internal Server Error";
        this.error502message = "error 502: bad gateway";
        this.status200message = "Status: 200 - " + entity + " Successfully Updated";
        this.status201message = "Status: 201 - " + entity + " Successfully Created";
        this.status204message = "Status: 204 - " + entity + " Successfully Deleted";
    }
}