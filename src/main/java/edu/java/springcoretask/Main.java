package edu.java.springcoretask;

import edu.java.springcoretask.config.SpringConfig;
import edu.java.springcoretask.entity.Trainee;
import edu.java.springcoretask.entity.Trainer;
import edu.java.springcoretask.entity.Training;
import edu.java.springcoretask.entity.TrainingType;
import edu.java.springcoretask.service.TraineeService;
import edu.java.springcoretask.service.TrainerService;
import edu.java.springcoretask.service.TrainingService;
import edu.java.springcoretask.storage.TraineeStorage;
import edu.java.springcoretask.storage.TrainerStorage;
import edu.java.springcoretask.storage.TrainingStorage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------- Show trainee storage ------------------------------");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        TraineeStorage traineeStorage = context.getBean("traineeStorage", TraineeStorage.class);

        for (Trainee trainee : traineeStorage.getAllValues()) {
            System.out.println(trainee);
        }


        System.out.println("--------------------- Show trainer storage ------------------------------");

        TrainerStorage trainerStorage = context.getBean("trainerStorage", TrainerStorage.class);

        for (Trainer trainer : trainerStorage.getAllValues()) {
            System.out.println(trainer);
        }


        System.out.println("-------------------- Show training storage -------------------------------");

        TrainingStorage trainingStorage = context.getBean("trainingStorage", TrainingStorage.class);

        for (Training training : trainingStorage.getAllValues()) {
            System.out.println(training);
        }


        System.out.println("------------------- Find Trainee by username --------------------------------");

        TraineeService traineeService = context.getBean("traineeService", TraineeService.class);

        System.out.println(traineeService.select("Shannon.Velazquez"));


        System.out.println("--------------------- Find Trainer by username ------------------------------");

        TrainerService trainerService = context.getBean("trainerService", TrainerService.class);

        System.out.println(trainerService.select("Frazier.Richards"));


        System.out.println("--------------------- Find Trainings by username ------------------------------");

        TrainingService trainingService = context.getBean("trainingService", TrainingService.class);

        System.out.println(trainingService.select("Allyson.Bauer"));


        System.out.println("--------------------- Create Trainee ------------------------------");

        Trainee trainee = new Trainee("Igor",
                "Ivanov",
                LocalDate.parse("1999-10-05"),
                "Simonova str 7/15");

        traineeService.create(trainee);

        trainee = new Trainee("Igor",
                "Ivanov",
                LocalDate.parse("2000-11-15"),
                "Red str 9/189");

        traineeService.create(trainee);

        for (Trainee showTrainee : traineeStorage.getAllValues()) {
            System.out.println(showTrainee);
        }


        System.out.println("--------------------- Update Trainee ------------------------------");

        Trainee updatedTrainee = traineeService.select("Igor.Ivanov");

        updatedTrainee.setLastName("Petrov");

        traineeService.update(updatedTrainee);

        System.out.println("updated trainee " + traineeService.select("Igor.Petrov"));

        for (Trainee showTrainee : traineeStorage.getAllValues()) {
            System.out.println(showTrainee);
        }


        System.out.println("--------------------- Delete Trainee ------------------------------");

        Trainee deleteTrainee = traineeService.select("Igor.Petrov");
        traineeService.delete(deleteTrainee);
        System.out.println("Deleted trainee " + traineeService.select("Igor.Petrov"));

        for (Trainee showTrainee : traineeStorage.getAllValues()) {
            System.out.println(showTrainee);
        }


        System.out.println("--------------------- Create Trainer ------------------------------");

        Trainer trainer = new Trainer("Samanta",
                "Serova",
                new TrainingType("resistance"));

        trainerService.create(trainer);

        trainer = new Trainer("Samanta",
                "Serova",
                new TrainingType("fitness"));

        trainerService.create(trainer);

        trainer = new Trainer("Samanta",
                "Serova",
                new TrainingType("Zumba"));

        trainerService.create(trainer);

        for (Trainer trainer1 : trainerStorage.getAllValues()) {
            System.out.println(trainer1);
        }


        System.out.println("--------------------- Update Trainer ------------------------------");

        Trainer updatedTrainer = trainerService.select("Samanta.Serova");

        updatedTrainer.setLastName("Bronks");

        trainerService.update(updatedTrainer);

        System.out.println("updated trainer " + trainerService.select("Samanta.Bronks"));

        for (Trainer showTrainer : trainerStorage.getAllValues()) {
            System.out.println(showTrainer);
        }

        System.out.println("--------------------- Create Training ------------------------------");

        Training newTraining = new Training(60, 23, 67, "some training", new TrainingType("yoga"), LocalDate.parse("2024-12-27"), 60);

        trainingService.create(newTraining);

        for (Training training : trainingStorage.getAllValues()) {
            System.out.println(training);
        }
    }
}
