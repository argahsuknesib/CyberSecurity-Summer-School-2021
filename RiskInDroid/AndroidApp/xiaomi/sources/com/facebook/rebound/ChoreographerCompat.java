package com.facebook.rebound;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;

public class ChoreographerCompat {
    private static final boolean IS_JELLYBEAN_OR_HIGHER = (Build.VERSION.SDK_INT >= 16);
    private static ChoreographerCompat __instance = new ChoreographerCompat();
    private Choreographer mChoreographer;
    private Handler mHandler;

    public static ChoreographerCompat getInstance() {
        return __instance;
    }

    private ChoreographerCompat() {
        if (IS_JELLYBEAN_OR_HIGHER) {
            this.mChoreographer = getChoreographer();
        } else {
            this.mHandler = new Handler(Looper.getMainLooper());
        }
    }

    public void postFrameCallback(FrameCallback frameCallback) {
        if (IS_JELLYBEAN_OR_HIGHER) {
            choreographerPostFrameCallback(frameCallback.getFrameCallback());
        } else {
            this.mHandler.postDelayed(frameCallback.getRunnable(), 0);
        }
    }

    public void postFrameCallbackDelayed(FrameCallback frameCallback, long j) {
        if (IS_JELLYBEAN_OR_HIGHER) {
            choreographerPostFrameCallbackDelayed(frameCallback.getFrameCallback(), j);
        } else {
            this.mHandler.postDelayed(frameCallback.getRunnable(), j + 17);
        }
    }

    public void removeFrameCallback(FrameCallback frameCallback) {
        if (IS_JELLYBEAN_OR_HIGHER) {
            choreographerRemoveFrameCallback(frameCallback.getFrameCallback());
        } else {
            this.mHandler.removeCallbacks(frameCallback.getRunnable());
        }
    }

    @TargetApi(16)
    private Choreographer getChoreographer() {
        return Choreographer.getInstance();
    }

    @TargetApi(16)
    private void choreographerPostFrameCallback(Choreographer.FrameCallback frameCallback) {
        this.mChoreographer.postFrameCallback(frameCallback);
    }

    @TargetApi(16)
    private void choreographerPostFrameCallbackDelayed(Choreographer.FrameCallback frameCallback, long j) {
        this.mChoreographer.postFrameCallbackDelayed(frameCallback, j);
    }

    @TargetApi(16)
    private void choreographerRemoveFrameCallback(Choreographer.FrameCallback frameCallback) {
        this.mChoreographer.removeFrameCallback(frameCallback);
    }

    public static abstract class FrameCallback {
        private Choreographer.FrameCallback mFrameCallback;
        private Runnable mRunnable;

        public abstract void doFrame(long j);

        /* access modifiers changed from: package-private */
        @TargetApi(16)
        public Choreographer.FrameCallback getFrameCallback() {
            if (this.mFrameCallback == null) {
                this.mFrameCallback = new Choreographer.FrameCallback() {
                    /* class com.facebook.rebound.ChoreographerCompat.FrameCallback.AnonymousClass1 */

                    public void doFrame(long j) {
                        FrameCallback.this.doFrame(j);
                    }
                };
            }
            return this.mFrameCallback;
        }

        /* access modifiers changed from: package-private */
        public Runnable getRunnable() {
            if (this.mRunnable == null) {
                this.mRunnable = new Runnable() {
                    /* class com.facebook.rebound.ChoreographerCompat.FrameCallback.AnonymousClass2 */

                    public void run() {
                        FrameCallback.this.doFrame(System.nanoTime());
                    }
                };
            }
            return this.mRunnable;
        }
    }
}
