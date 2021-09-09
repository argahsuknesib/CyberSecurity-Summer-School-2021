package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.util.Util;

public final class VideoFrameReleaseTimeHelper {
    private long adjustedLastFrameTimeNs;
    private final DefaultDisplayListener displayListener;
    private long frameCount;
    private boolean haveSync;
    private long lastFramePresentationTimeUs;
    private long pendingAdjustedFrameTimeNs;
    private long syncFramePresentationTimeNs;
    private long syncUnadjustedReleaseTimeNs;
    private long vsyncDurationNs;
    private long vsyncOffsetNs;
    private final VSyncSampler vsyncSampler;
    private final WindowManager windowManager;

    public VideoFrameReleaseTimeHelper() {
        this(null);
    }

    public VideoFrameReleaseTimeHelper(Context context) {
        DefaultDisplayListener defaultDisplayListener = null;
        if (context != null) {
            context = context.getApplicationContext();
            this.windowManager = (WindowManager) context.getSystemService("window");
        } else {
            this.windowManager = null;
        }
        if (this.windowManager != null) {
            this.displayListener = Util.SDK_INT >= 17 ? maybeBuildDefaultDisplayListenerV17(context) : defaultDisplayListener;
            this.vsyncSampler = VSyncSampler.getInstance();
        } else {
            this.displayListener = null;
            this.vsyncSampler = null;
        }
        this.vsyncDurationNs = -9223372036854775807L;
        this.vsyncOffsetNs = -9223372036854775807L;
    }

    @TargetApi(17)
    public final void enable() {
        this.haveSync = false;
        if (this.windowManager != null) {
            this.vsyncSampler.addObserver();
            DefaultDisplayListener defaultDisplayListener = this.displayListener;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.register();
            }
            updateDefaultDisplayRefreshRateParams();
        }
    }

    @TargetApi(17)
    public final void disable() {
        if (this.windowManager != null) {
            DefaultDisplayListener defaultDisplayListener = this.displayListener;
            if (defaultDisplayListener != null) {
                defaultDisplayListener.unregister();
            }
            this.vsyncSampler.removeObserver();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    public final long adjustReleaseTime(long j, long j2) {
        long j3;
        long j4;
        VSyncSampler vSyncSampler;
        long j5 = 1000 * j;
        if (this.haveSync) {
            if (j != this.lastFramePresentationTimeUs) {
                this.frameCount++;
                this.adjustedLastFrameTimeNs = this.pendingAdjustedFrameTimeNs;
            }
            long j6 = this.frameCount;
            if (j6 >= 6) {
                j4 = this.adjustedLastFrameTimeNs + ((j5 - this.syncFramePresentationTimeNs) / j6);
                if (isDriftTooLarge(j4, j2)) {
                    this.haveSync = false;
                } else {
                    j3 = (this.syncUnadjustedReleaseTimeNs + j4) - this.syncFramePresentationTimeNs;
                    if (!this.haveSync) {
                        this.syncFramePresentationTimeNs = j5;
                        this.syncUnadjustedReleaseTimeNs = j2;
                        this.frameCount = 0;
                        this.haveSync = true;
                    }
                    this.lastFramePresentationTimeUs = j;
                    this.pendingAdjustedFrameTimeNs = j4;
                    vSyncSampler = this.vsyncSampler;
                    if (vSyncSampler != null || this.vsyncDurationNs == -9223372036854775807L) {
                        return j3;
                    }
                    long j7 = vSyncSampler.sampledVsyncTimeNs;
                    if (j7 == -9223372036854775807L) {
                        return j3;
                    }
                    return closestVsync(j3, j7, this.vsyncDurationNs) - this.vsyncOffsetNs;
                }
            } else if (isDriftTooLarge(j5, j2)) {
                this.haveSync = false;
            }
        }
        j3 = j2;
        j4 = j5;
        if (!this.haveSync) {
        }
        this.lastFramePresentationTimeUs = j;
        this.pendingAdjustedFrameTimeNs = j4;
        vSyncSampler = this.vsyncSampler;
        if (vSyncSampler != null) {
        }
        return j3;
    }

    private DefaultDisplayListener maybeBuildDefaultDisplayListenerV17(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return null;
        }
        return new DefaultDisplayListener(displayManager);
    }

    public final void updateDefaultDisplayRefreshRateParams() {
        Display defaultDisplay = this.windowManager.getDefaultDisplay();
        if (defaultDisplay != null) {
            double refreshRate = (double) defaultDisplay.getRefreshRate();
            Double.isNaN(refreshRate);
            this.vsyncDurationNs = (long) (1.0E9d / refreshRate);
            this.vsyncOffsetNs = (this.vsyncDurationNs * 80) / 100;
        }
    }

    private boolean isDriftTooLarge(long j, long j2) {
        return Math.abs((j2 - this.syncUnadjustedReleaseTimeNs) - (j - this.syncFramePresentationTimeNs)) > 20000000;
    }

    private static long closestVsync(long j, long j2, long j3) {
        long j4;
        long j5 = j2 + (((j - j2) / j3) * j3);
        if (j <= j5) {
            j4 = j5 - j3;
        } else {
            long j6 = j5;
            j5 = j3 + j5;
            j4 = j6;
        }
        return j5 - j < j - j4 ? j5 : j4;
    }

    final class DefaultDisplayListener implements DisplayManager.DisplayListener {
        private final DisplayManager displayManager;

        public final void onDisplayAdded(int i) {
        }

        public final void onDisplayRemoved(int i) {
        }

        public DefaultDisplayListener(DisplayManager displayManager2) {
            this.displayManager = displayManager2;
        }

        public final void register() {
            this.displayManager.registerDisplayListener(this, null);
        }

        public final void unregister() {
            this.displayManager.unregisterDisplayListener(this);
        }

        public final void onDisplayChanged(int i) {
            if (i == 0) {
                VideoFrameReleaseTimeHelper.this.updateDefaultDisplayRefreshRateParams();
            }
        }
    }

    static final class VSyncSampler implements Handler.Callback, Choreographer.FrameCallback {
        private static final VSyncSampler INSTANCE = new VSyncSampler();
        private Choreographer choreographer;
        private final HandlerThread choreographerOwnerThread = new HandlerThread("ExoPlayer:FrameReleaseChoreographer");
        private final Handler handler;
        private int observerCount;
        public volatile long sampledVsyncTimeNs = -9223372036854775807L;

        public static VSyncSampler getInstance() {
            return INSTANCE;
        }

        private VSyncSampler() {
            this.choreographerOwnerThread.start();
            this.handler = Util.createHandler(this.choreographerOwnerThread.getLooper(), this);
            this.handler.sendEmptyMessage(0);
        }

        public final void addObserver() {
            this.handler.sendEmptyMessage(1);
        }

        public final void removeObserver() {
            this.handler.sendEmptyMessage(2);
        }

        public final void doFrame(long j) {
            this.sampledVsyncTimeNs = j;
            this.choreographer.postFrameCallbackDelayed(this, 500);
        }

        public final boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                createChoreographerInstanceInternal();
                return true;
            } else if (i == 1) {
                addObserverInternal();
                return true;
            } else if (i != 2) {
                return false;
            } else {
                removeObserverInternal();
                return true;
            }
        }

        private void createChoreographerInstanceInternal() {
            this.choreographer = Choreographer.getInstance();
        }

        private void addObserverInternal() {
            this.observerCount++;
            if (this.observerCount == 1) {
                this.choreographer.postFrameCallback(this);
            }
        }

        private void removeObserverInternal() {
            this.observerCount--;
            if (this.observerCount == 0) {
                this.choreographer.removeFrameCallback(this);
                this.sampledVsyncTimeNs = -9223372036854775807L;
            }
        }
    }
}
