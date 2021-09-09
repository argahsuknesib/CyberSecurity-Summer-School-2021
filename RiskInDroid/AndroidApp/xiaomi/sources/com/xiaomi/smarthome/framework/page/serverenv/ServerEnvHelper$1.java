package com.xiaomi.smarthome.framework.page.serverenv;

import _m_j.ft;
import _m_j.fvx;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ServerEnvHelper$1 extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ ft f7932O000000o;
    final /* synthetic */ fvx.O000000o O00000Oo;

    public ServerEnvHelper$1(ft ftVar, fvx.O000000o o000000o) {
        this.f7932O000000o = ftVar;
        this.O00000Oo = o000000o;
    }

    public final void onReceive(Context context, Intent intent) {
        fvx.O000000o o000000o;
        this.f7932O000000o.O000000o(this);
        if (intent.getIntExtra("param_key", 0) == 1 && (o000000o = this.O00000Oo) != null) {
            o000000o.O000000o();
        }
    }
}
