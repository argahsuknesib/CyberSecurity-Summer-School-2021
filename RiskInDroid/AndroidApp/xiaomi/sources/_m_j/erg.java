package _m_j;

import _m_j.elr;
import android.content.Context;
import java.util.ArrayList;

final class erg extends elr.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ Context f15742O000000o;

    erg(Context context) {
        this.f15742O000000o = context;
    }

    public final void b() {
        ArrayList arrayList;
        synchronized (erf.O00000o) {
            arrayList = new ArrayList(erf.O00000oO);
            erf.O00000oO.clear();
        }
        erf.O000000o(this.f15742O000000o, arrayList);
    }
}
