package _m_j;

import android.util.Log;

public final class dpv {

    /* renamed from: O000000o  reason: collision with root package name */
    public o0O0OOO0<Integer, bnt> f14844O000000o = new o0O0OOO0<>();

    public final boolean O000000o(dpu dpu) {
        int i = dpu.O00000o;
        int O00000o0 = dpu.O00000o0();
        int i2 = 0;
        while (i2 < O00000o0) {
            int O00000o02 = dpu.O00000o0();
            short O00000Oo = dpu.O00000Oo();
            int i3 = dpu.O00000o0;
            if (i3 + O00000Oo <= i) {
                this.f14844O000000o.put(Integer.valueOf(O00000o02), new bnt(dpu.O00000Oo, i3, O00000Oo));
                dpu.O000000o(O00000Oo);
                i2++;
            } else {
                Log.e("CodeManager_TMTEST", "read string over");
                return false;
            }
        }
        return true;
    }
}
