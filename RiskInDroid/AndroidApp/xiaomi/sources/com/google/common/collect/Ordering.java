package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@GwtCompatible
public abstract class Ordering<T> implements Comparator<T> {
    @CanIgnoreReturnValue
    public abstract int compare(T t, T t2);

    @GwtCompatible(serializable = true)
    public static <C extends Comparable> Ordering<C> natural() {
        return NaturalOrdering.INSTANCE;
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> from(Comparator comparator) {
        return comparator instanceof Ordering ? (Ordering) comparator : new ComparatorOrdering(comparator);
    }

    @GwtCompatible(serializable = true)
    @Deprecated
    public static <T> Ordering<T> from(Ordering ordering) {
        return (Ordering) Preconditions.checkNotNull(ordering);
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> explicit(List<T> list) {
        return new ExplicitOrdering(list);
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> explicit(T t, T... tArr) {
        return explicit(Lists.asList(t, tArr));
    }

    @GwtCompatible(serializable = true)
    public static Ordering<Object> allEqual() {
        return AllEqualOrdering.INSTANCE;
    }

    @GwtCompatible(serializable = true)
    public static Ordering<Object> usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }

    public static Ordering<Object> arbitrary() {
        return ArbitraryOrderingHolder.ARBITRARY_ORDERING;
    }

    static class ArbitraryOrderingHolder {
        static final Ordering<Object> ARBITRARY_ORDERING = new ArbitraryOrdering();

        private ArbitraryOrderingHolder() {
        }
    }

    @VisibleForTesting
    static class ArbitraryOrdering extends Ordering<Object> {
        private final AtomicInteger counter = new AtomicInteger(0);
        private final ConcurrentMap<Object, Integer> uids = Platform.tryWeakKeys(new MapMaker()).makeMap();

        public String toString() {
            return "Ordering.arbitrary()";
        }

        ArbitraryOrdering() {
        }

        private Integer getUid(Object obj) {
            Integer num = this.uids.get(obj);
            if (num != null) {
                return num;
            }
            Integer valueOf = Integer.valueOf(this.counter.getAndIncrement());
            Integer putIfAbsent = this.uids.putIfAbsent(obj, valueOf);
            return putIfAbsent != null ? putIfAbsent : valueOf;
        }

        public int compare(Object obj, Object obj2) {
            if (obj == obj2) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            int identityHashCode = identityHashCode(obj);
            int identityHashCode2 = identityHashCode(obj2);
            if (identityHashCode != identityHashCode2) {
                return identityHashCode < identityHashCode2 ? -1 : 1;
            }
            int compareTo = getUid(obj).compareTo(getUid(obj2));
            if (compareTo != 0) {
                return compareTo;
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public int identityHashCode(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    protected Ordering() {
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<S> reverse() {
        return new ReverseOrdering(this);
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<S> nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<S> nullsLast() {
        return new NullsLastOrdering(this);
    }

    @GwtCompatible(serializable = true)
    public <F> Ordering<F> onResultOf(Function<F, ? extends T> function) {
        return new ByFunctionOrdering(function, this);
    }

    /* access modifiers changed from: package-private */
    public <T2 extends T> Ordering<Map.Entry<T2, ?>> onKeys() {
        return onResultOf(Maps.keyFunction());
    }

    @GwtCompatible(serializable = true)
    public <U extends T> Ordering<U> compound(Comparator<? super U> comparator) {
        return new CompoundOrdering(this, (Comparator) Preconditions.checkNotNull(comparator));
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> iterable) {
        return new CompoundOrdering(iterable);
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<Iterable<S>> lexicographical() {
        return new LexicographicalOrdering(this);
    }

    @CanIgnoreReturnValue
    public <E extends T> E min(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = min(next, it.next());
        }
        return next;
    }

    @CanIgnoreReturnValue
    public <E extends T> E min(Iterable<E> iterable) {
        return min(iterable.iterator());
    }

    @CanIgnoreReturnValue
    public <E extends T> E min(E e, E e2) {
        return compare(e, e2) <= 0 ? e : e2;
    }

    @CanIgnoreReturnValue
    public <E extends T> E min(E e, E e2, E e3, E... eArr) {
        E min = min(min(e, e2), e3);
        for (E min2 : eArr) {
            min = min(min, min2);
        }
        return min;
    }

    @CanIgnoreReturnValue
    public <E extends T> E max(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = max(next, it.next());
        }
        return next;
    }

    @CanIgnoreReturnValue
    public <E extends T> E max(Iterable<E> iterable) {
        return max(iterable.iterator());
    }

    @CanIgnoreReturnValue
    public <E extends T> E max(E e, E e2) {
        return compare(e, e2) >= 0 ? e : e2;
    }

    @CanIgnoreReturnValue
    public <E extends T> E max(E e, E e2, E e3, E... eArr) {
        E max = max(max(e, e2), e3);
        for (E max2 : eArr) {
            max = max(max, max2);
        }
        return max;
    }

    public <E extends T> List<E> leastOf(Iterable<E> iterable, int i) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (((long) collection.size()) <= ((long) i) * 2) {
                Object[] array = collection.toArray();
                Arrays.sort(array, this);
                if (array.length > i) {
                    array = Arrays.copyOf(array, i);
                }
                return Collections.unmodifiableList(Arrays.asList(array));
            }
        }
        return leastOf(iterable.iterator(), i);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.Iterator<E>, java.util.Iterator, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public <E extends T> List<E> leastOf(Iterator<E> r2, int i) {
        Preconditions.checkNotNull(r2);
        CollectPreconditions.checkNonnegative(i, "k");
        if (i == 0 || !r2.hasNext()) {
            return Collections.emptyList();
        }
        if (i >= 1073741823) {
            ArrayList newArrayList = Lists.newArrayList((Iterator) r2);
            Collections.sort(newArrayList, this);
            if (newArrayList.size() > i) {
                newArrayList.subList(i, newArrayList.size()).clear();
            }
            newArrayList.trimToSize();
            return Collections.unmodifiableList(newArrayList);
        }
        TopKSelector least = TopKSelector.least(i, this);
        least.offerAll((Iterator) r2);
        return least.topK();
    }

    public <E extends T> List<E> greatestOf(Iterable<E> iterable, int i) {
        return reverse().leastOf(iterable, i);
    }

    public <E extends T> List<E> greatestOf(Iterator<E> it, int i) {
        return reverse().leastOf(it, i);
    }

    @CanIgnoreReturnValue
    public <E extends T> List<E> sortedCopy(Iterable<E> iterable) {
        Object[] array = Iterables.toArray(iterable);
        Arrays.sort(array, this);
        return Lists.newArrayList(Arrays.asList(array));
    }

    @CanIgnoreReturnValue
    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        return ImmutableList.sortedCopyOf(this, iterable);
    }

    public boolean isOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        Object next = it.next();
        while (it.hasNext()) {
            Object next2 = it.next();
            if (compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        Object next = it.next();
        while (it.hasNext()) {
            Object next2 = it.next();
            if (compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    @Deprecated
    public int binarySearch(List<? extends T> list, T t) {
        return Collections.binarySearch(list, t, this);
    }

    @VisibleForTesting
    static class IncomparableValueException extends ClassCastException {
        private static final long serialVersionUID = 0;
        final Object value;

        IncomparableValueException(Object obj) {
            super("Cannot compare value: ".concat(String.valueOf(obj)));
            this.value = obj;
        }
    }
}
