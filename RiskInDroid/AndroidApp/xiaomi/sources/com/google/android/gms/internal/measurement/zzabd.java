package com.google.android.gms.internal.measurement;

import java.util.Map;

final class zzabd implements Comparable<zzabd>, Map.Entry<K, V> {
    private V value;
    private final K zzbue;
    private final /* synthetic */ zzaay zzbuf;

    zzabd(zzaay zzaay, K k, V v) {
        this.zzbuf = zzaay;
        this.zzbue = k;
        this.value = v;
    }

    zzabd(zzaay zzaay, Map.Entry<K, V> entry) {
        this(zzaay, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean equals(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzabd) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return equals(this.zzbue, entry.getKey()) && equals(this.value, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.zzbue;
    }

    public final V getValue() {
        return this.value;
    }

    public final int hashCode() {
        K k = this.zzbue;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.value;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final V setValue(V v) {
        this.zzbuf.zzul();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzbue);
        String valueOf2 = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }
}
