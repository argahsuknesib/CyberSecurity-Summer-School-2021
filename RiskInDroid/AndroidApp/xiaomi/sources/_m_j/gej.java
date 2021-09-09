package _m_j;

import android.os.Bundle;
import org.json.JSONObject;

public final class gej extends gdy {
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
            jSONObject.optString("model");
            String optString = jSONObject.optString("did");
            Bundle bundle = new Bundle();
            bundle.putString("device_id", optString);
            fvj.O000000o("initDeviceRoomActivity", bundle, true, 335544320);
        } catch (Exception unused) {
        }
    }
}
