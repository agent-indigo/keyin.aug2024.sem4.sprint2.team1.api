package com.keyin.aug2024.sem4.sprint2.team1.api.classes.services;

import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.*;
import com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public final class LocationService {
    @Autowired
    private LocationRepository repo;
    private LocationEntity current;

    public LocationService() {}

    /**
     * @name    getAll
     * @desc    Get all locations
     * @route   GET /api/locations
     * @access  private
     */
    public List<LocationEntity> getAll() {
        return StreamSupport.stream(
                repo.findAll().spliterator(),
                false
        ).collect(Collectors.toList());
    }

    /**
     * @name    getByPk
     * @desc    Get a location by its primary key
     * @route   GET /api/locations/{pk}
     * @access  private
     */
    public LocationEntity getByPk(UUID pk) {
        return repo.findById(pk).get();
    }

    /**
     * @name    findAllByAgency
     * @desc    Get all locations or an agency
     * @route   GET /api/locations/{agency}
     * @access  private
     */
    public List<LocationEntity> findAllByAgency(AgencyEntity agency) {
        return findAllByAgency(agency);
    }

    /**
     * @name    getByAddress
     * @desc    Get the location by the address
     * @route   GET /api/locations/{address}
     * @access  private
     */
    public LocationEntity getByAddress(AddressEntity address) {
        return repo.findByAddress(address);
    }

    /**
     * @name    getByPhone
     * @desc    Get the location by phone
     * @route   GET /api/locations/{phone}
     * @access  private
     */
    public LocationEntity getByPhone(PhoneEntity phone) {
        return repo.findByPhone(phone);
    }

    /**
     * @name    findByVehicle
     * @desc    Get the location of the vehicle
     * @route   GET /api/locations/{vehicle}
     * @access  private
     */
    public LocationEntity getByVehicle(VehicleEntity vehicle) {
        return repo.findByVehicle(vehicle);
    }

    /**
     * @name    findAllByRental
     * @desc    Get the location of a rental
     * @route   GET /api/locations/{rental}
     * @access  private
     */
    public List<LocationEntity> findAllByRental(RentalEntity rental) {
        return repo.findAllByRental(rental);
    }

    /**
     * @name    findAllByHours
     * @desc    Get the locations by hours
     * @route   GET /api/locations/{hours}
     * @access  private
     */
    public List<LocationEntity> findAllByHours(String hours) {
        return repo.findAllByHours(hours);
    }

    /**
     * @name    getActive
     * @desc    Get all active locations
     * @route   GET /api/locations/active
     * @access  private
     */
    public List<LocationEntity> getActive() {
        return repo.findAllByActive(true);
    }

    /**
     * @name    getInactive
     * @desc    Get all inactive locations
     * @route   GET /api/locations/inactive
     * @access  private
     */
    public List<LocationEntity> getInactive() {
        return repo.findAllByActive(false);
    }

    /**
     * @name    add
     * @desc    Add a location
     * @route   POST /api/locations
     * @access  private
     */
    public LocationEntity add(LocationEntity location) {
        return repo.save(location);
    }

    /**
     * @name    activate
     * @desc    Activate an location
     * @route   GET /api/locations/{pk}/activate
     * @access  private
     */
    public LocationEntity activate(UUID pk) {
        this.current = repo.findById(pk).get();
        current.setActive(true);
        return repo.save(current);
    }

    /**
     * @name    deactivate
     * @desc    Deactivate an agency
     * @route   GET /api/agencies/{pk}/deactivate
     * @access  private
     */
    public LocationEntity deactivate(UUID pk) {
        this.current = repo.findById(pk).get();
        current.setActive(false);
        return repo.save(current);
    }
}
