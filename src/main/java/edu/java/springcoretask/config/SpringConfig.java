package edu.java.springcoretask.config;

import edu.java.springcoretask.dao.TraineeDAO;
import edu.java.springcoretask.dao.TrainerDAO;
import edu.java.springcoretask.service.TraineeService;
import edu.java.springcoretask.service.TrainerService;
import edu.java.springcoretask.storage.TraineeStorage;
import edu.java.springcoretask.storage.TrainerStorage;
import edu.java.springcoretask.storage.TrainingStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:init_storage.properties")
public class SpringConfig {
    @Bean
    public TraineeStorage traineeStorage() {
        return new TraineeStorage();
    }
    @Bean
    public TraineeDAO traineeDAO(){
        return new TraineeDAO();
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
    public TrainerDAO trainerDAO(){
        return new TrainerDAO();
    }
    @Bean
    public TrainerService trainerService(){
        return new TrainerService();
    }

    @Bean
    public TrainingStorage trainingStorage() {
        return new TrainingStorage();
    }
}
