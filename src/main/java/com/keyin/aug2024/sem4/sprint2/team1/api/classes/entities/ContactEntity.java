package com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.abstracts.DataEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.ContactRole;
import jakarta.annotation.Nullable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.List;
public final class ContactEntity extends DataEntity {
    private String first;
    private String last;
    private ContactRole role;
    @ManyToMany
    private List<AddressEntity> addresses;
    @ManyToMany
    private List<PhoneEntity> phones;
    @OneToMany
    private List<EmailEntity> emails;
    @Nullable
    @OneToMany
    private List<RentalEntity> rentals;
    public ContactEntity(
        String first,
        String last,
        ContactRole role,
        List<AddressEntity> addresses,
        List<PhoneEntity> phones,
        List<EmailEntity> emails,
        List<RentalEntity> rentals
    ) {
        super();
        this.first = first;
        this.last = last;
        this.role = role;
        this.addresses = addresses;
        this.phones = phones;
        this.emails = emails;
        this.rentals = rentals;
    }
    public ContactEntity(
        String first,
        String last,
        ContactRole role,
        List<AddressEntity> addresses,
        List<PhoneEntity> phones,
        List<EmailEntity> emails
    ) {
        super();
        this.first = first;
        this.last = last;
        this.role = role;
        this.addresses = addresses;
        this.phones = phones;
        this.emails = emails;
    }
    public ContactEntity() {
        super();
    }
    public String getFirst() {
        return first;
    }
    public void setFirst(String first) {
        this.first = first;
    }
    public String getLast() {
        return last;
    }
    public void setLast(String last) {
        this.last = last;
    }
    public ContactRole getRole() {
        return role;
    }
    public void setRole(ContactRole role) {
        this.role = role;
    }
    public List<AddressEntity> getAddresses() {
        return addresses;
    }
    public void setAddresses(List<AddressEntity> addresses) {
        this.addresses = addresses;
    }
    public List<PhoneEntity> getPhones() {
        return phones;
    }
    public void setPhones(List<PhoneEntity> phones) {
        this.phones = phones;
    }
    public List<EmailEntity> getEmails() {
        return emails;
    }
    public void setEmails(List<EmailEntity> emails) {
        this.emails = emails;
    }
    public List<RentalEntity> getRentals() {
        return rentals;
    }
    public void setRentals(List<RentalEntity> rentals) {
        this.rentals = rentals;
    }
}