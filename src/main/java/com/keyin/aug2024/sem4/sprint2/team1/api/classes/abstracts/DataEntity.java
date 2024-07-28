package com.keyin.aug2024.sem4.sprint2.team1.api.classes.abstracts;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.util.UUID;
@MappedSuperclass
public abstract class DataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID pk;
    private boolean active;
    public DataEntity() {
        this.pk = UUID.randomUUID();
        this.active = true;
    }
    public final UUID getPk() {
        return pk;
    }
    public final void setPk(UUID pk) {
        this.pk = pk;
    }
    public final boolean isActive() {
        return active;
    }
    public final void setActive(boolean active) {
        this.active = active;
    }
}