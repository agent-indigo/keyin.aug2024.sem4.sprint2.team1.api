package com.keyin.aug2024.sem4.sprint2.team1.api.classes.controllers;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AgencyEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.RentalEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.VehicleEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.services.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;
@RestController
@CrossOrigin
public final class AgencyController {
    @Autowired
    private AgencyService service;
    public AgencyController() {
        this.service = new AgencyService();
    }
    @GetMapping("/api/agencies")
    public List<AgencyEntity> getAll() {
        return service.getAll();
    }
    @GetMapping("/api/agencies/{pk}")
    public AgencyEntity getByPk(@PathVariable UUID pk) {
        return service.getByPk(pk);
    }
    @GetMapping("/api/agencies/{name}")
    public AgencyEntity getByName(@PathVariable String name) {
        return service.getByName(name);
    }
    @GetMapping("/api/agencies/{website}")
    public AgencyEntity getByWebsite(@PathVariable String website) {
        return service.getByWebsite(website);
    }
    @GetMapping("/api/agencies/{location}")
    public AgencyEntity getByLocation(@PathVariable LocationEntity location) {
        return service.getByLocation(location);
    }
    @GetMapping("/api/agencies/{contact}")
    public AgencyEntity getByContact(@PathVariable ContactEntity contact) {
        return service.getByContact(contact);
    }
    @GetMapping("/api/agencies/{vehicle}")
    public AgencyEntity getByVehicle(@PathVariable VehicleEntity vehicle) {
        return service.getByVehicle(vehicle);
    }
    @GetMapping("/api/agencies/{rental}")
    public AgencyEntity getByRental(@PathVariable RentalEntity rental) {
        return service.getByRental(rental);
    }
    @GetMapping("/api/agencies/active")
    public List<AgencyEntity> getActive() {
        return service.getActive();
    }
    @GetMapping("/api/agencies/inactive")
    public List<AgencyEntity> getInactive() {
        return service.getInactive();
    }
    @PostMapping("/api/agencies")
    public AgencyEntity add(@RequestBody AgencyEntity agency) {
        return service.add(agency);
    }
    @PatchMapping("/api/agencies/{pk}/name")
    public AgencyEntity rename(
        @PathVariable UUID pk,
        @RequestBody String name
    ) {
        return service.rename(pk, name);
    }
    @PatchMapping("/api/agencies/{pk}/website")
    public AgencyEntity editWebsite(
        @PathVariable UUID pk,
        @RequestBody String website
    ) {
        return service.editWebsite(pk, website);
    }
    @GetMapping("/api/agencies/{pk}/activate")
    public AgencyEntity activate(@PathVariable UUID pk) {
        return service.activate(pk);
    }
    @GetMapping("/api/agencies/{pk}/deactivate")
    public AgencyEntity deactivate(@PathVariable UUID pk) {
        return service.deactivate(pk);
    }
}