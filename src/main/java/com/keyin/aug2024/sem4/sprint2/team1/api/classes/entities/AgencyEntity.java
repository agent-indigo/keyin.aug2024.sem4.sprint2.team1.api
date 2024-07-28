package com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.abstracts.DataEntity;
import java.util.List;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "agencies")
public final class AgencyEntity extends DataEntity {
    private String name;
    private String website;
    @OneToMany
    private List<LocationEntity> locations;
    @OneToMany
    private List<ContactEntity> contacts;
    @OneToMany
    private List<VehicleEntity> vehicles;
    @Nullable
    @OneToMany
    private List<RentalEntity> rentals;
    public AgencyEntity() {
        super();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
    public List<LocationEntity> getLocations() {
        return locations;
    }
    public void setLocations(List<LocationEntity> locations) {
        this.locations = locations;
    }
    public List<ContactEntity> getContacts() {
        return contacts;
    }
    public void setContacts(List<ContactEntity> contacts) {
        this.contacts = contacts;
    }
    public List<VehicleEntity> getVehicles() {
        return vehicles;
    }
    public void setVehicles(List<VehicleEntity> vehicles) {
        this.vehicles = vehicles;
    }
    public List<RentalEntity> getRentals() {
        return rentals;
    }
    public void setRentals(List<RentalEntity> rentals) {
        this.rentals = rentals;
    }
}