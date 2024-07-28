package com.keyin.aug2024.sem4.sprint2.team1.api.classes.abstracts;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.UUID;
public abstract class DataEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    protected UUID pk;
    public DataEntity() {
        this.pk = UUID.randomUUID();
    }
    public final UUID getPk() {
        return pk;
    }
    public final void setPk(UUID pk) {
        this.pk = pk;
    }
}