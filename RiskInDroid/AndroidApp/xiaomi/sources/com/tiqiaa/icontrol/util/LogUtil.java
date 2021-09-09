package com.tiqiaa.icontrol.util;

import android.util.Log;

public class LogUtil {
    private static boolean d_on = false;
    private static boolean e_on = false;
    private static boolean excp_on = false;
    private static boolean i_on = false;
    private static boolean v_on = false;
    private static boolean w_on = false;
    private static boolean wtf_on = false;

    public static void i(String str, String str2) {
        if (i_on) {
            Log.i(str, str2);
        }
    }

    public static void v(String str, String str2) {
        if (v_on) {
            Log.v(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (e_on) {
            Log.e(str, str2);
        }
    }

    public static void d(String str, String str2) {
        if (d_on) {
            Log.d(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (w_on) {
            Log.w(str, str2);
        }
    }

    public static void wtf(String str, String str2) {
        if (wtf_on) {
            Log.wtf(str, str2);
        }
    }

    public static void setI_off() {
        i_on = false;
    }

    public static void setV_off() {
        v_on = false;
    }

    public static void setE_off() {
        e_on = false;
    }

    public static void setD_off() {
        d_on = false;
    }

    public static void setW_off() {
        w_on = false;
    }

    public static void setWTF_off() {
        wtf_on = false;
    }

    public static void setAllLogOff() {
        i_on = false;
        v_on = false;
        e_on = false;
        d_on = false;
        w_on = false;
        wtf_on = false;
        excp_on = false;
    }

    public static void setAllLogOn() {
        i_on = true;
        v_on = true;
        e_on = true;
        d_on = true;
        w_on = true;
        wtf_on = true;
        excp_on = true;
    }

    public static void printException(Exception exc) {
        if (excp_on) {
            exc.printStackTrace();
        }
    }
}
