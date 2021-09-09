package _m_j;

import android.content.Context;

public final class ecm extends ecn {

    /* renamed from: O000000o  reason: collision with root package name */
    static ecm f15167O000000o = new ecm();

    public static ecm O000000o() {
        return f15167O000000o;
    }

    public final void O000000o(Context context, String str) {
        O00000Oo(context, "crashMD5", str);
    }

    public final String O00000Oo(Context context) {
        return O000000o(context, "crashMD5", "");
    }

    public final void O000000o(Context context, int i) {
        super.O00000o0(context).edit().putInt("vmimei", i).commit();
    }

    public final int O000000o(Context context) {
        return super.O00000o0(context).getInt("vmimei", 0);
    }
}
