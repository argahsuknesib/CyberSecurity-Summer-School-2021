package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import com.google.android.exoplayer2.util.Log;

final class WakeLockManager {
    private boolean enabled;
    private final PowerManager powerManager;
    private boolean stayAwake;
    private PowerManager.WakeLock wakeLock;

    public WakeLockManager(Context context) {
        this.powerManager = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    public final void setEnabled(boolean z) {
        if (z && this.wakeLock == null) {
            PowerManager powerManager2 = this.powerManager;
            if (powerManager2 == null) {
                Log.w("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            } else {
                this.wakeLock = powerManager2.newWakeLock(1, "ExoPlayer:WakeLockManager");
                this.wakeLock.setReferenceCounted(false);
            }
        }
        this.enabled = z;
        updateWakeLock();
    }

    public final void setStayAwake(boolean z) {
        this.stayAwake = z;
        updateWakeLock();
    }

    @SuppressLint({"WakelockTimeout"})
    private void updateWakeLock() {
        PowerManager.WakeLock wakeLock2 = this.wakeLock;
        if (wakeLock2 != null) {
            if (!this.enabled || !this.stayAwake) {
                this.wakeLock.release();
            } else {
                wakeLock2.acquire();
            }
        }
    }
}
