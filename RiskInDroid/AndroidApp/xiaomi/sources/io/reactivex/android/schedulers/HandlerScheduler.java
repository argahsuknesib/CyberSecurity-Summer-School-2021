package io.reactivex.android.schedulers;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

final class HandlerScheduler extends Scheduler {
    private final boolean async;
    private final Handler handler;

    HandlerScheduler(Handler handler2, boolean z) {
        this.handler = handler2;
        this.async = z;
    }

    @SuppressLint({"NewApi"})
    public final Disposable scheduleDirect(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        } else if (timeUnit != null) {
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.handler, RxJavaPlugins.onSchedule(runnable));
            Message obtain = Message.obtain(this.handler, scheduledRunnable);
            if (this.async) {
                obtain.setAsynchronous(true);
            }
            this.handler.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            return scheduledRunnable;
        } else {
            throw new NullPointerException("unit == null");
        }
    }

    public final Scheduler.Worker createWorker() {
        return new HandlerWorker(this.handler, this.async);
    }

    static final class HandlerWorker extends Scheduler.Worker {
        private final boolean async;
        private volatile boolean disposed;
        private final Handler handler;

        HandlerWorker(Handler handler2, boolean z) {
            this.handler = handler2;
            this.async = z;
        }

        @SuppressLint({"NewApi"})
        public final Disposable schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.disposed) {
                return Disposables.disposed();
            } else {
                ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.handler, RxJavaPlugins.onSchedule(runnable));
                Message obtain = Message.obtain(this.handler, scheduledRunnable);
                obtain.obj = this;
                if (this.async) {
                    obtain.setAsynchronous(true);
                }
                this.handler.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                if (!this.disposed) {
                    return scheduledRunnable;
                }
                this.handler.removeCallbacks(scheduledRunnable);
                return Disposables.disposed();
            }
        }

        public final void dispose() {
            this.disposed = true;
            this.handler.removeCallbacksAndMessages(this);
        }

        public final boolean isDisposed() {
            return this.disposed;
        }
    }

    static final class ScheduledRunnable implements Disposable, Runnable {
        private final Runnable delegate;
        private volatile boolean disposed;
        private final Handler handler;

        ScheduledRunnable(Handler handler2, Runnable runnable) {
            this.handler = handler2;
            this.delegate = runnable;
        }

        public final void run() {
            try {
                this.delegate.run();
            } catch (Throwable th) {
                RxJavaPlugins.onError(th);
            }
        }

        public final void dispose() {
            this.handler.removeCallbacks(this);
            this.disposed = true;
        }

        public final boolean isDisposed() {
            return this.disposed;
        }
    }
}
