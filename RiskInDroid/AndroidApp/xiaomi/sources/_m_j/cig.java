package _m_j;

import android.os.Handler;
import android.os.Looper;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import org.json.JSONArray;
import org.json.JSONObject;

public final class cig {

    /* renamed from: O000000o  reason: collision with root package name */
    public static long f13893O000000o;
    private static String O00000Oo;
    private static Handler O00000o0 = new Handler(Looper.getMainLooper());

    public static void O000000o(Callback<String> callback) {
        String str = O00000Oo;
        if (str != null) {
            callback.onSuccess(str);
            O00000Oo(null);
            return;
        }
        String O000000o2 = cil.O000000o(ckh.O000000o(), "miss_tutk_version_config");
        O00000Oo = O000000o2;
        if (O000000o2 != null) {
            callback.onSuccess(O00000Oo);
            O00000Oo(null);
            return;
        }
        O00000Oo(callback);
    }

    public static void O00000Oo(final Callback<String> callback) {
        if (System.currentTimeMillis() - f13893O000000o >= 3600000 || O00000Oo == null) {
            XmPluginHostApi.instance().getAppConfig("miss_tutk_version_config", "en", "1", new Callback<String>() {
                /* class _m_j.cig.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    String str = (String) obj;
                    gsy.O00000Oo("CameraMissUtil", str);
                    try {
                        JSONArray jSONArray = new JSONArray(str);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            jSONObject.getString("model");
                            jSONObject.getString("version");
                        }
                        cig.f13893O000000o = System.currentTimeMillis();
                        cil.O000000o("miss_tutk_version_config", str);
                        if (callback != null) {
                            callback.onSuccess(str);
                        }
                    } catch (Exception e) {
                        if (callback != null) {
                            gsy.O00000Oo("CameraMissUtils", "forceGetMissTutkVersionConfig:" + e.getLocalizedMessage());
                            callback.onFailure(-35, e.getLocalizedMessage());
                        }
                    }
                }

                public final void onFailure(int i, String str) {
                    if (callback != null) {
                        gsy.O00000Oo("CameraMissUtils", "forceGetMissTutkVersionConfig:".concat(String.valueOf(str)));
                        callback.onFailure(i, str);
                    }
                }
            });
        }
    }
}
