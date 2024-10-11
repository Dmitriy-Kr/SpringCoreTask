package edu.java.springcoretask.dao;

import edu.java.springcoretask.entity.Trainer;

import java.util.Optional;

public interface TrainerDAO {

    boolean create(Trainer trainer);

    void update(Trainer trainer);

    Optional<Trainer> select(String userName);

}
