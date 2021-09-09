package _m_j;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONObject;

public final class geg extends gdy {
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
            if (TextUtils.isEmpty(str)) {
                O000000o();
            }
            if (!gva.O000000o().clickCommonMessage(new JSONObject(str).optJSONObject("params"))) {
                O000000o();
            }
        } catch (Exception unused) {
            O000000o();
        }
    }

    private static void O000000o() {
        fvj.O000000o("/message/MessageCenterActivity", new Bundle(), true, 67108864);
    }
}
