package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.stream.Stream;

@GwtCompatible(emulated = true)
public abstract class FluentIterable<E> implements Iterable<E> {
    private final Optional<Iterable<E>> iterableDelegate;

    protected FluentIterable() {
        this.iterableDelegate = Optional.absent();
    }

    FluentIterable(Iterable<E> iterable) {
        Preconditions.checkNotNull(iterable);
        this.iterableDelegate = Optional.fromNullable(this == iterable ? null : iterable);
    }

    private Iterable<E> getDelegate() {
        return this.iterableDelegate.or(this);
    }

    public static <E> FluentIterable<E> from(final Iterable iterable) {
        return iterable instanceof FluentIterable ? (FluentIterable) iterable : new FluentIterable<E>(iterable) {
            /* class com.google.common.collect.FluentIterable.AnonymousClass1 */

            public final Iterator<E> iterator() {
                return iterable.iterator();
            }
        };
    }

    @Beta
    public static <E> FluentIterable<E> from(Object[] objArr) {
        return from(Arrays.asList(objArr));
    }

    @Deprecated
    public static <E> FluentIterable<E> from(FluentIterable fluentIterable) {
        return (FluentIterable) Preconditions.checkNotNull(fluentIterable);
    }

    @Beta
    public static <T> FluentIterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return concatNoDefensiveCopy(iterable, iterable2);
    }

    @Beta
    public static <T> FluentIterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return concatNoDefensiveCopy(iterable, iterable2, iterable3);
    }

    @Beta
    public static <T> FluentIterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return concatNoDefensiveCopy(iterable, iterable2, iterable3, iterable4);
    }

    @Beta
    public static <T> FluentIterable<T> concat(Iterable<? extends T>... iterableArr) {
        return concatNoDefensiveCopy((Iterable[]) Arrays.copyOf(iterableArr, iterableArr.length));
    }

    @Beta
    public static <T> FluentIterable<T> concat(final Iterable<? extends Iterable<? extends T>> iterable) {
        Preconditions.checkNotNull(iterable);
        return new FluentIterable<T>() {
            /* class com.google.common.collect.FluentIterable.AnonymousClass2 */

            public final Iterator<T> iterator() {
                return Iterators.concat(Iterators.transform(iterable.iterator(), Iterables.toIterator()));
            }
        };
    }

    private static <T> FluentIterable<T> concatNoDefensiveCopy(final Iterable<? extends T>... iterableArr) {
        for (Iterable<? extends T> checkNotNull : iterableArr) {
            Preconditions.checkNotNull(checkNotNull);
        }
        return new FluentIterable<T>() {
            /* class com.google.common.collect.FluentIterable.AnonymousClass3 */

            public final Iterator<T> iterator() {
                return Iterators.concat(new AbstractIndexedListIterator<Iterator<? extends T>>(iterableArr.length) {
                    /* class com.google.common.collect.FluentIterable.AnonymousClass3.AnonymousClass1 */

                    public Iterator<? extends T> get(int i) {
                        return iterableArr[i].iterator();
                    }
                });
            }
        };
    }

    @Beta
    public static <E> FluentIterable<E> of() {
        return from(ImmutableList.of());
    }

    @Beta
    public static <E> FluentIterable<E> of(E e, E... eArr) {
        return from(Lists.asList(e, eArr));
    }

    public String toString() {
        return Iterables.toString(getDelegate());
    }

    public final int size() {
        return Iterables.size(getDelegate());
    }

    public final boolean contains(Object obj) {
        return Iterables.contains(getDelegate(), obj);
    }

    public final FluentIterable<E> cycle() {
        return from(Iterables.cycle(getDelegate()));
    }

    @Beta
    public final FluentIterable<E> append(Iterable<? extends E> iterable) {
        return concat(getDelegate(), iterable);
    }

    @Beta
    public final FluentIterable<E> append(E... eArr) {
        return concat(getDelegate(), Arrays.asList(eArr));
    }

    public final FluentIterable<E> filter(Predicate predicate) {
        return from(Iterables.filter(getDelegate(), predicate));
    }

    @GwtIncompatible
    public final <T> FluentIterable<T> filter(Class cls) {
        return from(Iterables.filter(getDelegate(), cls));
    }

    public final boolean anyMatch(Predicate<? super E> predicate) {
        return Iterables.any(getDelegate(), predicate);
    }

    public final boolean allMatch(Predicate<? super E> predicate) {
        return Iterables.all(getDelegate(), predicate);
    }

    public final Optional<E> firstMatch(Predicate<? super E> predicate) {
        return Iterables.tryFind(getDelegate(), predicate);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.common.base.Function<? super E, T>, com.google.common.base.Function] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final <T> FluentIterable<T> transform(Function<? super E, T> r2) {
        return from(Iterables.transform(getDelegate(), r2));
    }

    public <T> FluentIterable<T> transformAndConcat(Function<? super E, ? extends Iterable<? extends T>> function) {
        return concat(transform(function));
    }

    public final Optional<E> first() {
        Iterator it = getDelegate().iterator();
        return it.hasNext() ? Optional.of(it.next()) : Optional.absent();
    }

    public final Optional<E> last() {
        Object next;
        Iterable delegate = getDelegate();
        if (delegate instanceof List) {
            List list = (List) delegate;
            if (list.isEmpty()) {
                return Optional.absent();
            }
            return Optional.of(list.get(list.size() - 1));
        }
        Iterator it = delegate.iterator();
        if (!it.hasNext()) {
            return Optional.absent();
        }
        if (delegate instanceof SortedSet) {
            return Optional.of(((SortedSet) delegate).last());
        }
        do {
            next = it.next();
        } while (it.hasNext());
        return Optional.of(next);
    }

    public final FluentIterable<E> skip(int i) {
        return from(Iterables.skip(getDelegate(), i));
    }

    public final FluentIterable<E> limit(int i) {
        return from(Iterables.limit(getDelegate(), i));
    }

    public final boolean isEmpty() {
        return !getDelegate().iterator().hasNext();
    }

    public final ImmutableList<E> toList() {
        return ImmutableList.copyOf(getDelegate());
    }

    public final ImmutableList<E> toSortedList(Comparator<? super E> comparator) {
        return Ordering.from(comparator).immutableSortedCopy(getDelegate());
    }

    public final ImmutableSet<E> toSet() {
        return ImmutableSet.copyOf(getDelegate());
    }

    public final ImmutableSortedSet<E> toSortedSet(Comparator<? super E> comparator) {
        return ImmutableSortedSet.copyOf(comparator, getDelegate());
    }

    public final ImmutableMultiset<E> toMultiset() {
        return ImmutableMultiset.copyOf(getDelegate());
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.common.base.Function, com.google.common.base.Function<? super E, V>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final <V> ImmutableMap<E, V> toMap(Function<? super E, V> r2) {
        return Maps.toMap(getDelegate(), (Function) r2);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.common.base.Function, com.google.common.base.Function<? super E, K>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final <K> ImmutableListMultimap<K, E> index(Function<? super E, K> r2) {
        return Multimaps.index(getDelegate(), (Function) r2);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.common.base.Function, com.google.common.base.Function<? super E, K>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final <K> ImmutableMap<K, E> uniqueIndex(Function<? super E, K> r2) {
        return Maps.uniqueIndex(getDelegate(), (Function) r2);
    }

    @GwtIncompatible
    public final E[] toArray(Class<E> cls) {
        return Iterables.toArray(getDelegate(), cls);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: C
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
    public final <C extends java.util.Collection<? super E>> C copyInto(C r3) {
        /*
            r2 = this;
            com.google.common.base.Preconditions.checkNotNull(r3)
            java.lang.Iterable r0 = r2.getDelegate()
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L_0x0013
            java.util.Collection r0 = com.google.common.collect.Collections2.cast(r0)
            r3.addAll(r0)
            goto L_0x0025
        L_0x0013:
            java.util.Iterator r0 = r0.iterator()
        L_0x0017:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0025
            java.lang.Object r1 = r0.next()
            r3.add(r1)
            goto L_0x0017
        L_0x0025:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.FluentIterable.copyInto(java.util.Collection):java.util.Collection");
    }

    @Beta
    public final String join(Joiner joiner) {
        return joiner.join(this);
    }

    public final E get(int i) {
        return Iterables.get(getDelegate(), i);
    }

    public final Stream<E> stream() {
        return Streams.stream(getDelegate());
    }

    static class FromIterableFunction<E> implements Function<Iterable<E>, FluentIterable<E>> {
        private FromIterableFunction() {
        }

        public FluentIterable<E> apply(Iterable<E> iterable) {
            return FluentIterable.from(iterable);
        }
    }
}
