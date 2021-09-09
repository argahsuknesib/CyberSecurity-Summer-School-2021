package com.j256.ormlite.logger;

import android.support.v4.app.NotificationCompat;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.misc.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class LocalLog implements Log {
    private static final Log.Level DEFAULT_LEVEL = Log.Level.DEBUG;
    private static final List<PatternLevel> classLevels = readLevelResourceFile(LocalLog.class.getResourceAsStream("/ormliteLocalLog.properties"));
    private static final ThreadLocal<DateFormat> dateFormatThreadLocal = new ThreadLocal<DateFormat>() {
        /* class com.j256.ormlite.logger.LocalLog.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public final DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        }
    };
    private static PrintStream printStream;
    private final String className;
    private final Log.Level level;

    static {
        openLogFile(System.getProperty("com.j256.ormlite.logger.file"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r6 = com.j256.ormlite.logger.Log.Level.valueOf(r6.toUpperCase(java.util.Locale.ENGLISH));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0076, code lost:
        throw new java.lang.IllegalArgumentException("Level '" + r6 + "' was not found", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0052 */
    public LocalLog(String str) {
        this.className = LoggerFactory.getSimpleClassName(str);
        List<PatternLevel> list = classLevels;
        Log.Level level2 = null;
        if (list != null) {
            for (PatternLevel next : list) {
                if (next.pattern.matcher(str).matches() && (level2 == null || next.level.ordinal() < level2.ordinal())) {
                    level2 = next.level;
                }
            }
        }
        if (level2 == null) {
            String property = System.getProperty("com.j256.ormlite.logger.level");
            if (property == null) {
                level2 = DEFAULT_LEVEL;
            } else {
                Log.Level valueOf = Log.Level.valueOf(property.toUpperCase());
                level2 = valueOf;
            }
        }
        this.level = level2;
    }

    public static void openLogFile(String str) {
        if (str == null) {
            printStream = System.out;
            return;
        }
        try {
            printStream = new PrintStream(new File(str));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Log file " + str + " was not found", e);
        }
    }

    public boolean isLevelEnabled(Log.Level level2) {
        return this.level.isEnabled(level2);
    }

    public void log(Log.Level level2, String str) {
        printMessage(level2, str, null);
    }

    public void log(Log.Level level2, String str, Throwable th) {
        printMessage(level2, str, th);
    }

    /* access modifiers changed from: package-private */
    public void flush() {
        printStream.flush();
    }

    static List<PatternLevel> readLevelResourceFile(InputStream inputStream) {
        if (inputStream != null) {
            try {
                return configureClassLevels(inputStream);
            } catch (IOException e) {
                System.err.println("IO exception reading the log properties file '/ormliteLocalLog.properties': ".concat(String.valueOf(e)));
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
        }
        return null;
    }

    private static List<PatternLevel> configureClassLevels(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            if (!(readLine.length() == 0 || readLine.charAt(0) == '#')) {
                String[] split = readLine.split("=");
                if (split.length != 2) {
                    System.err.println("Line is not in the format of 'pattern = level': ".concat(String.valueOf(readLine)));
                } else {
                    try {
                        arrayList.add(new PatternLevel(Pattern.compile(split[0].trim()), Log.Level.valueOf(split[1].trim())));
                    } catch (IllegalArgumentException unused) {
                        PrintStream printStream2 = System.err;
                        printStream2.println("Level '" + split[1] + "' was not found");
                    }
                }
            }
        }
    }

    private void printMessage(Log.Level level2, String str, Throwable th) {
        if (isLevelEnabled(level2)) {
            StringBuilder sb = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
            sb.append(dateFormatThreadLocal.get().format(new Date()));
            sb.append(" [");
            sb.append(level2.name());
            sb.append("] ");
            sb.append(this.className);
            sb.append(' ');
            sb.append(str);
            printStream.println(sb.toString());
            if (th != null) {
                th.printStackTrace(printStream);
            }
        }
    }

    static class PatternLevel {
        Log.Level level;
        Pattern pattern;

        public PatternLevel(Pattern pattern2, Log.Level level2) {
            this.pattern = pattern2;
            this.level = level2;
        }
    }
}
