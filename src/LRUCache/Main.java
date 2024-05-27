package LRUCache;

import LRUCache.Cache.Cache;
import LRUCache.Cache.Factories.CacheFactory;

public class Main {
    public static void main(String[] args) {

        CacheFactory<String,String> cacheFactory = new CacheFactory<>();
        Cache<String,String> cache = cacheFactory.getCache(3);

        cache.add("1","abc");
        cache.add("2","xyz");
        cache.add("3", "iop");
        cache.add("4", "ert");
        System.out.println(cache.get("1"));
        cache.add("5", "top");

        System.out.println(cache.get("3"));
        System.out.println(cache.get("2"));
    }
}
