package edu.java.springcoretask.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Storage <T>{
    protected Map<Long,T> storage;

    public Storage() {
    }

    public Storage(Map<Long, T> storage) {
        this.storage = storage;
    }

    public void setStorage(Map<Long, T> storage) {
        this.storage = storage;
    }

    public List<T> getAllValues() {
        return new ArrayList<>(storage.values());
    }

    /**
     * Put value to the storage Map<Long, T>
     * @param value
     * @return key
     */
    public long put(T value){
        long key = getNewKey();
        storage.put(key, value);
        return key;
    }
    public T update(long key, T value){
        return storage.put(key, value);
    }

    public T delete(long key){
        return storage.remove(key);
    }

    public abstract T getByUserName(String userName);

    /**
     * Generate new key for Map
     * @return long key
     */
    private long getNewKey(){
        long key = 0;

        for(key = Long.MIN_VALUE; key < Long.MAX_VALUE; key++){
            if(!storage.containsKey(key)){
                break;
            }
        }

        return key;
    }
}
