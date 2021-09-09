package com.hzy.tvmao.utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.hzy.tvmao.KookongSDK;
import com.hzy.tvmao.a.a;
import com.hzy.tvmao.u;
import java.util.Locale;
import java.util.UUID;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static PackageInfo f4472a;

    public static PackageInfo a() {
        if (f4472a == null) {
            try {
                f4472a = KookongSDK.getContext().getPackageManager().getPackageInfo(KookongSDK.getContext().getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        return f4472a;
    }

    public static String b() {
        if (a() != null) {
            return f4472a.versionName;
        }
        return null;
    }

    public static int c() {
        if (a() != null) {
            return f4472a.versionCode;
        }
        return 0;
    }

    public static String d() {
        return KookongSDK.getContext().getPackageName();
    }

    public static String e() {
        String string = DataStoreUtil.i().getString(a.f4407a, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String str = u.l;
        String sha = StringUtil.sha(UUID.randomUUID().toString());
        DataStoreUtil.i().putString(a.f4407a, sha);
        return sha;
    }

    public static String f() {
        try {
            Locale locale = KookongSDK.getContext().getResources().getConfiguration().locale;
            String language = locale.getLanguage();
            String country = locale.getCountry();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(language)) {
                sb.append(language);
                if (!TextUtils.isEmpty(country)) {
                    sb.append("_");
                    sb.append(country);
                }
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
