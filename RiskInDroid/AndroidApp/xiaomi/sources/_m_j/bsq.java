package _m_j;

import android.content.Context;
import java.util.List;

public final class bsq {

    /* renamed from: O000000o  reason: collision with root package name */
    bsk f13243O000000o;
    Context O00000Oo;

    public bsq(Context context, boolean z) {
        this.O00000Oo = context;
        this.f13243O000000o = O000000o(this.O00000Oo, z);
    }

    static bsk O000000o(Context context, boolean z) {
        try {
            return new bsk(context, bsk.O000000o((Class<? extends bsj>) bso.class));
        } catch (Throwable th) {
            if (!z) {
                bsf.O00000Oo(th, "sd", "gdb");
            }
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.bsk.O000000o(java.lang.String, java.lang.Class, boolean):java.util.List<T>
     arg types: [java.lang.String, java.lang.Class, int]
     candidates:
      _m_j.bsk.O000000o(android.database.Cursor, java.lang.Class, _m_j.bsl):T
      _m_j.bsk.O000000o(java.lang.String, java.lang.Class, boolean):java.util.List<T> */
    public final List<brr> O000000o() {
        try {
            return this.f13243O000000o.O000000o(brr.O00000oO(), brr.class, true);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
