package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

@GwtCompatible(emulated = true)
abstract class AbstractBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    public transient Map<K, V> delegate;
    private transient Set<Map.Entry<K, V>> entrySet;
    @RetainedWith
    transient AbstractBiMap<V, K> inverse;
    private transient Set<K> keySet;
    private transient Set<V> valueSet;

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public K checkKey(K k) {
        return k;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public V checkValue(V v) {
        return v;
    }

    AbstractBiMap(Map<K, V> map, Map<V, K> map2) {
        setDelegates(map, map2);
    }

    private AbstractBiMap(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
        this.delegate = map;
        this.inverse = abstractBiMap;
    }

    /* access modifiers changed from: protected */
    public Map<K, V> delegate() {
        return this.delegate;
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.Map, java.util.Map<V, K>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    public void setDelegates(Map<K, V> map, Map<V, K> r5) {
        boolean z = true;
        Preconditions.checkState(this.delegate == null);
        Preconditions.checkState(this.inverse == null);
        Preconditions.checkArgument(map.isEmpty());
        Preconditions.checkArgument(r5.isEmpty());
        if (map == r5) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.delegate = map;
        this.inverse = makeInverse(r5);
    }

    /* access modifiers changed from: package-private */
    public AbstractBiMap<V, K> makeInverse(Map<V, K> map) {
        return new Inverse(map, this);
    }

    /* access modifiers changed from: package-private */
    public void setInverse(AbstractBiMap<V, K> abstractBiMap) {
        this.inverse = abstractBiMap;
    }

    public boolean containsValue(Object obj) {
        return this.inverse.containsKey(obj);
    }

    @CanIgnoreReturnValue
    public V put(K k, V v) {
        return putInBothMaps(k, v, false);
    }

    @CanIgnoreReturnValue
    public V forcePut(K k, V v) {
        return putInBothMaps(k, v, true);
    }

    private V putInBothMaps(K k, V v, boolean z) {
        checkKey(k);
        checkValue(v);
        boolean containsKey = containsKey(k);
        if (containsKey && Objects.equal(v, get(k))) {
            return v;
        }
        if (z) {
            inverse().remove(v);
        } else {
            Preconditions.checkArgument(!containsValue(v), "value already present: %s", v);
        }
        V put = this.delegate.put(k, v);
        updateInverseMap(k, containsKey, put, v);
        return put;
    }

    public void updateInverseMap(K k, boolean z, V v, V v2) {
        if (z) {
            removeFromInverseMap(v);
        }
        this.inverse.delegate.put(v2, k);
    }

    @CanIgnoreReturnValue
    public V remove(Object obj) {
        if (containsKey(obj)) {
            return removeFromBothMaps(obj);
        }
        return null;
    }

    @CanIgnoreReturnValue
    public V removeFromBothMaps(Object obj) {
        V remove = this.delegate.remove(obj);
        removeFromInverseMap(remove);
        return remove;
    }

    public void removeFromInverseMap(V v) {
        this.inverse.delegate.remove(v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        this.delegate.replaceAll(biFunction);
        this.inverse.delegate.clear();
        Iterator<Map.Entry<K, V>> it = this.delegate.entrySet().iterator();
        Map.Entry entry = null;
        while (it.hasNext()) {
            Map.Entry next = it.next();
            Object key = next.getKey();
            if (this.inverse.delegate.putIfAbsent(next.getValue(), key) != null) {
                it.remove();
                entry = next;
            }
        }
        if (entry != null) {
            throw new IllegalArgumentException("value already present: " + entry.getValue());
        }
    }

    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    public BiMap<V, K> inverse() {
        return this.inverse;
    }

    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        KeySet keySet2 = new KeySet();
        this.keySet = keySet2;
        return keySet2;
    }

    class KeySet extends ForwardingSet<K> {
        private KeySet() {
        }

        /* access modifiers changed from: protected */
        public Set<K> delegate() {
            return AbstractBiMap.this.delegate.keySet();
        }

        public void clear() {
            AbstractBiMap.this.clear();
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            AbstractBiMap.this.removeFromBothMaps(obj);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }

        public Iterator<K> iterator() {
            return Maps.keyIterator(AbstractBiMap.this.entrySet().iterator());
        }
    }

    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        ValueSet valueSet2 = new ValueSet();
        this.valueSet = valueSet2;
        return valueSet2;
    }

    class ValueSet extends ForwardingSet<V> {
        final Set<V> valuesDelegate;

        private ValueSet() {
            this.valuesDelegate = AbstractBiMap.this.inverse.keySet();
        }

        /* access modifiers changed from: protected */
        public Set<V> delegate() {
            return this.valuesDelegate;
        }

        public Iterator<V> iterator() {
            return Maps.valueIterator(AbstractBiMap.this.entrySet().iterator());
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return standardToArray(tArr);
        }

        public String toString() {
            return standardToString();
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        EntrySet entrySet2 = new EntrySet();
        this.entrySet = entrySet2;
        return entrySet2;
    }

    class BiMapEntry extends ForwardingMapEntry<K, V> {
        private final Map.Entry<K, V> delegate;

        BiMapEntry(Map.Entry<K, V> entry) {
            this.delegate = entry;
        }

        /* access modifiers changed from: protected */
        public Map.Entry<K, V> delegate() {
            return this.delegate;
        }

        public V setValue(V v) {
            AbstractBiMap.this.checkValue(v);
            Preconditions.checkState(AbstractBiMap.this.entrySet().contains(this), "entry no longer in map");
            if (Objects.equal(v, getValue())) {
                return v;
            }
            Preconditions.checkArgument(!AbstractBiMap.this.containsValue(v), "value already present: %s", v);
            V value = this.delegate.setValue(v);
            Preconditions.checkState(Objects.equal(v, AbstractBiMap.this.get(getKey())), "entry no longer in map");
            AbstractBiMap.this.updateInverseMap(getKey(), true, value, v);
            return value;
        }
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> entrySetIterator() {
        final Iterator<Map.Entry<K, V>> it = this.delegate.entrySet().iterator();
        return new Iterator<Map.Entry<K, V>>() {
            /* class com.google.common.collect.AbstractBiMap.AnonymousClass1 */
            Map.Entry<K, V> entry;

            public boolean hasNext() {
                return it.hasNext();
            }

            public Map.Entry<K, V> next() {
                this.entry = (Map.Entry) it.next();
                return new BiMapEntry(this.entry);
            }

            public void remove() {
                CollectPreconditions.checkRemove(this.entry != null);
                V value = this.entry.getValue();
                it.remove();
                AbstractBiMap.this.removeFromInverseMap(value);
                this.entry = null;
            }
        };
    }

    class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
        final Set<Map.Entry<K, V>> esDelegate;

        private EntrySet() {
            this.esDelegate = AbstractBiMap.this.delegate.entrySet();
        }

        /* access modifiers changed from: protected */
        public Set<Map.Entry<K, V>> delegate() {
            return this.esDelegate;
        }

        public void clear() {
            AbstractBiMap.this.clear();
        }

        public boolean remove(Object obj) {
            if (!this.esDelegate.contains(obj)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            AbstractBiMap.this.inverse.delegate.remove(entry.getValue());
            this.esDelegate.remove(entry);
            return true;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractBiMap.this.entrySetIterator();
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return standardToArray(tArr);
        }

        public boolean contains(Object obj) {
            return Maps.containsEntryImpl(delegate(), obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return standardContainsAll(collection);
        }

        public boolean removeAll(Collection<?> collection) {
            return standardRemoveAll(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return standardRetainAll(collection);
        }
    }

    static class Inverse<K, V> extends AbstractBiMap<K, V> {
        @GwtIncompatible
        private static final long serialVersionUID = 0;

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ Object delegate() {
            return AbstractBiMap.super.delegate();
        }

        public /* bridge */ /* synthetic */ Collection values() {
            return AbstractBiMap.super.values();
        }

        Inverse(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap);
        }

        /* access modifiers changed from: package-private */
        public K checkKey(K k) {
            return this.inverse.checkValue(k);
        }

        /* access modifiers changed from: package-private */
        public V checkValue(V v) {
            return this.inverse.checkKey(v);
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(inverse());
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            setInverse((AbstractBiMap) objectInputStream.readObject());
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        public Object readResolve() {
            return inverse().inverse();
        }
    }
}
