package com.amap.openapi;

import _m_j.qh;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;

public class av$1 extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ qh f3556O000000o;

    public av$1(qh qhVar) {
        this.f3556O000000o = qhVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|(1:6)|7|8|(1:16)(2:11|13)) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0012 */
    public final void onReceive(Context context, Intent intent) {
        boolean z = true;
        NetworkInfo activeNetworkInfo = this.f3556O000000o.O00000o.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            z = false;
        }
        if (isInitialStickyBroadcast() && z) {
            this.f3556O000000o.O000000o();
        }
    }
}
