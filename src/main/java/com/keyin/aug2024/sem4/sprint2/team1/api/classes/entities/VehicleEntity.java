package com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.abstracts.DataEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.VehicleCategory;
import java.util.List;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
public final class VehicleEntity extends DataEntity {
    private String manufacturer;
    private String model;
    private int year;
    private int capacity;
    private VehicleCategory category;
    private float stdRate;
    private float premRate;
    private float stdIns;
    private float premIns;
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
        int year,
        int capacity,
        VehicleCategory category,
        float stdRate,
        float premRate,
        float stdIns,
        float premIns,
        String plates,
        AgencyEntity agency,
        LocationEntity location,
        List<RentalEntity> rentals
    ) {
        super();
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.capacity = capacity;
        this.category = category;
        this.stdRate = stdRate;
        this.premRate = premRate;
        this.stdIns = stdIns;
        this.premIns = premIns;
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
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public VehicleCategory getCategory() {
        return category;
    }
    public void setCategory(VehicleCategory category) {
        this.category = category;
    }
    public float getStdRate() {
        return stdRate;
    }
    public void setStdRate(float stdRate) {
        this.stdRate = stdRate;
    }
    public float getPremRate() {
        return premRate;
    }
    public void setPremRate(float premRate) {
        this.premRate = premRate;
    }
    public float getStdIns() {
        return stdIns;
    }
    public void setStdIns(float stdIns) {
        this.stdIns = stdIns;
    }
    public float getPremIns() {
        return premIns;
    }
    public void setPremIns(float premIns) {
        this.premIns = premIns;
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