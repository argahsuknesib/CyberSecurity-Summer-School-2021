package _m_j;

import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.NotFoundException;
import com.xiaomi.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class iet extends iev {

    /* renamed from: O000000o  reason: collision with root package name */
    private final iev[] f1246O000000o;

    public iet(Map<DecodeHintType, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        }
        boolean z = (map == null || map.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new ieu(map));
            }
            if (collection.contains(BarcodeFormat.CODE_39)) {
                arrayList.add(new ien(z));
            }
            if (collection.contains(BarcodeFormat.CODE_93)) {
                arrayList.add(new ieo());
            }
            if (collection.contains(BarcodeFormat.CODE_128)) {
                arrayList.add(new iem());
            }
            if (collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new ies());
            }
            if (collection.contains(BarcodeFormat.CODABAR)) {
                arrayList.add(new iel());
            }
            if (collection.contains(BarcodeFormat.RSS_14)) {
                arrayList.add(new ifg());
            }
            if (collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                arrayList.add(new ifl());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new ieu(map));
            arrayList.add(new ien());
            arrayList.add(new iel());
            arrayList.add(new ieo());
            arrayList.add(new iem());
            arrayList.add(new ies());
            arrayList.add(new ifg());
            arrayList.add(new ifl());
        }
        this.f1246O000000o = (iev[]) arrayList.toArray(new iev[arrayList.size()]);
    }

    public final idf O000000o(int i, idl idl, Map<DecodeHintType, ?> map) throws NotFoundException {
        iev[] ievArr = this.f1246O000000o;
        int i2 = 0;
        while (i2 < ievArr.length) {
            try {
                return ievArr[i2].O000000o(i, idl, map);
            } catch (ReaderException unused) {
                i2++;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final void O000000o() {
        for (iev O000000o2 : this.f1246O000000o) {
            O000000o2.O000000o();
        }
    }
}
