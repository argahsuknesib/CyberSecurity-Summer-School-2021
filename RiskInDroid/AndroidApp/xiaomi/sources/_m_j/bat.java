package _m_j;

import java.util.Locale;

public final class bat {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f12754O000000o = "ByteOperator";

    public static int O000000o(byte[] bArr) throws StringIndexOutOfBoundsException {
        return ((bArr[1] << 8) & 65280) | (bArr[0] & 255);
    }

    public static int O00000Oo(byte[] bArr) throws StringIndexOutOfBoundsException {
        return ((bArr[3] << 24) & -16777216) | (bArr[0] & 255) | ((bArr[1] << 8) & 65280) | ((bArr[2] << 16) & 16711680);
    }

    public static int O00000o0(byte[] bArr) throws StringIndexOutOfBoundsException {
        return ((bArr[22] << 24) & -16777216) | (bArr[19] & 255) | ((bArr[20] << 8) & 65280) | ((bArr[21] << 16) & 16711680);
    }

    public static byte[] O000000o(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & -16777216) >> 24)};
    }

    public static final boolean O000000o(byte[] bArr, byte[] bArr2) throws StringIndexOutOfBoundsException {
        int length = bArr.length;
        int length2 = bArr2.length;
        if (length >= length2) {
            length = length2;
        }
        for (int i = 0; i < length; i++) {
            bArr[i] = bArr2[i];
        }
        return true;
    }

    public static final boolean O000000o(byte[] bArr, int i, byte[] bArr2, int i2, int i3) throws StringIndexOutOfBoundsException {
        int length = bArr.length - i;
        int i4 = (i3 - i2) + 1;
        if (length < i4) {
            i4 = length;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[i5 + i] = bArr2[i5 + i2];
        }
        return true;
    }

    private static String O000000o(byte[] bArr, int i) throws StringIndexOutOfBoundsException {
        if (i > bArr.length) {
            i = bArr.length;
        }
        String str = "";
        for (int i2 = 0; i2 < i; i2++) {
            String hexString = Integer.toHexString(bArr[i2] & 255);
            if (hexString.length() == 1) {
                hexString = "0".concat(String.valueOf(hexString));
            }
            str = str + hexString.toUpperCase(Locale.ENGLISH);
        }
        return str;
    }

    public static final String O00000o(byte[] bArr) {
        int length = bArr == null ? 0 : bArr.length;
        String str = "";
        for (int i = 0; i < length; i++) {
            String hexString = Integer.toHexString(bArr[i] & 255);
            if (hexString.length() == 1) {
                hexString = "0".concat(String.valueOf(hexString));
            }
            str = str + hexString.toUpperCase(Locale.ENGLISH);
        }
        return str;
    }

    public static byte[] O00000oO(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        for (int i = 0; i < 4; i++) {
            bArr2[i] = bArr[3 - i];
            bArr2[i + 4] = bArr[7 - i];
            bArr2[i + 8] = bArr[11 - i];
            bArr2[i + 12] = bArr[15 - i];
        }
        return bArr2;
    }

    public static byte[] O00000Oo(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i & 65280) >> 8)};
    }

    public static final boolean O00000Oo(byte[] bArr, byte[] bArr2) throws StringIndexOutOfBoundsException {
        if (bArr.length - 0 < 4) {
            return false;
        }
        byte[] O000000o2 = O000000o(bArr2, 0, 3);
        byte[] O000000o3 = O000000o(bArr, 0, 3);
        return O000000o(O000000o2, O000000o2.length).equals(O000000o(O000000o3, O000000o3.length));
    }

    private static byte[] O000000o(byte[] bArr, int i, int i2) throws StringIndexOutOfBoundsException {
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        return bArr2;
    }
}
