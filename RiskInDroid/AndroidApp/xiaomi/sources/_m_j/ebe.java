package _m_j;

import com.xiaomi.mipush.sdk.au;
import com.xiaomi.mipush.sdk.e;
import com.xiaomi.push.hu;
import java.util.HashMap;

public final class ebe {

    /* renamed from: O000000o  reason: collision with root package name */
    private static HashMap<e, O000000o> f15142O000000o = new HashMap<>();

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f15143O000000o;
        public String O00000Oo;

        public O000000o(String str, String str2) {
            this.f15143O000000o = str;
            this.O00000Oo = str2;
        }
    }

    static {
        O000000o(e.f6055a, new O000000o("com.xiaomi.assemble.control.HmsPushManager", "newInstance"));
        O000000o(e.b, new O000000o("com.xiaomi.assemble.control.FCMPushManager", "newInstance"));
        O000000o(e.c, new O000000o("com.xiaomi.assemble.control.COSPushManager", "newInstance"));
        O000000o(e.d, new O000000o("com.xiaomi.assemble.control.FTOSPushManager", "newInstance"));
    }

    public static O000000o O000000o(e eVar) {
        return f15142O000000o.get(eVar);
    }

    public static hu O000000o() {
        return hu.ao;
    }

    private static void O000000o(e eVar, O000000o o000000o) {
        f15142O000000o.put(eVar, o000000o);
    }

    public static au O00000Oo(e eVar) {
        int i = ebf.f15144O000000o[eVar.ordinal()];
        if (i == 1) {
            return au.c;
        }
        if (i == 2) {
            return au.d;
        }
        if (i == 3) {
            return au.e;
        }
        if (i != 4) {
            return null;
        }
        return au.f;
    }
}
