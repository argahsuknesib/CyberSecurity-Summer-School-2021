package _m_j;

import android.content.Context;
import android.util.Log;
import com.amap.location.security.Core;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;

public final class rq {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f2441O000000o;
    private pg O00000Oo;
    private rt O00000o = new rt();
    private pf O00000o0;
    private rk O00000oO;
    private boolean O00000oo;
    private O000000o O0000O0o;

    interface O000000o {
        void O000000o();
    }

    public rq(Context context, pg pgVar, pf pfVar, O000000o o000000o) {
        this.f2441O000000o = context;
        this.O00000Oo = pgVar;
        this.O00000o0 = pfVar;
        this.O0000O0o = o000000o;
    }

    private static rx O000000o(ow owVar) {
        try {
            List list = owVar.O00000Oo.get("Content-Encoding");
            String str = (list == null || list.size() <= 0) ? null : (String) list.get(0);
            byte[] bArr = owVar.O00000o0;
            if (bArr != null && bArr.length > 0) {
                if ("gzip".equals(str)) {
                    bArr = pc.O00000Oo(bArr);
                }
                return rx.O000000o(ByteBuffer.wrap(bArr));
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private void O000000o(rr rrVar) {
        this.O00000oo = false;
        if (rrVar != null) {
            if (rrVar.f2442O000000o == 1) {
                sc.O00000oO(this.f2441O000000o);
                return;
            }
            O000000o o000000o = this.O0000O0o;
            if (o000000o != null) {
                o000000o.O000000o();
            }
        }
    }

    private void O000000o(rr rrVar, ow owVar) {
        O000000o o000000o;
        if (owVar == null) {
            om.O00000Oo("@_18_6_@", "@_18_6_12_@");
            O000000o(rrVar);
            return;
        }
        String str = null;
        List list = owVar.O00000Oo.get("code");
        if (list != null) {
            str = (String) list.get(list.size() - 1);
        }
        om.O00000Oo("@_18_6_@", "@_18_6_13_@".concat(String.valueOf(str)));
        if (rrVar == null) {
            this.O00000oo = false;
            om.O00000Oo("@_18_6_@", "@_18_6_11_@");
        } else if (!"260".equals(str)) {
            O000000o(rrVar);
        } else {
            if (rrVar.f2442O000000o == 1) {
                sc.O00000oO(this.f2441O000000o);
                if (rrVar.O00000Oo == 0) {
                    sc.O00000oo(this.f2441O000000o);
                }
            }
            if (rrVar.f2442O000000o == 0) {
                sc.O00000o(this.f2441O000000o);
            }
            boolean O00000Oo2 = O00000Oo(rrVar, owVar);
            this.O00000oo = false;
            if ((O00000Oo2 || rrVar.f2442O000000o == 0) && (o000000o = this.O0000O0o) != null) {
                o000000o.O000000o();
            }
        }
    }

    private rr O00000Oo(byte b, int i) throws Exception {
        List<Long> list;
        List<String> list2;
        byte[] xxt;
        byte[] O000000o2;
        byte b2 = b;
        if (this.O00000oO == null) {
            this.O00000oO = rk.O000000o(this.f2441O000000o);
        }
        if (b2 == 1) {
            int O00000o2 = this.O00000o0.O00000o();
            int O0000Oo0 = this.O00000o0.O0000Oo0();
            List<Long> O00000Oo2 = this.O00000oO.O00000Oo(O00000o2, O0000Oo0);
            int size = O00000Oo2.size();
            List<String> O000000o3 = this.O00000oO.O000000o(O00000o2, size < O0000Oo0 ? O0000Oo0 - size : (O0000Oo0 * 2) / 10);
            int size2 = O000000o3.size();
            if (size2 > 0 && size == O0000Oo0) {
                O00000Oo2 = O00000Oo2.subList(0, O0000Oo0 - size2);
            }
            if (O00000Oo2.size() + O000000o3.size() < 5) {
                om.O00000Oo("@_18_6_@", "@_18_6_6_@");
                return null;
            }
            om.O00000Oo("@_18_6_@", "@_18_6_7_@(" + O000000o3.size() + "," + O00000Oo2.size() + ")");
            list2 = O000000o3;
            list = O00000Oo2;
        } else {
            om.O00000Oo("@_18_6_@", "@_18_6_8_@");
            list2 = null;
            list = null;
        }
        rr rrVar = new rr(b2, list, list2);
        rrVar.O00000Oo = i;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Content-Type", "application/octet-stream");
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put("gzipped", "1");
        hashMap.put("v", "1.4.0");
        hashMap.put("et", "110");
        rrVar.O00000oO = hashMap;
        rr rrVar2 = rrVar;
        byte[] O000000o4 = this.O00000o.O000000o(b, "1.4.0", this.O00000Oo.O00000Oo, this.O00000Oo.O00000o0, this.O00000Oo.O00000o, (byte) ol.O00000oO(), this.O00000Oo.O00000oo, this.O00000Oo.O0000O0o, this.O00000Oo.O0000OOo, ol.O000000o(), ol.O00000o(this.f2441O000000o), ol.O00000o(), ol.O00000o0(), this.O00000Oo.O0000Oo0, this.O00000Oo.O0000Oo, list, list2);
        if (O000000o4 == null || (xxt = Core.xxt(O000000o4, 1)) == null || xxt.length == 0 || (O000000o2 = pc.O000000o(xxt)) == null || O000000o2.length == 0) {
            return null;
        }
        rr rrVar3 = rrVar2;
        rrVar3.O00000oo = O000000o2;
        return rrVar3;
    }

    private boolean O00000Oo(rr rrVar, ow owVar) {
        rx O000000o2 = O000000o(owVar);
        if (O000000o2 == null) {
            om.O00000Oo("@_18_6_@", "@_18_6_10_@");
            return false;
        }
        if (this.O00000oO == null) {
            this.O00000oO = rk.O000000o(this.f2441O000000o);
        }
        if (rrVar.f2442O000000o == 0) {
            this.O00000oO.O000000o(O000000o2);
            return true;
        }
        this.O00000oO.O000000o(O000000o2, rrVar.O00000o0, rrVar.O00000o);
        return true;
    }

    public final void O000000o(byte b, int i) {
        this.O00000oo = true;
        try {
            rr O00000Oo2 = O00000Oo(b, i);
            if (O00000Oo2 == null || this.O00000Oo.O0000o0 == null) {
                this.O00000oo = false;
                return;
            }
            ov ovVar = new ov();
            ovVar.f2376O000000o = pg.f2381O000000o ? "http://aps.testing.amap.com/LoadOfflineData/repeatData" : "http://offline.aps.amap.com/LoadOfflineData/repeatData";
            ovVar.O00000Oo = O00000Oo2.O00000oO;
            ovVar.O00000o0 = O00000Oo2.O00000oo;
            O000000o(O00000Oo2, this.O00000Oo.O0000o0.O000000o(ovVar));
        } catch (Throwable th) {
            this.O00000oo = false;
            om.O00000Oo("@_18_6_@", "@_18_6_2_@" + Log.getStackTraceString(th));
        }
    }

    public final boolean O000000o() {
        om.O00000Oo("@_18_6_@", "@_18_6_5_@" + this.O00000oo);
        return this.O00000oo;
    }
}
