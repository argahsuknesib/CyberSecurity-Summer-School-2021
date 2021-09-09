package _m_j;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, k = 5, mv = {1, 1, 13}, xi = 1, xs = "kotlin/text/StringsKt")
public class iyv extends iyu {
    public static final Long O000000o(String str) {
        ixe.O00000o0(str, "receiver$0");
        return iyo.O00000Oo(str);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Character.digit(int, int):int}
     arg types: [char, int]
     candidates:
      ClspMth{java.lang.Character.digit(char, int):int}
      ClspMth{java.lang.Character.digit(int, int):int} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0035 A[LOOP:0: B:17:0x0035->B:28:0x005b, LOOP_START, PHI: r2 r8 10  PHI: (r2v2 int) = (r2v1 int), (r2v3 int) binds: [B:16:0x0033, B:28:0x005b] A[DONT_GENERATE, DONT_INLINE]10  PHI: (r8v2 long) = (r8v0 long), (r8v4 long) binds: [B:16:0x0033, B:28:0x005b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065  */
    public static final Long O00000Oo(String str) {
        boolean z;
        int i;
        ixe.O00000o0(str, "receiver$0");
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char charAt = str.charAt(0);
        long j = -9223372036854775807L;
        if (charAt < '0') {
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                j = Long.MIN_VALUE;
                i2 = 1;
                z = true;
                long j2 = 0;
                i = length - 1;
                if (i2 <= i) {
                    while (true) {
                        int digit = Character.digit((int) str.charAt(i2), 10);
                        if (digit >= 0 && j2 >= -922337203685477580L) {
                            long j3 = j2 * 10;
                            long j4 = (long) digit;
                            if (j3 >= j + j4) {
                                j2 = j3 - j4;
                                if (i2 == i) {
                                    break;
                                }
                                i2++;
                            } else {
                                return null;
                            }
                        } else {
                            return null;
                        }
                    }
                }
                return !z ? Long.valueOf(j2) : Long.valueOf(-j2);
            } else if (charAt != '+') {
                return null;
            } else {
                i2 = 1;
            }
        }
        z = false;
        long j22 = 0;
        i = length - 1;
        if (i2 <= i) {
        }
        if (!z) {
        }
    }
}
