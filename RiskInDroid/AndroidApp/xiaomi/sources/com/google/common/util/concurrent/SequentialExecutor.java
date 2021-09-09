package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtIncompatible
final class SequentialExecutor implements Executor {
    public static final Logger log = Logger.getLogger(SequentialExecutor.class.getName());
    private final Executor executor;
    @GuardedBy("queue")
    public final Deque<Runnable> queue = new ArrayDeque();
    private final QueueWorker worker = new QueueWorker();
    @GuardedBy("queue")
    public long workerRunCount = 0;
    @GuardedBy("queue")
    public WorkerRunningState workerRunningState = WorkerRunningState.IDLE;

    enum WorkerRunningState {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    SequentialExecutor(Executor executor2) {
        this.executor = (Executor) Preconditions.checkNotNull(executor2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r7.executor.execute(r7.worker);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (r7.workerRunningState == com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.QUEUING) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
        if (r8 == false) goto L_0x0038;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        r4 = r7.queue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003a, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
        if (r7.workerRunCount != r1) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
        if (r7.workerRunningState != com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.QUEUING) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
        r7.workerRunningState = com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.QUEUED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0050, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0055, code lost:
        monitor-enter(r7.queue);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x005a, code lost:
        if (r7.workerRunningState == com.google.common.util.concurrent.SequentialExecutor.WorkerRunningState.IDLE) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x006b, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006e, code lost:
        if ((r1 instanceof java.util.concurrent.RejectedExecutionException) == false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0073, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0074, code lost:
        throw r1;
     */
    public final void execute(final Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        synchronized (this.queue) {
            if (this.workerRunningState != WorkerRunningState.RUNNING) {
                if (this.workerRunningState != WorkerRunningState.QUEUED) {
                    long j = this.workerRunCount;
                    AnonymousClass1 r3 = new Runnable() {
                        /* class com.google.common.util.concurrent.SequentialExecutor.AnonymousClass1 */

                        public void run() {
                            runnable.run();
                        }
                    };
                    this.queue.add(r3);
                    this.workerRunningState = WorkerRunningState.QUEUING;
                }
            }
            this.queue.add(runnable);
        }
    }

    final class QueueWorker implements Runnable {
        private QueueWorker() {
        }

        public final void run() {
            try {
                workOnQueue();
            } catch (Error e) {
                synchronized (SequentialExecutor.this.queue) {
                    SequentialExecutor.this.workerRunningState = WorkerRunningState.IDLE;
                    throw e;
                }
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
         arg types: [java.util.logging.Level, java.lang.String, java.lang.RuntimeException]
         candidates:
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
          ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
            if (r1 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004e, code lost:
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r3.run();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
            if (r1 == false) goto L_?;
         */
        private void workOnQueue() {
            Runnable poll;
            boolean z = false;
            boolean z2 = false;
            while (true) {
                try {
                    synchronized (SequentialExecutor.this.queue) {
                        if (!z) {
                            if (SequentialExecutor.this.workerRunningState != WorkerRunningState.RUNNING) {
                                SequentialExecutor.this.workerRunCount++;
                                SequentialExecutor.this.workerRunningState = WorkerRunningState.RUNNING;
                                z = true;
                            }
                        }
                        poll = SequentialExecutor.this.queue.poll();
                        if (poll == null) {
                            SequentialExecutor.this.workerRunningState = WorkerRunningState.IDLE;
                        }
                    }
                } catch (RuntimeException e) {
                    SequentialExecutor.log.log(Level.SEVERE, "Exception while executing runnable ".concat(String.valueOf(poll)), (Throwable) e);
                } catch (Throwable th) {
                    if (z2) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
        }
    }
}
