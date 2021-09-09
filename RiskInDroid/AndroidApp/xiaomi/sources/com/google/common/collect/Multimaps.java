package com.google.common.collect;

import com.google.auto.common.BasicAnnotationProcessor;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Sets;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

@GwtCompatible(emulated = true)
public final class Multimaps {
    private Multimaps() {
    }

    @Beta
    public static <T, K, V, M extends Multimap<K, V>> Collector<T, ?, M> toMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, Supplier<M> supplier) {
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(function2);
        Preconditions.checkNotNull(supplier);
        return Collector.of(supplier, new BiConsumer(function, function2) {
            /* class com.google.common.collect.$$Lambda$Multimaps$zBBJ4jROVwwBTKEHXtJrmYAg */
            private final /* synthetic */ Function f$0;
            private final /* synthetic */ Function f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void accept(Object obj, Object obj2) {
                ((Multimap) obj).put(this.f$0.apply(obj2), this.f$1.apply(obj2));
            }
        }, $$Lambda$Multimaps$3e8JKtUKONJRv94EWa38FL3Y4.INSTANCE, new Collector.Characteristics[0]);
    }

    @Beta
    public static <T, K, V, M extends Multimap<K, V>> Collector<T, ?, M> flatteningToMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends Stream<? extends V>> function2, Supplier<M> supplier) {
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(function2);
        Preconditions.checkNotNull(supplier);
        return Collector.of(supplier, new BiConsumer(function, function2) {
            /* class com.google.common.collect.$$Lambda$Multimaps$OwsOFq4RH6ujyGBgLd28yfGSmIg */
            private final /* synthetic */ Function f$0;
            private final /* synthetic */ Function f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void accept(Object obj, Object obj2) {
                Multimaps.lambda$flatteningToMultimap$2(this.f$0, this.f$1, (Multimap) obj, obj2);
            }
        }, $$Lambda$Multimaps$EGqBcBjNFW4VPyKfp3wZs77_0A.INSTANCE, new Collector.Characteristics[0]);
    }

    static /* synthetic */ void lambda$flatteningToMultimap$2(Function function, Function function2, Multimap multimap, Object obj) {
        Collection collection = multimap.get(function.apply(obj));
        collection.getClass();
        ((Stream) function2.apply(obj)).forEachOrdered(new Consumer(collection) {
            /* class com.google.common.collect.$$Lambda$CMyQKLwBy0EAPqyDBUlb1AohkGk */
            private final /* synthetic */ Collection f$0;

            {
                this.f$0 = r1;
            }

            public final void accept(Object obj) {
                this.f$0.add(obj);
            }
        });
    }

    public static <K, V> Multimap<K, V> newMultimap(Map<K, Collection<V>> map, com.google.common.base.Supplier<? extends Collection<V>> supplier) {
        return new CustomMultimap(map, supplier);
    }

    static class CustomMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
        @GwtIncompatible
        private static final long serialVersionUID = 0;
        transient com.google.common.base.Supplier<? extends Collection<V>> factory;

        CustomMultimap(Map<K, Collection<V>> map, com.google.common.base.Supplier<? extends Collection<V>> supplier) {
            super(map);
            this.factory = (com.google.common.base.Supplier) Preconditions.checkNotNull(supplier);
        }

        /* access modifiers changed from: package-private */
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        /* access modifiers changed from: package-private */
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        /* access modifiers changed from: protected */
        public Collection<V> createCollection() {
            return (Collection) this.factory.get();
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [java.util.Collection<E>, java.util.Collection] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Unknown variable types count: 1 */
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> r2) {
            if (r2 instanceof NavigableSet) {
                return Sets.unmodifiableNavigableSet((NavigableSet) r2);
            }
            if (r2 instanceof SortedSet) {
                return Collections.unmodifiableSortedSet((SortedSet) r2);
            }
            if (r2 instanceof Set) {
                return Collections.unmodifiableSet((Set) r2);
            }
            if (r2 instanceof List) {
                return Collections.unmodifiableList((List) r2);
            }
            return Collections.unmodifiableCollection(r2);
        }

        /* access modifiers changed from: package-private */
        public Collection<V> wrapCollection(K k, Collection<V> collection) {
            if (collection instanceof List) {
                return wrapList(k, (List) collection, null);
            }
            if (collection instanceof NavigableSet) {
                return new AbstractMapBasedMultimap.WrappedNavigableSet(k, (NavigableSet) collection, null);
            }
            if (collection instanceof SortedSet) {
                return new AbstractMapBasedMultimap.WrappedSortedSet(k, (SortedSet) collection, null);
            }
            if (collection instanceof Set) {
                return new AbstractMapBasedMultimap.WrappedSet(k, (Set) collection);
            }
            return new AbstractMapBasedMultimap.WrappedCollection(k, collection, null);
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (com.google.common.base.Supplier) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }
    }

    public static <K, V> ListMultimap<K, V> newListMultimap(Map<K, Collection<V>> map, com.google.common.base.Supplier<? extends List<V>> supplier) {
        return new CustomListMultimap(map, supplier);
    }

    static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
        @GwtIncompatible
        private static final long serialVersionUID = 0;
        transient com.google.common.base.Supplier<? extends List<V>> factory;

        CustomListMultimap(Map<K, Collection<V>> map, com.google.common.base.Supplier<? extends List<V>> supplier) {
            super(map);
            this.factory = (com.google.common.base.Supplier) Preconditions.checkNotNull(supplier);
        }

        /* access modifiers changed from: package-private */
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        /* access modifiers changed from: package-private */
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        /* access modifiers changed from: protected */
        public List<V> createCollection() {
            return (List) this.factory.get();
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (com.google.common.base.Supplier) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }
    }

    public static <K, V> SetMultimap<K, V> newSetMultimap(Map<K, Collection<V>> map, com.google.common.base.Supplier<? extends Set<V>> supplier) {
        return new CustomSetMultimap(map, supplier);
    }

    static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
        @GwtIncompatible
        private static final long serialVersionUID = 0;
        transient com.google.common.base.Supplier<? extends Set<V>> factory;

        CustomSetMultimap(Map<K, Collection<V>> map, com.google.common.base.Supplier<? extends Set<V>> supplier) {
            super(map);
            this.factory = (com.google.common.base.Supplier) Preconditions.checkNotNull(supplier);
        }

        /* access modifiers changed from: package-private */
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        /* access modifiers changed from: package-private */
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        /* access modifiers changed from: protected */
        public Set<V> createCollection() {
            return (Set) this.factory.get();
        }

        /* access modifiers changed from: package-private */
        public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
            if (collection instanceof NavigableSet) {
                return Sets.unmodifiableNavigableSet((NavigableSet) collection);
            }
            if (collection instanceof SortedSet) {
                return Collections.unmodifiableSortedSet((SortedSet) collection);
            }
            return Collections.unmodifiableSet((Set) collection);
        }

        /* access modifiers changed from: package-private */
        public Collection<V> wrapCollection(K k, Collection<V> collection) {
            if (collection instanceof NavigableSet) {
                return new AbstractMapBasedMultimap.WrappedNavigableSet(k, (NavigableSet) collection, null);
            }
            if (collection instanceof SortedSet) {
                return new AbstractMapBasedMultimap.WrappedSortedSet(k, (SortedSet) collection, null);
            }
            return new AbstractMapBasedMultimap.WrappedSet(k, (Set) collection);
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (com.google.common.base.Supplier) objectInputStream.readObject();
            setMap((Map) objectInputStream.readObject());
        }
    }

    public static <K, V> SortedSetMultimap<K, V> newSortedSetMultimap(Map<K, Collection<V>> map, com.google.common.base.Supplier<? extends SortedSet<V>> supplier) {
        return new CustomSortedSetMultimap(map, supplier);
    }

    static class CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
        @GwtIncompatible
        private static final long serialVersionUID = 0;
        transient com.google.common.base.Supplier<? extends SortedSet<V>> factory;
        transient Comparator<? super V> valueComparator;

        CustomSortedSetMultimap(Map<K, Collection<V>> map, com.google.common.base.Supplier<? extends SortedSet<V>> supplier) {
            super(map);
            this.factory = (com.google.common.base.Supplier) Preconditions.checkNotNull(supplier);
            this.valueComparator = ((SortedSet) supplier.get()).comparator();
        }

        /* access modifiers changed from: package-private */
        public Set<K> createKeySet() {
            return createMaybeNavigableKeySet();
        }

        /* access modifiers changed from: package-private */
        public Map<K, Collection<V>> createAsMap() {
            return createMaybeNavigableAsMap();
        }

        /* access modifiers changed from: protected */
        public SortedSet<V> createCollection() {
            return (SortedSet) this.factory.get();
        }

        public Comparator<? super V> valueComparator() {
            return this.valueComparator;
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.factory);
            objectOutputStream.writeObject(backingMap());
        }

        @GwtIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.factory = (com.google.common.base.Supplier) objectInputStream.readObject();
            this.valueComparator = ((SortedSet) this.factory.get()).comparator();
            setMap((Map) objectInputStream.readObject());
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: M
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public static <K, V, M extends com.google.common.collect.Multimap<K, V>> M invertFrom(com.google.common.collect.Multimap<? extends V, ? extends K> r2, M r3) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r3)
            java.util.Collection r2 = r2.entries()
            java.util.Iterator r2 = r2.iterator()
        L_0x000b:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0023
            java.lang.Object r0 = r2.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getValue()
            java.lang.Object r0 = r0.getKey()
            r3.put(r1, r0)
            goto L_0x000b
        L_0x0023:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Multimaps.invertFrom(com.google.common.collect.Multimap, com.google.common.collect.Multimap):com.google.common.collect.Multimap");
    }

    public static <K, V> Multimap<K, V> synchronizedMultimap(Multimap<K, V> multimap) {
        return Synchronized.multimap(multimap, null);
    }

    public static <K, V> Multimap<K, V> unmodifiableMultimap(Multimap<K, V> multimap) {
        return ((multimap instanceof UnmodifiableMultimap) || (multimap instanceof ImmutableMultimap)) ? multimap : new UnmodifiableMultimap(multimap);
    }

    @Deprecated
    public static <K, V> Multimap<K, V> unmodifiableMultimap(ImmutableMultimap<K, V> immutableMultimap) {
        return (Multimap) Preconditions.checkNotNull(immutableMultimap);
    }

    static class UnmodifiableMultimap<K, V> extends ForwardingMultimap<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final Multimap<K, V> delegate;
        transient Collection<Map.Entry<K, V>> entries;
        transient Set<K> keySet;
        transient Multiset<K> keys;
        transient Map<K, Collection<V>> map;
        transient Collection<V> values;

        UnmodifiableMultimap(Multimap<K, V> multimap) {
            this.delegate = (Multimap) Preconditions.checkNotNull(multimap);
        }

        /* access modifiers changed from: protected */
        public Multimap<K, V> delegate() {
            return this.delegate;
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map2 = this.map;
            if (map2 != null) {
                return map2;
            }
            Map<K, V2> unmodifiableMap = Collections.unmodifiableMap(Maps.transformValues(this.delegate.asMap(), new com.google.common.base.Function<Collection<V>, Collection<V>>() {
                /* class com.google.common.collect.Multimaps.UnmodifiableMultimap.AnonymousClass1 */

                public Collection<V> apply(Collection<V> collection) {
                    return Multimaps.unmodifiableValueCollection(collection);
                }
            }));
            this.map = unmodifiableMap;
            return unmodifiableMap;
        }

        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> collection = this.entries;
            if (collection != null) {
                return collection;
            }
            Collection<Map.Entry<K, V>> unmodifiableEntries = Multimaps.unmodifiableEntries(this.delegate.entries());
            this.entries = unmodifiableEntries;
            return unmodifiableEntries;
        }

        public Collection<V> get(K k) {
            return Multimaps.unmodifiableValueCollection(this.delegate.get(k));
        }

        public Multiset<K> keys() {
            Multiset<K> multiset = this.keys;
            if (multiset != null) {
                return multiset;
            }
            Multiset<K> unmodifiableMultiset = Multisets.unmodifiableMultiset(this.delegate.keys());
            this.keys = unmodifiableMultiset;
            return unmodifiableMultiset;
        }

        public Set<K> keySet() {
            Set<K> set = this.keySet;
            if (set != null) {
                return set;
            }
            Set<K> unmodifiableSet = Collections.unmodifiableSet(this.delegate.keySet());
            this.keySet = unmodifiableSet;
            return unmodifiableSet;
        }

        public boolean put(K k, V v) {
            throw new UnsupportedOperationException();
        }

        public boolean putAll(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            throw new UnsupportedOperationException();
        }

        public boolean remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        public Collection<V> removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        public Collection<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        public Collection<V> values() {
            Collection<V> collection = this.values;
            if (collection != null) {
                return collection;
            }
            Collection<V> unmodifiableCollection = Collections.unmodifiableCollection(this.delegate.values());
            this.values = unmodifiableCollection;
            return unmodifiableCollection;
        }
    }

    static class UnmodifiableListMultimap<K, V> extends UnmodifiableMultimap<K, V> implements ListMultimap<K, V> {
        private static final long serialVersionUID = 0;

        UnmodifiableListMultimap(ListMultimap<K, V> listMultimap) {
            super(listMultimap);
        }

        public ListMultimap<K, V> delegate() {
            return (ListMultimap) super.delegate();
        }

        public List<V> get(K k) {
            return Collections.unmodifiableList(delegate().get((Object) k));
        }

        public List<V> removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    static class UnmodifiableSetMultimap<K, V> extends UnmodifiableMultimap<K, V> implements SetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        public /* synthetic */ void forEach(BiConsumer<? super K, ? super V> biConsumer) {
            Multimap.CC.$default$forEach(this, biConsumer);
        }

        UnmodifiableSetMultimap(SetMultimap<K, V> setMultimap) {
            super(setMultimap);
        }

        public SetMultimap<K, V> delegate() {
            return (SetMultimap) super.delegate();
        }

        public Set<V> get(K k) {
            return Collections.unmodifiableSet(delegate().get((BasicAnnotationProcessor.ProcessingStep) k));
        }

        public Set<Map.Entry<K, V>> entries() {
            return Maps.unmodifiableEntrySet(delegate().entries());
        }

        public Set<V> removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    static class UnmodifiableSortedSetMultimap<K, V> extends UnmodifiableSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        public /* synthetic */ void forEach(BiConsumer<? super K, ? super V> biConsumer) {
            Multimap.CC.$default$forEach(this, biConsumer);
        }

        UnmodifiableSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap) {
            super(sortedSetMultimap);
        }

        public SortedSetMultimap<K, V> delegate() {
            return (SortedSetMultimap) super.delegate();
        }

        public SortedSet<V> get(K k) {
            return Collections.unmodifiableSortedSet(delegate().get((Object) k));
        }

        public SortedSet<V> removeAll(Object obj) {
            throw new UnsupportedOperationException();
        }

        public SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        public Comparator<? super V> valueComparator() {
            return delegate().valueComparator();
        }
    }

    public static <K, V> SetMultimap<K, V> synchronizedSetMultimap(SetMultimap<K, V> setMultimap) {
        return Synchronized.setMultimap(setMultimap, null);
    }

    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(SetMultimap<K, V> setMultimap) {
        return ((setMultimap instanceof UnmodifiableSetMultimap) || (setMultimap instanceof ImmutableSetMultimap)) ? setMultimap : new UnmodifiableSetMultimap(setMultimap);
    }

    @Deprecated
    public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(ImmutableSetMultimap<K, V> immutableSetMultimap) {
        return (SetMultimap) Preconditions.checkNotNull(immutableSetMultimap);
    }

    public static <K, V> SortedSetMultimap<K, V> synchronizedSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap) {
        return Synchronized.sortedSetMultimap(sortedSetMultimap, null);
    }

    public static <K, V> SortedSetMultimap<K, V> unmodifiableSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap) {
        if (sortedSetMultimap instanceof UnmodifiableSortedSetMultimap) {
            return sortedSetMultimap;
        }
        return new UnmodifiableSortedSetMultimap(sortedSetMultimap);
    }

    public static <K, V> ListMultimap<K, V> synchronizedListMultimap(ListMultimap<K, V> listMultimap) {
        return Synchronized.listMultimap(listMultimap, null);
    }

    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ListMultimap<K, V> listMultimap) {
        return ((listMultimap instanceof UnmodifiableListMultimap) || (listMultimap instanceof ImmutableListMultimap)) ? listMultimap : new UnmodifiableListMultimap(listMultimap);
    }

    @Deprecated
    public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ImmutableListMultimap<K, V> immutableListMultimap) {
        return (ListMultimap) Preconditions.checkNotNull(immutableListMultimap);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Collection<V>, java.util.Collection] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static <V> Collection<V> unmodifiableValueCollection(Collection<V> r1) {
        if (r1 instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) r1);
        }
        if (r1 instanceof Set) {
            return Collections.unmodifiableSet((Set) r1);
        }
        if (r1 instanceof List) {
            return Collections.unmodifiableList((List) r1);
        }
        return Collections.unmodifiableCollection(r1);
    }

    public static <K, V> Collection<Map.Entry<K, V>> unmodifiableEntries(Collection<Map.Entry<K, V>> collection) {
        if (collection instanceof Set) {
            return Maps.unmodifiableEntrySet((Set) collection);
        }
        return new Maps.UnmodifiableEntries(Collections.unmodifiableCollection(collection));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.ListMultimap<K, V>, com.google.common.collect.ListMultimap] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Beta
    public static <K, V> Map<K, List<V>> asMap(ListMultimap<K, V> r0) {
        return r0.asMap();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.SetMultimap<K, V>, com.google.common.collect.SetMultimap] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Beta
    public static <K, V> Map<K, Set<V>> asMap(SetMultimap<K, V> r0) {
        return r0.asMap();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.SortedSetMultimap<K, V>, com.google.common.collect.SortedSetMultimap] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Beta
    public static <K, V> Map<K, SortedSet<V>> asMap(SortedSetMultimap<K, V> r0) {
        return r0.asMap();
    }

    @Beta
    public static <K, V> Map<K, Collection<V>> asMap(Multimap<K, V> multimap) {
        return multimap.asMap();
    }

    public static <K, V> SetMultimap<K, V> forMap(Map<K, V> map) {
        return new MapMultimap(map);
    }

    static class MapMultimap<K, V> extends AbstractMultimap<K, V> implements SetMultimap<K, V>, Serializable {
        private static final long serialVersionUID = 7845222491160860175L;
        final Map<K, V> map;

        MapMultimap(Map<K, V> map2) {
            this.map = (Map) Preconditions.checkNotNull(map2);
        }

        public int size() {
            return this.map.size();
        }

        public boolean containsKey(Object obj) {
            return this.map.containsKey(obj);
        }

        public boolean containsValue(Object obj) {
            return this.map.containsValue(obj);
        }

        public boolean containsEntry(Object obj, Object obj2) {
            return this.map.entrySet().contains(Maps.immutableEntry(obj, obj2));
        }

        public Set<V> get(final K k) {
            return new Sets.ImprovedAbstractSet<V>() {
                /* class com.google.common.collect.Multimaps.MapMultimap.AnonymousClass1 */

                public Iterator<V> iterator() {
                    return new Iterator<V>() {
                        /* class com.google.common.collect.Multimaps.MapMultimap.AnonymousClass1.AnonymousClass1 */
                        int i;

                        public boolean hasNext() {
                            return this.i == 0 && MapMultimap.this.map.containsKey(k);
                        }

                        public V next() {
                            if (hasNext()) {
                                this.i++;
                                return MapMultimap.this.map.get(k);
                            }
                            throw new NoSuchElementException();
                        }

                        public void remove() {
                            boolean z = true;
                            if (this.i != 1) {
                                z = false;
                            }
                            CollectPreconditions.checkRemove(z);
                            this.i = -1;
                            MapMultimap.this.map.remove(k);
                        }
                    };
                }

                public int size() {
                    return MapMultimap.this.map.containsKey(k) ? 1 : 0;
                }
            };
        }

        public boolean put(K k, V v) {
            throw new UnsupportedOperationException();
        }

        public boolean putAll(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            throw new UnsupportedOperationException();
        }

        public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        public boolean remove(Object obj, Object obj2) {
            return this.map.entrySet().remove(Maps.immutableEntry(obj, obj2));
        }

        public Set<V> removeAll(Object obj) {
            HashSet hashSet = new HashSet(2);
            if (!this.map.containsKey(obj)) {
                return hashSet;
            }
            hashSet.add(this.map.remove(obj));
            return hashSet;
        }

        public void clear() {
            this.map.clear();
        }

        /* access modifiers changed from: package-private */
        public Set<K> createKeySet() {
            return this.map.keySet();
        }

        /* access modifiers changed from: package-private */
        public Collection<V> createValues() {
            return this.map.values();
        }

        public Set<Map.Entry<K, V>> entries() {
            return this.map.entrySet();
        }

        /* access modifiers changed from: package-private */
        public Collection<Map.Entry<K, V>> createEntries() {
            throw new AssertionError("unreachable");
        }

        /* access modifiers changed from: package-private */
        public Multiset<K> createKeys() {
            return new Keys(this);
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V>> entryIterator() {
            return this.map.entrySet().iterator();
        }

        /* access modifiers changed from: package-private */
        public Map<K, Collection<V>> createAsMap() {
            return new AsMap(this);
        }

        public int hashCode() {
            return this.map.hashCode();
        }
    }

    public static <K, V1, V2> Multimap<K, V2> transformValues(Multimap<K, V1> multimap, com.google.common.base.Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return transformEntries(multimap, Maps.asEntryTransformer(function));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Multimaps.transformEntries(com.google.common.collect.ListMultimap, com.google.common.collect.Maps$EntryTransformer):com.google.common.collect.ListMultimap<K, V2>
     arg types: [com.google.common.collect.ListMultimap<K, V1>, com.google.common.collect.Maps$EntryTransformer<K, V1, V2>]
     candidates:
      com.google.common.collect.Multimaps.transformEntries(com.google.common.collect.Multimap, com.google.common.collect.Maps$EntryTransformer):com.google.common.collect.Multimap<K, V2>
      com.google.common.collect.Multimaps.transformEntries(com.google.common.collect.ListMultimap, com.google.common.collect.Maps$EntryTransformer):com.google.common.collect.ListMultimap<K, V2> */
    public static <K, V1, V2> ListMultimap<K, V2> transformValues(ListMultimap<K, V1> listMultimap, com.google.common.base.Function<? super V1, V2> function) {
        Preconditions.checkNotNull(function);
        return transformEntries((ListMultimap) listMultimap, (Maps.EntryTransformer) Maps.asEntryTransformer(function));
    }

    public static <K, V1, V2> Multimap<K, V2> transformEntries(Multimap<K, V1> multimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new TransformedEntriesMultimap(multimap, entryTransformer);
    }

    public static <K, V1, V2> ListMultimap<K, V2> transformEntries(ListMultimap<K, V1> listMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new TransformedEntriesListMultimap(listMultimap, entryTransformer);
    }

    static class TransformedEntriesMultimap<K, V1, V2> extends AbstractMultimap<K, V2> {
        final Multimap<K, V1> fromMultimap;
        final Maps.EntryTransformer<? super K, ? super V1, V2> transformer;

        TransformedEntriesMultimap(Multimap<K, V1> multimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            this.fromMultimap = (Multimap) Preconditions.checkNotNull(multimap);
            this.transformer = (Maps.EntryTransformer) Preconditions.checkNotNull(entryTransformer);
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [java.util.Collection, java.util.Collection<V1>] */
        /* access modifiers changed from: package-private */
        /* JADX WARNING: Unknown variable types count: 1 */
        public Collection<V2> transform(K k, Collection<V1> r3) {
            com.google.common.base.Function<? super V1, V2> asValueToValueFunction = Maps.asValueToValueFunction(this.transformer, k);
            if (r3 instanceof List) {
                return Lists.transform((List) r3, asValueToValueFunction);
            }
            return Collections2.transform(r3, asValueToValueFunction);
        }

        /* access modifiers changed from: package-private */
        public Map<K, Collection<V2>> createAsMap() {
            return Maps.transformEntries(this.fromMultimap.asMap(), new Maps.EntryTransformer<K, Collection<V1>, Collection<V2>>() {
                /* class com.google.common.collect.Multimaps.TransformedEntriesMultimap.AnonymousClass1 */

                public Collection<V2> transformEntry(K k, Collection<V1> collection) {
                    return TransformedEntriesMultimap.this.transform(k, collection);
                }
            });
        }

        public void clear() {
            this.fromMultimap.clear();
        }

        public boolean containsKey(Object obj) {
            return this.fromMultimap.containsKey(obj);
        }

        /* access modifiers changed from: package-private */
        public Collection<Map.Entry<K, V2>> createEntries() {
            return new AbstractMultimap.Entries();
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V2>> entryIterator() {
            return Iterators.transform(this.fromMultimap.entries().iterator(), Maps.asEntryToEntryFunction(this.transformer));
        }

        public Collection<V2> get(K k) {
            return transform(k, this.fromMultimap.get(k));
        }

        public boolean isEmpty() {
            return this.fromMultimap.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public Set<K> createKeySet() {
            return this.fromMultimap.keySet();
        }

        /* access modifiers changed from: package-private */
        public Multiset<K> createKeys() {
            return this.fromMultimap.keys();
        }

        public boolean put(K k, V2 v2) {
            throw new UnsupportedOperationException();
        }

        public boolean putAll(K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        public boolean putAll(Multimap<? extends K, ? extends V2> multimap) {
            throw new UnsupportedOperationException();
        }

        public boolean remove(Object obj, Object obj2) {
            return get(obj).remove(obj2);
        }

        public Collection<V2> removeAll(Object obj) {
            return transform(obj, this.fromMultimap.removeAll(obj));
        }

        public Collection<V2> replaceValues(K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return this.fromMultimap.size();
        }

        /* access modifiers changed from: package-private */
        public Collection<V2> createValues() {
            return Collections2.transform(this.fromMultimap.entries(), Maps.asEntryToValueFunction(this.transformer));
        }
    }

    static final class TransformedEntriesListMultimap<K, V1, V2> extends TransformedEntriesMultimap<K, V1, V2> implements ListMultimap<K, V2> {
        public /* synthetic */ void forEach(BiConsumer<? super K, ? super V> biConsumer) {
            Multimap.CC.$default$forEach(this, biConsumer);
        }

        TransformedEntriesListMultimap(ListMultimap<K, V1> listMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(listMultimap, entryTransformer);
        }

        /* access modifiers changed from: package-private */
        public final List<V2> transform(K k, Collection<V1> collection) {
            return Lists.transform((List) collection, Maps.asValueToValueFunction(this.transformer, k));
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.Multimaps.TransformedEntriesListMultimap.transform(java.lang.Object, java.util.Collection):java.util.List<V2>
         arg types: [K, java.util.Collection]
         candidates:
          com.google.common.collect.Multimaps.TransformedEntriesListMultimap.transform(java.lang.Object, java.util.Collection):java.util.Collection
          com.google.common.collect.Multimaps.TransformedEntriesMultimap.transform(java.lang.Object, java.util.Collection):java.util.Collection<V2>
          com.google.common.collect.Multimaps.TransformedEntriesListMultimap.transform(java.lang.Object, java.util.Collection):java.util.List<V2> */
        public final List<V2> get(K k) {
            return transform((Object) k, this.fromMultimap.get(k));
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.Multimaps.TransformedEntriesListMultimap.transform(java.lang.Object, java.util.Collection):java.util.List<V2>
         arg types: [java.lang.Object, java.util.Collection]
         candidates:
          com.google.common.collect.Multimaps.TransformedEntriesListMultimap.transform(java.lang.Object, java.util.Collection):java.util.Collection
          com.google.common.collect.Multimaps.TransformedEntriesMultimap.transform(java.lang.Object, java.util.Collection):java.util.Collection<V2>
          com.google.common.collect.Multimaps.TransformedEntriesListMultimap.transform(java.lang.Object, java.util.Collection):java.util.List<V2> */
        public final List<V2> removeAll(Object obj) {
            return transform(obj, this.fromMultimap.removeAll(obj));
        }

        public final List<V2> replaceValues(K k, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }
    }

    public static <K, V> ImmutableListMultimap<K, V> index(Iterable iterable, com.google.common.base.Function function) {
        return index(iterable.iterator(), function);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V>
     arg types: [java.lang.Object, java.lang.Object]
     candidates:
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableMultimap$Builder
      com.google.common.collect.ImmutableMultimap.Builder.put(java.lang.Class<? extends java.lang.annotation.Annotation>, javax.lang.model.element.Element):com.google.common.collect.ImmutableMultimap$Builder<K, V>
      com.google.common.collect.ImmutableListMultimap.Builder.put(java.lang.Object, java.lang.Object):com.google.common.collect.ImmutableListMultimap$Builder<K, V> */
    public static <K, V> ImmutableListMultimap<K, V> index(Iterator it, com.google.common.base.Function function) {
        Preconditions.checkNotNull(function);
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        while (it.hasNext()) {
            Object next = it.next();
            Preconditions.checkNotNull(next, it);
            builder.put(function.apply(next), next);
        }
        return builder.build();
    }

    static class Keys<K, V> extends AbstractMultiset<K> {
        @Weak
        final Multimap<K, V> multimap;

        Keys(Multimap<K, V> multimap2) {
            this.multimap = multimap2;
        }

        /* access modifiers changed from: package-private */
        public Iterator<Multiset.Entry<K>> entryIterator() {
            return new TransformedIterator<Map.Entry<K, Collection<V>>, Multiset.Entry<K>>(this.multimap.asMap().entrySet().iterator()) {
                /* class com.google.common.collect.Multimaps.Keys.AnonymousClass1 */

                /* access modifiers changed from: package-private */
                public Multiset.Entry<K> transform(final Map.Entry<K, Collection<V>> entry) {
                    return new Multisets.AbstractEntry<K>() {
                        /* class com.google.common.collect.Multimaps.Keys.AnonymousClass1.AnonymousClass1 */

                        public K getElement() {
                            return entry.getKey();
                        }

                        public int getCount() {
                            return ((Collection) entry.getValue()).size();
                        }
                    };
                }
            };
        }

        public Spliterator<K> spliterator() {
            return CollectSpliterators.map(this.multimap.entries().spliterator(), $$Lambda$hFUlwGe7_RidLzlAlfUmdwML3h4.INSTANCE);
        }

        public void forEach(Consumer<? super K> consumer) {
            Preconditions.checkNotNull(consumer);
            this.multimap.entries().forEach(new Consumer(consumer) {
                /* class com.google.common.collect.$$Lambda$Multimaps$Keys$Gpr87NcFo5GtWsdYxwu1nUKoqc */
                private final /* synthetic */ Consumer f$0;

                {
                    this.f$0 = r1;
                }

                public final void accept(Object obj) {
                    this.f$0.accept(((Map.Entry) obj).getKey());
                }
            });
        }

        /* access modifiers changed from: package-private */
        public int distinctElements() {
            return this.multimap.asMap().size();
        }

        public int size() {
            return this.multimap.size();
        }

        public boolean contains(Object obj) {
            return this.multimap.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return Maps.keyIterator(this.multimap.entries().iterator());
        }

        public int count(Object obj) {
            Collection collection = (Collection) Maps.safeGet(this.multimap.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        public int remove(Object obj, int i) {
            CollectPreconditions.checkNonnegative(i, "occurrences");
            if (i == 0) {
                return count(obj);
            }
            Collection collection = (Collection) Maps.safeGet(this.multimap.asMap(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i >= size) {
                collection.clear();
            } else {
                Iterator it = collection.iterator();
                for (int i2 = 0; i2 < i; i2++) {
                    it.next();
                    it.remove();
                }
            }
            return size;
        }

        public void clear() {
            this.multimap.clear();
        }

        public Set<K> elementSet() {
            return this.multimap.keySet();
        }

        /* access modifiers changed from: package-private */
        public Iterator<K> elementIterator() {
            throw new AssertionError("should never be called");
        }
    }

    static abstract class Entries<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        /* access modifiers changed from: package-private */
        public abstract Multimap<K, V> multimap();

        Entries() {
        }

        public int size() {
            return multimap().size();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return multimap().containsEntry(entry.getKey(), entry.getValue());
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return multimap().remove(entry.getKey(), entry.getValue());
        }

        public void clear() {
            multimap().clear();
        }
    }

    static final class AsMap<K, V> extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
        @Weak
        public final Multimap<K, V> multimap;

        AsMap(Multimap<K, V> multimap2) {
            this.multimap = (Multimap) Preconditions.checkNotNull(multimap2);
        }

        public final int size() {
            return this.multimap.keySet().size();
        }

        /* access modifiers changed from: protected */
        public final Set<Map.Entry<K, Collection<V>>> createEntrySet() {
            return new EntrySet();
        }

        /* access modifiers changed from: package-private */
        public final void removeValuesForKey(Object obj) {
            this.multimap.keySet().remove(obj);
        }

        class EntrySet extends Maps.EntrySet<K, Collection<V>> {
            EntrySet() {
            }

            /* access modifiers changed from: package-private */
            public Map<K, Collection<V>> map() {
                return AsMap.this;
            }

            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return Maps.asMapEntryIterator(AsMap.this.multimap.keySet(), new com.google.common.base.Function<K, Collection<V>>() {
                    /* class com.google.common.collect.Multimaps.AsMap.EntrySet.AnonymousClass1 */

                    public Collection<V> apply(K k) {
                        return AsMap.this.multimap.get(k);
                    }
                });
            }

            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                AsMap.this.removeValuesForKey(((Map.Entry) obj).getKey());
                return true;
            }
        }

        public final Collection<V> get(Object obj) {
            if (containsKey(obj)) {
                return this.multimap.get(obj);
            }
            return null;
        }

        public final Collection<V> remove(Object obj) {
            if (containsKey(obj)) {
                return this.multimap.removeAll(obj);
            }
            return null;
        }

        public final Set<K> keySet() {
            return this.multimap.keySet();
        }

        public final boolean isEmpty() {
            return this.multimap.isEmpty();
        }

        public final boolean containsKey(Object obj) {
            return this.multimap.containsKey(obj);
        }

        public final void clear() {
            this.multimap.clear();
        }
    }

    public static <K, V> Multimap<K, V> filterKeys(Multimap multimap, Predicate predicate) {
        if (multimap instanceof SetMultimap) {
            return filterKeys((SetMultimap) multimap, predicate);
        }
        if (multimap instanceof ListMultimap) {
            return filterKeys((ListMultimap) multimap, predicate);
        }
        if (multimap instanceof FilteredKeyMultimap) {
            FilteredKeyMultimap filteredKeyMultimap = (FilteredKeyMultimap) multimap;
            return new FilteredKeyMultimap(filteredKeyMultimap.unfiltered, Predicates.and(filteredKeyMultimap.keyPredicate, predicate));
        } else if (multimap instanceof FilteredMultimap) {
            return filterFiltered((FilteredMultimap) multimap, Maps.keyPredicateOnEntries(predicate));
        } else {
            return new FilteredKeyMultimap(multimap, predicate);
        }
    }

    public static <K, V> SetMultimap<K, V> filterKeys(SetMultimap setMultimap, Predicate predicate) {
        if (setMultimap instanceof FilteredKeySetMultimap) {
            FilteredKeySetMultimap filteredKeySetMultimap = (FilteredKeySetMultimap) setMultimap;
            return new FilteredKeySetMultimap(filteredKeySetMultimap.unfiltered(), Predicates.and(filteredKeySetMultimap.keyPredicate, predicate));
        } else if (setMultimap instanceof FilteredSetMultimap) {
            return filterFiltered((FilteredSetMultimap) setMultimap, Maps.keyPredicateOnEntries(predicate));
        } else {
            return new FilteredKeySetMultimap(setMultimap, predicate);
        }
    }

    public static <K, V> ListMultimap<K, V> filterKeys(ListMultimap listMultimap, Predicate predicate) {
        if (!(listMultimap instanceof FilteredKeyListMultimap)) {
            return new FilteredKeyListMultimap(listMultimap, predicate);
        }
        FilteredKeyListMultimap filteredKeyListMultimap = (FilteredKeyListMultimap) listMultimap;
        return new FilteredKeyListMultimap(filteredKeyListMultimap.unfiltered(), Predicates.and(filteredKeyListMultimap.keyPredicate, predicate));
    }

    public static <K, V> Multimap<K, V> filterValues(Multimap<K, V> multimap, Predicate<? super V> predicate) {
        return filterEntries(multimap, Maps.valuePredicateOnEntries(predicate));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Multimaps.filterEntries(com.google.common.collect.SetMultimap, com.google.common.base.Predicate):com.google.common.collect.SetMultimap<K, V>
     arg types: [com.google.common.collect.SetMultimap<K, V>, com.google.common.base.Predicate<java.util.Map$Entry<?, V>>]
     candidates:
      com.google.common.collect.Multimaps.filterEntries(com.google.common.collect.Multimap, com.google.common.base.Predicate):com.google.common.collect.Multimap<K, V>
      com.google.common.collect.Multimaps.filterEntries(com.google.common.collect.SetMultimap, com.google.common.base.Predicate):com.google.common.collect.SetMultimap<K, V> */
    public static <K, V> SetMultimap<K, V> filterValues(SetMultimap<K, V> setMultimap, Predicate<? super V> predicate) {
        return filterEntries((SetMultimap) setMultimap, (Predicate) Maps.valuePredicateOnEntries(predicate));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Multimaps.filterEntries(com.google.common.collect.SetMultimap, com.google.common.base.Predicate):com.google.common.collect.SetMultimap<K, V>
     arg types: [com.google.common.collect.SetMultimap, com.google.common.base.Predicate<? super java.util.Map$Entry<K, V>>]
     candidates:
      com.google.common.collect.Multimaps.filterEntries(com.google.common.collect.Multimap, com.google.common.base.Predicate):com.google.common.collect.Multimap<K, V>
      com.google.common.collect.Multimaps.filterEntries(com.google.common.collect.SetMultimap, com.google.common.base.Predicate):com.google.common.collect.SetMultimap<K, V> */
    public static <K, V> Multimap<K, V> filterEntries(Multimap<K, V> multimap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (multimap instanceof SetMultimap) {
            return filterEntries((SetMultimap) multimap, (Predicate) predicate);
        }
        if (multimap instanceof FilteredMultimap) {
            return filterFiltered((FilteredMultimap) multimap, predicate);
        }
        return new FilteredEntryMultimap((Multimap) Preconditions.checkNotNull(multimap), predicate);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Multimaps.filterFiltered(com.google.common.collect.FilteredSetMultimap, com.google.common.base.Predicate):com.google.common.collect.SetMultimap<K, V>
     arg types: [com.google.common.collect.FilteredSetMultimap, com.google.common.base.Predicate<? super java.util.Map$Entry<K, V>>]
     candidates:
      com.google.common.collect.Multimaps.filterFiltered(com.google.common.collect.FilteredMultimap, com.google.common.base.Predicate):com.google.common.collect.Multimap<K, V>
      com.google.common.collect.Multimaps.filterFiltered(com.google.common.collect.FilteredSetMultimap, com.google.common.base.Predicate):com.google.common.collect.SetMultimap<K, V> */
    public static <K, V> SetMultimap<K, V> filterEntries(SetMultimap<K, V> setMultimap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.checkNotNull(predicate);
        if (setMultimap instanceof FilteredSetMultimap) {
            return filterFiltered((FilteredSetMultimap) setMultimap, (Predicate) predicate);
        }
        return new FilteredEntrySetMultimap((SetMultimap) Preconditions.checkNotNull(setMultimap), predicate);
    }

    private static <K, V> Multimap<K, V> filterFiltered(FilteredMultimap<K, V> filteredMultimap, Predicate<? super Map.Entry<K, V>> predicate) {
        return new FilteredEntryMultimap(filteredMultimap.unfiltered(), Predicates.and(filteredMultimap.entryPredicate(), predicate));
    }

    private static <K, V> SetMultimap<K, V> filterFiltered(FilteredSetMultimap<K, V> filteredSetMultimap, Predicate<? super Map.Entry<K, V>> predicate) {
        return new FilteredEntrySetMultimap(filteredSetMultimap.unfiltered(), Predicates.and(filteredSetMultimap.entryPredicate(), predicate));
    }

    static boolean equalsImpl(Multimap<?, ?> multimap, Object obj) {
        if (obj == multimap) {
            return true;
        }
        if (obj instanceof Multimap) {
            return multimap.asMap().equals(((Multimap) obj).asMap());
        }
        return false;
    }
}
