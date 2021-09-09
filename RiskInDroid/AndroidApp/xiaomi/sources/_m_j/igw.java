package _m_j;

import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.EncodeHintType;
import com.xiaomi.zxing.WriterException;
import com.xiaomi.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Map;

public final class igw {
    public static idm O000000o(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(barcodeFormat)));
        } else if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        } else {
            ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
            int i3 = 4;
            if (map.containsKey(EncodeHintType.ERROR_CORRECTION)) {
                errorCorrectionLevel = ErrorCorrectionLevel.valueOf(map.get(EncodeHintType.ERROR_CORRECTION).toString());
            }
            if (map.containsKey(EncodeHintType.MARGIN)) {
                i3 = Integer.parseInt(map.get(EncodeHintType.MARGIN).toString());
            }
            return O000000o(ihl.O000000o(str, errorCorrectionLevel, map), i, i2, i3);
        }
    }

    private static idm O000000o(iho iho, int i, int i2, int i3) {
        ihk ihk = iho.O00000oO;
        if (ihk != null) {
            int i4 = ihk.O00000Oo;
            int i5 = ihk.O00000o0;
            int i6 = i3 * 2;
            int i7 = i4 + i6;
            int i8 = i6 + i5;
            int max = Math.max(i, i7);
            int max2 = Math.max(i2, i8);
            int min = Math.min(max / i7, max2 / i8);
            int i9 = (max - (i4 * min)) / 2;
            int i10 = (max2 - (i5 * min)) / 2;
            idm idm = new idm(max, max2);
            int i11 = 0;
            while (i11 < i5) {
                int i12 = i9;
                int i13 = 0;
                while (i13 < i4) {
                    if (ihk.O000000o(i13, i11) == 1) {
                        idm.O000000o(i12, i10, min, min);
                    }
                    i13++;
                    i12 += min;
                }
                i11++;
                i10 += min;
            }
            return idm;
        }
        throw new IllegalStateException();
    }
}
