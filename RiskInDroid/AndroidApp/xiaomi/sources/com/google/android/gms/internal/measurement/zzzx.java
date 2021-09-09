package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zzzx<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzbsv;

    public zzzx(Iterator<Map.Entry<K, Object>> it) {
        this.zzbsv = it;
    }

    public final boolean hasNext() {
        return this.zzbsv.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzbsv.next();
        return next.getValue() instanceof zzzu ? new zzzw(next) : next;
    }

    public final void remove() {
        this.zzbsv.remove();
    }
}
