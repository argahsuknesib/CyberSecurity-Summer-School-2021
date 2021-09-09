package com.google.common.collect;

import com.google.auto.common.BasicAnnotationProcessor;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@GwtCompatible
public interface SetMultimap<K, V> extends Multimap<K, V> {

    /* renamed from: com.google.common.collect.SetMultimap$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    Map<K, Collection<V>> asMap();

    Set<Map.Entry<K, V>> entries();

    boolean equals(Object obj);

    Set<V> get(BasicAnnotationProcessor.ProcessingStep processingStep);

    @CanIgnoreReturnValue
    Set<V> removeAll(Object obj);

    @CanIgnoreReturnValue
    Set<V> replaceValues(BasicAnnotationProcessor.ProcessingStep processingStep, Iterable<? extends BasicAnnotationProcessor.ElementName> iterable);
}
