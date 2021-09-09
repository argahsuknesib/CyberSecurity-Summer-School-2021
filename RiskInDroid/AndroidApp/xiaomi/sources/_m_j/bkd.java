package _m_j;

import android.content.Intent;
import java.util.Arrays;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class bkd extends bjz {
    private static final String[] O00000o = {"android.bluetooth.adapter.action.STATE_CHANGED"};

    private static String O000000o(int i) {
        switch (i) {
            case 10:
                return "state_off";
            case 11:
                return "state_turning_on";
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                return "state_on";
            case 13:
                return "state_turning_off";
            default:
                return "unknown";
        }
    }

    private bkd(bkf bkf) {
        super(bkf);
    }

    /* access modifiers changed from: package-private */
    public final List<String> O000000o() {
        return Arrays.asList(O00000o);
    }

    public static bkd O000000o(bkf bkf) {
        return new bkd(bkf);
    }

    public final boolean O000000o(Intent intent) {
        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
        int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 0);
        bky.O00000Oo(String.format("state changed: %s -> %s", O000000o(intExtra2), O000000o(intExtra)));
        for (bkm O000000o2 : O000000o(bkn.class)) {
            O000000o2.O000000o(Integer.valueOf(intExtra2), Integer.valueOf(intExtra));
        }
        return true;
    }
}
