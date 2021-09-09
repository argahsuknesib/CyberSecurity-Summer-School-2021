package com.mi.multimonitor;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;

public class CrashReport {
    private static String META_DATA_ID = "com.mi.monitor.APP_ID";
    private static String TAG = "CrashReport";
    public static boolean isForSdk = false;
    private static CrashReport singleton;
    private Context context;
    private Executor executor;
    private ICrashProcessor mCrashProcessor;
    private UncaughtExceptionHunter mUncaughtExceptionHunter;

    CrashReport(Context context2, String str, String str2) {
        if (!isForSdk) {
            this.context = context2;
            String checkAppId = checkAppId(context2, str);
            this.executor = new Executor(TAG);
            checkCrashCache(this.executor);
            this.mCrashProcessor = new CrashProcessor(context2, checkAppId, str2);
            this.mUncaughtExceptionHunter = new UncaughtExceptionHunter(new CrashSender(context2, this.executor, this.mCrashProcessor));
        }
    }

    public static CrashReport initialize(Context context2, String str) {
        if (singleton == null) {
            synchronized (CrashReport.class) {
                if (singleton == null) {
                    singleton = new Builder(context2).appId(str).build();
                }
            }
        }
        return singleton;
    }

    public static CrashReport initialize(Context context2) {
        return initialize(context2, null);
    }

    public static CrashReport get() {
        return singleton;
    }

    public static void setSingletonInstance(CrashReport crashReport) {
        synchronized (CrashReport.class) {
            singleton = crashReport;
        }
    }

    public static void postCrash(Thread thread, Throwable th) {
        if (!isForSdk) {
            get().sendCrashData(thread, th, null);
        }
    }

    public static void postCrash(Throwable th) {
        if (!isForSdk) {
            get().sendCrashData(null, th, null);
        }
    }

    public static void postCrash(Thread thread, Throwable th, String str) {
        if (!isForSdk) {
            get().sendCrashData(thread, th, str);
        }
    }

    public static void postRNCrash(Thread thread, Throwable th, String str) {
        if (!isForSdk) {
            get().sendCrashData(thread, th, str);
        }
    }

    public static void postRNCrash(Throwable th, String str) {
        if (!isForSdk) {
            get().sendCrashData(null, th, str);
        }
    }

    public static void postCrash(Throwable th, String str) {
        if (!isForSdk) {
            get().sendCrashData(null, th, str);
        }
    }

    private String checkAppId(Context context2, String str) {
        if (TextUtils.isEmpty(str)) {
            try {
                Bundle bundle = context2.getPackageManager().getApplicationInfo(context2.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY).metaData;
                if (bundle != null) {
                    str = bundle.getString(META_DATA_ID);
                }
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new NullPointerException("appId is null");
    }

    private void checkCrashCache(Executor executor2) {
        if (!isForSdk) {
            DiskCache diskCache = new DiskCache(this.context);
            File crashCacheFile = diskCache.getCrashCacheFile();
            if (crashCacheFile.exists() && crashCacheFile.length() > 0) {
                executor2.execute(new CrashCacheRequest(diskCache, crashCacheFile));
            }
        }
    }

    private void sendCrashData(Thread thread, Throwable th, String str) {
        CrashReportBean processorException;
        if (!isForSdk && (processorException = this.mCrashProcessor.processorException(thread, th)) != null) {
            processorException.tag = "manually";
            if (!TextUtils.isEmpty(str)) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add("----------------RN Crash----------------");
                arrayList.add(str);
                arrayList.addAll(processorException.mStackTraces);
                processorException.mStackTraces = arrayList;
            }
            Context context2 = this.context;
            if (thread == null) {
                thread = Thread.currentThread();
            }
            this.executor.execute(new CrashRequest(context2, thread, th, processorException));
        }
    }

    public static class Builder {
        private final Context context;
        private boolean isForSdk;
        private String mAppId;
        private String mVersionName;

        public Builder(Context context2) {
            this.context = context2.getApplicationContext();
        }

        public Builder appId(String str) {
            this.mAppId = str;
            return this;
        }

        public Builder version(String str) {
            this.mVersionName = str;
            return this;
        }

        public Builder isForSdk(boolean z) {
            this.isForSdk = z;
            return this;
        }

        public CrashReport build() {
            CrashReport.isForSdk = this.isForSdk;
            return new CrashReport(this.context, this.mAppId, this.mVersionName);
        }
    }
}
