package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@GwtIncompatible
@Beta
public final class Quantiles {
    public static double interpolate(double d, double d2, double d3, double d4) {
        if (d == Double.NEGATIVE_INFINITY) {
            return d2 == Double.POSITIVE_INFINITY ? Double.NaN : Double.NEGATIVE_INFINITY;
        }
        if (d2 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return d + (((d2 - d) * d3) / d4);
    }

    public static ScaleAndIndex median() {
        return scale(2).index(1);
    }

    public static Scale quartiles() {
        return scale(4);
    }

    public static Scale percentiles() {
        return scale(100);
    }

    public static Scale scale(int i) {
        return new Scale(i);
    }

    public static final class Scale {
        private final int scale;

        private Scale(int i) {
            Preconditions.checkArgument(i > 0, "Quantile scale must be positive");
            this.scale = i;
        }

        public final ScaleAndIndex index(int i) {
            return new ScaleAndIndex(this.scale, i);
        }

        public final ScaleAndIndexes indexes(int... iArr) {
            return new ScaleAndIndexes(this.scale, (int[]) iArr.clone());
        }

        public final ScaleAndIndexes indexes(Collection<Integer> collection) {
            return new ScaleAndIndexes(this.scale, Ints.toArray(collection));
        }
    }

    public static final class ScaleAndIndex {
        private final int index;
        private final int scale;

        private ScaleAndIndex(int i, int i2) {
            Quantiles.checkIndex(i2, i);
            this.scale = i;
            this.index = i2;
        }

        public final double compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public final double compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public final double compute(long... jArr) {
            return computeInPlace(Quantiles.longsToDoubles(jArr));
        }

        public final double compute(int... iArr) {
            return computeInPlace(Quantiles.intsToDoubles(iArr));
        }

        public final double computeInPlace(double... dArr) {
            Preconditions.checkArgument(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.containsNaN(dArr)) {
                return Double.NaN;
            }
            long length = ((long) this.index) * ((long) (dArr.length - 1));
            int divide = (int) LongMath.divide(length, (long) this.scale, RoundingMode.DOWN);
            int i = (int) (length - (((long) divide) * ((long) this.scale)));
            Quantiles.selectInPlace(divide, dArr, 0, dArr.length - 1);
            if (i == 0) {
                return dArr[divide];
            }
            int i2 = divide + 1;
            Quantiles.selectInPlace(i2, dArr, i2, dArr.length - 1);
            return Quantiles.interpolate(dArr[divide], dArr[i2], (double) i, (double) this.scale);
        }
    }

    public static final class ScaleAndIndexes {
        private final int[] indexes;
        private final int scale;

        private ScaleAndIndexes(int i, int[] iArr) {
            for (int checkIndex : iArr) {
                Quantiles.checkIndex(checkIndex, i);
            }
            this.scale = i;
            this.indexes = iArr;
        }

        public final Map<Integer, Double> compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public final Map<Integer, Double> compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public final Map<Integer, Double> compute(long... jArr) {
            return computeInPlace(Quantiles.longsToDoubles(jArr));
        }

        public final Map<Integer, Double> compute(int... iArr) {
            return computeInPlace(Quantiles.intsToDoubles(iArr));
        }

        public final Map<Integer, Double> computeInPlace(double... dArr) {
            double[] dArr2 = dArr;
            int i = 0;
            int i2 = 1;
            Preconditions.checkArgument(dArr2.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.containsNaN(dArr)) {
                HashMap hashMap = new HashMap();
                int[] iArr = this.indexes;
                int length = iArr.length;
                while (i < length) {
                    hashMap.put(Integer.valueOf(iArr[i]), Double.valueOf(Double.NaN));
                    i++;
                }
                return Collections.unmodifiableMap(hashMap);
            }
            int[] iArr2 = this.indexes;
            int[] iArr3 = new int[iArr2.length];
            int[] iArr4 = new int[iArr2.length];
            int[] iArr5 = new int[(iArr2.length * 2)];
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int[] iArr6 = this.indexes;
                if (i3 >= iArr6.length) {
                    break;
                }
                long length2 = ((long) iArr6[i3]) * ((long) (dArr2.length - i2));
                int divide = (int) LongMath.divide(length2, (long) this.scale, RoundingMode.DOWN);
                int i5 = i3;
                int i6 = (int) (length2 - (((long) divide) * ((long) this.scale)));
                iArr3[i5] = divide;
                iArr4[i5] = i6;
                iArr5[i4] = divide;
                i4++;
                if (i6 != 0) {
                    iArr5[i4] = divide + 1;
                    i4++;
                }
                i3 = i5 + 1;
                i2 = 1;
            }
            Arrays.sort(iArr5, 0, i4);
            Quantiles.selectAllInPlace(iArr5, 0, i4 - 1, dArr, 0, dArr2.length - 1);
            HashMap hashMap2 = new HashMap();
            while (true) {
                int[] iArr7 = this.indexes;
                if (i >= iArr7.length) {
                    return Collections.unmodifiableMap(hashMap2);
                }
                int i7 = iArr3[i];
                int i8 = iArr4[i];
                if (i8 == 0) {
                    hashMap2.put(Integer.valueOf(iArr7[i]), Double.valueOf(dArr2[i7]));
                } else {
                    hashMap2.put(Integer.valueOf(iArr7[i]), Double.valueOf(Quantiles.interpolate(dArr2[i7], dArr2[i7 + 1], (double) i8, (double) this.scale)));
                }
                i++;
            }
        }
    }

    public static boolean containsNaN(double... dArr) {
        for (double isNaN : dArr) {
            if (Double.isNaN(isNaN)) {
                return true;
            }
        }
        return false;
    }

    public static void checkIndex(int i, int i2) {
        if (i < 0 || i > i2) {
            throw new IllegalArgumentException("Quantile indexes must be between 0 and the scale, which is ".concat(String.valueOf(i2)));
        }
    }

    public static double[] longsToDoubles(long[] jArr) {
        int length = jArr.length;
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            dArr[i] = (double) jArr[i];
        }
        return dArr;
    }

    public static double[] intsToDoubles(int[] iArr) {
        int length = iArr.length;
        double[] dArr = new double[length];
        for (int i = 0; i < length; i++) {
            dArr[i] = (double) iArr[i];
        }
        return dArr;
    }

    public static void selectInPlace(int i, double[] dArr, int i2, int i3) {
        if (i == i2) {
            int i4 = i2;
            for (int i5 = i2 + 1; i5 <= i3; i5++) {
                if (dArr[i4] > dArr[i5]) {
                    i4 = i5;
                }
            }
            if (i4 != i2) {
                swap(dArr, i4, i2);
                return;
            }
            return;
        }
        while (i3 > i2) {
            int partition = partition(dArr, i2, i3);
            if (partition >= i) {
                i3 = partition - 1;
            }
            if (partition <= i) {
                i2 = partition + 1;
            }
        }
    }

    private static int partition(double[] dArr, int i, int i2) {
        movePivotToStartOfSlice(dArr, i, i2);
        double d = dArr[i];
        int i3 = i2;
        while (i2 > i) {
            if (dArr[i2] > d) {
                swap(dArr, i3, i2);
                i3--;
            }
            i2--;
        }
        swap(dArr, i, i3);
        return i3;
    }

    private static void movePivotToStartOfSlice(double[] dArr, int i, int i2) {
        boolean z = true;
        int i3 = (i + i2) >>> 1;
        boolean z2 = dArr[i2] < dArr[i3];
        boolean z3 = dArr[i3] < dArr[i];
        if (dArr[i2] >= dArr[i]) {
            z = false;
        }
        if (z2 == z3) {
            swap(dArr, i3, i);
        } else if (z2 != z) {
            swap(dArr, i, i2);
        }
    }

    public static void selectAllInPlace(int[] iArr, int i, int i2, double[] dArr, int i3, int i4) {
        int i5 = i;
        int i6 = i3;
        while (true) {
            int chooseNextSelection = chooseNextSelection(iArr, i5, i2, i6, i4);
            int i7 = iArr[chooseNextSelection];
            selectInPlace(i7, dArr, i6, i4);
            int i8 = chooseNextSelection - 1;
            while (i8 >= i5 && iArr[i8] == i7) {
                i8--;
            }
            if (i8 >= i5) {
                selectAllInPlace(iArr, i5, i8, dArr, i6, i7 - 1);
            }
            i5 = chooseNextSelection + 1;
            while (i5 <= i2 && iArr[i5] == i7) {
                i5++;
            }
            if (i5 <= i2) {
                i6 = i7 + 1;
            } else {
                return;
            }
        }
    }

    private static int chooseNextSelection(int[] iArr, int i, int i2, int i3, int i4) {
        if (i == i2) {
            return i;
        }
        int i5 = i3 + i4;
        int i6 = i5 >>> 1;
        while (i2 > i + 1) {
            int i7 = (i + i2) >>> 1;
            if (iArr[i7] > i6) {
                i2 = i7;
            } else if (iArr[i7] >= i6) {
                return i7;
            } else {
                i = i7;
            }
        }
        return (i5 - iArr[i]) - iArr[i2] > 0 ? i2 : i;
    }

    private static void swap(double[] dArr, int i, int i2) {
        double d = dArr[i];
        dArr[i] = dArr[i2];
        dArr[i2] = d;
    }
}
