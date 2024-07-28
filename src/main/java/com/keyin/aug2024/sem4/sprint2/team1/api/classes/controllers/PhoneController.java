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
    /**
     * @name    list
     * @desc    List all phone numbers
     * @route   GET /api/phones
     * @access  private
     */
    @GetMapping("/api/phones")
    public List<PhoneEntity> list() {
        return service.list();
    }
    /**
     * @name    getByPk
     * @desc    Get a phone number by its primary key
     * @route   GET /api/phones/:pk
     * @access  private
     */
    @GetMapping("/api/phones/{pk}")
    public PhoneEntity getByPk(@PathVariable UUID pk) {
        return service.getByPk(pk);
    }
    /**
     * @name    getByNumber
     * @desc    Get a phone number by the recorded number
     * @route   GET /api/phones/:number
     * @access  private
     */
    @GetMapping("/api/phones/{number}")
    public PhoneEntity getByNumber(@PathVariable String number) {
        return service.getByNumber(number);
    }
    /**
     * @name    getByContact
     * @desc    List all phone numbers associated with a contact
     * @route   GET /api/phones/:contact
     * @access  private
     */
    @GetMapping("/api/phones/{contact}")
    public List<PhoneEntity> getByContact(@PathVariable ContactEntity contact) {
        return service.getByContact(contact);
    }
    /**
     * @name    getByCategory
     * @desc    List all personal or work phone numbers
     * @route   GET /api/phones/:category
     * @access  private
     */
    @GetMapping("/api/phones/{category}")
    public List<PhoneEntity> getByCategory(@PathVariable PhoneEmailCategory category) {
        return service.getByCategory(category);
    }
    /**
     * @name    getByLocation
     * @desc    Get the phone number of the given agency location
     * @route   GET /api/phones/:location
     * @access  private
     */
    @GetMapping("/api/phones/{location}")
    public PhoneEntity getByLocation(@PathVariable LocationEntity location) {
        return service.getByLocation(location);
    }
    /**
     * @name    add
     * @desc    Add a phone number
     * @route   POST /api/phones
     * @access  private
     */
    @PostMapping("/api/phones")
    public PhoneEntity add(@RequestBody PhoneEntity number) {
        return service.add(number);
    }
    /**
     * @name    editNumber
     * @desc    Edit a phone number
     * @route   PATCH /api/phones/:pk/number
     * @access  private
     */
    @PatchMapping("/api/phones/{pk}/number")
    public PhoneEntity editNumber(
        @PathVariable UUID pk,
        @RequestBody String number
    ) {
        return service.editNumber(pk, number);
    }
    /**
     * @name    switchCategory
     * @desc    Switch a phone number's category to personal or work
     * @route   PATCH /api/phones/:pk/category
     * @access  private
     */
    @PatchMapping("/api/phones/{pk}/category")
    public PhoneEntity switchCategory(
        @PathVariable UUID pk,
        @RequestBody PhoneEmailCategory category
    ) {
        return service.switchCategory(pk, category);
    }
    /**
     * @name    addLocation
     * @desc    Add an agency location to a phone number
     * @route   POST /api/phones/:pk
     * @access  private
     */
    @PostMapping("/api/phones/:pk")
    public PhoneEntity addLocation(
        @PathVariable UUID pk,
        @RequestBody LocationEntity location
    ) {
        return service.addLocation(pk, location);
    }
    /**
     * @name    deleteLocation
     * @desc    Delete an agency location from a phone number
     * @route   DELETE /api/phones/:pk/location
     * @access  private
     */
    @DeleteMapping("/api/phones/{pk}/location")
    public PhoneEntity deleteLocation(@PathVariable UUID pk) {
        return service.deleteLocation(pk);
    }
    /**
     * @name    addContact
     * @desc    Add a contact to a phone number
     * @route   POST /api/phones/:pk/contacts
     * @access  private
     */
    @PostMapping("/api/phones/{pk}/contacts")
    public PhoneEntity addContact(
        @PathVariable UUID pk,
        @RequestBody ContactEntity contact
    ) {
        return service.addContact(pk, contact);
    }
    /**
     * @name    addContacts
     * @desc    Add contacts to a phone number
     * @route   POST /api/phones/:pk
     * @access  private
     */
    @PostMapping("/api/phones/{pk}")
    public PhoneEntity addContacts(
        @PathVariable UUID pk,
        @RequestBody List<ContactEntity> contacts
    ) {
        return service.addContacts(pk, contacts);
    }
    /**
     * @name    replaceContact
     * @desc    Replace a contact associated with a phone number
     * @route   PATCH /api/phones/:pk/contacts/:index
     * @access  private
     */
    @PatchMapping("/api/phones/{pk}/contacts/{index}")
    public PhoneEntity replaceContact(
        @PathVariable UUID pk,
        @PathVariable int index,
        @RequestBody ContactEntity contact
    ) {
        return service.replaceContact(pk, index, contact);
    }
    /**
     * @name    deleteContact
     * @desc    Delete a contact from a phone number
     * @route   DELETE /api/phones/:pk/contacts/:index
     * @access  private
     */
    @DeleteMapping("/api/phones/{pk}/contacts/{index}")
    public PhoneEntity deleteContact(
        @PathVariable UUID pk,
        @PathVariable int index
    ) {
        return service.deleteContact(pk, index);
    }
    /**
     * @name    deleteContacts
     * @desc    Delete all contacts from a phone number
     * @route   DELETE /api/phones/:pk/contacts
     * @access  private
     */
    @DeleteMapping("/api/phones/{pk}/contacts")
    public PhoneEntity deleteContacts(@PathVariable UUID pk) {
        return service.deleteContacts(pk);
    }
    /**
     * @name    activate
     * @desc    Activate a phone number
     * @route   PATCH /api/phones/:pk/activate
     * @access  private
     */
    @GetMapping("/api/phones/{pk}/activate")
    public PhoneEntity activate(@PathVariable UUID pk) {
        return service.activate(pk);
    }
    /**
     * @name    deactivate
     * @desc    Deactivate a phone number
     * @route   PATCH /api/phones/:pk/deactivate
     * @access  private
     */
    @GetMapping("/api/phone/{pk}/deactivate")
    public PhoneEntity deactivate(@PathVariable UUID pk) {
        return service.deactivate(pk);
    }
}