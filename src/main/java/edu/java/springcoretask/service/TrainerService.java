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
        return trainerDAO.select(userName).orElse(new Trainer(-100));
    }

    private String createValidUserName(Trainer trainer) {
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
