package edu.java.springcoretask.service;

import edu.java.springcoretask.dao.TraineeDAO;
import edu.java.springcoretask.entity.Trainee;
import org.springframework.beans.factory.annotation.Autowired;

public class TraineeService {
    @Autowired
    private TraineeDAO traineeDAO;

    public TraineeService() {
    }

    //@Autowired
    public TraineeService(TraineeDAO traineeDAO) {
        this.traineeDAO = traineeDAO;
    }

    public void create(Trainee trainee) {
        traineeDAO.create(trainee);
    }

    public void update(Trainee trainee) {
        traineeDAO.update(trainee);
    }

    public Trainee delete(Trainee trainee) {
        return traineeDAO.delete(trainee);
    }

    public Trainee select(String userName) {
        return traineeDAO.select(userName);
    }
}
