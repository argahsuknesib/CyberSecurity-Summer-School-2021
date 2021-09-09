package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.ImmutableDoubleArray;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;

@GwtCompatible
@Immutable
@Beta
public final class ImmutableDoubleArray implements Serializable {
    public static final ImmutableDoubleArray EMPTY = new ImmutableDoubleArray(new double[0]);
    public final double[] array;
    private final int end;
    public final transient int start;

    public static ImmutableDoubleArray of() {
        return EMPTY;
    }

    public static ImmutableDoubleArray of(double d) {
        return new ImmutableDoubleArray(new double[]{d});
    }

    public static ImmutableDoubleArray of(double d, double d2) {
        return new ImmutableDoubleArray(new double[]{d, d2});
    }

    public static ImmutableDoubleArray of(double d, double d2, double d3) {
        return new ImmutableDoubleArray(new double[]{d, d2, d3});
    }

    public static ImmutableDoubleArray of(double d, double d2, double d3, double d4) {
        return new ImmutableDoubleArray(new double[]{d, d2, d3, d4});
    }

    public static ImmutableDoubleArray of(double d, double d2, double d3, double d4, double d5) {
        return new ImmutableDoubleArray(new double[]{d, d2, d3, d4, d5});
    }

    public static ImmutableDoubleArray of(double d, double d2, double d3, double d4, double d5, double d6) {
        return new ImmutableDoubleArray(new double[]{d, d2, d3, d4, d5, d6});
    }

    public static ImmutableDoubleArray of(double d, double... dArr) {
        Preconditions.checkArgument(dArr.length <= 2147483646, "the total number of elements must fit in an int");
        double[] dArr2 = new double[(dArr.length + 1)];
        dArr2[0] = d;
        System.arraycopy(dArr, 0, dArr2, 1, dArr.length);
        return new ImmutableDoubleArray(dArr2);
    }

    public static ImmutableDoubleArray copyOf(double[] dArr) {
        if (dArr.length == 0) {
            return EMPTY;
        }
        return new ImmutableDoubleArray(Arrays.copyOf(dArr, dArr.length));
    }

    public static ImmutableDoubleArray copyOf(Collection<Double> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableDoubleArray(Doubles.toArray(collection));
    }

    public static ImmutableDoubleArray copyOf(Iterable<Double> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Double>) ((Collection) iterable));
        }
        return builder().addAll(iterable).build();
    }

    public static ImmutableDoubleArray copyOf(DoubleStream doubleStream) {
        double[] array2 = doubleStream.toArray();
        return array2.length == 0 ? EMPTY : new ImmutableDoubleArray(array2);
    }

    public static Builder builder(int i) {
        Preconditions.checkArgument(i >= 0, "Invalid initialCapacity: %s", i);
        return new Builder(i);
    }

    public static Builder builder() {
        return new Builder(10);
    }

    @CanIgnoreReturnValue
    public static final class Builder {
        private double[] array;
        private int count = 0;

        Builder(int i) {
            this.array = new double[i];
        }

        public final Builder add(double d) {
            ensureRoomFor(1);
            double[] dArr = this.array;
            int i = this.count;
            dArr[i] = d;
            this.count = i + 1;
            return this;
        }

        public final Builder addAll(double[] dArr) {
            ensureRoomFor(dArr.length);
            System.arraycopy(dArr, 0, this.array, this.count, dArr.length);
            this.count += dArr.length;
            return this;
        }

        public final Builder addAll(Iterable<Double> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection<Double>) ((Collection) iterable));
            }
            for (Double doubleValue : iterable) {
                add(doubleValue.doubleValue());
            }
            return this;
        }

        public final Builder addAll(Collection<Double> collection) {
            ensureRoomFor(collection.size());
            for (Double doubleValue : collection) {
                double[] dArr = this.array;
                int i = this.count;
                this.count = i + 1;
                dArr[i] = doubleValue.doubleValue();
            }
            return this;
        }

        public final Builder addAll(DoubleStream doubleStream) {
            Spliterator.OfDouble spliterator = doubleStream.spliterator();
            long exactSizeIfKnown = spliterator.getExactSizeIfKnown();
            if (exactSizeIfKnown > 0) {
                ensureRoomFor(Ints.saturatedCast(exactSizeIfKnown));
            }
            spliterator.forEachRemaining((DoubleConsumer) new DoubleConsumer() {
                /* class com.google.common.primitives.$$Lambda$54TIlpnh0zD74vLfBDjk02xN2w */

                public final void accept(double d) {
                    ImmutableDoubleArray.Builder.this.add(d);
                }
            });
            return this;
        }

        public final Builder addAll(ImmutableDoubleArray immutableDoubleArray) {
            ensureRoomFor(immutableDoubleArray.length());
            System.arraycopy(immutableDoubleArray.array, immutableDoubleArray.start, this.array, this.count, immutableDoubleArray.length());
            this.count += immutableDoubleArray.length();
            return this;
        }

        private void ensureRoomFor(int i) {
            int i2 = this.count + i;
            double[] dArr = this.array;
            if (i2 > dArr.length) {
                double[] dArr2 = new double[expandedCapacity(dArr.length, i2)];
                System.arraycopy(this.array, 0, dArr2, 0, this.count);
                this.array = dArr2;
            }
        }

        private static int expandedCapacity(int i, int i2) {
            if (i2 >= 0) {
                int i3 = i + (i >> 1) + 1;
                if (i3 < i2) {
                    i3 = Integer.highestOneBit(i2 - 1) << 1;
                }
                if (i3 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i3;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        @CheckReturnValue
        public final ImmutableDoubleArray build() {
            int i = this.count;
            return i == 0 ? ImmutableDoubleArray.EMPTY : new ImmutableDoubleArray(this.array, 0, i);
        }
    }

    private ImmutableDoubleArray(double[] dArr) {
        this(dArr, 0, dArr.length);
    }

    private ImmutableDoubleArray(double[] dArr, int i, int i2) {
        this.array = dArr;
        this.start = i;
        this.end = i2;
    }

    public final int length() {
        return this.end - this.start;
    }

    public final boolean isEmpty() {
        return this.end == this.start;
    }

    public final double get(int i) {
        Preconditions.checkElementIndex(i, length());
        return this.array[this.start + i];
    }

    public final int indexOf(double d) {
        for (int i = this.start; i < this.end; i++) {
            if (areEqual(this.array[i], d)) {
                return i - this.start;
            }
        }
        return -1;
    }

    public final int lastIndexOf(double d) {
        int i = this.end;
        while (true) {
            i--;
            if (i < this.start) {
                return -1;
            }
            if (areEqual(this.array[i], d)) {
                return i - this.start;
            }
        }
    }

    public final boolean contains(double d) {
        return indexOf(d) >= 0;
    }

    public final void forEach(DoubleConsumer doubleConsumer) {
        Preconditions.checkNotNull(doubleConsumer);
        for (int i = this.start; i < this.end; i++) {
            doubleConsumer.accept(this.array[i]);
        }
    }

    public final DoubleStream stream() {
        return Arrays.stream(this.array, this.start, this.end);
    }

    public final double[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    public final ImmutableDoubleArray subArray(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, length());
        if (i == i2) {
            return EMPTY;
        }
        double[] dArr = this.array;
        int i3 = this.start;
        return new ImmutableDoubleArray(dArr, i + i3, i3 + i2);
    }

    public final Spliterator.OfDouble spliterator() {
        return Spliterators.spliterator(this.array, this.start, this.end, 1040);
    }

    public final List<Double> asList() {
        return new AsList();
    }

    static class AsList extends AbstractList<Double> implements Serializable, RandomAccess {
        private final ImmutableDoubleArray parent;

        private AsList(ImmutableDoubleArray immutableDoubleArray) {
            this.parent = immutableDoubleArray;
        }

        public int size() {
            return this.parent.length();
        }

        public Double get(int i) {
            return Double.valueOf(this.parent.get(i));
        }

        public boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        public int indexOf(Object obj) {
            if (obj instanceof Double) {
                return this.parent.indexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        public int lastIndexOf(Object obj) {
            if (obj instanceof Double) {
                return this.parent.lastIndexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        public List<Double> subList(int i, int i2) {
            return this.parent.subArray(i, i2).asList();
        }

        public Spliterator<Double> spliterator() {
            return this.parent.spliterator();
        }

        public boolean equals(Object obj) {
            if (obj instanceof AsList) {
                return this.parent.equals(((AsList) obj).parent);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i = this.parent.start;
            for (Object next : list) {
                if (next instanceof Double) {
                    int i2 = i + 1;
                    if (ImmutableDoubleArray.areEqual(this.parent.array[i], ((Double) next).doubleValue())) {
                        i = i2;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.parent.hashCode();
        }

        public String toString() {
            return this.parent.toString();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableDoubleArray)) {
            return false;
        }
        ImmutableDoubleArray immutableDoubleArray = (ImmutableDoubleArray) obj;
        if (length() != immutableDoubleArray.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (!areEqual(get(i), immutableDoubleArray.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean areEqual(double d, double d2) {
        return Double.doubleToLongBits(d) == Double.doubleToLongBits(d2);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 31) + Doubles.hashCode(this.array[i2]);
        }
        return i;
    }

    public final String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder(length() * 5);
        sb.append('[');
        sb.append(this.array[this.start]);
        int i = this.start;
        while (true) {
            i++;
            if (i < this.end) {
                sb.append(", ");
                sb.append(this.array[i]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }

    public final ImmutableDoubleArray trimmed() {
        return isPartialView() ? new ImmutableDoubleArray(toArray()) : this;
    }

    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    /* access modifiers changed from: package-private */
    public final Object writeReplace() {
        return trimmed();
    }

    /* access modifiers changed from: package-private */
    public final Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }
}
