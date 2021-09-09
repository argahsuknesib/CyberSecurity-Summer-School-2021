package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.BiConsumer;

@GwtCompatible(emulated = true, serializable = true)
final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
    private final transient EnumMap<K, V> delegate;

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return false;
    }

    static <K extends Enum<K>, V> ImmutableMap<K, V> asImmutable(EnumMap<K, V> enumMap) {
        int size = enumMap.size();
        if (size == 0) {
            return ImmutableMap.of();
        }
        if (size != 1) {
            return new ImmutableEnumMap(enumMap);
        }
        Map.Entry entry = (Map.Entry) Iterables.getOnlyElement(enumMap.entrySet());
        return ImmutableMap.of(entry.getKey(), entry.getValue());
    }

    private ImmutableEnumMap(EnumMap<K, V> enumMap) {
        this.delegate = enumMap;
        Preconditions.checkArgument(!enumMap.isEmpty());
    }

    /* access modifiers changed from: package-private */
    public final UnmodifiableIterator<K> keyIterator() {
        return Iterators.unmodifiableIterator(this.delegate.keySet().iterator());
    }

    /* access modifiers changed from: package-private */
    public final Spliterator<K> keySpliterator() {
        return this.delegate.keySet().spliterator();
    }

    public final int size() {
        return this.delegate.size();
    }

    public final boolean containsKey(Object obj) {
        return this.delegate.containsKey(obj);
    }

    public final V get(Object obj) {
        return this.delegate.get(obj);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEnumMap) {
            obj = ((ImmutableEnumMap) obj).delegate;
        }
        return this.delegate.equals(obj);
    }

    /* access modifiers changed from: package-private */
    public final UnmodifiableIterator<Map.Entry<K, V>> entryIterator() {
        return Maps.unmodifiableEntryIterator(this.delegate.entrySet().iterator());
    }

    /* access modifiers changed from: package-private */
    public final Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return CollectSpliterators.map(this.delegate.entrySet().spliterator(), $$Lambda$r2lp_fE5ckwj_jBe0116w_4kyQ.INSTANCE);
    }

    public final void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        this.delegate.forEach(biConsumer);
    }

    /* access modifiers changed from: package-private */
    public final Object writeReplace() {
        return new EnumSerializedForm(this.delegate);
    }

    static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumMap<K, V> delegate;

        EnumSerializedForm(EnumMap<K, V> enumMap) {
            this.delegate = enumMap;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return new ImmutableEnumMap(this.delegate);
        }
    }
}
