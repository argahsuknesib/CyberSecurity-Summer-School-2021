package _m_j;

import _m_j.cbm;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.mi.util.Device;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class cah extends ceo {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13520O000000o = "cah";
    public Response.Listener<JSONObject> O00000Oo;

    public cah(String str, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this(0, str, null, listener, errorListener);
    }

    public cah(int i, String str, String str2, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(i, str, str2, listener, errorListener);
        this.O00000Oo = this.mListener;
        if (this.mListener != null) {
            this.mListener = new Response.Listener<JSONObject>() {
                /* class _m_j.cah.AnonymousClass1 */

                public final /* synthetic */ void onResponse(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    try {
                        if (jSONObject.getInt("errno") == 20005) {
                            ccn O0000o00 = ccn.O0000o00();
                            O0000o00.O0000OoO();
                            String O0000Ooo = O0000o00.O0000Ooo();
                            if (!TextUtils.isEmpty(O0000Ooo)) {
                                ccr.O00000Oo(cah.f13520O000000o, "new extended token plain:".concat(String.valueOf(O0000Ooo)));
                                cbm.O00000o0.O000000o("pref_extended_token", O0000Ooo);
                                cbm.O00000o0.O000000o("pref_last_refresh_serviceToken_time", Long.valueOf(System.currentTimeMillis()));
                                ced.f13683O000000o.add((cah) cah.this.clone());
                                return;
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (CloneNotSupportedException e2) {
                        e2.printStackTrace();
                    }
                    cah.this.O00000Oo.onResponse(jSONObject);
                }
            };
        }
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = super.getHeaders();
        StringBuilder sb = new StringBuilder();
        sb.append("version=");
        sb.append(Device.O0000oO0);
        sb.append("&");
        sb.append("phone_model=");
        sb.append(Device.O00000oO);
        sb.append("&");
        sb.append("networkType=");
        sb.append(cbf.O000000o());
        sb.append("&");
        sb.append("appname=shop&");
        sb.append("android_sdk_version=");
        sb.append(Device.O0000o00);
        sb.append("&");
        sb.append("android_version=");
        sb.append(Device.O0000o0O);
        sb.append("&");
        if (TextUtils.isEmpty(cbe.O000000o(byl.O00000oO()))) {
            sb.append("DEVICEID=");
            sb.append(Device.O000O0OO);
            sb.append("&");
        } else {
            sb.append("DEVICEID=");
            sb.append(cbe.O000000o(byl.O00000oO()));
            sb.append("&");
        }
        if (byl.O0000O0o != null) {
            if (byl.O0000O0o.O00000oo.equals("community_sdk")) {
                sb.append("request_from=community_sdk&");
            } else if (byl.O0000O0o.O00000oo.equals("mihome_sdk")) {
                sb.append("request_from=mihome_sdk&");
            } else {
                sb.append("request_from=community_sdk&");
            }
        }
        String str = f13520O000000o;
        ccr.O00000Oo(str, "device:" + sb.toString());
        headers.put("Mi-Info", sb.toString());
        return headers;
    }

    public String getCookies() {
        try {
            CookieSyncManager.createInstance(byl.O00000oO());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cae.O000000o();
    }
}
