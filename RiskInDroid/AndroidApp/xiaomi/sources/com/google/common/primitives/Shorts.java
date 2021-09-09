package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible(emulated = true)
public final class Shorts {
    public static int compare(short s, short s2) {
        return s - s2;
    }

    @GwtIncompatible
    public static short fromBytes(byte b, byte b2) {
        return (short) ((b << 8) | (b2 & 255));
    }

    public static int hashCode(short s) {
        return s;
    }

    public static short saturatedCast(long j) {
        if (j > 32767) {
            return Short.MAX_VALUE;
        }
        if (j < -32768) {
            return Short.MIN_VALUE;
        }
        return (short) ((int) j);
    }

    private Shorts() {
    }

    public static short checkedCast(long j) {
        short s = (short) ((int) j);
        Preconditions.checkArgument(((long) s) == j, "Out of range: %s", j);
        return s;
    }

    public static boolean contains(short[] sArr, short s) {
        for (short s2 : sArr) {
            if (s2 == s) {
                return true;
            }
        }
        return false;
    }

    public static int indexOf(short[] sArr, short s) {
        return indexOf(sArr, s, 0, sArr.length);
    }

    public static int indexOf(short[] sArr, short s, int i, int i2) {
        while (i < i2) {
            if (sArr[i] == s) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int indexOf(short[] sArr, short[] sArr2) {
        Preconditions.checkNotNull(sArr, "array");
        Preconditions.checkNotNull(sArr2, "target");
        if (sArr2.length == 0) {
            return 0;
        }
        int i = 0;
        while (i < (sArr.length - sArr2.length) + 1) {
            int i2 = 0;
            while (i2 < sArr2.length) {
                if (sArr[i + i2] == sArr2[i2]) {
                    i2++;
                } else {
                    i++;
                }
            }
            return i;
        }
        return -1;
    }

    public static int lastIndexOf(short[] sArr, short s) {
        return lastIndexOf(sArr, s, 0, sArr.length);
    }

    public static int lastIndexOf(short[] sArr, short s, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            if (sArr[i3] == s) {
                return i3;
            }
        }
        return -1;
    }

    public static short min(short... sArr) {
        Preconditions.checkArgument(sArr.length > 0);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            if (sArr[i] < s) {
                s = sArr[i];
            }
        }
        return s;
    }

    public static short max(short... sArr) {
        Preconditions.checkArgument(sArr.length > 0);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            if (sArr[i] > s) {
                s = sArr[i];
            }
        }
        return s;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, int, int):void
     arg types: [boolean, java.lang.String, short, short]
     candidates:
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, char, char):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, char, int):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, char, long):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, char, java.lang.Object):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, int, char):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, int, long):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, int, java.lang.Object):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, long, char):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, long, int):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, long, long):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, long, java.lang.Object):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, java.lang.Object, char):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, java.lang.Object, int):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, java.lang.Object, long):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, java.lang.Object, java.lang.Object):void
      com.google.common.base.Preconditions.checkArgument(boolean, java.lang.String, int, int):void */
    @Beta
    public static short constrainToRange(short s, short s2, short s3) {
        Preconditions.checkArgument(s2 <= s3, "min (%s) must be less than or equal to max (%s)", (int) s2, (int) s3);
        if (s < s2) {
            return s2;
        }
        return s < s3 ? s : s3;
    }

    public static short[] concat(short[]... sArr) {
        int i = 0;
        for (short[] length : sArr) {
            i += length.length;
        }
        short[] sArr2 = new short[i];
        int i2 = 0;
        for (short[] sArr3 : sArr) {
            System.arraycopy(sArr3, 0, sArr2, i2, sArr3.length);
            i2 += sArr3.length;
        }
        return sArr2;
    }

    @GwtIncompatible
    public static byte[] toByteArray(short s) {
        return new byte[]{(byte) (s >> 8), (byte) s};
    }

    @GwtIncompatible
    public static short fromByteArray(byte[] bArr) {
        Preconditions.checkArgument(bArr.length >= 2, "array too small: %s < %s", bArr.length, 2);
        return fromBytes(bArr[0], bArr[1]);
    }

    static final class ShortConverter extends Converter<String, Short> implements Serializable {
        static final ShortConverter INSTANCE = new ShortConverter();
        private static final long serialVersionUID = 1;

        public final String toString() {
            return "Shorts.stringConverter()";
        }

        private ShortConverter() {
        }

        /* access modifiers changed from: protected */
        public final Short doForward(String str) {
            return Short.decode(str);
        }

        /* access modifiers changed from: protected */
        public final String doBackward(Short sh) {
            return sh.toString();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    @Beta
    public static Converter<String, Short> stringConverter() {
        return ShortConverter.INSTANCE;
    }

    public static short[] ensureCapacity(short[] sArr, int i, int i2) {
        boolean z = true;
        Preconditions.checkArgument(i >= 0, "Invalid minLength: %s", i);
        if (i2 < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid padding: %s", i2);
        return sArr.length < i ? Arrays.copyOf(sArr, i + i2) : sArr;
    }

    public static String join(String str, short... sArr) {
        Preconditions.checkNotNull(str);
        if (sArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(sArr.length * 6);
        sb.append((int) sArr[0]);
        for (int i = 1; i < sArr.length; i++) {
            sb.append(str);
            sb.append((int) sArr[i]);
        }
        return sb.toString();
    }

    public static Comparator<short[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    enum LexicographicalComparator implements Comparator<short[]> {
        INSTANCE;

        public final String toString() {
            return "Shorts.lexicographicalComparator()";
        }

        public final int compare(short[] sArr, short[] sArr2) {
            int min = Math.min(sArr.length, sArr2.length);
            for (int i = 0; i < min; i++) {
                int compare = Shorts.compare(sArr[i], sArr2[i]);
                if (compare != 0) {
                    return compare;
                }
            }
            return sArr.length - sArr2.length;
        }
    }

    public static void sortDescending(short[] sArr) {
        Preconditions.checkNotNull(sArr);
        sortDescending(sArr, 0, sArr.length);
    }

    public static void sortDescending(short[] sArr, int i, int i2) {
        Preconditions.checkNotNull(sArr);
        Preconditions.checkPositionIndexes(i, i2, sArr.length);
        Arrays.sort(sArr, i, i2);
        reverse(sArr, i, i2);
    }

    public static void reverse(short[] sArr) {
        Preconditions.checkNotNull(sArr);
        reverse(sArr, 0, sArr.length);
    }

    public static void reverse(short[] sArr, int i, int i2) {
        Preconditions.checkNotNull(sArr);
        Preconditions.checkPositionIndexes(i, i2, sArr.length);
        for (int i3 = i2 - 1; i < i3; i3--) {
            short s = sArr[i];
            sArr[i] = sArr[i3];
            sArr[i3] = s;
            i++;
        }
    }

    public static short[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof ShortArrayAsList) {
            return ((ShortArrayAsList) collection).toShortArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        short[] sArr = new short[length];
        for (int i = 0; i < length; i++) {
            sArr[i] = ((Number) Preconditions.checkNotNull(array[i])).shortValue();
        }
        return sArr;
    }

    public static List<Short> asList(short... sArr) {
        if (sArr.length == 0) {
            return Collections.emptyList();
        }
        return new ShortArrayAsList(sArr);
    }

    @GwtCompatible
    static class ShortArrayAsList extends AbstractList<Short> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final short[] array;
        final int end;
        final int start;

        public boolean isEmpty() {
            return false;
        }

        ShortArrayAsList(short[] sArr) {
            this(sArr, 0, sArr.length);
        }

        ShortArrayAsList(short[] sArr, int i, int i2) {
            this.array = sArr;
            this.start = i;
            this.end = i2;
        }

        public int size() {
            return this.end - this.start;
        }

        public Short get(int i) {
            Preconditions.checkElementIndex(i, size());
            return Short.valueOf(this.array[this.start + i]);
        }

        public boolean contains(Object obj) {
            return (obj instanceof Short) && Shorts.indexOf(this.array, ((Short) obj).shortValue(), this.start, this.end) != -1;
        }

        public int indexOf(Object obj) {
            int indexOf;
            if (!(obj instanceof Short) || (indexOf = Shorts.indexOf(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return indexOf - this.start;
        }

        public int lastIndexOf(Object obj) {
            int lastIndexOf;
            if (!(obj instanceof Short) || (lastIndexOf = Shorts.lastIndexOf(this.array, ((Short) obj).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return lastIndexOf - this.start;
        }

        public Short set(int i, Short sh) {
            Preconditions.checkElementIndex(i, size());
            short[] sArr = this.array;
            int i2 = this.start;
            short s = sArr[i2 + i];
            sArr[i2 + i] = ((Short) Preconditions.checkNotNull(sh)).shortValue();
            return Short.valueOf(s);
        }

        public List<Short> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            if (i == i2) {
                return Collections.emptyList();
            }
            short[] sArr = this.array;
            int i3 = this.start;
            return new ShortArrayAsList(sArr, i + i3, i3 + i2);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ShortArrayAsList)) {
                return super.equals(obj);
            }
            ShortArrayAsList shortArrayAsList = (ShortArrayAsList) obj;
            int size = size();
            if (shortArrayAsList.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (this.array[this.start + i] != shortArrayAsList.array[shortArrayAsList.start + i]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 1;
            for (int i2 = this.start; i2 < this.end; i2++) {
                i = (i * 31) + Shorts.hashCode(this.array[i2]);
            }
            return i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 6);
            sb.append('[');
            sb.append((int) this.array[this.start]);
            int i = this.start;
            while (true) {
                i++;
                if (i < this.end) {
                    sb.append(", ");
                    sb.append((int) this.array[i]);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public short[] toShortArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }
    }
}
