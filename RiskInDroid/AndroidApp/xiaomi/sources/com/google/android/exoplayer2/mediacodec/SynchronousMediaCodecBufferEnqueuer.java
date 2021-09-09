package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import com.google.android.exoplayer2.decoder.CryptoInfo;

class SynchronousMediaCodecBufferEnqueuer implements MediaCodecInputBufferEnqueuer {
    private final MediaCodec codec;

    public void flush() {
    }

    public void shutdown() {
    }

    public void start() {
    }

    SynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec) {
        this.codec = mediaCodec;
    }

    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.codec.queueInputBuffer(i, i2, i3, j, i4);
    }

    public void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) {
        this.codec.queueSecureInputBuffer(i, i2, cryptoInfo.getFrameworkCryptoInfo(), j, i3);
    }
}
