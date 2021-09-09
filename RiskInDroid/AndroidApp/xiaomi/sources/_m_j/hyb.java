package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.InputStream;
import org.json.JSONObject;

public final class hyb {

    /* renamed from: O000000o  reason: collision with root package name */
    private static hyb f967O000000o = new hyb();
    private JSONObject O00000Oo = null;

    public static hyb O000000o() {
        return f967O000000o;
    }

    private hyb() {
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
            inputStream = appContext.getResources().getAssets().open("stat_config.json");
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
        JSONObject jSONObject;
        String string;
        JSONObject O00000Oo2 = O00000Oo();
        if (O00000Oo2 == null) {
            return str2;
        }
        try {
            JSONObject jSONObject2 = O00000Oo2.getJSONObject("key_map");
            return (jSONObject2 == null || (jSONObject = jSONObject2.getJSONObject(str)) == null || (string = jSONObject.getString(str2)) == null || string.length() <= 0) ? str2 : string;
        } catch (Exception unused) {
        }
    }
}
