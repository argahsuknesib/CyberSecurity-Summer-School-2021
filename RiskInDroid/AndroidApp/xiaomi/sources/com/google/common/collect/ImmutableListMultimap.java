package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.MultimapBuilder;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.annotation.Annotation;
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
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements ListMultimap<K, V> {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    @RetainedWith
    @LazyInit
    private transient ImmutableListMultimap<V, K> inverse;

    @Beta
    public static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> toImmutableListMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        Preconditions.checkNotNull(function, "keyFunction");
        Preconditions.checkNotNull(function2, "valueFunction");
        return Collector.of($$Lambda$ki6G207kprHsN7dVJVjhPKT0bs.INSTANCE, new BiConsumer(function, function2) {
            /* class com.google.common.collect.$$Lambda$ImmutableListMultimap$0LQpQfTQ93x0y_7DJDTseJazKw */
            private final /* synthetic */ Function f$0;
            private final /* synthetic */ Function f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void accept(Object obj, Object obj2) {
                ((ImmutableListMultimap.Builder) obj).put(this.f$0.apply(obj2), this.f$1.apply(obj2));
            }
        }, $$Lambda$kXgwA_sZzDnEmZmoJP3cLI_W5k.INSTANCE, $$Lambda$97U0YQNPGq3BJMaleKjDH1EOwEA.INSTANCE, new Collector.Characteristics[0]);
    }

    @Beta
    public static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> flatteningToImmutableListMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends Stream<? extends V>> function2) {
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(function2);
        $$Lambda$ImmutableListMultimap$thPuQPfWk1EI4g0Kc7jhgSPR9_U r0 = new Function(function) {
            /* class com.google.common.collect.$$Lambda$ImmutableListMultimap$thPuQPfWk1EI4g0Kc7jhgSPR9_U */
            private final /* synthetic */ Function f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj) {
                return Preconditions.checkNotNull(this.f$0.apply(obj));
            }
        };
        $$Lambda$ImmutableListMultimap$hWj29vJ30VmxhPYELy1tU0j2ZU r2 = new Function(function2) {
            /* class com.google.common.collect.$$Lambda$ImmutableListMultimap$hWj29vJ30VmxhPYELy1tU0j2ZU */
            private final /* synthetic */ Function f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj) {
                return ((Stream) this.f$0.apply(obj)).peek($$Lambda$mMGTWQ3xwuIaCkgFwTr_lFVvQ4M.INSTANCE);
            }
        };
        MultimapBuilder.ListMultimapBuilder<Object, Object> arrayListValues = MultimapBuilder.linkedHashKeys().arrayListValues();
        arrayListValues.getClass();
        return Collectors.collectingAndThen(Multimaps.flatteningToMultimap(r0, r2, new Supplier() {
            /* class com.google.common.collect.$$Lambda$yEFp6dlddIAxuEuCjcM4vSwhwAE */

            public final Object get() {
                return MultimapBuilder.ListMultimapBuilder.this.build();
            }
        }), $$Lambda$Xxw32g7ROf3L8FxiPJeloRx_PDA.INSTANCE);
    }

    public static <K, V> ImmutableListMultimap<K, V> of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V>
     arg types: [K, V]
     candidates:
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap$Builder
      com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V> */
    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v) {
        Builder builder = builder();
        builder.put((Object) k, (Object) v);
        return builder.build();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V>
     arg types: [K, V]
     candidates:
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap$Builder
      com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V> */
    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2) {
        Builder builder = builder();
        builder.put((Object) k, (Object) v);
        builder.put((Object) k2, (Object) v2);
        return builder.build();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V>
     arg types: [K, V]
     candidates:
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap$Builder
      com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V> */
    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        Builder builder = builder();
        builder.put((Object) k, (Object) v);
        builder.put((Object) k2, (Object) v2);
        builder.put((Object) k3, (Object) v3);
        return builder.build();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V>
     arg types: [K, V]
     candidates:
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap$Builder
      com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V> */
    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        Builder builder = builder();
        builder.put((Object) k, (Object) v);
        builder.put((Object) k2, (Object) v2);
        builder.put((Object) k3, (Object) v3);
        builder.put((Object) k4, (Object) v4);
        return builder.build();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V>
     arg types: [K, V]
     candidates:
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap$Builder
      com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V> */
    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Builder builder = builder();
        builder.put((Object) k, (Object) v);
        builder.put((Object) k2, (Object) v2);
        builder.put((Object) k3, (Object) v3);
        builder.put((Object) k4, (Object) v4);
        builder.put((Object) k5, (Object) v5);
        return builder.build();
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static final class Builder<K, V> extends ImmutableMultimap.Builder<K, V> {
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
         arg types: [java.lang.Object, java.lang.Object]
         candidates:
          com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V>
          com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V> */
        @CanIgnoreReturnValue
        public final Builder<K, V> put(Object obj, Object obj2) {
            super.put((Class<? extends Annotation>) obj, (Element) obj2);
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put((Map.Entry) entry);
            return this;
        }

        @CanIgnoreReturnValue
        @Beta
        public final Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll((Iterable) iterable);
            return this;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.ImmutableMultimap.Builder.putAll(java.lang.Object, java.lang.Iterable):com.google.common.collect.ImmutableMultimap$Builder<K, V>
         arg types: [K, java.lang.Iterable<? extends V>]
         candidates:
          com.google.common.collect.ImmutableListMultimap.Builder.putAll(java.lang.Object, java.lang.Iterable):com.google.common.collect.ImmutableListMultimap$Builder<K, V>
          com.google.common.collect.ImmutableListMultimap.Builder.putAll(java.lang.Object, java.lang.Object[]):com.google.common.collect.ImmutableListMultimap$Builder<K, V>
          com.google.common.collect.ImmutableListMultimap.Builder.putAll(java.lang.Object, java.lang.Object[]):com.google.common.collect.ImmutableMultimap$Builder
          com.google.common.collect.ImmutableMultimap.Builder.putAll(java.lang.Object, java.lang.Object[]):com.google.common.collect.ImmutableMultimap$Builder<K, V>
          com.google.common.collect.ImmutableMultimap.Builder.putAll(java.lang.Object, java.lang.Iterable):com.google.common.collect.ImmutableMultimap$Builder<K, V> */
        @CanIgnoreReturnValue
        public final Builder<K, V> putAll(K k, Iterable<? extends V> iterable) {
            super.putAll((Object) k, (Iterable) iterable);
            return this;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.ImmutableMultimap.Builder.putAll(java.lang.Object, java.lang.Object[]):com.google.common.collect.ImmutableMultimap$Builder<K, V>
         arg types: [K, V[]]
         candidates:
          com.google.common.collect.ImmutableListMultimap.Builder.putAll(java.lang.Object, java.lang.Iterable):com.google.common.collect.ImmutableListMultimap$Builder<K, V>
          com.google.common.collect.ImmutableListMultimap.Builder.putAll(java.lang.Object, java.lang.Object[]):com.google.common.collect.ImmutableListMultimap$Builder<K, V>
          com.google.common.collect.ImmutableListMultimap.Builder.putAll(java.lang.Object, java.lang.Iterable):com.google.common.collect.ImmutableMultimap$Builder
          com.google.common.collect.ImmutableMultimap.Builder.putAll(java.lang.Object, java.lang.Iterable):com.google.common.collect.ImmutableMultimap$Builder<K, V>
          com.google.common.collect.ImmutableMultimap.Builder.putAll(java.lang.Object, java.lang.Object[]):com.google.common.collect.ImmutableMultimap$Builder<K, V> */
        @CanIgnoreReturnValue
        public final Builder<K, V> putAll(K k, V... vArr) {
            super.putAll((Object) k, (Object[]) vArr);
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap) {
            super.putAll((Multimap) multimap);
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

        public final ImmutableListMultimap<K, V> build() {
            return (ImmutableListMultimap) super.build();
        }
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        if (multimap.isEmpty()) {
            return of();
        }
        if (multimap instanceof ImmutableListMultimap) {
            ImmutableListMultimap<K, V> immutableListMultimap = (ImmutableListMultimap) multimap;
            if (!immutableListMultimap.isPartialView()) {
                return immutableListMultimap;
            }
        }
        return fromMapEntries(multimap.asMap().entrySet(), null);
    }

    @Beta
    public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new Builder().putAll((Iterable) iterable).build();
    }

    static <K, V> ImmutableListMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        ImmutableList<E> immutableList;
        if (collection.isEmpty()) {
            return of();
        }
        ImmutableMap.Builder builder = new ImmutableMap.Builder(collection.size());
        int i = 0;
        for (Map.Entry entry : collection) {
            Object key = entry.getKey();
            Collection collection2 = (Collection) entry.getValue();
            if (comparator == null) {
                immutableList = ImmutableList.copyOf(collection2);
            } else {
                immutableList = ImmutableList.sortedCopyOf(comparator, collection2);
            }
            if (!immutableList.isEmpty()) {
                builder.put(key, immutableList);
                i += immutableList.size();
            }
        }
        return new ImmutableListMultimap<>(builder.build(), i);
    }

    ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> immutableMap, int i) {
        super(immutableMap, i);
    }

    public ImmutableList<V> get(K k) {
        ImmutableList<V> immutableList = (ImmutableList) this.map.get(k);
        return immutableList == null ? ImmutableList.of() : immutableList;
    }

    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> immutableListMultimap = this.inverse;
        if (immutableListMultimap != null) {
            return immutableListMultimap;
        }
        ImmutableListMultimap<V, K> invert = invert();
        this.inverse = invert;
        return invert;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V>
     arg types: [java.lang.Object, java.lang.Object]
     candidates:
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap$Builder
      com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V> */
    private ImmutableListMultimap<V, K> invert() {
        Builder builder = builder();
        UnmodifiableIterator it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.put(entry.getValue(), entry.getKey());
        }
        ImmutableListMultimap<V, K> build = builder.build();
        build.inverse = this;
        return build;
    }

    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableList<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableList<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultimap(this, objectOutputStream);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            int i = 0;
            int i2 = 0;
            while (i < readInt) {
                Object readObject = objectInputStream.readObject();
                int readInt2 = objectInputStream.readInt();
                if (readInt2 > 0) {
                    ImmutableList.Builder builder2 = ImmutableList.builder();
                    for (int i3 = 0; i3 < readInt2; i3++) {
                        builder2.add(objectInputStream.readObject());
                    }
                    builder.put(readObject, builder2.build());
                    i2 += readInt2;
                    i++;
                } else {
                    throw new InvalidObjectException("Invalid value count ".concat(String.valueOf(readInt2)));
                }
            }
            try {
                ImmutableMultimap.FieldSettersHolder.MAP_FIELD_SETTER.set(this, builder.build());
                ImmutableMultimap.FieldSettersHolder.SIZE_FIELD_SETTER.set(this, i2);
            } catch (IllegalArgumentException e) {
                throw ((InvalidObjectException) new InvalidObjectException(e.getMessage()).initCause(e));
            }
        } else {
            throw new InvalidObjectException("Invalid key count ".concat(String.valueOf(readInt)));
        }
    }
}
