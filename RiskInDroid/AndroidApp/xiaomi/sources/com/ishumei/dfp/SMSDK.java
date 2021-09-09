package com.ishumei.dfp;

import _m_j.blu;
import android.content.Context;
import java.io.IOException;

public class SMSDK {
    static {
        try {
            System.loadLibrary("smsdk");
        } catch (Throwable th) {
            blu.O000000o(th);
        }
    }

    public static int O000000o(String str) {
        try {
            return new SMSDK().z3(str);
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    public static String O000000o(Context context) {
        try {
            return new SMSDK().z1(context);
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    public static String O000000o(String str, String str2) {
        try {
            return new SMSDK().x2(str, str2);
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    public static String O000000o(boolean z, String str, boolean z2, String str2) {
        try {
            return new SMSDK().y2(true, str, z2, str2);
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    public static String O00000Oo(String str, String str2) {
        try {
            return new SMSDK().x4(str, str2);
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    public static String O00000o0(String str, String str2) {
        try {
            return new SMSDK().x6(str, str2);
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private native String x2(String str, String str2);

    private native String x4(String str, String str2);

    private native String x6(String str, String str2);

    private native String y2(boolean z, String str, boolean z2, String str2);

    private native String z1(Context context);

    private native int z3(String str);
}
