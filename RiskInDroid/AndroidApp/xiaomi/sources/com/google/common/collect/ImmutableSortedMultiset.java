package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

@GwtIncompatible
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements SortedMultiset<E> {
    @LazyInit
    transient ImmutableSortedMultiset<E> descendingMultiset;

    static /* synthetic */ int lambda$toImmutableSortedMultiset$0(Object obj) {
        return 1;
    }

    public abstract ImmutableSortedSet<E> elementSet();

    public /* synthetic */ void forEach(Consumer<? super E> consumer) {
        Multiset.CC.$default$forEach(this, consumer);
    }

    @Beta
    public /* synthetic */ void forEachEntry(ObjIntConsumer<? super E> objIntConsumer) {
        Multiset.CC.$default$forEachEntry(this, objIntConsumer);
    }

    public abstract ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType);

    public abstract ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType);

    @Beta
    public static <E> Collector<E, ?, ImmutableSortedMultiset<E>> toImmutableSortedMultiset(Comparator<? super E> comparator) {
        return toImmutableSortedMultiset(comparator, Function.identity(), $$Lambda$ImmutableSortedMultiset$SLUqlvP2vUYpFEdZojvXQ6hxVIY.INSTANCE);
    }

    public static <T, E> Collector<T, ?, ImmutableSortedMultiset<E>> toImmutableSortedMultiset(Comparator<? super E> comparator, Function<? super T, ? extends E> function, ToIntFunction<? super T> toIntFunction) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(toIntFunction);
        return Collector.of(new Supplier(comparator) {
            /* class com.google.common.collect.$$Lambda$ImmutableSortedMultiset$k2J7QxvCzqBQvGMY4cDh9lR8cUA */
            private final /* synthetic */ Comparator f$0;

            {
                this.f$0 = r1;
            }

            public final Object get() {
                return TreeMultiset.create(this.f$0);
            }
        }, new BiConsumer(function, toIntFunction) {
            /* class com.google.common.collect.$$Lambda$ImmutableSortedMultiset$rlYIAG2L8JzJiwkHw0NZooNUX4 */
            private final /* synthetic */ Function f$0;
            private final /* synthetic */ ToIntFunction f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void accept(Object obj, Object obj2) {
                ((Multiset) obj).add(Preconditions.checkNotNull(this.f$0.apply(obj2)), this.f$1.applyAsInt(obj2));
            }
        }, $$Lambda$ImmutableSortedMultiset$iSZBRszHXFXNOPGHgGMuoWQwExE.INSTANCE, new Function(comparator) {
            /* class com.google.common.collect.$$Lambda$ImmutableSortedMultiset$I50ifYmXyfa7rE9Z1jwOjn82dE */
            private final /* synthetic */ Comparator f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj) {
                return ImmutableSortedMultiset.copyOfSortedEntries(this.f$0, ((Multiset) obj).entrySet());
            }
        }, new Collector.Characteristics[0]);
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of((Comparable) e), new long[]{0, 1}, 0, 1);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e, E e2) {
        return copyOf(Ordering.natural(), Arrays.asList(e, e2));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e, E e2, E e3) {
        return copyOf(Ordering.natural(), Arrays.asList(e, e2, e3));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e, E e2, E e3, E e4) {
        return copyOf(Ordering.natural(), Arrays.asList(e, e2, e3, e4));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e, E e2, E e3, E e4, E e5) {
        return copyOf(Ordering.natural(), Arrays.asList(e, e2, e3, e4, e5));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(eArr.length + 6);
        Collections.addAll(newArrayListWithCapacity, e, e2, e3, e4, e5, e6);
        Collections.addAll(newArrayListWithCapacity, eArr);
        return copyOf(Ordering.natural(), newArrayListWithCapacity);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> copyOf(E[] eArr) {
        return copyOf(Ordering.natural(), Arrays.asList(eArr));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        Preconditions.checkNotNull(comparator);
        return new Builder(comparator).addAll((Iterator) it).build();
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                return immutableSortedMultiset.isPartialView() ? copyOfSortedEntries(comparator, immutableSortedMultiset.entrySet().asList()) : immutableSortedMultiset;
            }
        }
        ArrayList<E> newArrayList = Lists.newArrayList(iterable);
        TreeMultiset create = TreeMultiset.create((Comparator) Preconditions.checkNotNull(comparator));
        Iterables.addAll(create, newArrayList);
        return copyOfSortedEntries(comparator, create.entrySet());
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(SortedMultiset<E> sortedMultiset) {
        return copyOfSortedEntries(sortedMultiset.comparator(), Lists.newArrayList(sortedMultiset.entrySet()));
    }

    /* access modifiers changed from: private */
    public static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> comparator, Collection<Multiset.Entry<E>> collection) {
        if (collection.isEmpty()) {
            return emptyMultiset(comparator);
        }
        ImmutableList.Builder builder = new ImmutableList.Builder(collection.size());
        long[] jArr = new long[(collection.size() + 1)];
        int i = 0;
        for (Multiset.Entry next : collection) {
            builder.add(next.getElement());
            int i2 = i + 1;
            jArr[i2] = jArr[i] + ((long) next.getCount());
            i = i2;
        }
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(builder.build(), comparator), jArr, 0, collection.size());
    }

    static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
        }
        return new RegularImmutableSortedMultiset(comparator);
    }

    ImmutableSortedMultiset() {
    }

    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultiset = this.descendingMultiset;
        if (immutableSortedMultiset == null) {
            immutableSortedMultiset = isEmpty() ? emptyMultiset(Ordering.from(comparator()).reverse()) : new DescendingImmutableSortedMultiset<>(this);
            this.descendingMultiset = immutableSortedMultiset;
        }
        return immutableSortedMultiset;
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final Multiset.Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final Multiset.Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedMultiset.headMultiset(java.lang.Object, com.google.common.collect.BoundType):com.google.common.collect.ImmutableSortedMultiset<E>
     arg types: [E, com.google.common.collect.BoundType]
     candidates:
      com.google.common.collect.ImmutableSortedMultiset.headMultiset(java.lang.Object, com.google.common.collect.BoundType):com.google.common.collect.SortedMultiset
      com.google.common.collect.SortedMultiset.headMultiset(java.lang.Object, com.google.common.collect.BoundType):com.google.common.collect.SortedMultiset<E>
      com.google.common.collect.ImmutableSortedMultiset.headMultiset(java.lang.Object, com.google.common.collect.BoundType):com.google.common.collect.ImmutableSortedMultiset<E> */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableSortedMultiset.tailMultiset(java.lang.Object, com.google.common.collect.BoundType):com.google.common.collect.ImmutableSortedMultiset<E>
     arg types: [E, com.google.common.collect.BoundType]
     candidates:
      com.google.common.collect.ImmutableSortedMultiset.tailMultiset(java.lang.Object, com.google.common.collect.BoundType):com.google.common.collect.SortedMultiset
      com.google.common.collect.SortedMultiset.tailMultiset(java.lang.Object, com.google.common.collect.BoundType):com.google.common.collect.SortedMultiset<E>
      com.google.common.collect.ImmutableSortedMultiset.tailMultiset(java.lang.Object, com.google.common.collect.BoundType):com.google.common.collect.ImmutableSortedMultiset<E> */
    public ImmutableSortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        Preconditions.checkArgument(comparator().compare(e, e2) <= 0, "Expected lowerBound <= upperBound but %s > %s", e, e2);
        return tailMultiset((Object) e, boundType).headMultiset((Object) e2, boundType2);
    }

    public static <E> Builder<E> orderedBy(Comparator<E> comparator) {
        return new Builder<>(comparator);
    }

    public static <E extends Comparable<?>> Builder<E> reverseOrder() {
        return new Builder<>(Ordering.natural().reverse());
    }

    public static <E extends Comparable<?>> Builder<E> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    public static class Builder<E> extends ImmutableMultiset.Builder<E> {
        public Builder(Comparator<? super E> comparator) {
            super(TreeMultiset.create((Comparator) Preconditions.checkNotNull(comparator)));
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E e) {
            super.add((Object) e);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            super.add((Object[]) eArr);
            return this;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.ImmutableMultiset.Builder.addCopies(java.lang.Object, int):com.google.common.collect.ImmutableMultiset$Builder<E>
         arg types: [E, int]
         candidates:
          com.google.common.collect.ImmutableSortedMultiset.Builder.addCopies(java.lang.Object, int):com.google.common.collect.ImmutableSortedMultiset$Builder<E>
          com.google.common.collect.ImmutableMultiset.Builder.addCopies(java.lang.Object, int):com.google.common.collect.ImmutableMultiset$Builder<E> */
        @CanIgnoreReturnValue
        public Builder<E> addCopies(E e, int i) {
            super.addCopies((Object) e, i);
            return this;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.ImmutableMultiset.Builder.setCount(java.lang.Object, int):com.google.common.collect.ImmutableMultiset$Builder<E>
         arg types: [E, int]
         candidates:
          com.google.common.collect.ImmutableSortedMultiset.Builder.setCount(java.lang.Object, int):com.google.common.collect.ImmutableSortedMultiset$Builder<E>
          com.google.common.collect.ImmutableMultiset.Builder.setCount(java.lang.Object, int):com.google.common.collect.ImmutableMultiset$Builder<E> */
        @CanIgnoreReturnValue
        public Builder<E> setCount(E e, int i) {
            super.setCount((Object) e, i);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            super.addAll((Iterable) iterable);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            super.addAll((Iterator) it);
            return this;
        }

        public ImmutableSortedMultiset<E> build() {
            return ImmutableSortedMultiset.copyOfSorted((SortedMultiset) this.contents);
        }
    }

    static final class SerializedForm<E> implements Serializable {
        final Comparator<? super E> comparator;
        final int[] counts;
        final E[] elements;

        SerializedForm(SortedMultiset<E> sortedMultiset) {
            this.comparator = sortedMultiset.comparator();
            int size = sortedMultiset.entrySet().size();
            this.elements = (Object[]) new Object[size];
            this.counts = new int[size];
            int i = 0;
            for (Multiset.Entry next : sortedMultiset.entrySet()) {
                this.elements[i] = next.getElement();
                this.counts[i] = next.getCount();
                i++;
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.ImmutableSortedMultiset.Builder.addCopies(java.lang.Object, int):com.google.common.collect.ImmutableSortedMultiset$Builder<E>
         arg types: [E, int]
         candidates:
          com.google.common.collect.ImmutableSortedMultiset.Builder.addCopies(java.lang.Object, int):com.google.common.collect.ImmutableMultiset$Builder
          com.google.common.collect.ImmutableMultiset.Builder.addCopies(java.lang.Object, int):com.google.common.collect.ImmutableMultiset$Builder<E>
          com.google.common.collect.ImmutableSortedMultiset.Builder.addCopies(java.lang.Object, int):com.google.common.collect.ImmutableSortedMultiset$Builder<E> */
        /* access modifiers changed from: package-private */
        public final Object readResolve() {
            int length = this.elements.length;
            Builder builder = new Builder(this.comparator);
            for (int i = 0; i < length; i++) {
                builder.addCopies((Object) this.elements[i], this.counts[i]);
            }
            return builder.build();
        }
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new SerializedForm(this);
    }
}
