package com.mi.global.shop.base.request;

import _m_j.bym;
import _m_j.byn;
import _m_j.cdv;
import _m_j.ny;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.mi.global.shop.base.service.CookieUtilService;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class SimpleJsonRequest<T extends byn> extends Request<T> {
    public static final String TAG = "SimpleJsonRequest";
    @Autowired
    CookieUtilService cookieUtilService;
    private final Gson gson = new Gson();
    private SimpleCallback<T> mCallback;
    private Class<T> mClass;
    private Map<String, String> mMap;
    private String mUrl;

    public SimpleJsonRequest(String str, Class<T> cls, SimpleCallback<T> simpleCallback) {
        super(0, str, simpleCallback);
        ny.O000000o();
        ny.O000000o(this);
        if (this.cookieUtilService != null) {
            this.mCallback = simpleCallback;
            this.mClass = cls;
            this.mUrl = str;
            return;
        }
        throw new RuntimeException("调用方需要实现 globalShopBase 组件的 Service 包的所有接口。");
    }

    public SimpleJsonRequest(String str, Class<T> cls, Map<String, String> map, SimpleCallback<T> simpleCallback) {
        super(1, str, simpleCallback);
        ny.O000000o();
        ny.O000000o(this);
        if (this.cookieUtilService != null) {
            this.mCallback = simpleCallback;
            this.mClass = cls;
            this.mMap = map;
            this.mUrl = str;
            return;
        }
        throw new RuntimeException("调用方需要实现 globalShopBase 组件的 Service 包的所有接口。");
    }

    public Map<String, String> getParams() throws AuthFailureError {
        return this.mMap;
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        HashMap hashMap = new HashMap();
        String cookies = getCookies();
        if (!TextUtils.isEmpty(cookies)) {
            hashMap.put("Cookie", cookies);
        }
        String deviceInfo = SimpleProtobufRequest.getDeviceInfo();
        if (!TextUtils.isEmpty(deviceInfo)) {
            hashMap.put("Mi-Info", deviceInfo);
        }
        return hashMap;
    }

    public String getCookies() {
        try {
            CookieSyncManager.createInstance(bym.f13411O000000o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.cookieUtilService == null) {
            ny.O000000o();
            this.cookieUtilService = (CookieUtilService) ny.O000000o(CookieUtilService.class);
        }
        return this.cookieUtilService.O000000o();
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
            return Response.success(this.gson.fromJson(jSONObject.toString(), (Class) this.mClass), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            StackTraceElement[] stackTraceElementArr = new StackTraceElement[(stackTrace.length + 1)];
            System.arraycopy(stackTrace, 0, stackTraceElementArr, 0, stackTrace.length);
            stackTraceElementArr[stackTrace.length] = new StackTraceElement("Exception url:", this.mUrl, "", 0);
            e.setStackTrace(stackTraceElementArr);
            return Response.error(new ParseError(e));
        }
    }

    /* access modifiers changed from: protected */
    public void deliverResponse(T t) {
        this.mCallback.onResponse((byn) t);
    }

    public String getBodyContentType() {
        return "application/x-www-form-urlencoded; charset=" + getParamsEncoding();
    }
}
