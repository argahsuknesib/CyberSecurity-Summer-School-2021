package com.mi.multimonitor;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Locale;

public class CrashReportBean {
    public String mAppData;
    public String mAppId;
    public long mAppLastModifyTime;
    public String mAppLocal = Locale.getDefault().getCountry();
    public String mAppSignature;
    public String mAppVersion;
    public long mAvailableMemory;
    public long mCrashOccurredTime = (System.currentTimeMillis() / 1000);
    public long mCrashReportTime;
    public String mDeviceName = Build.MODEL;
    public Display mDisplay;
    public String mExceptionSignature;
    public String mOsName = "Android";
    public String mOsVersion = Build.VERSION.RELEASE;
    public String mPackageName;
    public ArrayList<String> mStackTraces;
    public long mTotalMemory;
    public String mUserIp = "";
    public String mVersionNameTrue;
    public String rnDetailException;
    public String tag;

    public static class Display {
        public int height;
        public int width;

        public Display(Context context) {
            android.view.Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            this.width = point.x;
            this.height = point.y;
        }
    }
}
