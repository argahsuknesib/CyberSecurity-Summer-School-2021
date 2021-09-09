package com.google.common.collect;

import com.google.auto.common.BasicAnnotationProcessor;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Table;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

@GwtCompatible(emulated = true)
final class Synchronized {
    private Synchronized() {
    }

    static class SynchronizedObject implements Serializable {
        @GwtIncompatible
        private static final long serialVersionUID = 0;
        final Object delegate;
        final Object mutex;

        SynchronizedObject(Object obj, Object obj2) {
            this.delegate = Preconditions.checkNotNull(obj);
            this.mutex = obj2 == null ? this : obj2;
        }

        /* access modifiers changed from: package-private */
        public Object delegate() {
            return this.delegate;
        }

        public String toString() {
            String obj;
            synchronized (this.mutex) {
                obj = this.delegate.toString();
            }
            return obj;
        }

        @GwtIncompatible
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            synchronized (this.mutex) {
                objectOutputStream.defaultWriteObject();
            }
        }
    }

    public static <E> Collection<E> collection(Collection<E> collection, Object obj) {
        return new SynchronizedCollection(collection, obj);
    }

    @VisibleForTesting
    static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
        private static final long serialVersionUID = 0;

        private SynchronizedCollection(Collection<E> collection, Object obj) {
            super(collection, obj);
        }

        /* access modifiers changed from: package-private */
        public Collection<E> delegate() {
            return (Collection) super.delegate();
        }

        public boolean add(E e) {
            boolean add;
            synchronized (this.mutex) {
                add = delegate().add(e);
            }
            return add;
        }

        public boolean addAll(Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = delegate().addAll(collection);
            }
            return addAll;
        }

        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        public boolean contains(Object obj) {
            boolean contains;
            synchronized (this.mutex) {
                contains = delegate().contains(obj);
            }
            return contains;
        }

        public boolean containsAll(Collection<?> collection) {
            boolean containsAll;
            synchronized (this.mutex) {
                containsAll = delegate().containsAll(collection);
            }
            return containsAll;
        }

        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        public Iterator<E> iterator() {
            return delegate().iterator();
        }

        public Spliterator<E> spliterator() {
            Spliterator<E> spliterator;
            synchronized (this.mutex) {
                spliterator = delegate().spliterator();
            }
            return spliterator;
        }

        public Stream<E> stream() {
            Stream<E> stream;
            synchronized (this.mutex) {
                stream = delegate().stream();
            }
            return stream;
        }

        public Stream<E> parallelStream() {
            Stream<E> parallelStream;
            synchronized (this.mutex) {
                parallelStream = delegate().parallelStream();
            }
            return parallelStream;
        }

        public void forEach(Consumer<? super E> consumer) {
            synchronized (this.mutex) {
                delegate().forEach(consumer);
            }
        }

        public boolean remove(Object obj) {
            boolean remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj);
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(collection);
            }
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            boolean retainAll;
            synchronized (this.mutex) {
                retainAll = delegate().retainAll(collection);
            }
            return retainAll;
        }

        public boolean removeIf(Predicate<? super E> predicate) {
            boolean removeIf;
            synchronized (this.mutex) {
                removeIf = delegate().removeIf(predicate);
            }
            return removeIf;
        }

        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        public Object[] toArray() {
            Object[] array;
            synchronized (this.mutex) {
                array = delegate().toArray();
            }
            return array;
        }

        public <T> T[] toArray(T[] tArr) {
            T[] array;
            synchronized (this.mutex) {
                array = delegate().toArray(tArr);
            }
            return array;
        }
    }

    @VisibleForTesting
    static <E> Set<E> set(Set<E> set, Object obj) {
        return new SynchronizedSet(set, obj);
    }

    static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        private static final long serialVersionUID = 0;

        SynchronizedSet(Set<E> set, Object obj) {
            super(set, obj);
        }

        /* access modifiers changed from: package-private */
        public Set<E> delegate() {
            return (Set) super.delegate();
        }

        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }
    }

    public static <E> SortedSet<E> sortedSet(SortedSet<E> sortedSet, Object obj) {
        return new SynchronizedSortedSet(sortedSet, obj);
    }

    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private static final long serialVersionUID = 0;

        SynchronizedSortedSet(SortedSet<E> sortedSet, Object obj) {
            super(sortedSet, obj);
        }

        /* access modifiers changed from: package-private */
        public SortedSet<E> delegate() {
            return (SortedSet) super.delegate();
        }

        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator;
            synchronized (this.mutex) {
                comparator = delegate().comparator();
            }
            return comparator;
        }

        public SortedSet<E> subSet(E e, E e2) {
            SortedSet<E> sortedSet;
            synchronized (this.mutex) {
                sortedSet = Synchronized.sortedSet(delegate().subSet(e, e2), this.mutex);
            }
            return sortedSet;
        }

        public SortedSet<E> headSet(E e) {
            SortedSet<E> sortedSet;
            synchronized (this.mutex) {
                sortedSet = Synchronized.sortedSet(delegate().headSet(e), this.mutex);
            }
            return sortedSet;
        }

        public SortedSet<E> tailSet(E e) {
            SortedSet<E> sortedSet;
            synchronized (this.mutex) {
                sortedSet = Synchronized.sortedSet(delegate().tailSet(e), this.mutex);
            }
            return sortedSet;
        }

        public E first() {
            E first;
            synchronized (this.mutex) {
                first = delegate().first();
            }
            return first;
        }

        public E last() {
            E last;
            synchronized (this.mutex) {
                last = delegate().last();
            }
            return last;
        }
    }

    public static <E> List<E> list(List<E> list, Object obj) {
        return list instanceof RandomAccess ? new SynchronizedRandomAccessList(list, obj) : new SynchronizedList(list, obj);
    }

    static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        private static final long serialVersionUID = 0;

        SynchronizedList(List<E> list, Object obj) {
            super(list, obj);
        }

        /* access modifiers changed from: package-private */
        public List<E> delegate() {
            return (List) super.delegate();
        }

        public void add(int i, E e) {
            synchronized (this.mutex) {
                delegate().add(i, e);
            }
        }

        public boolean addAll(int i, Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.mutex) {
                addAll = delegate().addAll(i, collection);
            }
            return addAll;
        }

        public E get(int i) {
            E e;
            synchronized (this.mutex) {
                e = delegate().get(i);
            }
            return e;
        }

        public int indexOf(Object obj) {
            int indexOf;
            synchronized (this.mutex) {
                indexOf = delegate().indexOf(obj);
            }
            return indexOf;
        }

        public int lastIndexOf(Object obj) {
            int lastIndexOf;
            synchronized (this.mutex) {
                lastIndexOf = delegate().lastIndexOf(obj);
            }
            return lastIndexOf;
        }

        public ListIterator<E> listIterator() {
            return delegate().listIterator();
        }

        public ListIterator<E> listIterator(int i) {
            return delegate().listIterator(i);
        }

        public E remove(int i) {
            E remove;
            synchronized (this.mutex) {
                remove = delegate().remove(i);
            }
            return remove;
        }

        public E set(int i, E e) {
            E e2;
            synchronized (this.mutex) {
                e2 = delegate().set(i, e);
            }
            return e2;
        }

        public void replaceAll(UnaryOperator<E> unaryOperator) {
            synchronized (this.mutex) {
                delegate().replaceAll(unaryOperator);
            }
        }

        public void sort(Comparator<? super E> comparator) {
            synchronized (this.mutex) {
                delegate().sort(comparator);
            }
        }

        public List<E> subList(int i, int i2) {
            List<E> list;
            synchronized (this.mutex) {
                list = Synchronized.list(delegate().subList(i, i2), this.mutex);
            }
            return list;
        }

        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }
    }

    static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        private static final long serialVersionUID = 0;

        SynchronizedRandomAccessList(List<E> list, Object obj) {
            super(list, obj);
        }
    }

    static <E> Multiset<E> multiset(Multiset<E> multiset, Object obj) {
        return ((multiset instanceof SynchronizedMultiset) || (multiset instanceof ImmutableMultiset)) ? multiset : new SynchronizedMultiset(multiset, obj);
    }

    static class SynchronizedMultiset<E> extends SynchronizedCollection<E> implements Multiset<E> {
        private static final long serialVersionUID = 0;
        transient Set<E> elementSet;
        transient Set<Multiset.Entry<E>> entrySet;

        @Beta
        public /* synthetic */ void forEachEntry(ObjIntConsumer<? super E> objIntConsumer) {
            Multiset.CC.$default$forEachEntry(this, objIntConsumer);
        }

        SynchronizedMultiset(Multiset<E> multiset, Object obj) {
            super(multiset, obj);
        }

        /* access modifiers changed from: package-private */
        public Multiset<E> delegate() {
            return (Multiset) super.delegate();
        }

        public int count(Object obj) {
            int count;
            synchronized (this.mutex) {
                count = delegate().count(obj);
            }
            return count;
        }

        public int add(E e, int i) {
            int add;
            synchronized (this.mutex) {
                add = delegate().add(e, i);
            }
            return add;
        }

        public int remove(Object obj, int i) {
            int remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, i);
            }
            return remove;
        }

        public int setCount(E e, int i) {
            int count;
            synchronized (this.mutex) {
                count = delegate().setCount(e, i);
            }
            return count;
        }

        public boolean setCount(E e, int i, int i2) {
            boolean count;
            synchronized (this.mutex) {
                count = delegate().setCount(e, i, i2);
            }
            return count;
        }

        public Set<E> elementSet() {
            Set<E> set;
            synchronized (this.mutex) {
                if (this.elementSet == null) {
                    this.elementSet = Synchronized.typePreservingSet(delegate().elementSet(), this.mutex);
                }
                set = this.elementSet;
            }
            return set;
        }

        public Set<Multiset.Entry<E>> entrySet() {
            Set<Multiset.Entry<E>> set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = Synchronized.typePreservingSet(delegate().entrySet(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }

        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }
    }

    static <K, V> Multimap<K, V> multimap(Multimap<K, V> multimap, Object obj) {
        return ((multimap instanceof SynchronizedMultimap) || (multimap instanceof BaseImmutableMultimap)) ? multimap : new SynchronizedMultimap(multimap, obj);
    }

    static class SynchronizedMultimap<K, V> extends SynchronizedObject implements Multimap<K, V> {
        private static final long serialVersionUID = 0;
        transient Map<K, Collection<V>> asMap;
        transient Collection<Map.Entry<K, V>> entries;
        transient Set<K> keySet;
        transient Multiset<K> keys;
        transient Collection<V> valuesCollection;

        /* access modifiers changed from: package-private */
        public Multimap<K, V> delegate() {
            return (Multimap) super.delegate();
        }

        SynchronizedMultimap(Multimap<K, V> multimap, Object obj) {
            super(multimap, obj);
        }

        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        public boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = delegate().containsKey(obj);
            }
            return containsKey;
        }

        public boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        public boolean containsEntry(Object obj, Object obj2) {
            boolean containsEntry;
            synchronized (this.mutex) {
                containsEntry = delegate().containsEntry(obj, obj2);
            }
            return containsEntry;
        }

        public Collection<V> get(K k) {
            Collection<V> typePreservingCollection;
            synchronized (this.mutex) {
                typePreservingCollection = Synchronized.typePreservingCollection(delegate().get(k), this.mutex);
            }
            return typePreservingCollection;
        }

        public boolean put(K k, V v) {
            boolean put;
            synchronized (this.mutex) {
                put = delegate().put(k, v);
            }
            return put;
        }

        public boolean putAll(K k, Iterable<? extends V> iterable) {
            boolean putAll;
            synchronized (this.mutex) {
                putAll = delegate().putAll(k, iterable);
            }
            return putAll;
        }

        public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
            boolean putAll;
            synchronized (this.mutex) {
                putAll = delegate().putAll(multimap);
            }
            return putAll;
        }

        public Collection<V> replaceValues(K k, Iterable<? extends V> iterable) {
            Collection<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues(k, iterable);
            }
            return replaceValues;
        }

        public boolean remove(Object obj, Object obj2) {
            boolean remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, obj2);
            }
            return remove;
        }

        public Collection<V> removeAll(Object obj) {
            Collection<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.mutex) {
                if (this.keySet == null) {
                    this.keySet = Synchronized.typePreservingSet(delegate().keySet(), this.mutex);
                }
                set = this.keySet;
            }
            return set;
        }

        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                if (this.valuesCollection == null) {
                    this.valuesCollection = Synchronized.collection(delegate().values(), this.mutex);
                }
                collection = this.valuesCollection;
            }
            return collection;
        }

        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> collection;
            synchronized (this.mutex) {
                if (this.entries == null) {
                    this.entries = Synchronized.typePreservingCollection(delegate().entries(), this.mutex);
                }
                collection = this.entries;
            }
            return collection;
        }

        public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
            synchronized (this.mutex) {
                delegate().forEach(biConsumer);
            }
        }

        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map;
            synchronized (this.mutex) {
                if (this.asMap == null) {
                    this.asMap = new SynchronizedAsMap(delegate().asMap(), this.mutex);
                }
                map = this.asMap;
            }
            return map;
        }

        public Multiset<K> keys() {
            Multiset<K> multiset;
            synchronized (this.mutex) {
                if (this.keys == null) {
                    this.keys = Synchronized.multiset(delegate().keys(), this.mutex);
                }
                multiset = this.keys;
            }
            return multiset;
        }

        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }
    }

    static <K, V> ListMultimap<K, V> listMultimap(ListMultimap<K, V> listMultimap, Object obj) {
        return ((listMultimap instanceof SynchronizedListMultimap) || (listMultimap instanceof BaseImmutableMultimap)) ? listMultimap : new SynchronizedListMultimap(listMultimap, obj);
    }

    static class SynchronizedListMultimap<K, V> extends SynchronizedMultimap<K, V> implements ListMultimap<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedListMultimap(ListMultimap<K, V> listMultimap, Object obj) {
            super(listMultimap, obj);
        }

        /* access modifiers changed from: package-private */
        public ListMultimap<K, V> delegate() {
            return (ListMultimap) super.delegate();
        }

        public List<V> get(K k) {
            List<V> list;
            synchronized (this.mutex) {
                list = Synchronized.list(delegate().get((Object) k), this.mutex);
            }
            return list;
        }

        public List<V> removeAll(Object obj) {
            List<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.ListMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.List<V>
         arg types: [K, java.lang.Iterable<? extends V>]
         candidates:
          com.google.common.collect.Multimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Collection<V>
          com.google.common.collect.ListMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.List<V> */
        public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
            List<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((Object) k, (Iterable) iterable);
            }
            return replaceValues;
        }
    }

    static <K, V> SetMultimap<K, V> setMultimap(SetMultimap<K, V> setMultimap, Object obj) {
        return ((setMultimap instanceof SynchronizedSetMultimap) || (setMultimap instanceof BaseImmutableMultimap)) ? setMultimap : new SynchronizedSetMultimap(setMultimap, obj);
    }

    static class SynchronizedSetMultimap<K, V> extends SynchronizedMultimap<K, V> implements SetMultimap<K, V> {
        private static final long serialVersionUID = 0;
        transient Set<Map.Entry<K, V>> entrySet;

        SynchronizedSetMultimap(SetMultimap<K, V> setMultimap, Object obj) {
            super(setMultimap, obj);
        }

        /* access modifiers changed from: package-private */
        public SetMultimap<K, V> delegate() {
            return (SetMultimap) super.delegate();
        }

        public Set<V> get(K k) {
            Set<V> set;
            synchronized (this.mutex) {
                set = Synchronized.set(delegate().get((BasicAnnotationProcessor.ProcessingStep) k), this.mutex);
            }
            return set;
        }

        public Set<V> removeAll(Object obj) {
            Set<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.SetMultimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Set<V>
         arg types: [K, java.lang.Iterable<? extends V>]
         candidates:
          com.google.common.collect.Multimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Collection<V>
          com.google.common.collect.SetMultimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Set<V> */
        public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
            Set<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((BasicAnnotationProcessor.ProcessingStep) k, (Iterable<? extends BasicAnnotationProcessor.ElementName>) iterable);
            }
            return replaceValues;
        }

        public Set<Map.Entry<K, V>> entries() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = Synchronized.set(delegate().entries(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }
    }

    static <K, V> SortedSetMultimap<K, V> sortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap, Object obj) {
        if (sortedSetMultimap instanceof SynchronizedSortedSetMultimap) {
            return sortedSetMultimap;
        }
        return new SynchronizedSortedSetMultimap(sortedSetMultimap, obj);
    }

    static class SynchronizedSortedSetMultimap<K, V> extends SynchronizedSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap, Object obj) {
            super(sortedSetMultimap, obj);
        }

        /* access modifiers changed from: package-private */
        public SortedSetMultimap<K, V> delegate() {
            return (SortedSetMultimap) super.delegate();
        }

        public SortedSet<V> get(K k) {
            SortedSet<V> sortedSet;
            synchronized (this.mutex) {
                sortedSet = Synchronized.sortedSet(delegate().get((Object) k), this.mutex);
            }
            return sortedSet;
        }

        public SortedSet<V> removeAll(Object obj) {
            SortedSet<V> removeAll;
            synchronized (this.mutex) {
                removeAll = delegate().removeAll(obj);
            }
            return removeAll;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.SortedSetMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.SortedSet<V>
         arg types: [K, java.lang.Iterable<? extends V>]
         candidates:
          com.google.common.collect.SetMultimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Set<V>
          com.google.common.collect.Multimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Collection<V>
          com.google.common.collect.SortedSetMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.SortedSet<V> */
        public SortedSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
            SortedSet<V> replaceValues;
            synchronized (this.mutex) {
                replaceValues = delegate().replaceValues((Object) k, (Iterable) iterable);
            }
            return replaceValues;
        }

        public Comparator<? super V> valueComparator() {
            Comparator<? super V> valueComparator;
            synchronized (this.mutex) {
                valueComparator = delegate().valueComparator();
            }
            return valueComparator;
        }
    }

    public static <E> Collection<E> typePreservingCollection(Collection<E> collection, Object obj) {
        if (collection instanceof SortedSet) {
            return sortedSet((SortedSet) collection, obj);
        }
        if (collection instanceof Set) {
            return set((Set) collection, obj);
        }
        if (collection instanceof List) {
            return list((List) collection, obj);
        }
        return collection(collection, obj);
    }

    public static <E> Set<E> typePreservingSet(Set<E> set, Object obj) {
        if (set instanceof SortedSet) {
            return sortedSet((SortedSet) set, obj);
        }
        return set(set, obj);
    }

    static class SynchronizedAsMapEntries<K, V> extends SynchronizedSet<Map.Entry<K, Collection<V>>> {
        private static final long serialVersionUID = 0;

        SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> set, Object obj) {
            super(set, obj);
        }

        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            return new TransformedIterator<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>>(super.iterator()) {
                /* class com.google.common.collect.Synchronized.SynchronizedAsMapEntries.AnonymousClass1 */

                /* access modifiers changed from: package-private */
                public Map.Entry<K, Collection<V>> transform(final Map.Entry<K, Collection<V>> entry) {
                    return new ForwardingMapEntry<K, Collection<V>>() {
                        /* class com.google.common.collect.Synchronized.SynchronizedAsMapEntries.AnonymousClass1.AnonymousClass1 */

                        /* access modifiers changed from: protected */
                        public Map.Entry<K, Collection<V>> delegate() {
                            return entry;
                        }

                        public Collection<V> getValue() {
                            return Synchronized.typePreservingCollection((Collection) entry.getValue(), SynchronizedAsMapEntries.this.mutex);
                        }
                    };
                }
            };
        }

        public Object[] toArray() {
            Object[] arrayImpl;
            synchronized (this.mutex) {
                arrayImpl = ObjectArrays.toArrayImpl(delegate());
            }
            return arrayImpl;
        }

        public <T> T[] toArray(T[] tArr) {
            T[] arrayImpl;
            synchronized (this.mutex) {
                arrayImpl = ObjectArrays.toArrayImpl(delegate(), tArr);
            }
            return arrayImpl;
        }

        public boolean contains(Object obj) {
            boolean containsEntryImpl;
            synchronized (this.mutex) {
                containsEntryImpl = Maps.containsEntryImpl(delegate(), obj);
            }
            return containsEntryImpl;
        }

        public boolean containsAll(Collection<?> collection) {
            boolean containsAllImpl;
            synchronized (this.mutex) {
                containsAllImpl = Collections2.containsAllImpl(delegate(), collection);
            }
            return containsAllImpl;
        }

        public boolean equals(Object obj) {
            boolean equalsImpl;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equalsImpl = Sets.equalsImpl(delegate(), obj);
            }
            return equalsImpl;
        }

        public boolean remove(Object obj) {
            boolean removeEntryImpl;
            synchronized (this.mutex) {
                removeEntryImpl = Maps.removeEntryImpl(delegate(), obj);
            }
            return removeEntryImpl;
        }

        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            synchronized (this.mutex) {
                removeAll = Iterators.removeAll(delegate().iterator(), collection);
            }
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            boolean retainAll;
            synchronized (this.mutex) {
                retainAll = Iterators.retainAll(delegate().iterator(), collection);
            }
            return retainAll;
        }
    }

    @VisibleForTesting
    static <K, V> Map<K, V> map(Map<K, V> map, Object obj) {
        return new SynchronizedMap(map, obj);
    }

    static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
        private static final long serialVersionUID = 0;
        transient Set<Map.Entry<K, V>> entrySet;
        transient Set<K> keySet;
        transient Collection<V> values;

        SynchronizedMap(Map<K, V> map, Object obj) {
            super(map, obj);
        }

        /* access modifiers changed from: package-private */
        public Map<K, V> delegate() {
            return (Map) super.delegate();
        }

        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        public boolean containsKey(Object obj) {
            boolean containsKey;
            synchronized (this.mutex) {
                containsKey = delegate().containsKey(obj);
            }
            return containsKey;
        }

        public boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                if (this.entrySet == null) {
                    this.entrySet = Synchronized.set(delegate().entrySet(), this.mutex);
                }
                set = this.entrySet;
            }
            return set;
        }

        public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
            synchronized (this.mutex) {
                delegate().forEach(biConsumer);
            }
        }

        public V get(Object obj) {
            V v;
            synchronized (this.mutex) {
                v = delegate().get(obj);
            }
            return v;
        }

        public V getOrDefault(Object obj, V v) {
            V orDefault;
            synchronized (this.mutex) {
                orDefault = delegate().getOrDefault(obj, v);
            }
            return orDefault;
        }

        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.mutex) {
                if (this.keySet == null) {
                    this.keySet = Synchronized.set(delegate().keySet(), this.mutex);
                }
                set = this.keySet;
            }
            return set;
        }

        public V put(K k, V v) {
            V put;
            synchronized (this.mutex) {
                put = delegate().put(k, v);
            }
            return put;
        }

        public V putIfAbsent(K k, V v) {
            V putIfAbsent;
            synchronized (this.mutex) {
                putIfAbsent = delegate().putIfAbsent(k, v);
            }
            return putIfAbsent;
        }

        public boolean replace(K k, V v, V v2) {
            boolean replace;
            synchronized (this.mutex) {
                replace = delegate().replace(k, v, v2);
            }
            return replace;
        }

        public V replace(K k, V v) {
            V replace;
            synchronized (this.mutex) {
                replace = delegate().replace(k, v);
            }
            return replace;
        }

        public V computeIfAbsent(K k, Function<? super K, ? extends V> function) {
            V computeIfAbsent;
            synchronized (this.mutex) {
                computeIfAbsent = delegate().computeIfAbsent(k, function);
            }
            return computeIfAbsent;
        }

        public V computeIfPresent(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            V computeIfPresent;
            synchronized (this.mutex) {
                computeIfPresent = delegate().computeIfPresent(k, biFunction);
            }
            return computeIfPresent;
        }

        public V compute(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
            V compute;
            synchronized (this.mutex) {
                compute = delegate().compute(k, biFunction);
            }
            return compute;
        }

        public V merge(K k, V v, BiFunction<? super V, ? super V, ? extends V> biFunction) {
            V merge;
            synchronized (this.mutex) {
                merge = delegate().merge(k, v, biFunction);
            }
            return merge;
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (this.mutex) {
                delegate().putAll(map);
            }
        }

        public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
            synchronized (this.mutex) {
                delegate().replaceAll(biFunction);
            }
        }

        public V remove(Object obj) {
            V remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj);
            }
            return remove;
        }

        public boolean remove(Object obj, Object obj2) {
            boolean remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, obj2);
            }
            return remove;
        }

        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                if (this.values == null) {
                    this.values = Synchronized.collection(delegate().values(), this.mutex);
                }
                collection = this.values;
            }
            return collection;
        }

        public boolean equals(Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }
    }

    static <K, V> SortedMap<K, V> sortedMap(SortedMap<K, V> sortedMap, Object obj) {
        return new SynchronizedSortedMap(sortedMap, obj);
    }

    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedSortedMap(SortedMap<K, V> sortedMap, Object obj) {
            super(sortedMap, obj);
        }

        /* access modifiers changed from: package-private */
        public SortedMap<K, V> delegate() {
            return (SortedMap) super.delegate();
        }

        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.mutex) {
                comparator = delegate().comparator();
            }
            return comparator;
        }

        public K firstKey() {
            K firstKey;
            synchronized (this.mutex) {
                firstKey = delegate().firstKey();
            }
            return firstKey;
        }

        public SortedMap<K, V> headMap(K k) {
            SortedMap<K, V> sortedMap;
            synchronized (this.mutex) {
                sortedMap = Synchronized.sortedMap(delegate().headMap(k), this.mutex);
            }
            return sortedMap;
        }

        public K lastKey() {
            K lastKey;
            synchronized (this.mutex) {
                lastKey = delegate().lastKey();
            }
            return lastKey;
        }

        public SortedMap<K, V> subMap(K k, K k2) {
            SortedMap<K, V> sortedMap;
            synchronized (this.mutex) {
                sortedMap = Synchronized.sortedMap(delegate().subMap(k, k2), this.mutex);
            }
            return sortedMap;
        }

        public SortedMap<K, V> tailMap(K k) {
            SortedMap<K, V> sortedMap;
            synchronized (this.mutex) {
                sortedMap = Synchronized.sortedMap(delegate().tailMap(k), this.mutex);
            }
            return sortedMap;
        }
    }

    static <K, V> BiMap<K, V> biMap(BiMap<K, V> biMap, Object obj) {
        return ((biMap instanceof SynchronizedBiMap) || (biMap instanceof ImmutableBiMap)) ? biMap : new SynchronizedBiMap(biMap, obj, null);
    }

    @VisibleForTesting
    static class SynchronizedBiMap<K, V> extends SynchronizedMap<K, V> implements BiMap<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        @RetainedWith
        private transient BiMap<V, K> inverse;
        private transient Set<V> valueSet;

        private SynchronizedBiMap(BiMap<K, V> biMap, Object obj, BiMap<V, K> biMap2) {
            super(biMap, obj);
            this.inverse = biMap2;
        }

        /* access modifiers changed from: package-private */
        public BiMap<K, V> delegate() {
            return (BiMap) super.delegate();
        }

        public Set<V> values() {
            Set<V> set;
            synchronized (this.mutex) {
                if (this.valueSet == null) {
                    this.valueSet = Synchronized.set(delegate().values(), this.mutex);
                }
                set = this.valueSet;
            }
            return set;
        }

        public V forcePut(K k, V v) {
            V forcePut;
            synchronized (this.mutex) {
                forcePut = delegate().forcePut(k, v);
            }
            return forcePut;
        }

        public BiMap<V, K> inverse() {
            BiMap<V, K> biMap;
            synchronized (this.mutex) {
                if (this.inverse == null) {
                    this.inverse = new SynchronizedBiMap(delegate().inverse(), this.mutex, this);
                }
                biMap = this.inverse;
            }
            return biMap;
        }
    }

    static class SynchronizedAsMap<K, V> extends SynchronizedMap<K, Collection<V>> {
        private static final long serialVersionUID = 0;
        transient Set<Map.Entry<K, Collection<V>>> asMapEntrySet;
        transient Collection<Collection<V>> asMapValues;

        SynchronizedAsMap(Map<K, Collection<V>> map, Object obj) {
            super(map, obj);
        }

        public Collection<V> get(Object obj) {
            Collection<V> collection;
            synchronized (this.mutex) {
                Collection collection2 = (Collection) super.get(obj);
                if (collection2 == null) {
                    collection = null;
                } else {
                    collection = Synchronized.typePreservingCollection(collection2, this.mutex);
                }
            }
            return collection;
        }

        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            Set<Map.Entry<K, Collection<V>>> set;
            synchronized (this.mutex) {
                if (this.asMapEntrySet == null) {
                    this.asMapEntrySet = new SynchronizedAsMapEntries(delegate().entrySet(), this.mutex);
                }
                set = this.asMapEntrySet;
            }
            return set;
        }

        public Collection<Collection<V>> values() {
            Collection<Collection<V>> collection;
            synchronized (this.mutex) {
                if (this.asMapValues == null) {
                    this.asMapValues = new SynchronizedAsMapValues(delegate().values(), this.mutex);
                }
                collection = this.asMapValues;
            }
            return collection;
        }

        public boolean containsValue(Object obj) {
            return values().contains(obj);
        }
    }

    static class SynchronizedAsMapValues<V> extends SynchronizedCollection<Collection<V>> {
        private static final long serialVersionUID = 0;

        SynchronizedAsMapValues(Collection<Collection<V>> collection, Object obj) {
            super(collection, obj);
        }

        public Iterator<Collection<V>> iterator() {
            return new TransformedIterator<Collection<V>, Collection<V>>(super.iterator()) {
                /* class com.google.common.collect.Synchronized.SynchronizedAsMapValues.AnonymousClass1 */

                /* access modifiers changed from: package-private */
                public Collection<V> transform(Collection<V> collection) {
                    return Synchronized.typePreservingCollection(collection, SynchronizedAsMapValues.this.mutex);
                }
            };
        }
    }

    @GwtIncompatible
    @VisibleForTesting
    static class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {
        private static final long serialVersionUID = 0;
        transient NavigableSet<E> descendingSet;

        SynchronizedNavigableSet(NavigableSet<E> navigableSet, Object obj) {
            super(navigableSet, obj);
        }

        /* access modifiers changed from: package-private */
        public NavigableSet<E> delegate() {
            return (NavigableSet) super.delegate();
        }

        public E ceiling(E e) {
            E ceiling;
            synchronized (this.mutex) {
                ceiling = delegate().ceiling(e);
            }
            return ceiling;
        }

        public Iterator<E> descendingIterator() {
            return delegate().descendingIterator();
        }

        public NavigableSet<E> descendingSet() {
            synchronized (this.mutex) {
                if (this.descendingSet == null) {
                    NavigableSet<E> navigableSet = Synchronized.navigableSet(delegate().descendingSet(), this.mutex);
                    this.descendingSet = navigableSet;
                    return navigableSet;
                }
                NavigableSet<E> navigableSet2 = this.descendingSet;
                return navigableSet2;
            }
        }

        public E floor(E e) {
            E floor;
            synchronized (this.mutex) {
                floor = delegate().floor(e);
            }
            return floor;
        }

        public NavigableSet<E> headSet(E e, boolean z) {
            NavigableSet<E> navigableSet;
            synchronized (this.mutex) {
                navigableSet = Synchronized.navigableSet(delegate().headSet(e, z), this.mutex);
            }
            return navigableSet;
        }

        public SortedSet<E> headSet(E e) {
            return headSet(e, false);
        }

        public E higher(E e) {
            E higher;
            synchronized (this.mutex) {
                higher = delegate().higher(e);
            }
            return higher;
        }

        public E lower(E e) {
            E lower;
            synchronized (this.mutex) {
                lower = delegate().lower(e);
            }
            return lower;
        }

        public E pollFirst() {
            E pollFirst;
            synchronized (this.mutex) {
                pollFirst = delegate().pollFirst();
            }
            return pollFirst;
        }

        public E pollLast() {
            E pollLast;
            synchronized (this.mutex) {
                pollLast = delegate().pollLast();
            }
            return pollLast;
        }

        public NavigableSet<E> subSet(E e, boolean z, E e2, boolean z2) {
            NavigableSet<E> navigableSet;
            synchronized (this.mutex) {
                navigableSet = Synchronized.navigableSet(delegate().subSet(e, z, e2, z2), this.mutex);
            }
            return navigableSet;
        }

        public SortedSet<E> subSet(E e, E e2) {
            return subSet(e, true, e2, false);
        }

        public NavigableSet<E> tailSet(E e, boolean z) {
            NavigableSet<E> navigableSet;
            synchronized (this.mutex) {
                navigableSet = Synchronized.navigableSet(delegate().tailSet(e, z), this.mutex);
            }
            return navigableSet;
        }

        public SortedSet<E> tailSet(E e) {
            return tailSet(e, true);
        }
    }

    @GwtIncompatible
    static <E> NavigableSet<E> navigableSet(NavigableSet<E> navigableSet, Object obj) {
        return new SynchronizedNavigableSet(navigableSet, obj);
    }

    @GwtIncompatible
    static <E> NavigableSet<E> navigableSet(NavigableSet<E> navigableSet) {
        return navigableSet(navigableSet, null);
    }

    @GwtIncompatible
    static <K, V> NavigableMap<K, V> navigableMap(NavigableMap<K, V> navigableMap) {
        return navigableMap(navigableMap, null);
    }

    @GwtIncompatible
    static <K, V> NavigableMap<K, V> navigableMap(NavigableMap<K, V> navigableMap, Object obj) {
        return new SynchronizedNavigableMap(navigableMap, obj);
    }

    @GwtIncompatible
    @VisibleForTesting
    static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
        private static final long serialVersionUID = 0;
        transient NavigableSet<K> descendingKeySet;
        transient NavigableMap<K, V> descendingMap;
        transient NavigableSet<K> navigableKeySet;

        SynchronizedNavigableMap(NavigableMap<K, V> navigableMap, Object obj) {
            super(navigableMap, obj);
        }

        /* access modifiers changed from: package-private */
        public NavigableMap<K, V> delegate() {
            return (NavigableMap) super.delegate();
        }

        public Map.Entry<K, V> ceilingEntry(K k) {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.mutex) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().ceilingEntry(k), this.mutex);
            }
            return nullableSynchronizedEntry;
        }

        public K ceilingKey(K k) {
            K ceilingKey;
            synchronized (this.mutex) {
                ceilingKey = delegate().ceilingKey(k);
            }
            return ceilingKey;
        }

        public NavigableSet<K> descendingKeySet() {
            synchronized (this.mutex) {
                if (this.descendingKeySet == null) {
                    NavigableSet<K> navigableSet = Synchronized.navigableSet(delegate().descendingKeySet(), this.mutex);
                    this.descendingKeySet = navigableSet;
                    return navigableSet;
                }
                NavigableSet<K> navigableSet2 = this.descendingKeySet;
                return navigableSet2;
            }
        }

        public NavigableMap<K, V> descendingMap() {
            synchronized (this.mutex) {
                if (this.descendingMap == null) {
                    NavigableMap<K, V> navigableMap = Synchronized.navigableMap(delegate().descendingMap(), this.mutex);
                    this.descendingMap = navigableMap;
                    return navigableMap;
                }
                NavigableMap<K, V> navigableMap2 = this.descendingMap;
                return navigableMap2;
            }
        }

        public Map.Entry<K, V> firstEntry() {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.mutex) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().firstEntry(), this.mutex);
            }
            return nullableSynchronizedEntry;
        }

        public Map.Entry<K, V> floorEntry(K k) {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.mutex) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().floorEntry(k), this.mutex);
            }
            return nullableSynchronizedEntry;
        }

        public K floorKey(K k) {
            K floorKey;
            synchronized (this.mutex) {
                floorKey = delegate().floorKey(k);
            }
            return floorKey;
        }

        public NavigableMap<K, V> headMap(K k, boolean z) {
            NavigableMap<K, V> navigableMap;
            synchronized (this.mutex) {
                navigableMap = Synchronized.navigableMap(delegate().headMap(k, z), this.mutex);
            }
            return navigableMap;
        }

        public SortedMap<K, V> headMap(K k) {
            return headMap(k, false);
        }

        public Map.Entry<K, V> higherEntry(K k) {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.mutex) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().higherEntry(k), this.mutex);
            }
            return nullableSynchronizedEntry;
        }

        public K higherKey(K k) {
            K higherKey;
            synchronized (this.mutex) {
                higherKey = delegate().higherKey(k);
            }
            return higherKey;
        }

        public Map.Entry<K, V> lastEntry() {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.mutex) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().lastEntry(), this.mutex);
            }
            return nullableSynchronizedEntry;
        }

        public Map.Entry<K, V> lowerEntry(K k) {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.mutex) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().lowerEntry(k), this.mutex);
            }
            return nullableSynchronizedEntry;
        }

        public K lowerKey(K k) {
            K lowerKey;
            synchronized (this.mutex) {
                lowerKey = delegate().lowerKey(k);
            }
            return lowerKey;
        }

        public Set<K> keySet() {
            return navigableKeySet();
        }

        public NavigableSet<K> navigableKeySet() {
            synchronized (this.mutex) {
                if (this.navigableKeySet == null) {
                    NavigableSet<K> navigableSet = Synchronized.navigableSet(delegate().navigableKeySet(), this.mutex);
                    this.navigableKeySet = navigableSet;
                    return navigableSet;
                }
                NavigableSet<K> navigableSet2 = this.navigableKeySet;
                return navigableSet2;
            }
        }

        public Map.Entry<K, V> pollFirstEntry() {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.mutex) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().pollFirstEntry(), this.mutex);
            }
            return nullableSynchronizedEntry;
        }

        public Map.Entry<K, V> pollLastEntry() {
            Map.Entry<K, V> nullableSynchronizedEntry;
            synchronized (this.mutex) {
                nullableSynchronizedEntry = Synchronized.nullableSynchronizedEntry(delegate().pollLastEntry(), this.mutex);
            }
            return nullableSynchronizedEntry;
        }

        public NavigableMap<K, V> subMap(K k, boolean z, K k2, boolean z2) {
            NavigableMap<K, V> navigableMap;
            synchronized (this.mutex) {
                navigableMap = Synchronized.navigableMap(delegate().subMap(k, z, k2, z2), this.mutex);
            }
            return navigableMap;
        }

        public SortedMap<K, V> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        public NavigableMap<K, V> tailMap(K k, boolean z) {
            NavigableMap<K, V> navigableMap;
            synchronized (this.mutex) {
                navigableMap = Synchronized.navigableMap(delegate().tailMap(k, z), this.mutex);
            }
            return navigableMap;
        }

        public SortedMap<K, V> tailMap(K k) {
            return tailMap(k, true);
        }
    }

    @GwtIncompatible
    public static <K, V> Map.Entry<K, V> nullableSynchronizedEntry(Map.Entry<K, V> entry, Object obj) {
        if (entry == null) {
            return null;
        }
        return new SynchronizedEntry(entry, obj);
    }

    @GwtIncompatible
    static class SynchronizedEntry<K, V> extends SynchronizedObject implements Map.Entry<K, V> {
        private static final long serialVersionUID = 0;

        SynchronizedEntry(Map.Entry<K, V> entry, Object obj) {
            super(entry, obj);
        }

        /* access modifiers changed from: package-private */
        public Map.Entry<K, V> delegate() {
            return (Map.Entry) super.delegate();
        }

        public boolean equals(Object obj) {
            boolean equals;
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        public K getKey() {
            K key;
            synchronized (this.mutex) {
                key = delegate().getKey();
            }
            return key;
        }

        public V getValue() {
            V value;
            synchronized (this.mutex) {
                value = delegate().getValue();
            }
            return value;
        }

        public V setValue(V v) {
            V value;
            synchronized (this.mutex) {
                value = delegate().setValue(v);
            }
            return value;
        }
    }

    static <E> Queue<E> queue(Queue<E> queue, Object obj) {
        return queue instanceof SynchronizedQueue ? queue : new SynchronizedQueue(queue, obj);
    }

    static class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
        private static final long serialVersionUID = 0;

        SynchronizedQueue(Queue<E> queue, Object obj) {
            super(queue, obj);
        }

        /* access modifiers changed from: package-private */
        public Queue<E> delegate() {
            return (Queue) super.delegate();
        }

        public E element() {
            E element;
            synchronized (this.mutex) {
                element = delegate().element();
            }
            return element;
        }

        public boolean offer(E e) {
            boolean offer;
            synchronized (this.mutex) {
                offer = delegate().offer(e);
            }
            return offer;
        }

        public E peek() {
            E peek;
            synchronized (this.mutex) {
                peek = delegate().peek();
            }
            return peek;
        }

        public E poll() {
            E poll;
            synchronized (this.mutex) {
                poll = delegate().poll();
            }
            return poll;
        }

        public E remove() {
            E remove;
            synchronized (this.mutex) {
                remove = delegate().remove();
            }
            return remove;
        }
    }

    static <E> Deque<E> deque(Deque<E> deque, Object obj) {
        return new SynchronizedDeque(deque, obj);
    }

    static final class SynchronizedDeque<E> extends SynchronizedQueue<E> implements Deque<E> {
        private static final long serialVersionUID = 0;

        SynchronizedDeque(Deque<E> deque, Object obj) {
            super(deque, obj);
        }

        /* access modifiers changed from: package-private */
        public final Deque<E> delegate() {
            return (Deque) super.delegate();
        }

        public final void addFirst(E e) {
            synchronized (this.mutex) {
                delegate().addFirst(e);
            }
        }

        public final void addLast(E e) {
            synchronized (this.mutex) {
                delegate().addLast(e);
            }
        }

        public final boolean offerFirst(E e) {
            boolean offerFirst;
            synchronized (this.mutex) {
                offerFirst = delegate().offerFirst(e);
            }
            return offerFirst;
        }

        public final boolean offerLast(E e) {
            boolean offerLast;
            synchronized (this.mutex) {
                offerLast = delegate().offerLast(e);
            }
            return offerLast;
        }

        public final E removeFirst() {
            E removeFirst;
            synchronized (this.mutex) {
                removeFirst = delegate().removeFirst();
            }
            return removeFirst;
        }

        public final E removeLast() {
            E removeLast;
            synchronized (this.mutex) {
                removeLast = delegate().removeLast();
            }
            return removeLast;
        }

        public final E pollFirst() {
            E pollFirst;
            synchronized (this.mutex) {
                pollFirst = delegate().pollFirst();
            }
            return pollFirst;
        }

        public final E pollLast() {
            E pollLast;
            synchronized (this.mutex) {
                pollLast = delegate().pollLast();
            }
            return pollLast;
        }

        public final E getFirst() {
            E first;
            synchronized (this.mutex) {
                first = delegate().getFirst();
            }
            return first;
        }

        public final E getLast() {
            E last;
            synchronized (this.mutex) {
                last = delegate().getLast();
            }
            return last;
        }

        public final E peekFirst() {
            E peekFirst;
            synchronized (this.mutex) {
                peekFirst = delegate().peekFirst();
            }
            return peekFirst;
        }

        public final E peekLast() {
            E peekLast;
            synchronized (this.mutex) {
                peekLast = delegate().peekLast();
            }
            return peekLast;
        }

        public final boolean removeFirstOccurrence(Object obj) {
            boolean removeFirstOccurrence;
            synchronized (this.mutex) {
                removeFirstOccurrence = delegate().removeFirstOccurrence(obj);
            }
            return removeFirstOccurrence;
        }

        public final boolean removeLastOccurrence(Object obj) {
            boolean removeLastOccurrence;
            synchronized (this.mutex) {
                removeLastOccurrence = delegate().removeLastOccurrence(obj);
            }
            return removeLastOccurrence;
        }

        public final void push(E e) {
            synchronized (this.mutex) {
                delegate().push(e);
            }
        }

        public final E pop() {
            E pop;
            synchronized (this.mutex) {
                pop = delegate().pop();
            }
            return pop;
        }

        public final Iterator<E> descendingIterator() {
            Iterator<E> descendingIterator;
            synchronized (this.mutex) {
                descendingIterator = delegate().descendingIterator();
            }
            return descendingIterator;
        }
    }

    static <R, C, V> Table<R, C, V> table(Table<R, C, V> table, Object obj) {
        return new SynchronizedTable(table, obj);
    }

    static final class SynchronizedTable<R, C, V> extends SynchronizedObject implements Table<R, C, V> {
        SynchronizedTable(Table<R, C, V> table, Object obj) {
            super(table, obj);
        }

        /* access modifiers changed from: package-private */
        public final Table<R, C, V> delegate() {
            return (Table) super.delegate();
        }

        public final boolean contains(Object obj, Object obj2) {
            boolean contains;
            synchronized (this.mutex) {
                contains = delegate().contains(obj, obj2);
            }
            return contains;
        }

        public final boolean containsRow(Object obj) {
            boolean containsRow;
            synchronized (this.mutex) {
                containsRow = delegate().containsRow(obj);
            }
            return containsRow;
        }

        public final boolean containsColumn(Object obj) {
            boolean containsColumn;
            synchronized (this.mutex) {
                containsColumn = delegate().containsColumn(obj);
            }
            return containsColumn;
        }

        public final boolean containsValue(Object obj) {
            boolean containsValue;
            synchronized (this.mutex) {
                containsValue = delegate().containsValue(obj);
            }
            return containsValue;
        }

        public final V get(Object obj, Object obj2) {
            V v;
            synchronized (this.mutex) {
                v = delegate().get(obj, obj2);
            }
            return v;
        }

        public final boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.mutex) {
                isEmpty = delegate().isEmpty();
            }
            return isEmpty;
        }

        public final int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        public final void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        public final V put(R r, C c, V v) {
            V put;
            synchronized (this.mutex) {
                put = delegate().put(r, c, v);
            }
            return put;
        }

        public final void putAll(Table<? extends R, ? extends C, ? extends V> table) {
            synchronized (this.mutex) {
                delegate().putAll(table);
            }
        }

        public final V remove(Object obj, Object obj2) {
            V remove;
            synchronized (this.mutex) {
                remove = delegate().remove(obj, obj2);
            }
            return remove;
        }

        public final Map<C, V> row(R r) {
            Map<C, V> map;
            synchronized (this.mutex) {
                map = Synchronized.map(delegate().row(r), this.mutex);
            }
            return map;
        }

        public final Map<R, V> column(C c) {
            Map<R, V> map;
            synchronized (this.mutex) {
                map = Synchronized.map(delegate().column(c), this.mutex);
            }
            return map;
        }

        public final Set<Table.Cell<R, C, V>> cellSet() {
            Set<Table.Cell<R, C, V>> set;
            synchronized (this.mutex) {
                set = Synchronized.set(delegate().cellSet(), this.mutex);
            }
            return set;
        }

        public final Set<R> rowKeySet() {
            Set<R> set;
            synchronized (this.mutex) {
                set = Synchronized.set(delegate().rowKeySet(), this.mutex);
            }
            return set;
        }

        public final Set<C> columnKeySet() {
            Set<C> set;
            synchronized (this.mutex) {
                set = Synchronized.set(delegate().columnKeySet(), this.mutex);
            }
            return set;
        }

        public final Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                collection = Synchronized.collection(delegate().values(), this.mutex);
            }
            return collection;
        }

        public final Map<R, Map<C, V>> rowMap() {
            Map<R, Map<C, V>> map;
            synchronized (this.mutex) {
                map = Synchronized.map(Maps.transformValues(delegate().rowMap(), new com.google.common.base.Function<Map<C, V>, Map<C, V>>() {
                    /* class com.google.common.collect.Synchronized.SynchronizedTable.AnonymousClass1 */

                    public Map<C, V> apply(Map<C, V> map) {
                        return Synchronized.map(map, SynchronizedTable.this.mutex);
                    }
                }), this.mutex);
            }
            return map;
        }

        public final Map<C, Map<R, V>> columnMap() {
            Map<C, Map<R, V>> map;
            synchronized (this.mutex) {
                map = Synchronized.map(Maps.transformValues(delegate().columnMap(), new com.google.common.base.Function<Map<R, V>, Map<R, V>>() {
                    /* class com.google.common.collect.Synchronized.SynchronizedTable.AnonymousClass2 */

                    public Map<R, V> apply(Map<R, V> map) {
                        return Synchronized.map(map, SynchronizedTable.this.mutex);
                    }
                }), this.mutex);
            }
            return map;
        }

        public final int hashCode() {
            int hashCode;
            synchronized (this.mutex) {
                hashCode = delegate().hashCode();
            }
            return hashCode;
        }

        public final boolean equals(Object obj) {
            boolean equals;
            if (this == obj) {
                return true;
            }
            synchronized (this.mutex) {
                equals = delegate().equals(obj);
            }
            return equals;
        }
    }
}
