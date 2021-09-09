package _m_j;

import com.xiaomi.smarthome.application.ServiceApplication;
import org.json.JSONObject;

public final class frc extends gdy {

    /* renamed from: O000000o  reason: collision with root package name */
    private static frc f16956O000000o;

    public static frc O000000o() {
        if (f16956O000000o == null) {
            f16956O000000o = new frc();
        }
        return f16956O000000o;
    }

    public final boolean onReceiveMessage(String str, String str2) {
        O000000o(str2);
        return true;
    }

    public final boolean onReceiveNotifiedMessage(String str, String str2) {
        O000000o(str2);
        return true;
    }

    private static void O000000o(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            fre.O000000o().O00000Oo(jSONObject.optString("subid"), jSONObject.optString("did"), jSONObject.optString("model"), jSONObject.optJSONArray("attrs"));
            ServiceApplication.getAppContext();
            hje.O000000o();
            hje.O000000o(str);
        } catch (Exception unused) {
        }
    }
}
