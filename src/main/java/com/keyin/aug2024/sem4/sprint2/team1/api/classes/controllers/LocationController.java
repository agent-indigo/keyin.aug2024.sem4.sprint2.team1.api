package com.keyin.aug2024.sem4.sprint2.team1.api.classes.controllers;


import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
public final class LocationController {
    @Autowired
    private LocationController service;
    public LocationController() {
        this.service = new LocationController();
    }
    @GetMapping("/api/locations")
    public List<LocationEntity> getAll() {
        return service.getAll();
    }
    @GetMapping("/api/locations/{pk}")
    public LocationEntity getByPk(@PathVariable UUID pk) {
        return service.getByPk(pk);
    }

    @GetMapping("/api/locations/{agency}")
    public List<LocationEntity> findAllByAgency(@PathVariable AgencyEntity agency) {
        return service.findAllByAgency(agency);
    }

    @GetMapping("/api/locations/{address}")
    public LocationEntity getByAddress(@PathVariable AddressEntity address) {
        return service.getByAddress(address);
    }

    @GetMapping("/api/locations/{phone}")
    public LocationEntity getByPhone(@PathVariable PhoneEntity phone) {
        return service.getByPhone(phone);
    }

    @GetMapping("/api/locations/{vehicle}")
    public LocationEntity getByVehicle(@PathVariable VehicleEntity vehicle) {
        return service.getByVehicle(vehicle);
    }

    @GetMapping("/api/locations/{rental}")
    public List<LocationEntity> findAllByRental(@PathVariable RentalEntity rental) {
        return service.findAllByRental(rental);
    }

    @PostMapping("/api/locations")
    public LocationEntity add(@RequestBody LocationEntity location) {
        return service.add(location);
    }

    @PatchMapping("/api/locations/{pk}/hrs")
    public LocationEntity updateHours(
            @PathVariable UUID pk,
            @RequestBody String hrs
    ) {
        return service.updateHours(pk, hrs);
    }

    @GetMapping("/api/locations/{pk}/activate")
    public LocationEntity activate(@PathVariable UUID pk) {

        return service.activate(pk);
    }

    @GetMapping("/api/locationss/{pk}/deactivate")
    public LocationEntity deactivate(@PathVariable UUID pk) {

        return service.deactivate(pk);
    }
}
