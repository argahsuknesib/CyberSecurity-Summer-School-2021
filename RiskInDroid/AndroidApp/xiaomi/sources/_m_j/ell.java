package _m_j;

public final class ell {

    /* renamed from: O000000o  reason: collision with root package name */
    static final char[] f15609O000000o = "0123456789ABCDEF".toCharArray();

    public static String O000000o(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder(i * 2);
        for (int i2 = 0; i2 < i; i2++) {
            byte b = bArr[i2 + 0] & 255;
            sb.append(f15609O000000o[b >> 4]);
            sb.append(f15609O000000o[b & 15]);
        }
        return sb.toString();
    }

    public static boolean O000000o() {
        return elk.O00000Oo;
    }
}
