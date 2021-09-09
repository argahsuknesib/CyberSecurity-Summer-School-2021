package _m_j;

public final class idc extends ida {
    private final int O00000o;
    private final byte[] O00000o0;
    private final int O00000oO;
    private final int O00000oo;
    private final int O0000O0o;

    public idc(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.O00000o0 = bArr;
        this.O00000o = i;
        this.O00000oO = i2;
        this.O00000oo = i3;
        this.O0000O0o = i4;
        if (z) {
            O000000o(i5, i6);
        }
    }

    private void O000000o(int i, int i2) {
        byte[] bArr = this.O00000o0;
        int i3 = (this.O0000O0o * this.O00000o) + this.O00000oo;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = (i / 2) + i3;
            int i6 = (i3 + i) - 1;
            int i7 = i3;
            while (i7 < i5) {
                byte b = bArr[i7];
                bArr[i7] = bArr[i6];
                bArr[i6] = b;
                i7++;
                i6--;
            }
            i4++;
            i3 += this.O00000o;
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
        if (bArr2.length < i3 + i6) {
            return bArr2;
        }
        for (int i7 = 0; i7 < i2; i7++) {
            System.arraycopy(bArr2, i6, bArr, i7 * i, i);
            i6 += this.O00000o;
        }
        return bArr;
    }

    public final int[] O00000oO() {
        int i = this.f1206O000000o / 2;
        int i2 = this.O00000Oo / 2;
        int[] iArr = new int[(i * i2)];
        byte[] bArr = this.O00000o0;
        int i3 = (this.O0000O0o * this.O00000o) + this.O00000oo;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 * i;
            for (int i6 = 0; i6 < i; i6++) {
                iArr[i5 + i6] = ((bArr[(i6 * 2) + i3] & 255) * 65793) | -16777216;
            }
            i3 += this.O00000o * 2;
        }
        return iArr;
    }
}
