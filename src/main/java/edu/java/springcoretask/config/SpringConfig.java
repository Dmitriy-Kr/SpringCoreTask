package edu.java.springcoretask.config;

import edu.java.springcoretask.storage.TraineeStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:init_storage.properties")
public class SpringConfig {

//    @Bean
//    public UserStorage userStorage() {
//        return new UserStorage();
//    }

    @Bean
    public TraineeStorage traineeStorage() {
        return new TraineeStorage();
    }
}
