package edu.java.springcoretask.entity;

import java.util.Objects;

public class Trainer extends User {
    private long id;
    private long userId;
    private TrainingType specialization;

    public Trainer() {
    }

    public Trainer(long id, String firstName, String lastName, String userName, String password, boolean isActive, long id1, long userId, TrainingType specialization) {
        super(id, firstName, lastName, userName, password, isActive);
        this.id = id1;
        this.userId = userId;
        this.specialization = specialization;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public TrainingType getSpecialization() {
        return specialization;
    }

    public void setSpecialization(TrainingType specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        if (!super.equals(o)) return false;
        Trainer trainer = (Trainer) o;
        return getId() == trainer.getId() && getUserId() == trainer.getUserId() && getSpecialization().equals(trainer.getSpecialization());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getUserId(), getSpecialization());
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", userId=" + userId +
                ", specialization=" + specialization +
                "} " + super.toString();
    }
}
