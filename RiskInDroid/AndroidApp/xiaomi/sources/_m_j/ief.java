package _m_j;

import com.xiaomi.zxing.ChecksumException;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.common.reedsolomon.ReedSolomonException;
import com.xiaomi.zxing.datamatrix.decoder.DecodedBitStreamParser;

public final class ief {

    /* renamed from: O000000o  reason: collision with root package name */
    private final iea f1230O000000o = new iea(idy.O00000oo);

    public final ido O000000o(idm idm) throws FormatException, ChecksumException {
        ied ied = new ied(idm);
        iee[] O000000o2 = iee.O000000o(ied.O000000o(), ied.f1228O000000o);
        int length = O000000o2.length;
        int i = 0;
        for (iee iee : O000000o2) {
            i += iee.f1229O000000o;
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < length; i2++) {
            iee iee2 = O000000o2[i2];
            byte[] bArr2 = iee2.O00000Oo;
            int i3 = iee2.f1229O000000o;
            O000000o(bArr2, i3);
            for (int i4 = 0; i4 < i3; i4++) {
                bArr[(i4 * length) + i2] = bArr2[i4];
            }
        }
        return DecodedBitStreamParser.O000000o(bArr);
    }

    private void O000000o(byte[] bArr, int i) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f1230O000000o.O000000o(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }
}
