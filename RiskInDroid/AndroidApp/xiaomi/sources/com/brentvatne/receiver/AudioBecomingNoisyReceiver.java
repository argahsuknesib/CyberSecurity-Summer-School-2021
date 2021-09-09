package com.brentvatne.receiver;

import _m_j.un;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AudioBecomingNoisyReceiver extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Context f3570O000000o;
    public un O00000Oo = un.O000O0OO;

    public AudioBecomingNoisyReceiver(Context context) {
        this.f3570O000000o = context.getApplicationContext();
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.O00000Oo.O00000oo();
        }
    }
}
