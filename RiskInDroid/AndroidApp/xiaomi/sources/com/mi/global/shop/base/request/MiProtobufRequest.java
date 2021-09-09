package com.mi.global.shop.base.request;

import _m_j.bym;
import _m_j.ceq;
import _m_j.ny;
import android.webkit.CookieSyncManager;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.mi.global.shop.base.service.CookieUtilService;
import java.util.Map;

public class MiProtobufRequest extends ceq {
    private static final String TAG = "MiProtobufRequest";
    @Autowired
    CookieUtilService cookieUtilService;

    public MiProtobufRequest(int i, String str, Response.Listener<byte[]> listener, Response.ErrorListener errorListener) {
        this(i, str, null, listener, errorListener);
    }

    public MiProtobufRequest(int i, String str, String str2, Response.Listener<byte[]> listener, Response.ErrorListener errorListener) {
        super(i, str, str2, listener, errorListener);
        ny.O000000o();
        ny.O000000o(this);
        if (this.cookieUtilService == null) {
            throw new RuntimeException("调用方需要实现 globalShopBase 组件的 Service 包的所有接口。");
        }
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = super.getHeaders();
        headers.put("Mi-Info", SimpleProtobufRequest.getDeviceInfo());
        return headers;
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
}
