package com.mi.global.shop.base.request;

import _m_j.bym;
import _m_j.byt;
import _m_j.ccr;
import _m_j.ced;
import _m_j.ceo;
import _m_j.ny;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.mi.global.shop.base.service.CookieUtilService;
import com.mi.global.shop.base.service.LoginManagerService;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MiJsonObjectRequest extends ceo {
    public static final String TAG = "MiJsonObjectRequest";
    @Autowired
    CookieUtilService cookieUtilService;
    public Response.Listener<JSONObject> internalListener;
    @Autowired
    LoginManagerService loginManagerService;

    public MiJsonObjectRequest(int i, String str, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this(i, str, null, listener, errorListener);
        ny.O000000o();
        ny.O000000o(this);
    }

    public MiJsonObjectRequest(int i, String str, String str2, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(i, str, str2, listener, errorListener);
        ny.O000000o();
        ny.O000000o(this);
        if (this.cookieUtilService == null || this.loginManagerService == null) {
            throw new RuntimeException("调用方需要实现 globalShopBase 组件的 Service 包的所有接口。");
        }
        this.internalListener = this.mListener;
        if (this.mListener != null) {
            this.mListener = new Response.Listener<JSONObject>() {
                /* class com.mi.global.shop.base.request.MiJsonObjectRequest.AnonymousClass1 */

                public void onResponse(JSONObject jSONObject) {
                    try {
                        if (jSONObject.getInt("errno") == 20005) {
                            MiJsonObjectRequest.this.loginManagerService.O000000o();
                            String O00000Oo = MiJsonObjectRequest.this.loginManagerService.O00000Oo();
                            if (!TextUtils.isEmpty(O00000Oo)) {
                                ccr.O00000Oo(MiJsonObjectRequest.TAG, "new extended token plain:".concat(String.valueOf(O00000Oo)));
                                byt.O00000Oo.O000000o("pref_extended_token", O00000Oo);
                                byt.O00000Oo.O000000o("pref_last_refresh_serviceToken_time", Long.valueOf(System.currentTimeMillis()));
                                ced.f13683O000000o.add((MiJsonObjectRequest) MiJsonObjectRequest.this.clone());
                                return;
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (CloneNotSupportedException e2) {
                        e2.printStackTrace();
                    }
                    MiJsonObjectRequest.this.internalListener.onResponse(jSONObject);
                }
            };
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
