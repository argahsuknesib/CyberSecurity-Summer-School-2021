package com.google.common.collect;

import com.google.auto.common.BasicAnnotationProcessor;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multimap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

@GwtCompatible
public abstract class ForwardingSetMultimap<K, V> extends ForwardingMultimap<K, V> implements SetMultimap<K, V> {
    /* access modifiers changed from: protected */
    public abstract SetMultimap<K, V> delegate();

    public /* synthetic */ void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Multimap.CC.$default$forEach(this, biConsumer);
    }

    public Set<Map.Entry<K, V>> entries() {
        return delegate().entries();
    }

    public Set<V> get(K k) {
        return delegate().get((BasicAnnotationProcessor.ProcessingStep) k);
    }

    @CanIgnoreReturnValue
    public Set<V> removeAll(Object obj) {
        return delegate().removeAll(obj);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.SetMultimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Set<V>
     arg types: [K, java.lang.Iterable<? extends V>]
     candidates:
      com.google.common.collect.Multimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Collection<V>
      com.google.common.collect.SetMultimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Set<V> */
    @CanIgnoreReturnValue
    public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return delegate().replaceValues((BasicAnnotationProcessor.ProcessingStep) k, (Iterable<? extends BasicAnnotationProcessor.ElementName>) iterable);
    }
}
