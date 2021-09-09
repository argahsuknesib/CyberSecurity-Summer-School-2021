package com.google.android.gms.internal.measurement;

import java.util.Map;

final class zzzw<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzzu> zzbsu;

    private zzzw(Map.Entry<K, zzzu> entry) {
        this.zzbsu = entry;
    }

    public final K getKey() {
        return this.zzbsu.getKey();
    }

    public final Object getValue() {
        if (this.zzbsu.getValue() == null) {
            return null;
        }
        return zzzu.zzto();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzaal) {
            return this.zzbsu.getValue().zzc((zzaal) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
