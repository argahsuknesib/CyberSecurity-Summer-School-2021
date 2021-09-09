package _m_j;

import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.AppConfigHelper;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public final class gat {

    /* renamed from: O000000o  reason: collision with root package name */
    public static volatile boolean f17471O000000o = false;
    private static final Set<String> O00000Oo;
    private static JSONObject O00000o = new JSONObject();
    private static JSONObject O00000o0 = new JSONObject();
    private static JSONObject O00000oO = new JSONObject();

    static {
        HashSet hashSet = new HashSet();
        O00000Oo = hashSet;
        hashSet.add("null");
    }

    public static <T> T O000000o(String str, T t) {
        return O00000o0.has(str) ? O00000o0.opt(str) : t;
    }

    public static void O000000o() {
        new AppConfigHelper(CommonApplication.getAppContext()).O000000o("rn_pluginkit_common_config", "1", "zh_CN", "plugin_config/rn_pluginkit_common_config.json", new AppConfigHelper.O00000Oo() {
            /* class _m_j.gat.AnonymousClass1 */

            public final boolean O000000o(String str) throws Exception {
                gat.O000000o(str);
                return gat.f17471O000000o;
            }

            public final boolean O00000Oo(String str) throws Exception {
                gat.O000000o(str);
                return gat.f17471O000000o;
            }
        }, new AppConfigHelper.O000000o() {
            /* class _m_j.gat.AnonymousClass2 */

            /* renamed from: O000000o */
            public final void onSuccess(String str, Response response) {
                gat.f17471O000000o = true;
                gat.O000000o(str);
            }

            public final void onFailure(gsf gsf, Exception exc, Response response) {
                if (gsf != null) {
                    fyc.O00000o0("MRnConfig", String.format("requestUpdateConfig,requestConfigWitchCache failed, code:%d,msg:%s", Integer.valueOf(gsf.f18205O000000o), gsf.O00000Oo));
                }
            }
        });
    }

    public static void O000000o(String str) {
        if (TextUtils.isEmpty(str) || O00000Oo.contains(str)) {
            fyc.O00000o0("MRnConfig", "parse ,invalid content:".concat(String.valueOf(str)));
            return;
        }
        new HashMap();
        try {
            fyc.O000000o("MRnConfig", "parse, content:".concat(String.valueOf(str)));
            JSONObject jSONObject = new JSONObject(str);
            JSONObject optJSONObject = jSONObject.optJSONObject("android");
            JSONObject optJSONObject2 = jSONObject.optJSONObject("js");
            JSONObject optJSONObject3 = jSONObject.optJSONObject("both");
            if (optJSONObject != null) {
                O00000o0 = optJSONObject;
            } else {
                O00000o0 = new JSONObject();
            }
            if (optJSONObject2 != null) {
                O00000o = optJSONObject2;
            } else {
                O00000o = new JSONObject();
            }
            if (optJSONObject3 != null) {
                O00000oO = optJSONObject3;
            } else {
                O00000oO = new JSONObject();
            }
        } catch (JSONException e) {
            fyc.O000000o("MRnConfig", "parse config error, exception:" + Log.getStackTraceString(e));
        }
    }

    public static <T> T O00000Oo(String str) {
        if (O00000o.has(str)) {
            return O00000o.opt(str);
        }
        return null;
    }

    public static <T> T O00000Oo(String str, T t) {
        return O00000oO.has(str) ? O00000oO.opt(str) : t;
    }
}
