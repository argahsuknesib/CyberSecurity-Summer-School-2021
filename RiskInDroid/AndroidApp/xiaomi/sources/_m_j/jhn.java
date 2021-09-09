package _m_j;

abstract class jhn extends jhq implements jhi {

    /* renamed from: O000000o  reason: collision with root package name */
    Class[] f1835O000000o;
    String[] O00000Oo;
    Class[] O00000o0;

    jhn(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.f1835O000000o = clsArr;
        this.O00000Oo = strArr;
        this.O00000o0 = clsArr2;
    }

    public final Class[] O000000o() {
        if (this.f1835O000000o == null) {
            this.f1835O000000o = O00000o0(3);
        }
        return this.f1835O000000o;
    }

    public final Class[] O00000Oo() {
        if (this.O00000o0 == null) {
            this.O00000o0 = O00000o0(5);
        }
        return this.O00000o0;
    }
}
