package _m_j;

import _m_j.jpi;
import ss.q;

public final class jri {

    /* renamed from: O000000o  reason: collision with root package name */
    public final q f2095O000000o;
    public final String O00000Oo;
    public final jrj O00000o;
    public final jpi O00000o0;
    final Object O00000oO;
    private volatile jox O00000oo;

    /* synthetic */ jri(O000000o o000000o, byte b) {
        this(o000000o);
    }

    public final O000000o O000000o() {
        return new O000000o(this, (byte) 0);
    }

    public final String O000000o(String str) {
        return this.O00000o0.O000000o(str);
    }

    public final jox O00000Oo() {
        jox jox = this.O00000oo;
        if (jox != null) {
            return jox;
        }
        jox O000000o2 = jox.O000000o(this.O00000o0);
        this.O00000oo = O000000o2;
        return O000000o2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.O00000Oo);
        sb.append(", url=");
        sb.append(this.f2095O000000o);
        sb.append(", tag=");
        Object obj = this.O00000oO;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        q f2096O000000o;
        String O00000Oo;
        jrj O00000o;
        jpi.O000000o O00000o0;
        Object O00000oO;

        public O000000o() {
            this.O00000Oo = "GET";
            this.O00000o0 = new jpi.O000000o();
        }

        /* synthetic */ O000000o(jri jri, byte b) {
            this(jri);
        }

        public final O000000o O000000o(String str) {
            this.O00000o0.O000000o(str);
            return this;
        }

        public final O000000o O000000o(String str, jrj jrj) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (jrj != null && !jpz.O00000Oo(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (jrj != null || !jpz.O000000o(str)) {
                this.O00000Oo = str;
                this.O00000o = jrj;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public final O000000o O000000o(String str, String str2) {
            this.O00000o0.O00000o0(str, str2);
            return this;
        }

        public final O000000o O000000o(q qVar) {
            if (qVar != null) {
                this.f2096O000000o = qVar;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public final jri O000000o() {
            if (this.f2096O000000o != null) {
                return new jri(this, (byte) 0);
            }
            throw new IllegalStateException("url == null");
        }

        private O000000o(jri jri) {
            this.f2096O000000o = jri.f2095O000000o;
            this.O00000Oo = jri.O00000Oo;
            this.O00000o = jri.O00000o;
            this.O00000oO = jri.O00000oO;
            this.O00000o0 = jri.O00000o0.O000000o();
        }
    }

    private jri(O000000o o000000o) {
        this.f2095O000000o = o000000o.f2096O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0.O000000o();
        this.O00000o = o000000o.O00000o;
        this.O00000oO = o000000o.O00000oO != null ? o000000o.O00000oO : this;
    }
}
