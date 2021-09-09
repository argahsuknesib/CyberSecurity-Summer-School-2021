package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import org.json.JSONException;
import org.json.JSONObject;

public final class hje {

    /* renamed from: O000000o  reason: collision with root package name */
    private static hje f18974O000000o;

    public interface O000000o {
        void O000000o();

        void O000000o(int i);
    }

    private hje() {
    }

    public static hje O000000o() {
        if (f18974O000000o == null) {
            f18974O000000o = new hje();
        }
        return f18974O000000o;
    }

    public static void O00000Oo() {
        if (!TextUtils.isEmpty(CoreApi.O000000o().O0000o0()) && hjc.O00000Oo(ServiceApplication.getAppContext())) {
            hjf.O000000o(ServiceApplication.getAppContext()).O00000o0 = true;
            hjf.O000000o(ServiceApplication.getAppContext()).O000000o(true);
            hjf.O000000o(ServiceApplication.getAppContext()).O000000o();
        }
    }

    public static void O00000o0() {
        hjf.O000000o(ServiceApplication.getAppContext()).O00000oo();
    }

    public static void O000000o(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (hjf.O000000o(ServiceApplication.getAppContext()).O00000o0) {
                    String optString = jSONObject.optString("did");
                    if (hjf.O000000o(ServiceApplication.getAppContext()).O000000o(optString)) {
                        hjf.O000000o(ServiceApplication.getAppContext()).O000000o(optString, jSONObject.optJSONArray("attrs"));
                        hjf.O000000o(ServiceApplication.getAppContext()).O0000O0o();
                    }
                }
            } catch (JSONException unused) {
            }
        }
    }

    public static void O00000o() {
        hjf.O000000o(ServiceApplication.getAppContext()).O00000oo();
    }

    public static void O00000oO() {
        hjc.O000000o(ServiceApplication.getAppContext());
        hjf.O000000o(ServiceApplication.getAppContext()).O00000oo();
        hjf.O000000o(ServiceApplication.getAppContext()).O00000o0 = false;
    }
}
