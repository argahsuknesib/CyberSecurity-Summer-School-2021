package _m_j;

public final class fku {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final char[] f16553O000000o = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String O000000o(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(f16553O000000o[(b & 240) >>> 4]);
            sb.append(f16553O000000o[b & 15]);
        }
        return sb.toString();
    }

    public static byte[] O000000o(String str) {
        if (str == null || str.trim().equals("")) {
            return new byte[0];
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(str.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }
}
