package com.xiaomi.accountsdk.account;

import _m_j.iak;
import _m_j.ial;
import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.xiaomi.account.exception.PassportCAException;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.ActivatorPhoneInfo;
import com.xiaomi.accountsdk.account.data.BindingType;
import com.xiaomi.accountsdk.account.data.CheckRegPhoneParams;
import com.xiaomi.accountsdk.account.data.DeviceModelInfo;
import com.xiaomi.accountsdk.account.data.EmailRegisterParams;
import com.xiaomi.accountsdk.account.data.Gender;
import com.xiaomi.accountsdk.account.data.IdentityAuthReason;
import com.xiaomi.accountsdk.account.data.MetaLoginData;
import com.xiaomi.accountsdk.account.data.MiCloudAuthInfo;
import com.xiaomi.accountsdk.account.data.MiuiActivatorInfo;
import com.xiaomi.accountsdk.account.data.OAuthParameter;
import com.xiaomi.accountsdk.account.data.PassTokenLoginParams;
import com.xiaomi.accountsdk.account.data.PassportInfo;
import com.xiaomi.accountsdk.account.data.PasswordLoginParams;
import com.xiaomi.accountsdk.account.data.PhoneTicketLoginParams;
import com.xiaomi.accountsdk.account.data.PhoneTokenRegisterParams;
import com.xiaomi.accountsdk.account.data.QRLoginUrlInfo;
import com.xiaomi.accountsdk.account.data.QueryPhoneInfoParams;
import com.xiaomi.accountsdk.account.data.RegisterUserInfo;
import com.xiaomi.accountsdk.account.data.SecurityQuestion;
import com.xiaomi.accountsdk.account.data.SendEmailActMsgParams;
import com.xiaomi.accountsdk.account.data.SendPhoneTicketParams;
import com.xiaomi.accountsdk.account.data.SetPasswordParams;
import com.xiaomi.accountsdk.account.data.Step2LoginParams;
import com.xiaomi.accountsdk.account.data.XiaomiUserCoreInfo;
import com.xiaomi.accountsdk.account.data.XiaomiUserInfo;
import com.xiaomi.accountsdk.account.data.XiaomiUserProfile;
import com.xiaomi.accountsdk.account.exception.DeleteSafeAddressException;
import com.xiaomi.accountsdk.account.exception.InvalidBindAddressException;
import com.xiaomi.accountsdk.account.exception.InvalidCredentialException;
import com.xiaomi.accountsdk.account.exception.InvalidParameterException;
import com.xiaomi.accountsdk.account.exception.InvalidPhoneNumException;
import com.xiaomi.accountsdk.account.exception.InvalidPhoneOrTicketException;
import com.xiaomi.accountsdk.account.exception.InvalidUserNameException;
import com.xiaomi.accountsdk.account.exception.InvalidVerifyCodeException;
import com.xiaomi.accountsdk.account.exception.NeedCaptchaException;
import com.xiaomi.accountsdk.account.exception.NeedNotificationException;
import com.xiaomi.accountsdk.account.exception.NeedOAuthorizeException;
import com.xiaomi.accountsdk.account.exception.NeedVerificationException;
import com.xiaomi.accountsdk.account.exception.PackageNameDeniedException;
import com.xiaomi.accountsdk.account.exception.PassportIOException;
import com.xiaomi.accountsdk.account.exception.ReachLimitException;
import com.xiaomi.accountsdk.account.exception.RegisteredPhoneException;
import com.xiaomi.accountsdk.account.exception.SendVerifyCodeExceedLimitException;
import com.xiaomi.accountsdk.account.exception.TokenExpiredException;
import com.xiaomi.accountsdk.account.exception.UsedEmailAddressException;
import com.xiaomi.accountsdk.account.exception.UserRestrictedException;
import com.xiaomi.accountsdk.hasheddeviceidlib.HashedDeviceIdUtil;
import com.xiaomi.accountsdk.hasheddeviceidlib.OAIDUtil;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.CipherException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.accountsdk.request.PassportLoginRequest;
import com.xiaomi.accountsdk.request.PassportRequestArguments;
import com.xiaomi.accountsdk.request.SecureRequestForAccount;
import com.xiaomi.accountsdk.request.SimpleRequest;
import com.xiaomi.accountsdk.request.SimpleRequestForAccount;
import com.xiaomi.accountsdk.request.UploadFileRequest;
import com.xiaomi.accountsdk.request.log.HttpMethod;
import com.xiaomi.accountsdk.request.log.ProtocolLogHelper;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.AssertionUtils;
import com.xiaomi.accountsdk.utils.CloudCoder;
import com.xiaomi.accountsdk.utils.EasyMap;
import com.xiaomi.accountsdk.utils.UserSpaceIdUtil;
import com.xiaomi.accountsdk.utils.XMPassportUtil;
import com.xiaomi.passport.SecurityDeviceSignManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class XMPassport {
    @Deprecated
    public static final String ACCOUNT_DOMAIN = URLs.ACCOUNT_DOMAIN;
    private static final Integer INT_0 = 0;
    private static final Integer TIMEOUT_LONG_POLLING = 300000;
    @Deprecated
    public static final String URL_ACCOUNT_API_V2_BASE = URLs.URL_ACCOUNT_API_V2_BASE;
    @Deprecated
    public static final String URL_ACCOUNT_API_V3_BASE = URLs.URL_ACCOUNT_API_V3_BASE;
    @Deprecated
    public static final String URL_ACCOUNT_BASE = URLs.URL_ACCOUNT_BASE;
    @Deprecated
    public static final String URL_ACCOUNT_SAFE_API_BASE = URLs.URL_ACCOUNT_SAFE_API_BASE;
    @Deprecated
    public static final String URL_ACOUNT_API_BASE = URLs.URL_ACOUNT_API_BASE;
    @Deprecated
    public static final String URL_ACOUNT_API_BASE_SECURE = URLs.URL_ACOUNT_API_BASE_SECURE;
    @Deprecated
    public static final String URL_ACOUNT_API_BASE_V2_SECURE = URLs.URL_ACOUNT_API_BASE_V2_SECURE;
    public static final boolean USE_PREVIEW = URLs.USE_PREVIEW;
    static boolean sDisableLoginFallbackForTest = false;

    enum CheckAvailibilityType {
        EMAIL,
        PHONE
    }

    public static AccountInfo loginByPassword(String str, String str2, String str3, String str4, String str5, String str6, MetaLoginData metaLoginData) throws InvalidResponseException, InvalidCredentialException, InvalidUserNameException, NeedVerificationException, NeedCaptchaException, IOException, AccessDeniedException, AuthenticationFailureException {
        try {
            return loginByPassword(str, str2, str3, str4, str5, str6, metaLoginData, false);
        } catch (NeedNotificationException unused) {
            throw new InvalidResponseException("Unexpected NeedNotificationException");
        }
    }

    public static AccountInfo loginByPassword(String str, String str2, String str3, String str4, String str5, String str6, MetaLoginData metaLoginData, boolean z) throws InvalidResponseException, InvalidCredentialException, InvalidUserNameException, NeedVerificationException, NeedCaptchaException, IOException, AccessDeniedException, AuthenticationFailureException, NeedNotificationException {
        return loginByPassword(str, str2, str3, str4, str5, str6, metaLoginData, z, null);
    }

    public static AccountInfo loginByPassword(String str, String str2, String str3, String str4, String str5, String str6, MetaLoginData metaLoginData, boolean z, String[] strArr) throws InvalidResponseException, InvalidCredentialException, InvalidUserNameException, NeedVerificationException, NeedCaptchaException, IOException, AccessDeniedException, AuthenticationFailureException, NeedNotificationException {
        try {
            return loginByPassword(str, str2, str3, str4, str5, str6, metaLoginData, z, strArr, PassportCATokenManager.getInstance(), false);
        } catch (PassportCAException unused) {
            throw new IllegalStateException("this should never happen in product environment.Have you set sDisableLoginFallbackForTest to be true? ");
        }
    }

    public static AccountInfo getStsUrlByPassword(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr) throws InvalidResponseException, InvalidCredentialException, InvalidUserNameException, NeedVerificationException, NeedCaptchaException, IOException, AccessDeniedException, AuthenticationFailureException, NeedNotificationException {
        try {
            return loginByPassword(str, str3, str4, str2, str5, str6, null, true, strArr, PassportCATokenManager.getInstance(), true);
        } catch (PassportCAException unused) {
            throw new IllegalStateException("this should never happen in product environment.Have you set sDisableLoginFallbackForTest to be true? ");
        }
    }

    @Deprecated
    public static AccountInfo confirmPassword(String str, String str2, String str3, String str4, String str5, String str6) throws InvalidResponseException, InvalidCredentialException, InvalidUserNameException, NeedVerificationException, NeedCaptchaException, IOException, AccessDeniedException, AuthenticationFailureException, NeedNotificationException {
        try {
            return loginByPassword(str, str3, str4, str2, str5, str6, null, false, null, PassportCATokenManager.getInstance(), true);
        } catch (PassportCAException unused) {
            throw new IllegalStateException("this should never happen in product environment.Have you set sDisableLoginFallbackForTest to be true? ");
        } catch (NeedNotificationException unused2) {
            throw new InvalidResponseException("Unexpected NeedNotificationException");
        }
    }

    static AccountInfo loginByPassword(String str, String str2, String str3, String str4, String str5, String str6, MetaLoginData metaLoginData, boolean z, String[] strArr, PassportCATokenManager passportCATokenManager, boolean z2) throws InvalidResponseException, InvalidCredentialException, InvalidUserNameException, NeedVerificationException, NeedCaptchaException, IOException, AccessDeniedException, AuthenticationFailureException, NeedNotificationException, PassportCAException {
        return loginByPassword(new PasswordLoginParams.Builder().setUserId(str).setPassword(str4).setDeviceId(str3).setCaptCode(str5).setCaptIck(str6).setServiceId(str2).setMetaLoginData(metaLoginData).setNeedProcessNotification(z).setIsReturnStsUrl(z2).setHashedEnvFactors(strArr).build());
    }

    public static AccountInfo loginByPassword(PasswordLoginParams passwordLoginParams) throws InvalidResponseException, InvalidCredentialException, InvalidUserNameException, NeedVerificationException, NeedCaptchaException, IOException, AccessDeniedException, AuthenticationFailureException, NeedNotificationException {
        if (passwordLoginParams == null || passwordLoginParams.password == null) {
            throw new IllegalArgumentException("password params should not be null");
        }
        String str = passwordLoginParams.userId;
        String str2 = passwordLoginParams.password;
        String str3 = passwordLoginParams.deviceId;
        String str4 = TextUtils.isEmpty(passwordLoginParams.serviceId) ? "passport" : passwordLoginParams.serviceId;
        String str5 = passwordLoginParams.captIck;
        String str6 = passwordLoginParams.captCode;
        boolean z = passwordLoginParams.returnStsUrl;
        boolean z2 = passwordLoginParams.needProcessNotification;
        MetaLoginData metaLoginData = passwordLoginParams.metaLoginData;
        ActivatorPhoneInfo activatorPhoneInfo = passwordLoginParams.activatorPhoneInfo;
        EasyMap easyPut = new EasyMap().easyPutOpt("user", str).easyPut("hash", CloudCoder.getMd5DigestUpperCase(str2)).easyPutOpt("sid", str4).easyPutOpt("captCode", str6).easyPutOpt("cc", passwordLoginParams.countryCode).easyPut("_json", "true");
        EasyMap easyPutOpt = new EasyMap().easyPutOpt("ick", str5).easyPutOpt("ticketToken", passwordLoginParams.ticketToken);
        addDeviceIdInCookies(easyPutOpt, str3);
        if (activatorPhoneInfo != null) {
            easyPut.easyPutOpt("userHash", activatorPhoneInfo.phoneHash);
            easyPutOpt.easyPutOpt("activatorToken", activatorPhoneInfo.activatorToken);
        }
        String str7 = URLs.URL_LOGIN_AUTH2_HTTPS;
        PassportRequestArguments passportRequestArguments = new PassportRequestArguments();
        passportRequestArguments.putAllParams(easyPut);
        passportRequestArguments.putAllCookies(easyPutOpt);
        passportRequestArguments.setUrl(str7);
        passportRequestArguments.setReadBody(true);
        PassportLoginRequest.ByPassword byPassword = new PassportLoginRequest.ByPassword(passportRequestArguments, str, str4, metaLoginData);
        try {
            ProtocolLogHelper.newRequestLog(str7, HttpMethod.POST, new String[]{"hash", "ticketToken", "userHash", "activatorToken"}).paramWithMaskOrNull(easyPut).cookieWithMaskOrNull(easyPutOpt).log();
            SimpleRequest.StringContent executeEx = byPassword.executeEx();
            logLoginResponseAllowNull(str7, executeEx);
            if (executeEx != null) {
                try {
                    return processLoginContent(executeEx, str4, z2, z);
                } catch (PackageNameDeniedException unused) {
                    throw new InvalidResponseException("It's not loginByPassToken(), PackageNameDeniedException is unexpected");
                }
            } else {
                throw new IOException("failed to get response from server");
            }
        } catch (PassportCAException unused2) {
            throw new IllegalStateException("this should never happen in product environment.Have you set sDisableLoginFallbackForTest to be true? ");
        }
    }

    public static String exchangePhoneTokenByTempPhoneToken(String str, String str2, String str3, String str4) throws AccessDeniedException, AuthenticationFailureException, IOException, InvalidResponseException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("invalid params");
        }
        EasyMap easyPutOpt = new EasyMap().easyPutOpt("tmpPhoneToken", str).easyPutOpt("devId", getHashedDeviceId()).easyPutOpt("simId", str2).easyPutOpt("iccId", str3).easyPutOpt("mccmnc", str4).easyPutOpt("_json", "true");
        String str5 = URLs.URL_EXCHANGE_PHONETOKE_HTTPS;
        try {
            ProtocolLogHelper.newRequestLog(str5, HttpMethod.POST, new String[]{"tmpPhoneToken", "simId", "iccId", "mccmnc"}).paramWithMaskOrNull(easyPutOpt).log();
            SimpleRequest.StringContent postAsString = SimpleRequestForAccount.postAsString(str5, easyPutOpt, null, true);
            ProtocolLogHelper.newResponseLog(str5, new String[]{"tmpPhoneToken", "simId", "iccId", "mccmnc"}).jsonResponseWithMaskOrNull(postAsString).log();
            if (postAsString != null) {
                JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody(postAsString));
                int i = jSONObject.getInt("code");
                String str6 = "code: " + i + ", desc: " + jSONObject.optString("description");
                AccountLog.i("XMPassport", "exchangePhoneTokenBytempPhoneToken: ".concat(String.valueOf(str6)));
                if (i == 0) {
                    return jSONObject.getJSONObject("data").optString("phoneToken");
                }
                throw new InvalidResponseException(str6);
            }
            throw new InvalidResponseException("result content is null");
        } catch (JSONException unused) {
            throw new InvalidResponseException("result not json");
        }
    }

    public static AccountInfo getStsUrlByPassToken(String str, String str2, String str3, String str4) throws InvalidResponseException, InvalidCredentialException, IOException, AccessDeniedException, AuthenticationFailureException, PackageNameDeniedException, InvalidUserNameException, NeedNotificationException {
        return loginByPassToken(new PassTokenLoginParams.Builder().userId(str).passToken(str4).serviceId(str2).loginRequestUrl(URLs.URL_LOGIN_HTTPS).deviceId(str3).isReturnStsUrl(true).isGetPhoneTicketLoginMetaData(false).build());
    }

    public static AccountInfo loginByPassTokenNE(String str, String str2, String str3, String str4) throws InvalidResponseException, InvalidCredentialException, IOException, AccessDeniedException, AuthenticationFailureException, InvalidUserNameException, NeedNotificationException, PackageNameDeniedException {
        return loginByPassTokenNE(str, str2, str3, str4, URLs.URL_LOGIN_HTTPS);
    }

    public static AccountInfo loginByPassTokenNE(String str, String str2, String str3, String str4, String str5) throws InvalidResponseException, InvalidCredentialException, IOException, AccessDeniedException, AuthenticationFailureException, InvalidUserNameException, NeedNotificationException, PackageNameDeniedException {
        return loginByPassToken(new PassTokenLoginParams.Builder().userId(str).passToken(str4).serviceId(str2).loginRequestUrl(str5).deviceId(str3).isReturnStsUrl(false).isGetPhoneTicketLoginMetaData(false).build());
    }

    public static AccountInfo loginByPassToken(String str, String str2, String str3, String str4) throws InvalidResponseException, InvalidCredentialException, PackageNameDeniedException, IOException, AccessDeniedException, AuthenticationFailureException, InvalidUserNameException {
        return loginByPassToken(str, str2, str3, str4, URLs.URL_LOGIN_HTTPS);
    }

    public static AccountInfo loginByPassToken(String str, String str2, String str3, String str4, String str5) throws InvalidResponseException, InvalidCredentialException, PackageNameDeniedException, IOException, AccessDeniedException, AuthenticationFailureException, InvalidUserNameException {
        try {
            return loginByPassTokenNE(str, str2, str3, str4, str5);
        } catch (NeedNotificationException unused) {
            throw new InvalidResponseException("Unexpected NeedNotificationException");
        }
    }

    public static AccountInfo loginByPassToken(PassTokenLoginParams passTokenLoginParams) throws InvalidResponseException, InvalidCredentialException, IOException, AccessDeniedException, AuthenticationFailureException, InvalidUserNameException, NeedNotificationException, PackageNameDeniedException {
        if (passTokenLoginParams != null) {
            String str = passTokenLoginParams.loginRequestUrl;
            if (TextUtils.isEmpty(str)) {
                str = URLs.URL_LOGIN_HTTPS;
            }
            String str2 = passTokenLoginParams.serviceId;
            if (TextUtils.isEmpty(str2)) {
                str2 = "passport";
            }
            String str3 = str2;
            String str4 = passTokenLoginParams.userId;
            String str5 = passTokenLoginParams.passToken;
            String str6 = passTokenLoginParams.deviceId;
            String str7 = passTokenLoginParams.uDevId;
            boolean z = passTokenLoginParams.returnStsUrl;
            String queryParameter = Uri.parse(str).getQueryParameter("sid");
            EasyMap easyMap = new EasyMap();
            if (TextUtils.isEmpty(queryParameter)) {
                easyMap.easyPut("sid", str3);
            }
            easyMap.easyPut("_json", "true");
            if (!TextUtils.isEmpty(passTokenLoginParams.packageName)) {
                easyMap.easyPut("appName", passTokenLoginParams.packageName);
            }
            if (passTokenLoginParams.isGetPhoneTicketLoginMetaData) {
                easyMap.put("_loginSign", "ticket");
            }
            EasyMap easyPutOpt = new EasyMap().easyPut("userId", str4).easyPutOpt("passToken", str5).easyPutOpt("uDevId", str7);
            addDeviceIdInCookies(easyPutOpt, str6);
            PassportRequestArguments passportRequestArguments = new PassportRequestArguments();
            passportRequestArguments.setUrl(str);
            passportRequestArguments.putAllCookies(easyPutOpt);
            passportRequestArguments.putAllParams(easyMap);
            passportRequestArguments.setReadBody(true);
            PassportLoginRequest.ByPassToken byPassToken = new PassportLoginRequest.ByPassToken(passportRequestArguments);
            try {
                ProtocolLogHelper.newRequestLog(str, HttpMethod.GET, new String[]{"passToken"}).cookieWithMaskOrNull(easyPutOpt).paramOrNull(easyMap).log();
                SimpleRequest.StringContent executeEx = byPassToken.executeEx();
                logLoginResponseAllowNull(str, executeEx);
                if (executeEx != null) {
                    return processLoginContent(str4, executeEx, str3, true, byPassToken.isResultFromCA(), z);
                }
                throw new IOException("failed to get response from service server");
            } catch (NeedVerificationException unused) {
                throw new InvalidResponseException("Unexpected NeedVerificationException");
            } catch (NeedCaptchaException unused2) {
                throw new InvalidResponseException("Unexpected NeedCaptchaException");
            } catch (PassportCAException unused3) {
                throw new IllegalStateException();
            }
        } else {
            throw new IllegalArgumentException("passToken login params can not be empty");
        }
    }

    public static AccountInfo loginByStep2(String str, String str2, String str3, String str4, MetaLoginData metaLoginData, boolean z, String str5) throws NeedVerificationException, IOException, AccessDeniedException, AuthenticationFailureException, InvalidResponseException {
        return loginByStep2(str, str2, str3, str4, metaLoginData, z, str5, false);
    }

    public static AccountInfo getStsUrlByStep2(String str, String str2, String str3, String str4, MetaLoginData metaLoginData, boolean z, String str5) throws NeedVerificationException, IOException, AccessDeniedException, AuthenticationFailureException, InvalidResponseException {
        return loginByStep2(str, str2, str3, str4, metaLoginData, z, str5, true);
    }

    private static AccountInfo loginByStep2(String str, String str2, String str3, String str4, MetaLoginData metaLoginData, boolean z, String str5, boolean z2) throws NeedVerificationException, IOException, AccessDeniedException, AuthenticationFailureException, InvalidResponseException {
        return loginByStep2(new Step2LoginParams.Builder().setUserId(str).setServiceId(str2).setDeviceId(str3).setStep2code(str4).setMetaLoginData(metaLoginData).setTrust(z).setStep1Token(str5).setReturnStsUrl(z2).build());
    }

    public static AccountInfo loginByStep2(Step2LoginParams step2LoginParams) throws NeedVerificationException, IOException, AccessDeniedException, AuthenticationFailureException, InvalidResponseException {
        if (step2LoginParams != null) {
            String str = step2LoginParams.userId;
            String str2 = step2LoginParams.step2code;
            MetaLoginData metaLoginData = step2LoginParams.metaLoginData;
            String str3 = TextUtils.isEmpty(step2LoginParams.serviceId) ? "passport" : step2LoginParams.serviceId;
            boolean z = step2LoginParams.trust;
            boolean z2 = step2LoginParams.returnStsUrl;
            String str4 = step2LoginParams.deviceId;
            String str5 = step2LoginParams.step1Token;
            if (str == null || str2 == null || metaLoginData == null) {
                throw new NullPointerException("invalid params");
            }
            String str6 = URLs.URL_LOGIN_AUTH_STEP2;
            EasyMap easyPut = new EasyMap().easyPut("user", str).easyPut("code", str2).easyPut("_sign", metaLoginData.sign).easyPut("qs", metaLoginData.qs).easyPut("callback", metaLoginData.callback).easyPut("trust", z ? "true" : "false").easyPutOpt("sid", str3).easyPut("_json", "true");
            EasyMap easyPut2 = new EasyMap().easyPut("step1Token", str5);
            addDeviceIdInCookies(easyPut2, str4);
            ProtocolLogHelper.newRequestLog(str6, HttpMethod.POST, new String[]{"code", "step1Token"}).paramWithMaskOrNull(easyPut).cookieWithMaskOrNull(easyPut2).log();
            SimpleRequest.StringContent postAsString = SimpleRequestForAccount.postAsString(str6, easyPut, easyPut2, true);
            logLoginResponseAllowNull(str6, postAsString);
            if (postAsString != null) {
                try {
                    return processLoginContent(postAsString, str3, false, z2);
                } catch (NeedCaptchaException unused) {
                    throw new InvalidResponseException("Unexpected NeedCaptchaException");
                } catch (InvalidUserNameException unused2) {
                    throw new InvalidResponseException("Unexpected InvalidUserNameException");
                } catch (InvalidCredentialException unused3) {
                    throw new InvalidResponseException("Unexpected InvalidCredentialException");
                } catch (NeedNotificationException unused4) {
                    throw new InvalidResponseException("Unexpected NeedNotificationException");
                } catch (PackageNameDeniedException unused5) {
                    throw new InvalidResponseException("It's not loginByPassToken(), PackageNameDeniedException is unexpected");
                }
            } else {
                throw new IOException("failed to get response from service server");
            }
        } else {
            throw new IllegalArgumentException("step2 params is null");
        }
    }

    public static Pair<Bitmap, String> getCaptchaImage(String str) {
        return getCaptchaImageAndIck(ACCOUNT_DOMAIN + str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038 A[SYNTHETIC, Splitter:B:19:0x0038] */
    public static Pair<Bitmap, String> getCaptchaImageAndIck(String str) {
        SimpleRequest.StreamContent streamContent;
        try {
            ProtocolLogHelper.newRequestLog(str, HttpMethod.GET).log();
            streamContent = SimpleRequestForAccount.getAsStream(str, null, null);
            try {
                ProtocolLogHelper.newResponseLog(str).streamResponseOrNull(streamContent).log();
            } catch (IOException e) {
                e = e;
            } catch (AccessDeniedException e2) {
                e = e2;
                AccountLog.w("XMPassport", "getCaptchaImageAndIck", e);
                if (streamContent != null) {
                }
            } catch (AuthenticationFailureException e3) {
                e = e3;
                AccountLog.w("XMPassport", "getCaptchaImageAndIck", e);
                if (streamContent != null) {
                }
            }
        } catch (IOException e4) {
            e = e4;
            streamContent = null;
            AccountLog.w("XMPassport", "getCaptchaImageAndIck", e);
            if (streamContent != null) {
            }
        } catch (AccessDeniedException e5) {
            e = e5;
            streamContent = null;
            AccountLog.w("XMPassport", "getCaptchaImageAndIck", e);
            if (streamContent != null) {
            }
        } catch (AuthenticationFailureException e6) {
            e = e6;
            streamContent = null;
            AccountLog.w("XMPassport", "getCaptchaImageAndIck", e);
            if (streamContent != null) {
            }
        }
        if (streamContent != null) {
            return null;
        }
        try {
            return Pair.create(BitmapFactory.decodeStream(streamContent.getStream()), streamContent.getHeader("ick"));
        } finally {
            streamContent.closeStream();
        }
    }

    protected static String getClientSign(Long l, String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("nonce", String.valueOf(l));
        return CloudCoder.generateSignature(null, null, treeMap, str);
    }

    public static MetaLoginData getMetaLoginData(String str, String str2) throws IOException, InvalidResponseException, AccessDeniedException, AuthenticationFailureException, InvalidUserNameException {
        try {
            loginByPassToken(str, str2, null, null);
            throw new InvalidResponseException("Unexpected login success with empty pass token");
        } catch (InvalidCredentialException e) {
            return e.getMetaLoginData();
        } catch (PackageNameDeniedException unused) {
            throw new InvalidResponseException("PackageNameDeniedException is unexpected with empty userId or passToken");
        }
    }

    private static MetaLoginData getMetaLoginData(String str) throws IOException, InvalidResponseException, AccessDeniedException, AuthenticationFailureException {
        try {
            loginByPassToken(null, str, null, null);
            throw new InvalidResponseException("Unexpected login success with empty pass token");
        } catch (InvalidCredentialException e) {
            return e.getMetaLoginData();
        } catch (InvalidUserNameException unused) {
            throw new InvalidResponseException("should not be throw this exception");
        } catch (PackageNameDeniedException unused2) {
            throw new InvalidResponseException("PackageNameDeniedException is unexpected with empty userId or passToken");
        }
    }

    private static AccountInfo processLoginContent(SimpleRequest.StringContent stringContent, String str, boolean z, boolean z2) throws InvalidResponseException, InvalidCredentialException, PackageNameDeniedException, IOException, AccessDeniedException, NeedVerificationException, NeedCaptchaException, InvalidUserNameException, NeedNotificationException, AuthenticationFailureException {
        return processLoginContent(stringContent, str, z, false, z2);
    }

    private static AccountInfo processLoginContent(SimpleRequest.StringContent stringContent, String str, boolean z, boolean z2, boolean z3) throws InvalidResponseException, InvalidCredentialException, PackageNameDeniedException, IOException, AccessDeniedException, NeedVerificationException, NeedCaptchaException, InvalidUserNameException, NeedNotificationException, AuthenticationFailureException {
        return processLoginContent(null, stringContent, str, z, z2, z3);
    }

    private static AccountInfo processLoginContent(String str, SimpleRequest.StringContent stringContent, String str2, boolean z, boolean z2, boolean z3) throws InvalidResponseException, InvalidCredentialException, IOException, AccessDeniedException, NeedVerificationException, NeedCaptchaException, InvalidUserNameException, NeedNotificationException, AuthenticationFailureException, PackageNameDeniedException {
        String str3;
        String str4;
        try {
            JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody(stringContent));
            int i = jSONObject.getInt("code");
            String string = jSONObject.getString("desc");
            ServerError serverError = new ServerError(jSONObject);
            AccountLog.i("XMPassport", "processLoginContent, code: " + i + ", desc: " + string);
            if (i == 0) {
                if (z2) {
                    str3 = jSONObject.optString("userId");
                    str4 = jSONObject.optString("passToken");
                } else {
                    str3 = stringContent.getHeader("userId");
                    str4 = stringContent.getHeader("passToken");
                }
                String str5 = str3;
                String str6 = str4;
                String str7 = str5;
                boolean z4 = (!z || str == null || !jSONObject.optBoolean("disableHotfixMiui73508", false)) ? z : false;
                int optInt = jSONObject.optInt("securityStatus", 0);
                AccountLog.i("XMPassport", "securityStatus: ".concat(String.valueOf(optInt)));
                if (z4 && optInt != 0) {
                    String string2 = jSONObject.getString("notificationUrl");
                    if (string2 == null) {
                        throw new InvalidResponseException("noticationUrl is null");
                    } else if (string2.startsWith("http")) {
                        throw new NeedNotificationException(str7, string2, stringContent);
                    } else {
                        throw new NeedNotificationException(str7, ACCOUNT_DOMAIN + string2, stringContent);
                    }
                } else if (TextUtils.isEmpty(str7)) {
                    throw new InvalidResponseException("no user Id");
                } else if (!TextUtils.isEmpty(str6)) {
                    return parseLoginResult(str7, stringContent, str2, null, z2, z3);
                } else {
                    throw new InvalidResponseException("no passToken in login response");
                }
            } else if (i == 20003) {
                throw new InvalidUserNameException();
            } else if (i == 22009) {
                PackageNameDeniedException packageNameDeniedException = new PackageNameDeniedException(i, string);
                AccountLog.w("XMPassport", packageNameDeniedException);
                throw packageNameDeniedException;
            } else if (i == 70002) {
                throw new InvalidCredentialException(i, string, false);
            } else if (i == 70016) {
                String string3 = jSONObject.getString("_sign");
                String string4 = jSONObject.getString("qs");
                String string5 = jSONObject.getString("callback");
                String string6 = jSONObject.getString("captchaUrl");
                if (TextUtils.equals("null", string6)) {
                    string6 = null;
                }
                throw new InvalidCredentialException(i, string, true).metaLoginData(new MetaLoginData(string3, string4, string5)).captchaUrl(string6);
            } else if (i == 81003) {
                throw new NeedVerificationException(new MetaLoginData(jSONObject.getString("_sign"), jSONObject.getString("qs"), jSONObject.getString("callback")), stringContent.getHeader("step1Token"), jSONObject.optString("userId"));
            } else if (i != 87001) {
                throw new InvalidResponseException(i, string, serverError);
            } else {
                throw new NeedCaptchaException(i, string, jSONObject.getString("captchaUrl"));
            }
        } catch (JSONException unused) {
            AccountLog.e("XMPassport", "processLoginContent: ".concat(String.valueOf(stringContent)));
            throw new InvalidResponseException("processLoginContent JSONException");
        }
    }

    private static AccountInfo parseLoginResult(String str, SimpleRequest.StringContent stringContent, String str2, String str3, boolean z, boolean z2) throws InvalidResponseException, IOException, AccessDeniedException, AuthenticationFailureException {
        String str4;
        String str5;
        SimpleRequest.StringContent stringContent2 = stringContent;
        String str6 = str2;
        try {
            JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody(stringContent));
            if (z) {
                str4 = jSONObject.optString("passToken");
                str5 = jSONObject.optString("cUserId");
            } else {
                str4 = stringContent2.getHeader("passToken");
                str5 = stringContent2.getHeader("cUserId");
            }
            String optString = jSONObject.optString("ssecurity");
            Long valueOf = Long.valueOf(jSONObject.optLong("nonce"));
            String optString2 = jSONObject.optString("psecurity");
            if (optString == null || valueOf == null || optString2 == null) {
                try {
                    String header = stringContent2.getHeader("extension-pragma");
                    if (TextUtils.isEmpty(header)) {
                        header = stringContent2.getHeader("Extension-Pragma");
                        if (TextUtils.isEmpty(header)) {
                            throw new InvalidResponseException("empty extension-pragma");
                        }
                    }
                    JSONObject jSONObject2 = new JSONObject(header);
                    optString = jSONObject2.optString("ssecurity");
                    valueOf = Long.valueOf(jSONObject2.optLong("nonce"));
                    optString2 = jSONObject2.optString("psecurity");
                } catch (JSONException unused) {
                }
            }
            if (optString == null || valueOf == null || optString2 == null) {
                throw new InvalidResponseException("security, nonce or psecurity is null");
            }
            String header2 = stringContent2.getHeader("re-pass-token");
            boolean z3 = true;
            if (jSONObject.optInt("pwd") != 1) {
                z3 = false;
            }
            String string = jSONObject.getString("location");
            String str7 = str;
            AccountInfo.Builder psecurity = new AccountInfo.Builder().userId(str).encryptedUserId(str5).serviceId(str6).passToken(str4).psecurity(optString2);
            if (str3 != null) {
                string = str3;
            }
            AccountInfo build = psecurity.autoLoginUrl(string).rePassToken(header2).hasPwd(z3).security(optString).build();
            if (TextUtils.isEmpty(str2) || "passport".equals(str6) || z2) {
                return build;
            }
            return getServiceTokenByStsUrl(build, valueOf);
        } catch (AccessDeniedException e) {
            AccessDeniedException accessDeniedException = e;
            AccountLog.e("XMPassport", "sts url request error", accessDeniedException);
            accessDeniedException.stsUrlRequestError(str6);
            throw accessDeniedException;
        } catch (InvalidResponseException e2) {
            InvalidResponseException invalidResponseException = e2;
            AccountLog.e("XMPassport", "sts url request error", invalidResponseException);
            invalidResponseException.stsUrlRequestError(str6);
            throw invalidResponseException;
        } catch (IOException e3) {
            IOException iOException = e3;
            AccountLog.e("XMPassport", "sts url request error", iOException);
            PassportIOException passportIOException = new PassportIOException(iOException);
            passportIOException.stsUrlRequestError(str6);
            throw passportIOException;
        } catch (AuthenticationFailureException e4) {
            AuthenticationFailureException authenticationFailureException = e4;
            AccountLog.e("XMPassport", "sts url request error", authenticationFailureException);
            authenticationFailureException.stsUrlRequestError(str6);
            throw authenticationFailureException;
        } catch (JSONException unused2) {
            AccountLog.e("XMPassport", "parseLoginResult: ".concat(String.valueOf(stringContent)));
            throw new InvalidResponseException("parseLoginResult JSONException");
        }
    }

    private static AccountInfo getServiceTokenByStsUrl(AccountInfo accountInfo, Long l) throws IOException, AccessDeniedException, InvalidResponseException, AuthenticationFailureException {
        String str = accountInfo.serviceId;
        AccountLog.i("XMPassport", "start sts request: ".concat(String.valueOf(str)));
        String clientSign = getClientSign(l, accountInfo.security);
        if (clientSign != null) {
            String autoLoginUrl = accountInfo.getAutoLoginUrl();
            EasyMap easyPut = new EasyMap().easyPut("clientSign", clientSign).easyPut("_userIdNeedEncrypt", "true");
            ProtocolLogHelper.newRequestLog(autoLoginUrl, HttpMethod.GET).paramOrNull(easyPut).log();
            SimpleRequest.StringContent asString = SimpleRequestForAccount.getAsString(autoLoginUrl, easyPut, null, false);
            ProtocolLogHelper.newResponseLog(autoLoginUrl, new String[]{"serviceToken", String.format("%s_serviceToken", str)}).jsonResponseWithMaskOrNull(asString).log();
            if (asString != null) {
                String header = asString.getHeader(String.format("%s_serviceToken", str));
                if (TextUtils.isEmpty(header)) {
                    header = asString.getHeader("serviceToken");
                    if (TextUtils.isEmpty(header)) {
                        throw new InvalidResponseException(0, "no service token contained in callback cookies: ".concat(String.valueOf(str)));
                    }
                }
                String header2 = asString.getHeader(str + "_slh");
                return new AccountInfo.Builder().userId(accountInfo.userId).serviceId(str).passToken(accountInfo.passToken).encryptedUserId(accountInfo.encryptedUserId).serviceToken(header).security(accountInfo.security).psecurity(accountInfo.psecurity).slh(header2).ph(asString.getHeader(str + "_ph")).rePassToken(accountInfo.rePassToken).hasPwd(accountInfo.hasPwd).build();
            }
            throw new InvalidResponseException(0, "no response when get service token");
        }
        AccountLog.e("XMPassport", "failed to get client sign");
        throw new InvalidResponseException(0, "sign parameters failure");
    }

    @Deprecated
    public static String regByPhone(String str, String str2, String str3) throws IOException, InvalidResponseException {
        Object obj;
        String str4 = URLs.URL_REG_PHONE;
        EasyMap easyPut = new EasyMap().easyPut("phone", str).easyPut("password", str2).easyPut("ticket", str3);
        EasyMap easyMap = new EasyMap();
        SimpleRequest.MapContent mapContent = null;
        addDeviceIdInCookies(easyMap, null);
        try {
            ProtocolLogHelper.newRequestLog(str4, HttpMethod.POST, new String[]{"phone", "password", "ticket"}).paramWithMaskOrNull(easyPut).cookieOrNull(easyMap).log();
            mapContent = SimpleRequestForAccount.postAsMap(str4, easyPut, easyMap, true);
            ProtocolLogHelper.newResponseLog(str4).mapResponseOrNull(mapContent).log();
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        } catch (AuthenticationFailureException e2) {
            e2.printStackTrace();
        }
        if (mapContent != null) {
            Object fromBody = mapContent.getFromBody("code");
            if (INT_0.equals(fromBody)) {
                Object fromBody2 = mapContent.getFromBody("data");
                if ((fromBody2 instanceof Map) && (obj = ((Map) fromBody2).get("userId")) != null) {
                    return obj.toString();
                }
            }
            if (USE_PREVIEW) {
                AccountLog.w("XMPassport", String.format("register failed, code: %s, description: %s", fromBody, mapContent.getFromBody("description")));
            }
            throw new InvalidResponseException("failed to register due to invalid response from server");
        }
        throw new IOException("failed to register, no response");
    }

    @Deprecated
    public static String regByEmail(String str, String str2, String str3, String str4) throws IOException, InvalidResponseException, NeedCaptchaException {
        try {
            return regByEmail(new EmailRegisterParams.Builder().email(str).password(str2).captchaCode(str3, str4).build());
        } catch (UsedEmailAddressException e) {
            AccountLog.w("XMPassport", "email used");
            throw new InvalidResponseException(e.getMessage());
        }
    }

    public static String regByEmail(EmailRegisterParams emailRegisterParams) throws IOException, InvalidResponseException, NeedCaptchaException, UsedEmailAddressException {
        if (emailRegisterParams != null) {
            String str = emailRegisterParams.emailAddress;
            String str2 = emailRegisterParams.password;
            String str3 = emailRegisterParams.captCode;
            String str4 = emailRegisterParams.captIck;
            String str5 = emailRegisterParams.region;
            String str6 = emailRegisterParams.serviceId;
            String replaceUrlHost = replaceUrlHost(URLs.URL_EMAIL_REGISTER, str5);
            EasyMap easyPut = new EasyMap().easyPut("email", str).easyPut("password", str2).easyPut("_json", "true").easyPutOpt("inputcode", str3).easyPutOpt("region", str5).easyPutOpt("sid", str6).easyPut("acceptLicense", "true");
            EasyMap easyPutOpt = new EasyMap().easyPutOpt("ick", str4);
            SimpleRequest.StringContent stringContent = null;
            addDeviceIdInCookies(easyPutOpt, null);
            try {
                ProtocolLogHelper.newRequestLog(replaceUrlHost, HttpMethod.POST, new String[]{"email", "password"}).paramWithMaskOrNull(easyPut).cookieOrNull(easyPutOpt).log();
                stringContent = SimpleRequestForAccount.postAsString(replaceUrlHost, easyPut, easyPutOpt, true);
                ProtocolLogHelper.newResponseLog(replaceUrlHost).stringResponseOrNull(stringContent).log();
            } catch (AccessDeniedException e) {
                e.printStackTrace();
            } catch (AuthenticationFailureException e2) {
                e2.printStackTrace();
            }
            if (stringContent != null) {
                try {
                    JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody(stringContent));
                    int i = jSONObject.getInt("code");
                    ServerError serverError = new ServerError(jSONObject);
                    String optString = jSONObject.optString("description");
                    if (i == 0) {
                        return jSONObject.getString("userId");
                    }
                    if (i == 25005) {
                        throw new UsedEmailAddressException(optString);
                    } else if (i != 87001) {
                        throw new InvalidResponseException(i, optString, serverError);
                    } else {
                        throw new NeedCaptchaException(i, optString, URLs.URL_REG_GET_CAPTCHA_CODE);
                    }
                } catch (JSONException e3) {
                    AccountLog.w("XMPassport", "json error", e3);
                    throw new InvalidResponseException("json error");
                }
            } else {
                throw new IOException("failed to register, no response");
            }
        } else {
            throw new IllegalArgumentException("email params should not be null");
        }
    }

    private static String replaceUrlHost(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        Application applicationContext = XMPassportSettings.getApplicationContext();
        if (applicationContext == null) {
            str3 = null;
        } else {
            str3 = new RegionConfig(applicationContext).blockingGetRegHostName(str2);
        }
        if (TextUtils.isEmpty(str3)) {
            return str;
        }
        return str.replaceFirst(URLs.HOST_URL_ACCOUNT_BASE, str3);
    }

    public static void getRegisterVerifyCode(String str, String str2, String str3) throws IOException, AccessDeniedException, AuthenticationFailureException, InvalidResponseException, RegisteredPhoneException, NeedCaptchaException {
        String str4 = URLs.URL_REG_GET_VERIFY_CODE;
        EasyMap easyPut = new EasyMap().easyPut("phone", str);
        if (str2 != null) {
            easyPut.easyPut("icode", str2);
        }
        EasyMap easyMap = null;
        if (str3 != null) {
            easyMap = new EasyMap().easyPutOpt("ick", str3);
        }
        ProtocolLogHelper.newRequestLog(str4, HttpMethod.POST, new String[]{"phone"}).paramWithMaskOrNull(easyPut).cookieOrNull(easyMap).log();
        SimpleRequest.StringContent postAsString = SimpleRequestForAccount.postAsString(str4, easyPut, easyMap, true);
        ProtocolLogHelper.newResponseLog(str4).stringResponseOrNull(postAsString).log();
        try {
            JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody(postAsString));
            int i = jSONObject.getInt("code");
            if (i == 0) {
                return;
            }
            if (i == 20031) {
                throw new NeedCaptchaException(i, "", jSONObject.getString("info"));
            } else if (i != 25001) {
                throw new InvalidResponseException("process result is failed");
            } else {
                throw new RegisteredPhoneException("phone is registered");
            }
        } catch (JSONException e) {
            AccountLog.e("XMPassport", "getRegisterVerifyCode ", e);
            throw new InvalidResponseException("process result is failed");
        }
    }

    public static void checkRegisterVerifyCode(String str, String str2) throws IOException, AccessDeniedException, AuthenticationFailureException, InvalidResponseException {
        String str3 = URLs.URL_REG_CHECK_VERIFY_CODE;
        EasyMap easyPut = new EasyMap().easyPut("phone", str).easyPut("ticket", str2);
        ProtocolLogHelper.newRequestLog(str3, HttpMethod.GET, new String[]{"phone", "ticket"}).paramWithMaskOrNull(easyPut).log();
        SimpleRequest.StringContent asString = SimpleRequestForAccount.getAsString(str3, easyPut, null, true);
        ProtocolLogHelper.newResponseLog(str3).stringResponseOrNull(asString).log();
        try {
            if (new JSONObject(removeSafePrefixAndGetRealBody(asString)).getInt("code") != 0) {
                throw new InvalidResponseException("invalid response, failed to check register verify code");
            }
        } catch (JSONException unused) {
            throw new InvalidResponseException("invalid response, fail to convert to JSON");
        }
    }

    public static boolean checkEmailAvailability(String str) throws IOException, InvalidResponseException {
        String userIdForAddress = getUserIdForAddress(str, CheckAvailibilityType.EMAIL);
        if ("1".equals(userIdForAddress)) {
            return false;
        }
        if ("-1".equals(userIdForAddress)) {
            return true;
        }
        throw new InvalidResponseException(String.format("url %s should only return 1 or -1 as user id, but actually return %s", URLs.URL_USER_EXISTS, userIdForAddress));
    }

    public static boolean checkPhoneAvailability(Context context, String str, String str2) throws IOException, InvalidResponseException {
        String userIdForAddress = getUserIdForAddress(str, CheckAvailibilityType.PHONE);
        if ("1".equals(userIdForAddress)) {
            return false;
        }
        if ("-1".equals(userIdForAddress)) {
            return true;
        }
        throw new InvalidResponseException(String.format("url %s should only return 1 or -1 as user id, but actually return %s", URLs.URL_USER_EXISTS, userIdForAddress));
    }

    private static String getUserIdForAddress(String str, CheckAvailibilityType checkAvailibilityType) throws IOException, InvalidResponseException {
        Object obj;
        String str2 = checkAvailibilityType == CheckAvailibilityType.EMAIL ? "EM" : "PH";
        String str3 = URLs.URL_USER_EXISTS;
        EasyMap easyPut = new EasyMap().easyPut("type", str2).easyPut("externalId", str);
        SimpleRequest.MapContent mapContent = null;
        try {
            ProtocolLogHelper.newRequestLog(str3, HttpMethod.GET).paramOrNull(easyPut).log();
            mapContent = SimpleRequestForAccount.getAsMap(str3, easyPut, null, true);
            ProtocolLogHelper.newResponseLog(str3).mapResponseOrNull(mapContent).log();
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        } catch (AuthenticationFailureException e2) {
            e2.printStackTrace();
        }
        if (mapContent != null) {
            if (INT_0.equals(mapContent.getFromBody("code"))) {
                Object fromBody = mapContent.getFromBody("data");
                if ((fromBody instanceof Map) && (obj = ((Map) fromBody).get("userId")) != null) {
                    return obj.toString();
                }
            }
            throw new InvalidResponseException(String.format("server error when getting user id, reason:%s, description:%s, code:%s", mapContent.getFromBody("reason"), mapContent.getFromBody("description"), mapContent.getFromBody("code")));
        }
        throw new IOException("failed to get response when getting user id");
    }

    @Deprecated
    public static void sendActivateEmail(String str, String str2) throws IOException, InvalidResponseException {
        String str3 = URLs.URL_RESEND_EMAIL;
        EasyMap easyPut = new EasyMap().easyPut("userId", str).easyPut("addressType", "EM").easyPut("address", str2);
        SimpleRequest.MapContent mapContent = null;
        try {
            ProtocolLogHelper.newRequestLog(str3, HttpMethod.GET, new String[]{"address"}).paramWithMaskOrNull(easyPut).log();
            mapContent = SimpleRequestForAccount.getAsMap(str3, easyPut, null, true);
            ProtocolLogHelper.newResponseLog(str3).mapResponseOrNull(mapContent).log();
        } catch (AccessDeniedException e) {
            e.printStackTrace();
        } catch (AuthenticationFailureException e2) {
            e2.printStackTrace();
        }
        if (mapContent != null) {
            if (!INT_0.equals(mapContent.getFromBody("code"))) {
                throw new InvalidResponseException("invalid response, failed to send activate email");
            }
            return;
        }
        throw new IOException("failed to register, no response");
    }

    @Deprecated
    public static void sendPhoneRegTicket(String str, String str2, String str3, String str4) throws NeedCaptchaException, InvalidResponseException, AccessDeniedException, AuthenticationFailureException, IOException, SendVerifyCodeExceedLimitException {
        sendPhoneRegTicket(new SendPhoneTicketParams.Builder().phone(str).deviceId(str2).captchaCode(str3, str4).build());
    }

    public static void sendPhoneRegTicket(SendPhoneTicketParams sendPhoneTicketParams) throws NeedCaptchaException, InvalidResponseException, AccessDeniedException, AuthenticationFailureException, IOException, SendVerifyCodeExceedLimitException {
        if (sendPhoneTicketParams != null) {
            String str = sendPhoneTicketParams.phone;
            String str2 = sendPhoneTicketParams.deviceId;
            String str3 = sendPhoneTicketParams.region;
            String str4 = sendPhoneTicketParams.captCode;
            String str5 = sendPhoneTicketParams.captIck;
            String replaceUrlHost = replaceUrlHost(URLs.URL_REG_SEND_PHONE_TICKET, str3);
            EasyMap easyPutOpt = new EasyMap().easyPut("phone", str).easyPutOpt("icode", str4).easyPutOpt("region", str3);
            easyPutOpt.putAll(XMPassportUtil.getDefaultLocaleParam());
            EasyMap easyMap = new EasyMap();
            easyMap.easyPutOpt("ick", str5);
            addDeviceIdInCookies(easyMap, str2);
            ProtocolLogHelper.newRequestLog(replaceUrlHost, HttpMethod.POST, new String[]{"phone"}).paramWithMaskOrNull(easyPutOpt).cookieOrNull(easyMap).log();
            SimpleRequest.StringContent postAsString = SimpleRequestForAccount.postAsString(replaceUrlHost, easyPutOpt, easyMap, true);
            ProtocolLogHelper.newResponseLog(replaceUrlHost).stringResponseOrNull(postAsString).log();
            try {
                JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody(postAsString));
                int i = jSONObject.getInt("code");
                String optString = jSONObject.optString("description");
                ServerError serverError = new ServerError(jSONObject);
                if (i != 0) {
                    if (i != 20031) {
                        if (i == 70022) {
                            throw new SendVerifyCodeExceedLimitException(optString);
                        } else if (i != 87001) {
                            throw new InvalidResponseException(i, optString, serverError);
                        }
                    }
                    throw new NeedCaptchaException(i, optString, jSONObject.getString("info"));
                }
            } catch (JSONException e) {
                throw new InvalidResponseException("JSON error", e);
            }
        } else {
            throw new IllegalArgumentException("send phone reg ticket params should not be null");
        }
    }

    @Deprecated
    public static RegisterUserInfo checkRegisterPhone(String str, String str2, String str3, String str4) throws IOException, AccessDeniedException, InvalidPhoneOrTicketException, AuthenticationFailureException, InvalidResponseException, UserRestrictedException {
        return checkRegisterPhone(new CheckRegPhoneParams.Builder().phoneTicket(str, str2).activatedPhone(str3, null, null).deviceId(str4).build());
    }

    @Deprecated
    public static RegisterUserInfo checkRegisterPhone(String str, String str2, String str3, String str4, String str5, String str6) throws IOException, AccessDeniedException, InvalidPhoneOrTicketException, AuthenticationFailureException, InvalidResponseException, UserRestrictedException {
        return checkRegisterPhone(new CheckRegPhoneParams.Builder().phoneTicket(str, str2).activatedPhone(str3, str5, str6).deviceId(str4).build());
    }

    public static RegisterUserInfo checkRegisterPhone(CheckRegPhoneParams checkRegPhoneParams) throws IOException, AccessDeniedException, InvalidPhoneOrTicketException, AuthenticationFailureException, InvalidResponseException, UserRestrictedException {
        if (checkRegPhoneParams != null) {
            String str = checkRegPhoneParams.phone;
            String str2 = checkRegPhoneParams.ticket;
            String str3 = checkRegPhoneParams.hashedSimId;
            String str4 = checkRegPhoneParams.vKey2;
            String str5 = checkRegPhoneParams.vKey2Nonce;
            String str6 = checkRegPhoneParams.deviceId;
            String str7 = checkRegPhoneParams.region;
            String replaceUrlHost = replaceUrlHost(URLs.URL_REG_VERIFY_PHONE, str7);
            EasyMap easyPutOpt = new EasyMap().easyPut("phone", str).easyPutOpt("ticket", str2).easyPutOpt("simId", str3).easyPutOpt("vkey2", str4).easyPutOpt("nonce", str5).easyPutOpt("region", str7);
            EasyMap easyMap = new EasyMap();
            addDeviceIdInCookies(easyMap, str6);
            ProtocolLogHelper.newRequestLog(replaceUrlHost, HttpMethod.POST, new String[]{"phone", "ticket"}).paramWithMaskOrNull(easyPutOpt).cookieOrNull(easyMap).log();
            SimpleRequest.StringContent postAsString = SimpleRequestForAccount.postAsString(replaceUrlHost, easyPutOpt, easyMap, true);
            ProtocolLogHelper.newResponseLog(replaceUrlHost).stringResponseOrNull(postAsString).log();
            try {
                JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody(postAsString));
                ServerError serverError = new ServerError(jSONObject);
                int i = jSONObject.getInt("code");
                String str8 = "code: " + i + ", desc: " + jSONObject.optString("description");
                if (i == 0) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                    String header = postAsString.getHeader("ticketToken");
                    if (header != null) {
                        return new RegisterUserInfo.Builder(jSONObject2.getInt("status")).phone(str).userId(jSONObject2.optString("userId", null)).maskedUserId(jSONObject2.optString("maskedUserId", null)).userName(jSONObject2.optString("userName", null)).avatarAddress(jSONObject2.optString("portraitUrl", null)).bindTime(jSONObject2.optLong("bindTime", 0)).needGetActiveTime(jSONObject2.optBoolean("needGetActiveTime", false)).needToast(jSONObject2.optBoolean("needToast", false)).ticketToken(header).build();
                    }
                    throw new InvalidResponseException("fail to get ticketToken");
                } else if (i == 10017) {
                    throw new InvalidPhoneOrTicketException(str8);
                } else if (i == 20023) {
                    throw new UserRestrictedException(str8);
                } else {
                    throw new InvalidResponseException(i, str8, serverError);
                }
            } catch (JSONException e) {
                throw new InvalidResponseException("process result is failed", e);
            }
        } else {
            throw new IllegalArgumentException("check reg phone params can not be null");
        }
    }

    @Deprecated
    public static String regByPhoneWithToken(String str, String str2, String str3, String str4) throws IOException, AccessDeniedException, AuthenticationFailureException, InvalidResponseException, InvalidParameterException, TokenExpiredException {
        try {
            return regByPhoneWithToken(new PhoneTokenRegisterParams.Builder().phoneTicketToken(str, str3).password(str2).region(str4).build()).getUserId();
        } catch (UserRestrictedException e) {
            throw new InvalidResponseException(e.getMessage());
        } catch (ReachLimitException e2) {
            throw new InvalidResponseException(e2.getMessage());
        }
    }

    public static AccountInfo regByPhoneWithToken(PhoneTokenRegisterParams phoneTokenRegisterParams) throws IOException, AccessDeniedException, AuthenticationFailureException, InvalidResponseException, InvalidParameterException, TokenExpiredException, UserRestrictedException, ReachLimitException {
        if (phoneTokenRegisterParams != null) {
            String str = phoneTokenRegisterParams.phone;
            String str2 = phoneTokenRegisterParams.phoneHash;
            String str3 = phoneTokenRegisterParams.password;
            String str4 = phoneTokenRegisterParams.region;
            String str5 = phoneTokenRegisterParams.ticketToken;
            String str6 = phoneTokenRegisterParams.activatorToken;
            boolean z = phoneTokenRegisterParams.noPwd;
            String str7 = phoneTokenRegisterParams.serviceId;
            String replaceUrlHost = replaceUrlHost(URLs.URL_REG_TOKEN, str4);
            EasyMap easyPut = new EasyMap().easyPutOpt("phone", str).easyPutOpt("phoneHash", str2).easyPutOpt("password", str3).easyPut("noPwd", String.valueOf(z)).easyPut("_locale", XMPassportUtil.getISOLocaleString(Locale.getDefault())).easyPutOpt("region", str4).easyPutOpt("sid", str7).easyPut("_json", "true").easyPut("acceptLicense", "true");
            EasyMap easyPutOpt = new EasyMap().easyPutOpt("activatorToken", str6).easyPutOpt("ticketToken", str5);
            addDeviceIdInCookies(easyPutOpt, null);
            ProtocolLogHelper.newRequestLog(replaceUrlHost, HttpMethod.POST, new String[]{"phone", "phoneHash", "password", "activatorToken", "ticketToken"}).paramWithMaskOrNull(easyPut).cookieWithMaskOrNull(easyPutOpt).log();
            boolean z2 = true;
            SimpleRequest.StringContent postAsString = SimpleRequestForAccount.postAsString(replaceUrlHost, easyPut, easyPutOpt, true);
            ProtocolLogHelper.newResponseLog(replaceUrlHost, new String[]{"passToken"}).jsonResponseWithMaskOrNull(postAsString).log();
            try {
                JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody(postAsString));
                int i = jSONObject.getInt("code");
                String optString = jSONObject.optString("description");
                String str8 = "code: " + i + ", desc: " + optString;
                if (i == 0) {
                    String header = postAsString.getHeader("userId");
                    String header2 = postAsString.getHeader("cUserId");
                    String header3 = postAsString.getHeader("passToken");
                    String optString2 = jSONObject.optString("user_synced_url");
                    AccountInfo.Builder passToken = new AccountInfo.Builder().userId(header).encryptedUserId(header2).passToken(header3);
                    if (TextUtils.isEmpty(str3)) {
                        z2 = false;
                    }
                    return passToken.hasPwd(z2).userSyncedUrl(optString2).build();
                } else if (i == 10017) {
                    throw new InvalidParameterException(i, optString);
                } else if (i == 21317) {
                    throw new TokenExpiredException(str8);
                } else if (i == 20023) {
                    throw new UserRestrictedException(str8);
                } else if (i == 25004) {
                    throw new ReachLimitException(str8);
                } else {
                    throw new InvalidResponseException(str8);
                }
            } catch (JSONException e) {
                throw new InvalidResponseException("process result is failed", e);
            }
        } else {
            throw new IllegalArgumentException("phone can not be empty");
        }
    }

    public static void resetPassword(String str, String str2, String str3, String str4, String str5) throws InvalidResponseException, AccessDeniedException, AuthenticationFailureException, IOException, InvalidParameterException {
        String str6 = URLs.URL_RESET_PASSWORD;
        EasyMap easyPutOpt = new EasyMap().easyPut("userId", str).easyPut("password", str2).easyPut("_json", "true").easyPutOpt("passportsecurity_ph", str4);
        EasyMap easyPutOpt2 = new EasyMap().easyPut("userId", str).easyPutOpt("serviceToken", str3).easyPutOpt("passportsecurity_ph", str4).easyPutOpt("passportsecurity_slh", str5);
        ProtocolLogHelper.newRequestLog(str6, HttpMethod.POST, new String[]{"password", "serviceToken"}).paramWithMaskOrNull(easyPutOpt).cookieWithMaskOrNull(easyPutOpt2).log();
        SimpleRequest.StringContent postAsString = SimpleRequestForAccount.postAsString(str6, easyPutOpt, easyPutOpt2, true);
        ProtocolLogHelper.newResponseLog(str6).stringResponseOrNull(postAsString).log();
        try {
            String removeSafePrefixAndGetRealBody = removeSafePrefixAndGetRealBody(postAsString);
            long j = new JSONObject(removeSafePrefixAndGetRealBody).getLong("result");
            if (j != 0) {
                if (j != 110021001) {
                    if (j != 110071001) {
                        throw new InvalidResponseException("reset password fail: ".concat(String.valueOf(removeSafePrefixAndGetRealBody)));
                    }
                }
                throw new InvalidParameterException("invalid password");
            }
        } catch (JSONException e) {
            throw new InvalidResponseException("process result is failed", e);
        }
    }

    @Deprecated
    public static XiaomiUserInfo getXiaomiUserInfo(String str, String str2, String str3) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException {
        return getXiaomiUserInfo(new PassportInfo(str, null, null, str2, str3));
    }

    @Deprecated
    public static XiaomiUserInfo getXiaomiUserInfo(String str, String str2, String str3, String str4) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException {
        return getXiaomiUserInfo(new PassportInfo(str, str2, null, str3, str4));
    }

    public static XiaomiUserInfo getXiaomiUserInfo(PassportInfo passportInfo) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(XiaomiUserCoreInfo.Flag.BASE_INFO);
        arrayList.add(XiaomiUserCoreInfo.Flag.BIND_ADDRESS);
        return new XiaomiUserInfo(passportInfo.getUserId(), getXiaomiUserCoreInfo(passportInfo, null, arrayList));
    }

    @Deprecated
    public static XiaomiUserProfile getXiaomiUserProfile(String str, String str2, String str3, String str4, String str5) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException {
        return getXiaomiUserProfile(new PassportInfo(str, str2, str3, str4, str5));
    }

    public static XiaomiUserProfile getXiaomiUserProfile(PassportInfo passportInfo) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(XiaomiUserCoreInfo.Flag.BASE_INFO);
        arrayList.add(XiaomiUserCoreInfo.Flag.EXTRA_INFO);
        XiaomiUserCoreInfo xiaomiUserCoreInfo = getXiaomiUserCoreInfo(passportInfo, null, arrayList);
        if (xiaomiUserCoreInfo == null) {
            return null;
        }
        XiaomiUserProfile xiaomiUserProfile = new XiaomiUserProfile(passportInfo.getUserId());
        xiaomiUserProfile.setUserName(xiaomiUserCoreInfo.userName);
        xiaomiUserProfile.setBirthday(xiaomiUserCoreInfo.birthday);
        xiaomiUserProfile.setGender(xiaomiUserCoreInfo.gender);
        return xiaomiUserProfile;
    }

    @Deprecated
    public static MiCloudAuthInfo getOAuthInfo(Context context, String str, String str2, String str3, String str4, Bundle bundle, String str5, String str6) throws NeedOAuthorizeException, IOException, AuthenticationFailureException, AccessDeniedException {
        String string = bundle.getString("extra_scope");
        if (string == null || !string.equals("3")) {
            throw new NeedOAuthorizeException();
        }
        try {
            return tryGetOAuthInfoQuietly(new OAuthParameter.Builder().userId(str).clientId(str2).redirectUri(str3).deviceId(str4).scope("3").serviceToken(str5).responseType("token").build());
        } catch (InvalidResponseException unused) {
            throw new NeedOAuthorizeException();
        }
    }

    public static MiCloudAuthInfo tryGetOAuthInfoQuietly(OAuthParameter oAuthParameter) throws IOException, InvalidResponseException, AccessDeniedException, NeedOAuthorizeException, AuthenticationFailureException {
        String str = URLs.URL_AUTH2_AUTHORIZE;
        EasyMap easyPutOpt = new EasyMap().easyPutOpt("serviceToken", oAuthParameter.serviceToken);
        if (!oAuthParameter.useCUserId || TextUtils.isEmpty(oAuthParameter.cUserId)) {
            easyPutOpt.easyPutOpt("userId", oAuthParameter.userId);
        } else {
            easyPutOpt.easyPutOpt("cUserId", oAuthParameter.cUserId);
        }
        easyPutOpt.easyPutOpt("deviceId", oAuthParameter.deviceId);
        easyPutOpt.easyPutOpt("userSpaceId", UserSpaceIdUtil.getNullableUserSpaceIdCookie());
        if (TextUtils.isEmpty(oAuthParameter.responseType)) {
            oAuthParameter.responseType = "token";
        }
        EasyMap easyPut = new EasyMap().easyPut("client_id", oAuthParameter.clientId).easyPut("redirect_uri", oAuthParameter.redirectUri).easyPut("response_type", oAuthParameter.responseType).easyPut("scope", oAuthParameter.scope).easyPut("skip_confirm", "true").easyPut("state", oAuthParameter.state).easyPut("_json", "true");
        if (!TextUtils.isEmpty(oAuthParameter.aUthorizedDeviceId) && !TextUtils.isEmpty(oAuthParameter.aUthorizedDeviceId.trim())) {
            easyPut.easyPutOpt("device_id", oAuthParameter.aUthorizedDeviceId);
        }
        easyPut.easyPutOpt("pt", oAuthParameter.platform);
        ProtocolLogHelper.newRequestLog(str, HttpMethod.GET, new String[]{"serviceToken"}).cookieWithMaskOrNull(easyPutOpt).paramOrNull(easyPut).log();
        SimpleRequest.StringContent asString = SimpleRequestForAccount.getAsString(str, easyPut, easyPutOpt, true);
        ProtocolLogHelper.newResponseLog(str, new String[]{"access_token"}).jsonResponseWithMaskOrNull(asString).log();
        return parseOAuthInfoResult(oAuthParameter.responseType, asString);
    }

    static MiCloudAuthInfo parseOAuthInfoResult(String str, SimpleRequest.StringContent stringContent) throws IOException, InvalidResponseException, NeedOAuthorizeException, AuthenticationFailureException {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (str == null) {
            throw new IllegalArgumentException("response type is null");
        } else if (stringContent != null) {
            String str8 = stringContent.getHeaders().get("Content-Type");
            if (str8 == null || !str8.toLowerCase().contains("json")) {
                throw new NeedOAuthorizeException("contentType error : ".concat(String.valueOf(str8)));
            }
            try {
                String removeSafePrefixAndGetRealBody = removeSafePrefixAndGetRealBody(stringContent);
                if (removeSafePrefixAndGetRealBody != null) {
                    JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody);
                    int i = jSONObject.getInt("code");
                    if (i == 70016) {
                        throw new AuthenticationFailureException(removeSafePrefixAndGetRealBody);
                    } else if (i != 0 || !str.equals(jSONObject.getString("result"))) {
                        throw new NeedOAuthorizeException();
                    } else {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        String str9 = null;
                        if ("code".equals(str)) {
                            String queryParameter = Uri.parse(jSONObject2.getString("redirectUrl")).getQueryParameter("code");
                            if (!TextUtils.isEmpty(queryParameter)) {
                                str6 = queryParameter;
                                str3 = null;
                                str2 = null;
                                str7 = null;
                                str5 = null;
                                str4 = null;
                            } else {
                                throw new NeedOAuthorizeException();
                            }
                        } else {
                            str3 = jSONObject2.getString("access_token");
                            if (!TextUtils.isEmpty(str3)) {
                                str7 = jSONObject2.getString("expires_in");
                                String string = jSONObject2.getString("scope");
                                str5 = jSONObject2.getString("token_type");
                                str4 = jSONObject2.getString("mac_key");
                                str2 = jSONObject2.getString("mac_algorithm");
                                String str10 = string;
                                str6 = null;
                                str9 = str10;
                            } else {
                                throw new NeedOAuthorizeException();
                            }
                        }
                        MiCloudAuthInfo miCloudAuthInfo = new MiCloudAuthInfo();
                        miCloudAuthInfo.setAccessToken(str3);
                        if (str7 != null) {
                            miCloudAuthInfo.setExpires(Integer.valueOf(str7).intValue());
                        }
                        miCloudAuthInfo.setScope(str9);
                        miCloudAuthInfo.setTokenType(str5);
                        miCloudAuthInfo.setMacKey(str4);
                        miCloudAuthInfo.setMacAlgorithm(str2);
                        miCloudAuthInfo.setCode(str6);
                        return miCloudAuthInfo;
                    }
                } else {
                    throw new InvalidResponseException("empty response");
                }
            } catch (JSONException e) {
                throw new NeedOAuthorizeException(e.getMessage());
            }
        } else {
            throw new IOException("failed to get response to get Auth2 auth info");
        }
    }

    public static String removeSafePrefixAndGetRealBody(SimpleRequest.StringContent stringContent) throws IOException {
        if (stringContent != null) {
            String body = stringContent.getBody();
            return body.startsWith("&&&START&&&") ? body.substring(11) : body;
        }
        throw new IOException("failed to get response to check register verify code");
    }

    public static String getThirdPartyAccessToken(String str, String str2, String str3, String str4) throws IOException, AccessDeniedException, AuthenticationFailureException {
        String str5 = URLs.OPEN_URL_GET_ACCESS_TOKEN;
        EasyMap easyPut = new EasyMap().easyPut("userId", str).easyPut("snsType", str3).easyPut("sid", str2);
        EasyMap easyPut2 = new EasyMap().easyPut("userId", str).easyPut("serviceToken", str4);
        ProtocolLogHelper.newRequestLog(str5, HttpMethod.GET, new String[]{"serviceToken"}).cookieWithMaskOrNull(easyPut2).paramOrNull(easyPut).log();
        SimpleRequest.StringContent asString = SimpleRequestForAccount.getAsString(str5, easyPut, easyPut2, true);
        ProtocolLogHelper.newResponseLog(str5).stringResponseOrNull(asString).log();
        if (asString != null) {
            return asString.toString();
        }
        throw new IOException("failed to get response to get access token");
    }

    public static String refreshThirdPartyAccessToken(String str, String str2, String str3, String str4) throws IOException, AccessDeniedException, AuthenticationFailureException {
        String str5 = URLs.OPEN_URL_REFRESH_ACCESS_TOKEN;
        EasyMap easyPut = new EasyMap().easyPut("userId", str).easyPut("snsType", str3).easyPut("sid", str2);
        EasyMap easyPut2 = new EasyMap().easyPut("userId", str).easyPut("serviceToken", str4);
        ProtocolLogHelper.newRequestLog(str5, HttpMethod.GET, new String[]{"serviceToken"}).cookieWithMaskOrNull(easyPut2).paramOrNull(easyPut).log();
        SimpleRequest.StringContent asString = SimpleRequestForAccount.getAsString(str5, easyPut, easyPut2, true);
        ProtocolLogHelper.newResponseLog(str5).stringResponseOrNull(asString).log();
        if (asString != null) {
            return asString.toString();
        }
        throw new IOException("failed to get response to refresh access token");
    }

    public static HashMap<String, Object> getDeviceInfo(PassportInfo passportInfo, String str, List<String> list) throws IOException, AccessDeniedException, CipherException, InvalidResponseException, AuthenticationFailureException {
        return DeviceInfoHelper.getDeviceInfo(passportInfo, str, list);
    }

    public static ArrayList<HashMap<String, Object>> getAllDevicesInfo(PassportInfo passportInfo, ArrayList<String> arrayList) throws IOException, AccessDeniedException, AuthenticationFailureException, CipherException, InvalidResponseException {
        return DeviceInfoHelper.getAllDevicesInfo(passportInfo, arrayList);
    }

    @Deprecated
    public static boolean uploadDeviceInfo(String str, String str2, String str3, String str4, String str5, Map<String, Object> map) throws IOException, AccessDeniedException, InvalidResponseException, CipherException, AuthenticationFailureException {
        return uploadDeviceInfo(new PassportInfo(str, str2, null, str3, str4), str5, map);
    }

    public static boolean uploadDeviceInfo(PassportInfo passportInfo, String str, Map<String, Object> map) throws IOException, AccessDeniedException, InvalidResponseException, CipherException, AuthenticationFailureException {
        return DeviceInfoHelper.uploadDeviceInfo(passportInfo, str, map);
    }

    @Deprecated
    public static void uploadXiaomiUserName(String str, String str2, String str3, String str4, String str5, String str6) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidParameterException {
        uploadXiaomiUserProfile(str, str2, str3, str4, str5, str6, null, null);
    }

    @Deprecated
    public static void uploadXiaomiUserBirthday(String str, String str2, String str3, String str4, String str5, Calendar calendar) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidParameterException {
        uploadXiaomiUserProfile(str, str2, str3, str4, str5, null, calendar, null);
    }

    @Deprecated
    public static void uploadXiaomiUserGender(String str, String str2, String str3, String str4, String str5, Gender gender) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidParameterException {
        uploadXiaomiUserProfile(str, str2, str3, str4, str5, null, null, gender);
    }

    @Deprecated
    public static void uploadXiaomiUserProfile(String str, String str2, String str3, String str4, String str5, String str6, Calendar calendar, Gender gender) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidParameterException {
        uploadXiaomiUserProfile(new PassportInfo(str, str2, str3, str4, str5), new XiaomiUserProfile(str, str6, calendar, gender));
    }

    public static void uploadXiaomiUserProfile(PassportInfo passportInfo, XiaomiUserProfile xiaomiUserProfile) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidParameterException {
        if (passportInfo == null || xiaomiUserProfile == null) {
            throw new IllegalArgumentException("invalid parameter");
        }
        String str = URLs.URL_ACCOUNT_USER_PROFILE;
        Calendar birthday = xiaomiUserProfile.getBirthday();
        String str2 = null;
        EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("sid", passportInfo.getServiceId()).easyPut("transId", UUID.randomUUID().toString().substring(0, 15)).easyPut("userName", xiaomiUserProfile.getUserName()).easyPut("birthday", birthday != null ? new SimpleDateFormat("yyyy-MM-dd").format(birthday.getTime()) : null);
        if (xiaomiUserProfile.getGender() != null) {
            str2 = xiaomiUserProfile.getGender().getType();
        }
        EasyMap easyPut2 = easyPut.easyPut("gender", str2);
        EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
        ProtocolLogHelper.newRequestLog(str, HttpMethod.POST, new String[]{"serviceToken"}).cookieWithMaskOrNull(passportCookie).paramOrNull(easyPut2).log();
        SimpleRequest.MapContent postAsMap = SecureRequestForAccount.postAsMap(str, easyPut2, passportCookie, true, passportInfo.getSecurity());
        ProtocolLogHelper.newResponseLog(str).mapResponseOrNull(postAsMap).log();
        if (postAsMap != null) {
            Integer num = (Integer) postAsMap.getFromBody("code");
            ServerError serverError = new ServerError(postAsMap);
            if (!INT_0.equals(num)) {
                String str3 = (String) postAsMap.getFromBody("description");
                String str4 = "code: " + num + ", desc: " + str3;
                AccountLog.i("XMPassport", "failed to upload xiaomi user info, ".concat(String.valueOf(str4)));
                int intValue = num.intValue();
                if (intValue == 10017) {
                    throw new InvalidParameterException(num.intValue(), str3);
                } else if (intValue != 66108) {
                    throw new InvalidResponseException(str4, serverError);
                } else {
                    throw new InvalidParameterException(num.intValue(), str3);
                }
            }
        } else {
            throw new InvalidResponseException("failed to upload xiaomi user profile");
        }
    }

    @Deprecated
    public static String uploadXiaomiUserIcon(String str, String str2, String str3, String str4, String str5, Bitmap bitmap) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidParameterException {
        return uploadXiaomiUserIcon(new PassportInfo(str, str2, str3, str4, str5), bitmap);
    }

    public static String uploadXiaomiUserIcon(PassportInfo passportInfo, Bitmap bitmap) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidParameterException {
        if (passportInfo == null || bitmap == null) {
            throw new IllegalArgumentException("invalid parameter");
        }
        AccountLog.i("XMPassport", "requestUploadUserIcon start: ");
        String requestUploadUserIcon = requestUploadUserIcon(passportInfo);
        AccountLog.i("XMPassport", "uploadIconToServer start: ");
        JSONObject uploadIconToServer = uploadIconToServer(requestUploadUserIcon, bitmap);
        AccountLog.i("XMPassport", "commitUploadUserIcon start: ");
        return commitUploadUserIcon(passportInfo, uploadIconToServer);
    }

    private static String requestUploadUserIcon(PassportInfo passportInfo) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException {
        String str = URLs.URL_REQUEST_UPDATE_ICON;
        EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("method", "json");
        EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
        ProtocolLogHelper.newRequestLog(str, HttpMethod.GET, new String[]{"serviceToken"}).cookieWithMaskOrNull(passportCookie).paramOrNull(easyPut).log();
        SimpleRequest.MapContent asMap = SecureRequestForAccount.getAsMap(str, easyPut, passportCookie, true, passportInfo.getSecurity());
        ProtocolLogHelper.newResponseLog(str).mapResponseOrNull(asMap).log();
        if (asMap != null) {
            Object fromBody = asMap.getFromBody("code");
            ServerError serverError = new ServerError(asMap);
            if (INT_0.equals(fromBody)) {
                Object fromBody2 = asMap.getFromBody("data");
                if (fromBody2 instanceof Map) {
                    Object obj = ((Map) fromBody2).get("uploadUrl");
                    if (obj != null) {
                        return obj.toString();
                    }
                    throw new InvalidResponseException("uploadUrl is null");
                }
            }
            Object fromBody3 = asMap.getFromBody("description");
            AccountLog.d("XMPassport", "requestUploadUserIcon failed, code: " + fromBody + "; description: " + fromBody3);
            throw new InvalidResponseException("requestUploadUserIcon failed, description: ".concat(String.valueOf(fromBody3)), serverError);
        }
        throw new InvalidResponseException("requestUploadUserIcon request content is null");
    }

    private static JSONObject uploadIconToServer(String str, Bitmap bitmap) throws IOException, InvalidResponseException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ProtocolLogHelper.newRequestLog(str, HttpMethod.POST).log();
        String execute = UploadFileRequest.execute(str, byteArrayInputStream, "userfile", "icon.jpg");
        ProtocolLogHelper.newResponseLog(str).stringResponseOrNull(new SimpleRequest.StringContent(execute)).log();
        try {
            if (!TextUtils.isEmpty(execute)) {
                return new JSONObject(execute);
            }
        } catch (JSONException e) {
            AccountLog.e("XMPassport", "uploadIconToServer error", e);
        }
        throw new InvalidResponseException("upload error: ".concat(String.valueOf(execute)));
    }

    private static String commitUploadUserIcon(PassportInfo passportInfo, JSONObject jSONObject) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidParameterException {
        String str = URLs.URL_COMMIT_UPDATE_ICON;
        EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("sid", passportInfo.getServiceId()).easyPut("transId", UUID.randomUUID().toString().substring(0, 15)).easyPut("json", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
        ProtocolLogHelper.newRequestLog(str, HttpMethod.POST, new String[]{"serviceToken"}).cookieWithMaskOrNull(passportCookie).paramOrNull(easyPut).log();
        SimpleRequest.MapContent postAsMap = SecureRequestForAccount.postAsMap(str, easyPut, passportCookie, true, passportInfo.getSecurity());
        ProtocolLogHelper.newResponseLog(str).mapResponseOrNull(postAsMap).log();
        if (postAsMap != null) {
            Integer num = (Integer) postAsMap.getFromBody("code");
            String str2 = (String) postAsMap.getFromBody("description");
            ServerError serverError = new ServerError(postAsMap);
            AccountLog.d("XMPassport", "commitUploadUserIcon failed, code: " + num + "; description: " + str2);
            int intValue = num.intValue();
            if (intValue == 0) {
                Object fromBody = postAsMap.getFromBody("data");
                if (!(fromBody instanceof Map)) {
                    return null;
                }
                Object obj = ((Map) fromBody).get("downloadUrl");
                if (obj != null) {
                    return obj.toString();
                }
                throw new InvalidResponseException("downloadUrl is null");
            } else if (intValue != 66108) {
                throw new InvalidResponseException(num.intValue(), str2, serverError);
            } else {
                throw new InvalidParameterException(num.intValue(), str2);
            }
        } else {
            throw new InvalidResponseException("commitUploadUserIcon content is null");
        }
    }

    public static String getIdentityAuthUrl(PassportInfo passportInfo, String str, IdentityAuthReason identityAuthReason) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException {
        return getIdentityAuthUrl(passportInfo, str, getUrlForIdentityAuth(identityAuthReason));
    }

    private static String getIdentityAuthUrl(PassportInfo passportInfo, String str, String str2) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException {
        if (passportInfo != null) {
            String substring = UUID.randomUUID().toString().substring(0, 15);
            EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("_json", "true").easyPut("authST", str).easyPut("transId", substring).easyPut("traceId", substring);
            EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
            ProtocolLogHelper.newRequestLog(str2, HttpMethod.GET).paramOrNull(easyPut).cookieOrNull(passportCookie).log();
            SimpleRequest.MapContent asMap = SecureRequestForAccount.getAsMap(str2, easyPut, passportCookie, true, passportInfo.getSecurity());
            ProtocolLogHelper.newResponseLog(str2).mapResponseOrNull(asMap).log();
            if (asMap != null) {
                Object fromBody = asMap.getFromBody("code");
                String str3 = "code: " + fromBody + ", desc: " + asMap.getFromBody("description");
                ServerError serverError = new ServerError(asMap);
                AccountLog.d("XMPassport", "getIdentityAuthUrl".concat(String.valueOf(str3)));
                if (fromBody instanceof Integer) {
                    int intValue = ((Integer) fromBody).intValue();
                    if (intValue == 0) {
                        return null;
                    }
                    if (intValue == 2) {
                        Object fromBody2 = asMap.getFromBody("url");
                        if (fromBody2 != null) {
                            return fromBody2.toString();
                        }
                        throw new InvalidResponseException("identityUrl is null");
                    }
                }
                throw new InvalidResponseException("getIdentityAuthUrl: ".concat(String.valueOf(str3)), serverError);
            }
            throw new IOException("getIdentityAuthUrl result should not be null");
        }
        throw new IllegalArgumentException("passportInfo is null");
    }

    private static String getUrlForIdentityAuth(IdentityAuthReason identityAuthReason) {
        if (identityAuthReason != null) {
            switch (AnonymousClass1.$SwitchMap$com$xiaomi$accountsdk$account$data$IdentityAuthReason[identityAuthReason.ordinal()]) {
                case 1:
                    return URLs.URL_IDENTITY_AUTH_FOR_ADDING_EMAIL;
                case 2:
                    return URLs.URL_IDENTITY_AUTH_FOR_REPLACING_EMAIL;
                case 3:
                    return URLs.URL_IDENTITY_AUTH_FOR_ADDING_PHONE;
                case 4:
                    return URLs.URL_IDENTITY_AUTH_FOR_REPLACING_PHONE;
                case 5:
                    return URLs.URL_IDENTITY_AUTH_FOR_DELETING_PHONE;
                case 6:
                    return URLs.URL_IDENTITY_AUTH_FOR_SEND_EMAIL_ACTIVATE_MESSAGE;
                case 7:
                    return URLs.URL_IDENTITY_AUTH_FOR_SET_SECURITY_QUESTIONS;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    return URLs.URL_IDENTITY_AUTH_FOR_MODIFY_SAFE_PHONE;
                case 9:
                    return URLs.URL_IDENTITY_AUTH_FOR_CHANGE_PWD;
                default:
                    throw new IllegalArgumentException("invalid identityAuthReason");
            }
        } else {
            throw new IllegalArgumentException("identityAuthReason is null");
        }
    }

    private static JSONArray convertSQsToJsonArray(List<SecurityQuestion> list) {
        JSONArray jSONArray = new JSONArray();
        for (SecurityQuestion next : list) {
            if (next != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("q", next.question);
                    jSONObject.put("a", next.answer);
                } catch (JSONException e) {
                    AccountLog.e("XMPassport", "convertSQsToJsonArray", e);
                }
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }

    @Deprecated
    public static void setSecurityQuestions(PassportInfo passportInfo, List<SecurityQuestion> list, String str) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidParameterException {
        if (passportInfo == null || list == null || list.size() == 0) {
            throw new IllegalArgumentException("invalid param");
        }
        String str2 = URLs.URL_SET_SECURITY_QUESTIONS;
        JSONArray convertSQsToJsonArray = convertSQsToJsonArray(list);
        EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("questions", convertSQsToJsonArray != null ? convertSQsToJsonArray.toString() : null).easyPut("sid", passportInfo.getServiceId()).easyPut("authST", str);
        EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
        ProtocolLogHelper.newRequestLog(str2, HttpMethod.POST, new String[]{"serviceToken"}).cookieWithMaskOrNull(passportCookie).paramOrNull(easyPut).log();
        SimpleRequest.MapContent postAsMap = SecureRequestForAccount.postAsMap(str2, easyPut, passportCookie, true, passportInfo.getSecurity());
        ProtocolLogHelper.newResponseLog(str2).mapResponseOrNull(postAsMap).log();
        if (postAsMap != null) {
            Object fromBody = postAsMap.getFromBody("code");
            Object fromBody2 = postAsMap.getFromBody("description");
            if (fromBody instanceof Integer) {
                int intValue = ((Integer) fromBody).intValue();
                if (intValue == 0) {
                    return;
                }
                if (intValue == 10016 || intValue == 10017) {
                    throw new InvalidParameterException("code: " + fromBody + " ;description: " + fromBody2);
                }
            }
            throw new InvalidResponseException("code: " + fromBody + " ;description: " + fromBody2);
        }
        throw new IOException("failed to setSecurityQuestions");
    }

    public static void sendEmailActivateMessage(PassportInfo passportInfo, String str, String str2, String str3, String str4, String str5) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidBindAddressException, NeedCaptchaException, UsedEmailAddressException, ReachLimitException {
        if (passportInfo != null) {
            sendEmailActivateMessage(new SendEmailActMsgParams.Builder().passportInfo(passportInfo).emailAddress(str).deviceId(CloudCoder.hashDeviceInfo(str3)).identityAuthToken(str2).captcha(str4, str5).build());
            return;
        }
        throw new IllegalArgumentException("passportInfo is null");
    }

    public static void sendEmailActivateMessage(SendEmailActMsgParams sendEmailActMsgParams) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidBindAddressException, NeedCaptchaException, UsedEmailAddressException, ReachLimitException {
        if (sendEmailActMsgParams == null || sendEmailActMsgParams.passportInfo == null) {
            throw new IllegalArgumentException("params should not be null!");
        }
        String str = URLs.URL_SEND_EMAIL_ACTIVATE_MESSAGE;
        PassportInfo passportInfo = sendEmailActMsgParams.passportInfo;
        String str2 = sendEmailActMsgParams.email;
        String str3 = sendEmailActMsgParams.deviceId;
        String str4 = sendEmailActMsgParams.identityAuthToken;
        String str5 = sendEmailActMsgParams.captcha;
        String str6 = sendEmailActMsgParams.captIck;
        EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("address", str2).easyPut("sid", passportInfo.getServiceId()).easyPut("deviceId", str3).easyPutOpt("userSpaceId", UserSpaceIdUtil.getNullableUserSpaceIdCookie()).easyPut("authST", str4).easyPut("icode", str5);
        EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
        passportCookie.easyPut("ick", str6);
        ProtocolLogHelper.newRequestLog(str, HttpMethod.POST, new String[]{"address", "serviceToken"}).paramWithMaskOrNull(easyPut).cookieWithMaskOrNull(passportCookie).log();
        SimpleRequest.MapContent postAsMap = SecureRequestForAccount.postAsMap(str, easyPut, passportCookie, true, passportInfo.getSecurity());
        ProtocolLogHelper.newResponseLog(str).mapResponseOrNull(postAsMap).log();
        if (postAsMap != null) {
            Integer num = (Integer) postAsMap.getFromBody("code");
            String str7 = (String) postAsMap.getFromBody("description");
            String str8 = "code: " + num + " ;description: " + str7;
            ServerError serverError = new ServerError(postAsMap);
            switch (num.intValue()) {
                case 0:
                    break;
                case 20031:
                case 87001:
                    throw new NeedCaptchaException(num.intValue(), str7, (String) postAsMap.getFromBody("info"));
                case 70006:
                    throw new InvalidBindAddressException(str8);
                case 70013:
                case 70021:
                    throw new UsedEmailAddressException(str8);
                case 70022:
                    throw new ReachLimitException(str8);
                default:
                    throw new InvalidResponseException(num.intValue(), str8, serverError);
            }
            return;
        }
        throw new IOException("failed to checkAvailabilityOfBindingEmail");
    }

    @Deprecated
    public static boolean checkEmailAvailabilityForBinding(PassportInfo passportInfo, String str, String str2, String str3) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidBindAddressException, NeedCaptchaException {
        if (passportInfo != null) {
            String str4 = URLs.URL_CHECK_SAFE_EMAIL_AVAILABILITY;
            EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("address", str).easyPut("icode", str2);
            EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
            passportCookie.easyPut("ick", str3);
            ProtocolLogHelper.newRequestLog(str4, HttpMethod.POST, new String[]{"address", "serviceToken"}).paramWithMaskOrNull(easyPut).cookieWithMaskOrNull(passportCookie).log();
            SimpleRequest.MapContent postAsMap = SecureRequestForAccount.postAsMap(str4, easyPut, passportCookie, true, passportInfo.getSecurity());
            ProtocolLogHelper.newResponseLog(str4).mapResponseOrNull(postAsMap).log();
            if (postAsMap != null) {
                int intValue = ((Integer) postAsMap.getFromBody("code")).intValue();
                String str5 = (String) postAsMap.getFromBody("description");
                if (intValue == 0) {
                    return true;
                }
                if (intValue == 70006) {
                    throw new InvalidBindAddressException("code: " + intValue + " ;description: " + str5);
                } else if (intValue == 70013 || intValue == 70021) {
                    return false;
                } else {
                    if (intValue != 87001) {
                        throw new InvalidResponseException(intValue, str5);
                    }
                    throw new NeedCaptchaException(intValue, str5, null);
                }
            } else {
                throw new IOException("failed to checkAvailabilityOfBindingEmail");
            }
        } else {
            throw new IllegalArgumentException("passportInfo is null");
        }
    }

    @Deprecated
    public static void sendVerifyCodeForBindingPhoneOrEmail(PassportInfo passportInfo, String str, BindingType bindingType) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidBindAddressException, SendVerifyCodeExceedLimitException {
        if (bindingType != null) {
            sendVerifyCode(passportInfo, str, bindingType.isBindingEmail() ? URLs.URL_SEND_BIND_EMAIL_VERIFY_CODE : URLs.URL_SEND_BIND_PHONE_VERIFY_CODE);
            return;
        }
        throw new IllegalArgumentException("type is null");
    }

    private static void sendVerifyCode(PassportInfo passportInfo, String str, String str2) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidBindAddressException, SendVerifyCodeExceedLimitException {
        if (passportInfo != null) {
            EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("address", str);
            easyPut.putAll(XMPassportUtil.getDefaultLocaleParam());
            EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
            ProtocolLogHelper.newRequestLog(str2, HttpMethod.POST, new String[]{"address", "serviceToken"}).paramWithMaskOrNull(easyPut).cookieWithMaskOrNull(passportCookie).log();
            SimpleRequest.MapContent postAsMap = SecureRequestForAccount.postAsMap(str2, easyPut, passportCookie, true, passportInfo.getSecurity());
            ProtocolLogHelper.newResponseLog(str2).mapResponseOrNull(postAsMap).log();
            if (postAsMap != null) {
                Object fromBody = postAsMap.getFromBody("code");
                Object fromBody2 = postAsMap.getFromBody("description");
                if (fromBody instanceof Integer) {
                    int intValue = ((Integer) fromBody).intValue();
                    if (intValue == 0) {
                        return;
                    }
                    if (intValue == 70006 || intValue == 70008) {
                        throw new InvalidBindAddressException("code: " + fromBody + " ;description: " + fromBody2);
                    } else if (intValue == 70022) {
                        throw new SendVerifyCodeExceedLimitException("code: " + fromBody + " ;description: " + fromBody2);
                    }
                }
                throw new InvalidResponseException("code: " + fromBody + "; description: " + fromBody2);
            }
            throw new IOException("failed to sendVerifyCode");
        }
        throw new IllegalArgumentException("passportInfo is null");
    }

    @Deprecated
    public static String updateBindedPhoneOrEmail(PassportInfo passportInfo, String str, BindingType bindingType, String str2, String str3, String str4) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidVerifyCodeException, InvalidBindAddressException, UserRestrictedException {
        return updateBindedPhoneOrEmail(passportInfo, getUrlForBindingPhoneOrEmail(bindingType), generateUpdateBindingParams(passportInfo, str, bindingType, str2, str3, str4));
    }

    /* renamed from: com.xiaomi.accountsdk.account.XMPassport$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaomi$accountsdk$account$data$BindingType = new int[BindingType.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$xiaomi$accountsdk$account$data$IdentityAuthReason = new int[IdentityAuthReason.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|(3:33|34|36)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(31:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0066 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0087 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0093 */
        static {
            try {
                $SwitchMap$com$xiaomi$accountsdk$account$data$BindingType[BindingType.ADD_SAFE_EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$xiaomi$accountsdk$account$data$BindingType[BindingType.REPLACE_SAFE_EMAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$xiaomi$accountsdk$account$data$BindingType[BindingType.ADD_PHONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$xiaomi$accountsdk$account$data$BindingType[BindingType.REPLACE_PHONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $SwitchMap$com$xiaomi$accountsdk$account$data$IdentityAuthReason[IdentityAuthReason.ADD_SAFE_EMAIL.ordinal()] = 1;
            $SwitchMap$com$xiaomi$accountsdk$account$data$IdentityAuthReason[IdentityAuthReason.REPLACE_SAFE_EMAIL.ordinal()] = 2;
            $SwitchMap$com$xiaomi$accountsdk$account$data$IdentityAuthReason[IdentityAuthReason.ADD_PHONE.ordinal()] = 3;
            $SwitchMap$com$xiaomi$accountsdk$account$data$IdentityAuthReason[IdentityAuthReason.REPLACE_PHONE.ordinal()] = 4;
            $SwitchMap$com$xiaomi$accountsdk$account$data$IdentityAuthReason[IdentityAuthReason.DELETE_PHONE.ordinal()] = 5;
            $SwitchMap$com$xiaomi$accountsdk$account$data$IdentityAuthReason[IdentityAuthReason.SEND_EMAIL_ACTIVATE_MESSAGE.ordinal()] = 6;
            $SwitchMap$com$xiaomi$accountsdk$account$data$IdentityAuthReason[IdentityAuthReason.SET_SECURITY_QUESTIONS.ordinal()] = 7;
            $SwitchMap$com$xiaomi$accountsdk$account$data$IdentityAuthReason[IdentityAuthReason.MODIFY_SAFE_PHONE.ordinal()] = 8;
            try {
                $SwitchMap$com$xiaomi$accountsdk$account$data$IdentityAuthReason[IdentityAuthReason.CHANGE_PASSWORD.ordinal()] = 9;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static String getUrlForBindingPhoneOrEmail(BindingType bindingType) {
        if (bindingType != null) {
            int i = AnonymousClass1.$SwitchMap$com$xiaomi$accountsdk$account$data$BindingType[bindingType.ordinal()];
            if (i == 1) {
                return URLs.URL_ADD_BIND_EMAIL;
            }
            if (i == 2) {
                return URLs.URL_REPLACE_BIND_EMAIL;
            }
            if (i == 3) {
                return URLs.URL_ADD_BIND_PHONE;
            }
            if (i == 4) {
                return URLs.URL_REPLACE_BIND_PHONE;
            }
            throw new IllegalArgumentException("invalid bindingType");
        }
        throw new IllegalArgumentException("bindingType is null");
    }

    private static EasyMap<String, String> generateUpdateBindingParams(PassportInfo passportInfo, String str, BindingType bindingType, String str2, String str3, String str4) {
        if (bindingType != null) {
            EasyMap<String, String> easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("sid", passportInfo.getServiceId()).easyPut("vkey", str2).easyPut("authST", str3);
            if (bindingType == BindingType.REPLACE_PHONE) {
                easyPut.easyPut("oldAuthPhone", str4).easyPut("newAuthPhone", str);
            } else {
                easyPut.easyPut("address", str);
            }
            return easyPut;
        }
        throw new IllegalArgumentException("type is null");
    }

    private static String updateBindedPhoneOrEmail(PassportInfo passportInfo, String str, EasyMap<String, String> easyMap) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidVerifyCodeException, InvalidBindAddressException, UserRestrictedException {
        if (passportInfo != null) {
            EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
            ProtocolLogHelper.newRequestLog(str, HttpMethod.POST, new String[]{"serviceToken"}).cookieWithMaskOrNull(passportCookie).paramOrNull(easyMap).log();
            SimpleRequest.MapContent postAsMap = SecureRequestForAccount.postAsMap(str, easyMap, passportCookie, true, passportInfo.getSecurity());
            ProtocolLogHelper.newResponseLog(str).mapResponseOrNull(postAsMap).log();
            if (postAsMap != null) {
                Object fromBody = postAsMap.getFromBody("code");
                Object fromBody2 = postAsMap.getFromBody("description");
                if (fromBody instanceof Integer) {
                    int intValue = ((Integer) fromBody).intValue();
                    if (intValue == 0) {
                        Object fromBody3 = postAsMap.getFromBody("data");
                        if (fromBody3 instanceof Map) {
                            Object obj = ((Map) fromBody3).get("address");
                            if (obj != null) {
                                return obj.toString();
                            }
                            throw new InvalidResponseException("address is null");
                        }
                    } else if (intValue == 20023) {
                        throw new UserRestrictedException();
                    } else if (!(intValue == 70006 || intValue == 70008)) {
                        if (intValue == 70014) {
                            throw new InvalidVerifyCodeException("code: " + fromBody + "; description: " + fromBody2);
                        }
                    }
                    throw new InvalidBindAddressException("code: " + fromBody + " ;description: " + fromBody2);
                }
                throw new InvalidResponseException("code: " + fromBody + "; description: " + fromBody2);
            }
            throw new IOException("failed to updateBindedPhoneOrEmail");
        }
        throw new IllegalArgumentException("passportInfo is null");
    }

    @Deprecated
    public static void deleteBindedPhone(PassportInfo passportInfo, String str, String str2) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidBindAddressException, DeleteSafeAddressException {
        if (passportInfo != null) {
            String str3 = URLs.URL_DELETE_BIND_PHONE;
            EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("sid", passportInfo.getServiceId()).easyPut("address", str).easyPut("authST", str2);
            EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
            ProtocolLogHelper.newRequestLog(str3, HttpMethod.POST, new String[]{"address", "serviceToken"}).paramOrNull(easyPut).cookieOrNull(passportCookie).log();
            SimpleRequest.MapContent postAsMap = SecureRequestForAccount.postAsMap(str3, easyPut, passportCookie, true, passportInfo.getSecurity());
            ProtocolLogHelper.newResponseLog(str3).mapResponseOrNull(postAsMap).log();
            if (postAsMap != null) {
                Object fromBody = postAsMap.getFromBody("code");
                Object fromBody2 = postAsMap.getFromBody("description");
                if (fromBody instanceof Integer) {
                    int intValue = ((Integer) fromBody).intValue();
                    if (intValue == 0) {
                        return;
                    }
                    if (intValue == 25009) {
                        throw new DeleteSafeAddressException("code: " + fromBody + " ;description: " + fromBody2);
                    } else if (intValue == 70008) {
                        throw new InvalidBindAddressException("code: " + fromBody + " ;description: " + fromBody2);
                    }
                }
                throw new InvalidResponseException("code: " + fromBody + "; description: " + fromBody2);
            }
            throw new IOException("failed to deleteBindedPhone");
        }
        throw new IllegalArgumentException("passportInfo is null");
    }

    @Deprecated
    public static String checkPhoneActivateStatus(PassportInfo passportInfo, String str, String str2, String str3) throws InvalidResponseException, CipherException, IOException, AuthenticationFailureException, AccessDeniedException, InvalidBindAddressException {
        if (passportInfo != null) {
            String str4 = URLs.URL_CHECK_PHONE_ACTIVATE_STATUS;
            EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("address", str).easyPut("simId", CloudCoder.hashDeviceInfo(str2)).easyPutOpt("userSpaceId", UserSpaceIdUtil.getNullableUserSpaceIdCookie()).easyPut("deviceId", CloudCoder.hashDeviceInfo(str3));
            EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
            ProtocolLogHelper.newRequestLog(str4, HttpMethod.POST, new String[]{"address", "serviceToken"}).paramWithMaskOrNull(easyPut).cookieWithMaskOrNull(passportCookie).log();
            SimpleRequest.MapContent postAsMap = SecureRequestForAccount.postAsMap(str4, easyPut, passportCookie, true, passportInfo.getSecurity());
            ProtocolLogHelper.newResponseLog(str4).mapResponseOrNull(postAsMap).log();
            if (postAsMap != null) {
                Object fromBody = postAsMap.getFromBody("code");
                Object fromBody2 = postAsMap.getFromBody("description");
                if (fromBody instanceof Integer) {
                    int intValue = ((Integer) fromBody).intValue();
                    if (intValue == 0) {
                        Object fromBody3 = postAsMap.getFromBody("data");
                        if (!(fromBody3 instanceof Map)) {
                            return null;
                        }
                        Object obj = ((Map) fromBody3).get("key");
                        if (obj != null) {
                            return obj.toString();
                        }
                        throw new InvalidResponseException("key is null");
                    } else if (intValue == 10017) {
                        return null;
                    } else {
                        if (intValue == 70008) {
                            throw new InvalidBindAddressException("code: " + fromBody + " ;description: " + fromBody2);
                        }
                    }
                }
                throw new InvalidResponseException("code: " + fromBody + "; description: " + fromBody2);
            }
            throw new IOException("failed to checkPhoneActivateStatus");
        }
        throw new IllegalArgumentException("passportInfo is null");
    }

    public static void changePassword(PassportInfo passportInfo, String str, String str2, String str3, String str4) throws AccessDeniedException, AuthenticationFailureException, InvalidResponseException, CipherException, IOException, NeedCaptchaException, UserRestrictedException, InvalidParameterException, InvalidCredentialException {
        if (passportInfo != null) {
            String str5 = URLs.URL_CHANGE_PASSWORD;
            EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("oldPassword", str).easyPut("password", str2).easyPut("icode", str3);
            EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
            passportCookie.easyPut("ick", str4);
            ProtocolLogHelper.newRequestLog(str5, HttpMethod.POST, new String[]{"oldPassword", "password", "serviceToken"}).paramWithMaskOrNull(easyPut).cookieWithMaskOrNull(passportCookie).log();
            SimpleRequest.MapContent postAsMap = SecureRequestForAccount.postAsMap(str5, easyPut, passportCookie, true, passportInfo.getSecurity());
            ProtocolLogHelper.newResponseLog(str5).mapResponseOrNull(postAsMap).log();
            if (postAsMap != null) {
                int intValue = ((Integer) postAsMap.getFromBody("code")).intValue();
                String str6 = (String) postAsMap.getFromBody("description");
                String str7 = "code: " + intValue + " ;description: " + str6;
                if (intValue != 0) {
                    if (intValue != 10017) {
                        if (intValue != 20023) {
                            if (intValue != 20031) {
                                if (intValue == 70001) {
                                    throw new InvalidCredentialException(intValue, str7, true);
                                } else if (intValue != 70003) {
                                    if (intValue != 87001) {
                                        throw new InvalidResponseException(intValue, str6);
                                    }
                                }
                            }
                            throw new NeedCaptchaException(intValue, str6, (String) postAsMap.getFromBody("info"));
                        }
                        throw new UserRestrictedException();
                    }
                    throw new InvalidParameterException(str7);
                }
                return;
            }
            throw new IOException("failed to changePassword");
        }
        throw new IllegalArgumentException("passportInfo is null");
    }

    private static EasyMap<String, String> getPassportCookie(PassportInfo passportInfo) {
        if (passportInfo != null) {
            EasyMap<String, String> easyPut = new EasyMap().easyPut("serviceToken", passportInfo.getServiceToken());
            if (TextUtils.isEmpty(passportInfo.getEncryptedUserId())) {
                easyPut.easyPut("userId", passportInfo.getUserId());
            } else {
                easyPut.easyPut("cUserId", passportInfo.getEncryptedUserId());
            }
            easyPut.easyPut("uLocale", Locale.getDefault().toString());
            return easyPut;
        }
        throw new IllegalArgumentException("passportInfo is null");
    }

    public static HashMap<String, DeviceModelInfo> getDeviceModelInfos(ArrayList<String> arrayList) throws AccessDeniedException, AuthenticationFailureException, IOException, InvalidResponseException {
        return DeviceInfoHelper.getDeviceModelInfos(arrayList);
    }

    public static void setUserRegion(PassportInfo passportInfo, String str, String str2) throws AccessDeniedException, AuthenticationFailureException, InvalidResponseException, CipherException, IOException, InvalidParameterException {
        if (passportInfo != null) {
            processPostSecureRequestForSetUserInfo(URLs.URL_SET_USER_REGION, new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("region", str).easyPut("sid", str2).easyPut("transId", UUID.randomUUID().toString().substring(0, 15)), getPassportCookie(passportInfo), true, passportInfo.getSecurity());
            return;
        }
        throw new IllegalArgumentException("null passport info");
    }

    public static void setUserLocation(PassportInfo passportInfo, String str, String str2, String str3) throws InvalidParameterException, CipherException, IOException, InvalidResponseException, AccessDeniedException, AuthenticationFailureException {
        if (passportInfo != null) {
            processPostSecureRequestForSetUserInfo(URLs.URL_SET_USER_LOCATION, new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("region", str).easyPut("location", str2).easyPut("sid", str3).easyPut("transId", UUID.randomUUID().toString().substring(0, 15)), getPassportCookie(passportInfo), true, passportInfo.getSecurity());
            return;
        }
        throw new IllegalArgumentException("null passport info");
    }

    public static void setUserEducation(PassportInfo passportInfo, XiaomiUserCoreInfo.Education education, String str) throws InvalidParameterException, CipherException, IOException, InvalidResponseException, AccessDeniedException, AuthenticationFailureException {
        if (passportInfo == null || education == null) {
            throw new IllegalArgumentException("invalid params");
        }
        processPostSecureRequestForSetUserInfo(URLs.URL_SET_USER_EDUCATION, new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("education", education.level).easyPut("sid", str).easyPut("transId", UUID.randomUUID().toString().substring(0, 15)), getPassportCookie(passportInfo), true, passportInfo.getSecurity());
    }

    public static void setUserIncome(PassportInfo passportInfo, XiaomiUserCoreInfo.Income income, String str) throws InvalidParameterException, CipherException, IOException, InvalidResponseException, AccessDeniedException, AuthenticationFailureException {
        if (passportInfo == null || income == null) {
            throw new IllegalArgumentException("invalid params");
        }
        processPostSecureRequestForSetUserInfo(URLs.URL_SET_USER_INCOME, new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("income", income.level).easyPut("sid", str).easyPut("transId", UUID.randomUUID().toString().substring(0, 15)), getPassportCookie(passportInfo), true, passportInfo.getSecurity());
    }

    private static void processPostSecureRequestForSetUserInfo(String str, Map<String, String> map, Map<String, String> map2, boolean z, String str2) throws AccessDeniedException, AuthenticationFailureException, InvalidResponseException, CipherException, IOException, InvalidParameterException {
        ProtocolLogHelper.newRequestLog(str, HttpMethod.POST, new String[]{"serviceToken"}).cookieWithMaskOrNull(map2).paramWithMaskOrNull(map).log();
        SimpleRequest.MapContent postAsMap = SecureRequestForAccount.postAsMap(str, map, map2, z, str2);
        ProtocolLogHelper.newResponseLog(str).mapResponseOrNull(postAsMap).log();
        if (postAsMap != null) {
            Object fromBody = postAsMap.getFromBody("code");
            Object fromBody2 = postAsMap.getFromBody("description");
            if (fromBody instanceof Integer) {
                int intValue = ((Integer) fromBody).intValue();
                if (intValue == 0) {
                    return;
                }
                if (intValue == 10016 || intValue == 10017) {
                    throw new InvalidParameterException(fromBody2 != null ? fromBody2.toString() : "invalid params");
                }
            }
            throw new InvalidResponseException("code: " + fromBody + "description: " + fromBody2);
        }
        throw new InvalidResponseException("invalid response content");
    }

    public static XiaomiUserCoreInfo getXiaomiUserCoreInfo(PassportInfo passportInfo, String str, List<XiaomiUserCoreInfo.Flag> list) throws AccessDeniedException, AuthenticationFailureException, InvalidResponseException, CipherException, IOException {
        int i;
        if (passportInfo != null) {
            if (list != null) {
                i = 0;
                for (XiaomiUserCoreInfo.Flag flag : list) {
                    i |= flag.value;
                }
            } else {
                i = 0;
            }
            String substring = UUID.randomUUID().toString().substring(0, 15);
            String str2 = URLs.URL_GET_USER_CORE_INFO;
            EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("sid", str).easyPut("transId", substring);
            if (i != 0) {
                easyPut.easyPut("flags", String.valueOf(i));
            }
            EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
            ProtocolLogHelper.newRequestLog(str2, HttpMethod.GET, new String[]{"serviceToken"}).cookieWithMaskOrNull(passportCookie).paramWithMaskOrNull(easyPut).log();
            SimpleRequest.MapContent asMap = SecureRequestForAccount.getAsMap(str2, easyPut, passportCookie, true, passportInfo.getSecurity());
            ProtocolLogHelper.newResponseLog(str2).mapResponseOrNull(asMap).log();
            return processCoreInfoContent(passportInfo.getUserId(), asMap);
        }
        throw new IllegalArgumentException("passportInfo is null");
    }

    public static JSONObject getXiaomiUserStatus(PassportInfo passportInfo, String str, String str2) throws AccessDeniedException, AuthenticationFailureException, InvalidResponseException, CipherException, IOException {
        if (passportInfo == null) {
            throw new IllegalArgumentException("passportInfo is null");
        } else if (!TextUtils.isEmpty(str2)) {
            EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("sid", str).easyPut("transId", UUID.randomUUID().toString().substring(0, 15));
            easyPut.easyPut("securityFlag", str2);
            EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
            ProtocolLogHelper.newRequestLog("https://account.xiaomi.com/pass2/user/status", HttpMethod.GET, new String[]{"serviceToken"}).cookieWithMaskOrNull(passportCookie).paramWithMaskOrNull(easyPut).log();
            SimpleRequest.StringContent asString = SimpleRequestForAccount.getAsString("https://account.xiaomi.com/pass2/user/status", easyPut, passportCookie, true);
            ProtocolLogHelper.newResponseLog("https://account.xiaomi.com/pass2/user/status").stringResponseOrNull(asString).log();
            return processJsonContent(asString).getJsonContent();
        } else {
            throw new IllegalArgumentException("securityFlag is empty");
        }
    }

    public static boolean modifyUserTwoFactorAuthType(PassportInfo passportInfo, String str, String str2) throws AccessDeniedException, AuthenticationFailureException, IOException, InvalidResponseException {
        if (passportInfo == null) {
            throw new IllegalArgumentException("passportInfo is null");
        } else if (!TextUtils.isEmpty(str2)) {
            EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPut("type", str2).easyPut("transId", UUID.randomUUID().toString().substring(0, 15));
            EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
            ProtocolLogHelper.newRequestLog("https://account.xiaomi.com/pass2/modify/twoFactorAuthType/status", HttpMethod.POST, new String[]{"serviceToken"}).cookieWithMaskOrNull(passportCookie).paramWithMaskOrNull(easyPut).log();
            SimpleRequest.StringContent postAsString = SimpleRequestForAccount.postAsString("https://account.xiaomi.com/pass2/modify/twoFactorAuthType/status", easyPut, passportCookie, true);
            ProtocolLogHelper.newResponseLog("https://account.xiaomi.com/pass2/modify/twoFactorAuthType/status").stringResponseOrNull(postAsString).log();
            int resultCode = processJsonContent(postAsString).getResultCode();
            AccountLog.i("XMPassport", "modifyUserTwoFactorAuthType: code=".concat(String.valueOf(resultCode)));
            if (resultCode == 0) {
                return true;
            }
            return false;
        } else {
            throw new IllegalArgumentException("authMethod is empty");
        }
    }

    static class GeneralJsonResult {
        private final JSONObject jsonContent;
        private final int resultCode;

        GeneralJsonResult(JSONObject jSONObject) {
            this.jsonContent = jSONObject;
            this.resultCode = jSONObject.optInt("code", -1);
        }

        public JSONObject getJsonContent() {
            return this.jsonContent;
        }

        public int getResultCode() {
            return this.resultCode;
        }
    }

    private static GeneralJsonResult processJsonContent(SimpleRequest.StringContent stringContent) throws IOException, InvalidResponseException {
        try {
            GeneralJsonResult generalJsonResult = new GeneralJsonResult(new JSONObject(removeSafePrefixAndGetRealBody(stringContent)));
            if (generalJsonResult.getResultCode() == 0) {
                return generalJsonResult;
            }
            throw new InvalidResponseException(stringContent.toString());
        } catch (JSONException e) {
            AccountLog.e("XMPassport", "JSON ERROR", e);
            throw new InvalidResponseException(e.getMessage());
        }
    }

    private static XiaomiUserCoreInfo processCoreInfoContent(String str, SimpleRequest.MapContent mapContent) throws InvalidResponseException {
        if (mapContent != null) {
            Object fromBody = mapContent.getFromBody("code");
            if (INT_0.equals(fromBody)) {
                XiaomiUserCoreInfo.Builder builder = new XiaomiUserCoreInfo.Builder(str);
                Object fromBody2 = mapContent.getFromBody("data");
                if (fromBody2 instanceof Map) {
                    Map map = (Map) fromBody2;
                    Object obj = map.get("userName");
                    if (obj instanceof String) {
                        builder.setUserName((String) obj);
                    }
                    Object obj2 = map.get("icon");
                    if (obj2 instanceof String) {
                        String str2 = (String) obj2;
                        int lastIndexOf = str2.lastIndexOf(".");
                        if (str2.length() > 0 && lastIndexOf > 0) {
                            String substring = str2.substring(0, lastIndexOf);
                            String substring2 = str2.substring(str2.lastIndexOf("."));
                            builder.setAvatarAddress(substring + "_320" + substring2);
                        }
                    }
                    Object obj3 = map.get("sns");
                    if (obj3 instanceof List) {
                        builder.setSnsInfoList(XiaomiUserCoreInfo.SnsInfo.parseSnsList((List) obj3));
                    }
                    Object obj4 = map.get("userAddresses");
                    if (obj4 instanceof List) {
                        ArrayList arrayList = new ArrayList();
                        for (Object next : (List) obj4) {
                            if (next instanceof Map) {
                                Map map2 = (Map) next;
                                Object obj5 = map2.get("addressType");
                                Object obj6 = map2.get("address");
                                Object obj7 = map2.get("flags");
                                if ((obj5 instanceof Integer) && (obj6 instanceof String)) {
                                    Integer num = (Integer) obj5;
                                    String str3 = (String) obj6;
                                    Integer num2 = INT_0;
                                    if (obj7 instanceof Integer) {
                                        num2 = (Integer) obj7;
                                    }
                                    boolean z = (num2.intValue() & 2) != 0;
                                    int intValue = num.intValue();
                                    if (intValue != 1) {
                                        if (intValue != 2) {
                                            if (intValue == 9) {
                                                int lastIndexOf2 = str3.lastIndexOf("@ALIAS");
                                                if (lastIndexOf2 > 0) {
                                                    str3 = str3.substring(0, lastIndexOf2);
                                                }
                                                builder.setNickName(str3);
                                            }
                                        } else if (z) {
                                            builder.setEmailAddress(str3);
                                        }
                                    } else if (z) {
                                        builder.setSafePhone(str3);
                                        arrayList.add(0, str3);
                                    } else if (num2.intValue() == 8) {
                                        arrayList.add(str3);
                                    }
                                }
                            }
                        }
                        builder.setPhoneList(arrayList);
                    }
                    Object obj8 = map.get("birthday");
                    if ((obj8 instanceof String) && !TextUtils.isEmpty((String) obj8)) {
                        Calendar instance = Calendar.getInstance();
                        try {
                            instance.setTime(new SimpleDateFormat("yyyy-MM-dd").parse((String) obj8));
                            builder.setBirthday(instance);
                        } catch (ParseException e) {
                            AccountLog.e("XMPassport", "getXiaomiUserProfile", e);
                        }
                    }
                    Object obj9 = map.get("gender");
                    if (obj9 instanceof String) {
                        String str4 = (String) obj9;
                        if (!TextUtils.isEmpty(str4)) {
                            if ("m".equals(str4)) {
                                builder.setGender(Gender.MALE);
                            } else if ("f".equals(str4)) {
                                builder.setGender(Gender.FEMALE);
                            }
                        }
                    }
                    Object obj10 = map.get("isSetSafeQuestions");
                    if (obj10 != null && (obj10 instanceof Boolean)) {
                        builder.setIsSetSafeQuestions(((Boolean) obj10).booleanValue());
                    }
                    Object obj11 = map.get("locale");
                    if (obj11 instanceof String) {
                        String str5 = (String) obj11;
                        if (!TextUtils.isEmpty(str5)) {
                            builder.setLocale(str5);
                        }
                    }
                    Object obj12 = map.get("region");
                    if (obj12 instanceof String) {
                        String str6 = (String) obj12;
                        if (!TextUtils.isEmpty(str6)) {
                            builder.setRegion(str6);
                        }
                    }
                    Object obj13 = map.get("location");
                    if (obj13 != null && (obj13 instanceof String)) {
                        builder.setLocationZipCode((String) obj13);
                    }
                    Object obj14 = map.get("education");
                    if (obj14 instanceof String) {
                        String str7 = (String) obj14;
                        if (!TextUtils.isEmpty(str7)) {
                            XiaomiUserCoreInfo.Education educationTypeByName = XiaomiUserCoreInfo.Education.getEducationTypeByName(str7);
                            if (educationTypeByName != null) {
                                builder.setEducation(educationTypeByName);
                            } else {
                                throw new InvalidResponseException("invalid education value: ".concat(String.valueOf(obj14)));
                            }
                        }
                    }
                    Object obj15 = map.get("income");
                    if (obj15 instanceof String) {
                        String str8 = (String) obj15;
                        if (!TextUtils.isEmpty(str8)) {
                            XiaomiUserCoreInfo.Income incomeTypeByName = XiaomiUserCoreInfo.Income.getIncomeTypeByName(str8);
                            if (incomeTypeByName != null) {
                                builder.setIncome(incomeTypeByName);
                            } else {
                                throw new InvalidResponseException("invalid income value: ".concat(String.valueOf(obj15)));
                            }
                        }
                    }
                }
                return builder.build();
            }
            Object fromBody3 = mapContent.getFromBody("description");
            throw new InvalidResponseException("code: " + fromBody + "; description: " + fromBody3);
        }
        throw new InvalidResponseException("result content is null");
    }

    public static String generateRandomPasswordFromServer() throws AccessDeniedException, AuthenticationFailureException, IOException, InvalidResponseException {
        String str = URLs.URL_GENERATE_RANDOM_PASSWORD;
        ProtocolLogHelper.newRequestLog(str, HttpMethod.GET).log();
        SimpleRequest.StringContent asString = SimpleRequestForAccount.getAsString(str, null, null, true);
        ProtocolLogHelper.newResponseLog(str, new String[]{"pwd"}).jsonResponseWithMaskOrNull(asString).log();
        if (asString != null) {
            try {
                JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody(asString));
                if (jSONObject.getInt("code") == 0) {
                    return new JSONObject(jSONObject.getString("data")).optString("pwd");
                }
                throw new InvalidResponseException(asString.toString());
            } catch (JSONException e) {
                AccountLog.e("XMPassport", "JSON ERROR", e);
                throw new InvalidResponseException(e.getMessage());
            }
        } else {
            throw new InvalidResponseException("result content is null");
        }
    }

    public static int sendPhoneLoginTicket(SendPhoneTicketParams sendPhoneTicketParams) throws AccessDeniedException, AuthenticationFailureException, IOException, InvalidResponseException, NeedCaptchaException, ReachLimitException, TokenExpiredException, InvalidPhoneNumException {
        if (sendPhoneTicketParams != null) {
            String str = URLs.URL_ACCOUNT_BASE + "/sendServiceLoginTicket";
            EasyMap easyPut = new EasyMap().easyPutOpt("user", sendPhoneTicketParams.phone).easyPutOpt("userHash", sendPhoneTicketParams.phoneHash).easyPutOpt("sid", sendPhoneTicketParams.serviceId).easyPutOpt("captCode", sendPhoneTicketParams.captCode).easyPut("_json", "true");
            easyPut.putAll(XMPassportUtil.getDefaultLocaleParam());
            EasyMap easyPutOpt = new EasyMap().easyPutOpt("activatorToken", sendPhoneTicketParams.activatorToken).easyPutOpt("ick", sendPhoneTicketParams.captIck).easyPutOpt("vToken", sendPhoneTicketParams.token).easyPutOpt("vAction", sendPhoneTicketParams.action);
            addDeviceIdInCookies(easyPutOpt, sendPhoneTicketParams.deviceId);
            ProtocolLogHelper.newRequestLog(str, HttpMethod.POST, new String[]{"user", "userHash", "activatorToken"}).paramWithMaskOrNull(easyPut).cookieWithMaskOrNull(easyPutOpt).log();
            SimpleRequest.StringContent postAsString = SimpleRequestForAccount.postAsString(str, easyPut, easyPutOpt, true);
            ProtocolLogHelper.newResponseLog(str).stringResponseOrNull(postAsString).log();
            if (postAsString != null) {
                try {
                    JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody(postAsString));
                    int i = jSONObject.getInt("code");
                    String optString = jSONObject.optString("description");
                    ServerError serverError = new ServerError(jSONObject);
                    String str2 = "code: " + i + ", desc: " + optString;
                    AccountLog.i("XMPassport", "sendPhoneLoginTicket: ".concat(String.valueOf(str2)));
                    if (i == 0) {
                        return jSONObject.getJSONObject("data").optInt("vCodeLen");
                    }
                    if (i == 21317) {
                        throw new TokenExpiredException(str2);
                    } else if (i == 70008) {
                        throw new InvalidPhoneNumException(optString);
                    } else if (i == 70022) {
                        throw new ReachLimitException(str2);
                    } else if (i != 87001) {
                        throw new InvalidResponseException(i, optString, serverError);
                    } else {
                        throw new NeedCaptchaException(i, optString, jSONObject.getString("captchaUrl"));
                    }
                } catch (JSONException unused) {
                    throw new InvalidResponseException("result not json");
                }
            } else {
                throw new InvalidResponseException("result content is null");
            }
        } else {
            throw new IllegalArgumentException("send phone ticket params is null");
        }
    }

    public static RegisterUserInfo queryPhoneUserInfo(QueryPhoneInfoParams queryPhoneInfoParams) throws AccessDeniedException, AuthenticationFailureException, IOException, InvalidResponseException, InvalidVerifyCodeException, InvalidPhoneNumException {
        if (queryPhoneInfoParams != null) {
            String str = URLs.URL_ACCOUNT_BASE + "/phoneInfo";
            EasyMap easyPut = new EasyMap().easyPutOpt("user", queryPhoneInfoParams.phone).easyPutOpt("ticket", queryPhoneInfoParams.ticket).easyPutOpt("userHash", queryPhoneInfoParams.phoneHash).easyPutOpt("sid", queryPhoneInfoParams.serviceId).easyPut("_json", "true");
            EasyMap easyPutOpt = new EasyMap().easyPutOpt("activatorToken", queryPhoneInfoParams.activatorToken);
            addDeviceIdInCookies(easyPutOpt, queryPhoneInfoParams.deviceId);
            ProtocolLogHelper.newRequestLog(str, HttpMethod.POST, new String[]{"user", "ticket", "userHash", "activatorToken"}).paramWithMaskOrNull(easyPut).cookieWithMaskOrNull(easyPutOpt).log();
            boolean z = true;
            SimpleRequest.StringContent postAsString = SimpleRequestForAccount.postAsString(str, easyPut, easyPutOpt, true);
            ProtocolLogHelper.newResponseLog(str, new String[]{"ticketToken", "phone"}).jsonResponseWithMaskOrNull(postAsString).log();
            if (postAsString != null) {
                try {
                    JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody(postAsString));
                    int i = jSONObject.getInt("code");
                    String str2 = "code: " + i + ", desc: " + jSONObject.optString("description");
                    AccountLog.i("XMPassport", "queryPhoneUserInfo: ".concat(String.valueOf(str2)));
                    if (i == 0) {
                        String header = postAsString.getHeader("ticketToken");
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        String optString = jSONObject2.optString("tmpPhoneToken");
                        if (TextUtils.isEmpty(optString)) {
                            AccountLog.i("XMPassport", "tmpPhoneToken is null");
                        }
                        RegisterUserInfo.Builder needToast = new RegisterUserInfo.Builder(jSONObject2.getInt("status")).userId(jSONObject2.getString("id")).userName(jSONObject2.optString("nickname")).avatarAddress(jSONObject2.optString("portrait")).phone(jSONObject2.optString("phone")).tmpPhoneToken(optString).ticketToken(header).maskedUserId(jSONObject2.optString("maskedUserId")).hasPwd(jSONObject2.optInt("pwd") == 1).bindTime(jSONObject2.optLong("bindTime", 0)).needGetActiveTime(jSONObject2.optBoolean("needGetActiveTime", false)).needToast(jSONObject2.optBoolean("needToast", false));
                        if (jSONObject2.optInt("registerPwd") != 1) {
                            z = false;
                        }
                        return needToast.registerPwd(z).build();
                    } else if (i == 10031) {
                        throw new InvalidVerifyCodeException(str2);
                    } else if (i != 70008) {
                        throw new InvalidResponseException(i, str2);
                    } else {
                        throw new InvalidPhoneNumException(str2);
                    }
                } catch (JSONException unused) {
                    throw new InvalidResponseException("result not json");
                }
            } else {
                throw new InvalidResponseException("result content is null");
            }
        } else {
            throw new IllegalArgumentException("invalid params");
        }
    }

    public static AccountInfo loginByPhone(PhoneTicketLoginParams phoneTicketLoginParams) throws AccessDeniedException, AuthenticationFailureException, IOException, InvalidResponseException, InvalidUserNameException, NeedNotificationException, InvalidVerifyCodeException, InvalidPhoneNumException {
        if (phoneTicketLoginParams != null) {
            String str = URLs.URL_ACCOUNT_BASE + "/serviceLoginTicketAuth";
            MetaLoginData phoneLoginMetaLoginData = getPhoneLoginMetaLoginData(phoneTicketLoginParams.phone, phoneTicketLoginParams.serviceId);
            String str2 = TextUtils.isEmpty(phoneTicketLoginParams.serviceId) ? "passport" : phoneTicketLoginParams.serviceId;
            EasyMap easyPut = new EasyMap().easyPutOpt("user", phoneTicketLoginParams.phone).easyPutOpt("userHash", phoneTicketLoginParams.phoneHash).easyPutOpt("ticket", phoneTicketLoginParams.ticket).easyPut("sid", str2).easyPut("_json", "true").easyPut("_sign", phoneLoginMetaLoginData.sign).easyPut("qs", phoneLoginMetaLoginData.qs).easyPut("callback", phoneLoginMetaLoginData.callback);
            EasyMap easyPutOpt = new EasyMap().easyPutOpt("activatorToken", phoneTicketLoginParams.activatorToken).easyPutOpt("ticketToken", phoneTicketLoginParams.ticketToken);
            String addDeviceIdInCookies = addDeviceIdInCookies(easyPutOpt, phoneTicketLoginParams.deviceId);
            Application applicationContext = XMPassportSettings.getApplicationContext();
            if (applicationContext != null && !TextUtils.isEmpty(addDeviceIdInCookies)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(addDeviceIdInCookies);
                if (!TextUtils.isEmpty(phoneTicketLoginParams.phoneHash)) {
                    arrayList.add(phoneTicketLoginParams.phoneHash);
                } else if (!TextUtils.isEmpty(phoneTicketLoginParams.phone)) {
                    arrayList.add(phoneTicketLoginParams.phone);
                }
                String O000000o2 = SecurityDeviceSignManager.O000000o(applicationContext, (String[]) arrayList.toArray(new String[0]));
                if (O000000o2 != null) {
                    easyPut.easyPut("tzSign", O000000o2);
                }
            }
            ProtocolLogHelper.newRequestLog(str, HttpMethod.POST, new String[]{"user", "userHash", "ticket", "activatorToken", "ticketToken"}).paramWithMaskOrNull(easyPut).cookieWithMaskOrNull(easyPutOpt).log();
            SimpleRequest.StringContent postAsString = SimpleRequestForAccount.postAsString(str, easyPut, easyPutOpt, true);
            logLoginResponseAllowNull(str, postAsString);
            if (postAsString != null) {
                return processPhoneLoginContent(postAsString, str2, phoneTicketLoginParams.returnStsUrl);
            }
            throw new InvalidResponseException("result content is null");
        }
        throw new IllegalArgumentException("null phone ticket login params");
    }

    private static MetaLoginData getPhoneLoginMetaLoginData(String str, String str2) throws IOException, InvalidResponseException, AccessDeniedException, AuthenticationFailureException, InvalidUserNameException, NeedNotificationException {
        try {
            loginByPassToken(new PassTokenLoginParams.Builder().userId(str).passToken(null).serviceId(str2).isGetPhoneTicketLoginMetaData(true).build());
            throw new InvalidResponseException("Unexpected login success with empty pass token");
        } catch (InvalidCredentialException e) {
            return e.getMetaLoginData();
        } catch (PackageNameDeniedException unused) {
            throw new InvalidResponseException("PackageNameDeniedException is unexpected with empty userId or passToken");
        }
    }

    private static AccountInfo processPhoneLoginContent(SimpleRequest.StringContent stringContent, String str, boolean z) throws IOException, InvalidResponseException, NeedNotificationException, AccessDeniedException, InvalidVerifyCodeException, InvalidPhoneNumException, AuthenticationFailureException {
        try {
            JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody(stringContent));
            int i = jSONObject.getInt("code");
            String str2 = "code: " + i + ", desc: " + jSONObject.optString("desc");
            AccountLog.i("XMPassport", "processPhoneLoginContent: ".concat(String.valueOf(str2)));
            if (i == 0) {
                String header = stringContent.getHeader("userId");
                String header2 = stringContent.getHeader("passToken");
                if (jSONObject.optInt("securityStatus", 0) != 0) {
                    String string = jSONObject.getString("notificationUrl");
                    if (string != null) {
                        if (!string.startsWith("http")) {
                            string = ACCOUNT_DOMAIN + string;
                        }
                        throw new NeedNotificationException(header, string, stringContent);
                    }
                    throw new InvalidResponseException("notificationUrl is null");
                } else if (TextUtils.isEmpty(header)) {
                    throw new InvalidResponseException("no user Id in login response");
                } else if (!TextUtils.isEmpty(header2)) {
                    return parseLoginResult(header, stringContent, str, null, false, z);
                } else {
                    throw new InvalidResponseException("no passToken in login response");
                }
            } else if (i == 70008) {
                throw new InvalidPhoneNumException(str2);
            } else if (i != 70014) {
                throw new InvalidResponseException(str2);
            } else {
                throw new InvalidVerifyCodeException(str2);
            }
        } catch (JSONException unused) {
            throw new InvalidResponseException("result not json");
        }
    }

    public static String sendSetPasswordTicket(PassportInfo passportInfo, String str) throws AccessDeniedException, AuthenticationFailureException, InvalidResponseException, CipherException, IOException, ReachLimitException, InvalidPhoneNumException {
        if (passportInfo != null) {
            String str2 = URLs.URL_ACCOUNT_SAFE_API_BASE + "/user/sendSetPasswordTicket";
            EasyMap easyPut = new EasyMap().easyPut("userId", passportInfo.getUserId()).easyPutOpt("sid", str).easyPut("transId", UUID.randomUUID().toString().substring(0, 15));
            easyPut.putAll(XMPassportUtil.getDefaultLocaleParam());
            EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
            addDeviceIdInCookies(passportCookie, null);
            ProtocolLogHelper.newRequestLog(str2, HttpMethod.POST, new String[]{"serviceToken"}).cookieWithMaskOrNull(passportCookie).paramOrNull(easyPut).log();
            SimpleRequest.StringContent postAsString = SecureRequestForAccount.postAsString(str2, easyPut, passportCookie, true, passportInfo.getSecurity());
            ProtocolLogHelper.newResponseLog(str2).stringResponseOrNull(postAsString).log();
            if (postAsString != null) {
                try {
                    JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody(postAsString));
                    int i = jSONObject.getInt("code");
                    String str3 = "code: " + i + ", desc: " + jSONObject.optString("description");
                    AccountLog.d("XMPassport", "requestSetPassword: ".concat(String.valueOf(str3)));
                    if (i == 0) {
                        return jSONObject.getJSONObject("data").getString("maskedPhone");
                    }
                    if (i == 70009) {
                        throw new InvalidPhoneNumException(str3);
                    } else if (i != 70022) {
                        throw new InvalidResponseException(i, str3);
                    } else {
                        throw new ReachLimitException(str3);
                    }
                } catch (JSONException unused) {
                    throw new InvalidResponseException("result not json");
                }
            } else {
                throw new InvalidResponseException("result content is null");
            }
        } else {
            throw new IllegalArgumentException("passport info should not be null");
        }
    }

    public static String setPassword(SetPasswordParams setPasswordParams) throws AccessDeniedException, AuthenticationFailureException, IOException, InvalidResponseException, InvalidVerifyCodeException, InvalidParameterException, InvalidCredentialException, UserRestrictedException, CipherException {
        if (setPasswordParams != null) {
            PassportInfo passportInfo = setPasswordParams.passportApiInfo;
            if (passportInfo != null) {
                String str = URLs.URL_ACCOUNT_API_V2_BASE + "/safe/user/setPassword";
                EasyMap easyPut = new EasyMap().easyPut("userId", setPasswordParams.userId).easyPut("pwd", setPasswordParams.pwd).easyPut("passToken", setPasswordParams.passToken).easyPutOpt("sid", setPasswordParams.serviceId).easyPutOpt("ticket", setPasswordParams.ticket).easyPut("transId", UUID.randomUUID().toString().substring(0, 15));
                MiuiActivatorInfo miuiActivatorInfo = setPasswordParams.miuiActivatorInfo;
                if (miuiActivatorInfo != null) {
                    easyPut.easyPutOpt("phone", miuiActivatorInfo.phone).easyPutOpt("simId", miuiActivatorInfo.simId).easyPutOpt("vKey2", miuiActivatorInfo.vKey2).easyPutOpt("nonce", miuiActivatorInfo.vKey2Nonce);
                }
                EasyMap<String, String> passportCookie = getPassportCookie(passportInfo);
                addDeviceIdInCookies(passportCookie, setPasswordParams.deviceId);
                ProtocolLogHelper.newRequestLog(str, HttpMethod.POST, new String[]{"pwd", "passToken", "ticket", "phone", "serviceToken"}).paramWithMaskOrNull(easyPut).cookieWithMaskOrNull(passportCookie).log();
                SimpleRequest.StringContent postAsString = SecureRequestForAccount.postAsString(str, easyPut, passportCookie, true, passportInfo.getSecurity());
                ProtocolLogHelper.newResponseLog(str, new String[]{"passToken"}).jsonResponseWithMaskOrNull(postAsString).log();
                if (postAsString != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody(postAsString));
                        int i = jSONObject.getInt("code");
                        String str2 = "code: " + i + ", desc: " + jSONObject.optString("description");
                        AccountLog.d("XMPassport", "requestSetPassword: ".concat(String.valueOf(str2)));
                        if (i == 0) {
                            return jSONObject.getJSONObject("data").getString("passToken");
                        }
                        if (i == 10031) {
                            throw new UserRestrictedException(str2);
                        } else if (i == 21317) {
                            throw new InvalidCredentialException(i, str2, false);
                        } else if (i == 70003) {
                            throw new InvalidParameterException(str2);
                        } else if (i == 70012 || i == 70014) {
                            throw new InvalidVerifyCodeException(str2);
                        } else {
                            throw new InvalidResponseException(str2);
                        }
                    } catch (JSONException unused) {
                        throw new InvalidResponseException("result not json");
                    }
                } else {
                    throw new InvalidResponseException("result content is null");
                }
            } else {
                throw new IllegalArgumentException("passport info should not be null");
            }
        } else {
            throw new IllegalArgumentException("set password params should not be null");
        }
    }

    public static QRLoginUrlInfo getQRLoginUrl(String str, String str2) throws AccessDeniedException, AuthenticationFailureException, InvalidResponseException, IOException {
        if (TextUtils.isEmpty(str)) {
            str = "passport";
        }
        MetaLoginData metaLoginData = getMetaLoginData(str);
        String str3 = URLs.ACCOUNT_DOMAIN + "/longPolling/loginUrl";
        EasyMap easyMap = new EasyMap();
        easyMap.easyPut("sid", str).easyPut("callback", metaLoginData.callback);
        if (!TextUtils.isEmpty(str2)) {
            easyMap.easyPut("csid", str2).easyPut("ccallback", getMetaLoginData(str2).callback);
        }
        ProtocolLogHelper.newRequestLog(str3, HttpMethod.GET).paramOrNull(easyMap).log();
        SimpleRequest.StringContent asString = SimpleRequestForAccount.getAsString(str3, easyMap, null, true);
        ProtocolLogHelper.newResponseLog(str3).stringResponseOrNull(asString).log();
        if (asString != null) {
            String removeSafePrefixAndGetRealBody = removeSafePrefixAndGetRealBody(asString);
            try {
                JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody);
                int i = jSONObject.getInt("code");
                String string = jSONObject.getString("description");
                AccountLog.i("XMPassport", "getQRLoginUrl code: " + i + ", desc: " + string);
                if (i == 0) {
                    return new QRLoginUrlInfo(str, jSONObject.getString("lp"), jSONObject.getString("loginUrl"), jSONObject.getString("qr"));
                }
                throw new InvalidResponseException(i, string);
            } catch (JSONException unused) {
                throw new InvalidResponseException("JSONException: ".concat(String.valueOf(removeSafePrefixAndGetRealBody)));
            }
        } else {
            throw new InvalidResponseException("qr login url content is null");
        }
    }

    public static AccountInfo loginByLongPolling(QRLoginUrlInfo qRLoginUrlInfo) throws AccessDeniedException, AuthenticationFailureException, IOException, InvalidResponseException, InvalidCredentialException, NeedNotificationException {
        if (qRLoginUrlInfo != null) {
            String str = qRLoginUrlInfo.lp;
            ProtocolLogHelper.newRequestLog(str, HttpMethod.GET).log();
            SimpleRequest.StringContent asString = SimpleRequestForAccount.getAsString(str, null, null, null, true, TIMEOUT_LONG_POLLING);
            logLoginResponseAllowNull(str, asString);
            if (asString != null) {
                try {
                    return processLoginContent(asString, qRLoginUrlInfo.serviceId, true, true, false);
                } catch (InvalidUserNameException | NeedCaptchaException | NeedVerificationException e) {
                    throw new InvalidResponseException("should not reach here!", e);
                } catch (PackageNameDeniedException unused) {
                    throw new InvalidResponseException("It's not loginByPassToken(), PackageNameDeniedException is unexpected");
                }
            } else {
                throw new InvalidResponseException("long polling result is null");
            }
        } else {
            throw new IllegalArgumentException("null long polling para");
        }
    }

    private static String addDeviceIdInCookies(EasyMap<String, String> easyMap, String str) {
        if (easyMap != null) {
            Application applicationContext = XMPassportSettings.getApplicationContext();
            String oaid = OAIDUtil.getOAID(applicationContext);
            if (TextUtils.isEmpty(str)) {
                str = getHashedDeviceId();
            }
            if (applicationContext != null) {
                AssertionUtils.checkCondition(applicationContext, !TextUtils.isEmpty(str), "deviceId cannot be empty", true);
            }
            easyMap.easyPutOpt("deviceId", str).easyPutOpt("pass_o", oaid).easyPutOpt("userSpaceId", UserSpaceIdUtil.getNullableUserSpaceIdCookie());
            return str;
        }
        throw new IllegalArgumentException("cookie params should not be null");
    }

    private static String getHashedDeviceId() {
        return new HashedDeviceIdUtil(XMPassportSettings.getApplicationContext()).getHashedDeviceIdNoThrow();
    }

    private static void logLoginResponseAllowNull(String str, SimpleRequest.StringContent stringContent) {
        ProtocolLogHelper.newResponseLog(str, new String[]{"passToken", "Set-Cookie"}).jsonResponseWithMaskOrNull(stringContent).log();
    }

    public static ial querySmsGateway(String str, String str2, String str3, String str4, String str5) throws InvalidResponseException, AccessDeniedException, AuthenticationFailureException, IOException {
        String str6 = URLs.ACCOUNT_DOMAIN + "/pass2/mobileOriginal/config";
        EasyMap easyPutOpt = new EasyMap().easyPut("user", str).easyPut("extraType", str2).easyPut("sceneId", str3).easyPut("countryCode", str4).easyPutOpt("sid", str5);
        easyPutOpt.putAll(XMPassportUtil.getDefaultLocaleParam());
        ProtocolLogHelper.newRequestLog(str6, HttpMethod.GET).log();
        SimpleRequest.StringContent asString = SimpleRequestForAccount.getAsString(str6, easyPutOpt, null, null, true);
        ProtocolLogHelper.newResponseLog(str6).stringResponseOrNull(asString).log();
        if (asString != null) {
            try {
                JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody(asString));
                int i = jSONObject.getInt("code");
                String str7 = "code: " + i + ", desc: " + jSONObject.optString("description");
                AccountLog.d("XMPassport", "get mobileOriginal config: ".concat(String.valueOf(str7)));
                if (i == 0) {
                    boolean optBoolean = jSONObject.optBoolean("enableMo");
                    JSONArray optJSONArray = jSONObject.optJSONArray("config");
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        if ("default".equals(optJSONArray.getJSONObject(i2).optString("operator"))) {
                            JSONArray optJSONArray2 = optJSONArray.optJSONObject(i2).optJSONArray("gateways");
                            if (optJSONArray2.length() > 0) {
                                return new ial(optBoolean, optJSONArray2.getString(0));
                            }
                        }
                    }
                    throw new InvalidResponseException(jSONObject.toString());
                }
                throw new InvalidResponseException(i, str7);
            } catch (JSONException unused) {
                throw new InvalidResponseException("result not json");
            }
        } else {
            throw new InvalidResponseException("result content is null");
        }
    }

    public static iak verifyMobileOrignal(String str, String str2, String str3, String str4, String str5) throws AccessDeniedException, AuthenticationFailureException, InvalidResponseException, InvalidParameterException, IOException, InvalidCredentialException {
        String str6 = URLs.ACCOUNT_DOMAIN + "/pass2/mobileOriginal/verify";
        EasyMap easyMap = new EasyMap();
        easyMap.easyPut("user", str);
        easyMap.easyPut("extraType", str2);
        easyMap.easyPut("sceneId", str3);
        easyMap.easyPut("ticket", str5);
        easyMap.put("sid", str4);
        ProtocolLogHelper.newRequestLog(str6, HttpMethod.POST).log();
        SimpleRequest.StringContent postAsString = SimpleRequestForAccount.postAsString(str6, easyMap, null, true);
        ProtocolLogHelper.newResponseLog(str6).stringResponseOrNull(postAsString).log();
        try {
            JSONObject jSONObject = new JSONObject(removeSafePrefixAndGetRealBody(postAsString));
            int i = jSONObject.getInt("code");
            String str7 = "code: " + i + ", desc: " + jSONObject.optString("description");
            AccountLog.d("XMPassport", "verifyMobileOrignal config: ".concat(String.valueOf(str7)));
            if (i == 0) {
                return new iak(jSONObject);
            }
            if (i == 21317) {
                throw new InvalidCredentialException(i, str7, false);
            } else if (i != 60018) {
                throw new InvalidResponseException(i, str7);
            } else {
                throw new InvalidParameterException(i, str7);
            }
        } catch (JSONException unused) {
            throw new InvalidResponseException("result not json");
        }
    }
}
