package com.keyin.aug2024.sem4.sprint2.team1.api.classes.services;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AgencyEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.RentalEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.VehicleEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.Serve;
import com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
public final class AgencyService implements Serve {
    @Autowired
    private AgencyRepository repo;
    private AgencyEntity current;
    public AgencyService() {}
    /**
     * @name    list
     * @desc    List all rental agencies
     * @route   GET /api/agencies
     * @access  private
     */
    public List<AgencyEntity> list() {
        return StreamSupport.stream(
            repo.findAll().spliterator(),
            false
        ).collect(Collectors.toList());
    }
    /**
     * @name    getByPk
     * @desc    Get a rental agency by its primary key
     * @route   GET /api/agencies/:pk
     * @access  private
     */
    public AgencyEntity getByPk(int pk) {
        return repo.findById(pk).get();
    }
    /**
     * @name    getByName
     * @desc    Get a rental agency by its name
     * @route   GET /api/agencies/:name
     * @access  private
     */
    public AgencyEntity getByName(String name) {
        return repo.findByName(name);
    }
    /**
     * @name    getByWebsite
     * @desc    Get a rental agency by its website
     * @route   GET /api/agencies/:website
     * @access  private
     */
    public AgencyEntity getByWebsite(String website) {
        return repo.findByWebsite(website);
    }
    /**
     * @name    getByLocation
     * @desc    Get the agency that owns the given location
     * @route   GET /api/agencies/:location
     * @access  private
     */
    public AgencyEntity getByLocation(LocationEntity location) {
        return repo.findByLocation(location);
    }
    /**
     * @name    getByContact
     * @desc    Get the rental agency that employs the given contact
     * @route   GET /api/agencies/:contact
     * @access  private
     */
    public AgencyEntity getByContact(ContactEntity contact) {
        return repo.findByContact(contact);
    }
    /**
     * @name    getByVehicle
     * @desc    Get the agency that owns the given vehicle
     * @route   GET /api/agencies/:vehicle
     * @access  private
     */
    public AgencyEntity getByVehicle(VehicleEntity vehicle) {
        return repo.findByVehicle(vehicle);
    }
    /**
     * @name    getByRental
     * @desc    Get the agency that the given vehicle was rented from
     * @route   GET /api/agencies/:rental
     * @access  private
     */
    public AgencyEntity getByRental(RentalEntity rental) {
        return repo.findByRental(rental);
    }
    /**
     * @name    getByActiveStatus
     * @desc    List all active or inactive rental agencies
     * @route   GET /api/agencies/:active
     * @access  private
     */
    public List<AgencyEntity> getByActiveStatus(boolean active) {
        return repo.findByStatus(active);
    }
    /**
     * @name    add
     * @desc    Add a rental agency
     * @route   POST /api/agencies
     * @access  private
     */
    public AgencyEntity add(AgencyEntity agency) {
        return repo.save(agency);
    }
    /**
     * @name    rename
     * @desc    Rename a rental agency
     * @route   PATCH /api/agencies/:pk/name
     * @access  private
     */
    public AgencyEntity rename(
        int pk,
        String name
    ) {
        this.current = repo.findById(pk).get();
        current.setName(name);
        return repo.save(current);
    }
    /**
     * @name    editWebsite
     * @desc    Edit a rental agency's website address
     * @route   PATCH /api/agencies/:pk/website
     * @access  private
     */
    public AgencyEntity editWebsite(
        int pk,
        String website
    ) {
        this.current = repo.findById(pk).get();
        current.setWebsite(website);
        return repo.save(current);
    }

    /**
     * @name    activate
     * @desc    Activate a rental agency
     * @route   PATCH /api/agencies/:pk/active
     * @access  private
     */
    public AgencyEntity activate(int pk) {
        this.current = repo.findById(pk).get();
        current.setActive(true);
        return repo.save(current);
    }
    /**
     * @name    deactivate
     * @desc    Deactivate a rental agency
     * @route   PATCH /api/agencies/:pk/active
     * @access  private
     */
    public AgencyEntity deactivate(int pk) {
        this.current = repo.findById(pk).get();
        current.setActive(false);
        return repo.save(current);
    }
    /**
     * @name    delete
     * @desc    Delete a rental agency
     * @route   DELETE /api/agencies/:pk
     * @access  private
     */
    @Override
    public String delete(int pk) {
        repo.deleteById(pk);
        return "Rental agency deleted.";
    }
}