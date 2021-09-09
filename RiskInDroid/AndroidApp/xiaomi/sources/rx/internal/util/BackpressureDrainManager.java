package rx.internal.util;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

public final class BackpressureDrainManager extends AtomicLong implements Producer {
    private static final long serialVersionUID = 2826241102729529449L;
    final BackpressureQueueCallback actual;
    boolean emitting;
    Throwable exception;
    volatile boolean terminated;

    public interface BackpressureQueueCallback {
        boolean accept(Object obj);

        void complete(Throwable th);

        Object peek();

        Object poll();
    }

    public BackpressureDrainManager(BackpressureQueueCallback backpressureQueueCallback) {
        this.actual = backpressureQueueCallback;
    }

    public final boolean isTerminated() {
        return this.terminated;
    }

    public final void terminate() {
        this.terminated = true;
    }

    public final void terminate(Throwable th) {
        if (!this.terminated) {
            this.exception = th;
            this.terminated = true;
        }
    }

    public final void terminateAndDrain() {
        this.terminated = true;
        drain();
    }

    public final void terminateAndDrain(Throwable th) {
        if (!this.terminated) {
            this.exception = th;
            this.terminated = true;
            drain();
        }
    }

    public final void request(long j) {
        long j2;
        boolean z;
        long j3;
        if (j != 0) {
            do {
                j2 = get();
                z = j2 == 0;
                j3 = Long.MAX_VALUE;
                if (j2 == Long.MAX_VALUE) {
                    break;
                } else if (j == Long.MAX_VALUE) {
                    j3 = j;
                    z = true;
                } else if (j2 <= Long.MAX_VALUE - j) {
                    j3 = j2 + j;
                }
            } while (!compareAndSet(j2, j3));
            if (z) {
                drain();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r5 = r13.actual;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        if (r2 > 0) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        if (r1 == false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001d, code lost:
        if (r1 == false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0023, code lost:
        if (r5.peek() != null) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r5.complete(r13.exception);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002b, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002f, code lost:
        if (r2 == 0) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r9 = r5.poll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0035, code lost:
        if (r9 == null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003b, code lost:
        if (r5.accept(r9) == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x003e, code lost:
        r2 = r2 - 1;
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0044, code lost:
        monitor-enter(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r1 = r13.terminated;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004b, code lost:
        if (r5.peek() == null) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x004d, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x004f, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005b, code lost:
        if (get() != Long.MAX_VALUE) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x005d, code lost:
        if (r2 != false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x005f, code lost:
        if (r1 != false) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r13.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0063, code lost:
        monitor-exit(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0064, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0065, code lost:
        r2 = Long.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r9 = addAndGet((long) (-r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x006f, code lost:
        if (r9 == 0) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0071, code lost:
        if (r2 != false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0073, code lost:
        if (r1 == false) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0075, code lost:
        if (r2 == false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0078, code lost:
        r2 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0079, code lost:
        monitor-exit(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r13.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x007d, code lost:
        monitor-exit(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x007e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x007f, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0080, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0081, code lost:
        monitor-exit(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0083, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0085, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0086, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0087, code lost:
        if (r0 == false) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0089, code lost:
        monitor-enter(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r13.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0091, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000d, code lost:
        r2 = get();
     */
    public final void drain() {
        synchronized (this) {
            if (!this.emitting) {
                boolean z = true;
                this.emitting = true;
                boolean z2 = this.terminated;
            }
        }
    }
}
