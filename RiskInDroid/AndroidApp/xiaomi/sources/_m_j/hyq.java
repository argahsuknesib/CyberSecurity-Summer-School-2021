package _m_j;

import android.util.SparseBooleanArray;

public final class hyq {
    private static hyq O00000o;

    /* renamed from: O000000o  reason: collision with root package name */
    public int f997O000000o = 1;
    public hyr O00000Oo;
    public SparseBooleanArray O00000o0 = new SparseBooleanArray();

    private hyq() {
    }

    public static hyq O000000o() {
        if (O00000o == null) {
            O00000o = new hyq();
        }
        return O00000o;
    }

    public final void O000000o(int i) {
        this.f997O000000o = i;
        hyr hyr = this.O00000Oo;
        if (hyr != null) {
            if (i == 0) {
                hyr.onManageMode();
            } else if (i == 1) {
                this.O00000o0.clear();
                this.O00000Oo.onBrowseMode();
            }
        }
    }

    public final void O00000Oo() {
        this.O00000o0.clear();
        this.O00000Oo = null;
        if (O00000o != null) {
            O00000o = null;
        }
    }
}
