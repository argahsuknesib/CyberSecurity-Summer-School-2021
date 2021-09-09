package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

@GwtCompatible
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements Predicate<C>, Serializable {
    private static final Range<Comparable> ALL = new Range<>(Cut.belowAll(), Cut.aboveAll());
    private static final long serialVersionUID = 0;
    final Cut<C> lowerBound;
    final Cut<C> upperBound;

    public /* synthetic */ boolean test(T t) {
        return Predicate.CC.$default$test(this, t);
    }

    static class LowerBoundFn implements Function<Range, Cut> {
        static final LowerBoundFn INSTANCE = new LowerBoundFn();

        LowerBoundFn() {
        }

        public Cut apply(Range range) {
            return range.lowerBound;
        }
    }

    static class UpperBoundFn implements Function<Range, Cut> {
        static final UpperBoundFn INSTANCE = new UpperBoundFn();

        UpperBoundFn() {
        }

        public Cut apply(Range range) {
            return range.upperBound;
        }
    }

    static <C extends Comparable<?>> Function<Range<C>, Cut<C>> lowerBoundFn() {
        return LowerBoundFn.INSTANCE;
    }

    static <C extends Comparable<?>> Function<Range<C>, Cut<C>> upperBoundFn() {
        return UpperBoundFn.INSTANCE;
    }

    static <C extends Comparable<?>> Ordering<Range<C>> rangeLexOrdering() {
        return RangeLexOrdering.INSTANCE;
    }

    static <C extends Comparable<?>> Range<C> create(Cut<C> cut, Cut<C> cut2) {
        return new Range<>(cut, cut2);
    }

    public static <C extends Comparable<?>> Range<C> open(C c, C c2) {
        return create(Cut.aboveValue(c), Cut.belowValue(c2));
    }

    public static <C extends Comparable<?>> Range<C> closed(C c, C c2) {
        return create(Cut.belowValue(c), Cut.aboveValue(c2));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C c, C c2) {
        return create(Cut.belowValue(c), Cut.belowValue(c2));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C c, C c2) {
        return create(Cut.aboveValue(c), Cut.aboveValue(c2));
    }

    public static <C extends Comparable<?>> Range<C> range(C c, BoundType boundType, C c2, BoundType boundType2) {
        Preconditions.checkNotNull(boundType);
        Preconditions.checkNotNull(boundType2);
        return create(boundType == BoundType.OPEN ? Cut.aboveValue(c) : Cut.belowValue(c), boundType2 == BoundType.OPEN ? Cut.belowValue(c2) : Cut.aboveValue(c2));
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C c) {
        return create(Cut.belowAll(), Cut.belowValue(c));
    }

    public static <C extends Comparable<?>> Range<C> atMost(C c) {
        return create(Cut.belowAll(), Cut.aboveValue(c));
    }

    /* renamed from: com.google.common.collect.Range$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BoundType = new int[BoundType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            $SwitchMap$com$google$common$collect$BoundType[BoundType.OPEN.ordinal()] = 1;
            $SwitchMap$com$google$common$collect$BoundType[BoundType.CLOSED.ordinal()] = 2;
        }
    }

    public static <C extends Comparable<?>> Range<C> upTo(C c, BoundType boundType) {
        int i = AnonymousClass1.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()];
        if (i == 1) {
            return lessThan(c);
        }
        if (i == 2) {
            return atMost(c);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C c) {
        return create(Cut.aboveValue(c), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C c) {
        return create(Cut.belowValue(c), Cut.aboveAll());
    }

    public static <C extends Comparable<?>> Range<C> downTo(C c, BoundType boundType) {
        int i = AnonymousClass1.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()];
        if (i == 1) {
            return greaterThan(c);
        }
        if (i == 2) {
            return atLeast(c);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return ALL;
    }

    public static <C extends Comparable<?>> Range<C> singleton(C c) {
        return closed(c, c);
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof SortedSet) {
            SortedSet<C> cast = cast(iterable);
            Comparator<? super C> comparator = cast.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return closed((Comparable) cast.first(), (Comparable) cast.last());
            }
        }
        Iterator<C> it = iterable.iterator();
        Comparable comparable = (Comparable) Preconditions.checkNotNull(it.next());
        Comparable comparable2 = comparable;
        while (it.hasNext()) {
            Comparable comparable3 = (Comparable) Preconditions.checkNotNull(it.next());
            comparable = (Comparable) Ordering.natural().min(comparable, comparable3);
            comparable2 = (Comparable) Ordering.natural().max(comparable2, comparable3);
        }
        return closed(comparable, comparable2);
    }

    private Range(Cut<C> cut, Cut<C> cut2) {
        this.lowerBound = (Cut) Preconditions.checkNotNull(cut);
        this.upperBound = (Cut) Preconditions.checkNotNull(cut2);
        if (cut.compareTo((Cut) cut2) > 0 || cut == Cut.aboveAll() || cut2 == Cut.belowAll()) {
            throw new IllegalArgumentException("Invalid range: " + toString(cut, cut2));
        }
    }

    public final boolean hasLowerBound() {
        return this.lowerBound != Cut.belowAll();
    }

    public final C lowerEndpoint() {
        return this.lowerBound.endpoint();
    }

    public final BoundType lowerBoundType() {
        return this.lowerBound.typeAsLowerBound();
    }

    public final boolean hasUpperBound() {
        return this.upperBound != Cut.aboveAll();
    }

    public final C upperEndpoint() {
        return this.upperBound.endpoint();
    }

    public final BoundType upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }

    public final boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public final boolean contains(C c) {
        Preconditions.checkNotNull(c);
        return this.lowerBound.isLessThan(c) && !this.upperBound.isLessThan(c);
    }

    @Deprecated
    public final boolean apply(C c) {
        return contains(c);
    }

    public final boolean containsAll(Iterable<? extends C> iterable) {
        if (Iterables.isEmpty(iterable)) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            SortedSet<? extends C> cast = cast(iterable);
            Comparator<? super Object> comparator = cast.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                if (!contains((Comparable) cast.first()) || !contains((Comparable) cast.last())) {
                    return false;
                }
                return true;
            }
        }
        Iterator<? extends C> it = iterable.iterator();
        while (it.hasNext()) {
            if (!contains((Comparable) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean encloses(Range<C> range) {
        return this.lowerBound.compareTo(range.lowerBound) <= 0 && this.upperBound.compareTo(range.upperBound) >= 0;
    }

    public final boolean isConnected(Range<C> range) {
        return this.lowerBound.compareTo(range.upperBound) <= 0 && range.lowerBound.compareTo(this.upperBound) <= 0;
    }

    public final Range<C> intersection(Range<C> range) {
        int compareTo = this.lowerBound.compareTo((Cut) range.lowerBound);
        int compareTo2 = this.upperBound.compareTo((Cut) range.upperBound);
        if (compareTo >= 0 && compareTo2 <= 0) {
            return this;
        }
        if (compareTo <= 0 && compareTo2 >= 0) {
            return range;
        }
        return create(compareTo >= 0 ? this.lowerBound : range.lowerBound, compareTo2 <= 0 ? this.upperBound : range.upperBound);
    }

    /* JADX WARN: Failed to insert an additional move for type inference into block B:7:0x0012 */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.google.common.collect.Range} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.google.common.collect.Range} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=com.google.common.collect.Range<C>, code=com.google.common.collect.Range, for r3v0, types: [com.google.common.collect.Range, com.google.common.collect.Range<C>] */
    /* JADX WARNING: Multi-variable type inference failed */
    public final Range<C> gap(Range range) {
        boolean z = this.lowerBound.compareTo(range.lowerBound) < 0;
        Range range2 = z ? this : range;
        if (!z) {
            range = this;
        }
        return create(range2.upperBound, range.lowerBound);
    }

    public final Range<C> span(Range<C> range) {
        int compareTo = this.lowerBound.compareTo((Cut) range.lowerBound);
        int compareTo2 = this.upperBound.compareTo((Cut) range.upperBound);
        if (compareTo <= 0 && compareTo2 >= 0) {
            return this;
        }
        if (compareTo >= 0 && compareTo2 <= 0) {
            return range;
        }
        return create(compareTo <= 0 ? this.lowerBound : range.lowerBound, compareTo2 >= 0 ? this.upperBound : range.upperBound);
    }

    public final Range<C> canonical(DiscreteDomain<C> discreteDomain) {
        Preconditions.checkNotNull(discreteDomain);
        Cut<C> canonical = this.lowerBound.canonical(discreteDomain);
        Cut<C> canonical2 = this.upperBound.canonical(discreteDomain);
        return (canonical == this.lowerBound && canonical2 == this.upperBound) ? this : create(canonical, canonical2);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Range) {
            Range range = (Range) obj;
            if (!this.lowerBound.equals(range.lowerBound) || !this.upperBound.equals(range.upperBound)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public final String toString() {
        return toString(this.lowerBound, this.upperBound);
    }

    private static String toString(Cut<?> cut, Cut<?> cut2) {
        StringBuilder sb = new StringBuilder(16);
        cut.describeAsLowerBound(sb);
        sb.append("..");
        cut2.describeAsUpperBound(sb);
        return sb.toString();
    }

    private static <T> SortedSet<T> cast(Iterable<T> iterable) {
        return (SortedSet) iterable;
    }

    /* access modifiers changed from: package-private */
    public final Object readResolve() {
        return equals(ALL) ? all() : this;
    }

    static int compareOrThrow(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {
        static final Ordering<Range<?>> INSTANCE = new RangeLexOrdering();
        private static final long serialVersionUID = 0;

        private RangeLexOrdering() {
        }

        public /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return compare((Range<?>) ((Range) obj), (Range<?>) ((Range) obj2));
        }

        public int compare(Range<?> range, Range<?> range2) {
            return ComparisonChain.start().compare(range.lowerBound, range2.lowerBound).compare(range.upperBound, range2.upperBound).result();
        }
    }
}
