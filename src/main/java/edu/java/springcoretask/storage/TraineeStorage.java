package edu.java.springcoretask.storage;

import edu.java.springcoretask.entity.Trainee;
import edu.java.springcoretask.utility.JsonToObject;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

public class TraineeStorage extends Storage<Trainee>{
    @Value("${trainee_storage_path}")
    private String path;
    @PostConstruct
    public void init() {
        setStorage(JsonToObject.getUserMapFromJson(path, Trainee.class));
    }
}
