package _m_j;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.notishortcut.inward.QuickOpServiceNew;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hjf {
    public static Map<String, O00000Oo> O00000Oo = new HashMap();
    private static volatile hjf O0000O0o;

    /* renamed from: O000000o  reason: collision with root package name */
    public List<O000000o> f18975O000000o = new ArrayList();
    public Map<String, Bitmap> O00000o = new ConcurrentHashMap();
    public boolean O00000o0;
    public Map<String, Integer> O00000oO = new HashMap();
    public Context O00000oo;

    private hjf(Context context) {
        this.O00000oo = context;
        gsy.O000000o(6, "NotiSettingManager", "NotiSettingManager " + System.currentTimeMillis());
        try {
            if (!Fresco.hasBeenInitialized()) {
                gsy.O00000o0(LogType.MAIN_PAGE, "NotiSettingManager", "NotiSettingManager-->Fresco.initialize...");
                Fresco.initialize(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.O00000o0 = hjc.O00000Oo(context);
        if (this.O00000o0) {
            gsy.O00000Oo("NotiSettingManager", "NotiSettingManager updateFromLocal");
            O000000o(false);
        }
    }

    public static hjf O000000o(Context context) {
        if (O0000O0o == null) {
            synchronized (hjf.class) {
                if (O0000O0o == null) {
                    O0000O0o = new hjf(context);
                }
            }
        }
        return O0000O0o;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01e2, code lost:
        return;
     */
    public final synchronized void O000000o(boolean z) {
        String str;
        if (CoreApi.O000000o().O0000oo0() && this.O00000o0) {
            O00000oo();
        } else if (this.O00000o0) {
            Context context = this.O00000oo;
            if (TextUtils.isEmpty(CoreApi.O000000o().O0000o0())) {
                gsy.O00000Oo("DeviceConfigManager", "uid is null ");
                str = "";
            } else {
                str = hjd.O00000Oo(context, "noti_device_setting" + gpp.O000000o(CoreApi.O000000o().O0000o0()), "devices", "");
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONArray optJSONArray = jSONObject.optJSONArray("config");
                    O00000Oo.clear();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        O00000Oo o00000Oo = new O00000Oo();
                        o00000Oo.f18983O000000o = optJSONObject.optString("model");
                        o00000Oo.O00000Oo = optJSONObject.optString("prop_name");
                        o00000Oo.O00000o0 = optJSONObject.optString("prop_on");
                        o00000Oo.O00000o = optJSONObject.optString("prop_off");
                        o00000Oo.O00000oO = optJSONObject.optString("rpc_method_on");
                        o00000Oo.O00000oo = optJSONObject.optString("rpc_method_off");
                        o00000Oo.O0000O0o = optJSONObject.optString("prop_params_on");
                        o00000Oo.O0000OOo = optJSONObject.optString("prop_params_off");
                        O00000Oo.put(o00000Oo.f18983O000000o, o00000Oo);
                    }
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("list");
                    this.f18975O000000o.clear();
                    HashSet hashSet = new HashSet();
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                        O000000o o000000o = new O000000o();
                        o000000o.f18982O000000o = optJSONObject2.optString("id");
                        o000000o.O00000Oo = optJSONObject2.optString("name");
                        o000000o.O00000o0 = optJSONObject2.optString("model");
                        o000000o.O00000o = optJSONObject2.optBoolean("is_online");
                        o000000o.O0000Oo = optJSONObject2.optString("ic_off");
                        o000000o.O0000Oo0 = optJSONObject2.optString("ic_on");
                        o000000o.O0000OoO = optJSONObject2.optString("ic_offline");
                        JSONObject optJSONObject3 = optJSONObject2.optJSONObject("props");
                        if (!(optJSONObject3 == null || TextUtils.isEmpty(o000000o.O00000o0) || O00000Oo.get(o000000o.O00000o0) == null)) {
                            if (TextUtils.equals(O00000Oo.get(o000000o.O00000o0).O00000o0, optJSONObject3.optString(O00000Oo.get(o000000o.O00000o0).O00000Oo))) {
                                o000000o.O00000oO = true;
                                o000000o.O0000o00 = O00000Oo.get(o000000o.O00000o0).O0000O0o;
                                o000000o.O0000Ooo = O00000Oo.get(o000000o.O00000o0).O00000oO;
                            } else {
                                o000000o.O00000oO = false;
                                o000000o.O0000o00 = O00000Oo.get(o000000o.O00000o0).O0000OOo;
                                o000000o.O0000Ooo = O00000Oo.get(o000000o.O00000o0).O00000oo;
                            }
                        }
                        this.f18975O000000o.add(o000000o);
                        hashSet.add(o000000o.O0000Oo0);
                        if (!TextUtils.isEmpty(o000000o.O0000Oo0)) {
                            O00000o0(o000000o.O0000Oo0);
                        }
                        hashSet.add(o000000o.O0000Oo);
                        if (!TextUtils.isEmpty(o000000o.O0000Oo)) {
                            O00000o0(o000000o.O0000Oo);
                        }
                        hashSet.add(o000000o.O0000OoO);
                        if (!TextUtils.isEmpty(o000000o.O0000OoO)) {
                            O00000o0(o000000o.O0000OoO);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (z) {
                    O0000O0o();
                }
            }
        }
    }

    public final boolean O000000o(String str, JSONArray jSONArray) {
        return O000000o(O000000o.O000000o(O00000Oo(str), jSONArray));
    }

    public final synchronized boolean O000000o(O000000o o000000o) {
        if (o000000o == null) {
            return false;
        }
        for (int i = 0; i < this.f18975O000000o.size(); i++) {
            if (TextUtils.equals(this.f18975O000000o.get(i).f18982O000000o, o000000o.f18982O000000o)) {
                this.f18975O000000o.get(i).O00000Oo = o000000o.O00000Oo;
                this.f18975O000000o.get(i).O00000o = o000000o.O00000o;
                this.f18975O000000o.get(i).O00000oO = o000000o.O00000oO;
                if (!TextUtils.isEmpty(o000000o.O00000o0) && O00000Oo.get(o000000o.O00000o0) != null) {
                    if (o000000o.O00000oO) {
                        this.f18975O000000o.get(i).O0000o00 = O00000Oo.get(o000000o.O00000o0).O0000O0o;
                        this.f18975O000000o.get(i).O0000Ooo = O00000Oo.get(o000000o.O00000o0).O00000oO;
                    } else {
                        this.f18975O000000o.get(i).O0000o00 = O00000Oo.get(o000000o.O00000o0).O0000OOo;
                        this.f18975O000000o.get(i).O0000Ooo = O00000Oo.get(o000000o.O00000o0).O00000oo;
                    }
                }
                O00000Oo();
                return true;
            }
        }
        return false;
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
    public final void O000000o() {
        if (this.O00000o0) {
            String O00000o02 = hjc.O00000o0(this.O00000oo);
            if (!TextUtils.isEmpty(O00000o02)) {
                try {
                    JSONArray jSONArray = new JSONArray(O00000o02);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("dids", jSONArray);
                    } catch (JSONException unused) {
                        gsy.O000000o(6, "NotiSettingManager", "-999  : JSONException");
                    }
                    jSONObject.put("get_online_status", true);
                    jSONObject.put("get_props", true);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                    CoreApi.O000000o().O000000o(this.O00000oo, new NetRequest.O000000o().O000000o("POST").O00000Oo("/device/deviceinfo").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                        /* class _m_j.hjf.AnonymousClass1 */

                        public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                            return jSONObject;
                        }
                    }, Crypto.RC4, new fsm<JSONObject, fso>() {
                        /* class _m_j.hjf.AnonymousClass2 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            try {
                                JSONArray optJSONArray = ((JSONObject) obj).optJSONArray("list");
                                if (optJSONArray == null) {
                                    return;
                                }
                                if (optJSONArray.length() != 0) {
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                                        O000000o o000000o = new O000000o();
                                        o000000o.f18982O000000o = jSONObject.optString("did");
                                        o000000o.O00000Oo = jSONObject.optString("name");
                                        o000000o.O00000o0 = jSONObject.optString("model");
                                        o000000o.O00000o = jSONObject.optInt("is_online") != 0;
                                        JSONObject optJSONObject = jSONObject.optJSONObject("props");
                                        if (!(optJSONObject == null || hjf.O00000Oo.get(o000000o.O00000o0) == null)) {
                                            String str = hjf.O00000Oo.get(o000000o.O00000o0).O00000Oo;
                                            String str2 = hjf.O00000Oo.get(o000000o.O00000o0).O00000o0;
                                            if (!TextUtils.isEmpty(str)) {
                                                if (!TextUtils.isEmpty(str2)) {
                                                    if (TextUtils.equals(str2, optJSONObject.optString("prop.".concat(String.valueOf(str))))) {
                                                        o000000o.O00000oO = true;
                                                        o000000o.O0000o00 = hjf.O00000Oo.get(o000000o.O00000o0).O0000O0o;
                                                        o000000o.O0000Ooo = hjf.O00000Oo.get(o000000o.O00000o0).O00000oO;
                                                    } else {
                                                        o000000o.O00000oO = false;
                                                        o000000o.O0000o00 = hjf.O00000Oo.get(o000000o.O00000o0).O0000OOo;
                                                        o000000o.O0000Ooo = hjf.O00000Oo.get(o000000o.O00000o0).O00000oo;
                                                    }
                                                }
                                            }
                                        }
                                        hjf.this.O000000o(o000000o);
                                        Intent intent = new Intent(hjf.this.O00000oo, QuickOpServiceNew.class);
                                        intent.setAction("quick_noti_setting_update");
                                        intent.putExtra("device_id", o000000o.f18982O000000o);
                                        if (Build.VERSION.SDK_INT >= 26) {
                                            ServiceApplication.getAppContext().startForegroundService(intent);
                                        } else {
                                            ServiceApplication.getAppContext().startService(intent);
                                        }
                                        gsy.O00000Oo("NotiSettingManager", "updateDevicesFromRemote onSuccess");
                                    }
                                }
                            } catch (JSONException unused) {
                                gsy.O000000o(6, "NotiSettingManager", "JSONException");
                            }
                        }

                        public final void onFailure(fso fso) {
                            gsy.O000000o(6, "NotiSettingManager", fso.O000000o() + " : " + fso.O00000Oo());
                        }
                    });
                } catch (Exception unused2) {
                    gsy.O000000o(6, "NotiSettingManager", "-999  : dids is not exist!");
                }
            }
        }
    }

    public static String O000000o(String str, String str2) {
        JSONArray jSONArray;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", (int) ((Math.random() * 100000.0d) + 100000.0d));
            jSONObject.put("method", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONArray = new JSONArray(str2);
            } else {
                jSONArray = new JSONArray();
            }
            jSONObject.put("params", jSONArray);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public final void O00000Oo() {
        JSONArray jSONArray = new JSONArray();
        for (O000000o O000000o2 : this.f18975O000000o) {
            jSONArray.put(O000000o.O000000o(O000000o2));
        }
        List<O000000o> list = this.f18975O000000o;
        if (list == null || list.size() == 0) {
            hjc.O000000o(this.O00000oo);
        } else {
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, O00000Oo> value : O00000Oo.entrySet()) {
                jSONArray2.put(O00000Oo.O000000o((O00000Oo) value.getValue()));
            }
            hjc.O000000o(this.O00000oo, jSONArray, jSONArray2);
            hjc.O000000o(this.O00000oo, this.O00000o0);
        }
        gsy.O00000Oo("NotiSettingManager", "回写成功");
    }

    public final synchronized void O00000o0() {
        if (O0000O0o != null) {
            O0000O0o = null;
            gsy.O000000o(6, "NotiSettingManager", "NotiSettingManager clear" + System.currentTimeMillis());
        }
    }

    public final synchronized void O00000o() {
        if (this.f18975O000000o != null) {
            for (int i = 0; i < this.f18975O000000o.size(); i++) {
                this.f18975O000000o.get(i).O00000oo = false;
                this.f18975O000000o.get(i).O0000O0o = 0;
            }
            this.O00000oO.clear();
        }
    }

    private O000000o O00000Oo(String str) {
        for (int i = 0; i < this.f18975O000000o.size(); i++) {
            if (TextUtils.equals(this.f18975O000000o.get(i).f18982O000000o, str)) {
                return this.f18975O000000o.get(i);
            }
        }
        return null;
    }

    public final boolean O000000o(String str) {
        return O00000Oo(str) != null;
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        String f18983O000000o;
        String O00000Oo;
        String O00000o;
        String O00000o0;
        String O00000oO;
        String O00000oo;
        String O0000O0o;
        String O0000OOo;

        O00000Oo() {
        }

        public static JSONObject O000000o(O00000Oo o00000Oo) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("model", o00000Oo.f18983O000000o);
                jSONObject.put("prop_on", o00000Oo.O00000o0);
                if (!TextUtils.isEmpty(o00000Oo.O0000O0o)) {
                    jSONObject.put("prop_params_on", o00000Oo.O0000O0o);
                }
                if (!TextUtils.isEmpty(o00000Oo.O0000OOo)) {
                    jSONObject.put("prop_params_off", o00000Oo.O0000OOo);
                }
                jSONObject.put("prop_off", o00000Oo.O00000o);
                jSONObject.put("prop_name", o00000Oo.O00000Oo);
                jSONObject.put("rpc_method_on", o00000Oo.O00000oO);
                jSONObject.put("rpc_method_off", o00000Oo.O00000oo);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f18982O000000o;
        String O00000Oo;
        boolean O00000o;
        String O00000o0;
        boolean O00000oO;
        public boolean O00000oo;
        public int O0000O0o;
        String O0000OOo;
        String O0000Oo;
        String O0000Oo0;
        String O0000OoO;
        public String O0000Ooo;
        public String O0000o00;

        O000000o() {
        }

        public static O000000o O000000o(O000000o o000000o, JSONArray jSONArray) {
            if (!(jSONArray == null || hjf.O00000Oo.get(o000000o.O00000o0) == null)) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (hjf.O00000Oo.get(o000000o.O00000o0) != null) {
                        String str = hjf.O00000Oo.get(o000000o.O00000o0).O00000Oo;
                        String optString = optJSONObject.optString("key");
                        String str2 = hjf.O00000Oo.get(o000000o.O00000o0).O00000o0;
                        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !TextUtils.equals("prop.".concat(String.valueOf(str)), optString)) {
                            return o000000o;
                        }
                        if (optJSONObject.has("value")) {
                            JSONArray optJSONArray = optJSONObject.optJSONArray("value");
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                if (TextUtils.equals(str2, optJSONArray.optString(i2))) {
                                    o000000o.O00000oO = true;
                                    o000000o.O0000o00 = hjf.O00000Oo.get(o000000o.O00000o0).O0000O0o;
                                    o000000o.O0000Ooo = hjf.O00000Oo.get(o000000o.O00000o0).O00000oO;
                                    return o000000o;
                                }
                            }
                            o000000o.O00000oO = false;
                            o000000o.O0000o00 = hjf.O00000Oo.get(o000000o.O00000o0).O0000OOo;
                            o000000o.O0000Ooo = hjf.O00000Oo.get(o000000o.O00000o0).O00000oo;
                        } else {
                            continue;
                        }
                    }
                }
            }
            return o000000o;
        }

        public static JSONObject O000000o(O000000o o000000o) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", o000000o.f18982O000000o);
                jSONObject.put("name", o000000o.O00000Oo);
                jSONObject.put("model", o000000o.O00000o0);
                jSONObject.put("is_online", o000000o.O00000o);
                jSONObject.put("ic_on", o000000o.O0000Oo0);
                jSONObject.put("ic_off", o000000o.O0000Oo);
                jSONObject.put("ic_offline", o000000o.O0000OoO);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(hjf.O00000Oo.get(o000000o.O00000o0).O00000Oo, o000000o.O00000oO ? hjf.O00000Oo.get(o000000o.O00000o0).O00000o0 : hjf.O00000Oo.get(o000000o.O00000o0).O00000o);
                jSONObject.put("props", jSONObject2);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public final synchronized void O00000oO() {
        for (O000000o next : this.f18975O000000o) {
            if (!TextUtils.isEmpty(next.O0000Oo0)) {
                O00000o0(next.O0000Oo0);
            }
            if (!TextUtils.isEmpty(next.O0000Oo)) {
                O00000o0(next.O0000Oo);
            }
            if (!TextUtils.isEmpty(next.O0000OoO)) {
                O00000o0(next.O0000OoO);
            }
        }
    }

    private void O00000o0(final String str) {
        if (!this.O00000o.containsKey(str) || this.O00000o.get(str).isRecycled()) {
            if (this.O00000o.containsKey(str) && this.O00000o.get(str).isRecycled()) {
                this.O00000o.remove(str);
            }
            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).setProgressiveRenderingEnabled(true).build(), this.O00000oo).subscribe(new BaseDataSubscriber<CloseableReference<CloseableImage>>() {
                /* class _m_j.hjf.AnonymousClass3 */

                public final void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                    gsy.O000000o(6, "NotiSettingManager", "图片下载失败");
                }

                public final void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                    CloseableReference result = dataSource.getResult();
                    if (result != null) {
                        CloseableImage closeableImage = (CloseableImage) result.get();
                        if (closeableImage instanceof CloseableBitmap) {
                            hjf.this.O00000o.put(str, ((CloseableBitmap) closeableImage).getUnderlyingBitmap());
                            if (hjf.this.O00000o0) {
                                hjf.this.O0000O0o();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    gsy.O000000o(6, "NotiSettingManager", "result null");
                }
            }, CallerThreadExecutor.getInstance());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0168, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01da, code lost:
        return;
     */
    public final synchronized void O000000o(int i, int i2) {
        if (i >= 0) {
            if (i < this.f18975O000000o.size()) {
                this.f18975O000000o.get(i).O00000oo = false;
                this.f18975O000000o.get(i).O0000O0o = 2;
                if (i2 == -4005001) {
                    this.f18975O000000o.get(i).O0000OOo = this.O00000oo.getString(R.string.noti_device_expired);
                    O0000O0o();
                    this.f18975O000000o.remove(i);
                } else if (i2 == -2) {
                    this.f18975O000000o.get(i).O0000OOo = this.O00000oo.getString(R.string.noti_device_offline);
                    this.f18975O000000o.get(i).O00000o = false;
                } else if (i2 == 0) {
                    this.O00000oO.put(this.f18975O000000o.get(i).f18982O000000o, Integer.valueOf(i));
                    this.f18975O000000o.get(i).O00000o = true;
                    String str = this.f18975O000000o.get(i).O00000o0;
                    if (this.f18975O000000o.get(i).O00000oO) {
                        this.f18975O000000o.get(i).O0000OOo = this.O00000oo.getString(R.string.noti_device_on);
                        this.f18975O000000o.get(i).O0000o00 = O00000Oo.get(str).O0000O0o;
                        this.f18975O000000o.get(i).O0000Ooo = O00000Oo.get(str).O00000oO;
                    } else {
                        this.f18975O000000o.get(i).O0000OOo = this.O00000oo.getString(R.string.noti_device_off);
                        this.f18975O000000o.get(i).O0000o00 = O00000Oo.get(str).O0000OOo;
                        this.f18975O000000o.get(i).O0000Ooo = O00000Oo.get(str).O00000oo;
                    }
                    O0000O0o();
                    if (this.O00000oO.containsValue(Integer.valueOf(i)) && i < this.f18975O000000o.size()) {
                        this.f18975O000000o.get(i).O00000oo = false;
                        this.f18975O000000o.get(i).O0000O0o = 0;
                        this.O00000oO.remove(this.f18975O000000o.get(i).f18982O000000o);
                        O0000O0o();
                    }
                } else if (i2 != 401) {
                    this.f18975O000000o.get(i).O0000OOo = this.O00000oo.getString(R.string.execute_fail);
                } else {
                    this.f18975O000000o.get(i).O0000OOo = this.O00000oo.getString(R.string.noti_token_expired);
                    Intent intent = new Intent(this.O00000oo, QuickOpServiceNew.class);
                    intent.setAction("auth_expired");
                    if (Build.VERSION.SDK_INT >= 26) {
                        ServiceApplication.getAppContext().startForegroundService(intent);
                    } else {
                        ServiceApplication.getAppContext().startService(intent);
                    }
                }
                if (this.f18975O000000o.size() <= 0) {
                    this.O00000o0 = false;
                }
                O00000Oo();
                O0000O0o();
                if (this.f18975O000000o.size() <= 0 || i >= this.f18975O000000o.size()) {
                    O00000oo();
                    return;
                }
                this.f18975O000000o.get(i).O0000O0o = 0;
                O0000O0o();
            }
        }
    }

    public final void O00000oo() {
        if (ServiceApplication.getAppContext() != null) {
            Intent intent = new Intent(this.O00000oo, QuickOpServiceNew.class);
            intent.setAction("notification_cancel");
            if (Build.VERSION.SDK_INT >= 26) {
                ServiceApplication.getAppContext().startForegroundService(intent);
            } else {
                ServiceApplication.getAppContext().startService(intent);
            }
        }
    }

    public final void O0000O0o() {
        if (ServiceApplication.getAppContext() != null) {
            Intent intent = new Intent(this.O00000oo, QuickOpServiceNew.class);
            intent.setAction("quick_noti_setting_update");
            if (Build.VERSION.SDK_INT >= 26) {
                ServiceApplication.getAppContext().startForegroundService(intent);
            } else {
                ServiceApplication.getAppContext().startService(intent);
            }
        }
    }
}
