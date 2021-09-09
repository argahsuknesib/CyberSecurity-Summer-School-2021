package com.xiaomi.smarthome.service;

import _m_j.dcp;
import _m_j.ezu;
import _m_j.fke;
import _m_j.fmy;
import _m_j.fnu;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.fux;
import _m_j.ggb;
import _m_j.gpq;
import _m_j.gpv;
import _m_j.gpy;
import _m_j.gsy;
import _m_j.hlz;
import _m_j.hna;
import _m_j.htt;
import _m_j.htx;
import _m_j.hty;
import _m_j.hvg;
import _m_j.hxc;
import _m_j.hxi;
import android.app.ActivityManager;
import android.app.DownloadManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.miui.FindDeviceDialogActivity;
import com.xiaomi.smarthome.nfctag.ui.NFCDeviceDialogActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceObserveService extends BroadcastReceiver {
    private static DeviceObserveService O0000OoO;

    /* renamed from: O000000o  reason: collision with root package name */
    HashSet<String> f11342O000000o = null;
    public HashMap<String, Long> O00000Oo = null;
    NotificationManager O00000o;
    HashSet<String> O00000o0 = new HashSet<>();
    public volatile Handler O00000oO = null;
    public boolean O00000oo = true;
    private WifiManager O0000O0o;
    private DownloadManager O0000OOo;
    private boolean O0000Oo = false;
    private final Object O0000Oo0 = new Object();
    private Map<String, Long> O0000Ooo = new HashMap();

    public static DeviceObserveService O000000o() {
        if (O0000OoO == null) {
            O0000OoO = new DeviceObserveService();
        }
        return O0000OoO;
    }

    public final void O00000Oo() {
        if (O00000o0()) {
            Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
            if (O0000Oo02 == null || !O0000Oo02.isOwner()) {
                gsy.O000000o(6, "DeviceObserveService", "home is shared");
                return;
            }
            Handler handler = this.O00000oO;
            if (handler != null) {
                handler.sendEmptyMessage(1);
                return;
            }
            return;
        }
        gsy.O000000o(6, "DeviceObserveService", "cta not passed");
    }

    public final boolean O00000o0() {
        boolean z = false;
        if (!ezu.O000000o()) {
            return false;
        }
        if (this.O00000oO == null) {
            this.O0000O0o = (WifiManager) CommonApplication.getAppContext().getApplicationContext().getSystemService("wifi");
            this.O00000o = (NotificationManager) CommonApplication.getAppContext().getSystemService("notification");
            this.O0000OOo = (DownloadManager) CommonApplication.getAppContext().getSystemService("download");
            Context appContext = CommonApplication.getAppContext();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) appContext.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                String packageName = appContext.getPackageName();
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.importance == 100 && next.processName.equals(packageName)) {
                        z = true;
                        break;
                    }
                }
            }
            this.O0000Oo = z;
            synchronized (this.O0000Oo0) {
                if (this.O00000oO == null) {
                    gpq gpq = new gpq("device_observer");
                    gpq.start();
                    this.O00000oO = new Handler(gpq.getLooper()) {
                        /* class com.xiaomi.smarthome.service.DeviceObserveService.AnonymousClass1 */

                        public final void handleMessage(Message message) {
                            int i = message.what;
                            if (i == 1) {
                                DeviceObserveService.this.O00000oO();
                            } else if (i == 2) {
                                String str = (String) message.obj;
                                DeviceObserveService deviceObserveService = DeviceObserveService.this;
                                deviceObserveService.O00000oo = true;
                                synchronized (deviceObserveService) {
                                    deviceObserveService.O00000oo();
                                    deviceObserveService.f11342O000000o.add(str);
                                }
                                JSONArray jSONArray = new JSONArray();
                                deviceObserveService.O00000oo();
                                Iterator<String> it = deviceObserveService.f11342O000000o.iterator();
                                while (it.hasNext()) {
                                    jSONArray.put(it.next());
                                }
                                gpv.O00000Oo("ignore_device", jSONArray.toString());
                                deviceObserveService.O00000oO();
                            } else if (i == 3) {
                                DeviceObserveService.this.O00000oo = false;
                            } else if (i == 4) {
                                gsy.O000000o(6, "DeviceObserveService", "on msg smart config stop");
                                DeviceObserveService deviceObserveService2 = DeviceObserveService.this;
                                String str2 = (String) message.obj;
                                int i2 = message.arg1;
                                deviceObserveService2.O00000oo = true;
                                synchronized (deviceObserveService2) {
                                    deviceObserveService2.O0000O0o();
                                    deviceObserveService2.O00000o0.add(str2);
                                }
                                deviceObserveService2.O00000oO();
                            }
                        }
                    };
                }
            }
        }
        return true;
    }

    public final void O000000o(String str) {
        Handler handler;
        if (O00000o0() && (handler = this.O00000oO) != null) {
            handler.sendMessage(this.O00000oO.obtainMessage(3, str));
        }
    }

    public final void O000000o(String str, boolean z) {
        Handler handler;
        if (O00000o0() && (handler = this.O00000oO) != null) {
            handler.sendMessage(this.O00000oO.obtainMessage(4, z ^ true ? 1 : 0, 0, str));
        }
    }

    public final void O00000o() {
        JSONObject jSONObject = new JSONObject();
        for (String next : this.O00000Oo.keySet()) {
            try {
                jSONObject.put(next, this.O00000Oo.get(next));
            } catch (JSONException unused) {
            }
        }
        gpv.O00000Oo("notified_device", jSONObject.toString());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    public final void O00000oO() {
        gsy.O000000o(6, "DeviceObserveService", "start process scan result");
        if (!this.O00000oo) {
            gsy.O000000o(6, "DeviceObserveService", "doing smart config");
        }
        if (!gpy.O00000o0(CommonApplication.getAppContext(), "prefs_lite_config", "miui_auto_discovery", false)) {
            gsy.O000000o(6, "DeviceObserveService", "disable auto discovery");
            return;
        }
        if (this.O00000Oo == null) {
            this.f11342O000000o = new HashSet<>();
            this.O00000Oo = new HashMap<>();
            String O000000o2 = gpv.O000000o("notified_device", "");
            String O000000o3 = gpv.O000000o("ignore_device", "");
            try {
                JSONObject jSONObject = new JSONObject(O000000o2);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    this.O00000Oo.put(next, Long.valueOf(jSONObject.getLong(next)));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                JSONArray jSONArray = new JSONArray(O000000o3);
                O00000oo();
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.f11342O000000o.add(jSONArray.optString(i));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (fux.O000000o()) {
            try {
                List<ScanResult> scanResults = this.O0000O0o.getScanResults();
                if (scanResults != null) {
                    gsy.O000000o(6, "DeviceObserveService", "scan result size - " + scanResults.size());
                    ArrayList arrayList = new ArrayList();
                    O00000oo();
                    for (ScanResult next2 : scanResults) {
                        if (Pattern.matches("\\w+-\\w+-\\w+_mi(?:ap|bt|dev)\\w{4}", next2.SSID) && !this.f11342O000000o.contains(next2.SSID)) {
                            arrayList.add(next2);
                        }
                    }
                    if (arrayList.size() > 0) {
                        for (int i2 = 0; i2 < arrayList.size(); i2++) {
                            final ScanResult scanResult = (ScanResult) arrayList.get(i2);
                            if (DeviceFactory.O00000oo(scanResult)) {
                                Intent intent = new Intent("wifi_scan_device");
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(scanResult);
                                intent.putParcelableArrayListExtra("wifi_scan_device_result", arrayList2);
                                ft.O000000o(CommonApplication.getAppContext()).O000000o(intent);
                            }
                            if (this.O00000oO != null) {
                                this.O00000oO.postDelayed(new Runnable() {
                                    /* class com.xiaomi.smarthome.service.DeviceObserveService.AnonymousClass2 */

                                    public final void run() {
                                        DeviceObserveService.this.O000000o(scanResult);
                                    }
                                }, (long) (i2 * 3000));
                            }
                        }
                        return;
                    }
                    gsy.O000000o(6, "DeviceObserveService", "find no result");
                }
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000oo() {
        if (this.f11342O000000o == null) {
            this.f11342O000000o = new HashSet<>();
        }
    }

    /* access modifiers changed from: package-private */
    public final void O0000O0o() {
        if (this.O00000o0 == null) {
            this.O00000o0 = new HashSet<>();
        }
    }

    public final void O000000o(ScanResult scanResult) {
        CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new CoreApi.O0000o0(scanResult) {
            /* class com.xiaomi.smarthome.service.$$Lambda$DeviceObserveService$5erpe_51Lwz_ejf9HCPjk9owWVw */
            private final /* synthetic */ ScanResult f$1;

            {
                this.f$1 = r2;
            }

            public final void onCoreReady() {
                DeviceObserveService.this.O00000o0(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(final ScanResult scanResult) {
        hlz.O000000o(DeviceFactory.O0000Ooo(scanResult.SSID), new fsm<hlz.O000000o, fso>() {
            /* class com.xiaomi.smarthome.service.DeviceObserveService.AnonymousClass3 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
             arg types: [android.content.Context, java.lang.String, java.lang.String, int]
             candidates:
              _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
              _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
            /* JADX WARNING: Removed duplicated region for block: B:38:0x0116  */
            /* JADX WARNING: Removed duplicated region for block: B:40:0x013c  */
            public final /* synthetic */ void onSuccess(Object obj) {
                htx htx;
                boolean z;
                htx O000000o2;
                htx O000000o3;
                hlz.O000000o o000000o = (hlz.O000000o) obj;
                int i = o000000o.O00000oO;
                if (Build.PRODUCT.equals("gemini") || Build.PRODUCT.equals("lithium")) {
                    i += 5;
                }
                if (scanResult.level >= i || hna.O00000Oo().isSHMainActivityResumed()) {
                    DeviceObserveService deviceObserveService = DeviceObserveService.this;
                    String str = o000000o.O00000o;
                    String str2 = o000000o.O00000o0;
                    String str3 = o000000o.f19057O000000o;
                    String str4 = o000000o.O00000Oo;
                    ScanResult scanResult = scanResult;
                    if (!gpy.O00000o0(CommonApplication.getAppContext(), "prefs_lite_config", "miui_auto_discovery", false) && CommonApplication.getForegroundActivityCount() == 0) {
                        gsy.O000000o(6, "DeviceObserveService", "disable auto discovery");
                    } else if (deviceObserveService.O00000o != null) {
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(CommonApplication.getAppContext());
                        builder.O000000o((int) R.drawable.mj_notify_icon);
                        builder.O000000o(CommonApplication.getAppContext().getResources().getString(R.string.wifi_scan_new_device_title));
                        builder.O000000o(System.currentTimeMillis());
                        builder.O00000Oo();
                        htx O000000o4 = hty.O000000o();
                        if (O000000o4 != null) {
                            Intent intent = null;
                            if (htt.O000000o(str2)) {
                                if (!(TextUtils.isEmpty(str2) || scanResult == null || (O000000o3 = hty.O000000o()) == null)) {
                                    intent = new Intent(CommonApplication.getAppContext(), O000000o3.getConfigRouterStationActivity());
                                    intent.putExtra("model", str2);
                                    intent.putExtra("mac", scanResult.BSSID);
                                    intent.putExtra("scanResult", scanResult);
                                }
                            } else if (!htt.O00000Oo(str2)) {
                                htx = O000000o4;
                                intent = O000000o4.getSmartConfigIntent(CommonApplication.getAppContext(), scanResult, str2, null, null);
                                if (intent != null) {
                                    gsy.O000000o(6, "DeviceObserveService", "notifyFindDevice - intent is null scanResult:" + scanResult + ",  model:" + str2 + " enableScan:" + deviceObserveService.O00000oo);
                                    return;
                                }
                                intent.putExtra("category", 1);
                                PendingIntent activity = PendingIntent.getActivity(CommonApplication.getAppContext(), scanResult.SSID.hashCode(), intent, 134217728);
                                StringBuilder sb = new StringBuilder("current - ");
                                sb.append(scanResult.frequency);
                                sb.append(", ");
                                sb.append(FindDeviceDialogActivity.sResumed);
                                sb.append(", ");
                                sb.append(CommonApplication.getForegroundActivityCount() == 0);
                                sb.append(", ");
                                sb.append(hna.O00000Oo().isSHMainActivityResumed());
                                sb.append(" enableScan:");
                                sb.append(deviceObserveService.O00000oo);
                                sb.append("  SSID");
                                sb.append(scanResult.SSID);
                                gsy.O000000o(6, "DeviceObserveService", sb.toString());
                                if (CommonApplication.getForegroundActivityCount() == 0 || hna.O00000Oo().isSHMainActivityResumed()) {
                                    if (deviceObserveService.O00000Oo.containsKey(scanResult.SSID) && System.currentTimeMillis() - deviceObserveService.O00000Oo.get(scanResult.SSID).longValue() < 3600000) {
                                        gsy.O000000o(6, "DeviceObserveService", "mNotifiedSSIDs containsKey  last show time:" + deviceObserveService.O00000Oo.get(scanResult.SSID));
                                        return;
                                    } else if (fnu.O000000o.f16724O000000o.O000000o()) {
                                        gsy.O000000o(6, "DeviceObserveService", "XiaoMiRouterConnectionManager isShowing");
                                        return;
                                    } else if (FindDeviceDialogActivity.sResumed) {
                                        gsy.O000000o(6, "DeviceObserveService", "FindDeviceDialogActivity.sResumed");
                                        return;
                                    } else if (NFCDeviceDialogActivity.sResumed) {
                                        gsy.O000000o(6, "DeviceObserveService", "NFCDeviceDialogActivity.sResumed");
                                        return;
                                    } else if (!deviceObserveService.O00000oo) {
                                        gsy.O000000o(6, "DeviceObserveService", "enableScan is false");
                                        return;
                                    } else if (dcp.O000000o().O00000o0() || fmy.O00000o != null) {
                                        gsy.O000000o(6, "mainconnect", "miui or mainconnect is showing, don't show");
                                        return;
                                    } else {
                                        if (DeviceFactory.O00000oo(scanResult)) {
                                            Iterator<ScanResult> it = DeviceRouterFactory.getApDeviceManager().getDiscoveredUnconnectDevice().iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    if (it.next().SSID.equals(scanResult.SSID)) {
                                                        z = true;
                                                        break;
                                                    }
                                                } else {
                                                    z = false;
                                                    break;
                                                }
                                            }
                                            if (!z) {
                                                gsy.O000000o(6, "DeviceObserveService", "getDiscoveredUnconnectDevice not find " + scanResult.SSID);
                                                return;
                                            }
                                        }
                                        if (DeviceFactory.O0000Oo0(scanResult)) {
                                            if (fmy.O00000o0().O00000o(DeviceFactory.O0000Oo(scanResult).toUpperCase())) {
                                                gsy.O000000o(6, "mainconnect", "this wifi device is in ignored combo key list");
                                                return;
                                            } else if (!fmy.O00000o0().O00000Oo(DeviceFactory.O00000o0(scanResult.BSSID, scanResult.SSID))) {
                                                gsy.O000000o(6, "mainconnect", "time limit, return");
                                                return;
                                            }
                                        }
                                        hvg.O000000o(CommonApplication.getAppContext()).O000000o(str2);
                                        hxc.O000000o().O000000o(str2, 5);
                                        Intent intent2 = new Intent(CommonApplication.getAppContext(), FindDeviceDialogActivity.class);
                                        if (CommonApplication.getApplication().isAppForeground()) {
                                            intent2.addFlags(8388608);
                                        }
                                        intent2.addFlags(536870912);
                                        intent2.addFlags(4194304);
                                        intent2.addFlags(268435456);
                                        intent2.putExtra("find_device", scanResult);
                                        intent2.putExtra("device_name", str);
                                        intent2.putExtra("model", str2);
                                        intent2.putExtra("image_url", str3);
                                        intent2.putExtra("video_url", str4);
                                        intent2.putExtra("from_miui", CommonApplication.getForegroundActivityCount() == 0);
                                        intent2.putExtra("timestamp", System.currentTimeMillis());
                                        builder.O0000O0o = PendingIntent.getActivity(CommonApplication.getAppContext(), R.string.app_name, intent2, 134217728);
                                        builder.O000000o(android.support.v4.app.NotificationCompat.FLAG_HIGH_PRIORITY, true);
                                        String quantityString = CommonApplication.getAppContext().getResources().getQuantityString(R.plurals.wifi_scan_new_device, 1, 1, str);
                                        builder.O000000o(CommonApplication.getAppContext().getResources().getString(R.string.wifi_scan_new_device_title));
                                        builder.O00000Oo(quantityString);
                                        builder.O00000oo = activity;
                                        builder.O0000Ooo = 1;
                                        int hashCode = scanResult.SSID.hashCode();
                                        if (Build.VERSION.SDK_INT >= 26) {
                                            builder.O000OO00 = fke.O000000o(deviceObserveService.O00000o, CommonApplication.getAppContext());
                                        }
                                        deviceObserveService.O00000o.notify(hashCode, builder.O00000o());
                                        synchronized (deviceObserveService) {
                                            deviceObserveService.O0000O0o();
                                            deviceObserveService.O00000o0.remove(scanResult.SSID);
                                            deviceObserveService.O00000Oo.put(scanResult.SSID, Long.valueOf(System.currentTimeMillis()));
                                        }
                                        gsy.O000000o(6, "DeviceObserveService", "start notify - ".concat(String.valueOf(hashCode)));
                                        hxi.O00000oO.f958O000000o.O000000o("miui_push_find", "model", str2);
                                        deviceObserveService.O00000o();
                                    }
                                }
                                htx.onScanResultAvailable(scanResult);
                                return;
                            } else if (!(TextUtils.isEmpty(str2) || scanResult == null || (O000000o2 = hty.O000000o()) == null)) {
                                intent = new Intent(CommonApplication.getAppContext(), O000000o2.getConfigRouterSubDeviceActivity());
                                intent.putExtra("device_model", str2);
                                intent.putExtra("key_qrcode_oob", "");
                                intent.putExtra("mac", scanResult.BSSID);
                                intent.putExtra("scanResult", scanResult);
                            }
                            htx = O000000o4;
                            if (intent != null) {
                            }
                        }
                    }
                }
            }

            public final void onFailure(fso fso) {
                gsy.O00000Oo("DeviceObserveService", "requestDeviceImage ERROR");
            }
        });
    }

    public final boolean O00000Oo(ScanResult scanResult) {
        if (scanResult == null) {
            return false;
        }
        synchronized (this) {
            if (this.f11342O000000o != null && this.f11342O000000o.contains(scanResult.SSID)) {
                return false;
            }
            if (this.O00000o0 == null || !this.O00000o0.contains(scanResult.SSID)) {
                return true;
            }
            return false;
        }
    }

    public void onReceive(Context context, Intent intent) {
        O000000o().O00000Oo();
    }
}
