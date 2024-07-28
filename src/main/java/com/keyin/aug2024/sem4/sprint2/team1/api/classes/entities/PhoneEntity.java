package com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.abstracts.DataEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.PhoneEmailCategory;
import java.util.List;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
@Entity
public final class PhoneEntity extends DataEntity {
    private String number;
    @ManyToMany
    private List<ContactEntity> contacts;
    @Nullable
    @OneToOne
    private LocationEntity location;
    private PhoneEmailCategory category;
    private boolean active;
    public PhoneEntity() {
        super();
        this.active = true;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public List<ContactEntity> getContacts() {
        return contacts;
    }
    public void setContacts(List<ContactEntity> contacts) {
        this.contacts = contacts;
    }
    public LocationEntity getLocation() {
        return location;
    }
    public void setLocation(LocationEntity location) {
        this.location = location;
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