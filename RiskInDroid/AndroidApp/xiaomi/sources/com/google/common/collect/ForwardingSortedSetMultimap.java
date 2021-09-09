package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multimap;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.function.BiConsumer;

@GwtCompatible
public abstract class ForwardingSortedSetMultimap<K, V> extends ForwardingSetMultimap<K, V> implements SortedSetMultimap<K, V> {
    /* access modifiers changed from: protected */
    public abstract SortedSetMultimap<K, V> delegate();

    public /* synthetic */ void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Multimap.CC.$default$forEach(this, biConsumer);
    }

    protected ForwardingSortedSetMultimap() {
    }

    public SortedSet<V> get(K k) {
        return delegate().get((Object) k);
    }

    public SortedSet<V> removeAll(Object obj) {
        return delegate().removeAll(obj);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.SortedSetMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.SortedSet<V>
     arg types: [K, java.lang.Iterable<? extends V>]
     candidates:
      com.google.common.collect.SetMultimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Set<V>
      com.google.common.collect.Multimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Collection<V>
      com.google.common.collect.SortedSetMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.SortedSet<V> */
    public SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return delegate().replaceValues((Object) k, (Iterable) iterable);
    }

    public Comparator<? super V> valueComparator() {
        return delegate().valueComparator();
    }
}
