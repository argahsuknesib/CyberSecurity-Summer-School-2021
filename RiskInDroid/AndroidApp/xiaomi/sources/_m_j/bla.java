package _m_j;

public final class bla {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final byte[] f13031O000000o = new byte[0];

    public static String O000000o(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (!(bArr == null || bArr.length == 0)) {
            for (int i = 0; i < bArr.length; i++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i])));
            }
        }
        return sb.toString();
    }
}
