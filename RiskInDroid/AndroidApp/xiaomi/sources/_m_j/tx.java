package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;

public class tx {
    private static final String O00000oo = "tx";

    /* renamed from: O000000o  reason: collision with root package name */
    public WifiManager f2518O000000o;
    public long O00000Oo = -1;
    public Location O00000o;
    public List<ScanResult> O00000o0 = new ArrayList();
    public ArrayList<pn> O00000oO = new ArrayList<>();
    private Context O0000O0o;
    private Handler O0000OOo;
    private BroadcastReceiver O0000Oo0;

    public tx(Context context, Looper looper) {
        this.O0000O0o = context;
        this.f2518O000000o = (WifiManager) context.getSystemService("wifi");
        this.O0000OOo = new Handler(looper);
    }

    public static boolean O000000o(Location location, long j, long j2) {
        return j > 0 && j2 - j < ((long) ((location.getSpeed() > 10.0f ? 1 : (location.getSpeed() == 10.0f ? 0 : -1)) >= 0 ? 2000 : 3500));
    }

    private void O00000o0() {
        this.O00000Oo = -1;
        try {
            WifiInfo connectionInfo = this.f2518O000000o == null ? null : this.f2518O000000o.getConnectionInfo();
            if (connectionInfo != null) {
                this.O00000Oo = pe.O000000o(connectionInfo.getBSSID());
            }
        } catch (Throwable unused) {
        }
    }

    public final void O000000o() {
        this.O0000Oo0 = new BroadcastReceiver() {
            /* class _m_j.tx.AnonymousClass1 */

            public final void onReceive(Context context, Intent intent) {
                try {
                    tx.O000000o(tx.this, intent);
                } catch (Throwable unused) {
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        try {
            this.O0000O0o.registerReceiver(this.O0000Oo0, intentFilter, null, this.O0000OOo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        O00000o0();
    }

    public final void O00000Oo() {
        BroadcastReceiver broadcastReceiver = this.O0000Oo0;
        if (broadcastReceiver != null) {
            try {
                this.O0000O0o.unregisterReceiver(broadcastReceiver);
                this.O0000Oo0 = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.O0000OOo.removeCallbacksAndMessages(null);
        this.O0000OOo = null;
    }

    static /* synthetic */ void O000000o(tx txVar, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            char c = 65535;
            if (action.hashCode() == -343630553 && action.equals("android.net.wifi.STATE_CHANGE")) {
                c = 0;
            }
            if (c == 0) {
                txVar.O00000o0();
            }
        }
    }
}
