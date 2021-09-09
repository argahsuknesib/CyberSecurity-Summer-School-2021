package com.facebook.imagepipeline.cache;

import com.android.internal.util.Predicate;
import com.facebook.common.internal.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountingLruMap<K, V> {
    private final LinkedHashMap<K, V> mMap = new LinkedHashMap<>();
    private int mSizeInBytes = 0;
    private final ValueDescriptor<V> mValueDescriptor;

    public CountingLruMap(ValueDescriptor<V> valueDescriptor) {
        this.mValueDescriptor = valueDescriptor;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized ArrayList<K> getKeys() {
        return new ArrayList<>(this.mMap.keySet());
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized ArrayList<V> getValues() {
        return new ArrayList<>(this.mMap.values());
    }

    public synchronized int getCount() {
        return this.mMap.size();
    }

    public synchronized int getSizeInBytes() {
        return this.mSizeInBytes;
    }

    public synchronized K getFirstKey() {
        if (this.mMap.isEmpty()) {
            return null;
        }
        return this.mMap.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> getMatchingEntries(Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.mMap.entrySet().size());
        for (Map.Entry next : this.mMap.entrySet()) {
            if (predicate == null || predicate.apply(next.getKey())) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.mMap.containsKey(k);
    }

    public synchronized V get(K k) {
        return this.mMap.get(k);
    }

    public synchronized V put(K k, V v) {
        V remove;
        remove = this.mMap.remove(k);
        this.mSizeInBytes -= getValueSizeInBytes(remove);
        this.mMap.put(k, v);
        this.mSizeInBytes += getValueSizeInBytes(v);
        return remove;
    }

    public synchronized V remove(K k) {
        V remove;
        remove = this.mMap.remove(k);
        this.mSizeInBytes -= getValueSizeInBytes(remove);
        return remove;
    }

    public synchronized ArrayList<V> removeAll(Predicate<K> predicate) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<K, V>> it = this.mMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (predicate == null || predicate.apply(next.getKey())) {
                arrayList.add(next.getValue());
                this.mSizeInBytes -= getValueSizeInBytes(next.getValue());
                it.remove();
            }
        }
        return arrayList;
    }

    public synchronized ArrayList<V> clear() {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>(this.mMap.values());
        this.mMap.clear();
        this.mSizeInBytes = 0;
        return arrayList;
    }

    private int getValueSizeInBytes(V v) {
        if (v == null) {
            return 0;
        }
        return this.mValueDescriptor.getSizeInBytes(v);
    }
}
