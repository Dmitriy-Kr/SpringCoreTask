package edu.java.springcoretask.storage;

import edu.java.springcoretask.entity.Trainer;
import edu.java.springcoretask.utility.JsonToObject;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.Optional;

public class TrainerStorage extends AbstractUserStorage<Trainer> {
    @Value("${trainer_storage_path}")
    private String path;
    @PostConstruct
    public void init() {
        setStorage(JsonToObject.getUserMapFromJson(path, Trainer.class));
    }

    @Override
    public Optional<Trainer> getByUserName(String userName) {

        Optional<Trainer> foundTrainer = storage.values().stream().filter(e -> userName.equals(e.getUserName())).findAny();

        return foundTrainer.map(Trainer::new);
    }
}
