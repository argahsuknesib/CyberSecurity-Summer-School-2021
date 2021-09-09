package _m_j;

public final class cnb {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final char[] f14135O000000o = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static int O000000o(int i) {
        return i & 65535;
    }

    public static int O00000Oo(int i) {
        return i & 255;
    }

    public static long O00000o0(int i) {
        return ((long) i) & 4294967295L;
    }

    public static String O000000o(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(f14135O000000o[(b & 240) >>> 4]);
            sb.append(f14135O000000o[b & 15]);
        }
        return sb.toString();
    }

    public static String O000000o(long j) {
        long j2 = (j >>> 1) / 5;
        return Long.toString(j2) + (j - (10 * j2));
    }

    public static long O000000o(String str) throws NumberFormatException {
        if (str != null) {
            int length = str.length();
            if (length <= 0) {
                throw new NumberFormatException("For input string: \"" + str + jdn.f1779O000000o);
            } else if (str.charAt(0) == '-') {
                throw new NumberFormatException(String.format("Illegal leading minus sign on unsigned string %s.", str));
            } else if (length <= 12 || length <= 18) {
                return Long.parseLong(str, 10);
            } else {
                int i = length - 1;
                long parseLong = Long.parseLong(str.substring(0, i), 10);
                int digit = Character.digit(str.charAt(i), 10);
                if (digit >= 0) {
                    long j = (10 * parseLong) + ((long) digit);
                    long j2 = j - Long.MIN_VALUE;
                    long j3 = parseLong - Long.MIN_VALUE;
                    if ((j2 < j3 ? 65535 : j2 == j3 ? (char) 0 : 1) >= 0) {
                        return j;
                    }
                    throw new NumberFormatException(String.format("String value %s exceeds range of unsigned long.", str));
                }
                throw new NumberFormatException("Bad digit at end of ".concat(String.valueOf(str)));
            }
        } else {
            throw new NumberFormatException("null");
        }
    }
}
