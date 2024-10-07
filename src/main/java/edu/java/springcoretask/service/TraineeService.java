package edu.java.springcoretask.service;

import edu.java.springcoretask.dao.TraineeDAO;
import edu.java.springcoretask.entity.Trainee;
import edu.java.springcoretask.utility.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;

public class TraineeService {
    @Autowired
    private TraineeDAO traineeDAO;

    public void create(Trainee trainee) {
        trainee.setUserName(createValidUserName(trainee));
        trainee.setPassword(PasswordGenerator.generatePassword());
        trainee.setIsActive(true);
        traineeDAO.create(trainee);
    }

    public void update(Trainee trainee) {
        traineeDAO.update(trainee);
    }

    public Trainee delete(Trainee trainee) {
        return traineeDAO.delete(trainee);
    }

    public Trainee select(String userName) {
        return traineeDAO.select(userName).orElse(new Trainee(-100));
    }
    
    private String createValidUserName(Trainee trainee){

        String userName = trainee.getFirstName() + "." + trainee.getLastName();

        if(select(userName).getId() < 0){
            return userName;
        }

        for (long i = 0; i < Long.MAX_VALUE; i++) {
            StringBuilder newUserName = new StringBuilder(userName + i);
            if(select(newUserName.toString()).getId() < 0){
                return newUserName.toString();
            }
        }

        return userName;
}
}
