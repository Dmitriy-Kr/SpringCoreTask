package edu.java.springcoretask.storage;

import edu.java.springcoretask.entity.Trainee;
import edu.java.springcoretask.entity.Trainer;
import edu.java.springcoretask.entity.Training;
import edu.java.springcoretask.utility.JsonToObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

public class TrainingStorage extends AbstractTrainingStorage<Training> {
    @Value("${training_storage_path}")
    private String path;
    private TraineeStorage traineeStorage;
    private TrainerStorage trainerStorage;

    @Autowired
    public void setTraineeStorage(TraineeStorage traineeStorage) {
        this.traineeStorage = traineeStorage;
    }

    @Autowired
    public void setTrainerStorage(TrainerStorage trainerStorage) {
        this.trainerStorage = trainerStorage;
    }

    @PostConstruct
    public void init() {
        setStorage(JsonToObject.getTrainingMapFromJson(path, Training.class));
    }

    @Override
    public List<Training> getByUserName(String userName) {
        long traineeId = traineeStorage.getByUserName(userName).orElse(new Trainee(-100)).getId();
        long trainerId = trainerStorage.getByUserName(userName).orElse(new Trainer(-100)).getId();
        return storage.values().stream().filter(e -> traineeId == e.getTraineeId() || trainerId == e.getTrainerId()).collect(Collectors.toList());
    }
}
