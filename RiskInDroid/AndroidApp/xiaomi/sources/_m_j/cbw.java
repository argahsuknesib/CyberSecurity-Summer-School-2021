package _m_j;

import _m_j.caw;
import _m_j.cbm;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.mi.util.Device;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cbw {
    public static void O000000o() {
        String str;
        try {
            CookieManager instance = CookieManager.getInstance();
            instance.setCookie(cav.O0000oO, "ISAPP=1; domain=" + cav.O0000oO);
            instance.setCookie(cav.O0000oO, "APPVERSION=" + Device.O0000oO0 + "; domain=" + cav.O0000oO);
            if (TextUtils.isEmpty(cbe.O000000o(byl.O00000oO()))) {
                str = "DEVICEID=" + Device.O000O0OO + "; domain=" + cav.O0000oO;
            } else {
                str = "DEVICEID=" + cbe.O000000o(byl.O00000oO()) + "; domain=" + cav.O0000oO;
            }
            instance.setCookie(cav.O0000oO, str);
            String str2 = "request_from=community_sdk; domain=" + cav.O0000oO;
            if (byl.O0000O0o != null) {
                if (byl.O0000O0o.O00000oo.equals("community_sdk")) {
                    str2 = "request_from=community_sdk; domain=" + cav.O0000oO;
                } else if (byl.O0000O0o.O00000oo.equals("mihome_sdk")) {
                    str2 = "request_from=mihome_sdk; domain=" + cav.O0000oO;
                }
            }
            instance.setCookie(cav.O0000oO, str2);
            instance.setCookie(cav.O0000oO, "sdk_version=30502; domain=" + cav.O0000oO);
            CookieSyncManager.getInstance().sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String O000000o(String str, String str2) {
        if (Build.VERSION.SDK_INT < 21 && byl.O00000oo() != null) {
            CookieSyncManager.createInstance(byl.O00000oO());
        }
        ccr.O00000Oo("WebViewCookieManager", "get Cookie key:" + str2 + " from:" + str);
        String cookie = CookieManager.getInstance().getCookie(str);
        if (cookie == null) {
            return "";
        }
        for (String split : cookie.split(";")) {
            String[] split2 = split.split("=");
            if (split2.length == 2 && split2[0].trim().equals(str2)) {
                return split2[1];
            }
        }
        ccr.O00000Oo("WebViewCookieManager", "get Cookie val:" + "" + " from:" + str);
        if (Build.VERSION.SDK_INT < 21) {
            CookieSyncManager.getInstance().sync();
        }
        return "";
    }

    public static void O000000o(Context context) {
        ccr.O00000Oo("WebViewCookieManager", "remove login cookie in:" + context.toString());
        O00000Oo(context, "userId");
        O00000Oo(context, "serviceToken");
        O00000Oo(context, "xm_user_in_num");
        O00000Oo(context, "cUserId");
        O00000Oo(context, "mUserId");
    }

    private static void O00000Oo(Context context, String str) {
        O000000o(context, str, caw.O00000Oo.f13572O000000o, "/");
        O000000o(context, str, caw.O00000Oo.f13572O000000o, cav.O0000oOo);
    }

    public static String O000000o(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("=");
        sb.append(str2);
        sb.append(";domain=");
        sb.append(str3);
        sb.append(";path=");
        sb.append(str4);
        if (str5 != null) {
            sb.append(";expires=");
            sb.append(str5);
        } else {
            sb.append(";");
        }
        return sb.toString();
    }

    public static void O000000o(Context context, String str, String str2, String str3, String str4) {
        CookieSyncManager.createInstance(context);
        CookieManager instance = CookieManager.getInstance();
        if (instance != null) {
            String O000000o2 = O000000o(str, str2, str3, str4, (String) null);
            instance.setCookie(str3, O000000o2);
            ccr.O00000Oo("WebViewCookieManager", "set Cookie: ".concat(String.valueOf(O000000o2)));
            CookieSyncManager.getInstance().sync();
        }
    }

    private static void O000000o(Context context, String str, String str2, String str3) {
        ccr.O00000Oo("WebViewCookieManager", "remove Cookie: " + str2 + ": " + str + "; path is : " + str3);
        CookieManager instance = CookieManager.getInstance();
        CookieSyncManager.createInstance(context);
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str3);
        String cookie = instance.getCookie(sb.toString());
        ccr.O00000Oo("WebViewCookieManager", "Get from Domain:" + str2 + str3 + " result is:" + cookie);
        if (cookie == null) {
            ccr.O00000Oo("WebViewCookieManager", "no cookie in domain " + str2 + str3);
            return;
        }
        String[] split = cookie.split(";");
        int length = split.length;
        int i = 0;
        while (i < length) {
            String[] split2 = split[i].split("=");
            if (split2.length < 2 || !TextUtils.equals(split2[0].trim(), str)) {
                i++;
            } else {
                instance.setCookie(str2, O000000o(str, "", str2, str3, new Date(1).toGMTString()));
                ccr.O00000Oo("WebViewCookieManager", "remove succeed");
                instance.removeExpiredCookie();
                CookieSyncManager.getInstance().sync();
                return;
            }
        }
        ccr.O00000Oo("WebViewCookieManager", "cookie name not found");
    }

    public static void O00000Oo(Context context) {
        String O00000Oo = cbm.O00000o0.O00000Oo(context, "pref_key_custom_cookies", (String) null);
        if (O00000Oo != null && !O00000Oo.equals("")) {
            cbm.O00000o0.O00000Oo(context, "pref_key_custom_cookies");
            O00000o0(context, O00000Oo);
        }
    }

    public static void O00000o0(Context context) {
        String O00000Oo = cbm.O00000o0.O00000Oo(context, "pref_key_custom_cookies", (String) null);
        if (O00000Oo != null && !O00000Oo.equals("")) {
            O000000o(context, O00000Oo);
        }
    }

    public static void O000000o(Context context, String str) {
        if (context != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("key");
                    String optString2 = optJSONObject.optString("value");
                    String optString3 = optJSONObject.optString("domain");
                    String optString4 = optJSONObject.optString("path");
                    if (!(optString == null || optString2 == null || optString3 == null || optString4 == null)) {
                        O000000o(context, optString, optString2, optString3, optString4);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static void O00000o0(Context context, String str) {
        if (context != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("key");
                    String optString2 = optJSONObject.optString("value");
                    String optString3 = optJSONObject.optString("domain");
                    String optString4 = optJSONObject.optString("path");
                    if (!(optString == null || optString2 == null || optString3 == null || optString4 == null)) {
                        O000000o(context, optString, optString3, optString4);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void O00000o(Context context) {
        String str;
        ccn O0000o00 = ccn.O0000o00();
        if (O0000o00.O0000o0O()) {
            String O00000Oo = O0000o00.O00000Oo();
            caw.O000000o.O00000oO();
            ExtendedAuthToken O000000o2 = O0000o00.O000000o(caw.O000000o.O00000o0());
            if (O000000o2 == null) {
                str = null;
            } else {
                str = O000000o2.authToken;
            }
            O000000o(context, O00000Oo, str);
        }
    }

    public static void O000000o(Context context, String str, String str2) {
        ccn O0000o00 = ccn.O0000o00();
        if (O0000o00.O0000o0O()) {
            ccr.O00000Oo("WebViewCookieManager", "set login cookie>>>");
            O000000o(context, "mUserId", cei.O000000o(str), caw.O00000Oo.f13572O000000o, "/");
            String O000000o2 = cei.O000000o(str);
            String str3 = caw.O00000Oo.f13572O000000o;
            O000000o(context, "mUserId", O000000o2, str3, "/" + cav.O0000oo0);
            O000000o(context, "cUserId", cei.O00000Oo(str), caw.O00000Oo.f13572O000000o, "/");
            String O00000Oo = cei.O00000Oo(str);
            String str4 = caw.O00000Oo.f13572O000000o;
            O000000o(context, "cUserId", O00000Oo, str4, "/" + cav.O0000oo0);
            ccr.O00000Oo("WebViewCookieManager", "set uid:" + O0000o00.O00000Oo());
            if (!TextUtils.isEmpty(str2)) {
                String str5 = caw.O00000Oo.f13572O000000o;
                O000000o(context, "serviceToken", str2, str5, "/" + cav.O0000oo0);
                ccr.O00000Oo("WebViewCookieManager", "set serviceToken:".concat(String.valueOf(str2)));
            }
            String O0000oo = ccn.O0000o00().O0000oo();
            if (!TextUtils.isEmpty(O0000oo)) {
                O000000o(context, "serviceToken", O0000oo, "sg.support.kefu.mi.com", "/");
            }
            String O0000o = ccn.O0000o00().O0000o();
            if (!TextUtils.isEmpty(O0000o)) {
                O000000o(context, "serviceToken", O0000o, cav.O000O0o0, "/");
            }
            String O0000oO0 = ccn.O0000o00().O0000oO0();
            if (!TextUtils.isEmpty(O0000oO0)) {
                O000000o(context, "cashpay_wap_id_slh", O0000oO0, cav.O000O0o0, "/");
            }
            String O0000oO = ccn.O0000o00().O0000oO();
            if (!TextUtils.isEmpty(O0000oO)) {
                O000000o(context, "cashpay_wap_id_ph", O0000oO, cav.O000O0o0, "/");
            }
            String O0000oOO = ccn.O0000o00().O0000oOO();
            if (!TextUtils.isEmpty(O0000oOO)) {
                O000000o(context, "cUserId", O0000oOO, cav.O000O0o0, "/");
            }
            String format = String.format("XM_%1$s_UN", cei.O00000Oo(str));
            String str6 = null;
            try {
                String O0000oo0 = O0000o00.O0000oo0();
                if (O0000oo0 == null) {
                    O0000oo0 = "";
                }
                str6 = URLEncoder.encode(O0000oo0, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                ccr.O000000o(e.getMessage());
            }
            if (!TextUtils.isEmpty(str6)) {
                O000000o(context, format, str6, caw.O00000Oo.f13572O000000o, "/");
                ccr.O00000Oo("WebViewCookieManager", "set username:".concat(String.valueOf(str6)));
            }
            ccr.O00000Oo("WebViewCookieManager", "set login cookie<<<");
        }
    }
}
