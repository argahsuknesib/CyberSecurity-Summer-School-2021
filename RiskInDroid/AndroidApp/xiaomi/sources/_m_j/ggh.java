package _m_j;

import android.content.Context;
import android.text.TextUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ggh {
    private static ggh O00000Oo = new ggh();

    /* renamed from: O000000o  reason: collision with root package name */
    public List<String> f17740O000000o = new ArrayList();
    private List<String> O00000o = new ArrayList();
    private JSONObject O00000o0 = null;

    public static ggh O000000o() {
        return O00000Oo;
    }

    private ggh() {
        try {
            O00000Oo();
            JSONObject optJSONObject = this.O00000o0.optJSONObject("home_background_style");
            if (optJSONObject != null) {
                JSONArray optJSONArray = optJSONObject.optJSONArray("backgroundNames");
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("styles");
                if (optJSONArray == null) {
                    return;
                }
                if (optJSONArray2 != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        this.O00000o.add(optJSONArray.optString(i));
                    }
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        this.f17740O000000o.add(optJSONArray2.optString(i2));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final boolean O000000o(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("_")) == -1) {
            return false;
        }
        if (!this.f17740O000000o.contains(str.substring(0, lastIndexOf))) {
            return false;
        }
        if (!this.O00000o.contains(str.substring(lastIndexOf + 1))) {
            return false;
        }
        return true;
    }

    public final JSONObject O00000Oo() {
        JSONObject jSONObject = this.O00000o0;
        if (jSONObject != null) {
            return jSONObject;
        }
        Context O00000Oo2 = fsp.O00000Oo();
        InputStream inputStream = null;
        if (O00000Oo2 == null) {
            return null;
        }
        try {
            inputStream = O00000Oo2.getResources().getAssets().open("room_background_config.json");
            this.O00000o0 = new JSONObject(new String(fim.O000000o(inputStream)));
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            gpg.O000000o(inputStream);
            throw th;
        }
        gpg.O000000o(inputStream);
        return this.O00000o0;
    }
}
