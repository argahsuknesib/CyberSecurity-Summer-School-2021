package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Predicate;

@GwtCompatible(emulated = true)
public final class Lists {
    private Lists() {
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    @GwtCompatible(serializable = true)
    @CanIgnoreReturnValue
    @SafeVarargs
    public static <E> ArrayList<E> newArrayList(Object... objArr) {
        Preconditions.checkNotNull(objArr);
        ArrayList<E> arrayList = new ArrayList<>(computeArrayListCapacity(objArr.length));
        Collections.addAll(arrayList, objArr);
        return arrayList;
    }

    @GwtCompatible(serializable = true)
    @CanIgnoreReturnValue
    public static <E> ArrayList<E> newArrayList(Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList<>(Collections2.cast(iterable));
        }
        return newArrayList(iterable.iterator());
    }

    @GwtCompatible(serializable = true)
    @CanIgnoreReturnValue
    public static <E> ArrayList<E> newArrayList(Iterator it) {
        ArrayList<E> newArrayList = newArrayList();
        Iterators.addAll(newArrayList, it);
        return newArrayList;
    }

    @VisibleForTesting
    static int computeArrayListCapacity(int i) {
        CollectPreconditions.checkNonnegative(i, "arraySize");
        return Ints.saturatedCast(((long) i) + 5 + ((long) (i / 10)));
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayListWithCapacity(int i) {
        CollectPreconditions.checkNonnegative(i, "initialArraySize");
        return new ArrayList<>(i);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayListWithExpectedSize(int i) {
        return new ArrayList<>(computeArrayListCapacity(i));
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> newLinkedList(Iterable<? extends E> iterable) {
        LinkedList<E> newLinkedList = newLinkedList();
        Iterables.addAll(newLinkedList, iterable);
        return newLinkedList;
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList<>();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Iterable<? extends E>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @GwtIncompatible
    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList(Iterable<? extends E> r1) {
        return new CopyOnWriteArrayList<>(r1 instanceof Collection ? Collections2.cast(r1) : newArrayList((Iterable) r1));
    }

    public static <E> List<E> asList(E e, E[] eArr) {
        return new OnePlusArrayList(e, eArr);
    }

    public static <E> List<E> asList(E e, E e2, E[] eArr) {
        return new TwoPlusArrayList(e, e2, eArr);
    }

    static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final E first;
        final E[] rest;

        OnePlusArrayList(E e, E[] eArr) {
            this.first = e;
            this.rest = (Object[]) Preconditions.checkNotNull(eArr);
        }

        public int size() {
            return IntMath.saturatedAdd(this.rest.length, 1);
        }

        public E get(int i) {
            Preconditions.checkElementIndex(i, size());
            return i == 0 ? this.first : this.rest[i - 1];
        }
    }

    static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final E first;
        final E[] rest;
        final E second;

        TwoPlusArrayList(E e, E e2, E[] eArr) {
            this.first = e;
            this.second = e2;
            this.rest = (Object[]) Preconditions.checkNotNull(eArr);
        }

        public int size() {
            return IntMath.saturatedAdd(this.rest.length, 2);
        }

        public E get(int i) {
            if (i == 0) {
                return this.first;
            }
            if (i == 1) {
                return this.second;
            }
            Preconditions.checkElementIndex(i, size());
            return this.rest[i - 2];
        }
    }

    public static <B> List<List<B>> cartesianProduct(List<? extends List<? extends B>> list) {
        return CartesianList.create(list);
    }

    @SafeVarargs
    public static <B> List<List<B>> cartesianProduct(List<? extends B>... listArr) {
        return cartesianProduct(Arrays.asList(listArr));
    }

    public static <F, T> List<T> transform(List<F> list, Function<? super F, ? extends T> function) {
        return list instanceof RandomAccess ? new TransformingRandomAccessList(list, function) : new TransformingSequentialList(list, function);
    }

    static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        TransformingSequentialList(List<F> list, Function<? super F, ? extends T> function2) {
            this.fromList = (List) Preconditions.checkNotNull(list);
            this.function = (Function) Preconditions.checkNotNull(function2);
        }

        public void clear() {
            this.fromList.clear();
        }

        public int size() {
            return this.fromList.size();
        }

        public ListIterator<T> listIterator(int i) {
            return new TransformedListIterator<F, T>(this.fromList.listIterator(i)) {
                /* class com.google.common.collect.Lists.TransformingSequentialList.AnonymousClass1 */

                /* access modifiers changed from: package-private */
                public T transform(F f) {
                    return TransformingSequentialList.this.function.apply(f);
                }
            };
        }

        public boolean removeIf(Predicate<? super T> predicate) {
            Preconditions.checkNotNull(predicate);
            return this.fromList.removeIf(new Predicate(predicate) {
                /* class com.google.common.collect.$$Lambda$Lists$TransformingSequentialList$gefUOqUeZ_qGqBwGXQbDQQfe4c */
                private final /* synthetic */ Predicate f$1;

                {
                    this.f$1 = r2;
                }

                public final boolean test(Object obj) {
                    return Lists.TransformingSequentialList.this.lambda$removeIf$0$Lists$TransformingSequentialList(this.f$1, obj);
                }
            });
        }

        public /* synthetic */ boolean lambda$removeIf$0$Lists$TransformingSequentialList(Predicate predicate, Object obj) {
            return predicate.test(this.function.apply(obj));
        }
    }

    static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        TransformingRandomAccessList(List<F> list, Function<? super F, ? extends T> function2) {
            this.fromList = (List) Preconditions.checkNotNull(list);
            this.function = (Function) Preconditions.checkNotNull(function2);
        }

        public void clear() {
            this.fromList.clear();
        }

        public T get(int i) {
            return this.function.apply(this.fromList.get(i));
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i) {
            return new TransformedListIterator<F, T>(this.fromList.listIterator(i)) {
                /* class com.google.common.collect.Lists.TransformingRandomAccessList.AnonymousClass1 */

                /* access modifiers changed from: package-private */
                public T transform(F f) {
                    return TransformingRandomAccessList.this.function.apply(f);
                }
            };
        }

        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        public boolean removeIf(Predicate<? super T> predicate) {
            Preconditions.checkNotNull(predicate);
            return this.fromList.removeIf(new Predicate(predicate) {
                /* class com.google.common.collect.$$Lambda$Lists$TransformingRandomAccessList$g7MolxqBYF0nCjBJyyPsyRjD6Q */
                private final /* synthetic */ Predicate f$1;

                {
                    this.f$1 = r2;
                }

                public final boolean test(Object obj) {
                    return Lists.TransformingRandomAccessList.this.lambda$removeIf$0$Lists$TransformingRandomAccessList(this.f$1, obj);
                }
            });
        }

        public /* synthetic */ boolean lambda$removeIf$0$Lists$TransformingRandomAccessList(Predicate predicate, Object obj) {
            return predicate.test(this.function.apply(obj));
        }

        public T remove(int i) {
            return this.function.apply(this.fromList.remove(i));
        }

        public int size() {
            return this.fromList.size();
        }
    }

    public static <T> List<List<T>> partition(List<T> list, int i) {
        Preconditions.checkNotNull(list);
        Preconditions.checkArgument(i > 0);
        return list instanceof RandomAccess ? new RandomAccessPartition(list, i) : new Partition(list, i);
    }

    static class Partition<T> extends AbstractList<List<T>> {
        final List<T> list;
        final int size;

        Partition(List<T> list2, int i) {
            this.list = list2;
            this.size = i;
        }

        public List<T> get(int i) {
            Preconditions.checkElementIndex(i, size());
            int i2 = this.size;
            int i3 = i * i2;
            return this.list.subList(i3, Math.min(i2 + i3, this.list.size()));
        }

        public int size() {
            return IntMath.divide(this.list.size(), this.size, RoundingMode.CEILING);
        }

        public boolean isEmpty() {
            return this.list.isEmpty();
        }
    }

    static class RandomAccessPartition<T> extends Partition<T> implements RandomAccess {
        RandomAccessPartition(List<T> list, int i) {
            super(list, i);
        }
    }

    public static ImmutableList<Character> charactersOf(String str) {
        return new StringAsImmutableList((String) Preconditions.checkNotNull(str));
    }

    @Beta
    public static List<Character> charactersOf(CharSequence charSequence) {
        return new CharSequenceAsList((CharSequence) Preconditions.checkNotNull(charSequence));
    }

    static final class StringAsImmutableList extends ImmutableList<Character> {
        private final String string;

        /* access modifiers changed from: package-private */
        public final boolean isPartialView() {
            return false;
        }

        StringAsImmutableList(String str) {
            this.string = str;
        }

        public final int indexOf(Object obj) {
            if (obj instanceof Character) {
                return this.string.indexOf(((Character) obj).charValue());
            }
            return -1;
        }

        public final int lastIndexOf(Object obj) {
            if (obj instanceof Character) {
                return this.string.lastIndexOf(((Character) obj).charValue());
            }
            return -1;
        }

        public final ImmutableList<Character> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            return Lists.charactersOf(this.string.substring(i, i2));
        }

        public final Character get(int i) {
            Preconditions.checkElementIndex(i, size());
            return Character.valueOf(this.string.charAt(i));
        }

        public final int size() {
            return this.string.length();
        }
    }

    static final class CharSequenceAsList extends AbstractList<Character> {
        private final CharSequence sequence;

        CharSequenceAsList(CharSequence charSequence) {
            this.sequence = charSequence;
        }

        public final Character get(int i) {
            Preconditions.checkElementIndex(i, size());
            return Character.valueOf(this.sequence.charAt(i));
        }

        public final int size() {
            return this.sequence.length();
        }
    }

    public static <T> List<T> reverse(List<T> list) {
        if (list instanceof ImmutableList) {
            return ((ImmutableList) list).reverse();
        }
        if (list instanceof ReverseList) {
            return ((ReverseList) list).getForwardList();
        }
        if (list instanceof RandomAccess) {
            return new RandomAccessReverseList(list);
        }
        return new ReverseList(list);
    }

    static class ReverseList<T> extends AbstractList<T> {
        private final List<T> forwardList;

        ReverseList(List<T> list) {
            this.forwardList = (List) Preconditions.checkNotNull(list);
        }

        /* access modifiers changed from: package-private */
        public List<T> getForwardList() {
            return this.forwardList;
        }

        private int reverseIndex(int i) {
            int size = size();
            Preconditions.checkElementIndex(i, size);
            return (size - 1) - i;
        }

        public int reversePosition(int i) {
            int size = size();
            Preconditions.checkPositionIndex(i, size);
            return size - i;
        }

        public void add(int i, T t) {
            this.forwardList.add(reversePosition(i), t);
        }

        public void clear() {
            this.forwardList.clear();
        }

        public T remove(int i) {
            return this.forwardList.remove(reverseIndex(i));
        }

        /* access modifiers changed from: protected */
        public void removeRange(int i, int i2) {
            subList(i, i2).clear();
        }

        public T set(int i, T t) {
            return this.forwardList.set(reverseIndex(i), t);
        }

        public T get(int i) {
            return this.forwardList.get(reverseIndex(i));
        }

        public int size() {
            return this.forwardList.size();
        }

        public List<T> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            return Lists.reverse(this.forwardList.subList(reversePosition(i2), reversePosition(i)));
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i) {
            final ListIterator<T> listIterator = this.forwardList.listIterator(reversePosition(i));
            return new ListIterator<T>() {
                /* class com.google.common.collect.Lists.ReverseList.AnonymousClass1 */
                boolean canRemoveOrSet;

                public void add(T t) {
                    listIterator.add(t);
                    listIterator.previous();
                    this.canRemoveOrSet = false;
                }

                public boolean hasNext() {
                    return listIterator.hasPrevious();
                }

                public boolean hasPrevious() {
                    return listIterator.hasNext();
                }

                public T next() {
                    if (hasNext()) {
                        this.canRemoveOrSet = true;
                        return listIterator.previous();
                    }
                    throw new NoSuchElementException();
                }

                public int nextIndex() {
                    return ReverseList.this.reversePosition(listIterator.nextIndex());
                }

                public T previous() {
                    if (hasPrevious()) {
                        this.canRemoveOrSet = true;
                        return listIterator.next();
                    }
                    throw new NoSuchElementException();
                }

                public int previousIndex() {
                    return nextIndex() - 1;
                }

                public void remove() {
                    CollectPreconditions.checkRemove(this.canRemoveOrSet);
                    listIterator.remove();
                    this.canRemoveOrSet = false;
                }

                public void set(T t) {
                    Preconditions.checkState(this.canRemoveOrSet);
                    listIterator.set(t);
                }
            };
        }
    }

    static class RandomAccessReverseList<T> extends ReverseList<T> implements RandomAccess {
        RandomAccessReverseList(List<T> list) {
            super(list);
        }
    }

    static int hashCodeImpl(List<?> list) {
        int i;
        int i2 = 1;
        for (Object next : list) {
            int i3 = i2 * 31;
            if (next == null) {
                i = 0;
            } else {
                i = next.hashCode();
            }
            i2 = ((i3 + i) ^ -1) ^ -1;
        }
        return i2;
    }

    static boolean equalsImpl(List<?> list, Object obj) {
        if (obj == Preconditions.checkNotNull(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return Iterators.elementsEqual(list.iterator(), list2.iterator());
        }
        for (int i = 0; i < size; i++) {
            if (!Objects.equal(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    static <E> boolean addAllImpl(List<E> list, int i, Iterable<? extends E> iterable) {
        ListIterator<E> listIterator = list.listIterator(i);
        boolean z = false;
        for (Object add : iterable) {
            listIterator.add(add);
            z = true;
        }
        return z;
    }

    static int indexOfImpl(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return indexOfRandomAccess(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (Objects.equal(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int indexOfRandomAccess(List<?> list, Object obj) {
        int size = list.size();
        int i = 0;
        if (obj == null) {
            while (i < size) {
                if (list.get(i) == null) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        while (i < size) {
            if (obj.equals(list.get(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    static int lastIndexOfImpl(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return lastIndexOfRandomAccess(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (Objects.equal(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int lastIndexOfRandomAccess(List<?> list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    static <E> ListIterator<E> listIteratorImpl(List<E> list, int i) {
        return new AbstractListWrapper(list).listIterator(i);
    }

    static <E> List<E> subListImpl(List<E> list, int i, int i2) {
        List list2;
        if (list instanceof RandomAccess) {
            list2 = new RandomAccessListWrapper<E>(list) {
                /* class com.google.common.collect.Lists.AnonymousClass1 */
                private static final long serialVersionUID = 0;

                public final ListIterator<E> listIterator(int i) {
                    return this.backingList.listIterator(i);
                }
            };
        } else {
            list2 = new AbstractListWrapper<E>(list) {
                /* class com.google.common.collect.Lists.AnonymousClass2 */
                private static final long serialVersionUID = 0;

                public final ListIterator<E> listIterator(int i) {
                    return this.backingList.listIterator(i);
                }
            };
        }
        return list2.subList(i, i2);
    }

    static class AbstractListWrapper<E> extends AbstractList<E> {
        final List<E> backingList;

        AbstractListWrapper(List<E> list) {
            this.backingList = (List) Preconditions.checkNotNull(list);
        }

        public void add(int i, E e) {
            this.backingList.add(i, e);
        }

        public boolean addAll(int i, Collection<? extends E> collection) {
            return this.backingList.addAll(i, collection);
        }

        public E get(int i) {
            return this.backingList.get(i);
        }

        public E remove(int i) {
            return this.backingList.remove(i);
        }

        public E set(int i, E e) {
            return this.backingList.set(i, e);
        }

        public boolean contains(Object obj) {
            return this.backingList.contains(obj);
        }

        public int size() {
            return this.backingList.size();
        }
    }

    static class RandomAccessListWrapper<E> extends AbstractListWrapper<E> implements RandomAccess {
        RandomAccessListWrapper(List<E> list) {
            super(list);
        }
    }

    static <T> List<T> cast(Iterable<T> iterable) {
        return (List) iterable;
    }
}
