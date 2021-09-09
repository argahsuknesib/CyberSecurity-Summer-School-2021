package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;

public final class EmptySampleStream implements SampleStream {
    public final boolean isReady() {
        return true;
    }

    public final void maybeThrowError() {
    }

    public final int skipData(long j) {
        return 0;
    }

    public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        decoderInputBuffer.setFlags(4);
        return -4;
    }
}
