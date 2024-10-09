package edu.java.springcoretask.service;

import edu.java.springcoretask.dao.TraineeDAO;
import edu.java.springcoretask.entity.Trainee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
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
    Mockito.when(traineeDAO.select("Igor.Ivanov")).thenReturn(Optional.ofNullable(trainee));
    }
}