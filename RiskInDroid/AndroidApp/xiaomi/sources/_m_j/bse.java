package _m_j;

import java.util.HashMap;
import java.util.Map;

public final class bse extends bsz {

    /* renamed from: O000000o  reason: collision with root package name */
    private byte[] f13232O000000o;
    private String O00000Oo = "1";

    public bse(byte[] bArr, String str) {
        this.f13232O000000o = (byte[]) bArr.clone();
        this.O00000Oo = str;
    }

    public final Map<String, String> O000000o() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/zip");
        hashMap.put("Content-Length", String.valueOf(this.f13232O000000o.length));
        return hashMap;
    }

    public final Map<String, String> O00000Oo() {
        return null;
    }

    public final byte[] O00000o() {
        return this.f13232O000000o;
    }

    public final String O00000o0() {
        String O00000o0 = brs.O00000o0(bsa.O00000o0);
        byte[] O000000o2 = brs.O000000o(bsa.O00000Oo);
        byte[] bArr = new byte[(O000000o2.length + 50)];
        System.arraycopy(this.f13232O000000o, 0, bArr, 0, 50);
        System.arraycopy(O000000o2, 0, bArr, 50, O000000o2.length);
        return String.format(O00000o0, "1", this.O00000Oo, "1", "open", brp.O000000o(bArr));
    }
}
