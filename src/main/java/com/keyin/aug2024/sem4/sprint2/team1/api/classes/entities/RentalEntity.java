package com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities;
import java.time.ZonedDateTime;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "rentals")
public final class RentalEntity {
    @ManyToOne
    private VehicleEntity vehicle;
    @ManyToOne
    private ContactEntity contact;
    private String license;
    @ManyToOne
    private AgencyEntity agency;
    @ManyToOne
    private LocationEntity rentedFrom;
    private ZonedDateTime rentedOn;
    private ZonedDateTime due;
    @Nullable
    private ZonedDateTime returnedOn;
    @Nullable
    @ManyToOne
    private LocationEntity returnedTo;
    public RentalEntity() {
        super();
    }
    public VehicleEntity getVehicle() {
        return vehicle;
    }
    public void setVehicle(VehicleEntity vehicle) {
        this.vehicle = vehicle;
    }
    public ContactEntity getContact() {
        return contact;
    }
    public void setContact(ContactEntity contact) {
        this.contact = contact;
    }
    public String getLicense() {
        return license;
    }
    public void setLicense(String license) {
        this.license = license;
    }
    public AgencyEntity getAgency() {
        return agency;
    }
    public void setAgency(AgencyEntity agency) {
        this.agency = agency;
    }
    public LocationEntity getRentedFrom() {
        return rentedFrom;
    }
    public void setRentedFrom(LocationEntity rentedFrom) {
        this.rentedFrom = rentedFrom;
    }
    public ZonedDateTime getRentedOn() {
        return rentedOn;
    }
    public void setRentedOn(ZonedDateTime rentedOn) {
        this.rentedOn = rentedOn;
    }
    public ZonedDateTime getDue() {
        return due;
    }
    public void setDue(ZonedDateTime due) {
        this.due = due;
    }
    public ZonedDateTime getReturnedOn() {
        return returnedOn;
    }
    public void setReturnedOn(ZonedDateTime returnedOn) {
        this.returnedOn = returnedOn;
    }
    public LocationEntity getReturnedTo() {
        return returnedTo;
    }
    public void setReturnedTo(LocationEntity returnedTo) {
        this.returnedTo = returnedTo;
    }
}