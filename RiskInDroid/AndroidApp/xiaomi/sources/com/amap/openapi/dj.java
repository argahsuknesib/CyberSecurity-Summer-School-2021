package com.amap.openapi;

import _m_j.om;
import _m_j.sq;
import _m_j.ss;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.util.List;

public class dj implements ss {

    /* renamed from: O000000o  reason: collision with root package name */
    private WifiManager f3559O000000o;

    public dj(Context context) {
        this.f3559O000000o = (WifiManager) context.getSystemService("wifi");
    }

    public final List<ScanResult> O000000o() {
        try {
            if (this.f3559O000000o == null) {
                return null;
            }
            return this.f3559O000000o.getScanResults();
        } catch (SecurityException unused) {
            om.O00000Oo("@_24_3_@", "@_24_3_1_@");
            return null;
        }
    }

    public final void O000000o(Context context, final sq.O000000o o000000o) {
        try {
            context.getApplicationContext().registerReceiver(new BroadcastReceiver() {
                /* class com.amap.openapi.dj.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                sq.O000000o f3560O000000o = o000000o;

                public final void onReceive(Context context, Intent intent) {
                    sq.O000000o o000000o;
                    if (intent != null && "android.net.wifi.SCAN_RESULTS".equals(intent.getAction()) && (o000000o = this.f3560O000000o) != null) {
                        o000000o.O000000o();
                    }
                }
            }, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        } catch (Throwable unused) {
        }
    }

    public final boolean O00000Oo() {
        String str;
        try {
            return this.f3559O000000o != null && this.f3559O000000o.startScan();
        } catch (SecurityException unused) {
            str = "@_24_3_2_@";
            om.O00000Oo("@_24_3_@", str);
            return false;
        } catch (Exception e) {
            str = "@_24_3_3_@" + e.toString();
            om.O00000Oo("@_24_3_@", str);
            return false;
        }
    }

    public final boolean O00000o0() {
        try {
            if (this.f3559O000000o == null) {
                return false;
            }
            return this.f3559O000000o.isWifiEnabled();
        } catch (Exception e) {
            om.O000000o("@_24_3_@", "@_24_3_9_@", e);
            return false;
        }
    }
}
