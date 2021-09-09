package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

final class HlsSampleStream implements SampleStream {
    private int sampleQueueIndex = -1;
    private final HlsSampleStreamWrapper sampleStreamWrapper;
    private final int trackGroupIndex;

    public HlsSampleStream(HlsSampleStreamWrapper hlsSampleStreamWrapper, int i) {
        this.sampleStreamWrapper = hlsSampleStreamWrapper;
        this.trackGroupIndex = i;
    }

    public final void bindSampleQueue() {
        Assertions.checkArgument(this.sampleQueueIndex == -1);
        this.sampleQueueIndex = this.sampleStreamWrapper.bindSampleQueueToSampleStream(this.trackGroupIndex);
    }

    public final void unbindSampleQueue() {
        if (this.sampleQueueIndex != -1) {
            this.sampleStreamWrapper.unbindSampleQueue(this.trackGroupIndex);
            this.sampleQueueIndex = -1;
        }
    }

    public final boolean isReady() {
        if (this.sampleQueueIndex != -3) {
            return hasValidSampleQueueIndex() && this.sampleStreamWrapper.isReady(this.sampleQueueIndex);
        }
        return true;
    }

    public final void maybeThrowError() throws IOException {
        int i = this.sampleQueueIndex;
        if (i == -2) {
            throw new SampleQueueMappingException(this.sampleStreamWrapper.getTrackGroups().get(this.trackGroupIndex).getFormat(0).sampleMimeType);
        } else if (i == -1) {
            this.sampleStreamWrapper.maybeThrowError();
        } else if (i != -3) {
            this.sampleStreamWrapper.maybeThrowError(i);
        }
    }

    public final int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        if (this.sampleQueueIndex == -3) {
            decoderInputBuffer.addFlag(4);
            return -4;
        } else if (hasValidSampleQueueIndex()) {
            return this.sampleStreamWrapper.readData(this.sampleQueueIndex, formatHolder, decoderInputBuffer, z);
        } else {
            return -3;
        }
    }

    public final int skipData(long j) {
        if (hasValidSampleQueueIndex()) {
            return this.sampleStreamWrapper.skipData(this.sampleQueueIndex, j);
        }
        return 0;
    }

    private boolean hasValidSampleQueueIndex() {
        int i = this.sampleQueueIndex;
        return (i == -1 || i == -3 || i == -2) ? false : true;
    }
}
