package com.payu.magicretry.Helpers;

import android.util.Log;

public class L {
    private static int sLogLevel = 2;

    public static synchronized void t(String str) {
        synchronized (L.class) {
            if (sLogLevel <= 2) {
                Log.v("PAYU-TIMESTAMP", str);
            }
        }
    }

    public static synchronized void v(String str, String str2) {
        synchronized (L.class) {
            if (sLogLevel <= 2) {
                Log.v(str, str2);
            }
        }
    }

    public static synchronized void v(String str) {
        synchronized (L.class) {
            if (sLogLevel <= 2) {
                Log.v("### PAYU ####", str);
            }
        }
    }

    public static synchronized void v(int i) {
        synchronized (L.class) {
            if (sLogLevel <= 2) {
                v("### PAYU ####", String.valueOf(i));
            }
        }
    }

    public static synchronized void v(String str, int i) {
        synchronized (L.class) {
            if (sLogLevel <= 2) {
                v(str, String.valueOf(i));
            }
        }
    }

    public static synchronized void d(String str, String str2) {
        synchronized (L.class) {
            if (sLogLevel <= 4) {
                Log.d(str, str2);
            }
        }
    }

    public static synchronized void w(String str, String str2) {
        synchronized (L.class) {
            if (sLogLevel <= 5) {
                Log.w(str, str2);
            }
        }
    }

    public static synchronized void i(String str, String str2) {
        synchronized (L.class) {
            if (sLogLevel <= 3) {
                Log.i(str, str2);
            }
        }
    }

    public static synchronized void e(String str, String str2) {
        synchronized (L.class) {
            if (sLogLevel <= 6) {
                Log.e(str, str2);
            }
        }
    }
}
