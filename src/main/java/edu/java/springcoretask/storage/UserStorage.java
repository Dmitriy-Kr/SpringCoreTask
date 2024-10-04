package edu.java.springcoretask.storage;

import edu.java.springcoretask.entity.User;

import javax.annotation.PostConstruct;
import java.util.Map;

public class UserStorage extends Storage<User> {
    public UserStorage(Map<Long, User> storage) {
        super(storage);
    }

    @PostConstruct
    public void init() {

    }
}
