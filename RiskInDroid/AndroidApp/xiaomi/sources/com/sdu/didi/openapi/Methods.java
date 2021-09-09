package com.sdu.didi.openapi;

import _m_j.dat;
import _m_j.dau;
import _m_j.dav;
import _m_j.dbb;
import _m_j.dbh;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebView;
import com.sdu.didi.openapi.annotation.KeepClass;
import com.sdu.didi.openapi.location.Location;
import com.sdu.didi.openapi.location.LocationHelper;
import com.sdu.didi.openapi.ss.d;
import com.sdu.didi.openapi.utils.Utils;
import java.lang.ref.SoftReference;
import org.json.JSONException;
import org.json.JSONObject;

@KeepClass
public class Methods {
    private static Methods methods;
    private SoftReference<DiDiWebActivity> activitySoftReference;

    public Methods(DiDiWebActivity diDiWebActivity) {
        this.activitySoftReference = new SoftReference<>(diDiWebActivity);
    }

    public String getAppInfo(String str) {
        DiDiWebActivity diDiWebActivity = this.activitySoftReference.get();
        if (diDiWebActivity == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("weixin", Utils.O000000o(diDiWebActivity, "com.tencent.mm"));
            jSONObject.put("alipay", Utils.O000000o(diDiWebActivity, "com.eg.android.AlipayGphone"));
            jSONObject.put("didipasnger", Utils.O000000o(diDiWebActivity, "com.sdu.didi.psnger"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String getData(String str) {
        DiDiWebActivity diDiWebActivity = this.activitySoftReference.get();
        if (diDiWebActivity == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("key");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("key", optString);
            jSONObject2.put("data", dbb.O000000o(diDiWebActivity).O000000o(optString));
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public String getLocationInfo(String str) {
        DiDiWebActivity diDiWebActivity = this.activitySoftReference.get();
        if (diDiWebActivity == null) {
            return "";
        }
        Location location = LocationHelper.getInstance(diDiWebActivity).getLocation();
        if (!location.isAvail()) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lat", location.getLat());
            jSONObject.put("lng", location.getLng());
            jSONObject.put("maptype", location.getMapType());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return (!jSONObject.has("lat") || !jSONObject.has("lng")) ? "" : jSONObject.toString();
    }

    public String getSystemInfo(String str) {
        DiDiWebActivity diDiWebActivity = this.activitySoftReference.get();
        if (diDiWebActivity == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", Utils.O000000o(diDiWebActivity));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public String getUserInfo(String str) {
        return "success";
    }

    public String pageClose(String str) {
        DiDiWebActivity diDiWebActivity = this.activitySoftReference.get();
        if (diDiWebActivity == null) {
            return "";
        }
        diDiWebActivity.finish();
        return "success";
    }

    public String pageRefresh(String str) {
        DiDiWebActivity diDiWebActivity = this.activitySoftReference.get();
        if (diDiWebActivity == null) {
            return "";
        }
        final WebView webView = (WebView) diDiWebActivity.findViewById(new d(diDiWebActivity).O000000o("didi_webview"));
        if (Build.VERSION.SDK_INT > 10 && Build.VERSION.SDK_INT < 17) {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
        }
        diDiWebActivity.runOnUiThread(new Runnable() {
            /* class com.sdu.didi.openapi.Methods.AnonymousClass1 */

            public final void run() {
                WebView webView = webView;
                webView.loadUrl(webView.getUrl());
            }
        });
        return "success";
    }

    public String setData(String str) {
        DiDiWebActivity diDiWebActivity = this.activitySoftReference.get();
        if (diDiWebActivity == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            dbb.O000000o(diDiWebActivity).O000000o(jSONObject.optString("key"), jSONObject.optString("data"));
            return "success";
        } catch (Exception unused) {
            return "";
        }
    }

    public String setPassportToken(String str) {
        DiDiWebActivity diDiWebActivity = this.activitySoftReference.get();
        if (diDiWebActivity == null) {
            return "";
        }
        try {
            String optString = new JSONObject(str).optString("token", "");
            String O000000o2 = dat.O000000o().O000000o(diDiWebActivity);
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(O000000o2)) {
                dav.O000000o().O00000Oo(diDiWebActivity);
                return "success";
            }
            dav.O000000o().O000000o(diDiWebActivity, optString);
            return "success";
        } catch (JSONException e) {
            e.printStackTrace();
            dav.O000000o().O00000Oo(diDiWebActivity);
            return "success";
        }
    }

    public String getSign(String str) {
        DiDiWebActivity diDiWebActivity = this.activitySoftReference.get();
        if (diDiWebActivity == null) {
            return "";
        }
        try {
            String optString = new JSONObject(str).optString("package");
            if (TextUtils.isEmpty(optString)) {
                return optString;
            }
            String timestamp = Utils.getTimestamp();
            String randomString = Utils.getRandomString(10);
            String str2 = dau.O000000o().O000000o(diDiWebActivity).f14425O000000o;
            String secrectStr = DIOpenSDK.getSecrectStr(diDiWebActivity);
            DIOpenSDK instance = DIOpenSDK.getInstance();
            String sDKSign = instance.getSDKSign(str2 + secrectStr + optString + timestamp + randomString);
            if (TextUtils.isEmpty(sDKSign)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("openid", str2);
                jSONObject.put("timestamp", timestamp);
                jSONObject.put("noncestr", randomString);
                jSONObject.put("channel", dau.O000000o().O000000o(diDiWebActivity).O00000Oo);
                jSONObject.put("sign", sDKSign);
                jSONObject.put("version", Utils.getCurrentVersion());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (TextUtils.isEmpty(jSONObject.toString())) {
                return "";
            }
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String getEnvSign(String str) {
        DiDiWebActivity diDiWebActivity = this.activitySoftReference.get();
        if (diDiWebActivity == null) {
            return "";
        }
        try {
            String optString = new JSONObject(str).optString("package");
            if (TextUtils.isEmpty(optString)) {
                return optString;
            }
            String timestamp = Utils.getTimestamp();
            String randomString = Utils.getRandomString(10);
            String str2 = dau.O000000o().O000000o(diDiWebActivity).f14425O000000o;
            String secrectStr = DIOpenSDK.getSecrectStr(diDiWebActivity);
            DIOpenSDK instance = DIOpenSDK.getInstance();
            String sDKSign = instance.getSDKSign(str2 + secrectStr + optString + timestamp + randomString);
            if (!TextUtils.isEmpty(sDKSign) && !TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(secrectStr)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("openid", str2);
                    jSONObject.put("timestamp", timestamp);
                    jSONObject.put("noncestr", randomString);
                    jSONObject.put("channel", dau.O000000o().O000000o(diDiWebActivity).O00000Oo);
                    jSONObject.put("sign", sDKSign);
                    jSONObject.put("envdata", dbh.O000000o(diDiWebActivity).O00000Oo());
                    jSONObject.put("version", Utils.getCurrentVersion());
                    if (TextUtils.isEmpty(jSONObject.toString())) {
                        return "";
                    }
                    return jSONObject.toString();
                }
            }
            return "";
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
