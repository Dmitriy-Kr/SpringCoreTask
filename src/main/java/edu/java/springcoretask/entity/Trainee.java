package edu.java.springcoretask.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Trainee extends User{
    private LocalDate dateOfBirth;
    private String address;

    public Trainee() {
    }

    public Trainee(long id, String firstName, String lastName, String userName, String password, boolean isActive, LocalDate dateOfBirth, String address) {
        super(id, firstName, lastName, userName, password, isActive);
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate fateOfBirth) {
        this.dateOfBirth = fateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        if (!super.equals(o)) return false;
        Trainee trainee = (Trainee) o;
        return getDateOfBirth().equals(trainee.getDateOfBirth()) && getAddress().equals(trainee.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDateOfBirth(), getAddress());
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                "} " + super.toString();
    }
}
