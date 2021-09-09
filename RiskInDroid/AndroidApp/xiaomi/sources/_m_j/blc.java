package _m_j;

import java.lang.reflect.Method;

public final class blc {

    /* renamed from: O000000o  reason: collision with root package name */
    public Object f13032O000000o;
    public Method O00000Oo;
    public Object[] O00000o0;

    public blc(Object obj, Method method, Object[] objArr) {
        this.f13032O000000o = obj;
        this.O00000Oo = method;
        this.O00000o0 = objArr;
    }

    public final Object O000000o() {
        try {
            return this.O00000Oo.invoke(this.f13032O000000o, this.O00000o0);
        } catch (Throwable th) {
            bky.O000000o(th);
            return null;
        }
    }
}
