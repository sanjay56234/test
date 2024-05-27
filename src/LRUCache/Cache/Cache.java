package LRUCache.Cache;

import LRUCache.Cache.EvictionPolicy.EvictionPolicy;
import LRUCache.Cache.Storage.Storage;


public class Cache<Key,Val> {

    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key,Val> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key,Val>storage){
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void add(Key key, Val val){
        if(this.storage.isFull()){
            System.out.println("Got storage full. Will try to evict.");
            Key keyToEvict = this.evictionPolicy.evictKey();
            if(keyToEvict==null){
                System.out.println("Null evict key");
                return ;
            }
            this.storage.remove(keyToEvict);
            this.storage.add(key,val);
        }else{
            this.storage.add(key,val);
            this.evictionPolicy.keyAccessed(key);
        }
    }

    public Val get(Key key){
        Val val = this.storage.get(key);
        this.evictionPolicy.keyAccessed(key);
        return val;
    }
}
