package com.xiaomi.accountsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class XMPassportUtil {
    public static String getISOLocaleString(Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (TextUtils.isEmpty(country)) {
            return language;
        }
        return String.format("%s_%s", language, country);
    }

    public static Map<String, String> getDefaultLocaleParam() {
        HashMap hashMap = new HashMap();
        hashMap.put("_locale", getISOLocaleString(Locale.getDefault()));
        return hashMap;
    }

    public static String buildUrlWithLocaleQueryParam(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("_locale");
        Uri.Builder buildUpon = parse.buildUpon();
        String iSOLocaleString = getISOLocaleString(Locale.getDefault());
        if (TextUtils.isEmpty(queryParameter) && !TextUtils.isEmpty(iSOLocaleString)) {
            buildUpon.appendQueryParameter("_locale", iSOLocaleString);
        }
        return buildUpon.build().toString();
    }

    public static String extractPasstokenFromNotificationLoginEndCookie(String str) {
        return extractFromCookieString(str, "passToken");
    }

    public static String extractUserIdFromNotificationLoginEndCookie(String str) {
        return extractFromCookieString(str, "userId");
    }

    public static String extractFromCookieString(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            for (String str3 : str.split(";")) {
                if (str3.contains(str2) && str3.split("=")[0].trim().equals(str2)) {
                    return str3.substring(str3.indexOf("=") + 1);
                }
            }
        }
        return null;
    }

    public static String getSimpleDateFormat() {
        Locale locale = Locale.getDefault();
        if (!locale.getLanguage().equals(Locale.ENGLISH.getLanguage())) {
            return SimpleDateFormat.default_not_en.toString();
        }
        if (locale.getCountry().equals(Locale.US.getCountry())) {
            return SimpleDateFormat.en_US.toString();
        }
        return SimpleDateFormat.en_not_US.toString();
    }

    enum SimpleDateFormat {
        en_US("MM-dd-yyyy"),
        en_not_US("dd-MM-yyyy"),
        default_not_en("yyyy-MM-dd");
        
        private String value;

        private SimpleDateFormat(String str) {
            this.value = str;
        }

        public final String toString() {
            return this.value;
        }
    }
}
