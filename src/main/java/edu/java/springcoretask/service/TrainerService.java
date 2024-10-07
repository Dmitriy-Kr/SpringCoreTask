package edu.java.springcoretask.service;

import edu.java.springcoretask.dao.TrainerDAO;
import edu.java.springcoretask.entity.Trainer;
import org.springframework.beans.factory.annotation.Autowired;

public class TrainerService {
    @Autowired
    private TrainerDAO trainerDAO;
    public void create(Trainer trainer) {
        trainerDAO.create(trainer);
    }

    public void update(Trainer trainer) {
        trainerDAO.update(trainer);
    }

    public Trainer select(String userName){
        return trainerDAO.select(userName);
    }
}
