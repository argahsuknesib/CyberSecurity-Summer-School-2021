package _m_j;

import _m_j.gfg;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.device.PhoneIRDevice;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class gfb {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f17633O000000o = new Object();
    private static volatile gfb O00000Oo;

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O000000o(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000Oo(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000o0(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    private gfb() {
    }

    public static gfb O000000o() {
        if (O00000Oo == null) {
            synchronized (f17633O000000o) {
                if (O00000Oo == null) {
                    O00000Oo = new gfb();
                }
            }
        }
        return O00000Oo;
    }

    public final fsn O000000o(Context context, List<KeyValuePair> list, final fsm<gfg, fso> fsm) {
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (KeyValuePair next : list) {
                        String str = next.f6728O000000o;
                        String str2 = next.O00000Oo;
                        PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(str2);
                        if (O0000Oo == null) {
                            LogType logType = LogType.NETWORK;
                            gsy.O00000Oo(logType, "UpdateApi", "packageInfo is null: model: " + str2 + " ; did: " + str);
                        }
                        if (!TextUtils.equals(str, PhoneIRDevice.f9714O000000o)) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("did", str);
                            if (O0000Oo == null) {
                                jSONObject.put("plugin_level", "0");
                            } else if (TextUtils.isEmpty(str2) || (!str2.equals("chuangmi.camera.ipc009") && !str2.equals("chuangmi.camera.ipc019") && !str2.equals("chuangmi.camera.ipc021") && !str2.equals("chuangmi.camera.021a04"))) {
                                StringBuilder sb = new StringBuilder();
                                sb.append(O0000Oo.O00000oO());
                                jSONObject.put("plugin_level", sb.toString());
                            } else {
                                jSONObject.put("plugin_level", "96");
                            }
                            jSONArray.put(jSONObject);
                            if (jSONArray.length() >= 300) {
                                arrayList.add(jSONArray);
                                jSONArray = new JSONArray();
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                gsy.O000000o(6, "UpdateApi", Log.getStackTraceString(e));
            }
        }
        if (jSONArray.length() > 0) {
            arrayList.add(jSONArray);
        }
        LogType logType2 = LogType.NETWORK;
        gsy.O00000Oo(logType2, "UpdateApi", "checkFirmwareUpdateBatch: checkList: " + Arrays.deepToString(list.toArray()) + " ; check_reqs: " + jSONArray);
        $$Lambda$gfb$v8cF4Ro3lceOh4EJ7hqOWfYCA4I r12 = $$Lambda$gfb$v8cF4Ro3lceOh4EJ7hqOWfYCA4I.INSTANCE;
        final AtomicInteger atomicInteger = new AtomicInteger();
        AnonymousClass9 r2 = new fsm<gfg, fso>() {
            /* class _m_j.gfb.AnonymousClass9 */

            /* renamed from: O000000o  reason: collision with root package name */
            gfg f17647O000000o = new gfg();
            fso O00000Oo;

            public final /* synthetic */ void onSuccess(Object obj) {
                gfg gfg = (gfg) obj;
                this.f17647O000000o.f17652O000000o = gfg.f17652O000000o;
                this.f17647O000000o.O00000Oo = gfg.O00000Oo;
                this.f17647O000000o.O00000o0 = gfg.O00000o0;
                this.f17647O000000o.O00000o.addAll(gfg.O00000o);
                onFailure(null);
            }

            public final void onFailure(fso fso) {
                fsm fsm;
                if (fso != null) {
                    this.O00000Oo = fso;
                }
                int decrementAndGet = atomicInteger.decrementAndGet();
                gsy.O00000Oo("UpdateApi", "checkFirmwareUpdateBatch response times " + decrementAndGet + " size:" + this.f17647O000000o.O00000o.size());
                if (decrementAndGet == 0 && (fsm = fsm) != null) {
                    fso fso2 = this.O00000Oo;
                    if (fso2 == null) {
                        fsm.onSuccess(this.f17647O000000o);
                    } else {
                        fsm.onFailure(fso2);
                    }
                }
            }
        };
        final ArrayList arrayList2 = new ArrayList();
        if (arrayList.size() == 0) {
            atomicInteger.incrementAndGet();
            O000000o(context, r12, r2, new JSONArray());
        } else {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                atomicInteger.incrementAndGet();
                arrayList2.add(O000000o(context, r12, r2, (JSONArray) it.next()));
            }
        }
        return new fsn<gfg>() {
            /* class _m_j.gfb.AnonymousClass10 */

            public final void cancel() {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((fsn) it.next()).cancel();
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ gfg O0000O0o(JSONObject jSONObject) throws JSONException {
        gsy.O00000Oo(LogType.NETWORK, "UpdateApi", "checkFirmwareUpdateBatch: response: ".concat(String.valueOf(jSONObject)));
        gfg gfg = new gfg();
        JSONArray jSONArray = jSONObject.getJSONArray("list");
        gfg.f17652O000000o = jSONObject.optBoolean("auto_upgrade_switch");
        gfg.O00000Oo = jSONObject.optBoolean("user_set_switch");
        gfg.O00000o0 = jSONObject.optBoolean("upgrade_notify_switch");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            gfg.O000000o o000000o = new gfg.O000000o();
            o000000o.O00000oO = jSONObject2.optBoolean("isLatest");
            o000000o.f17653O000000o = jSONObject2.optString("did");
            o000000o.O00000Oo = jSONObject2.optBoolean("updating");
            o000000o.O00000o0 = jSONObject2.optString("curr");
            o000000o.O00000o = jSONObject2.optString("latest");
            o000000o.O00000oo = jSONObject2.optString("description");
            o000000o.O0000O0o = jSONObject2.optInt("ota_progress");
            o000000o.O0000OOo = jSONObject2.optString("ota_status");
            o000000o.O0000Oo0 = jSONObject2.optInt("timeout_time");
            o000000o.O0000Oo = jSONObject2.optLong("upload_time");
            gfg.O00000o.add(o000000o);
        }
        return gfg;
    }

    private static fsn O000000o(Context context, fss<gfg> fss, fsm<gfg, fso> fsm, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "android");
            jSONObject.put("check_reqs", jSONArray);
            if (context != null) {
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    StringBuilder sb = new StringBuilder();
                    sb.append(packageInfo.versionCode);
                    jSONObject.put("app_level", sb.toString());
                } catch (PackageManager.NameNotFoundException e) {
                    gsy.O000000o(6, "UpdateApi", Log.getStackTraceString(e));
                }
            }
        } catch (JSONException e2) {
            gsy.O000000o(6, "UpdateApi", Log.getStackTraceString(e2));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/multi_check_device_version").O000000o(arrayList).O000000o(), fss, Crypto.RC4, fsm);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:1|2|(2:4|5)|6|7|(5:11|12|(3:14|15|(1:21))|22|(1:24))|25|26) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x003d */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0057 A[SYNTHETIC, Splitter:B:14:0x0057] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0087 A[Catch:{ JSONException -> 0x00cf }] */
    public static fsn O000000o(Context context, String str, int i, fsm<Void, fso> fsm) {
        Device O000000o2;
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("pid", i);
            jSONObject.put("platform", "android");
            if (context != null) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                StringBuilder sb = new StringBuilder();
                sb.append(packageInfo.versionCode);
                jSONObject.put("app_level", sb.toString());
            }
            if (!TextUtils.isEmpty(str) && (O000000o2 = fno.O000000o().O000000o(str)) != null) {
                if (!TextUtils.isEmpty(O000000o2.model)) {
                    if (O000000o2.model.equals("chuangmi.camera.ipc009") || O000000o2.model.equals("chuangmi.camera.ipc019") || O000000o2.model.equals("chuangmi.camera.ipc021")) {
                        jSONObject.put("plugin_level", "96");
                    }
                }
                PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(O000000o2.model);
                if (O0000Oo != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(O0000Oo.O00000oO());
                    jSONObject.put("plugin_level", sb2.toString());
                }
            }
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/devupgrade").O000000o(arrayList).O000000o(), (fss) null, Crypto.RC4, fsm);
        } catch (JSONException unused) {
            fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), ""));
            return new fsn(null);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|(2:4|5)|6|7|(5:11|12|(3:14|15|(1:21))|22|(1:24))|25|26) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0038 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0052 A[SYNTHETIC, Splitter:B:14:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0082 A[Catch:{ JSONException -> 0x00ce }] */
    public final fsn O000000o(Context context, String str, fsm<gfh, fso> fsm) {
        Device O000000o2;
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("platform", "android");
            if (context != null) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                StringBuilder sb = new StringBuilder();
                sb.append(packageInfo.versionCode);
                jSONObject.put("app_level", sb.toString());
            }
            if (!TextUtils.isEmpty(str) && (O000000o2 = fno.O000000o().O000000o(str)) != null) {
                if (!TextUtils.isEmpty(O000000o2.model)) {
                    if (O000000o2.model.equals("chuangmi.camera.ipc009") || O000000o2.model.equals("chuangmi.camera.ipc019") || O000000o2.model.equals("chuangmi.camera.ipc021")) {
                        jSONObject.put("plugin_level", "96");
                    }
                }
                PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(O000000o2.model);
                if (O0000Oo != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(O0000Oo.O00000oO());
                    jSONObject.put("plugin_level", sb2.toString());
                }
            }
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/check_device_version").O000000o(arrayList).O000000o(), new fss<gfh>() {
                /* class _m_j.gfb.AnonymousClass11 */

                public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    gfh gfh = new gfh();
                    gfh.O00000o = jSONObject.optBoolean("isLatest");
                    gfh.f17654O000000o = jSONObject.optBoolean("updating");
                    gfh.O00000Oo = jSONObject.optString("curr");
                    gfh.O00000o0 = jSONObject.optString("latest");
                    gfh.O00000oO = jSONObject.optString("description");
                    gfh.O00000oo = jSONObject.optInt("ota_progress");
                    gfh.O0000O0o = jSONObject.optString("ota_status");
                    gfh.O0000OOo = jSONObject.optInt("timeout_time");
                    long currentTimeMillis = (System.currentTimeMillis() / 1000) - jSONObject.optLong("ota_start_time");
                    int i = (int) (currentTimeMillis / 2);
                    if (gfh.O0000OOo > 0) {
                        i = (int) ((currentTimeMillis / ((long) gfh.O0000OOo)) * 90);
                    }
                    if (i > 90) {
                        i = 90;
                    }
                    if (i > gfh.O00000oo) {
                        gfh.O00000oo = i;
                    }
                    return gfh;
                }
            }, Crypto.RC4, fsm);
        } catch (JSONException unused) {
            fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), ""));
            return new fsn(null);
        }
    }

    public final fsn O000000o(Context context, String str, String str2, int i, fsm<gfc, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("package_name", str);
            jSONObject.put("version_name", str2);
            jSONObject.put("version_code", i);
            jSONObject.put("api_level", 2);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/version/check_gray").O000000o(arrayList).O000000o(), new fss<gfc>() {
                /* class _m_j.gfb.AnonymousClass12 */

                public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    gfc gfc = new gfc();
                    gfc.f17648O000000o = jSONObject.optInt("new_version");
                    gfc.O00000Oo = jSONObject.optInt("new_version_code");
                    gfc.O00000o0 = jSONObject.optString("new_version_name");
                    gfc.O00000o = jSONObject.optString("download_url");
                    gfc.O00000oO = jSONObject.optString("change_log");
                    gfc.O00000oo = jSONObject.optInt("gray_type");
                    gfc.O0000O0o = jSONObject.optInt("switch");
                    return gfc;
                }
            }, Crypto.RC4, fsm);
        } catch (JSONException unused) {
            fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), ""));
            return new fsn(null);
        }
    }

    public final fsn O00000Oo(Context context, String str, int i, fsm<gfe, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version_name", str);
            jSONObject.put("version_code", i);
            jSONObject.put("api_level", 2);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/version/online_version").O000000o(arrayList).O000000o(), new fss<gfe>() {
            /* class _m_j.gfb.AnonymousClass13 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                gfe gfe = new gfe();
                gfe.f17650O000000o = jSONObject.optInt("new_version");
                gfe.O00000Oo = jSONObject.optInt("force");
                gfe.O00000o0 = jSONObject.optInt("new_version_code");
                gfe.O00000o = jSONObject.optString("new_version_name");
                gfe.O00000oO = jSONObject.optString("download_url");
                gfe.O00000oo = jSONObject.optString("change_log");
                return gfe;
            }
        }, Crypto.HTTPS, fsm);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:1|2|3|4|5|6|(5:10|11|(3:13|14|(1:20))|21|(1:23))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0050 A[SYNTHETIC, Splitter:B:13:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080 A[Catch:{ JSONException -> 0x0093 }] */
    public final fsn O00000Oo(Context context, String str, fsm<JSONObject, fso> fsm) {
        Device O000000o2;
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("platform", "android");
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            StringBuilder sb = new StringBuilder();
            sb.append(packageInfo.versionCode);
            jSONObject.put("app_level", sb.toString());
            if (!TextUtils.isEmpty(str) && (O000000o2 = fno.O000000o().O000000o(str)) != null) {
                if (!TextUtils.isEmpty(O000000o2.model)) {
                    if (O000000o2.model.equals("chuangmi.camera.ipc009") || O000000o2.model.equals("chuangmi.camera.ipc019") || O000000o2.model.equals("chuangmi.camera.ipc021")) {
                        jSONObject.put("plugin_level", "96");
                    }
                }
                PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(O000000o2.model);
                if (O0000Oo != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(O0000Oo.O00000oO());
                    jSONObject.put("plugin_level", sb2.toString());
                }
            }
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/check_device_version").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.gfb.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, final fsm<List<gyf>, fso> fsm) {
        PluginPackageInfo O0000Oo;
        JSONArray jSONArray = new JSONArray();
        final ArrayList arrayList = new ArrayList();
        try {
            Map<String, Device> O0000O0o = fno.O000000o().O0000O0o();
            if (O0000O0o != null && O0000O0o.size() > 0) {
                for (Map.Entry<String, Device> value : O0000O0o.entrySet()) {
                    Device device = (Device) value.getValue();
                    if (!(device == null || (O0000Oo = CoreApi.O000000o().O0000Oo(device.model)) == null)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("did", device.did);
                        if (device != null) {
                            if (!TextUtils.isEmpty(device.model)) {
                                if (device.model.equals("chuangmi.camera.ipc009") || device.model.equals("chuangmi.camera.ipc019") || device.model.equals("chuangmi.camera.ipc021")) {
                                    jSONObject.put("plugin_level", "96");
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append(O0000Oo.O00000oO());
                            jSONObject.put("plugin_level", sb.toString());
                        }
                        jSONArray.put(jSONObject);
                        if (jSONArray.length() >= 300) {
                            arrayList.add(jSONArray);
                            jSONArray = new JSONArray();
                        }
                    }
                }
            }
            if (jSONArray.length() > 0) {
                arrayList.add(jSONArray);
            }
        } catch (JSONException e) {
            gsy.O000000o(6, "UpdateApi", Log.getStackTraceString(e));
        }
        final ArrayList arrayList2 = new ArrayList();
        AnonymousClass2 r10 = new fss<List<gyf>>() {
            /* class _m_j.gfb.AnonymousClass2 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return O000000o(jSONObject);
            }

            private static List<gyf> O000000o(JSONObject jSONObject) throws JSONException {
                ArrayList arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("list");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        gyf gyf = new gyf();
                        gyf.O0000OOo = jSONObject2.getBoolean("isLatest");
                        if (!gyf.O0000OOo) {
                            gyf.O00000Oo = jSONObject2.getString("did");
                            try {
                                Device O000000o2 = fno.O000000o().O000000o(gyf.O00000Oo);
                                if (O000000o2 != null) {
                                    if (O000000o2.isOnline) {
                                        gyf.O00000o0 = O000000o2.pid;
                                        gyf.O00000oO = jSONObject2.getBoolean("updating");
                                        gyf.O00000oo = jSONObject2.getString("curr");
                                        gyf.O0000O0o = jSONObject2.getString("latest");
                                        gyf.O0000Oo0 = jSONObject2.getString("description");
                                        gyf.O0000Oo = 0;
                                        gyf.O0000OoO = jSONObject2.getString("ota_status");
                                        arrayList.add(gyf);
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                } catch (JSONException unused2) {
                }
                return arrayList;
            }
        };
        new fsm<List<gyf>, fso>() {
            /* class _m_j.gfb.AnonymousClass3 */

            public final void onFailure(fso fso) {
            }

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
            }
        };
        AnonymousClass4 r11 = new fsm<List<gyf>, fso>() {
            /* class _m_j.gfb.AnonymousClass4 */

            /* renamed from: O000000o  reason: collision with root package name */
            List<gyf> f17642O000000o = new ArrayList();
            AtomicInteger O00000Oo = new AtomicInteger(arrayList.size());
            fso O00000o0;

            public final /* synthetic */ void onSuccess(Object obj) {
                this.f17642O000000o.addAll((List) obj);
                onFailure(null);
            }

            public final void onFailure(fso fso) {
                fsm fsm;
                if (fso != null) {
                    this.O00000o0 = fso;
                }
                int decrementAndGet = this.O00000Oo.decrementAndGet();
                gsy.O00000Oo("UpdateApi", "getBatchUpdateInfo response times " + decrementAndGet + " size:" + this.f17642O000000o.size());
                if (decrementAndGet == 0 && (fsm = fsm) != null) {
                    fso fso2 = this.O00000o0;
                    if (fso2 == null) {
                        fsm.onSuccess(this.f17642O000000o);
                    } else {
                        fsm.onFailure(fso2);
                    }
                }
            }
        };
        if (arrayList.size() == 0) {
            fsm.onSuccess(new ArrayList());
        } else {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                JSONArray jSONArray2 = (JSONArray) it.next();
                ArrayList arrayList3 = new ArrayList();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("platform", "android");
                    jSONObject2.put("check_reqs", jSONArray2);
                    if (context != null) {
                        try {
                            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(packageInfo.versionCode);
                            jSONObject2.put("app_level", sb2.toString());
                        } catch (PackageManager.NameNotFoundException e2) {
                            gsy.O000000o(6, "UpdateApi", Log.getStackTraceString(e2));
                        }
                    }
                } catch (JSONException e3) {
                    gsy.O000000o(6, "UpdateApi", Log.getStackTraceString(e3));
                }
                arrayList3.add(new KeyValuePair("data", jSONObject2.toString()));
                arrayList2.add(CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/multi_check_device_version").O000000o(arrayList3).O000000o(), r10, Crypto.RC4, r11));
            }
        }
        return new fsn<gfg>() {
            /* class _m_j.gfb.AnonymousClass5 */

            public final void cancel() {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((fsn) it.next()).cancel();
                }
            }
        };
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:1|2|3|4|5|6|(5:10|11|(3:13|14|(1:20))|21|(1:23))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x003b */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0055 A[SYNTHETIC, Splitter:B:13:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0085 A[Catch:{ JSONException -> 0x0098 }] */
    public final fsn O00000o0(Context context, String str, int i, fsm<JSONObject, fso> fsm) {
        Device O000000o2;
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("pid", i);
            jSONObject.put("platform", "android");
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            StringBuilder sb = new StringBuilder();
            sb.append(packageInfo.versionCode);
            jSONObject.put("app_level", sb.toString());
            if (!TextUtils.isEmpty(str) && (O000000o2 = fno.O000000o().O000000o(str)) != null) {
                if (!TextUtils.isEmpty(O000000o2.model)) {
                    if (O000000o2.model.equals("chuangmi.camera.ipc009") || O000000o2.model.equals("chuangmi.camera.ipc019") || O000000o2.model.equals("chuangmi.camera.ipc021")) {
                        jSONObject.put("plugin_level", "96");
                    }
                }
                PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(O000000o2.model);
                if (O0000Oo != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(O0000Oo.O00000oO());
                    jSONObject.put("plugin_level", sb2.toString());
                }
            }
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/devupgrade").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.gfb.AnonymousClass6 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O00000Oo(Context context, String str, String str2, int i, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("package_name", str);
            jSONObject.put("version_name", str2);
            jSONObject.put("version_code", i);
            jSONObject.put("api_level", 2);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/version/check_gray").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.gfb.AnonymousClass7 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O00000o(Context context, String str, int i, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version_name", str);
            jSONObject.put("version_code", i);
            jSONObject.put("api_level", 2);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/version/online_version").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.gfb.AnonymousClass8 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.HTTPS, fsm);
    }

    public static void O00000Oo(Context context, fsm<ArrayList<KeyValuePair>, fso> fsm) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dids", new JSONArray());
        } catch (JSONException unused) {
        }
        Context context2 = context;
        CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O000000o("POST").O000000o(Collections.singletonList(new KeyValuePair("data", jSONObject.toString()))).O00000Oo("/v2/device/auto_upgrade_list").O000000o(), $$Lambda$gfb$81bvkOoEqwI7p9rRHAuzGolHaS0.INSTANCE, Crypto.RC4, fsm);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ArrayList O00000oo(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("list");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("switch_config");
                String optString = optJSONObject.optString("did");
                if (optJSONObject2 != null) {
                    arrayList.add(new KeyValuePair(optString, optJSONObject2.optString("active")));
                }
            }
        }
        return arrayList;
    }

    public static void O00000Oo(Context context, List<String> list, fsm<List<gfj>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray();
        for (String put : list) {
            jSONArray.put(put);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("dids", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O000000o(arrayList).O00000Oo("/v2/device/batch_get_latest_upgrade").O000000o();
        gsy.O000000o(3, "zz", "batchGetLatestUpgrade " + O000000o2.toString());
        CoreApi.O000000o().O000000o(context, O000000o2, $$Lambda$gfb$ricn7D2voqK5iHYhm4ZgBVEM0NE.INSTANCE, Crypto.RC4, fsm);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List O00000oO(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("list");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            gfj gfj = new gfj();
            gfj.f17656O000000o = optJSONObject.optString("did");
            gfj.O00000Oo = optJSONObject.optInt("type");
            gfj.O00000o0 = optJSONObject.optLong("time");
            gfj.O00000o = optJSONObject.optString("post_version");
            gfj.O00000oO = optJSONObject.optString("pre_version");
            gfj.O00000oo = optJSONObject.optString("description");
            arrayList.add(gfj);
        }
        gsy.O000000o(3, "zz", "batchGetLatestUpgrade ".concat(String.valueOf(optJSONArray)));
        return arrayList;
    }

    public static void O00000o0(Context context, String str, fsm<List<gff>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        Context context2 = context;
        CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O000000o("POST").O000000o(arrayList).O00000Oo("/v2/device/get_upgrade_history").O000000o(), $$Lambda$gfb$FLjsQfDvZQm2e6oieyy74UcKVgQ.INSTANCE, Crypto.RC4, fsm);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List O00000o(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("list");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            gff gff = new gff();
            gff.f17651O000000o = optJSONObject.optString("did");
            gff.O00000Oo = optJSONObject.optInt("type");
            gff.O00000o0 = optJSONObject.optLong("time");
            gff.O00000o = optJSONObject.optString("post_version");
            gff.O00000oO = optJSONObject.optString("pre_version");
            gff.O00000oo = optJSONObject.optString("description");
            arrayList.add(gff);
        }
        gsy.O000000o(3, "zz", "getUpgradeHistory ".concat(String.valueOf(optJSONArray)));
        return arrayList;
    }

    public static void O000000o(Context context, boolean z, fsm<JSONObject, fso> fsm) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("switch_on", z);
        } catch (JSONException unused) {
        }
        Context context2 = context;
        CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O000000o("POST").O000000o(Collections.singletonList(new KeyValuePair("data", jSONObject.toString()))).O00000Oo("/v2/device/set_auto_upgrade_switch").O000000o(), $$Lambda$gfb$BQQtUDPj2alMGcQZkdynjN5IqLo.INSTANCE, Crypto.RC4, fsm);
    }

    public static void O000000o(Context context, String str, boolean z, fsm<JSONObject, fso> fsm) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject2.put("prop.s_auto_upgrade_switch", z ? "1" : "0");
            jSONObject.put("props", jSONObject2);
        } catch (JSONException unused) {
        }
        CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O000000o(Collections.singletonList(new KeyValuePair("data", jSONObject.toString()))).O00000Oo("/v2/device/set_props").O000000o(), $$Lambda$gfb$oeg1DmqibiX48L_DH5G0RdhZrqs.INSTANCE, Crypto.RC4, fsm);
    }

    public static void O00000Oo(Context context, boolean z, fsm<JSONObject, fso> fsm) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("switch_on", z);
        } catch (JSONException unused) {
        }
        Context context2 = context;
        CoreApi.O000000o().O000000o(context2, new NetRequest.O000000o().O000000o("POST").O000000o(Collections.singletonList(new KeyValuePair("data", jSONObject.toString()))).O00000Oo("/v2/device/set_upgrade_notify_switch").O000000o(), $$Lambda$gfb$K02JvBSlXHvsH9JNTxoR6ybqOY.INSTANCE, Crypto.RC4, fsm);
    }
}
