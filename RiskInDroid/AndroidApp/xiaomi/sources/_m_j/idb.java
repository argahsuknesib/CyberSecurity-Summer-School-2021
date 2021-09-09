package _m_j;

import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.DecodeHintType;
import com.xiaomi.zxing.NotFoundException;
import com.xiaomi.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class idb implements ide {

    /* renamed from: O000000o  reason: collision with root package name */
    private Map<DecodeHintType, ?> f1207O000000o;
    private ide[] O00000Oo;

    public final idf O000000o(icy icy, Map<DecodeHintType, ?> map) throws NotFoundException {
        O000000o(map);
        return O00000Oo(icy);
    }

    public final idf O000000o(icy icy) throws NotFoundException {
        if (this.O00000Oo == null) {
            O000000o((Map<DecodeHintType, ?>) null);
        }
        return O00000Oo(icy);
    }

    public final void O000000o(Map<DecodeHintType, ?> map) {
        Collection collection;
        this.f1207O000000o = map;
        boolean z = true;
        boolean z2 = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        }
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (!collection.contains(BarcodeFormat.UPC_A) && !collection.contains(BarcodeFormat.UPC_E) && !collection.contains(BarcodeFormat.EAN_13) && !collection.contains(BarcodeFormat.EAN_8) && !collection.contains(BarcodeFormat.CODABAR) && !collection.contains(BarcodeFormat.CODE_39) && !collection.contains(BarcodeFormat.CODE_93) && !collection.contains(BarcodeFormat.CODE_128) && !collection.contains(BarcodeFormat.ITF) && !collection.contains(BarcodeFormat.RSS_14) && !collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                z = false;
            }
            if (z && !z2) {
                arrayList.add(new iet(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new igv());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new iec());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new idj());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new igf());
            }
            if (collection.contains(BarcodeFormat.MAXICODE)) {
                arrayList.add(new ieh());
            }
            if (z && z2) {
                arrayList.add(new iet(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z2) {
                arrayList.add(new iet(map));
            }
            arrayList.add(new igv());
            arrayList.add(new iec());
            arrayList.add(new idj());
            arrayList.add(new igf());
            arrayList.add(new ieh());
            if (z2) {
                arrayList.add(new iet(map));
            }
        }
        this.O00000Oo = (ide[]) arrayList.toArray(new ide[arrayList.size()]);
    }

    public final void O000000o() {
        ide[] ideArr = this.O00000Oo;
        if (ideArr != null) {
            for (ide O000000o2 : ideArr) {
                O000000o2.O000000o();
            }
        }
    }

    private idf O00000Oo(icy icy) throws NotFoundException {
        ide[] ideArr = this.O00000Oo;
        if (ideArr != null) {
            int length = ideArr.length;
            int i = 0;
            while (i < length) {
                try {
                    return ideArr[i].O000000o(icy, this.f1207O000000o);
                } catch (ReaderException unused) {
                    i++;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
