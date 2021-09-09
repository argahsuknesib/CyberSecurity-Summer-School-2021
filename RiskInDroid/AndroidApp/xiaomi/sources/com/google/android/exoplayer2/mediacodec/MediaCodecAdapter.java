package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.google.android.exoplayer2.decoder.CryptoInfo;

interface MediaCodecAdapter {
    int dequeueInputBufferIndex();

    int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo);

    void flush();

    MediaFormat getOutputFormat();

    void queueInputBuffer(int i, int i2, int i3, long j, int i4);

    void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3);

    void shutdown();

    void start();
}
