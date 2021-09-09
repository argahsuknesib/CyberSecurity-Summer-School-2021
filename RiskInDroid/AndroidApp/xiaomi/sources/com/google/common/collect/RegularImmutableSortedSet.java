package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;

@GwtCompatible(emulated = true, serializable = true)
final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    static final RegularImmutableSortedSet<Comparable> NATURAL_EMPTY_SET = new RegularImmutableSortedSet<>(ImmutableList.of(), Ordering.natural());
    private final transient ImmutableList<E> elements;

    RegularImmutableSortedSet(ImmutableList<E> immutableList, Comparator<? super E> comparator) {
        super(comparator);
        this.elements = immutableList;
    }

    /* access modifiers changed from: package-private */
    public final Object[] internalArray() {
        return this.elements.internalArray();
    }

    /* access modifiers changed from: package-private */
    public final int internalArrayStart() {
        return this.elements.internalArrayStart();
    }

    /* access modifiers changed from: package-private */
    public final int internalArrayEnd() {
        return this.elements.internalArrayEnd();
    }

    public final UnmodifiableIterator<E> iterator() {
        return this.elements.iterator();
    }

    @GwtIncompatible
    public final UnmodifiableIterator<E> descendingIterator() {
        return this.elements.reverse().iterator();
    }

    public final Spliterator<E> spliterator() {
        return asList().spliterator();
    }

    public final void forEach(Consumer<? super E> consumer) {
        this.elements.forEach(consumer);
    }

    public final int size() {
        return this.elements.size();
    }

    public final boolean contains(Object obj) {
        if (obj != null) {
            try {
                if (unsafeBinarySearch(obj) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    public final boolean containsAll(Collection<?> collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        if (!SortedIterables.hasSameComparator(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        UnmodifiableIterator it = iterator();
        Iterator<?> it2 = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        Object next = it2.next();
        Object next2 = it.next();
        while (true) {
            try {
                int unsafeCompare = unsafeCompare(next2, next);
                if (unsafeCompare < 0) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    next2 = it.next();
                } else if (unsafeCompare == 0) {
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else if (unsafeCompare > 0) {
                    break;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    private int unsafeBinarySearch(Object obj) throws ClassCastException {
        return Collections.binarySearch(this.elements, obj, unsafeComparator());
    }

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return this.elements.isPartialView();
    }

    /* access modifiers changed from: package-private */
    public final int copyIntoArray(Object[] objArr, int i) {
        return this.elements.copyIntoArray(objArr, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0034 A[Catch:{ ClassCastException | NoSuchElementException -> 0x0046 }] */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!SortedIterables.hasSameComparator(this.comparator, set)) {
            return containsAll(set);
        }
        Iterator it = set.iterator();
        try {
            UnmodifiableIterator it2 = iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                Object next2 = it.next();
                if (next2 == null || unsafeCompare(next, next2) != 0) {
                    return false;
                }
                while (it2.hasNext()) {
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    public final E first() {
        if (!isEmpty()) {
            return this.elements.get(0);
        }
        throw new NoSuchElementException();
    }

    public final E last() {
        if (!isEmpty()) {
            return this.elements.get(size() - 1);
        }
        throw new NoSuchElementException();
    }

    public final E lower(E e) {
        int headIndex = headIndex(e, false) - 1;
        if (headIndex == -1) {
            return null;
        }
        return this.elements.get(headIndex);
    }

    public final E floor(E e) {
        int headIndex = headIndex(e, true) - 1;
        if (headIndex == -1) {
            return null;
        }
        return this.elements.get(headIndex);
    }

    public final E ceiling(E e) {
        int tailIndex = tailIndex(e, true);
        if (tailIndex == size()) {
            return null;
        }
        return this.elements.get(tailIndex);
    }

    public final E higher(E e) {
        int tailIndex = tailIndex(e, false);
        if (tailIndex == size()) {
            return null;
        }
        return this.elements.get(tailIndex);
    }

    /* access modifiers changed from: package-private */
    public final ImmutableSortedSet<E> headSetImpl(E e, boolean z) {
        return getSubSet(0, headIndex(e, z));
    }

    /* access modifiers changed from: package-private */
    public final int headIndex(E e, boolean z) {
        int binarySearch = Collections.binarySearch(this.elements, Preconditions.checkNotNull(e), comparator());
        if (binarySearch >= 0) {
            return z ? binarySearch + 1 : binarySearch;
        }
        return binarySearch ^ -1;
    }

    /* access modifiers changed from: package-private */
    public final ImmutableSortedSet<E> subSetImpl(E e, boolean z, E e2, boolean z2) {
        return tailSetImpl(e, z).headSetImpl(e2, z2);
    }

    /* access modifiers changed from: package-private */
    public final ImmutableSortedSet<E> tailSetImpl(E e, boolean z) {
        return getSubSet(tailIndex(e, z), size());
    }

    /* access modifiers changed from: package-private */
    public final int tailIndex(E e, boolean z) {
        int binarySearch = Collections.binarySearch(this.elements, Preconditions.checkNotNull(e), comparator());
        if (binarySearch >= 0) {
            return z ? binarySearch : binarySearch + 1;
        }
        return binarySearch ^ -1;
    }

    /* access modifiers changed from: package-private */
    public final Comparator<Object> unsafeComparator() {
        return this.comparator;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableList.subList(int, int):com.google.common.collect.ImmutableList<E>
     arg types: [int, int]
     candidates:
      com.google.common.collect.ImmutableList.subList(int, int):java.util.List
      ClspMth{java.util.List.subList(int, int):java.util.List<E>}
      com.google.common.collect.ImmutableList.subList(int, int):com.google.common.collect.ImmutableList<E> */
    /* access modifiers changed from: package-private */
    public final RegularImmutableSortedSet<E> getSubSet(int i, int i2) {
        if (i == 0 && i2 == size()) {
            return this;
        }
        if (i < i2) {
            return new RegularImmutableSortedSet<>(this.elements.subList(i, i2), this.comparator);
        }
        return emptySet(this.comparator);
    }

    /* access modifiers changed from: package-private */
    public final int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int binarySearch = Collections.binarySearch(this.elements, obj, unsafeComparator());
            if (binarySearch >= 0) {
                return binarySearch;
            }
            return -1;
        } catch (ClassCastException unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final ImmutableList<E> createAsList() {
        return size() <= 1 ? this.elements : new ImmutableSortedAsList(this, this.elements);
    }

    /* access modifiers changed from: package-private */
    public final ImmutableSortedSet<E> createDescendingSet() {
        Comparator reverseOrder = Collections.reverseOrder(this.comparator);
        if (isEmpty()) {
            return emptySet(reverseOrder);
        }
        return new RegularImmutableSortedSet(this.elements.reverse(), reverseOrder);
    }
}
