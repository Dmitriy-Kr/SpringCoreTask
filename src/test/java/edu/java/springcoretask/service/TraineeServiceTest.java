package edu.java.springcoretask.service;

import edu.java.springcoretask.dao.TraineeDAO;
import edu.java.springcoretask.entity.Trainee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;
@ExtendWith(MockitoExtension.class)
class TraineeServiceTest {
    @InjectMocks
    private TraineeService traineeService;
    @Mock
    private TraineeDAO traineeDAO;
    private Trainee trainee = new Trainee("Igor","Ivanov", LocalDate.parse("1999-10-05"),"Simonova str 7/15");
    @Test
    void testCreate() {
    Mockito.when(traineeDAO.create(trainee)).thenReturn(true);
    Mockito.when(traineeDAO.select(ArgumentMatchers.anyString()))
            .thenReturn(Optional.ofNullable(trainee))
            .thenReturn(Optional.ofNullable(trainee))
            .thenReturn(Optional.ofNullable(trainee))
            .thenReturn(Optional.empty());

    traineeService.create(trainee);

        Assertions.assertEquals("Igor.Ivanov2", trainee.getUserName());
        Assertions.assertEquals(10, trainee.getPassword().length());
    }
}