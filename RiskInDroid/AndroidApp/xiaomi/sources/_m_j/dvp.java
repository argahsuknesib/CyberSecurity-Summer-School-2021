package _m_j;

import java.util.Locale;

public final class dvp {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f14975O000000o = "ByteOperator ";

    public static int O000000o(byte[] bArr, int i) throws StringIndexOutOfBoundsException {
        return ((bArr[i + 1] << 8) & 65280) | (bArr[i] & 255);
    }

    public static int O00000Oo(byte[] bArr, int i) throws StringIndexOutOfBoundsException {
        return ((bArr[i + 3] << 24) & -16777216) | (bArr[i] & 255) | ((bArr[i + 1] << 8) & 65280) | ((bArr[i + 2] << 16) & 16711680);
    }

    public static byte[] O000000o(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & -16777216) >> 24)};
    }

    public static final boolean O000000o(byte[] bArr, byte[] bArr2) throws StringIndexOutOfBoundsException {
        int length = bArr2.length;
        if (2 < length) {
            length = 2;
        }
        System.arraycopy(bArr2, 0, bArr, 0, length);
        return true;
    }

    public static final boolean O000000o(byte[] bArr, int i, byte[] bArr2, int i2) throws StringIndexOutOfBoundsException {
        int length = bArr.length - i;
        int i3 = (i2 - 0) + 1;
        if (length < i3) {
            i3 = length;
        }
        System.arraycopy(bArr2, 0, bArr, i, i3);
        return true;
    }

    private static String O00000o0(byte[] bArr, int i) throws StringIndexOutOfBoundsException {
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

    public static final String O000000o(byte[] bArr) {
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

    public static byte[] O000000o(byte[] bArr, int i, int i2) throws StringIndexOutOfBoundsException {
        if (i2 < i) {
            return new byte[48];
        }
        if (i2 == i) {
            return new byte[]{bArr[i]};
        }
        byte[] bArr2 = new byte[((i2 - i) + 1)];
        System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
        return bArr2;
    }

    public static final boolean O000000o(byte[] bArr, byte[] bArr2, int i) throws StringIndexOutOfBoundsException {
        int i2 = i + 0 + 1;
        if (bArr.length - 0 < i2) {
            return false;
        }
        byte[] O000000o2 = O000000o(bArr2, 0, i);
        byte[] O000000o3 = O000000o(bArr, 0, i2 - 1);
        return O00000o0(O000000o2, O000000o2.length).equals(O00000o0(O000000o3, O000000o3.length));
    }

    public static byte[] O00000Oo(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i & 65280) >> 8)};
    }

    public static byte[] O00000o0(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i & 65280) >> 8)};
    }
}
