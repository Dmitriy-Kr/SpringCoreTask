package edu.java.springcoretask.entity;

import java.util.Objects;

public class Trainer extends User {
    long userId;
    TrainingType specialization;

    public Trainer(String firstName, String lastName, String userName, String password, boolean isActive, long userId, TrainingType specialization) {
        super(firstName, lastName, userName, password, isActive);
        this.userId = userId;
        this.specialization = specialization;
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
        return getUserId() == trainer.getUserId() && getSpecialization() == trainer.getSpecialization();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUserId(), getSpecialization());
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "userId=" + userId +
                ", specialization=" + specialization +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
