package com.keyin.aug2024.sem4.sprint2.team1.api.classes.services;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AddressEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.EmailEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.PhoneEmailCategory;
import com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
public final class EmailService {
    @Autowired
    private EmailRepository repo;
    private EmailEntity current;
    public EmailService() {}
    /**
     * @name    getAll
     * @desc    Get all email address
     * @route   GET /api/emails
     * @access  private
     */
    public List<EmailEntity> getAll() {
        return StreamSupport.stream(
            repo.findAll().spliterator(),
            false
        ).collect(Collectors.toList());
    }
    /**
     * @name    getByPk
     * @desc    Get an email address by its primary key
     * @route   GET /api/emails/{pk}
     * @access  private
     */
    public EmailEntity getByPk(UUID pk) {
        return repo.findById(pk).get();
    }
    /**
     * @name    getByAddress
     * @desc    Get a single email address
     * @route   GET /api/emails/{address}
     * @access  private
     */
    public EmailEntity getByAddress(AddressEntity address) {
        return repo.findByAddress(null);
    }
    /**
     * @name    getByContact
     * @desc    Get all email address associated with the given contact
     * @route   GET /api/emails/{contact}
     * @access  private
     */
    public List<EmailEntity> getByContact(ContactEntity contact) {
        return repo.findByContact(contact);
    }
    /**
     * @name    getByCategory
     * @desc    Get all personal or work email addresses
     * @route   GET /api/emails/{category}
     * @access  private
     */
    public List<EmailEntity> getByCategory(PhoneEmailCategory category) {
        return repo.findAllByCategory(category);
    }
    /**
     * @name    getActive
     * @desc    Get all active email addresses
     * @route   GET /api/emails/active
     * @access  private
     */
    public List<EmailEntity> getActive() {
        return repo.findAllByActive(true);
    }
    /**
     * @name    getInactive
     * @desc    Get all inactive email addresses
     * @route   GET /api/emails/inactive
     * @access  private
     */
    public List<EmailEntity> getInactive() {
        return repo.findAllByActive(false);
    }
    /**
     * @name    add
     * @desc    Add an email address
     * @route   POST /api/emails
     * @access  private
     */
    public EmailEntity add(EmailEntity email) {
        return repo.save(email);
    }
    /**
     * @name    editAddress
     * @desc    Edit an email address
     * @route   PATCH /api/emails/{pk}/address
     * @access  private
     */
    public EmailEntity editAddress(
        UUID pk,
        String address
    ) {
        this.current = repo.findById(pk).get();
        current.setAddress(address);
        return repo.save(current);
    }
    /**
     * @name    switchCategory
     * @desc    Switch an email address's category to personal or work
     * @route   PATCH /api/emails/{pk}/category
     * @access  private
     */
    public EmailEntity switchCategory(
        UUID pk,
        PhoneEmailCategory category
    ) {
        this.current = repo.findById(pk).get();
        current.setCategory(category);
        return repo.save(current);
    }
    /**
     * @name    activate
     * @desc    Activate an email address
     * @route   GET /api/emails/{pk}/activate
     * @access  private
     */
    public EmailEntity activate(UUID pk) {
        this.current = repo.findById(pk).get();
        current.setActive(true);
        return repo.save(current);
    }
    /**
     * @name    deactivate
     * @desc    Deactivate an email address
     * @route   GET /api/emails/{pk}/deactivate
     * @access  private
     */
    public EmailEntity deactivate(UUID pk) {
        this.current = repo.findById(pk).get();
        current.setActive(false);
        return repo.save(current);
    }
}