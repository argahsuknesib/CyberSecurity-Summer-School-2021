package _m_j;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class fpd extends fpc {
    private static final String[] O00000oO = {"android.bluetooth.adapter.action.STATE_CHANGED"};
    private static fpd O00000oo;
    public List<O000000o> O00000o = new ArrayList();

    public interface O000000o {
        void O000000o(int i, int i2);
    }

    private static String O000000o(int i) {
        switch (i) {
            case 10:
                return "state_off";
            case 11:
                return "state_turning_on";
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                return "state_on";
            case 13:
                return "state_turning_off";
            default:
                return "unknown";
        }
    }

    private fpd() {
        O000000o(O00000oO);
    }

    public final void O000000o(final O000000o o000000o) {
        this.O00000o0.post(new Runnable() {
            /* class _m_j.fpd.AnonymousClass1 */

            public final void run() {
                if (o000000o != null && !fpd.this.O00000o.contains(o000000o)) {
                    fpd.this.O00000o.add(o000000o);
                }
            }
        });
    }

    public final void O00000Oo(final O000000o o000000o) {
        this.O00000o0.post(new Runnable() {
            /* class _m_j.fpd.AnonymousClass2 */

            public final void run() {
                if (o000000o != null) {
                    fpd.this.O00000o.remove(o000000o);
                }
            }
        });
    }

    public static fpd O00000Oo() {
        if (O00000oo == null) {
            O00000oo = new fpd();
        }
        return O00000oo;
    }

    public final boolean O000000o(Context context, Intent intent) {
        if (!"android.bluetooth.adapter.action.STATE_CHANGED".equalsIgnoreCase(intent.getAction())) {
            return false;
        }
        int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
        int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 0);
        gnk.O00000o0(String.format("state changed: %s -> %s", O000000o(intExtra2), O000000o(intExtra)));
        for (O000000o O000000o2 : this.O00000o) {
            O000000o2.O000000o(intExtra2, intExtra);
        }
        if (intExtra == 10) {
            gnk.O00000o0("onBluetoothTurnedOff");
            gsy.O000000o(4, "stopScan", "BSR turn off stop");
            fpo.O00000Oo();
            fpo.O00000o0();
        } else if (intExtra == 12) {
            gnk.O00000o0("onBluetoothTurnedOn");
            if (CommonApplication.getApplication().isAppForeground()) {
                fob.O000000o(new SearchRequest.O000000o().O00000Oo(8000, 1).O000000o(), (fon) null);
            } else {
                gsy.O000000o(2, "BluetoothStateReceiver", "app is on background, don't search ble device");
            }
        }
        return true;
    }
}
