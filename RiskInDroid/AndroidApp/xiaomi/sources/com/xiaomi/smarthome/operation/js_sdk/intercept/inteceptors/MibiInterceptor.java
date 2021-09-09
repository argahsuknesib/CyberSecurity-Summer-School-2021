package com.xiaomi.smarthome.operation.js_sdk.intercept.inteceptors;

import _m_j.ftn;
import _m_j.gsy;
import _m_j.hkw;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.xiaomi.smarthome.WebViewRouterFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.util.Locale;
import org.json.JSONObject;

public class MibiInterceptor extends hkw {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f10516O000000o = null;
    private final Context O00000Oo;

    public MibiInterceptor(Context context) {
        this.O00000Oo = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x013c A[Catch:{ Exception -> 0x0146 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String jSONObject;
        ServerBean O0000ooO;
        try {
            Uri parse = Uri.parse(str);
            gsy.O000000o(3, "MibiInterceptor", "shouldOverrideUrlLoading:".concat(String.valueOf(str)));
            if (parse != null && parse.getHost() != null && parse.getHost().contains("mibi.mi.com") && !TextUtils.isEmpty(parse.getPath()) && parse.getPath().contains("pay")) {
                String queryParameter = parse.getQueryParameter("identifier");
                if (!TextUtils.isEmpty(queryParameter) && queryParameter.equals("mipay_sr62m5p7ds")) {
                    webView.stopLoading();
                    try {
                        String queryParameter2 = parse.getQueryParameter("pid");
                        String queryParameter3 = parse.getQueryParameter("xiaomiId");
                        boolean booleanQueryParameter = parse.getBooleanQueryParameter("autoRenew", false);
                        String queryParameter4 = parse.getQueryParameter("payExtraInfo");
                        String queryParameter5 = parse.getQueryParameter("did");
                        if (TextUtils.isEmpty(queryParameter5)) {
                            queryParameter5 = this.f10516O000000o;
                        }
                        if (TextUtils.isEmpty(queryParameter5)) {
                            gsy.O000000o(6, "MibiInterceptor", "processPayMibi: empty did: pay failed");
                            return false;
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("userId", queryParameter3);
                        jSONObject2.put("did", queryParameter5);
                        jSONObject2.put("pid", queryParameter2);
                        jSONObject2.put("autoRenew", booleanQueryParameter);
                        if (!TextUtils.isEmpty(queryParameter4)) {
                            jSONObject2.put("payExtraInfo", queryParameter4);
                        }
                        Locale O00000o = ftn.O00000o(this.O00000Oo);
                        if (O00000o != null) {
                            if (!TextUtils.isEmpty(O00000o.getCountry())) {
                                jSONObject2.put("region", O00000o.getCountry().toLowerCase());
                                if (CoreApi.O000000o().O0000O0o() && CoreApi.O000000o().O0000ooO() != null && (O0000ooO = CoreApi.O000000o().O0000ooO()) != null && !TextUtils.isEmpty(O0000ooO.O00000Oo) && O0000ooO.O00000Oo.equalsIgnoreCase("in")) {
                                    jSONObject2.put("region", "india");
                                }
                                jSONObject2.getString("region");
                                jSONObject = jSONObject2.toString();
                                if (!TextUtils.isEmpty(jSONObject)) {
                                    return true;
                                }
                                WebViewRouterFactory.getWebViewHelpManager().payWithMipayChinaMainland(this.O00000Oo, jSONObject, booleanQueryParameter);
                                return true;
                            }
                        }
                        Locale locale = Locale.getDefault();
                        if (locale != null && !TextUtils.isEmpty(locale.getCountry())) {
                            jSONObject2.put("region", locale.getCountry().toLowerCase());
                        }
                        jSONObject2.put("region", "india");
                        jSONObject2.getString("region");
                        jSONObject = jSONObject2.toString();
                        if (!TextUtils.isEmpty(jSONObject)) {
                        }
                    } catch (Exception e) {
                        gsy.O000000o(6, "MibiInterceptor", "processPayMibi: " + e.getLocalizedMessage());
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e2) {
            Log.e("MibiInterceptor", "processPayMibi: ", e2);
            return false;
        }
    }
}
