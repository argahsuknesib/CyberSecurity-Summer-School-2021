package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@GwtCompatible
abstract class AbstractListMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements ListMultimap<K, V> {
    private static final long serialVersionUID = 6588350623831699109L;

    /* access modifiers changed from: package-private */
    public abstract List<V> createCollection();

    protected AbstractListMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    /* access modifiers changed from: package-private */
    public List<V> createUnmodifiableEmptyCollection() {
        return Collections.emptyList();
    }

    /* access modifiers changed from: package-private */
    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableList((List) collection);
    }

    /* access modifiers changed from: package-private */
    public Collection<V> wrapCollection(K k, Collection<V> collection) {
        return wrapList(k, (List) collection, null);
    }

    public List<V> get(K k) {
        return (List) super.get((Object) k);
    }

    @CanIgnoreReturnValue
    public List<V> removeAll(Object obj) {
        return (List) super.removeAll(obj);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.AbstractMapBasedMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection<V>
     arg types: [K, java.lang.Iterable<? extends V>]
     candidates:
      com.google.common.collect.AbstractListMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.List<V>
      com.google.common.collect.ListMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.List<V>
      com.google.common.collect.AbstractMapBasedMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection<V> */
    @CanIgnoreReturnValue
    public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return (List) super.replaceValues((Object) k, (Iterable) iterable);
    }

    @CanIgnoreReturnValue
    public boolean put(K k, V v) {
        return super.put(k, v);
    }

    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
