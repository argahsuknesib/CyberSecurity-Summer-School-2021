package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.common.collect.Multimap;
import java.util.List;
import java.util.function.BiConsumer;

@GwtCompatible
final class FilteredKeyListMultimap<K, V> extends FilteredKeyMultimap<K, V> implements ListMultimap<K, V> {
    public /* synthetic */ void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Multimap.CC.$default$forEach(this, biConsumer);
    }

    FilteredKeyListMultimap(ListMultimap<K, V> listMultimap, Predicate<? super K> predicate) {
        super(listMultimap, predicate);
    }

    public final ListMultimap<K, V> unfiltered() {
        return (ListMultimap) super.unfiltered();
    }

    public final List<V> get(K k) {
        return (List) super.get((Object) k);
    }

    public final List<V> removeAll(Object obj) {
        return (List) super.removeAll(obj);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.AbstractMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection<V>
     arg types: [K, java.lang.Iterable<? extends V>]
     candidates:
      com.google.common.collect.FilteredKeyListMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.List<V>
      com.google.common.collect.ListMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.List<V>
      com.google.common.collect.AbstractMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection<V> */
    public final List<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return (List) super.replaceValues((Object) k, (Iterable) iterable);
    }
}
