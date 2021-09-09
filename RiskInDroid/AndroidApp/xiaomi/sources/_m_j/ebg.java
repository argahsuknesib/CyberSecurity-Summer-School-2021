package _m_j;

import android.content.ComponentName;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.ag;

public final class ebg {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f15145O000000o = -1;

    public static ag O000000o(Context context) {
        try {
            return (context.getPackageManager().getServiceInfo(new ComponentName("com.huawei.hwid", "com.huawei.hms.core.service.HMSCoreService"), NotificationCompat.FLAG_HIGH_PRIORITY) == null || !O000000o()) ? ag.f : ag.f6051a;
        } catch (Exception unused) {
            return ag.f;
        }
    }

    private static boolean O000000o() {
        try {
            String str = (String) emg.O000000o("android.os.SystemProperties", "get", "ro.build.hw_emui_api_level", "");
            return !TextUtils.isEmpty(str) && Integer.parseInt(str) >= 9;
        } catch (Exception e) {
            duv.O000000o(e);
        }
    }

    public static boolean O00000Oo(Context context) {
        Object O000000o2 = emg.O000000o(emg.O000000o("com.google.android.gms.common.GoogleApiAvailability", "getInstance", new Object[0]), "isGooglePlayServicesAvailable", context);
        Object O000000o3 = emg.O000000o("com.google.android.gms.common.ConnectionResult", "SUCCESS");
        if (O000000o3 == null || !(O000000o3 instanceof Integer)) {
            duv.O00000o0("google service is not avaliable");
            f15145O000000o = 0;
            return false;
        }
        int intValue = Integer.class.cast(O000000o3).intValue();
        if (O000000o2 != null) {
            if (O000000o2 instanceof Integer) {
                f15145O000000o = Integer.class.cast(O000000o2).intValue() == intValue ? 1 : 0;
            } else {
                f15145O000000o = 0;
                duv.O00000o0("google service is not avaliable");
            }
        }
        StringBuilder sb = new StringBuilder("is google service can be used");
        sb.append(f15145O000000o > 0);
        duv.O00000o0(sb.toString());
        return f15145O000000o > 0;
    }

    public static boolean O00000o(Context context) {
        boolean z = false;
        Object O000000o2 = emg.O000000o("com.xiaomi.assemble.control.FTOSPushManager", "isSupportPush", context);
        if (O000000o2 != null && (O000000o2 instanceof Boolean)) {
            z = Boolean.class.cast(O000000o2).booleanValue();
        }
        duv.O00000o0("fun touch os push  is avaliable ? :".concat(String.valueOf(z)));
        return z;
    }

    public static boolean O00000o0(Context context) {
        boolean z = false;
        Object O000000o2 = emg.O000000o("com.xiaomi.assemble.control.COSPushManager", "isSupportPush", context);
        if (O000000o2 != null && (O000000o2 instanceof Boolean)) {
            z = Boolean.class.cast(O000000o2).booleanValue();
        }
        duv.O00000o0("color os push  is avaliable ? :".concat(String.valueOf(z)));
        return z;
    }
}
