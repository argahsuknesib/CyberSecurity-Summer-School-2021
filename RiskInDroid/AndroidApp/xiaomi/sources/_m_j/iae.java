package _m_j;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;

public final class iae implements hun {
    public static ArrayList<ScanResult> O00000o = new ArrayList<>();
    public static ArrayList<ScanResult> O00000o0 = new ArrayList<>();
    public static HashMap<String, Integer> O00000oO = new HashMap<>();
    public static Map<String, O000000o> O00000oo = new ConcurrentHashMap();
    public static Map<String, O000000o> O0000O0o = new ConcurrentHashMap();
    private static iae O0000Ooo = null;

    /* renamed from: O000000o  reason: collision with root package name */
    WifiManager f1074O000000o;
    NotificationManager O00000Oo;
    public Context O0000OOo;
    public HandlerThread O0000Oo;
    Handler O0000Oo0 = new Handler();
    public Handler O0000OoO;

    public static iae O000000o() {
        if (O0000Ooo == null) {
            O0000Ooo = new iae();
        }
        return O0000Ooo;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        long f1079O000000o;
        long O00000Oo;
        ScanResult O00000o0;

        public final String toString() {
            return "findTime - " + this.O00000Oo + ", " + this.O00000o0.toString();
        }
    }

    public class O00000Oo extends Handler {
        public O00000Oo(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: Removed duplicated region for block: B:131:0x02ac A[Catch:{ Exception -> 0x02e5 }] */
        /* JADX WARNING: Removed duplicated region for block: B:133:0x02b8 A[Catch:{ Exception -> 0x02e5 }] */
        public final void handleMessage(Message message) {
            boolean z;
            boolean z2;
            boolean z3;
            String[] split;
            Message message2 = message;
            int i = message2.what;
            if (i == 1) {
                try {
                    Long valueOf = Long.valueOf(System.currentTimeMillis());
                    iae iae = iae.this;
                    List<ScanResult> list = null;
                    try {
                        list = iae.f1074O000000o.getScanResults();
                    } catch (Exception e) {
                        gsy.O00000o0(LogType.KUAILIAN, "scanResult", Log.getStackTraceString(e));
                    }
                    if (list != null) {
                        if (list.size() != 0) {
                            long currentTimeMillis = System.currentTimeMillis();
                            boolean z4 = true;
                            for (int i2 = 0; i2 < list.size(); i2++) {
                                ScanResult scanResult = list.get(i2);
                                String str = scanResult.SSID;
                                if (!TextUtils.isEmpty(str) && (split = str.split("-")) != null && split.length >= 3) {
                                    LogType logType = LogType.KUAILIAN;
                                    gsy.O00000o0(logType, "scanResult", "WifiDeviceFinder " + scanResult.level + " " + scanResult.SSID);
                                }
                                if (!DeviceFactory.O0000O0o(scanResult)) {
                                    if (DeviceFactory.O0000OOo(scanResult) && !DeviceFactory.O00000oo(list.get(i2)) && scanResult.level > -60) {
                                        if (DeviceFactory.O00000oO(scanResult) == DeviceFactory.AP_TYPE.AP_MIDEA) {
                                            z4 = false;
                                        }
                                        iae.O000000o(scanResult, currentTimeMillis);
                                    } else if (DeviceFactory.O000000o(scanResult) != null) {
                                        gsy.O00000Oo("WifiDeviceFinder", "XMRouter:check Xiaomi/Redmi sum(15) :" + scanResult.SSID);
                                        iae.O000000o(scanResult, currentTimeMillis);
                                    }
                                    if (DeviceFactory.O00000oo(list.get(i2)) && list.get(i2).level > -70) {
                                        iae.O000000o(scanResult, currentTimeMillis);
                                    }
                                }
                            }
                            Set<String> keySet = iae.O00000oo.keySet();
                            ArrayList arrayList = new ArrayList();
                            for (String next : keySet) {
                                O000000o o000000o = iae.O00000oo.get(next);
                                if (currentTimeMillis - o000000o.f1079O000000o < 10000) {
                                    arrayList.add(o000000o.O00000o0);
                                } else {
                                    iae.O00000oo.remove(next);
                                }
                            }
                            Collections.sort(arrayList, new Comparator<ScanResult>() {
                                /* class _m_j.iae.AnonymousClass1 */

                                public final /* synthetic */ int compare(Object obj, Object obj2) {
                                    ScanResult scanResult = (ScanResult) obj;
                                    ScanResult scanResult2 = (ScanResult) obj2;
                                    O000000o o000000o = iae.O00000oo.get(scanResult.SSID);
                                    O000000o o000000o2 = iae.O00000oo.get(scanResult2.SSID);
                                    if (o000000o.f1079O000000o != o000000o2.f1079O000000o) {
                                        return (int) (o000000o.f1079O000000o - o000000o2.f1079O000000o);
                                    }
                                    return scanResult.SSID.compareTo(scanResult2.SSID);
                                }
                            });
                            if (iae.O00000o0.size() != arrayList.size()) {
                                iae.O00000o0.clear();
                                iae.O00000o0.addAll(arrayList);
                            } else {
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= iae.O00000o0.size()) {
                                        z3 = false;
                                        break;
                                    } else if (!iae.O00000o0.get(i3).SSID.equals(((ScanResult) arrayList.get(i3)).SSID)) {
                                        z3 = true;
                                        break;
                                    } else {
                                        i3++;
                                    }
                                }
                                if (z3) {
                                    iae.O00000o0.clear();
                                    iae.O00000o0.addAll(arrayList);
                                } else {
                                    z4 = false;
                                }
                            }
                            Set<String> keySet2 = iae.O0000O0o.keySet();
                            ArrayList arrayList2 = new ArrayList();
                            for (String next2 : keySet2) {
                                O000000o o000000o2 = iae.O0000O0o.get(next2);
                                if (currentTimeMillis - o000000o2.f1079O000000o < 10000) {
                                    arrayList2.add(o000000o2.O00000o0);
                                } else {
                                    iae.O0000O0o.remove(next2);
                                }
                            }
                            Collections.sort(arrayList2, new Comparator<ScanResult>() {
                                /* class _m_j.iae.AnonymousClass2 */

                                public final /* synthetic */ int compare(Object obj, Object obj2) {
                                    ScanResult scanResult = (ScanResult) obj;
                                    ScanResult scanResult2 = (ScanResult) obj2;
                                    O000000o o000000o = iae.O0000O0o.get(scanResult.SSID);
                                    O000000o o000000o2 = iae.O0000O0o.get(scanResult2.SSID);
                                    if (o000000o.f1079O000000o != o000000o2.f1079O000000o) {
                                        return (int) (o000000o.f1079O000000o - o000000o2.f1079O000000o);
                                    }
                                    return scanResult.SSID.compareTo(scanResult2.SSID);
                                }
                            });
                            if (iae.O00000o.size() != arrayList2.size()) {
                                iae.O00000o.clear();
                                iae.O00000o.addAll(arrayList2);
                            } else {
                                int i4 = 0;
                                while (true) {
                                    if (i4 >= iae.O00000o.size()) {
                                        z2 = false;
                                        break;
                                    } else if (!iae.O00000o.get(i4).SSID.equals(((ScanResult) arrayList2.get(i4)).SSID)) {
                                        z2 = true;
                                        break;
                                    } else {
                                        i4++;
                                    }
                                }
                                if (z2) {
                                    iae.O00000o.clear();
                                    iae.O00000o.addAll(arrayList2);
                                } else {
                                    z = false;
                                    if (z4) {
                                        iae.O0000Oo0.post(new Runnable() {
                                            /* class _m_j.iae.AnonymousClass3 */

                                            public final void run() {
                                                Intent intent = new Intent("wifi_scan_result_broadcast");
                                                ArrayList arrayList = new ArrayList();
                                                arrayList.addAll(iae.O00000o0);
                                                intent.putParcelableArrayListExtra("wifi_scan_result", arrayList);
                                                ft.O000000o(iae.this.O0000OOo).O000000o(intent);
                                                try {
                                                    SmartConfigRouterFactory.getSmartConfigManager().onStartCommand();
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                        });
                                    }
                                    if (z) {
                                        iae.O0000Oo0.post(new Runnable() {
                                            /* class _m_j.iae.AnonymousClass4 */

                                            public final void run() {
                                                Intent intent = new Intent("wifi_scan_device");
                                                intent.putParcelableArrayListExtra("wifi_scan_device_result", iae.O00000o);
                                                ft.O000000o(iae.this.O0000OOo).O000000o(intent);
                                                SmartConfigRouterFactory.getSmartConfigManager().onStartCommand();
                                            }
                                        });
                                    }
                                    gsy.O000000o(6, "WifiDeviceFinder", "start process end time - " + (System.currentTimeMillis() - valueOf.longValue()));
                                }
                            }
                            z = true;
                            if (z4) {
                            }
                            if (z) {
                            }
                            gsy.O000000o(6, "WifiDeviceFinder", "start process end time - " + (System.currentTimeMillis() - valueOf.longValue()));
                        }
                    }
                    gsy.O00000o0(LogType.KUAILIAN, "scanResult", "WifiDeviceFinder scanResult is empty");
                    gsy.O000000o(6, "WifiDeviceFinder", "start process end time - " + (System.currentTimeMillis() - valueOf.longValue()));
                } catch (Exception unused) {
                }
            } else if (i == 2) {
                try {
                    ScanResult scanResult2 = (ScanResult) message2.obj;
                    if (scanResult2 != null && !DeviceFactory.O0000O0o(scanResult2)) {
                        Iterator<ScanResult> it = iae.O00000o0.iterator();
                        while (it.hasNext()) {
                            if (it.next().SSID.equals(scanResult2.SSID)) {
                                return;
                            }
                        }
                        Iterator<ScanResult> it2 = iae.O00000o.iterator();
                        while (it2.hasNext()) {
                            if (it2.next().SSID.equals(scanResult2.SSID)) {
                                return;
                            }
                        }
                        if (DeviceFactory.O0000OOo(scanResult2)) {
                            iae.O00000o0.add(scanResult2);
                            Intent intent = new Intent("wifi_scan_result_broadcast");
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.addAll(iae.O00000o0);
                            intent.putParcelableArrayListExtra("wifi_scan_result", arrayList3);
                            ft.O000000o(iae.this.O0000OOo).O000000o(intent);
                        } else if (DeviceFactory.O00000oo(scanResult2)) {
                            int i5 = 0;
                            while (true) {
                                if (i5 >= iae.O00000o.size()) {
                                    break;
                                } else if (iae.O00000o.get(i5).SSID.compareTo(scanResult2.SSID) > 0) {
                                    iae.O00000o.add(i5, scanResult2);
                                    break;
                                } else {
                                    i5++;
                                }
                            }
                            iae.O00000o.add(scanResult2);
                        }
                    }
                } catch (Exception unused2) {
                }
            }
        }
    }

    public final void O00000Oo() {
        O0000Ooo = this;
        this.O00000Oo = (NotificationManager) this.O0000OOo.getSystemService("notification");
        this.f1074O000000o = (WifiManager) this.O0000OOo.getSystemService("wifi");
        O00000o();
    }

    public static void O000000o(ScanResult scanResult) {
        if (scanResult != null) {
            Iterator<ScanResult> it = O00000o0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ScanResult next = it.next();
                if (next.BSSID.equals(scanResult.BSSID)) {
                    O00000o0.remove(next);
                    break;
                }
            }
            for (Map.Entry next2 : O00000oo.entrySet()) {
                if (((O000000o) next2.getValue()).O00000o0.BSSID.equals(scanResult.BSSID)) {
                    O00000oo.remove(next2.getKey());
                }
            }
            if (O0000Ooo != null) {
                Intent intent = new Intent("wifi_scan_result_broadcast");
                intent.putParcelableArrayListExtra("wifi_scan_result", O00000o0);
                ft.O000000o(SmartConfigRouterFactory.getSmartConfigManager().getAppContext()).O000000o(intent);
            }
        }
    }

    private static void O00000o() {
        String O00000o2 = fcb.O000000o().O00000o("wifi_ignore_list");
        if (O00000o2 != null) {
            try {
                JSONArray jSONArray = new JSONArray(O00000o2);
                for (int i = 0; i < jSONArray.length(); i++) {
                    O00000oO.put(jSONArray.optString(i), Integer.valueOf(i));
                }
            } catch (JSONException unused) {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (com.xiaomi.smarthome.device.DeviceFactory.O0000OOo(r3) == false) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (((r1 + 5) + 4) == r0.length()) goto L_0x002c;
     */
    static void O000000o(ScanResult scanResult, long j) {
        String str = scanResult.SSID;
        boolean z = true;
        if (!TextUtils.isEmpty(str) && (r1 = str.indexOf("_miap")) > 1) {
            String O0000o00 = DeviceFactory.O0000o00(str);
            if (!DeviceFactory.O0000O0o(O0000o00)) {
            }
        }
        z = false;
        if (!z) {
            O000000o o000000o = O00000oo.get(str);
            if (o000000o == null) {
                o000000o = new O000000o();
                O00000oo.put(str, o000000o);
                o000000o.O00000Oo = j;
                o000000o.f1079O000000o = j;
            }
            o000000o.O00000o0 = scanResult;
            o000000o.f1079O000000o = j;
        }
    }

    public final void O00000o0() {
        if (this.O0000Oo == null) {
            this.O0000Oo = new gpq("WifiDeviceFinder");
            this.O0000Oo.start();
            this.O0000OoO = new O00000Oo(this.O0000Oo.getLooper());
        }
        this.O0000OoO.removeMessages(1);
        this.O0000OoO.sendEmptyMessage(1);
    }
}
