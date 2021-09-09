package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import java.util.UUID;

public final class gsa {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f18201O000000o = "";

    public static String O000000o(Context context) {
        if (O000000o(f18201O000000o)) {
            return f18201O000000o;
        }
        String string = context.getSharedPreferences("spfs_uuid", 0).getString("spfs_uuid_key", "");
        if (O000000o(string)) {
            f18201O000000o = string;
            return string;
        }
        String O000000o2 = gsb.O000000o(context);
        if (!O000000o(O000000o2)) {
            O000000o2 = Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
        if (!O000000o(O000000o2)) {
            O000000o2 = O00000Oo(context);
        }
        f18201O000000o = O000000o2;
        context.getSharedPreferences("spfs_uuid", 0).edit().putString("spfs_uuid_key", O000000o2).commit();
        return f18201O000000o;
    }

    @SuppressLint({"MissingPermission"})
    private static String O00000Oo(Context context) {
        String str;
        try {
            if (Build.VERSION.SDK_INT <= 28 && ContextCompat.O000000o(context, "android.permission.READ_PHONE_STATE") == 0) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (O000000o(deviceId)) {
                    return UUID.nameUUIDFromBytes(deviceId.getBytes()).toString();
                }
            }
        } catch (Exception unused) {
        }
        String str2 = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
        try {
            str = Build.VERSION.SDK_INT >= 26 ? Build.getSerial() : Build.SERIAL;
        } catch (Exception unused2) {
            str = "serial";
        }
        return new UUID((long) str2.hashCode(), (long) str.hashCode()).toString();
    }

    private static boolean O000000o(String str) {
        return !TextUtils.isEmpty(str) && !"unknow".equalsIgnoreCase(str) && !"null".equalsIgnoreCase(str);
    }
}
