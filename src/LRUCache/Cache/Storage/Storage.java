package LRUCache.Cache.Storage;

public interface Storage<Key,Val> {
    public void add(Key key, Val val);
    public void remove(Key key);
    public Val get(Key key);

    public boolean isFull();
}
