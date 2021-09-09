package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

@GwtCompatible(emulated = true)
public final class Iterables {
    private Iterables() {
    }

    public static <T> Iterable<T> unmodifiableIterable(Iterable<? extends T> iterable) {
        Preconditions.checkNotNull(iterable);
        return ((iterable instanceof UnmodifiableIterable) || (iterable instanceof ImmutableCollection)) ? iterable : new UnmodifiableIterable(iterable);
    }

    @Deprecated
    public static <E> Iterable<E> unmodifiableIterable(ImmutableCollection<E> immutableCollection) {
        return (Iterable) Preconditions.checkNotNull(immutableCollection);
    }

    static final class UnmodifiableIterable<T> extends FluentIterable<T> {
        private final Iterable<? extends T> iterable;

        private UnmodifiableIterable(Iterable<? extends T> iterable2) {
            this.iterable = iterable2;
        }

        public final Iterator<T> iterator() {
            return Iterators.unmodifiableIterator(this.iterable.iterator());
        }

        public final void forEach(Consumer<? super T> consumer) {
            this.iterable.forEach(consumer);
        }

        public final Spliterator<T> spliterator() {
            return this.iterable.spliterator();
        }

        public final String toString() {
            return this.iterable.toString();
        }
    }

    public static int size(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return Iterators.size(iterable.iterator());
    }

    public static boolean contains(Iterable<?> iterable, Object obj) {
        if (iterable instanceof Collection) {
            return Collections2.safeContains((Collection) iterable, obj);
        }
        return Iterators.contains(iterable.iterator(), obj);
    }

    @CanIgnoreReturnValue
    public static boolean removeAll(Iterable<?> iterable, Collection<?> collection) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).removeAll((Collection) Preconditions.checkNotNull(collection));
        }
        return Iterators.removeAll(iterable.iterator(), collection);
    }

    @CanIgnoreReturnValue
    public static boolean retainAll(Iterable<?> iterable, Collection<?> collection) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).retainAll((Collection) Preconditions.checkNotNull(collection));
        }
        return Iterators.retainAll(iterable.iterator(), collection);
    }

    @CanIgnoreReturnValue
    public static <T> boolean removeIf(Iterable<T> iterable, Predicate<? super T> predicate) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).removeIf(predicate);
        }
        return Iterators.removeIf(iterable.iterator(), predicate);
    }

    static <T> T removeFirstMatching(Iterable<T> iterable, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    public static boolean elementsEqual(Iterable<?> iterable, Iterable<?> iterable2) {
        if (!(iterable instanceof Collection) || !(iterable2 instanceof Collection) || ((Collection) iterable).size() == ((Collection) iterable2).size()) {
            return Iterators.elementsEqual(iterable.iterator(), iterable2.iterator());
        }
        return false;
    }

    public static String toString(Iterable<?> iterable) {
        return Iterators.toString(iterable.iterator());
    }

    public static <T> T getOnlyElement(Iterable<T> iterable) {
        return Iterators.getOnlyElement(iterable.iterator());
    }

    public static <T> T getOnlyElement(Iterable<? extends T> iterable, T t) {
        return Iterators.getOnlyElement(iterable.iterator(), t);
    }

    @GwtIncompatible
    public static <T> T[] toArray(Iterable iterable, Class cls) {
        return toArray(iterable, ObjectArrays.newArray(cls, 0));
    }

    static <T> T[] toArray(Iterable iterable, Object[] objArr) {
        return castOrCopyToCollection(iterable).toArray(objArr);
    }

    static Object[] toArray(Iterable<?> iterable) {
        return castOrCopyToCollection(iterable).toArray();
    }

    private static <E> Collection<E> castOrCopyToCollection(Iterable<E> iterable) {
        if (iterable instanceof Collection) {
            return (Collection) iterable;
        }
        return Lists.newArrayList(iterable.iterator());
    }

    @CanIgnoreReturnValue
    public static <T> boolean addAll(Collection<T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll(Collections2.cast(iterable));
        }
        return Iterators.addAll(collection, ((Iterable) Preconditions.checkNotNull(iterable)).iterator());
    }

    public static int frequency(Iterable<?> iterable, Object obj) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).count(obj);
        }
        if (iterable instanceof Set) {
            return ((Set) iterable).contains(obj) ? 1 : 0;
        }
        return Iterators.frequency(iterable.iterator(), obj);
    }

    public static <T> Iterable<T> cycle(final Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        return new FluentIterable<T>() {
            /* class com.google.common.collect.Iterables.AnonymousClass1 */

            static /* synthetic */ Iterable lambda$spliterator$0(Iterable iterable) {
                return iterable;
            }

            public final Iterator<T> iterator() {
                return Iterators.cycle(iterable);
            }

            public final Spliterator<T> spliterator() {
                return Stream.generate(new Supplier(iterable) {
                    /* class com.google.common.collect.$$Lambda$Iterables$1$cnx_iJv_8hTsXmkH4zUejiNKVlg */
                    private final /* synthetic */ Iterable f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final Object get() {
                        return Iterables.AnonymousClass1.lambda$spliterator$0(this.f$0);
                    }
                }).flatMap($$Lambda$J3JCy2OxEIdbwSUl7gccsAF4s8o.INSTANCE).spliterator();
            }

            public final String toString() {
                return iterable.toString() + " (cycled)";
            }
        };
    }

    @SafeVarargs
    public static <T> Iterable<T> cycle(Object... objArr) {
        return cycle(Lists.newArrayList(objArr));
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return FluentIterable.concat(iterable, iterable2);
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return FluentIterable.concat(iterable, iterable2, iterable3);
    }

    public static <T> Iterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return FluentIterable.concat(iterable, iterable2, iterable3, iterable4);
    }

    @SafeVarargs
    public static <T> Iterable<T> concat(Iterable<? extends T>... iterableArr) {
        return FluentIterable.concat(iterableArr);
    }

    public static <T> Iterable<T> concat(Iterable<? extends Iterable<? extends T>> iterable) {
        return FluentIterable.concat(iterable);
    }

    public static <T> Iterable<List<T>> partition(final Iterable<T> iterable, final int i) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(i > 0);
        return new FluentIterable<List<T>>() {
            /* class com.google.common.collect.Iterables.AnonymousClass2 */

            public final Iterator<List<T>> iterator() {
                return Iterators.partition(iterable.iterator(), i);
            }
        };
    }

    public static <T> Iterable<List<T>> paddedPartition(final Iterable<T> iterable, final int i) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(i > 0);
        return new FluentIterable<List<T>>() {
            /* class com.google.common.collect.Iterables.AnonymousClass3 */

            public final Iterator<List<T>> iterator() {
                return Iterators.paddedPartition(iterable.iterator(), i);
            }
        };
    }

    public static <T> Iterable<T> filter(final Iterable iterable, final Predicate predicate) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(predicate);
        return new FluentIterable<T>() {
            /* class com.google.common.collect.Iterables.AnonymousClass4 */

            public final Iterator<T> iterator() {
                return Iterators.filter(iterable.iterator(), predicate);
            }

            public final void forEach(Consumer<? super T> consumer) {
                Preconditions.checkNotNull(consumer);
                iterable.forEach(new Consumer(consumer) {
                    /* class com.google.common.collect.$$Lambda$Iterables$4$VpO1YP7t_U0V7DaI5u55sdej8A8 */
                    private final /* synthetic */ Consumer f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void accept(Object obj) {
                        Iterables.AnonymousClass4.lambda$forEach$0(Predicate.this, this.f$1, obj);
                    }
                });
            }

            static /* synthetic */ void lambda$forEach$0(Predicate predicate, Consumer consumer, Object obj) {
                if (predicate.test(obj)) {
                    consumer.accept(obj);
                }
            }

            public final Spliterator<T> spliterator() {
                return CollectSpliterators.filter(iterable.spliterator(), predicate);
            }
        };
    }

    @GwtIncompatible
    public static <T> Iterable<T> filter(Iterable<?> iterable, Class cls) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(cls);
        return filter(iterable, Predicates.instanceOf(cls));
    }

    public static <T> boolean any(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.any(iterable.iterator(), predicate);
    }

    public static <T> boolean all(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.all(iterable.iterator(), predicate);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.find(iterable.iterator(), predicate);
    }

    public static <T> T find(Iterable<? extends T> iterable, Predicate<? super T> predicate, T t) {
        return Iterators.find(iterable.iterator(), predicate, t);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.common.base.Predicate, com.google.common.base.Predicate<? super T>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static <T> Optional<T> tryFind(Iterable<T> iterable, Predicate<? super T> r1) {
        return Iterators.tryFind(iterable.iterator(), r1);
    }

    public static <T> int indexOf(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.indexOf(iterable.iterator(), predicate);
    }

    public static <F, T> Iterable<T> transform(final Iterable<F> iterable, final Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(function);
        return new FluentIterable<T>() {
            /* class com.google.common.collect.Iterables.AnonymousClass5 */

            public final Iterator<T> iterator() {
                return Iterators.transform(iterable.iterator(), function);
            }

            public final void forEach(Consumer<? super T> consumer) {
                Preconditions.checkNotNull(consumer);
                iterable.forEach(new Consumer(consumer, function) {
                    /* class com.google.common.collect.$$Lambda$Iterables$5$F27v40icavd1kuXO6hvOVXqQs */
                    private final /* synthetic */ Consumer f$0;
                    private final /* synthetic */ Function f$1;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                    }

                    public final void accept(Object obj) {
                        this.f$0.accept(this.f$1.apply(obj));
                    }
                });
            }

            public final Spliterator<T> spliterator() {
                return CollectSpliterators.map(iterable.spliterator(), function);
            }
        };
    }

    public static <T> T get(Iterable<T> iterable, int i) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof List) {
            return ((List) iterable).get(i);
        }
        return Iterators.get(iterable.iterator(), i);
    }

    public static <T> T get(Iterable<? extends T> iterable, int i, T t) {
        Preconditions.checkNotNull(iterable);
        Iterators.checkNonnegative(i);
        if (iterable instanceof List) {
            List<? extends T> cast = Lists.cast(iterable);
            return i < cast.size() ? cast.get(i) : t;
        }
        Iterator<? extends T> it = iterable.iterator();
        Iterators.advance(it, i);
        return Iterators.getNext(it, t);
    }

    public static <T> T getFirst(Iterable<? extends T> iterable, T t) {
        return Iterators.getNext(iterable.iterator(), t);
    }

    public static <T> T getLast(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return Iterators.getLast(iterable.iterator());
        }
        List list = (List) iterable;
        if (!list.isEmpty()) {
            return getLastInNonemptyList(list);
        }
        throw new NoSuchElementException();
    }

    public static <T> T getLast(Iterable<? extends T> iterable, T t) {
        if (iterable instanceof Collection) {
            if (Collections2.cast(iterable).isEmpty()) {
                return t;
            }
            if (iterable instanceof List) {
                return getLastInNonemptyList(Lists.cast(iterable));
            }
        }
        return Iterators.getLast(iterable.iterator(), t);
    }

    private static <T> T getLastInNonemptyList(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> Iterable<T> skip(final Iterable<T> iterable, final int i) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(i >= 0, "number to skip cannot be negative");
        return new FluentIterable<T>() {
            /* class com.google.common.collect.Iterables.AnonymousClass6 */

            public final Iterator<T> iterator() {
                Iterable iterable = iterable;
                if (iterable instanceof List) {
                    List list = (List) iterable;
                    return list.subList(Math.min(list.size(), i), list.size()).iterator();
                }
                final Iterator it = iterable.iterator();
                Iterators.advance(it, i);
                return new Iterator<T>() {
                    /* class com.google.common.collect.Iterables.AnonymousClass6.AnonymousClass1 */
                    boolean atStart = true;

                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    public T next() {
                        T next = it.next();
                        this.atStart = false;
                        return next;
                    }

                    public void remove() {
                        CollectPreconditions.checkRemove(!this.atStart);
                        it.remove();
                    }
                };
            }

            public final Spliterator<T> spliterator() {
                Iterable iterable = iterable;
                if (!(iterable instanceof List)) {
                    return Streams.stream(iterable).skip((long) i).spliterator();
                }
                List list = (List) iterable;
                return list.subList(Math.min(list.size(), i), list.size()).spliterator();
            }
        };
    }

    public static <T> Iterable<T> limit(final Iterable<T> iterable, final int i) {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkArgument(i >= 0, "limit is negative");
        return new FluentIterable<T>() {
            /* class com.google.common.collect.Iterables.AnonymousClass7 */

            public final Iterator<T> iterator() {
                return Iterators.limit(iterable.iterator(), i);
            }

            public final Spliterator<T> spliterator() {
                return Streams.stream(iterable).limit((long) i).spliterator();
            }
        };
    }

    public static <T> Iterable<T> consumingIterable(final Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new FluentIterable<T>() {
            /* class com.google.common.collect.Iterables.AnonymousClass8 */

            public final String toString() {
                return "Iterables.consumingIterable(...)";
            }

            public final Iterator<T> iterator() {
                Iterable iterable = iterable;
                if (iterable instanceof Queue) {
                    return new ConsumingQueueIterator((Queue) iterable);
                }
                return Iterators.consumingIterator(iterable.iterator());
            }
        };
    }

    public static boolean isEmpty(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    @Beta
    public static <T> Iterable<T> mergeSorted(final Iterable<? extends Iterable<? extends T>> iterable, final Comparator<? super T> comparator) {
        Preconditions.checkNotNull(iterable, "iterables");
        Preconditions.checkNotNull(comparator, "comparator");
        return new UnmodifiableIterable(new FluentIterable<T>() {
            /* class com.google.common.collect.Iterables.AnonymousClass9 */

            public final Iterator<T> iterator() {
                return Iterators.mergeSorted(Iterables.transform(iterable, Iterables.toIterator()), comparator);
            }
        });
    }

    static <T> Function<Iterable<? extends T>, Iterator<? extends T>> toIterator() {
        return new Function<Iterable<? extends T>, Iterator<? extends T>>() {
            /* class com.google.common.collect.Iterables.AnonymousClass10 */

            public final Iterator<? extends T> apply(Iterable<? extends T> iterable) {
                return iterable.iterator();
            }
        };
    }
}
