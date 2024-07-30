package com.keyin.aug2024.sem4.sprint2.team1.api.classes.controllers;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AgencyEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.RentalEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.VehicleEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
@RestController
@CrossOrigin
public final class RentalController {
    @Autowired
    private RentalService service;
    public RentalController() {
        this.service = new RentalService();
    }
    @GetMapping("/api/rentals")
    public List<RentalEntity> getAll() {
        return service.getAll();
    }
    @GetMapping("/api/rentals/{pk}")
    public RentalEntity getByPk(@PathVariable UUID pk) {
        return service.getByPk(pk);
    }
    @GetMapping("/api/rentals/{vehicle}")
    public List<RentalEntity> getByVehicle(@PathVariable VehicleEntity vehicle) {
        return service.getByVehicle(vehicle);
    }
    @GetMapping("/api/rentals/{contact}")
    public List<RentalEntity> getByContact(@PathVariable ContactEntity contact) {
        return service.getByContact(contact);
    }
    @GetMapping("/api/rentals/{license}")
    public List<RentalEntity> getByLicense(@PathVariable String license) {
        return service.getByLicense(license);
    }
    @GetMapping("/api/rentals/{agency}")
    public List<RentalEntity> getByAgency(@PathVariable AgencyEntity agency) {
        return service.getByAgency(agency);
    }
    @GetMapping("/api/rentals/rentedFrom/{location}")
    public List<RentalEntity> getByRentedFrom(@PathVariable LocationEntity location) {
        return service.getByRentedFrom(location);
    }
    @GetMapping("/api/rentals/rentedOn/{date}")
    public List<RentalEntity> getByRentedOn(@PathVariable ZonedDateTime date) {
        return service.getByRentedOn(date);
    }
    @GetMapping("/api/rentals/dueToday")
    public List<RentalEntity> getDueToday() {
        return service.getDueToday();
    }
    @GetMapping("/api/rentals/dueOn/{date}")
    public List<RentalEntity> getDueOn(@PathVariable ZonedDateTime date) {
        return service.getDueOn(date);
    }
    @GetMapping("/api/rentals/returnedOn/{date}")
    public List<RentalEntity> getByReturnedOn(@PathVariable ZonedDateTime date) {
        return service.getByReturnedOn(date);
    }
    @GetMapping("/api/rentals/returnedTo/{location}")
    public List<RentalEntity> getByReturnedTo(@PathVariable LocationEntity location) {
        return service.getByReturnedTo(location);
    }
    @GetMapping("/api/rentals/active")
    public List<RentalEntity> getActive() {
        return service.getActive();
    }
    @GetMapping("/api/rentals/returned")
    public List<RentalEntity> getReturned() {
        return service.getReturned();
    }
    @GetMapping("api/rentals/overdue")
    public List<RentalEntity> getOverdue() {
        return service.getOverdue();
    }
    @PostMapping("/api/rentals")
    public RentalEntity rent(@RequestBody RentalEntity rental) {
        return service.rent(rental);
    }
    @PatchMapping("/api/rentals/{pk}/vehicle")
    public RentalEntity swapVehicle(
        @PathVariable UUID pk,
        @RequestBody VehicleEntity vehicle
    ) {
        return service.swapVehicle(pk, vehicle);
    }
    @PatchMapping("/api/rentals/{pk}/return")
    public RentalEntity returnVehicle(
        @PathVariable UUID pk,
        @RequestBody LocationEntity location
    ) {
        return service.returnVehicle(pk, location);
    }
}