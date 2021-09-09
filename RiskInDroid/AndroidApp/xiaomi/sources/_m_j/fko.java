package _m_j;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fko {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f16539O000000o = new Object();
    private static volatile fko O00000Oo;

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O000000o(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    private fko() {
    }

    public static fko O000000o() {
        if (O00000Oo == null) {
            synchronized (f16539O000000o) {
                if (O00000Oo == null) {
                    O00000Oo = new fko();
                }
            }
        }
        return O00000Oo;
    }

    private static void O00000Oo() {
        if (Looper.myLooper() == null) {
            throw new RuntimeException("Async Callback must have Looper");
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
    public final fdf O000000o(long j, long j2, int i, String str, final fde<fks, fdg> fde) {
        O00000Oo();
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("devices_last_modify", j);
            jSONObject.put("developers_last_modify", j2);
            jSONObject.put("app_version", i);
            jSONObject.put("app_platform", str);
            jSONObject.put("isLocal", false);
            jSONObject.put("v", 2);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return new fdf(fdt.O000000o().O000000o(new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/plugin/get_config_info_new").O000000o(arrayList).O000000o(), new fdh<NetResult, NetError>() {
                /* class _m_j.fko.AnonymousClass1 */

                public final /* synthetic */ void onFailure(Error error) {
                    NetError netError = (NetError) error;
                    fde.sendFailureMessage(new fdg(netError.f6718O000000o, netError.O00000Oo));
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    fdw.O000000o().O000000o((NetResult) obj, $$Lambda$fko$1$KpJl5qEF_2L3NILxIZnXkHW8cnk.INSTANCE, fde);
                }
            }));
        } catch (JSONException unused) {
            fde.sendFailureMessage(new fdg(-1, ""));
            return new fdf(null);
        }
    }

    public final fdf O000000o(JSONArray jSONArray, final fde<JSONArray, fdg> fde) {
        O00000Oo();
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "Android");
            jSONObject.put("sdk_version", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/plugin/fetch_sdk").O000000o(arrayList).O000000o();
        final AnonymousClass3 r0 = new fdv<JSONArray>() {
            /* class _m_j.fko.AnonymousClass3 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject.getJSONArray("info");
            }
        };
        return new fdf(fdt.O000000o().O000000o(O000000o2, new fdh<NetResult, NetError>() {
            /* class _m_j.fko.AnonymousClass4 */

            public final /* synthetic */ void onFailure(Error error) {
                NetError netError = (NetError) error;
                fde.sendFailureMessage(new fdg(netError.f6718O000000o, netError.O00000Oo));
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                NetResult netResult = (NetResult) obj;
                hsi.O000000o("fetch sdk info", netResult.O00000o0);
                fdw.O000000o().O000000o(netResult, r0, fde);
            }
        }));
    }

    public static final void O000000o(Context context, String str) {
        if (context != null) {
            if (str == null) {
                str = "";
            }
            fkw.O000000o(new File(fkw.O000000o(context), "ModelToReplaceAllPluginForTestOnly"), str.getBytes());
        }
    }

    public static final void O000000o(Context context, boolean z) {
        O000000o(context, z ? "old_plugin_only" : "");
    }

    public static final boolean O000000o(Context context) {
        return "old_plugin_only".equals(O00000Oo(context));
    }

    private static final String O00000Oo(Context context) {
        byte[] O000000o2;
        if (context == null && (context = CommonApplication.getAppContext()) == null) {
            return "";
        }
        File file = new File(fkw.O000000o(context), "ModelToReplaceAllPluginForTestOnly");
        if (file.exists() && (O000000o2 = fkw.O000000o(file)) != null && O000000o2.length > 0) {
            return new String(O000000o2);
        }
        return "";
    }

    public final fdf O000000o(JSONArray jSONArray, String str, fde<List<fkt>, fdg> fde) {
        final JSONArray jSONArray2 = jSONArray;
        final fde<List<fkt>, fdg> fde2 = fde;
        O00000Oo();
        ArrayList arrayList = new ArrayList();
        final String O00000Oo2 = O00000Oo(null);
        final boolean equals = "old_plugin_only".equals(O00000Oo2);
        final HashSet hashSet = new HashSet();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("api_version", 10058);
            jSONObject2.put("app_platform", "Android");
            ServerBean O00000oO = fcx.f16092O000000o.O00000oO();
            if (O00000oO == null) {
                O00000oO = ftn.O000000o();
            }
            jSONObject2.put("region", O00000oO.O00000Oo);
            if (!equals) {
                if (!O00000Oo2.isEmpty()) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        hashSet.add(jSONArray2.optJSONObject(i).optString("model"));
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("model", O00000Oo2);
                    jSONArray3.put(jSONObject3);
                    jSONObject2.put("plugins", jSONArray3);
                    jSONObject2.put("package_type", "");
                    jSONObject.put("latest_req", jSONObject2);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("plugins", jSONArray2);
                    jSONObject4.put("api_level", 111);
                    jSONObject4.put("app_platform", str);
                    jSONObject.put("backup_req", jSONObject4);
                    arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                    NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/plugin/fetch_plugin").O000000o(arrayList).O000000o();
                    final AnonymousClass5 r4 = new fdv<List<fkt>>() {
                        /* class _m_j.fko.AnonymousClass5 */

                        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0173, code lost:
                            if (r7.isEmpty() != false) goto L_0x0178;
                         */
                        public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                            int i;
                            HashMap hashMap;
                            int i2;
                            HashMap hashMap2;
                            JSONObject jSONObject2 = jSONObject;
                            ArrayList arrayList = new ArrayList();
                            JSONArray optJSONArray = equals ? null : jSONObject2.optJSONArray("latest_info");
                            HashMap hashMap3 = new HashMap();
                            if (equals || optJSONArray == null) {
                                hashMap = hashMap3;
                                i = 0;
                            } else {
                                int length = optJSONArray.length();
                                fkt fkt = null;
                                int i3 = 0;
                                while (i3 < length) {
                                    fkt fkt2 = new fkt();
                                    JSONObject jSONObject3 = (JSONObject) optJSONArray.get(i3);
                                    fkt2.O0000OoO = "rn";
                                    fkt2.f16552O000000o = jSONObject3.optString("model");
                                    if (!TextUtils.isEmpty(fkt2.f16552O000000o)) {
                                        hashMap3.put(fkt2.f16552O000000o, fkt2);
                                        HashMap hashMap4 = hashMap3;
                                        i2 = length;
                                        fkt2.O00000o0 = jSONObject3.optLong("plugin_id");
                                        if (fkl.O00000o0(fkt2.O00000o0)) {
                                            fkt2.O00000o = jSONObject3.optLong("plugin_package_id");
                                            if (fkl.O00000o(fkt2.O00000o)) {
                                                fkt2.O0000OOo = jSONObject3.optString("download_url");
                                                if (!TextUtils.isEmpty(fkt2.O0000OOo)) {
                                                    fkt2.O0000Ooo = (long) jSONObject3.optInt("sdk_version");
                                                    fkt2.O00000oo = jSONObject3.optInt("version");
                                                    fkt2.O00000Oo = 1;
                                                    fkt2.O0000O0o = jSONObject3.optString("change_log");
                                                    fkt2.O00000oO = jSONObject3.optInt("force_update_status");
                                                    fkt2.O0000Oo = jSONObject3.optLong("size");
                                                    hashMap2 = hashMap4;
                                                    hsi.O000000o("fetch plugin:", fkt2.f16552O000000o, Long.valueOf(fkt2.O0000Ooo), Long.valueOf(fkt2.O00000o0), Long.valueOf(fkt2.O00000o));
                                                    if (O00000Oo2.isEmpty() || !TextUtils.equals(O00000Oo2, fkt2.f16552O000000o)) {
                                                        arrayList.add(fkt2);
                                                    } else {
                                                        fkt = fkt2;
                                                    }
                                                }
                                            }
                                        }
                                        hashMap2 = hashMap4;
                                    } else {
                                        i2 = length;
                                        hashMap2 = hashMap3;
                                    }
                                    i3++;
                                    hashMap3 = hashMap2;
                                    length = i2;
                                }
                                hashMap = hashMap3;
                                if (fkt != null) {
                                    for (Iterator it = hashSet.iterator(); it.hasNext(); it = it) {
                                        fkt fkt3 = new fkt();
                                        fkt3.f16552O000000o = (String) it.next();
                                        fkt3.O0000OOo = fkt.O0000OOo;
                                        fkt3.O0000Ooo = fkt.O0000Ooo;
                                        fkt3.O0000Oo = fkt.O0000Oo;
                                        fkt3.O00000Oo = fkt.O00000Oo;
                                        fkt3.O00000o0 = fkt.O00000o0;
                                        fkt3.O00000o = fkt.O00000o;
                                        fkt3.O00000oo = fkt.O00000oo;
                                        fkt3.O0000O0o = fkt.O0000O0o;
                                        fkt3.O0000OoO = fkt.O0000OoO;
                                        hsi.O000000o("FETCH OLD plugin:", fkt3.f16552O000000o, fkt3.O0000OoO, Long.valueOf(fkt3.O00000o0), Long.valueOf(fkt3.O00000o));
                                        arrayList.add(fkt3);
                                    }
                                }
                                i = 0;
                            }
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray("backup_info");
                            if (optJSONArray2 != null) {
                                int length2 = optJSONArray2.length();
                                while (i < length2) {
                                    fkt fkt4 = new fkt();
                                    JSONObject jSONObject4 = (JSONObject) optJSONArray2.get(i);
                                    fkt4.f16552O000000o = jSONObject4.optString("model");
                                    if (((fkt) hashMap.get(fkt4.f16552O000000o)) != null) {
                                        System.out.println("INFO: OLD PLUGIN INFO OF " + fkt4.f16552O000000o);
                                    } else {
                                        fkt4.O0000OOo = jSONObject4.optString("download_url");
                                        if (gqb.O000000o(fkt4.O0000OOo)) {
                                            System.out.println("WARN: EMPTY PLUGIN INFO OF " + fkt4.f16552O000000o);
                                        } else {
                                            fkt4.O00000Oo = jSONObject4.optInt("new_version");
                                            fkt4.O00000o0 = jSONObject4.optLong("plugin_id");
                                            fkt4.O00000o = jSONObject4.optLong("package_id");
                                            fkt4.O00000oO = jSONObject4.optInt("force");
                                            fkt4.O00000oo = jSONObject4.optInt("version");
                                            fkt4.O0000O0o = jSONObject4.optString("change_log");
                                            fkt4.O0000Oo0 = jSONObject4.optString("safe_url");
                                            fkt4.O0000Oo = jSONObject4.optLong("length");
                                            fkt4.O0000OoO = jSONObject4.optString("type");
                                            arrayList.add(fkt4);
                                        }
                                    }
                                    i++;
                                }
                            }
                            return arrayList;
                        }
                    };
                    return new fdf(fdt.O000000o().O000000o(O000000o2, new fdh<NetResult, NetError>() {
                        /* class _m_j.fko.AnonymousClass6 */

                        public final /* synthetic */ void onFailure(Error error) {
                            NetError netError = (NetError) error;
                            if (jSONArray2 != null) {
                                StringBuilder sb = new StringBuilder();
                                for (int i = 0; i < jSONArray2.length(); i++) {
                                    if (i != 0) {
                                        sb.append(";");
                                    }
                                    sb.append(jSONArray2.optJSONObject(i).optString("model"));
                                }
                                hxi.O0000Oo.O000000o(2, sb.toString());
                            }
                            fde2.sendFailureMessage(new fdg(netError.f6718O000000o, netError.O00000Oo));
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            fdw.O000000o().O000000o((NetResult) obj, r4, fde2);
                        }
                    }));
                }
            }
            jSONObject2.put("plugins", jSONArray2);
            jSONObject2.put("package_type", "");
            jSONObject.put("latest_req", jSONObject2);
            JSONObject jSONObject42 = new JSONObject();
            jSONObject42.put("plugins", jSONArray2);
            jSONObject42.put("api_level", 111);
            jSONObject42.put("app_platform", str);
            jSONObject.put("backup_req", jSONObject42);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            NetRequest O000000o22 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/plugin/fetch_plugin").O000000o(arrayList).O000000o();
            final AnonymousClass5 r42 = new fdv<List<fkt>>() {
                /* class _m_j.fko.AnonymousClass5 */

                /* JADX WARNING: Code restructure failed: missing block: B:34:0x0173, code lost:
                    if (r7.isEmpty() != false) goto L_0x0178;
                 */
                public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    int i;
                    HashMap hashMap;
                    int i2;
                    HashMap hashMap2;
                    JSONObject jSONObject2 = jSONObject;
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = equals ? null : jSONObject2.optJSONArray("latest_info");
                    HashMap hashMap3 = new HashMap();
                    if (equals || optJSONArray == null) {
                        hashMap = hashMap3;
                        i = 0;
                    } else {
                        int length = optJSONArray.length();
                        fkt fkt = null;
                        int i3 = 0;
                        while (i3 < length) {
                            fkt fkt2 = new fkt();
                            JSONObject jSONObject3 = (JSONObject) optJSONArray.get(i3);
                            fkt2.O0000OoO = "rn";
                            fkt2.f16552O000000o = jSONObject3.optString("model");
                            if (!TextUtils.isEmpty(fkt2.f16552O000000o)) {
                                hashMap3.put(fkt2.f16552O000000o, fkt2);
                                HashMap hashMap4 = hashMap3;
                                i2 = length;
                                fkt2.O00000o0 = jSONObject3.optLong("plugin_id");
                                if (fkl.O00000o0(fkt2.O00000o0)) {
                                    fkt2.O00000o = jSONObject3.optLong("plugin_package_id");
                                    if (fkl.O00000o(fkt2.O00000o)) {
                                        fkt2.O0000OOo = jSONObject3.optString("download_url");
                                        if (!TextUtils.isEmpty(fkt2.O0000OOo)) {
                                            fkt2.O0000Ooo = (long) jSONObject3.optInt("sdk_version");
                                            fkt2.O00000oo = jSONObject3.optInt("version");
                                            fkt2.O00000Oo = 1;
                                            fkt2.O0000O0o = jSONObject3.optString("change_log");
                                            fkt2.O00000oO = jSONObject3.optInt("force_update_status");
                                            fkt2.O0000Oo = jSONObject3.optLong("size");
                                            hashMap2 = hashMap4;
                                            hsi.O000000o("fetch plugin:", fkt2.f16552O000000o, Long.valueOf(fkt2.O0000Ooo), Long.valueOf(fkt2.O00000o0), Long.valueOf(fkt2.O00000o));
                                            if (O00000Oo2.isEmpty() || !TextUtils.equals(O00000Oo2, fkt2.f16552O000000o)) {
                                                arrayList.add(fkt2);
                                            } else {
                                                fkt = fkt2;
                                            }
                                        }
                                    }
                                }
                                hashMap2 = hashMap4;
                            } else {
                                i2 = length;
                                hashMap2 = hashMap3;
                            }
                            i3++;
                            hashMap3 = hashMap2;
                            length = i2;
                        }
                        hashMap = hashMap3;
                        if (fkt != null) {
                            for (Iterator it = hashSet.iterator(); it.hasNext(); it = it) {
                                fkt fkt3 = new fkt();
                                fkt3.f16552O000000o = (String) it.next();
                                fkt3.O0000OOo = fkt.O0000OOo;
                                fkt3.O0000Ooo = fkt.O0000Ooo;
                                fkt3.O0000Oo = fkt.O0000Oo;
                                fkt3.O00000Oo = fkt.O00000Oo;
                                fkt3.O00000o0 = fkt.O00000o0;
                                fkt3.O00000o = fkt.O00000o;
                                fkt3.O00000oo = fkt.O00000oo;
                                fkt3.O0000O0o = fkt.O0000O0o;
                                fkt3.O0000OoO = fkt.O0000OoO;
                                hsi.O000000o("FETCH OLD plugin:", fkt3.f16552O000000o, fkt3.O0000OoO, Long.valueOf(fkt3.O00000o0), Long.valueOf(fkt3.O00000o));
                                arrayList.add(fkt3);
                            }
                        }
                        i = 0;
                    }
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray("backup_info");
                    if (optJSONArray2 != null) {
                        int length2 = optJSONArray2.length();
                        while (i < length2) {
                            fkt fkt4 = new fkt();
                            JSONObject jSONObject4 = (JSONObject) optJSONArray2.get(i);
                            fkt4.f16552O000000o = jSONObject4.optString("model");
                            if (((fkt) hashMap.get(fkt4.f16552O000000o)) != null) {
                                System.out.println("INFO: OLD PLUGIN INFO OF " + fkt4.f16552O000000o);
                            } else {
                                fkt4.O0000OOo = jSONObject4.optString("download_url");
                                if (gqb.O000000o(fkt4.O0000OOo)) {
                                    System.out.println("WARN: EMPTY PLUGIN INFO OF " + fkt4.f16552O000000o);
                                } else {
                                    fkt4.O00000Oo = jSONObject4.optInt("new_version");
                                    fkt4.O00000o0 = jSONObject4.optLong("plugin_id");
                                    fkt4.O00000o = jSONObject4.optLong("package_id");
                                    fkt4.O00000oO = jSONObject4.optInt("force");
                                    fkt4.O00000oo = jSONObject4.optInt("version");
                                    fkt4.O0000O0o = jSONObject4.optString("change_log");
                                    fkt4.O0000Oo0 = jSONObject4.optString("safe_url");
                                    fkt4.O0000Oo = jSONObject4.optLong("length");
                                    fkt4.O0000OoO = jSONObject4.optString("type");
                                    arrayList.add(fkt4);
                                }
                            }
                            i++;
                        }
                    }
                    return arrayList;
                }
            };
            return new fdf(fdt.O000000o().O000000o(O000000o22, new fdh<NetResult, NetError>() {
                /* class _m_j.fko.AnonymousClass6 */

                public final /* synthetic */ void onFailure(Error error) {
                    NetError netError = (NetError) error;
                    if (jSONArray2 != null) {
                        StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < jSONArray2.length(); i++) {
                            if (i != 0) {
                                sb.append(";");
                            }
                            sb.append(jSONArray2.optJSONObject(i).optString("model"));
                        }
                        hxi.O0000Oo.O000000o(2, sb.toString());
                    }
                    fde2.sendFailureMessage(new fdg(netError.f6718O000000o, netError.O00000Oo));
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    fdw.O000000o().O000000o((NetResult) obj, r42, fde2);
                }
            }));
        } catch (JSONException unused) {
            fde2.sendFailureMessage(new fdg(-1, ""));
            return new fdf(null);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:3|4|(2:6|7)|8|9|10|(3:12|13|(1:19))|20|(1:22)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0049 A[SYNTHETIC, Splitter:B:12:0x0049] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0077 A[Catch:{ JSONException -> 0x008a }] */
    public final fdf O000000o(Context context, DeviceStat deviceStat, final fde<JSONObject, fdg> fde) {
        O00000Oo();
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        if (deviceStat != null) {
            try {
                jSONObject.put("did", deviceStat.did);
                jSONObject.put("platform", "android");
                if (context != null) {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    StringBuilder sb = new StringBuilder();
                    sb.append(packageInfo.versionCode);
                    jSONObject.put("app_level", sb.toString());
                }
                if (!TextUtils.isEmpty(deviceStat.model)) {
                    if (deviceStat.model.equals("chuangmi.camera.ipc009") || deviceStat.model.equals("chuangmi.camera.ipc019") || deviceStat.model.equals("chuangmi.camera.ipc021")) {
                        jSONObject.put("plugin_level", "96");
                    }
                }
                PluginPackageInfo O00000Oo2 = fcx.f16092O000000o.O00000Oo(deviceStat.model);
                if (O00000Oo2 != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(O00000Oo2.O00000oO());
                    jSONObject.put("plugin_level", sb2.toString());
                }
            } catch (JSONException unused) {
            }
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/check_device_version").O000000o(arrayList).O000000o();
        final $$Lambda$fko$dW3vta9X8ucP_XAHL2BDWS5YKQI r6 = $$Lambda$fko$dW3vta9X8ucP_XAHL2BDWS5YKQI.INSTANCE;
        return new fdf(fdt.O000000o().O000000o(O000000o2, new fdh<NetResult, NetError>() {
            /* class _m_j.fko.AnonymousClass7 */

            public final /* synthetic */ void onFailure(Error error) {
                NetError netError = (NetError) error;
                fdg fdg = new fdg(netError.f6718O000000o, netError.O00000Oo);
                fde fde = fde;
                if (fde != null) {
                    fde.sendFailureMessage(fdg);
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                fdw.O000000o().O000000o((NetResult) obj, r6, fde);
            }
        }));
    }
}
