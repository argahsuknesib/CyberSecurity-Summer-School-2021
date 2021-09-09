package _m_j;

import java.security.InvalidKeyException;

public final class fys implements fyq {

    /* renamed from: O000000o  reason: collision with root package name */
    private final byte[] f17420O000000o;
    private final fyr O00000Oo;
    private int O00000o = 0;
    private byte[] O00000o0;

    public fys(byte[] bArr) throws InvalidKeyException {
        this.f17420O000000o = bArr;
        this.O00000Oo = new fyr();
        this.O00000Oo.O000000o(bArr);
        this.O00000o0 = new byte[8192];
    }

    public final void O000000o() {
        try {
            this.O00000Oo.O000000o(this.f17420O000000o);
            this.O00000o = 0;
        } catch (InvalidKeyException unused) {
        }
    }

    public final void O000000o(long j) {
        try {
            this.O00000Oo.O000000o(this.f17420O000000o);
            this.O00000o = 0;
            fyr fyr = this.O00000Oo;
            for (long j2 = 0; j2 < j; j2++) {
                fyr.O00000Oo = (fyr.O00000Oo + 1) & 255;
                fyr.O00000o0 = (fyr.f17419O000000o[fyr.O00000Oo] + fyr.O00000o0) & 255;
                int i = fyr.f17419O000000o[fyr.O00000Oo];
                fyr.f17419O000000o[fyr.O00000Oo] = fyr.f17419O000000o[fyr.O00000o0];
                fyr.f17419O000000o[fyr.O00000o0] = i;
            }
        } catch (InvalidKeyException unused) {
        }
    }

    public final void O00000Oo() {
        this.O00000o = 0;
    }

    public final int O00000o0() {
        return Math.max(8192 - this.O00000o, 0);
    }

    public final synchronized void O000000o(byte[] bArr, int i) {
        int i2 = this.O00000o + i;
        if (i2 > this.O00000o0.length) {
            byte[] bArr2 = this.O00000o0;
            int length = bArr2.length;
            while (true) {
                length <<= 1;
                if (i2 <= length) {
                    break;
                }
            }
            this.O00000o0 = new byte[length];
            System.arraycopy(bArr2, 0, this.O00000o0, 0, this.O00000o);
        }
        fyr fyr = this.O00000Oo;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i) {
            fyr.O00000Oo = (fyr.O00000Oo + 1) & 255;
            fyr.O00000o0 = (fyr.f17419O000000o[fyr.O00000Oo] + fyr.O00000o0) & 255;
            int i6 = fyr.f17419O000000o[fyr.O00000Oo];
            fyr.f17419O000000o[fyr.O00000Oo] = fyr.f17419O000000o[fyr.O00000o0];
            fyr.f17419O000000o[fyr.O00000o0] = i6;
            int i7 = i5 + 1;
            bArr[i4] = (byte) (bArr[i5] ^ fyr.f17419O000000o[(fyr.f17419O000000o[fyr.O00000Oo] + fyr.f17419O000000o[fyr.O00000o0]) & 255]);
            i3++;
            i4++;
            i5 = i7;
        }
        System.arraycopy(bArr, 0, this.O00000o0, this.O00000o, i);
        this.O00000o = i2;
    }

    public final synchronized int O000000o(byte[] bArr, int i, int i2) {
        if (this.O00000o <= 0) {
            return 0;
        }
        int min = Math.min(Math.min(this.O00000o, i2), bArr.length - i);
        System.arraycopy(this.O00000o0, 0, bArr, i, min);
        int i3 = this.O00000o - min;
        if (i3 > 0) {
            byte[] bArr2 = this.O00000o0;
            System.arraycopy(bArr2, min, bArr2, 0, i3);
        }
        this.O00000o = i3;
        return min;
    }

    /* access modifiers changed from: private */
    /* renamed from: O00000o */
    public fys clone() {
        try {
            return new fys(this.f17420O000000o);
        } catch (InvalidKeyException unused) {
            return null;
        }
    }
}
