package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.util.IntArrayQueue;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayDeque;

final class MultiLockAsyncMediaCodecAdapter extends MediaCodec.Callback implements MediaCodecAdapter {
    private final IntArrayQueue availableInputBuffers;
    private final IntArrayQueue availableOutputBuffers;
    private final MediaCodecInputBufferEnqueuer bufferEnqueuer;
    private final ArrayDeque<MediaCodec.BufferInfo> bufferInfos;
    private final MediaCodec codec;
    private IllegalStateException codecException;
    private Runnable codecStartRunnable;
    private MediaFormat currentFormat;
    private final ArrayDeque<MediaFormat> formats;
    private Handler handler;
    private final HandlerThread handlerThread;
    private final Object inputBufferLock;
    private final Object objectStateLock;
    private final Object outputBufferLock;
    private long pendingFlush;
    private int state;

    MultiLockAsyncMediaCodecAdapter(MediaCodec mediaCodec, int i) {
        this(mediaCodec, false, i, new HandlerThread(createThreadLabel(i)));
    }

    MultiLockAsyncMediaCodecAdapter(MediaCodec mediaCodec, boolean z, int i) {
        this(mediaCodec, z, i, new HandlerThread(createThreadLabel(i)));
    }

    MultiLockAsyncMediaCodecAdapter(MediaCodec mediaCodec, boolean z, int i, HandlerThread handlerThread2) {
        this.codec = mediaCodec;
        this.inputBufferLock = new Object();
        this.outputBufferLock = new Object();
        this.objectStateLock = new Object();
        this.availableInputBuffers = new IntArrayQueue();
        this.availableOutputBuffers = new IntArrayQueue();
        this.bufferInfos = new ArrayDeque<>();
        this.formats = new ArrayDeque<>();
        this.codecException = null;
        this.handlerThread = handlerThread2;
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
            this.bufferEnqueuer = new SynchronousMediaCodecBufferEnqueuer(mediaCodec);
        }
        this.state = 0;
    }

    public final void start() {
        synchronized (this.objectStateLock) {
            this.handlerThread.start();
            this.handler = new Handler(this.handlerThread.getLooper());
            this.codec.setCallback(this, this.handler);
            this.bufferEnqueuer.start();
            this.codecStartRunnable.run();
            this.state = 1;
        }
    }

    public final int dequeueInputBufferIndex() {
        synchronized (this.objectStateLock) {
            if (isFlushing()) {
                return -1;
            }
            maybeThrowException();
            int dequeueAvailableInputBufferIndex = dequeueAvailableInputBufferIndex();
            return dequeueAvailableInputBufferIndex;
        }
    }

    public final int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.objectStateLock) {
            if (isFlushing()) {
                return -1;
            }
            maybeThrowException();
            int dequeueAvailableOutputBufferIndex = dequeueAvailableOutputBufferIndex(bufferInfo);
            return dequeueAvailableOutputBufferIndex;
        }
    }

    public final MediaFormat getOutputFormat() {
        MediaFormat mediaFormat;
        synchronized (this.objectStateLock) {
            if (this.currentFormat != null) {
                mediaFormat = this.currentFormat;
            } else {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public final void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.bufferEnqueuer.queueInputBuffer(i, i2, i3, j, i4);
    }

    public final void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) {
        this.bufferEnqueuer.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
    }

    public final void flush() {
        synchronized (this.objectStateLock) {
            this.bufferEnqueuer.flush();
            this.codec.flush();
            this.pendingFlush++;
            ((Handler) Util.castNonNull(this.handler)).post(new Runnable() {
                /* class com.google.android.exoplayer2.mediacodec.$$Lambda$MultiLockAsyncMediaCodecAdapter$c6BFARbPHxJlAFmAJFEFNyhLMeI */

                public final void run() {
                    MultiLockAsyncMediaCodecAdapter.this.onFlushComplete();
                }
            });
        }
    }

    public final void shutdown() {
        synchronized (this.objectStateLock) {
            if (this.state == 1) {
                this.bufferEnqueuer.shutdown();
                this.handlerThread.quit();
            }
            this.state = 2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void setCodecStartRunnable(Runnable runnable) {
        this.codecStartRunnable = runnable;
    }

    private int dequeueAvailableInputBufferIndex() {
        int i;
        synchronized (this.inputBufferLock) {
            if (this.availableInputBuffers.isEmpty()) {
                i = -1;
            } else {
                i = this.availableInputBuffers.remove();
            }
        }
        return i;
    }

    private int dequeueAvailableOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        int i;
        synchronized (this.outputBufferLock) {
            if (this.availableOutputBuffers.isEmpty()) {
                i = -1;
            } else {
                int remove = this.availableOutputBuffers.remove();
                if (remove == -2) {
                    this.currentFormat = this.formats.remove();
                } else if (remove >= 0) {
                    MediaCodec.BufferInfo remove2 = this.bufferInfos.remove();
                    bufferInfo.set(remove2.offset, remove2.size, remove2.presentationTimeUs, remove2.flags);
                }
                i = remove;
            }
        }
        return i;
    }

    private boolean isFlushing() {
        return this.pendingFlush > 0;
    }

    private void maybeThrowException() {
        IllegalStateException illegalStateException = this.codecException;
        if (illegalStateException != null) {
            this.codecException = null;
            throw illegalStateException;
        }
    }

    public final void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.inputBufferLock) {
            this.availableInputBuffers.add(i);
        }
    }

    public final void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.outputBufferLock) {
            this.availableOutputBuffers.add(i);
            this.bufferInfos.add(bufferInfo);
        }
    }

    public final void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException2) {
        onMediaCodecError(codecException2);
    }

    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.outputBufferLock) {
            this.availableOutputBuffers.add(-2);
            this.formats.add(mediaFormat);
        }
    }

    /* access modifiers changed from: package-private */
    public final void onMediaCodecError(IllegalStateException illegalStateException) {
        synchronized (this.objectStateLock) {
            this.codecException = illegalStateException;
        }
    }

    /* access modifiers changed from: private */
    public void onFlushComplete() {
        synchronized (this.objectStateLock) {
            if (this.state != 2) {
                this.pendingFlush--;
                if (this.pendingFlush <= 0) {
                    if (this.pendingFlush < 0) {
                        this.codecException = new IllegalStateException();
                        return;
                    }
                    clearAvailableInput();
                    clearAvailableOutput();
                    this.codecException = null;
                    try {
                        this.codecStartRunnable.run();
                    } catch (IllegalStateException e) {
                        this.codecException = e;
                    } catch (Exception e2) {
                        this.codecException = new IllegalStateException(e2);
                    }
                }
            }
        }
    }

    private void clearAvailableInput() {
        synchronized (this.inputBufferLock) {
            this.availableInputBuffers.clear();
        }
    }

    private void clearAvailableOutput() {
        synchronized (this.outputBufferLock) {
            this.availableOutputBuffers.clear();
            this.bufferInfos.clear();
            this.formats.clear();
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
