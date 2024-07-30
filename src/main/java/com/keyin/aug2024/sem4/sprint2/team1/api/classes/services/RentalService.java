package com.keyin.aug2024.sem4.sprint2.team1.api.classes.services;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AgencyEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.RentalEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.VehicleEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories.RentalRepository;
import com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
@Service
public final class RentalService {
    @Autowired
    private RentalRepository rentalRepository;
    private VehicleRepository vehicleRepository;
    private RentalEntity currentRental;
    private VehicleEntity currentVehicle;
    public RentalService() {}
    /**
     * @name    getAll
     * @desc    Get all rentals
     * @route   GET /api/rentals
     * @access  private
     */
    public List<RentalEntity> getAll() {
        return StreamSupport.stream(
            rentalRepository.findAll().spliterator(),
            false
        ).collect(Collectors.toList());
    }
    /**
     * @name    getByPk
     * @desc    Get a rental by its primary key
     * @route   GET /api/rentals/{pk}
     * @access  private
     */
    public RentalEntity getByPk(UUID pk) {
        return rentalRepository.findById(pk).get();
    }
    /**
     * @name    getByVehicle
     * @desc    Get all rentals of the given vehicle
     * @route   GET /api/rentals/{vehicle}
     * @access  private
     */
    public List<RentalEntity> getByVehicle(VehicleEntity vehicle) {
        return rentalRepository.findAllByVehicle(vehicle);
    }
    /**
     * @name    getByContact
     * @desc    Get all of a contact's rentals
     * @route   GET /api/rentals/{contact}
     * @access  private
     */
    public List<RentalEntity> getByContact(ContactEntity contact) {
        return rentalRepository.findAllByContact(contact);
    }
    /**
     * @name    getByLicense
     * @desc    Get all rentals associated with the given driving license
     * @route   GET /api/rentals/{license}
     * @access  private
     */
    public List<RentalEntity> getByLicense(String license) {
        return rentalRepository.findAllByLicense(license);
    }
    /**
     * @name    getByAgency
     * @desc    Get all rentals from the given agency
     * @route   GET /api/rentals/{agency}
     * @access  private
     */
    public List<RentalEntity> getByAgency(AgencyEntity agency) {
        return rentalRepository.findAllByAgency(agency);
    }
    /**
     * @name    getByRentedFrom
     * @desc    Get all vehicles rented from a location
     * @route   GET /api/rentals/rentedFrom/{location}
     * @access  private
     */
    public List<RentalEntity> getByRentedFrom(LocationEntity location) {
        return rentalRepository.findAllByRentedFrom(location);
    }
    /**
     * @name    getByRentedOn
     * @desc    Get all rentals booked on the given date
     * @route   GET /api/rentals/rentedOn/{date}
     * @access  private
     */
    public List<RentalEntity> getByRentedOn(ZonedDateTime date) {
        return rentalRepository.findAllByRentedOn(date);
    }
    /**
     * @name    getDue
     * @desc    Get all rentals due to be returned on the given date
     * @route   GET /api/rentals/due
     * @access  private
     */
    public List<RentalEntity> getDue(ZonedDateTime date) {
        return rentalRepository.findAllByDue(date);
    }
    /**
     * @name    getByReturnedOn
     * @desc    Get all rentals returned on the given date
     * @route   GET /api/rentals/returnedOn/{date}
     * @access  private
     */
    public List<RentalEntity> getByReturnedOn(ZonedDateTime date) {
        return rentalRepository.findAllByRentedOn(date);
    }
    /**
     * @name    getByRetunedTo
     * @desc    Get all rentals returned to the given location
     * @route   GET /api/rentals/returnedTo/{location}
     * @access  private
     */
    public List<RentalEntity> getByReturnedTo(LocationEntity location) {
        return rentalRepository.findAllByReturnedTo(location);
    }
    /**
     * @name    getActive
     * @desc    Get all active rentals
     * @route   GET /api/rentals/active
     * @access  private
     */
    public List<RentalEntity> getActive() {
        return rentalRepository.findAllByActive(true);
    }
    /**
     * @name    getReturned
     * @desc    Get all returned rentals
     * @route   GET /api/rentals/returned
     * @access  private
     */
    public List<RentalEntity> getReturned() {
        return rentalRepository.findAllByActive(false);
    }
    /**
     * @name    getOverdue
     * @desc    Get all overdue rentals
     * @route   GET /api/rentals/overdue
     * @access  private
     */
    public List<RentalEntity> getOverdue() {
        return rentalRepository.findAllOverdue();
    }
    /**
     * @name    rent
     * @desc    Rent a vehicle
     * @route   POST /api/rentals
     * @access  private
     */
    public RentalEntity rent(RentalEntity rental) {
        this.currentVehicle = vehicleRepository.findById(rental.getVehicle().getPk()).get();
        currentVehicle.setRented(true);
        vehicleRepository.save(currentVehicle);
        return rentalRepository.save(rental);
    }
    /**
     * @name    swapVehicle
     * @desc    Swap a rented vehicle
     * @route   PATCH /api/rentals/{pk}/vehicle
     * @access  private
     */
    public RentalEntity swapVehicle(
        UUID pk,
        VehicleEntity vehicle
    ) {
        this.currentRental = rentalRepository.findById(pk).get();
        this.currentVehicle = vehicleRepository.findById(currentRental.getVehicle().getPk()).get();
        currentVehicle.setRented(false);
        vehicleRepository.save(currentVehicle);
        currentRental.setVehicle(vehicle);
        this.currentVehicle = vehicleRepository.findById(currentRental.getVehicle().getPk()).get();
        currentVehicle.setRented(true);
        vehicleRepository.save(currentVehicle);
        return rentalRepository.save(currentRental);
    }
    /**
     * @name    returnVehicle
     * @desc    Return a rented vehicle
     * @route   GET /api/rentals/{pk}/return
     * @access  private
     */
    public RentalEntity returnVehicle(
        UUID pk,
        LocationEntity location
    ) {
        this.currentRental = rentalRepository.findById(pk).get();
        this.currentVehicle = vehicleRepository.findById(currentRental.getVehicle().getPk()).get();
        currentVehicle.setRented(false);
        currentRental.setReturnedTo(location);
        currentRental.setReturnedOn(ZonedDateTime.now());
        vehicleRepository.save(currentVehicle);
        return rentalRepository.save(currentRental);
    }
}