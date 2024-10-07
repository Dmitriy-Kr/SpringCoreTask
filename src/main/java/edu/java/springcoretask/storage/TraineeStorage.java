package edu.java.springcoretask.storage;

import edu.java.springcoretask.entity.Trainee;
import edu.java.springcoretask.utility.JsonToObject;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.Optional;

public class TraineeStorage extends AbstractUserStorage<Trainee>{
    @Value("${trainee_storage_path}")
    private String path;
    @PostConstruct
    public void init() {
        setStorage(JsonToObject.getUserMapFromJson(path, Trainee.class));
    }

    @Override
    public Optional<Trainee> getByUserName(String userName) {
        return storage.values().stream().filter(trainee -> userName.equals(trainee.getUserName())).findAny();
    }
}
