package com.keyin.aug2024.sem4.sprint2.team1.api.classes.controllers;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.PhoneEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.services.PhoneService;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.PhoneEmailCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;
@RestController
@CrossOrigin
public final class PhoneController {
    @Autowired
    private PhoneService service;
    public PhoneController() {
        this.service = new PhoneService();
    }
    @GetMapping("/api/phones")
    public List<PhoneEntity> list() {
        return service.getAll();
    }
    @GetMapping("/api/phones/{pk}")
    public PhoneEntity getByPk(@PathVariable UUID pk) {
        return service.getByPk(pk);
    }
    @GetMapping("/api/phones/{number}")
    public PhoneEntity getByNumber(@PathVariable String number) {
        return service.getByNumber(number);
    }
    @GetMapping("/api/phones/{contact}")
    public List<PhoneEntity> getByContact(@PathVariable ContactEntity contact) {
        return service.getByContact(contact);
    }
    @GetMapping("/api/phones/{category}")
    public List<PhoneEntity> getByCategory(@PathVariable PhoneEmailCategory category) {
        return service.getByCategory(category);
    }
    @GetMapping("/api/phones/{location}")
    public PhoneEntity getByLocation(@PathVariable LocationEntity location) {
        return service.getByLocation(location);
    }
    @GetMapping("/api/phones/active")
    public List<PhoneEntity> getActive() {
        return service.getActive();
    }
    @GetMapping("/api/phones/inactive")
    public List<PhoneEntity> getInactive() {
        return service.getInactive();
    }
    @PostMapping("/api/phones")
    public PhoneEntity add(@RequestBody PhoneEntity number) {
        return service.add(number);
    }
    @PatchMapping("/api/phones/{pk}/number")
    public PhoneEntity editNumber(
        @PathVariable UUID pk,
        @RequestBody String number
    ) {
        return service.editNumber(pk, number);
    }
    @PatchMapping("/api/phones/{pk}/category")
    public PhoneEntity switchCategory(
        @PathVariable UUID pk,
        @RequestBody PhoneEmailCategory category
    ) {
        return service.switchCategory(pk, category);
    }
    @PostMapping("/api/phones/:pk")
    public PhoneEntity addLocation(
        @PathVariable UUID pk,
        @RequestBody LocationEntity location
    ) {
        return service.addLocation(pk, location);
    }
    @DeleteMapping("/api/phones/{pk}/location")
    public PhoneEntity deleteLocation(@PathVariable UUID pk) {
        return service.deleteLocation(pk);
    }
    @PostMapping("/api/phones/{pk}/contacts")
    public PhoneEntity addContact(
        @PathVariable UUID pk,
        @RequestBody ContactEntity contact
    ) {
        return service.addContact(pk, contact);
    }
    @PostMapping("/api/phones/{pk}")
    public PhoneEntity addContacts(
        @PathVariable UUID pk,
        @RequestBody List<ContactEntity> contacts
    ) {
        return service.addContacts(pk, contacts);
    }
    @PatchMapping("/api/phones/{pk}/contacts/{index}")
    public PhoneEntity replaceContact(
        @PathVariable UUID pk,
        @PathVariable int index,
        @RequestBody ContactEntity contact
    ) {
        return service.replaceContact(pk, index, contact);
    }
    @PatchMapping("/api/phones/{pk}/contacts")
    public PhoneEntity replaceContacts(
        UUID pk,
        List<ContactEntity> contacts
    ) {
        return service.replaceContacts(pk, contacts);
    }
    @DeleteMapping("/api/phones/{pk}/contacts/{index}")
    public PhoneEntity deleteContact(
        @PathVariable UUID pk,
        @PathVariable int index
    ) {
        return service.deleteContact(pk, index);
    }
    @DeleteMapping("/api/phones/{pk}/contacts")
    public PhoneEntity deleteContacts(@PathVariable UUID pk) {
        return service.deleteContacts(pk);
    }
    @GetMapping("/api/phones/{pk}/activate")
    public PhoneEntity activate(@PathVariable UUID pk) {
        return service.activate(pk);
    }
    @GetMapping("/api/phone/{pk}/deactivate")
    public PhoneEntity deactivate(@PathVariable UUID pk) {
        return service.deactivate(pk);
    }
}