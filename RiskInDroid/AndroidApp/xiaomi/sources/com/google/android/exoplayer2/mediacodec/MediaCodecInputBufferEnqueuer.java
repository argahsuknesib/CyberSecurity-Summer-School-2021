package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.decoder.CryptoInfo;

interface MediaCodecInputBufferEnqueuer {
    void flush();

    void queueInputBuffer(int i, int i2, int i3, long j, int i4);

    void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3);

    void shutdown();

    void start();
}
