package _m_j;

import com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth.bouncycastle.crypto.DataLengthException;

public abstract class fhz implements fhw {

    /* renamed from: O000000o  reason: collision with root package name */
    private final fhw f16390O000000o;

    /* access modifiers changed from: protected */
    public abstract byte O000000o(byte b);

    protected fhz(fhw fhw) {
        this.f16390O000000o = fhw;
    }

    public final int O000000o(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
        if (i3 + i2 <= bArr2.length) {
            int i4 = i + i2;
            if (i4 <= bArr.length) {
                while (i < i4) {
                    bArr2[i3] = O000000o(bArr[i]);
                    i3++;
                    i++;
                }
                return i2;
            }
            throw new DataLengthException("input buffer too small");
        }
        throw new DataLengthException("output buffer too short");
    }
}
