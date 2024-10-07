package edu.java.springcoretask.dao;

import edu.java.springcoretask.entity.Trainer;
import edu.java.springcoretask.storage.TrainerStorage;
import org.springframework.beans.factory.annotation.Autowired;

public class TrainerDAO {
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

    public Trainer select(String userName) {
        return trainerStorage.getByUserName(userName);
    }
}
