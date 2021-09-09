package com.google.android.gms.common.util;

import java.util.ArrayList;

public abstract class ObjectPoolBase<T> {
    private final ArrayList<T> zzaag;
    private final int zzaah;

    public ObjectPoolBase(int i) {
        this.zzaag = new ArrayList<>(i);
        this.zzaah = i;
    }

    public final T aquire() {
        synchronized (this.zzaag) {
            int size = this.zzaag.size();
            if (size > 0) {
                T remove = this.zzaag.remove(size - 1);
                return remove;
            }
            T newObject = newObject();
            return newObject;
        }
    }

    /* access modifiers changed from: protected */
    public boolean cleanUpObject(T t) {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract T newObject();

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        return false;
     */
    public final boolean release(T t) {
        synchronized (this.zzaag) {
            int size = this.zzaag.size();
            int i = 0;
            while (i < size) {
                if (this.zzaag.get(i) != t) {
                    i++;
                } else {
                    String valueOf = String.valueOf(t);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
                    sb.append("Object released already: ");
                    sb.append(valueOf);
                    throw new IllegalArgumentException(sb.toString());
                }
            }
            if (size < this.zzaah && cleanUpObject(t)) {
                this.zzaag.add(t);
                return true;
            }
        }
    }
}
