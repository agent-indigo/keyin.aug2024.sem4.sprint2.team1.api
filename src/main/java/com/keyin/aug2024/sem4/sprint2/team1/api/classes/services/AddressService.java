package com.keyin.aug2024.sem4.sprint2.team1.api.classes.services;

import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AddressEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AgencyEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.AddressCategory;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.ProvTerrCode;
import com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public final class AddressService {
    @Autowired
    private AddressRepository repo;
    private AddressEntity current;
    private String addressDeletedMessage;

    public AddressService() {
        this.addressDeletedMessage = "Address deleted.";
    }

    /**
     * @name    getAll
     * @desc    Get all addresses
     * @route   GET /api/addresses
     * @access  private
     */
    public List<AddressEntity> getAll() {
        return StreamSupport.stream(
                repo.findAll().spliterator(),
                false
        ).collect(Collectors.toList());
    }

    /**
     * @name    getByPk
     * @desc    Get address by pk
     * @route   GET /api/addresses/{pk}
     * @access  private
     */
    public AddressEntity getByPk(UUID pk) {
        return repo.findById(pk).orElse(null);
    }

    /**
     * @name    getByStreet
     * @desc    Get all addresses by street
     * @route   GET /api/addresses/{street}
     * @access  private
     */
    public List<AddressEntity> getByStreet(String street) {
        return StreamSupport.stream(
                repo.findAllByStreet(street).spliterator(),
                false
        ).collect(Collectors.toList());
    }

    /**
     * @name    getByLocation
     * @desc    Get address by location
     * @route   GET /api/addresses/{location}
     * @access  private
     */
    public AddressEntity getByLocation(LocationEntity location) {
        return repo.findByLocation(location);
    }

    /**
     * @name    add
     * @desc    Add an address
     * @route   POST /api/addresses
     * @access  private
     */
    public AddressEntity add(AddressEntity newAddress) {
        return repo.save(newAddress);
    }

    /**
     * @name    editAddress
     * @desc    Edit an address's street number
     * @route   PATCH /api/addresses/{pk}/number
     * @access  private
     */
    public AddressEntity newNumber(
            UUID pk,
            int number
    ) {
        this.current = repo.findById(pk).get();
        current.setNumber(number);
        return repo.save(current);
    }

    /**
     * @name    editAddress
     * @desc    Edit an address's street
     * @route   PATCH /api/addresses/{pk}/street
     * @access  private
     */
    public AddressEntity renameStreet(
            UUID pk,
            String street
    ) {
        this.current = repo.findById(pk).get();
        current.setStreet(street);
        return repo.save(current);
    }

    /**
     * @name    editAddress
     * @desc    Edit an address's unit number
     * @route   PATCH /api/addresses/{pk}/unit
     * @access  private
     */
    public AddressEntity newUnit(
            UUID pk,
            int unit
    ) {
        this.current = repo.findById(pk).get();
        current.setUnit(unit);
        return repo.save(current);
    }

    /**
     * @name    editAddress
     * @desc    Edit an address's city
     * @route   PATCH /api/addresses/{pk}/city
     * @access  private
     */
    public AddressEntity renameCity(
            UUID pk,
            String city
    ) {
        this.current = repo.findById(pk).get();
        current.setCity(city);
        return repo.save(current);
    }

    /**
     * @name    editAddress
     * @desc    Edit an address's prov/terr
     * @route   PATCH /api/addresses/{pk}/prov
     * @access  private
     */
    public AddressEntity newProv(
            UUID pk,
            ProvTerrCode prov
    ) {
        this.current = repo.findById(pk).get();
        current.setProv(prov);
        return repo.save(current);
    }

    /**
     * @name    editAddress
     * @desc    Edit an address's postal code
     * @route   PATCH /api/addresses/{pk}/postal
     * @access  private
     */
    public AddressEntity newPostal(
            UUID pk,
            String postal
    ) {
        this.current = repo.findById(pk).get();
        current.setPostal(postal);
        return repo.save(current);
    }

    /**
     * @name    editAddress
     * @desc    Edit an address's category
     * @route   PATCH /api/addresses/{pk}/category
     * @access  private
     */
    public AddressEntity newCategory(
            UUID pk,
            AddressCategory category
    ) {
        this.current = repo.findById(pk).get();
        current.setCategory(category);
        return repo.save(current);
    }

    /**
     * @name    activate
     * @desc    Activate an address
     * @route   GET /api/addresses/{pk}/activate
     * @access  private
     */
    public AddressEntity activate(UUID pk) {
        this.current = repo.findById(pk).get();
        current.setActive(true);
        return repo.save(current);
    }
    /**
     * @name    deactivate
     * @desc    Deactivate an address
     * @route   GET /api/addresses/{pk}/deactivate
     * @access  private
     */
    public AddressEntity deactivate(UUID pk) {
        this.current = repo.findById(pk).get();
        current.setActive(false);
        return repo.save(current);
    }

}
