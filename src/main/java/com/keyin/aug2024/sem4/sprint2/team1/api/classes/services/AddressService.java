package com.keyin.aug2024.sem4.sprint2.team1.api.classes.services;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AddressEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.AddressCategory;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.ProvTerrCode;
import com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
public final class AddressService {
    @Autowired
    private AddressRepository repo;
    private AddressEntity current;
    public AddressService() {}
    /**
     * @name    getAll
     * @desc    Get all addresses
     * @route   GET /api/addresses
     * @access  private
     */
    public List<AddressEntity> getAll() {
        return StreamSupport.stream(
            repo.findAll().spliterator(),
            false
        ).collect(Collectors.toList());
    }
    /**
     * @name    getByPk
     * @desc    Get an address by its primary key
     * @route   GET /api/addresses/{pk}
     * @access  private
     */
    public AddressEntity getByPk(UUID pk) {
        return repo.findById(pk).orElse(null);
    }
    /**
     * @name    getByNumber
     * @desc    Get all addresses with the given street number
     * @route   GET /api/addresses/{number}
     * @access  private
     */
    public List<AddressEntity> getByNumber(int number) {
        return repo.findAllByNumber(number);
    }
    /**
     * @name    getByStreet
     * @desc    Get all addresses on a street
     * @route   GET /api/addresses/{street}
     * @access  private
     */
    public List<AddressEntity> getByStreet(String street) {
        return StreamSupport.stream(
            repo.findAllByStreet(street).spliterator(),
            false
        ).collect(Collectors.toList());
    }
    /**
     * @name    getByUnit
     * @desc    Get all addresses with the given unit number
     * @route   GET /api/addresses/{unit}
     * @access  private
     */
    public List<AddressEntity> getByUnit(int unit) {
        return repo.findAllByUnit(unit);
    }
    /**
     * @name    getByCity
     * @desc    Get all addresses in the given city
     * @route   GET /api/addresses/{city}
     * @access  private
     */
    public List<AddressEntity> getByCity(String city) {
        return repo.findAllByCity(city);
    }
    /**
     * @name    getByProvTerr
     * @desc    Get all addresses in the given Province or Territory
     * @route   GET /api/address/{prov}
     * @access  private
     */
    public List<AddressEntity> getByProvTerr(ProvTerrCode prov) {
        return repo.findAllByProv(prov);
    }
    /**
     * @name    getByPostal
     * @desc    Get all addresses with the given postal code
     * @route   GET /api/addresses/{postal}
     * @access  private
     */
    public List<AddressEntity> getByPostal(String postal) {
        return repo.findAllByPostal(postal);
    }
    /**
     * @name    getByCategory
     * @desc    Get all business, government, or residential addresses
     * @route   /api/addresses/{category}
     * @access  private
     */
    public List<AddressEntity> getByCategory(AddressCategory category) {
        return repo.findAllByCategory(category);
    }
    /**
     * @name    getByContact
     * @desc    Get all addresses associated with the given contact
     * @route   GET /api/addresses/{contact}
     * @access  private
     */
    public List<AddressEntity> getByContact(ContactEntity contact) {
        return repo.findAllByContact(contact);
    }
    /**
     * @name    getByLocation
     * @desc    Get the address of an agency location
     * @route   GET /api/addresses/{location}
     * @access  private
     */
    public AddressEntity getByLocation(LocationEntity location) {
        return repo.findByLocation(location);
    }
    /**
     * @name    getActive
     * @desc    Get all active addresses
     * @route   GET /api/addresses/active
     * @access  private
     */
    public List<AddressEntity> getActive() {
        return repo.findAllByActive(true);
    }
    /**
     * @name    getInactive
     * @desc    Get all inactive addresses
     * @route   GET /api/addresses/inactive
     * @access  private
     */
    public List<AddressEntity> getInactive() {
        return repo.findAllByActive(false);
    }
    /**
     * @name    add
     * @desc    Add an address
     * @route   POST /api/addresses
     * @access  private
     */
    public AddressEntity add(AddressEntity newAddress) {
        return repo.save(newAddress);
    }
    /**
     * @name    editNumber
     * @desc    Edit an address's street number
     * @route   PATCH /api/addresses/{pk}/number
     * @access  private
     */
    public AddressEntity editNumber(
        UUID pk,
        int number
    ) {
        this.current = repo.findById(pk).get();
        current.setNumber(number);
        return repo.save(current);
    }
    /**
     * @name    editStreet
     * @desc    Edit an address's street
     * @route   PATCH /api/addresses/{pk}/street
     * @access  private
     */
    public AddressEntity editStreet(
        UUID pk,
        String street
    ) {
        this.current = repo.findById(pk).get();
        current.setStreet(street);
        return repo.save(current);
    }
    /**
     * @name    editUnit
     * @desc    Edit an address's unit number
     * @route   PATCH /api/addresses/{pk}/unit
     * @access  private
     */
    public AddressEntity editUnit(
        UUID pk,
        int unit
    ) {
        this.current = repo.findById(pk).get();
        current.setUnit(unit);
        return repo.save(current);
    }
    /**
     * @name    editCity
     * @desc    Edit an address's city
     * @route   PATCH /api/addresses/{pk}/city
     * @access  private
     */
    public AddressEntity editCity(
        UUID pk,
        String city
    ) {
        this.current = repo.findById(pk).get();
        current.setCity(city);
        return repo.save(current);
    }
    /**
     * @name    editProvTerr
     * @desc    Edit an address's Province  or Territory
     * @route   PATCH /api/addresses/{pk}/prov
     * @access  private
     */
    public AddressEntity editProvTerr(
        UUID pk,
        ProvTerrCode prov
    ) {
        this.current = repo.findById(pk).get();
        current.setProv(prov);
        return repo.save(current);
    }
    /**
     * @name    editPostal
     * @desc    Edit an address's postal code
     * @route   PATCH /api/addresses/{pk}/postal
     * @access  private
     */
    public AddressEntity editPostal(
        UUID pk,
        String postal
    ) {
        this.current = repo.findById(pk).get();
        current.setPostal(postal);
        return repo.save(current);
    }
    /**
     * @name    editCategory
     * @desc    Edit an address's category
     * @route   PATCH /api/addresses/{pk}/category
     * @access  private
     */
    public AddressEntity editCategory(
        UUID pk,
        AddressCategory category
    ) {
        this.current = repo.findById(pk).get();
        current.setCategory(category);
        return repo.save(current);
    }
    /**
     * @name    addContact
     * @desc    Add a contact to an address
     * @route   POST /api/addresses/{pk}/contacts
     * @access  private
     */
    public AddressEntity addContact(
        UUID pk,
        ContactEntity contact
    ) {
        this.current = repo.findById(pk).get();
        current.getContacts().add(contact);
        return repo.save(current);
    }
    /**
     * @name    addContacts
     * @desc    Add contacts to an address
     * @route   POST /api/addresses/{pk}
     * @access  private
     */
    public AddressEntity addContacts(
        UUID pk,
        List<ContactEntity> contacts
    ) {
        this.current = repo.findById(pk).get();
        current.setContacts(contacts);
        return repo.save(current);
    }
    /**
     * @name    replaceContact
     * @desc    Replace a contact associated with an address
     * @route   PATCH /api/addresses/{pk}/contacts/{index}
     * @access  private
     */
    public AddressEntity replaceContact(
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
     * @desc    Replace all contacts associated with an address
     * @route   PATCH /api/addresses/{pk}/contacts
     * @access  private
     */
    public AddressEntity replaceContacts(
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
     * @route   DELETE /api/addresses/{pk}/contacts/{index}
     * @access  private
     */
    public AddressEntity deleteContact(
        UUID pk,
        int index
    ) {
        this.current = repo.findById(pk).get();
        current.getContacts().remove(index);
        return repo.save(current);
    }
    /**
     * @name    deleteContacts
     * @desc    Delete all contacts from an address
     * @route   DELETE /api/addresses/{pk}/contacts
     * @access  private
     */
    public AddressEntity deleteContacts(UUID pk) {
        this.current = repo.findById(pk).get();
        current.getContacts().clear();
        return repo.save(current);
    }
    /**
     * @name    activate
     * @desc    Activate an address
     * @route   GET /api/addresses/{pk}/activate
     * @access  private
     */
    public AddressEntity activate(UUID pk) {
        this.current = repo.findById(pk).get();
        current.setActive(true);
        return repo.save(current);
    }
    /**
     * @name    deactivate
     * @desc    Deactivate an address
     * @route   GET /api/addresses/{pk}/deactivate
     * @access  private
     */
    public AddressEntity deactivate(UUID pk) {
        this.current = repo.findById(pk).get();
        current.setActive(false);
        return repo.save(current);
    }
}