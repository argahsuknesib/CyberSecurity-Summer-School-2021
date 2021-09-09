package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@GwtCompatible
public abstract class ForwardingMap<K, V> extends ForwardingObject implements Map<K, V> {
    /* access modifiers changed from: protected */
    public abstract Map<K, V> delegate();

    protected ForwardingMap() {
    }

    public int size() {
        return delegate().size();
    }

    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @CanIgnoreReturnValue
    public V remove(Object obj) {
        return delegate().remove(obj);
    }

    public void clear() {
        delegate().clear();
    }

    public boolean containsKey(Object obj) {
        return delegate().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return delegate().containsValue(obj);
    }

    public V get(Object obj) {
        return delegate().get(obj);
    }

    @CanIgnoreReturnValue
    public V put(Object obj, Object obj2) {
        return delegate().put(obj, obj2);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    public Set<K> keySet() {
        return delegate().keySet();
    }

    public Collection<V> values() {
        return delegate().values();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    public int hashCode() {
        return delegate().hashCode();
    }

    /* access modifiers changed from: protected */
    public void standardPutAll(Map<? extends K, ? extends V> map) {
        Maps.putAllImpl(this, map);
    }

    /* access modifiers changed from: protected */
    @Beta
    public V standardRemove(Object obj) {
        Iterator it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (Objects.equal(entry.getKey(), obj)) {
                V value = entry.getValue();
                it.remove();
                return value;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void standardClear() {
        Iterators.clear(entrySet().iterator());
    }

    @Beta
    public class StandardKeySet extends Maps.KeySet<K, V> {
        public StandardKeySet() {
            super(ForwardingMap.this);
        }
    }

    /* access modifiers changed from: protected */
    @Beta
    public boolean standardContainsKey(Object obj) {
        return Maps.containsKeyImpl(this, obj);
    }

    @Beta
    public class StandardValues extends Maps.Values<K, V> {
        public StandardValues() {
            super(ForwardingMap.this);
        }
    }

    /* access modifiers changed from: protected */
    public boolean standardContainsValue(Object obj) {
        return Maps.containsValueImpl(this, obj);
    }

    @Beta
    public abstract class StandardEntrySet extends Maps.EntrySet<K, V> {
        public StandardEntrySet() {
        }

        /* access modifiers changed from: package-private */
        public Map<K, V> map() {
            return ForwardingMap.this;
        }
    }

    /* access modifiers changed from: protected */
    public boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    /* access modifiers changed from: protected */
    public boolean standardEquals(Object obj) {
        return Maps.equalsImpl(this, obj);
    }

    /* access modifiers changed from: protected */
    public int standardHashCode() {
        return Sets.hashCodeImpl(entrySet());
    }

    /* access modifiers changed from: protected */
    public String standardToString() {
        return Maps.toStringImpl(this);
    }
}
