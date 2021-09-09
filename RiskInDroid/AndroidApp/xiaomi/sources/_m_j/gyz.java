package _m_j;

import android.widget.RemoteViews;

public class gyz extends gza {
    private static volatile gyz O0000OoO;

    public final boolean O00000Oo() {
        return false;
    }

    public static gyz O000000o() {
        if (O0000OoO == null) {
            synchronized (gyz.class) {
                if (O0000OoO == null) {
                    O0000OoO = new gyz();
                }
            }
        }
        return O0000OoO;
    }

    public final void O000000o(RemoteViews remoteViews, int i) {
        for (int i2 = 0; i2 < i / 2; i2++) {
            remoteViews.setViewVisibility(O00000o()[i2], 0);
        }
    }
}
