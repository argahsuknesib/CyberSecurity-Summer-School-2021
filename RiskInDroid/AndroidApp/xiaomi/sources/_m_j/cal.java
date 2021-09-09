package _m_j;

import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.util.Device;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class cal<T extends BaseResult> extends Request<T> {
    public static final String O00000o = "cal";

    /* renamed from: O000000o  reason: collision with root package name */
    private final Gson f13523O000000o = new Gson();
    private cak<T> O00000Oo;
    private Class<T> O00000o0;
    private Map<String, String> O00000oO;
    private String O00000oo;

    public /* synthetic */ void deliverResponse(Object obj) {
        this.O00000Oo.onResponse((BaseResult) obj);
    }

    public cal(String str, Class<T> cls, cak<T> cak) {
        super(0, str, cak);
        this.O00000Oo = cak;
        this.O00000o0 = cls;
        this.O00000oo = str;
    }

    public cal(String str, Class<T> cls, Map<String, String> map, cak<T> cak) {
        super(1, str, cak);
        this.O00000Oo = cak;
        this.O00000o0 = cls;
        this.O00000oO = map;
        this.O00000oo = str;
    }

    public Map<String, String> getParams() throws AuthFailureError {
        return this.O00000oO;
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        HashMap hashMap = new HashMap();
        String O000000o2 = O000000o();
        if (!TextUtils.isEmpty(O000000o2)) {
            hashMap.put("Cookie", O000000o2);
        }
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
        sb.append("device_width=");
        sb.append(Device.f5099O000000o);
        sb.append("&");
        sb.append("device_height=");
        sb.append(Device.O00000Oo);
        sb.append("&");
        if (byl.O0000O0o != null) {
            if (byl.O0000O0o.O00000oo.equals("community_sdk")) {
                sb.append("request_from=community_sdk&");
            } else if (byl.O0000O0o.O00000oo.equals("mihome_sdk")) {
                sb.append("request_from=mihome_sdk&");
            } else {
                sb.append("request_from=community_sdk&");
            }
        }
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(sb2)) {
            hashMap.put("Mi-Info", sb2);
        }
        return hashMap;
    }

    private static String O000000o() {
        try {
            CookieSyncManager.createInstance(byl.O00000oO());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cae.O000000o();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.gson.Gson.fromJson(java.lang.String, java.lang.Class):T
     arg types: [java.lang.String, java.lang.Class<T>]
     candidates:
      com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.Class):T
      com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(com.google.gson.stream.JsonReader, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.io.Reader, java.lang.Class):T
      com.google.gson.Gson.fromJson(java.io.Reader, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.lang.String, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.lang.String, java.lang.Class):T */
    public Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            JSONObject jSONObject = new JSONObject(new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers)));
            if (jSONObject.optBoolean("security")) {
                String O000000o2 = cdv.O000000o(jSONObject.optString("data"));
                if (!TextUtils.isEmpty(O000000o2)) {
                    jSONObject.put("data", new JSONObject(O000000o2));
                }
            }
            return Response.success(this.f13523O000000o.fromJson(jSONObject.toString(), (Class) this.O00000o0), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            StackTraceElement[] stackTraceElementArr = new StackTraceElement[(stackTrace.length + 1)];
            System.arraycopy(stackTrace, 0, stackTraceElementArr, 0, stackTrace.length);
            stackTraceElementArr[stackTrace.length] = new StackTraceElement("Exception url:", this.O00000oo, "", 0);
            e.setStackTrace(stackTraceElementArr);
            return Response.error(new ParseError(e));
        }
    }

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + getParamsEncoding();
    }
}
