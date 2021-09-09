package _m_j;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.accountsdk.account.URLs;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.accountsdk.account.data.MetaLoginData;
import com.xiaomi.accountsdk.account.data.PassTokenLoginParams;
import com.xiaomi.accountsdk.account.data.PassportInfo;
import com.xiaomi.accountsdk.account.data.PasswordLoginParams;
import com.xiaomi.accountsdk.account.data.Step2LoginParams;
import com.xiaomi.accountsdk.account.exception.IllegalDeviceException;
import com.xiaomi.accountsdk.account.exception.InvalidCredentialException;
import com.xiaomi.accountsdk.account.exception.InvalidUserNameException;
import com.xiaomi.accountsdk.account.exception.NeedCaptchaException;
import com.xiaomi.accountsdk.account.exception.NeedNotificationException;
import com.xiaomi.accountsdk.account.exception.NeedVerificationException;
import com.xiaomi.accountsdk.account.exception.PackageNameDeniedException;
import com.xiaomi.accountsdk.hasheddeviceidlib.HashedDeviceIdUtil;
import com.xiaomi.accountsdk.hasheddeviceidlib.UDevIdUtil;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.request.SecureRequestForAccount;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.request.log.HttpMethod;
import com.xiaomi.accountsdk.request.log.ProtocolLogHelper;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.EasyMap;
import com.xiaomi.accountsdk.utils.FidSigningUtil;
import com.xiaomi.accountsdk.utils.UserSpaceIdUtil;
import com.xiaomi.passport.PassportUserEnvironment;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;

public final class ekq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Integer f15583O000000o = 0;
    private static final String O00000Oo = (URLs.URL_ACCOUNT_API_V2_BASE + "/safe/user/isSetPassword");

    public static AccountInfo O000000o(String str, String str2, String str3) throws IOException, InvalidResponseException, NeedVerificationException, AuthenticationFailureException, NeedCaptchaException, InvalidCredentialException, AccessDeniedException, InvalidUserNameException, NeedNotificationException, IllegalDeviceException {
        return XMPassport.getStsUrlByPassword(str, str2, str3, O000000o(), null, null, O00000Oo());
    }

    public static AccountInfo O000000o(PasswordLoginParams passwordLoginParams) throws IOException, NeedCaptchaException, InvalidUserNameException, InvalidResponseException, AccessDeniedException, AuthenticationFailureException, InvalidCredentialException, NeedVerificationException, NeedNotificationException, IllegalDeviceException {
        if (passwordLoginParams != null) {
            PasswordLoginParams.Builder copyFrom = PasswordLoginParams.copyFrom(passwordLoginParams);
            if (TextUtils.isEmpty(passwordLoginParams.deviceId)) {
                copyFrom.setDeviceId(O000000o());
            }
            if (passwordLoginParams.hashedEnvFactors == null) {
                copyFrom.setHashedEnvFactors(O00000Oo());
            }
            return XMPassport.loginByPassword(copyFrom.build());
        }
        throw new IllegalArgumentException("password login params is null");
    }

    public static AccountInfo O000000o(Context context, PassTokenLoginParams passTokenLoginParams) throws InvalidResponseException, InvalidCredentialException, PackageNameDeniedException, IOException, AccessDeniedException, AuthenticationFailureException, InvalidUserNameException, IllegalDeviceException, NeedNotificationException {
        PassTokenLoginParams.Builder buildUpon = PassTokenLoginParams.buildUpon(passTokenLoginParams);
        if (TextUtils.isEmpty(passTokenLoginParams.deviceId)) {
            buildUpon.deviceId(O000000o());
        }
        if (TextUtils.isEmpty(passTokenLoginParams.uDevId)) {
            buildUpon.uDevId(O000000o(context, passTokenLoginParams.userId));
        }
        return XMPassport.loginByPassToken(buildUpon.build());
    }

    public static AccountInfo O000000o(Step2LoginParams step2LoginParams) throws IOException, AccessDeniedException, AuthenticationFailureException, InvalidCredentialException, InvalidResponseException, NeedVerificationException, InvalidUserNameException {
        return XMPassport.loginByStep2(step2LoginParams);
    }

    public static AccountInfo O000000o(String str, String str2, MetaLoginData metaLoginData, boolean z, String str3, String str4) throws IOException, AccessDeniedException, AuthenticationFailureException, InvalidCredentialException, InvalidResponseException, NeedVerificationException, InvalidUserNameException, IllegalDeviceException {
        return XMPassport.loginByStep2(str, str4, O000000o(), str2, metaLoginData, z, str3);
    }

    public static String O000000o() {
        return new HashedDeviceIdUtil(XMPassportSettings.getApplicationContext()).getHashedDeviceIdNoThrow();
    }

    public static Bundle O000000o(int i, AccountInfo accountInfo, boolean z) {
        Bundle O000000o2 = O000000o(accountInfo, z);
        if (i == 0) {
            O000000o2.putInt("errorCode", 4);
        }
        return O000000o2;
    }

    public static Bundle O000000o(AccountInfo accountInfo, boolean z) {
        Bundle bundle = new Bundle();
        if (accountInfo == null || accountInfo.userId == null) {
            bundle.putBoolean("booleanResult", false);
            return bundle;
        }
        bundle.putString("authAccount", accountInfo.userId);
        bundle.putString("accountType", "com.xiaomi");
        if (!TextUtils.isEmpty(accountInfo.encryptedUserId)) {
            bundle.putString("encrypted_user_id", accountInfo.encryptedUserId);
        }
        bundle.putBoolean("has_password", accountInfo.getHasPwd());
        if (!TextUtils.isEmpty(accountInfo.autoLoginUrl)) {
            bundle.putString("sts_url_result", accountInfo.autoLoginUrl);
            bundle.putString("sts_url", accountInfo.autoLoginUrl);
        }
        String serviceId = accountInfo.getServiceId();
        String serviceToken = accountInfo.getServiceToken();
        if (!TextUtils.isEmpty(serviceId) && !TextUtils.isEmpty(serviceToken)) {
            bundle.putString("authtoken", ExtendedAuthToken.build(serviceToken, accountInfo.getSecurity()).toPlain());
        }
        bundle.putBoolean("booleanResult", true);
        bundle.putBoolean("retry", z);
        return bundle;
    }

    public static boolean O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            URL url = new URL(str);
            URL url2 = new URL(XMPassport.ACCOUNT_DOMAIN);
            String protocol = url2.getProtocol();
            String protocol2 = url.getProtocol();
            String host = url2.getHost();
            String host2 = url.getHost();
            if (!protocol.equalsIgnoreCase(protocol2) || !host.equalsIgnoreCase(host2)) {
                return false;
            }
            return true;
        } catch (MalformedURLException unused) {
        }
    }

    private static String[] O00000Oo() {
        return PassportUserEnvironment.O000000o.O000000o().O000000o(XMPassportSettings.getApplicationContext());
    }

    private static URL O00000o0(String str) {
        try {
            return new URL(new URL(str).toString());
        } catch (MalformedURLException e) {
            AccountLog.w("AccountHelper", e);
            return null;
        }
    }

    public static boolean O00000Oo(String str) {
        if (!TextUtils.isEmpty(str)) {
            URL O00000o0 = O00000o0(str);
            if (O00000o0 != null && "https".equals(O00000o0.getProtocol()) && O00000o0.getUserInfo() == null && O00000o0.getHost().endsWith(".account.xiaomi.com")) {
                return true;
            }
        }
        return false;
    }

    public static boolean O000000o(PassportInfo passportInfo, String str, String str2, String str3) throws AccessDeniedException, AuthenticationFailureException, InvalidResponseException, CipherException, IOException {
        if (passportInfo != null) {
            String str4 = O00000Oo;
            EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPutOpt("sid", str).easyPut("transId", str3);
            EasyMap easyPutOpt = new EasyMap().easyPut("cUserId", passportInfo.getEncryptedUserId()).easyPut("serviceToken", passportInfo.getServiceToken()).easyPut("deviceId", str2).easyPutOpt("userSpaceId", UserSpaceIdUtil.getNullableUserSpaceIdCookie());
            ProtocolLogHelper.newRequestLog(str4, HttpMethod.GET, new String[]{"serviceToken"}).cookieWithMaskOrNull(easyPutOpt).paramWithMaskOrNull(easyPut).log();
            SimpleRequest.StringContent asString = SecureRequestForAccount.getAsString(str4, easyPut, easyPutOpt, true, passportInfo.getSecurity());
            ProtocolLogHelper.newResponseLog(str4).stringResponseOrNull(asString).log();
            if (asString != null) {
                String removeSafePrefixAndGetRealBody = XMPassport.removeSafePrefixAndGetRealBody(asString);
                try {
                    JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody);
                    int i = jSONObject.getInt("code");
                    if (i == 0) {
                        return jSONObject.getJSONObject("data").getBoolean("status");
                    }
                    throw new InvalidResponseException("code: " + i + "desc: " + jSONObject.optString("description"));
                } catch (JSONException unused) {
                    throw new InvalidResponseException("json error: ".concat(String.valueOf(removeSafePrefixAndGetRealBody)));
                }
            } else {
                throw new InvalidResponseException("http response result should not be null");
            }
        } else {
            throw new IllegalArgumentException("passport info should not be null");
        }
    }

    private static String O000000o(Context context, String str) {
        try {
            return UDevIdUtil.getUDevId(context, str);
        } catch (FidSigningUtil.FidSignException unused) {
            AccountLog.d("AccountHelper", " getUDevId   FidSignException ");
            return null;
        }
    }

    public static AccountInfo O000000o(String str, String str2, String str3, String str4) throws IOException, NeedCaptchaException, InvalidUserNameException, InvalidResponseException, AccessDeniedException, AuthenticationFailureException, InvalidCredentialException, NeedVerificationException, IllegalDeviceException {
        try {
            return XMPassport.loginByPassword(str, null, O000000o(), str2, str3, str4, null, false, O00000Oo());
        } catch (NeedNotificationException unused) {
            throw new InvalidResponseException("Unexpected NeedNotificationException");
        }
    }
}
