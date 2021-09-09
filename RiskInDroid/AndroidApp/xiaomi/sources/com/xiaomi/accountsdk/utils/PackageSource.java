package com.xiaomi.accountsdk.utils;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

public class PackageSource {
    private PackageSource() {
    }

    public static String getOriginalPackageNameFromOptions(Context context, Bundle bundle, String str) {
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        } else if (bundle == null) {
            return str;
        } else {
            String str2 = null;
            String string = bundle.getString("androidPackageName", null);
            if (TextUtils.equals(string, context.getPackageName())) {
                str2 = bundle.getString("original_calling_package_name", null);
            }
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
            return !TextUtils.isEmpty(string) ? string : str;
        }
    }
}
