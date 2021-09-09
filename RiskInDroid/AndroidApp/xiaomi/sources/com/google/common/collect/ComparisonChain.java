package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import java.util.Comparator;

@GwtCompatible
public abstract class ComparisonChain {
    public static final ComparisonChain ACTIVE = new ComparisonChain() {
        /* class com.google.common.collect.ComparisonChain.AnonymousClass1 */

        public final int result() {
            return 0;
        }

        public final ComparisonChain compare(Comparable comparable, Comparable comparable2) {
            return classify(comparable.compareTo(comparable2));
        }

        public final <T> ComparisonChain compare(T t, T t2, Comparator<T> comparator) {
            return classify(comparator.compare(t, t2));
        }

        public final ComparisonChain compare(int i, int i2) {
            return classify(Ints.compare(i, i2));
        }

        public final ComparisonChain compare(long j, long j2) {
            return classify(Longs.compare(j, j2));
        }

        public final ComparisonChain compare(float f, float f2) {
            return classify(Float.compare(f, f2));
        }

        public final ComparisonChain compare(double d, double d2) {
            return classify(Double.compare(d, d2));
        }

        public final ComparisonChain compareTrueFirst(boolean z, boolean z2) {
            return classify(Booleans.compare(z2, z));
        }

        public final ComparisonChain compareFalseFirst(boolean z, boolean z2) {
            return classify(Booleans.compare(z, z2));
        }

        /* access modifiers changed from: package-private */
        public final ComparisonChain classify(int i) {
            if (i < 0) {
                return ComparisonChain.LESS;
            }
            return i > 0 ? ComparisonChain.GREATER : ComparisonChain.ACTIVE;
        }
    };
    public static final ComparisonChain GREATER = new InactiveComparisonChain(1);
    public static final ComparisonChain LESS = new InactiveComparisonChain(-1);

    public abstract ComparisonChain compare(double d, double d2);

    public abstract ComparisonChain compare(float f, float f2);

    public abstract ComparisonChain compare(int i, int i2);

    public abstract ComparisonChain compare(long j, long j2);

    public abstract ComparisonChain compare(Comparable<?> comparable, Comparable<?> comparable2);

    public abstract <T> ComparisonChain compare(T t, T t2, Comparator<T> comparator);

    public abstract ComparisonChain compareFalseFirst(boolean z, boolean z2);

    public abstract ComparisonChain compareTrueFirst(boolean z, boolean z2);

    public abstract int result();

    private ComparisonChain() {
    }

    public static ComparisonChain start() {
        return ACTIVE;
    }

    static final class InactiveComparisonChain extends ComparisonChain {
        final int result;

        public final ComparisonChain compare(double d, double d2) {
            return this;
        }

        public final ComparisonChain compare(float f, float f2) {
            return this;
        }

        public final ComparisonChain compare(int i, int i2) {
            return this;
        }

        public final ComparisonChain compare(long j, long j2) {
            return this;
        }

        public final ComparisonChain compare(Comparable comparable, Comparable comparable2) {
            return this;
        }

        public final <T> ComparisonChain compare(T t, T t2, Comparator<T> comparator) {
            return this;
        }

        public final ComparisonChain compareFalseFirst(boolean z, boolean z2) {
            return this;
        }

        public final ComparisonChain compareTrueFirst(boolean z, boolean z2) {
            return this;
        }

        InactiveComparisonChain(int i) {
            super();
            this.result = i;
        }

        public final int result() {
            return this.result;
        }
    }

    @Deprecated
    public final ComparisonChain compare(Boolean bool, Boolean bool2) {
        return compareFalseFirst(bool.booleanValue(), bool2.booleanValue());
    }
}
