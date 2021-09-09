package com.miui.tsmclient.common.service;

import android.app.Service;
import android.text.TextUtils;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public abstract class CancellableService extends Service {
    private final Object mTaskLock = new Object();
    private Map<String, WeakReference<Thread>> mTaskMap = new HashMap();

    /* access modifiers changed from: protected */
    public void afterDoTask(String str) {
    }

    public void cancelTask(String str) {
        Thread thread;
        synchronized (this.mTaskLock) {
            WeakReference remove = this.mTaskMap.remove(str);
            if (!(remove == null || (thread = (Thread) remove.get()) == null)) {
                thread.interrupt();
                Log.v("TSMClient", "serviceTask:" + str + " thread:" + thread + " is interrupted");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void beforeDoTask(String str) {
        Thread.interrupted();
        addTask(str);
    }

    /* access modifiers changed from: protected */
    public void addTask(String str) {
        synchronized (this.mTaskLock) {
            if (!TextUtils.isEmpty(str)) {
                this.mTaskMap.put(str, new WeakReference(Thread.currentThread()));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void removeTask(String str) {
        synchronized (this.mTaskLock) {
            this.mTaskMap.remove(str);
        }
    }
}
