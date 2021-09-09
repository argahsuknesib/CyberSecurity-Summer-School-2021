package _m_j;

import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.bouncycastle.crypto.DataLengthException;

public final class fie extends fhz {

    /* renamed from: O000000o  reason: collision with root package name */
    private final fhw f16396O000000o;
    private final int O00000Oo = this.f16396O000000o.O000000o();
    private byte[] O00000o;
    private byte[] O00000o0;
    private byte[] O00000oO;
    private int O00000oo;

    public fie(fhw fhw) {
        super(fhw);
        this.f16396O000000o = fhw;
        int i = this.O00000Oo;
        this.O00000o0 = new byte[i];
        this.O00000o = new byte[i];
        this.O00000oO = new byte[i];
        this.O00000oo = 0;
    }

    public final void O000000o(boolean z, fhx fhx) throws IllegalArgumentException {
        if (fhx instanceof fii) {
            fii fii = (fii) fhx;
            this.O00000o0 = fij.O00000Oo(fii.f16399O000000o);
            int i = this.O00000Oo;
            if (i >= this.O00000o0.length) {
                int i2 = 8;
                if (8 > i / 2) {
                    i2 = i / 2;
                }
                if (this.O00000Oo - this.O00000o0.length <= i2) {
                    if (fii.O00000Oo != null) {
                        this.f16396O000000o.O000000o(true, fii.O00000Oo);
                    }
                    O00000Oo();
                    return;
                }
                throw new IllegalArgumentException("CTR/SIC mode requires IV of at least: " + (this.O00000Oo - i2) + " bytes.");
            }
            throw new IllegalArgumentException("CTR/SIC mode requires IV no greater than: " + this.O00000Oo + " bytes.");
        }
        throw new IllegalArgumentException("CTR/SIC mode requires ParametersWithIV");
    }

    public final int O000000o() {
        return this.f16396O000000o.O000000o();
    }

    public final int O000000o(byte[] bArr, int i, byte[] bArr2, int i2) throws DataLengthException, IllegalStateException {
        O000000o(bArr, i, this.O00000Oo, bArr2, i2);
        return this.O00000Oo;
    }

    public final byte O000000o(byte b) throws DataLengthException, IllegalStateException {
        byte b2;
        int i = this.O00000oo;
        int i2 = 0;
        if (i == 0) {
            this.f16396O000000o.O000000o(this.O00000o, 0, this.O00000oO, 0);
            byte[] bArr = this.O00000oO;
            int i3 = this.O00000oo;
            this.O00000oo = i3 + 1;
            return (byte) (b ^ bArr[i3]);
        }
        byte[] bArr2 = this.O00000oO;
        this.O00000oo = i + 1;
        byte b3 = (byte) (b ^ bArr2[i]);
        int i4 = this.O00000oo;
        byte[] bArr3 = this.O00000o;
        if (i4 == bArr3.length) {
            this.O00000oo = 0;
            int length = bArr3.length - 0;
            do {
                length--;
                if (length < 0) {
                    break;
                }
                byte[] bArr4 = this.O00000o;
                b2 = (byte) (bArr4[length] + 1);
                bArr4[length] = b2;
            } while (b2 == 0);
            if (this.O00000o0.length < this.O00000Oo) {
                while (true) {
                    byte[] bArr5 = this.O00000o0;
                    if (i2 == bArr5.length) {
                        break;
                    } else if (this.O00000o[i2] == bArr5[i2]) {
                        i2++;
                    } else {
                        throw new IllegalStateException("Counter in CTR/SIC mode out of range.");
                    }
                }
            }
        }
        return b3;
    }

    public final void O00000Oo() {
        fij.O000000o(this.O00000o);
        byte[] bArr = this.O00000o0;
        System.arraycopy(bArr, 0, this.O00000o, 0, bArr.length);
        this.f16396O000000o.O00000Oo();
        this.O00000oo = 0;
    }
}
