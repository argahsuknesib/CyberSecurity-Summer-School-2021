package _m_j;

import com.xiaomi.zxing.ChecksumException;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.common.reedsolomon.ReedSolomonException;
import com.xiaomi.zxing.qrcode.decoder.DataMask;
import com.xiaomi.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Map;

public final class iha {

    /* renamed from: O000000o  reason: collision with root package name */
    private final iea f1287O000000o = new iea(idy.O00000oO);

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0015 A[Catch:{ ChecksumException | FormatException -> 0x006e }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c A[Catch:{ ChecksumException | FormatException -> 0x006e }] */
    public final ido O000000o(idm idm, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        ChecksumException checksumException;
        int i;
        igx igx = new igx(idm);
        try {
            return O000000o(igx, map);
        } catch (FormatException e) {
            e = e;
            checksumException = null;
            try {
                if (igx.O00000o0 != null) {
                    DataMask.values()[igx.O00000o0.O00000Oo].unmaskBitMatrix(igx.f1284O000000o, igx.f1284O000000o.O00000Oo);
                }
                igx.O00000Oo = null;
                igx.O00000o0 = null;
                igx.O00000o = true;
                igx.O00000Oo();
                igx.O000000o();
                i = 0;
                while (i < igx.f1284O000000o.f1214O000000o) {
                    int i2 = i + 1;
                    for (int i3 = i2; i3 < igx.f1284O000000o.O00000Oo; i3++) {
                        if (igx.f1284O000000o.O000000o(i, i3) != igx.f1284O000000o.O000000o(i3, i)) {
                            igx.f1284O000000o.O00000o0(i3, i);
                            igx.f1284O000000o.O00000o0(i, i3);
                        }
                    }
                    i = i2;
                }
                ido O000000o2 = O000000o(igx, map);
                O000000o2.O0000O0o = new ihc();
                return O000000o2;
            } catch (ChecksumException | FormatException e2) {
                if (e != null) {
                    throw e;
                } else if (checksumException != null) {
                    throw checksumException;
                } else {
                    throw e2;
                }
            }
        } catch (ChecksumException e3) {
            checksumException = e3;
            e = null;
            if (igx.O00000o0 != null) {
            }
            igx.O00000Oo = null;
            igx.O00000o0 = null;
            igx.O00000o = true;
            igx.O00000Oo();
            igx.O000000o();
            i = 0;
            while (i < igx.f1284O000000o.f1214O000000o) {
            }
            ido O000000o22 = O000000o(igx, map);
            O000000o22.O0000O0o = new ihc();
            return O000000o22;
        }
    }

    private ido O000000o(igx igx, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        ihd O00000Oo = igx.O00000Oo();
        ErrorCorrectionLevel errorCorrectionLevel = igx.O000000o().f1288O000000o;
        igy[] O000000o2 = igy.O000000o(igx.O00000o0(), O00000Oo, errorCorrectionLevel);
        int i = 0;
        for (igy igy : O000000o2) {
            i += igy.f1285O000000o;
        }
        byte[] bArr = new byte[i];
        int length = O000000o2.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            igy igy2 = O000000o2[i2];
            byte[] bArr2 = igy2.O00000Oo;
            int i4 = igy2.f1285O000000o;
            O000000o(bArr2, i4);
            int i5 = i3;
            int i6 = 0;
            while (i6 < i4) {
                bArr[i5] = bArr2[i6];
                i6++;
                i5++;
            }
            i2++;
            i3 = i5;
        }
        return igz.O000000o(bArr, O00000Oo, errorCorrectionLevel, map);
    }

    private void O000000o(byte[] bArr, int i) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f1287O000000o.O000000o(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }
}
