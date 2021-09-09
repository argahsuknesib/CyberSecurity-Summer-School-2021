package _m_j;

import java.lang.reflect.Method;

public final class gmt {

    /* renamed from: O000000o  reason: collision with root package name */
    public Object f18020O000000o;
    public Method O00000Oo;
    public Object[] O00000o0;

    public gmt(Object obj, Method method, Object[] objArr) {
        this.f18020O000000o = obj;
        this.O00000Oo = method;
        this.O00000o0 = objArr;
    }

    public final Object O000000o() {
        try {
            return this.O00000Oo.invoke(this.f18020O000000o, this.O00000o0);
        } catch (Throwable th) {
            gnk.O00000Oo(gnk.O00000Oo(th));
            return null;
        }
    }
}
