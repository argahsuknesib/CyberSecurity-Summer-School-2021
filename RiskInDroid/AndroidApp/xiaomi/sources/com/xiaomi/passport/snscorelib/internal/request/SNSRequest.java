package com.xiaomi.passport.snscorelib.internal.request;

import _m_j.efl;
import _m_j.efm;
import android.text.TextUtils;
import com.xiaomi.accountsdk.account.ServerError;
import com.xiaomi.accountsdk.account.URLs;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.exception.NeedNotificationException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.request.SimpleRequestForAccount;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.EasyMap;
import com.xiaomi.passport.snscorelib.internal.entity.SNSBindParameter;
import com.xiaomi.passport.snscorelib.internal.entity.SNSLoginParameter;
import com.xiaomi.passport.snscorelib.internal.entity.SNSTokenLoginResult;
import com.xiaomi.passport.snscorelib.internal.exception.SNSLoginException;
import java.io.IOException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class SNSRequest {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f6211O000000o = (URLs.URL_ACCOUNT_API_V2_BASE + "/safe/user/accessToken/full/delete");
    private static final String O00000Oo = (URLs.URL_ACCOUNT_BASE + "/sns/login/load");
    private static final String O00000o = (URLs.URL_ACCOUNT_BASE + "/sns/bind/bindSns");
    private static final String O00000o0 = (URLs.URL_ACCOUNT_BASE + "/sns/login/load/token");
    private static final String O00000oO = (URLs.URL_ACCOUNT_BASE + "/sns/token/bind/try");

    public static class BindLimitException extends Exception {
    }

    public static AccountInfo O000000o(SNSLoginParameter sNSLoginParameter) throws AccessDeniedException, AuthenticationFailureException, IOException, InvalidResponseException, SNSLoginException, NeedNotificationException, NeedLoginForBindException, BindLimitException, RedirectToWebLoginException {
        String O00000o02 = O00000o0(sNSLoginParameter);
        StringBuilder sb = new StringBuilder();
        sb.append(O00000o02);
        sb.append("&");
        sb.append("_auto=" + String.valueOf(sNSLoginParameter.O0000Oo0));
        if (!TextUtils.isEmpty(sNSLoginParameter.O0000Oo)) {
            sb.append("&");
            sb.append("_phones=" + String.valueOf(URLEncoder.encode(sNSLoginParameter.O0000Oo)));
        }
        sb.append("&");
        sb.append("_snsQuickLogin=" + String.valueOf(sNSLoginParameter.O0000OoO));
        String sb2 = sb.toString();
        String property = System.getProperty("http.agent");
        EasyMap easyMap = new EasyMap();
        return O000000o(SimpleRequestForAccount.getAsString(sb2, null, easyMap.easyPut("User-Agent", property + " AndroidSnsSDK/3.2.4 " + sNSLoginParameter.O0000o0), null, true).getBody());
    }

    public static AccountInfo O00000Oo(SNSLoginParameter sNSLoginParameter) throws AccessDeniedException, AuthenticationFailureException, IOException, InvalidResponseException, SNSLoginException, NeedNotificationException, NeedLoginForBindException, BindLimitException, RedirectToWebLoginException {
        EasyMap easyPutOpt = new EasyMap().easyPutOpt("enToken", sNSLoginParameter.O00000oO).easyPutOpt("token", sNSLoginParameter.O00000oo).easyPutOpt("expires_in", !TextUtils.isEmpty(sNSLoginParameter.O0000O0o) ? sNSLoginParameter.O0000O0o : "-1").easyPutOpt("openId", sNSLoginParameter.O0000OOo);
        if (!TextUtils.isEmpty(sNSLoginParameter.O0000Oo)) {
            easyPutOpt.easyPutOpt("_phones", sNSLoginParameter.O0000Oo);
        }
        easyPutOpt.easyPut("_auto", String.valueOf(sNSLoginParameter.O0000Oo0)).easyPut("_snsQuickLogin", String.valueOf(sNSLoginParameter.O0000OoO)).easyPut("_json", "true");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sid", sNSLoginParameter.O00000Oo);
            jSONObject.put("callback", URLEncoder.encode(sNSLoginParameter.O00000o0 == null ? "" : sNSLoginParameter.O00000o0, "UTF-8"));
            jSONObject.put("appid", sNSLoginParameter.O00000o);
            jSONObject.put("locale", efm.O000000o());
            jSONObject.put("region", sNSLoginParameter.O0000Ooo);
            easyPutOpt.easyPutOpt("state", efl.O000000o(jSONObject.toString().getBytes()));
            easyPutOpt.easyPutOpt("t", sNSLoginParameter.O0000o00);
            String property = System.getProperty("http.agent");
            EasyMap easyMap = new EasyMap();
            SimpleRequest.StringContent asString = SimpleRequestForAccount.getAsString(O00000o0, easyPutOpt, easyMap.easyPut("User-Agent", property + " AndroidSnsSDK/3.2.4 " + sNSLoginParameter.O0000o0), null, true);
            if (asString != null) {
                return O000000o(asString.getBody());
            }
            throw new SNSLoginException(3, "failed to snsLoginByAccessToken : stringContent is null");
        } catch (JSONException e) {
            e.printStackTrace();
            AccountLog.e("SNSRequest", "snsLoginByAccessToken :invalid state params", e);
            throw new SNSLoginException(3, "snsLoginByAccessToken :invalid state params:" + e.toString());
        }
    }

    private static AccountInfo O000000o(String str) throws NeedNotificationException, NeedLoginForBindException, SNSLoginException, BindLimitException, RedirectToWebLoginException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("code");
            String optString = jSONObject.optString("description");
            ServerError serverError = new ServerError(jSONObject);
            if (optInt == 0) {
                SNSTokenLoginResult.O000000o o000000o = new SNSTokenLoginResult.O000000o();
                o000000o.f6210O000000o = jSONObject.optInt("Status");
                o000000o.O00000Oo = jSONObject.optString("Sid");
                o000000o.O00000o0 = jSONObject.optString("WebViewCallback");
                o000000o.O00000o = jSONObject.optString("Callback");
                o000000o.O00000oO = jSONObject.optString("NotificationUrl");
                o000000o.O00000oo = jSONObject.optString("userId");
                o000000o.O0000O0o = jSONObject.optString("passToken");
                o000000o.O0000OOo = jSONObject.optString("snsBindTryUrl");
                o000000o.O0000Oo0 = jSONObject.optString("sns_token_ph");
                o000000o.O0000Oo = jSONObject.optString("openId");
                o000000o.O0000OoO = jSONObject.optString("snsLoginUrl");
                o000000o.O0000Ooo = jSONObject.optBoolean("bindLimit");
                SNSTokenLoginResult sNSTokenLoginResult = new SNSTokenLoginResult(o000000o, (byte) 0);
                int i = sNSTokenLoginResult.f6209O000000o;
                if (i == 0) {
                    String str2 = sNSTokenLoginResult.O00000oO;
                    String str3 = sNSTokenLoginResult.O00000Oo;
                    if (TextUtils.isEmpty(str2)) {
                        return new AccountInfo.Builder().userId(sNSTokenLoginResult.O00000oo).passToken(sNSTokenLoginResult.O0000O0o).build();
                    }
                    throw new NeedNotificationException(str3, str2);
                } else if (i == 1) {
                    String str4 = sNSTokenLoginResult.O0000OoO;
                    boolean z = sNSTokenLoginResult.O0000Ooo;
                    String str5 = sNSTokenLoginResult.O0000OOo;
                    String str6 = sNSTokenLoginResult.O0000Oo0;
                    String str7 = sNSTokenLoginResult.O0000Oo;
                    String str8 = sNSTokenLoginResult.O00000Oo;
                    if (z) {
                        throw new BindLimitException();
                    } else if (!TextUtils.isEmpty(str4)) {
                        SNSBindParameter.O000000o o000000o2 = new SNSBindParameter.O000000o();
                        o000000o2.O00000o0 = str4;
                        o000000o2.f6206O000000o = str6;
                        o000000o2.O00000Oo = str7;
                        o000000o2.O00000o = str8;
                        throw new RedirectToWebLoginException(o000000o2.O000000o());
                    } else {
                        SNSBindParameter.O000000o o000000o3 = new SNSBindParameter.O000000o();
                        o000000o3.O00000o0 = str5;
                        o000000o3.f6206O000000o = str6;
                        o000000o3.O00000Oo = str7;
                        o000000o3.O00000o = str8;
                        throw new NeedLoginForBindException(o000000o3.O000000o());
                    }
                } else {
                    throw new IllegalStateException("unknown error:status=".concat(String.valueOf(i)));
                }
            } else {
                AccountLog.w("SNSRequest", "getAccountInfo :code=" + optInt + ";message = " + optString);
                throw new SNSLoginException(optInt, optString, serverError);
            }
        } catch (JSONException e) {
            AccountLog.e("SNSRequest", "getAccountInfo:fail to parse JSONObject ".concat(String.valueOf(str)), e);
            throw new SNSLoginException(3, "getAccountInfo:fail to parse JSONObject: ".concat(String.valueOf(str)));
        }
    }

    public static SNSBindParameter O000000o(SNSLoginParameter sNSLoginParameter, AccountInfo accountInfo) throws AccessDeniedException, AuthenticationFailureException, IOException, InvalidResponseException, SNSLoginException {
        EasyMap easyPut = new EasyMap().easyPut("passToken", accountInfo.passToken).easyPut("userId", accountInfo.userId);
        EasyMap easyPut2 = new EasyMap().easyPutOpt("code", sNSLoginParameter.f6207O000000o).easyPut("_json", "true").easyPut("userId", accountInfo.userId);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sid", sNSLoginParameter.O00000Oo);
            jSONObject.put("callback", URLEncoder.encode(sNSLoginParameter.O00000o0 == null ? "" : sNSLoginParameter.O00000o0, "UTF-8"));
            jSONObject.put("appid", sNSLoginParameter.O00000o);
            easyPut2.easyPutOpt("state", efl.O000000o(jSONObject.toString().getBytes()));
            easyPut2.easyPutOpt("t", sNSLoginParameter.O0000o00);
            String property = System.getProperty("http.agent");
            EasyMap easyMap = new EasyMap();
            SimpleRequest.StringContent asString = SimpleRequestForAccount.getAsString(O00000o, easyPut2, easyMap.easyPut("User-Agent", property + " AndroidSnsSDK/3.2.4 " + sNSLoginParameter.O0000o0), easyPut, true);
            if (asString != null) {
                return O00000Oo(asString.getBody());
            }
            throw new SNSLoginException(3, "failed to getSNSBindParameterByCode : stringContent is null");
        } catch (JSONException e) {
            e.printStackTrace();
            AccountLog.e("SNSRequest", "getSNSBindParameterByCode :invalid state params", e);
            throw new SNSLoginException(3, "getSNSBindParameterByCode:invalid state params:" + e.toString());
        }
    }

    public static SNSBindParameter O00000Oo(SNSLoginParameter sNSLoginParameter, AccountInfo accountInfo) throws AccessDeniedException, AuthenticationFailureException, IOException, InvalidResponseException, SNSLoginException {
        String str = !TextUtils.isEmpty(sNSLoginParameter.O0000O0o) ? sNSLoginParameter.O0000O0o : "-1";
        EasyMap easyPut = new EasyMap().easyPut("passToken", accountInfo.passToken).easyPut("userId", accountInfo.userId);
        EasyMap easyPut2 = new EasyMap().easyPutOpt("enToken", sNSLoginParameter.O00000oO).easyPutOpt("token", sNSLoginParameter.O00000oo).easyPutOpt("expires_in", str).easyPutOpt("openId", sNSLoginParameter.O0000OOo).easyPutOpt("userId", accountInfo.userId).easyPut("_json", "true");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sid", sNSLoginParameter.O00000Oo);
            jSONObject.put("callback", URLEncoder.encode(sNSLoginParameter.O00000o0 == null ? "" : sNSLoginParameter.O00000o0, "UTF-8"));
            jSONObject.put("appid", sNSLoginParameter.O00000o);
            easyPut2.easyPutOpt("state", efl.O000000o(jSONObject.toString().getBytes()));
            easyPut2.easyPutOpt("t", sNSLoginParameter.O0000o00);
            String property = System.getProperty("http.agent");
            EasyMap easyMap = new EasyMap();
            SimpleRequest.StringContent asString = SimpleRequestForAccount.getAsString(O00000oO, easyPut2, easyMap.easyPut("User-Agent", property + " AndroidSnsSDK/3.2.4 " + sNSLoginParameter.O0000o0), easyPut, true);
            if (asString != null) {
                return O00000Oo(asString.getBody());
            }
            throw new SNSLoginException(3, "failed to getSNSBindParameterByToken : stringContent is null");
        } catch (JSONException e) {
            e.printStackTrace();
            AccountLog.e("SNSRequest", "getSNSBindParameterByToken :invalid state params", e);
            throw new SNSLoginException(3, "getSNSBindParameterByToken :invalid state params:" + e.toString());
        }
    }

    private static SNSBindParameter O00000Oo(String str) throws SNSLoginException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("code");
            String optString = jSONObject.optString("description");
            ServerError serverError = new ServerError(jSONObject);
            if (optInt == 0) {
                SNSBindParameter.O000000o o000000o = new SNSBindParameter.O000000o();
                o000000o.O00000o0 = jSONObject.optString("snsBindTryUrl");
                o000000o.f6206O000000o = jSONObject.optString("sns_token_ph");
                o000000o.O00000Oo = jSONObject.optString("openId");
                return o000000o.O000000o();
            }
            AccountLog.w("SNSRequest", "getSNSBindParameter :code=" + optInt + ";message = " + optString);
            throw new SNSLoginException(optInt, optString, serverError);
        } catch (JSONException e) {
            AccountLog.e("SNSRequest", "getSNSBindParameter: fail to parse JSONObject ".concat(String.valueOf(str)), e);
            throw new SNSLoginException(3, "getSNSBindParameter: fail to parse JSONObject:" + e.toString());
        }
    }

    private static String O00000o0(SNSLoginParameter sNSLoginParameter) throws AccessDeniedException, AuthenticationFailureException, IOException, InvalidResponseException, SNSLoginException {
        EasyMap easyPut = new EasyMap().easyPutOpt("code", sNSLoginParameter.f6207O000000o).easyPut("_json", "true");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sid", sNSLoginParameter.O00000Oo);
            jSONObject.put("callback", URLEncoder.encode(sNSLoginParameter.O00000o0 == null ? "" : sNSLoginParameter.O00000o0, "UTF-8"));
            jSONObject.put("appid", sNSLoginParameter.O00000o);
            jSONObject.put("locale", efm.O000000o());
            jSONObject.put("region", sNSLoginParameter.O0000Ooo);
            easyPut.easyPutOpt("state", efl.O000000o(jSONObject.toString().getBytes()));
            easyPut.easyPutOpt("t", sNSLoginParameter.O0000o00);
            String property = System.getProperty("http.agent");
            EasyMap easyMap = new EasyMap();
            SimpleRequest.StringContent asString = SimpleRequestForAccount.getAsString(O00000Oo, easyPut, easyMap.easyPut("User-Agent", property + " AndroidSnsSDK/3.2.4 " + sNSLoginParameter.O0000o0), null, true);
            if (asString != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(asString.getBody());
                    int optInt = jSONObject2.optInt("code");
                    String optString = jSONObject2.optString("description");
                    ServerError serverError = new ServerError(jSONObject2);
                    if (optInt == 0) {
                        return jSONObject2.getJSONObject("data").optString("location");
                    }
                    AccountLog.w("SNSRequest", "getSNSTokenLoginUrl :code=" + optInt + ";message = " + optString);
                    throw new SNSLoginException(optInt, optString, serverError);
                } catch (JSONException e) {
                    AccountLog.e("SNSRequest", "getSNSTokenLoginUrl: fail to parse JSONObject " + asString.toString(), e);
                    throw new SNSLoginException(3, "getSNSTokenLoginUrl: fail to parse JSONObject:" + e.toString());
                }
            } else {
                throw new SNSLoginException(3, "failed to getSNSTokenLoginUrl : stringContent is null");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            AccountLog.e("SNSRequest", "getSNSTokenLoginUrl :invalid state params", e2);
            throw new SNSLoginException(3, "getSNSTokenLoginUrl:invalid state params:" + e2.toString());
        }
    }

    public static class NeedLoginForBindException extends Exception {
        private final SNSBindParameter mSNSBindParameter;

        public NeedLoginForBindException(SNSBindParameter sNSBindParameter) {
            this.mSNSBindParameter = sNSBindParameter;
        }

        public SNSBindParameter getSNSBindParameter() {
            return this.mSNSBindParameter;
        }
    }

    public static class RedirectToWebLoginException extends Exception {
        private final SNSBindParameter snsBindParameter;

        public RedirectToWebLoginException(SNSBindParameter sNSBindParameter) {
            this.snsBindParameter = sNSBindParameter;
        }

        public SNSBindParameter getSNSBindParameter() {
            return this.snsBindParameter;
        }
    }
}
