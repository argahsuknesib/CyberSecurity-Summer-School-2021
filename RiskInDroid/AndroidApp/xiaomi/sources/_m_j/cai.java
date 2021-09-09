package _m_j;

import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.mi.util.Device;
import java.util.Map;

public class cai extends ceq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f13522O000000o = "cai";

    public cai(String str, Response.Listener<byte[]> listener, Response.ErrorListener errorListener) {
        this(0, str, null, listener, errorListener);
    }

    public cai(int i, String str, String str2, Response.Listener<byte[]> listener, Response.ErrorListener errorListener) {
        super(i, str, str2, listener, errorListener);
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
        String str = f13522O000000o;
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
