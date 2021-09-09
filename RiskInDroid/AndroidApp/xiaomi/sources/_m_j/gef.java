package _m_j;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.library.log.LogType;
import org.json.JSONException;
import org.json.JSONObject;

public final class gef extends gdy {
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
            String optString = new JSONObject(str).optString("url");
            gsy.O000000o(LogType.GENERAL, "shop", "url: ".concat(String.valueOf(optString)));
            if (!optString.contains("/main?")) {
                cmc.O00000oo();
            }
            Class O00000Oo = fbs.O00000Oo(Activity.class, "com.xiaomi.smarthome.framework.navigate.SmartHomeLauncher");
            if (O00000Oo != null) {
                Intent intent = new Intent(ServiceApplication.getAppContext(), O00000Oo);
                intent.setData(Uri.parse(optString));
                intent.addFlags(268435456);
                ServiceApplication.getAppContext().startActivity(intent);
            }
        } catch (Exception | JSONException unused) {
        }
    }
}
