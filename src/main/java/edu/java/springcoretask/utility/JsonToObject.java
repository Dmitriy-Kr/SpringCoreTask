package edu.java.springcoretask.utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import edu.java.springcoretask.entity.Training;
import edu.java.springcoretask.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JsonToObject {
    static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> List<T> jsonToObjectList (String json, Class<T> clazz){

        CollectionType listType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz);

        List<T> result = null;

        try {
            result = objectMapper.readValue(json, listType);
        } catch (JsonProcessingException | NullPointerException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static <T extends User> Map<Long, T> userListToMap (List<T> list){

        return list.stream().collect(Collectors.toMap(User::getId, Function.identity()));

    }

    public static <T extends Training> Map<Long, T> trainingListToMap (List<T> list){

        return list.stream().collect(Collectors.toMap(Training::getId, Function.identity()));

    }
}
