package _m_j;

import _m_j.jhf;

final class jhp implements jhg {

    /* renamed from: O000000o  reason: collision with root package name */
    Object f1837O000000o;
    Object O00000Oo;
    jhf.O000000o O00000o;
    Object[] O00000o0;

    static class O000000o implements jhf.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f1838O000000o;
        jhh O00000Oo;
        private int O00000o;
        jhl O00000o0;

        public O000000o(int i, String str, jhh jhh, jhl jhl) {
            this.f1838O000000o = str;
            this.O00000Oo = jhh;
            this.O00000o0 = jhl;
            this.O00000o = i;
        }

        public final String toString() {
            jhu jhu = jhu.O0000OoO;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(jhu.O000000o(this.f1838O000000o));
            stringBuffer.append("(");
            stringBuffer.append(((jhs) this.O00000Oo).O00000Oo(jhu));
            stringBuffer.append(")");
            return stringBuffer.toString();
        }
    }

    public jhp(jhf.O000000o o000000o, Object obj, Object obj2, Object[] objArr) {
        this.O00000o = o000000o;
        this.f1837O000000o = obj;
        this.O00000Oo = obj2;
        this.O00000o0 = objArr;
    }

    public final Object O000000o() {
        return this.O00000Oo;
    }

    public final String toString() {
        return this.O00000o.toString();
    }
}
