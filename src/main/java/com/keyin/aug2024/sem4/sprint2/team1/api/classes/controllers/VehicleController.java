package com.keyin.aug2024.sem4.sprint2.team1.api.classes.controllers;

import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.*;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.services.VehicleService;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.VehicleCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
public final class VehicleController {
    @Autowired
    private VehicleService service;
    public VehicleController() {
        this.service = new VehicleService();
    }

    @GetMapping("/api/vehicles")
    public List<VehicleEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/api/vehicles/{pk}")
    public VehicleEntity getByPk(@PathVariable UUID pk) {
        return service.getByPk(pk);
    }

    @GetMapping("/api/vehicles/{manufacturer}")
    public List<VehicleEntity> getByManufacturer(@PathVariable String manufacturer) {
        return service.getByManufacturer(manufacturer);
    }

    @GetMapping("/api/vehicles/{model}")
    public List<VehicleEntity> getByModel(@PathVariable String model) {
        return service.getByModel(model);
    }

    @GetMapping("/api/vehicles/{year}")
    public List<VehicleEntity> getByYear(@PathVariable int year) {
        return service.getByYear(year);
    }

    @GetMapping("/api/vehicles/{capacity}")
    public List<VehicleEntity> getByCapacity(@PathVariable int capacity) {
        return service.getByCapacity(capacity);
    }

    @GetMapping("/api/vehicles/{category}")
    public List<VehicleEntity> getByCategory(@PathVariable VehicleCategory category) {
        return service.getByCategory(category);
    }

    @GetMapping("/api/vehicles/{stdRate}")
    public List<VehicleEntity> getByStdRate(@PathVariable float stdRate) {
        return service.getByStdRate(stdRate);
    }

    @GetMapping("/api/vehicles/{premRate}")
    public List<VehicleEntity> getByPremRate(@PathVariable float premRate) {
        return service.getByPremRate(premRate);
    }

    @GetMapping("/api/vehicles/{stdIns}")
    public List<VehicleEntity> getByStdIns(@PathVariable float stdIns) {
        return service.getByStdIns(stdIns);
    }

    @GetMapping("/api/vehicles/{premIns}")
    public List<VehicleEntity> getByPremIns(@PathVariable float premIns) {
        return service.getByPremIns(premIns);
    }

    @GetMapping("/api/vehicles/{plates}")
    public VehicleEntity getByPlates(@PathVariable String plates) {
        return service.getByPlates(plates);
    }

    @GetMapping("/api/vehicles/{agency}")
    public List<VehicleEntity> getByAgency(@PathVariable AgencyEntity agency) {
        return service.getByAgency(agency);
    }

    @GetMapping("/api/vehicles/{location}")
    public List<VehicleEntity> getByLocation(@PathVariable LocationEntity location) {
        return service.getByLocation(location);
    }

    @GetMapping("/api/vehicles/{rental}")
    public VehicleEntity getByRental(@PathVariable RentalEntity rental) {
        return service.getByRental(rental);
    }

    @GetMapping("/api/vehicles/rented")
    public List<VehicleEntity> getRented() {
        return service.getRented();
    }

    @GetMapping("/api/vehicles/available")
    public List<VehicleEntity> getAvailable() {
        return service.getAvailable();
    }

    @GetMapping("/api/vehicles/active")
    public List<VehicleEntity> getActive() {
        return service.getActive();
    }
    @GetMapping("/api/vehicle/inactive")
    public List<VehicleEntity> getInactive() {
        return service.getInactive();
    }

    @GetMapping("/api/vehicles/active")
    public List<VehicleEntity> getAllWithStdUnder(@PathVariable float max) {
        return service.getAllWithStdUnder(max);
    }

    @GetMapping("/api/vehicles/active")
    public List<VehicleEntity> getAllWithPremUnder(@PathVariable float max) {
        return service.getAllWithPremUnder(max);
    }

    @PostMapping("/api/vehicles")
    public VehicleEntity add(@RequestBody VehicleEntity vehicle) {
        return service.add(vehicle);
    }

    @PatchMapping("/api/vehicles/{pk}/manufacturer")
    public VehicleEntity editManufacturer(
            @PathVariable UUID pk,
            @RequestBody String manufacturer
    ) {
        return service.editManufacturer(pk, manufacturer);
    }

    @PatchMapping("/api/vehicles/{pk}/model")
    public VehicleEntity editModel(
            @PathVariable UUID pk,
            @RequestBody String model
    ) {
        return service.editModel(pk, model);
    }

    @PatchMapping("/api/vehicles/{pk}/year")
    public VehicleEntity editYear(
            @PathVariable UUID pk,
            @RequestBody int year
    ) {
        return service.editYear(pk, year);
    }

    @PatchMapping("/api/vehicles/{pk}/capacity")
    public VehicleEntity editCapacity(
            @PathVariable UUID pk,
            @RequestBody int capacity
    ) {
        return service.editCapacity(pk, capacity);
    }

    @PatchMapping("/api/vehicles/{pk}/category")
    public VehicleEntity editCategory(
            @PathVariable UUID pk,
            @RequestBody VehicleCategory category
    ) {
        return service.editCategory(pk, category);
    }

    @PatchMapping("/api/vehicles/{pk}/stdRate")
    public VehicleEntity editStdRate(
            @PathVariable UUID pk,
            @RequestBody float stdRate
    ) {
        return service.editStdRate(pk, stdRate);
    }

    @PatchMapping("/api/vehicles/{pk}/premRate")
    public VehicleEntity editPremRate(
            @PathVariable UUID pk,
            @RequestBody float premRate
    ) {
        return service.editPremRate(pk, premRate);
    }

    @PatchMapping("/api/vehicles/{pk}/stdIms")
    public VehicleEntity editStdIns(
            @PathVariable UUID pk,
            @RequestBody float stdIns
    ) {
        return service.editStdIns(pk, stdIns);
    }

    @PatchMapping("/api/vehicles/{pk}/premIms")
    public VehicleEntity editPremIns(
            @PathVariable UUID pk,
            @RequestBody float premIns
    ) {
        return service.editPremIns(pk, premIns);
    }

    @PatchMapping("/api/vehicles/{pk}/plates")
    public VehicleEntity editPlates(
            @PathVariable UUID pk,
            @RequestBody String plates
    ) {
        return service.editPlates(pk, plates);
    }

    @PatchMapping("/api/vehicles/{pk}/agency")
    public VehicleEntity editAgency(
            @PathVariable UUID pk,
            @RequestBody AgencyEntity agency
    ) {
        return service.editAgency(pk, agency);
    }

    @PatchMapping("/api/vehicles/{pk}/location")
    public VehicleEntity editLocation(
            @PathVariable UUID pk,
            @RequestBody LocationEntity location
    ) {
        return service.editLocation(pk, location);
    }

    @GetMapping("/api/vehicles/{pk}/activate")
    public VehicleEntity activate(@PathVariable UUID pk) {
        return service.activate(pk);
    }
    @GetMapping("/api/vehicle/{pk}/deactivate")
    public VehicleEntity deactivate(@PathVariable UUID pk) {
        return service.deactivate(pk);
    }
}
