package com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.EmailEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.PhoneEmailCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
@Repository
public interface EmailRepository extends CrudRepository<EmailEntity, UUID> {
    EmailEntity findByAddress(String address);
    EmailEntity findByContact(ContactEntity contact);
    List<EmailEntity> findAllByCategory(PhoneEmailCategory category);
    List<EmailEntity> findAllByActive(boolean active);
}