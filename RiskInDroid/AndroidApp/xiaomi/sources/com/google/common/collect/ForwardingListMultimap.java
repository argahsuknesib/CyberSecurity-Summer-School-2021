package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;
import java.util.function.BiConsumer;

@GwtCompatible
public abstract class ForwardingListMultimap<K, V> extends ForwardingMultimap<K, V> implements ListMultimap<K, V> {
    /* access modifiers changed from: protected */
    public abstract ListMultimap<K, V> delegate();

    public /* synthetic */ void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Multimap.CC.$default$forEach(this, biConsumer);
    }

    protected ForwardingListMultimap() {
    }

    public List<V> get(K k) {
        return delegate().get((Object) k);
    }

    @CanIgnoreReturnValue
    public List<V> removeAll(Object obj) {
        return delegate().removeAll(obj);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ListMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.List<V>
     arg types: [K, java.lang.Iterable<? extends V>]
     candidates:
      com.google.common.collect.Multimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Collection<V>
      com.google.common.collect.ListMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.List<V> */
    @CanIgnoreReturnValue
    public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return delegate().replaceValues((Object) k, (Iterable) iterable);
    }
}
