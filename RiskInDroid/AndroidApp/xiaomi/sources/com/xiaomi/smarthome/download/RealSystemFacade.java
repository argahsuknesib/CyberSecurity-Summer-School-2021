package com.xiaomi.smarthome.download;

import _m_j.frm;
import _m_j.gsy;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class RealSystemFacade implements frm {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f7318O000000o;
    private NotificationManager O00000Oo;
    private boolean O00000o0 = false;

    public RealSystemFacade(Context context) {
        this.f7318O000000o = context;
        this.O00000Oo = (NotificationManager) this.f7318O000000o.getSystemService("notification");
    }

    public final long O000000o() {
        return System.currentTimeMillis();
    }

    public final Integer O00000Oo() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f7318O000000o.getSystemService("connectivity");
        if (connectivityManager == null) {
            gsy.O000000o(5, "DownloadManager", "couldn't get connectivity manager");
            return null;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return Integer.valueOf(activeNetworkInfo.getType());
        }
        gsy.O000000o(2, "DownloadManager", "network is not available");
        return null;
    }

    public final boolean O00000o0() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f7318O000000o.getSystemService("connectivity");
        boolean z = false;
        if (connectivityManager == null) {
            gsy.O000000o(5, "DownloadManager", "couldn't get connectivity manager");
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.getType() == 0;
        TelephonyManager telephonyManager = (TelephonyManager) this.f7318O000000o.getSystemService("phone");
        if (z2 && telephonyManager.isNetworkRoaming()) {
            z = true;
        }
        if (z) {
            gsy.O000000o(2, "DownloadManager", "network is roaming");
        }
        return z;
    }

    public final Long O00000o() {
        return 20971520L;
    }

    public final Long O00000oO() {
        return 10485760L;
    }

    public final void O000000o(Intent intent) {
        this.f7318O000000o.sendBroadcast(intent);
    }

    public final boolean O000000o(int i, String str) throws PackageManager.NameNotFoundException {
        return this.f7318O000000o.getPackageManager().getApplicationInfo(str, 0).uid == i;
    }

    public final void O000000o(long j) {
        this.O00000Oo.cancel((int) j);
    }

    public final void O00000oo() {
        this.O00000Oo.cancelAll();
    }

    public final void O000000o(Thread thread) {
        thread.start();
    }

    public final void O0000O0o() {
        this.O00000o0 = true;
    }

    public final boolean O0000OOo() {
        return this.O00000o0;
    }
}
