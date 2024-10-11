package edu.java.springcoretask.config;

import edu.java.springcoretask.dao.impl.TraineeDAOImpl;
import edu.java.springcoretask.dao.impl.TrainerDAOImpl;
import edu.java.springcoretask.dao.impl.TrainingDAOImpl;
import edu.java.springcoretask.service.TraineeService;
import edu.java.springcoretask.service.TrainerService;
import edu.java.springcoretask.service.TrainingService;
import edu.java.springcoretask.storage.TraineeStorage;
import edu.java.springcoretask.storage.TrainerStorage;
import edu.java.springcoretask.storage.TrainingStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class SpringConfig {
    @Bean
    public TraineeStorage traineeStorage() {
        return new TraineeStorage();
    }
    @Bean
    public TraineeDAOImpl traineeDAO(){
        return new TraineeDAOImpl();
    }
    @Bean
    public TraineeService traineeService(){
        return new TraineeService();
    }

    @Bean
    public TrainerStorage trainerStorage() {
        return new TrainerStorage();
    }

    @Bean
    public TrainerDAOImpl trainerDAO(){
        return new TrainerDAOImpl();
    }
    @Bean
    public TrainerService trainerService(){
        return new TrainerService();
    }

    @Bean
    public TrainingStorage trainingStorage() {
        return new TrainingStorage();
    }
    @Bean
    public TrainingDAOImpl trainingDAO(){
        return new TrainingDAOImpl();
    }
    @Bean
    public TrainingService trainingService(){
        return new TrainingService();
    }
}
