package com.tencent.mars.xlog;

import _m_j.dir;

public class Xlog implements dir.O000000o {
    public static native void appenderOpen(int i, int i2, String str, String str2, String str3, int i3, String str4);

    public static native void logWrite(XLoggerInfo xLoggerInfo, String str);

    public static native void logWrite2(int i, String str, String str2, String str3, int i2, int i3, long j, long j2, String str4);

    public static native void setAppenderMode(int i);

    public static native void setConsoleLogOpen(boolean z);

    public static native void setErrLogOpen(boolean z);

    public static native void setLogLevel(int i);

    public static native void setMaxAliveTime(long j);

    public static native void setMaxFileSize(long j);

    public native void appenderClose();

    public native void appenderFlush(boolean z);

    public native int getLogLevel();

    static class XLoggerInfo {
        XLoggerInfo() {
        }
    }

    public final void O000000o(String str, String str2, String str3, int i, long j, long j2, String str4) {
        logWrite2(0, str, str2, str3, 0, i, j, j2, str4);
    }

    public final void O00000o0(String str, String str2, String str3, int i, long j, long j2, String str4) {
        logWrite2(1, str, str2, str3, 0, i, j, j2, str4);
    }

    public final void O00000Oo(String str, String str2, String str3, int i, long j, long j2, String str4) {
        logWrite2(2, str, str2, str3, 0, i, j, j2, str4);
    }

    public final void O00000o(String str, String str2, String str3, int i, long j, long j2, String str4) {
        logWrite2(3, str, str2, str3, 0, i, j, j2, str4);
    }

    public final void O00000oO(String str, String str2, String str3, int i, long j, long j2, String str4) {
        logWrite2(4, str, str2, str3, 0, i, j, j2, str4);
    }

    public final void O00000oo(String str, String str2, String str3, int i, long j, long j2, String str4) {
        logWrite2(5, str, str2, str3, 0, i, j, j2, str4);
    }
}
