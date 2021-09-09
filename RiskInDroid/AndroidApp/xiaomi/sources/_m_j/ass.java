package _m_j;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public final class ass {

    /* renamed from: O000000o  reason: collision with root package name */
    final asq f12573O000000o;

    public ass(asq asq) {
        this.f12573O000000o = asq;
    }

    /* access modifiers changed from: package-private */
    public ajv O000000o(O000000o o000000o) throws IllegalArgumentException {
        if (o000000o.hasMoreTokens()) {
            Class<?> O000000o2 = O000000o(o000000o.nextToken(), o000000o);
            if (o000000o.hasMoreTokens()) {
                String nextToken = o000000o.nextToken();
                if ("<".equals(nextToken)) {
                    return this.f12573O000000o.O000000o(O000000o2, O00000Oo(o000000o));
                }
                o000000o.O000000o(nextToken);
            }
            return this.f12573O000000o.O00000Oo(O000000o2);
        }
        throw O000000o(o000000o, "Unexpected end-of-string");
    }

    private List<ajv> O00000Oo(O000000o o000000o) throws IllegalArgumentException {
        ArrayList arrayList = new ArrayList();
        while (o000000o.hasMoreTokens()) {
            arrayList.add(O000000o(o000000o));
            if (!o000000o.hasMoreTokens()) {
                break;
            }
            String nextToken = o000000o.nextToken();
            if (">".equals(nextToken)) {
                return arrayList;
            }
            if (!",".equals(nextToken)) {
                throw O000000o(o000000o, "Unexpected token '" + nextToken + "', expected ',' or '>')");
            }
        }
        throw O000000o(o000000o, "Unexpected end-of-string");
    }

    private static Class<?> O000000o(String str, O000000o o000000o) {
        try {
            return asw.O000000o(str);
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                throw ((RuntimeException) e);
            }
            throw O000000o(o000000o, "Can not locate class '" + str + "', problem: " + e.getMessage());
        }
    }

    static IllegalArgumentException O000000o(O000000o o000000o, String str) {
        return new IllegalArgumentException("Failed to parse type '" + o000000o.O000000o() + "' (remaining: '" + o000000o.O00000Oo() + "'): " + str);
    }

    static final class O000000o extends StringTokenizer {

        /* renamed from: O000000o  reason: collision with root package name */
        protected final String f12574O000000o;
        protected int O00000Oo;
        protected String O00000o0;

        public O000000o(String str) {
            super(str, "<,>", true);
            this.f12574O000000o = str;
        }

        public final boolean hasMoreTokens() {
            return this.O00000o0 != null || super.hasMoreTokens();
        }

        public final String nextToken() {
            String str = this.O00000o0;
            if (str != null) {
                this.O00000o0 = null;
            } else {
                str = super.nextToken();
            }
            this.O00000Oo += str.length();
            return str;
        }

        public final void O000000o(String str) {
            this.O00000o0 = str;
            this.O00000Oo -= str.length();
        }

        public final String O000000o() {
            return this.f12574O000000o;
        }

        public final String O00000Oo() {
            return this.f12574O000000o.substring(this.O00000Oo);
        }
    }
}
