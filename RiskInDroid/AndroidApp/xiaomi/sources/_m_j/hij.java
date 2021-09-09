package _m_j;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hij {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f18962O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public int O00000oO = 0;

    public static hij O000000o(String str) {
        hij hij = new hij();
        try {
            JSONObject jSONObject = new JSONObject(str);
            hij.O00000Oo = jSONObject.optString("bt_mac");
            hij.O00000o0 = jSONObject.optString("wifi_mac");
            hij.O00000o = jSONObject.optString("id_hash");
            hij.f18962O000000o = jSONObject.optString("did");
            JSONArray optJSONArray = jSONObject.optJSONArray("supports");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    if (TextUtils.equals(optJSONArray.optString(i), "tv_screen")) {
                        hij.O00000oO |= 1;
                    } else if (TextUtils.equals(optJSONArray.optString(i), "voice_relay")) {
                        hij.O00000oO |= 2;
                    } else if (TextUtils.equals(optJSONArray.optString(i), "phone_relay")) {
                        hij.O00000oO |= 4;
                    } else if (TextUtils.equals(optJSONArray.optString(i), "videocall_relay")) {
                        hij.O00000oO |= 8;
                    } else if (TextUtils.equals(optJSONArray.optString(i), "video_relay")) {
                        hij.O00000oO |= 16;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return hij;
    }

    public final JSONObject O000000o() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.O00000Oo)) {
                jSONObject.put("bt_mac", this.O00000Oo);
            }
            if (!TextUtils.isEmpty(this.O00000o0)) {
                jSONObject.put("wifi_mac", this.O00000o0);
            }
            if (!TextUtils.isEmpty(this.O00000o)) {
                jSONObject.put("id_hash", this.O00000o);
            }
            if (!TextUtils.isEmpty(this.f18962O000000o)) {
                jSONObject.put("did", this.f18962O000000o);
            }
            JSONArray jSONArray = new JSONArray();
            int i = 1;
            if ((this.O00000oO & 1) == 1) {
                jSONArray.put(0, "tv_screen");
            } else {
                i = 0;
            }
            if ((this.O00000oO & 2) == 2) {
                jSONArray.put(i, "voice_relay");
                i++;
            }
            if ((this.O00000oO & 4) == 4) {
                jSONArray.put(i, "phone_relay");
                i++;
            }
            if ((this.O00000oO & 8) == 8) {
                jSONArray.put(i, "videocall_relay");
                i++;
            }
            if ((this.O00000oO & 16) == 16) {
                jSONArray.put(i, "video_relay");
            }
            if (jSONArray.length() > 0) {
                jSONObject.put("supports", jSONArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
