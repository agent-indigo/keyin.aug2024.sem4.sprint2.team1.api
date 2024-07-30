package com.keyin.aug2024.sem4.sprint2.team1.api.classes.services;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AddressEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.EmailEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.PhoneEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.RentalEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.ContactRole;
import com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
public final class ContactService {
    @Autowired
    private ContactRepository repo;
    private ContactEntity current;
    public ContactService() {}
    /**
     * @name    getAll
     * @desc    Get all contacts
     * @route   GET /api/contacts
     * @access  private
     */
    public List<ContactEntity> getAll() {
        return StreamSupport.stream(
            repo.findAll().spliterator(),
            false
        ).collect(Collectors.toList());
    }
    /**
     * @name    getByPk
     * @desc    Get a contact by their primary key
     * @route   GET /api/contacts/{pk}
     * @access  private
     */
    public ContactEntity getByPk(UUID pk) {
        return repo.findById(pk).get();
    }
    /**
     * @name    getByFirst
     * @desc    Get contacts with the given name
     * @route   GET /api/contacts/{first}
     * @access  private
     */
    public List<ContactEntity> getByFirst(String first) {
        return repo.findAllByFirst(first);
    }
    /**
     * @name    getByLast
     * @desc    Get contacts with the given name
     * @route   GET /api/contact/{last}
     * @access  private
     */
    public List<ContactEntity> getByLast(String last) {
        return repo.findAllByLast(last);
    }
    /**
     * @name    getByRole
     * @desc    Get contacts by role
     * @route   GET /api/contacts/{role}
     * @access  private
     */
    public List<ContactEntity> getByRole(ContactRole role) {
        return repo.findAllByRole(role);
    }
    /**
     * @name    getByAddress
     * @desc    Get all contacts at the given street address
     * @route   GET /api/contacts/{address}
     * @access  private
     */
    public List<ContactEntity> getByAddress(AddressEntity address) {
        return repo.findAllByAddress(address);
    }
    /**
     * @name    getByPhone
     * @desc    Get all contacts with the given phone number
     * @route   GET /api/contacts/{phone}
     * @access  private
     */
    public List<ContactEntity> getByPhone(PhoneEntity phone) {
        return repo.findAllByPhone(phone);
    }
    /**
     * @name    getByEmail
     * @desc    Get the contact with the given email address
     * @route   GET /api/contacts/{email}
     * @access  private
     */
    public ContactEntity getByEmail(EmailEntity email) {
        return repo.findByEmail(email);
    }
    /**
     * @name    getByRental
     * @desc    Get the contact who rented the given vehicle
     * @route   GET /api/contacts/{rental}
     * @access  private
     */
    public ContactEntity getByRental(RentalEntity rental) {
        return repo.findByRental(rental);
    }
    /**
     * @name    getActive
     * @desc    Get all active contacts
     * @route   GET /api/contacts/active
     * @access  private
     */
    public List<ContactEntity> getActive() {
        return repo.findAllByActive(true);
    }
    /**
     * @name    getInactive
     * @desc    Get all inactive contacts
     * @route   GET /api/contacts/inactive
     * @access  private
     */
    public List<ContactEntity> getInactive() {
        return repo.findAllByActive(false);
    }
    /**
     * @name    add
     * @desc    Add a contact
     * @route   POST /api/contacts
     * @access  private
     */
    public ContactEntity add(ContactEntity contact) {
        return repo.save(contact);
    }
    /**
     * @name    editFirst
     * @desc    Edit a contact's first name
     * @route   PATCH /api/contacts/{pk}/first
     * @access  private
     */
    public ContactEntity editFirst(
        UUID pk,
        String first
    ) {
        this.current = repo.findById(pk).get();
        current.setFirst(first);
        return repo.save(current);
    }
    /**
     * @name    editLast
     * @desc    Edit a contact's last name
     * @route   PATCH /api/contacts/{pk}/last
     * @access  private
     */
    public ContactEntity editLast(
        UUID pk,
        String last
    ) {
        this.current = repo.findById(pk).get();
        current.setLast(last);
        return repo.save(current);
    }
    /**
     * @name    editRole
     * @desc    Edit a contact's role
     * @route   PATCH /api/contacts/{pk}/role
     * @access  private
     */
    public ContactEntity editRole(
        UUID pk,
        ContactRole role
    ) {
        this.current = repo.findById(pk).get();
        current.setRole(role);
        return repo.save(current);
    }
    /**
     * @name    addAddress
     * @desc    Add an address to a contact
     * @route   POST /api/contacts/{pk}/contacts
     * @access  private
     */
    public ContactEntity addAddress(
        UUID pk,
        AddressEntity address
    ) {
        this.current = repo.findById(pk).get();
        current.getAddresses().add(address);
        return repo.save(current);
    }
    /**
     * @name    addAddresses
     * @desc    Add addresses to a contact
     * @route   POST /api/contacts/{pk}
     * @access  private
     */
    public ContactEntity addAddresses(
        UUID pk,
        List<AddressEntity> addresses
    ) {
        this.current = repo.findById(pk).get();
        current.setAddresses(addresses);
        return repo.save(current);
    }
    /**
     * @name    replaceAddress
     * @desc    Replace an address associated with a contact
     * @route   PATCH /api/addresses/{pk}/addresses/{index}
     * @access  private
     */
    public ContactEntity replaceAddress(
        UUID pk,
        int index,
        AddressEntity address
    ) {
        this.current = repo.findById(pk).get();
        current.getAddresses().set(index, address);
        return repo.save(current);
    }
    /**
     * @name    replaceAddresses
     * @desc    Replace all addresses associated with a contact
     * @route   PATCH /api/contacts/{pk}/addresses
     * @access  private
     */
    public ContactEntity replaceAddresses(
        UUID pk,
        List<AddressEntity> addresses
    ) {
        this.current = repo.findById(pk).get();
        current.setAddresses(addresses);
        return repo.save(current);
    }
    /**
     * @name    deleteAddress
     * @desc    Delete an address from a contact
     * @route   DELETE /api/contacts/{pk}/addresses/{index}
     * @access  private
     */
    public ContactEntity deleteAddress(
        UUID pk,
        int index
    ) {
        this.current = repo.findById(pk).get();
        current.getAddresses().remove(index);
        return repo.save(current);
    }
    /**
     * @name    deleteAddresses
     * @desc    Delete all addresses associated with a contact
     * @route   DELETE /api/contacts/{pk}/addresses
     * @access  private
     */
    public ContactEntity deleteAddresses(UUID pk) {
        this.current = repo.findById(pk).get();
        current.getAddresses().clear();
        return repo.save(current);
    }
    /**
     * @name    addPhone
     * @desc    Add a phone number to a contact
     * @route   POST /api/contacts/{pk}/phones
     * @access  private
     */
    public ContactEntity addPhone(
        UUID pk,
        PhoneEntity phone
    ) {
        this.current = repo.findById(pk).get();
        current.getPhones().add(phone);
        return repo.save(current);
    }
    /**
     * @name    addPhones
     * @desc    Add phone numbers to a contact
     * @route   POST /api/contacts/{pk}
     * @access  private
     */
    public ContactEntity addPhones(
        UUID pk,
        List<PhoneEntity> phones
    ) {
        this.current = repo.findById(pk).get();
        current.setPhones(phones);
        return repo.save(current);
    }
    /**
     * @name    replacePhone
     * @desc    Replace a phone number associated with a contact
     * @route   PATCH /api/contacts/{pk}/phones/{index}
     * @access  private
     */
    public ContactEntity replacePhone(
        UUID pk,
        int index,
        PhoneEntity phone
    ) {
        this.current = repo.findById(pk).get();
        current.getPhones().set(index, phone);
        return repo.save(current);
    }
    /**
     * @name    replacePhones
     * @desc    Replace all phone numbers associated with a contact
     * @route   PATCH /api/contacts/{pk}/phones
     * @access  private
     */
    public ContactEntity replacePhones(
        UUID pk,
        List<PhoneEntity> phones
    ) {
        this.current = repo.findById(pk).get();
        current.setPhones(phones);
        return repo.save(current);
    }
    /**
     * @name    deletePhone
     * @desc    Delete a phone number from a contact
     * @route   DELETE /api/contacts/{pk}/phones/{index}
     * @access  private
     */
    public ContactEntity deletePhone(
        UUID pk,
        int index
    ) {
        this.current = repo.findById(pk).get();
        current.getPhones().remove(index);
        return repo.save(current);
    }
    /**
     * @name    deletePhones
     * @desc    Delete all phones numbers from a contact
     * @route   DELETE /api/contacts/{pk}/phones
     * @access  private
     */
    public ContactEntity deletePhones(UUID pk) {
        this.current = repo.findById(pk).get();
        current.getPhones().clear();
        return repo.save(current);
    }
    /**
     * @name    activate
     * @desc    Activate a contact
     * @route   GET /api/contacts/{pk}/activate
     * @access  private
     */
    public ContactEntity activate(UUID pk) {
        this.current = repo.findById(pk).get();
        current.setActive(true);
        return repo.save(current);
    }
    /**
     * @name    deactivate
     * @desc    Deactivate a contact
     * @route   GET /api/contacts/{pk}/deactivate
     * @access  private
     */
    public ContactEntity deactivate(UUID pk) {
        this.current = repo.findById(pk).get();
        current.setActive(false);
        return repo.save(current);
    }
}