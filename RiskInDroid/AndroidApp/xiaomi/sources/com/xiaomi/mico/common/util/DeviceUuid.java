package com.xiaomi.mico.common.util;

import _m_j.gqb;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class DeviceUuid {
    public static String DEVICE_PREFIX = "and:";
    private static String sCachedHardId;

    @Deprecated
    public static String getUuid(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_uuid.xml", 0);
        String string = sharedPreferences.getString("device_uuid", null);
        if (string != null) {
            return string;
        }
        String string2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (string2 != null && !"9774d56d682e549c".equals(string2)) {
            try {
                string = UUID.nameUUIDFromBytes(string2.getBytes("UTF-8")).toString();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(string)) {
            String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            if (deviceId == null) {
                deviceId = UUID.randomUUID().toString();
            }
            string = deviceId;
        }
        if (!TextUtils.isEmpty(string)) {
            sharedPreferences.edit().putString("device_uuid", string).commit();
        }
        return string;
    }

    public static String getSoftUuid(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_uuid.xml", 0);
        String string = sharedPreferences.getString("device_soft_uuid", null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        if (!TextUtils.isEmpty(uuid)) {
            sharedPreferences.edit().putString("device_soft_uuid", uuid).commit();
        }
        return uuid;
    }

    public static String hashSoftUuid(Context context) {
        String str;
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_uuid.xml", 0);
        String string = sharedPreferences.getString("device_hash_soft_uuid", null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String softUuid = getSoftUuid(context);
        try {
            str = Base64.encodeToString(MessageDigest.getInstance("SHA1").digest(softUuid.getBytes()), 8).substring(0, 16);
        } catch (NoSuchAlgorithmException unused) {
            str = softUuid;
        }
        if (!TextUtils.isEmpty(softUuid)) {
            sharedPreferences.edit().putString("device_hash_soft_uuid", str).commit();
        }
        return str;
    }

    public static String getHardwareId(Context context) {
        String str;
        if (sCachedHardId == null) {
            String str2 = null;
            try {
                str = Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Throwable unused) {
                str = null;
            }
            if (Build.VERSION.SDK_INT > 8) {
                str2 = Build.SERIAL;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(DEVICE_PREFIX);
            StringBuilder sb2 = new StringBuilder();
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            sb2.append(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            sb2.append(str2);
            sb.append(gqb.O0000Oo(sb2.toString()));
            sCachedHardId = sb.toString();
        }
        return sCachedHardId;
    }
}
