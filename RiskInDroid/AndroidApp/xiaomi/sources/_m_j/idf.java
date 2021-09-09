package _m_j;

import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

public final class idf {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f1208O000000o;
    public final byte[] O00000Oo;
    public final BarcodeFormat O00000o;
    public idg[] O00000o0;
    public Map<ResultMetadataType, Object> O00000oO;
    private final long O00000oo;

    public idf(String str, byte[] bArr, idg[] idgArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, idgArr, barcodeFormat, System.currentTimeMillis());
    }

    private idf(String str, byte[] bArr, idg[] idgArr, BarcodeFormat barcodeFormat, long j) {
        this.f1208O000000o = str;
        this.O00000Oo = bArr;
        this.O00000o0 = idgArr;
        this.O00000o = barcodeFormat;
        this.O00000oO = null;
        this.O00000oo = j;
    }

    public final void O000000o(ResultMetadataType resultMetadataType, Object obj) {
        if (this.O00000oO == null) {
            this.O00000oO = new EnumMap(ResultMetadataType.class);
        }
        this.O00000oO.put(resultMetadataType, obj);
    }

    public final void O000000o(Map<ResultMetadataType, Object> map) {
        if (map != null) {
            Map<ResultMetadataType, Object> map2 = this.O00000oO;
            if (map2 == null) {
                this.O00000oO = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public final String toString() {
        return this.f1208O000000o;
    }
}
