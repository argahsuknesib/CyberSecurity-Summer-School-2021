package _m_j;

import android.widget.RemoteViews;

public class gyy extends gza {
    private static volatile gyy O0000OoO;

    public final boolean O00000Oo() {
        return true;
    }

    public static gyy O000000o() {
        if (O0000OoO == null) {
            synchronized (gyy.class) {
                if (O0000OoO == null) {
                    O0000OoO = new gyy();
                }
            }
        }
        return O0000OoO;
    }

    public final void O000000o(RemoteViews remoteViews, int i) {
        remoteViews.setViewVisibility(O00000o()[0], 0);
    }
}
