package edu.java.springcoretask.dao;

import edu.java.springcoretask.entity.Trainee;

import java.util.Optional;

public interface TraineeDAO {

    boolean create(Trainee trainee);

    void update(Trainee updatedTrainee);

    Trainee delete(Trainee trainee);

    Optional<Trainee> select(String userName);

}
