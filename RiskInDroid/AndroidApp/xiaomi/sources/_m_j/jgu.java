package _m_j;

public final class jgu implements jgt {
    private static final char[] O00000o = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] O00000oO = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static byte[] O000000o(String str) {
        char[] cArr;
        int i = 0;
        if (str != null) {
            cArr = str.toCharArray();
        } else {
            cArr = new char[0];
        }
        int length = cArr == null ? 0 : cArr.length;
        if ((length & 1) == 0) {
            byte[] bArr = new byte[(length >> 1)];
            int i2 = 0;
            while (i < length) {
                int i3 = i + 1;
                i = i3 + 1;
                bArr[i2] = (byte) (((O000000o(cArr[i], i) << 4) | O000000o(cArr[i3], i3)) & 255);
                i2++;
            }
            return bArr;
        }
        throw new RuntimeException("Odd number of characters.");
    }

    public static String O000000o(byte[] bArr) {
        return new String(O00000Oo(bArr));
    }

    private static int O000000o(char c, int i) {
        int digit = Character.digit(c, 16);
        if (digit != -1) {
            return digit;
        }
        throw new RuntimeException("Illegal hexadecimal character " + c + " at index " + i);
    }

    public final String toString() {
        return super.toString() + "[charsetName=" + f1830O000000o + "]";
    }

    private static char[] O00000Oo(byte[] bArr) {
        char[] cArr = O00000o;
        int length = bArr.length;
        char[] cArr2 = new char[(length << 1)];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i + 1;
            cArr2[i] = cArr[(bArr[i2] & 240) >>> 4];
            i = i3 + 1;
            cArr2[i3] = cArr[bArr[i2] & 15];
        }
        return cArr2;
    }
}
