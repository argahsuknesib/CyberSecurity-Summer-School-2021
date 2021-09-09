package _m_j;

final class gry {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f18190O000000o;
    private int O00000Oo;
    private final byte[] O00000o0 = new byte[256];

    public gry(byte[] bArr) {
        int length = bArr.length;
        for (int i = 0; i < 256; i++) {
            this.O00000o0[i] = (byte) i;
        }
        byte b = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            int i3 = b + bArr[i2 % length];
            byte[] bArr2 = this.O00000o0;
            b = (i3 + bArr2[i2]) & 255;
            byte b2 = bArr2[i2];
            bArr2[i2] = bArr2[b];
            bArr2[b] = b2;
        }
        this.f18190O000000o = 0;
        this.O00000Oo = 0;
    }

    public final void O000000o(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            this.f18190O000000o = (this.f18190O000000o + 1) & 255;
            int i2 = this.O00000Oo;
            byte[] bArr2 = this.O00000o0;
            int i3 = this.f18190O000000o;
            this.O00000Oo = (i2 + bArr2[i3]) & 255;
            byte b2 = bArr2[i3];
            int i4 = this.O00000Oo;
            bArr2[i3] = bArr2[i4];
            bArr2[i4] = b2;
            bArr[i] = (byte) (b ^ bArr2[(bArr2[i3] + bArr2[i4]) & 255]);
        }
    }
}
