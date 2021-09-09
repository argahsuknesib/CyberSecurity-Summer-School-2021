package _m_j;

import _m_j.ejs;
import com.xiaomi.accountsdk.account.ServerError;
import com.xiaomi.accountsdk.account.URLs;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.data.MiuiActivatorInfo;
import com.xiaomi.accountsdk.account.data.PassportInfo;
import com.xiaomi.accountsdk.account.exception.InvalidCredentialException;
import com.xiaomi.accountsdk.account.exception.InvalidParameterException;
import com.xiaomi.accountsdk.account.exception.InvalidPhoneNumException;
import com.xiaomi.accountsdk.account.exception.InvalidVerifyCodeException;
import com.xiaomi.accountsdk.account.exception.NeedCaptchaException;
import com.xiaomi.accountsdk.account.exception.NeedVerificationException;
import com.xiaomi.accountsdk.account.exception.ReachLimitException;
import com.xiaomi.accountsdk.account.exception.UserRestrictedException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.request.SecureRequestForAccount;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.EasyMap;
import com.xiaomi.accountsdk.utils.XMPassportUtil;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public final class ejq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f15529O000000o = (URLs.URL_ACCOUNT_SAFE_API_BASE + "/user/modifySafePhone");
    private static final String O00000Oo = (URLs.URL_ACCOUNT_SAFE_API_BASE + "/user/sendModifySafePhoneTicket");
    private static final String O00000o = (URLs.URL_ACCOUNT_SAFE_API_BASE + "/user/native/changePassword");
    private static final String O00000o0 = (URLs.URL_ACCOUNT_SAFE_API_BASE + "/user/getUserBindIdAndLimit");

    public static void O000000o(PassportInfo passportInfo, String str, String str2, MiuiActivatorInfo miuiActivatorInfo, boolean z, String str3, String str4) throws AccessDeniedException, AuthenticationFailureException, InvalidResponseException, CipherException, IOException, InvalidVerifyCodeException, UserRestrictedException, InvalidPhoneNumException, NeedVerificationException {
        if (passportInfo == null) {
            AccountLog.i("CloudHelper", "passport info should be not null");
            return;
        }
        EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("phone", str).easyPutOpt("ticket", str2).easyPutOpt("sid", str4).easyPut("replace", String.valueOf(z)).easyPut("authST", str3).easyPut("transId", UUID.randomUUID().toString().substring(0, 15));
        if (miuiActivatorInfo != null) {
            easyPut.easyPutOpt("simId", miuiActivatorInfo.simId).easyPutOpt("vKey2", miuiActivatorInfo.vKey2).easyPutOpt("nonce", miuiActivatorInfo.vKey2Nonce);
        }
        SimpleRequest.MapContent postAsMap = SecureRequestForAccount.postAsMap(f15529O000000o, easyPut, O000000o(passportInfo), true, passportInfo.getSecurity());
        if (postAsMap != null) {
            Object fromBody = postAsMap.getFromBody("code");
            Object fromBody2 = postAsMap.getFromBody("description");
            ServerError serverError = new ServerError(postAsMap);
            String str5 = "code: " + fromBody + "; description: " + fromBody2;
            AccountLog.d("CloudHelper", "modifySafePhone: ".concat(String.valueOf(str5)));
            if (fromBody instanceof Integer) {
                int intValue = ((Integer) fromBody).intValue();
                if (intValue == 0) {
                    return;
                }
                if (intValue == 20023) {
                    throw new UserRestrictedException();
                } else if (intValue == 70008) {
                    throw new InvalidPhoneNumException(str5);
                } else if (intValue == 70012) {
                    throw new NeedVerificationException(null);
                } else if (intValue == 70014) {
                    throw new InvalidVerifyCodeException(str5);
                }
            }
            throw new InvalidResponseException(serverError);
        }
        throw new InvalidResponseException("failed to modifySafePhone");
    }

    public static String O000000o(PassportInfo passportInfo, String str, String str2, String str3, String str4) throws AccessDeniedException, AuthenticationFailureException, InvalidResponseException, CipherException, IOException, InvalidCredentialException, InvalidParameterException {
        if (passportInfo != null) {
            SimpleRequest.StringContent postAsString = SecureRequestForAccount.postAsString(O00000o, new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("pwd", str2).easyPut("passToken", str).easyPutOpt("sid", str4).easyPut("authST", str3).easyPut("traceId", UUID.randomUUID().toString().substring(0, 15)).easyPut("_json", "true"), O000000o(passportInfo), true, passportInfo.getSecurity());
            if (postAsString != null) {
                String removeSafePrefixAndGetRealBody = XMPassport.removeSafePrefixAndGetRealBody(postAsString);
                try {
                    JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody);
                    int i = jSONObject.getInt("code");
                    String str5 = "code: " + i + ", desc: " + jSONObject.optString("description");
                    ServerError serverError = new ServerError(jSONObject);
                    AccountLog.d("CloudHelper", "changePassword: ".concat(String.valueOf(str5)));
                    if (i == 0) {
                        return jSONObject.getJSONObject("data").getString("passToken");
                    }
                    if (i == 21317) {
                        throw new InvalidCredentialException(i, str5, false);
                    } else if (i == 70003) {
                        throw new InvalidParameterException(i, str5);
                    } else if (i != 85110) {
                        throw new InvalidResponseException(serverError);
                    } else {
                        throw new InvalidParameterException(i, str5);
                    }
                } catch (JSONException unused) {
                    throw new InvalidResponseException("result not json: ".concat(String.valueOf(removeSafePrefixAndGetRealBody)));
                }
            } else {
                throw new InvalidResponseException("result content is null");
            }
        } else {
            AccountLog.i("CloudHelper", "passport info should be not null");
            throw new AuthenticationFailureException("passport info is null");
        }
    }

    public static void O00000Oo(PassportInfo passportInfo, String str, String str2, String str3, String str4) throws AccessDeniedException, AuthenticationFailureException, InvalidResponseException, CipherException, IOException, ReachLimitException, NeedCaptchaException, InvalidPhoneNumException {
        if (passportInfo == null) {
            AccountLog.i("CloudHelper", "passport info should be not null");
            return;
        }
        EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("phone", str).easyPutOpt("sid", str4).easyPutOpt("icode", str2).easyPut("transId", UUID.randomUUID().toString().substring(0, 15));
        easyPut.putAll(XMPassportUtil.getDefaultLocaleParam());
        EasyMap<String, String> O000000o2 = O000000o(passportInfo);
        O000000o2.easyPutOpt("ick", str3);
        SimpleRequest.MapContent postAsMap = SecureRequestForAccount.postAsMap(O00000Oo, easyPut, O000000o2, true, passportInfo.getSecurity());
        if (postAsMap != null) {
            int intValue = ((Integer) postAsMap.getFromBody("code")).intValue();
            String str5 = (String) postAsMap.getFromBody("description");
            String str6 = "code: " + intValue + "; description: " + str5;
            ServerError serverError = new ServerError(postAsMap);
            AccountLog.d("CloudHelper", "send modify ticket: ".concat(String.valueOf(str6)));
            if (intValue != 0) {
                if (intValue != 20031) {
                    if (intValue == 70008) {
                        throw new InvalidPhoneNumException(str6);
                    } else if (intValue == 70022) {
                        throw new ReachLimitException(str6);
                    } else if (intValue != 87001) {
                        throw new InvalidResponseException(serverError);
                    }
                }
                throw new NeedCaptchaException(intValue, str5, URLs.ACCOUNT_DOMAIN + ((String) postAsMap.getFromBody("info")));
            }
            return;
        }
        throw new InvalidResponseException("failed to send ticket");
    }

    private static EasyMap<String, String> O000000o(PassportInfo passportInfo) {
        if (passportInfo != null) {
            return new EasyMap().easyPut("serviceToken", passportInfo.getServiceToken()).easyPut("cUserId", passportInfo.getEncryptedUserId());
        }
        throw new IllegalArgumentException("passportInfo is null");
    }

    static ejs.O00000o0 O000000o(PassportInfo passportInfo, String str) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidPhoneNumException {
        return O000000o(passportInfo, str, O00000o0);
    }

    private static ejs.O00000o0 O000000o(PassportInfo passportInfo, String str, String str2) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidPhoneNumException {
        if (passportInfo != null) {
            SimpleRequest.MapContent asMap = SecureRequestForAccount.getAsMap(str2, new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("type", "PH").easyPut("externalId", str), O000000o(passportInfo), true, passportInfo.getSecurity());
            if (asMap != null) {
                int intValue = ((Integer) asMap.getFromBody("code")).intValue();
                String str3 = (String) asMap.getFromBody("description");
                ServerError serverError = new ServerError(asMap);
                if (intValue == 0) {
                    Object fromBody = asMap.getFromBody("data");
                    if (fromBody instanceof Map) {
                        Map map = (Map) fromBody;
                        int i = 0;
                        long j = 0;
                        try {
                            if (map.containsKey("times")) {
                                i = Integer.parseInt(String.valueOf(map.get("times")));
                            }
                            String obj = map.containsKey("userId") ? map.get("userId").toString() : "";
                            if (map.containsKey("ts")) {
                                j = Long.parseLong(String.valueOf(map.get("ts")));
                            }
                            return new ejs.O00000o0(obj, j, i);
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                } else if (intValue != 70008) {
                    throw new InvalidResponseException(serverError);
                }
                throw new InvalidPhoneNumException(str3);
            }
            throw new IOException("failed to getUserBindIdAndLimit");
        }
        throw new IllegalArgumentException("passportInfo is null");
    }
}
