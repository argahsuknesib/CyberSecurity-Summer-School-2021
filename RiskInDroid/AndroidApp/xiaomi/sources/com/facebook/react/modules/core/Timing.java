package com.facebook.react.modules.core;

import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.common.SystemClock;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.modules.core.ReactChoreographer;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;

@ReactModule(name = "Timing")
public final class Timing extends ReactContextBaseJavaModule implements LifecycleEventListener, HeadlessJsTaskEventListener {
    public final AtomicBoolean isPaused = new AtomicBoolean(true);
    public final AtomicBoolean isRunningTasks = new AtomicBoolean(false);
    public IdleCallbackRunnable mCurrentIdleCallbackRunnable;
    private final DevSupportManager mDevSupportManager;
    private boolean mFrameCallbackPosted = false;
    private boolean mFrameIdleCallbackPosted = false;
    public final Object mIdleCallbackGuard = new Object();
    private final IdleFrameCallback mIdleFrameCallback = new IdleFrameCallback();
    public final ReactChoreographer mReactChoreographer;
    public boolean mSendIdleEvents = false;
    private final TimerFrameCallback mTimerFrameCallback = new TimerFrameCallback();
    public final Object mTimerGuard = new Object();
    public final SparseArray<Timer> mTimerIdsToTimers;
    public final PriorityQueue<Timer> mTimers;

    public final String getName() {
        return "Timing";
    }

    static class Timer {
        public final int mCallbackID;
        public final int mInterval;
        public final boolean mRepeat;
        public long mTargetTime;

        private Timer(int i, long j, int i2, boolean z) {
            this.mCallbackID = i;
            this.mTargetTime = j;
            this.mInterval = i2;
            this.mRepeat = z;
        }
    }

    class TimerFrameCallback extends ChoreographerCompat.FrameCallback {
        private WritableArray mTimersToCall;

        private TimerFrameCallback() {
            this.mTimersToCall = null;
        }

        public void doFrame(long j) {
            if (!Timing.this.isPaused.get() || Timing.this.isRunningTasks.get()) {
                long j2 = j / 1000000;
                synchronized (Timing.this.mTimerGuard) {
                    while (!Timing.this.mTimers.isEmpty() && Timing.this.mTimers.peek().mTargetTime < j2) {
                        Timer poll = Timing.this.mTimers.poll();
                        if (this.mTimersToCall == null) {
                            this.mTimersToCall = Arguments.createArray();
                        }
                        this.mTimersToCall.pushInt(poll.mCallbackID);
                        if (poll.mRepeat) {
                            poll.mTargetTime = ((long) poll.mInterval) + j2;
                            Timing.this.mTimers.add(poll);
                        } else {
                            Timing.this.mTimerIdsToTimers.remove(poll.mCallbackID);
                        }
                    }
                }
                if (this.mTimersToCall != null) {
                    ((JSTimers) Timing.this.getReactApplicationContext().getJSModule(JSTimers.class)).callTimers(this.mTimersToCall);
                    this.mTimersToCall = null;
                }
                Timing.this.mReactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this);
            }
        }
    }

    class IdleFrameCallback extends ChoreographerCompat.FrameCallback {
        private IdleFrameCallback() {
        }

        public void doFrame(long j) {
            if (!Timing.this.isPaused.get() || Timing.this.isRunningTasks.get()) {
                if (Timing.this.mCurrentIdleCallbackRunnable != null) {
                    Timing.this.mCurrentIdleCallbackRunnable.cancel();
                }
                Timing timing = Timing.this;
                timing.mCurrentIdleCallbackRunnable = new IdleCallbackRunnable(j);
                Timing.this.getReactApplicationContext().runOnJSQueueThread(Timing.this.mCurrentIdleCallbackRunnable);
                Timing.this.mReactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, this);
            }
        }
    }

    class IdleCallbackRunnable implements Runnable {
        private volatile boolean mCancelled = false;
        private final long mFrameStartTime;

        public IdleCallbackRunnable(long j) {
            this.mFrameStartTime = j;
        }

        public void run() {
            boolean z;
            if (!this.mCancelled) {
                long uptimeMillis = SystemClock.uptimeMillis() - (this.mFrameStartTime / 1000000);
                long currentTimeMillis = SystemClock.currentTimeMillis() - uptimeMillis;
                if (16.666666f - ((float) uptimeMillis) >= 1.0f) {
                    synchronized (Timing.this.mIdleCallbackGuard) {
                        z = Timing.this.mSendIdleEvents;
                    }
                    if (z) {
                        ((JSTimers) Timing.this.getReactApplicationContext().getJSModule(JSTimers.class)).callIdleCallbacks((double) currentTimeMillis);
                    }
                    Timing.this.mCurrentIdleCallbackRunnable = null;
                }
            }
        }

        public void cancel() {
            this.mCancelled = true;
        }
    }

    public Timing(ReactApplicationContext reactApplicationContext, DevSupportManager devSupportManager) {
        super(reactApplicationContext);
        this.mDevSupportManager = devSupportManager;
        this.mTimers = new PriorityQueue<>(11, new Comparator<Timer>() {
            /* class com.facebook.react.modules.core.Timing.AnonymousClass1 */

            public int compare(Timer timer, Timer timer2) {
                long j = timer.mTargetTime - timer2.mTargetTime;
                if (j == 0) {
                    return 0;
                }
                return j < 0 ? -1 : 1;
            }
        });
        this.mTimerIdsToTimers = new SparseArray<>();
        this.mReactChoreographer = ReactChoreographer.getInstance();
    }

    public final void initialize() {
        getReactApplicationContext().addLifecycleEventListener(this);
        HeadlessJsTaskContext.getInstance(getReactApplicationContext()).addTaskEventListener(this);
    }

    public final void onHostPause() {
        this.isPaused.set(true);
        clearFrameCallback();
        maybeIdleCallback();
    }

    public final void onHostDestroy() {
        clearFrameCallback();
        maybeIdleCallback();
    }

    public final void onHostResume() {
        this.isPaused.set(false);
        setChoreographerCallback();
        maybeSetChoreographerIdleCallback();
    }

    public final void onHeadlessJsTaskStart(int i) {
        if (!this.isRunningTasks.getAndSet(true)) {
            setChoreographerCallback();
            maybeSetChoreographerIdleCallback();
        }
    }

    public final void onHeadlessJsTaskFinish(int i) {
        if (!HeadlessJsTaskContext.getInstance(getReactApplicationContext()).hasActiveTasks()) {
            this.isRunningTasks.set(false);
            clearFrameCallback();
            maybeIdleCallback();
        }
    }

    public final void onCatalystInstanceDestroy() {
        clearFrameCallback();
        clearChoreographerIdleCallback();
        HeadlessJsTaskContext.getInstance(getReactApplicationContext()).removeTaskEventListener(this);
    }

    private void maybeSetChoreographerIdleCallback() {
        synchronized (this.mIdleCallbackGuard) {
            if (this.mSendIdleEvents) {
                setChoreographerIdleCallback();
            }
        }
    }

    private void maybeIdleCallback() {
        if (this.isPaused.get() && !this.isRunningTasks.get()) {
            clearFrameCallback();
        }
    }

    private void setChoreographerCallback() {
        if (!this.mFrameCallbackPosted) {
            this.mReactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this.mTimerFrameCallback);
            this.mFrameCallbackPosted = true;
        }
    }

    private void clearFrameCallback() {
        HeadlessJsTaskContext instance = HeadlessJsTaskContext.getInstance(getReactApplicationContext());
        if (this.mFrameCallbackPosted && this.isPaused.get() && !instance.hasActiveTasks()) {
            this.mReactChoreographer.removeFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, this.mTimerFrameCallback);
            this.mFrameCallbackPosted = false;
        }
    }

    public final void setChoreographerIdleCallback() {
        if (!this.mFrameIdleCallbackPosted) {
            this.mReactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, this.mIdleFrameCallback);
            this.mFrameIdleCallbackPosted = true;
        }
    }

    public final void clearChoreographerIdleCallback() {
        if (this.mFrameIdleCallbackPosted) {
            this.mReactChoreographer.removeFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, this.mIdleFrameCallback);
            this.mFrameIdleCallbackPosted = false;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.Math.max(long, long):long}
     arg types: [int, long]
     candidates:
      ClspMth{java.lang.Math.max(double, double):double}
      ClspMth{java.lang.Math.max(int, int):int}
      ClspMth{java.lang.Math.max(float, float):float}
      ClspMth{java.lang.Math.max(long, long):long} */
    @ReactMethod
    public final void createTimer(int i, int i2, double d, boolean z) {
        long currentTimeMillis = SystemClock.currentTimeMillis();
        long j = (long) d;
        if (this.mDevSupportManager.getDevSupportEnabled() && Math.abs(j - currentTimeMillis) > 60000) {
            ((JSTimers) getReactApplicationContext().getJSModule(JSTimers.class)).emitTimeDriftWarning("Debugger and device times have drifted by more than 60s. Please correct this by running adb shell \"date `date +%m%d%H%M%Y.%S`\" on your debugger machine.");
        }
        long max = Math.max(0L, (j - currentTimeMillis) + ((long) i2));
        if (i2 != 0 || z) {
            Timer timer = new Timer(i, (SystemClock.nanoTime() / 1000000) + max, i2, z);
            synchronized (this.mTimerGuard) {
                this.mTimers.add(timer);
                this.mTimerIdsToTimers.put(i, timer);
            }
            return;
        }
        WritableArray createArray = Arguments.createArray();
        createArray.pushInt(i);
        ((JSTimers) getReactApplicationContext().getJSModule(JSTimers.class)).callTimers(createArray);
    }

    @ReactMethod
    public final void deleteTimer(int i) {
        synchronized (this.mTimerGuard) {
            Timer timer = this.mTimerIdsToTimers.get(i);
            if (timer != null) {
                this.mTimerIdsToTimers.remove(i);
                this.mTimers.remove(timer);
            }
        }
    }

    @ReactMethod
    public final void setSendIdleEvents(final boolean z) {
        synchronized (this.mIdleCallbackGuard) {
            this.mSendIdleEvents = z;
        }
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.modules.core.Timing.AnonymousClass2 */

            public void run() {
                synchronized (Timing.this.mIdleCallbackGuard) {
                    if (z) {
                        Timing.this.setChoreographerIdleCallback();
                    } else {
                        Timing.this.clearChoreographerIdleCallback();
                    }
                }
            }
        });
    }
}
