package _m_j;

public final class idn {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f1215O000000o;
    public int O00000Oo;
    private final byte[] O00000o0;

    public idn(byte[] bArr) {
        this.O00000o0 = bArr;
    }

    public final int O000000o(int i) {
        byte b;
        if (i <= 0 || i > 32 || i > O000000o()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2 = this.O00000Oo;
        if (i2 > 0) {
            int i3 = 8 - i2;
            int i4 = i < i3 ? i : i3;
            int i5 = i3 - i4;
            byte[] bArr = this.O00000o0;
            int i6 = this.f1215O000000o;
            b = (((255 >> (8 - i4)) << i5) & bArr[i6]) >> i5;
            i -= i4;
            this.O00000Oo += i4;
            if (this.O00000Oo == 8) {
                this.O00000Oo = 0;
                this.f1215O000000o = i6 + 1;
            }
        } else {
            b = 0;
        }
        if (i <= 0) {
            return b;
        }
        while (i >= 8) {
            byte[] bArr2 = this.O00000o0;
            int i7 = this.f1215O000000o;
            b = (b << 8) | (bArr2[i7] & 255);
            this.f1215O000000o = i7 + 1;
            i -= 8;
        }
        if (i <= 0) {
            return b;
        }
        int i8 = 8 - i;
        int i9 = (b << i) | ((((255 >> i8) << i8) & this.O00000o0[this.f1215O000000o]) >> i8);
        this.O00000Oo += i;
        return i9;
    }

    public final int O000000o() {
        return ((this.O00000o0.length - this.f1215O000000o) * 8) - this.O00000Oo;
    }
}
