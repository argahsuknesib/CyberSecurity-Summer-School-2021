package _m_j;

import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.util.Device;
import java.util.HashMap;
import java.util.Map;

public class cam<T extends BaseResult> extends Request<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13524O000000o = "cam";
    private cak<T> O00000Oo;
    private Map<String, String> O00000o;
    private Class<T> O00000o0;
    private String O00000oO;

    public /* synthetic */ void deliverResponse(Object obj) {
        this.O00000Oo.onResponse((BaseResult) obj);
    }

    public cam(String str, Class<T> cls, cak<T> cak) {
        super(0, str, cak);
        this.O00000Oo = cak;
        this.O00000o0 = cls;
        this.O00000oO = str;
    }

    public cam(String str, Class<T> cls, Map<String, String> map, cak<T> cak) {
        super(1, str, cak);
        this.O00000Oo = cak;
        this.O00000o0 = cls;
        this.O00000o = map;
        this.O00000oO = str;
    }

    public Map<String, String> getParams() throws AuthFailureError {
        return this.O00000o;
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

    public Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            byte b = networkResponse.data[networkResponse.data.length - 1];
            byte[] bArr = new byte[(networkResponse.data.length - 1)];
            System.arraycopy(networkResponse.data, 0, bArr, 0, networkResponse.data.length - 1);
            if (2 == b || 1 == b) {
                if (2 == b) {
                    bArr = cdv.O000000o(bArr);
                }
                return Response.success((BaseResult) this.O00000o0.getMethod("decode", byte[].class).invoke(null, bArr), HttpHeaderParser.parseCacheHeaders(networkResponse));
            }
            return Response.error(new ParseError(new Exception("Protobuf Format Incorrect!" + this.O00000oO)));
        } catch (Exception e) {
            return Response.error(new ParseError(e));
        }
    }

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + getParamsEncoding();
    }
}
