package _m_j;

public final class bnd {
    public static boolean O000000o(String str) {
        if (str == null) {
            return true;
        }
        return str.isEmpty();
    }

    private static byte[] O000000o(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = (byte) (bArr[i] ^ -1);
        }
        return bArr2;
    }

    public static boolean O00000Oo(String str) {
        return !O000000o(str);
    }

    private static byte[] O00000o(String str) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) Integer.parseInt(new String(bytes, i, 2), 16);
        }
        return bArr;
    }

    public static String O00000o0(String str) {
        return new String(O000000o(O00000o(str)));
    }
}
