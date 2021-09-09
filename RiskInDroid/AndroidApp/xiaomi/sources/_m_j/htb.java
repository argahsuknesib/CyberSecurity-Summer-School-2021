package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.HashMap;
import org.json.JSONObject;

@Deprecated
public final class htb extends gdy {

    /* renamed from: O000000o  reason: collision with root package name */
    private HashMap<String, Object> f614O000000o = new HashMap<>();
    private String O00000Oo;

    public final boolean onReceiveMessage(String str, String str2) {
        this.O00000Oo = str;
        O000000o(str2);
        return true;
    }

    public final boolean onReceiveNotifiedMessage(String str, String str2) {
        this.O00000Oo = str;
        O000000o(str2);
        return true;
    }

    private void O000000o(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("action");
            gsy.O000000o(LogType.GENERAL, "push", "action: ".concat(String.valueOf(optString)));
            gsy.O000000o(LogType.GENERAL, "push", "source: ".concat(String.valueOf("push?msgId=" + this.O00000Oo)));
            if (!TextUtils.isEmpty(optString)) {
                if (TextUtils.equals(optString, "1")) {
                    fvj.O000000o();
                } else if (TextUtils.equals(optString, "2")) {
                    String optString2 = jSONObject.optString("gid");
                    if (!TextUtils.isEmpty(optString2)) {
                        hjp.O000000o(String.format("https://home.mi.com/shop/detail?gid=%s", optString2));
                    }
                } else if (!TextUtils.equals(optString, "3") && TextUtils.equals(optString, "4")) {
                    hjp.O000000o(jSONObject.optString("url"));
                }
            }
        } catch (Exception unused) {
        }
    }
}
