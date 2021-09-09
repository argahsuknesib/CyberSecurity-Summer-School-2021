package com.xiaomi.smarthome.international;

import _m_j.ft;
import _m_j.gpr;
import _m_j.hsq;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ServerHelper$2 extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ ft f9059O000000o;
    final /* synthetic */ gpr O00000Oo;

    public ServerHelper$2(ft ftVar, gpr gpr) {
        this.f9059O000000o = ftVar;
        this.O00000Oo = gpr;
    }

    public final void onReceive(Context context, Intent intent) {
        this.f9059O000000o.O000000o(this);
        hsq hsq = (hsq) this.O00000Oo.f18128O000000o;
        this.O00000Oo.f18128O000000o = null;
        int intExtra = intent.getIntExtra("param_key", 0);
        if (intExtra == 1) {
            if (hsq != null) {
                hsq.O000000o();
            }
        } else if (intExtra == 2 && hsq != null) {
            hsq.O00000Oo();
        }
    }
}
