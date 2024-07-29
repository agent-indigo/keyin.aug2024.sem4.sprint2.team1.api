package com.keyin.aug2024.sem4.sprint2.team1.api.classes.controllers;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AddressEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.EmailEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.services.EmailService;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.PhoneEmailCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;
@RestController
@CrossOrigin
public final class EmailController {
    @Autowired
    private EmailService service;
    public EmailController() {
        this.service = new EmailService();
    }
    @GetMapping("/api/emails")
    public List<EmailEntity> getAll() {
        return service.getAll();
    }
    @GetMapping("/api/emails/{pk}")
    public EmailEntity getByPk(@PathVariable UUID pk) {
        return service.getByPk(pk);
    }
    @GetMapping("/api/emails/{address}")
    public EmailEntity getByAddress(@PathVariable AddressEntity address) {
        return service.getByAddress(address);
    }
    @GetMapping("/api/emails/{contact}")
    public List<EmailEntity> getByContact(@PathVariable ContactEntity contact) {
        return service.getByContact(contact);
    }
    @GetMapping("/api/emails/{category}")
    public List<EmailEntity> getByCategory(@PathVariable PhoneEmailCategory category) {
        return service.getByCategory(category);
    }
    @GetMapping("/api/emails/active")
    public List<EmailEntity> getActive() {
        return service.getActive();
    }
    @GetMapping("/api/emails/inactive")
    public List<EmailEntity> getInactive() {
        return service.getInactive();
    }
    @PatchMapping("/api/emails/{pk}/address")
    public EmailEntity editAddress(
        @PathVariable UUID pk,
        @RequestBody String address
    ) {
        return service.editAddress(pk, address);
    }
    @PatchMapping("/api/emails/{pk}/category")
    public EmailEntity editCategory(
        @PathVariable UUID pk,
        @RequestBody PhoneEmailCategory category
    ) {
        return service.switchCategory(pk, category);
    }
    @GetMapping("/api/emails/{pk}/activate")
    public EmailEntity activate(@PathVariable UUID pk) {
        return service.activate(pk);
    }
    @GetMapping("/api/emails/{pk}/deactivate")
    public EmailEntity deactivate(@PathVariable UUID pk) {
        return service.deactivate(pk);
    }
}