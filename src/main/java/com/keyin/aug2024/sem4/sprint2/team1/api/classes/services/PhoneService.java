package com.keyin.aug2024.sem4.sprint2.team1.api.classes.services;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.PhoneEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.PhoneEmailCategory;
import com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.Serve;
import com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
public final class PhoneService implements Serve {
    @Autowired
    private PhoneRepository repo;
    private PhoneEntity current;
    public PhoneService() {}
    /**
     * @name    list
     * @desc    List all phone numbers
     * @route   GET /api/phones
     * @access  private
     */
    public List<PhoneEntity> list() {
        return StreamSupport.stream(
            repo.findAll().spliterator(),
            false
        ).collect(Collectors.toList());
    }
    /**
     * @name    getByPk
     * @desc    Get a phone number by its primary key
     * @route   GET /api/phones/:pk
     * @access  private
     */
    public PhoneEntity getByPk(int pk) {
        return repo.findById(pk).orElse(null);
    }
    /**
     * @name    getByNumber
     * @desc    Get a phone number by the recorded number
     * @route   GET /api/phones/:number
     * @access  private
     */
    public PhoneEntity getByNumber(String number) {
        return repo.findByNumber(number);
    }
    /**
     * @name    getByContact
     * @desc    List all phone numbers associated with a contact
     * @route   GET /api/phones/:contact
     * @access  private
     */
    public List<PhoneEntity> getByContact(ContactEntity contact) {
        return StreamSupport.stream(
            repo.findAllByContact(contact).spliterator(),
            false
        ).collect(Collectors.toList());
    }
    /**
     * @name    getByCategory
     * @desc    List all personal or work phone numbers
     * @route   GET /api/phones/:category
     * @access  private
     */
    public List<PhoneEntity> getByCategory(PhoneEmailCategory category) {
        return StreamSupport.stream(
            repo.findAllByCategory(category).spliterator(),
            false
        ).collect(Collectors.toList());
    }
    /**
     * @name    getByLocation
     * @desc    Get a phone number by its location
     * @route   GET /api/phones/:location
     * @access  private
     */
    public PhoneEntity getByLocation(LocationEntity location) {
        return repo.findByLocation(location);
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
     * @name    edit
     * @desc    Edit a phone number
     * @route   PUT /api/phones/:pk
     * @access  private
     */
    public PhoneEntity edit(
        int pk,
        PhoneEntity update
    ) {
        this.current = repo.findById(pk).get();
        current.setNumber(update.getNumber());
        current.setContacts(update.getContacts());
        current.setCategory(update.getCategory());
        current.setLocation(update.getLocation());
        return repo.save(current);
    }
    /**
     * @name    editNumber
     * @desc    Edit a phone number
     * @route   PATCH /api/phones/:pk/number
     * @access  private
     */
    public PhoneEntity editNumber(
        int pk,
        String number
    ) {
        this.current = repo.findById(pk).get();
        current.setNumber(number);
        return repo.save(current);
    }
    /**
     * @name    switchCategory
     * @desc    Switch a phone number's category to personal or work
     * @route   PATCH /api/phones/:pk/category
     * @access  private
     */
    public PhoneEntity switchCategory(
        int pk,
        PhoneEmailCategory category
    ) {
        this.current = repo.findById(pk).get();
        current.setCategory(category);
        return repo.save(current);
    }
    /**
     * @name    addLocation
     * @desc    Add an agency location to a phone number
     * @route   POST /api/phones/:pk
     * @access  private
     */
    public PhoneEntity addLocation(
        int pk,
        LocationEntity location
    ) {
        this.current = repo.findById(pk).get();
        current.setLocation(location);
        return repo.save(current);
    }
    /**
     * @name    deleteLocation
     * @desc    Delete an agency location from a phone number
     * @route   DELETE /api/phones/:pk/location
     * @access  private
     */
    public PhoneEntity deleteLocation(int pk) {
        this.current = repo.findById(pk).get();
        current.setLocation(null);
        return repo.save(current);
    }
    /**
     * @name    addContact
     * @desc    Add a contact to a phone number
     * @route   POST /api/phones/:pk/contacts
     * @access  private
     */
    public PhoneEntity addContact(
        int pk,
        ContactEntity contact
    ) {
        this.current = repo.findById(pk).get();
        current.getContacts().add(contact);
        return repo.save(current);
    }
    /**
     * @name    addContacts
     * @desc    Add contacts to a phone number
     * @route   POST /api/phones/:pk
     * @access  private
     */
    public PhoneEntity addContacts(
        int pk,
        List<ContactEntity> contacts
    ) {
        this.current = repo.findById(pk).get();
        current.setContacts(contacts);
        return repo.save(current);
    }
    /**
     * @name    replaceContact
     * @desc    Replace a contact associated with a phone number
     * @route   PATCH /api/phones/:pk/contacts/:index
     * @access  private
     */
    public PhoneEntity replaceContact(
        int pk,
        int index,
        ContactEntity contact
    ) {
        this.current = repo.findById(pk).get();
        current.getContacts().set(index, contact);
        return repo.save(current);
    }
    /**
     * @name    deleteContact
     * @desc    Delete a contact from a phone number
     * @route   DELETE /api/phones/:pk/contacts/:index
     * @access  private
     */
    public PhoneEntity deleteContact(
        int pk,
        int index
    ) {
        this.current = repo.findById(pk).get();
        current.getContacts().remove(index);
        return repo.save(current);
    }
    /**
     * @name    deleteContacts
     * @desc    Delete all contacts from a phone number
     * @route   DELETE /api/phones/:pk/contacts
     * @access  private
     */
    public PhoneEntity deleteContacts(int pk) {
        this.current = repo.findById(pk).get();
        current.getContacts().clear();
        return repo.save(current);
    }
    /**
     * @name    delete
     * @desc    Delete a phone number
     * @route   DELETE /api/phones/:pk
     * @access  private
     */
    @Override
    public String delete(int pk) {
        repo.deleteById(pk);
        return "Phone number deleted.";
    }
    /**
     * @name    deleteByNumber
     * @desc    Delete a phone number by the recorded number
     * @route   DELETE /api/phones/:number
     * @access  private
     */
    public String deleteByNumber(String number) {
        repo.deleteByNumber(number);
        return "Phone number deleted.";
    }
    /**
     * @name    deleteByContact
     * @desc    Delete all phone numbers associated with a contact
     * @route   DELETE /api/phones/:contact
     * @access  private
     */
    public String deleteByContact(ContactEntity contact) {
        repo.deleteAllByContact(contact);
        return "Phone numbers deleted.";
    }
    /**
     * @name    deleteByLocation
     * @desc    Delete a phone number by its associated location
     * @route   DELETE /api/phones/:location
     * @access  private
     */
    public String deleteByLocation(LocationEntity location) {
        repo.deleteByLocation(location);
        return "Phone number deleted.";
    }
}