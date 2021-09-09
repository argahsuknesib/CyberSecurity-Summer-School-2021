package com.facebook.rebound;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Choreographer;

abstract class AndroidSpringLooperFactory {
    AndroidSpringLooperFactory() {
    }

    public static SpringLooper createSpringLooper() {
        if (Build.VERSION.SDK_INT >= 16) {
            return ChoreographerAndroidSpringLooper.create();
        }
        return LegacyAndroidSpringLooper.create();
    }

    static class LegacyAndroidSpringLooper extends SpringLooper {
        public final Handler mHandler;
        public long mLastTime;
        public final Runnable mLooperRunnable = new Runnable() {
            /* class com.facebook.rebound.AndroidSpringLooperFactory.LegacyAndroidSpringLooper.AnonymousClass1 */

            public void run() {
                if (LegacyAndroidSpringLooper.this.mStarted && LegacyAndroidSpringLooper.this.mSpringSystem != null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    LegacyAndroidSpringLooper.this.mSpringSystem.loop((double) (uptimeMillis - LegacyAndroidSpringLooper.this.mLastTime));
                    LegacyAndroidSpringLooper legacyAndroidSpringLooper = LegacyAndroidSpringLooper.this;
                    legacyAndroidSpringLooper.mLastTime = uptimeMillis;
                    legacyAndroidSpringLooper.mHandler.post(LegacyAndroidSpringLooper.this.mLooperRunnable);
                }
            }
        };
        public boolean mStarted;

        public static SpringLooper create() {
            return new LegacyAndroidSpringLooper(new Handler());
        }

        public LegacyAndroidSpringLooper(Handler handler) {
            this.mHandler = handler;
        }

        public void start() {
            if (!this.mStarted) {
                this.mStarted = true;
                this.mLastTime = SystemClock.uptimeMillis();
                this.mHandler.removeCallbacks(this.mLooperRunnable);
                this.mHandler.post(this.mLooperRunnable);
            }
        }

        public void stop() {
            this.mStarted = false;
            this.mHandler.removeCallbacks(this.mLooperRunnable);
        }
    }

    @TargetApi(16)
    static class ChoreographerAndroidSpringLooper extends SpringLooper {
        public final Choreographer mChoreographer;
        public final Choreographer.FrameCallback mFrameCallback = new Choreographer.FrameCallback() {
            /* class com.facebook.rebound.AndroidSpringLooperFactory.ChoreographerAndroidSpringLooper.AnonymousClass1 */

            public void doFrame(long j) {
                if (ChoreographerAndroidSpringLooper.this.mStarted && ChoreographerAndroidSpringLooper.this.mSpringSystem != null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    ChoreographerAndroidSpringLooper.this.mSpringSystem.loop((double) (uptimeMillis - ChoreographerAndroidSpringLooper.this.mLastTime));
                    ChoreographerAndroidSpringLooper choreographerAndroidSpringLooper = ChoreographerAndroidSpringLooper.this;
                    choreographerAndroidSpringLooper.mLastTime = uptimeMillis;
                    choreographerAndroidSpringLooper.mChoreographer.postFrameCallback(ChoreographerAndroidSpringLooper.this.mFrameCallback);
                }
            }
        };
        public long mLastTime;
        public boolean mStarted;

        public static ChoreographerAndroidSpringLooper create() {
            return new ChoreographerAndroidSpringLooper(Choreographer.getInstance());
        }

        public ChoreographerAndroidSpringLooper(Choreographer choreographer) {
            this.mChoreographer = choreographer;
        }

        public void start() {
            if (!this.mStarted) {
                this.mStarted = true;
                this.mLastTime = SystemClock.uptimeMillis();
                this.mChoreographer.removeFrameCallback(this.mFrameCallback);
                this.mChoreographer.postFrameCallback(this.mFrameCallback);
            }
        }

        public void stop() {
            this.mStarted = false;
            this.mChoreographer.removeFrameCallback(this.mFrameCallback);
        }
    }
}
