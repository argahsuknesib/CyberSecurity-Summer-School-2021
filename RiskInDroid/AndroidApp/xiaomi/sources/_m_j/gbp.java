package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.AppConfigHelper;
import com.xiaomi.smarthome.application.CommonApplication;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public final class gbp {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f17501O000000o = true;

    public static void O000000o() {
        new AppConfigHelper(CommonApplication.getAppContext()).O000000o("android_rn_call_method_config", "1", "zh_CN", null, new AppConfigHelper.O000000o() {
            /* class _m_j.gbp.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj, Response response) {
                gbp.O000000o((String) obj);
            }

            public final void O000000o(String str, Response response) {
                gbp.O000000o(str);
            }

            public final void onFailure(gsf gsf, Exception exc, Response response) {
                if (gsf != null) {
                    gbu.O00000o(String.format("RnCallMethodConfigHelper#updateConfig,requestConfigWitchCache failed, code:%d,msg:%s", Integer.valueOf(gsf.f18205O000000o), gsf.O00000Oo));
                }
            }
        });
    }

    static boolean O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            gbu.O00000o0("RnCallMethodConfigHelper#parse, content:" + jSONObject.toString());
            if (!jSONObject.has("check_did")) {
                return false;
            }
            f17501O000000o = jSONObject.getBoolean("check_did");
            return true;
        } catch (JSONException unused) {
            gbu.O00000o0("RnCallMethodConfigHelper#parse error, content:".concat(String.valueOf(str)));
            return false;
        }
    }

    public static boolean O00000Oo() {
        return f17501O000000o;
    }
}
