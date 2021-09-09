package _m_j;

import android.content.SharedPreferences;
import com.xiaomi.smarthome.application.ServiceApplication;
import java.io.File;

public final class hta {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f613O000000o;
    public static final String O00000Oo = (f613O000000o + File.separator + "share");
    static boolean O00000o = false;
    static SharedPreferences O00000o0 = null;

    static {
        File externalCacheDir = ServiceApplication.getAppContext().getExternalCacheDir();
        if (externalCacheDir != null) {
            f613O000000o = externalCacheDir.getPath();
        } else {
            f613O000000o = ServiceApplication.getAppContext().getCacheDir().getPath();
        }
    }

    public static boolean O000000o() {
        if (O00000o0 == null) {
            SharedPreferences sharedPreferences = ServiceApplication.getAppContext().getSharedPreferences("miotStore1.0", 0);
            O00000o0 = sharedPreferences;
            if (sharedPreferences != null) {
                O00000o = O00000o0.getBoolean("StoreDebugMode", false);
            }
        }
        return O00000o;
    }

    public static void O000000o(boolean z) {
        if (O00000o0 == null || O00000o != z) {
            O00000o = z;
            if (O00000o0 == null) {
                O00000o0 = ServiceApplication.getAppContext().getSharedPreferences("miotStore1.0", 0);
            }
            SharedPreferences sharedPreferences = O00000o0;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putBoolean("StoreDebugMode", z).commit();
            }
        }
    }
}
