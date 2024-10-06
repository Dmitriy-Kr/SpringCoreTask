package edu.java.springcoretask.storage;

import edu.java.springcoretask.entity.Training;
import edu.java.springcoretask.utility.JsonToObject;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

public class TrainingStorage extends Storage<Training>{
    @Value("${training_storage_path}")
    private String path;
    @PostConstruct
    public void init() {
        setStorage(JsonToObject.getTrainingMapFromJson(path, Training.class));
    }
}
