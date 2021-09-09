package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@GwtCompatible(emulated = true)
final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {
    @Weak
    public final ImmutableMap<K, V> map;

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return true;
    }

    ImmutableMapValues(ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    public final int size() {
        return this.map.size();
    }

    public final UnmodifiableIterator<V> iterator() {
        return new UnmodifiableIterator<V>() {
            /* class com.google.common.collect.ImmutableMapValues.AnonymousClass1 */
            final UnmodifiableIterator<Map.Entry<K, V>> entryItr = ImmutableMapValues.this.map.entrySet().iterator();

            public boolean hasNext() {
                return this.entryItr.hasNext();
            }

            public V next() {
                return this.entryItr.next().getValue();
            }
        };
    }

    public final Spliterator<V> spliterator() {
        return CollectSpliterators.map(this.map.entrySet().spliterator(), $$Lambda$73uG8GvDFSgCg7ViZNTbzvdqilI.INSTANCE);
    }

    public final boolean contains(Object obj) {
        return obj != null && Iterators.contains(iterator(), obj);
    }

    public final ImmutableList<V> asList() {
        final ImmutableList<Map.Entry<K, V>> asList = this.map.entrySet().asList();
        return new ImmutableAsList<V>() {
            /* class com.google.common.collect.ImmutableMapValues.AnonymousClass2 */

            public V get(int i) {
                return ((Map.Entry) asList.get(i)).getValue();
            }

            /* access modifiers changed from: package-private */
            public ImmutableCollection<V> delegateCollection() {
                return ImmutableMapValues.this;
            }
        };
    }

    @GwtIncompatible
    public final void forEach(Consumer<? super V> consumer) {
        Preconditions.checkNotNull(consumer);
        this.map.forEach(new BiConsumer(consumer) {
            /* class com.google.common.collect.$$Lambda$ImmutableMapValues$kZtXx30wmUIpstG6wnsuJOZGigQ */
            private final /* synthetic */ Consumer f$0;

            {
                this.f$0 = r1;
            }

            public final void accept(Object obj, Object obj2) {
                this.f$0.accept(obj2);
            }
        });
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public final Object writeReplace() {
        return new SerializedForm(this.map);
    }

    @GwtIncompatible
    static class SerializedForm<V> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<?, V> map;

        SerializedForm(ImmutableMap<?, V> immutableMap) {
            this.map = immutableMap;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return this.map.values();
        }
    }
}
