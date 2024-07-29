package com.keyin.aug2024.sem4.sprint2.team1.api.classes.controllers;

import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AddressEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.services.AddressService;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.services.PhoneService;
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

    @PutMapping("/api/addresses/{pk}")
    public AddressEntity edit(@PathVariable UUID pk, @RequestBody AddressEntity updatedAddress) {
        return service.edit(pk, updatedAddress);
    }

    @DeleteMapping("/api/address")
    public String delete(@PathVariable UUID pk) {
        return service.delete(pk);
    }


}