package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Serialization;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.lang.model.element.Element;

@GwtCompatible(emulated = true)
public abstract class ImmutableMultimap<K, V> extends BaseImmutableMultimap<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;

    public abstract ImmutableCollection<V> get(Object obj);

    public abstract ImmutableMultimap<V, K> inverse();

    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableListMultimap.of(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap<K, V>
     arg types: [K, V]
     candidates:
      com.google.common.collect.ImmutableMultimap.of(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap<K, V>
      com.google.common.collect.ImmutableListMultimap.of(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap<K, V> */
    public static <K, V> ImmutableMultimap<K, V> of(K k, V v) {
        return ImmutableListMultimap.of((Object) k, (Object) v);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableListMultimap.of(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap<K, V>
     arg types: [K, V, K, V]
     candidates:
      com.google.common.collect.ImmutableMultimap.of(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap<K, V>
      com.google.common.collect.ImmutableListMultimap.of(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap<K, V> */
    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableListMultimap.of(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap<K, V>
     arg types: [K, V, K, V, K, V]
     candidates:
      com.google.common.collect.ImmutableMultimap.of(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap<K, V>
      com.google.common.collect.ImmutableListMultimap.of(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap<K, V> */
    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableListMultimap.of(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap<K, V>
     arg types: [K, V, K, V, K, V, K, V]
     candidates:
      com.google.common.collect.ImmutableMultimap.of(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap<K, V>
      com.google.common.collect.ImmutableListMultimap.of(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap<K, V> */
    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableListMultimap.of(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap<K, V>
     arg types: [K, V, K, V, K, V, K, V, K, V]
     candidates:
      com.google.common.collect.ImmutableMultimap.of(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap<K, V>
      com.google.common.collect.ImmutableListMultimap.of(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap<K, V> */
    public static <K, V> ImmutableMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ImmutableListMultimap.of((Object) k, (Object) v, (Object) k2, (Object) v2, (Object) k3, (Object) v3, (Object) k4, (Object) v4, (Object) k5, (Object) v5);
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static class Builder<K, V> {
        Map<K, Collection<V>> builderMap = Platform.preservesInsertionOrderOnPutsMap();
        Comparator<? super K> keyComparator;
        Comparator<? super V> valueComparator;

        /* access modifiers changed from: package-private */
        public Collection<V> newMutableValueCollection() {
            return new ArrayList();
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(Class<? extends Annotation> cls, Element element) {
            CollectPreconditions.checkEntryNotNull(cls, element);
            Collection collection = this.builderMap.get(cls);
            if (collection == null) {
                Map<K, Collection<V>> map = this.builderMap;
                Collection newMutableValueCollection = newMutableValueCollection();
                map.put(cls, newMutableValueCollection);
                collection = newMutableValueCollection;
            }
            collection.add(element);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry entry) {
            return put(entry.getKey(), entry.getValue());
        }

        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable iterable) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                put((Map.Entry) it.next());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Object obj, Iterable iterable) {
            if (obj != null) {
                Collection collection = this.builderMap.get(obj);
                if (collection != null) {
                    for (Object next : iterable) {
                        CollectPreconditions.checkEntryNotNull(obj, next);
                        collection.add(next);
                    }
                    return this;
                }
                Iterator it = iterable.iterator();
                if (!it.hasNext()) {
                    return this;
                }
                Collection newMutableValueCollection = newMutableValueCollection();
                while (it.hasNext()) {
                    Object next2 = it.next();
                    CollectPreconditions.checkEntryNotNull(obj, next2);
                    newMutableValueCollection.add(next2);
                }
                this.builderMap.put(obj, newMutableValueCollection);
                return this;
            }
            throw new NullPointerException("null key in entry: null=" + Iterables.toString(iterable));
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Object obj, Object... objArr) {
            return putAll(obj, Arrays.asList(objArr));
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Multimap multimap) {
            for (Map.Entry entry : multimap.asMap().entrySet()) {
                putAll(entry.getKey(), (Iterable) entry.getValue());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> orderKeysBy(Comparator comparator) {
            this.keyComparator = (Comparator) Preconditions.checkNotNull(comparator);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> orderValuesBy(Comparator comparator) {
            this.valueComparator = (Comparator) Preconditions.checkNotNull(comparator);
            return this;
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public Builder<K, V> combine(Builder builder) {
            for (Map.Entry next : builder.builderMap.entrySet()) {
                putAll(next.getKey(), (Iterable) next.getValue());
            }
            return this;
        }

        public ImmutableMultimap<K, V> build() {
            Object entrySet = this.builderMap.entrySet();
            Comparator comparator = this.keyComparator;
            if (comparator != null) {
                entrySet = Ordering.from(comparator).onKeys().immutableSortedCopy(entrySet);
            }
            return ImmutableListMultimap.fromMapEntries(entrySet, this.valueComparator);
        }
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Multimap<? extends K, ? extends V> multimap) {
        if (multimap instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) multimap;
            if (!immutableMultimap.isPartialView()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.copyOf((Multimap) multimap);
    }

    @Beta
    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return ImmutableListMultimap.copyOf((Iterable) iterable);
    }

    @GwtIncompatible
    static class FieldSettersHolder {
        static final Serialization.FieldSetter<ImmutableMultimap> MAP_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "map");
        static final Serialization.FieldSetter<ImmutableMultimap> SIZE_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "size");

        FieldSettersHolder() {
        }
    }

    ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i) {
        this.map = immutableMap;
        this.size = i;
    }

    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableCollection<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public ImmutableCollection<V> replaceValues(Object obj, Iterable iterable) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public boolean put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public boolean isPartialView() {
        return this.map.isPartialView();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    public int size() {
        return this.size;
    }

    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    /* access modifiers changed from: package-private */
    public Set<K> createKeySet() {
        throw new AssertionError("unreachable");
    }

    public ImmutableMap<K, Collection<V>> asMap() {
        return this.map;
    }

    /* access modifiers changed from: package-private */
    public Map<K, Collection<V>> createAsMap() {
        throw new AssertionError("should never be called");
    }

    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    /* access modifiers changed from: package-private */
    public ImmutableCollection<Map.Entry<K, V>> createEntries() {
        return new EntryCollection(this);
    }

    static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;
        @Weak
        final ImmutableMultimap<K, V> multimap;

        EntryCollection(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
            return this.multimap.entryIterator();
        }

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return this.multimap.isPartialView();
        }

        public int size() {
            return this.multimap.size();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }
    }

    /* access modifiers changed from: package-private */
    public UnmodifiableIterator<Map.Entry<K, V>> entryIterator() {
        return new UnmodifiableIterator<Map.Entry<K, V>>() {
            /* class com.google.common.collect.ImmutableMultimap.AnonymousClass1 */
            final Iterator<? extends Map.Entry<K, ? extends ImmutableCollection<V>>> asMapItr = ImmutableMultimap.this.map.entrySet().iterator();
            K currentKey = null;
            Iterator<V> valueItr = Iterators.emptyIterator();

            public boolean hasNext() {
                return this.valueItr.hasNext() || this.asMapItr.hasNext();
            }

            public Map.Entry<K, V> next() {
                if (!this.valueItr.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.asMapItr.next();
                    this.currentKey = entry.getKey();
                    this.valueItr = ((ImmutableCollection) entry.getValue()).iterator();
                }
                return Maps.immutableEntry(this.currentKey, this.valueItr.next());
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return CollectSpliterators.flatMap(asMap().entrySet().spliterator(), $$Lambda$ImmutableMultimap$4WozpdkAAYTHkEWDf7l4joSUk.INSTANCE, (this instanceof SetMultimap) | true, (long) size());
    }

    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Preconditions.checkNotNull(biConsumer);
        asMap().forEach(new BiConsumer(biConsumer) {
            /* class com.google.common.collect.$$Lambda$ImmutableMultimap$WWrhHu3Ux9miZ0Nal8FJvU_oe4 */
            private final /* synthetic */ BiConsumer f$0;

            {
                this.f$0 = r1;
            }

            public final void accept(Object obj, Object obj2) {
                ((Collection) obj2).forEach(new Consumer(this.f$0, obj) {
                    /* class com.google.common.collect.$$Lambda$ImmutableMultimap$qQhGyUwMC1Vnz4O7s7CYBeKRBs */
                    private final /* synthetic */ BiConsumer f$0;
                    private final /* synthetic */ Object f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void accept(Object obj) {
                        this.f$0.accept(this.f$1, obj);
                    }
                });
            }
        });
    }

    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    /* access modifiers changed from: package-private */
    public ImmutableMultiset<K> createKeys() {
        return new Keys();
    }

    class Keys extends ImmutableMultiset<K> {
        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return true;
        }

        Keys() {
        }

        public boolean contains(Object obj) {
            return ImmutableMultimap.this.containsKey(obj);
        }

        public int count(Object obj) {
            Collection collection = (Collection) ImmutableMultimap.this.map.get(obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        public ImmutableSet<K> elementSet() {
            return ImmutableMultimap.this.keySet();
        }

        public int size() {
            return ImmutableMultimap.this.size();
        }

        /* access modifiers changed from: package-private */
        public Multiset.Entry<K> getEntry(int i) {
            Map.Entry entry = ImmutableMultimap.this.map.entrySet().asList().get(i);
            return Multisets.immutableEntry(entry.getKey(), ((Collection) entry.getValue()).size());
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        public Object writeReplace() {
            return new KeysSerializedForm(ImmutableMultimap.this);
        }
    }

    @GwtIncompatible
    static final class KeysSerializedForm implements Serializable {
        final ImmutableMultimap<?, ?> multimap;

        KeysSerializedForm(ImmutableMultimap<?, ?> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        /* access modifiers changed from: package-private */
        public final Object readResolve() {
            return this.multimap.keys();
        }
    }

    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    /* access modifiers changed from: package-private */
    public ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    /* access modifiers changed from: package-private */
    public UnmodifiableIterator<V> valueIterator() {
        return new UnmodifiableIterator<V>() {
            /* class com.google.common.collect.ImmutableMultimap.AnonymousClass2 */
            Iterator<? extends ImmutableCollection<V>> valueCollectionItr = ImmutableMultimap.this.map.values().iterator();
            Iterator<V> valueItr = Iterators.emptyIterator();

            public boolean hasNext() {
                return this.valueItr.hasNext() || this.valueCollectionItr.hasNext();
            }

            public V next() {
                if (!this.valueItr.hasNext()) {
                    this.valueItr = ((ImmutableCollection) this.valueCollectionItr.next()).iterator();
                }
                return this.valueItr.next();
            }
        };
    }

    static final class Values<K, V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;
        @Weak
        private final transient ImmutableMultimap<K, V> multimap;

        /* access modifiers changed from: package-private */
        public final boolean isPartialView() {
            return true;
        }

        Values(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        public final boolean contains(Object obj) {
            return this.multimap.containsValue(obj);
        }

        public final UnmodifiableIterator<V> iterator() {
            return this.multimap.valueIterator();
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        public final int copyIntoArray(Object[] objArr, int i) {
            UnmodifiableIterator<? extends ImmutableCollection<V>> it = this.multimap.map.values().iterator();
            while (it.hasNext()) {
                i = ((ImmutableCollection) it.next()).copyIntoArray(objArr, i);
            }
            return i;
        }

        public final int size() {
            return this.multimap.size();
        }
    }
}
