package com.xiaomi.account.openid;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

class OAuthUtils {
    OAuthUtils() {
    }

    static String makeUrlQueryParams(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (String next : bundle.keySet()) {
            String string = bundle.getString(next);
            if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string)) {
                arrayList.add(new BasicNameValuePair(next, string));
            }
        }
        return URLEncodedUtils.format(arrayList, "UTF-8");
    }

    static String cookieToString(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Map.Entry next : map.entrySet()) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append((String) next.getKey());
            sb.append("=");
            sb.append((String) next.getValue());
            i++;
        }
        return sb.toString();
    }

    static String getLocaleString() {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return "";
        }
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (TextUtils.isEmpty(country)) {
            return language;
        }
        return String.format("%s_%s", language, country);
    }
}
