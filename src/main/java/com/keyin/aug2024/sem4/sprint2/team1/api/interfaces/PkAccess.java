package com.keyin.aug2024.sem4.sprint2.team1.api.interfaces;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
@Entity
public interface PkAccess {
    @SequenceGenerator(
        name = "pk",
        sequenceName = "pk"
    )
    int getPk();
    void setPk(int pk);
}