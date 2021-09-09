package _m_j;

public final class idd extends ida {
    private final int O00000o;
    private final byte[] O00000o0;
    private final int O00000oO;
    private final int O00000oo = 0;
    private final int O0000O0o = 0;

    public idd(int i, int i2, int[] iArr) {
        super(i, i2);
        this.O00000o = i;
        this.O00000oO = i2;
        int i3 = i * i2;
        this.O00000o0 = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            this.O00000o0[i4] = (byte) (((((i5 >> 16) & 255) + ((i5 >> 7) & 510)) + (i5 & 255)) / 4);
        }
    }

    public final byte[] O000000o(int i, byte[] bArr) {
        if (i < 0 || i >= this.O00000Oo) {
            throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i)));
        }
        int i2 = this.f1206O000000o;
        if (bArr == null || bArr.length < i2) {
            bArr = new byte[i2];
        }
        System.arraycopy(this.O00000o0, ((i + this.O0000O0o) * this.O00000o) + this.O00000oo, bArr, 0, i2);
        return bArr;
    }

    public final byte[] O000000o() {
        int i = this.f1206O000000o;
        int i2 = this.O00000Oo;
        if (i == this.O00000o && i2 == this.O00000oO) {
            return this.O00000o0;
        }
        int i3 = i * i2;
        byte[] bArr = new byte[i3];
        int i4 = this.O0000O0o;
        int i5 = this.O00000o;
        int i6 = (i4 * i5) + this.O00000oo;
        if (i == i5) {
            System.arraycopy(this.O00000o0, i6, bArr, 0, i3);
            return bArr;
        }
        byte[] bArr2 = this.O00000o0;
        for (int i7 = 0; i7 < i2; i7++) {
            System.arraycopy(bArr2, i6, bArr, i7 * i, i);
            i6 += this.O00000o;
        }
        return bArr;
    }
}
