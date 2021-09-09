package com.xiaomi.mi_connect_service.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileLogger {
    private static FileLogger sIntance;
    private String mAppLogDir;
    private String mCrashLogDir;
    private String mCurrentAppLogFile;
    private Handler mHandler;
    private boolean mIsInited = false;
    private String mMisLogDir;
    private String mPackageName;
    private int mPid;
    private long mVersionCode;
    private String mVersionName;
    private FileOutputStream mWriter;

    public static final FileLogger getInstance() {
        synchronized (FileLogger.class) {
            if (sIntance == null) {
                sIntance = new FileLogger();
            }
        }
        return sIntance;
    }

    private FileLogger() {
    }

    /* access modifiers changed from: package-private */
    public void init(Context context) {
        String str;
        if (DeviceUtil.isMiPhone()) {
            str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/MIUI/debug_log/" + context.getPackageName();
        } else if (!DeviceUtil.isMiTv()) {
            str = new File(context.getCacheDir(), "debug_log").getAbsolutePath();
        } else if (new File("/data/log/").exists()) {
            str = "/data/log/" + context.getPackageName();
        } else {
            str = context.getFilesDir().getAbsolutePath() + "/log/";
        }
        this.mAppLogDir = str + "/app_log";
        this.mMisLogDir = str + "/mis_log";
        this.mCrashLogDir = str + "/crash_log";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.mVersionName = packageInfo.versionName;
            if (Build.VERSION.SDK_INT >= 28) {
                this.mVersionCode = packageInfo.getLongVersionCode();
            } else {
                this.mVersionCode = (long) packageInfo.versionCode;
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("FileLogger", "", e);
        }
        this.mPid = Process.myPid();
        this.mPackageName = context.getPackageName();
        HandlerThread handlerThread = new HandlerThread("FileLogger");
        handlerThread.start();
        this.mHandler = new LogHanler(handlerThread.getLooper());
        this.mIsInited = true;
    }

    public void log(String str, String str2, String str3, Throwable th) {
        log(str, str2, str3, th, Process.myTid());
    }

    private void log(String str, String str2, String str3, Throwable th, int i) {
        if (this.mIsInited) {
            this.mHandler.obtainMessage(0, new LogInfo(this.mPid, i, str, str2, str3, System.currentTimeMillis(), th)).sendToTarget();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x010d A[SYNTHETIC, Splitter:B:28:0x010d] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x011c A[SYNTHETIC, Splitter:B:38:0x011c] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0127 A[SYNTHETIC, Splitter:B:44:0x0127] */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:35:0x0117=Splitter:B:35:0x0117, B:25:0x0108=Splitter:B:25:0x0108} */
    public void logCrash(Thread thread, Throwable th) {
        File andCheckLogFile;
        if (this.mIsInited && (andCheckLogFile = getAndCheckLogFile(this.mCrashLogDir)) != null) {
            String format = new SimpleDateFormat("MM-dd HH:mm:ss.SSS").format(new Date());
            FileOutputStream fileOutputStream = null;
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("------------------------ CRASHED: " + this.mPackageName + " ------------------------\n");
                sb.append("PID: " + this.mPid + "\n");
                sb.append("TID: " + thread.getId() + " " + thread.getName() + "\n");
                StringBuilder sb2 = new StringBuilder("APP VERSIONNAME: ");
                sb2.append(this.mVersionName);
                sb2.append("\n");
                sb.append(sb2.toString());
                sb.append("APP VERSIONCODE: " + this.mVersionCode + "\n");
                sb.append("CRASHTIME: " + format + "\n");
                sb.append("REASON: \n");
                sb.append(getStackFromThrowable(th));
                sb.append("\n\n\n");
                log("E", "CRASH", sb.toString(), null, (int) thread.getId());
                FileOutputStream fileOutputStream2 = new FileOutputStream(andCheckLogFile, true);
                try {
                    fileOutputStream2.write(sb.toString().getBytes());
                    fileOutputStream2.flush();
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e) {
                        Log.e("FileLogger", "", e);
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    Log.e("FileLogger", "", e);
                    if (fileOutputStream == null) {
                    }
                } catch (IOException e3) {
                    e = e3;
                    fileOutputStream = fileOutputStream2;
                    try {
                        Log.e("FileLogger", "", e);
                        if (fileOutputStream == null) {
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                Log.e("FileLogger", "", e4);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                    }
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
                Log.e("FileLogger", "", e);
                if (fileOutputStream == null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        Log.e("FileLogger", "", e6);
                    }
                }
            } catch (IOException e7) {
                e = e7;
                Log.e("FileLogger", "", e);
                if (fileOutputStream == null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e8) {
                        Log.e("FileLogger", "", e8);
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException}
     arg types: [java.io.File, int]
     candidates:
      ClspMth{java.io.FileOutputStream.<init>(java.lang.String, boolean):void throws java.io.FileNotFoundException}
      ClspMth{java.io.FileOutputStream.<init>(java.io.File, boolean):void throws java.io.FileNotFoundException} */
    public void writeAppLogToFile(LogInfo logInfo) {
        File andCheckLogFile = getAndCheckLogFile(this.mAppLogDir);
        if (andCheckLogFile != null) {
            try {
                if (this.mCurrentAppLogFile == null || this.mCurrentAppLogFile.equals(andCheckLogFile.getName())) {
                    this.mCurrentAppLogFile = andCheckLogFile.getName();
                    if (this.mWriter != null) {
                        this.mWriter.close();
                    }
                    this.mWriter = new FileOutputStream(andCheckLogFile, true);
                }
                this.mWriter.write(logInfo.toLogString().getBytes());
                this.mWriter.flush();
            } catch (Exception e) {
                Log.e("FileLogger", "", e);
            }
        }
    }

    public String getMisLogFilePath() {
        File andCheckLogFile = getAndCheckLogFile(this.mMisLogDir);
        if (andCheckLogFile == null) {
            return null;
        }
        return andCheckLogFile.getAbsolutePath();
    }

    private File getAndCheckLogFile(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, new SimpleDateFormat("yyyyMMdd").format(new Date()));
        if (!file2.exists()) {
            checkLogFiles(str);
            try {
                if (!file2.createNewFile()) {
                    file2 = null;
                }
            } catch (IOException e) {
                Log.e("FileLogger", "", e);
                return null;
            }
        } else if (file2.isDirectory()) {
            return null;
        }
        return file2;
    }

    private void checkLogFiles(String str) {
        File[] listFiles = new File(str).listFiles(new FileFilter() {
            /* class com.xiaomi.mi_connect_service.util.FileLogger.AnonymousClass1 */

            public boolean accept(File file) {
                if (file.isDirectory()) {
                    return false;
                }
                String name = file.getName();
                if (name.length() != 8) {
                    return false;
                }
                int i = -1;
                try {
                    i = Integer.parseInt(name);
                } catch (Exception unused) {
                }
                if (i <= 0) {
                    return false;
                }
                return true;
            }
        });
        if (listFiles != null && listFiles.length > 7) {
            ArrayList arrayList = new ArrayList();
            for (File add : listFiles) {
                arrayList.add(add);
            }
            while (arrayList.size() > 7) {
                int i = 0;
                for (int i2 = 1; i2 < arrayList.size(); i2++) {
                    if (Integer.parseInt(((File) arrayList.get(i2)).getName()) < Integer.valueOf(Integer.parseInt(((File) arrayList.get(i)).getName())).intValue()) {
                        i = i2;
                    }
                }
                ((File) arrayList.get(i)).delete();
                arrayList.remove(i);
            }
        }
    }

    class LogHanler extends Handler {
        LogHanler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what == 0) {
                FileLogger.this.writeAppLogToFile((LogInfo) message.obj);
            }
        }
    }

    class LogInfo {
        long date;
        String msg;
        int pid;
        String priority;
        String tag;
        int tid;
        Throwable tr;

        LogInfo(int i, int i2, String str, String str2, String str3, long j, Throwable th) {
            this.pid = i;
            this.tid = i2;
            this.priority = str;
            this.tag = str2;
            this.msg = str3;
            this.date = j;
            this.tr = th;
        }

        public String toLogString() {
            String format = new SimpleDateFormat("MM-dd HH:mm:ss.SSS").format(new Date(this.date));
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s %d %d %s %s : %s\n", format, Integer.valueOf(this.pid), Integer.valueOf(this.tid), this.priority, this.tag, this.msg));
            Throwable th = this.tr;
            if (th != null) {
                sb.append(FileLogger.getStackFromThrowable(th));
            }
            return sb.toString();
        }
    }

    public static String getStackFromThrowable(Throwable th) {
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringWriter stringWriter = new StringWriter();
        try {
            PrintWriter printWriter = new PrintWriter(stringWriter);
            if (th != null) {
                th.printStackTrace(printWriter);
            }
            sb.append(stringWriter.toString());
            return sb.toString();
        } finally {
            try {
                stringWriter.close();
            } catch (IOException unused) {
            }
        }
    }
}
