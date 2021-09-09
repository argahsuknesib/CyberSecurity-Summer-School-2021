package com.xiaomi.accountsdk.utils;

import java.util.HashMap;

public class EasyMap<K, V> extends HashMap<K, V> {
    private static final long serialVersionUID = -7846033686833655451L;

    public EasyMap() {
    }

    public EasyMap(K k, V v) {
        put(k, v);
    }

    public EasyMap<K, V> easyPut(K k, V v) {
        put(k, v);
        return this;
    }

    public EasyMap<K, V> easyPutOpt(K k, V v) {
        boolean z = true;
        if (k == null || v == null) {
            z = false;
        } else if (v instanceof String) {
            z = true ^ ((String) v).isEmpty();
        }
        if (z) {
            put(k, v);
        }
        return this;
    }
}
