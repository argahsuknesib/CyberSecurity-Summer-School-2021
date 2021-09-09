package com.xiaomi.mico.api.logger;

import _m_j.gsy;
import android.util.Log;
import com.xiaomi.accountsdk.utils.AccountLog;

public class AndroidAccountLog extends AccountLog {
    private String mTag;

    public AndroidAccountLog(String str) {
        this.mTag = str;
    }

    public int logV(String str, String str2) {
        String str3 = this.mTag;
        return gsy.O000000o(2, str3, "(" + str + ") --- " + str2);
    }

    public int logV(String str, String str2, Throwable th) {
        String str3 = this.mTag;
        return Log.v(str3, "(" + str + ") --- " + str2, th);
    }

    public int logD(String str, String str2) {
        String str3 = this.mTag;
        return gsy.O000000o(3, str3, "(" + str + ") --- " + str2);
    }

    public int logD(String str, String str2, Throwable th) {
        String str3 = this.mTag;
        return Log.d(str3, "(" + str + ") --- " + str2, th);
    }

    public int logI(String str, String str2) {
        String str3 = this.mTag;
        return gsy.O000000o(4, str3, "(" + str + ") --- " + str2);
    }

    public int logI(String str, String str2, Throwable th) {
        String str3 = this.mTag;
        return Log.i(str3, "(" + str + ") --- " + str2, th);
    }

    public int logW(String str, String str2) {
        String str3 = this.mTag;
        return gsy.O000000o(5, str3, "(" + str + ") --- " + str2);
    }

    public int logW(String str, String str2, Throwable th) {
        String str3 = this.mTag;
        return Log.w(str3, "(" + str + ") --- " + str2, th);
    }

    public int logW(String str, Throwable th) {
        String str2 = this.mTag;
        return Log.w(str2, "(" + str + ") ---", th);
    }

    public int logE(String str, String str2) {
        String str3 = this.mTag;
        return gsy.O000000o(6, str3, "(" + str + ") --- " + str2);
    }

    public int logE(String str, String str2, Throwable th) {
        String str3 = this.mTag;
        return Log.e(str3, "(" + str + ") --- " + str2, th);
    }
}
