package edu.java.springcoretask.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Storage <T>{
    private Map<Long,T> storage;

    public Storage(Map<Long, T> storage) {
        this.storage = storage;
    }

    public List<T> getAllValues() {
        return new ArrayList<>(storage.values());
    }

    public void put(long key, T value){
        storage.put(key, value);
    }

    public T getValue(long key){
        return storage.get(key);
    }
}
