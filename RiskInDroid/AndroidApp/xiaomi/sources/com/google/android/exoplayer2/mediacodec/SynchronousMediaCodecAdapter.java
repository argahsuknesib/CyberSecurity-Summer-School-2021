package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.google.android.exoplayer2.decoder.CryptoInfo;

final class SynchronousMediaCodecAdapter implements MediaCodecAdapter {
    private final MediaCodec codec;

    public final void shutdown() {
    }

    public SynchronousMediaCodecAdapter(MediaCodec mediaCodec) {
        this.codec = mediaCodec;
    }

    public final void start() {
        this.codec.start();
    }

    public final int dequeueInputBufferIndex() {
        return this.codec.dequeueInputBuffer(0);
    }

    public final int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        return this.codec.dequeueOutputBuffer(bufferInfo, 0);
    }

    public final MediaFormat getOutputFormat() {
        return this.codec.getOutputFormat();
    }

    public final void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.codec.queueInputBuffer(i, i2, i3, j, i4);
    }

    public final void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) {
        this.codec.queueSecureInputBuffer(i, i2, cryptoInfo.getFrameworkCryptoInfo(), j, i3);
    }

    public final void flush() {
        this.codec.flush();
    }
}
