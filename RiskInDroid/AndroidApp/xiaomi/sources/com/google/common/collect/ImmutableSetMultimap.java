package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Serialization;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.lang.model.element.Element;

@GwtCompatible(emulated = true, serializable = true)
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements SetMultimap<K, V> {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    private final transient ImmutableSet<V> emptySet;
    private transient ImmutableSet<Map.Entry<K, V>> entries;
    @RetainedWith
    @LazyInit
    private transient ImmutableSetMultimap<V, K> inverse;

    @Beta
    public static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> toImmutableSetMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        Preconditions.checkNotNull(function, "keyFunction");
        Preconditions.checkNotNull(function2, "valueFunction");
        return Collector.of($$Lambda$JMuuO5tNa9NyxKBQEkc8YlC4xz4.INSTANCE, new BiConsumer(function, function2) {
            /* class com.google.common.collect.$$Lambda$ImmutableSetMultimap$kRvzEANd_wUlf5KZkmiNXyWS204 */
            private final /* synthetic */ Function f$0;
            private final /* synthetic */ Function f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void accept(Object obj, Object obj2) {
                ((ImmutableSetMultimap.Builder) obj).put((Class<? extends Annotation>) this.f$0.apply(obj2), (Element) this.f$1.apply(obj2));
            }
        }, $$Lambda$SIBU91s2V_lsg9WNIhV53gu2h_w.INSTANCE, $$Lambda$EgphYFJShmxml3u__T3BV50hz8.INSTANCE, new Collector.Characteristics[0]);
    }

    @Beta
    public static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> flatteningToImmutableSetMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends Stream<? extends V>> function2) {
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(function2);
        $$Lambda$ImmutableSetMultimap$RnaIAK71Ux9TAei2vT9EIA0MGvg r0 = new Function(function) {
            /* class com.google.common.collect.$$Lambda$ImmutableSetMultimap$RnaIAK71Ux9TAei2vT9EIA0MGvg */
            private final /* synthetic */ Function f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj) {
                return Preconditions.checkNotNull(this.f$0.apply(obj));
            }
        };
        $$Lambda$ImmutableSetMultimap$lHmDO7ojKDt2wNe37GsxiLsVW8E r2 = new Function(function2) {
            /* class com.google.common.collect.$$Lambda$ImmutableSetMultimap$lHmDO7ojKDt2wNe37GsxiLsVW8E */
            private final /* synthetic */ Function f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj) {
                return ((Stream) this.f$0.apply(obj)).peek($$Lambda$mMGTWQ3xwuIaCkgFwTr_lFVvQ4M.INSTANCE);
            }
        };
        MultimapBuilder.SetMultimapBuilder<Object, Object> linkedHashSetValues = MultimapBuilder.linkedHashKeys().linkedHashSetValues();
        linkedHashSetValues.getClass();
        return Collectors.collectingAndThen(Multimaps.flatteningToMultimap(r0, r2, new Supplier() {
            /* class com.google.common.collect.$$Lambda$nsORw7IQZpknnH5_OFSB_yNu0GE */

            public final Object get() {
                return MultimapBuilder.SetMultimapBuilder.this.build();
            }
        }), $$Lambda$zSHdU_CyjfI1rocqBvafH4ppd0.INSTANCE);
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableSetMultimap$Builder<K, V>
     arg types: [K, V]
     candidates:
      com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap$Builder
      com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
      com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableSetMultimap$Builder<K, V> */
    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v) {
        Builder builder = builder();
        builder.put((Class<? extends Annotation>) k, (Element) v);
        return builder.build();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableSetMultimap$Builder<K, V>
     arg types: [K, V]
     candidates:
      com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap$Builder
      com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
      com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableSetMultimap$Builder<K, V> */
    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2) {
        Builder builder = builder();
        builder.put((Class<? extends Annotation>) k, (Element) v);
        builder.put((Class<? extends Annotation>) k2, (Element) v2);
        return builder.build();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableSetMultimap$Builder<K, V>
     arg types: [K, V]
     candidates:
      com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap$Builder
      com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
      com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableSetMultimap$Builder<K, V> */
    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        Builder builder = builder();
        builder.put((Class<? extends Annotation>) k, (Element) v);
        builder.put((Class<? extends Annotation>) k2, (Element) v2);
        builder.put((Class<? extends Annotation>) k3, (Element) v3);
        return builder.build();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableSetMultimap$Builder<K, V>
     arg types: [K, V]
     candidates:
      com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap$Builder
      com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
      com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableSetMultimap$Builder<K, V> */
    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        Builder builder = builder();
        builder.put((Class<? extends Annotation>) k, (Element) v);
        builder.put((Class<? extends Annotation>) k2, (Element) v2);
        builder.put((Class<? extends Annotation>) k3, (Element) v3);
        builder.put((Class<? extends Annotation>) k4, (Element) v4);
        return builder.build();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableSetMultimap$Builder<K, V>
     arg types: [K, V]
     candidates:
      com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap$Builder
      com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
      com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableSetMultimap$Builder<K, V> */
    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Builder builder = builder();
        builder.put((Class<? extends Annotation>) k, (Element) v);
        builder.put((Class<? extends Annotation>) k2, (Element) v2);
        builder.put((Class<? extends Annotation>) k3, (Element) v3);
        builder.put((Class<? extends Annotation>) k4, (Element) v4);
        builder.put((Class<? extends Annotation>) k5, (Element) v5);
        return builder.build();
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
        /* access modifiers changed from: package-private */
        public final Collection<V> newMutableValueCollection() {
            return Platform.preservesInsertionOrderOnAddsSet();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
         arg types: [java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element]
         candidates:
          com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableSetMultimap$Builder<K, V>
          com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V> */
        @CanIgnoreReturnValue
        public final Builder<K, V> put(Class<? extends Annotation> cls, Element element) {
            super.put(cls, element);
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put((Map.Entry) entry);
            return this;
        }

        @CanIgnoreReturnValue
        @Beta
        public final Builder<K, V> putAll(Iterable iterable) {
            super.putAll(iterable);
            return this;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.ImmutableMultimap.Builder.putAll(java.lang.Object, java.lang.Iterable):com.google.common.collect.ImmutableMultimap$Builder<K, V>
         arg types: [K, java.lang.Iterable<? extends V>]
         candidates:
          com.google.common.collect.ImmutableSetMultimap.Builder.putAll(java.lang.Object, java.lang.Object[]):com.google.common.collect.ImmutableMultimap$Builder
          com.google.common.collect.ImmutableSetMultimap.Builder.putAll(java.lang.Object, java.lang.Iterable):com.google.common.collect.ImmutableSetMultimap$Builder<K, V>
          com.google.common.collect.ImmutableSetMultimap.Builder.putAll(java.lang.Object, java.lang.Object[]):com.google.common.collect.ImmutableSetMultimap$Builder<K, V>
          com.google.common.collect.ImmutableMultimap.Builder.putAll(java.lang.Object, java.lang.Object[]):com.google.common.collect.ImmutableMultimap$Builder<K, V>
          com.google.common.collect.ImmutableMultimap.Builder.putAll(java.lang.Object, java.lang.Iterable):com.google.common.collect.ImmutableMultimap$Builder<K, V> */
        @CanIgnoreReturnValue
        public final Builder<K, V> putAll(K k, Iterable<? extends V> iterable) {
            super.putAll((Object) k, (Iterable) iterable);
            return this;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.ImmutableSetMultimap.Builder.putAll(java.lang.Object, java.lang.Iterable):com.google.common.collect.ImmutableSetMultimap$Builder<K, V>
         arg types: [K, java.util.List]
         candidates:
          com.google.common.collect.ImmutableSetMultimap.Builder.putAll(java.lang.Object, java.lang.Iterable):com.google.common.collect.ImmutableMultimap$Builder
          com.google.common.collect.ImmutableSetMultimap.Builder.putAll(java.lang.Object, java.lang.Object[]):com.google.common.collect.ImmutableMultimap$Builder
          com.google.common.collect.ImmutableSetMultimap.Builder.putAll(java.lang.Object, java.lang.Object[]):com.google.common.collect.ImmutableSetMultimap$Builder<K, V>
          com.google.common.collect.ImmutableMultimap.Builder.putAll(java.lang.Object, java.lang.Iterable):com.google.common.collect.ImmutableMultimap$Builder<K, V>
          com.google.common.collect.ImmutableMultimap.Builder.putAll(java.lang.Object, java.lang.Object[]):com.google.common.collect.ImmutableMultimap$Builder<K, V>
          com.google.common.collect.ImmutableSetMultimap.Builder.putAll(java.lang.Object, java.lang.Iterable):com.google.common.collect.ImmutableSetMultimap$Builder<K, V> */
        @CanIgnoreReturnValue
        public final Builder<K, V> putAll(K k, V... vArr) {
            return putAll((Object) k, (Iterable) Arrays.asList(vArr));
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.ImmutableSetMultimap.Builder.putAll(java.lang.Object, java.lang.Iterable):com.google.common.collect.ImmutableSetMultimap$Builder<K, V>
         arg types: [java.lang.Object, java.lang.Iterable]
         candidates:
          com.google.common.collect.ImmutableSetMultimap.Builder.putAll(java.lang.Object, java.lang.Iterable):com.google.common.collect.ImmutableMultimap$Builder
          com.google.common.collect.ImmutableSetMultimap.Builder.putAll(java.lang.Object, java.lang.Object[]):com.google.common.collect.ImmutableMultimap$Builder
          com.google.common.collect.ImmutableSetMultimap.Builder.putAll(java.lang.Object, java.lang.Object[]):com.google.common.collect.ImmutableSetMultimap$Builder<K, V>
          com.google.common.collect.ImmutableMultimap.Builder.putAll(java.lang.Object, java.lang.Iterable):com.google.common.collect.ImmutableMultimap$Builder<K, V>
          com.google.common.collect.ImmutableMultimap.Builder.putAll(java.lang.Object, java.lang.Object[]):com.google.common.collect.ImmutableMultimap$Builder<K, V>
          com.google.common.collect.ImmutableSetMultimap.Builder.putAll(java.lang.Object, java.lang.Iterable):com.google.common.collect.ImmutableSetMultimap$Builder<K, V> */
        @CanIgnoreReturnValue
        public final Builder<K, V> putAll(Multimap multimap) {
            for (Map.Entry entry : multimap.asMap().entrySet()) {
                putAll(entry.getKey(), (Iterable) entry.getValue());
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public final Builder<K, V> combine(ImmutableMultimap.Builder<K, V> builder) {
            super.combine((ImmutableMultimap.Builder) builder);
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder<K, V> orderKeysBy(Comparator<? super K> comparator) {
            super.orderKeysBy((Comparator) comparator);
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder<K, V> orderValuesBy(Comparator<? super V> comparator) {
            super.orderValuesBy((Comparator) comparator);
            return this;
        }

        public final ImmutableSetMultimap<K, V> build() {
            Object entrySet = this.builderMap.entrySet();
            if (this.keyComparator != null) {
                entrySet = Ordering.from(this.keyComparator).onKeys().immutableSortedCopy(entrySet);
            }
            return ImmutableSetMultimap.fromMapEntries(entrySet, this.valueComparator);
        }
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        return copyOf(multimap, null);
    }

    private static <K, V> ImmutableSetMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap, Comparator<? super V> comparator) {
        Preconditions.checkNotNull(multimap);
        if (multimap.isEmpty() && comparator == null) {
            return of();
        }
        if (multimap instanceof ImmutableSetMultimap) {
            ImmutableSetMultimap<K, V> immutableSetMultimap = (ImmutableSetMultimap) multimap;
            if (!immutableSetMultimap.isPartialView()) {
                return immutableSetMultimap;
            }
        }
        return fromMapEntries(multimap.asMap().entrySet(), comparator);
    }

    @Beta
    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new Builder().putAll((Iterable) iterable).build();
    }

    static <K, V> ImmutableSetMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return of();
        }
        ImmutableMap.Builder builder = new ImmutableMap.Builder(collection.size());
        int i = 0;
        for (Map.Entry entry : collection) {
            Object key = entry.getKey();
            ImmutableSet<V> valueSet = valueSet(comparator, (Collection) entry.getValue());
            if (!valueSet.isEmpty()) {
                builder.put(key, valueSet);
                i += valueSet.size();
            }
        }
        return new ImmutableSetMultimap<>(builder.build(), i, comparator);
    }

    ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> immutableMap, int i, Comparator<? super V> comparator) {
        super(immutableMap, i);
        this.emptySet = emptySet(comparator);
    }

    public ImmutableSet<V> get(Object obj) {
        return (ImmutableSet) MoreObjects.firstNonNull((ImmutableSet) this.map.get(obj), this.emptySet);
    }

    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> immutableSetMultimap = this.inverse;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<V, K> invert = invert();
        this.inverse = invert;
        return invert;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableSetMultimap$Builder<K, V>
     arg types: [java.lang.Object, java.lang.Object]
     candidates:
      com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap$Builder
      com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
      com.google.common.collect.ImmutableSetMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableSetMultimap$Builder<K, V> */
    private ImmutableSetMultimap<V, K> invert() {
        Builder builder = builder();
        UnmodifiableIterator it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.put((Class<? extends Annotation>) entry.getValue(), (Element) entry.getKey());
        }
        ImmutableSetMultimap<V, K> build = builder.build();
        build.inverse = this;
        return build;
    }

    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableSet<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public ImmutableSet<Map.Entry<K, V>> entries() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entries;
        if (immutableSet != null) {
            return immutableSet;
        }
        EntrySet entrySet = new EntrySet(this);
        this.entries = entrySet;
        return entrySet;
    }

    static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        @Weak
        private final transient ImmutableSetMultimap<K, V> multimap;

        /* access modifiers changed from: package-private */
        public final boolean isPartialView() {
            return false;
        }

        EntrySet(ImmutableSetMultimap<K, V> immutableSetMultimap) {
            this.multimap = immutableSetMultimap;
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }

        public final int size() {
            return this.multimap.size();
        }

        public final UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Collection<? extends V>, java.util.Collection] */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedSet.copyOf(java.util.Comparator, java.util.Collection):com.google.common.collect.ImmutableSortedSet<E>
     arg types: [java.util.Comparator<? super V>, ?]
     candidates:
      com.google.common.collect.ImmutableSortedSet.copyOf(java.util.Comparator, java.lang.Iterable):com.google.common.collect.ImmutableSortedSet<E>
      com.google.common.collect.ImmutableSortedSet.copyOf(java.util.Comparator, java.util.Iterator):com.google.common.collect.ImmutableSortedSet<E>
      com.google.common.collect.ImmutableSortedSet.copyOf(java.util.Comparator, java.util.Collection):com.google.common.collect.ImmutableSortedSet<E> */
    /* JADX WARNING: Unknown variable types count: 1 */
    private static <V> ImmutableSet<V> valueSet(Comparator<? super V> comparator, Collection<? extends V> r1) {
        if (comparator == null) {
            return ImmutableSet.copyOf((Collection) r1);
        }
        return ImmutableSortedSet.copyOf((Comparator) comparator, (Collection) r1);
    }

    private static <V> ImmutableSet<V> emptySet(Comparator<? super V> comparator) {
        if (comparator == null) {
            return ImmutableSet.of();
        }
        return ImmutableSortedSet.emptySet(comparator);
    }

    private static <V> ImmutableSet.Builder<V> valuesBuilder(Comparator<? super V> comparator) {
        return comparator == null ? new ImmutableSet.Builder<>() : new ImmutableSortedSet.Builder(comparator);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(valueComparator());
        Serialization.writeMultimap(this, objectOutputStream);
    }

    /* access modifiers changed from: package-private */
    public Comparator<? super V> valueComparator() {
        ImmutableSet<V> immutableSet = this.emptySet;
        if (immutableSet instanceof ImmutableSortedSet) {
            return ((ImmutableSortedSet) immutableSet).comparator();
        }
        return null;
    }

    @GwtIncompatible
    static final class SetFieldSettersHolder {
        static final Serialization.FieldSetter<ImmutableSetMultimap> EMPTY_SET_FIELD_SETTER = Serialization.getFieldSetter(ImmutableSetMultimap.class, "emptySet");

        private SetFieldSettersHolder() {
        }
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            int i = 0;
            int i2 = 0;
            while (i < readInt) {
                Object readObject = objectInputStream.readObject();
                int readInt2 = objectInputStream.readInt();
                if (readInt2 > 0) {
                    ImmutableSet.Builder valuesBuilder = valuesBuilder(comparator);
                    for (int i3 = 0; i3 < readInt2; i3++) {
                        valuesBuilder.add(objectInputStream.readObject());
                    }
                    ImmutableSet build = valuesBuilder.build();
                    if (build.size() == readInt2) {
                        builder.put(readObject, build);
                        i2 += readInt2;
                        i++;
                    } else {
                        throw new InvalidObjectException("Duplicate key-value pairs exist for key ".concat(String.valueOf(readObject)));
                    }
                } else {
                    throw new InvalidObjectException("Invalid value count ".concat(String.valueOf(readInt2)));
                }
            }
            try {
                ImmutableMultimap.FieldSettersHolder.MAP_FIELD_SETTER.set(this, builder.build());
                ImmutableMultimap.FieldSettersHolder.SIZE_FIELD_SETTER.set(this, i2);
                SetFieldSettersHolder.EMPTY_SET_FIELD_SETTER.set(this, emptySet(comparator));
            } catch (IllegalArgumentException e) {
                throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
            }
        } else {
            throw new InvalidObjectException("Invalid key count ".concat(String.valueOf(readInt)));
        }
    }
}
