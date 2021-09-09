package com.j256.ormlite.logger;

import android.support.v4.app.NotificationCompat;
import com.j256.ormlite.logger.Log;
import java.lang.reflect.Array;

public class Logger {
    private static final Object UNKNOWN_ARG = new Object();
    private final Log log;

    public Logger(Log log2) {
        this.log = log2;
    }

    public boolean isLevelEnabled(Log.Level level) {
        return this.log.isLevelEnabled(level);
    }

    public void trace(String str) {
        Log.Level level = Log.Level.TRACE;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj, obj, null);
    }

    public void trace(String str, Object obj) {
        Log.Level level = Log.Level.TRACE;
        Object obj2 = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj2, obj2, null);
    }

    public void trace(String str, Object obj, Object obj2) {
        logIfEnabled(Log.Level.TRACE, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void trace(String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Log.Level.TRACE, null, str, obj, obj2, obj3, null);
    }

    public void trace(String str, Object[] objArr) {
        Log.Level level = Log.Level.TRACE;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj, obj, objArr);
    }

    public void trace(Throwable th, String str) {
        Log.Level level = Log.Level.TRACE;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj, obj, null);
    }

    public void trace(Throwable th, String str, Object obj) {
        Log.Level level = Log.Level.TRACE;
        Object obj2 = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj2, obj2, null);
    }

    public void trace(Throwable th, String str, Object obj, Object obj2) {
        logIfEnabled(Log.Level.TRACE, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void trace(Throwable th, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Log.Level.TRACE, th, str, obj, obj2, obj3, null);
    }

    public void trace(Throwable th, String str, Object[] objArr) {
        Log.Level level = Log.Level.TRACE;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj, obj, objArr);
    }

    public void debug(String str) {
        Log.Level level = Log.Level.DEBUG;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj, obj, null);
    }

    public void debug(String str, Object obj) {
        Log.Level level = Log.Level.DEBUG;
        Object obj2 = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj2, obj2, null);
    }

    public void debug(String str, Object obj, Object obj2) {
        logIfEnabled(Log.Level.DEBUG, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void debug(String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Log.Level.DEBUG, null, str, obj, obj2, obj3, null);
    }

    public void debug(String str, Object[] objArr) {
        Log.Level level = Log.Level.DEBUG;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj, obj, objArr);
    }

    public void debug(Throwable th, String str) {
        Log.Level level = Log.Level.DEBUG;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj, obj, null);
    }

    public void debug(Throwable th, String str, Object obj) {
        Log.Level level = Log.Level.DEBUG;
        Object obj2 = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj2, obj2, null);
    }

    public void debug(Throwable th, String str, Object obj, Object obj2) {
        logIfEnabled(Log.Level.DEBUG, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void debug(Throwable th, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Log.Level.DEBUG, th, str, obj, obj2, obj3, null);
    }

    public void debug(Throwable th, String str, Object[] objArr) {
        Log.Level level = Log.Level.DEBUG;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj, obj, objArr);
    }

    public void info(String str) {
        Log.Level level = Log.Level.INFO;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj, obj, null);
    }

    public void info(String str, Object obj) {
        Log.Level level = Log.Level.INFO;
        Object obj2 = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj2, obj2, null);
    }

    public void info(String str, Object obj, Object obj2) {
        logIfEnabled(Log.Level.INFO, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void info(String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Log.Level.INFO, null, str, obj, obj2, obj3, null);
    }

    public void info(String str, Object[] objArr) {
        Log.Level level = Log.Level.INFO;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj, obj, objArr);
    }

    public void info(Throwable th, String str) {
        Log.Level level = Log.Level.INFO;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj, obj, null);
    }

    public void info(Throwable th, String str, Object obj) {
        Log.Level level = Log.Level.INFO;
        Object obj2 = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj2, obj2, null);
    }

    public void info(Throwable th, String str, Object obj, Object obj2) {
        logIfEnabled(Log.Level.INFO, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void info(Throwable th, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Log.Level.INFO, th, str, obj, obj2, obj3, null);
    }

    public void info(Throwable th, String str, Object[] objArr) {
        Log.Level level = Log.Level.INFO;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj, obj, objArr);
    }

    public void warn(String str) {
        Log.Level level = Log.Level.WARNING;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj, obj, null);
    }

    public void warn(String str, Object obj) {
        Log.Level level = Log.Level.WARNING;
        Object obj2 = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj2, obj2, null);
    }

    public void warn(String str, Object obj, Object obj2) {
        logIfEnabled(Log.Level.WARNING, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void warn(String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Log.Level.WARNING, null, str, obj, obj2, obj3, null);
    }

    public void warn(String str, Object[] objArr) {
        Log.Level level = Log.Level.WARNING;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj, obj, objArr);
    }

    public void warn(Throwable th, String str) {
        Log.Level level = Log.Level.WARNING;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj, obj, null);
    }

    public void warn(Throwable th, String str, Object obj) {
        Log.Level level = Log.Level.WARNING;
        Object obj2 = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj2, obj2, null);
    }

    public void warn(Throwable th, String str, Object obj, Object obj2) {
        logIfEnabled(Log.Level.WARNING, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void warn(Throwable th, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Log.Level.WARNING, th, str, obj, obj2, obj3, null);
    }

    public void warn(Throwable th, String str, Object[] objArr) {
        Log.Level level = Log.Level.WARNING;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj, obj, objArr);
    }

    public void error(String str) {
        Log.Level level = Log.Level.ERROR;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj, obj, null);
    }

    public void error(String str, Object obj) {
        Log.Level level = Log.Level.ERROR;
        Object obj2 = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj2, obj2, null);
    }

    public void error(String str, Object obj, Object obj2) {
        logIfEnabled(Log.Level.ERROR, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void error(String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Log.Level.ERROR, null, str, obj, obj2, obj3, null);
    }

    public void error(String str, Object[] objArr) {
        Log.Level level = Log.Level.ERROR;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj, obj, objArr);
    }

    public void error(Throwable th, String str) {
        Log.Level level = Log.Level.ERROR;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj, obj, null);
    }

    public void error(Throwable th, String str, Object obj) {
        Log.Level level = Log.Level.ERROR;
        Object obj2 = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj2, obj2, null);
    }

    public void error(Throwable th, String str, Object obj, Object obj2) {
        logIfEnabled(Log.Level.ERROR, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void error(Throwable th, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Log.Level.ERROR, th, str, obj, obj2, obj3, null);
    }

    public void error(Throwable th, String str, Object[] objArr) {
        Log.Level level = Log.Level.ERROR;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj, obj, objArr);
    }

    public void fatal(String str) {
        Log.Level level = Log.Level.FATAL;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj, obj, null);
    }

    public void fatal(String str, Object obj) {
        Log.Level level = Log.Level.FATAL;
        Object obj2 = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj2, obj2, null);
    }

    public void fatal(String str, Object obj, Object obj2) {
        logIfEnabled(Log.Level.FATAL, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void fatal(String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Log.Level.FATAL, null, str, obj, obj2, obj3, null);
    }

    public void fatal(String str, Object[] objArr) {
        Log.Level level = Log.Level.FATAL;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj, obj, objArr);
    }

    public void fatal(Throwable th, String str) {
        Log.Level level = Log.Level.FATAL;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj, obj, null);
    }

    public void fatal(Throwable th, String str, Object obj) {
        Log.Level level = Log.Level.FATAL;
        Object obj2 = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj2, obj2, null);
    }

    public void fatal(Throwable th, String str, Object obj, Object obj2) {
        logIfEnabled(Log.Level.FATAL, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void fatal(Throwable th, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Log.Level.FATAL, th, str, obj, obj2, obj3, null);
    }

    public void fatal(Throwable th, String str, Object[] objArr) {
        Log.Level level = Log.Level.FATAL;
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj, obj, objArr);
    }

    public void log(Log.Level level, String str) {
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj, obj, null);
    }

    public void log(Log.Level level, String str, Object obj) {
        Object obj2 = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj2, obj2, null);
    }

    public void log(Log.Level level, String str, Object obj, Object obj2) {
        logIfEnabled(level, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void log(Log.Level level, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(level, null, str, obj, obj2, obj3, null);
    }

    public void log(Log.Level level, String str, Object[] objArr) {
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, null, str, obj, obj, obj, objArr);
    }

    public void log(Log.Level level, Throwable th, String str) {
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj, obj, null);
    }

    public void log(Log.Level level, Throwable th, String str, Object obj) {
        Object obj2 = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj2, obj2, null);
    }

    public void log(Log.Level level, Throwable th, String str, Object obj, Object obj2) {
        logIfEnabled(level, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void log(Log.Level level, Throwable th, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(level, th, str, obj, obj2, obj3, null);
    }

    public void log(Log.Level level, Throwable th, String str, Object[] objArr) {
        Object obj = UNKNOWN_ARG;
        logIfEnabled(level, th, str, obj, obj, obj, objArr);
    }

    private void logIfEnabled(Log.Level level, Throwable th, String str, Object obj, Object obj2, Object obj3, Object[] objArr) {
        if (this.log.isLevelEnabled(level)) {
            String buildFullMessage = buildFullMessage(str, obj, obj2, obj3, objArr);
            if (th == null) {
                this.log.log(level, buildFullMessage);
            } else {
                this.log.log(level, buildFullMessage, th);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.StringBuilder.append(java.lang.CharSequence, int, int):java.lang.StringBuilder}
     arg types: [java.lang.String, int, int]
     candidates:
      ClspMth{java.lang.StringBuilder.append(java.lang.CharSequence, int, int):java.lang.Appendable throws java.io.IOException}
      ClspMth{java.lang.StringBuilder.append(char[], int, int):java.lang.StringBuilder}
      ClspMth{java.lang.Appendable.append(java.lang.CharSequence, int, int):java.lang.Appendable throws java.io.IOException}
      ClspMth{java.lang.StringBuilder.append(java.lang.CharSequence, int, int):java.lang.StringBuilder} */
    private String buildFullMessage(String str, Object obj, Object obj2, Object obj3, Object[] objArr) {
        int i = 0;
        StringBuilder sb = null;
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf("{}", i);
            if (indexOf == -1) {
                break;
            }
            if (sb == null) {
                sb = new StringBuilder((int) NotificationCompat.FLAG_HIGH_PRIORITY);
            }
            sb.append((CharSequence) str, i, indexOf);
            i = indexOf + 2;
            if (objArr == null) {
                if (i2 == 0) {
                    appendArg(sb, obj);
                } else if (i2 == 1) {
                    appendArg(sb, obj2);
                } else if (i2 == 2) {
                    appendArg(sb, obj3);
                }
            } else if (i2 < objArr.length) {
                appendArg(sb, objArr[i2]);
            }
            i2++;
        }
        if (sb == null) {
            return str;
        }
        sb.append((CharSequence) str, i, str.length());
        return sb.toString();
    }

    private void appendArg(StringBuilder sb, Object obj) {
        if (obj == UNKNOWN_ARG) {
            return;
        }
        if (obj == null) {
            sb.append("null");
        } else if (obj.getClass().isArray()) {
            sb.append('[');
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(Array.get(obj, i));
            }
            sb.append(']');
        } else {
            sb.append(obj.toString());
        }
    }
}
