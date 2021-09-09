package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zzabe implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzaay zzbuf;
    private boolean zzbug;
    private Iterator<Map.Entry<K, V>> zzbuh;

    private zzabe(zzaay zzaay) {
        this.zzbuf = zzaay;
        this.pos = -1;
    }

    /* synthetic */ zzabe(zzaay zzaay, zzaaz zzaaz) {
        this(zzaay);
    }

    private final Iterator<Map.Entry<K, V>> zzup() {
        if (this.zzbuh == null) {
            this.zzbuh = this.zzbuf.zzbtz.entrySet().iterator();
        }
        return this.zzbuh;
    }

    public final boolean hasNext() {
        return this.pos + 1 < this.zzbuf.zzbty.size() || (!this.zzbuf.zzbtz.isEmpty() && zzup().hasNext());
    }

    public final /* synthetic */ Object next() {
        this.zzbug = true;
        int i = this.pos + 1;
        this.pos = i;
        return (Map.Entry) (i < this.zzbuf.zzbty.size() ? this.zzbuf.zzbty.get(this.pos) : zzup().next());
    }

    public final void remove() {
        if (this.zzbug) {
            this.zzbug = false;
            this.zzbuf.zzul();
            if (this.pos < this.zzbuf.zzbty.size()) {
                zzaay zzaay = this.zzbuf;
                int i = this.pos;
                this.pos = i - 1;
                Object unused = zzaay.zzai(i);
                return;
            }
            zzup().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
