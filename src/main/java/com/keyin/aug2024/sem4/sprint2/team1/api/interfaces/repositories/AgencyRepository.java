package com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AgencyEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.RentalEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.VehicleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AgencyRepository extends CrudRepository<AgencyEntity, Integer> {
    AgencyEntity findByName(String name);
    AgencyEntity findByWebsite(String website);
    AgencyEntity findByLocation(LocationEntity location);
    AgencyEntity findByContact(ContactEntity contact);
    AgencyEntity findByVehicle(VehicleEntity vehicle);
    AgencyEntity findByRental(RentalEntity rental);
    List<AgencyEntity> findByStatus(boolean active);
}