package LRUCache.Cache.Factories;

import LRUCache.Cache.Cache;
import LRUCache.Cache.EvictionPolicy.LRUEvictionPolicy;
import LRUCache.Cache.Storage.HashMapStorage;

public class CacheFactory<Key,Val> {

    public Cache<Key,Val> getCache(int cap){
        return new Cache<>(new LRUEvictionPolicy<>(), new HashMapStorage<>(cap));
    }
}
