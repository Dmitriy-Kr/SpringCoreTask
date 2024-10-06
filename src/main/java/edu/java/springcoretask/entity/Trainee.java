package edu.java.springcoretask.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Trainee extends User{
    private long id;
    private long userId;
    private LocalDate dateOfBirth;
    private String address;

    public Trainee() {
    }

    public Trainee(long id, String firstName, String lastName, String userName, String password, boolean isActive, long id1, long userId, LocalDate dateOfBirth, String address) {
        super(id, firstName, lastName, userName, password, isActive);
        this.id = id1;
        this.userId = userId;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
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
        return getId() == trainee.getId() && getUserId() == trainee.getUserId() && getDateOfBirth().equals(trainee.getDateOfBirth()) && getAddress().equals(trainee.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getUserId(), getDateOfBirth(), getAddress());
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id=" + id +
                ", userId=" + userId +
                ", fateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                "} " + super.toString();
    }
}
