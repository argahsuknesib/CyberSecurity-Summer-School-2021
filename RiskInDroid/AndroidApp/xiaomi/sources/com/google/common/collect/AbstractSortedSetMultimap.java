package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableSet;
import java.util.SortedSet;

@GwtCompatible
abstract class AbstractSortedSetMultimap<K, V> extends AbstractSetMultimap<K, V> implements SortedSetMultimap<K, V> {
    private static final long serialVersionUID = 430848587173315748L;

    /* access modifiers changed from: package-private */
    public abstract SortedSet<V> createCollection();

    protected AbstractSortedSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    /* access modifiers changed from: package-private */
    public SortedSet<V> createUnmodifiableEmptyCollection() {
        return unmodifiableCollectionSubclass((Collection) createCollection());
    }

    /* access modifiers changed from: package-private */
    public <E> SortedSet<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        if (collection instanceof NavigableSet) {
            return Sets.unmodifiableNavigableSet((NavigableSet) collection);
        }
        return Collections.unmodifiableSortedSet((SortedSet) collection);
    }

    /* access modifiers changed from: package-private */
    public Collection<V> wrapCollection(K k, Collection<V> collection) {
        if (collection instanceof NavigableSet) {
            return new AbstractMapBasedMultimap.WrappedNavigableSet(k, (NavigableSet) collection, null);
        }
        return new AbstractMapBasedMultimap.WrappedSortedSet(k, (SortedSet) collection, null);
    }

    public SortedSet<V> get(K k) {
        return (SortedSet) super.get((Object) k);
    }

    @CanIgnoreReturnValue
    public SortedSet<V> removeAll(Object obj) {
        return (SortedSet) super.removeAll(obj);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.AbstractSetMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Set<V>
     arg types: [K, java.lang.Iterable<? extends V>]
     candidates:
      com.google.common.collect.AbstractSortedSetMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection
      com.google.common.collect.AbstractSortedSetMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.SortedSet<V>
      com.google.common.collect.AbstractSetMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection
      com.google.common.collect.AbstractMapBasedMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection<V>
      com.google.common.collect.AbstractMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection<V>
      com.google.common.collect.Multimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Collection<V>
      com.google.common.collect.Multimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Collection<V>
      com.google.common.collect.SortedSetMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.SortedSet<V>
      com.google.common.collect.Multimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Collection<V>
      com.google.common.collect.AbstractSetMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Set<V> */
    @CanIgnoreReturnValue
    public SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return (SortedSet) super.replaceValues((Object) k, (Iterable) iterable);
    }

    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    public Collection<V> values() {
        return super.values();
    }
}
