package _m_j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.gms.common.ConnectionResult;
import com.xiaomi.smarthome.core.client.IClientCallback;
import com.xiaomi.smarthome.core.server.CoreService;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class flt {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f16587O000000o = (O00000oo() ? ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED : 30000);
    public static IClientCallback O00000oO;
    public static boolean O00000oo = false;
    public static flt O0000O0o = null;
    private static final int[] O0000Oo = {6000, 24000, 30000, 30000};
    private static final int[] O0000OoO = {4000, C.MSG_CUSTOM_BASE, C.MSG_CUSTOM_BASE, 8000};
    private static final int[] O0000Ooo = {6000, C.MSG_CUSTOM_BASE};
    private static List<fls> O0000o0 = new ArrayList(4);
    private static final int[][] O0000o00 = {new int[0], O0000Oo, O0000OoO, O0000Ooo};
    private static String O0000o0O = null;
    public WifiManager O00000Oo;
    public boolean O00000o = false;
    public PowerManager O00000o0;
    public Handler O0000OOo = new O000000o(this, (byte) 0);
    public BroadcastReceiver O0000Oo0 = new BroadcastReceiver() {
        /* class _m_j.flt.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (flt.O00000oO != null) {
                Bundle bundle = new Bundle();
                if (action.equals("android.net.wifi.SCAN_RESULTS") && flt.O000000o()) {
                    bundle.putString("result", "com.xiaomi.smarthome.wifiscanservice.SCAN_RESULTS");
                } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                    bundle.putString("result", "com.xiaomi.smarthome.wifiscanservice.STATE_CHANGE");
                } else if (action.equals("android.intent.action.USER_PRESENT")) {
                    bundle.putString("result", "com.xiaomi.smarthome.wifiscanservice.USER_PRESENT");
                } else if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    bundle.putString("result", "com.xiaomi.smarthome.wifiscanservice.CONNECTIVITY_CHANGE");
                }
                if (bundle.containsKey("result")) {
                    try {
                        flt.O00000oO.onSuccess(bundle);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    private static String O000000o(int[] iArr, String str) {
        if (iArr == null || TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int append : iArr) {
            sb.append(append);
            sb.append(str);
        }
        return sb.toString();
    }

    public static void O000000o(int i) {
        if (O00000oo()) {
            f16587O000000o = O00000oo() ? ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED : 30000;
        } else {
            f16587O000000o = i;
        }
    }

    public static boolean O000000o() {
        return O00000oo;
    }

    public static void O00000Oo() {
        O00000oo = false;
        flt flt = O0000O0o;
        if (flt != null) {
            O0000o0O = null;
            flt.O0000OOo.removeMessages(1);
        }
        gsy.O00000Oo("WifiScanServicesMonitor", "stopScan");
    }

    public static void O000000o(int i, IClientCallback iClientCallback) {
        O00000oo = true;
        O00000oO = iClientCallback;
        flt flt = O0000O0o;
        if (flt != null) {
            flt.O00000o0();
        }
        if (!O00000oo()) {
            return;
        }
        if (O0000o0.size() == 0) {
            O0000o0.add(new fls(i));
            return;
        }
        if (O0000o0.get(O0000o0.size() - 1).O00000o0 != i) {
            O0000o0.add(new fls(i));
        }
    }

    public static void O000000o(String str, IClientCallback iClientCallback) {
        O000000o(2, iClientCallback);
        O0000o0O = str;
    }

    public final void O00000o0() {
        this.O0000OOo.removeMessages(1);
        this.O0000OOo.sendEmptyMessageDelayed(1, 300);
    }

    private static boolean O00000oO() {
        int[] iArr;
        int[] O0000OOo2;
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<fls> it = O0000o0.iterator();
        fls fls = null;
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            fls = it.next();
            if (currentTimeMillis - fls.f16586O000000o > 120000 || (fls.O00000Oo > 0 && currentTimeMillis - fls.O00000Oo > 120000)) {
                z = true;
            }
            if (z) {
                it.remove();
            }
        }
        if (O00000oo && O0000o0.isEmpty() && fls != null) {
            O0000o0.add(new fls(fls.O00000o0));
        }
        int[] iArr2 = {0, 0, 0, 0};
        int i = 0;
        for (fls next : O0000o0) {
            if (next.O00000Oo > 0) {
                iArr2[next.O00000o0] = iArr2[next.O00000o0] + 1;
                i++;
            }
        }
        gsy.O00000Oo("WifiScanServicesMonitor", String.format("checkCanScan,during 2 minutes, valid sum scan=%d, auto scan=%d,manual scan=%d,other scan=%d", Integer.valueOf(i), Integer.valueOf(iArr2[1]), Integer.valueOf(iArr2[2]), Integer.valueOf(iArr2[3])));
        if (i >= 4) {
            gsy.O00000Oo("WifiScanServicesMonitor", "checkCanScan, current valid scan num >=4, return!!!!!");
            return false;
        }
        int size = O0000o0.size();
        if (size > 0) {
            fls fls2 = O0000o0.get(size - 1);
            int i2 = iArr2[fls2.O00000o0];
            int i3 = fls2.O00000o0;
            if (i3 != 2) {
                iArr = O0000o00[i3];
            } else {
                String str = O0000o0O;
                if (TextUtils.isEmpty(str)) {
                    str = "default";
                }
                int[] O0000OOo3 = eyr.O00000Oo().O0000OOo(str);
                gsy.O00000Oo("WifiScanServicesMonitor", String.format("getScanInternal model=%s, config internal arr:{%s}", str, O000000o(O0000OOo3, ",")));
                if (O0000OOo3 != null && O0000OOo3.length != 0) {
                    iArr = O0000OOo3;
                } else if ("default".equals(str) || (O0000OOo2 = eyr.O00000Oo().O0000OOo("default")) == null || O0000OOo2.length <= 0) {
                    iArr = O0000OoO;
                } else {
                    gsy.O00000Oo("WifiScanServicesMonitor", String.format("getScanInternal model=%s, config internal arr(default):{%s}", str, O000000o(O0000OOo2, ",")));
                    iArr = O0000OOo2;
                }
            }
            int i4 = iArr[i2 >= iArr.length ? iArr.length - 1 : i2];
            gsy.O00000Oo("WifiScanServicesMonitor", String.format("checkCanScan,top item.type=%d, type[count]=%d,scan interval=%d,scanStartTime=%s", Integer.valueOf(fls2.O00000o0), Integer.valueOf(i2), Integer.valueOf(i4), String.valueOf(fls2.O00000Oo)));
            return fls2.O00000Oo > 0 ? ((int) (currentTimeMillis - fls2.O00000Oo)) > i4 : currentTimeMillis - fls2.f16586O000000o > ((long) i4);
        }
        gsy.O00000Oo("WifiScanServicesMonitor", "checkCanScan, end list size =" + size + ",return false");
        return false;
    }

    public static void O000000o(flt flt) {
        if (!O00000oo()) {
            gsy.O00000Oo("WifiScanServicesMonitor", "below Android 9.0, scan result =".concat(String.valueOf(flt.O00000Oo.startScan())));
        } else if (!O00000oO()) {
            gsy.O00000Oo("WifiScanServicesMonitor", "current time cannot scan");
        } else if (flt.O00000Oo.startScan()) {
            int size = O0000o0.size();
            gsy.O00000o0(LogType.KUAILIAN, "WifiScanServicesMonitor", "do scan, and scan 《《《《success》》》, list size=".concat(String.valueOf(size)));
            if (size > 0) {
                fls fls = O0000o0.get(size - 1);
                if (fls.O00000Oo > 0) {
                    fls fls2 = new fls(fls.O00000o0);
                    fls2.O00000Oo = System.currentTimeMillis();
                    O0000o0.add(fls2);
                    return;
                }
                fls.O00000Oo = System.currentTimeMillis();
            }
        } else {
            gsy.O00000Oo("WifiScanServicesMonitor", "do scan but invalid");
        }
    }

    static class O000000o extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        WeakReference<flt> f16589O000000o;

        /* synthetic */ O000000o(flt flt, byte b) {
            this(flt);
        }

        private O000000o(flt flt) {
            this.f16589O000000o = new WeakReference<>(flt);
        }

        public final void handleMessage(Message message) {
            flt flt = this.f16589O000000o.get();
            if (flt != null && message.what == 1) {
                try {
                    if (flt.O00000Oo.isWifiEnabled() && flt.O00000o0.isScreenOn() && flt.O00000oo) {
                        flt.O000000o(flt);
                    }
                    if (!flt.O00000Oo.isWifiEnabled()) {
                        if (flt.O00000o) {
                            fix.O000000o().O000000o("wifi_show_disable");
                        }
                        flt.O00000o = false;
                    } else {
                        if (!flt.O00000o) {
                            fix.O000000o().O000000o("wifi_show_disable");
                        }
                        flt.O00000o = true;
                    }
                    removeMessages(1);
                    sendEmptyMessageDelayed(1, (long) flt.f16587O000000o);
                    gsy.O000000o(6, "scan2", "MSG_SCAN_WIFI");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Context O00000o() {
        return CoreService.getAppContext();
    }

    private static boolean O00000oo() {
        return Build.VERSION.SDK_INT >= 28 && eyr.O00000Oo().O00000o0();
    }
}
