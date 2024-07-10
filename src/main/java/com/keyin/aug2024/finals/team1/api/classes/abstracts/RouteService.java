package com.keyin.aug2024.finals.team1.api.classes.abstracts;
public abstract class RouteService {
    protected String collectionRoute;
    protected String entryRoute;
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
        this.collectionRoute = "/" + entity + "s";
        this.entryRoute = "/" + entity + "s/{id}";
        this.error400message = "error 404: bad request";
        this.error401message = "error 401: unauthorized";
        this.error403message = "error 403: forbidden";
        this.error404message = "error 404: " + entity + " not found";
        this.error500message = "error 500: internal server error";
        this.error502message = "error 502: bad gateway";
        this.status200message = "status 200: " + entity + " successfully updated";
        this.status201message = "status 201: " + entity + " successfully created";
        this.status204message = "status 204: " + entity + " successfully deleted";
    }
}