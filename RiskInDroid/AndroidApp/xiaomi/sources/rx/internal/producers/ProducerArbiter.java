package rx.internal.producers;

import rx.Producer;

public final class ProducerArbiter implements Producer {
    static final Producer NULL_PRODUCER = new Producer() {
        /* class rx.internal.producers.ProducerArbiter.AnonymousClass1 */

        public final void request(long j) {
        }
    };
    Producer currentProducer;
    boolean emitting;
    long missedProduced;
    Producer missedProducer;
    long missedRequested;
    long requested;

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r2 = r5.requested + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0020, code lost:
        if (r2 >= 0) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0022, code lost:
        r2 = Long.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
        r5.requested = r2;
        r0 = r5.currentProducer;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002b, code lost:
        if (r0 == null) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002d, code lost:
        r0.request(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0030, code lost:
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0033, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0034, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0035, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        r5.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x003a, code lost:
        throw r6;
     */
    public final void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (j != 0) {
            synchronized (this) {
                if (this.emitting) {
                    this.missedRequested += j;
                    return;
                }
                this.emitting = true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r2 = r7.requested;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001f, code lost:
        if (r2 == Long.MAX_VALUE) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        r2 = r2 - r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        if (r2 < 0) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        r7.requested = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        throw new java.lang.IllegalStateException("more items arrived than were requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0036, code lost:
        monitor-enter(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r7.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003b, code lost:
        throw r8;
     */
    public final void produced(long j) {
        if (j > 0) {
            synchronized (this) {
                if (this.emitting) {
                    this.missedProduced += j;
                    return;
                }
                this.emitting = true;
            }
        } else {
            throw new IllegalArgumentException("n > 0 required");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r2.currentProducer = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0013, code lost:
        if (r3 == null) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0015, code lost:
        r3.request(r2.requested);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001a, code lost:
        emitLoop();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001f, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r2.emitting = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0024, code lost:
        throw r3;
     */
    public final void setProducer(Producer producer) {
        synchronized (this) {
            if (this.emitting) {
                if (producer == null) {
                    producer = NULL_PRODUCER;
                }
                this.missedProducer = producer;
                return;
            }
            this.emitting = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        r8 = r13.requested;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        if (r8 == Long.MAX_VALUE) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        r8 = r8 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        if (r8 < 0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        if (r8 != Long.MAX_VALUE) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        r8 = r8 - r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        if (r8 < 0) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        r13.requested = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        throw new java.lang.IllegalStateException("more produced than requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        r13.requested = Long.MAX_VALUE;
        r8 = Long.MAX_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0048, code lost:
        if (r4 == null) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004c, code lost:
        if (r4 != rx.internal.producers.ProducerArbiter.NULL_PRODUCER) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
        r13.currentProducer = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0051, code lost:
        r13.currentProducer = r4;
        r4.request(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0057, code lost:
        r2 = r13.currentProducer;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0059, code lost:
        if (r2 == null) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005d, code lost:
        if (r0 == 0) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005f, code lost:
        r2.request(r0);
     */
    public final void emitLoop() {
        while (true) {
            synchronized (this) {
                long j = this.missedRequested;
                long j2 = this.missedProduced;
                Producer producer = this.missedProducer;
                if (j == 0 && j2 == 0 && producer == null) {
                    this.emitting = false;
                    return;
                }
                this.missedRequested = 0;
                this.missedProduced = 0;
                this.missedProducer = null;
            }
        }
        while (true) {
        }
    }
}
