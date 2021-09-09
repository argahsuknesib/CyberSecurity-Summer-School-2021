package com.sdu.didi.openapi;

import _m_j.dat;
import _m_j.dau;
import _m_j.dav;
import _m_j.daw;
import _m_j.dax;
import _m_j.daz;
import _m_j.dbe;
import _m_j.gsy;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ContextThemeWrapper;
import com.sdu.didi.openapi.utils.Utils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class DIOpenSDK {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static MapLocationType f5586O000000o = MapLocationType.SYSTEM;
    /* access modifiers changed from: private */
    public static String O00000Oo;
    private static DIOpenSDK O00000o;
    private static String O00000o0;

    public enum BusinessType {
        TAXI(1),
        PREMIUM(2),
        FLASH(3),
        DRIVER_SERVICE(4);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f5592a;

        private BusinessType(int i) {
            this.f5592a = i;
        }

        public final int getValue() {
            return this.f5592a;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f5592a);
            return sb.toString();
        }
    }

    public interface DDCallBack {
        void onFinish(Map<String, String> map);
    }

    public enum MapLocationType {
        BAIDU,
        SOSO,
        GAODE,
        SYSTEM
    }

    public enum PageType {
        LOGIN("login"),
        ORDERDETAIL("orderDetail"),
        ORDERLIST("orderList"),
        INVOICE("invoice");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f5593a;

        private PageType(String str) {
            this.f5593a = str;
        }

        public final String getValue() {
            return this.f5593a;
        }

        public final String toString() {
            return this.f5593a;
        }
    }

    public enum TicketType {
        SINGLE("single"),
        LONGTIME("longtime");
        

        /* renamed from: a  reason: collision with root package name */
        private final String f5594a;

        private TicketType(String str) {
            this.f5594a = str;
        }

        public final String getValue() {
            return this.f5594a;
        }

        public final String toString() {
            return this.f5594a;
        }
    }

    static {
        System.loadLibrary("didi_secure");
        gsy.O000000o(4, "DIOpenSDK", "sdk_version:2.0.0111_18060500163622");
    }

    private DIOpenSDK() {
    }

    public static void O000000o(Context context, int i) {
        if (i == 2050) {
            dau.O000000o().O00000Oo(context);
        } else if (i == 2051) {
            dav.O000000o().O00000Oo(context);
        }
    }

    private static void O000000o(String str) {
        if (TextUtils.isEmpty(O00000o0) || TextUtils.isEmpty(O00000Oo)) {
            throw new IllegalArgumentException(str);
        }
    }

    private static String O00000Oo(String str) {
        return new String(Base64.encode(Base64.encode(str.getBytes(), 0), 0));
    }

    private static String O00000o0(String str) {
        return new String(Base64.decode(Base64.decode(str.getBytes(), 0), 0));
    }

    public static void asynCallDDApi(final Context context, final String str, final Map<String, String> map, final DDCallBack dDCallBack) {
        new AsyncTask<Void, Void, Map<String, String>>() {
            /* class com.sdu.didi.openapi.DIOpenSDK.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                Map map = (Map) obj;
                DDCallBack dDCallBack = dDCallBack;
                if (dDCallBack != null) {
                    dDCallBack.onFinish(map);
                }
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                return DIOpenSDK.syncCallDDApi(context, str, map);
            }
        }.execute(new Void[0]);
    }

    public static void asynGetTicket(final Context context, final TicketType ticketType, final DDCallBack dDCallBack) {
        new AsyncTask<Void, Void, Map<String, String>>() {
            /* class com.sdu.didi.openapi.DIOpenSDK.AnonymousClass2 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                Map map = (Map) obj;
                DDCallBack dDCallBack = dDCallBack;
                if (dDCallBack != null) {
                    dDCallBack.onFinish(map);
                }
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                return DIOpenSDK.syncGetTicket(context, ticketType);
            }
        }.execute(new Void[0]);
    }

    private native boolean callPhone(Context context, String str, String str2);

    public static String getAppId(Context context) {
        if (TextUtils.isEmpty(O00000o0)) {
            getInstance();
            O00000o0 = O00000o0(dbe.O000000o(context, "a1b2c3_1", ""));
        }
        if (TextUtils.isEmpty(O00000Oo)) {
            getInstance();
            O00000Oo = O00000o0(dbe.O000000o(context, "a1b2c3_2", ""));
        }
        O000000o("appid or secrect illegal you should call registerApp first");
        return O00000o0;
    }

    public static synchronized DIOpenSDK getInstance() {
        DIOpenSDK dIOpenSDK;
        synchronized (DIOpenSDK.class) {
            if (O00000o == null) {
                O00000o = new DIOpenSDK();
            }
            dIOpenSDK = O00000o;
        }
        return dIOpenSDK;
    }

    public static MapLocationType getMapSdkType() {
        return f5586O000000o;
    }

    public static String getSecrectStr(Context context) {
        if (TextUtils.isEmpty(O00000Oo)) {
            getInstance();
            O00000Oo = O00000o0(dbe.O000000o(context, "a1b2c3_2", ""));
        }
        if (TextUtils.isEmpty(O00000o0)) {
            getInstance();
            O00000o0 = O00000o0(dbe.O000000o(context, "a1b2c3_1", ""));
        }
        O000000o("appid or secrect illegal you should call registerApp first");
        return O00000Oo;
    }

    public static boolean isLogin(Context context) {
        return dav.O000000o().O00000o0(context);
    }

    public static void openPage(Context context, String str, Map<String, String> map, DDCallBack dDCallBack) {
        openPage(context, str, map, DiDiWebActivity.class, dDCallBack);
    }

    public static void openPage(Context context, String str, Map<String, String> map, Class<? extends DiDiWebActivity> cls, DDCallBack dDCallBack) {
        final Context context2 = context;
        final Map<String, String> map2 = map;
        final String str2 = str;
        final Class<? extends DiDiWebActivity> cls2 = cls;
        final DDCallBack dDCallBack2 = dDCallBack;
        new AsyncTask<Void, Void, Map<String, String>>() {
            /* class com.sdu.didi.openapi.DIOpenSDK.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                return O000000o();
            }

            private Map<String, String> O000000o() {
                HashMap hashMap = new HashMap();
                String str = dau.O000000o().O000000o(context2).f14425O000000o;
                if (TextUtils.isEmpty(dat.O000000o().O000000o(context2)) || TextUtils.isEmpty(str)) {
                    hashMap.put("errno", "-1");
                    hashMap.put("errmsg", "data error");
                    return hashMap;
                }
                String timestamp = Utils.getTimestamp();
                String randomString = Utils.getRandomString(10);
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    if (map2 != null && !map2.isEmpty()) {
                        jSONObject2.put("data", new JSONObject((Map<?, ?>) map2));
                    }
                    jSONObject2.put("page", str2);
                    jSONObject.put("apiname", "getPageUrl");
                    jSONObject.put("token", dav.O000000o().O000000o(context2));
                    jSONObject.put("params", jSONObject2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String jSONObject3 = jSONObject.toString();
                hashMap.put("openid", str);
                hashMap.put("timestamp", timestamp);
                hashMap.put("noncestr", randomString);
                hashMap.put("package", jSONObject3);
                hashMap.put("version", Utils.getCurrentVersion());
                DIOpenSDK instance = DIOpenSDK.getInstance();
                hashMap.put("sign", instance.getv11Sign(str + DIOpenSDK.O00000Oo + jSONObject3 + timestamp + randomString));
                String O000000o2 = daz.O000000o().O000000o("https://api.xiaojukeji.com/v1/remote", hashMap);
                new daw() {
                    /* class com.sdu.didi.openapi.DIOpenSDK.AnonymousClass3.AnonymousClass1 */

                    public final void O000000o(JSONObject jSONObject) {
                        String optString = jSONObject.optString("url");
                        if (!TextUtils.isEmpty(optString)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("special_url", optString);
                            DIOpenSDK.showDDPage(context2, hashMap, cls2);
                        }
                    }
                }.O000000o(O000000o2);
                return DIOpenSDK.getInstance().O000000o(context2, O000000o2);
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                Map map = (Map) obj;
                DDCallBack dDCallBack = dDCallBack2;
                if (dDCallBack != null) {
                    dDCallBack.onFinish(map);
                }
            }
        }.execute(new Void[0]);
    }

    public static void registerApp(Context context, String str, String str2) {
        O00000Oo = str2;
        O00000o0 = str;
        O000000o("appid or secrect illegal you should call registerApp first");
        getInstance();
        dbe.O00000Oo(context, "a1b2c3_1", O00000Oo(str));
        getInstance();
        dbe.O00000Oo(context, "a1b2c3_2", O00000Oo(str2));
    }

    public static void setMapSdkType(MapLocationType mapLocationType) {
        f5586O000000o = mapLocationType;
    }

    public static void showDDPage(Context context, HashMap<String, String> hashMap) {
        showDDPage(context, hashMap, DiDiWebActivity.class);
    }

    public static void showDDPage(Context context, HashMap<String, String> hashMap, Class<? extends DiDiWebActivity> cls) {
        O000000o("appid or secrect illegal you should call registerApp first");
        Intent intent = new Intent(context, cls);
        if (hashMap == null) {
            hashMap = new HashMap<>();
        }
        intent.putExtra("params", hashMap);
        if (!(context instanceof ContextThemeWrapper)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static Map<String, String> syncCallDDApi(Context context, String str, Map<String, String> map) {
        Map<String, String> O000000o2 = getInstance().O000000o(context, str, map);
        O000000o2.put("version", Utils.getCurrentVersion());
        return getInstance().O000000o(context, O000000o2.isEmpty() ? "" : daz.O000000o().O000000o("https://api.xiaojukeji.com/v1/remote", O000000o2));
    }

    public static Map<String, String> syncGetTicket(Context context, TicketType ticketType) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", ticketType.getValue());
        Map<String, String> O000000o2 = getInstance().O000000o(context, "getTicket", hashMap);
        return getInstance().O000000o(context, O000000o2.isEmpty() ? "" : daz.O000000o().O000000o("https://api.xiaojukeji.com/v1/remote", O000000o2));
    }

    public final native String getSDKId(String str);

    public final native String getSDKSign(String str);

    public final native String getv11Sign(String str);

    public static boolean callPhone(Context context, String str) {
        dau.O000000o();
        dax dax = new dax();
        dax.O000000o(dbe.O000000o(context, "openid_json", ""));
        if (!dax.O000000o()) {
            return false;
        }
        getInstance().callPhone(context, str, dax.f14425O000000o);
        return true;
    }

    /* access modifiers changed from: private */
    public Map<String, String> O000000o(Context context, String str) {
        final HashMap hashMap = new HashMap();
        AnonymousClass4 r1 = new daw() {
            /* class com.sdu.didi.openapi.DIOpenSDK.AnonymousClass4 */

            public final void O000000o(JSONObject jSONObject) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
            }
        };
        r1.O000000o(str);
        StringBuilder sb = new StringBuilder();
        sb.append(r1.O00000o0);
        hashMap.put("errno", sb.toString());
        O000000o(context, r1.O00000o0);
        hashMap.put("errmsg", r1.O00000o);
        return hashMap;
    }

    private Map<String, String> O000000o(Context context, String str, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        dax O000000o2 = dau.O000000o().O000000o(context);
        if (!O000000o2.O000000o() || TextUtils.isEmpty(dat.O000000o().O000000o(context))) {
            return hashMap;
        }
        String str2 = O000000o2.f14425O000000o;
        String timestamp = Utils.getTimestamp();
        String randomString = Utils.getRandomString(10);
        hashMap.put("openid", str2);
        hashMap.put("version", Utils.getCurrentVersion());
        hashMap.put("timestamp", timestamp);
        hashMap.put("noncestr", randomString);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("apiname", str);
            jSONObject.put("token", dav.O000000o().O000000o(context));
            if (map != null) {
                jSONObject.put("params", new JSONObject((Map<?, ?>) map));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        hashMap.put("package", jSONObject2);
        hashMap.put("sign", getv11Sign(str2 + O00000Oo + jSONObject2 + timestamp + randomString));
        return hashMap;
    }
}
