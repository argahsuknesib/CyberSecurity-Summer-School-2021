package _m_j;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class jkr extends jks {

    /* renamed from: O000000o  reason: collision with root package name */
    Logger f1910O000000o;

    public jkr(String str) {
        this.f1910O000000o = Logger.getLogger(str);
    }

    public final void O000000o(String str) {
        this.f1910O000000o.log(Level.FINE, str);
    }

    public final void O00000Oo(String str) {
        this.f1910O000000o.log(Level.WARNING, str);
    }

    public final void O00000o0(String str) {
        this.f1910O000000o.log(Level.SEVERE, str);
    }
}
