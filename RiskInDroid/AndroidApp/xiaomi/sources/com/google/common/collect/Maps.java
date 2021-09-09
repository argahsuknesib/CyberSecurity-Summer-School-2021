package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import com.tencent.mmkv.MMKVRecoverStrategic;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collector;

@GwtCompatible(emulated = true)
public final class Maps {

    enum EntryFunction implements Function<Map.Entry<?, ?>, Object> {
        KEY {
            public final /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Map.Entry<?, ?>) ((Map.Entry) obj));
            }

            public final Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE {
            public final /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((Map.Entry<?, ?>) ((Map.Entry) obj));
            }

            public final Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }
    }

    @FunctionalInterface
    public interface EntryTransformer<K, V1, V2> {
        V2 transformEntry(Object obj, Object obj2);
    }

    private Maps() {
    }

    static <K> Function<Map.Entry<K, ?>, K> keyFunction() {
        return EntryFunction.KEY;
    }

    static <V> Function<Map.Entry<?, V>, V> valueFunction() {
        return EntryFunction.VALUE;
    }

    static <K, V> Iterator<K> keyIterator(Iterator<Map.Entry<K, V>> it) {
        return new TransformedIterator<Map.Entry<K, V>, K>(it) {
            /* class com.google.common.collect.Maps.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            public final K transform(Map.Entry<K, V> entry) {
                return entry.getKey();
            }
        };
    }

    static <K, V> Iterator<V> valueIterator(Iterator<Map.Entry<K, V>> it) {
        return new TransformedIterator<Map.Entry<K, V>, V>(it) {
            /* class com.google.common.collect.Maps.AnonymousClass2 */

            /* access modifiers changed from: package-private */
            public final V transform(Map.Entry<K, V> entry) {
                return entry.getValue();
            }
        };
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [java.lang.Enum, java.lang.Object]
     candidates:
      ClspMth{java.util.EnumMap.put(java.lang.Object, java.lang.Object):java.lang.Object}
      ClspMth{java.util.AbstractMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    @GwtCompatible(serializable = true)
    @Beta
    public static <K extends Enum<K>, V> ImmutableMap<K, V> immutableEnumMap(Map<K, ? extends V> map) {
        if (map instanceof ImmutableEnumMap) {
            return (ImmutableEnumMap) map;
        }
        Iterator<Map.Entry<K, ? extends V>> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return ImmutableMap.of();
        }
        Map.Entry next = it.next();
        Enum enumR = (Enum) next.getKey();
        Object value = next.getValue();
        CollectPreconditions.checkEntryNotNull(enumR, value);
        EnumMap enumMap = new EnumMap(enumR.getDeclaringClass());
        enumMap.put((MMKVRecoverStrategic) enumR, (Integer) value);
        while (it.hasNext()) {
            Map.Entry next2 = it.next();
            Enum enumR2 = (Enum) next2.getKey();
            Object value2 = next2.getValue();
            CollectPreconditions.checkEntryNotNull(enumR2, value2);
            enumMap.put((MMKVRecoverStrategic) enumR2, (Integer) value2);
        }
        return ImmutableEnumMap.asImmutable(enumMap);
    }

    static class Accumulator<K extends Enum<K>, V> {
        private EnumMap<K, V> map = null;
        private final BinaryOperator<V> mergeFunction;

        Accumulator(BinaryOperator<V> binaryOperator) {
            this.mergeFunction = binaryOperator;
        }

        /* access modifiers changed from: package-private */
        public void put(K k, V v) {
            if (this.map == null) {
                this.map = new EnumMap<>(k.getDeclaringClass());
            }
            this.map.merge(k, v, this.mergeFunction);
        }

        /* access modifiers changed from: package-private */
        public Accumulator<K, V> combine(Accumulator<K, V> accumulator) {
            if (this.map == null) {
                return accumulator;
            }
            EnumMap<K, V> enumMap = accumulator.map;
            if (enumMap == null) {
                return this;
            }
            enumMap.forEach(new BiConsumer() {
                /* class com.google.common.collect.$$Lambda$hkKTg4B5exFEdy3jyJzxEq9PjhI */

                public final void accept(Object obj, Object obj2) {
                    Maps.Accumulator.this.put((Enum) obj, obj2);
                }
            });
            return this;
        }

        /* access modifiers changed from: package-private */
        public ImmutableMap<K, V> toImmutableMap() {
            EnumMap<K, V> enumMap = this.map;
            return enumMap == null ? ImmutableMap.of() : ImmutableEnumMap.asImmutable(enumMap);
        }
    }

    @Beta
    public static <T, K extends Enum<K>, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableEnumMap(java.util.function.Function<? super T, ? extends K> function, java.util.function.Function<? super T, ? extends V> function2) {
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(function2);
        return Collector.of($$Lambda$Maps$sa2evLlNzG4l0daqnB_BZ6Hpk.INSTANCE, new BiConsumer(function, function2) {
            /* class com.google.common.collect.$$Lambda$Maps$SXEpF6E5Ua6Fh_ekkDo69PdfFe4 */
            private final /* synthetic */ java.util.function.Function f$0;
            private final /* synthetic */ java.util.function.Function f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void accept(Object obj, Object obj2) {
                ((Maps.Accumulator) obj).put((Enum) Preconditions.checkNotNull(this.f$0.apply(obj2), "Null key for input %s", obj2), Preconditions.checkNotNull(this.f$1.apply(obj2), "Null value for input %s", obj2));
            }
        }, $$Lambda$gr3P2nGL7W8VpcERw4klfzrPGXE.INSTANCE, $$Lambda$2o4X03rSa_8uE4aeQ0hIjzviXc.INSTANCE, Collector.Characteristics.UNORDERED);
    }

    static /* synthetic */ Accumulator lambda$toImmutableEnumMap$1() {
        return new Accumulator($$Lambda$Maps$v_qfPi_seRU9XAbxpmO5HO2iWM.INSTANCE);
    }

    static /* synthetic */ Object lambda$null$0(Object obj, Object obj2) {
        throw new IllegalArgumentException("Multiple values for key: " + obj + ", " + obj2);
    }

    @Beta
    public static <T, K extends Enum<K>, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableEnumMap(java.util.function.Function<? super T, ? extends K> function, java.util.function.Function<? super T, ? extends V> function2, BinaryOperator<V> binaryOperator) {
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(function2);
        Preconditions.checkNotNull(binaryOperator);
        return Collector.of(new Supplier(binaryOperator) {
            /* class com.google.common.collect.$$Lambda$Maps$c15SODvgGFHT_vXvnHXLrWlQx4 */
            private final /* synthetic */ BinaryOperator f$0;

            {
                this.f$0 = r1;
            }

            public final Object get() {
                return Maps.lambda$toImmutableEnumMap$3(this.f$0);
            }
        }, new BiConsumer(function, function2) {
            /* class com.google.common.collect.$$Lambda$Maps$48w8etaF9h3rLnn16gUMA3RPKk */
            private final /* synthetic */ java.util.function.Function f$0;
            private final /* synthetic */ java.util.function.Function f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void accept(Object obj, Object obj2) {
                ((Maps.Accumulator) obj).put((Enum) Preconditions.checkNotNull(this.f$0.apply(obj2), "Null key for input %s", obj2), Preconditions.checkNotNull(this.f$1.apply(obj2), "Null value for input %s", obj2));
            }
        }, $$Lambda$gr3P2nGL7W8VpcERw4klfzrPGXE.INSTANCE, $$Lambda$2o4X03rSa_8uE4aeQ0hIjzviXc.INSTANCE, new Collector.Characteristics[0]);
    }

    static /* synthetic */ Accumulator lambda$toImmutableEnumMap$3(BinaryOperator binaryOperator) {
        return new Accumulator(binaryOperator);
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> newHashMap(Map<? extends K, ? extends V> map) {
        return new HashMap<>(map);
    }

    public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int i) {
        return new HashMap<>(capacity(i));
    }

    static int capacity(int i) {
        if (i < 3) {
            CollectPreconditions.checkNonnegative(i, "expectedSize");
            return i + 1;
        } else if (i < 1073741824) {
            return (int) ((((float) i) / 0.75f) + 1.0f);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(Map<? extends K, ? extends V> map) {
        return new LinkedHashMap<>(map);
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int i) {
        return new LinkedHashMap<>(capacity(i));
    }

    public static <K, V> ConcurrentMap<K, V> newConcurrentMap() {
        return new ConcurrentHashMap();
    }

    public static <K extends Comparable, V> TreeMap<K, V> newTreeMap() {
        return new TreeMap<>();
    }

    public static <K, V> TreeMap<K, V> newTreeMap(SortedMap<K, ? extends V> sortedMap) {
        return new TreeMap<>((SortedMap) sortedMap);
    }

    public static <C, K extends C, V> TreeMap<K, V> newTreeMap(Comparator<C> comparator) {
        return new TreeMap<>(comparator);
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Class<K> cls) {
        return new EnumMap<>((Class) Preconditions.checkNotNull(cls));
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Map<K, ? extends V> map) {
        return new EnumMap<>(map);
    }

    public static <K, V> IdentityHashMap<K, V> newIdentityHashMap() {
        return new IdentityHashMap<>();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Maps.difference(java.util.SortedMap, java.util.Map):com.google.common.collect.SortedMapDifference<K, V>
     arg types: [java.util.SortedMap, java.util.Map<? extends K, ? extends V>]
     candidates:
      com.google.common.collect.Maps.difference(java.util.Map, java.util.Map):com.google.common.collect.MapDifference<K, V>
      com.google.common.collect.Maps.difference(java.util.SortedMap, java.util.Map):com.google.common.collect.SortedMapDifference<K, V> */
    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        if (map instanceof SortedMap) {
            return difference((SortedMap) map, (Map) map2);
        }
        return difference(map, map2, Equivalence.equals());
    }

    public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, Equivalence<? super V> equivalence) {
        Preconditions.checkNotNull(equivalence);
        LinkedHashMap newLinkedHashMap = newLinkedHashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap(map2);
        LinkedHashMap newLinkedHashMap2 = newLinkedHashMap();
        LinkedHashMap newLinkedHashMap3 = newLinkedHashMap();
        doDifference(map, map2, equivalence, newLinkedHashMap, linkedHashMap, newLinkedHashMap2, newLinkedHashMap3);
        return new MapDifferenceImpl(newLinkedHashMap, linkedHashMap, newLinkedHashMap2, newLinkedHashMap3);
    }

    public static <K, V> SortedMapDifference<K, V> difference(SortedMap<K, ? extends V> sortedMap, Map<? extends K, ? extends V> map) {
        Preconditions.checkNotNull(sortedMap);
        Preconditions.checkNotNull(map);
        Comparator<? super E> orNaturalOrder = orNaturalOrder(sortedMap.comparator());
        TreeMap<K, V> newTreeMap = newTreeMap(orNaturalOrder);
        TreeMap<K, V> newTreeMap2 = newTreeMap(orNaturalOrder);
        newTreeMap2.putAll(map);
        TreeMap<K, V> newTreeMap3 = newTreeMap(orNaturalOrder);
        TreeMap<K, V> newTreeMap4 = newTreeMap(orNaturalOrder);
        doDifference(sortedMap, map, Equivalence.equals(), newTreeMap, newTreeMap2, newTreeMap3, newTreeMap4);
        return new SortedMapDifferenceImpl(newTreeMap, newTreeMap2, newTreeMap3, newTreeMap4);
    }

    private static <K, V> void doDifference(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, Equivalence<? super V> equivalence, Map<K, V> map3, Map<K, V> map4, Map<K, V> map5, Map<K, MapDifference.ValueDifference<V>> map6) {
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            Object value = next.getValue();
            if (map2.containsKey(key)) {
                V remove = map4.remove(key);
                if (equivalence.equivalent(value, remove)) {
                    map5.put(key, value);
                } else {
                    map6.put(key, ValueDifferenceImpl.create(value, remove));
                }
            } else {
                map3.put(key, value);
            }
        }
    }

    public static <K, V> Map<K, V> unmodifiableMap(Map<K, ? extends V> map) {
        if (map instanceof SortedMap) {
            return Collections.unmodifiableSortedMap((SortedMap) map);
        }
        return Collections.unmodifiableMap(map);
    }

    static class MapDifferenceImpl<K, V> implements MapDifference<K, V> {
        final Map<K, MapDifference.ValueDifference<V>> differences;
        final Map<K, V> onBoth;
        final Map<K, V> onlyOnLeft;
        final Map<K, V> onlyOnRight;

        MapDifferenceImpl(Map<K, V> map, Map<K, V> map2, Map<K, V> map3, Map<K, MapDifference.ValueDifference<V>> map4) {
            this.onlyOnLeft = Maps.unmodifiableMap(map);
            this.onlyOnRight = Maps.unmodifiableMap(map2);
            this.onBoth = Maps.unmodifiableMap(map3);
            this.differences = Maps.unmodifiableMap(map4);
        }

        public boolean areEqual() {
            return this.onlyOnLeft.isEmpty() && this.onlyOnRight.isEmpty() && this.differences.isEmpty();
        }

        public Map<K, V> entriesOnlyOnLeft() {
            return this.onlyOnLeft;
        }

        public Map<K, V> entriesOnlyOnRight() {
            return this.onlyOnRight;
        }

        public Map<K, V> entriesInCommon() {
            return this.onBoth;
        }

        public Map<K, MapDifference.ValueDifference<V>> entriesDiffering() {
            return this.differences;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof MapDifference) {
                MapDifference mapDifference = (MapDifference) obj;
                return entriesOnlyOnLeft().equals(mapDifference.entriesOnlyOnLeft()) && entriesOnlyOnRight().equals(mapDifference.entriesOnlyOnRight()) && entriesInCommon().equals(mapDifference.entriesInCommon()) && entriesDiffering().equals(mapDifference.entriesDiffering());
            }
        }

        public int hashCode() {
            return Objects.hashCode(entriesOnlyOnLeft(), entriesOnlyOnRight(), entriesInCommon(), entriesDiffering());
        }

        public String toString() {
            if (areEqual()) {
                return "equal";
            }
            StringBuilder sb = new StringBuilder("not equal");
            if (!this.onlyOnLeft.isEmpty()) {
                sb.append(": only on left=");
                sb.append(this.onlyOnLeft);
            }
            if (!this.onlyOnRight.isEmpty()) {
                sb.append(": only on right=");
                sb.append(this.onlyOnRight);
            }
            if (!this.differences.isEmpty()) {
                sb.append(": value differences=");
                sb.append(this.differences);
            }
            return sb.toString();
        }
    }

    static class ValueDifferenceImpl<V> implements MapDifference.ValueDifference<V> {
        private final V left;
        private final V right;

        static <V> MapDifference.ValueDifference<V> create(V v, V v2) {
            return new ValueDifferenceImpl(v, v2);
        }

        private ValueDifferenceImpl(V v, V v2) {
            this.left = v;
            this.right = v2;
        }

        public V leftValue() {
            return this.left;
        }

        public V rightValue() {
            return this.right;
        }

        public boolean equals(Object obj) {
            if (obj instanceof MapDifference.ValueDifference) {
                MapDifference.ValueDifference valueDifference = (MapDifference.ValueDifference) obj;
                if (!Objects.equal(this.left, valueDifference.leftValue()) || !Objects.equal(this.right, valueDifference.rightValue())) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.left, this.right);
        }

        public String toString() {
            return "(" + ((Object) this.left) + ", " + ((Object) this.right) + ")";
        }
    }

    static class SortedMapDifferenceImpl<K, V> extends MapDifferenceImpl<K, V> implements SortedMapDifference<K, V> {
        SortedMapDifferenceImpl(SortedMap<K, V> sortedMap, SortedMap<K, V> sortedMap2, SortedMap<K, V> sortedMap3, SortedMap<K, MapDifference.ValueDifference<V>> sortedMap4) {
            super(sortedMap, sortedMap2, sortedMap3, sortedMap4);
        }

        public SortedMap<K, MapDifference.ValueDifference<V>> entriesDiffering() {
            return (SortedMap) super.entriesDiffering();
        }

        public SortedMap<K, V> entriesInCommon() {
            return (SortedMap) super.entriesInCommon();
        }

        public SortedMap<K, V> entriesOnlyOnLeft() {
            return (SortedMap) super.entriesOnlyOnLeft();
        }

        public SortedMap<K, V> entriesOnlyOnRight() {
            return (SortedMap) super.entriesOnlyOnRight();
        }
    }

    static <E> Comparator<? super E> orNaturalOrder(Comparator<? super E> comparator) {
        return comparator != null ? comparator : Ordering.natural();
    }

    public static <K, V> Map<K, V> asMap(Set<K> set, Function<? super K, V> function) {
        return new AsMapView(set, function);
    }

    public static <K, V> SortedMap<K, V> asMap(SortedSet<K> sortedSet, Function<? super K, V> function) {
        return new SortedAsMapView(sortedSet, function);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> asMap(NavigableSet<K> navigableSet, Function<? super K, V> function) {
        return new NavigableAsMapView(navigableSet, function);
    }

    static class AsMapView<K, V> extends ViewCachingAbstractMap<K, V> {
        final Function<? super K, V> function;
        private final Set<K> set;

        /* access modifiers changed from: package-private */
        public Set<K> backingSet() {
            return this.set;
        }

        AsMapView(Set<K> set2, Function<? super K, V> function2) {
            this.set = (Set) Preconditions.checkNotNull(set2);
            this.function = (Function) Preconditions.checkNotNull(function2);
        }

        public Set<K> createKeySet() {
            return Maps.removeOnlySet(backingSet());
        }

        /* access modifiers changed from: package-private */
        public Collection<V> createValues() {
            return Collections2.transform(this.set, this.function);
        }

        public int size() {
            return backingSet().size();
        }

        public boolean containsKey(Object obj) {
            return backingSet().contains(obj);
        }

        public V get(Object obj) {
            return getOrDefault(obj, null);
        }

        public V getOrDefault(Object obj, V v) {
            return Collections2.safeContains(backingSet(), obj) ? this.function.apply(obj) : v;
        }

        public V remove(Object obj) {
            if (backingSet().remove(obj)) {
                return this.function.apply(obj);
            }
            return null;
        }

        public void clear() {
            backingSet().clear();
        }

        /* access modifiers changed from: protected */
        public Set<Map.Entry<K, V>> createEntrySet() {
            return new EntrySet<K, V>() {
                /* class com.google.common.collect.Maps.AsMapView.AnonymousClass1EntrySetImpl */

                /* access modifiers changed from: package-private */
                public Map<K, V> map() {
                    return AsMapView.this;
                }

                public Iterator<Map.Entry<K, V>> iterator() {
                    return Maps.asMapEntryIterator(AsMapView.this.backingSet(), AsMapView.this.function);
                }
            };
        }

        public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
            Preconditions.checkNotNull(biConsumer);
            backingSet().forEach(new Consumer(biConsumer) {
                /* class com.google.common.collect.$$Lambda$Maps$AsMapView$g9v_3LymatxQlAQeGCWPUc7zVo */
                private final /* synthetic */ BiConsumer f$1;

                {
                    this.f$1 = r2;
                }

                public final void accept(Object obj) {
                    Maps.AsMapView.this.lambda$forEach$0$Maps$AsMapView(this.f$1, obj);
                }
            });
        }

        public /* synthetic */ void lambda$forEach$0$Maps$AsMapView(BiConsumer biConsumer, Object obj) {
            biConsumer.accept(obj, this.function.apply(obj));
        }
    }

    static <K, V> Iterator<Map.Entry<K, V>> asMapEntryIterator(Set<K> set, final Function<? super K, V> function) {
        return new TransformedIterator<K, Map.Entry<K, V>>(set.iterator()) {
            /* class com.google.common.collect.Maps.AnonymousClass3 */

            /* access modifiers changed from: package-private */
            public final Map.Entry<K, V> transform(K k) {
                return Maps.immutableEntry(k, function.apply(k));
            }
        };
    }

    static class SortedAsMapView<K, V> extends AsMapView<K, V> implements SortedMap<K, V> {
        SortedAsMapView(SortedSet<K> sortedSet, Function<? super K, V> function) {
            super(sortedSet, function);
        }

        /* access modifiers changed from: package-private */
        public SortedSet<K> backingSet() {
            return (SortedSet) super.backingSet();
        }

        public Comparator<? super K> comparator() {
            return backingSet().comparator();
        }

        public Set<K> keySet() {
            return Maps.removeOnlySortedSet(backingSet());
        }

        public SortedMap<K, V> subMap(K k, K k2) {
            return Maps.asMap(backingSet().subSet(k, k2), this.function);
        }

        public SortedMap<K, V> headMap(K k) {
            return Maps.asMap(backingSet().headSet(k), this.function);
        }

        public SortedMap<K, V> tailMap(K k) {
            return Maps.asMap(backingSet().tailSet(k), this.function);
        }

        public K firstKey() {
            return backingSet().first();
        }

        public K lastKey() {
            return backingSet().last();
        }
    }

    @GwtIncompatible
    static final class NavigableAsMapView<K, V> extends AbstractNavigableMap<K, V> {
        private final Function<? super K, V> function;
        private final NavigableSet<K> set;

        NavigableAsMapView(NavigableSet<K> navigableSet, Function<? super K, V> function2) {
            this.set = (NavigableSet) Preconditions.checkNotNull(navigableSet);
            this.function = (Function) Preconditions.checkNotNull(function2);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.Maps.asMap(java.util.NavigableSet, com.google.common.base.Function):java.util.NavigableMap<K, V>
         arg types: [java.util.NavigableSet<K>, com.google.common.base.Function<? super K, V>]
         candidates:
          com.google.common.collect.Maps.asMap(java.util.Set, com.google.common.base.Function):java.util.Map<K, V>
          com.google.common.collect.Maps.asMap(java.util.SortedSet, com.google.common.base.Function):java.util.SortedMap<K, V>
          com.google.common.collect.Maps.asMap(java.util.NavigableSet, com.google.common.base.Function):java.util.NavigableMap<K, V> */
        public final NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return Maps.asMap((NavigableSet) this.set.subSet(k, z, k2, z2), (Function) this.function);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.Maps.asMap(java.util.NavigableSet, com.google.common.base.Function):java.util.NavigableMap<K, V>
         arg types: [java.util.NavigableSet<K>, com.google.common.base.Function<? super K, V>]
         candidates:
          com.google.common.collect.Maps.asMap(java.util.Set, com.google.common.base.Function):java.util.Map<K, V>
          com.google.common.collect.Maps.asMap(java.util.SortedSet, com.google.common.base.Function):java.util.SortedMap<K, V>
          com.google.common.collect.Maps.asMap(java.util.NavigableSet, com.google.common.base.Function):java.util.NavigableMap<K, V> */
        public final NavigableMap<K, V> headMap(K k, boolean z) {
            return Maps.asMap((NavigableSet) this.set.headSet(k, z), (Function) this.function);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.Maps.asMap(java.util.NavigableSet, com.google.common.base.Function):java.util.NavigableMap<K, V>
         arg types: [java.util.NavigableSet<K>, com.google.common.base.Function<? super K, V>]
         candidates:
          com.google.common.collect.Maps.asMap(java.util.Set, com.google.common.base.Function):java.util.Map<K, V>
          com.google.common.collect.Maps.asMap(java.util.SortedSet, com.google.common.base.Function):java.util.SortedMap<K, V>
          com.google.common.collect.Maps.asMap(java.util.NavigableSet, com.google.common.base.Function):java.util.NavigableMap<K, V> */
        public final NavigableMap<K, V> tailMap(K k, boolean z) {
            return Maps.asMap((NavigableSet) this.set.tailSet(k, z), (Function) this.function);
        }

        public final Comparator<? super K> comparator() {
            return this.set.comparator();
        }

        public final V get(Object obj) {
            return getOrDefault(obj, null);
        }

        public final V getOrDefault(Object obj, V v) {
            return Collections2.safeContains(this.set, obj) ? this.function.apply(obj) : v;
        }

        public final void clear() {
            this.set.clear();
        }

        /* access modifiers changed from: package-private */
        public final Iterator<Map.Entry<K, V>> entryIterator() {
            return Maps.asMapEntryIterator(this.set, this.function);
        }

        /* access modifiers changed from: package-private */
        public final Spliterator<Map.Entry<K, V>> entrySpliterator() {
            return CollectSpliterators.map(this.set.spliterator(), new java.util.function.Function() {
                /* class com.google.common.collect.$$Lambda$Maps$NavigableAsMapView$QeEZAvsa2ozSjUesNqR6GTod3pc */

                public final Object apply(Object obj) {
                    return Maps.NavigableAsMapView.this.lambda$entrySpliterator$0$Maps$NavigableAsMapView(obj);
                }
            });
        }

        public /* synthetic */ Map.Entry lambda$entrySpliterator$0$Maps$NavigableAsMapView(Object obj) {
            return Maps.immutableEntry(obj, this.function.apply(obj));
        }

        public final void forEach(BiConsumer<? super K, ? super V> biConsumer) {
            this.set.forEach(new Consumer(biConsumer) {
                /* class com.google.common.collect.$$Lambda$Maps$NavigableAsMapView$lRvrJKxSd5i76WJW8HMI3Rub_mQ */
                private final /* synthetic */ BiConsumer f$1;

                {
                    this.f$1 = r2;
                }

                public final void accept(Object obj) {
                    Maps.NavigableAsMapView.this.lambda$forEach$1$Maps$NavigableAsMapView(this.f$1, obj);
                }
            });
        }

        public /* synthetic */ void lambda$forEach$1$Maps$NavigableAsMapView(BiConsumer biConsumer, Object obj) {
            biConsumer.accept(obj, this.function.apply(obj));
        }

        /* access modifiers changed from: package-private */
        public final Iterator<Map.Entry<K, V>> descendingEntryIterator() {
            return descendingMap().entrySet().iterator();
        }

        public final NavigableSet<K> navigableKeySet() {
            return Maps.removeOnlyNavigableSet(this.set);
        }

        public final int size() {
            return this.set.size();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.Maps.asMap(java.util.NavigableSet, com.google.common.base.Function):java.util.NavigableMap<K, V>
         arg types: [java.util.NavigableSet<K>, com.google.common.base.Function<? super K, V>]
         candidates:
          com.google.common.collect.Maps.asMap(java.util.Set, com.google.common.base.Function):java.util.Map<K, V>
          com.google.common.collect.Maps.asMap(java.util.SortedSet, com.google.common.base.Function):java.util.SortedMap<K, V>
          com.google.common.collect.Maps.asMap(java.util.NavigableSet, com.google.common.base.Function):java.util.NavigableMap<K, V> */
        public final NavigableMap<K, V> descendingMap() {
            return Maps.asMap((NavigableSet) this.set.descendingSet(), (Function) this.function);
        }
    }

    public static <E> Set<E> removeOnlySet(final Set<E> set) {
        return new ForwardingSet<E>() {
            /* class com.google.common.collect.Maps.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public final Set<E> delegate() {
                return set;
            }

            public final boolean add(E e) {
                throw new UnsupportedOperationException();
            }

            public final boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static <E> SortedSet<E> removeOnlySortedSet(final SortedSet<E> sortedSet) {
        return new ForwardingSortedSet<E>() {
            /* class com.google.common.collect.Maps.AnonymousClass5 */

            /* access modifiers changed from: protected */
            public final SortedSet<E> delegate() {
                return sortedSet;
            }

            public final boolean add(E e) {
                throw new UnsupportedOperationException();
            }

            public final boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }

            public final SortedSet<E> headSet(E e) {
                return Maps.removeOnlySortedSet(super.headSet(e));
            }

            public final SortedSet<E> subSet(E e, E e2) {
                return Maps.removeOnlySortedSet(super.subSet(e, e2));
            }

            public final SortedSet<E> tailSet(E e) {
                return Maps.removeOnlySortedSet(super.tailSet(e));
            }
        };
    }

    @GwtIncompatible
    public static <E> NavigableSet<E> removeOnlyNavigableSet(final NavigableSet<E> navigableSet) {
        return new ForwardingNavigableSet<E>() {
            /* class com.google.common.collect.Maps.AnonymousClass6 */

            /* access modifiers changed from: protected */
            public final NavigableSet<E> delegate() {
                return navigableSet;
            }

            public final boolean add(E e) {
                throw new UnsupportedOperationException();
            }

            public final boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }

            public final SortedSet<E> headSet(E e) {
                return Maps.removeOnlySortedSet(super.headSet(e));
            }

            public final NavigableSet<E> headSet(E e, boolean z) {
                return Maps.removeOnlyNavigableSet(super.headSet(e, z));
            }

            public final SortedSet<E> subSet(E e, E e2) {
                return Maps.removeOnlySortedSet(super.subSet(e, e2));
            }

            public final NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
                return Maps.removeOnlyNavigableSet(super.subSet(e, z, e2, z2));
            }

            public final SortedSet<E> tailSet(E e) {
                return Maps.removeOnlySortedSet(super.tailSet(e));
            }

            public final NavigableSet<E> tailSet(E e, boolean z) {
                return Maps.removeOnlyNavigableSet(super.tailSet(e, z));
            }

            public final NavigableSet<E> descendingSet() {
                return Maps.removeOnlyNavigableSet(super.descendingSet());
            }
        };
    }

    public static <K, V> ImmutableMap<K, V> toMap(Iterable iterable, Function function) {
        return toMap(iterable.iterator(), function);
    }

    public static <K, V> ImmutableMap<K, V> toMap(Iterator it, Function function) {
        Preconditions.checkNotNull(function);
        LinkedHashMap newLinkedHashMap = newLinkedHashMap();
        while (it.hasNext()) {
            Object next = it.next();
            newLinkedHashMap.put(next, function.apply(next));
        }
        return ImmutableMap.copyOf(newLinkedHashMap);
    }

    @CanIgnoreReturnValue
    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterable iterable, Function function) {
        return uniqueIndex(iterable.iterator(), function);
    }

    @CanIgnoreReturnValue
    public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterator it, Function function) {
        Preconditions.checkNotNull(function);
        ImmutableMap.Builder builder = ImmutableMap.builder();
        while (it.hasNext()) {
            Object next = it.next();
            builder.put(function.apply(next), next);
        }
        try {
            return builder.build();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage() + ". To index multiple values under a key, use Multimaps.index.");
        }
    }

    @GwtIncompatible
    public static ImmutableMap<String, String> fromProperties(Properties properties) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            builder.put(str, properties.getProperty(str));
        }
        return builder.build();
    }

    @GwtCompatible(serializable = true)
    public static <K, V> Map.Entry<K, V> immutableEntry(K k, V v) {
        return new ImmutableEntry(k, v);
    }

    static <K, V> Set<Map.Entry<K, V>> unmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
        return new UnmodifiableEntrySet(Collections.unmodifiableSet(set));
    }

    static <K, V> Map.Entry<K, V> unmodifiableEntry(final Map.Entry<? extends K, ? extends V> entry) {
        Preconditions.checkNotNull(entry);
        return new AbstractMapEntry<K, V>() {
            /* class com.google.common.collect.Maps.AnonymousClass7 */

            public final K getKey() {
                return entry.getKey();
            }

            public final V getValue() {
                return entry.getValue();
            }
        };
    }

    static <K, V> UnmodifiableIterator<Map.Entry<K, V>> unmodifiableEntryIterator(final Iterator<Map.Entry<K, V>> it) {
        return new UnmodifiableIterator<Map.Entry<K, V>>() {
            /* class com.google.common.collect.Maps.AnonymousClass8 */

            public final boolean hasNext() {
                return it.hasNext();
            }

            public final Map.Entry<K, V> next() {
                return Maps.unmodifiableEntry((Map.Entry) it.next());
            }
        };
    }

    static class UnmodifiableEntries<K, V> extends ForwardingCollection<Map.Entry<K, V>> {
        private final Collection<Map.Entry<K, V>> entries;

        UnmodifiableEntries(Collection<Map.Entry<K, V>> collection) {
            this.entries = collection;
        }

        /* access modifiers changed from: protected */
        public Collection<Map.Entry<K, V>> delegate() {
            return this.entries;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return Maps.unmodifiableEntryIterator(this.entries.iterator());
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return standardToArray(tArr);
        }
    }

    static class UnmodifiableEntrySet<K, V> extends UnmodifiableEntries<K, V> implements Set<Map.Entry<K, V>> {
        UnmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
            super(set);
        }

        public boolean equals(Object obj) {
            return Sets.equalsImpl(this, obj);
        }

        public int hashCode() {
            return Sets.hashCodeImpl(this);
        }
    }

    @Beta
    public static <A, B> Converter<A, B> asConverter(BiMap<A, B> biMap) {
        return new BiMapConverter(biMap);
    }

    static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final BiMap<A, B> bimap;

        BiMapConverter(BiMap<A, B> biMap) {
            this.bimap = (BiMap) Preconditions.checkNotNull(biMap);
        }

        public final B doForward(A a2) {
            return convert(this.bimap, a2);
        }

        public final A doBackward(B b) {
            return convert(this.bimap.inverse(), b);
        }

        private static <X, Y> Y convert(BiMap<X, Y> biMap, X x) {
            Y y = biMap.get(x);
            Preconditions.checkArgument(y != null, "No non-null mapping present for input: %s", x);
            return y;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof BiMapConverter) {
                return this.bimap.equals(((BiMapConverter) obj).bimap);
            }
            return false;
        }

        public final int hashCode() {
            return this.bimap.hashCode();
        }

        public final String toString() {
            return "Maps.asConverter(" + this.bimap + ")";
        }
    }

    public static <K, V> BiMap<K, V> synchronizedBiMap(BiMap<K, V> biMap) {
        return Synchronized.biMap(biMap, null);
    }

    public static <K, V> BiMap<K, V> unmodifiableBiMap(BiMap<? extends K, ? extends V> biMap) {
        return new UnmodifiableBiMap(biMap, null);
    }

    static class UnmodifiableBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final BiMap<? extends K, ? extends V> delegate;
        @RetainedWith
        BiMap<V, K> inverse;
        final Map<K, V> unmodifiableMap;
        transient Set<V> values;

        UnmodifiableBiMap(BiMap<? extends K, ? extends V> biMap, BiMap<V, K> biMap2) {
            this.unmodifiableMap = Collections.unmodifiableMap(biMap);
            this.delegate = biMap;
            this.inverse = biMap2;
        }

        /* access modifiers changed from: protected */
        public Map<K, V> delegate() {
            return this.unmodifiableMap;
        }

        public V forcePut(K k, V v) {
            throw new UnsupportedOperationException();
        }

        public BiMap<V, K> inverse() {
            BiMap<V, K> biMap = this.inverse;
            if (biMap != null) {
                return biMap;
            }
            UnmodifiableBiMap unmodifiableBiMap = new UnmodifiableBiMap(this.delegate.inverse(), this);
            this.inverse = unmodifiableBiMap;
            return unmodifiableBiMap;
        }

        public Set<V> values() {
            Set<V> set = this.values;
            if (set != null) {
                return set;
            }
            Set<V> unmodifiableSet = Collections.unmodifiableSet(this.delegate.values());
            this.values = unmodifiableSet;
            return unmodifiableSet;
        }
    }

    public static <K, V1, V2> Map<K, V2> transformValues(Map map, Function function) {
        return transformEntries(map, asEntryTransformer(function));
    }

    public static <K, V1, V2> SortedMap<K, V2> transformValues(SortedMap sortedMap, Function function) {
        return transformEntries(sortedMap, asEntryTransformer(function));
    }

    @GwtIncompatible
    public static <K, V1, V2> NavigableMap<K, V2> transformValues(NavigableMap navigableMap, Function function) {
        return transformEntries(navigableMap, asEntryTransformer(function));
    }

    public static <K, V1, V2> Map<K, V2> transformEntries(Map map, EntryTransformer entryTransformer) {
        return new TransformedEntriesMap(map, entryTransformer);
    }

    public static <K, V1, V2> SortedMap<K, V2> transformEntries(SortedMap sortedMap, EntryTransformer entryTransformer) {
        return new TransformedEntriesSortedMap(sortedMap, entryTransformer);
    }

    @GwtIncompatible
    public static <K, V1, V2> NavigableMap<K, V2> transformEntries(NavigableMap navigableMap, EntryTransformer entryTransformer) {
        return new TransformedEntriesNavigableMap(navigableMap, entryTransformer);
    }

    static <K, V1, V2> EntryTransformer<K, V1, V2> asEntryTransformer(final Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return new EntryTransformer<K, V1, V2>() {
            /* class com.google.common.collect.Maps.AnonymousClass9 */

            public final V2 transformEntry(K k, V1 v1) {
                return function.apply(v1);
            }
        };
    }

    static <K, V1, V2> Function<V1, V2> asValueToValueFunction(final EntryTransformer<? super K, V1, V2> entryTransformer, final K k) {
        Preconditions.checkNotNull(entryTransformer);
        return new Function<V1, V2>() {
            /* class com.google.common.collect.Maps.AnonymousClass10 */

            public final V2 apply(V1 v1) {
                return entryTransformer.transformEntry(k, v1);
            }
        };
    }

    static <K, V1, V2> Function<Map.Entry<K, V1>, V2> asEntryToValueFunction(final EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        Preconditions.checkNotNull(entryTransformer);
        return new Function<Map.Entry<K, V1>, V2>() {
            /* class com.google.common.collect.Maps.AnonymousClass11 */

            public final V2 apply(Map.Entry<K, V1> entry) {
                return entryTransformer.transformEntry(entry.getKey(), entry.getValue());
            }
        };
    }

    static <V2, K, V1> Map.Entry<K, V2> transformEntry(final EntryTransformer<? super K, ? super V1, V2> entryTransformer, final Map.Entry<K, V1> entry) {
        Preconditions.checkNotNull(entryTransformer);
        Preconditions.checkNotNull(entry);
        return new AbstractMapEntry<K, V2>() {
            /* class com.google.common.collect.Maps.AnonymousClass12 */

            public final K getKey() {
                return entry.getKey();
            }

            public final V2 getValue() {
                return entryTransformer.transformEntry(entry.getKey(), entry.getValue());
            }
        };
    }

    static <K, V1, V2> Function<Map.Entry<K, V1>, Map.Entry<K, V2>> asEntryToEntryFunction(final EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        Preconditions.checkNotNull(entryTransformer);
        return new Function<Map.Entry<K, V1>, Map.Entry<K, V2>>() {
            /* class com.google.common.collect.Maps.AnonymousClass13 */

            public final Map.Entry<K, V2> apply(Map.Entry<K, V1> entry) {
                return Maps.transformEntry(entryTransformer, entry);
            }
        };
    }

    static class TransformedEntriesMap<K, V1, V2> extends IteratorBasedAbstractMap<K, V2> {
        final Map<K, V1> fromMap;
        final EntryTransformer<? super K, ? super V1, V2> transformer;

        TransformedEntriesMap(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            this.fromMap = (Map) Preconditions.checkNotNull(map);
            this.transformer = (EntryTransformer) Preconditions.checkNotNull(entryTransformer);
        }

        public int size() {
            return this.fromMap.size();
        }

        public boolean containsKey(Object obj) {
            return this.fromMap.containsKey(obj);
        }

        public V2 get(Object obj) {
            return getOrDefault(obj, null);
        }

        public V2 getOrDefault(Object obj, V2 v2) {
            V1 v1 = this.fromMap.get(obj);
            if (v1 != null || this.fromMap.containsKey(obj)) {
                return this.transformer.transformEntry(obj, v1);
            }
            return v2;
        }

        public V2 remove(Object obj) {
            if (this.fromMap.containsKey(obj)) {
                return this.transformer.transformEntry(obj, this.fromMap.remove(obj));
            }
            return null;
        }

        public void clear() {
            this.fromMap.clear();
        }

        public Set<K> keySet() {
            return this.fromMap.keySet();
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V2>> entryIterator() {
            return Iterators.transform(this.fromMap.entrySet().iterator(), Maps.asEntryToEntryFunction(this.transformer));
        }

        /* access modifiers changed from: package-private */
        public Spliterator<Map.Entry<K, V2>> entrySpliterator() {
            return CollectSpliterators.map(this.fromMap.entrySet().spliterator(), Maps.asEntryToEntryFunction(this.transformer));
        }

        public void forEach(BiConsumer<? super K, ? super V2> biConsumer) {
            Preconditions.checkNotNull(biConsumer);
            this.fromMap.forEach(new BiConsumer(biConsumer) {
                /* class com.google.common.collect.$$Lambda$Maps$TransformedEntriesMap$pyPQciuq7_6Ffsb2Rp0dfufM0ng */
                private final /* synthetic */ BiConsumer f$1;

                {
                    this.f$1 = r2;
                }

                public final void accept(Object obj, Object obj2) {
                    Maps.TransformedEntriesMap.this.lambda$forEach$0$Maps$TransformedEntriesMap(this.f$1, obj, obj2);
                }
            });
        }

        public /* synthetic */ void lambda$forEach$0$Maps$TransformedEntriesMap(BiConsumer biConsumer, Object obj, Object obj2) {
            biConsumer.accept(obj, this.transformer.transformEntry(obj, obj2));
        }

        public Collection<V2> values() {
            return new Values(this);
        }
    }

    static class TransformedEntriesSortedMap<K, V1, V2> extends TransformedEntriesMap<K, V1, V2> implements SortedMap<K, V2> {
        /* access modifiers changed from: protected */
        public SortedMap<K, V1> fromMap() {
            return (SortedMap) this.fromMap;
        }

        TransformedEntriesSortedMap(SortedMap<K, V1> sortedMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(sortedMap, entryTransformer);
        }

        public Comparator<? super K> comparator() {
            return fromMap().comparator();
        }

        public K firstKey() {
            return fromMap().firstKey();
        }

        public SortedMap<K, V2> headMap(K k) {
            return Maps.transformEntries(fromMap().headMap(k), this.transformer);
        }

        public K lastKey() {
            return fromMap().lastKey();
        }

        public SortedMap<K, V2> subMap(K k, K k2) {
            return Maps.transformEntries(fromMap().subMap(k, k2), this.transformer);
        }

        public SortedMap<K, V2> tailMap(K k) {
            return Maps.transformEntries(fromMap().tailMap(k), this.transformer);
        }
    }

    @GwtIncompatible
    static class TransformedEntriesNavigableMap<K, V1, V2> extends TransformedEntriesSortedMap<K, V1, V2> implements NavigableMap<K, V2> {
        TransformedEntriesNavigableMap(NavigableMap<K, V1> navigableMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(navigableMap, entryTransformer);
        }

        public Map.Entry<K, V2> ceilingEntry(K k) {
            return transformEntry(fromMap().ceilingEntry(k));
        }

        public K ceilingKey(K k) {
            return fromMap().ceilingKey(k);
        }

        public NavigableSet<K> descendingKeySet() {
            return fromMap().descendingKeySet();
        }

        public NavigableMap<K, V2> descendingMap() {
            return Maps.transformEntries(fromMap().descendingMap(), this.transformer);
        }

        public Map.Entry<K, V2> firstEntry() {
            return transformEntry(fromMap().firstEntry());
        }

        public Map.Entry<K, V2> floorEntry(K k) {
            return transformEntry(fromMap().floorEntry(k));
        }

        public K floorKey(K k) {
            return fromMap().floorKey(k);
        }

        public NavigableMap<K, V2> headMap(K k) {
            return headMap(k, false);
        }

        public NavigableMap<K, V2> headMap(K k, boolean z) {
            return Maps.transformEntries(fromMap().headMap(k, z), this.transformer);
        }

        public Map.Entry<K, V2> higherEntry(K k) {
            return transformEntry(fromMap().higherEntry(k));
        }

        public K higherKey(K k) {
            return fromMap().higherKey(k);
        }

        public Map.Entry<K, V2> lastEntry() {
            return transformEntry(fromMap().lastEntry());
        }

        public Map.Entry<K, V2> lowerEntry(K k) {
            return transformEntry(fromMap().lowerEntry(k));
        }

        public K lowerKey(K k) {
            return fromMap().lowerKey(k);
        }

        public NavigableSet<K> navigableKeySet() {
            return fromMap().navigableKeySet();
        }

        public Map.Entry<K, V2> pollFirstEntry() {
            return transformEntry(fromMap().pollFirstEntry());
        }

        public Map.Entry<K, V2> pollLastEntry() {
            return transformEntry(fromMap().pollLastEntry());
        }

        public NavigableMap<K, V2> subMap(K k, boolean z, K k2, boolean z2) {
            return Maps.transformEntries(fromMap().subMap(k, z, k2, z2), this.transformer);
        }

        public NavigableMap<K, V2> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        public NavigableMap<K, V2> tailMap(K k) {
            return tailMap(k, true);
        }

        public NavigableMap<K, V2> tailMap(K k, boolean z) {
            return Maps.transformEntries(fromMap().tailMap(k, z), this.transformer);
        }

        private Map.Entry<K, V2> transformEntry(Map.Entry<K, V1> entry) {
            if (entry == null) {
                return null;
            }
            return Maps.transformEntry(this.transformer, entry);
        }

        /* access modifiers changed from: protected */
        public NavigableMap<K, V1> fromMap() {
            return (NavigableMap) super.fromMap();
        }
    }

    static <K> Predicate<Map.Entry<K, ?>> keyPredicateOnEntries(Predicate<? super K> predicate) {
        return Predicates.compose(predicate, keyFunction());
    }

    static <V> Predicate<Map.Entry<?, V>> valuePredicateOnEntries(Predicate<? super V> predicate) {
        return Predicates.compose(predicate, valueFunction());
    }

    public static <K, V> Map<K, V> filterKeys(Map<K, V> map, Predicate<? super K> predicate) {
        Preconditions.checkNotNull(predicate);
        Predicate<Map.Entry<K, ?>> keyPredicateOnEntries = keyPredicateOnEntries(predicate);
        if (map instanceof AbstractFilteredMap) {
            return filterFiltered((AbstractFilteredMap) map, keyPredicateOnEntries);
        }
        return new FilteredKeyMap((Map) Preconditions.checkNotNull(map), predicate, keyPredicateOnEntries);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Maps.filterEntries(java.util.SortedMap, com.google.common.base.Predicate):java.util.SortedMap<K, V>
     arg types: [java.util.SortedMap<K, V>, com.google.common.base.Predicate<java.util.Map$Entry<K, ?>>]
     candidates:
      com.google.common.collect.Maps.filterEntries(com.google.common.collect.BiMap, com.google.common.base.Predicate):com.google.common.collect.BiMap<K, V>
      com.google.common.collect.Maps.filterEntries(java.util.Map, com.google.common.base.Predicate):java.util.Map<K, V>
      com.google.common.collect.Maps.filterEntries(java.util.NavigableMap, com.google.common.base.Predicate):java.util.NavigableMap<K, V>
      com.google.common.collect.Maps.filterEntries(java.util.SortedMap, com.google.common.base.Predicate):java.util.SortedMap<K, V> */
    public static <K, V> SortedMap<K, V> filterKeys(SortedMap<K, V> sortedMap, Predicate<? super K> predicate) {
        return filterEntries((SortedMap) sortedMap, (Predicate) keyPredicateOnEntries(predicate));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Maps.filterEntries(java.util.NavigableMap, com.google.common.base.Predicate):java.util.NavigableMap<K, V>
     arg types: [java.util.NavigableMap<K, V>, com.google.common.base.Predicate<java.util.Map$Entry<K, ?>>]
     candidates:
      com.google.common.collect.Maps.filterEntries(com.google.common.collect.BiMap, com.google.common.base.Predicate):com.google.common.collect.BiMap<K, V>
      com.google.common.collect.Maps.filterEntries(java.util.Map, com.google.common.base.Predicate):java.util.Map<K, V>
      com.google.common.collect.Maps.filterEntries(java.util.SortedMap, com.google.common.base.Predicate):java.util.SortedMap<K, V>
      com.google.common.collect.Maps.filterEntries(java.util.NavigableMap, com.google.common.base.Predicate):java.util.NavigableMap<K, V> */
    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> filterKeys(NavigableMap<K, V> navigableMap, Predicate<? super K> predicate) {
        return filterEntries((NavigableMap) navigableMap, (Predicate) keyPredicateOnEntries(predicate));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Maps.filterEntries(com.google.common.collect.BiMap, com.google.common.base.Predicate):com.google.common.collect.BiMap<K, V>
     arg types: [com.google.common.collect.BiMap<K, V>, com.google.common.base.Predicate<java.util.Map$Entry<K, ?>>]
     candidates:
      com.google.common.collect.Maps.filterEntries(java.util.Map, com.google.common.base.Predicate):java.util.Map<K, V>
      com.google.common.collect.Maps.filterEntries(java.util.NavigableMap, com.google.common.base.Predicate):java.util.NavigableMap<K, V>
      com.google.common.collect.Maps.filterEntries(java.util.SortedMap, com.google.common.base.Predicate):java.util.SortedMap<K, V>
      com.google.common.collect.Maps.filterEntries(com.google.common.collect.BiMap, com.google.common.base.Predicate):com.google.common.collect.BiMap<K, V> */
    public static <K, V> BiMap<K, V> filterKeys(BiMap<K, V> biMap, Predicate<? super K> predicate) {
        Preconditions.checkNotNull(predicate);
        return filterEntries((BiMap) biMap, (Predicate) keyPredicateOnEntries(predicate));
    }

    public static <K, V> Map<K, V> filterValues(Map<K, V> map, Predicate<? super V> predicate) {
        return filterEntries(map, valuePredicateOnEntries(predicate));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Maps.filterEntries(java.util.SortedMap, com.google.common.base.Predicate):java.util.SortedMap<K, V>
     arg types: [java.util.SortedMap<K, V>, com.google.common.base.Predicate<java.util.Map$Entry<?, V>>]
     candidates:
      com.google.common.collect.Maps.filterEntries(com.google.common.collect.BiMap, com.google.common.base.Predicate):com.google.common.collect.BiMap<K, V>
      com.google.common.collect.Maps.filterEntries(java.util.Map, com.google.common.base.Predicate):java.util.Map<K, V>
      com.google.common.collect.Maps.filterEntries(java.util.NavigableMap, com.google.common.base.Predicate):java.util.NavigableMap<K, V>
      com.google.common.collect.Maps.filterEntries(java.util.SortedMap, com.google.common.base.Predicate):java.util.SortedMap<K, V> */
    public static <K, V> SortedMap<K, V> filterValues(SortedMap<K, V> sortedMap, Predicate<? super V> predicate) {
        return filterEntries((SortedMap) sortedMap, (Predicate) valuePredicateOnEntries(predicate));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Maps.filterEntries(java.util.NavigableMap, com.google.common.base.Predicate):java.util.NavigableMap<K, V>
     arg types: [java.util.NavigableMap<K, V>, com.google.common.base.Predicate<java.util.Map$Entry<?, V>>]
     candidates:
      com.google.common.collect.Maps.filterEntries(com.google.common.collect.BiMap, com.google.common.base.Predicate):com.google.common.collect.BiMap<K, V>
      com.google.common.collect.Maps.filterEntries(java.util.Map, com.google.common.base.Predicate):java.util.Map<K, V>
      com.google.common.collect.Maps.filterEntries(java.util.SortedMap, com.google.common.base.Predicate):java.util.SortedMap<K, V>
      com.google.common.collect.Maps.filterEntries(java.util.NavigableMap, com.google.common.base.Predicate):java.util.NavigableMap<K, V> */
    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> filterValues(NavigableMap<K, V> navigableMap, Predicate<? super V> predicate) {
        return filterEntries((NavigableMap) navigableMap, (Predicate) valuePredicateOnEntries(predicate));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Maps.filterEntries(com.google.common.collect.BiMap, com.google.common.base.Predicate):com.google.common.collect.BiMap<K, V>
     arg types: [com.google.common.collect.BiMap<K, V>, com.google.common.base.Predicate<java.util.Map$Entry<?, V>>]
     candidates:
      com.google.common.collect.Maps.filterEntries(java.util.Map, com.google.common.base.Predicate):java.util.Map<K, V>
      com.google.common.collect.Maps.filterEntries(java.util.NavigableMap, com.google.common.base.Predicate):java.util.NavigableMap<K, V>
      com.google.common.collect.Maps.filterEntries(java.util.SortedMap, com.google.common.base.Predicate):java.util.SortedMap<K, V>
      com.google.common.collect.Maps.filterEntries(com.google.common.collect.BiMap, com.google.common.base.Predicate):com.google.common.collect.BiMap<K, V> */
    public static <K, V> BiMap<K, V> filterValues(BiMap<K, V> biMap, Predicate<? super V> predicate) {
        return filterEntries((BiMap) biMap, (Predicate) valuePredicateOnEntries(predicate));
    }

    public static <K, V> Map<K, V> filterEntries(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (map instanceof AbstractFilteredMap) {
            return filterFiltered((AbstractFilteredMap) map, predicate);
        }
        return new FilteredEntryMap((Map) Preconditions.checkNotNull(map), predicate);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Maps.filterFiltered(com.google.common.collect.Maps$FilteredEntrySortedMap, com.google.common.base.Predicate):java.util.SortedMap<K, V>
     arg types: [com.google.common.collect.Maps$FilteredEntrySortedMap, com.google.common.base.Predicate<? super java.util.Map$Entry<K, V>>]
     candidates:
      com.google.common.collect.Maps.filterFiltered(com.google.common.collect.Maps$FilteredEntryBiMap, com.google.common.base.Predicate):com.google.common.collect.BiMap<K, V>
      com.google.common.collect.Maps.filterFiltered(com.google.common.collect.Maps$AbstractFilteredMap, com.google.common.base.Predicate):java.util.Map<K, V>
      com.google.common.collect.Maps.filterFiltered(com.google.common.collect.Maps$FilteredEntryNavigableMap, com.google.common.base.Predicate):java.util.NavigableMap<K, V>
      com.google.common.collect.Maps.filterFiltered(com.google.common.collect.Maps$FilteredEntrySortedMap, com.google.common.base.Predicate):java.util.SortedMap<K, V> */
    public static <K, V> SortedMap<K, V> filterEntries(SortedMap<K, V> sortedMap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (sortedMap instanceof FilteredEntrySortedMap) {
            return filterFiltered((FilteredEntrySortedMap) sortedMap, (Predicate) predicate);
        }
        return new FilteredEntrySortedMap((SortedMap) Preconditions.checkNotNull(sortedMap), predicate);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> filterEntries(NavigableMap<K, V> navigableMap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (navigableMap instanceof FilteredEntryNavigableMap) {
            return filterFiltered((FilteredEntryNavigableMap) navigableMap, predicate);
        }
        return new FilteredEntryNavigableMap((NavigableMap) Preconditions.checkNotNull(navigableMap), predicate);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Maps.filterFiltered(com.google.common.collect.Maps$FilteredEntryBiMap, com.google.common.base.Predicate):com.google.common.collect.BiMap<K, V>
     arg types: [com.google.common.collect.Maps$FilteredEntryBiMap, com.google.common.base.Predicate<? super java.util.Map$Entry<K, V>>]
     candidates:
      com.google.common.collect.Maps.filterFiltered(com.google.common.collect.Maps$AbstractFilteredMap, com.google.common.base.Predicate):java.util.Map<K, V>
      com.google.common.collect.Maps.filterFiltered(com.google.common.collect.Maps$FilteredEntryNavigableMap, com.google.common.base.Predicate):java.util.NavigableMap<K, V>
      com.google.common.collect.Maps.filterFiltered(com.google.common.collect.Maps$FilteredEntrySortedMap, com.google.common.base.Predicate):java.util.SortedMap<K, V>
      com.google.common.collect.Maps.filterFiltered(com.google.common.collect.Maps$FilteredEntryBiMap, com.google.common.base.Predicate):com.google.common.collect.BiMap<K, V> */
    public static <K, V> BiMap<K, V> filterEntries(BiMap<K, V> biMap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(biMap);
        Preconditions.checkNotNull(predicate);
        return biMap instanceof FilteredEntryBiMap ? filterFiltered((FilteredEntryBiMap) biMap, (Predicate) predicate) : new FilteredEntryBiMap(biMap, predicate);
    }

    private static <K, V> Map<K, V> filterFiltered(AbstractFilteredMap<K, V> abstractFilteredMap, Predicate<? super Map.Entry<K, V>> predicate) {
        return new FilteredEntryMap(abstractFilteredMap.unfiltered, Predicates.and(abstractFilteredMap.predicate, predicate));
    }

    private static <K, V> SortedMap<K, V> filterFiltered(FilteredEntrySortedMap<K, V> filteredEntrySortedMap, Predicate<? super Map.Entry<K, V>> predicate) {
        return new FilteredEntrySortedMap(filteredEntrySortedMap.sortedMap(), Predicates.and(filteredEntrySortedMap.predicate, predicate));
    }

    @GwtIncompatible
    private static <K, V> NavigableMap<K, V> filterFiltered(FilteredEntryNavigableMap<K, V> filteredEntryNavigableMap, Predicate<? super Map.Entry<K, V>> predicate) {
        return new FilteredEntryNavigableMap(filteredEntryNavigableMap.unfiltered, Predicates.and(filteredEntryNavigableMap.entryPredicate, predicate));
    }

    private static <K, V> BiMap<K, V> filterFiltered(FilteredEntryBiMap<K, V> filteredEntryBiMap, Predicate<? super Map.Entry<K, V>> predicate) {
        return new FilteredEntryBiMap(filteredEntryBiMap.unfiltered(), Predicates.and(filteredEntryBiMap.predicate, predicate));
    }

    static abstract class AbstractFilteredMap<K, V> extends ViewCachingAbstractMap<K, V> {
        final Predicate<? super Map.Entry<K, V>> predicate;
        final Map<K, V> unfiltered;

        AbstractFilteredMap(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate2) {
            this.unfiltered = map;
            this.predicate = predicate2;
        }

        /* access modifiers changed from: package-private */
        public boolean apply(Object obj, V v) {
            return this.predicate.apply(Maps.immutableEntry(obj, v));
        }

        public V put(K k, V v) {
            Preconditions.checkArgument(apply(k, v));
            return this.unfiltered.put(k, v);
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            for (Map.Entry next : map.entrySet()) {
                Preconditions.checkArgument(apply(next.getKey(), next.getValue()));
            }
            this.unfiltered.putAll(map);
        }

        public boolean containsKey(Object obj) {
            return this.unfiltered.containsKey(obj) && apply(obj, this.unfiltered.get(obj));
        }

        public V get(Object obj) {
            V v = this.unfiltered.get(obj);
            if (v == null || !apply(obj, v)) {
                return null;
            }
            return v;
        }

        public boolean isEmpty() {
            return entrySet().isEmpty();
        }

        public V remove(Object obj) {
            if (containsKey(obj)) {
                return this.unfiltered.remove(obj);
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public Collection<V> createValues() {
            return new FilteredMapValues(this, this.unfiltered, this.predicate);
        }
    }

    static final class FilteredMapValues<K, V> extends Values<K, V> {
        final Predicate<? super Map.Entry<K, V>> predicate;
        final Map<K, V> unfiltered;

        FilteredMapValues(Map<K, V> map, Map<K, V> map2, Predicate<? super Map.Entry<K, V>> predicate2) {
            super(map);
            this.unfiltered = map2;
            this.predicate = predicate2;
        }

        public final boolean remove(Object obj) {
            Iterator<Map.Entry<K, V>> it = this.unfiltered.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (this.predicate.apply(next) && Objects.equal(next.getValue(), obj)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        public final boolean removeAll(Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = this.unfiltered.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (this.predicate.apply(next) && collection.contains(next.getValue())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public final boolean retainAll(Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = this.unfiltered.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (this.predicate.apply(next) && !collection.contains(next.getValue())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public final Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        public final <T> T[] toArray(T[] tArr) {
            return Lists.newArrayList(iterator()).toArray(tArr);
        }
    }

    static class FilteredKeyMap<K, V> extends AbstractFilteredMap<K, V> {
        final Predicate<? super K> keyPredicate;

        FilteredKeyMap(Map<K, V> map, Predicate<? super K> predicate, Predicate<? super Map.Entry<K, V>> predicate2) {
            super(map, predicate2);
            this.keyPredicate = predicate;
        }

        /* access modifiers changed from: protected */
        public Set<Map.Entry<K, V>> createEntrySet() {
            return Sets.filter(this.unfiltered.entrySet(), this.predicate);
        }

        /* access modifiers changed from: package-private */
        public Set<K> createKeySet() {
            return Sets.filter(this.unfiltered.keySet(), this.keyPredicate);
        }

        public boolean containsKey(Object obj) {
            return this.unfiltered.containsKey(obj) && this.keyPredicate.apply(obj);
        }
    }

    static class FilteredEntryMap<K, V> extends AbstractFilteredMap<K, V> {
        final Set<Map.Entry<K, V>> filteredEntrySet;

        FilteredEntryMap(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate) {
            super(map, predicate);
            this.filteredEntrySet = Sets.filter(map.entrySet(), this.predicate);
        }

        /* access modifiers changed from: protected */
        public Set<Map.Entry<K, V>> createEntrySet() {
            return new EntrySet();
        }

        class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
            private EntrySet() {
            }

            /* access modifiers changed from: protected */
            public Set<Map.Entry<K, V>> delegate() {
                return FilteredEntryMap.this.filteredEntrySet;
            }

            public Iterator<Map.Entry<K, V>> iterator() {
                return new TransformedIterator<Map.Entry<K, V>, Map.Entry<K, V>>(FilteredEntryMap.this.filteredEntrySet.iterator()) {
                    /* class com.google.common.collect.Maps.FilteredEntryMap.EntrySet.AnonymousClass1 */

                    /* access modifiers changed from: package-private */
                    public Map.Entry<K, V> transform(final Map.Entry<K, V> entry) {
                        return new ForwardingMapEntry<K, V>() {
                            /* class com.google.common.collect.Maps.FilteredEntryMap.EntrySet.AnonymousClass1.AnonymousClass1 */

                            /* access modifiers changed from: protected */
                            public Map.Entry<K, V> delegate() {
                                return entry;
                            }

                            public V setValue(V v) {
                                Preconditions.checkArgument(FilteredEntryMap.this.apply(getKey(), v));
                                return super.setValue(v);
                            }
                        };
                    }
                };
            }
        }

        /* access modifiers changed from: package-private */
        public Set<K> createKeySet() {
            return new KeySet();
        }

        static <K, V> boolean removeAllKeys(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate, Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (predicate.apply(next) && collection.contains(next.getKey())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        static <K, V> boolean retainAllKeys(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate, Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry next = it.next();
                if (predicate.apply(next) && !collection.contains(next.getKey())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        class KeySet extends KeySet<K, V> {
            KeySet() {
                super(FilteredEntryMap.this);
            }

            public boolean remove(Object obj) {
                if (!FilteredEntryMap.this.containsKey(obj)) {
                    return false;
                }
                FilteredEntryMap.this.unfiltered.remove(obj);
                return true;
            }

            public boolean removeAll(Collection<?> collection) {
                return FilteredEntryMap.removeAllKeys(FilteredEntryMap.this.unfiltered, FilteredEntryMap.this.predicate, collection);
            }

            public boolean retainAll(Collection<?> collection) {
                return FilteredEntryMap.retainAllKeys(FilteredEntryMap.this.unfiltered, FilteredEntryMap.this.predicate, collection);
            }

            public Object[] toArray() {
                return Lists.newArrayList(iterator()).toArray();
            }

            public <T> T[] toArray(T[] tArr) {
                return Lists.newArrayList(iterator()).toArray(tArr);
            }
        }
    }

    static class FilteredEntrySortedMap<K, V> extends FilteredEntryMap<K, V> implements SortedMap<K, V> {
        FilteredEntrySortedMap(SortedMap<K, V> sortedMap, Predicate<? super Map.Entry<K, V>> predicate) {
            super(sortedMap, predicate);
        }

        /* access modifiers changed from: package-private */
        public SortedMap<K, V> sortedMap() {
            return (SortedMap) this.unfiltered;
        }

        public SortedSet<K> keySet() {
            return (SortedSet) super.keySet();
        }

        /* access modifiers changed from: package-private */
        public SortedSet<K> createKeySet() {
            return new SortedKeySet();
        }

        class SortedKeySet extends FilteredEntryMap<K, V>.KeySet implements SortedSet<K> {
            SortedKeySet() {
                super();
            }

            public Comparator<? super K> comparator() {
                return FilteredEntrySortedMap.this.sortedMap().comparator();
            }

            public SortedSet<K> subSet(K k, K k2) {
                return (SortedSet) FilteredEntrySortedMap.this.subMap(k, k2).keySet();
            }

            public SortedSet<K> headSet(K k) {
                return (SortedSet) FilteredEntrySortedMap.this.headMap(k).keySet();
            }

            public SortedSet<K> tailSet(K k) {
                return (SortedSet) FilteredEntrySortedMap.this.tailMap(k).keySet();
            }

            public K first() {
                return FilteredEntrySortedMap.this.firstKey();
            }

            public K last() {
                return FilteredEntrySortedMap.this.lastKey();
            }
        }

        public Comparator<? super K> comparator() {
            return sortedMap().comparator();
        }

        public K firstKey() {
            return keySet().iterator().next();
        }

        public K lastKey() {
            SortedMap sortedMap = sortedMap();
            while (true) {
                K lastKey = sortedMap.lastKey();
                if (apply(lastKey, this.unfiltered.get(lastKey))) {
                    return lastKey;
                }
                sortedMap = sortedMap().headMap(lastKey);
            }
        }

        public SortedMap<K, V> headMap(K k) {
            return new FilteredEntrySortedMap(sortedMap().headMap(k), this.predicate);
        }

        public SortedMap<K, V> subMap(K k, K k2) {
            return new FilteredEntrySortedMap(sortedMap().subMap(k, k2), this.predicate);
        }

        public SortedMap<K, V> tailMap(K k) {
            return new FilteredEntrySortedMap(sortedMap().tailMap(k), this.predicate);
        }
    }

    @GwtIncompatible
    static class FilteredEntryNavigableMap<K, V> extends AbstractNavigableMap<K, V> {
        public final Predicate<? super Map.Entry<K, V>> entryPredicate;
        private final Map<K, V> filteredDelegate;
        public final NavigableMap<K, V> unfiltered;

        FilteredEntryNavigableMap(NavigableMap<K, V> navigableMap, Predicate<? super Map.Entry<K, V>> predicate) {
            this.unfiltered = (NavigableMap) Preconditions.checkNotNull(navigableMap);
            this.entryPredicate = predicate;
            this.filteredDelegate = new FilteredEntryMap(navigableMap, predicate);
        }

        public Comparator<? super K> comparator() {
            return this.unfiltered.comparator();
        }

        public NavigableSet<K> navigableKeySet() {
            return new NavigableKeySet<K, V>(this) {
                /* class com.google.common.collect.Maps.FilteredEntryNavigableMap.AnonymousClass1 */

                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMap.removeAllKeys(FilteredEntryNavigableMap.this.unfiltered, FilteredEntryNavigableMap.this.entryPredicate, collection);
                }

                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMap.retainAllKeys(FilteredEntryNavigableMap.this.unfiltered, FilteredEntryNavigableMap.this.entryPredicate, collection);
                }
            };
        }

        public Collection<V> values() {
            return new FilteredMapValues(this, this.unfiltered, this.entryPredicate);
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return Iterators.filter(this.unfiltered.entrySet().iterator(), this.entryPredicate);
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V>> descendingEntryIterator() {
            return Iterators.filter(this.unfiltered.descendingMap().entrySet().iterator(), this.entryPredicate);
        }

        public int size() {
            return this.filteredDelegate.size();
        }

        public boolean isEmpty() {
            return !Iterables.any(this.unfiltered.entrySet(), this.entryPredicate);
        }

        public V get(Object obj) {
            return this.filteredDelegate.get(obj);
        }

        public boolean containsKey(Object obj) {
            return this.filteredDelegate.containsKey(obj);
        }

        public V put(K k, V v) {
            return this.filteredDelegate.put(k, v);
        }

        public V remove(Object obj) {
            return this.filteredDelegate.remove(obj);
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            this.filteredDelegate.putAll(map);
        }

        public void clear() {
            this.filteredDelegate.clear();
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return this.filteredDelegate.entrySet();
        }

        public Map.Entry<K, V> pollFirstEntry() {
            return (Map.Entry) Iterables.removeFirstMatching(this.unfiltered.entrySet(), this.entryPredicate);
        }

        public Map.Entry<K, V> pollLastEntry() {
            return (Map.Entry) Iterables.removeFirstMatching(this.unfiltered.descendingMap().entrySet(), this.entryPredicate);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.Maps.filterEntries(java.util.NavigableMap, com.google.common.base.Predicate):java.util.NavigableMap<K, V>
         arg types: [java.util.NavigableMap<K, V>, com.google.common.base.Predicate<? super java.util.Map$Entry<K, V>>]
         candidates:
          com.google.common.collect.Maps.filterEntries(com.google.common.collect.BiMap, com.google.common.base.Predicate):com.google.common.collect.BiMap<K, V>
          com.google.common.collect.Maps.filterEntries(java.util.Map, com.google.common.base.Predicate):java.util.Map<K, V>
          com.google.common.collect.Maps.filterEntries(java.util.SortedMap, com.google.common.base.Predicate):java.util.SortedMap<K, V>
          com.google.common.collect.Maps.filterEntries(java.util.NavigableMap, com.google.common.base.Predicate):java.util.NavigableMap<K, V> */
        public NavigableMap<K, V> descendingMap() {
            return Maps.filterEntries((NavigableMap) this.unfiltered.descendingMap(), (Predicate) this.entryPredicate);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.Maps.filterEntries(java.util.NavigableMap, com.google.common.base.Predicate):java.util.NavigableMap<K, V>
         arg types: [java.util.NavigableMap<K, V>, com.google.common.base.Predicate<? super java.util.Map$Entry<K, V>>]
         candidates:
          com.google.common.collect.Maps.filterEntries(com.google.common.collect.BiMap, com.google.common.base.Predicate):com.google.common.collect.BiMap<K, V>
          com.google.common.collect.Maps.filterEntries(java.util.Map, com.google.common.base.Predicate):java.util.Map<K, V>
          com.google.common.collect.Maps.filterEntries(java.util.SortedMap, com.google.common.base.Predicate):java.util.SortedMap<K, V>
          com.google.common.collect.Maps.filterEntries(java.util.NavigableMap, com.google.common.base.Predicate):java.util.NavigableMap<K, V> */
        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return Maps.filterEntries((NavigableMap) this.unfiltered.subMap(k, z, k2, z2), (Predicate) this.entryPredicate);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.Maps.filterEntries(java.util.NavigableMap, com.google.common.base.Predicate):java.util.NavigableMap<K, V>
         arg types: [java.util.NavigableMap<K, V>, com.google.common.base.Predicate<? super java.util.Map$Entry<K, V>>]
         candidates:
          com.google.common.collect.Maps.filterEntries(com.google.common.collect.BiMap, com.google.common.base.Predicate):com.google.common.collect.BiMap<K, V>
          com.google.common.collect.Maps.filterEntries(java.util.Map, com.google.common.base.Predicate):java.util.Map<K, V>
          com.google.common.collect.Maps.filterEntries(java.util.SortedMap, com.google.common.base.Predicate):java.util.SortedMap<K, V>
          com.google.common.collect.Maps.filterEntries(java.util.NavigableMap, com.google.common.base.Predicate):java.util.NavigableMap<K, V> */
        public NavigableMap<K, V> headMap(K k, boolean z) {
            return Maps.filterEntries((NavigableMap) this.unfiltered.headMap(k, z), (Predicate) this.entryPredicate);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.Maps.filterEntries(java.util.NavigableMap, com.google.common.base.Predicate):java.util.NavigableMap<K, V>
         arg types: [java.util.NavigableMap<K, V>, com.google.common.base.Predicate<? super java.util.Map$Entry<K, V>>]
         candidates:
          com.google.common.collect.Maps.filterEntries(com.google.common.collect.BiMap, com.google.common.base.Predicate):com.google.common.collect.BiMap<K, V>
          com.google.common.collect.Maps.filterEntries(java.util.Map, com.google.common.base.Predicate):java.util.Map<K, V>
          com.google.common.collect.Maps.filterEntries(java.util.SortedMap, com.google.common.base.Predicate):java.util.SortedMap<K, V>
          com.google.common.collect.Maps.filterEntries(java.util.NavigableMap, com.google.common.base.Predicate):java.util.NavigableMap<K, V> */
        public NavigableMap<K, V> tailMap(K k, boolean z) {
            return Maps.filterEntries((NavigableMap) this.unfiltered.tailMap(k, z), (Predicate) this.entryPredicate);
        }
    }

    static final class FilteredEntryBiMap<K, V> extends FilteredEntryMap<K, V> implements BiMap<K, V> {
        @RetainedWith
        private final BiMap<V, K> inverse;

        private static <K, V> Predicate<Map.Entry<V, K>> inversePredicate(final Predicate<? super Map.Entry<K, V>> predicate) {
            return new Predicate<Map.Entry<V, K>>() {
                /* class com.google.common.collect.Maps.FilteredEntryBiMap.AnonymousClass1 */

                public /* synthetic */ boolean test(T t) {
                    return Predicate.CC.$default$test(this, t);
                }

                public final boolean apply(Map.Entry<V, K> entry) {
                    return predicate.apply(Maps.immutableEntry(entry.getValue(), entry.getKey()));
                }
            };
        }

        FilteredEntryBiMap(BiMap<K, V> biMap, Predicate<? super Map.Entry<K, V>> predicate) {
            super(biMap, predicate);
            this.inverse = new FilteredEntryBiMap(biMap.inverse(), inversePredicate(predicate), this);
        }

        private FilteredEntryBiMap(BiMap<K, V> biMap, Predicate<? super Map.Entry<K, V>> predicate, BiMap<V, K> biMap2) {
            super(biMap, predicate);
            this.inverse = biMap2;
        }

        /* access modifiers changed from: package-private */
        public final BiMap<K, V> unfiltered() {
            return (BiMap) this.unfiltered;
        }

        public final V forcePut(K k, V v) {
            Preconditions.checkArgument(apply(k, v));
            return unfiltered().forcePut(k, v);
        }

        public final void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
            unfiltered().replaceAll(new BiFunction(biFunction) {
                /* class com.google.common.collect.$$Lambda$Maps$FilteredEntryBiMap$OE537khb_eNPcbHxi4mO1N8eLo4 */
                private final /* synthetic */ BiFunction f$1;

                {
                    this.f$1 = r2;
                }

                public final Object apply(Object obj, Object obj2) {
                    return Maps.FilteredEntryBiMap.this.lambda$replaceAll$0$Maps$FilteredEntryBiMap(this.f$1, obj, obj2);
                }
            });
        }

        public /* synthetic */ Object lambda$replaceAll$0$Maps$FilteredEntryBiMap(BiFunction biFunction, Object obj, Object obj2) {
            return this.predicate.apply(Maps.immutableEntry(obj, obj2)) ? biFunction.apply(obj, obj2) : obj2;
        }

        public final BiMap<V, K> inverse() {
            return this.inverse;
        }

        public final Set<V> values() {
            return this.inverse.keySet();
        }
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> unmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap) {
        Preconditions.checkNotNull(navigableMap);
        if (navigableMap instanceof UnmodifiableNavigableMap) {
            return navigableMap;
        }
        return new UnmodifiableNavigableMap(navigableMap);
    }

    public static <K, V> Map.Entry<K, V> unmodifiableOrNull(Map.Entry<K, ? extends V> entry) {
        if (entry == null) {
            return null;
        }
        return unmodifiableEntry(entry);
    }

    @GwtIncompatible
    static class UnmodifiableNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements Serializable, NavigableMap<K, V> {
        private final NavigableMap<K, ? extends V> delegate;
        private transient UnmodifiableNavigableMap<K, V> descendingMap;

        UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap) {
            this.delegate = navigableMap;
        }

        UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap, UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap) {
            this.delegate = navigableMap;
            this.descendingMap = unmodifiableNavigableMap;
        }

        /* access modifiers changed from: protected */
        public SortedMap<K, V> delegate() {
            return Collections.unmodifiableSortedMap(this.delegate);
        }

        public Map.Entry<K, V> lowerEntry(K k) {
            return Maps.unmodifiableOrNull(this.delegate.lowerEntry(k));
        }

        public K lowerKey(K k) {
            return this.delegate.lowerKey(k);
        }

        public Map.Entry<K, V> floorEntry(K k) {
            return Maps.unmodifiableOrNull(this.delegate.floorEntry(k));
        }

        public K floorKey(K k) {
            return this.delegate.floorKey(k);
        }

        public Map.Entry<K, V> ceilingEntry(K k) {
            return Maps.unmodifiableOrNull(this.delegate.ceilingEntry(k));
        }

        public K ceilingKey(K k) {
            return this.delegate.ceilingKey(k);
        }

        public Map.Entry<K, V> higherEntry(K k) {
            return Maps.unmodifiableOrNull(this.delegate.higherEntry(k));
        }

        public K higherKey(K k) {
            return this.delegate.higherKey(k);
        }

        public Map.Entry<K, V> firstEntry() {
            return Maps.unmodifiableOrNull(this.delegate.firstEntry());
        }

        public Map.Entry<K, V> lastEntry() {
            return Maps.unmodifiableOrNull(this.delegate.lastEntry());
        }

        public final Map.Entry<K, V> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        public final Map.Entry<K, V> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        public NavigableMap<K, V> descendingMap() {
            UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap = this.descendingMap;
            if (unmodifiableNavigableMap != null) {
                return unmodifiableNavigableMap;
            }
            UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap2 = new UnmodifiableNavigableMap<>(this.delegate.descendingMap(), this);
            this.descendingMap = unmodifiableNavigableMap2;
            return unmodifiableNavigableMap2;
        }

        public Set<K> keySet() {
            return navigableKeySet();
        }

        public NavigableSet<K> navigableKeySet() {
            return Sets.unmodifiableNavigableSet(this.delegate.navigableKeySet());
        }

        public NavigableSet<K> descendingKeySet() {
            return Sets.unmodifiableNavigableSet(this.delegate.descendingKeySet());
        }

        public SortedMap<K, V> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return Maps.unmodifiableNavigableMap(this.delegate.subMap(k, z, k2, z2));
        }

        public SortedMap<K, V> headMap(K k) {
            return headMap(k, false);
        }

        public NavigableMap<K, V> headMap(K k, boolean z) {
            return Maps.unmodifiableNavigableMap(this.delegate.headMap(k, z));
        }

        public SortedMap<K, V> tailMap(K k) {
            return tailMap(k, true);
        }

        public NavigableMap<K, V> tailMap(K k, boolean z) {
            return Maps.unmodifiableNavigableMap(this.delegate.tailMap(k, z));
        }
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> synchronizedNavigableMap(NavigableMap<K, V> navigableMap) {
        return Synchronized.navigableMap(navigableMap);
    }

    @GwtCompatible
    static abstract class ViewCachingAbstractMap<K, V> extends AbstractMap<K, V> {
        private transient Set<Map.Entry<K, V>> entrySet;
        private transient Set<K> keySet;
        private transient Collection<V> values;

        /* access modifiers changed from: package-private */
        public abstract Set<Map.Entry<K, V>> createEntrySet();

        ViewCachingAbstractMap() {
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
            this.entrySet = createEntrySet;
            return createEntrySet;
        }

        public Set<K> keySet() {
            Set<K> set = this.keySet;
            if (set != null) {
                return set;
            }
            Set<K> createKeySet = createKeySet();
            this.keySet = createKeySet;
            return createKeySet;
        }

        /* access modifiers changed from: package-private */
        public Set<K> createKeySet() {
            return new KeySet(this);
        }

        public Collection<V> values() {
            Collection<V> collection = this.values;
            if (collection != null) {
                return collection;
            }
            Collection<V> createValues = createValues();
            this.values = createValues;
            return createValues;
        }

        /* access modifiers changed from: package-private */
        public Collection<V> createValues() {
            return new Values(this);
        }
    }

    static abstract class IteratorBasedAbstractMap<K, V> extends AbstractMap<K, V> {
        /* access modifiers changed from: package-private */
        public abstract Iterator<Map.Entry<K, V>> entryIterator();

        public abstract int size();

        IteratorBasedAbstractMap() {
        }

        /* access modifiers changed from: package-private */
        public Spliterator<Map.Entry<K, V>> entrySpliterator() {
            return Spliterators.spliterator(entryIterator(), (long) size(), 65);
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return new EntrySet<K, V>() {
                /* class com.google.common.collect.Maps.IteratorBasedAbstractMap.AnonymousClass1 */

                /* access modifiers changed from: package-private */
                public Map<K, V> map() {
                    return IteratorBasedAbstractMap.this;
                }

                public Iterator<Map.Entry<K, V>> iterator() {
                    return IteratorBasedAbstractMap.this.entryIterator();
                }

                public Spliterator<Map.Entry<K, V>> spliterator() {
                    return IteratorBasedAbstractMap.this.entrySpliterator();
                }

                public void forEach(Consumer<? super Map.Entry<K, V>> consumer) {
                    IteratorBasedAbstractMap.this.forEachEntry(consumer);
                }
            };
        }

        /* access modifiers changed from: package-private */
        public void forEachEntry(Consumer<? super Map.Entry<K, V>> consumer) {
            entryIterator().forEachRemaining(consumer);
        }

        public void clear() {
            Iterators.clear(entryIterator());
        }
    }

    static <V> V safeGet(Map<?, V> map, Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static boolean safeContainsKey(Map<?, ?> map, Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static <V> V safeRemove(Map<?, V> map, Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static boolean containsKeyImpl(Map<?, ?> map, Object obj) {
        return Iterators.contains(keyIterator(map.entrySet().iterator()), obj);
    }

    static boolean containsValueImpl(Map<?, ?> map, Object obj) {
        return Iterators.contains(valueIterator(map.entrySet().iterator()), obj);
    }

    static <K, V> boolean containsEntryImpl(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return collection.contains(unmodifiableEntry((Map.Entry) obj));
    }

    static <K, V> boolean removeEntryImpl(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return collection.remove(unmodifiableEntry((Map.Entry) obj));
    }

    static boolean equalsImpl(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    static String toStringImpl(Map<?, ?> map) {
        StringBuilder newStringBuilderForCollection = Collections2.newStringBuilderForCollection(map.size());
        newStringBuilderForCollection.append('{');
        boolean z = true;
        for (Map.Entry next : map.entrySet()) {
            if (!z) {
                newStringBuilderForCollection.append(", ");
            }
            z = false;
            newStringBuilderForCollection.append(next.getKey());
            newStringBuilderForCollection.append('=');
            newStringBuilderForCollection.append(next.getValue());
        }
        newStringBuilderForCollection.append('}');
        return newStringBuilderForCollection.toString();
    }

    static <K, V> void putAllImpl(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry next : map2.entrySet()) {
            map.put(next.getKey(), next.getValue());
        }
    }

    static class KeySet<K, V> extends Sets.ImprovedAbstractSet<K> {
        @Weak
        final Map<K, V> map;

        KeySet(Map<K, V> map2) {
            this.map = (Map) Preconditions.checkNotNull(map2);
        }

        /* access modifiers changed from: package-private */
        public Map<K, V> map() {
            return this.map;
        }

        public Iterator<K> iterator() {
            return Maps.keyIterator(map().entrySet().iterator());
        }

        public void forEach(Consumer<? super K> consumer) {
            Preconditions.checkNotNull(consumer);
            this.map.forEach(new BiConsumer(consumer) {
                /* class com.google.common.collect.$$Lambda$Maps$KeySet$Mb0LAbe7BQc1Qj7v5jZpkCaG1M */
                private final /* synthetic */ Consumer f$0;

                {
                    this.f$0 = r1;
                }

                public final void accept(Object obj, Object obj2) {
                    this.f$0.accept(obj);
                }
            });
        }

        public int size() {
            return map().size();
        }

        public boolean isEmpty() {
            return map().isEmpty();
        }

        public boolean contains(Object obj) {
            return map().containsKey(obj);
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            map().remove(obj);
            return true;
        }

        public void clear() {
            map().clear();
        }
    }

    static <K> K keyOrNull(Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    static <V> V valueOrNull(Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    static class SortedKeySet<K, V> extends KeySet<K, V> implements SortedSet<K> {
        SortedKeySet(SortedMap<K, V> sortedMap) {
            super(sortedMap);
        }

        /* access modifiers changed from: package-private */
        public SortedMap<K, V> map() {
            return (SortedMap) super.map();
        }

        public Comparator<? super K> comparator() {
            return map().comparator();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new SortedKeySet(map().subMap(k, k2));
        }

        public SortedSet<K> headSet(K k) {
            return new SortedKeySet(map().headMap(k));
        }

        public SortedSet<K> tailSet(K k) {
            return new SortedKeySet(map().tailMap(k));
        }

        public K first() {
            return map().firstKey();
        }

        public K last() {
            return map().lastKey();
        }
    }

    @GwtIncompatible
    static class NavigableKeySet<K, V> extends SortedKeySet<K, V> implements NavigableSet<K> {
        NavigableKeySet(NavigableMap<K, V> navigableMap) {
            super(navigableMap);
        }

        /* access modifiers changed from: package-private */
        public NavigableMap<K, V> map() {
            return (NavigableMap) this.map;
        }

        public K lower(K k) {
            return map().lowerKey(k);
        }

        public K floor(K k) {
            return map().floorKey(k);
        }

        public K ceiling(K k) {
            return map().ceilingKey(k);
        }

        public K higher(K k) {
            return map().higherKey(k);
        }

        public K pollFirst() {
            return Maps.keyOrNull(map().pollFirstEntry());
        }

        public K pollLast() {
            return Maps.keyOrNull(map().pollLastEntry());
        }

        public NavigableSet<K> descendingSet() {
            return map().descendingKeySet();
        }

        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return map().subMap(k, z, k2, z2).navigableKeySet();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        public NavigableSet<K> headSet(K k, boolean z) {
            return map().headMap(k, z).navigableKeySet();
        }

        public SortedSet<K> headSet(K k) {
            return headSet(k, false);
        }

        public NavigableSet<K> tailSet(K k, boolean z) {
            return map().tailMap(k, z).navigableKeySet();
        }

        public SortedSet<K> tailSet(K k) {
            return tailSet(k, true);
        }
    }

    static class Values<K, V> extends AbstractCollection<V> {
        @Weak
        final Map<K, V> map;

        Values(Map<K, V> map2) {
            this.map = (Map) Preconditions.checkNotNull(map2);
        }

        /* access modifiers changed from: package-private */
        public final Map<K, V> map() {
            return this.map;
        }

        public Iterator<V> iterator() {
            return Maps.valueIterator(map().entrySet().iterator());
        }

        public void forEach(Consumer<? super V> consumer) {
            Preconditions.checkNotNull(consumer);
            this.map.forEach(new BiConsumer(consumer) {
                /* class com.google.common.collect.$$Lambda$Maps$Values$4I647vOf6ceTE_5XzH7zgevdOcc */
                private final /* synthetic */ Consumer f$0;

                {
                    this.f$0 = r1;
                }

                public final void accept(Object obj, Object obj2) {
                    this.f$0.accept(obj2);
                }
            });
        }

        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry entry : map().entrySet()) {
                    if (Objects.equal(obj, entry.getValue())) {
                        map().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet newHashSet = Sets.newHashSet();
                for (Map.Entry entry : map().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        newHashSet.add(entry.getKey());
                    }
                }
                return map().keySet().removeAll(newHashSet);
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet newHashSet = Sets.newHashSet();
                for (Map.Entry entry : map().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        newHashSet.add(entry.getKey());
                    }
                }
                return map().keySet().retainAll(newHashSet);
            }
        }

        public int size() {
            return map().size();
        }

        public boolean isEmpty() {
            return map().isEmpty();
        }

        public boolean contains(Object obj) {
            return map().containsValue(obj);
        }

        public void clear() {
            map().clear();
        }
    }

    static abstract class EntrySet<K, V> extends Sets.ImprovedAbstractSet<Map.Entry<K, V>> {
        /* access modifiers changed from: package-private */
        public abstract Map<K, V> map();

        EntrySet() {
        }

        public int size() {
            return map().size();
        }

        public void clear() {
            map().clear();
        }

        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object safeGet = Maps.safeGet(map(), key);
                if (!Objects.equal(safeGet, entry.getValue()) || (safeGet == null && !map().containsKey(key))) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            return map().isEmpty();
        }

        public boolean remove(Object obj) {
            if (contains(obj)) {
                return map().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                return Sets.removeAllImpl(this, collection.iterator());
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet newHashSetWithExpectedSize = Sets.newHashSetWithExpectedSize(collection.size());
                for (Object next : collection) {
                    if (contains(next)) {
                        newHashSetWithExpectedSize.add(((Map.Entry) next).getKey());
                    }
                }
                return map().keySet().retainAll(newHashSetWithExpectedSize);
            }
        }
    }

    @GwtIncompatible
    static abstract class DescendingMap<K, V> extends ForwardingMap<K, V> implements NavigableMap<K, V> {
        private transient Comparator<? super K> comparator;
        private transient Set<Map.Entry<K, V>> entrySet;
        private transient NavigableSet<K> navigableKeySet;

        /* access modifiers changed from: package-private */
        public abstract Iterator<Map.Entry<K, V>> entryIterator();

        /* access modifiers changed from: package-private */
        public abstract NavigableMap<K, V> forward();

        DescendingMap() {
        }

        /* access modifiers changed from: protected */
        public final Map<K, V> delegate() {
            return forward();
        }

        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator2 = this.comparator;
            if (comparator2 != null) {
                return comparator2;
            }
            Object comparator3 = forward().comparator();
            if (comparator3 == null) {
                comparator3 = Ordering.natural();
            }
            Ordering reverse = reverse(comparator3);
            this.comparator = reverse;
            return reverse;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Comparator<T>, java.util.Comparator] */
        /* JADX WARNING: Unknown variable types count: 1 */
        private static <T> Ordering<T> reverse(Comparator<T> r0) {
            return Ordering.from((Comparator) r0).reverse();
        }

        public K firstKey() {
            return forward().lastKey();
        }

        public K lastKey() {
            return forward().firstKey();
        }

        public Map.Entry<K, V> lowerEntry(K k) {
            return forward().higherEntry(k);
        }

        public K lowerKey(K k) {
            return forward().higherKey(k);
        }

        public Map.Entry<K, V> floorEntry(K k) {
            return forward().ceilingEntry(k);
        }

        public K floorKey(K k) {
            return forward().ceilingKey(k);
        }

        public Map.Entry<K, V> ceilingEntry(K k) {
            return forward().floorEntry(k);
        }

        public K ceilingKey(K k) {
            return forward().floorKey(k);
        }

        public Map.Entry<K, V> higherEntry(K k) {
            return forward().lowerEntry(k);
        }

        public K higherKey(K k) {
            return forward().lowerKey(k);
        }

        public Map.Entry<K, V> firstEntry() {
            return forward().lastEntry();
        }

        public Map.Entry<K, V> lastEntry() {
            return forward().firstEntry();
        }

        public Map.Entry<K, V> pollFirstEntry() {
            return forward().pollLastEntry();
        }

        public Map.Entry<K, V> pollLastEntry() {
            return forward().pollFirstEntry();
        }

        public NavigableMap<K, V> descendingMap() {
            return forward();
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> createEntrySet = createEntrySet();
            this.entrySet = createEntrySet;
            return createEntrySet;
        }

        /* access modifiers changed from: package-private */
        public Set<Map.Entry<K, V>> createEntrySet() {
            return new EntrySet<K, V>() {
                /* class com.google.common.collect.Maps.DescendingMap.AnonymousClass1EntrySetImpl */

                /* access modifiers changed from: package-private */
                public Map<K, V> map() {
                    return DescendingMap.this;
                }

                public Iterator<Map.Entry<K, V>> iterator() {
                    return DescendingMap.this.entryIterator();
                }
            };
        }

        public Set<K> keySet() {
            return navigableKeySet();
        }

        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> navigableSet = this.navigableKeySet;
            if (navigableSet != null) {
                return navigableSet;
            }
            NavigableKeySet navigableKeySet2 = new NavigableKeySet(this);
            this.navigableKeySet = navigableKeySet2;
            return navigableKeySet2;
        }

        public NavigableSet<K> descendingKeySet() {
            return forward().navigableKeySet();
        }

        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            return forward().subMap(k2, z2, k, z).descendingMap();
        }

        public SortedMap<K, V> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        public NavigableMap<K, V> headMap(K k, boolean z) {
            return forward().tailMap(k, z).descendingMap();
        }

        public SortedMap<K, V> headMap(K k) {
            return headMap(k, false);
        }

        public NavigableMap<K, V> tailMap(K k, boolean z) {
            return forward().headMap(k, z).descendingMap();
        }

        public SortedMap<K, V> tailMap(K k) {
            return tailMap(k, true);
        }

        public Collection<V> values() {
            return new Values(this);
        }

        public String toString() {
            return standardToString();
        }
    }

    static <E> ImmutableMap<E, Integer> indexMap(Collection<E> collection) {
        ImmutableMap.Builder builder = new ImmutableMap.Builder(collection.size());
        int i = 0;
        for (E put : collection) {
            builder.put(put, Integer.valueOf(i));
            i++;
        }
        return builder.build();
    }

    @GwtIncompatible
    @Beta
    public static <K extends Comparable<? super K>, V> NavigableMap<K, V> subMap(NavigableMap<K, V> navigableMap, Range<K> range) {
        boolean z = true;
        if (navigableMap.comparator() != null && navigableMap.comparator() != Ordering.natural() && range.hasLowerBound() && range.hasUpperBound()) {
            Preconditions.checkArgument(navigableMap.comparator().compare(range.lowerEndpoint(), range.upperEndpoint()) <= 0, "map is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.hasLowerBound() && range.hasUpperBound()) {
            K lowerEndpoint = range.lowerEndpoint();
            boolean z2 = range.lowerBoundType() == BoundType.CLOSED;
            K upperEndpoint = range.upperEndpoint();
            if (range.upperBoundType() != BoundType.CLOSED) {
                z = false;
            }
            return navigableMap.subMap(lowerEndpoint, z2, upperEndpoint, z);
        } else if (range.hasLowerBound()) {
            K lowerEndpoint2 = range.lowerEndpoint();
            if (range.lowerBoundType() != BoundType.CLOSED) {
                z = false;
            }
            return navigableMap.tailMap(lowerEndpoint2, z);
        } else if (!range.hasUpperBound()) {
            return (NavigableMap) Preconditions.checkNotNull(navigableMap);
        } else {
            K upperEndpoint2 = range.upperEndpoint();
            if (range.upperBoundType() != BoundType.CLOSED) {
                z = false;
            }
            return navigableMap.headMap(upperEndpoint2, z);
        }
    }
}
