package _m_j;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

public final class esu {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Context f15778O000000o;
    private static String O00000Oo;

    public static Context O000000o() {
        return f15778O000000o;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0024 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024 A[SYNTHETIC, Splitter:B:13:0x0024] */
    public static Class<?> O000000o(Context context, String str) {
        if (str == null || str.trim().length() == 0) {
            throw new ClassNotFoundException("class is empty");
        }
        boolean z = context != null;
        if (z && Build.VERSION.SDK_INT >= 29) {
            return context.getClassLoader().loadClass(str);
        }
        try {
            return Class.forName(str);
        } catch (Throwable th) {
            duv.O000000o(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z), th.getLocalizedMessage()));
            throw new ClassNotFoundException("loadClass fail ", th);
        }
    }

    public static void O000000o(Context context) {
        f15778O000000o = context.getApplicationContext();
    }

    public static int O00000Oo() {
        try {
            Class<?> O000000o2 = O000000o(null, "miui.os.Build");
            if (O000000o2.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            return O000000o2.getField("IS_DEVELOPMENT_VERSION").getBoolean(null) ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean O00000Oo(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception e) {
            duv.O000000o(e);
            return false;
        }
    }

    public static boolean O00000o() {
        try {
            return O000000o(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(Boolean.FALSE);
        } catch (ClassNotFoundException unused) {
            duv.O00000o("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e) {
            duv.O000000o(e);
            return false;
        }
    }

    public static String O00000o0(Context context) {
        if (esl.O00000Oo()) {
            return "";
        }
        String str = (String) emg.O000000o("com.xiaomi.xmsf.helper.MIIDAccountHelper", "getMIID", context);
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    public static boolean O00000o0() {
        return TextUtils.equals((String) emg.O000000o("android.os.SystemProperties", "get", "sys.boot_completed"), "1");
    }

    public static synchronized String O00000oO() {
        String str;
        synchronized (esu.class) {
            if (O00000Oo != null) {
                String str2 = O00000Oo;
                return str2;
            }
            String str3 = Build.VERSION.INCREMENTAL;
            if (O00000Oo() <= 0) {
                str = est.O000000o("ro.build.version.emui", "");
                O00000Oo = str;
                if (TextUtils.isEmpty(str)) {
                    String O000000o2 = est.O000000o("ro.build.version.opporom", "");
                    if (!TextUtils.isEmpty(O000000o2) && !O000000o2.startsWith("ColorOS_")) {
                        O00000Oo = "ColorOS_".concat(String.valueOf(O000000o2));
                    }
                    str = O00000Oo;
                    if (TextUtils.isEmpty(str)) {
                        String O000000o3 = est.O000000o("ro.vivo.os.version", "");
                        if (!TextUtils.isEmpty(O000000o3) && !O000000o3.startsWith("FuntouchOS_")) {
                            O00000Oo = "FuntouchOS_".concat(String.valueOf(O000000o3));
                        }
                        str = O00000Oo;
                        if (TextUtils.isEmpty(str)) {
                            str3 = String.valueOf(est.O000000o("ro.product.brand", "Android") + "_" + str3);
                        }
                    }
                }
                O00000Oo = str;
                return str;
            }
            str = str3;
            O00000Oo = str;
            return str;
        }
    }
}
