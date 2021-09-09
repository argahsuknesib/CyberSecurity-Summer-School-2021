package _m_j;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public final class ccz {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f13648O000000o;
    private static String O00000Oo;

    @SuppressLint({"NewApi"})
    public static String O000000o(Context context) {
        String str;
        if (TextUtils.isEmpty(f13648O000000o)) {
            f13648O000000o = cde.O000000o(context, "device_id", "");
        }
        if (TextUtils.isEmpty(f13648O000000o)) {
            String O00000o0 = O00000o0(context);
            String str2 = null;
            try {
                str = Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Exception e) {
                e.printStackTrace();
                str = null;
            }
            if (Build.VERSION.SDK_INT > 8) {
                str2 = Build.SERIAL;
            }
            if (Build.VERSION.SDK_INT == 28 && context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0) {
                str2 = Build.getSerial();
            }
            f13648O000000o = O000000o(O00000o0 + str + str2);
            cde.O00000Oo(context, "device_id", f13648O000000o);
        }
        return f13648O000000o;
    }

    @TargetApi(9)
    public static String O00000Oo(Context context) {
        try {
            if (TextUtils.isEmpty(O00000Oo)) {
                String O000000o2 = cde.O000000o(context, "imei", "");
                O00000Oo = O000000o2;
                if (TextUtils.isEmpty(O000000o2)) {
                    if (context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) != 0 || Build.VERSION.SDK_INT >= 29) {
                        cdc.O00000o("cannot get READ_PHONE_STATE permission");
                    } else {
                        cdc.O00000Oo("get READ_PHONE_STATE permission");
                        O00000Oo = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                        cde.O00000Oo(context, "imei", O00000Oo);
                    }
                }
            }
        } catch (Throwable th) {
            cdc.O000000o("getImei exception:", th);
        }
        if (TextUtils.isEmpty(O00000Oo)) {
            cdc.O00000o0("Imei is empty");
            O00000Oo = "";
        }
        return O00000Oo;
    }

    public static String O000000o(String str) {
        if (str != null) {
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA1");
                instance.update(O00000Oo(str));
                return String.format("%1$032X", new BigInteger(1, instance.digest()));
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static String O00000o0(Context context) {
        String O000000o2 = cde.O000000o(context, "random_device_id", "");
        if (!TextUtils.isEmpty(O000000o2)) {
            return O000000o2;
        }
        String uuid = UUID.randomUUID().toString();
        cde.O00000Oo(context, "random_device_id", uuid);
        return uuid;
    }

    private static byte[] O00000Oo(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str.getBytes();
        }
    }
}
