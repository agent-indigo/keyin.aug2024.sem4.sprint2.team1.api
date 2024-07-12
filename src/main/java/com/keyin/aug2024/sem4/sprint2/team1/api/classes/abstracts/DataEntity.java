package com.keyin.aug2024.sem4.sprint2.team1.api.classes.abstracts;
import com.keyin.aug2024.sem4.sprint2.team1.api.interfaces.PkAccess;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
public abstract class DataEntity implements PkAccess {
    @Id
    @GeneratedValue(generator = "pk")
    protected int pk;
    public DataEntity() {}
    @Override
    public final int getPk() {
        return pk;
    }
    @Override
    public final void setPk(int pk) {
        this.pk = pk;
    }
}