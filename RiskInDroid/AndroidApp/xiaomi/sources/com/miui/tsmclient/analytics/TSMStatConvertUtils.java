package com.miui.tsmclient.analytics;

import android.annotation.TargetApi;
import android.text.TextUtils;

public class TSMStatConvertUtils {
    private TSMStatConvertUtils() {
    }

    @TargetApi(26)
    public static String getStatFormatTime(long j) {
        return Long.toUnsignedString(j, 32);
    }

    public static String getStatFormatLbs(String str) {
        int indexOf;
        return (TextUtils.isEmpty(str) || !str.contains(".") || str.length() <= (indexOf = str.indexOf(46) + 2)) ? str : str.substring(0, indexOf + 1);
    }
}
