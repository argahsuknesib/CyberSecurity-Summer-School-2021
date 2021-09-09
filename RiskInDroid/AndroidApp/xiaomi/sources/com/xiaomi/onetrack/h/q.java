package com.xiaomi.onetrack.h;

import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.onetrack.f.a;

public class q {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f6178a = false;
    public static boolean b = false;
    public static boolean c;

    public static void a() {
        try {
            String d = a.d();
            String a2 = aa.a("debug.onetrack.log");
            boolean z = true;
            f6178a = !TextUtils.isEmpty(a2) && !TextUtils.isEmpty(d) && TextUtils.equals(d, a2);
            String a3 = aa.a("debug.onetrack.upload");
            b = !TextUtils.isEmpty(a3) && !TextUtils.isEmpty(d) && TextUtils.equals(d, a3);
            String a4 = aa.a("debug.onetrack.test");
            if (TextUtils.isEmpty(a4) || TextUtils.isEmpty(d) || !TextUtils.equals(d, a4)) {
                z = false;
            }
            c = z;
        } catch (Exception e) {
            Log.e("OneTrackSdk", "LogUtil static initializer: " + e.toString());
        }
        Log.d("OneTrackSdk", "log on: " + f6178a + ", quick upload on: " + b);
    }

    public static void a(String str, String str2) {
        if (f6178a) {
            a(a(str), str2, 3);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (f6178a) {
            Log.d(a(str), str2, th);
        }
    }

    public static void b(String str, String str2) {
        if (f6178a) {
            a(a(str), str2, 0);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (f6178a) {
            Log.e(a(str), str2, th);
        }
    }

    public static void c(String str, String str2) {
        if (f6178a) {
            a(a(str), str2, 1);
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (f6178a) {
            Log.w(a(str), str2, th);
        }
    }

    public static void d(String str, String str2) {
        if (f6178a) {
            a(a(str), str2, 2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (f6178a) {
            Log.i(a(str), str2, th);
        }
    }

    private static void a(String str, String str2, int i) {
        if (str2 != null) {
            int i2 = 0;
            while (i2 <= str2.length() / 3000) {
                int i3 = i2 * 3000;
                i2++;
                int min = Math.min(str2.length(), i2 * 3000);
                if (i3 < min) {
                    String substring = str2.substring(i3, min);
                    if (i == 0) {
                        Log.e(str, substring);
                    } else if (i == 1) {
                        Log.w(str, substring);
                    } else if (i == 2) {
                        Log.i(str, substring);
                    } else if (i == 3) {
                        Log.d(str, substring);
                    } else if (i == 4) {
                        Log.v(str, substring);
                    }
                }
            }
        }
    }

    public static String a(String str) {
        return "OneTrack-Api-".concat(String.valueOf(str));
    }
}
