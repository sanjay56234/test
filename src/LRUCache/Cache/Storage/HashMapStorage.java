package LRUCache.Cache.Storage;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<Key,Val> implements Storage<Key,Val>{
    Map<Key,Val> storage;

    private int capacity;

    public HashMapStorage(int capacity){
        this.storage = new HashMap<>();
        this.capacity = capacity;
    }
    @Override
    public void add(Key key, Val val) {
        if(storage.size()>=capacity){
            System.out.println("Storage is full");
            return ;
        }
        storage.put(key,val);
    }

    @Override
    public void remove(Key key) {
        if(!storage.containsKey(key)){
            System.out.println("Key not found");
            return ;
        }
        storage.remove(key);

    }

    @Override
    public Val get(Key key) {
        if(!storage.containsKey(key)){
            System.out.println("Key not found");
            return null ;
        }
        return storage.get(key);
    }

    @Override
    public boolean isFull() {
        return storage.size() == capacity;
    }
}
