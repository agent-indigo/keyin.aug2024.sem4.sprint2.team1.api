package com.keyin.aug2024.sem4.sprint2.team1.api.classes.controllers;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AddressEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.services.AddressService;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.AddressCategory;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.ProvTerrCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
    public AddressEntity editNumber(
        @PathVariable UUID pk,
        @RequestBody int number
    ) {
        return service.editNumber(pk, number);
    }
    @PatchMapping("/api/address/{pk}/street")
    public AddressEntity editStreet(
        @PathVariable UUID pk,
        @RequestBody String street
    ) {
        return service.editStreet(pk, street);
    }
    @PatchMapping("/api/address/{pk}/unit")
    public AddressEntity editUnit(
        @PathVariable UUID pk,
        @RequestBody int unit
    ) {
        return service.editUnit(pk, unit);
    }
    @PatchMapping("/api/address/{pk}/city")
    public AddressEntity editCity(
        @PathVariable UUID pk,
        @RequestBody String city
    ) {
        return service.editCity(pk, city);
    }
    @PatchMapping("/api/address/{pk}/prov")
    public AddressEntity editProvTerr(
        @PathVariable UUID pk,
        @RequestBody ProvTerrCode prov
    ) {
        return service.editProvTerr(pk, prov);
    }
    @PatchMapping("/api/address/{pk}/postal")
    public AddressEntity editPostal(
        @PathVariable UUID pk,
        @RequestBody String postal
    ) {
        return service.editPostal(pk, postal);
    }
    @PatchMapping("/api/address/{pk}/category")
    public AddressEntity editCategory(
        @PathVariable UUID pk,
        @RequestBody AddressCategory category
    ) {
        return service.editCategory(pk, category);
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