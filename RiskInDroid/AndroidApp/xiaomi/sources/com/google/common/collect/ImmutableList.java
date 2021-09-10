package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    public final ImmutableList<E> asList() {
        return this;
    }

    @Beta
    public static <E> Collector<E, ?, ImmutableList<E>> toImmutableList() {
        return CollectCollectors.toImmutableList();
    }

    public static <E> ImmutableList<E> of() {
        return RegularImmutableList.EMPTY;
    }

    public static <E> ImmutableList<E> of(E e) {
        return new SingletonImmutableList(e);
    }

    public static <E> ImmutableList<E> of(E e, E e2) {
        return construct(e, e2);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3) {
        return construct(e, e2, e3);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4) {
        return construct(e, e2, e3, e4);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5) {
        return construct(e, e2, e3, e4, e5);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6) {
        return construct(e, e2, e3, e4, e5, e6);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7) {
        return construct(e, e2, e3, e4, e5, e6, e7);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return construct(e, e2, e3, e4, e5, e6, e7, e8);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        return construct(e, e2, e3, e4, e5, e6, e7, e8, e9);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        return construct(e, e2, e3, e4, e5, e6, e7, e8, e9, e10);
    }

    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11) {
        return construct(e, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11);
    }

    @SafeVarargs
    public static <E> ImmutableList<E> of(E e, E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12, E... eArr) {
        E[] eArr2 = eArr;
        Preconditions.checkArgument(eArr2.length <= 2147483635, "the total number of elements must fit in an int");
        Object[] objArr = new Object[(eArr2.length + 12)];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        objArr[6] = e7;
        objArr[7] = e8;
        objArr[8] = e9;
        objArr[9] = e10;
        objArr[10] = e11;
        objArr[11] = e12;
        System.arraycopy(eArr2, 0, objArr, 12, eArr2.length);
        return construct(objArr);
    }

    public static <E> ImmutableList<E> copyOf(Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableList<E> copyOf(Collection collection) {
        if (!(collection instanceof ImmutableCollection)) {
            return construct(collection.toArray());
        }
        ImmutableList<E> asList = ((ImmutableCollection) collection).asList();
        return asList.isPartialView() ? asImmutableList(asList.toArray()) : asList;
    }

    public static <E> ImmutableList<E> copyOf(Iterator it) {
        if (!it.hasNext()) {
            return of();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return of(next);
        }
        return new Builder().add(next).addAll(it).build();
    }

    public static <E> ImmutableList<E> copyOf(Object[] objArr) {
        int length = objArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return construct((Object[]) objArr.clone());
        }
        return of(objArr[0]);
    }

    public static <E extends Comparable<? super E>> ImmutableList<E> sortedCopyOf(Iterable<? extends E> iterable) {
        Comparable[] comparableArr = (Comparable[]) Iterables.toArray(iterable, new Comparable[0]);
        ObjectArrays.checkElementsNotNull((Object[]) comparableArr);
        Arrays.sort(comparableArr);
        return asImmutableList(comparableArr);
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(comparator);
        Object[] array = Iterables.toArray(iterable);
        ObjectArrays.checkElementsNotNull(array);
        Arrays.sort(array, comparator);
        return asImmutableList(array);
    }

    private static <E> ImmutableList<E> construct(Object... objArr) {
        return asImmutableList(ObjectArrays.checkElementsNotNull(objArr));
    }

    static <E> ImmutableList<E> asImmutableList(Object[] objArr) {
        return asImmutableList(objArr, objArr.length);
    }

    static <E> ImmutableList<E> asImmutableList(Object[] objArr, int i) {
        if (i == 0) {
            return of();
        }
        if (i == 1) {
            return of(objArr[0]);
        }
        if (i < objArr.length) {
            objArr = Arrays.copyOf(objArr, i);
        }
        return new RegularImmutableList(objArr);
    }

    ImmutableList() {
    }

    public UnmodifiableIterator<E> iterator() {
        return listIterator();
    }

    public UnmodifiableListIterator<E> listIterator() {
        return listIterator(0);
    }

    public UnmodifiableListIterator<E> listIterator(int i) {
        return new AbstractIndexedListIterator<E>(size(), i) {
            /* class com.google.common.collect.ImmutableList.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public E get(int i) {
                return ImmutableList.this.get(i);
            }
        };
    }

    public void forEach(Consumer<? super E> consumer) {
        Preconditions.checkNotNull(consumer);
        int size = size();
        for (int i = 0; i < size; i++) {
            consumer.accept(get(i));
        }
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.indexOfImpl(this, obj);
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.lastIndexOfImpl(this, obj);
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public ImmutableList<E> subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return of();
        }
        if (i3 == 1) {
            return of(get(i));
        }
        return subListUnchecked(i, i2);
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<E> subListUnchecked(int i, int i2) {
        return new SubList(i, i2 - i);
    }

    class SubList extends ImmutableList<E> {
        final transient int length;
        final transient int offset;

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return true;
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return ImmutableList.super.iterator();
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return ImmutableList.super.listIterator();
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return ImmutableList.super.listIterator(i);
        }

        SubList(int i, int i2) {
            this.offset = i;
            this.length = i2;
        }

        public int size() {
            return this.length;
        }

        public E get(int i) {
            Preconditions.checkElementIndex(i, this.length);
            return ImmutableList.this.get(i + this.offset);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.ImmutableList.subList(int, int):com.google.common.collect.ImmutableList<E>
         arg types: [int, int]
         candidates:
          com.google.common.collect.ImmutableList.subList(int, int):java.util.List
          ClspMth{java.util.List.subList(int, int):java.util.List<E>}
          com.google.common.collect.ImmutableList.subList(int, int):com.google.common.collect.ImmutableList<E> */
        public ImmutableList<E> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, this.length);
            ImmutableList immutableList = ImmutableList.this;
            int i3 = this.offset;
            return immutableList.subList(i + i3, i2 + i3);
        }
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void replaceAll(UnaryOperator<E> unaryOperator) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void sort(Comparator<? super E> comparator) {
        throw new UnsupportedOperationException();
    }

    public Spliterator<E> spliterator() {
        return CollectSpliterators.indexed(size(), 1296, new IntFunction() {
            /* class com.google.common.collect.$$Lambda$J9zVGv6YXVkAf1JUJc7fbdQoC3U */

            public final Object apply(int i) {
                return ImmutableList.this.get(i);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public int copyIntoArray(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public ImmutableList<E> reverse() {
        return size() <= 1 ? this : new ReverseImmutableList(this);
    }

    static class ReverseImmutableList<E> extends ImmutableList<E> {
        private final transient ImmutableList<E> forwardList;

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return ImmutableList.super.iterator();
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return ImmutableList.super.listIterator();
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator(int i) {
            return ImmutableList.super.listIterator(i);
        }

        ReverseImmutableList(ImmutableList<E> immutableList) {
            this.forwardList = immutableList;
        }

        private int reverseIndex(int i) {
            return (size() - 1) - i;
        }

        private int reversePosition(int i) {
            return size() - i;
        }

        public ImmutableList<E> reverse() {
            return this.forwardList;
        }

        public boolean contains(Object obj) {
            return this.forwardList.contains(obj);
        }

        public int indexOf(Object obj) {
            int lastIndexOf = this.forwardList.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return reverseIndex(lastIndexOf);
            }
            return -1;
        }

        public int lastIndexOf(Object obj) {
            int indexOf = this.forwardList.indexOf(obj);
            if (indexOf >= 0) {
                return reverseIndex(indexOf);
            }
            return -1;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.ImmutableList.subList(int, int):com.google.common.collect.ImmutableList<E>
         arg types: [int, int]
         candidates:
          com.google.common.collect.ImmutableList.subList(int, int):java.util.List
          ClspMth{java.util.List.subList(int, int):java.util.List<E>}
          com.google.common.collect.ImmutableList.subList(int, int):com.google.common.collect.ImmutableList<E> */
        public ImmutableList<E> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            return this.forwardList.subList(reversePosition(i2), reversePosition(i)).reverse();
        }

        public E get(int i) {
            Preconditions.checkElementIndex(i, size());
            return this.forwardList.get(reverseIndex(i));
        }

        public int size() {
            return this.forwardList.size();
        }

        /* access modifiers changed from: package-private */
        public boolean isPartialView() {
            return this.forwardList.isPartialView();
        }
    }

    public boolean equals(Object obj) {
        return Lists.equalsImpl(this, obj);
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (((i * 31) + get(i2).hashCode()) ^ -1) ^ -1;
        }
        return i;
    }

    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return ImmutableList.copyOf(this.elements);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    @Beta
    public static <E> Builder<E> builderWithExpectedSize(int i) {
        CollectPreconditions.checkNonnegative(i, "expectedSize");
        return new Builder<>(i);
    }

    public static final class Builder<E> extends ImmutableCollection.Builder<E> {
        @VisibleForTesting
        Object[] contents;
        private boolean forceCopy;
        private int size;

        public Builder() {
            this(4);
        }

        Builder(int i) {
            this.contents = new Object[i];
            this.size = 0;
        }

        private void getReadyToExpandTo(int i) {
            Object[] objArr = this.contents;
            if (objArr.length < i) {
                this.contents = Arrays.copyOf(objArr, expandedCapacity(objArr.length, i));
                this.forceCopy = false;
            } else if (this.forceCopy) {
                this.contents = Arrays.copyOf(objArr, objArr.length);
                this.forceCopy = false;
            }
        }

        @CanIgnoreReturnValue
        public final Builder<E> add(E e) {
            Preconditions.checkNotNull(e);
            getReadyToExpandTo(this.size + 1);
            Object[] objArr = this.contents;
            int i = this.size;
            this.size = i + 1;
            objArr[i] = e;
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder<E> add(E... eArr) {
            ObjectArrays.checkElementsNotNull(eArr);
            add(eArr, eArr.length);
            return this;
        }

        private void add(Object[] objArr, int i) {
            getReadyToExpandTo(this.size + i);
            System.arraycopy(objArr, 0, this.contents, this.size, i);
            this.size += i;
        }

        @CanIgnoreReturnValue
        public final Builder<E> addAll(Iterable<? extends E> iterable) {
            Preconditions.checkNotNull(iterable);
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                getReadyToExpandTo(this.size + collection.size());
                if (collection instanceof ImmutableCollection) {
                    this.size = ((ImmutableCollection) collection).copyIntoArray(this.contents, this.size);
                    return this;
                }
            }
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
        public final Builder<E> combine(Builder<E> builder) {
            Preconditions.checkNotNull(builder);
            add(builder.contents, builder.size);
            return this;
        }

        public final ImmutableList<E> build() {
            this.forceCopy = true;
            return ImmutableList.asImmutableList(this.contents, this.size);
        }
    }
}
