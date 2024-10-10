package edu.java.springcoretask.service;

import edu.java.springcoretask.dao.TraineeDAO;
import edu.java.springcoretask.entity.Trainee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TraineeServiceTest {
    @InjectMocks
    private TraineeService traineeService;
    @Mock
    private TraineeDAO traineeDAO;
    private Trainee trainee = new Trainee("Igor", "Ivanov", LocalDate.parse("1999-10-05"), "Simonova str 7/15");

    @Test
    void testCreate() {
        Mockito.when(traineeDAO.create(trainee)).thenReturn(true);
        Mockito.when(traineeDAO.select(ArgumentMatchers.anyString()))
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
        Mockito.when(traineeDAO.select(ArgumentMatchers.anyString())).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> traineeService.update(trainee));
    }

    @Test
    void testUpdate() {
        Trainee updatedTrainee = new Trainee(32L, "Igor", "Ivanov",
                "Igor.Ivanov", "aaahj5yto9", false, LocalDate.parse("1999-10-05"), "Simonova str 7/15");

        Mockito.when(traineeDAO.select(ArgumentMatchers.anyString()))
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
        Mockito.when(traineeDAO.select(ArgumentMatchers.anyString()))
                .thenReturn(Optional.of(new Trainee(32L, "Ivan", "Ivanov",
                        "Ivan.Ivanov", "12ghj5yto8", true, LocalDate.parse("1999-10-05"), "Simonova str 7/15")));

        traineeService.update(trainee);


    }
}