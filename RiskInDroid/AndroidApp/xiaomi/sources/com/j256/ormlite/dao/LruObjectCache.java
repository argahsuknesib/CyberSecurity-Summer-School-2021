package com.j256.ormlite.dao;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LruObjectCache implements ObjectCache {
    private final int capacity;
    private final ConcurrentHashMap<Class<?>, Map<Object, Object>> classMaps = new ConcurrentHashMap<>();

    public LruObjectCache(int i) {
        this.capacity = i;
    }

    public synchronized <T> void registerClass(Class<T> cls) {
        if (this.classMaps.get(cls) == null) {
            this.classMaps.put(cls, Collections.synchronizedMap(new LimitedLinkedHashMap(this.capacity)));
        }
    }

    public <T, ID> T get(Class<T> cls, ID id) {
        Map<Object, Object> mapForClass = getMapForClass(cls);
        if (mapForClass == null) {
            return null;
        }
        return mapForClass.get(id);
    }

    public <T, ID> void put(Class<T> cls, ID id, T t) {
        Map<Object, Object> mapForClass = getMapForClass(cls);
        if (mapForClass != null) {
            mapForClass.put(id, t);
        }
    }

    public <T> void clear(Class<T> cls) {
        Map<Object, Object> mapForClass = getMapForClass(cls);
        if (mapForClass != null) {
            mapForClass.clear();
        }
    }

    public void clearAll() {
        for (Map<Object, Object> clear : this.classMaps.values()) {
            clear.clear();
        }
    }

    public <T, ID> void remove(Class<T> cls, ID id) {
        Map<Object, Object> mapForClass = getMapForClass(cls);
        if (mapForClass != null) {
            mapForClass.remove(id);
        }
    }

    public <T, ID> T updateId(Class<T> cls, ID id, ID id2) {
        T remove;
        Map<Object, Object> mapForClass = getMapForClass(cls);
        if (mapForClass == null || (remove = mapForClass.remove(id)) == null) {
            return null;
        }
        mapForClass.put(id2, remove);
        return remove;
    }

    public <T> int size(Class<T> cls) {
        Map<Object, Object> mapForClass = getMapForClass(cls);
        if (mapForClass == null) {
            return 0;
        }
        return mapForClass.size();
    }

    public int sizeAll() {
        int i = 0;
        for (Map<Object, Object> size : this.classMaps.values()) {
            i += size.size();
        }
        return i;
    }

    private Map<Object, Object> getMapForClass(Class<?> cls) {
        Map<Object, Object> map = this.classMaps.get(cls);
        if (map == null) {
            return null;
        }
        return map;
    }

    static class LimitedLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private static final long serialVersionUID = -4566528080395573236L;
        private final int capacity;

        public LimitedLinkedHashMap(int i) {
            super(i, 0.75f, true);
            this.capacity = i;
        }

        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry<K, V> entry) {
            return size() > this.capacity;
        }
    }
}
