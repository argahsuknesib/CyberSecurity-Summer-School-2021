package com.xiaomi.smarthome.library.common.floatingview;

import _m_j.gns;
import _m_j.gnt;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class FloatingView$2 extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ gnt f9126O000000o;

    public FloatingView$2(gnt gnt) {
        this.f9126O000000o = gnt;
    }

    public final void onReceive(Context context, Intent intent) {
        Activity attachActivity = gnt.f18057O000000o.getAttachActivity();
        if (attachActivity != null && !attachActivity.isFinishing()) {
            if (gns.O00000o0()) {
                this.f9126O000000o.O000000o(attachActivity);
            } else {
                this.f9126O000000o.O00000Oo(attachActivity);
            }
        }
    }
}
