package com.google.common.math;

import com.google.android.exoplayer2.C;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;

@GwtCompatible(emulated = true)
public final class IntMath {
    @VisibleForTesting
    static int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};
    private static final int[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
    @VisibleForTesting
    static final int[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};
    @VisibleForTesting
    static final int[] powersOf10 = {1, 10, 100, 1000, C.MSG_CUSTOM_BASE, 100000, 1000000, 10000000, 100000000, 1000000000};

    public static boolean isPowerOfTwo(int i) {
        boolean z = false;
        boolean z2 = i > 0;
        if ((i & (i - 1)) == 0) {
            z = true;
        }
        return z2 & z;
    }

    @VisibleForTesting
    static int lessThanBranchFree(int i, int i2) {
        return (((i - i2) ^ -1) ^ -1) >>> 31;
    }

    public static int mean(int i, int i2) {
        return (i & i2) + ((i ^ i2) >> 1);
    }

    @Beta
    public static int ceilingPowerOfTwo(int i) {
        MathPreconditions.checkPositive("x", i);
        if (i <= 1073741824) {
            return 1 << (-Integer.numberOfLeadingZeros(i - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + i + ") not representable as an int");
    }

    @Beta
    public static int floorPowerOfTwo(int i) {
        MathPreconditions.checkPositive("x", i);
        return Integer.highestOneBit(i);
    }

    /* renamed from: com.google.common.math.IntMath$1  reason: invalid class name */
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
            $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;
            $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 3;
            $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;
            $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 5;
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
            try {
                $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static int log2(int i, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", i);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(i));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i - 1);
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i);
                return (31 - numberOfLeadingZeros) + lessThanBranchFree(-1257966797 >>> numberOfLeadingZeros, i);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    @GwtIncompatible
    public static int log10(int i, RoundingMode roundingMode) {
        int lessThanBranchFree;
        MathPreconditions.checkPositive("x", i);
        int log10Floor = log10Floor(i);
        int i2 = powersOf10[log10Floor];
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(i == i2);
                return log10Floor;
            case 2:
            case 3:
                return log10Floor;
            case 4:
            case 5:
                lessThanBranchFree = lessThanBranchFree(i2, i);
                return log10Floor + lessThanBranchFree;
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                lessThanBranchFree = lessThanBranchFree(halfPowersOf10[log10Floor], i);
                return log10Floor + lessThanBranchFree;
            default:
                throw new AssertionError();
        }
    }

    private static int log10Floor(int i) {
        byte b = maxLog10ForLeadingZeros[Integer.numberOfLeadingZeros(i)];
        return b - lessThanBranchFree(i, powersOf10[b]);
    }

    @GwtIncompatible
    public static int pow(int i, int i2) {
        MathPreconditions.checkNonNegative("exponent", i2);
        if (i != -2) {
            if (i == -1) {
                return (i2 & 1) == 0 ? 1 : -1;
            }
            if (i == 0) {
                return i2 == 0 ? 1 : 0;
            }
            if (i == 1) {
                return 1;
            }
            if (i != 2) {
                int i3 = i;
                int i4 = 1;
                while (i2 != 0) {
                    if (i2 == 1) {
                        return i3 * i4;
                    }
                    i4 *= (i2 & 1) == 0 ? 1 : i3;
                    i3 *= i3;
                    i2 >>= 1;
                }
                return i4;
            } else if (i2 < 32) {
                return 1 << i2;
            } else {
                return 0;
            }
        } else if (i2 < 32) {
            return (i2 & 1) == 0 ? 1 << i2 : -(1 << i2);
        } else {
            return 0;
        }
    }

    @GwtIncompatible
    public static int sqrt(int i, RoundingMode roundingMode) {
        int lessThanBranchFree;
        MathPreconditions.checkNonNegative("x", i);
        int sqrtFloor = sqrtFloor(i);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(sqrtFloor * sqrtFloor == i);
                return sqrtFloor;
            case 2:
            case 3:
                return sqrtFloor;
            case 4:
            case 5:
                lessThanBranchFree = lessThanBranchFree(sqrtFloor * sqrtFloor, i);
                return sqrtFloor + lessThanBranchFree;
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                lessThanBranchFree = lessThanBranchFree((sqrtFloor * sqrtFloor) + sqrtFloor, i);
                return sqrtFloor + lessThanBranchFree;
            default:
                throw new AssertionError();
        }
    }

    private static int sqrtFloor(int i) {
        return (int) Math.sqrt((double) i);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        if (((r7 == java.math.RoundingMode.HALF_EVEN) & ((r0 & 1) != 0)) != false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0047, code lost:
        if (r1 > 0) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004a, code lost:
        if (r5 > 0) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004d, code lost:
        if (r5 < 0) goto L_0x0058;
     */
    public static int divide(int i, int i2, RoundingMode roundingMode) {
        Preconditions.checkNotNull(roundingMode);
        if (i2 != 0) {
            int i3 = i / i2;
            int i4 = i - (i2 * i3);
            if (i4 == 0) {
                return i3;
            }
            boolean z = true;
            int i5 = ((i ^ i2) >> 31) | 1;
            switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
                case 1:
                    if (i4 != 0) {
                        z = false;
                    }
                    MathPreconditions.checkRoundingUnnecessary(z);
                    z = false;
                    break;
                case 2:
                    z = false;
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                case 7:
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    int abs = Math.abs(i4);
                    int abs2 = abs - (Math.abs(i2) - abs);
                    if (abs2 == 0) {
                        if (roundingMode != RoundingMode.HALF_UP) {
                            break;
                        }
                    }
                    break;
                default:
                    throw new AssertionError();
            }
            return z ? i3 + i5 : i3;
        }
        throw new ArithmeticException("/ by zero");
    }

    public static int mod(int i, int i2) {
        if (i2 > 0) {
            int i3 = i % i2;
            return i3 >= 0 ? i3 : i3 + i2;
        }
        throw new ArithmeticException("Modulus " + i2 + " must be > 0");
    }

    public static int gcd(int i, int i2) {
        MathPreconditions.checkNonNegative("a", i);
        MathPreconditions.checkNonNegative("b", i2);
        if (i == 0) {
            return i2;
        }
        if (i2 == 0) {
            return i;
        }
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i);
        int i3 = i >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Integer.numberOfTrailingZeros(i2);
        int i4 = i2 >> numberOfTrailingZeros2;
        while (i3 != i4) {
            int i5 = i3 - i4;
            int i6 = (i5 >> 31) & i5;
            int i7 = (i5 - i6) - i6;
            i4 += i6;
            i3 = i7 >> Integer.numberOfTrailingZeros(i7);
        }
        return i3 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static int checkedAdd(int i, int i2) {
        long j = ((long) i) + ((long) i2);
        int i3 = (int) j;
        MathPreconditions.checkNoOverflow(j == ((long) i3), "checkedAdd", i, i2);
        return i3;
    }

    public static int checkedSubtract(int i, int i2) {
        long j = ((long) i) - ((long) i2);
        int i3 = (int) j;
        MathPreconditions.checkNoOverflow(j == ((long) i3), "checkedSubtract", i, i2);
        return i3;
    }

    public static int checkedMultiply(int i, int i2) {
        long j = ((long) i) * ((long) i2);
        int i3 = (int) j;
        MathPreconditions.checkNoOverflow(j == ((long) i3), "checkedMultiply", i, i2);
        return i3;
    }

    public static int checkedPow(int i, int i2) {
        MathPreconditions.checkNonNegative("exponent", i2);
        boolean z = false;
        if (i == -2) {
            if (i2 < 32) {
                z = true;
            }
            MathPreconditions.checkNoOverflow(z, "checkedPow", i, i2);
            return (i2 & 1) == 0 ? 1 << i2 : -1 << i2;
        } else if (i == -1) {
            return (i2 & 1) == 0 ? 1 : -1;
        } else {
            if (i == 0) {
                return i2 == 0 ? 1 : 0;
            }
            if (i == 1) {
                return 1;
            }
            if (i != 2) {
                int i3 = i;
                int i4 = 1;
                while (i2 != 0) {
                    if (i2 == 1) {
                        return checkedMultiply(i4, i3);
                    }
                    if ((i2 & 1) != 0) {
                        i4 = checkedMultiply(i4, i3);
                    }
                    i2 >>= 1;
                    if (i2 > 0) {
                        MathPreconditions.checkNoOverflow((-46340 <= i3) & (i3 <= 46340), "checkedPow", i3, i2);
                        i3 *= i3;
                    }
                }
                return i4;
            }
            if (i2 < 31) {
                z = true;
            }
            MathPreconditions.checkNoOverflow(z, "checkedPow", i, i2);
            return 1 << i2;
        }
    }

    @Beta
    public static int saturatedAdd(int i, int i2) {
        return Ints.saturatedCast(((long) i) + ((long) i2));
    }

    @Beta
    public static int saturatedSubtract(int i, int i2) {
        return Ints.saturatedCast(((long) i) - ((long) i2));
    }

    @Beta
    public static int saturatedMultiply(int i, int i2) {
        return Ints.saturatedCast(((long) i) * ((long) i2));
    }

    @Beta
    public static int saturatedPow(int i, int i2) {
        MathPreconditions.checkNonNegative("exponent", i2);
        if (i != -2) {
            if (i == -1) {
                return (i2 & 1) == 0 ? 1 : -1;
            }
            if (i == 0) {
                return i2 == 0 ? 1 : 0;
            }
            if (i == 1) {
                return 1;
            }
            if (i != 2) {
                int i3 = ((i >>> 31) & i2 & 1) + Integer.MAX_VALUE;
                int i4 = i;
                int i5 = 1;
                while (i2 != 0) {
                    if (i2 == 1) {
                        return saturatedMultiply(i5, i4);
                    }
                    if ((i2 & 1) != 0) {
                        i5 = saturatedMultiply(i5, i4);
                    }
                    i2 >>= 1;
                    if (i2 > 0) {
                        if ((-46340 > i4) || (i4 > 46340)) {
                            return i3;
                        }
                        i4 *= i4;
                    }
                }
                return i5;
            } else if (i2 >= 31) {
                return Integer.MAX_VALUE;
            } else {
                return 1 << i2;
            }
        } else if (i2 >= 32) {
            return (i2 & 1) + Integer.MAX_VALUE;
        } else {
            return (i2 & 1) == 0 ? 1 << i2 : -1 << i2;
        }
    }

    public static int factorial(int i) {
        MathPreconditions.checkNonNegative("n", i);
        int[] iArr = factorials;
        if (i < iArr.length) {
            return iArr[i];
        }
        return Integer.MAX_VALUE;
    }

    public static int binomial(int i, int i2) {
        MathPreconditions.checkNonNegative("n", i);
        MathPreconditions.checkNonNegative("k", i2);
        int i3 = 0;
        Preconditions.checkArgument(i2 <= i, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        int[] iArr = biggestBinomials;
        if (i2 >= iArr.length || i > iArr[i2]) {
            return Integer.MAX_VALUE;
        }
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return i;
        }
        long j = 1;
        while (i3 < i2) {
            i3++;
            j = (j * ((long) (i - i3))) / ((long) i3);
        }
        return (int) j;
    }

    @GwtIncompatible
    @Beta
    public static boolean isPrime(int i) {
        return LongMath.isPrime((long) i);
    }

    private IntMath() {
    }
}
