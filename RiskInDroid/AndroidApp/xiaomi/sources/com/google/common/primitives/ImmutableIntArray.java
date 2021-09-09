package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.ImmutableIntArray;
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
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

@GwtCompatible
@Immutable
@Beta
public final class ImmutableIntArray implements Serializable {
    public static final ImmutableIntArray EMPTY = new ImmutableIntArray(new int[0]);
    public final int[] array;
    private final int end;
    public final transient int start;

    public static ImmutableIntArray of() {
        return EMPTY;
    }

    public static ImmutableIntArray of(int i) {
        return new ImmutableIntArray(new int[]{i});
    }

    public static ImmutableIntArray of(int i, int i2) {
        return new ImmutableIntArray(new int[]{i, i2});
    }

    public static ImmutableIntArray of(int i, int i2, int i3) {
        return new ImmutableIntArray(new int[]{i, i2, i3});
    }

    public static ImmutableIntArray of(int i, int i2, int i3, int i4) {
        return new ImmutableIntArray(new int[]{i, i2, i3, i4});
    }

    public static ImmutableIntArray of(int i, int i2, int i3, int i4, int i5) {
        return new ImmutableIntArray(new int[]{i, i2, i3, i4, i5});
    }

    public static ImmutableIntArray of(int i, int i2, int i3, int i4, int i5, int i6) {
        return new ImmutableIntArray(new int[]{i, i2, i3, i4, i5, i6});
    }

    public static ImmutableIntArray of(int i, int... iArr) {
        Preconditions.checkArgument(iArr.length <= 2147483646, "the total number of elements must fit in an int");
        int[] iArr2 = new int[(iArr.length + 1)];
        iArr2[0] = i;
        System.arraycopy(iArr, 0, iArr2, 1, iArr.length);
        return new ImmutableIntArray(iArr2);
    }

    public static ImmutableIntArray copyOf(int[] iArr) {
        return iArr.length == 0 ? EMPTY : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length));
    }

    public static ImmutableIntArray copyOf(Collection<Integer> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableIntArray(Ints.toArray(collection));
    }

    public static ImmutableIntArray copyOf(Iterable<Integer> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Integer>) ((Collection) iterable));
        }
        return builder().addAll(iterable).build();
    }

    public static ImmutableIntArray copyOf(IntStream intStream) {
        int[] array2 = intStream.toArray();
        return array2.length == 0 ? EMPTY : new ImmutableIntArray(array2);
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
        private int[] array;
        private int count = 0;

        Builder(int i) {
            this.array = new int[i];
        }

        public final Builder add(int i) {
            ensureRoomFor(1);
            int[] iArr = this.array;
            int i2 = this.count;
            iArr[i2] = i;
            this.count = i2 + 1;
            return this;
        }

        public final Builder addAll(int[] iArr) {
            ensureRoomFor(iArr.length);
            System.arraycopy(iArr, 0, this.array, this.count, iArr.length);
            this.count += iArr.length;
            return this;
        }

        public final Builder addAll(Iterable<Integer> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection<Integer>) ((Collection) iterable));
            }
            for (Integer intValue : iterable) {
                add(intValue.intValue());
            }
            return this;
        }

        public final Builder addAll(Collection<Integer> collection) {
            ensureRoomFor(collection.size());
            for (Integer intValue : collection) {
                int[] iArr = this.array;
                int i = this.count;
                this.count = i + 1;
                iArr[i] = intValue.intValue();
            }
            return this;
        }

        public final Builder addAll(IntStream intStream) {
            Spliterator.OfInt spliterator = intStream.spliterator();
            long exactSizeIfKnown = spliterator.getExactSizeIfKnown();
            if (exactSizeIfKnown > 0) {
                ensureRoomFor(Ints.saturatedCast(exactSizeIfKnown));
            }
            spliterator.forEachRemaining((IntConsumer) new IntConsumer() {
                /* class com.google.common.primitives.$$Lambda$WS9wTzcqMM_7dGjLt3km_ukixD8 */

                public final void accept(int i) {
                    ImmutableIntArray.Builder.this.add(i);
                }
            });
            return this;
        }

        public final Builder addAll(ImmutableIntArray immutableIntArray) {
            ensureRoomFor(immutableIntArray.length());
            System.arraycopy(immutableIntArray.array, immutableIntArray.start, this.array, this.count, immutableIntArray.length());
            this.count += immutableIntArray.length();
            return this;
        }

        private void ensureRoomFor(int i) {
            int i2 = this.count + i;
            int[] iArr = this.array;
            if (i2 > iArr.length) {
                int[] iArr2 = new int[expandedCapacity(iArr.length, i2)];
                System.arraycopy(this.array, 0, iArr2, 0, this.count);
                this.array = iArr2;
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
        public final ImmutableIntArray build() {
            int i = this.count;
            return i == 0 ? ImmutableIntArray.EMPTY : new ImmutableIntArray(this.array, 0, i);
        }
    }

    private ImmutableIntArray(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    private ImmutableIntArray(int[] iArr, int i, int i2) {
        this.array = iArr;
        this.start = i;
        this.end = i2;
    }

    public final int length() {
        return this.end - this.start;
    }

    public final boolean isEmpty() {
        return this.end == this.start;
    }

    public final int get(int i) {
        Preconditions.checkElementIndex(i, length());
        return this.array[this.start + i];
    }

    public final int indexOf(int i) {
        for (int i2 = this.start; i2 < this.end; i2++) {
            if (this.array[i2] == i) {
                return i2 - this.start;
            }
        }
        return -1;
    }

    public final int lastIndexOf(int i) {
        int i2 = this.end;
        while (true) {
            i2--;
            int i3 = this.start;
            if (i2 < i3) {
                return -1;
            }
            if (this.array[i2] == i) {
                return i2 - i3;
            }
        }
    }

    public final boolean contains(int i) {
        return indexOf(i) >= 0;
    }

    public final void forEach(IntConsumer intConsumer) {
        Preconditions.checkNotNull(intConsumer);
        for (int i = this.start; i < this.end; i++) {
            intConsumer.accept(this.array[i]);
        }
    }

    public final IntStream stream() {
        return Arrays.stream(this.array, this.start, this.end);
    }

    public final int[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    public final ImmutableIntArray subArray(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, length());
        if (i == i2) {
            return EMPTY;
        }
        int[] iArr = this.array;
        int i3 = this.start;
        return new ImmutableIntArray(iArr, i + i3, i3 + i2);
    }

    public final Spliterator.OfInt spliterator() {
        return Spliterators.spliterator(this.array, this.start, this.end, 1040);
    }

    public final List<Integer> asList() {
        return new AsList();
    }

    static class AsList extends AbstractList<Integer> implements Serializable, RandomAccess {
        private final ImmutableIntArray parent;

        private AsList(ImmutableIntArray immutableIntArray) {
            this.parent = immutableIntArray;
        }

        public int size() {
            return this.parent.length();
        }

        public Integer get(int i) {
            return Integer.valueOf(this.parent.get(i));
        }

        public boolean contains(Object obj) {
            return indexOf(obj) >= 0;
        }

        public int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.parent.indexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        public int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return this.parent.lastIndexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        public List<Integer> subList(int i, int i2) {
            return this.parent.subArray(i, i2).asList();
        }

        public Spliterator<Integer> spliterator() {
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
                if (next instanceof Integer) {
                    int i2 = i + 1;
                    if (this.parent.array[i] == ((Integer) next).intValue()) {
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
        if (!(obj instanceof ImmutableIntArray)) {
            return false;
        }
        ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
        if (length() != immutableIntArray.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (get(i) != immutableIntArray.get(i)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 31) + Ints.hashCode(this.array[i2]);
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

    public final ImmutableIntArray trimmed() {
        return isPartialView() ? new ImmutableIntArray(toArray()) : this;
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
