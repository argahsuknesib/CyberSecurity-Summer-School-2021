package _m_j;

import java.util.Arrays;

public final class got {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final byte[] f18097O000000o = new byte[0];

    public static String O000000o(byte[] bArr) {
        return new String(bArr);
    }

    public static byte[] O000000o(byte[] bArr, int i, int i2) {
        byte[] bArr2 = null;
        if (bArr == null) {
            return null;
        }
        if (i >= 0 && i < bArr.length && i2 >= 0 && i2 < bArr.length) {
            if (i > i2) {
                return null;
            }
            bArr2 = new byte[((i2 - i) + 1)];
            for (int i3 = i; i3 <= i2; i3++) {
                bArr2[i3 - i] = bArr[i3];
            }
        }
        return bArr2;
    }

    public static boolean O000000o(byte[] bArr, byte[] bArr2) {
        int length;
        if (bArr == null && bArr2 == null) {
            return true;
        }
        if (bArr == null || bArr2 == null || (length = bArr.length) != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static String O00000Oo(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (!O00000o(bArr)) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                sb.append(String.format("%02x", Byte.valueOf(bArr[length])));
            }
        }
        return sb.toString();
    }

    public static String O00000o0(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (!O00000o(bArr)) {
            for (int i = 0; i < bArr.length; i++) {
                sb.append(String.format("%02x", Byte.valueOf(bArr[i])));
            }
        }
        return sb.toString();
    }

    public static byte[] O000000o(String str) {
        int length = str.length();
        byte[] bArr = new byte[((length + 1) / 2)];
        int i = 0;
        while (i < length) {
            try {
                bArr[i / 2] = (byte) Integer.parseInt(str.substring(i, Math.min(2, length - i) + i), 16);
                i += 2;
            } catch (Exception e) {
                e.printStackTrace();
                return f18097O000000o;
            }
        }
        return bArr;
    }

    public static boolean O00000o(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    public static boolean O00000oO(byte[] bArr) {
        int length = bArr != null ? bArr.length : 0;
        for (int i = 0; i < length; i++) {
            if ((bArr[i] & 255) != 255) {
                return false;
            }
        }
        return true;
    }

    public static byte[] O00000oo(byte[] bArr) {
        int length = bArr != null ? bArr.length : 0;
        if (length >= 20) {
            return bArr;
        }
        byte[] bArr2 = new byte[20];
        int i = 19;
        int i2 = length - 1;
        while (i >= 0) {
            if (i2 >= 0) {
                bArr2[i] = bArr[i2];
            } else {
                bArr2[i] = 0;
            }
            i--;
            i2--;
        }
        return bArr2;
    }

    public static byte[] O0000O0o(byte[] bArr) {
        if (O00000o(bArr)) {
            return bArr;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != 0) {
                return Arrays.copyOfRange(bArr, i, bArr.length);
            }
        }
        return f18097O000000o;
    }

    public static byte[] O0000OOo(byte[] bArr) {
        if (O00000o(bArr)) {
            return bArr;
        }
        for (int length = bArr.length - 1; length >= 0; length--) {
            if (bArr[length] != 0) {
                return Arrays.copyOfRange(bArr, 0, length + 1);
            }
        }
        return f18097O000000o;
    }

    public static byte[] O000000o(int i) {
        byte[] bArr = new byte[4];
        for (int i2 = 0; i2 < 4; i2++) {
            bArr[i2] = (byte) (i >>> (i2 * 8));
        }
        return bArr;
    }

    public static byte[] O000000o(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((int) (j >>> (i * 8)));
        }
        return bArr;
    }

    public static byte[] O000000o(short s) {
        return new byte[]{(byte) s, (byte) (s >>> 8)};
    }

    public static boolean O000000o(byte[] bArr, byte b) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (b2 != b) {
                return false;
            }
        }
        return true;
    }

    public static void O000000o(byte[] bArr, byte[] bArr2, int i, int i2) {
        if (bArr2 != null && i >= 0) {
            while (i2 < bArr2.length && i < bArr.length) {
                bArr[i] = bArr2[i2];
                i++;
                i2++;
            }
        }
    }

    public static boolean O00000Oo(byte[] bArr, byte[] bArr2) {
        int min = Math.min(bArr.length, bArr2.length);
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length < min || bArr2.length < min) {
            return false;
        }
        for (int i = 0; i < min; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static byte[] O0000Oo0(byte[] bArr) {
        int length = bArr.length - 4;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 4, bArr2, 0, length);
        return bArr2;
    }
}
