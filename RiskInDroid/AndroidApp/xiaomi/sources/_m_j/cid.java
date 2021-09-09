package _m_j;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.mijia.model.alarmcloud.AlarmCloudManager;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.FirmwareUpdateResult;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cid extends chs {
    private static ArrayList<cid> O0000oOo = new ArrayList<>();
    public boolean O00000o = false;
    public boolean O00000o0 = false;
    private clj O0000O0o = null;
    private clr O0000OOo = null;
    private clq O0000Oo = null;
    private cls O0000Oo0 = null;
    private cht O0000OoO = null;
    private chz O0000Ooo = null;
    private clg O0000o = null;
    private clp O0000o0 = null;
    private clo O0000o00 = null;
    private cld O0000o0O = null;
    private cle O0000o0o = null;
    private AlarmCloudManager O0000oO = null;
    private cit O0000oO0 = null;
    private String O0000oOO = "";

    public final synchronized AlarmCloudManager O00000oo() {
        if (this.O0000oO == null) {
            this.O0000oO = new AlarmCloudManager(this);
        }
        return this.O0000oO;
    }

    public final synchronized clj O0000O0o() {
        if (this.O0000O0o == null) {
            this.O0000O0o = new clj(this);
        }
        return this.O0000O0o;
    }

    public final synchronized clr O0000OOo() {
        if (this.O0000OOo == null) {
            this.O0000OOo = new clr(this);
        }
        return this.O0000OOo;
    }

    public final synchronized cls O0000Oo0() {
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = new cls(this);
        }
        return this.O0000Oo0;
    }

    public final synchronized clq O0000Oo() {
        if (this.O0000Oo == null) {
            this.O0000Oo = new clq(this);
        }
        return this.O0000Oo;
    }

    public final synchronized cht O0000OoO() {
        if (this.O0000OoO == null) {
            this.O0000OoO = new cht(this);
        }
        return this.O0000OoO;
    }

    public final synchronized chz O0000Ooo() {
        if (this.O0000Ooo == null) {
            this.O0000Ooo = new chz(this);
        }
        return this.O0000Ooo;
    }

    public final synchronized clo O0000o00() {
        if (this.O0000o00 == null) {
            this.O0000o00 = new clo(this);
        }
        return this.O0000o00;
    }

    public final synchronized clp O0000o0() {
        if (this.O0000o0 == null) {
            this.O0000o0 = new clp(this);
        }
        return this.O0000o0;
    }

    public final synchronized cld O0000o0O() {
        if (this.O0000o0O == null) {
            this.O0000o0O = new cld(this);
        }
        return this.O0000o0O;
    }

    public final synchronized cle O0000o0o() {
        if (this.O0000o0o == null) {
            this.O0000o0o = new cle(this);
        }
        return this.O0000o0o;
    }

    public final synchronized clg O0000o() {
        if (this.O0000o == null) {
            this.O0000o = new clg(this);
        }
        return this.O0000o;
    }

    public final synchronized cit O0000oO0() {
        if (this.O0000oO0 == null) {
            this.O0000oO0 = new cit(this);
        }
        return this.O0000oO0;
    }

    public static synchronized cid O000000o(DeviceStat deviceStat, String str) {
        synchronized (cid.class) {
            Iterator<cid> it = O0000oOo.iterator();
            while (it.hasNext()) {
                cid next = it.next();
                if (deviceStat.did.equals(next.getDid()) && next.O0000oOO.equals(str)) {
                    next.mDeviceStat = deviceStat;
                    return next;
                }
            }
            cid cid = new cid(deviceStat);
            cid.O0000oOO = str;
            O0000oOo.add(cid);
            return cid;
        }
    }

    public final boolean O0000oO() {
        return (this.mDeviceStat == null || this.mDeviceStat.isSetPinCode == 0) ? false : true;
    }

    public final boolean O0000oOO() {
        return "isa.camera.hlc6".equals(getModel());
    }

    public cid(DeviceStat deviceStat) {
        super(deviceStat);
        String O00000o02 = O00000o0();
        gsy.O00000Oo("CameraPlay", "deviceVersion:" + O00000o02 + " model:" + deviceStat.model);
        if (!TextUtils.isEmpty(O00000o02) && ((("chuangmi.camera.ipc009".equals(deviceStat.model) || "chuangmi.camera.ipc019".equals(deviceStat.model)) && cin.O000000o(O00000o02, "3.5.1_0399") > 0) || DeviceConstant.isNewChuangmi(deviceStat.model))) {
            this.f13830O000000o = true;
        } else if (!TextUtils.isEmpty(O00000o02) && "mijia.camera.v3".equals(deviceStat.model) && cin.O00000Oo(O00000o02, "3.5.1_0070") > 0) {
            this.f13830O000000o = true;
        } else if ("isa.camera.hlc6".equals(deviceStat.model)) {
            this.f13830O000000o = true;
        } else {
            this.f13830O000000o = false;
        }
        O000O0Oo();
    }

    public final String O0000oOo() {
        return this.O00000oo;
    }

    public final String O0000oo0() {
        return TextUtils.isEmpty(this.O0000oOO) ? getDid() : this.O0000oOO;
    }

    public final void updateDeviceStatus() {
        super.updateDeviceStatus();
        String O00000o02 = O00000o0();
        if (!TextUtils.isEmpty(O00000o02) && this.mDeviceStat != null && ((("chuangmi.camera.ipc009".equals(this.mDeviceStat.model) || "chuangmi.camera.ipc019".equals(this.mDeviceStat.model)) && cin.O000000o(O00000o02, "3.5.1_0399") > 0) || DeviceConstant.isNewChuangmi(this.mDeviceStat.model))) {
            this.f13830O000000o = true;
        } else if (!TextUtils.isEmpty(O00000o02) && this.mDeviceStat != null && "mijia.camera.v3".equals(this.mDeviceStat.model) && cin.O00000Oo(O00000o02, "3.5.1_0070") > 0) {
            this.f13830O000000o = true;
        } else if (this.mDeviceStat == null || !"isa.camera.hlc6".equals(this.mDeviceStat.model)) {
            this.f13830O000000o = false;
        } else {
            this.f13830O000000o = true;
        }
        O000O0Oo();
    }

    private void O000O0Oo() {
        cig.O000000o(new Callback<String>() {
            /* class _m_j.cid.AnonymousClass1 */

            /* JADX WARNING: Can't wrap try/catch for region: R(7:17|(2:23|(3:25|26|(3:28|29|(2:31|32))))|33|34|(1:36)(1:37)|38|39) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0090 */
            /* JADX WARNING: Removed duplicated region for block: B:36:0x009a A[Catch:{ JSONException -> 0x009f }] */
            /* JADX WARNING: Removed duplicated region for block: B:37:0x009b A[Catch:{ JSONException -> 0x009f }] */
            public final /* synthetic */ void onSuccess(Object obj) {
                String str = (String) obj;
                cid cid = cid.this;
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    if (jSONArray.length() != 0) {
                        boolean z = false;
                        String str2 = "";
                        int i = 0;
                        while (i < jSONArray.length()) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            String string = jSONObject.getString("model");
                            str2 = jSONObject.getString("version");
                            if (!TextUtils.isEmpty(cid.getModel()) && cid.getModel().equals(string)) {
                                break;
                            }
                            i++;
                        }
                        if (i >= jSONArray.length()) {
                            cid.O00000o = true;
                            return;
                        }
                        if (!TextUtils.isEmpty(cid.getModel()) && cid.getModel().contains("chuangmi") && !TextUtils.isEmpty(cid.O00000o0())) {
                            String[] split = cid.O00000o0().split("[_]");
                            if (split.length >= 2) {
                                String str3 = split[split.length - 1];
                                if (str3.length() == 4) {
                                    if (Integer.parseInt(str3) >= 400) {
                                        cid.O00000o = true;
                                        return;
                                    }
                                }
                            }
                        }
                        if (cin.O00000o0(cid.O00000o0(), str2) <= 0) {
                            z = true;
                        }
                        cid.O00000o = z;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            public final void onFailure(int i, String str) {
                cid cid = cid.this;
                cid.O00000o = cid.f13830O000000o;
            }
        });
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|(2:4|5)|6|7|(2:9|(4:11|12|(4:14|15|16|(2:20|(1:22)(1:23)))|24))|27|28) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0039 */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003f A[Catch:{ JSONException -> 0x008a }] */
    public final void O000000o(Context context, final Callback<FirmwareUpdateResult> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", deviceStat().did);
            jSONObject.put("platform", "android");
            if (context != null) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                StringBuilder sb = new StringBuilder();
                sb.append(packageInfo.versionCode);
                jSONObject.put("app_level", sb.toString());
            }
            if (deviceStat() != null) {
                String str = deviceStat().model;
                if (!TextUtils.isEmpty(str)) {
                    if (!str.equals("chuangmi.camera.ipc009")) {
                        if (!str.equals("chuangmi.camera.ipc019") && !str.equals("chuangmi.camera.ipc021")) {
                            if (!str.equals("chuangmi.camera.021a04")) {
                                jSONObject.put("plugin_level", deviceStat().version);
                            }
                        }
                    }
                    jSONObject.put("plugin_level", "96");
                }
            }
        } catch (JSONException e) {
            callback.onFailure(-9999, e.getLocalizedMessage());
        }
        XmPluginHostApi.instance().callSmartHomeApi(deviceStat().model, "/v2/device/check_device_version", jSONObject, new Callback<JSONObject>() {
            /* class _m_j.cid.AnonymousClass7 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                Callback callback = callback;
                if (callback == null) {
                    return;
                }
                if (jSONObject != null) {
                    FirmwareUpdateResult firmwareUpdateResult = new FirmwareUpdateResult();
                    firmwareUpdateResult.isLatest = jSONObject.optBoolean("isLatest");
                    firmwareUpdateResult.updating = jSONObject.optBoolean("updating");
                    firmwareUpdateResult.curr = jSONObject.optString("curr");
                    firmwareUpdateResult.latest = jSONObject.optString("latest");
                    firmwareUpdateResult.description = jSONObject.optString("description");
                    firmwareUpdateResult.ota_progress = jSONObject.optInt("ota_progress");
                    firmwareUpdateResult.ota_status = jSONObject.optString("ota_status");
                    firmwareUpdateResult.timeout = jSONObject.optInt("timeout_time");
                    firmwareUpdateResult.force = jSONObject.optBoolean("force");
                    firmwareUpdateResult.rec = jSONObject.optBoolean("rec", true);
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) - jSONObject.optLong("ota_start_time");
                    int i = (int) (currentTimeMillis / 2);
                    if (firmwareUpdateResult.timeout > 0) {
                        i = (int) ((currentTimeMillis / ((long) firmwareUpdateResult.timeout)) * 90);
                    }
                    if (i > 90) {
                        i = 90;
                    }
                    if (i > firmwareUpdateResult.ota_progress) {
                        firmwareUpdateResult.ota_progress = i;
                    }
                    callback.onSuccess(firmwareUpdateResult);
                    return;
                }
                callback.onFailure(-9998, "result is null");
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|(2:4|5)|6|7|(2:9|(4:11|12|(4:14|15|16|(2:20|(1:22)(1:23)))|24))|27|28) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0039 */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x003f A[Catch:{ JSONException -> 0x008a }] */
    public final void O00000Oo(Context context, final Callback<Integer[]> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", deviceStat().did);
            jSONObject.put("platform", "android");
            if (context != null) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                StringBuilder sb = new StringBuilder();
                sb.append(packageInfo.versionCode);
                jSONObject.put("app_level", sb.toString());
            }
            if (deviceStat() != null) {
                String str = deviceStat().model;
                if (!TextUtils.isEmpty(str)) {
                    if (!str.equals("chuangmi.camera.ipc009")) {
                        if (!str.equals("chuangmi.camera.ipc019") && !str.equals("chuangmi.camera.ipc021")) {
                            if (!str.equals("chuangmi.camera.021a04")) {
                                jSONObject.put("plugin_level", deviceStat().version);
                            }
                        }
                    }
                    jSONObject.put("plugin_level", "96");
                }
            }
        } catch (JSONException e) {
            callback.onFailure(-9999, e.getLocalizedMessage());
        }
        XmPluginHostApi.instance().callSmartHomeApi(deviceStat().model, "/v2/device/check_device_version", jSONObject, new Callback<JSONObject>() {
            /* class _m_j.cid.AnonymousClass8 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                Callback callback = callback;
                if (callback == null) {
                    return;
                }
                if (jSONObject == null) {
                    callback.onFailure(-9998, "result is null");
                } else if (jSONObject.optBoolean("updating")) {
                    int optInt = jSONObject.optInt("ota_progress");
                    callback.onSuccess(new Integer[]{1, Integer.valueOf(optInt)});
                } else {
                    callback.onSuccess(new Integer[]{0, 0});
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public final void O000000o(boolean z) {
        callMethod("set_improve_program", new JSONArray().put(z ? "on" : "off"), new Callback<JSONObject>(null) {
            /* class _m_j.cid.AnonymousClass9 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ Callback f13890O000000o = null;

            public final void onFailure(int i, String str) {
                Callback callback = this.f13890O000000o;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                Callback callback = this.f13890O000000o;
                if (callback != null) {
                    callback.onSuccess(null);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public final void O0000oo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", -90);
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        callMethod("miIO.event", jSONObject, new Callback<JSONObject>(null) {
            /* class _m_j.cid.AnonymousClass10 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ Callback f13881O000000o = null;

            public final void onFailure(int i, String str) {
                Callback callback = this.f13881O000000o;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
                civ.O00000o("Properties", "reStartTutk error ".concat(String.valueOf(str)));
            }

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                Callback callback = this.f13881O000000o;
                if (callback != null) {
                    callback.onSuccess(null);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public final void O000000o(final Callback<Void> callback) {
        callMethod("restart_device", new JSONArray(), new Callback<JSONObject>() {
            /* class _m_j.cid.AnonymousClass11 */

            public final void onFailure(int i, String str) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(null);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public static void O0000ooO() {
        O0000oOo.clear();
    }

    public final void O000000o(String str, Callback<Boolean> callback) {
        if (XmPluginHostApi.instance().getApiLevel() >= 58) {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject.put("did", this.mDeviceStat.did);
                jSONObject.put("region", "CN");
                JSONObject jSONObject2 = new JSONObject();
                jSONArray.put(str);
                jSONObject2.put("fileIds", jSONArray);
                jSONObject.put("fileIds", jSONObject2);
                XmPluginHostApi.instance().callSmartHomeApi(getModel(), "business.smartcamera.", "/miot/camera/app/v1/tags", "POST", jSONObject, callback, new Parser<Boolean>() {
                    /* class _m_j.cid.AnonymousClass2 */

                    public final /* synthetic */ Object parse(String str) throws JSONException {
                        gsy.O000000o(3, "cmkj", "getOnlyPeopleStatus = ".concat(String.valueOf(str)));
                        JSONObject jSONObject = new JSONObject(str);
                        new JSONArray();
                        boolean z = false;
                        JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("detectionTags").getJSONObject(0).getJSONArray("tags");
                        if (jSONArray.length() > 0 && jSONArray.getString(0).equals("people")) {
                            z = true;
                        }
                        gsy.O000000o(3, "cmkj", "getOnlyPeopleStatus = ".concat(String.valueOf(z)));
                        return Boolean.valueOf(z);
                    }
                });
            } catch (JSONException unused) {
                callback.onFailure(-10000, null);
            }
        }
    }

    public final void O000000o(boolean z, Callback<String> callback) {
        if (XmPluginHostApi.instance().getApiLevel() >= 58) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", this.mDeviceStat.did);
                jSONObject.put("region", "CN");
                jSONObject.put("open", z);
                XmPluginHostApi.instance().callSmartHomeApi(getModel(), "business.smartcamera.", "/miot/camera/app/v1/put/pedestrianDetectionPushSwitch", "POST", jSONObject, callback, new Parser<String>() {
                    /* class _m_j.cid.AnonymousClass4 */

                    public final /* synthetic */ Object parse(String str) throws JSONException {
                        return new JSONObject(str).optString("url");
                    }
                });
            } catch (JSONException unused) {
                if (callback != null) {
                    callback.onFailure(-10000, null);
                }
            }
        } else if (callback != null) {
            callback.onFailure(-1, "api level low");
        }
    }
}
