package edu.java.springcoretask.service;

import edu.java.springcoretask.entity.Training;

import java.util.List;

public interface TrainingService {

    void create(Training training);

    List<Training> select(String userName);

}
