package _m_j;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class dtr implements Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f14937O000000o;
    public String O00000Oo = "";
    public String O00000o = "";
    public String O00000o0 = "";
    public String O00000oO = "";
    public String O00000oo = "";
    public String O0000O0o = "";
    private String O0000OOo = "";
    private HashMap<String, String> O0000Oo0 = new HashMap<>();

    public static String O000000o(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public final String O000000o() {
        if (this.O0000Oo0.isEmpty()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : this.O0000Oo0.entrySet()) {
            try {
                jSONObject.put((String) next.getKey(), next.getValue());
            } catch (JSONException unused) {
                return "";
            }
        }
        return O000000o(jSONObject.toString());
    }

    public final String O000000o(boolean z) {
        if (z) {
            return O000000o(this.O00000Oo);
        }
        return this.O00000Oo;
    }

    public final void O000000o(Context context) {
        this.f14937O000000o = context.getApplicationContext();
    }

    public final boolean O00000Oo() {
        return this.f14937O000000o != null && !TextUtils.isEmpty(this.O00000Oo) && !TextUtils.isEmpty(this.O00000o) && !TextUtils.isEmpty(this.O00000oO);
    }

    public final Object clone() {
        try {
            dtr dtr = (dtr) super.clone();
            HashMap<String, String> hashMap = new HashMap<>();
            for (Map.Entry next : dtr.O0000Oo0.entrySet()) {
                hashMap.put(next.getKey(), next.getValue());
            }
            dtr.O0000Oo0 = hashMap;
            return dtr;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }
}
