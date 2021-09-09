package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

@GwtCompatible
public abstract class ForwardingMultimap<K, V> extends ForwardingObject implements Multimap<K, V> {
    /* access modifiers changed from: protected */
    public abstract Multimap<K, V> delegate();

    public /* synthetic */ void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Multimap.CC.$default$forEach(this, biConsumer);
    }

    protected ForwardingMultimap() {
    }

    public Map<K, Collection<V>> asMap() {
        return delegate().asMap();
    }

    public void clear() {
        delegate().clear();
    }

    public boolean containsEntry(Object obj, Object obj2) {
        return delegate().containsEntry(obj, obj2);
    }

    public boolean containsKey(Object obj) {
        return delegate().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return delegate().containsValue(obj);
    }

    public Collection<Map.Entry<K, V>> entries() {
        return delegate().entries();
    }

    public Collection<V> get(Object obj) {
        return delegate().get(obj);
    }

    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Multiset<K> keys() {
        return delegate().keys();
    }

    public Set<K> keySet() {
        return delegate().keySet();
    }

    @CanIgnoreReturnValue
    public boolean put(K k, V v) {
        return delegate().put(k, v);
    }

    @CanIgnoreReturnValue
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        return delegate().putAll(k, iterable);
    }

    @CanIgnoreReturnValue
    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        return delegate().putAll(multimap);
    }

    @CanIgnoreReturnValue
    public boolean remove(Object obj, Object obj2) {
        return delegate().remove(obj, obj2);
    }

    @CanIgnoreReturnValue
    public Collection<V> removeAll(Object obj) {
        return delegate().removeAll(obj);
    }

    @CanIgnoreReturnValue
    public Collection<V> replaceValues(Object obj, Iterable iterable) {
        return delegate().replaceValues(obj, iterable);
    }

    public int size() {
        return delegate().size();
    }

    public Collection<V> values() {
        return delegate().values();
    }

    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    public int hashCode() {
        return delegate().hashCode();
    }
}
