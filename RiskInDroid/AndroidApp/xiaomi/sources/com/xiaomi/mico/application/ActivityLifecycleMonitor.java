package com.xiaomi.mico.application;

import _m_j.cub;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.HashSet;
import java.util.Set;

class ActivityLifecycleMonitor implements Application.ActivityLifecycleCallbacks {
    private static final String TAG = "ActivityLifecycleMonitor";
    private Set<Activity> activitys = new HashSet();
    private int mCount = 0;
    private boolean mEnableMonitor = false;
    private boolean mForeground = false;
    private final ValidAppStateMonitor mMonitor;

    interface ValidAppStateMonitor {
        void onAppValid(boolean z);

        void onValidAppEnterBackground();

        void onValidAppEnterForeground();
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    ActivityLifecycleMonitor(ValidAppStateMonitor validAppStateMonitor) {
        this.mMonitor = validAppStateMonitor;
        checkAppState();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Class<?> O00000Oo = cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.SmartHomeMainActivity");
        if (activity != null && O00000Oo != null && activity.getClass() == O00000Oo) {
            this.mEnableMonitor = true;
            this.mMonitor.onAppValid(true);
        }
    }

    public void onActivityStarted(Activity activity) {
        this.mCount++;
        this.activitys.add(activity);
        checkAppState();
    }

    public void onActivityStopped(Activity activity) {
        if (this.activitys.remove(activity)) {
            this.mCount--;
        }
        checkAppState();
    }

    public void onActivityDestroyed(Activity activity) {
        Class<?> O00000Oo = cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.SmartHomeMainActivity");
        if (activity != null && O00000Oo != null && activity.getClass() == O00000Oo) {
            this.mEnableMonitor = false;
            this.mMonitor.onAppValid(false);
            if (this.mForeground) {
                this.mForeground = false;
                this.mMonitor.onValidAppEnterBackground();
            }
        }
    }

    private void checkAppState() {
        if (this.mEnableMonitor) {
            if (this.mCount == 1 && !this.mForeground) {
                this.mForeground = true;
                this.mMonitor.onValidAppEnterForeground();
                return;
            } else if (this.mCount != 0 || !this.mForeground) {
                return;
            }
        } else if (CommonApplication.getForegroundActivityCount() > 0) {
            this.mForeground = true;
            this.mMonitor.onValidAppEnterForeground();
            return;
        }
        this.mForeground = false;
        this.mMonitor.onValidAppEnterBackground();
    }
}
