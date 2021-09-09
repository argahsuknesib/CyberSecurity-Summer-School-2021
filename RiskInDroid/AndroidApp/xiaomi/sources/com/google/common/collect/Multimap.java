package com.google.common.collect;

import com.google.auto.common.BasicAnnotationProcessor;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@GwtCompatible
public interface Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsEntry(@CompatibleWith("K") Object obj, @CompatibleWith("V") Object obj2);

    boolean containsKey(@CompatibleWith("K") Object obj);

    boolean containsValue(@CompatibleWith("V") Object obj);

    Collection<Map.Entry<K, V>> entries();

    boolean equals(Object obj);

    void forEach(BiConsumer<? super K, ? super V> biConsumer);

    Collection<V> get(BasicAnnotationProcessor.ProcessingStep processingStep);

    int hashCode();

    boolean isEmpty();

    Set<K> keySet();

    Multiset<K> keys();

    @CanIgnoreReturnValue
    boolean put(K k, V v);

    @CanIgnoreReturnValue
    boolean putAll(Multimap<? extends K, ? extends V> multimap);

    @CanIgnoreReturnValue
    boolean putAll(K k, Iterable<? extends V> iterable);

    @CanIgnoreReturnValue
    boolean remove(@CompatibleWith("K") Object obj, @CompatibleWith("V") Object obj2);

    @CanIgnoreReturnValue
    Collection<V> removeAll(@CompatibleWith("K") Object obj);

    @CanIgnoreReturnValue
    Collection<V> replaceValues(BasicAnnotationProcessor.ProcessingStep processingStep, Iterable<? extends BasicAnnotationProcessor.ElementName> iterable);

    int size();

    Collection<V> values();

    /* renamed from: com.google.common.collect.Multimap$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$forEach(Multimap _this, BiConsumer biConsumer) {
            Preconditions.checkNotNull(biConsumer);
            _this.entries().forEach(new Consumer(biConsumer) {
                /* class com.google.common.collect.$$Lambda$Multimap$m1XizenlITg_G0gDTmsYEs2Ra8 */
                private final /* synthetic */ BiConsumer f$0;

                {
                    this.f$0 = r1;
                }

                public final void accept(Object obj) {
                    this.f$0.accept(((Map.Entry) obj).getKey(), ((Map.Entry) obj).getValue());
                }
            });
        }
    }
}
