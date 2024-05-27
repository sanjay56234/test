package LRUCache.Cache.EvictionPolicy;

public interface EvictionPolicy<Key> {

    public void keyAccessed(Key key);

    public Key evictKey();
}
