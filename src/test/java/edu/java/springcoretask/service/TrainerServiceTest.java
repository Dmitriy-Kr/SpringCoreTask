package edu.java.springcoretask.service;

import edu.java.springcoretask.dao.impl.TrainerDAOImpl;
import edu.java.springcoretask.entity.Trainer;
import edu.java.springcoretask.entity.TrainingType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TrainerServiceTest {
    @InjectMocks
    private TrainerService trainerService;
    @Mock
    private TrainerDAOImpl trainerDAO;

    @Test
    void testCreate() {

        Trainer trainer = new Trainer("Anton", "Red", new TrainingType("yoga"));

        Mockito.when(trainerDAO.create(trainer)).thenReturn(true);

        Mockito.when(trainerDAO.select(anyString()))
                .thenReturn(Optional.of(trainer))
                .thenReturn(Optional.of(trainer))
                .thenReturn(Optional.of(trainer))
                .thenReturn(Optional.empty());

        trainerService.create(trainer);

        assertEquals("Anton.Red2", trainer.getUserName());
        assertEquals(10, trainer.getPassword().length());
    }

    @Test
    void noTrainerFounded_whenUpdate_shouldThrowException() {

        Trainer trainer = new Trainer("Anton", "Red", new TrainingType("yoga"));

        Mockito.when(trainerDAO.select(anyString())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> trainerService.update(trainer));
    }

    @Test
    void testUpdate() {

        Trainer updatedTrainer = new Trainer(32L, "Igor", "Ivanov",
                "Igor.Ivanov", "aaahj5yto9", false, new TrainingType("yoga"));

        Mockito.when(trainerDAO.select(anyString()))
                .thenReturn(Optional.of(new Trainer(32L, "Igor", "Ivanov",
                        "Igor.Ivanov", "12ghj5yto8", true, new TrainingType("martial arts"))));

        trainerService.update(updatedTrainer);

        final ArgumentCaptor<Trainer> captor = ArgumentCaptor.forClass(Trainer.class);

        verify(trainerDAO, times(1)).update(captor.capture());

        assertFalse(captor.getValue().isActive());

        assertEquals(new TrainingType("yoga"), captor.getValue().getSpecialization());

    }

    @Test
    void givenTrainerHasDifferentFirstName_whenUpdate_shouldChangeUserName() {

        Trainer updatedTrainer = new Trainer(32L, "Denis", "Ivanov",
                "Igor.Ivanov", "aaahj5yto9", false, new TrainingType("martial arts"));

        Mockito.when(trainerDAO.select(anyString()))
                .thenReturn(Optional.of(new Trainer(32L, "Igor", "Ivanov",
                        "Igor.Ivanov", "12ghj5yto8", true, new TrainingType("yoga"))))
                .thenReturn(Optional.empty());

        trainerService.update(updatedTrainer);

        final ArgumentCaptor<Trainer> captor = ArgumentCaptor.forClass(Trainer.class);

        verify(trainerDAO, times(1)).update(captor.capture());

        assertFalse(captor.getValue().isActive());

        assertEquals(new TrainingType("martial arts"), captor.getValue().getSpecialization());

        assertEquals("Denis.Ivanov", captor.getValue().getUserName());

    }

    @Test
    void givenTrainerHasDifferentLastName_whenUpdate_shouldChangeUserName() {

        Trainer updatedTrainer = new Trainer(32L, "Igor", "Schmidt",
                "Igor.Ivanov", "aaahj5yto9", false, new TrainingType("martial arts"));

        Mockito.when(trainerDAO.select(anyString()))
                .thenReturn(Optional.of(new Trainer(32L, "Igor", "Ivanov",
                        "Igor.Ivanov", "12ghj5yto8", true, new TrainingType("yoga"))))
                .thenReturn(Optional.empty());

        trainerService.update(updatedTrainer);

        final ArgumentCaptor<Trainer> captor = ArgumentCaptor.forClass(Trainer.class);

        verify(trainerDAO, times(1)).update(captor.capture());

        assertFalse(captor.getValue().isActive());

        assertEquals(new TrainingType("martial arts"), captor.getValue().getSpecialization());

        assertEquals("Igor.Schmidt", captor.getValue().getUserName());

    }

    @Test
    void select_findTrainer_returnTrainer(){

        Trainer checkTrainer = new Trainer(32L, "Igor", "Ivanov",
                "Igor.Ivanov", "12ghj5yto8", true, new TrainingType("martial arts"));

        Mockito.when(trainerDAO.select(anyString()))
                .thenReturn(Optional.of(new Trainer(32L, "Igor", "Ivanov",
                        "Igor.Ivanov", "12ghj5yto8", true, new TrainingType("martial arts"))));

        Trainer foundTrainer = trainerService.select("Igor.Ivanov");

        assertEquals(checkTrainer, foundTrainer);
    }

    @Test
    void select_notFindTrainer_returnTrainerWithNegativeId(){

        Mockito.when(trainerDAO.select(anyString()))
                .thenReturn(Optional.empty());

        Trainer foundTrainer = trainerService.select("Igor.Ivanov");

        assertTrue(foundTrainer.getId() < 0);
    }
}