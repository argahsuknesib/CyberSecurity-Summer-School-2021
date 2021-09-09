package com.xiaomi.account.diagnosis.util;

import com.xiaomi.account.diagnosis.DiagnosisConstants;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LogcatCollector {
    private static final ThreadLocal<SimpleDateFormat> sFormat = new ThreadLocal<SimpleDateFormat>() {
        /* class com.xiaomi.account.diagnosis.util.LogcatCollector.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public final SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
        }
    };

    private LogcatCollector() {
    }

    private static File getOutputLogcatFileWithTime() {
        String format = sFormat.get().format(new Date());
        File logcatSubDir = DiagnosisConstants.getLogcatSubDir();
        return new File(logcatSubDir, format + ".logcat");
    }

    public static File collectLogcat() {
        File outputLogcatFileWithTime = getOutputLogcatFileWithTime();
        File parentFile = outputLogcatFileWithTime.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            return null;
        }
        try {
            Runtime.getRuntime().exec("logcat -d -f " + outputLogcatFileWithTime.getAbsolutePath()).waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return outputLogcatFileWithTime;
    }
}
