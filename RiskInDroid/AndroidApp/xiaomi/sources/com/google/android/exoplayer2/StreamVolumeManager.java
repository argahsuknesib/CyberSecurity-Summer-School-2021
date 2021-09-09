package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;

final class StreamVolumeManager {
    private final Context applicationContext;
    private final AudioManager audioManager = ((AudioManager) Assertions.checkStateNotNull((AudioManager) this.applicationContext.getSystemService("audio")));
    public final Handler eventHandler;
    private final Listener listener;
    private boolean muted = getMutedFromManager(this.audioManager, this.streamType);
    private VolumeChangeReceiver receiver;
    private int streamType = 3;
    private int volume = getVolumeFromManager(this.audioManager, this.streamType);

    public interface Listener {
        void onStreamTypeChanged(int i);

        void onStreamVolumeChanged(int i, boolean z);
    }

    public StreamVolumeManager(Context context, Handler handler, Listener listener2) {
        this.applicationContext = context.getApplicationContext();
        this.eventHandler = handler;
        this.listener = listener2;
        VolumeChangeReceiver volumeChangeReceiver = new VolumeChangeReceiver();
        try {
            this.applicationContext.registerReceiver(volumeChangeReceiver, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.receiver = volumeChangeReceiver;
        } catch (RuntimeException e) {
            Log.w("StreamVolumeManager", "Error registering stream volume receiver", e);
        }
    }

    public final void setStreamType(int i) {
        if (this.streamType != i) {
            this.streamType = i;
            updateVolumeAndNotifyIfChanged();
            this.listener.onStreamTypeChanged(i);
        }
    }

    public final int getMinVolume() {
        if (Util.SDK_INT >= 28) {
            return this.audioManager.getStreamMinVolume(this.streamType);
        }
        return 0;
    }

    public final int getMaxVolume() {
        return this.audioManager.getStreamMaxVolume(this.streamType);
    }

    public final int getVolume() {
        return this.volume;
    }

    public final boolean isMuted() {
        return this.muted;
    }

    public final void setVolume(int i) {
        if (i >= getMinVolume() && i <= getMaxVolume()) {
            this.audioManager.setStreamVolume(this.streamType, i, 1);
            updateVolumeAndNotifyIfChanged();
        }
    }

    public final void increaseVolume() {
        if (this.volume < getMaxVolume()) {
            this.audioManager.adjustStreamVolume(this.streamType, 1, 1);
            updateVolumeAndNotifyIfChanged();
        }
    }

    public final void decreaseVolume() {
        if (this.volume > getMinVolume()) {
            this.audioManager.adjustStreamVolume(this.streamType, -1, 1);
            updateVolumeAndNotifyIfChanged();
        }
    }

    public final void setMuted(boolean z) {
        if (Util.SDK_INT >= 23) {
            this.audioManager.adjustStreamVolume(this.streamType, z ? -100 : 100, 1);
        } else {
            this.audioManager.setStreamMute(this.streamType, z);
        }
        updateVolumeAndNotifyIfChanged();
    }

    public final void release() {
        VolumeChangeReceiver volumeChangeReceiver = this.receiver;
        if (volumeChangeReceiver != null) {
            try {
                this.applicationContext.unregisterReceiver(volumeChangeReceiver);
            } catch (RuntimeException e) {
                Log.w("StreamVolumeManager", "Error unregistering stream volume receiver", e);
            }
            this.receiver = null;
        }
    }

    public final void updateVolumeAndNotifyIfChanged() {
        int volumeFromManager = getVolumeFromManager(this.audioManager, this.streamType);
        boolean mutedFromManager = getMutedFromManager(this.audioManager, this.streamType);
        if (this.volume != volumeFromManager || this.muted != mutedFromManager) {
            this.volume = volumeFromManager;
            this.muted = mutedFromManager;
            this.listener.onStreamVolumeChanged(volumeFromManager, mutedFromManager);
        }
    }

    private static int getVolumeFromManager(AudioManager audioManager2, int i) {
        try {
            return audioManager2.getStreamVolume(i);
        } catch (RuntimeException e) {
            Log.w("StreamVolumeManager", "Could not retrieve stream volume for stream type ".concat(String.valueOf(i)), e);
            return audioManager2.getStreamMaxVolume(i);
        }
    }

    private static boolean getMutedFromManager(AudioManager audioManager2, int i) {
        if (Util.SDK_INT >= 23) {
            return audioManager2.isStreamMute(i);
        }
        return getVolumeFromManager(audioManager2, i) == 0;
    }

    final class VolumeChangeReceiver extends BroadcastReceiver {
        private VolumeChangeReceiver() {
        }

        public final void onReceive(Context context, Intent intent) {
            StreamVolumeManager.this.eventHandler.post(new Runnable() {
                /* class com.google.android.exoplayer2.$$Lambda$StreamVolumeManager$VolumeChangeReceiver$GBSF2uV8cR7F4Lk01XPY3pSaLFQ */

                public final void run() {
                    StreamVolumeManager.this.updateVolumeAndNotifyIfChanged();
                }
            });
        }
    }
}
