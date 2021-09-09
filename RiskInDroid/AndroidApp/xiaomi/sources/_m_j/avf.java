package _m_j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class avf {

    /* renamed from: O000000o  reason: collision with root package name */
    public final List<ave> f12638O000000o;

    public avf() {
        this.f12638O000000o = new ArrayList();
    }

    public avf(List<ave> list) {
        this.f12638O000000o = new ArrayList(list);
    }

    public avf(Map<String, String> map) {
        this();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                this.f12638O000000o.add(new ave((String) next.getKey(), (String) next.getValue()));
            }
        }
    }

    public final void O000000o(String str, String str2) {
        this.f12638O000000o.add(new ave(str, str2));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.avt.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.avt.O000000o(java.lang.String, java.lang.String):void
      _m_j.avt.O000000o(boolean, java.lang.String):void
      _m_j.avt.O000000o(java.lang.Object, java.lang.String):void */
    public final String O000000o(String str) {
        avt.O000000o((Object) str, "Cannot append to null URL");
        String O000000o2 = O000000o();
        if (O000000o2.equals("")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.indexOf(63) == -1 ? '?' : "&");
        sb.append(O000000o2);
        return sb.toString();
    }

    public final String O000000o() {
        if (this.f12638O000000o.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (ave O000000o2 : this.f12638O000000o) {
            sb.append("&");
            sb.append(O000000o2.O000000o());
        }
        return sb.substring(1);
    }

    public final void O000000o(avf avf) {
        this.f12638O000000o.addAll(avf.f12638O000000o);
    }

    public final void O00000Oo(String str) {
        if (str != null && !str.isEmpty()) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                this.f12638O000000o.add(new ave(avs.O00000Oo(split2[0]), split2.length > 1 ? avs.O00000Oo(split2[1]) : ""));
            }
        }
    }
}
