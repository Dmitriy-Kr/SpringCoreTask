package edu.java.springcoretask.dao.impl;

import edu.java.springcoretask.dao.TrainingDAO;
import edu.java.springcoretask.entity.Training;
import edu.java.springcoretask.storage.TrainingStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("trainingDAO")
@DependsOn("trainingStorage")
public class TrainingDAOImpl implements TrainingDAO {
    private TrainingStorage trainingStorage;
    @Autowired
    public void setTrainingStorage(TrainingStorage trainingStorage) {
        this.trainingStorage = trainingStorage;
    }

    public boolean create(Training training) {
        long key = trainingStorage.put(training);
        training.setId(key);
        return true;
    }

    public List<Training> select(String userName) {
        return trainingStorage.getByUserName(userName);
    }
}
