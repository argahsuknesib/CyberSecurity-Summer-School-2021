package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableBiMap<K, V> extends ImmutableBiMapFauxverideShim<K, V> implements BiMap<K, V> {
    public abstract ImmutableBiMap<V, K> inverse();

    @Beta
    public static <T, K, V> Collector<T, ?, ImmutableBiMap<K, V>> toImmutableBiMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return CollectCollectors.toImmutableBiMap(function, function2);
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return RegularImmutableBiMap.EMPTY;
    }

    public static <K, V> ImmutableBiMap<K, V> of(Object obj, Object obj2) {
        return new SingletonImmutableBiMap(obj, obj2);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2) {
        return RegularImmutableBiMap.fromEntries(entryOf(k, v), entryOf(k2, v2));
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return RegularImmutableBiMap.fromEntries(entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3));
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return RegularImmutableBiMap.fromEntries(entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4));
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return RegularImmutableBiMap.fromEntries(entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4), entryOf(k5, v5));
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    @Beta
    public static <K, V> Builder<K, V> builderWithExpectedSize(int i) {
        CollectPreconditions.checkNonnegative(i, "expectedSize");
        return new Builder<>(i);
    }

    public static final class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        public Builder() {
        }

        Builder(int i) {
            super(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.ImmutableMap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMap$Builder<K, V>
         arg types: [K, V]
         candidates:
          com.google.common.collect.ImmutableBiMap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableBiMap$Builder<K, V>
          com.google.common.collect.ImmutableMap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMap$Builder<K, V> */
        @CanIgnoreReturnValue
        public final Builder<K, V> put(K k, V v) {
            super.put((Object) k, (Object) v);
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put((Map.Entry) entry);
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            super.putAll((Map) map);
            return this;
        }

        @CanIgnoreReturnValue
        @Beta
        public final Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll((Iterable) iterable);
            return this;
        }

        @CanIgnoreReturnValue
        @Beta
        public final Builder<K, V> orderEntriesByValue(Comparator<? super V> comparator) {
            super.orderEntriesByValue((Comparator) comparator);
            return this;
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public final Builder<K, V> combine(ImmutableMap.Builder builder) {
            super.combine(builder);
            return this;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.ImmutableBiMap.of(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableBiMap<K, V>
         arg types: [java.lang.Object, java.lang.Object]
         candidates:
          com.google.common.collect.ImmutableMap.of(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMap<K, V>
          com.google.common.collect.ImmutableBiMap.of(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableBiMap<K, V> */
        public final ImmutableBiMap<K, V> build() {
            int i = this.size;
            if (i == 0) {
                return ImmutableBiMap.of();
            }
            if (i == 1) {
                return ImmutableBiMap.of(this.entries[0].getKey(), this.entries[0].getValue());
            }
            if (this.valueComparator != null) {
                if (this.entriesUsed) {
                    this.entries = (Map.Entry[]) Arrays.copyOf(this.entries, this.size);
                }
                Arrays.sort(this.entries, 0, this.size, Ordering.from(this.valueComparator).onResultOf(Maps.valueFunction()));
            }
            this.entriesUsed = true;
            return RegularImmutableBiMap.fromEntryArray(this.size, this.entries);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.ImmutableBiMap.of(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableBiMap<K, V>
         arg types: [java.lang.Object, java.lang.Object]
         candidates:
          com.google.common.collect.ImmutableMap.of(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMap<K, V>
          com.google.common.collect.ImmutableBiMap.of(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableBiMap<K, V> */
        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public final ImmutableBiMap<K, V> buildJdkBacked() {
            Preconditions.checkState(this.valueComparator == null, "buildJdkBacked is for tests only, doesn't support orderEntriesByValue");
            int i = this.size;
            if (i == 0) {
                return ImmutableBiMap.of();
            }
            if (i == 1) {
                return ImmutableBiMap.of(this.entries[0].getKey(), this.entries[0].getValue());
            }
            this.entriesUsed = true;
            return RegularImmutableBiMap.fromEntryArray(this.size, this.entries);
        }
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableBiMap.of(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableBiMap<K, V>
     arg types: [java.lang.Object, java.lang.Object]
     candidates:
      com.google.common.collect.ImmutableMap.of(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMap<K, V>
      com.google.common.collect.ImmutableBiMap.of(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableBiMap<K, V> */
    @Beta
    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) Iterables.toArray(iterable, EMPTY_ENTRY_ARRAY);
        int length = entryArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return RegularImmutableBiMap.fromEntries(entryArr);
        }
        Map.Entry entry = entryArr[0];
        return of(entry.getKey(), entry.getValue());
    }

    ImmutableBiMap() {
    }

    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    /* access modifiers changed from: package-private */
    public final ImmutableSet<V> createValues() {
        throw new AssertionError("should never be called");
    }

    @CanIgnoreReturnValue
    @Deprecated
    public V forcePut(K k, V v) {
        throw new UnsupportedOperationException();
    }

    static class SerializedForm extends ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0;

        SerializedForm(ImmutableBiMap<?, ?> immutableBiMap) {
            super(immutableBiMap);
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return createMap(new Builder());
        }
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new SerializedForm(this);
    }
}
