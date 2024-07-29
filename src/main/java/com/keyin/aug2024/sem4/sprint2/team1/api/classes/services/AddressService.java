package com.keyin.aug2024.sem4.sprint2.team1.api.classes.services;

import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AddressEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
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
     * @name    edit
     * @desc    Edit an address
     * @route   PUT /api/addresses/{pk}
     * @access  private
     */
    public AddressEntity edit(UUID pk, AddressEntity updatedAddress) {
        this.current = repo.findById(pk).get();
        current.setNumber(updatedAddress.getNumber());
        current.setStreet(updatedAddress.getStreet());
        current.setUnit(updatedAddress.getUnit());
        current.setCity(updatedAddress.getCity());
        current.setProv(updatedAddress.getProv());
        current.setPostal(updatedAddress.getPostal());
        return repo.save(current);
    }

    /**
     * @name    delete
     * @desc    Delete an address
     * @route   DELETE /api/addresses
     * @access  private
     */
    public String delete(UUID pk) {
        repo.deleteById(pk);
        return addressDeletedMessage;
    }
}
