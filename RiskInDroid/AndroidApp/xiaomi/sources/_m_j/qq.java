package _m_j;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public final class qq {
    public static boolean O000000o(Context context) {
        return pe.O000000o(context) == 1;
    }

    public static boolean O000000o(WifiManager wifiManager) {
        if (wifiManager == null) {
            return false;
        }
        try {
            if (wifiManager.isWifiEnabled()) {
                return true;
            }
            return Build.VERSION.SDK_INT >= 18 && wifiManager.isScanAlwaysAvailable();
        } catch (Exception | SecurityException unused) {
            return false;
        }
    }

    public static void O000000o(List<pn> list, List<ScanResult> list2) {
        list.clear();
        if (list2 != null) {
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            for (int i = 0; i < list2.size(); i++) {
                ScanResult scanResult = list2.get(i);
                hashMap.put(Integer.valueOf(scanResult.level), scanResult);
            }
            arrayList.addAll(hashMap.values());
            Collections.sort(arrayList, new Comparator<ScanResult>() {
                /* class _m_j.qq.AnonymousClass1 */

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((ScanResult) obj2).level - ((ScanResult) obj).level;
                }
            });
            int size = arrayList.size();
            if (size > 40) {
                size = 40;
            }
            for (int i2 = 0; i2 < size; i2++) {
                ScanResult scanResult2 = (ScanResult) arrayList.get(i2);
                if (scanResult2 != null) {
                    pn pnVar = new pn();
                    pnVar.f2390O000000o = pe.O000000o(scanResult2.BSSID);
                    pnVar.O00000Oo = (short) scanResult2.level;
                    pnVar.O00000o0 = scanResult2.SSID != null ? scanResult2.SSID.substring(0, Math.min(32, scanResult2.SSID.length())) : "";
                    pnVar.O00000oo = (short) scanResult2.frequency;
                    if (Build.VERSION.SDK_INT >= 17) {
                        pnVar.O00000oO = scanResult2.timestamp / 1000;
                        pnVar.O00000o = (short) ((int) ((SystemClock.elapsedRealtime() - pnVar.O00000oO) / 1000));
                        if (pnVar.O00000o < 0) {
                            pnVar.O00000o = 0;
                        }
                    }
                    list.add(pnVar);
                }
            }
        }
    }
}
