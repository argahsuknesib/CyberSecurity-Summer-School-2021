package _m_j;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.EncodeHintType;
import java.lang.reflect.Constructor;
import java.util.Hashtable;
import java.util.Locale;

public final class hze {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final byte[] f1009O000000o = new byte[0];
    private static final char[] O00000Oo = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static Bitmap O000000o(Context context, int i, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (context != null) {
                    Hashtable hashtable = new Hashtable();
                    hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
                    new igw();
                    idm O000000o2 = igw.O000000o(str, BarcodeFormat.QR_CODE, i, i, hashtable);
                    int[] iArr = new int[(i * i)];
                    for (int i2 = 0; i2 < i; i2++) {
                        for (int i3 = 0; i3 < i; i3++) {
                            if (O000000o2.O000000o(i3, i2)) {
                                iArr[(i2 * i) + i3] = -16777216;
                            } else {
                                iArr[(i2 * i) + i3] = -1;
                            }
                        }
                    }
                    Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
                    createBitmap.setPixels(iArr, 0, i, 0, 0, i, i);
                    return createBitmap;
                }
            }
            return null;
        } catch (Throwable th) {
            gsy.O00000o0(LogType.KUAILIAN, "genBarcodeBitmap", th.getMessage());
            return null;
        }
    }

    public static long O000000o(Object obj) {
        try {
            return Long.parseLong(String.valueOf(obj));
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean O000000o(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    public static String O000000o(Locale locale) {
        if (locale == null) {
            return "";
        }
        String language = locale.getLanguage();
        if (TextUtils.equals("iw", language)) {
            language = "he";
        } else if (TextUtils.equals("ji", language)) {
            language = "yi";
        } else if (TextUtils.equals("in", language)) {
            language = "id";
        }
        String country = locale.getCountry();
        if (TextUtils.isEmpty(country)) {
            return language;
        }
        return language + "_" + country;
    }

    public static boolean O00000Oo(Context context) {
        if (context == null) {
            return false;
        }
        return O000000o(context, "android.permission.ACCESS_FINE_LOCATION") || O000000o(context, "android.permission.ACCESS_COARSE_LOCATION");
    }

    private static boolean O000000o(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        return context.getApplicationInfo().targetSdkVersion < 23 ? g.O000000o(context, str, Binder.getCallingPid(), Binder.getCallingUid(), context.getPackageName()) == 0 : context.checkSelfPermission(str) == 0;
    }

    public static boolean O000000o(String str) {
        for (char c : str.toCharArray()) {
            if (c >= 19968 && c <= 40908) {
                return true;
            }
            if (c >= 12288 && c <= 12351) {
                return true;
            }
            if (c >= 65281 && c <= 65374) {
                return true;
            }
        }
        return false;
    }

    public static <T> T O000000o(Class cls, Object... objArr) {
        if (cls != null) {
            try {
                Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(objArr);
            } catch (Throwable th) {
                Log.e("ReflectUtils", "fatal getInstance", th);
                return null;
            }
        } else {
            throw new IllegalArgumentException("className 不能为空");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0021 A[RETURN] */
    public static boolean O000000o(byte[] bArr) {
        byte b = bArr[0];
        byte b2 = bArr[1];
        if (b != -84) {
            if (b != -64) {
                return b == 10;
            }
        } else if (b2 >= 16 && b2 <= 31) {
            return true;
        }
        if (b2 == -88) {
            return true;
        }
    }

    public static boolean O000000o(Context context, String str, String str2) {
        WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
        if (connectionInfo != null) {
            String ssid = connectionInfo.getSSID();
            String bssid = connectionInfo.getBSSID();
            if (!(bssid == null || str2 == null)) {
                String[] split = str2.split(":");
                if (bssid.equalsIgnoreCase(str2)) {
                    return true;
                }
                if (split.length == 6) {
                    String format = String.format("%1$s:%2$s:%3$s:%4$s:%5$s:%6$x", split[0], split[1], split[2], split[3], split[4], Integer.valueOf(Integer.valueOf(split[5], 16).intValue() + 1));
                    String format2 = String.format("%1$s:%2$s:%3$s:%4$s:%5$s:%6$x", split[0], split[1], split[2], split[3], split[4], Integer.valueOf(Integer.valueOf(split[5], 16).intValue() - 1));
                    if (bssid.equalsIgnoreCase(format) || bssid.equalsIgnoreCase(format2) || bssid.equalsIgnoreCase(str2)) {
                        return true;
                    }
                }
            }
            if (ssid == null || str == null || !iag.O000000o(ssid.replaceAll("([-_])?(2.4|5)G", ""), str.replaceAll("([-_])?(2.4|5)G", ""))) {
                return false;
            }
            return true;
        }
        return false;
    }
}
