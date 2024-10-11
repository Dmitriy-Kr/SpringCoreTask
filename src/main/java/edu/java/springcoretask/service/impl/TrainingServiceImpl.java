package edu.java.springcoretask.service.impl;

import edu.java.springcoretask.dao.TrainingDAO;
import edu.java.springcoretask.entity.Training;
import edu.java.springcoretask.service.TrainingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("trainingService")
public class TrainingServiceImpl implements TrainingService {
    @Autowired
    private TrainingDAO trainingDAO;
    private static Logger logger = LoggerFactory.getLogger(TrainingServiceImpl.class);
    public void create(Training training) {
        trainingDAO.create(training);
        logger.info("Training created with id {}", training.getId());
    }

    public List<Training> select(String userName){
        return trainingDAO.select(userName);
    }
}
