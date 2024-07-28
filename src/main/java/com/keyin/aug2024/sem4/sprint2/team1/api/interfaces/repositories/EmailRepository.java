package com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.EmailEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.PhoneEmailCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface EmailRepository extends CrudRepository<EmailEntity, Integer> {
    EmailEntity findByAddress(String address);
    EmailEntity findByContact(ContactEntity contact);
    List<EmailEntity> findAllByCategory(PhoneEmailCategory category);
    void deleteByAddress(String address);
    void deleteByContact(ContactEntity contact);
}