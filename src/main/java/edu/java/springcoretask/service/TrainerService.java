package edu.java.springcoretask.service;

import edu.java.springcoretask.dao.TrainerDAO;
import edu.java.springcoretask.entity.Trainer;
import edu.java.springcoretask.utility.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;

public class TrainerService {
    @Autowired
    private TrainerDAO trainerDAO;

    public void create(Trainer trainer) {
        trainer.setUserName(createValidUserName(trainer));
        trainer.setPassword(PasswordGenerator.generatePassword());
        trainer.setIsActive(true);
        trainerDAO.create(trainer);
    }

    public void update(Trainer trainer) {
        trainerDAO.update(trainer);
    }

    public Trainer select(String userName) {
        return trainerDAO.select(userName);
    }

    private String createValidUserName(Trainer trainer) {
        String userName = trainer.getFirstName() + "." + trainer.getLastName();
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            if (select(userName).getId() < 0) {
                return userName;
            }
            userName += i;
        }
        return userName;
    }
}
