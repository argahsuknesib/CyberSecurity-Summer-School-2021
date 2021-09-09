package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.frame.core.CoreApi;

public final class gwq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f18425O000000o = new Object();
    private static gwq O00000Oo;
    private gwt O00000o = new gwt();
    private gws O00000o0 = new gws();
    private String O00000oO;

    public static gwq O000000o() {
        gwq gwq;
        synchronized (f18425O000000o) {
            if (O00000Oo == null) {
                O00000Oo = new gwq();
            }
            gwq = O00000Oo;
        }
        return gwq;
    }

    private gwq() {
        O00000Oo();
    }

    public final void O00000Oo() {
        this.O00000o0 = new gws();
        this.O00000o = new gwt();
    }

    public static void O00000o0() {
        synchronized (f18425O000000o) {
            O00000Oo = null;
        }
    }

    public final gwp O00000o() {
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) || !ggb.O00000Oo().O00000oO() || ggb.O00000Oo().O0000Oo0() == null) {
            return this.O00000o;
        }
        String str = this.O00000oO;
        if (str == null) {
            this.O00000oO = ggb.O00000Oo().O0000OOo();
        } else if (!TextUtils.equals(str, ggb.O00000Oo().O0000OOo())) {
            this.O00000oO = ggb.O00000Oo().O0000OOo();
            this.O00000o0 = new gws();
        }
        return this.O00000o0;
    }
}
