package _m_j;

public final class dwx {
    public static byte[] O000000o(short s) {
        return new byte[]{(byte) (s >>> 8), (byte) (s & 255)};
    }

    public static short O000000o(byte[] bArr, int i) {
        if (bArr == null || bArr.length < i + 2) {
            return 0;
        }
        return (short) ((bArr[i + 1] & 255) | (bArr[i] << 8));
    }
}
