package com.xiaomi.push.service;

import _m_j.duv;
import android.content.ComponentName;
import android.content.pm.PackageManager;

class cf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ XMPushService f6548a;

    cf(XMPushService xMPushService) {
        this.f6548a = xMPushService;
    }

    public void run() {
        try {
            PackageManager packageManager = this.f6548a.getApplicationContext().getPackageManager();
            ComponentName componentName = new ComponentName(this.f6548a.getApplicationContext(), "com.xiaomi.push.service.receivers.PingReceiver");
            if (packageManager.getComponentEnabledSetting(componentName) != 2) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        } catch (Throwable th) {
            duv.O000000o("[Alarm] disable ping receiver may be failure. ".concat(String.valueOf(th)));
        }
    }
}
