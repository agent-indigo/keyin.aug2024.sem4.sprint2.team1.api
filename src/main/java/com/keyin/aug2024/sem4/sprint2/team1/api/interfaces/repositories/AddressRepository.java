package com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AddressEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.AddressCategory;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.ProvTerrCode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, UUID> {
    List<AddressEntity> findAllByNumber(int number);
    List<AddressEntity> findAllByStreet(String street);
    List<AddressEntity> findAllByUnit(int unit);
    List<AddressEntity> findAllByCity(String city);
    List<AddressEntity> findAllByProv(ProvTerrCode prov);
    List<AddressEntity> findAllByPostal(String postal);
    List<AddressEntity> findAllByCategory(AddressCategory category);
    List<AddressEntity> findAllByContact(ContactEntity contact);
    AddressEntity findByLocation(LocationEntity location);
    void deleteAllByContact(ContactEntity contact);
    void deleteByLocation(LocationEntity location);
}