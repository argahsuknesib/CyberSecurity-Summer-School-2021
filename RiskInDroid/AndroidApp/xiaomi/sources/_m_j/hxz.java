package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.InputStream;
import org.json.JSONObject;

public final class hxz {

    /* renamed from: O000000o  reason: collision with root package name */
    private static hxz f965O000000o = new hxz();
    private JSONObject O00000Oo = null;

    public static hxz O000000o() {
        return f965O000000o;
    }

    private hxz() {
        O00000Oo();
    }

    private JSONObject O00000Oo() {
        JSONObject jSONObject = this.O00000Oo;
        if (jSONObject != null) {
            return jSONObject;
        }
        Context appContext = CommonApplication.getAppContext();
        InputStream inputStream = null;
        if (appContext == null) {
            return null;
        }
        try {
            inputStream = appContext.getResources().getAssets().open("stat_config_onetrack.json");
            this.O00000Oo = new JSONObject(new String(hxw.O000000o(inputStream)));
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            gpg.O000000o(inputStream);
            throw th;
        }
        gpg.O000000o(inputStream);
        return this.O00000Oo;
    }

    public final String O000000o(String str, String str2) {
        JSONObject O00000Oo2 = O00000Oo();
        if (O00000Oo2 == null) {
            return str2;
        }
        try {
            String string = O00000Oo2.getJSONObject("key_map").getJSONObject(str).getString(str2);
            return string.length() <= 0 ? str2 : string;
        } catch (Exception unused) {
            return str2;
        }
    }
}
