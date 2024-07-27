package com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.abstracts.DataEntity;
import java.util.List;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
public final class VehicleEntity extends DataEntity {
    private String manufacturer;
    private String model;
    private String plates;
    @OneToOne
    private AgencyEntity agency;
    @OneToOne
    private LocationEntity location;
    @OneToMany
    private List<RentalEntity> rentals;
    public VehicleEntity(
        String manufacturer,
        String model,
        String plates,
        AgencyEntity agency,
        LocationEntity location,
        List<RentalEntity> rentals
    ) {
        super();
        this.manufacturer = manufacturer;
        this.model = model;
        this.plates = plates;
        this.agency = agency;
        this.location = location;
        this.rentals = rentals;
    }
    public VehicleEntity() {
        super();
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getPlates() {
        return plates;
    }
    public void setPlates(String plates) {
        this.plates = plates;
    }
    public AgencyEntity getAgency() {
        return agency;
    }
    public void setAgency(AgencyEntity agency) {
        this.agency = agency;
    }
    public LocationEntity getLocation() {
        return location;
    }
    public void setLocation(LocationEntity location) {
        this.location = location;
    }
    public List<RentalEntity> getRentals() {
        return rentals;
    }
    public void setRentals(List<RentalEntity> rentals) {
        this.rentals = rentals;
    }
}