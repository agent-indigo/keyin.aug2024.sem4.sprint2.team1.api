package com.keyin.aug2024.sem4.sprint2.team1.api.classes.services;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.PhoneEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.PhoneEmailCategory;
import com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
public final class PhoneService {
    @Autowired
    private PhoneRepository repo;
    private PhoneEntity current;
    public PhoneService() {}
    /**
     * @name    getAll
     * @desc    Get all phone numbers
     * @route   GET /api/phones
     * @access  private
     */
    public List<PhoneEntity> getAll() {
        return StreamSupport.stream(
            repo.findAll().spliterator(),
            false
        ).collect(Collectors.toList());
    }
    /**
     * @name    getByPk
     * @desc    Get a phone number by its primary key
     * @route   GET /api/phones/{pk}
     * @access  private
     */
    public PhoneEntity getByPk(UUID pk) {
        return repo.findById(pk).get();
    }
    /**
     * @name    getByNumber
     * @desc    Get a phone number by the recorded number
     * @route   GET /api/phones/{number}
     * @access  private
     */
    public PhoneEntity getByNumber(String number) {
        return repo.findByNumber(number);
    }
    /**
     * @name    getByContact
     * @desc    List all phone numbers associated with a contact
     * @route   GET /api/phones/{contact}
     * @access  private
     */
    public List<PhoneEntity> getByContact(ContactEntity contact) {
        return repo.findAllByContact(contact);
    }
    /**
     * @name    getByCategory
     * @desc    List all personal or work phone numbers
     * @route   GET /api/phones/{category}
     * @access  private
     */
    public List<PhoneEntity> getByCategory(PhoneEmailCategory category) {
        return repo.findAllByCategory(category);
    }
    /**
     * @name    getByLocation
     * @desc    Get the phone number of the given agency location
     * @route   GET /api/phones/{location}
     * @access  private
     */
    public PhoneEntity getByLocation(LocationEntity location) {
        return repo.findByLocation(location);
    }
    /**
     * @name    getActive
     * @desc    List all active phone numbers
     * @route   GET /api/phones/active
     * @access  private
     */
    public List<PhoneEntity> getActive() {
        return repo.findAllByActive(true);
    }
    /**
     * @name    getInactive
     * @desc    List all inactive phone numbers
     * @route   GET /api/phones/inactive
     * @access  private
     */
    public List<PhoneEntity> getInactive() {
        return repo.findAllByActive(false);
    }
    /**
     * @name    add
     * @desc    Add a phone number
     * @route   POST /api/phones
     * @access  private
     */
    public PhoneEntity add(PhoneEntity number) {
        return repo.save(number);
    }
    /**
     * @name    editNumber
     * @desc    Edit a phone number
     * @route   PATCH /api/phones/{pk}/number
     * @access  private
     */
    public PhoneEntity editNumber(
        UUID pk,
        String number
    ) {
        this.current = repo.findById(pk).get();
        current.setNumber(number);
        return repo.save(current);
    }
    /**
     * @name    switchCategory
     * @desc    Switch a phone number's category to personal or work
     * @route   PATCH /api/phones/{pk}/category
     * @access  private
     */
    public PhoneEntity switchCategory(
        UUID pk,
        PhoneEmailCategory category
    ) {
        this.current = repo.findById(pk).get();
        current.setCategory(category);
        return repo.save(current);
    }
    /**
     * @name    addLocation
     * @desc    Add an agency location to a phone number
     * @route   POST /api/phones/{pk}
     * @access  private
     */
    public PhoneEntity addLocation(
        UUID pk,
        LocationEntity location
    ) {
        this.current = repo.findById(pk).get();
        current.setLocation(location);
        return repo.save(current);
    }
    /**
     * @name    deleteLocation
     * @desc    Delete an agency location from a phone number
     * @route   DELETE /api/phones/{pk}/location
     * @access  private
     */
    public PhoneEntity deleteLocation(UUID pk) {
        this.current = repo.findById(pk).get();
        current.setLocation(null);
        return repo.save(current);
    }
    /**
     * @name    addContact
     * @desc    Add a contact to a phone number
     * @route   POST /api/phones/{pk}/contacts
     * @access  private
     */
    public PhoneEntity addContact(
        UUID pk,
        ContactEntity contact
    ) {
        this.current = repo.findById(pk).get();
        current.getContacts().add(contact);
        return repo.save(current);
    }
    /**
     * @name    addContacts
     * @desc    Add contacts to a phone number
     * @route   POST /api/phones/{pk}
     * @access  private
     */
    public PhoneEntity addContacts(
        UUID pk,
        List<ContactEntity> contacts
    ) {
        this.current = repo.findById(pk).get();
        current.setContacts(contacts);
        return repo.save(current);
    }
    /**
     * @name    replaceContact
     * @desc    Replace a contact associated with a phone number
     * @route   PATCH /api/phones/{pk}/contacts/{index}
     * @access  private
     */
    public PhoneEntity replaceContact(
        UUID pk,
        int index,
        ContactEntity contact
    ) {
        this.current = repo.findById(pk).get();
        current.getContacts().set(index, contact);
        return repo.save(current);
    }
    /**
     * @name    replaceContacts
     * @desc    Replace all contacts associated with a phone number
     * @route   PATCH /api/phones/{pk}/contacts
     * @access  private
     */
    public PhoneEntity replaceContacts(
        UUID pk,
        List<ContactEntity> contacts
    ) {
        this.current = repo.findById(pk).get();
        current.setContacts(contacts);
        return repo.save(current);
    }
    /**
     * @name    deleteContact
     * @desc    Delete a contact from a phone number
     * @route   DELETE /api/phones/{pk}/contacts/{index}
     * @access  private
     */
    public PhoneEntity deleteContact(
        UUID pk,
        int index
    ) {
        this.current = repo.findById(pk).get();
        current.getContacts().remove(index);
        return repo.save(current);
    }
    /**
     * @name    deleteContacts
     * @desc    Delete all contacts from a phone number
     * @route   DELETE /api/phones/{pk}/contacts
     * @access  private
     */
    public PhoneEntity deleteContacts(UUID pk) {
        this.current = repo.findById(pk).get();
        current.getContacts().clear();
        return repo.save(current);
    }
    /**
     * @name    activate
     * @desc    Activate a phone number
     * @route   GET /api/phones/{pk}/activate
     * @access  private
     */
    public PhoneEntity activate(UUID pk) {
        this.current = repo.findById(pk).get();
        current.setActive(true);
        return repo.save(current);
    }
    /**
     * @name    deactivate
     * @desc    Deactivate a phone number
     * @route   GET /api/phones/{pk}/deactivate
     * @access  private
     */
    public PhoneEntity deactivate(UUID pk) {
        this.current = repo.findById(pk).get();
        current.setActive(false);
        return repo.save(current);
    }
}