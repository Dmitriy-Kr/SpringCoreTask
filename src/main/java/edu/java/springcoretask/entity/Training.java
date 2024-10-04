package edu.java.springcoretask.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Training {
    private long id;
    private long traineeId;
    private long trainerId;
    private String trainingName;
    private TrainingType trainingType;
    private LocalDate trainingDay;

    public Training() {
    }

    public Training(long id, long traineeId, long trainerId, String trainingName, TrainingType trainingType, LocalDate trainingDay) {
        this.id = id;
        this.traineeId = traineeId;
        this.trainerId = trainerId;
        this.trainingName = trainingName;
        this.trainingType = trainingType;
        this.trainingDay = trainingDay;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(long traineeId) {
        this.traineeId = traineeId;
    }

    public long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(long trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public TrainingType getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(TrainingType trainingType) {
        this.trainingType = trainingType;
    }

    public LocalDate getTrainingDay() {
        return trainingDay;
    }

    public void setTrainingDay(LocalDate trainingDay) {
        this.trainingDay = trainingDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Training training = (Training) o;
        return getId() == training.getId() && getTraineeId() == training.getTraineeId() && getTrainerId() == training.getTrainerId() && getTrainingName().equals(training.getTrainingName()) && getTrainingType().equals(training.getTrainingType()) && getTrainingDay().equals(training.getTrainingDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTraineeId(), getTrainerId(), getTrainingName(), getTrainingType(), getTrainingDay());
    }

    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", traineeId=" + traineeId +
                ", trainerId=" + trainerId +
                ", trainingName='" + trainingName + '\'' +
                ", trainingType=" + trainingType +
                ", trainingDay=" + trainingDay +
                '}';
    }
}
