package com.xiaomi.smarthome.framework.page;

import _m_j.fut;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public enum ActivityStack {
    instance;
    
    private ConcurrentLinkedQueue<fut> mActivityListeners = new ConcurrentLinkedQueue<>();

    public final ConcurrentLinkedQueue<fut> getActivityListeners() {
        return this.mActivityListeners;
    }

    public final void registerActivityListener(fut fut) {
        this.mActivityListeners.add(fut);
    }

    public final void unregisterActivityListener(fut fut) {
        this.mActivityListeners.remove(fut);
    }

    public final void doClearOnServerChanged() {
        HashSet<fut> hashSet = new HashSet<>();
        Iterator<fut> it = this.mActivityListeners.iterator();
        while (it.hasNext()) {
            fut next = it.next();
            try {
                next.onServerChanged();
            } catch (Exception unused) {
                hashSet.add(next);
            }
        }
        for (fut remove : hashSet) {
            this.mActivityListeners.remove(remove);
        }
        try {
            CoreApi.O000000o().O00000Oo().clearWhiteList();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
