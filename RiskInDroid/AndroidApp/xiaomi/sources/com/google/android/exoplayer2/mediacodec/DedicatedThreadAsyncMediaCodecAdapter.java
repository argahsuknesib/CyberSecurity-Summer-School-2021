package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.util.Util;

final class DedicatedThreadAsyncMediaCodecAdapter extends MediaCodec.Callback implements MediaCodecAdapter {
    private final MediaCodecInputBufferEnqueuer bufferEnqueuer;
    private final MediaCodec codec;
    private Runnable codecStartRunnable;
    private Handler handler;
    private final HandlerThread handlerThread;
    private IllegalStateException internalException;
    private final MediaCodecAsyncCallback mediaCodecAsyncCallback;
    private long pendingFlushCount;
    private int state;

    DedicatedThreadAsyncMediaCodecAdapter(MediaCodec mediaCodec, int i) {
        this(mediaCodec, false, i, new HandlerThread(createThreadLabel(i)));
    }

    DedicatedThreadAsyncMediaCodecAdapter(MediaCodec mediaCodec, boolean z, int i) {
        this(mediaCodec, z, i, new HandlerThread(createThreadLabel(i)));
    }

    DedicatedThreadAsyncMediaCodecAdapter(MediaCodec mediaCodec, boolean z, int i, HandlerThread handlerThread2) {
        this.mediaCodecAsyncCallback = new MediaCodecAsyncCallback();
        this.codec = mediaCodec;
        this.handlerThread = handlerThread2;
        this.state = 0;
        mediaCodec.getClass();
        this.codecStartRunnable = new Runnable(mediaCodec) {
            /* class com.google.android.exoplayer2.mediacodec.$$Lambda$izPR8Lzfsy3jbfJFz3Zg9j84Yw */
            private final /* synthetic */ MediaCodec f$0;

            {
                this.f$0 = r1;
            }

            public final void run() {
                this.f$0.start();
            }
        };
        if (z) {
            this.bufferEnqueuer = new AsynchronousMediaCodecBufferEnqueuer(mediaCodec, i);
        } else {
            this.bufferEnqueuer = new SynchronousMediaCodecBufferEnqueuer(this.codec);
        }
    }

    public final synchronized void start() {
        this.handlerThread.start();
        this.handler = new Handler(this.handlerThread.getLooper());
        this.codec.setCallback(this, this.handler);
        this.bufferEnqueuer.start();
        this.codecStartRunnable.run();
        this.state = 1;
    }

    public final void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.bufferEnqueuer.queueInputBuffer(i, i2, i3, j, i4);
    }

    public final void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) {
        this.bufferEnqueuer.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
    }

    public final synchronized int dequeueInputBufferIndex() {
        if (isFlushing()) {
            return -1;
        }
        maybeThrowException();
        return this.mediaCodecAsyncCallback.dequeueInputBufferIndex();
    }

    public final synchronized int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        if (isFlushing()) {
            return -1;
        }
        maybeThrowException();
        return this.mediaCodecAsyncCallback.dequeueOutputBufferIndex(bufferInfo);
    }

    public final synchronized MediaFormat getOutputFormat() {
        return this.mediaCodecAsyncCallback.getOutputFormat();
    }

    public final synchronized void flush() {
        this.bufferEnqueuer.flush();
        this.codec.flush();
        this.pendingFlushCount++;
        ((Handler) Util.castNonNull(this.handler)).post(new Runnable() {
            /* class com.google.android.exoplayer2.mediacodec.$$Lambda$DedicatedThreadAsyncMediaCodecAdapter$xFnCdK8oHYwOZrIUf3UVXcO5VZk */

            public final void run() {
                DedicatedThreadAsyncMediaCodecAdapter.this.onFlushCompleted();
            }
        });
    }

    public final synchronized void shutdown() {
        if (this.state == 1) {
            this.bufferEnqueuer.shutdown();
            this.handlerThread.quit();
            this.mediaCodecAsyncCallback.flush();
        }
        this.state = 2;
    }

    public final synchronized void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        this.mediaCodecAsyncCallback.onInputBufferAvailable(mediaCodec, i);
    }

    public final synchronized void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        this.mediaCodecAsyncCallback.onOutputBufferAvailable(mediaCodec, i, bufferInfo);
    }

    public final synchronized void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        this.mediaCodecAsyncCallback.onError(mediaCodec, codecException);
    }

    public final synchronized void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        this.mediaCodecAsyncCallback.onOutputFormatChanged(mediaCodec, mediaFormat);
    }

    /* access modifiers changed from: package-private */
    public final void onMediaCodecError(IllegalStateException illegalStateException) {
        this.mediaCodecAsyncCallback.onMediaCodecError(illegalStateException);
    }

    /* access modifiers changed from: package-private */
    public final void setCodecStartRunnable(Runnable runnable) {
        this.codecStartRunnable = runnable;
    }

    /* access modifiers changed from: private */
    public synchronized void onFlushCompleted() {
        if (this.state == 1) {
            this.pendingFlushCount--;
            if (this.pendingFlushCount <= 0) {
                if (this.pendingFlushCount < 0) {
                    this.internalException = new IllegalStateException();
                    return;
                }
                this.mediaCodecAsyncCallback.flush();
                try {
                    this.codecStartRunnable.run();
                } catch (IllegalStateException e) {
                    this.internalException = e;
                } catch (Exception e2) {
                    this.internalException = new IllegalStateException(e2);
                }
            }
        }
    }

    private synchronized boolean isFlushing() {
        return this.pendingFlushCount > 0;
    }

    private synchronized void maybeThrowException() {
        maybeThrowInternalException();
        this.mediaCodecAsyncCallback.maybeThrowMediaCodecException();
    }

    private synchronized void maybeThrowInternalException() {
        if (this.internalException != null) {
            IllegalStateException illegalStateException = this.internalException;
            this.internalException = null;
            throw illegalStateException;
        }
    }

    private static String createThreadLabel(int i) {
        StringBuilder sb = new StringBuilder("ExoPlayer:MediaCodecAsyncAdapter:");
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
}
