package com.hzy.tvmao.utils;

import android.annotation.TargetApi;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.C;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogUtil {
    public static boolean DEBUG = false;
    public static boolean allowD = false;
    public static boolean allowE = false;
    public static boolean allowI = false;
    public static boolean allowV = false;
    public static boolean allowW = false;
    public static boolean allowWrite = false;
    public static boolean allowWtf = false;
    public static a customLogger = null;
    public static String customTagPrefix = "";
    private static FileWriter mFileWriter;
    private static String mLogPath;

    public interface a {
        void a(String str, String str2);

        void a(String str, String str2, Throwable th);

        void a(String str, Throwable th);

        void b(String str, String str2);

        void b(String str, String str2, Throwable th);

        void b(String str, Throwable th);

        void c(String str, String str2);

        void c(String str, String str2, Throwable th);

        void d(String str, String str2);

        void d(String str, String str2, Throwable th);

        void e(String str, String str2);

        void e(String str, String str2, Throwable th);

        void f(String str, String str2);

        void f(String str, String str2, Throwable th);
    }

    static {
        if (Environment.getExternalStorageState().equals("mounted")) {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            mLogPath = externalStorageDirectory.getAbsolutePath() + File.separator + "log.txt";
        }
        boolean z = DEBUG;
        allowE = z;
        allowI = z;
        allowV = z;
        allowW = z;
        allowWtf = z;
        allowWrite = z;
    }

    private LogUtil() {
    }

    public static void setDebugMode(boolean z) {
        DEBUG = false;
        allowD = z;
        allowE = z;
        allowI = z;
        allowV = z;
        allowW = z;
        allowWtf = z;
        allowWrite = z;
    }

    private static String generateTag(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        String format = String.format("%s.%s(L:%d)", className.substring(className.lastIndexOf(".") + 1), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()));
        if (TextUtils.isEmpty(customTagPrefix)) {
            return format;
        }
        return customTagPrefix + ":" + format;
    }

    public static void d(String str) {
        if (allowD) {
            String generateTag = generateTag(getCallerStackTraceElement());
            a aVar = customLogger;
            if (aVar != null) {
                aVar.a(generateTag, str);
            } else {
                Log.d(generateTag, str);
            }
        }
    }

    public static void d(String str, Throwable th) {
        if (allowD) {
            String generateTag = generateTag(getCallerStackTraceElement());
            a aVar = customLogger;
            if (aVar != null) {
                aVar.a(generateTag, str, th);
            } else {
                Log.d(generateTag, str, th);
            }
        }
    }

    public static void e(String str) {
        if (allowE) {
            String generateTag = generateTag(getCallerStackTraceElement());
            a aVar = customLogger;
            if (aVar != null) {
                aVar.b(generateTag, str);
            } else {
                Log.e(generateTag, str);
            }
        }
    }

    public static void e(String str, Throwable th) {
        if (allowE) {
            String generateTag = generateTag(getCallerStackTraceElement());
            a aVar = customLogger;
            if (aVar != null) {
                aVar.b(generateTag, str, th);
            } else {
                Log.e(generateTag, str, th);
            }
        }
    }

    public static void i(String str) {
        if (allowI) {
            String generateTag = generateTag(getCallerStackTraceElement());
            a aVar = customLogger;
            if (aVar != null) {
                aVar.c(generateTag, str);
            } else {
                Log.i(generateTag, str);
            }
        }
    }

    public static void i(String str, Throwable th) {
        if (allowI) {
            String generateTag = generateTag(getCallerStackTraceElement());
            a aVar = customLogger;
            if (aVar != null) {
                aVar.c(generateTag, str, th);
            } else {
                Log.i(generateTag, str, th);
            }
        }
    }

    public static void v(String str) {
        if (allowV) {
            String generateTag = generateTag(getCallerStackTraceElement());
            a aVar = customLogger;
            if (aVar != null) {
                aVar.d(generateTag, str);
            } else {
                Log.v(generateTag, str);
            }
        }
    }

    public static void v(String str, Throwable th) {
        if (allowV) {
            String generateTag = generateTag(getCallerStackTraceElement());
            a aVar = customLogger;
            if (aVar != null) {
                aVar.d(generateTag, str, th);
            } else {
                Log.v(generateTag, str, th);
            }
        }
    }

    public static void w(String str) {
        if (allowW) {
            String generateTag = generateTag(getCallerStackTraceElement());
            a aVar = customLogger;
            if (aVar != null) {
                aVar.e(generateTag, str);
            } else {
                Log.w(generateTag, str);
            }
        }
    }

    public static void w(String str, Throwable th) {
        if (allowW) {
            String generateTag = generateTag(getCallerStackTraceElement());
            a aVar = customLogger;
            if (aVar != null) {
                aVar.e(generateTag, str, th);
            } else {
                Log.w(generateTag, str, th);
            }
        }
    }

    public static void w(Throwable th) {
        if (allowW) {
            String generateTag = generateTag(getCallerStackTraceElement());
            a aVar = customLogger;
            if (aVar != null) {
                aVar.a(generateTag, th);
            } else {
                Log.w(generateTag, th);
            }
        }
    }

    @TargetApi(C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public static void wtf(String str) {
        if (allowWtf) {
            String generateTag = generateTag(getCallerStackTraceElement());
            a aVar = customLogger;
            if (aVar != null) {
                aVar.f(generateTag, str);
            } else {
                Log.wtf(generateTag, str);
            }
        }
    }

    @TargetApi(C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public static void wtf(String str, Throwable th) {
        if (allowWtf) {
            String generateTag = generateTag(getCallerStackTraceElement());
            a aVar = customLogger;
            if (aVar != null) {
                aVar.f(generateTag, str, th);
            } else {
                Log.wtf(generateTag, str, th);
            }
        }
    }

    @TargetApi(C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public static void wtf(Throwable th) {
        if (allowWtf) {
            String generateTag = generateTag(getCallerStackTraceElement());
            a aVar = customLogger;
            if (aVar != null) {
                aVar.b(generateTag, th);
            } else {
                Log.wtf(generateTag, th);
            }
        }
    }

    public static void write(String str) {
        if (allowWrite) {
            Log.e(generateTag(getCallerStackTraceElement()), str);
            writeLog(str);
        }
    }

    private static void writeLog(String str) {
        try {
            if (mFileWriter == null) {
                mFileWriter = new FileWriter(new File(mLogPath));
            }
            mFileWriter.write(str);
            mFileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StackTraceElement getCallerStackTraceElement() {
        return Thread.currentThread().getStackTrace()[4];
    }
}
