package com.ut.device;

import android.content.Context;

public class UTDevice {
    @Deprecated
    public static String getAid(String str, String str2, Context context) {
        return "";
    }

    @Deprecated
    public static void getAidAsync(String str, String str2, Context context, AidCallback aidCallback) {
    }

    public static String getUtdid(Context context) {
        return com.ta.utdid2.device.UTDevice.getUtdid(context);
    }

    @Deprecated
    public static String getUtdidForUpdate(Context context) {
        return com.ta.utdid2.device.UTDevice.getUtdidForUpdate(context);
    }
}
