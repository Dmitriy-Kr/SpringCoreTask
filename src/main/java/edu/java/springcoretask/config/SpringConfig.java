package edu.java.springcoretask.config;

import edu.java.springcoretask.storage.TraineeStorage;
import edu.java.springcoretask.storage.TrainerStorage;
import edu.java.springcoretask.storage.TrainingStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("edu.java.springcoretask")
@PropertySource("classpath:application.properties")
public class SpringConfig {
    @Bean
    public TraineeStorage traineeStorage() {
        return new TraineeStorage();
    }

    @Bean
    public TrainerStorage trainerStorage() {
        return new TrainerStorage();
    }

    @Bean
    public TrainingStorage trainingStorage() {
        return new TrainingStorage();
    }
}
