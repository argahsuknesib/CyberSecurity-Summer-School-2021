package _m_j;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class ccx {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Context f13643O000000o = null;
    private static String O00000Oo = null;
    private static String O00000o = null;
    private static String O00000o0 = null;
    private static String O00000oO = null;
    private static String O00000oo = null;
    private static String O0000O0o = null;
    private static String O0000OOo = "";
    private static ArrayList<String> O0000Oo = null;
    private static String O0000Oo0 = "";

    public static void O000000o(Application application, String str, String str2) {
        f13643O000000o = application;
        O00000Oo = str;
        O00000o0 = str2;
        cdh.O000000o();
        O00000oO = String.valueOf(cdh.O00000Oo());
        application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            /* class _m_j.ccx.AnonymousClass1 */

            public final void onActivityCreated(Activity activity, Bundle bundle) {
            }

            public final void onActivityDestroyed(Activity activity) {
            }

            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public final void onActivityStarted(Activity activity) {
            }

            public final void onActivityStopped(Activity activity) {
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ccx.O000000o(android.app.Activity, boolean):void
             arg types: [android.app.Activity, int]
             candidates:
              _m_j.ccx.O000000o(android.content.Context, java.lang.String):void
              _m_j.ccx.O000000o(android.app.Activity, boolean):void */
            public final void onActivityResumed(Activity activity) {
                ccx.O000000o(activity, true);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ccx.O000000o(android.app.Activity, boolean):void
             arg types: [android.app.Activity, int]
             candidates:
              _m_j.ccx.O000000o(android.content.Context, java.lang.String):void
              _m_j.ccx.O000000o(android.app.Activity, boolean):void */
            public final void onActivityPaused(Activity activity) {
                ccx.O000000o(activity, false);
            }
        });
    }

    public static Context O000000o() {
        return f13643O000000o;
    }

    public static String O00000Oo() {
        return O00000Oo;
    }

    public static String O00000o0() {
        return O00000o0;
    }

    public static String O00000o() {
        if (!TextUtils.isEmpty(O00000o)) {
            return O00000o;
        }
        try {
            PackageInfo packageInfo = f13643O000000o.getPackageManager().getPackageInfo(f13643O000000o.getPackageName(), 16384);
            if (packageInfo != null) {
                O00000o = String.valueOf(packageInfo.versionCode);
            }
        } catch (Exception unused) {
        }
        return O00000o;
    }

    public static String O00000oO() {
        return cde.O000000o(f13643O000000o, "installFrom", "");
    }

    public static void O000000o(Activity activity, boolean z) {
        ArrayList<String> arrayList = O0000Oo;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<String> it = O0000Oo.iterator();
            while (it.hasNext()) {
                if (activity.getClass().getName().contains(it.next())) {
                    if (z) {
                        cdg.O000000o().O00000o();
                        Context applicationContext = activity.getApplicationContext();
                        O000000o(applicationContext, O0000Oo0 + activity.getClass().getSimpleName());
                        return;
                    }
                    cdg.O000000o().O00000oO();
                    O0000Oo();
                    return;
                }
            }
        } else if (z) {
            cdg.O000000o().O00000o();
            Context applicationContext2 = activity.getApplicationContext();
            O000000o(applicationContext2, O0000Oo0 + activity.getClass().getSimpleName());
        } else {
            cdg.O000000o().O00000oO();
            O0000Oo();
        }
    }

    private static void O000000o(Context context, String str) {
        if (context != null && cdg.O000000o() != null && !ccv.O000000o().disableStat) {
            cdg.O000000o();
            cdg.O000000o(context, str);
        }
    }

    private static void O0000Oo() {
        if (cdg.O000000o() != null && !ccv.O000000o().disableStat) {
            cdg.O000000o().O00000oo();
        }
    }

    public static String O00000oo() {
        return O00000oo;
    }

    public static void O000000o(String str) {
        O00000oo = str;
    }

    public static String O0000O0o() {
        return O0000O0o;
    }

    public static void O00000Oo(String str) {
        O0000O0o = str;
    }

    public static void O000000o(ArrayList<String> arrayList) {
        O0000Oo = arrayList;
    }

    public static String O0000OOo() {
        return O0000OOo;
    }

    public static void O00000o0(String str) {
        O0000OOo = str;
    }

    public static void O0000Oo0() {
        O0000OOo = "";
    }
}
