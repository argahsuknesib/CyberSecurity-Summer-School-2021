package _m_j;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;

public final class ecp extends ecn {

    /* renamed from: O000000o  reason: collision with root package name */
    private static ecq f15170O000000o = new ecq();

    public static String O000000o() {
        ecq ecq = f15170O000000o;
        if (ecq != null && TextUtils.isEmpty(ecq.f15171O000000o)) {
            f15170O000000o.f15171O000000o = Build.VERSION.SDK;
        }
        return f15170O000000o.f15171O000000o;
    }

    public static String O00000Oo() {
        if (TextUtils.isEmpty(f15170O000000o.O00000Oo)) {
            f15170O000000o.O00000Oo = Build.VERSION.RELEASE;
        }
        return f15170O000000o.O00000Oo;
    }

    public static int O00000o(Context context) {
        ecq ecq = f15170O000000o;
        if (!(ecq == null || ecq.O0000Oo > 0 || context == null)) {
            f15170O000000o.O0000Oo = ebs.O000000o(context);
        }
        ecq ecq2 = f15170O000000o;
        if (ecq2 != null) {
            return ecq2.O0000Oo;
        }
        return -1;
    }

    public static String O00000oO(Context context) {
        if (TextUtils.isEmpty(f15170O000000o.O0000OoO) && context != null) {
            f15170O000000o.O0000OoO = ebs.O00000o0(context);
        }
        return f15170O000000o.O0000OoO;
    }

    public static int O00000oo(Context context) {
        int O000000o2 = ecm.O000000o().O000000o(context);
        if (O000000o2 != 0) {
            return O000000o2;
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        ecm.O000000o().O000000o(context, currentTimeMillis);
        return currentTimeMillis;
    }

    public static String O000000o(Context context) {
        ecq ecq = f15170O000000o;
        if (!(ecq == null || !TextUtils.isEmpty(ecq.O0000Oo0) || context == null)) {
            String O000000o2 = ecm.O000000o().O000000o(context, "setappkey", null);
            if (!TextUtils.isEmpty(O000000o2)) {
                f15170O000000o.O0000Oo0 = O000000o2;
            } else {
                String O00000Oo = ebs.O00000Oo(context, "XM_APPKEY");
                if (!TextUtils.isEmpty(O00000Oo)) {
                    f15170O000000o.O0000Oo0 = O00000Oo;
                    ecm.O000000o().O00000Oo(context, "setappkey", O00000Oo);
                }
            }
        }
        ecq ecq2 = f15170O000000o;
        return ecq2 != null ? ecq2.O0000Oo0 : "";
    }

    public static String O00000Oo(Context context) {
        ecq ecq = f15170O000000o;
        if (!(ecq == null || !TextUtils.isEmpty(ecq.O0000OOo) || context == null)) {
            String O000000o2 = ecm.O000000o().O000000o(context, "appchannel", null);
            if (!TextUtils.isEmpty(O000000o2)) {
                f15170O000000o.O0000OOo = O000000o2;
            } else {
                String O00000Oo = ebs.O00000Oo(context, "XM_APPCHANNEL");
                if (!TextUtils.isEmpty(O00000Oo)) {
                    f15170O000000o.O0000OOo = O00000Oo;
                    ecm.O000000o().O00000Oo(context, "appchannel", O00000Oo);
                }
            }
        }
        ecq ecq2 = f15170O000000o;
        return ecq2 != null ? ecq2.O0000OOo : "";
    }

    public static String O0000O0o(Context context) {
        SharedPreferences defaultSharedPreferences;
        String O000000o2 = ecm.O000000o().O000000o(context, "userId", "");
        if (!(!TextUtils.isEmpty(O000000o2) || context == null || (defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)) == null)) {
            O000000o2 = defaultSharedPreferences.getString("shop_sdk_pref_uid", "");
            if (!TextUtils.isEmpty(O000000o2)) {
                try {
                    O000000o2 = Base64.encodeToString(ecl.O000000o(O000000o2.getBytes("UTF-8")), 2);
                    if (TextUtils.isEmpty(O000000o2)) {
                        ecm.O000000o().O00000Oo(context, "userId", O000000o2);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        if (TextUtils.isEmpty(O000000o2)) {
            return "";
        }
        return O000000o2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0045  */
    public static String O0000OOo(Context context) {
        String str;
        ecq ecq = f15170O000000o;
        if (!(ecq == null || !TextUtils.isEmpty(ecq.O0000o0o) || context == null)) {
            if (context != null) {
                ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                if (activityManager == null || !ebs.O000000o(context, "android.permission.GET_TASKS")) {
                    ebs.O000000o("no permission", "android.permission.GET_TASKS");
                } else {
                    ComponentName componentName = activityManager.getRunningTasks(1).get(0).topActivity;
                    if (componentName != null) {
                        str = componentName.getPackageName();
                        if (!TextUtils.isEmpty(str)) {
                            f15170O000000o.O0000o0o = str;
                        }
                    }
                }
            }
            str = "";
            if (!TextUtils.isEmpty(str)) {
            }
        }
        ecq ecq2 = f15170O000000o;
        return ecq2 != null ? ecq2.O0000o0o : "";
    }
}
