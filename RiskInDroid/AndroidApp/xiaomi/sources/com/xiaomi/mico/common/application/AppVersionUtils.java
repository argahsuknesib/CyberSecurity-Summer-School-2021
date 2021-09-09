package com.xiaomi.mico.common.application;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;

public class AppVersionUtils {
    public static String getChannelName(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return context.getString(R.string.mico_update_channel_internal);
        }
        if (str.equalsIgnoreCase("release")) {
            return context.getString(R.string.mico_update_channel_release);
        }
        if (str.equalsIgnoreCase("stable")) {
            return context.getString(R.string.mico_update_channel_stable);
        }
        return context.getString(R.string.mico_update_channel_internal);
    }

    public static String getAppChannelName(Context context, String str) {
        if (str.equalsIgnoreCase("dev")) {
            return context.getString(R.string.mico_update_channel_stable);
        }
        if (str.equalsIgnoreCase("daily") || str.equalsIgnoreCase("neice")) {
            return context.getString(R.string.mico_update_channel_internal);
        }
        if (str.equalsIgnoreCase("beta")) {
            return context.getString(R.string.mico_update_channel_beta);
        }
        return context.getString(R.string.mico_update_channel_release);
    }
}
