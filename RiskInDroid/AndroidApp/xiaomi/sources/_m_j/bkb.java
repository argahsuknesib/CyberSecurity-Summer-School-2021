package _m_j;

import android.content.Intent;
import java.util.Arrays;
import java.util.List;

public final class bkb extends bjz {
    private static final String[] O00000o = {"action.connect_status_changed"};

    private bkb(bkf bkf) {
        super(bkf);
    }

    public static bkb O000000o(bkf bkf) {
        return new bkb(bkf);
    }

    /* access modifiers changed from: package-private */
    public final List<String> O000000o() {
        return Arrays.asList(O00000o);
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(Intent intent) {
        String stringExtra = intent.getStringExtra("extra.mac");
        int intExtra = intent.getIntExtra("extra.status", 0);
        bky.O00000Oo(String.format("onConnectStatusChanged for %s, status = %d", stringExtra, Integer.valueOf(intExtra)));
        for (bkm O000000o2 : O000000o(bki.class)) {
            O000000o2.O000000o(stringExtra, Integer.valueOf(intExtra));
        }
        return true;
    }
}
