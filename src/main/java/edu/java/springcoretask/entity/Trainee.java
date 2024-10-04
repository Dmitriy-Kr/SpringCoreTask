package edu.java.springcoretask.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Trainee extends User{
    private long userId;
    private LocalDate fateOfBirth;
    private String address;

    public Trainee() {
    }

    public Trainee(String firstName, String lastName, String userName, String password, boolean isActive, long userId, LocalDate fateOfBirth, String address) {
        super(firstName, lastName, userName, password, isActive);
        this.userId = userId;
        this.fateOfBirth = fateOfBirth;
        this.address = address;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getFateOfBirth() {
        return fateOfBirth;
    }

    public void setFateOfBirth(LocalDate fateOfBirth) {
        this.fateOfBirth = fateOfBirth;
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
        return getUserId() == trainee.getUserId() && getFateOfBirth().equals(trainee.getFateOfBirth()) && getAddress().equals(trainee.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUserId(), getFateOfBirth(), getAddress());
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "userId=" + userId +
                ", fateOfBirth=" + fateOfBirth +
                ", address='" + address + '\'' +
                "} " + super.toString();
    }
}
