package com.keyin.aug2024.sem4.sprint2.team1.api.classes.services;

import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AgencyEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.RentalEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.VehicleEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.VehicleCategory;
import com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public final class VehicleService {
    @Autowired
    private VehicleRepository repo;
    private VehicleEntity current;

    public VehicleService() {}

    /**
     * @name    getAll
     * @desc    Get all vehicles
     * @route   GET /api/vegicles
     * @access  private
     */
    public List<VehicleEntity> getAll() {
        return StreamSupport.stream(
                repo.findAll().spliterator(),
                false
        ).collect(Collectors.toList());
    }

    /**
     * @name    getByPk
     * @desc    Get an vehicle by its primary key
     * @route   GET /api/vehicles/{pk}
     * @access  private
     */
    public VehicleEntity getByPk(UUID pk) {
        return repo.findById(pk).orElse(null);
    }

    /**
     * @name    getByManufacturer
     * @desc    Get all vehicles by manufacturer
     * @route   GET /api/vehicles/{manufacturer}
     * @access  private
     */
    public List<VehicleEntity> getByManufacturer(String manufacturer) {
        return repo.findAllByManufacturer(manufacturer);
    }

    /**
     * @name    getByModel
     * @desc    Get all vehicles by model
     * @route   GET /api/vehicles/{model}
     * @access  private
     */
    public List<VehicleEntity> getByModel(String model) {
        return repo.findAllByModel(model);
    }

    /**
     * @name    getByYear
     * @desc    Get all vehicles by year
     * @route   GET /api/vehicles/{year}
     * @access  private
     */
    public List<VehicleEntity> getByYear(int year) {
        return repo.findAllByYear(year);
    }

    /**
     * @name    getByCapacity
     * @desc    Get all vehicles by seating capacity
     * @route   GET /api/vehicles/{capacity}
     * @access  private
     */
    public List<VehicleEntity> getByCapacity(int capacity) {
        return repo.findAllByCapacity(capacity);
    }

    /**
     * @name    getByCategory
     * @desc    Get all vehicles by category
     * @route   GET /api/vehicles/{category}
     * @access  private
     */
    public List<VehicleEntity> getByCategory(VehicleCategory category) {
        return repo.findAllByCategory(category);
    }

    /**
     * @name    getByStdRate
     * @desc    Get all vehicles by standard rate
     * @route   GET /api/vehicles/{stdRate}
     * @access  private
     */
    public List<VehicleEntity> getByStdRate(float stdRate) {
        return repo.findAllByStdRate(stdRate);
    }

    /**
     * @name    getByPremRate
     * @desc    Get all vehicles by premium rate
     * @route   GET /api/vehicles/{stdRate}
     * @access  private
     */
    public List<VehicleEntity> getByPremRate(float premRate) {
        return repo.findAllByPremRate(premRate);
    }

    /**
     * @name    getByStdIns
     * @desc    Get all vehicles by standard insurance
     * @route   GET /api/vehicles/{stdIns}
     * @access  private
     */
    public List<VehicleEntity> getByStdInd(float stdIns) {
        return repo.findAllByStdIns(stdIns);
    }

    /**
     * @name    getByPremIns
     * @desc    Get all vehicles by premium insurance
     * @route   GET /api/vehicles/{premIns}
     * @access  private
     */
    public List<VehicleEntity> getByPremIns(float premIns) {
        return repo.findAllByPremIns(premIns);
    }

    /**
     * @name    getByPlates
     * @desc    Get vehicle by plate
     * @route   GET /api/vehicles/{plates}
     * @access  private
     */
    public VehicleEntity getByPlates(String plates) {
        return repo.findByPlates(plates);
    }

    /**
     * @name    getByAgency
     * @desc    Get all vehicles by agency
     * @route   GET /api/vehicles/{agency}
     * @access  private
     */
    public List<VehicleEntity> getByAgency(AgencyEntity agency) {
        return repo.findAllByAgency(agency);
    }
    /**
     * @name    getByLocation
     * @desc    Get all vehicles by location
     * @route   GET /api/vehicles/{location}
     * @access  private
     */
    public List<VehicleEntity> getByLocation(LocationEntity location) {
        return repo.findAllByLocation(location);
    }
    /**
     * @name    getByRental
     * @desc    Get vehicle by rental
     * @route   GET /api/vehicles/{rental}
     * @access  private
     */
    public VehicleEntity getByRental(RentalEntity rental) {
        return repo.findByRental(rental);
    }

    /**
     * @name    getByRented
     * @desc    Get all vehicles that are currently rented
     * @route   GET /api/vehicles/rented
     * @access  private
     */
    public List<VehicleEntity> getByRented() {
        return repo.findAllByRented(true);
    }

    /**
     * @name    getByRented
     * @desc    Get all vehicles that are currently available
     * @route   GET /api/vehicles/rented
     * @access  private
     */
    public List<VehicleEntity> getByAvailable() {
        return repo.findAllByRented(false);
    }
    /**
     * @name    getActive
     * @desc    Get all active vehicles
     * @route   GET /api/vehicles/active
     * @access  private
     */
    public List<VehicleEntity> getActive() {
        return repo.findAllByActive(true);
    }
    /**
     * @name    getInactive
     * @desc    Get all inactive vehicles
     * @route   GET /api/vehicles/inactive
     * @access  private
     */
    public List<VehicleEntity> getInactive() {
        return repo.findAllByActive(false);
    }

    /**
     * @name    getAllWithStdUnder
     * @desc    Get all standard vehicles under max price
     * @route   GET /api/vehicles/active
     * @access  private
     */
    public List<VehicleEntity> getAllWithStdUnder(float max) {
        return repo.findAllWithStdUnder(max);
    }

    /**
     * @name    getAllWithPremUnder
     * @desc    Get all premium vehicles under max price
     * @route   GET /api/vehicles/active
     * @access  private
     */
    public List<VehicleEntity> getAllWithPremUnder(float max) {
        return repo.findAllWithPremUnder(max);
    }

    /**
     * @name    add
     * @desc    Add a vehicle
     * @route   POST /api/vehicles
     * @access  private
     */
    public VehicleEntity add(VehicleEntity newVehicle) {
        return repo.save(newVehicle);
    }

    /**
     * @name    editManufacturer
     * @desc    Edit a vehicle's manufacturer
     * @route   PATCH /api/vehicle/{pk}/manufacturer
     * @access  private
     */
    public VehicleEntity editManufacturer(
            UUID pk,
            String manufacturer
    ) {
        this.current = repo.findById(pk).get();
        current.setManufacturer(manufacturer);
        return repo.save(current);
    }

    /**
     * @name    editManufacturer
     * @desc    Edit a vehicle's model
     * @route   PATCH /api/vehicle/{pk}/model
     * @access  private
     */
    public VehicleEntity editModel(
            UUID pk,
            String model
    ) {
        this.current = repo.findById(pk).get();
        current.setModel(model);
        return repo.save(current);
    }

    /**
     * @name    editYear
     * @desc    Edit a vehicle's year
     * @route   PATCH /api/vehicle/{pk}/year
     * @access  private
     */
    public VehicleEntity editYear(
            UUID pk,
            int year
    ) {
        this.current = repo.findById(pk).get();
        current.setYear(year);
        return repo.save(current);
    }

    /**
     * @name    editCapacity
     * @desc    Edit a vehicle's capacity
     * @route   PATCH /api/vehicle/{pk}/capacity
     * @access  private
     */
    public VehicleEntity capacity(
            UUID pk,
            int capacity
    ) {
        this.current = repo.findById(pk).get();
        current.setCapacity(capacity);
        return repo.save(current);
    }

    /**
     * @name    editCategory
     * @desc    Edit a vehicle's category
     * @route   PATCH /api/vehicle/{pk}/category
     * @access  private
     */
    public VehicleEntity editCategory(
            UUID pk,
            VehicleCategory category
    ) {
        this.current = repo.findById(pk).get();
        current.setCategory(category);
        return repo.save(current);
    }

    /**
     * @name    editStdRate
     * @desc    Edit a vehicle's standard rate rental fee
     * @route   PATCH /api/vehicle/{pk}/stdRate
     * @access  private
     */
    public VehicleEntity editStdRate(
            UUID pk,
            float stdRate
    ) {
        this.current = repo.findById(pk).get();
        current.setStdRate(stdRate);
        return repo.save(current);
    }

    /**
     * @name    editPremRate
     * @desc    Edit a vehicle's premium rate rental fee
     * @route   PATCH /api/vehicle/{pk}/premRate
     * @access  private
     */
    public VehicleEntity editPremRate(
            UUID pk,
            float premRate
    ) {
        this.current = repo.findById(pk).get();
        current.setPremRate(premRate);
        return repo.save(current);
    }

    /**
     * @name    editStdIns
     * @desc    Edit a vehicle's standard insurance rate
     * @route   PATCH /api/vehicle/{pk}/stdIns
     * @access  private
     */
    public VehicleEntity editStdIns(
            UUID pk,
            float stdIns
    ) {
        this.current = repo.findById(pk).get();
        current.setStdRate(stdIns);
        return repo.save(current);
    }

    /**
     * @name    editPremIns
     * @desc    Edit a vehicle's premium insurance rate
     * @route   PATCH /api/vehicle/{pk}/premIns
     * @access  private
     */
    public VehicleEntity editPremIns(
            UUID pk,
            float premIns
    ) {
        this.current = repo.findById(pk).get();
        current.setPremRate(premIns);
        return repo.save(current);
    }

    /**
     * @name    editPlates
     * @desc    Edit a vehicle's plate value
     * @route   PATCH /api/vehicle/{pk}/plates
     * @access  private
     */
    public VehicleEntity editPlates(
            UUID pk,
            String plates
    ) {
        this.current = repo.findById(pk).get();
        current.setPlates(plates);
        return repo.save(current);
    }

//    /**
//     * @name    addAgency
//     * @desc    Add as agency to a vehicle
//     * @route   POST /api/vehicle/{pk}/agency
//     * @access  private
//     */
//    public VehicleEntity addAgency(
//            UUID pk,
//            AgencyEntity agency
//    ) {
//        this.current = repo.findById(pk).get();
//        current.getAgency().add(agency);
//        return repo.save(current);
//    }
//
//    /**
//     * @name    replaceAgency
//     * @desc    Replace an agency associated with a vehicle
//     * @route   PATCH /api/vehicle/{pk}/agency/{index}
//     * @access  private
//     */
//    public VehicleEntity replaceAgency(
//            UUID pk,
//            int index,
//            AgencyEntity agency
//    ) {
//        this.current = repo.findById(pk).get();
//        current.getAgency().set(index, agency);
//        return repo.save(current);
//    }
//
//    /**
//     * @name    addLocation
//     * @desc    Add a location to a vehicle
//     * @route   POST /api/vehicle/{pk}/location
//     * @access  private
//     */
//    public VehicleEntity addLocation(
//            UUID pk,
//            LocationEntity location
//    ) {
//        this.current = repo.findById(pk).get();
//        current.getLocation().add(location);
//        return repo.save(current);
//    }
//
//    /**
//     * @name    replaceLocation
//     * @desc    Replace a location associated with a vehicle
//     * @route   PATCH /api/vehicle/{pk}/location/{index}
//     * @access  private
//     */
//    public VehicleEntity replaceLocation(
//            UUID pk,
//            int index,
//            LocationEntity location
//    ) {
//        this.current = repo.findById(pk).get();
//        current.getLocation().set(index, location);
//        return repo.save(current);
//    }

    /**
     * @name    addRental
     * @desc    Add a rental to a vehicle
     * @route   POST /api/vehicle/{pk}/rentals
     * @access  private
     */
    public VehicleEntity addRental(
            UUID pk,
            RentalEntity rental
    ) {
        this.current = repo.findById(pk).get();
        current.getRentals().add(rental);
        return repo.save(current);
    }

    /**
     * @name    replaceRental
     * @desc    Replace a rental associated with a vehicle
     * @route   PATCH /api/vehicle/{pk}/rentals/{index}
     * @access  private
     */
    public VehicleEntity replaceRental(
            UUID pk,
            int index,
            RentalEntity rental
    ) {
        this.current = repo.findById(pk).get();
        current.getRentals().set(index, rental);
        return repo.save(current);
    }

    /**
     * @name    deleteRental
     * @desc    Delete a rental record from a vehicle
     * @route   DELETE /api/vehicles/{pk}/rental/{index}
     * @access  private
     */
    public VehicleEntity deleteRental(
            UUID pk,
            int index
    ) {
        this.current = repo.findById(pk).get();
        current.getRentals().remove(index);
        return repo.save(current);
    }

    /**
     * @name    activate
     * @desc    Activate a vehicle
     * @route   GET /api/vehicles/{pk}/activate
     * @access  private
     */
    public VehicleEntity activate(UUID pk) {
        this.current = repo.findById(pk).get();
        current.setActive(true);
        return repo.save(current);
    }
    /**
     * @name    deactivate
     * @desc    Deactivate a vehicle
     * @route   GET /api/vehicles/{pk}/deactivate
     * @access  private
     */
    public VehicleEntity deactivate(UUID pk) {
        this.current = repo.findById(pk).get();
        current.setActive(false);
        return repo.save(current);
    }
}
