package com.xiaomi.smarthome.newui.mainpage.devicepage;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class ThrottleFirstAndLastObserver<T> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
    final String TAG = ThrottleFirstAndLastObserver.class.getSimpleName();
    private volatile boolean cancelled;
    private volatile boolean done;
    private final Observer<? super T> downstream;
    private Throwable error;
    private final AtomicReference<T> latest;
    private final long timeout;
    private volatile boolean timerFired;
    private boolean timerRunning;
    private final TimeUnit unit;
    private Disposable upstream;
    private final Scheduler.Worker worker;

    public ThrottleFirstAndLastObserver(Observer<? super T> observer, long j, TimeUnit timeUnit) {
        this.downstream = observer;
        this.timeout = j;
        this.unit = timeUnit;
        this.worker = Schedulers.computation().createWorker();
        this.latest = new AtomicReference<>();
    }

    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.upstream, disposable)) {
            this.upstream = disposable;
            this.downstream.onSubscribe(this);
        }
    }

    public void onNext(T t) {
        this.latest.set(t);
        drain();
    }

    public void onError(Throwable th) {
        this.error = th;
        this.done = true;
        drain();
    }

    public void onComplete() {
        this.done = true;
        drain();
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        this.worker.dispose();
        if (getAndIncrement() == 0) {
            this.latest.lazySet(null);
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void run() {
        this.timerFired = true;
        drain();
    }

    private void drain() {
        if (getAndIncrement() == 0) {
            AtomicReference<T> atomicReference = this.latest;
            Observer<? super T> observer = this.downstream;
            while (!this.cancelled) {
                boolean z = this.done;
                if (!this.done || this.error == null) {
                    boolean z2 = atomicReference.get() == null;
                    if (z) {
                        T andSet = atomicReference.getAndSet(null);
                        if (!z2) {
                            observer.onNext(andSet);
                        }
                        observer.onComplete();
                        this.worker.dispose();
                        return;
                    }
                    if (z2) {
                        if (this.timerFired) {
                            this.timerRunning = false;
                            this.timerFired = false;
                        }
                    } else if (!this.timerRunning || this.timerFired) {
                        observer.onNext(atomicReference.getAndSet(null));
                        this.timerFired = false;
                        this.timerRunning = true;
                        this.worker.schedule(this, this.timeout, this.unit);
                    }
                    if (addAndGet(-1) == 0) {
                        return;
                    }
                } else {
                    atomicReference.lazySet(null);
                    observer.onError(this.error);
                    this.worker.dispose();
                    return;
                }
            }
            atomicReference.lazySet(null);
        }
    }
}
