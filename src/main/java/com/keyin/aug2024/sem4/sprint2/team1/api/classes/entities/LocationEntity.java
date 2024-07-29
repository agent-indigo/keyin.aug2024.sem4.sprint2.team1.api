package com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.abstracts.DataEntity;
import java.util.List;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "locations")
public final class LocationEntity extends DataEntity {
    @ManyToOne
    private AgencyEntity agency;
    @OneToOne
    private AddressEntity address;
    @OneToOne
    private PhoneEntity phone;
    @OneToMany
    private List<VehicleEntity> vehicles;
    @Nullable
    @ManyToMany
    private List<RentalEntity> rentals;
    private String hours;
    public LocationEntity(
        AgencyEntity agency,
        AddressEntity address,
        PhoneEntity phone,
        List<VehicleEntity> vehicles,
        String hours
    ) {
        super();
        this.agency = agency;
        this.address = address;
        this.phone = phone;
        this.vehicles = vehicles;
        this.hours = hours;
    }
    public LocationEntity() {
        super();
    }
    public AgencyEntity getAgency() {
        return agency;
    }
    public void setAgency(AgencyEntity agency) {
        this.agency = agency;
    }
    public AddressEntity getAddress() {
        return address;
    }
    public void setAddress(AddressEntity address) {
        this.address = address;
    }
    public PhoneEntity getPhone() {
        return phone;
    }
    public void setPhone(PhoneEntity phone) {
        this.phone = phone;
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
    public String getHours() {
        return hours;
    }
    public void setHours(String hours) {
        this.hours = hours;
    }
}