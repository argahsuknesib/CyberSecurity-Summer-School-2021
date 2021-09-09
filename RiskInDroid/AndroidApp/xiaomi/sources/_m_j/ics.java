package _m_j;

import android.content.Context;

public class ics {
    private static volatile ics O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f1194O000000o;

    public static ics O000000o(Context context) {
        if (O00000Oo == null) {
            synchronized (ics.class) {
                if (O00000Oo == null) {
                    O00000Oo = new ics(context);
                }
            }
        }
        return O00000Oo;
    }

    private ics(Context context) {
        this.f1194O000000o = context.getApplicationContext();
    }

    public final void O000000o(String str) {
        izb.O000000o(this.f1194O000000o, str, 0).show();
    }
}
