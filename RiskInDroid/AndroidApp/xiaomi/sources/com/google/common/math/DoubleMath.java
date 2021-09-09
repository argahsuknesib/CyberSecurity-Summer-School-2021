package com.google.common.math;

import com.google.android.exoplayer2.C;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

@GwtCompatible(emulated = true)
public final class DoubleMath {
    private static final double LN_2 = Math.log(2.0d);
    @VisibleForTesting
    static final double[] everySixteenthFactorial = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    @GwtIncompatible
    static double roundIntermediate(double d, RoundingMode roundingMode) {
        if (DoubleUtils.isFinite(d)) {
            switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
                case 1:
                    MathPreconditions.checkRoundingUnnecessary(isMathematicalInteger(d));
                    return d;
                case 2:
                    return (d >= 0.0d || isMathematicalInteger(d)) ? d : (double) (((long) d) - 1);
                case 3:
                    return (d <= 0.0d || isMathematicalInteger(d)) ? d : (double) (((long) d) + 1);
                case 4:
                    return d;
                case 5:
                    if (isMathematicalInteger(d)) {
                        return d;
                    }
                    return (double) (((long) d) + ((long) (d > 0.0d ? 1 : -1)));
                case 6:
                    return Math.rint(d);
                case 7:
                    double rint = Math.rint(d);
                    return Math.abs(d - rint) == 0.5d ? d + Math.copySign(0.5d, d) : rint;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    double rint2 = Math.rint(d);
                    return Math.abs(d - rint2) == 0.5d ? d : rint2;
                default:
                    throw new AssertionError();
            }
        } else {
            throw new ArithmeticException("input is infinite or NaN");
        }
    }

    /* renamed from: com.google.common.math.DoubleMath$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode = new int[RoundingMode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|(3:15|16|18)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            $SwitchMap$java$math$RoundingMode[RoundingMode.UNNECESSARY.ordinal()] = 1;
            $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 2;
            $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 3;
            $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 4;
            $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 5;
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 6;
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @GwtIncompatible
    public static int roundToInt(double d, RoundingMode roundingMode) {
        double roundIntermediate = roundIntermediate(d, roundingMode);
        boolean z = true;
        boolean z2 = roundIntermediate > -2.147483649E9d;
        if (roundIntermediate >= 2.147483648E9d) {
            z = false;
        }
        MathPreconditions.checkInRangeForRoundingInputs(z & z2, d, roundingMode);
        return (int) roundIntermediate;
    }

    @GwtIncompatible
    public static long roundToLong(double d, RoundingMode roundingMode) {
        double roundIntermediate = roundIntermediate(d, roundingMode);
        boolean z = true;
        boolean z2 = -9.223372036854776E18d - roundIntermediate < 1.0d;
        if (roundIntermediate >= 9.223372036854776E18d) {
            z = false;
        }
        MathPreconditions.checkInRangeForRoundingInputs(z2 & z, d, roundingMode);
        return (long) roundIntermediate;
    }

    @GwtIncompatible
    public static BigInteger roundToBigInteger(double d, RoundingMode roundingMode) {
        double roundIntermediate = roundIntermediate(d, roundingMode);
        boolean z = true;
        boolean z2 = -9.223372036854776E18d - roundIntermediate < 1.0d;
        if (roundIntermediate >= 9.223372036854776E18d) {
            z = false;
        }
        if (z && z2) {
            return BigInteger.valueOf((long) roundIntermediate);
        }
        BigInteger shiftLeft = BigInteger.valueOf(DoubleUtils.getSignificand(roundIntermediate)).shiftLeft(Math.getExponent(roundIntermediate) - 52);
        return roundIntermediate < 0.0d ? shiftLeft.negate() : shiftLeft;
    }

    @GwtIncompatible
    public static boolean isPowerOfTwo(double d) {
        if (d > 0.0d && DoubleUtils.isFinite(d)) {
            long significand = DoubleUtils.getSignificand(d);
            if ((significand & (significand - 1)) == 0) {
                return true;
            }
        }
        return false;
    }

    public static double log2(double d) {
        return Math.log(d) / LN_2;
    }

    @GwtIncompatible
    public static int log2(double d, RoundingMode roundingMode) {
        boolean z;
        boolean z2 = false;
        Preconditions.checkArgument(d > 0.0d && DoubleUtils.isFinite(d), "x must be positive and finite");
        int exponent = Math.getExponent(d);
        if (!DoubleUtils.isNormal(d)) {
            return log2(d * 4.503599627370496E15d, roundingMode) - 52;
        }
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(d));
                break;
            case 2:
                break;
            case 3:
                z2 = !isPowerOfTwo(d);
                break;
            case 4:
                if (exponent < 0) {
                    z2 = true;
                }
                z = isPowerOfTwo(d);
                z2 &= !z;
                break;
            case 5:
                if (exponent >= 0) {
                    z2 = true;
                }
                z = isPowerOfTwo(d);
                z2 &= !z;
                break;
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                double scaleNormalize = DoubleUtils.scaleNormalize(d);
                if (scaleNormalize * scaleNormalize > 2.0d) {
                    z2 = true;
                    break;
                }
                break;
            default:
                throw new AssertionError();
        }
        return z2 ? exponent + 1 : exponent;
    }

    @GwtIncompatible
    public static boolean isMathematicalInteger(double d) {
        if (DoubleUtils.isFinite(d)) {
            return d == 0.0d || 52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(d)) <= Math.getExponent(d);
        }
        return false;
    }

    public static double factorial(int i) {
        MathPreconditions.checkNonNegative("n", i);
        if (i > 170) {
            return Double.POSITIVE_INFINITY;
        }
        double d = 1.0d;
        int i2 = i & -16;
        while (true) {
            i2++;
            if (i2 > i) {
                return d * everySixteenthFactorial[i >> 4];
            }
            double d2 = (double) i2;
            Double.isNaN(d2);
            d *= d2;
        }
    }

    public static boolean fuzzyEquals(double d, double d2, double d3) {
        MathPreconditions.checkNonNegative("tolerance", d3);
        if (Math.copySign(d - d2, 1.0d) <= d3 || d == d2) {
            return true;
        }
        return Double.isNaN(d) && Double.isNaN(d2);
    }

    public static int fuzzyCompare(double d, double d2, double d3) {
        if (fuzzyEquals(d, d2, d3)) {
            return 0;
        }
        if (d < d2) {
            return -1;
        }
        if (d > d2) {
            return 1;
        }
        return Booleans.compare(Double.isNaN(d), Double.isNaN(d2));
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0, "Cannot take mean of 0 values");
        double checkFinite = checkFinite(dArr[0]);
        long j = 1;
        for (int i = 1; i < dArr.length; i++) {
            checkFinite(dArr[i]);
            j++;
            double d = (double) j;
            Double.isNaN(d);
            checkFinite += (dArr[i] - checkFinite) / d;
        }
        return checkFinite;
    }

    @Deprecated
    public static double mean(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0, "Cannot take mean of 0 values");
        long j = 0;
        for (int i : iArr) {
            j += (long) i;
        }
        double d = (double) j;
        double length = (double) iArr.length;
        Double.isNaN(d);
        Double.isNaN(length);
        return d / length;
    }

    @Deprecated
    public static double mean(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0, "Cannot take mean of 0 values");
        double d = (double) jArr[0];
        long j = 1;
        for (int i = 1; i < jArr.length; i++) {
            j++;
            double d2 = (double) jArr[i];
            Double.isNaN(d2);
            double d3 = (double) j;
            Double.isNaN(d3);
            d += (d2 - d) / d3;
        }
        return d;
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(Iterable<? extends Number> iterable) {
        return mean(iterable.iterator());
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(Iterator<? extends Number> it) {
        Preconditions.checkArgument(it.hasNext(), "Cannot take mean of 0 values");
        double checkFinite = checkFinite(((Number) it.next()).doubleValue());
        long j = 1;
        while (it.hasNext()) {
            j++;
            double d = (double) j;
            Double.isNaN(d);
            checkFinite += (checkFinite(((Number) it.next()).doubleValue()) - checkFinite) / d;
        }
        return checkFinite;
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    private static double checkFinite(double d) {
        Preconditions.checkArgument(DoubleUtils.isFinite(d));
        return d;
    }

    private DoubleMath() {
    }
}
