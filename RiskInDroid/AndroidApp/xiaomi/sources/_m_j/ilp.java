package _m_j;

import android.content.Context;

public final class ilp extends ilf {
    private static ilp O00000o0;

    private ilp(Context context, String str) {
        super(context, str);
    }

    public static ilp O000000o(Context context) {
        if (O00000o0 == null) {
            O00000o0 = new ilp(context, "ting_data");
        }
        return O00000o0;
    }

    public static ilp O00000Oo(Context context) {
        ilp ilp = new ilp(context, "ting_data");
        O00000o0 = ilp;
        return ilp;
    }
}
