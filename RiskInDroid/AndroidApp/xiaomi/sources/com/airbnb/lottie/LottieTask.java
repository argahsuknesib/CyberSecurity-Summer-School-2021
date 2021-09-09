package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class LottieTask<T> {
    public static Executor EXECUTOR = Executors.newCachedThreadPool();
    private final Set<LottieListener<Throwable>> failureListeners;
    private final Handler handler;
    public volatile LottieResult<T> result;
    private final Set<LottieListener<T>> successListeners;
    public final FutureTask<LottieResult<T>> task;
    private Thread taskObserver;

    public LottieTask(Callable<LottieResult<T>> callable) {
        this(callable, false);
    }

    LottieTask(Callable<LottieResult<T>> callable, boolean z) {
        this.successListeners = new LinkedHashSet(1);
        this.failureListeners = new LinkedHashSet(1);
        this.handler = new Handler(Looper.getMainLooper());
        this.result = null;
        this.task = new FutureTask<>(callable);
        if (z) {
            try {
                setResult(callable.call());
            } catch (Throwable th) {
                setResult(new LottieResult(th));
            }
        } else {
            EXECUTOR.execute(this.task);
            startTaskObserverIfNeeded();
        }
    }

    public void setResult(LottieResult<T> lottieResult) {
        if (this.result == null) {
            this.result = lottieResult;
            notifyListeners();
            return;
        }
        throw new IllegalStateException("A task may only be set once.");
    }

    public synchronized LottieTask<T> addListener(LottieListener<T> lottieListener) {
        if (!(this.result == null || this.result.getValue() == null)) {
            lottieListener.onResult(this.result.getValue());
        }
        this.successListeners.add(lottieListener);
        startTaskObserverIfNeeded();
        return this;
    }

    public synchronized LottieTask<T> removeListener(LottieListener<T> lottieListener) {
        this.successListeners.remove(lottieListener);
        stopTaskObserverIfNeeded();
        return this;
    }

    public synchronized LottieTask<T> addFailureListener(LottieListener<Throwable> lottieListener) {
        if (!(this.result == null || this.result.getException() == null)) {
            lottieListener.onResult(this.result.getException());
        }
        this.failureListeners.add(lottieListener);
        startTaskObserverIfNeeded();
        return this;
    }

    public synchronized LottieTask<T> removeFailureListener(LottieListener<Throwable> lottieListener) {
        this.failureListeners.remove(lottieListener);
        stopTaskObserverIfNeeded();
        return this;
    }

    private void notifyListeners() {
        this.handler.post(new Runnable() {
            /* class com.airbnb.lottie.LottieTask.AnonymousClass1 */

            public void run() {
                if (LottieTask.this.result != null && !LottieTask.this.task.isCancelled()) {
                    LottieResult<T> lottieResult = LottieTask.this.result;
                    if (lottieResult.getValue() != null) {
                        LottieTask.this.notifySuccessListeners(lottieResult.getValue());
                    } else {
                        LottieTask.this.notifyFailureListeners(lottieResult.getException());
                    }
                }
            }
        });
    }

    public void notifySuccessListeners(T t) {
        for (LottieListener onResult : new ArrayList(this.successListeners)) {
            onResult.onResult(t);
        }
    }

    public void notifyFailureListeners(Throwable th) {
        ArrayList<LottieListener> arrayList = new ArrayList<>(this.failureListeners);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        for (LottieListener onResult : arrayList) {
            onResult.onResult(th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        return;
     */
    private synchronized void startTaskObserverIfNeeded() {
        if (!taskObserverAlive()) {
            if (this.result == null) {
                this.taskObserver = new Thread("LottieTaskObserver") {
                    /* class com.airbnb.lottie.LottieTask.AnonymousClass2 */
                    private boolean taskComplete = false;

                    public void run() {
                        while (!isInterrupted() && !this.taskComplete) {
                            if (LottieTask.this.task.isDone()) {
                                try {
                                    LottieTask.this.setResult(LottieTask.this.task.get());
                                } catch (InterruptedException | ExecutionException e) {
                                    LottieTask.this.setResult(new LottieResult(e));
                                }
                                this.taskComplete = true;
                                LottieTask.this.stopTaskObserverIfNeeded();
                            }
                        }
                    }
                };
                this.taskObserver.start();
                L.debug("Starting TaskObserver thread");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return;
     */
    public synchronized void stopTaskObserverIfNeeded() {
        if (taskObserverAlive()) {
            if (this.successListeners.isEmpty() || this.result != null) {
                this.taskObserver.interrupt();
                this.taskObserver = null;
                L.debug("Stopping TaskObserver thread");
            }
        }
    }

    private boolean taskObserverAlive() {
        Thread thread = this.taskObserver;
        return thread != null && thread.isAlive();
    }
}
