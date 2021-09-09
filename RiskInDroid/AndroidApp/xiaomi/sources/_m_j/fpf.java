package _m_j;

import android.content.Context;
import android.content.Intent;

public final class fpf extends fpc {
    private static final String[] O00000o = {"com.xiaomi.smarthome.bluetooth.connect_status_changed"};
    private static fpf O00000oO;

    private fpf() {
        O000000o(O00000o);
    }

    public static fpf O00000Oo() {
        if (O00000oO == null) {
            O00000oO = new fpf();
        }
        return O00000oO;
    }

    public final boolean O000000o(Context context, Intent intent) {
        if (intent == null || !"com.xiaomi.smarthome.bluetooth.connect_status_changed".equals(intent.getAction())) {
            return false;
        }
        fob.O000000o(false);
        return true;
    }
}
