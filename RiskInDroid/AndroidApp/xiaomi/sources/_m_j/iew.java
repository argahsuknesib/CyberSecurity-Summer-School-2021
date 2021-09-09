package _m_j;

import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.ChecksumException;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;
import java.util.Map;

public final class iew extends ifa {

    /* renamed from: O000000o  reason: collision with root package name */
    private final ifa f1248O000000o = new iep();

    public final idf O000000o(int i, idl idl, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return O000000o(this.f1248O000000o.O000000o(i, idl, iArr, map));
    }

    public final idf O000000o(int i, idl idl, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        return O000000o(this.f1248O000000o.O000000o(i, idl, map));
    }

    public final idf O000000o(icy icy, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        return O000000o(this.f1248O000000o.O000000o(icy, map));
    }

    /* access modifiers changed from: package-private */
    public final BarcodeFormat O00000Oo() {
        return BarcodeFormat.UPC_A;
    }

    /* access modifiers changed from: protected */
    public final int O000000o(idl idl, int[] iArr, StringBuilder sb) throws NotFoundException {
        return this.f1248O000000o.O000000o(idl, iArr, sb);
    }

    private static idf O000000o(idf idf) throws FormatException {
        String str = idf.f1208O000000o;
        if (str.charAt(0) == '0') {
            return new idf(str.substring(1), null, idf.O00000o0, BarcodeFormat.UPC_A);
        }
        throw FormatException.getFormatInstance();
    }
}
