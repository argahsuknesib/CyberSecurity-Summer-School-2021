package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {
    private static final MapFieldLite EMPTY_MAP_FIELD;
    private boolean isMutable = true;

    private MapFieldLite() {
    }

    private MapFieldLite(Map<K, V> map) {
        super(map);
    }

    static {
        MapFieldLite mapFieldLite = new MapFieldLite();
        EMPTY_MAP_FIELD = mapFieldLite;
        mapFieldLite.makeImmutable();
    }

    public static <K, V> MapFieldLite<K, V> emptyMapField() {
        return EMPTY_MAP_FIELD;
    }

    public final void mergeFrom(MapFieldLite<K, V> mapFieldLite) {
        ensureMutable();
        if (!mapFieldLite.isEmpty()) {
            putAll(mapFieldLite);
        }
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final void clear() {
        ensureMutable();
        super.clear();
    }

    public final V put(K k, V v) {
        ensureMutable();
        Internal.checkNotNull(k);
        Internal.checkNotNull(v);
        return super.put(k, v);
    }

    public final V put(Map.Entry<K, V> entry) {
        return put(entry.getKey(), entry.getValue());
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        ensureMutable();
        checkForNullKeysAndValues(map);
        super.putAll(map);
    }

    public final V remove(Object obj) {
        ensureMutable();
        return super.remove(obj);
    }

    private static void checkForNullKeysAndValues(Map<?, ?> map) {
        for (Object next : map.keySet()) {
            Internal.checkNotNull(next);
            Internal.checkNotNull(map.get(next));
        }
    }

    private static boolean equals(Object obj, Object obj2) {
        if (!(obj instanceof byte[]) || !(obj2 instanceof byte[])) {
            return obj.equals(obj2);
        }
        return Arrays.equals((byte[]) obj, (byte[]) obj2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    static <K, V> boolean equals(Map map, Map map2) {
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !equals(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
            while (r4.hasNext()) {
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof Map) && equals(this, (Map) obj);
    }

    private static int calculateHashCodeForObject(Object obj) {
        if (obj instanceof byte[]) {
            return Internal.hashCode((byte[]) obj);
        }
        if (!(obj instanceof Internal.EnumLite)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    static <K, V> int calculateHashCodeForMap(Map<K, V> map) {
        int i = 0;
        for (Map.Entry next : map.entrySet()) {
            i += calculateHashCodeForObject(next.getValue()) ^ calculateHashCodeForObject(next.getKey());
        }
        return i;
    }

    public final int hashCode() {
        return calculateHashCodeForMap(this);
    }

    private static Object copy(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        return Arrays.copyOf(bArr, bArr.length);
    }

    static <K, V> Map<K, V> copy(Map<K, V> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            linkedHashMap.put(next.getKey(), copy(next.getValue()));
        }
        return linkedHashMap;
    }

    public final MapFieldLite<K, V> mutableCopy() {
        return isEmpty() ? new MapFieldLite<>() : new MapFieldLite<>(this);
    }

    public final void makeImmutable() {
        this.isMutable = false;
    }

    public final boolean isMutable() {
        return this.isMutable;
    }

    private void ensureMutable() {
        if (!isMutable()) {
            throw new UnsupportedOperationException();
        }
    }
}
