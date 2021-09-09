package com.xiaomi.smarthome.application;

import _m_j.dxw;
import _m_j.fab;
import _m_j.fac;
import _m_j.ftm;
import _m_j.gfr;
import _m_j.gpq;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.multidex.MultiDexApplication;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class CommonApplication extends MultiDexApplication implements Application.ActivityLifecycleCallbacks {
    private static AtomicInteger activeActivityCount = new AtomicInteger(0);
    private static AtomicInteger activityCount = null;
    protected static long mAppEnterTime;
    private static Map<Integer, WeakReference<Activity>> sActivityStack = new LinkedHashMap();
    protected static boolean sApplicationStart = false;
    protected static Handler sGlobalHandler;
    protected static Handler sGlobalWorkerHandler;
    private static boolean sHasEnteredForeground = false;
    private static volatile IWXAPI sIWXAPI;
    private static Object sIWXAPILock = new Object();
    protected static final O00000Oo<CommonApplication> sInstance = new O00000Oo<>();
    private static boolean sIsInSplitScreenMode = false;
    public static volatile long sOnCreateTime;
    public Runnable mResetRepeatedCrashRunnable;
    gpq sGlobalWorkerThread;

    public interface O000000o<T> {
        T O000000o();
    }

    public abstract ClassLoader createLoader(long j, long j2, String str);

    public abstract String getPushId();

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public abstract void onApplicationLifeCycleStart();

    public abstract Dialog showAppLoginDialog(Activity activity, boolean z);

    public static Handler getGlobalHandler() {
        return sGlobalHandler;
    }

    public static Handler getGlobalWorkerHandler() {
        return sGlobalWorkerHandler;
    }

    public static CommonApplication getApplication() {
        return (CommonApplication) sInstance.f4211O000000o;
    }

    public static boolean isApplicationStart() {
        return sApplicationStart;
    }

    public static boolean hasEnteredForeground() {
        return sHasEnteredForeground;
    }

    public static void enterForeground() {
        sHasEnteredForeground = true;
    }

    public static int getForegroundActivityCount() {
        AtomicInteger atomicInteger = activityCount;
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    public boolean isAppForeground() {
        return activeActivityCount.get() > 0;
    }

    public static Map<Integer, WeakReference<Activity>> getActivityStack() {
        return sActivityStack;
    }

    public static long getOnCreateTime() {
        return sOnCreateTime;
    }

    public static boolean isCurrentHotStart() {
        return System.currentTimeMillis() - getOnCreateTime() > 1000;
    }

    public static boolean shouldInitFacebookSdk() {
        return TextUtils.equals("GooglePlay", gfr.O0000o0O);
    }

    public void attachBaseContext(Context context) {
        dxw.O00000Oo().O000000o();
        super.attachBaseContext(context);
        sInstance.f4211O000000o = this;
        if (sGlobalHandler == null) {
            sGlobalHandler = new Handler();
        }
        if (this.sGlobalWorkerThread == null) {
            this.sGlobalWorkerThread = new gpq("GlobalWorker");
            this.sGlobalWorkerThread.start();
            sGlobalWorkerHandler = new Handler(this.sGlobalWorkerThread.getLooper());
        }
        registerActivityLifecycleCallbacks(this);
    }

    public static Context getAppContext() {
        return (Context) sInstance.f4211O000000o;
    }

    public void onCreate() {
        super.onCreate();
        if (!ftm.O000000o(this)) {
            setWebCacheDir();
        }
    }

    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        if (ftm.O000000o(this)) {
            setWebCacheDir();
        }
    }

    private void setWebCacheDir() {
        String O00000o0 = ftm.O00000o0(this);
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                String[] split = O00000o0.split(":");
                WebView.setDataDirectorySuffix(split.length == 2 ? split[1] : "main");
            }
        } catch (Throwable unused) {
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        sActivityStack.put(Integer.valueOf(activity.hashCode()), new WeakReference(activity));
    }

    public void onActivityStarted(Activity activity) {
        AtomicInteger atomicInteger = activityCount;
        if (atomicInteger == null) {
            activityCount = new AtomicInteger(1);
        } else if (atomicInteger.getAndIncrement() == 0) {
            mAppEnterTime = System.currentTimeMillis();
        }
    }

    public void onActivityResumed(Activity activity) {
        activeActivityCount.incrementAndGet();
    }

    public void onActivityPaused(Activity activity) {
        activeActivityCount.decrementAndGet();
    }

    public void onActivityStopped(Activity activity) {
        AtomicInteger atomicInteger = activityCount;
        if (atomicInteger != null) {
            atomicInteger.decrementAndGet();
        }
    }

    public void onActivityDestroyed(Activity activity) {
        sActivityStack.remove(Integer.valueOf(activity.hashCode()));
    }

    public static class O00000Oo<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        T f4211O000000o;

        protected O00000Oo() {
        }
    }

    public static void addApplicationLifeCycle(fab fab) {
        if (!fac.O000000o().f15994O000000o.contains(fab)) {
            fac.O000000o().f15994O000000o.add(fab);
        }
    }

    public static boolean isInSplitScreenMode() {
        return sIsInSplitScreenMode;
    }

    public static void setInSplitScreenMode(boolean z) {
        sIsInSplitScreenMode = z;
    }

    public static IWXAPI getSHIWXAPI() {
        if (sIWXAPI == null) {
            synchronized (sIWXAPILock) {
                if (sIWXAPI == null) {
                    IWXAPI createWXAPI = WXAPIFactory.createWXAPI(getAppContext(), "wx54b959a68fb6f580", true);
                    sIWXAPI = createWXAPI;
                    createWXAPI.registerApp("wx54b959a68fb6f580");
                }
            }
        }
        return sIWXAPI;
    }
}
