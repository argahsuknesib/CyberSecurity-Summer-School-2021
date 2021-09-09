package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Collector;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements SortedIterable<E>, NavigableSet<E> {
    final transient Comparator<? super E> comparator;
    @GwtIncompatible
    @LazyInit
    transient ImmutableSortedSet<E> descendingSet;

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public abstract ImmutableSortedSet<E> createDescendingSet();

    @GwtIncompatible
    public abstract UnmodifiableIterator<E> descendingIterator();

    /* access modifiers changed from: package-private */
    public abstract ImmutableSortedSet<E> headSetImpl(Object obj, boolean z);

    /* access modifiers changed from: package-private */
    public abstract int indexOf(Object obj);

    public abstract UnmodifiableIterator<E> iterator();

    /* access modifiers changed from: package-private */
    public abstract ImmutableSortedSet<E> subSetImpl(Object obj, boolean z, Object obj2, boolean z2);

    /* access modifiers changed from: package-private */
    public abstract ImmutableSortedSet<E> tailSetImpl(Object obj, boolean z);

    @Beta
    public static <E> Collector<E, ?, ImmutableSortedSet<E>> toImmutableSortedSet(Comparator<? super E> comparator2) {
        return CollectCollectors.toImmutableSortedSet(comparator2);
    }

    static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> comparator2) {
        if (Ordering.natural().equals(comparator2)) {
            return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
        }
        return new RegularImmutableSortedSet<>(ImmutableList.of(), comparator2);
    }

    public static <E> ImmutableSortedSet<E> of() {
        return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e) {
        return new RegularImmutableSortedSet(ImmutableList.of(e), Ordering.natural());
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2) {
        return construct(Ordering.natural(), 2, e, e2);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2, E e3) {
        return construct(Ordering.natural(), 3, e, e2, e3);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2, E e3, E e4) {
        return construct(Ordering.natural(), 4, e, e2, e3, e4);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2, E e3, E e4, E e5) {
        return construct(Ordering.natural(), 5, e, e2, e3, e4, e5);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        Comparable[] comparableArr = new Comparable[(eArr.length + 6)];
        comparableArr[0] = e;
        comparableArr[1] = e2;
        comparableArr[2] = e3;
        comparableArr[3] = e4;
        comparableArr[4] = e5;
        comparableArr[5] = e6;
        System.arraycopy(eArr, 0, comparableArr, 6, eArr.length);
        return construct(Ordering.natural(), comparableArr.length, comparableArr);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> copyOf(E[] eArr) {
        return construct(Ordering.natural(), eArr.length, (Object[]) eArr.clone());
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedSet.copyOf(java.util.Comparator, java.util.Collection):com.google.common.collect.ImmutableSortedSet<E>
     arg types: [com.google.common.collect.Ordering, java.util.Collection<? extends E>]
     candidates:
      com.google.common.collect.ImmutableSortedSet.copyOf(java.util.Comparator, java.lang.Iterable):com.google.common.collect.ImmutableSortedSet<E>
      com.google.common.collect.ImmutableSortedSet.copyOf(java.util.Comparator, java.util.Iterator):com.google.common.collect.ImmutableSortedSet<E>
      com.google.common.collect.ImmutableSortedSet.copyOf(java.util.Comparator, java.util.Collection):com.google.common.collect.ImmutableSortedSet<E> */
    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> collection) {
        return copyOf((Comparator) Ordering.natural(), (Collection) collection);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator comparator2, Iterator it) {
        return new Builder(comparator2).addAll(it).build();
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator comparator2, Iterable iterable) {
        Preconditions.checkNotNull(comparator2);
        if (SortedIterables.hasSameComparator(comparator2, iterable) && (iterable instanceof ImmutableSortedSet)) {
            ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet) iterable;
            if (!immutableSortedSet.isPartialView()) {
                return immutableSortedSet;
            }
        }
        Object[] array = Iterables.toArray(iterable);
        return construct(comparator2, array.length, array);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedSet.copyOf(java.util.Comparator, java.lang.Iterable):com.google.common.collect.ImmutableSortedSet<E>
     arg types: [java.util.Comparator, java.util.Collection]
     candidates:
      com.google.common.collect.ImmutableSortedSet.copyOf(java.util.Comparator, java.util.Collection):com.google.common.collect.ImmutableSortedSet<E>
      com.google.common.collect.ImmutableSortedSet.copyOf(java.util.Comparator, java.util.Iterator):com.google.common.collect.ImmutableSortedSet<E>
      com.google.common.collect.ImmutableSortedSet.copyOf(java.util.Comparator, java.lang.Iterable):com.google.common.collect.ImmutableSortedSet<E> */
    public static <E> ImmutableSortedSet<E> copyOf(Comparator comparator2, Collection collection) {
        return copyOf(comparator2, (Iterable) collection);
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator2 = SortedIterables.comparator(sortedSet);
        ImmutableList<E> copyOf = ImmutableList.copyOf((Collection) sortedSet);
        if (copyOf.isEmpty()) {
            return emptySet(comparator2);
        }
        return new RegularImmutableSortedSet(copyOf, comparator2);
    }

    static <E> ImmutableSortedSet<E> construct(Comparator<? super E> comparator2, int i, E... eArr) {
        if (i == 0) {
            return emptySet(comparator2);
        }
        ObjectArrays.checkElementsNotNull(eArr, i);
        Arrays.sort(eArr, 0, i, comparator2);
        int i2 = 1;
        for (int i3 = 1; i3 < i; i3++) {
            E e = eArr[i3];
            if (comparator2.compare(e, eArr[i2 - 1]) != 0) {
                eArr[i2] = e;
                i2++;
            }
        }
        Arrays.fill(eArr, i2, i, (Object) null);
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(eArr, i2), comparator2);
    }

    public static <E> Builder<E> orderedBy(Comparator<E> comparator2) {
        return new Builder<>(comparator2);
    }

    public static <E extends Comparable<?>> Builder<E> reverseOrder() {
        return new Builder<>(Collections.reverseOrder());
    }

    public static <E extends Comparable<?>> Builder<E> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    public static final class Builder<E> extends ImmutableSet.Builder<E> {
        private final Comparator<? super E> comparator;
        private E[] elements = ((Object[]) new Object[4]);
        private int n = 0;

        public Builder(Comparator<? super E> comparator2) {
            super(true);
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator2);
        }

        /* access modifiers changed from: package-private */
        public final void copy() {
            E[] eArr = this.elements;
            this.elements = Arrays.copyOf(eArr, eArr.length);
        }

        private void sortAndDedup() {
            int i = this.n;
            if (i != 0) {
                Arrays.sort(this.elements, 0, i, this.comparator);
                int i2 = 1;
                int i3 = 1;
                while (true) {
                    int i4 = this.n;
                    if (i2 < i4) {
                        Comparator<? super E> comparator2 = this.comparator;
                        E[] eArr = this.elements;
                        int compare = comparator2.compare(eArr[i3 - 1], eArr[i2]);
                        if (compare < 0) {
                            E[] eArr2 = this.elements;
                            eArr2[i3] = eArr2[i2];
                            i3++;
                        } else if (compare > 0) {
                            throw new AssertionError("Comparator " + this.comparator + " compare method violates its contract");
                        }
                        i2++;
                    } else {
                        Arrays.fill(this.elements, i3, i4, (Object) null);
                        this.n = i3;
                        return;
                    }
                }
            }
        }

        @CanIgnoreReturnValue
        public final Builder<E> add(Object obj) {
            Preconditions.checkNotNull(obj);
            copyIfNecessary();
            if (this.n == this.elements.length) {
                sortAndDedup();
                int i = this.n;
                int expandedCapacity = ImmutableCollection.Builder.expandedCapacity(i, i + 1);
                E[] eArr = this.elements;
                if (expandedCapacity > eArr.length) {
                    this.elements = Arrays.copyOf(eArr, expandedCapacity);
                }
            }
            Object[] objArr = this.elements;
            int i2 = this.n;
            this.n = i2 + 1;
            objArr[i2] = obj;
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder<E> add(Object... objArr) {
            ObjectArrays.checkElementsNotNull(objArr);
            for (Object add : objArr) {
                add(add);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder<E> addAll(Iterable<? extends E> iterable) {
            super.addAll((Iterable) iterable);
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder<E> addAll(Iterator<? extends E> it) {
            super.addAll((Iterator) it);
            return this;
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public final Builder<E> combine(ImmutableSet.Builder<E> builder) {
            copyIfNecessary();
            Builder builder2 = (Builder) builder;
            for (int i = 0; i < builder2.n; i++) {
                add((Object) builder2.elements[i]);
            }
            return this;
        }

        public final ImmutableSortedSet<E> build() {
            sortAndDedup();
            int i = this.n;
            if (i == 0) {
                return ImmutableSortedSet.emptySet(this.comparator);
            }
            this.forceCopy = true;
            return new RegularImmutableSortedSet(ImmutableList.asImmutableList(this.elements, i), this.comparator);
        }
    }

    /* access modifiers changed from: package-private */
    public int unsafeCompare(Object obj, Object obj2) {
        return unsafeCompare(this.comparator, obj, obj2);
    }

    static int unsafeCompare(Comparator<?> comparator2, Object obj, Object obj2) {
        return comparator2.compare(obj, obj2);
    }

    ImmutableSortedSet(Comparator<? super E> comparator2) {
        this.comparator = comparator2;
    }

    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedSet.headSet(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E>
     arg types: [E, int]
     candidates:
      com.google.common.collect.ImmutableSortedSet.headSet(java.lang.Object, boolean):java.util.NavigableSet
      ClspMth{java.util.NavigableSet.headSet(java.lang.Object, boolean):java.util.NavigableSet<E>}
      com.google.common.collect.ImmutableSortedSet.headSet(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E> */
    public ImmutableSortedSet<E> headSet(E e) {
        return headSet((Object) e, false);
    }

    @GwtIncompatible
    public ImmutableSortedSet<E> headSet(E e, boolean z) {
        return headSetImpl(Preconditions.checkNotNull(e), z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedSet.subSet(java.lang.Object, boolean, java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E>
     arg types: [E, int, E, int]
     candidates:
      com.google.common.collect.ImmutableSortedSet.subSet(java.lang.Object, boolean, java.lang.Object, boolean):java.util.NavigableSet
      ClspMth{java.util.NavigableSet.subSet(java.lang.Object, boolean, java.lang.Object, boolean):java.util.NavigableSet<E>}
      com.google.common.collect.ImmutableSortedSet.subSet(java.lang.Object, boolean, java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E> */
    public ImmutableSortedSet<E> subSet(E e, E e2) {
        return subSet((Object) e, true, (Object) e2, false);
    }

    @GwtIncompatible
    public ImmutableSortedSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        Preconditions.checkNotNull(e);
        Preconditions.checkNotNull(e2);
        Preconditions.checkArgument(this.comparator.compare(e, e2) <= 0);
        return subSetImpl(e, z, e2, z2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedSet.tailSet(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E>
     arg types: [E, int]
     candidates:
      com.google.common.collect.ImmutableSortedSet.tailSet(java.lang.Object, boolean):java.util.NavigableSet
      ClspMth{java.util.NavigableSet.tailSet(java.lang.Object, boolean):java.util.NavigableSet<E>}
      com.google.common.collect.ImmutableSortedSet.tailSet(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E> */
    public ImmutableSortedSet<E> tailSet(E e) {
        return tailSet((Object) e, true);
    }

    @GwtIncompatible
    public ImmutableSortedSet<E> tailSet(E e, boolean z) {
        return tailSetImpl(Preconditions.checkNotNull(e), z);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedSet.headSet(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E>
     arg types: [E, int]
     candidates:
      com.google.common.collect.ImmutableSortedSet.headSet(java.lang.Object, boolean):java.util.NavigableSet
      ClspMth{java.util.NavigableSet.headSet(java.lang.Object, boolean):java.util.NavigableSet<E>}
      com.google.common.collect.ImmutableSortedSet.headSet(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E> */
    @GwtIncompatible
    public E lower(E e) {
        return Iterators.getNext(headSet((Object) e, false).descendingIterator(), null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedSet.headSet(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E>
     arg types: [E, int]
     candidates:
      com.google.common.collect.ImmutableSortedSet.headSet(java.lang.Object, boolean):java.util.NavigableSet
      ClspMth{java.util.NavigableSet.headSet(java.lang.Object, boolean):java.util.NavigableSet<E>}
      com.google.common.collect.ImmutableSortedSet.headSet(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E> */
    @GwtIncompatible
    public E floor(E e) {
        return Iterators.getNext(headSet((Object) e, true).descendingIterator(), null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedSet.tailSet(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E>
     arg types: [E, int]
     candidates:
      com.google.common.collect.ImmutableSortedSet.tailSet(java.lang.Object, boolean):java.util.NavigableSet
      ClspMth{java.util.NavigableSet.tailSet(java.lang.Object, boolean):java.util.NavigableSet<E>}
      com.google.common.collect.ImmutableSortedSet.tailSet(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E> */
    @GwtIncompatible
    public E ceiling(E e) {
        return Iterables.getFirst(tailSet((Object) e, true), null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedSet.tailSet(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E>
     arg types: [E, int]
     candidates:
      com.google.common.collect.ImmutableSortedSet.tailSet(java.lang.Object, boolean):java.util.NavigableSet
      ClspMth{java.util.NavigableSet.tailSet(java.lang.Object, boolean):java.util.NavigableSet<E>}
      com.google.common.collect.ImmutableSortedSet.tailSet(java.lang.Object, boolean):com.google.common.collect.ImmutableSortedSet<E> */
    @GwtIncompatible
    public E higher(E e) {
        return Iterables.getFirst(tailSet((Object) e, false), null);
    }

    public E first() {
        return iterator().next();
    }

    public E last() {
        return descendingIterator().next();
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.descendingSet;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        ImmutableSortedSet<E> createDescendingSet = createDescendingSet();
        this.descendingSet = createDescendingSet;
        createDescendingSet.descendingSet = this;
        return createDescendingSet;
    }

    public Spliterator<E> spliterator() {
        return new Spliterators.AbstractSpliterator<E>((long) size(), 1365) {
            /* class com.google.common.collect.ImmutableSortedSet.AnonymousClass1 */
            final UnmodifiableIterator<E> iterator = ImmutableSortedSet.this.iterator();

            public boolean tryAdvance(Consumer<? super E> consumer) {
                if (!this.iterator.hasNext()) {
                    return false;
                }
                consumer.accept(this.iterator.next());
                return true;
            }

            public Comparator<? super E> getComparator() {
                return ImmutableSortedSet.this.comparator;
            }
        };
    }

    static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> comparator;
        final Object[] elements;

        public SerializedForm(Comparator<? super E> comparator2, Object[] objArr) {
            this.comparator = comparator2;
            this.elements = objArr;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return new Builder(this.comparator).add(this.elements).build();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new SerializedForm(this.comparator, toArray());
    }
}
