package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.util.Assertions;

final class AsynchronousMediaCodecAdapter implements MediaCodecAdapter {
    private final MediaCodec codec;
    private Runnable codecStartRunnable;
    private boolean flushing;
    private final Handler handler;
    private IllegalStateException internalException;
    private final MediaCodecAsyncCallback mediaCodecAsyncCallback;

    public AsynchronousMediaCodecAdapter(MediaCodec mediaCodec) {
        this(mediaCodec, (Looper) Assertions.checkNotNull(Looper.myLooper()));
    }

    AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, Looper looper) {
        this.mediaCodecAsyncCallback = new MediaCodecAsyncCallback();
        this.handler = new Handler(looper);
        this.codec = mediaCodec;
        this.codec.setCallback(this.mediaCodecAsyncCallback);
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
    }

    public final void start() {
        this.codecStartRunnable.run();
    }

    public final void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.codec.queueInputBuffer(i, i2, i3, j, i4);
    }

    public final void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) {
        this.codec.queueSecureInputBuffer(i, i2, cryptoInfo.getFrameworkCryptoInfo(), j, i3);
    }

    public final int dequeueInputBufferIndex() {
        if (this.flushing) {
            return -1;
        }
        maybeThrowException();
        return this.mediaCodecAsyncCallback.dequeueInputBufferIndex();
    }

    public final int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        if (this.flushing) {
            return -1;
        }
        maybeThrowException();
        return this.mediaCodecAsyncCallback.dequeueOutputBufferIndex(bufferInfo);
    }

    public final MediaFormat getOutputFormat() {
        return this.mediaCodecAsyncCallback.getOutputFormat();
    }

    public final void flush() {
        clearPendingFlushState();
        this.flushing = true;
        this.codec.flush();
        this.handler.post(new Runnable() {
            /* class com.google.android.exoplayer2.mediacodec.$$Lambda$AsynchronousMediaCodecAdapter$53EDScw7byJGtERkiJtfmQMp0 */

            public final void run() {
                AsynchronousMediaCodecAdapter.this.onCompleteFlush();
            }
        });
    }

    public final void shutdown() {
        clearPendingFlushState();
    }

    /* access modifiers changed from: package-private */
    public final MediaCodec.Callback getMediaCodecCallback() {
        return this.mediaCodecAsyncCallback;
    }

    /* access modifiers changed from: private */
    public void onCompleteFlush() {
        this.flushing = false;
        this.mediaCodecAsyncCallback.flush();
        try {
            this.codecStartRunnable.run();
        } catch (IllegalStateException e) {
            this.internalException = e;
        } catch (Exception e2) {
            this.internalException = new IllegalStateException(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void setCodecStartRunnable(Runnable runnable) {
        this.codecStartRunnable = runnable;
    }

    private void maybeThrowException() throws IllegalStateException {
        maybeThrowInternalException();
        this.mediaCodecAsyncCallback.maybeThrowMediaCodecException();
    }

    private void maybeThrowInternalException() {
        IllegalStateException illegalStateException = this.internalException;
        if (illegalStateException != null) {
            this.internalException = null;
            throw illegalStateException;
        }
    }

    private void clearPendingFlushState() {
        this.handler.removeCallbacksAndMessages(null);
        this.internalException = null;
    }
}
