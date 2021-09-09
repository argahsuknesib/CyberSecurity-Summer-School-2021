package com.xiaomi.accountsdk.account;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class URLs {
    public static final String ACCOUNT_DOMAIN;
    public static final String CA_ACCOUNT_DOMAIN;
    static final String HOST_URL_ACCOUNT_BASE = (USE_PREVIEW ? "account.preview.n.xiaomi.net" : "account.xiaomi.com");
    static final String OPEN_URL_GET_ACCESS_TOKEN = (URL_OPEN_ACCOUNT_THIRD_BASE + "getToken");
    static final String OPEN_URL_REFRESH_ACCESS_TOKEN = (URL_OPEN_ACCOUNT_THIRD_BASE + "refreshToken");
    public static final String URL_ACCOUNT_API_V2_BASE;
    public static final String URL_ACCOUNT_API_V3_BASE = (USE_PREVIEW ? "http://api.account.preview.n.xiaomi.net/pass/v3" : "https://api.account.xiaomi.com/pass/v3");
    public static final String URL_ACCOUNT_BASE;
    public static final String URL_ACCOUNT_HELP_CENTER = (ACCOUNT_DOMAIN + "/helpcenter");
    public static final String URL_ACCOUNT_OAUTH_BASE = (USE_PREVIEW ? "http://account.preview.n.xiaomi.net/oauth2/" : "https://account.xiaomi.com/oauth2/");
    public static final String URL_ACCOUNT_SAFE_API_BASE = (USE_PREVIEW ? "http://api.account.preview.n.xiaomi.net/pass/v2/safe" : "https://api.account.xiaomi.com/pass/v2/safe");
    static final String URL_ACCOUNT_USER_PROFILE = (URL_ACCOUNT_SAFE_API_BASE + "/user/profile");
    @Deprecated
    public static final String URL_ACOUNT_API_BASE;
    public static final String URL_ACOUNT_API_BASE_SECURE;
    public static final String URL_ACOUNT_API_BASE_V2_SECURE;
    public static final String URL_ACTIVATOR_BASE;
    static final String URL_ADD_BIND_EMAIL = (URL_ACCOUNT_SAFE_API_BASE + "/user/addSafeEmailAddress");
    static final String URL_ADD_BIND_PHONE = (URL_ACCOUNT_SAFE_API_BASE + "/user/addPhone");
    static final String URL_AUTH2_AUTHORIZE = (URL_ACCOUNT_OAUTH_BASE + "authorize");
    public static final String URL_CHANGE_PASSWORD = (URL_ACCOUNT_SAFE_API_BASE + "/user/changePassword");
    static final String URL_CHECK_PHONE_ACTIVATE_STATUS = (URL_ACCOUNT_SAFE_API_BASE + "/user/checkPhoneActivateStatus");
    static final String URL_CHECK_SAFE_EMAIL_AVAILABILITY = (URL_ACCOUNT_SAFE_API_BASE + "/user/checkSafeEmailBindParams");
    static final String URL_COMMIT_UPDATE_ICON = (URL_ACCOUNT_SAFE_API_BASE + "/user/updateIconCommit");
    static final String URL_DELETE_BIND_PHONE = (URL_ACCOUNT_SAFE_API_BASE + "/user/deletePhone");
    public static final String URL_DEVICES_SETTING = (URL_DEV_BASE + "/api/user/devices/setting");
    public static final String URL_DEV_BASE = (USE_PREVIEW ? "http://api.device.preview.n.xiaomi.net" : "https://api.device.xiaomi.net");
    public static final String URL_DEV_SETTING = (URL_DEV_BASE + "/api/user/device/setting");
    static final String URL_EMAIL_REGISTER = (URL_ACCOUNT_BASE + "/register");
    static String URL_EXCHANGE_PHONETOKE_HTTPS = (URL_ACTIVATOR_BASE + "/phoneToken/exchangePhoneToken");
    static final String URL_GENERATE_RANDOM_PASSWORD = (ACCOUNT_DOMAIN + "/appConf/randomPwd");
    public static final String URL_GET_BIND_EMAIL_CAPTCODE = (URL_ACCOUNT_BASE + "/getCode?icodeType=antispam");
    public static final String URL_GET_DEVICE_MODEL_INFOS = (URL_DEV_BASE + "/modelinfos");
    public static final String URL_GET_USER_CORE_INFO = (URL_ACCOUNT_SAFE_API_BASE + "/user/coreInfo");
    static final String URL_IDENTITY_AUTH_FOR_ADDING_EMAIL = (URL_ACCOUNT_SAFE_API_BASE + "/user/addSafeEmailAddressAuth");
    static final String URL_IDENTITY_AUTH_FOR_ADDING_PHONE = (URL_ACCOUNT_SAFE_API_BASE + "/user/addPhoneAuth");
    static final String URL_IDENTITY_AUTH_FOR_CHANGE_PWD = (URL_ACCOUNT_SAFE_API_BASE + "/user/native/changePasswordAuth");
    static final String URL_IDENTITY_AUTH_FOR_DELETING_PHONE = (URL_ACCOUNT_SAFE_API_BASE + "/user/deletePhoneAuth");
    static final String URL_IDENTITY_AUTH_FOR_MODIFY_SAFE_PHONE = (URL_ACCOUNT_SAFE_API_BASE + "/user/modifySafePhoneAuth");
    static final String URL_IDENTITY_AUTH_FOR_REPLACING_EMAIL = (URL_ACCOUNT_SAFE_API_BASE + "/user/replaceSafeEmailAddressAuth");
    static final String URL_IDENTITY_AUTH_FOR_REPLACING_PHONE = (URL_ACCOUNT_SAFE_API_BASE + "/user/updatePhoneAuth");
    static final String URL_IDENTITY_AUTH_FOR_SEND_EMAIL_ACTIVATE_MESSAGE = (URL_ACCOUNT_SAFE_API_BASE + "/user/sendEmailActivateMessageAuth");
    static final String URL_IDENTITY_AUTH_FOR_SET_SECURITY_QUESTIONS = (URL_ACCOUNT_SAFE_API_BASE + "/user/setSafeQuestionsAuth");
    @Deprecated
    public static final String URL_LOGIN = (URL_ACCOUNT_BASE + "/serviceLogin");
    public static final String URL_LOGIN_AUTH2 = (URL_ACCOUNT_BASE + "/serviceLoginAuth2");
    static String URL_LOGIN_AUTH2_HTTPS = (URL_ACCOUNT_BASE + "/serviceLoginAuth2");
    static final String URL_LOGIN_AUTH2_PASSPORT_CA = (URL_PASSPORT_CA_ACCOUNT_BASE + "/serviceLoginAuth2CA");
    public static final String URL_LOGIN_AUTH_STEP2 = (URL_ACCOUNT_BASE + "/loginStep2");
    static String URL_LOGIN_HTTPS = (URL_ACCOUNT_BASE + "/serviceLogin");
    static final String URL_LOGIN_PASSPORT_CA = (URL_PASSPORT_CA_ACCOUNT_BASE + "/serviceLoginCA");
    public static final String URL_OPEN_ACCOUNT_THIRD_BASE = (USE_PREVIEW ? "http://open.account.preview.n.xiaomi.net/third/" : "https://open.account.xiaomi.com/third/");
    static final String URL_PASSPORT_CA_ACCOUNT_BASE;
    static final String URL_REG = (URL_ACOUNT_API_BASE_V2_SECURE + "/user/full");
    static final String URL_REG_CHECK_VERIFY_CODE = (URL_ACCOUNT_BASE + "/verifyPhoneRegTicket");
    public static final String URL_REG_GET_CAPTCHA_CODE = (URL_ACCOUNT_BASE + "/getCode?icodeType=register");
    static final String URL_REG_GET_VERIFY_CODE = (URL_ACCOUNT_BASE + "/sendPhoneTicket");
    static final String URL_REG_PHONE = (URL_ACOUNT_API_BASE_SECURE + "/user/full/@phone");
    static final String URL_REG_SEND_PHONE_TICKET = (URL_ACCOUNT_BASE + "/sendPhoneRegTicket");
    static final String URL_REG_TOKEN = (URL_ACCOUNT_BASE + "/tokenRegister");
    static final String URL_REG_VERIFY_PHONE = (URL_ACCOUNT_BASE + "/verifyRegPhone");
    static final String URL_REPLACE_BIND_EMAIL = (URL_ACCOUNT_SAFE_API_BASE + "/user/replaceSafeEmailAddress");
    static final String URL_REPLACE_BIND_PHONE = (URL_ACCOUNT_SAFE_API_BASE + "/user/updatePhone");
    static final String URL_REQUEST_UPDATE_ICON = (URL_ACCOUNT_SAFE_API_BASE + "/user/updateIconRequest");
    public static final String URL_RESEND_EMAIL = (URL_ACOUNT_API_BASE_SECURE + "/sendActivateMessage");
    static final String URL_RESET_PASSWORD = (URL_ACCOUNT_BASE + "/auth/resetPassword");
    static final String URL_SEND_BIND_EMAIL_VERIFY_CODE = (URL_ACCOUNT_SAFE_API_BASE + "/user/sendBindSafeEmailVerifyMessage");
    static final String URL_SEND_BIND_PHONE_VERIFY_CODE = (URL_ACCOUNT_SAFE_API_BASE + "/user/sendBindAuthPhoneVerifyMessage");
    static final String URL_SEND_EMAIL_ACTIVATE_MESSAGE = (URL_ACCOUNT_SAFE_API_BASE + "/user/sendEmailActivateMessage");
    static final String URL_SET_SECURITY_QUESTIONS = (URL_ACCOUNT_SAFE_API_BASE + "/user/setSafeQuestions");
    public static final String URL_SET_USER_EDUCATION = (URL_ACCOUNT_SAFE_API_BASE + "/user/setEducation");
    public static final String URL_SET_USER_INCOME = (URL_ACCOUNT_SAFE_API_BASE + "/user/setIncome");
    public static final String URL_SET_USER_LOCATION = (URL_ACCOUNT_SAFE_API_BASE + "/user/setLocation");
    public static final String URL_SET_USER_REGION = (URL_ACCOUNT_SAFE_API_BASE + "/user/region");
    public static final String URL_USER_EXISTS = (URL_ACCOUNT_API_V3_BASE + "/user@id");
    static final boolean USE_PREVIEW;
    static final Map<String, String> caUrlMap;

    @Deprecated
    public static void setLocalUsePreview(Context context, boolean z) {
        XMPassportSettings.setLocalStaging(context, z);
    }

    static {
        boolean isStaging = XMPassportSettings.isStaging();
        USE_PREVIEW = isStaging;
        String str = "http://account.preview.n.xiaomi.net";
        ACCOUNT_DOMAIN = isStaging ? str : "https://account.xiaomi.com";
        if (!USE_PREVIEW) {
            str = "https://c.id.mi.com";
        }
        CA_ACCOUNT_DOMAIN = str;
        String str2 = "http://account.preview.n.xiaomi.net/pass";
        URL_ACCOUNT_BASE = USE_PREVIEW ? str2 : "https://account.xiaomi.com/pass";
        String str3 = "http://api.account.xiaomi.com/pass";
        URL_ACTIVATOR_BASE = USE_PREVIEW ? str3 : "https://api.account.xiaomi.com/pass";
        if (!USE_PREVIEW) {
            str2 = "http://c.id.mi.com/pass";
        }
        URL_PASSPORT_CA_ACCOUNT_BASE = str2;
        String str4 = "http://api.account.preview.n.xiaomi.net/pass";
        if (USE_PREVIEW) {
            str3 = str4;
        }
        URL_ACOUNT_API_BASE = str3;
        if (!USE_PREVIEW) {
            str4 = "https://api.account.xiaomi.com/pass";
        }
        URL_ACOUNT_API_BASE_SECURE = str4;
        String str5 = "http://api.account.preview.n.xiaomi.net/pass/v2";
        URL_ACOUNT_API_BASE_V2_SECURE = USE_PREVIEW ? str5 : "https://api.account.xiaomi.com/pass/v2";
        if (!USE_PREVIEW) {
            str5 = "https://api.account.xiaomi.com/pass/v2";
        }
        URL_ACCOUNT_API_V2_BASE = str5;
        HashMap hashMap = new HashMap();
        caUrlMap = hashMap;
        hashMap.put(URL_LOGIN_HTTPS, URL_LOGIN_PASSPORT_CA);
        caUrlMap.put(URL_LOGIN_AUTH2_HTTPS, URL_LOGIN_AUTH2_PASSPORT_CA);
    }

    public static String getCaUrl(String str) {
        return caUrlMap.get(str);
    }
}
