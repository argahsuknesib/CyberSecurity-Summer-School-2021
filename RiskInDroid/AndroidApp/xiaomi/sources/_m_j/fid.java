package _m_j;

import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.bouncycastle.crypto.DataLengthException;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.bouncycastle.crypto.InvalidCipherTextException;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.bouncycastle.crypto.OutputLengthException;
import java.io.ByteArrayOutputStream;

public final class fid {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f16394O000000o;
    public byte[] O00000Oo;
    public int O00000o;
    public byte[] O00000o0;
    public fhx O00000oO;
    private fhw O00000oo;
    private int O0000O0o;
    private byte[] O0000OOo;
    private O000000o O0000Oo = new O000000o();
    private O000000o O0000Oo0 = new O000000o();

    public fid(fhw fhw) {
        this.O00000oo = fhw;
        this.O0000O0o = fhw.O000000o();
        int i = this.O0000O0o;
        this.O0000OOo = new byte[i];
        if (i != 16) {
            throw new IllegalArgumentException("cipher required with a block size of 16.");
        }
    }

    public final int O000000o(byte[] bArr, int i) throws DataLengthException, IllegalStateException {
        if (bArr.length >= i + 0) {
            this.O0000Oo.write(bArr, 0, i);
            return 0;
        }
        throw new DataLengthException("Input buffer too short");
    }

    public final int O00000Oo(byte[] bArr, int i) throws IllegalStateException, InvalidCipherTextException {
        int i2;
        int i3;
        int i4;
        int i5;
        byte[] O000000o2 = this.O0000Oo.O000000o();
        int size = this.O0000Oo.size();
        if (this.O00000oO != null) {
            int length = 15 - this.O00000Oo.length;
            if (length >= 4 || size < (1 << (length * 8))) {
                byte[] bArr2 = new byte[this.O0000O0o];
                bArr2[0] = (byte) ((length - 1) & 7);
                byte[] bArr3 = this.O00000Oo;
                System.arraycopy(bArr3, 0, bArr2, 1, bArr3.length);
                fie fie = new fie(this.O00000oo);
                fie.O000000o(this.f16394O000000o, new fii(this.O00000oO, bArr2));
                if (this.f16394O000000o) {
                    int i6 = this.O00000o + size;
                    if (bArr.length >= i6 + 0) {
                        O000000o(O000000o2, 0, size, this.O0000OOo);
                        byte[] bArr4 = new byte[this.O0000O0o];
                        fie.O000000o(this.O0000OOo, 0, bArr4, 0);
                        int i7 = 0;
                        int i8 = 0;
                        while (true) {
                            i4 = size + 0;
                            i5 = this.O0000O0o;
                            if (i7 >= i4 - i5) {
                                break;
                            }
                            fie.O000000o(O000000o2, i7, bArr, i8);
                            int i9 = this.O0000O0o;
                            i8 += i9;
                            i7 += i9;
                        }
                        byte[] bArr5 = new byte[i5];
                        int i10 = i4 - i7;
                        System.arraycopy(O000000o2, i7, bArr5, 0, i10);
                        fie.O000000o(bArr5, 0, bArr5, 0);
                        System.arraycopy(bArr5, 0, bArr, i8, i10);
                        System.arraycopy(bArr4, 0, bArr, i4, this.O00000o);
                        i2 = i6;
                    } else {
                        throw new OutputLengthException("Output buffer too short.");
                    }
                } else {
                    int i11 = this.O00000o;
                    if (size >= i11) {
                        i2 = size - i11;
                        int i12 = i2 + 0;
                        if (bArr.length >= i12) {
                            System.arraycopy(O000000o2, i12, this.O0000OOo, 0, i11);
                            byte[] bArr6 = this.O0000OOo;
                            fie.O000000o(bArr6, 0, bArr6, 0);
                            int i13 = this.O00000o;
                            while (true) {
                                byte[] bArr7 = this.O0000OOo;
                                if (i13 == bArr7.length) {
                                    break;
                                }
                                bArr7[i13] = 0;
                                i13++;
                            }
                            int i14 = 0;
                            int i15 = 0;
                            while (true) {
                                i3 = this.O0000O0o;
                                if (i14 >= i12 - i3) {
                                    break;
                                }
                                fie.O000000o(O000000o2, i14, bArr, i15);
                                int i16 = this.O0000O0o;
                                i15 += i16;
                                i14 += i16;
                            }
                            byte[] bArr8 = new byte[i3];
                            int i17 = i2 - (i14 + 0);
                            System.arraycopy(O000000o2, i14, bArr8, 0, i17);
                            fie.O000000o(bArr8, 0, bArr8, 0);
                            System.arraycopy(bArr8, 0, bArr, i15, i17);
                            byte[] bArr9 = new byte[this.O0000O0o];
                            O000000o(bArr, 0, i2, bArr9);
                            if (!fij.O000000o(this.O0000OOo, bArr9)) {
                                throw new InvalidCipherTextException("mac check in CCM failed");
                            }
                        } else {
                            throw new OutputLengthException("Output buffer too short.");
                        }
                    } else {
                        throw new InvalidCipherTextException("data too short");
                    }
                }
                O000000o();
                return i2;
            }
            throw new IllegalStateException("CCM packet too large for choice of q.");
        }
        throw new IllegalStateException("CCM cipher unitialized.");
    }

    public final void O000000o() {
        this.O00000oo.O00000Oo();
        this.O0000Oo0.reset();
        this.O0000Oo.reset();
    }

    public final int O000000o(int i) {
        int size = i + this.O0000Oo.size();
        if (this.f16394O000000o) {
            return size + this.O00000o;
        }
        int i2 = this.O00000o;
        if (size < i2) {
            return 0;
        }
        return size - i2;
    }

    private int O000000o(byte[] bArr, int i, int i2, byte[] bArr2) {
        fib fib = new fib(this.O00000oo, this.O00000o * 8);
        fib.O000000o(this.O00000oO);
        byte[] bArr3 = new byte[16];
        if (O00000o0()) {
            bArr3[0] = (byte) (bArr3[0] | 64);
        }
        int i3 = 2;
        bArr3[0] = (byte) (bArr3[0] | ((((fib.O000000o() - 2) / 2) & 7) << 3));
        byte b = bArr3[0];
        byte[] bArr4 = this.O00000Oo;
        bArr3[0] = (byte) (b | (((15 - bArr4.length) - 1) & 7));
        System.arraycopy(bArr4, 0, bArr3, 1, bArr4.length);
        int i4 = i2;
        int i5 = 1;
        while (i4 > 0) {
            bArr3[16 - i5] = (byte) (i4 & 255);
            i4 >>>= 8;
            i5++;
        }
        fib.O000000o(bArr3, 0, 16);
        if (O00000o0()) {
            int O00000Oo2 = O00000Oo();
            if (O00000Oo2 < 65280) {
                fib.O000000o((byte) (O00000Oo2 >> 8));
                fib.O000000o((byte) O00000Oo2);
            } else {
                fib.O000000o((byte) -1);
                fib.O000000o((byte) -2);
                fib.O000000o((byte) (O00000Oo2 >> 24));
                fib.O000000o((byte) (O00000Oo2 >> 16));
                fib.O000000o((byte) (O00000Oo2 >> 8));
                fib.O000000o((byte) O00000Oo2);
                i3 = 6;
            }
            byte[] bArr5 = this.O00000o0;
            if (bArr5 != null) {
                fib.O000000o(bArr5, 0, bArr5.length);
            }
            if (this.O0000Oo0.size() > 0) {
                fib.O000000o(this.O0000Oo0.O000000o(), 0, this.O0000Oo0.size());
            }
            int i6 = (i3 + O00000Oo2) % 16;
            if (i6 != 0) {
                while (i6 != 16) {
                    fib.O000000o((byte) 0);
                    i6++;
                }
            }
        }
        fib.O000000o(bArr, i, i2);
        return fib.O000000o(bArr2);
    }

    private int O00000Oo() {
        int size = this.O0000Oo0.size();
        byte[] bArr = this.O00000o0;
        return size + (bArr == null ? 0 : bArr.length);
    }

    private boolean O00000o0() {
        return O00000Oo() > 0;
    }

    class O000000o extends ByteArrayOutputStream {
        public O000000o() {
        }

        public final byte[] O000000o() {
            return this.buf;
        }
    }
}
