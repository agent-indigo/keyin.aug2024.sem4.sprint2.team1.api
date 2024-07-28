package com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.LocationEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.PhoneEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.PhoneEmailCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface PhoneRepository extends CrudRepository<PhoneEntity, Integer> {
    PhoneEntity findByNumber(String number);
    List<PhoneEntity> findAllByContact(ContactEntity contact);
    List<PhoneEntity> findAllByCategory(PhoneEmailCategory category);
    PhoneEntity findByLocation(LocationEntity location);
    void deleteByNumber(String number);
    void deleteAllByContact(ContactEntity contact);
    void deleteByLocation(LocationEntity location);
}