package com.mi.global.shop.base.request;

import _m_j.bym;
import _m_j.byn;
import _m_j.byp;
import _m_j.cdv;
import _m_j.ny;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.mi.global.shop.base.service.AppVersionService;
import com.mi.global.shop.base.service.CookieUtilService;
import com.mi.global.shop.base.service.GlobalConfigService;
import com.mi.global.shop.base.service.LocaleService;
import com.mi.util.Device;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class SimpleProtobufRequest<T extends byn> extends Request<T> {
    public static final String TAG = "SimpleProtobufRequest";
    @Autowired
    static AppVersionService appVersionService;
    @Autowired
    static GlobalConfigService globalConfigService;
    @Autowired
    static LocaleService localeService;
    @Autowired
    CookieUtilService cookieUtilService;
    private SimpleCallback<T> mCallback;
    private Class<T> mClass;
    private Map<String, String> mMap;
    private String mUrl;

    public SimpleProtobufRequest(String str, Class<T> cls, SimpleCallback<T> simpleCallback) {
        super(0, str, simpleCallback);
        ny.O000000o();
        ny.O000000o(this);
        if (this.cookieUtilService == null || localeService == null || globalConfigService == null || appVersionService == null) {
            throw new RuntimeException("调用方需要实现 globalShopBase 组件的 Service 包的所有接口。");
        }
        this.mCallback = simpleCallback;
        this.mClass = cls;
        this.mUrl = str;
    }

    public SimpleProtobufRequest(String str, Class<T> cls, Map<String, String> map, SimpleCallback<T> simpleCallback) {
        super(1, str, simpleCallback);
        ny.O000000o();
        ny.O000000o(this);
        if (this.cookieUtilService == null || localeService == null || globalConfigService == null || appVersionService == null) {
            throw new RuntimeException("调用方需要实现 globalShopBase 组件的 Service 包的所有接口。");
        }
        this.mCallback = simpleCallback;
        this.mClass = cls;
        this.mMap = map;
        this.mUrl = str;
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
        String deviceInfo = getDeviceInfo();
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

    public static String getDeviceInfo() {
        NetworkInfo activeNetworkInfo;
        if (appVersionService == null) {
            ny.O000000o();
            appVersionService = (AppVersionService) ny.O000000o(AppVersionService.class);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("version=");
        sb.append(appVersionService.O000000o());
        sb.append("&");
        sb.append("phone_model=");
        sb.append(Device.O00000oO);
        sb.append("&");
        sb.append("networkType=");
        ConnectivityManager connectivityManager = (ConnectivityManager) bym.f13411O000000o.getSystemService("connectivity");
        String str = "NO_NETWORK";
        if (!(connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null)) {
            str = activeNetworkInfo.getTypeName();
        }
        sb.append(str);
        sb.append("&");
        sb.append("appname=shop&");
        sb.append("android_sdk_version=");
        sb.append(Device.O0000o00);
        sb.append("&");
        sb.append("android_version=");
        sb.append(Device.O0000o0O);
        sb.append("&");
        double d = (double) Device.O00000Oo;
        double d2 = (double) Device.f5099O000000o;
        Double.isNaN(d);
        Double.isNaN(d2);
        double doubleValue = new BigDecimal(d / d2).setScale(2, 4).doubleValue();
        sb.append("ratio=");
        sb.append(doubleValue);
        sb.append("&");
        if (localeService == null) {
            ny.O000000o();
            localeService = (LocaleService) ny.O000000o(LocaleService.class);
        }
        if (!localeService.O000000o()) {
            if (TextUtils.isEmpty(byp.O000000o(bym.f13411O000000o))) {
                sb.append("DEVICEID=");
                sb.append(Device.O000O0OO);
                sb.append("&");
            } else {
                sb.append("DEVICEID=");
                sb.append(byp.O000000o(bym.f13411O000000o));
                sb.append("&");
            }
            sb.append("device_width=");
            sb.append(Device.f5099O000000o);
            sb.append("&");
            sb.append("device_height=");
            sb.append(Device.O00000Oo);
            sb.append("&");
        } else {
            sb.append("DEVICEID=");
            sb.append(byp.O00000Oo(bym.f13411O000000o));
            sb.append("&");
        }
        if (globalConfigService == null) {
            ny.O000000o();
            globalConfigService = (GlobalConfigService) ny.O000000o(GlobalConfigService.class);
        }
        if (!TextUtils.isEmpty(globalConfigService.O000000o())) {
            sb.append("request_from=");
            sb.append(globalConfigService.O000000o());
            sb.append("&");
        }
        return sb.toString();
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
                return Response.success((byn) this.mClass.getMethod("decode", byte[].class).invoke(null, bArr), HttpHeaderParser.parseCacheHeaders(networkResponse));
            }
            return Response.error(new ParseError(new Exception("Protobuf Format Incorrect!" + this.mUrl)));
        } catch (Exception e) {
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
