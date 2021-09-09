package _m_j;

import _m_j.jpi;
import ss.u;

public final class jrk {

    /* renamed from: O000000o  reason: collision with root package name */
    public final jri f2098O000000o;
    final u O00000Oo;
    final String O00000o;
    public final int O00000o0;
    public final jph O00000oO;
    public final jpi O00000oo;
    public final jrl O0000O0o;
    jrk O0000OOo;
    final jrk O0000Oo;
    jrk O0000Oo0;
    private volatile jox O0000OoO;

    /* synthetic */ jrk(O000000o o000000o, byte b) {
        this(o000000o);
    }

    public final O000000o O000000o() {
        return new O000000o(this, (byte) 0);
    }

    public final String O000000o(String str) {
        String O000000o2 = this.O00000oo.O000000o(str);
        if (O000000o2 != null) {
            return O000000o2;
        }
        return null;
    }

    public final jox O00000Oo() {
        jox jox = this.O0000OoO;
        if (jox != null) {
            return jox;
        }
        jox O000000o2 = jox.O000000o(this.O00000oo);
        this.O0000OoO = O000000o2;
        return O000000o2;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public jri f2099O000000o;
        public u O00000Oo;
        public String O00000o;
        public int O00000o0;
        public jph O00000oO;
        jpi.O000000o O00000oo;
        public jrl O0000O0o;
        jrk O0000OOo;
        jrk O0000Oo;
        jrk O0000Oo0;

        public O000000o() {
            this.O00000o0 = -1;
            this.O00000oo = new jpi.O000000o();
        }

        /* synthetic */ O000000o(jrk jrk, byte b) {
            this(jrk);
        }

        public final O000000o O000000o(jpi jpi) {
            this.O00000oo = jpi.O000000o();
            return this;
        }

        public final O000000o O000000o(jrk jrk) {
            if (jrk != null) {
                O000000o("networkResponse", jrk);
            }
            this.O0000OOo = jrk;
            return this;
        }

        public final O000000o O000000o(String str, String str2) {
            this.O00000oo.O00000o0(str, str2);
            return this;
        }

        public final jrk O000000o() {
            if (this.f2099O000000o == null) {
                throw new IllegalStateException("request == null");
            } else if (this.O00000Oo == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.O00000o0 >= 0) {
                return new jrk(this, (byte) 0);
            } else {
                throw new IllegalStateException("code < 0: " + this.O00000o0);
            }
        }

        public final O000000o O00000Oo(jrk jrk) {
            if (jrk != null) {
                O000000o("cacheResponse", jrk);
            }
            this.O0000Oo0 = jrk;
            return this;
        }

        public final O000000o O00000Oo(String str, String str2) {
            this.O00000oo.O000000o(str, str2);
            return this;
        }

        public final O000000o O00000o0(jrk jrk) {
            if (jrk != null) {
                O00000o(jrk);
            }
            this.O0000Oo = jrk;
            return this;
        }

        private O000000o(jrk jrk) {
            this.O00000o0 = -1;
            this.f2099O000000o = jrk.f2098O000000o;
            this.O00000Oo = jrk.O00000Oo;
            this.O00000o0 = jrk.O00000o0;
            this.O00000o = jrk.O00000o;
            this.O00000oO = jrk.O00000oO;
            this.O00000oo = jrk.O00000oo.O000000o();
            this.O0000O0o = jrk.O0000O0o;
            this.O0000OOo = jrk.O0000OOo;
            this.O0000Oo0 = jrk.O0000Oo0;
            this.O0000Oo = jrk.O0000Oo;
        }

        private static void O000000o(String str, jrk jrk) {
            if (jrk.O0000O0o != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (jrk.O0000OOo != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (jrk.O0000Oo0 != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (jrk.O0000Oo != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        private static void O00000o(jrk jrk) {
            if (jrk.O0000O0o != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }
    }

    private jrk(O000000o o000000o) {
        this.f2098O000000o = o000000o.f2099O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0;
        this.O00000o = o000000o.O00000o;
        this.O00000oO = o000000o.O00000oO;
        this.O00000oo = o000000o.O00000oo.O000000o();
        this.O0000O0o = o000000o.O0000O0o;
        this.O0000OOo = o000000o.O0000OOo;
        this.O0000Oo0 = o000000o.O0000Oo0;
        this.O0000Oo = o000000o.O0000Oo;
    }

    public final String toString() {
        return "Response{protocol=" + this.O00000Oo + ", code=" + this.O00000o0 + ", message=" + this.O00000o + ", url=" + this.f2098O000000o.f2095O000000o + '}';
    }
}
