package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

final class AudioBecomingNoisyManager {
    private final Context context;
    private final AudioBecomingNoisyReceiver receiver;
    public boolean receiverRegistered;

    public interface EventListener {
        void onAudioBecomingNoisy();
    }

    public AudioBecomingNoisyManager(Context context2, Handler handler, EventListener eventListener) {
        this.context = context2.getApplicationContext();
        this.receiver = new AudioBecomingNoisyReceiver(handler, eventListener);
    }

    public final void setEnabled(boolean z) {
        if (z && !this.receiverRegistered) {
            this.context.registerReceiver(this.receiver, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.receiverRegistered = true;
        } else if (!z && this.receiverRegistered) {
            this.context.unregisterReceiver(this.receiver);
            this.receiverRegistered = false;
        }
    }

    final class AudioBecomingNoisyReceiver extends BroadcastReceiver implements Runnable {
        private final Handler eventHandler;
        private final EventListener listener;

        public AudioBecomingNoisyReceiver(Handler handler, EventListener eventListener) {
            this.eventHandler = handler;
            this.listener = eventListener;
        }

        public final void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.eventHandler.post(this);
            }
        }

        public final void run() {
            if (AudioBecomingNoisyManager.this.receiverRegistered) {
                this.listener.onAudioBecomingNoisy();
            }
        }
    }
}
