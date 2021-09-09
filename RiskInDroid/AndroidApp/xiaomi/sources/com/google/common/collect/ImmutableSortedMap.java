package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.Spliterator;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@GwtCompatible(emulated = true, serializable = true)
public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {
    private static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP = new ImmutableSortedMap<>(ImmutableSortedSet.emptySet(Ordering.natural()), ImmutableList.of());
    private static final Comparator<Comparable> NATURAL_ORDER = Ordering.natural();
    private static final long serialVersionUID = 0;
    private transient ImmutableSortedMap<K, V> descendingMap;
    public final transient RegularImmutableSortedSet<K> keySet;
    public final transient ImmutableList<V> valueList;

    @Beta
    public static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> toImmutableSortedMap(Comparator<? super K> comparator, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return CollectCollectors.toImmutableSortedMap(comparator, function, function2);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.function.BinaryOperator<V>, java.lang.Object, java.util.function.BinaryOperator] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Beta
    public static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> toImmutableSortedMap(Comparator<? super K> comparator, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, BinaryOperator<V> r4) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(function2);
        Preconditions.checkNotNull(r4);
        return Collectors.collectingAndThen(Collectors.toMap(function, function2, r4, new Supplier(comparator) {
            /* class com.google.common.collect.$$Lambda$ImmutableSortedMap$4ocGxK6czDjMtDtYIE2ztEq4z8 */
            private final /* synthetic */ Comparator f$0;

            {
                this.f$0 = r1;
            }

            public final Object get() {
                return ImmutableSortedMap.lambda$toImmutableSortedMap$0(this.f$0);
            }
        }), $$Lambda$WRrToC596FCyHKpXFGR2rH8N7lQ.INSTANCE);
    }

    static /* synthetic */ TreeMap lambda$toImmutableSortedMap$0(Comparator comparator) {
        return new TreeMap(comparator);
    }

    static <K, V> ImmutableSortedMap<K, V> emptyMap(Comparator<? super K> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return of();
        }
        return new ImmutableSortedMap<>(ImmutableSortedSet.emptySet(comparator), ImmutableList.of());
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        return NATURAL_EMPTY_MAP;
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k, V v) {
        return of(Ordering.natural(), k, v);
    }

    public static <K, V> ImmutableSortedMap<K, V> of(Comparator<? super K> comparator, K k, V v) {
        return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.of(k), (Comparator) Preconditions.checkNotNull(comparator)), ImmutableList.of(v));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2) {
        return ofEntries(entryOf(k, v), entryOf(k2, v2));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return ofEntries(entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return ofEntries(entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return ofEntries(entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4), entryOf(k5, v5));
    }

    private static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> ofEntries(Map.Entry<K, V>... entryArr) {
        return fromEntries(Ordering.natural(), false, entryArr, entryArr.length);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        return copyOfInternal(map, (Ordering) NATURAL_ORDER);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        return copyOfInternal(map, (Comparator) Preconditions.checkNotNull(comparator));
    }

    @Beta
    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return copyOf(iterable, (Ordering) NATURAL_ORDER);
    }

    @Beta
    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable, Comparator<? super K> comparator) {
        return fromEntries((Comparator) Preconditions.checkNotNull(comparator), false, iterable);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> sortedMap) {
        Comparator<? super K> comparator = sortedMap.comparator();
        if (comparator == null) {
            comparator = NATURAL_ORDER;
        }
        if (sortedMap instanceof ImmutableSortedMap) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) sortedMap;
            if (!immutableSortedMap.isPartialView()) {
                return immutableSortedMap;
            }
        }
        return fromEntries(comparator, true, sortedMap.entrySet());
    }

    private static <K, V> ImmutableSortedMap<K, V> copyOfInternal(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        boolean z = false;
        if (map instanceof SortedMap) {
            Comparator comparator2 = ((SortedMap) map).comparator();
            if (comparator2 != null) {
                z = comparator.equals(comparator2);
            } else if (comparator == NATURAL_ORDER) {
                z = true;
            }
        }
        if (z && (map instanceof ImmutableSortedMap)) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) map;
            if (!immutableSortedMap.isPartialView()) {
                return immutableSortedMap;
            }
        }
        return fromEntries(comparator, z, map.entrySet());
    }

    private static <K, V> ImmutableSortedMap<K, V> fromEntries(Comparator<? super K> comparator, boolean z, Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) Iterables.toArray(iterable, EMPTY_ENTRY_ARRAY);
        return fromEntries(comparator, z, entryArr, entryArr.length);
    }

    public static <K, V> ImmutableSortedMap<K, V> fromEntries(final Comparator<? super K> comparator, boolean z, Map.Entry<K, V>[] entryArr, int i) {
        if (i == 0) {
            return emptyMap(comparator);
        }
        if (i == 1) {
            return of(comparator, entryArr[0].getKey(), entryArr[0].getValue());
        }
        Object[] objArr = new Object[i];
        Object[] objArr2 = new Object[i];
        if (z) {
            for (int i2 = 0; i2 < i; i2++) {
                K key = entryArr[i2].getKey();
                V value = entryArr[i2].getValue();
                CollectPreconditions.checkEntryNotNull(key, value);
                objArr[i2] = key;
                objArr2[i2] = value;
            }
        } else {
            Arrays.sort(entryArr, 0, i, new Comparator<Map.Entry<K, V>>() {
                /* class com.google.common.collect.ImmutableSortedMap.AnonymousClass1 */

                public final int compare(Map.Entry<K, V> entry, Map.Entry<K, V> entry2) {
                    return comparator.compare(entry.getKey(), entry2.getKey());
                }
            });
            K key2 = entryArr[0].getKey();
            objArr[0] = key2;
            objArr2[0] = entryArr[0].getValue();
            CollectPreconditions.checkEntryNotNull(objArr[0], objArr2[0]);
            K k = key2;
            int i3 = 1;
            while (i3 < i) {
                K key3 = entryArr[i3].getKey();
                V value2 = entryArr[i3].getValue();
                CollectPreconditions.checkEntryNotNull(key3, value2);
                objArr[i3] = key3;
                objArr2[i3] = value2;
                checkNoConflict(comparator.compare(k, key3) != 0, "key", entryArr[i3 - 1], entryArr[i3]);
                i3++;
                k = key3;
            }
        }
        return new ImmutableSortedMap<>(new RegularImmutableSortedSet(new RegularImmutableList(objArr), comparator), new RegularImmutableList(objArr2));
    }

    public static <K extends Comparable<?>, V> Builder<K, V> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    public static <K, V> Builder<K, V> orderedBy(Comparator<K> comparator) {
        return new Builder<>(comparator);
    }

    public static <K extends Comparable<?>, V> Builder<K, V> reverseOrder() {
        return new Builder<>(Ordering.natural().reverse());
    }

    public static class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        private final Comparator<? super K> comparator;

        public Builder(Comparator<? super K> comparator2) {
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator2);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.ImmutableMap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMap$Builder<K, V>
         arg types: [K, V]
         candidates:
          com.google.common.collect.ImmutableSortedMap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableSortedMap$Builder<K, V>
          com.google.common.collect.ImmutableMap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMap$Builder<K, V> */
        @CanIgnoreReturnValue
        public Builder<K, V> put(K k, V v) {
            super.put((Object) k, (Object) v);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put((Map.Entry) entry);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            super.putAll((Map) map);
            return this;
        }

        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll((Iterable) iterable);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        @Beta
        public Builder<K, V> orderEntriesByValue(Comparator<? super V> comparator2) {
            throw new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
        }

        /* access modifiers changed from: package-private */
        public Builder<K, V> combine(ImmutableMap.Builder<K, V> builder) {
            super.combine((ImmutableMap.Builder) builder);
            return this;
        }

        public ImmutableSortedMap<K, V> build() {
            int i = this.size;
            if (i == 0) {
                return ImmutableSortedMap.emptyMap(this.comparator);
            }
            if (i != 1) {
                return ImmutableSortedMap.fromEntries(this.comparator, false, this.entries, this.size);
            }
            return ImmutableSortedMap.of(this.comparator, this.entries[0].getKey(), this.entries[0].getValue());
        }
    }

    ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList) {
        this(regularImmutableSortedSet, immutableList, null);
    }

    ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList, ImmutableSortedMap<K, V> immutableSortedMap) {
        this.keySet = regularImmutableSortedSet;
        this.valueList = immutableList;
        this.descendingMap = immutableSortedMap;
    }

    public final int size() {
        return this.valueList.size();
    }

    public final void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Preconditions.checkNotNull(biConsumer);
        ImmutableList<K> asList = this.keySet.asList();
        for (int i = 0; i < size(); i++) {
            biConsumer.accept(asList.get(i), this.valueList.get(i));
        }
    }

    public final V get(Object obj) {
        int indexOf = this.keySet.indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        return this.valueList.get(indexOf);
    }

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return this.keySet.isPartialView() || this.valueList.isPartialView();
    }

    public final ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    /* access modifiers changed from: package-private */
    public final ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new ImmutableMapEntrySet<K, V>() {
            /* class com.google.common.collect.ImmutableSortedMap.AnonymousClass1EntrySet */

            public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
                return asList().iterator();
            }

            public Spliterator<Map.Entry<K, V>> spliterator() {
                return asList().spliterator();
            }

            public void forEach(Consumer<? super Map.Entry<K, V>> consumer) {
                asList().forEach(consumer);
            }

            /* access modifiers changed from: package-private */
            public ImmutableList<Map.Entry<K, V>> createAsList() {
                return new ImmutableAsList<Map.Entry<K, V>>() {
                    /* class com.google.common.collect.ImmutableSortedMap.AnonymousClass1EntrySet.AnonymousClass1 */

                    public Map.Entry<K, V> get(int i) {
                        return new AbstractMap.SimpleImmutableEntry(ImmutableSortedMap.this.keySet.asList().get(i), ImmutableSortedMap.this.valueList.get(i));
                    }

                    public Spliterator<Map.Entry<K, V>> spliterator() {
                        return CollectSpliterators.indexed(size(), 1297, 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: RETURN  
                              (wrap: java.util.Spliterator<java.util.Map$Entry<K, V>> : 0x000b: INVOKE  (r0v1 java.util.Spliterator<java.util.Map$Entry<K, V>>) = 
                              (wrap: int : 0x0000: INVOKE  (r0v0 int) = (r3v0 'this' com.google.common.collect.ImmutableSortedMap$1EntrySet$1 A[THIS]) type: VIRTUAL call: com.google.common.collect.ImmutableSortedMap.1EntrySet.1.size():int)
                              (1297 int)
                              (wrap: com.google.common.collect.-$$Lambda$7PoTp3aIQo7HSLflqKWOsi7MUOA : 0x0006: CONSTRUCTOR  (r1v0 com.google.common.collect.-$$Lambda$7PoTp3aIQo7HSLflqKWOsi7MUOA) = (r3v0 'this' com.google.common.collect.ImmutableSortedMap$1EntrySet$1 A[THIS]) call: com.google.common.collect.-$$Lambda$7PoTp3aIQo7HSLflqKWOsi7MUOA.<init>(com.google.common.collect.ImmutableSortedMap$1EntrySet$1):void type: CONSTRUCTOR)
                             type: STATIC call: com.google.common.collect.CollectSpliterators.indexed(int, int, java.util.function.IntFunction):java.util.Spliterator)
                             in method: com.google.common.collect.ImmutableSortedMap.1EntrySet.1.spliterator():java.util.Spliterator<java.util.Map$Entry<K, V>>, dex: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:313)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.makeTernary(InsnGen.java:896)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:477)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:313)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE  (r0v1 java.util.Spliterator<java.util.Map$Entry<K, V>>) = 
                              (wrap: int : 0x0000: INVOKE  (r0v0 int) = (r3v0 'this' com.google.common.collect.ImmutableSortedMap$1EntrySet$1 A[THIS]) type: VIRTUAL call: com.google.common.collect.ImmutableSortedMap.1EntrySet.1.size():int)
                              (1297 int)
                              (wrap: com.google.common.collect.-$$Lambda$7PoTp3aIQo7HSLflqKWOsi7MUOA : 0x0006: CONSTRUCTOR  (r1v0 com.google.common.collect.-$$Lambda$7PoTp3aIQo7HSLflqKWOsi7MUOA) = (r3v0 'this' com.google.common.collect.ImmutableSortedMap$1EntrySet$1 A[THIS]) call: com.google.common.collect.-$$Lambda$7PoTp3aIQo7HSLflqKWOsi7MUOA.<init>(com.google.common.collect.ImmutableSortedMap$1EntrySet$1):void type: CONSTRUCTOR)
                             type: STATIC call: com.google.common.collect.CollectSpliterators.indexed(int, int, java.util.function.IntFunction):java.util.Spliterator in method: com.google.common.collect.ImmutableSortedMap.1EntrySet.1.spliterator():java.util.Spliterator<java.util.Map$Entry<K, V>>, dex: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:313)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 96 more
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0006: CONSTRUCTOR  (r1v0 com.google.common.collect.-$$Lambda$7PoTp3aIQo7HSLflqKWOsi7MUOA) = (r3v0 'this' com.google.common.collect.ImmutableSortedMap$1EntrySet$1 A[THIS]) call: com.google.common.collect.-$$Lambda$7PoTp3aIQo7HSLflqKWOsi7MUOA.<init>(com.google.common.collect.ImmutableSortedMap$1EntrySet$1):void type: CONSTRUCTOR in method: com.google.common.collect.ImmutableSortedMap.1EntrySet.1.spliterator():java.util.Spliterator<java.util.Map$Entry<K, V>>, dex: classes3.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 100 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.common.collect.-$$Lambda$7PoTp3aIQo7HSLflqKWOsi7MUOA, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 106 more
                            */
                        /*
                            this = this;
                            int r0 = r3.size()
                            com.google.common.collect.-$$Lambda$7PoTp3aIQo7HSLflqKWOsi7MUOA r1 = new com.google.common.collect.-$$Lambda$7PoTp3aIQo7HSLflqKWOsi7MUOA
                            r1.<init>(r3)
                            r2 = 1297(0x511, float:1.817E-42)
                            java.util.Spliterator r0 = com.google.common.collect.CollectSpliterators.indexed(r0, r2, r1)
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ImmutableSortedMap.AnonymousClass1EntrySet.AnonymousClass1.spliterator():java.util.Spliterator");
                    }

                    /* access modifiers changed from: package-private */
                    public ImmutableCollection<Map.Entry<K, V>> delegateCollection() {
                        return AnonymousClass1EntrySet.this;
                    }
                };
            }

            /* access modifiers changed from: package-private */
            public ImmutableMap<K, V> map() {
                return ImmutableSortedMap.this;
            }
        };
    }

    public final ImmutableSortedSet<K> keySet() {
        return this.keySet;
    }

    /* access modifiers changed from: package-private */
    public final ImmutableSet<K> createKeySet() {
        throw new AssertionError("should never be called");
    }

    public final ImmutableCollection<V> values() {
        return this.valueList;
    }

    /* access modifiers changed from: package-private */
    public final ImmutableCollection<V> createValues() {
        throw new AssertionError("should never be called");
    }

    public final Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    public final K firstKey() {
        return keySet().first();
    }

    public final K lastKey() {
        return keySet().last();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableList.subList(int, int):com.google.common.collect.ImmutableList<E>
     arg types: [int, int]
     candidates:
      com.google.common.collect.ImmutableList.subList(int, int):java.util.List
      ClspMth{java.util.List.subList(int, int):java.util.List<E>}
      com.google.common.collect.ImmutableList.subList(int, int):com.google.common.collect.ImmutableList<E> */
    private ImmutableSortedMap<K, V> getSubMap(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        if (i == i2) {
            return emptyMap(comparator());
        }
        return new ImmutableSortedMap<>(this.keySet.getSubSet(i, i2), this.valueList.subList(i, i2));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedMap.headMap(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedMap<K, V>
     arg types: [K, int]
     candidates:
      com.google.common.collect.ImmutableSortedMap.headMap(java.lang.Object, boolean):java.util.NavigableMap
      ClspMth{java.util.NavigableMap.headMap(java.lang.Object, boolean):java.util.NavigableMap<K, V>}
      com.google.common.collect.ImmutableSortedMap.headMap(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedMap<K, V> */
    public final ImmutableSortedMap<K, V> headMap(K k) {
        return headMap((Object) k, false);
    }

    public final ImmutableSortedMap<K, V> headMap(K k, boolean z) {
        return getSubMap(0, this.keySet.headIndex(Preconditions.checkNotNull(k), z));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedMap.subMap(java.lang.Object, boolean, java.lang.Object, boolean):com.google.common.collect.ImmutableSortedMap<K, V>
     arg types: [K, int, K, int]
     candidates:
      com.google.common.collect.ImmutableSortedMap.subMap(java.lang.Object, boolean, java.lang.Object, boolean):java.util.NavigableMap
      ClspMth{java.util.NavigableMap.subMap(java.lang.Object, boolean, java.lang.Object, boolean):java.util.NavigableMap<K, V>}
      com.google.common.collect.ImmutableSortedMap.subMap(java.lang.Object, boolean, java.lang.Object, boolean):com.google.common.collect.ImmutableSortedMap<K, V> */
    public final ImmutableSortedMap<K, V> subMap(K k, K k2) {
        return subMap((Object) k, true, (Object) k2, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedMap.tailMap(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedMap<K, V>
     arg types: [K, boolean]
     candidates:
      com.google.common.collect.ImmutableSortedMap.tailMap(java.lang.Object, boolean):java.util.NavigableMap
      ClspMth{java.util.NavigableMap.tailMap(java.lang.Object, boolean):java.util.NavigableMap<K, V>}
      com.google.common.collect.ImmutableSortedMap.tailMap(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedMap<K, V> */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedMap.headMap(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedMap<K, V>
     arg types: [K, boolean]
     candidates:
      com.google.common.collect.ImmutableSortedMap.headMap(java.lang.Object, boolean):java.util.NavigableMap
      ClspMth{java.util.NavigableMap.headMap(java.lang.Object, boolean):java.util.NavigableMap<K, V>}
      com.google.common.collect.ImmutableSortedMap.headMap(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedMap<K, V> */
    public final ImmutableSortedMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(k2);
        Preconditions.checkArgument(comparator().compare(k, k2) <= 0, "expected fromKey <= toKey but %s > %s", k, k2);
        return headMap((Object) k2, z2).tailMap((Object) k, z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedMap.tailMap(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedMap<K, V>
     arg types: [K, int]
     candidates:
      com.google.common.collect.ImmutableSortedMap.tailMap(java.lang.Object, boolean):java.util.NavigableMap
      ClspMth{java.util.NavigableMap.tailMap(java.lang.Object, boolean):java.util.NavigableMap<K, V>}
      com.google.common.collect.ImmutableSortedMap.tailMap(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedMap<K, V> */
    public final ImmutableSortedMap<K, V> tailMap(K k) {
        return tailMap((Object) k, true);
    }

    public final ImmutableSortedMap<K, V> tailMap(K k, boolean z) {
        return getSubMap(this.keySet.tailIndex(Preconditions.checkNotNull(k), z), size());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedMap.headMap(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedMap<K, V>
     arg types: [K, int]
     candidates:
      com.google.common.collect.ImmutableSortedMap.headMap(java.lang.Object, boolean):java.util.NavigableMap
      ClspMth{java.util.NavigableMap.headMap(java.lang.Object, boolean):java.util.NavigableMap<K, V>}
      com.google.common.collect.ImmutableSortedMap.headMap(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedMap<K, V> */
    public final Map.Entry<K, V> lowerEntry(K k) {
        return headMap((Object) k, false).lastEntry();
    }

    public final K lowerKey(K k) {
        return Maps.keyOrNull(lowerEntry(k));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedMap.headMap(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedMap<K, V>
     arg types: [K, int]
     candidates:
      com.google.common.collect.ImmutableSortedMap.headMap(java.lang.Object, boolean):java.util.NavigableMap
      ClspMth{java.util.NavigableMap.headMap(java.lang.Object, boolean):java.util.NavigableMap<K, V>}
      com.google.common.collect.ImmutableSortedMap.headMap(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedMap<K, V> */
    public final Map.Entry<K, V> floorEntry(K k) {
        return headMap((Object) k, true).lastEntry();
    }

    public final K floorKey(K k) {
        return Maps.keyOrNull(floorEntry(k));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedMap.tailMap(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedMap<K, V>
     arg types: [K, int]
     candidates:
      com.google.common.collect.ImmutableSortedMap.tailMap(java.lang.Object, boolean):java.util.NavigableMap
      ClspMth{java.util.NavigableMap.tailMap(java.lang.Object, boolean):java.util.NavigableMap<K, V>}
      com.google.common.collect.ImmutableSortedMap.tailMap(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedMap<K, V> */
    public final Map.Entry<K, V> ceilingEntry(K k) {
        return tailMap((Object) k, true).firstEntry();
    }

    public final K ceilingKey(K k) {
        return Maps.keyOrNull(ceilingEntry(k));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedMap.tailMap(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedMap<K, V>
     arg types: [K, int]
     candidates:
      com.google.common.collect.ImmutableSortedMap.tailMap(java.lang.Object, boolean):java.util.NavigableMap
      ClspMth{java.util.NavigableMap.tailMap(java.lang.Object, boolean):java.util.NavigableMap<K, V>}
      com.google.common.collect.ImmutableSortedMap.tailMap(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedMap<K, V> */
    public final Map.Entry<K, V> higherEntry(K k) {
        return tailMap((Object) k, false).firstEntry();
    }

    public final K higherKey(K k) {
        return Maps.keyOrNull(higherEntry(k));
    }

    public final Map.Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().asList().get(0);
    }

    public final Map.Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().asList().get(size() - 1);
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public final ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> immutableSortedMap = this.descendingMap;
        if (immutableSortedMap != null) {
            return immutableSortedMap;
        }
        if (isEmpty()) {
            return emptyMap(Ordering.from(comparator()).reverse());
        }
        return new ImmutableSortedMap<>((RegularImmutableSortedSet) this.keySet.descendingSet(), this.valueList.reverse(), this);
    }

    public final ImmutableSortedSet<K> navigableKeySet() {
        return this.keySet;
    }

    public final ImmutableSortedSet<K> descendingKeySet() {
        return this.keySet.descendingSet();
    }

    static class SerializedForm extends ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0;
        private final Comparator<Object> comparator;

        SerializedForm(ImmutableSortedMap<?, ?> immutableSortedMap) {
            super(immutableSortedMap);
            this.comparator = immutableSortedMap.comparator();
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return createMap(new Builder(this.comparator));
        }
    }

    /* access modifiers changed from: package-private */
    public final Object writeReplace() {
        return new SerializedForm(this);
    }
}
