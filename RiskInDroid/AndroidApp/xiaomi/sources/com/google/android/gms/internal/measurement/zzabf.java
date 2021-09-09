package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

final class zzabf extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzaay zzbuf;

    private zzabf(zzaay zzaay) {
        this.zzbuf = zzaay;
    }

    /* synthetic */ zzabf(zzaay zzaay, zzaaz zzaaz) {
        this(zzaay);
    }

    public final /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzbuf.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public final void clear() {
        this.zzbuf.clear();
    }

    public final boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzbuf.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzabe(this.zzbuf, null);
    }

    public final boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzbuf.remove(entry.getKey());
        return true;
    }

    public final int size() {
        return this.zzbuf.size();
    }
}
