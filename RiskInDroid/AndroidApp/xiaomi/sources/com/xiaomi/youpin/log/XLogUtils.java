package com.xiaomi.youpin.log;

import _m_j.dir;
import android.util.Log;
import com.tencent.mars.xlog.Xlog;

public class XLogUtils {

    public static class Builder {
        private String mCachePath;
        private int mCacheday;
        private int mLevel;
        private String mLogPath;
        private int mModel;
        private String mNamePrefix;
        private String mPubkey;

        public Builder() {
            System.loadLibrary("marsxlog");
        }

        public Builder setLevel(boolean z) {
            if (z) {
                this.mLevel = 1;
            } else {
                this.mLevel = 2;
            }
            return this;
        }

        public Builder setModel(int i) {
            this.mModel = i;
            return this;
        }

        public Builder setLogPath(String str) {
            this.mLogPath = str;
            return this;
        }

        public Builder setCachePath(String str) {
            this.mCachePath = str;
            return this;
        }

        public Builder setConsoleLogOpen(boolean z) {
            Xlog.setConsoleLogOpen(z);
            return this;
        }

        public Builder setCacheDay() {
            setCacheDay(0);
            return this;
        }

        public Builder setCacheDay(int i) {
            this.mCacheday = i;
            return this;
        }

        public Builder setNamePrefix(String str) {
            this.mNamePrefix = str;
            return this;
        }

        public Builder setPubKey(String str) {
            this.mPubkey = str;
            return this;
        }

        public Builder setXLog(Xlog xlog) {
            dir.O000000o(xlog);
            return this;
        }

        public Builder setMaxFileSize(long j) {
            Xlog.setMaxFileSize(j);
            return this;
        }

        public Builder setMaxAliveTime(long j) {
            Xlog.setMaxAliveTime(j);
            return this;
        }

        public void init() {
            Xlog.appenderOpen(this.mLevel, this.mModel, this.mCachePath, this.mLogPath, this.mNamePrefix, this.mCacheday, this.mPubkey);
        }
    }

    public static void d(String str, String str2) {
        dir.O00000oO(str, str2);
    }

    public static void d(String str, String str2, Throwable th) {
        dir.O00000oO(str, getTrMessage(str2, th));
    }

    public static void i(String str, String str2) {
        dir.O00000o(str, str2);
    }

    public static void i(String str, String str2, Throwable th) {
        dir.O00000o(str, getTrMessage(str2, th));
    }

    public static void f(String str, String str2) {
        dir.O000000o(str, str2);
    }

    public static void f(String str, String str2, Throwable th) {
        dir.O000000o(str, getTrMessage(str2, th));
    }

    public static void v(String str, String str2) {
        dir.O00000oo(str, str2);
    }

    public static void v(String str, String str2, Throwable th) {
        dir.O00000oo(str, getTrMessage(str2, th));
    }

    public static void e(String str, String str2) {
        dir.O00000Oo(str, str2);
    }

    public static void e(String str, Throwable th) {
        dir.O00000Oo(str, getTrMessage("", th));
    }

    public static void e(String str, String str2, Throwable th) {
        dir.O00000Oo(str, getTrMessage(str2, th));
    }

    public static void w(String str, String str2) {
        dir.O00000o0(str, str2);
    }

    public static void w(String str, Throwable th) {
        dir.O00000o0(str, getTrMessage("", th));
    }

    public static void w(String str, String str2, Throwable th) {
        dir.O00000o0(str, getTrMessage(str2, th));
    }

    public static void appenderFlush(boolean z) {
        dir.O000000o(z);
    }

    public static void appenderClose() {
        dir.O000000o();
    }

    private static String getTrMessage(String str, Throwable th) {
        return str + "\n" + Log.getStackTraceString(th);
    }
}
