package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.lang.Exception;
import java.util.ArrayDeque;

public abstract class SimpleDecoder<I extends DecoderInputBuffer, O extends OutputBuffer, E extends Exception> implements Decoder<I, O, E> {
    private int availableInputBufferCount;
    private final I[] availableInputBuffers;
    private int availableOutputBufferCount;
    private final O[] availableOutputBuffers;
    private final Thread decodeThread;
    private I dequeuedInputBuffer;
    private E exception;
    private boolean flushed;
    private final Object lock = new Object();
    private final ArrayDeque<I> queuedInputBuffers = new ArrayDeque<>();
    private final ArrayDeque<O> queuedOutputBuffers = new ArrayDeque<>();
    private boolean released;
    private int skippedOutputBufferCount;

    /* access modifiers changed from: protected */
    public abstract I createInputBuffer();

    /* access modifiers changed from: protected */
    public abstract O createOutputBuffer();

    /* access modifiers changed from: protected */
    public abstract E createUnexpectedDecodeException(Throwable th);

    /* access modifiers changed from: protected */
    public abstract E decode(I i, O o, boolean z);

    protected SimpleDecoder(I[] iArr, O[] oArr) {
        this.availableInputBuffers = iArr;
        this.availableInputBufferCount = iArr.length;
        for (int i = 0; i < this.availableInputBufferCount; i++) {
            this.availableInputBuffers[i] = createInputBuffer();
        }
        this.availableOutputBuffers = oArr;
        this.availableOutputBufferCount = oArr.length;
        for (int i2 = 0; i2 < this.availableOutputBufferCount; i2++) {
            this.availableOutputBuffers[i2] = createOutputBuffer();
        }
        this.decodeThread = new Thread("ExoPlayer:SimpleDecoder") {
            /* class com.google.android.exoplayer2.decoder.SimpleDecoder.AnonymousClass1 */

            public void run() {
                SimpleDecoder.this.run();
            }
        };
        this.decodeThread.start();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: I
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    protected final void setInitialInputBufferSize(int r5) {
        /*
            r4 = this;
            int r0 = r4.availableInputBufferCount
            I[] r1 = r4.availableInputBuffers
            int r1 = r1.length
            r2 = 0
            if (r0 != r1) goto L_0x000a
            r0 = 1
            goto L_0x000b
        L_0x000a:
            r0 = 0
        L_0x000b:
            com.google.android.exoplayer2.util.Assertions.checkState(r0)
            I[] r0 = r4.availableInputBuffers
            int r1 = r0.length
        L_0x0011:
            if (r2 >= r1) goto L_0x001b
            r3 = r0[r2]
            r3.ensureSpaceForWrite(r5)
            int r2 = r2 + 1
            goto L_0x0011
        L_0x001b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.decoder.SimpleDecoder.setInitialInputBufferSize(int):void");
    }

    public final I dequeueInputBuffer() throws Exception {
        I i;
        I i2;
        synchronized (this.lock) {
            maybeThrowException();
            Assertions.checkState(this.dequeuedInputBuffer == null);
            if (this.availableInputBufferCount == 0) {
                i = null;
            } else {
                I[] iArr = this.availableInputBuffers;
                int i3 = this.availableInputBufferCount - 1;
                this.availableInputBufferCount = i3;
                i = iArr[i3];
            }
            this.dequeuedInputBuffer = i;
            i2 = this.dequeuedInputBuffer;
        }
        return i2;
    }

    public final void queueInputBuffer(I i) throws Exception {
        synchronized (this.lock) {
            maybeThrowException();
            Assertions.checkArgument(i == this.dequeuedInputBuffer);
            this.queuedInputBuffers.addLast(i);
            maybeNotifyDecodeLoop();
            this.dequeuedInputBuffer = null;
        }
    }

    public final O dequeueOutputBuffer() throws Exception {
        synchronized (this.lock) {
            maybeThrowException();
            if (this.queuedOutputBuffers.isEmpty()) {
                return null;
            }
            O o = (OutputBuffer) this.queuedOutputBuffers.removeFirst();
            return o;
        }
    }

    /* access modifiers changed from: protected */
    public void releaseOutputBuffer(O o) {
        synchronized (this.lock) {
            releaseOutputBufferInternal(o);
            maybeNotifyDecodeLoop();
        }
    }

    public final void flush() {
        synchronized (this.lock) {
            this.flushed = true;
            this.skippedOutputBufferCount = 0;
            if (this.dequeuedInputBuffer != null) {
                releaseInputBufferInternal(this.dequeuedInputBuffer);
                this.dequeuedInputBuffer = null;
            }
            while (!this.queuedInputBuffers.isEmpty()) {
                releaseInputBufferInternal((DecoderInputBuffer) this.queuedInputBuffers.removeFirst());
            }
            while (!this.queuedOutputBuffers.isEmpty()) {
                ((OutputBuffer) this.queuedOutputBuffers.removeFirst()).release();
            }
            this.exception = null;
        }
    }

    public void release() {
        synchronized (this.lock) {
            this.released = true;
            this.lock.notify();
        }
        try {
            this.decodeThread.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    private void maybeThrowException() throws Exception {
        E e = this.exception;
        if (e != null) {
            throw e;
        }
    }

    private void maybeNotifyDecodeLoop() {
        if (canDecodeBuffer()) {
            this.lock.notify();
        }
    }

    public void run() {
        do {
            try {
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        } while (decode());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: O
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    private boolean decode() throws java.lang.InterruptedException {
        /*
            r6 = this;
            java.lang.Object r0 = r6.lock
            monitor-enter(r0)
        L_0x0003:
            boolean r1 = r6.released     // Catch:{ all -> 0x0090 }
            if (r1 != 0) goto L_0x0013
            boolean r1 = r6.canDecodeBuffer()     // Catch:{ all -> 0x0090 }
            if (r1 != 0) goto L_0x0013
            java.lang.Object r1 = r6.lock     // Catch:{ all -> 0x0090 }
            r1.wait()     // Catch:{ all -> 0x0090 }
            goto L_0x0003
        L_0x0013:
            boolean r1 = r6.released     // Catch:{ all -> 0x0090 }
            r2 = 0
            if (r1 == 0) goto L_0x001a
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            return r2
        L_0x001a:
            java.util.ArrayDeque<I> r1 = r6.queuedInputBuffers     // Catch:{ all -> 0x0090 }
            java.lang.Object r1 = r1.removeFirst()     // Catch:{ all -> 0x0090 }
            com.google.android.exoplayer2.decoder.DecoderInputBuffer r1 = (com.google.android.exoplayer2.decoder.DecoderInputBuffer) r1     // Catch:{ all -> 0x0090 }
            O[] r3 = r6.availableOutputBuffers     // Catch:{ all -> 0x0090 }
            int r4 = r6.availableOutputBufferCount     // Catch:{ all -> 0x0090 }
            r5 = 1
            int r4 = r4 - r5
            r6.availableOutputBufferCount = r4     // Catch:{ all -> 0x0090 }
            r3 = r3[r4]     // Catch:{ all -> 0x0090 }
            boolean r4 = r6.flushed     // Catch:{ all -> 0x0090 }
            r6.flushed = r2     // Catch:{ all -> 0x0090 }
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            boolean r0 = r1.isEndOfStream()
            if (r0 == 0) goto L_0x003c
            r0 = 4
            r3.addFlag(r0)
            goto L_0x0063
        L_0x003c:
            boolean r0 = r1.isDecodeOnly()
            if (r0 == 0) goto L_0x0047
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r3.addFlag(r0)
        L_0x0047:
            java.lang.Exception r0 = r6.decode(r1, r3, r4)     // Catch:{ RuntimeException -> 0x0052, OutOfMemoryError -> 0x004c }
            goto L_0x0057
        L_0x004c:
            r0 = move-exception
            java.lang.Exception r0 = r6.createUnexpectedDecodeException(r0)
            goto L_0x0057
        L_0x0052:
            r0 = move-exception
            java.lang.Exception r0 = r6.createUnexpectedDecodeException(r0)
        L_0x0057:
            if (r0 == 0) goto L_0x0063
            java.lang.Object r4 = r6.lock
            monitor-enter(r4)
            r6.exception = r0     // Catch:{ all -> 0x0060 }
            monitor-exit(r4)     // Catch:{ all -> 0x0060 }
            return r2
        L_0x0060:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0060 }
            throw r0
        L_0x0063:
            java.lang.Object r4 = r6.lock
            monitor-enter(r4)
            boolean r0 = r6.flushed     // Catch:{ all -> 0x008d }
            if (r0 == 0) goto L_0x006e
            r3.release()     // Catch:{ all -> 0x008d }
            goto L_0x0088
        L_0x006e:
            boolean r0 = r3.isDecodeOnly()     // Catch:{ all -> 0x008d }
            if (r0 == 0) goto L_0x007d
            int r0 = r6.skippedOutputBufferCount     // Catch:{ all -> 0x008d }
            int r0 = r0 + r5
            r6.skippedOutputBufferCount = r0     // Catch:{ all -> 0x008d }
            r3.release()     // Catch:{ all -> 0x008d }
            goto L_0x0088
        L_0x007d:
            int r0 = r6.skippedOutputBufferCount     // Catch:{ all -> 0x008d }
            r3.skippedOutputBufferCount = r0     // Catch:{ all -> 0x008d }
            r6.skippedOutputBufferCount = r2     // Catch:{ all -> 0x008d }
            java.util.ArrayDeque<O> r0 = r6.queuedOutputBuffers     // Catch:{ all -> 0x008d }
            r0.addLast(r3)     // Catch:{ all -> 0x008d }
        L_0x0088:
            r6.releaseInputBufferInternal(r1)     // Catch:{ all -> 0x008d }
            monitor-exit(r4)     // Catch:{ all -> 0x008d }
            return r5
        L_0x008d:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x008d }
            throw r0
        L_0x0090:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            goto L_0x0094
        L_0x0093:
            throw r1
        L_0x0094:
            goto L_0x0093
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.decoder.SimpleDecoder.decode():boolean");
    }

    private boolean canDecodeBuffer() {
        return !this.queuedInputBuffers.isEmpty() && this.availableOutputBufferCount > 0;
    }

    private void releaseInputBufferInternal(I i) {
        i.clear();
        I[] iArr = this.availableInputBuffers;
        int i2 = this.availableInputBufferCount;
        this.availableInputBufferCount = i2 + 1;
        iArr[i2] = i;
    }

    private void releaseOutputBufferInternal(O o) {
        o.clear();
        O[] oArr = this.availableOutputBuffers;
        int i = this.availableOutputBufferCount;
        this.availableOutputBufferCount = i + 1;
        oArr[i] = o;
    }
}
