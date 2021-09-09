package com.mijia.generalplayer.utils;

import _m_j.cim;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class AudioBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f5220O000000o;

    public interface O000000o {
        void setAudioMode(int i);
    }

    public AudioBroadcastReceiver(O000000o o000000o) {
        this.f5220O000000o = o000000o;
    }

    public void onReceive(Context context, Intent intent) {
        if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
            if (cim.O000000o()) {
                this.f5220O000000o.setAudioMode(3);
            } else if (cim.O000000o(context)) {
                this.f5220O000000o.setAudioMode(2);
            } else {
                this.f5220O000000o.setAudioMode(1);
            }
        } else if ("android.intent.action.HEADSET_PLUG".equals(intent.getAction()) && intent.hasExtra("state")) {
            intent.getIntExtra("state", 0);
            if (intent.getIntExtra("state", 0) == 0) {
                if (cim.O000000o()) {
                    this.f5220O000000o.setAudioMode(3);
                } else {
                    this.f5220O000000o.setAudioMode(1);
                }
            } else if (intent.getIntExtra("state", 0) == 1) {
                this.f5220O000000o.setAudioMode(2);
            }
        }
    }

    public final void O000000o(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        context.registerReceiver(this, intentFilter);
    }
}
