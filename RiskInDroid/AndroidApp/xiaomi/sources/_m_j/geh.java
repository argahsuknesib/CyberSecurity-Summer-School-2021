package _m_j;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.library.log.LogType;
import org.json.JSONException;
import org.json.JSONObject;

public final class geh extends gdy {
    public final boolean onReceiveMessage(String str, String str2) {
        O000000o(str2);
        return true;
    }

    public final boolean onReceiveNotifiedMessage(String str, String str2) {
        O000000o(str2);
        return true;
    }

    private static void O000000o(String str) {
        Class O00000Oo;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            JSONObject optJSONObject = jSONObject.optJSONObject("params");
            if (optJSONObject != null && optJSONObject.optBoolean("use_params_url")) {
                String optString2 = optJSONObject.optString("url");
                if (!TextUtils.isEmpty(optString2)) {
                    optString = optString2;
                }
            }
            gsy.O00000o0(LogType.PUSH, "CommonUriPushListener", "processMessage ".concat(String.valueOf(optString)));
            if (!TextUtils.isEmpty(optString) && (O00000Oo = fbs.O00000Oo(Activity.class, "com.xiaomi.smarthome.framework.navigate.SmartHomeLauncher")) != null) {
                Intent intent = new Intent(ServiceApplication.getAppContext(), O00000Oo);
                intent.setData(Uri.parse(optString));
                intent.addFlags(268435456);
                ServiceApplication.getAppContext().startActivity(intent);
            }
        } catch (JSONException e) {
            gsy.O000000o(6, "SmartHome-Push", Log.getStackTraceString(e));
        } catch (Exception e2) {
            gsy.O000000o(6, "SmartHome-Push", Log.getStackTraceString(e2));
        }
    }
}
