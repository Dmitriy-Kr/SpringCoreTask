package edu.java.springcoretask.config;

import edu.java.springcoretask.storage.UserStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:init_storage.properties")
public class SpringConfig {

    @Bean
    public UserStorage userStorage() {
        return new UserStorage();
    }
}
