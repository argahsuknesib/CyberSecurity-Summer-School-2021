package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.AppConfigHelper;
import com.xiaomi.smarthome.application.ServiceApplication;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public final class hif {

    /* renamed from: O000000o  reason: collision with root package name */
    public static volatile boolean f18960O000000o = false;
    public static volatile boolean O00000Oo = false;
    private static boolean O00000o = false;
    private static int O00000o0 = 0;
    private static boolean O00000oO = true;
    private static String O00000oo;
    private static boolean O0000O0o;

    public static void O000000o() {
        if (!O00000Oo) {
            O00000Oo = true;
            new AppConfigHelper(ServiceApplication.getAppContext()).O000000o("miui_nfc_config", "1", "zh_CN", null, new AppConfigHelper.O000000o() {
                /* class _m_j.hif.AnonymousClass1 */

                /* renamed from: O000000o */
                public final void onSuccess(String str, Response response) {
                    try {
                        hif.O000000o(str);
                        hif.f18960O000000o = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    hif.O00000Oo = false;
                }

                public final void onFailure(gsf gsf, Exception exc, Response response) {
                    String str;
                    hif.f18960O000000o = false;
                    StringBuilder sb = new StringBuilder("updateConfig onFailure ");
                    if (gsf == null) {
                        str = null;
                    } else {
                        str = gsf.f18205O000000o + "," + gsf.O00000Oo;
                    }
                    sb.append(str);
                    hih.O000000o("NFCConfigHelper", sb.toString());
                    hif.O00000Oo = false;
                }
            });
        }
    }

    public static String O00000Oo() {
        if (!f18960O000000o) {
            O000000o();
        }
        return O00000oo;
    }

    public static boolean O00000o0() {
        if (!f18960O000000o) {
            O000000o();
        }
        return O00000o;
    }

    public static boolean O00000o() {
        if (!f18960O000000o) {
            O000000o();
        }
        return O00000oO;
    }

    public static int O00000oO() {
        if (!f18960O000000o) {
            O000000o();
        }
        return O00000o0;
    }

    public static boolean O00000oo() {
        if (!f18960O000000o) {
            O000000o();
        }
        return O0000O0o;
    }

    public static boolean O000000o(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            hih.O000000o("AppConfig nfc_config", "isFromCache:false" + ", content==null");
            str = "{\"status\":false,\"mi_connect_version\":8,\"buy_link\":\"\",\"open_plugin\":false}";
        }
        JSONObject jSONObject = new JSONObject(str);
        O00000o0 = jSONObject.optInt("mi_connect_version", -1);
        O00000o = jSONObject.optBoolean("status", false);
        O00000oo = jSONObject.optString("buy_link");
        O00000oO = jSONObject.optBoolean("wifi_connect_is_idm");
        O0000O0o = jSONObject.optBoolean("open_plugin");
        return true;
    }
}
