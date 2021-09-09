package _m_j;

import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.NotFoundException;
import com.xiaomi.zxing.ResultMetadataType;
import com.xiaomi.zxing.aztec.decoder.Decoder;
import java.util.List;
import java.util.Map;

public final class idj implements ide {
    public final void O000000o() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0059 A[LOOP:0: B:28:0x0057->B:29:0x0059, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0079  */
    public final idf O000000o(icy icy, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        idg[] idgArr;
        FormatException formatException;
        List<byte[]> list;
        String str;
        idh idh;
        idg[] idgArr2;
        idk idk = new idk(icy.O00000Oo());
        ido ido = null;
        try {
            idi O000000o2 = idk.O000000o(false);
            idgArr2 = O000000o2.O00000oO;
            try {
                idgArr = idgArr2;
                formatException = null;
                ido = new Decoder().O000000o(O000000o2);
                e = null;
            } catch (NotFoundException e) {
                e = e;
                idgArr = idgArr2;
                formatException = null;
                if (ido == null) {
                }
                while (r6 < r0) {
                }
                idf idf = new idf(ido.O00000Oo, ido.f1216O000000o, idgArr, BarcodeFormat.AZTEC);
                list = ido.O00000o0;
                if (list != null) {
                }
                str = ido.O00000o;
                if (str != null) {
                }
                return idf;
            } catch (FormatException e2) {
                e = e2;
                idgArr = idgArr2;
                formatException = e;
                e = null;
                if (ido == null) {
                }
                while (r6 < r0) {
                }
                idf idf2 = new idf(ido.O00000Oo, ido.f1216O000000o, idgArr, BarcodeFormat.AZTEC);
                list = ido.O00000o0;
                if (list != null) {
                }
                str = ido.O00000o;
                if (str != null) {
                }
                return idf2;
            }
        } catch (NotFoundException e3) {
            e = e3;
            idgArr2 = null;
            idgArr = idgArr2;
            formatException = null;
            if (ido == null) {
            }
            while (r6 < r0) {
            }
            idf idf22 = new idf(ido.O00000Oo, ido.f1216O000000o, idgArr, BarcodeFormat.AZTEC);
            list = ido.O00000o0;
            if (list != null) {
            }
            str = ido.O00000o;
            if (str != null) {
            }
            return idf22;
        } catch (FormatException e4) {
            e = e4;
            idgArr2 = null;
            idgArr = idgArr2;
            formatException = e;
            e = null;
            if (ido == null) {
            }
            while (r6 < r0) {
            }
            idf idf222 = new idf(ido.O00000Oo, ido.f1216O000000o, idgArr, BarcodeFormat.AZTEC);
            list = ido.O00000o0;
            if (list != null) {
            }
            str = ido.O00000o;
            if (str != null) {
            }
            return idf222;
        }
        if (ido == null) {
            try {
                idi O000000o3 = idk.O000000o(true);
                idgArr = O000000o3.O00000oO;
                ido = new Decoder().O000000o(O000000o3);
            } catch (FormatException | NotFoundException e5) {
                if (e != null) {
                    throw e;
                } else if (formatException != null) {
                    throw formatException;
                } else {
                    throw e5;
                }
            }
        }
        if (!(map == null || (idh = (idh) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK)) == null)) {
            for (idg O000000o4 : idgArr) {
                idh.O000000o(O000000o4);
            }
        }
        idf idf2222 = new idf(ido.O00000Oo, ido.f1216O000000o, idgArr, BarcodeFormat.AZTEC);
        list = ido.O00000o0;
        if (list != null) {
            idf2222.O000000o(ResultMetadataType.BYTE_SEGMENTS, list);
        }
        str = ido.O00000o;
        if (str != null) {
            idf2222.O000000o(ResultMetadataType.ERROR_CORRECTION_LEVEL, str);
        }
        return idf2222;
    }
}
