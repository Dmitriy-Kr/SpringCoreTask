package edu.java.springcoretask.service;

import edu.java.springcoretask.dao.impl.TrainingDAOImpl;
import edu.java.springcoretask.entity.Training;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TrainingService {
    @Autowired
    private TrainingDAOImpl trainingDAO;
    private static Logger logger = LoggerFactory.getLogger(TrainingService.class);
    public void create(Training training) {
        trainingDAO.create(training);
        logger.info("Training created with id {}", training.getId());
    }

    public List<Training> select(String userName){
        return trainingDAO.select(userName);
    }
}
