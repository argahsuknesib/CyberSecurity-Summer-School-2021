package com.google.common.math;

import com.google.android.exoplayer2.C;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedLongs;
import com.xiaomi.mico.R2;
import java.math.RoundingMode;

@GwtCompatible(emulated = true)
public final class LongMath {
    static final int[] biggestBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};
    @VisibleForTesting
    static final int[] biggestSimpleBinomials = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, R2.attr.icon, 419, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
    static final long[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    @GwtIncompatible
    @VisibleForTesting
    static final long[] halfPowersOf10 = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros = {19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};
    private static final long[][] millerRabinBaseSets = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};
    @GwtIncompatible
    @VisibleForTesting
    static final long[] powersOf10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};

    static boolean fitsInInt(long j) {
        return ((long) ((int) j)) == j;
    }

    public static boolean isPowerOfTwo(long j) {
        boolean z = true;
        boolean z2 = j > 0;
        if ((j & (j - 1)) != 0) {
            z = false;
        }
        return z2 & z;
    }

    @VisibleForTesting
    static int lessThanBranchFree(long j, long j2) {
        return (int) ((((j - j2) ^ -1) ^ -1) >>> 63);
    }

    public static long mean(long j, long j2) {
        return (j & j2) + ((j ^ j2) >> 1);
    }

    @Beta
    public static long saturatedAdd(long j, long j2) {
        long j3 = j + j2;
        boolean z = true;
        boolean z2 = (j2 ^ j) < 0;
        if ((j ^ j3) < 0) {
            z = false;
        }
        return z2 | z ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @Beta
    public static long saturatedSubtract(long j, long j2) {
        long j3 = j - j2;
        boolean z = true;
        boolean z2 = (j2 ^ j) >= 0;
        if ((j ^ j3) < 0) {
            z = false;
        }
        return z2 | z ? j3 : ((j3 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @Beta
    public static long ceilingPowerOfTwo(long j) {
        MathPreconditions.checkPositive("x", j);
        if (j <= 4611686018427387904L) {
            return 1 << (-Long.numberOfLeadingZeros(j - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + j + ") is not representable as a long");
    }

    @Beta
    public static long floorPowerOfTwo(long j) {
        MathPreconditions.checkPositive("x", j);
        return 1 << (63 - Long.numberOfLeadingZeros(j));
    }

    /* renamed from: com.google.common.math.LongMath$1  reason: invalid class name */
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
    public static int log2(long j, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", j);
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(j));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j - 1);
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                int numberOfLeadingZeros = Long.numberOfLeadingZeros(j);
                return (63 - numberOfLeadingZeros) + lessThanBranchFree(-5402926248376769404 >>> numberOfLeadingZeros, j);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j);
    }

    @GwtIncompatible
    public static int log10(long j, RoundingMode roundingMode) {
        int lessThanBranchFree;
        MathPreconditions.checkPositive("x", j);
        int log10Floor = log10Floor(j);
        long j2 = powersOf10[log10Floor];
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.checkRoundingUnnecessary(j == j2);
                return log10Floor;
            case 2:
            case 3:
                return log10Floor;
            case 4:
            case 5:
                lessThanBranchFree = lessThanBranchFree(j2, j);
                return log10Floor + lessThanBranchFree;
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                lessThanBranchFree = lessThanBranchFree(halfPowersOf10[log10Floor], j);
                return log10Floor + lessThanBranchFree;
            default:
                throw new AssertionError();
        }
    }

    @GwtIncompatible
    static int log10Floor(long j) {
        byte b = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(j)];
        return b - lessThanBranchFree(j, powersOf10[b]);
    }

    @GwtIncompatible
    public static long pow(long j, int i) {
        MathPreconditions.checkNonNegative("exponent", i);
        if (-2 > j || j > 2) {
            long j2 = j;
            long j3 = 1;
            while (i != 0) {
                if (i == 1) {
                    return j3 * j2;
                }
                j3 *= (i & 1) == 0 ? 1 : j2;
                j2 *= j2;
                i >>= 1;
            }
            return j3;
        }
        int i2 = (int) j;
        if (i2 != -2) {
            if (i2 == -1) {
                return (i & 1) == 0 ? 1 : -1;
            }
            if (i2 == 0) {
                return i == 0 ? 1 : 0;
            }
            if (i2 == 1) {
                return 1;
            }
            if (i2 != 2) {
                throw new AssertionError();
            } else if (i < 64) {
                return 1 << i;
            } else {
                return 0;
            }
        } else if (i < 64) {
            return (i & 1) == 0 ? 1 << i : -(1 << i);
        } else {
            return 0;
        }
    }

    @GwtIncompatible
    public static long sqrt(long j, RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", j);
        if (fitsInInt(j)) {
            return (long) IntMath.sqrt((int) j, roundingMode);
        }
        long sqrt = (long) Math.sqrt((double) j);
        long j2 = sqrt * sqrt;
        boolean z = true;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                if (j2 != j) {
                    z = false;
                }
                MathPreconditions.checkRoundingUnnecessary(z);
                return sqrt;
            case 2:
            case 3:
                return j < j2 ? sqrt - 1 : sqrt;
            case 4:
            case 5:
                return j > j2 ? sqrt + 1 : sqrt;
            case 6:
            case 7:
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                if (j >= j2) {
                    z = false;
                }
                long j3 = sqrt - (z ? 1 : 0);
                return j3 + ((long) lessThanBranchFree((j3 * j3) + j3, j));
            default:
                throw new AssertionError();
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r2 > 0) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0056, code lost:
        if (r9 > 0) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
        if (r9 < 0) goto L_0x0066;
     */
    @GwtIncompatible
    public static long divide(long j, long j2, RoundingMode roundingMode) {
        Preconditions.checkNotNull(roundingMode);
        long j3 = j / j2;
        long j4 = j - (j2 * j3);
        if (j4 == 0) {
            return j3;
        }
        int i = (int) ((j ^ j2) >> 63);
        boolean z = true;
        int i2 = i | 1;
        switch (AnonymousClass1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1:
                if (j4 != 0) {
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
                long abs = Math.abs(j4);
                long abs2 = abs - (Math.abs(j2) - abs);
                if (abs2 != 0) {
                    break;
                } else {
                    boolean z2 = roundingMode == RoundingMode.HALF_UP;
                    boolean z3 = roundingMode == RoundingMode.HALF_EVEN;
                    if ((1 & j3) == 0) {
                        z = false;
                    }
                    z = (z & z3) | z2;
                    break;
                }
            default:
                throw new AssertionError();
        }
        return z ? j3 + ((long) i2) : j3;
    }

    @GwtIncompatible
    public static int mod(long j, int i) {
        return (int) mod(j, (long) i);
    }

    @GwtIncompatible
    public static long mod(long j, long j2) {
        if (j2 > 0) {
            long j3 = j % j2;
            return j3 >= 0 ? j3 : j3 + j2;
        }
        throw new ArithmeticException("Modulus must be positive");
    }

    public static long gcd(long j, long j2) {
        MathPreconditions.checkNonNegative("a", j);
        MathPreconditions.checkNonNegative("b", j2);
        if (j == 0) {
            return j2;
        }
        if (j2 == 0) {
            return j;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j);
        long j3 = j >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j2);
        long j4 = j2 >> numberOfTrailingZeros2;
        while (j3 != j4) {
            long j5 = j3 - j4;
            long j6 = (j5 >> 63) & j5;
            long j7 = (j5 - j6) - j6;
            j4 += j6;
            j3 = j7 >> Long.numberOfTrailingZeros(j7);
        }
        return j3 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    @GwtIncompatible
    public static long checkedAdd(long j, long j2) {
        long j3 = j + j2;
        boolean z = true;
        boolean z2 = (j ^ j2) < 0;
        if ((j ^ j3) < 0) {
            z = false;
        }
        MathPreconditions.checkNoOverflow(z2 | z, "checkedAdd", j, j2);
        return j3;
    }

    @GwtIncompatible
    public static long checkedSubtract(long j, long j2) {
        long j3 = j - j2;
        boolean z = true;
        boolean z2 = (j ^ j2) >= 0;
        if ((j ^ j3) < 0) {
            z = false;
        }
        MathPreconditions.checkNoOverflow(z2 | z, "checkedSubtract", j, j2);
        return j3;
    }

    public static long checkedMultiply(long j, long j2) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j) + Long.numberOfLeadingZeros(j ^ -1) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(-1 ^ j2);
        if (numberOfLeadingZeros > 65) {
            return j * j2;
        }
        MathPreconditions.checkNoOverflow(numberOfLeadingZeros >= 64, "checkedMultiply", j, j2);
        MathPreconditions.checkNoOverflow((j >= 0) | (j2 != Long.MIN_VALUE), "checkedMultiply", j, j2);
        long j3 = j * j2;
        MathPreconditions.checkNoOverflow(j == 0 || j3 / j == j2, "checkedMultiply", j, j2);
        return j3;
    }

    @GwtIncompatible
    public static long checkedPow(long j, int i) {
        long j2 = j;
        int i2 = i;
        MathPreconditions.checkNonNegative("exponent", i2);
        boolean z = false;
        long j3 = 1;
        if ((j2 >= -2) && (j2 <= 2)) {
            int i3 = (int) j2;
            if (i3 == -2) {
                if (i2 < 64) {
                    z = true;
                }
                MathPreconditions.checkNoOverflow(z, "checkedPow", j, (long) i2);
                return (i2 & 1) == 0 ? 1 << i2 : -1 << i2;
            } else if (i3 == -1) {
                return (i2 & 1) == 0 ? 1 : -1;
            } else {
                if (i3 != 0) {
                    if (i3 == 1) {
                        return 1;
                    }
                    if (i3 == 2) {
                        if (i2 < 63) {
                            z = true;
                        }
                        MathPreconditions.checkNoOverflow(z, "checkedPow", j, (long) i2);
                        return 1 << i2;
                    }
                    throw new AssertionError();
                } else if (i2 == 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        } else {
            while (i2 != 0) {
                if (i2 == 1) {
                    return checkedMultiply(j3, j2);
                }
                if ((i2 & 1) != 0) {
                    j3 = checkedMultiply(j3, j2);
                }
                i2 >>= 1;
                if (i2 > 0) {
                    MathPreconditions.checkNoOverflow(-3037000499L <= j2 && j2 <= 3037000499L, "checkedPow", j2, (long) i2);
                    j2 *= j2;
                }
            }
            return j3;
        }
    }

    @Beta
    public static long saturatedMultiply(long j, long j2) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j) + Long.numberOfLeadingZeros(j ^ -1) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(-1 ^ j2);
        if (numberOfLeadingZeros > 65) {
            return j * j2;
        }
        long j3 = ((j ^ j2) >>> 63) + Long.MAX_VALUE;
        boolean z = true;
        boolean z2 = numberOfLeadingZeros < 64;
        boolean z3 = j < 0;
        if (j2 != Long.MIN_VALUE) {
            z = false;
        }
        if (z2 || (z3 & z)) {
            return j3;
        }
        long j4 = j * j2;
        return (j == 0 || j4 / j == j2) ? j4 : j3;
    }

    @Beta
    public static long saturatedPow(long j, int i) {
        MathPreconditions.checkNonNegative("exponent", i);
        long j2 = 1;
        if ((j >= -2) && (j <= 2)) {
            int i2 = (int) j;
            if (i2 != -2) {
                if (i2 == -1) {
                    return (i & 1) == 0 ? 1 : -1;
                }
                if (i2 != 0) {
                    if (i2 == 1) {
                        return 1;
                    }
                    if (i2 != 2) {
                        throw new AssertionError();
                    } else if (i >= 63) {
                        return Long.MAX_VALUE;
                    } else {
                        return 1 << i;
                    }
                } else if (i == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else if (i >= 64) {
                return ((long) (i & 1)) + Long.MAX_VALUE;
            } else {
                return (i & 1) == 0 ? 1 << i : -1 << i;
            }
        } else {
            long j3 = ((j >>> 63) & ((long) (i & 1))) + Long.MAX_VALUE;
            while (i != 0) {
                if (i == 1) {
                    return saturatedMultiply(j2, j);
                }
                if ((i & 1) != 0) {
                    j2 = saturatedMultiply(j2, j);
                }
                i >>= 1;
                if (i > 0) {
                    if ((-3037000499L > j) || (j > 3037000499L)) {
                        return j3;
                    }
                    j *= j;
                }
            }
            return j2;
        }
    }

    @GwtIncompatible
    public static long factorial(int i) {
        MathPreconditions.checkNonNegative("n", i);
        long[] jArr = factorials;
        if (i < jArr.length) {
            return jArr[i];
        }
        return Long.MAX_VALUE;
    }

    public static long binomial(int i, int i2) {
        MathPreconditions.checkNonNegative("n", i);
        MathPreconditions.checkNonNegative("k", i2);
        Preconditions.checkArgument(i2 <= i, "k (%s) > n (%s)", i2, i);
        if (i2 > (i >> 1)) {
            i2 = i - i2;
        }
        if (i2 == 0) {
            return 1;
        }
        if (i2 == 1) {
            return (long) i;
        }
        long[] jArr = factorials;
        if (i < jArr.length) {
            return jArr[i] / (jArr[i2] * jArr[i - i2]);
        }
        int[] iArr = biggestBinomials;
        if (i2 >= iArr.length || i > iArr[i2]) {
            return Long.MAX_VALUE;
        }
        int[] iArr2 = biggestSimpleBinomials;
        int i3 = 2;
        if (i2 >= iArr2.length || i > iArr2[i2]) {
            long j = (long) i;
            int log2 = log2(j, RoundingMode.CEILING);
            long j2 = 1;
            long j3 = j;
            int i4 = i - 1;
            int i5 = log2;
            long j4 = 1;
            while (i3 <= i2) {
                i5 += log2;
                if (i5 < 63) {
                    j3 *= (long) i4;
                    j2 *= (long) i3;
                } else {
                    long multiplyFraction = multiplyFraction(j4, j3, j2);
                    i5 = log2;
                    j2 = (long) i3;
                    j3 = (long) i4;
                    j4 = multiplyFraction;
                }
                i3++;
                i4--;
            }
            return multiplyFraction(j4, j3, j2);
        }
        int i6 = i - 1;
        long j5 = (long) i;
        while (i3 <= i2) {
            j5 = (j5 * ((long) i6)) / ((long) i3);
            i6--;
            i3++;
        }
        return j5;
    }

    static long multiplyFraction(long j, long j2, long j3) {
        if (j == 1) {
            return j2 / j3;
        }
        long gcd = gcd(j, j3);
        return (j / gcd) * (j2 / (j3 / gcd));
    }

    @GwtIncompatible
    @Beta
    public static boolean isPrime(long j) {
        if (j < 2) {
            MathPreconditions.checkNonNegative("n", j);
            return false;
        } else if (j == 2 || j == 3 || j == 5 || j == 7 || j == 11 || j == 13) {
            return true;
        } else {
            if ((-545925251 & (1 << ((int) (j % 30)))) != 0 || j % 7 == 0 || j % 11 == 0 || j % 13 == 0) {
                return false;
            }
            if (j < 289) {
                return true;
            }
            for (long[] jArr : millerRabinBaseSets) {
                if (j <= jArr[0]) {
                    for (int i = 1; i < jArr.length; i++) {
                        if (!MillerRabinTester.test(jArr[i], j)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            throw new AssertionError();
        }
    }

    enum MillerRabinTester {
        SMALL {
            /* access modifiers changed from: package-private */
            public final long mulMod(long j, long j2, long j3) {
                return (j * j2) % j3;
            }

            /* access modifiers changed from: package-private */
            public final long squareMod(long j, long j2) {
                return (j * j) % j2;
            }
        },
        LARGE {
            private long plusMod(long j, long j2, long j3) {
                return j >= j3 - j2 ? (j + j2) - j3 : j + j2;
            }

            private long times2ToThe32Mod(long j, long j2) {
                int i = 32;
                do {
                    int min = Math.min(i, Long.numberOfLeadingZeros(j));
                    j = UnsignedLongs.remainder(j << min, j2);
                    i -= min;
                } while (i > 0);
                return j;
            }

            /* access modifiers changed from: package-private */
            public final long mulMod(long j, long j2, long j3) {
                long j4 = j3;
                long j5 = j >>> 32;
                long j6 = j2 >>> 32;
                long j7 = j & 4294967295L;
                long j8 = j2 & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j5 * j6, j4) + (j5 * j8);
                if (times2ToThe32Mod < 0) {
                    times2ToThe32Mod = UnsignedLongs.remainder(times2ToThe32Mod, j4);
                }
                Long.signum(j7);
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + (j6 * j7), j4), UnsignedLongs.remainder(j7 * j8, j4), j3);
            }

            /* access modifiers changed from: package-private */
            public final long squareMod(long j, long j2) {
                long j3 = j >>> 32;
                long j4 = j & 4294967295L;
                long times2ToThe32Mod = times2ToThe32Mod(j3 * j3, j2);
                long j5 = j3 * j4 * 2;
                if (j5 < 0) {
                    j5 = UnsignedLongs.remainder(j5, j2);
                }
                return plusMod(times2ToThe32Mod(times2ToThe32Mod + j5, j2), UnsignedLongs.remainder(j4 * j4, j2), j2);
            }
        };

        /* access modifiers changed from: package-private */
        public abstract long mulMod(long j, long j2, long j3);

        /* access modifiers changed from: package-private */
        public abstract long squareMod(long j, long j2);

        static boolean test(long j, long j2) {
            return (j2 <= 3037000499L ? SMALL : LARGE).testWitness(j, j2);
        }

        private long powMod(long j, long j2, long j3) {
            long j4 = 1;
            while (j2 != 0) {
                if ((j2 & 1) != 0) {
                    j4 = mulMod(j4, j, j3);
                }
                j = squareMod(j, j3);
                j2 >>= 1;
            }
            return j4;
        }

        private boolean testWitness(long j, long j2) {
            long j3 = j2;
            long j4 = j3 - 1;
            int numberOfTrailingZeros = Long.numberOfTrailingZeros(j4);
            long j5 = j4 >> numberOfTrailingZeros;
            long j6 = j % j3;
            if (j6 == 0) {
                return true;
            }
            long powMod = powMod(j6, j5, j2);
            if (powMod == 1) {
                return true;
            }
            int i = 0;
            while (powMod != j4) {
                i++;
                if (i == numberOfTrailingZeros) {
                    return false;
                }
                powMod = squareMod(powMod, j3);
            }
            return true;
        }
    }

    private LongMath() {
    }
}
