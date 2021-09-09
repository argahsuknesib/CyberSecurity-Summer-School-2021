package _m_j;

import java.util.Map;

public final class bxn implements bxl {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f13381O000000o;
    public Map<String, String> O00000Oo;

    public final String O000000o(String str) {
        Map<String, String> map = this.O00000Oo;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return this.O00000Oo.get(str);
    }

    public final String O000000o() {
        return this.f13381O000000o;
    }

    public final String toString() {
        return "JsonRequestData{mAction='" + this.f13381O000000o + '\'' + ", mParams=" + this.O00000Oo + '}';
    }
}
