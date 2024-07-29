package com.keyin.aug2024.sem4.sprint2.team1.api.classes.controllers;

import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AddressEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.services.AddressService;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.services.PhoneService;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.AddressCategory;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.ProvTerrCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin

public final class AddressController {
    @Autowired
    private AddressService service;
    public AddressController() {
        this.service = new AddressService();
    }

    @GetMapping("/api/addresses")
    public List<AddressEntity> list() {
        return service.getAll();
    }

    @GetMapping("/api/addresses/{pk}")
    public AddressEntity getByPk(@PathVariable UUID pk) {
        return service.getByPk(pk);
    }

    @GetMapping("/api/addresses/{street}")
    public List<AddressEntity> getByStreet(@PathVariable String street) {
        return service.getByStreet(street);
    }

    @GetMapping("/api/addresses/{location}")
    public AddressEntity getByLocation(@PathVariable LocationEntity location) {
        return service.getByLocation(location);
    }

    @PostMapping("/api/addresses")
    public AddressEntity add(@RequestBody AddressEntity newAddress) {
        return service.add(newAddress);
    }

    @PatchMapping("/api/address/{pk}/number")
    public AddressEntity newNumber(
            @PathVariable UUID pk,
            @RequestBody int number
    ) {
        return service.newNumber(pk, number);
    }

    @PatchMapping("/api/address/{pk}/street")
    public AddressEntity renameStreet(
            @PathVariable UUID pk,
            @RequestBody String street
    ) {
        return service.renameStreet(pk, street);
    }

    @PatchMapping("/api/address/{pk}/unit")
    public AddressEntity newUnit(
            @PathVariable UUID pk,
            @RequestBody int unit
    ) {
        return service.newUnit(pk, unit);
    }

    @PatchMapping("/api/address/{pk}/city")
    public AddressEntity renameCity(
            @PathVariable UUID pk,
            @RequestBody String city
    ) {
        return service.renameCity(pk, city);
    }

    @PatchMapping("/api/address/{pk}/prov")
    public AddressEntity newProv(
            @PathVariable UUID pk,
            @RequestBody ProvTerrCode prov
    ) {
        return service.newProv(pk, prov);
    }

    @PatchMapping("/api/address/{pk}/postal")
    public AddressEntity newPostal(
            @PathVariable UUID pk,
            @RequestBody String postal
    ) {
        return service.newPostal(pk, postal);
    }

    @PatchMapping("/api/address/{pk}/category")
    public AddressEntity newCategory(
            @PathVariable UUID pk,
            @RequestBody AddressCategory category
    ) {
        return service.newCategory(pk, category);
    }

    @GetMapping("/api/address/{pk}/activate")
    public AddressEntity activate(@PathVariable UUID pk) {
        return service.activate(pk);
    }
    @GetMapping("/api/address/{pk}/deactivate")
    public AddressEntity deactivate(@PathVariable UUID pk) {
        return service.deactivate(pk);
    }

}