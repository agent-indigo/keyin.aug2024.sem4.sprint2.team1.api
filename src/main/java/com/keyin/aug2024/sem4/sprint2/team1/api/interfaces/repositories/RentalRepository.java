package com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AgencyEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.RentalEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.VehicleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
@Repository
public interface RentalRepository extends CrudRepository<RentalEntity, UUID> {
    List<RentalEntity> findAllByVehicle(VehicleEntity vehicle);
    List<RentalEntity> findAllByContact(ContactEntity contact);
    List<RentalEntity> findAllByLicense(String license);
    List<RentalEntity> findAllByAgency(AgencyEntity agency);
    List<RentalEntity> findAllByRentedFrom(LocationEntity rentedFrom);
    List<RentalEntity> findAllByRentedOn(ZonedDateTime rentedOn);
    List<RentalEntity> findAllByDue(ZonedDateTime due);
    List<RentalEntity> findAllByReturnedOn(ZonedDateTime returnedOn);
    List<RentalEntity> findAllByReturnedTo(LocationEntity returnedTo);
    void deleteAllByVehicle(VehicleEntity vehicle);
    void deleteAllByContact(ContactEntity contact);
    void deleteAllByAgency(AgencyEntity agency);
}