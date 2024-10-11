package edu.java.springcoretask.service.impl;

import edu.java.springcoretask.dao.TraineeDAO;
import edu.java.springcoretask.entity.Trainee;
import edu.java.springcoretask.service.TraineeService;
import edu.java.springcoretask.utility.PasswordGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("traineeService")
public class TraineeServiceImpl implements TraineeService {
    @Autowired
    private TraineeDAO traineeDAO;
    private static Logger logger = LoggerFactory.getLogger(TraineeServiceImpl.class);

    public void create(Trainee trainee) {
        trainee.setUserName(createValidUserName(trainee));
        trainee.setPassword(PasswordGenerator.generatePassword());
        trainee.setIsActive(true);

        traineeDAO.create(trainee);

        logger.info("Trainee created with id {}", trainee.getId());
    }

    public void update(Trainee trainee) {

        Trainee updatedTrainee = select(trainee.getUserName());

        if (updatedTrainee.getId() >= 0) {

            if(updatedTrainee.getFirstName().equals(trainee.getFirstName()) && updatedTrainee.getLastName().equals(trainee.getLastName())){

                updatedTrainee.setUserName(trainee.getUserName());

            } else {

                updatedTrainee.setUserName(createValidUserName(trainee));
                updatedTrainee.setFirstName(trainee.getFirstName());
                updatedTrainee.setLastName(trainee.getLastName());

            }

            updatedTrainee.setDateOfBirth(trainee.getDateOfBirth());
            updatedTrainee.setAddress(trainee.getAddress());
            updatedTrainee.setIsActive(trainee.isActive());

            traineeDAO.update(updatedTrainee);

            logger.info("Trainee updated with id {}", trainee.getId());

        } else {
            logger.error("No such element present in the store Trainee with userName {}", trainee.getUserName());
            throw new RuntimeException("No such element present in the Trainee store");
        }
    }

    public Trainee delete(Trainee trainee) {
        Trainee deletedTrainee = traineeDAO.delete(trainee);
        logger.info("Trainee deleted with id {}", deletedTrainee.getId());
        return deletedTrainee;
    }

    public Trainee select(String userName) {
        return traineeDAO.select(userName).orElse(new Trainee(-100));
    }

}
