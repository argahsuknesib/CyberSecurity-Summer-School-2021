package _m_j;

import _m_j.gov;
import android.app.Activity;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.miui.whetstone.WhetstoneManager;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.WifiSetting;
import com.xiaomi.smarthome.miio.camera.match.CameraDevice;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.wificonfig.BaseWifiSetting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fmw {
    private static fmw O0000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public HashMap<String, String> f16658O000000o = new HashMap<>();
    public Handler O00000Oo = new Handler() {
        /* class _m_j.fmw.AnonymousClass1 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
         arg types: [java.lang.String, int]
         candidates:
          org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
          org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
        public final void handleMessage(Message message) {
            BaseWifiSetting baseWifiSetting;
            switch (message.what) {
                case 101:
                default:
                    return;
                case 102:
                    break;
                case 103:
                    if (fmw.this.O00000Oo.hasMessages(102)) {
                        fmw.this.O00000o = message.arg1;
                    }
                    fno.O000000o().O0000OOo();
                    return;
                case 104:
                    final Device device = fmw.this.O00000o0.get(0);
                    AnonymousClass1 r0 = new huc() {
                        /* class _m_j.fmw.AnonymousClass1.AnonymousClass1 */

                        public final void O000000o(String str) {
                            fmw fmw = fmw.this;
                            fmw.O00000oO = false;
                            fmw.O000000o(fmw.O00000o0);
                            fmw.this.f16658O000000o.remove(device.did);
                            if (fnn.O000000o().O00000o() != -1) {
                                WifiSetting.startConnectWifi();
                            }
                        }

                        public final void O000000o(int i, String str) {
                            fmw.this.O00000o0();
                        }
                    };
                    fmw fmw = fmw.this;
                    Device device2 = fmw.O00000o0.get(0);
                    if (device2 instanceof CameraDevice) {
                        r0.O000000o(-1, "");
                    }
                    htq O000000o2 = htq.O000000o();
                    O000000o2.O000000o(device2, new hua<Integer, hud>(device2, new hua<Void, hud>(device2, r0) {
                        /* class _m_j.fmw.AnonymousClass5 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ Device f16667O000000o;
                        final /* synthetic */ huc O00000Oo;

                        {
                            this.f16667O000000o = r2;
                            this.O00000Oo = r3;
                        }

                        public final void O000000o(hud hud) {
                            huc huc = this.O00000Oo;
                            if (huc != null) {
                                huc.O000000o(hud.f693O000000o, "");
                            }
                        }

                        public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                            fno.O000000o().O000000o(this.f16667O000000o);
                            huc huc = this.O00000Oo;
                            if (huc != null) {
                                huc.O000000o(null);
                            }
                            gwe.O000000o().O000000o(this.f16667O000000o);
                        }
                    }) {
                        /* class _m_j.htq.AnonymousClass30 */

                        /* renamed from: O000000o */
                        final /* synthetic */ Device f671O000000o;
                        final /* synthetic */ hua O00000Oo;

                        {
                            this.f671O000000o = r2;
                            this.O00000Oo = r3;
                        }

                        public final /* synthetic */ void O000000o(Object obj) {
                            Integer num = (Integer) obj;
                            if (num.intValue() == 1) {
                                this.f671O000000o.setOwner(true);
                                this.f671O000000o.userId = SmartConfigRouterFactory.getCoreApiManager().getMiId();
                                this.O00000Oo.O000000o((Object) null);
                                return;
                            }
                            this.O00000Oo.O000000o(new hud(num.intValue(), ""));
                        }

                        public final void O000000o(hud hud) {
                            this.O00000Oo.O000000o(hud);
                        }
                    });
                    return;
                case 105:
                    fmw fmw2 = fmw.this;
                    int i = fmw2.O0000OoO;
                    fmw2.O0000OoO = i + 1;
                    if (i >= 30 || fmw.this.O0000Ooo) {
                        fmw.this.O00000o();
                        gsy.O000000o(LogType.KUAILIAN, "", "handleBindingSuccess, bingd");
                        fmw.this.O00000oO = false;
                    } else {
                        fmw.this.O00000Oo.sendEmptyMessageDelayed(105, 2000);
                    }
                    htq.O000000o().O00000Oo(fmw.this.O00000o0.get(0), new hua<Integer, hud>() {
                        /* class _m_j.fmw.AnonymousClass1.AnonymousClass2 */

                        public final void O000000o(hud hud) {
                        }

                        public final /* synthetic */ void O000000o(Object obj) {
                            Integer num = (Integer) obj;
                            if (num.intValue() == 1 && !fmw.this.O0000Ooo) {
                                gsy.O000000o(LogType.KUAILIAN, "", "bindDevice miio devices".concat(String.valueOf(num)));
                                fmw.this.O00000Oo.removeMessages(105);
                                fmw.this.O0000Ooo = true;
                                gwe.O000000o().O000000o(fmw.this.O00000o0.get(0));
                                fmw.this.O000000o(fmw.this.O00000o0);
                                if (fnn.O000000o().O00000o() != -1) {
                                    WifiSetting.startConnectWifi();
                                }
                            }
                        }
                    });
                    return;
                case 106:
                    fmw.this.O00000o = message.arg1;
                    fno.O000000o().O0000OOo();
                    MiioLocalAPI.O000000o();
                    try {
                        WhetstoneManager.wifiSmartConfigStop();
                        break;
                    } catch (Exception | NoSuchMethodError unused) {
                        break;
                    }
            }
            fmw.this.O00000Oo.removeMessages(101);
            fmw.this.O00000Oo.removeMessages(102);
            if (fmw.this.O0000Oo != null) {
                fmw.this.O0000Oo.O00000Oo();
            }
            long j = 0;
            if (fmw.this.O00000o == 0) {
                fmw.this.O00000o();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("kuailian_result", false);
                    jSONObject.put("reason", "find 0 device");
                    SmartConfigRouterFactory.getCoreApiManager().addSmartHomeStatRecord(StatType.EVENT, "kuailian_result", jSONObject.toString(), null, false);
                } catch (JSONException unused2) {
                }
                gsy.O00000o0(LogType.KUAILIAN, "", "kuailian_result false, find 0 device");
                fmw.this.O00000oo();
            } else if (fmw.this.O00000oo) {
                if (fmw.this.O00000o0.get(0).isBinded()) {
                    fmw.this.O0000Ooo = true;
                    fno.O000000o().O000000o(fmw.this.O00000o0.get(0));
                    gwe.O000000o().O000000o(fmw.this.O00000o0.get(0));
                    fmw fmw3 = fmw.this;
                    fmw3.O000000o(fmw3.O00000o0);
                    if (fnn.O000000o().O00000o() != -1) {
                        WifiSetting.startConnectWifi();
                    }
                } else {
                    fmw fmw4 = fmw.this;
                    if (fmw4.f16658O000000o.containsKey(fmw4.O00000o0.get(0).did)) {
                        fmw4.O00000o0.get(0).token = fmw4.f16658O000000o.get(fmw4.O00000o0.get(0).did);
                        if (!TextUtils.isEmpty(fmw4.O00000o0.get(0).token)) {
                            fmw4.O00000Oo.sendEmptyMessageDelayed(104, 0);
                        }
                    }
                    htq.O000000o().O00000Oo(fmw4.O00000o0.get(0).ip, new hua<String, hud>(new Handler(Looper.getMainLooper())) {
                        /* class _m_j.fmw.AnonymousClass4 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ Handler f16665O000000o;

                        {
                            this.f16665O000000o = r2;
                        }

                        public final /* synthetic */ void O000000o(Object obj) {
                            fmw.this.O00000o0.get(0).token = (String) obj;
                            fmw.this.O00000Oo.sendEmptyMessageDelayed(104, 0);
                        }

                        public final void O000000o(hud hud) {
                            this.f16665O000000o.post(new Runnable() {
                                /* class _m_j.fmw.AnonymousClass4.AnonymousClass1 */

                                public final void run() {
                                    fmw fmw = fmw.this;
                                    SmartConfigRouterFactory.getCoreApiManager().addSmartHomeStatRecord(StatType.TIME, "fetch_token_error", null, null, false);
                                    String str = "fetchToken onFailure ip = " + fmw.O00000o0.get(0).ip + " did = " + fmw.O00000o0.get(0).did;
                                    String O00000Oo = gog.O00000Oo(SmartConfigRouterFactory.getSmartConfigManager().getAppContext());
                                    if (O00000Oo != null) {
                                        str = str + " bssid = " + O00000Oo;
                                    }
                                    gsy.O00000o0(LogType.KUAILIAN, "", str);
                                    fmw.this.O00000o0();
                                    fmw.this.O00000oO = false;
                                }
                            });
                        }
                    });
                }
                if (iae.O000000o().O0000OOo == null) {
                    iae.O000000o().O0000OOo = SmartConfigRouterFactory.getSmartConfigManager().getAppContext();
                    iae.O000000o().O00000Oo();
                }
                iae.O000000o(fmw.this.O0000O0o);
            } else {
                fmw fmw5 = fmw.this;
                fmw5.O00000oO = false;
                fmw5.O000000o(fmw5.O00000o0);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("kuailian_result", true);
                    SmartConfigRouterFactory.getCoreApiManager().addSmartHomeStatRecord(StatType.EVENT, "kuailian_result", jSONObject2.toString(), null, false);
                } catch (JSONException unused3) {
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            fmw fmw6 = fmw.this;
            if (!(fmw6.O0000OOo == null || (baseWifiSetting = fmw6.O0000OOo.get()) == null || baseWifiSetting.isFinishing())) {
                j = baseWifiSetting.getStartTime();
            }
            long j2 = currentTimeMillis - j;
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("isApConnection", false);
                jSONObject3.put("isSingleDevice", fmw.this.O00000oo);
                jSONObject3.put("device_model", fmw.this.O00000oO());
                jSONObject3.put("connection_count", fmw.this.O00000o);
                jSONObject3.put("bssid", gog.O00000Oo(SmartConfigRouterFactory.getSmartConfigManager().getAppContext()));
                jSONObject3.put("ssid", gog.O00000o0(SmartConfigRouterFactory.getSmartConfigManager().getAppContext()));
                JSONArray jSONArray = new JSONArray();
                if (!fmw.this.O00000oo) {
                    for (Long longValue : fmw.this.O0000Oo0) {
                        jSONArray.put(System.currentTimeMillis() - longValue.longValue());
                    }
                    if (fmw.this.O0000Oo0.size() > 0) {
                        jSONObject3.put("conn_detail_time", jSONArray);
                    }
                }
                SmartConfigRouterFactory.getCoreApiManager().addSmartHomeStatRecord(StatType.TIME, "get_connection_statistic", Long.toString(j2), jSONObject3.toString(), false);
            } catch (JSONException unused4) {
            }
        }
    };
    public int O00000o = 0;
    List<Device> O00000o0 = new ArrayList();
    boolean O00000oO = false;
    boolean O00000oo = false;
    public ScanResult O0000O0o;
    WeakReference<BaseWifiSetting> O0000OOo;
    gov O0000Oo;
    public List<Long> O0000Oo0 = new ArrayList();
    public int O0000OoO = 0;
    public boolean O0000Ooo = false;
    private Map<String, Boolean> O0000o00 = new HashMap();
    private long O0000o0O = 0;
    private int O0000o0o = 0;

    public static fmw O000000o() {
        if (O0000o0 == null) {
            O0000o0 = new fmw();
        }
        return O0000o0;
    }

    public final void O000000o(Activity activity, ScanResult scanResult) {
        this.O00000o0.clear();
        this.O00000oO = true;
        if (scanResult != null) {
            this.O00000oo = true;
            this.O0000O0o = scanResult;
        } else {
            this.O00000oo = true;
        }
        this.O0000OOo = new WeakReference<>((BaseWifiSetting) activity);
        this.O0000Oo0.clear();
        this.O00000o = 0;
        this.O00000Oo.sendEmptyMessage(101);
        this.O00000Oo.sendEmptyMessageDelayed(102, 70000);
        gov gov = this.O0000Oo;
        if (gov != null) {
            gov.O00000Oo();
        }
        this.O0000Oo = new gov();
        gov gov2 = this.O0000Oo;
        gov2.O00000oo = new Runnable() {
            /* class _m_j.fmw.AnonymousClass2 */

            public final void run() {
                gsy.O00000Oo(LogType.KUAILIAN, "Search", "StopSearch");
            }
        };
        gov2.O00000oO = 70000;
        this.O0000o0o = 0;
        this.O0000Oo.O000000o(new gov.O000000o(null) {
            /* class _m_j.fmw.AnonymousClass3 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ String f16663O000000o = null;

            public final void O000000o() {
                htq.O000000o().O000000o(SmartConfigRouterFactory.getSmartConfigManager().getAppContext(), this.f16663O000000o, false, fmw.this.O0000O0o != null ? fmw.this.O0000O0o.BSSID : null, null, null, null, fmw.this.O00000oO(), new hua<List<Device>, hud>() {
                    /* class _m_j.fmw.AnonymousClass3.AnonymousClass1 */

                    public final void O000000o(hud hud) {
                    }

                    public final /* synthetic */ void O000000o(Object obj) {
                        BaseWifiSetting baseWifiSetting;
                        int size = fmw.this.O00000o0.size();
                        for (Device device : (List) obj) {
                            Device device2 = null;
                            if (fmw.this.O00000o0.size() > 0) {
                                Iterator<Device> it = fmw.this.O00000o0.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (it.next().did.equalsIgnoreCase(device.did)) {
                                            device2 = device;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                            if (device2 == null) {
                                fmw.this.O00000o0.add(device);
                                device.scrollTo = true;
                                device.isNew = true;
                                htk.O000000o();
                                htk.O00000Oo(device.did);
                                fmw.this.O0000Oo0.add(Long.valueOf(System.currentTimeMillis()));
                            }
                        }
                        if (size != fmw.this.O00000o0.size()) {
                            Message obtainMessage = fmw.this.O00000Oo.obtainMessage();
                            if (fmw.this.O00000oo) {
                                obtainMessage.what = 106;
                            } else {
                                obtainMessage.what = 103;
                                fmw fmw = fmw.this;
                                List<Device> list = fmw.this.O00000o0;
                                if (!(fmw.O0000OOo == null || (baseWifiSetting = fmw.O0000OOo.get()) == null || baseWifiSetting.isFinishing())) {
                                    baseWifiSetting.onDeviceFindDevices(list.size());
                                    baseWifiSetting.onDeviceConnectionSuccess(list, false);
                                }
                            }
                            obtainMessage.arg1 = fmw.this.O00000o0.size();
                            fmw.this.O00000Oo.sendMessage(obtainMessage);
                        }
                    }
                });
                fmw.this.O0000Oo.O00000o0();
            }
        }, 5000);
        this.O0000Oo.O000000o();
        this.O0000o0O = System.currentTimeMillis();
    }

    public final boolean O000000o(String str) {
        if (this.O0000o00.containsKey(str)) {
            return this.O0000o00.get(str).booleanValue();
        }
        return true;
    }

    public final void O00000Oo() {
        if (this.O00000oO) {
            this.O00000oO = false;
            this.O00000Oo.removeMessages(102);
            MiioLocalAPI.O000000o();
            this.O0000Oo.O00000Oo();
        }
    }

    public final void O00000o() {
        BaseWifiSetting baseWifiSetting;
        WeakReference<BaseWifiSetting> weakReference = this.O0000OOo;
        if (weakReference != null && (baseWifiSetting = weakReference.get()) != null && !baseWifiSetting.isFinishing()) {
            baseWifiSetting.onDeviceConnectionError();
        }
    }

    public final void O000000o(List<Device> list) {
        BaseWifiSetting baseWifiSetting;
        WeakReference<BaseWifiSetting> weakReference = this.O0000OOo;
        if (weakReference != null && (baseWifiSetting = weakReference.get()) != null && !baseWifiSetting.isFinishing()) {
            baseWifiSetting.onDeviceConnectionSuccess(list, true);
        }
    }

    public final String O00000oO() {
        BaseWifiSetting baseWifiSetting;
        WeakReference<BaseWifiSetting> weakReference = this.O0000OOo;
        return (weakReference == null || (baseWifiSetting = weakReference.get()) == null || baseWifiSetting.isFinishing()) ? "" : baseWifiSetting.getConnDeviceModel();
    }

    public final void O00000oo() {
        if (!TextUtils.isEmpty(gog.O00000Oo(SmartConfigRouterFactory.getSmartConfigManager().getAppContext()))) {
            this.O0000o00.put(gog.O00000Oo(SmartConfigRouterFactory.getSmartConfigManager().getAppContext()), Boolean.FALSE);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public final void O00000o0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("kuailian_result", false);
            jSONObject.put("reason", "network bind error");
            SmartConfigRouterFactory.getCoreApiManager().addSmartHomeStatRecord(StatType.EVENT, "kuailian_result", jSONObject.toString(), null, false);
        } catch (JSONException unused) {
        }
        gsy.O00000o0(LogType.KUAILIAN, "", "kuailian_result false, network bind error");
        O000000o(this.O00000o0);
        this.O00000oO = false;
    }
}
