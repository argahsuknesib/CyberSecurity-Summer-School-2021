package _m_j;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

public class eqp extends eqr {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f15728O000000o = O000000o.f15729O000000o;
    private final Map<String, String> O00000Oo = new HashMap();

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O000000o f15729O000000o = new O000000o("get");
        public static final O000000o O00000Oo = new O000000o("set");
        public static final O000000o O00000o = new O000000o("error");
        public static final O000000o O00000o0 = new O000000o("result");
        public static final O000000o O00000oO = new O000000o("command");
        private String O00000oo;

        private O000000o(String str) {
            this.O00000oo = str;
        }

        public static O000000o O000000o(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            if (f15729O000000o.toString().equals(lowerCase)) {
                return f15729O000000o;
            }
            if (O00000Oo.toString().equals(lowerCase)) {
                return O00000Oo;
            }
            if (O00000o.toString().equals(lowerCase)) {
                return O00000o;
            }
            if (O00000o0.toString().equals(lowerCase)) {
                return O00000o0;
            }
            if (O00000oO.toString().equals(lowerCase)) {
                return O00000oO;
            }
            return null;
        }

        public final String toString() {
            return this.O00000oo;
        }
    }

    public eqp() {
    }

    public eqp(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_iq_type")) {
            this.f15728O000000o = O000000o.O000000o(bundle.getString("ext_iq_type"));
        }
    }

    public final Bundle O000000o() {
        Bundle O000000o2 = super.O000000o();
        O000000o o000000o = this.f15728O000000o;
        if (o000000o != null) {
            O000000o2.putString("ext_iq_type", o000000o.toString());
        }
        return O000000o2;
    }

    public final void O000000o(O000000o o000000o) {
        if (o000000o == null) {
            this.f15728O000000o = O000000o.f15729O000000o;
        } else {
            this.f15728O000000o = o000000o;
        }
    }

    public final synchronized void O000000o(Map<String, String> map) {
        this.O00000Oo.putAll(map);
    }

    public final String O00000Oo() {
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (O00000o() != null) {
            sb.append("id=\"" + O00000o() + "\" ");
        }
        if (this.O0000oO0 != null) {
            sb.append("to=\"");
            sb.append(erb.O000000o(this.O0000oO0));
            sb.append("\" ");
        }
        if (this.O0000oO != null) {
            sb.append("from=\"");
            sb.append(erb.O000000o(this.O0000oO));
            sb.append("\" ");
        }
        if (this.O0000oOO != null) {
            sb.append("chid=\"");
            sb.append(erb.O000000o(this.O0000oOO));
            sb.append("\" ");
        }
        for (Map.Entry next : this.O00000Oo.entrySet()) {
            sb.append(erb.O000000o((String) next.getKey()));
            sb.append("=\"");
            sb.append(erb.O000000o((String) next.getValue()));
            sb.append("\" ");
        }
        if (this.f15728O000000o == null) {
            sb.append("type=\"get\">");
        } else {
            sb.append("type=\"");
            sb.append(this.f15728O000000o);
            sb.append("\">");
        }
        sb.append(O00000oO());
        equ equ = this.O0000oo0;
        if (equ != null) {
            sb.append(equ.O00000Oo());
        }
        sb.append("</iq>");
        return sb.toString();
    }
}
