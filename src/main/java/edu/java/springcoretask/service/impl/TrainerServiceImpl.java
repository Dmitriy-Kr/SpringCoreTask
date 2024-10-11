package edu.java.springcoretask.service.impl;

import edu.java.springcoretask.dao.TrainerDAO;
import edu.java.springcoretask.entity.Trainer;
import edu.java.springcoretask.service.TrainerService;
import edu.java.springcoretask.utility.PasswordGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("trainerService")
public class TrainerServiceImpl implements TrainerService {
    @Autowired
    private TrainerDAO trainerDAO;
    private static Logger logger = LoggerFactory.getLogger(TrainerServiceImpl.class);

    public void create(Trainer trainer) {
        trainer.setUserName(createValidUserName(trainer));
        trainer.setPassword(PasswordGenerator.generatePassword());
        trainer.setIsActive(true);

        trainerDAO.create(trainer);

        logger.info("Trainer created with id {}", trainer.getId());
    }

    public void update(Trainer trainer) {
        Trainer updatedTrainer = select(trainer.getUserName());

        if (updatedTrainer.getId() >= 0) {

            if(updatedTrainer.getFirstName().equals(trainer.getFirstName()) && updatedTrainer.getLastName().equals(trainer.getLastName())){

                updatedTrainer.setUserName(trainer.getUserName());

            } else {

                updatedTrainer.setUserName(createValidUserName(trainer));
                updatedTrainer.setFirstName(trainer.getFirstName());
                updatedTrainer.setLastName(trainer.getLastName());

            }

            updatedTrainer.setIsActive(trainer.isActive());
            updatedTrainer.setSpecialization(trainer.getSpecialization());

            trainerDAO.update(updatedTrainer);

            logger.info("Trainer with id {} updated ", trainer.getId());

        } else {
            logger.error("No such element present in the store Trainer with userName {}", trainer.getUserName());
            throw new RuntimeException("No such element present in the Trainer store");
        }
    }

    public Trainer select(String userName) {
        return trainerDAO.select(userName).orElse(new Trainer(-100));
    }

}
