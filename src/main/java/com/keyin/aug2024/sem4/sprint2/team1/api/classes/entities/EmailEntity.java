package com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.abstracts.DataEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.PhoneEmailCategory;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "emails")
public final class EmailEntity extends DataEntity {
    private String address;
    @ManyToOne
    private ContactEntity contact;
    private PhoneEmailCategory category;
    public EmailEntity(
        String address,
        ContactEntity contact,
        PhoneEmailCategory category
    ) {
        super();
        this.address = address;
        this.contact = contact;
        this.category = category;
    }
    public EmailEntity() {
        super();
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
}