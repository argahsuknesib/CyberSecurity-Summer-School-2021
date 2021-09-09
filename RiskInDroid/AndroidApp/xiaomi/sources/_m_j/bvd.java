package _m_j;

public final class bvd {
    public static byte[] O000000o(int i) {
        byte[] bArr = new byte[4];
        bArr[3] = (byte) (i % 256);
        int i2 = i >> 8;
        bArr[2] = (byte) (i2 % 256);
        int i3 = i2 >> 8;
        bArr[1] = (byte) (i3 % 256);
        bArr[0] = (byte) ((i3 >> 8) % 256);
        return bArr;
    }
}
