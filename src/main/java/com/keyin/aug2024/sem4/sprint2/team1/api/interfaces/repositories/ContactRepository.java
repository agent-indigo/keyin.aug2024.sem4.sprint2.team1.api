package com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.repositories;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.AddressEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.ContactEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.EmailEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.PhoneEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.classes.entities.RentalEntity;
import com.keyin.aug2024.sem4.sprint2.team1.api.enums.ContactRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
@Repository
public interface ContactRepository extends CrudRepository<ContactEntity, UUID> {
    List<ContactEntity> findAllByFirst(String first);
    List<ContactEntity> findAllByLast(String last);
    List<ContactEntity> findAllByRole(ContactRole role);
    List<ContactEntity> findAllByAddress(AddressEntity address);
    List<ContactEntity> findAllByPhone(PhoneEntity phone);
    ContactEntity findByEmail(EmailEntity email);
    ContactEntity findByRental(RentalEntity rental);
    void deleteByEmail(EmailEntity email);
}