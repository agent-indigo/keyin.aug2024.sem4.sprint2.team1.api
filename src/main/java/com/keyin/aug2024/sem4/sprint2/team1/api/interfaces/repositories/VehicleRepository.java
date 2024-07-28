package com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AgencyEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.RentalEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.VehicleEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.VehicleCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface VehicleRepository extends CrudRepository<VehicleEntity, Integer> {
    List<VehicleEntity> findAllByManufacturer(String manufacturer);
    List<VehicleEntity> findAllByModel(String model);
    List<VehicleEntity> findAllByYear(int year);
    List<VehicleEntity> findAllByCapacity(int capacity);
    List<VehicleEntity> findAllByCategory(VehicleCategory category);
    List<VehicleEntity> findAllByStdRate(float stdRate);
    List<VehicleEntity> findAllByPremRate(float premRate);
    List<VehicleEntity> findAllByStdIns(float stdIns);
    List<VehicleEntity> findAllByPremIns(float premIns);
    VehicleEntity findByPlates(String plates);
    List<VehicleEntity> findAllByAgency(AgencyEntity agency);
    List<VehicleEntity> findAllByLocation(LocationEntity location);
    VehicleEntity findByRental(RentalEntity rental);
    void deleteByPlates(String plates);
    void deleteAllByAgency(AgencyEntity agency);
}