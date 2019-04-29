package designpatterns;

import java.util.concurrent.ConcurrentHashMap;


public class LocalCache {
    private static ConcurrentHashMap<Integer, CacheEntity> map =
            new ConcurrentHashMap<>();
    public static void addCache(int i, CacheEntity cache) {
        map.put(i,cache);
    }
    public static void remove(int i) {
        map.remove(i);
    }
}
