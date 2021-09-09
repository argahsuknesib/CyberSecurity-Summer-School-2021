package _m_j;

import _m_j.jfk;

final class jfu implements jfl {

    /* renamed from: O000000o  reason: collision with root package name */
    Object f1804O000000o;
    Object O00000Oo;
    jfk.O000000o O00000o;
    Object[] O00000o0;
    private jfr O00000oO;

    static class O000000o implements jfk.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f1805O000000o;
        jfm O00000Oo;
        private int O00000o;
        jfq O00000o0;

        public O000000o(int i, String str, jfm jfm, jfq jfq) {
            this.f1805O000000o = str;
            this.O00000Oo = jfm;
            this.O00000o0 = jfq;
            this.O00000o = i;
        }

        public final String toString() {
            jfz jfz = jfz.O0000OoO;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(jfz.O000000o(this.f1805O000000o));
            stringBuffer.append("(");
            stringBuffer.append(((jfx) this.O00000Oo).O00000Oo(jfz));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }
    }

    public jfu(jfk.O000000o o000000o, Object obj, Object obj2, Object[] objArr) {
        this.O00000o = o000000o;
        this.f1804O000000o = obj;
        this.O00000Oo = obj2;
        this.O00000o0 = objArr;
    }

    public final Object O000000o() {
        return this.O00000Oo;
    }

    public final String toString() {
        return this.O00000o.toString();
    }

    public final void O000000o(jfr jfr) {
        this.O00000oO = jfr;
    }

    public final Object O00000Oo() throws Throwable {
        jfr jfr = this.O00000oO;
        if (jfr == null) {
            return null;
        }
        return jfr.run(jfr.getState());
    }
}
