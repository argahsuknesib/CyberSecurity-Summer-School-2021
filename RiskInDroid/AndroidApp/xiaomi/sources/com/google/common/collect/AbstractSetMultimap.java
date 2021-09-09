package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@GwtCompatible
abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements SetMultimap<K, V> {
    private static final long serialVersionUID = 7431625294878419160L;

    /* access modifiers changed from: package-private */
    public abstract Set<V> createCollection();

    protected AbstractSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    /* access modifiers changed from: package-private */
    public Set<V> createUnmodifiableEmptyCollection() {
        return Collections.emptySet();
    }

    /* access modifiers changed from: package-private */
    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableSet((Set) collection);
    }

    /* access modifiers changed from: package-private */
    public Collection<V> wrapCollection(K k, Collection<V> collection) {
        return new AbstractMapBasedMultimap.WrappedSet(k, (Set) collection);
    }

    public Set<V> get(K k) {
        return (Set) super.get((Object) k);
    }

    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    @CanIgnoreReturnValue
    public Set<V> removeAll(Object obj) {
        return (Set) super.removeAll(obj);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.AbstractMapBasedMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection<V>
     arg types: [K, java.lang.Iterable<? extends V>]
     candidates:
      com.google.common.collect.AbstractSetMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Set<V>
      com.google.common.collect.SetMultimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Set<V>
      com.google.common.collect.AbstractMapBasedMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection<V> */
    @CanIgnoreReturnValue
    public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return (Set) super.replaceValues((Object) k, (Iterable) iterable);
    }

    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @CanIgnoreReturnValue
    public boolean put(K k, V v) {
        return super.put(k, v);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
