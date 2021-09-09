package _m_j;

import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.ChecksumException;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;
import com.xiaomi.zxing.ResultMetadataType;
import java.util.ArrayList;
import java.util.Map;

public final class igf implements ide {
    public final void O000000o() {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.igt.O000000o(_m_j.icy, boolean):_m_j.igu
     arg types: [_m_j.icy, int]
     candidates:
      _m_j.igt.O000000o(int[], int[]):float
      _m_j.igt.O000000o(boolean, _m_j.idm):java.util.List<_m_j.idg[]>
      _m_j.igt.O000000o(_m_j.icy, boolean):_m_j.igu */
    public final idf O000000o(icy icy, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException, ChecksumException {
        ArrayList arrayList = new ArrayList();
        igu O000000o2 = igt.O000000o(icy, false);
        for (idg[] next : O000000o2.O00000Oo) {
            ido O000000o3 = igp.O000000o(O000000o2.f1282O000000o, next[4], next[5], next[6], next[7], Math.min(Math.min(O00000Oo(next[0], next[4]), (O00000Oo(next[6], next[2]) * 17) / 18), Math.min(O00000Oo(next[1], next[5]), (O00000Oo(next[7], next[3]) * 17) / 18)), Math.max(Math.max(O000000o(next[0], next[4]), (O000000o(next[6], next[2]) * 17) / 18), Math.max(O000000o(next[1], next[5]), (O000000o(next[7], next[3]) * 17) / 18)));
            idf idf = new idf(O000000o3.O00000Oo, O000000o3.f1216O000000o, next, BarcodeFormat.PDF_417);
            idf.O000000o(ResultMetadataType.ERROR_CORRECTION_LEVEL, O000000o3.O00000o);
            igg igg = (igg) O000000o3.O0000O0o;
            if (igg != null) {
                idf.O000000o(ResultMetadataType.PDF417_EXTRA_METADATA, igg);
            }
            arrayList.add(idf);
        }
        idf[] idfArr = (idf[]) arrayList.toArray(new idf[arrayList.size()]);
        if (idfArr != null && idfArr.length != 0 && idfArr[0] != null) {
            return idfArr[0];
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int O000000o(idg idg, idg idg2) {
        if (idg == null || idg2 == null) {
            return 0;
        }
        return (int) Math.abs(idg.f1209O000000o - idg2.f1209O000000o);
    }

    private static int O00000Oo(idg idg, idg idg2) {
        if (idg == null || idg2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(idg.f1209O000000o - idg2.f1209O000000o);
    }
}
