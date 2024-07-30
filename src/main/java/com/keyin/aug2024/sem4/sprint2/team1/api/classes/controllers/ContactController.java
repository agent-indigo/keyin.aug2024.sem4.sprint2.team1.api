package com.keyin.aug2024.sem4.sprint2.team1.api.classes.controllers;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.services.ContactService;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.ContactRole;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AddressEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.PhoneEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.EmailEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.RentalEntity;
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
public final class ContactController {
    @Autowired
    private ContactService service;
    private ContactController() {
        this.service = new ContactService();
    }
    @GetMapping("/api/contacts")
    public List<ContactEntity> getAll() {
        return service.getAll();
    }
    @GetMapping("/api/contacts/{pk}")
    public ContactEntity getByPk(@PathVariable UUID pk) {
        return service.getByPk(pk);
    }
    @GetMapping("/api/contacts/{first}")
    public List<ContactEntity> getByFirst(@PathVariable String first) {
        return service.getByFirst(first);
    }
    @GetMapping("/api/contacts/{last}")
    public List<ContactEntity> getByLast(@PathVariable String last) {
        return service.getByLast(last);
    }
    @GetMapping("/api/contacts/{role}")
    public List<ContactEntity> getByRole(@PathVariable ContactRole role) {
        return service.getByRole(role);
    }
    @GetMapping("/api/contacts/{address}")
    public List<ContactEntity> getByAddress(@PathVariable AddressEntity address) {
        return service.getByAddress(address);
    }
    @GetMapping("/api/contacts/{phone}")
    public List<ContactEntity> getByPhone(@PathVariable PhoneEntity phone) {
        return service.getByPhone(phone);
    }
    @GetMapping("/api/contacts/{email}")
    public ContactEntity getByEmail(@PathVariable EmailEntity email) {
        return service.getByEmail(email);
    }
    @GetMapping("/api/contacts/{rental}")
    public ContactEntity getByRental(@PathVariable RentalEntity rental) {
        return service.getByRental(rental);
    }
    @GetMapping("/api/contacts/{active}")
    public List<ContactEntity> getActive() {
        return service.getActive();
    }
    @GetMapping("/api/contacts/inactive")
    public List<ContactEntity> getInactive() {
        return service.getInactive();
    }
    @PostMapping("/api/contacts")
    public ContactEntity add(@RequestBody ContactEntity contact) {
        return service.add(contact);
    }
    @PatchMapping("/api/contacts/{pk}/first")
    public ContactEntity editFirst(
        @PathVariable UUID pk,
        @RequestBody String first
    ) {
        return service.editFirst(pk, first);
    }
    @PatchMapping("/api/contacts/{pk}/last")
    public ContactEntity editLastt(
        @PathVariable UUID pk,
        @RequestBody String last
    ) {
        return service.editLast(pk, last);
    }
    @PatchMapping("/api/contacts/{pk}/role")
    public ContactEntity editRole(
        @PathVariable UUID pk,
        @RequestBody ContactRole role
    ) {
        return service.editRole(pk, role);
    }
    @PostMapping("/api/contacts/{pk}/addresses")
    public ContactEntity addAddress(
        @PathVariable UUID pk,
        @RequestBody AddressEntity address
    ) {
        return service.addAddress(pk, address);
    }
    @PostMapping("/api/contacts/{pk}")
    public ContactEntity addAddresses(
        @PathVariable UUID pk,
        @RequestBody List<AddressEntity> addresses
    ) {
        return service.addAddresses(pk, addresses);
    }
    @PatchMapping("/api/contacts/{pk}/addresses/{index}")
    public ContactEntity replaceAddress(
        @PathVariable UUID pk,
        @RequestBody int index,
        @RequestBody AddressEntity address
    ) {
        return service.replaceAddress(pk, index, address);
    }
    @PatchMapping("/api/contacts/{pk}/addresses")
    public ContactEntity replaceAddresses(
        @PathVariable UUID pk,
        @RequestBody List<AddressEntity> addresses
    ) {
        return service.replaceAddresses(pk, addresses);
    }
    @DeleteMapping("/api/contacts/{pk}/addresses/{index}")
    public ContactEntity deleteAddress(
        @PathVariable UUID pk,
        @PathVariable int index
    ) {
        return service.deleteAddress(pk, index);
    }
    @DeleteMapping("/api/contacts/{pk}/addresses")
    public ContactEntity deleteAddresses(@PathVariable UUID pk) {
        return service.deleteAddresses(pk);
    }
    @PostMapping("/api/contacts/{pk}/phones")
    public ContactEntity addPhone(
        @PathVariable UUID pk,
        @RequestBody PhoneEntity phone
    ) {
        return service.addPhone(pk, phone);
    }
    @PostMapping("/api/contacts/{pk}")
    public ContactEntity addPhones(
        @PathVariable UUID pk,
        @RequestBody List<PhoneEntity> phones
    ) {
        return service.addPhones(pk, phones);
    }
    @PatchMapping("/api/contacts/{pk}/phones/{index}")
    public ContactEntity replacePhone(
        @PathVariable UUID pk,
        @RequestBody int index,
        @RequestBody PhoneEntity phone

    ) {
        return service.replacePhone(pk, index, phone);
    }
    @PatchMapping("/api/contacts/{pk}/phones")
    public ContactEntity replacePhones(
        @PathVariable UUID pk,
        @RequestBody List<PhoneEntity> phones
    ) {
        return service.replacePhones(pk, phones);
    }
    @DeleteMapping("/api/contacts/{pk}/phones/{index}")
    public ContactEntity deletePhone(
        @PathVariable UUID pk,
        @PathVariable int index
    ) {
        return service.deletePhone(pk, index);
    }
    @DeleteMapping("/api/contacts/{pk}/phones")
    public ContactEntity deletePhones(@PathVariable UUID pk) {
        return service.deletePhones(pk);
    }
    @GetMapping("/api/contact/{pk}/activate")
    public ContactEntity activate(@PathVariable UUID pk) {
        return service.activate(pk);
    }
    @GetMapping("/api/contact/{pk}/deactivate")
    public ContactEntity deactivate(@PathVariable UUID pk) {
        return service.deactivate(pk);
    }
}