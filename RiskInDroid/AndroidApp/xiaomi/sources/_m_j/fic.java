package _m_j;

import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.bouncycastle.crypto.DataLengthException;

public final class fic implements fhw {

    /* renamed from: O000000o  reason: collision with root package name */
    private byte[] f16393O000000o;
    private byte[] O00000Oo;
    private int O00000o;
    private byte[] O00000o0;
    private fhw O00000oO = null;
    private boolean O00000oo;

    public fic(fhw fhw) {
        this.O00000oO = fhw;
        this.O00000o = fhw.O000000o();
        int i = this.O00000o;
        this.f16393O000000o = new byte[i];
        this.O00000Oo = new byte[i];
        this.O00000o0 = new byte[i];
    }

    public final void O000000o(boolean z, fhx fhx) throws IllegalArgumentException {
        boolean z2 = this.O00000oo;
        this.O00000oo = z;
        if (fhx instanceof fii) {
            fii fii = (fii) fhx;
            byte[] bArr = fii.f16399O000000o;
            if (bArr.length == this.O00000o) {
                System.arraycopy(bArr, 0, this.f16393O000000o, 0, bArr.length);
                O00000Oo();
                if (fii.O00000Oo != null) {
                    this.O00000oO.O000000o(z, fii.O00000Oo);
                } else if (z2 != z) {
                    throw new IllegalArgumentException("cannot change encrypting state without providing key.");
                }
            } else {
                throw new IllegalArgumentException("initialisation vector must be the same length as block size");
            }
        } else {
            O00000Oo();
            if (fhx != null) {
                this.O00000oO.O000000o(z, fhx);
            } else if (z2 != z) {
                throw new IllegalArgumentException("cannot change encrypting state without providing key.");
            }
        }
    }

    public final int O000000o() {
        return this.O00000oO.O000000o();
    }

    public final int O000000o(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        if (!this.O00000oo) {
            int i3 = this.O00000o;
            if (i + i3 <= bArr.length) {
                System.arraycopy(bArr, i, this.O00000o0, 0, i3);
                int O000000o2 = this.O00000oO.O000000o(bArr, i, bArr2, i2);
                for (int i4 = 0; i4 < this.O00000o; i4++) {
                    int i5 = i2 + i4;
                    bArr2[i5] = (byte) (bArr2[i5] ^ this.O00000Oo[i4]);
                }
                byte[] bArr3 = this.O00000Oo;
                this.O00000Oo = this.O00000o0;
                this.O00000o0 = bArr3;
                return O000000o2;
            }
            throw new DataLengthException("input buffer too short");
        } else if (this.O00000o + i <= bArr.length) {
            for (int i6 = 0; i6 < this.O00000o; i6++) {
                byte[] bArr4 = this.O00000Oo;
                bArr4[i6] = (byte) (bArr4[i6] ^ bArr[i + i6]);
            }
            int O000000o3 = this.O00000oO.O000000o(this.O00000Oo, 0, bArr2, i2);
            byte[] bArr5 = this.O00000Oo;
            System.arraycopy(bArr2, i2, bArr5, 0, bArr5.length);
            return O000000o3;
        } else {
            throw new DataLengthException("input buffer too short");
        }
    }

    public final void O00000Oo() {
        byte[] bArr = this.f16393O000000o;
        System.arraycopy(bArr, 0, this.O00000Oo, 0, bArr.length);
        fij.O000000o(this.O00000o0);
        this.O00000oO.O00000Oo();
    }
}
