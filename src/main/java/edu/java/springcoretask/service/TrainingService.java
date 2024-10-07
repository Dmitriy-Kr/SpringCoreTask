package edu.java.springcoretask.service;

import edu.java.springcoretask.dao.TrainingDAO;
import edu.java.springcoretask.entity.Training;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TrainingService {
    @Autowired
    private TrainingDAO trainingDAO;
    public void create(Training training) {
        trainingDAO.create(training);
    }

    public List<Training> select(String userName){
        return trainingDAO.select(userName);
    }
}
