package edu.java.springcoretask.service;

import edu.java.springcoretask.entity.Trainer;

public interface TrainerService {

    public void create(Trainer trainer);

    public void update(Trainer trainer);

    public Trainer select(String userName);

    default String createValidUserName(Trainer trainer) {
        String userName = trainer.getFirstName() + "." + trainer.getLastName();

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
