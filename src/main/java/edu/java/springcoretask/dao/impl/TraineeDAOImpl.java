package edu.java.springcoretask.dao.impl;

import edu.java.springcoretask.dao.TraineeDAO;
import edu.java.springcoretask.entity.Trainee;
import edu.java.springcoretask.storage.TraineeStorage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TraineeDAOImpl implements TraineeDAO {
    @Autowired
    private TraineeStorage traineeStorage;

    /**
     * Place the Trainee object into the Trainee storage and set the returned key to the Trainee.
     *
     * @param trainee
     * @return boolean
     */
    public boolean create(Trainee trainee) {
        long key = traineeStorage.put(trainee);
        trainee.setId(key);
        return true;
    }

    public void update(Trainee updatedTrainee) {
        traineeStorage.update(updatedTrainee.getId(), updatedTrainee);
    }

    public Trainee delete(Trainee trainee) {
        return traineeStorage.delete(trainee.getId());
    }

    public Optional<Trainee> select(String userName) {
        return traineeStorage.getByUserName(userName);
    }
}
