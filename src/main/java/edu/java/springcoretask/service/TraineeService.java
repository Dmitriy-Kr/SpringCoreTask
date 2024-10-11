package edu.java.springcoretask.service;

import edu.java.springcoretask.entity.Trainee;

public interface TraineeService {
    void create(Trainee trainee);

    public void update(Trainee trainee);

    Trainee delete(Trainee trainee);

    Trainee select(String userName);

    default String createValidUserName(Trainee trainee) {

        String userName = trainee.getFirstName() + "." + trainee.getLastName();

        if (select(userName).getId() < 0) {
            return userName;
        }

        for (long i = 0; i < Long.MAX_VALUE; i++) {
            StringBuilder newUserName = new StringBuilder(userName + i);
            if (select(newUserName.toString()).getId() < 0) {
                return newUserName.toString();
            }
        }

        return userName;
    }
}
