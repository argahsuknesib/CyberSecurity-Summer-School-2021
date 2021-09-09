package _m_j;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

public final class jgk {

    /* renamed from: O000000o  reason: collision with root package name */
    final Method f1823O000000o;
    final ThreadMode O00000Oo;
    final int O00000o;
    final Class<?> O00000o0;
    final boolean O00000oO;
    String O00000oo;

    public jgk(Method method, Class<?> cls, ThreadMode threadMode, int i, boolean z) {
        this.f1823O000000o = method;
        this.O00000Oo = threadMode;
        this.O00000o0 = cls;
        this.O00000o = i;
        this.O00000oO = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof jgk)) {
            return false;
        }
        O000000o();
        jgk jgk = (jgk) obj;
        jgk.O000000o();
        return this.O00000oo.equals(jgk.O00000oo);
    }

    private synchronized void O000000o() {
        if (this.O00000oo == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f1823O000000o.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f1823O000000o.getName());
            sb.append('(');
            sb.append(this.O00000o0.getName());
            this.O00000oo = sb.toString();
        }
    }

    public final int hashCode() {
        return this.f1823O000000o.hashCode();
    }
}
