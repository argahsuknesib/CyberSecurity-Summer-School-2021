package com.xiaomi.account.diagnosis.log;

import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.account.diagnosis.util.ProcessUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LogHeader {
    private static final ThreadLocal<SimpleDateFormat> sFormat = new ThreadLocal<SimpleDateFormat>() {
        /* class com.xiaomi.account.diagnosis.log.LogHeader.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public final SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        }
    };
    private static String sProcessName;

    private LogHeader() {
    }

    private static String getFormattedTime() {
        return sFormat.get().format(new Date());
    }

    public static String format(LogLevel logLevel, String str) {
        String cachedProcessName = getCachedProcessName();
        int myPid = Process.myPid();
        int myTid = Process.myTid();
        return getFormattedTime() + " " + myPid + "-" + myTid + "/" + cachedProcessName + " " + logLevel.toString() + "/" + str + ": ";
    }

    private static String getCachedProcessName() {
        if (sProcessName == null) {
            String processName = ProcessUtils.getProcessName(Process.myPid());
            if (TextUtils.isEmpty(processName)) {
                sProcessName = "UnknownProcess";
            } else {
                sProcessName = processName;
            }
        }
        return sProcessName;
    }
}
