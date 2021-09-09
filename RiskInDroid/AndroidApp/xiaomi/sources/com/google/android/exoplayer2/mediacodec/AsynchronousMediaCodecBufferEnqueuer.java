package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

class AsynchronousMediaCodecBufferEnqueuer implements MediaCodecInputBufferEnqueuer {
    private static final ArrayDeque<MessageParams> MESSAGE_PARAMS_INSTANCE_POOL = new ArrayDeque<>();
    private static final Object QUEUE_SECURE_LOCK = new Object();
    private final MediaCodec codec;
    private final ConditionVariable conditionVariable;
    private Handler handler;
    private final HandlerThread handlerThread;
    private final boolean needsSynchronizationWorkaround;
    private final AtomicReference<RuntimeException> pendingRuntimeException;
    private boolean started;

    public AsynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec, int i) {
        this(mediaCodec, new HandlerThread(createThreadLabel(i)), new ConditionVariable());
    }

    AsynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec, HandlerThread handlerThread2, ConditionVariable conditionVariable2) {
        this.codec = mediaCodec;
        this.handlerThread = handlerThread2;
        this.conditionVariable = conditionVariable2;
        this.pendingRuntimeException = new AtomicReference<>();
        this.needsSynchronizationWorkaround = needsSynchronizationWorkaround();
    }

    public void start() {
        if (!this.started) {
            this.handlerThread.start();
            this.handler = new Handler(this.handlerThread.getLooper()) {
                /* class com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer.AnonymousClass1 */

                public void handleMessage(Message message) {
                    AsynchronousMediaCodecBufferEnqueuer.this.doHandleMessage(message);
                }
            };
            this.started = true;
        }
    }

    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        maybeThrowException();
        MessageParams messageParams = getMessageParams();
        messageParams.setQueueParams(i, i2, i3, j, i4);
        ((Handler) Util.castNonNull(this.handler)).obtainMessage(0, messageParams).sendToTarget();
    }

    public void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) {
        maybeThrowException();
        MessageParams messageParams = getMessageParams();
        messageParams.setQueueParams(i, i2, 0, j, i3);
        copy(cryptoInfo, messageParams.cryptoInfo);
        ((Handler) Util.castNonNull(this.handler)).obtainMessage(1, messageParams).sendToTarget();
    }

    public void flush() {
        if (this.started) {
            try {
                flushHandlerThread();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    public void shutdown() {
        if (this.started) {
            flush();
            this.handlerThread.quit();
        }
        this.started = false;
    }

    public void doHandleMessage(Message message) {
        MessageParams messageParams;
        int i = message.what;
        if (i == 0) {
            messageParams = (MessageParams) message.obj;
            doQueueInputBuffer(messageParams.index, messageParams.offset, messageParams.size, messageParams.presentationTimeUs, messageParams.flags);
        } else if (i != 1) {
            if (i != 2) {
                setPendingRuntimeException(new IllegalStateException(String.valueOf(message.what)));
            } else {
                this.conditionVariable.open();
            }
            messageParams = null;
        } else {
            messageParams = (MessageParams) message.obj;
            doQueueSecureInputBuffer(messageParams.index, messageParams.offset, messageParams.cryptoInfo, messageParams.presentationTimeUs, messageParams.flags);
        }
        if (messageParams != null) {
            recycleMessageParams(messageParams);
        }
    }

    private void maybeThrowException() {
        RuntimeException andSet = this.pendingRuntimeException.getAndSet(null);
        if (andSet != null) {
            throw andSet;
        }
    }

    private void flushHandlerThread() throws InterruptedException {
        Handler handler2 = (Handler) Util.castNonNull(this.handler);
        handler2.removeCallbacksAndMessages(null);
        this.conditionVariable.close();
        handler2.obtainMessage(2).sendToTarget();
        this.conditionVariable.block();
        maybeThrowException();
    }

    /* access modifiers changed from: package-private */
    public void setPendingRuntimeException(RuntimeException runtimeException) {
        this.pendingRuntimeException.set(runtimeException);
    }

    private void doQueueInputBuffer(int i, int i2, int i3, long j, int i4) {
        try {
            this.codec.queueInputBuffer(i, i2, i3, j, i4);
        } catch (RuntimeException e) {
            setPendingRuntimeException(e);
        }
    }

    private void doQueueSecureInputBuffer(int i, int i2, MediaCodec.CryptoInfo cryptoInfo, long j, int i3) {
        try {
            if (this.needsSynchronizationWorkaround) {
                synchronized (QUEUE_SECURE_LOCK) {
                    this.codec.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
                }
                return;
            }
            this.codec.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
        } catch (RuntimeException e) {
            setPendingRuntimeException(e);
        }
    }

    static int getInstancePoolSize() {
        int size;
        synchronized (MESSAGE_PARAMS_INSTANCE_POOL) {
            size = MESSAGE_PARAMS_INSTANCE_POOL.size();
        }
        return size;
    }

    private static MessageParams getMessageParams() {
        synchronized (MESSAGE_PARAMS_INSTANCE_POOL) {
            if (MESSAGE_PARAMS_INSTANCE_POOL.isEmpty()) {
                MessageParams messageParams = new MessageParams();
                return messageParams;
            }
            MessageParams removeFirst = MESSAGE_PARAMS_INSTANCE_POOL.removeFirst();
            return removeFirst;
        }
    }

    private static void recycleMessageParams(MessageParams messageParams) {
        synchronized (MESSAGE_PARAMS_INSTANCE_POOL) {
            MESSAGE_PARAMS_INSTANCE_POOL.add(messageParams);
        }
    }

    static class MessageParams {
        public final MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        public int flags;
        public int index;
        public int offset;
        public long presentationTimeUs;
        public int size;

        MessageParams() {
        }

        public void setQueueParams(int i, int i2, int i3, long j, int i4) {
            this.index = i;
            this.offset = i2;
            this.size = i3;
            this.presentationTimeUs = j;
            this.flags = i4;
        }
    }

    private static boolean needsSynchronizationWorkaround() {
        String lowerInvariant = Util.toLowerInvariant(Util.MANUFACTURER);
        return lowerInvariant.contains("samsung") || lowerInvariant.contains("motorola");
    }

    private static String createThreadLabel(int i) {
        StringBuilder sb = new StringBuilder("ExoPlayer:MediaCodecBufferEnqueuer:");
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    private static void copy(CryptoInfo cryptoInfo, MediaCodec.CryptoInfo cryptoInfo2) {
        cryptoInfo2.numSubSamples = cryptoInfo.numSubSamples;
        cryptoInfo2.numBytesOfClearData = copy(cryptoInfo.numBytesOfClearData, cryptoInfo2.numBytesOfClearData);
        cryptoInfo2.numBytesOfEncryptedData = copy(cryptoInfo.numBytesOfEncryptedData, cryptoInfo2.numBytesOfEncryptedData);
        cryptoInfo2.key = copy(cryptoInfo.key, cryptoInfo2.key);
        cryptoInfo2.iv = copy(cryptoInfo.iv, cryptoInfo2.iv);
        cryptoInfo2.mode = cryptoInfo.mode;
        if (Util.SDK_INT >= 24) {
            cryptoInfo2.setPattern(new MediaCodec.CryptoInfo.Pattern(cryptoInfo.encryptedBlocks, cryptoInfo.clearBlocks));
        }
    }

    private static int[] copy(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    private static byte[] copy(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }
}
