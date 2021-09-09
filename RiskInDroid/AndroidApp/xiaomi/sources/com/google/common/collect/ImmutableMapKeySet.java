package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@GwtCompatible(emulated = true)
final class ImmutableMapKeySet<K, V> extends IndexedImmutableSet<K> {
    @Weak
    private final ImmutableMap<K, V> map;

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return true;
    }

    ImmutableMapKeySet(ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    public final int size() {
        return this.map.size();
    }

    public final UnmodifiableIterator<K> iterator() {
        return this.map.keyIterator();
    }

    public final Spliterator<K> spliterator() {
        return this.map.keySpliterator();
    }

    public final boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    /* access modifiers changed from: package-private */
    public final K get(int i) {
        return this.map.entrySet().asList().get(i).getKey();
    }

    public final void forEach(Consumer<? super K> consumer) {
        Preconditions.checkNotNull(consumer);
        this.map.forEach(new BiConsumer(consumer) {
            /* class com.google.common.collect.$$Lambda$ImmutableMapKeySet$MvtUaElxjjTXTntLQ1EOeUN7L4 */
            private final /* synthetic */ Consumer f$0;

            {
                this.f$0 = r1;
            }

            public final void accept(Object obj, Object obj2) {
                this.f$0.accept(obj);
            }
        });
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public final Object writeReplace() {
        return new KeySetSerializedForm(this.map);
    }

    @GwtIncompatible
    static class KeySetSerializedForm<K> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<K, ?> map;

        KeySetSerializedForm(ImmutableMap<K, ?> immutableMap) {
            this.map = immutableMap;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return this.map.keySet();
        }
    }
}
