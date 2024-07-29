package com.keyin.aug2024.sem4.sprint2.team1.api.classes.controllers;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.services.LocationService;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AgencyEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AddressEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.PhoneEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.VehicleEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.RentalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.UUID;
@RestController
@CrossOrigin
public final class LocationController {
    @Autowired
    private LocationService service;
    public LocationController() {
        this.service = new LocationService();
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
    public List<LocationEntity> getByAgency(@PathVariable AgencyEntity agency) {
        return service.getByAgency(agency);
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
    public List<LocationEntity> getByRental(@PathVariable RentalEntity rental) {
        return service.getByRental(rental);
    }
    @PostMapping("/api/locations")
    public LocationEntity add(@RequestBody LocationEntity location) {
        return service.add(location);
    }
    @PatchMapping("/api/locations/{pk}/agency")
    public LocationEntity editAgency(
        @PathVariable UUID pk,
        @RequestBody AgencyEntity agency
    ) {
        return service.editAgency(pk, agency);
    }
    @PatchMapping("/api/locations/{pk}/address")
    public LocationEntity editAddress(
        UUID pk,
        AddressEntity address
    ) {
        return service.editAddress(pk, address);
    }
    @PatchMapping("/api/locations/{pk}/phone")
    public LocationEntity editPhone(
        UUID pk,
        PhoneEntity phone
    ) {
        return service.editPhone(pk, phone);
    }
    @PatchMapping("/api/locations/{pk}/hours")
    public LocationEntity editHours(
        @PathVariable UUID pk,
        @RequestBody String hours
    ) {
        return service.editHours(pk, hours);
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