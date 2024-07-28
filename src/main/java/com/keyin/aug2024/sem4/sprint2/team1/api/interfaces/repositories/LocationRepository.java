package com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AddressEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AgencyEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.PhoneEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.RentalEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.VehicleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface LocationRepository extends CrudRepository<LocationEntity, Integer> {
    List<LocationEntity> findAllByAgency(AgencyEntity agency);
    LocationEntity findByAddress(AddressEntity address);
    LocationEntity findByPhone(PhoneEntity phone);
    LocationEntity findByVehicle(VehicleEntity vehicle);
    List<LocationEntity> findAllByRental(RentalEntity rental);
    List<LocationEntity> findAllByHours(String hours);
    void deleteAllByAgency(AgencyEntity agency);
    void deleteByAddress(AddressEntity address);
    void deleteByPhone(PhoneEntity phone);
}