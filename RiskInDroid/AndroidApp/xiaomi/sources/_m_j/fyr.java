package _m_j;

import java.security.InvalidKeyException;

public final class fyr {

    /* renamed from: O000000o  reason: collision with root package name */
    final int[] f17419O000000o = new int[256];
    int O00000Oo;
    int O00000o0;

    public final void O000000o(byte[] bArr) throws InvalidKeyException {
        if (bArr != null) {
            int length = bArr.length;
            if (length != 0) {
                this.O00000Oo = 0;
                this.O00000o0 = 0;
                for (int i = 0; i < 256; i++) {
                    this.f17419O000000o[i] = i;
                }
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < 256; i4++) {
                    int[] iArr = this.f17419O000000o;
                    i3 = ((bArr[i2] & 255) + iArr[i4] + i3) & 255;
                    int i5 = iArr[i4];
                    iArr[i4] = iArr[i3];
                    iArr[i3] = i5;
                    i2 = (i2 + 1) % length;
                }
                return;
            }
            throw new InvalidKeyException("Invalid user key length");
        }
        throw new InvalidKeyException("Null user key");
    }
}
