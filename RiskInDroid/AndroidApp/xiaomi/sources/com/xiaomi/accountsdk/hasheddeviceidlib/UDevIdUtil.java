package com.xiaomi.accountsdk.hasheddeviceidlib;

import android.content.Context;
import android.util.Log;
import com.xiaomi.accountsdk.utils.FidSigningUtil;

public class UDevIdUtil {
    public static String getUDevId(Context context, String str) throws FidSigningUtil.FidSignException {
        String fid = FidManager.getInstance().getFid(context);
        Log.i("UDevIdUtil", "fidPrefix " + fid.substring(0, fid.length() / 2));
        return getUDevId(str, fid);
    }

    private static String getUDevId(String str, String str2) {
        String concat = "ud:".concat(String.valueOf(DeviceIdHasher.hashDeviceInfo(str + str2)));
        StringBuilder sb = new StringBuilder("uDevIdPrefix  ");
        sb.append(concat.substring(0, concat.length() / 2));
        Log.i("UDevIdUtil", sb.toString());
        return concat;
    }
}
