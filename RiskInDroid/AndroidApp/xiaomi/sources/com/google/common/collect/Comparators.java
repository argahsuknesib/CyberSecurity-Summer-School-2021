package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collector;

@GwtCompatible
@Beta
public final class Comparators {
    private Comparators() {
    }

    public static <T, S extends T> Comparator<Iterable<S>> lexicographical(Comparator<T> comparator) {
        return new LexicographicalOrdering((Comparator) Preconditions.checkNotNull(comparator));
    }

    public static <T> boolean isInOrder(Iterable<? extends T> iterable, Comparator<T> comparator) {
        Preconditions.checkNotNull(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        Object next = it.next();
        while (it.hasNext()) {
            Object next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public static <T> boolean isInStrictOrder(Iterable<? extends T> iterable, Comparator<T> comparator) {
        Preconditions.checkNotNull(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        Object next = it.next();
        while (it.hasNext()) {
            Object next2 = it.next();
            if (comparator.compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public static <T> Collector<T, ?, List<T>> least(int i, Comparator<? super T> comparator) {
        CollectPreconditions.checkNonnegative(i, "k");
        Preconditions.checkNotNull(comparator);
        return Collector.of(new Supplier(i, comparator) {
            /* class com.google.common.collect.$$Lambda$Comparators$_DWKGNHcVQUcyfzpO4ynmD4as */
            private final /* synthetic */ int f$0;
            private final /* synthetic */ Comparator f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final Object get() {
                return TopKSelector.least(this.f$0, this.f$1);
            }
        }, $$Lambda$gdvJ8zzvQatRh6knqtwfSxKqxQ.INSTANCE, $$Lambda$Iilf_x3Yim75FBgBCib4qGxg29c.INSTANCE, $$Lambda$VPCwCVNyDcTS8_paG2FrPedynw.INSTANCE, Collector.Characteristics.UNORDERED);
    }

    public static <T> Collector<T, ?, List<T>> greatest(int i, Comparator<? super T> comparator) {
        return least(i, comparator.reversed());
    }

    @Beta
    public static <T> Comparator<Optional<T>> emptiesFirst(Comparator<? super T> comparator) {
        Preconditions.checkNotNull(comparator);
        return Comparator.comparing($$Lambda$Comparators$UiCeAsF2a9gO9y8sRhfhsM498w.INSTANCE, Comparator.nullsFirst(comparator));
    }

    @Beta
    public static <T> Comparator<Optional<T>> emptiesLast(Comparator<? super T> comparator) {
        Preconditions.checkNotNull(comparator);
        return Comparator.comparing($$Lambda$Comparators$5rbgZYIdOv59hWI8fiqZx2chh4.INSTANCE, Comparator.nullsLast(comparator));
    }
}
