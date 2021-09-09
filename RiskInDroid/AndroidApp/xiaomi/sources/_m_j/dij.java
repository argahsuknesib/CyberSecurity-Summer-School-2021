package _m_j;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.open.utils.a;
import org.json.JSONObject;

public final class dij {
    private static SharedPreferences O0000O0o;

    /* renamed from: O000000o  reason: collision with root package name */
    public String f14674O000000o;
    public String O00000Oo;
    private int O00000o = 1;
    public String O00000o0;
    private long O00000oO = -1;
    private a O00000oo;

    public dij(String str) {
        this.f14674O000000o = str;
    }

    public final boolean O000000o() {
        return this.O00000Oo != null && System.currentTimeMillis() < this.O00000oO;
    }

    public final void O000000o(String str, String str2) throws NumberFormatException {
        this.O00000Oo = str;
        this.O00000oO = 0;
        if (str2 != null) {
            this.O00000oO = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public final boolean O000000o(JSONObject jSONObject) {
        try {
            if (this.O00000oo == null) {
                this.O00000oo = new a(djk.O000000o());
            }
            return O000000o(this.f14674O000000o, jSONObject, this.O00000oo);
        } catch (Exception e) {
            diz.O00000o0("QQToken", "login saveSession" + e.toString());
            return false;
        }
    }

    @TargetApi(11)
    public static synchronized SharedPreferences O00000Oo() {
        SharedPreferences sharedPreferences;
        synchronized (dij.class) {
            if (O0000O0o == null) {
                O0000O0o = djk.O000000o().getSharedPreferences("token_info_file", 0);
            }
            sharedPreferences = O0000O0o;
        }
        return sharedPreferences;
    }

    private static synchronized boolean O000000o(String str, JSONObject jSONObject, a aVar) {
        synchronized (dij.class) {
            if (djk.O000000o() == null) {
                diz.O00000o0("QQToken", "saveJsonPreference context null");
                return false;
            } else if (str == null || jSONObject == null) {
                diz.O00000o0("QQToken", "saveJsonPreference prefKey or jsonObject null");
                return false;
            } else {
                try {
                    String string = jSONObject.getString("expires_in");
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put("expires_time", System.currentTimeMillis() + (Long.parseLong(string) * 1000));
                        String O000000o2 = O000000o(str);
                        String O000000o3 = aVar.O000000o(jSONObject.toString());
                        if (O000000o2.length() > 6) {
                            if (O000000o3 != null) {
                                O00000Oo().edit().putString(O000000o2, O000000o3).commit();
                                diz.O00000o0("QQToken", "saveJsonPreference sucess");
                                return true;
                            }
                        }
                        diz.O00000o0("QQToken", "saveJsonPreference keyEncode or josnEncode null");
                        return false;
                    }
                    diz.O00000o0("QQToken", "expires is null");
                    return false;
                } catch (Exception e) {
                    diz.O00000oO("QQToken", "saveJsonPreference exception:" + e.toString());
                    return false;
                }
            }
        }
    }

    public static String O000000o(String str) {
        return Base64.encodeToString(djp.O00000oO(str), 2) + "_aes_google";
    }

    @Deprecated
    public static String O00000Oo(String str) {
        return Base64.encodeToString(djp.O00000oO(str), 2) + "_spkey";
    }
}
