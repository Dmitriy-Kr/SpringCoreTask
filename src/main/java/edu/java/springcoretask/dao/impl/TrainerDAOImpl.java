package edu.java.springcoretask.dao.impl;

import edu.java.springcoretask.dao.TrainerDAO;
import edu.java.springcoretask.entity.Trainer;
import edu.java.springcoretask.storage.TrainerStorage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TrainerDAOImpl implements TrainerDAO {
    @Autowired
    private TrainerStorage trainerStorage;

    /**
     * Place the Trainee object into the Trainee storage and set the returned key to the Trainee.
     *
     * @param trainer
     * @return boolean
     */
    public boolean create(Trainer trainer) {
        long key = trainerStorage.put(trainer);
        trainer.setId(key);
        return true;
    }

    public void update(Trainer trainer) {
        trainerStorage.update(trainer.getId(), trainer);
    }

    public Optional<Trainer> select(String userName) {
        return trainerStorage.getByUserName(userName);
    }
}
