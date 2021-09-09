package _m_j;

import android.text.TextUtils;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class gwj {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<O000000o> f18407O000000o = new ArrayList();

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f18408O000000o;
        public boolean O00000Oo;
        public String O00000o;
        public String O00000o0;
        public String O00000oO;
        public String O00000oo;

        public static O000000o O000000o(JSONObject jSONObject, grz grz) {
            if (TextUtils.isEmpty(jSONObject.optString("password"))) {
                return null;
            }
            O000000o o000000o = new O000000o();
            o000000o.f18408O000000o = jSONObject.optInt("networkId");
            o000000o.O00000o0 = jSONObject.optString("ssid");
            o000000o.O00000o = TextUtils.isEmpty(jSONObject.optString("password")) ? "" : grz.O000000o(false, jSONObject.optString("password"));
            o000000o.O00000oO = jSONObject.optString("bssid");
            o000000o.O00000oo = jSONObject.optString("capabilities");
            o000000o.O00000Oo = true;
            return o000000o;
        }

        public static JSONObject O000000o(O000000o o000000o, grz grz) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("networkId", o000000o.f18408O000000o);
                jSONObject.put("ssid", o000000o.O00000o0);
                jSONObject.put("password", TextUtils.isEmpty(o000000o.O00000o) ? "" : grz.O000000o(o000000o.O00000o));
                jSONObject.put("bssid", o000000o.O00000oO);
                jSONObject.put("capabilities", o000000o.O00000oo);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    public final void O000000o(String str) {
        if (str != null) {
            this.f18407O000000o.clear();
            grz grz = null;
            try {
                grz = new grz(grx.O000000o("com.xiaomi.smarthome".getBytes()));
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (SecurityException e2) {
                e2.printStackTrace();
            } catch (NoSuchAlgorithmException e3) {
                e3.printStackTrace();
            }
            if (grz != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        O000000o O000000o2 = O000000o.O000000o((JSONObject) jSONArray.get(i), grz);
                        if (O000000o2 != null) {
                            this.f18407O000000o.add(O000000o2);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0022 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0023  */
    public final String O000000o() {
        grz grz;
        try {
            grz = new grz(grx.O000000o("com.xiaomi.smarthome".getBytes()));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SecurityException e2) {
            e2.printStackTrace();
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
        }
        if (grz != null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < this.f18407O000000o.size(); i++) {
            if (this.f18407O000000o.get(i).O00000Oo) {
                jSONArray.put(O000000o.O000000o(this.f18407O000000o.get(i), grz));
            }
        }
        return jSONArray.toString();
        grz = null;
        if (grz != null) {
        }
    }
}
