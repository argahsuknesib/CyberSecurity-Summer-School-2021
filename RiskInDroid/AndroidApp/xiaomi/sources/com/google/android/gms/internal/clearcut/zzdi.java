package com.google.android.gms.internal.clearcut;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zzdi<K, V> extends LinkedHashMap<K, V> {
    private static final zzdi zzme;
    private boolean zzfa = true;

    static {
        zzdi zzdi = new zzdi();
        zzme = zzdi;
        zzdi.zzfa = false;
    }

    private zzdi() {
    }

    private zzdi(Map<K, V> map) {
        super(map);
    }

    public static <K, V> zzdi<K, V> zzbz() {
        return zzme;
    }

    private final void zzcb() {
        if (!this.zzfa) {
            throw new UnsupportedOperationException();
        }
    }

    private static int zzf(Object obj) {
        if (obj instanceof byte[]) {
            return zzci.hashCode((byte[]) obj);
        }
        if (!(obj instanceof zzcj)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        zzcb();
        super.clear();
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c A[RETURN] */
    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this != map) {
                if (size() == map.size()) {
                    Iterator it = entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        if (map.containsKey(entry.getKey())) {
                            Object value = entry.getValue();
                            Object obj2 = map.get(entry.getKey());
                            if (!(value instanceof byte[]) || !(obj2 instanceof byte[])) {
                                z2 = value.equals(obj2);
                                continue;
                            } else {
                                z2 = Arrays.equals((byte[]) value, (byte[]) obj2);
                                continue;
                            }
                            if (!z2) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                z = false;
                if (!z) {
                    return true;
                }
            }
            z = true;
            if (!z) {
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        for (Map.Entry entry : entrySet()) {
            i += zzf(entry.getValue()) ^ zzf(entry.getKey());
        }
        return i;
    }

    public final boolean isMutable() {
        return this.zzfa;
    }

    public final V put(K k, V v) {
        zzcb();
        zzci.checkNotNull(k);
        zzci.checkNotNull(v);
        return super.put(k, v);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        zzcb();
        for (Object next : map.keySet()) {
            zzci.checkNotNull(next);
            zzci.checkNotNull(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        zzcb();
        return super.remove(obj);
    }

    public final void zza(zzdi<K, V> zzdi) {
        zzcb();
        if (!zzdi.isEmpty()) {
            putAll(zzdi);
        }
    }

    public final zzdi<K, V> zzca() {
        return isEmpty() ? new zzdi<>() : new zzdi<>(this);
    }

    public final void zzv() {
        this.zzfa = false;
    }
}
