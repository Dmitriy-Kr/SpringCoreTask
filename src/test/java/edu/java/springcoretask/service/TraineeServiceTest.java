package edu.java.springcoretask.service;

import edu.java.springcoretask.dao.impl.TraineeDAOImpl;
import edu.java.springcoretask.entity.Trainee;
import edu.java.springcoretask.service.impl.TraineeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TraineeServiceTest {
    @InjectMocks
    private TraineeServiceImpl traineeService;
    @Mock
    private TraineeDAOImpl traineeDAO;
    private Trainee trainee = new Trainee("Igor", "Ivanov", LocalDate.parse("1999-10-05"), "Simonova str 7/15");

    @Test
    void testCreate() {
        Mockito.when(traineeDAO.create(trainee)).thenReturn(true);
        Mockito.when(traineeDAO.select(anyString()))
                .thenReturn(Optional.ofNullable(trainee))
                .thenReturn(Optional.ofNullable(trainee))
                .thenReturn(Optional.ofNullable(trainee))
                .thenReturn(Optional.empty());

        traineeService.create(trainee);

        assertEquals("Igor.Ivanov2", trainee.getUserName());
        assertEquals(10, trainee.getPassword().length());
    }

    @Test
    void noTraineeFounded_whenUpdate_shouldThrowException() {
        Mockito.when(traineeDAO.select(anyString())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> traineeService.update(trainee));
    }

    @Test
    void testUpdate() {

        Trainee updatedTrainee = new Trainee(32L, "Igor", "Ivanov",
                "Igor.Ivanov", "aaahj5yto9", false, LocalDate.parse("1999-10-05"), "Simonova str 7/15");

        Mockito.when(traineeDAO.select(anyString()))
                .thenReturn(Optional.of(new Trainee(32L, "Igor", "Ivanov",
                        "Igor.Ivanov", "12ghj5yto8", true, LocalDate.parse("1999-10-05"), "West Baker str 31")));

        traineeService.update(updatedTrainee);

        final ArgumentCaptor<Trainee> captor = ArgumentCaptor.forClass(Trainee.class);

        verify(traineeDAO, times(1)).update(captor.capture());

        assertFalse(captor.getValue().isActive());

        assertEquals("Simonova str 7/15", captor.getValue().getAddress());

    }

    @Test
    void givenTraineeHasDifferentFirstName_whenUpdate_shouldChangeUserName() {

        Trainee updatedTrainee = new Trainee(32L, "Denis", "Ivanov",
                "Igor.Ivanov", "aaahj5yto9", false, LocalDate.parse("1999-10-05"), "Simonova str 7/15");

        Mockito.when(traineeDAO.select(anyString()))
                .thenReturn(Optional.of(new Trainee(32L, "Igor", "Ivanov",
                        "Igor.Ivanov", "12ghj5yto8", true, LocalDate.parse("1999-10-05"), "West Baker str 31")))
                .thenReturn(Optional.empty());

        traineeService.update(updatedTrainee);

        final ArgumentCaptor<Trainee> captor = ArgumentCaptor.forClass(Trainee.class);

        verify(traineeDAO, times(1)).update(captor.capture());

        assertFalse(captor.getValue().isActive());

        assertEquals("Simonova str 7/15", captor.getValue().getAddress());

        assertEquals("Denis.Ivanov", captor.getValue().getUserName());

    }

    @Test
    void givenTraineeHasDifferentLastName_whenUpdate_shouldChangeUserName() {

        Trainee updatedTrainee = new Trainee(32L, "Igor", "Schmidt",
                "Igor.Ivanov", "aaahj5yto9", false, LocalDate.parse("1999-10-05"), "Simonova str 7/15");

        Mockito.when(traineeDAO.select(anyString()))
                .thenReturn(Optional.of(new Trainee(32L, "Igor", "Ivanov",
                        "Igor.Ivanov", "12ghj5yto8", true, LocalDate.parse("1999-10-05"), "West Baker str 31")))
                .thenReturn(Optional.empty());

        traineeService.update(updatedTrainee);

        final ArgumentCaptor<Trainee> captor = ArgumentCaptor.forClass(Trainee.class);

        verify(traineeDAO, times(1)).update(captor.capture());

        assertFalse(captor.getValue().isActive());

        assertEquals("Simonova str 7/15", captor.getValue().getAddress());

        assertEquals("Igor.Schmidt", captor.getValue().getUserName());

    }

    @Test
    void select_findTrainee_returnTrainee(){

        Trainee checkTrainee = new Trainee(32L, "Igor", "Ivanov",
                "Igor.Ivanov", "12ghj5yto8", true, LocalDate.parse("1999-10-05"), "West Baker str 31");

        Mockito.when(traineeDAO.select(anyString()))
                .thenReturn(Optional.of(new Trainee(32L, "Igor", "Ivanov",
                        "Igor.Ivanov", "12ghj5yto8", true, LocalDate.parse("1999-10-05"), "West Baker str 31")));

        Trainee foundTrainee = traineeService.select("Igor.Ivanov");

        assertEquals(checkTrainee, foundTrainee);
    }

    @Test
    void select_notFindTrainee_returnTraineeWithNegativeId(){

        Mockito.when(traineeDAO.select(anyString()))
                .thenReturn(Optional.empty());

        Trainee foundTrainee = traineeService.select("Igor.Ivanov");

        assertTrue(foundTrainee.getId() < 0);
    }
}