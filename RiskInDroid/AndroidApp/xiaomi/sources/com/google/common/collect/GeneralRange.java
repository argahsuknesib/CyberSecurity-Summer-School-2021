package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;

@GwtCompatible(serializable = true)
final class GeneralRange<T> implements Serializable {
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;
    private final T lowerEndpoint;
    private transient GeneralRange<T> reverse;
    private final BoundType upperBoundType;
    private final T upperEndpoint;

    static <T extends Comparable> GeneralRange<T> from(Range<T> range) {
        T t = null;
        T lowerEndpoint2 = range.hasLowerBound() ? range.lowerEndpoint() : null;
        BoundType lowerBoundType2 = range.hasLowerBound() ? range.lowerBoundType() : BoundType.OPEN;
        if (range.hasUpperBound()) {
            t = range.upperEndpoint();
        }
        return new GeneralRange(Ordering.natural(), range.hasLowerBound(), lowerEndpoint2, lowerBoundType2, range.hasUpperBound(), t, range.hasUpperBound() ? range.upperBoundType() : BoundType.OPEN);
    }

    static <T> GeneralRange<T> all(Comparator<? super T> comparator2) {
        return new GeneralRange(comparator2, false, null, BoundType.OPEN, false, null, BoundType.OPEN);
    }

    static <T> GeneralRange<T> downTo(Comparator<? super T> comparator2, T t, BoundType boundType) {
        return new GeneralRange(comparator2, true, t, boundType, false, null, BoundType.OPEN);
    }

    static <T> GeneralRange<T> upTo(Comparator<? super T> comparator2, T t, BoundType boundType) {
        return new GeneralRange(comparator2, false, null, BoundType.OPEN, true, t, boundType);
    }

    static <T> GeneralRange<T> range(Comparator<? super T> comparator2, T t, BoundType boundType, T t2, BoundType boundType2) {
        return new GeneralRange(comparator2, true, t, boundType, true, t2, boundType2);
    }

    private GeneralRange(Comparator<? super T> comparator2, boolean z, T t, BoundType boundType, boolean z2, T t2, BoundType boundType2) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator2);
        this.hasLowerBound = z;
        this.hasUpperBound = z2;
        this.lowerEndpoint = t;
        this.lowerBoundType = (BoundType) Preconditions.checkNotNull(boundType);
        this.upperEndpoint = t2;
        this.upperBoundType = (BoundType) Preconditions.checkNotNull(boundType2);
        if (z) {
            comparator2.compare(t, t);
        }
        if (z2) {
            comparator2.compare(t2, t2);
        }
        if (z && z2) {
            int compare = comparator2.compare(t, t2);
            boolean z3 = true;
            Preconditions.checkArgument(compare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", t, t2);
            if (compare == 0) {
                Preconditions.checkArgument((boundType != BoundType.OPEN) | (boundType2 == BoundType.OPEN ? false : z3));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Comparator<? super T> comparator() {
        return this.comparator;
    }

    /* access modifiers changed from: package-private */
    public final boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    /* access modifiers changed from: package-private */
    public final boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    /* access modifiers changed from: package-private */
    public final boolean isEmpty() {
        if (!hasUpperBound() || !tooLow(getUpperEndpoint())) {
            return hasLowerBound() && tooHigh(getLowerEndpoint());
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean tooLow(T t) {
        if (!hasLowerBound()) {
            return false;
        }
        int compare = this.comparator.compare(t, getLowerEndpoint());
        boolean z = true;
        boolean z2 = compare < 0;
        boolean z3 = compare == 0;
        if (getLowerBoundType() != BoundType.OPEN) {
            z = false;
        }
        return (z3 & z) | z2;
    }

    /* access modifiers changed from: package-private */
    public final boolean tooHigh(T t) {
        if (!hasUpperBound()) {
            return false;
        }
        int compare = this.comparator.compare(t, getUpperEndpoint());
        boolean z = true;
        boolean z2 = compare > 0;
        boolean z3 = compare == 0;
        if (getUpperBoundType() != BoundType.OPEN) {
            z = false;
        }
        return (z3 & z) | z2;
    }

    /* access modifiers changed from: package-private */
    public final boolean contains(T t) {
        return !tooLow(t) && !tooHigh(t);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007b, code lost:
        if (r11.getUpperBoundType() == com.google.common.collect.BoundType.OPEN) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003f, code lost:
        if (r11.getLowerBoundType() == com.google.common.collect.BoundType.OPEN) goto L_0x0041;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0089 A[ADDED_TO_REGION] */
    public final GeneralRange<T> intersect(GeneralRange<T> generalRange) {
        boolean z;
        BoundType boundType;
        BoundType boundType2;
        T t;
        int compare;
        Preconditions.checkNotNull(generalRange);
        Preconditions.checkArgument(this.comparator.equals(generalRange.comparator));
        boolean z2 = this.hasLowerBound;
        T lowerEndpoint2 = getLowerEndpoint();
        BoundType lowerBoundType2 = getLowerBoundType();
        if (!hasLowerBound()) {
            z2 = generalRange.hasLowerBound;
        } else {
            if (generalRange.hasLowerBound()) {
                int compare2 = this.comparator.compare(getLowerEndpoint(), generalRange.getLowerEndpoint());
                if (compare2 >= 0) {
                    if (compare2 == 0) {
                    }
                }
            }
            z = z2;
            boolean z3 = this.hasUpperBound;
            T upperEndpoint2 = getUpperEndpoint();
            BoundType upperBoundType2 = getUpperBoundType();
            if (hasUpperBound()) {
                z3 = generalRange.hasUpperBound;
            } else {
                if (generalRange.hasUpperBound()) {
                    int compare3 = this.comparator.compare(getUpperEndpoint(), generalRange.getUpperEndpoint());
                    if (compare3 <= 0) {
                        if (compare3 == 0) {
                        }
                    }
                }
                boolean z4 = z3;
                T t2 = upperEndpoint2;
                if (z || !z4 || ((compare = this.comparator.compare(lowerEndpoint2, t2)) <= 0 && !(compare == 0 && lowerBoundType2 == BoundType.OPEN && upperBoundType2 == BoundType.OPEN))) {
                    boundType2 = lowerBoundType2;
                    boundType = upperBoundType2;
                    t = lowerEndpoint2;
                } else {
                    boundType2 = BoundType.OPEN;
                    boundType = BoundType.CLOSED;
                    t = t2;
                }
                return new GeneralRange(this.comparator, z, t, boundType2, z4, t2, boundType);
            }
            upperEndpoint2 = generalRange.getUpperEndpoint();
            upperBoundType2 = generalRange.getUpperBoundType();
            boolean z42 = z3;
            T t22 = upperEndpoint2;
            if (z) {
            }
            boundType2 = lowerBoundType2;
            boundType = upperBoundType2;
            t = lowerEndpoint2;
            return new GeneralRange(this.comparator, z, t, boundType2, z42, t22, boundType);
        }
        lowerEndpoint2 = generalRange.getLowerEndpoint();
        lowerBoundType2 = generalRange.getLowerBoundType();
        z = z2;
        boolean z32 = this.hasUpperBound;
        T upperEndpoint22 = getUpperEndpoint();
        BoundType upperBoundType22 = getUpperBoundType();
        if (hasUpperBound()) {
        }
        upperEndpoint22 = generalRange.getUpperEndpoint();
        upperBoundType22 = generalRange.getUpperBoundType();
        boolean z422 = z32;
        T t222 = upperEndpoint22;
        if (z) {
        }
        boundType2 = lowerBoundType2;
        boundType = upperBoundType22;
        t = lowerEndpoint2;
        return new GeneralRange(this.comparator, z, t, boundType2, z422, t222, boundType);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof GeneralRange) {
            GeneralRange generalRange = (GeneralRange) obj;
            if (!this.comparator.equals(generalRange.comparator) || this.hasLowerBound != generalRange.hasLowerBound || this.hasUpperBound != generalRange.hasUpperBound || !getLowerBoundType().equals(generalRange.getLowerBoundType()) || !getUpperBoundType().equals(generalRange.getUpperBoundType()) || !Objects.equal(getLowerEndpoint(), generalRange.getLowerEndpoint()) || !Objects.equal(getUpperEndpoint(), generalRange.getUpperEndpoint())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType());
    }

    /* access modifiers changed from: package-private */
    public final GeneralRange<T> reverse() {
        GeneralRange<T> generalRange = this.reverse;
        if (generalRange != null) {
            return generalRange;
        }
        GeneralRange generalRange2 = new GeneralRange(Ordering.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
        generalRange2.reverse = this;
        this.reverse = generalRange2;
        return generalRange2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.comparator);
        sb.append(":");
        sb.append(this.lowerBoundType == BoundType.CLOSED ? '[' : '(');
        sb.append((Object) (this.hasLowerBound ? this.lowerEndpoint : "-∞"));
        sb.append(',');
        sb.append((Object) (this.hasUpperBound ? this.upperEndpoint : "∞"));
        sb.append(this.upperBoundType == BoundType.CLOSED ? ']' : ')');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final T getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    /* access modifiers changed from: package-private */
    public final BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }

    /* access modifiers changed from: package-private */
    public final T getUpperEndpoint() {
        return this.upperEndpoint;
    }

    /* access modifiers changed from: package-private */
    public final BoundType getUpperBoundType() {
        return this.upperBoundType;
    }
}
