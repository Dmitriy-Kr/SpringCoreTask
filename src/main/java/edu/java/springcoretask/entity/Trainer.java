package edu.java.springcoretask.entity;

import java.util.Objects;

public class Trainer extends User {
    private TrainingType specialization;

    public Trainer() {
    }

    public Trainer(long id) {
        super(id);
    }

    public Trainer(String firstName, String lastName, TrainingType specialization) {
        super(firstName, lastName);
        this.specialization = specialization;
    }

    public Trainer(long id, String firstName, String lastName, String userName, String password, boolean isActive, TrainingType specialization) {
        super(id, firstName, lastName, userName, password, isActive);
        this.specialization = specialization;
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
        return getSpecialization().equals(trainer.getSpecialization());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSpecialization());
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "specialization=" + specialization +
                "} " + super.toString();
    }
}
