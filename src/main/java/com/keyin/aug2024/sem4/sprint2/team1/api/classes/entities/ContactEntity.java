package com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.abstracts.DataEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.ContactRole;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.List;
@Entity
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
    private boolean active;
    public ContactEntity() {
        super();
        this.active = true;
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
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}