package edu.java.springcoretask.storage;

import edu.java.springcoretask.entity.Trainer;
import edu.java.springcoretask.utility.JsonToObject;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

public class TrainerStorage extends Storage<Trainer> {
    @Value("${trainer_storage_path}")
    private String path;
    @PostConstruct
    public void init() {
        setStorage(JsonToObject.getUserMapFromJson(path, Trainer.class));
    }

    @Override
    public Trainer getByUserName(String userName) {
        return null;
    }
}
