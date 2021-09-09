package com.mi.multimonitor;

import _m_j.ccz;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.mi.multimonitor.CrashReportBean;
import java.util.ArrayList;

public class CrashProcessor implements ICrashProcessor {
    private String mAppId;
    private Context mContext;
    private String mVersionName;

    CrashProcessor(Context context, String str, String str2) {
        this.mContext = context;
        this.mAppId = str;
        this.mVersionName = str2;
    }

    public CrashReportBean processorException(Thread thread, Throwable th) {
        if (th == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        if (thread != null) {
            arrayList.add(getThreadInfo(thread));
        }
        arrayList.add("Caused by: " + th.toString());
        arrayList.addAll(getStackStringList(th));
        while (th.getCause() != null) {
            th = th.getCause();
            arrayList.add("Caused by: " + th.toString());
            arrayList.addAll(getStackStringList(th));
        }
        CrashReportBean crashReportBean = new CrashReportBean();
        crashReportBean.mStackTraces = arrayList;
        crashReportBean.mExceptionSignature = makeExceptionSignature(th);
        return patch(crashReportBean);
    }

    private String makeExceptionSignature(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(th.getClass().getName());
        sb.append(";");
        sb.append((th.getStackTrace() == null || th.getStackTrace().length <= 0) ? "" : th.getStackTrace()[0].toString());
        return sb.toString();
    }

    private ArrayList<String> getStackStringList(Throwable th) {
        ArrayList<String> arrayList = new ArrayList<>();
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace != null) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                arrayList.add("\tat " + stackTraceElement.toString());
            }
        }
        return arrayList;
    }

    private String getThreadInfo(Thread thread) {
        return "threadName:" + thread.getName() + ",threadPriority:" + thread.getPriority() + ",threadState:" + thread.getState();
    }

    private CrashReportBean patch(CrashReportBean crashReportBean) {
        String str;
        String str2;
        crashReportBean.mCrashReportTime = System.currentTimeMillis() / 1000;
        crashReportBean.mAppId = this.mAppId;
        crashReportBean.mDisplay = new CrashReportBean.Display(this.mContext);
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) this.mContext.getSystemService("activity")).getMemoryInfo(memoryInfo);
        if (Build.VERSION.SDK_INT > 15) {
            crashReportBean.mTotalMemory = memoryInfo.totalMem;
        }
        crashReportBean.mAvailableMemory = memoryInfo.availMem;
        String packageName = this.mContext.getPackageName();
        crashReportBean.mPackageName = packageName;
        crashReportBean.mAppSignature = ccz.O000000o(this.mContext);
        try {
            PackageInfo packageInfo = this.mContext.getPackageManager().getPackageInfo(packageName, 1);
            if (this.mVersionName != null) {
                if (this.mVersionName.trim().length() != 0) {
                    str2 = this.mVersionName;
                    crashReportBean.mAppVersion = str2;
                    crashReportBean.mAppLastModifyTime = packageInfo.lastUpdateTime;
                    str = packageInfo.versionName;
                    crashReportBean.mVersionNameTrue = str;
                    return crashReportBean;
                }
            }
            str2 = String.valueOf(packageInfo.versionCode);
            crashReportBean.mAppVersion = str2;
            crashReportBean.mAppLastModifyTime = packageInfo.lastUpdateTime;
            str = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            str = "";
        }
        crashReportBean.mVersionNameTrue = str;
        return crashReportBean;
    }
}
