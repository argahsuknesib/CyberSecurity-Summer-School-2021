package _m_j;

import java.util.Map;

public final class bxo implements bxl {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f13382O000000o;
    private String O00000Oo;
    private Map<String, String> O00000o;
    private String O00000o0;

    public final String O000000o(String str) {
        Map<String, String> map = this.O00000o;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return this.O00000o.get(str);
    }

    public static bxo O000000o(bxh bxh) {
        int i;
        bxo bxo = new bxo();
        bxo.O00000o0 = bxj.O00000o(bxh.O000000o("action"));
        bxo.O00000o = bxh.O00000o0("params");
        try {
            i = Integer.parseInt(bxo.O000000o("code"));
        } catch (Exception unused) {
            i = -1;
        }
        bxo.f13382O000000o = i;
        bxo.O00000Oo = bxo.O000000o("msg");
        return bxo;
    }

    public final String O000000o() {
        return this.O00000o0;
    }

    public final String toString() {
        return "JsonResponseData{mCode=" + this.f13382O000000o + ", mMsg='" + this.O00000Oo + '\'' + ", mAction='" + this.O00000o0 + '\'' + ", mParams=" + this.O00000o + '}';
    }
}
