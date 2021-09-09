package com.google.android.gms.common.logging;

import android.annotation.SuppressLint;
import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

public class Logger {
    private final String mTag;
    private final String zzud;
    private final GmsLogger zzvd;
    private final int zzve;

    private Logger(String str, String str2) {
        this.zzud = str2;
        this.mTag = str;
        this.zzvd = new GmsLogger(str);
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.mTag, i)) {
            i++;
        }
        this.zzve = i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public Logger(String str, String... strArr) {
        this(str, r8);
        String str2;
        if (strArr.length == 0) {
            str2 = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str3 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str3);
            }
            sb.append(']');
            sb.append(' ');
            str2 = sb.toString();
        }
    }

    public void d(String str, Throwable th, Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.mTag, format(str, objArr), th);
        }
    }

    public void d(String str, Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.mTag, format(str, objArr));
        }
    }

    public void e(String str, Throwable th, Object... objArr) {
        Log.e(this.mTag, format(str, objArr), th);
    }

    public void e(String str, Object... objArr) {
        Log.e(this.mTag, format(str, objArr));
    }

    public String elidePii(Object obj) {
        boolean canLogPii = this.zzvd.canLogPii();
        if (obj == null) {
            return "<NULL>";
        }
        String trim = obj.toString().trim();
        if (trim.isEmpty()) {
            return "<EMPTY>";
        }
        if (canLogPii) {
            return trim;
        }
        return String.format("<ELLIDED:%s>", Integer.valueOf(trim.hashCode()));
    }

    /* access modifiers changed from: protected */
    public String format(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.zzud.concat(str);
    }

    public String getTag() {
        return this.mTag;
    }

    public void i(String str, Throwable th, Object... objArr) {
        Log.i(this.mTag, format(str, objArr), th);
    }

    public void i(String str, Object... objArr) {
        Log.i(this.mTag, format(str, objArr));
    }

    public boolean isLoggable(int i) {
        return this.zzve <= i;
    }

    public boolean isPiiLoggable() {
        return this.zzvd.canLogPii();
    }

    public void v(String str, Throwable th, Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.mTag, format(str, objArr), th);
        }
    }

    public void v(String str, Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.mTag, format(str, objArr));
        }
    }

    public void w(String str, Throwable th, Object... objArr) {
        Log.w(this.mTag, format(str, objArr), th);
    }

    public void w(String str, Object... objArr) {
        Log.w(this.mTag, format(str, objArr));
    }

    public void w(Throwable th) {
        Log.w(this.mTag, th);
    }

    public void wtf(String str, Throwable th, Object... objArr) {
        Log.wtf(this.mTag, format(str, objArr), th);
    }

    @SuppressLint({"WtfWithoutException"})
    public void wtf(String str, Object... objArr) {
        Log.wtf(this.mTag, format(str, objArr));
    }

    public void wtf(Throwable th) {
        Log.wtf(this.mTag, th);
    }
}
