package com.xiaomi.smarthome.crashpin;

public class CrashPin {
    private static CrashPinCallback mCallback;

    public interface CrashPinCallback {
        void onNativeCrash(String str);
    }

    public static native void nativeInitial();

    public static native void testCrash();

    static {
        System.loadLibrary("crashpin");
    }

    public static void initial(CrashPinCallback crashPinCallback) {
        mCallback = crashPinCallback;
        nativeInitial();
    }

    public static void onNativeCrash(String str) {
        CrashPinCallback crashPinCallback = mCallback;
        if (crashPinCallback != null) {
            crashPinCallback.onNativeCrash(str);
        }
    }
}
