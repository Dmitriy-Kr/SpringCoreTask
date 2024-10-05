package edu.java.springcoretask.storage;

import edu.java.springcoretask.entity.User;
import edu.java.springcoretask.utility.JsonToObject;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

public class UserStorage extends Storage<User> {
    @Value("${user_storage_path}")
    private String path;
    @PostConstruct
    public void init() {
        setStorage(JsonToObject.getUserMapFromJson(path, User.class));
    }
}
