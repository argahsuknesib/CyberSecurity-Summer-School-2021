package _m_j;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

public final class bsd {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13230O000000o = "/a/";
    static final String O00000Oo = "b";
    static final String O00000o = "d";
    static final String O00000o0 = "c";
    static final String O00000oO = "i";
    public static final String O00000oo = "g";
    public static final String O0000O0o = "h";
    public static final String O0000OOo = "e";
    public static final String O0000Oo = "j";
    public static final String O0000Oo0 = "f";

    public static String O000000o(Context context) {
        return O00000o0(context, O00000oO);
    }

    public static String O000000o(Context context, String str) {
        return context.getSharedPreferences("AMSKLG_CFG", 0).getString(str, "");
    }

    @TargetApi(9)
    public static void O000000o(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    static boolean O000000o(String[] strArr, String str) {
        if (!(strArr == null || str == null)) {
            try {
                for (String trim : str.split("\n")) {
                    String trim2 = trim.trim();
                    if (!TextUtils.isEmpty(trim2) && trim2.contains("uncaughtException")) {
                        return false;
                    }
                    if (O00000Oo(strArr, trim2)) {
                        return true;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static void O00000Oo(final Context context) {
        try {
            ExecutorService O00000o2 = bsf.O00000o();
            if (O00000o2 == null) {
                return;
            }
            if (!O00000o2.isShutdown()) {
                O00000o2.submit(new Runnable() {
                    /* class _m_j.bsd.AnonymousClass1 */

                    public final void run() {
                        try {
                            btd.O000000o(context);
                            bsg.O00000Oo(context);
                            bsg.O00000o(context);
                            bsg.O00000o0(context);
                            bth.O000000o(context);
                            btf.O000000o(context);
                        } catch (RejectedExecutionException unused) {
                        } catch (Throwable th) {
                            bsf.O00000Oo(th, "Lg", "proL");
                        }
                    }
                });
            }
        } catch (Throwable th) {
            bsf.O00000Oo(th, "Lg", "proL");
        }
    }

    public static void O00000Oo(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("AMSKLG_CFG", 0).edit();
        edit.remove(str);
        edit.apply();
    }

    static boolean O00000Oo(String[] strArr, String str) {
        if (!(strArr == null || str == null)) {
            try {
                String str2 = str;
                for (String str3 : strArr) {
                    str2 = str2.trim();
                    if (str2.startsWith("at ")) {
                        if (str2.contains(str3 + ".") && str2.endsWith(")") && !str2.contains("uncaughtException")) {
                            return true;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static String O00000o0(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + f13230O000000o + str;
    }

    static List<brr> O00000o0(Context context) {
        List<brr> list = null;
        try {
            synchronized (Looper.getMainLooper()) {
                list = new bsq(context, false).O000000o();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return list;
    }
}
