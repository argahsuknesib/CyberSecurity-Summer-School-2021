package com.hzy.tvmao.offline;

import android.text.TextUtils;
import com.hzy.tvmao.KookongSDK;
import com.hzy.tvmao.utils.DataStoreUtil;
import java.util.Locale;

public class b {
    public static String a() {
        return DataStoreUtil.i().getString("country_code", "CN");
    }

    private static Locale c() {
        Locale locale = KookongSDK.getContext().getResources().getConfiguration().locale;
        return locale == null ? Locale.getDefault() : locale;
    }

    public static String b() {
        Locale c = c();
        String language = c.getLanguage();
        String country = c.getCountry();
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(language)) {
            sb.append(language);
            if (!TextUtils.isEmpty(country)) {
                sb.append("_");
                sb.append(country);
            }
        }
        return sb.toString();
    }
}
