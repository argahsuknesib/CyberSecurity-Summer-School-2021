package com.lidroid.xutils.cache;

import java.util.concurrent.ConcurrentHashMap;

public class KeyExpiryMap<K, V> extends ConcurrentHashMap<K, Long> {
    private static final long serialVersionUID = 1;

    public KeyExpiryMap(int i, float f, int i2) {
        super(i, f, i2);
    }

    public KeyExpiryMap(int i, float f) {
        super(i, f, 16);
    }

    public KeyExpiryMap(int i) {
        super(i);
    }

    public KeyExpiryMap() {
    }

    public synchronized Long get(Object obj) {
        if (!containsKey(obj)) {
            return null;
        }
        return (Long) super.get(obj);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.concurrent.ConcurrentHashMap.put(java.lang.Object, java.lang.Object):V}
     arg types: [K, java.lang.Long]
     candidates:
      com.lidroid.xutils.cache.KeyExpiryMap.put(java.lang.Object, java.lang.Long):java.lang.Long
      ClspMth{java.util.concurrent.ConcurrentHashMap.put(java.lang.Object, java.lang.Object):V} */
    public synchronized Long put(K k, Long l) {
        if (containsKey(k)) {
            remove((Object) k);
        }
        return (Long) super.put((Object) k, (Object) l);
    }

    public synchronized boolean containsKey(Object obj) {
        boolean z;
        z = false;
        Long l = (Long) super.get(obj);
        if (l == null || System.currentTimeMillis() >= l.longValue()) {
            remove(obj);
        } else {
            z = true;
        }
        return z;
    }

    public synchronized Long remove(Object obj) {
        return (Long) super.remove(obj);
    }

    public synchronized void clear() {
        super.clear();
    }
}
