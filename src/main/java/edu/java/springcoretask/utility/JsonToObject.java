package edu.java.springcoretask.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.java.springcoretask.entity.Training;
import edu.java.springcoretask.entity.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JsonToObject {
    private static final ObjectMapper objectMapper = getObjectMapper();

    private static ObjectMapper getObjectMapper(){
        ObjectMapper objectMapperConfig = new ObjectMapper();
        objectMapperConfig.registerModule(new JavaTimeModule());
        return objectMapperConfig;
    }

    private static <T> List<T> jsonFileToObjectList (String path, Class<T> clazz){

        CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz);

        List<T> result = null;

        try (InputStream inputJson = new FileInputStream(path);){

            result = objectMapper.readValue(inputJson, listType);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static <T extends User> Map<Long, T> getUserMapFromJson (String path, Class<T> clazz){

        List<T> userList = jsonFileToObjectList(path, clazz);

        return userList.stream().collect(Collectors.toMap(User::getId, Function.identity()));

    }

    public static <T extends Training> Map<Long, T> getTrainingMapFromJson (String path, Class<T> clazz){

        List<T> trainingList = jsonFileToObjectList(path, clazz);

        return trainingList.stream().collect(Collectors.toMap(Training::getId, Function.identity()));

    }


}
