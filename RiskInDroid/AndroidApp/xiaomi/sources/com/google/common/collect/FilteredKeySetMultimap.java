package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import java.util.Map;
import java.util.Set;

@GwtCompatible
final class FilteredKeySetMultimap<K, V> extends FilteredKeyMultimap<K, V> implements FilteredSetMultimap<K, V> {
    FilteredKeySetMultimap(SetMultimap<K, V> setMultimap, Predicate<? super K> predicate) {
        super(setMultimap, predicate);
    }

    public final SetMultimap<K, V> unfiltered() {
        return (SetMultimap) this.unfiltered;
    }

    public final Set<V> get(K k) {
        return (Set) super.get((Object) k);
    }

    public final Set<V> removeAll(Object obj) {
        return (Set) super.removeAll(obj);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.AbstractMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection<V>
     arg types: [K, java.lang.Iterable<? extends V>]
     candidates:
      com.google.common.collect.FilteredKeySetMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Set<V>
      com.google.common.collect.SetMultimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Set<V>
      com.google.common.collect.AbstractMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection<V> */
    public final Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return (Set) super.replaceValues((Object) k, (Iterable) iterable);
    }

    public final Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    /* access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> createEntries() {
        return new EntrySet();
    }

    class EntrySet extends FilteredKeyMultimap<K, V>.Entries implements Set<Map.Entry<K, V>> {
        EntrySet() {
            super();
        }

        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }

        public boolean equals(Object obj) {
            return Sets.equalsImpl(this, obj);
        }
    }
}
