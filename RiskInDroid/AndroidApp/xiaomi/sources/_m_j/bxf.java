package _m_j;

import com.mitv.airkan.opus.Opus;

public final class bxf {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f13376O000000o;
    private final Opus O00000Oo = new Opus();
    private byte[] O00000o;
    private byte[] O00000o0;

    public bxf() {
        this.O00000Oo.nativeInitEncoder();
    }

    public final synchronized byte[] O000000o(byte[] bArr) {
        int i;
        if (bArr.length == 0) {
            return null;
        }
        boolean z = true;
        boolean z2 = this.f13376O000000o > 0;
        int length = bArr.length;
        int i2 = 1024;
        if (length <= 1024) {
            z = false;
        }
        if (z) {
            if (length % 1024 == 0) {
                i = length / 1024;
            } else if (length % 640 == 0) {
                i = length / 640;
                i2 = 640;
            } else {
                i = 0;
                i2 = 0;
            }
            byte[] bArr2 = new byte[i2];
            byte[] bArr3 = null;
            for (int i3 = 0; i3 < i; i3++) {
                byte[] bArr4 = new byte[i2];
                System.arraycopy(bArr, i3 * i2, bArr4, 0, i2);
                int nativeEncodeBytes = this.O00000Oo.nativeEncodeBytes(bxg.O000000o(bArr4), bArr2);
                byte[] bArr5 = new byte[nativeEncodeBytes];
                System.arraycopy(bArr2, 0, bArr5, 0, nativeEncodeBytes);
                if (z2) {
                    this.O00000o = O000000o(this.O00000o, bArr5, i2);
                } else {
                    bArr3 = O000000o(bArr3, bArr5, i2);
                }
            }
            if (!z2) {
                return bArr3;
            }
            byte[] bArr6 = this.O00000o0;
            this.O00000o0 = null;
            StringBuilder sb = new StringBuilder("Info: encode data return: ");
            sb.append(bArr6 == null ? "null" : Integer.valueOf(bArr6.length));
            bxb.O000000o(sb.toString());
            return bArr6;
        }
        byte[] bArr7 = new byte[length];
        int nativeEncodeBytes2 = this.O00000Oo.nativeEncodeBytes(bxg.O000000o(bArr), bArr7);
        byte[] bArr8 = new byte[nativeEncodeBytes2];
        System.arraycopy(bArr7, 0, bArr8, 0, nativeEncodeBytes2);
        if (z2) {
            this.O00000o = O000000o(this.O00000o, bArr8, length);
            byte[] bArr9 = this.O00000o0;
            this.O00000o0 = null;
            StringBuilder sb2 = new StringBuilder("Info: encode data return: ");
            sb2.append(bArr9 == null ? "null" : Integer.valueOf(bArr9.length));
            bxb.O000000o(sb2.toString());
            return bArr9;
        }
        return O000000o(bArr8, length);
    }

    private byte[] O000000o(byte[] bArr, byte[] bArr2, int i) {
        if (bArr == null) {
            return O000000o(bArr2, i);
        }
        int length = bArr.length;
        int length2 = bArr2.length;
        int i2 = this.f13376O000000o;
        if (i2 <= 0 || length + length2 + 4 <= i2) {
            return O00000Oo(bArr, bArr2, i);
        }
        if (this.O00000o0 == null) {
            this.O00000o0 = bArr;
            return O000000o(bArr2, i);
        }
        throw new RuntimeException("return data not null");
    }

    private static byte[] O00000Oo(byte[] bArr, byte[] bArr2, int i) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length + 4)];
        byte[] O000000o2 = bxg.O000000o((short) bArr2.length);
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(O000000o2, 0, bArr3, bArr.length, 2);
        System.arraycopy(bxg.O000000o((short) i), 0, bArr3, bArr.length + 2, 2);
        System.arraycopy(bArr2, 0, bArr3, bArr.length + 4, bArr2.length);
        return bArr3;
    }

    private byte[] O000000o(byte[] bArr, int i) {
        byte[] bArr2 = new byte[(bArr.length + 4)];
        int length = bArr.length;
        System.arraycopy(bxg.O000000o((short) length), 0, bArr2, 0, 2);
        System.arraycopy(bxg.O000000o((short) i), 0, bArr2, 2, 2);
        System.arraycopy(bArr, 0, bArr2, 4, length);
        int i2 = this.f13376O000000o;
        if (i2 <= 0 || bArr2.length <= i2) {
            return bArr2;
        }
        throw new RuntimeException("invalid max out length set");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return null;
     */
    public final synchronized byte[] O000000o() {
        if (this.O00000o != null && this.O00000o.length > 0) {
            byte[] bArr = this.O00000o;
            this.O00000o = null;
            return bArr;
        }
    }

    public final void O00000Oo() {
        this.f13376O000000o = 0;
        this.O00000o0 = null;
        this.O00000o = null;
        Opus opus = this.O00000Oo;
        if (opus != null) {
            opus.nativeRelease();
        }
    }
}
