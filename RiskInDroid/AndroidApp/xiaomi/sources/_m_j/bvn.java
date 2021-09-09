package _m_j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

public final class bvn {
    static long O00000o;
    static long O00000o0;
    static long O00000oO;
    static long O00000oo;
    static long O0000O0o;
    public static HashMap<String, Long> O0000o = new HashMap<>(36);
    static int O0000oO = 0;
    public static long O0000oO0 = 0;

    /* renamed from: O000000o  reason: collision with root package name */
    WifiManager f13314O000000o;
    ArrayList<ScanResult> O00000Oo = new ArrayList<>();
    Context O0000OOo;
    StringBuilder O0000Oo = null;
    boolean O0000Oo0 = false;
    boolean O0000OoO = true;
    boolean O0000Ooo = true;
    String O0000o0 = null;
    boolean O0000o00 = true;
    TreeMap<Integer, ScanResult> O0000o0O = null;
    public boolean O0000o0o = true;
    ConnectivityManager O0000oOO = null;
    long O0000oOo = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
    private volatile WifiInfo O0000oo = null;
    volatile boolean O0000oo0 = false;

    public bvn(Context context, WifiManager wifiManager) {
        this.f13314O000000o = wifiManager;
        this.O0000OOo = context;
    }

    public static long O000000o() {
        return ((bwi.O00000o0() - O0000oO0) / 1000) + 1;
    }

    private static boolean O000000o(int i) {
        int i2 = 20;
        try {
            i2 = WifiManager.calculateSignalLevel(i, 20);
        } catch (ArithmeticException e) {
            bvz.O000000o(e, "Aps", "wifiSigFine");
        }
        return i2 > 0;
    }

    public static boolean O000000o(WifiInfo wifiInfo) {
        return wifiInfo != null && !TextUtils.isEmpty(wifiInfo.getSSID()) && bwi.O000000o(wifiInfo.getBSSID());
    }

    public static String O00000oo() {
        return String.valueOf(bwi.O00000o0() - O00000oo);
    }

    private List<ScanResult> O0000O0o() {
        long O00000o02;
        WifiManager wifiManager = this.f13314O000000o;
        if (wifiManager != null) {
            try {
                List<ScanResult> scanResults = wifiManager.getScanResults();
                if (Build.VERSION.SDK_INT >= 17) {
                    HashMap<String, Long> hashMap = new HashMap<>(36);
                    for (ScanResult next : scanResults) {
                        hashMap.put(next.BSSID, Long.valueOf(next.timestamp));
                    }
                    if (O0000o.isEmpty() || !O0000o.equals(hashMap)) {
                        O0000o = hashMap;
                        O00000o02 = bwi.O00000o0();
                    }
                    this.O0000o0 = null;
                    return scanResults;
                }
                O00000o02 = bwi.O00000o0();
                O0000oO0 = O00000o02;
                this.O0000o0 = null;
                return scanResults;
            } catch (SecurityException e) {
                this.O0000o0 = e.getMessage();
            } catch (Throwable th) {
                this.O0000o0 = null;
                bvz.O000000o(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    private WifiInfo O0000OOo() {
        try {
            if (this.f13314O000000o != null) {
                return this.f13314O000000o.getConnectionInfo();
            }
            return null;
        } catch (Throwable th) {
            bvz.O000000o(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    private boolean O0000Oo() {
        this.O0000o0o = this.f13314O000000o == null ? false : bwi.O0000OOo(this.O0000OOo);
        if (!this.O0000o0o || !this.O0000OoO) {
            return false;
        }
        if (O00000oO != 0) {
            if (bwi.O00000o0() - O00000oO < 4900 || bwi.O00000o0() - O00000oo < 1500) {
                return false;
            }
            int i = ((bwi.O00000o0() - O00000oo) > 4900 ? 1 : ((bwi.O00000o0() - O00000oo) == 4900 ? 0 : -1));
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        if (r0 < r6) goto L_0x0074;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0077 A[Catch:{ Throwable -> 0x007e }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    private void O0000Oo0() {
        boolean z;
        if (O0000Oo()) {
            try {
                long O00000o02 = bwi.O00000o0() - O00000o0;
                if (O00000o02 >= 4900) {
                    if (this.O0000oOO == null) {
                        this.O0000oOO = (ConnectivityManager) bwi.O000000o(this.O0000OOo, "connectivity");
                    }
                    if (!O000000o(this.O0000oOO) || O00000o02 >= 9900) {
                        if (O0000oO > 1) {
                            long j = this.O0000oOo;
                            long j2 = DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
                            if (j != DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
                                j2 = this.O0000oOo;
                            } else if (bvy.O000O00o() != -1) {
                                j2 = bvy.O000O00o();
                            }
                            if (Build.VERSION.SDK_INT >= 28) {
                            }
                        }
                        if (this.f13314O000000o != null) {
                            O00000o0 = bwi.O00000o0();
                            if (O0000oO < 2) {
                                O0000oO++;
                            }
                            z = this.f13314O000000o.startScan();
                            if (!z) {
                                O00000oO = bwi.O00000o0();
                                return;
                            }
                            return;
                        }
                    }
                }
                z = false;
                if (!z) {
                }
            } catch (Throwable th) {
                bvz.O000000o(th, "WifiManager", "wifiScan");
            }
        }
    }

    public final void O000000o(boolean z) {
        String str;
        if (!z) {
            O0000Oo0();
        } else if (O0000Oo()) {
            long O00000o02 = bwi.O00000o0();
            if (O00000o02 - O00000o >= 10000) {
                this.O00000Oo.clear();
                O0000O0o = O00000oo;
            }
            O0000Oo0();
            if (O00000o02 - O00000o >= 10000) {
                for (int i = 20; i > 0 && O00000oo == O0000O0o; i--) {
                    try {
                        Thread.sleep(150);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        if (this.O0000oo0) {
            this.O0000oo0 = false;
            O00000o0();
        }
        if (O0000O0o != O00000oo) {
            List<ScanResult> list = null;
            try {
                list = O0000O0o();
            } catch (Throwable th) {
                bvz.O000000o(th, "WifiManager", "updateScanResult");
            }
            O0000O0o = O00000oo;
            if (list != null) {
                this.O00000Oo.clear();
                this.O00000Oo.addAll(list);
            } else {
                this.O00000Oo.clear();
            }
        }
        if (bwi.O00000o0() - O00000oo > 20000) {
            this.O00000Oo.clear();
        }
        O00000o = bwi.O00000o0();
        if (this.O00000Oo.isEmpty()) {
            O00000oo = bwi.O00000o0();
            List<ScanResult> O0000O0o2 = O0000O0o();
            if (O0000O0o2 != null) {
                this.O00000Oo.addAll(O0000O0o2);
            }
        }
        ArrayList<ScanResult> arrayList = this.O00000Oo;
        if (arrayList != null && !arrayList.isEmpty()) {
            if (bwi.O00000o0() - O00000oo > 3600000) {
                O00000o0();
            }
            if (this.O0000o0O == null) {
                this.O0000o0O = new TreeMap<>(Collections.reverseOrder());
            }
            this.O0000o0O.clear();
            int size = this.O00000Oo.size();
            for (int i2 = 0; i2 < size; i2++) {
                ScanResult scanResult = this.O00000Oo.get(i2);
                if (bwi.O000000o(scanResult != null ? scanResult.BSSID : "") && (size <= 20 || O000000o(scanResult.level))) {
                    if (!TextUtils.isEmpty(scanResult.SSID)) {
                        if (!"<unknown ssid>".equals(scanResult.SSID)) {
                            str = String.valueOf(i2);
                        }
                        this.O0000o0O.put(Integer.valueOf((scanResult.level * 25) + i2), scanResult);
                    } else {
                        str = "unkwn";
                    }
                    scanResult.SSID = str;
                    this.O0000o0O.put(Integer.valueOf((scanResult.level * 25) + i2), scanResult);
                }
            }
            this.O00000Oo.clear();
            for (ScanResult add : this.O0000o0O.values()) {
                this.O00000Oo.add(add);
            }
            this.O0000o0O.clear();
        }
    }

    public final boolean O000000o(ConnectivityManager connectivityManager) {
        WifiManager wifiManager = this.f13314O000000o;
        if (wifiManager == null) {
            return false;
        }
        try {
            return bwi.O000000o(connectivityManager.getActiveNetworkInfo()) == 1 && O000000o(wifiManager.getConnectionInfo());
        } catch (Throwable th) {
            bvz.O000000o(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public final ArrayList<ScanResult> O00000Oo() {
        if (this.O00000Oo == null) {
            return null;
        }
        ArrayList<ScanResult> arrayList = new ArrayList<>();
        if (!this.O00000Oo.isEmpty()) {
            arrayList.addAll(this.O00000Oo);
        }
        return arrayList;
    }

    public final WifiInfo O00000o() {
        this.O0000oo = O0000OOo();
        return this.O0000oo;
    }

    public final void O00000o0() {
        this.O0000oo = null;
        this.O00000Oo.clear();
    }

    public final String O00000oO() {
        boolean z;
        String str;
        StringBuilder sb = this.O0000Oo;
        if (sb == null) {
            this.O0000Oo = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        this.O0000Oo0 = false;
        this.O0000oo = O00000o();
        String bssid = O000000o(this.O0000oo) ? this.O0000oo.getBSSID() : "";
        int size = this.O00000Oo.size();
        int i = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i < size) {
            String str2 = this.O00000Oo.get(i).BSSID;
            if (!this.O0000Ooo && !"<unknown ssid>".equals(this.O00000Oo.get(i).SSID)) {
                z2 = true;
            }
            if (bssid.equals(str2)) {
                str = "access";
                z = true;
            } else {
                z = z3;
                str = "nb";
            }
            this.O0000Oo.append(String.format(Locale.US, "#%s,%s", str2, str));
            i++;
            z3 = z;
        }
        if (this.O00000Oo.size() == 0) {
            z2 = true;
        }
        if (!this.O0000Ooo && !z2) {
            this.O0000Oo0 = true;
        }
        if (!z3 && !TextUtils.isEmpty(bssid)) {
            StringBuilder sb2 = this.O0000Oo;
            sb2.append("#");
            sb2.append(bssid);
            this.O0000Oo.append(",access");
        }
        return this.O0000Oo.toString();
    }
}
