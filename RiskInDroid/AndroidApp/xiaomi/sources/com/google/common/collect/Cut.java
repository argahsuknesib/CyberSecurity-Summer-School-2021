package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;

@GwtCompatible
abstract class Cut<C extends Comparable> implements Serializable, Comparable<Cut<C>> {
    private static final long serialVersionUID = 0;
    final C endpoint;

    /* access modifiers changed from: package-private */
    public Cut<C> canonical(DiscreteDomain<C> discreteDomain) {
        return this;
    }

    /* access modifiers changed from: package-private */
    public abstract void describeAsLowerBound(StringBuilder sb);

    /* access modifiers changed from: package-private */
    public abstract void describeAsUpperBound(StringBuilder sb);

    /* access modifiers changed from: package-private */
    public abstract C greatestValueBelow(DiscreteDomain<C> discreteDomain);

    public abstract int hashCode();

    /* access modifiers changed from: package-private */
    public abstract boolean isLessThan(C c);

    /* access modifiers changed from: package-private */
    public abstract C leastValueAbove(DiscreteDomain<C> discreteDomain);

    /* access modifiers changed from: package-private */
    public abstract BoundType typeAsLowerBound();

    /* access modifiers changed from: package-private */
    public abstract BoundType typeAsUpperBound();

    /* access modifiers changed from: package-private */
    public abstract Cut<C> withLowerBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain);

    /* access modifiers changed from: package-private */
    public abstract Cut<C> withUpperBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain);

    Cut(C c) {
        this.endpoint = c;
    }

    public int compareTo(Cut cut) {
        if (cut == belowAll()) {
            return 1;
        }
        if (cut == aboveAll()) {
            return -1;
        }
        int compareOrThrow = Range.compareOrThrow(this.endpoint, cut.endpoint);
        if (compareOrThrow != 0) {
            return compareOrThrow;
        }
        return Booleans.compare(this instanceof AboveValue, cut instanceof AboveValue);
    }

    /* access modifiers changed from: package-private */
    public C endpoint() {
        return this.endpoint;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cut) {
            try {
                if (compareTo((Cut) obj) == 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    static <C extends Comparable> Cut<C> belowAll() {
        return BelowAll.INSTANCE;
    }

    static final class BelowAll extends Cut<Comparable<?>> {
        public static final BelowAll INSTANCE = new BelowAll();
        private static final long serialVersionUID = 0;

        public final int compareTo(Cut<Comparable<?>> cut) {
            return cut == this ? 0 : -1;
        }

        /* access modifiers changed from: package-private */
        public final boolean isLessThan(Comparable<?> comparable) {
            return true;
        }

        public final String toString() {
            return "-∞";
        }

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((Cut<Comparable<?>>) ((Cut) obj));
        }

        private BelowAll() {
            super(null);
        }

        /* access modifiers changed from: package-private */
        public final Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        /* access modifiers changed from: package-private */
        public final BoundType typeAsLowerBound() {
            throw new IllegalStateException();
        }

        /* access modifiers changed from: package-private */
        public final BoundType typeAsUpperBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        /* access modifiers changed from: package-private */
        public final Cut<Comparable<?>> withLowerBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new IllegalStateException();
        }

        /* access modifiers changed from: package-private */
        public final Cut<Comparable<?>> withUpperBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError("this statement should be unreachable");
        }

        /* access modifiers changed from: package-private */
        public final void describeAsLowerBound(StringBuilder sb) {
            sb.append("(-∞");
        }

        /* access modifiers changed from: package-private */
        public final void describeAsUpperBound(StringBuilder sb) {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public final Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> discreteDomain) {
            return discreteDomain.minValue();
        }

        /* access modifiers changed from: package-private */
        public final Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public final Cut<Comparable<?>> canonical(DiscreteDomain<Comparable<?>> discreteDomain) {
            try {
                return Cut.belowValue(discreteDomain.minValue());
            } catch (NoSuchElementException unused) {
                return this;
            }
        }

        public final int hashCode() {
            return System.identityHashCode(this);
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    static <C extends Comparable> Cut<C> aboveAll() {
        return AboveAll.INSTANCE;
    }

    static final class AboveAll extends Cut<Comparable<?>> {
        public static final AboveAll INSTANCE = new AboveAll();
        private static final long serialVersionUID = 0;

        public final int compareTo(Cut<Comparable<?>> cut) {
            return cut == this ? 0 : 1;
        }

        /* access modifiers changed from: package-private */
        public final boolean isLessThan(Comparable<?> comparable) {
            return false;
        }

        public final String toString() {
            return "+∞";
        }

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return compareTo((Cut<Comparable<?>>) ((Cut) obj));
        }

        private AboveAll() {
            super(null);
        }

        /* access modifiers changed from: package-private */
        public final Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        /* access modifiers changed from: package-private */
        public final BoundType typeAsLowerBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        /* access modifiers changed from: package-private */
        public final BoundType typeAsUpperBound() {
            throw new IllegalStateException();
        }

        /* access modifiers changed from: package-private */
        public final Cut<Comparable<?>> withLowerBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError("this statement should be unreachable");
        }

        /* access modifiers changed from: package-private */
        public final Cut<Comparable<?>> withUpperBoundType(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new IllegalStateException();
        }

        /* access modifiers changed from: package-private */
        public final void describeAsLowerBound(StringBuilder sb) {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public final void describeAsUpperBound(StringBuilder sb) {
            sb.append("+∞)");
        }

        /* access modifiers changed from: package-private */
        public final Comparable<?> leastValueAbove(DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public final Comparable<?> greatestValueBelow(DiscreteDomain<Comparable<?>> discreteDomain) {
            return discreteDomain.maxValue();
        }

        public final int hashCode() {
            return System.identityHashCode(this);
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    static <C extends Comparable> Cut<C> belowValue(C c) {
        return new BelowValue(c);
    }

    static final class BelowValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return Cut.super.compareTo((Cut) obj);
        }

        BelowValue(C c) {
            super((Comparable) Preconditions.checkNotNull(c));
        }

        /* access modifiers changed from: package-private */
        public final boolean isLessThan(C c) {
            return Range.compareOrThrow(this.endpoint, c) <= 0;
        }

        /* access modifiers changed from: package-private */
        public final BoundType typeAsLowerBound() {
            return BoundType.CLOSED;
        }

        /* access modifiers changed from: package-private */
        public final BoundType typeAsUpperBound() {
            return BoundType.OPEN;
        }

        /* access modifiers changed from: package-private */
        public final Cut<C> withLowerBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i = AnonymousClass1.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()];
            if (i == 1) {
                return this;
            }
            if (i == 2) {
                C previous = discreteDomain.previous(this.endpoint);
                return previous == null ? Cut.belowAll() : new AboveValue(previous);
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public final Cut<C> withUpperBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i = AnonymousClass1.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()];
            if (i == 1) {
                C previous = discreteDomain.previous(this.endpoint);
                return previous == null ? Cut.aboveAll() : new AboveValue(previous);
            } else if (i == 2) {
                return this;
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        public final void describeAsLowerBound(StringBuilder sb) {
            sb.append('[');
            sb.append(this.endpoint);
        }

        /* access modifiers changed from: package-private */
        public final void describeAsUpperBound(StringBuilder sb) {
            sb.append(this.endpoint);
            sb.append(')');
        }

        /* access modifiers changed from: package-private */
        public final C leastValueAbove(DiscreteDomain<C> discreteDomain) {
            return this.endpoint;
        }

        /* access modifiers changed from: package-private */
        public final C greatestValueBelow(DiscreteDomain<C> discreteDomain) {
            return discreteDomain.previous(this.endpoint);
        }

        public final int hashCode() {
            return this.endpoint.hashCode();
        }

        public final String toString() {
            return "\\" + this.endpoint + "/";
        }
    }

    /* renamed from: com.google.common.collect.Cut$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BoundType = new int[BoundType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            $SwitchMap$com$google$common$collect$BoundType[BoundType.CLOSED.ordinal()] = 1;
            $SwitchMap$com$google$common$collect$BoundType[BoundType.OPEN.ordinal()] = 2;
        }
    }

    static <C extends Comparable> Cut<C> aboveValue(C c) {
        return new AboveValue(c);
    }

    static final class AboveValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return Cut.super.compareTo((Cut) obj);
        }

        AboveValue(C c) {
            super((Comparable) Preconditions.checkNotNull(c));
        }

        /* access modifiers changed from: package-private */
        public final boolean isLessThan(C c) {
            return Range.compareOrThrow(this.endpoint, c) < 0;
        }

        /* access modifiers changed from: package-private */
        public final BoundType typeAsLowerBound() {
            return BoundType.OPEN;
        }

        /* access modifiers changed from: package-private */
        public final BoundType typeAsUpperBound() {
            return BoundType.CLOSED;
        }

        /* access modifiers changed from: package-private */
        public final Cut<C> withLowerBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i = AnonymousClass1.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()];
            if (i == 1) {
                C next = discreteDomain.next(this.endpoint);
                return next == null ? Cut.belowAll() : belowValue(next);
            } else if (i == 2) {
                return this;
            } else {
                throw new AssertionError();
            }
        }

        /* access modifiers changed from: package-private */
        public final Cut<C> withUpperBoundType(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i = AnonymousClass1.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()];
            if (i == 1) {
                return this;
            }
            if (i == 2) {
                C next = discreteDomain.next(this.endpoint);
                return next == null ? Cut.aboveAll() : belowValue(next);
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        public final void describeAsLowerBound(StringBuilder sb) {
            sb.append('(');
            sb.append(this.endpoint);
        }

        /* access modifiers changed from: package-private */
        public final void describeAsUpperBound(StringBuilder sb) {
            sb.append(this.endpoint);
            sb.append(']');
        }

        /* access modifiers changed from: package-private */
        public final C leastValueAbove(DiscreteDomain<C> discreteDomain) {
            return discreteDomain.next(this.endpoint);
        }

        /* access modifiers changed from: package-private */
        public final C greatestValueBelow(DiscreteDomain<C> discreteDomain) {
            return this.endpoint;
        }

        /* access modifiers changed from: package-private */
        public final Cut<C> canonical(DiscreteDomain<C> discreteDomain) {
            C leastValueAbove = leastValueAbove(discreteDomain);
            return leastValueAbove != null ? belowValue(leastValueAbove) : Cut.aboveAll();
        }

        public final int hashCode() {
            return this.endpoint.hashCode() ^ -1;
        }

        public final String toString() {
            return "/" + this.endpoint + "\\";
        }
    }
}
