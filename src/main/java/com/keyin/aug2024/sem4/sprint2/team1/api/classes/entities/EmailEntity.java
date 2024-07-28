package com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.abstracts.DataEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.PhoneEmailCategory;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
@Entity
public final class EmailEntity extends DataEntity {
    private String address;
    @ManyToOne
    private ContactEntity contact;
    private PhoneEmailCategory category;
    private boolean active;
    public EmailEntity() {
        super();
        this.active = true;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public ContactEntity getContact() {
        return contact;
    }
    public void setContact(ContactEntity contact) {
        this.contact = contact;
    }
    public PhoneEmailCategory getCategory() {
        return category;
    }
    public void setCategory(PhoneEmailCategory category) {
        this.category = category;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}