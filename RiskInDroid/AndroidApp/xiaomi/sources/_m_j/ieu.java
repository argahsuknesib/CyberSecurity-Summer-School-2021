package _m_j;

import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.NotFoundException;
import com.xiaomi.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class ieu extends iev {

    /* renamed from: O000000o  reason: collision with root package name */
    private final ifa[] f1247O000000o;

    public ieu(Map<DecodeHintType, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        }
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new iep());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new iew());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new ieq());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new ifb());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new iep());
            arrayList.add(new ieq());
            arrayList.add(new ifb());
        }
        this.f1247O000000o = (ifa[]) arrayList.toArray(new ifa[arrayList.size()]);
    }

    public final idf O000000o(int i, idl idl, Map<DecodeHintType, ?> map) throws NotFoundException {
        Collection collection;
        int[] O000000o2 = ifa.O000000o(idl);
        ifa[] ifaArr = this.f1247O000000o;
        boolean z = false;
        int i2 = 0;
        while (i2 < ifaArr.length) {
            try {
                idf O000000o3 = ifaArr[i2].O000000o(i, idl, O000000o2, map);
                boolean z2 = O000000o3.O00000o == BarcodeFormat.EAN_13 && O000000o3.f1208O000000o.charAt(0) == '0';
                if (map == null) {
                    collection = null;
                } else {
                    collection = (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
                }
                if (collection == null || collection.contains(BarcodeFormat.UPC_A)) {
                    z = true;
                }
                if (!z2 || !z) {
                    return O000000o3;
                }
                idf idf = new idf(O000000o3.f1208O000000o.substring(1), O000000o3.O00000Oo, O000000o3.O00000o0, BarcodeFormat.UPC_A);
                idf.O000000o(O000000o3.O00000oO);
                return idf;
            } catch (ReaderException unused) {
                i2++;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final void O000000o() {
        for (ifa O000000o2 : this.f1247O000000o) {
            O000000o2.O000000o();
        }
    }
}
