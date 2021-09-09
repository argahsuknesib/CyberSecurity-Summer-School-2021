package _m_j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class cpg implements cpi {

    /* renamed from: O000000o  reason: collision with root package name */
    private final ThreadLocal<String> f14181O000000o = new ThreadLocal<>();
    private final List<cpc> O00000Oo = new ArrayList();

    cpg() {
    }

    public final cpi O000000o(String str) {
        if (str != null) {
            this.f14181O000000o.set(str);
        }
        return this;
    }

    public final void O000000o(String str, Object... objArr) {
        O00000Oo(str, objArr);
    }

    public final void O00000Oo(String str, Object... objArr) {
        O000000o(6, (Throwable) null, str, objArr);
    }

    public final void O00000o0(String str, Object... objArr) {
        O000000o(5, (Throwable) null, str, objArr);
    }

    private synchronized void O000000o(int i, String str, String str2, Throwable th) {
        if (!(th == null || str2 == null)) {
            str2 = str2 + " : " + cpj.O000000o(th);
        }
        if (th != null && str2 == null) {
            str2 = cpj.O000000o(th);
        }
        if (cpj.O000000o((CharSequence) str2)) {
            str2 = "Empty/NULL log message";
        }
        for (cpc next : this.O00000Oo) {
            if (next.O000000o()) {
                next.O000000o(i, str, str2);
            }
        }
    }

    public final void O000000o(cpc cpc) {
        this.O00000Oo.add(cpj.O000000o(cpc));
    }

    private synchronized void O000000o(int i, Throwable th, String str, Object... objArr) {
        cpj.O000000o((Object) str);
        String str2 = this.f14181O000000o.get();
        if (str2 != null) {
            this.f14181O000000o.remove();
        } else {
            str2 = null;
        }
        if (objArr != null) {
            if (objArr.length != 0) {
                str = String.format(str, objArr);
            }
        }
        O000000o(i, str2, str, (Throwable) null);
    }

    public final void O000000o(Object obj) {
        String str;
        if (obj == null) {
            str = "null";
        } else if (!obj.getClass().isArray()) {
            str = obj.toString();
        } else if (obj instanceof boolean[]) {
            str = Arrays.toString((boolean[]) obj);
        } else if (obj instanceof byte[]) {
            str = Arrays.toString((byte[]) obj);
        } else if (obj instanceof char[]) {
            str = Arrays.toString((char[]) obj);
        } else if (obj instanceof short[]) {
            str = Arrays.toString((short[]) obj);
        } else if (obj instanceof int[]) {
            str = Arrays.toString((int[]) obj);
        } else if (obj instanceof long[]) {
            str = Arrays.toString((long[]) obj);
        } else if (obj instanceof float[]) {
            str = Arrays.toString((float[]) obj);
        } else if (obj instanceof double[]) {
            str = Arrays.toString((double[]) obj);
        } else {
            str = obj instanceof Object[] ? Arrays.deepToString((Object[]) obj) : "Couldn't find a correct type for the object";
        }
        O000000o(3, (Throwable) null, str, new Object[0]);
    }
}
