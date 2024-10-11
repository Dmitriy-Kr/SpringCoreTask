package edu.java.springcoretask.dao;

import edu.java.springcoretask.entity.Training;

import java.util.List;

public interface TrainingDAO {

    public boolean create(Training training);

    public List<Training> select(String userName);

}
