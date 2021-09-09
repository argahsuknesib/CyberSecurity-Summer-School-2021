package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import java.io.IOException;

final class UnexpectedSampleTimestampException extends IOException {
    public final long lastAcceptedSampleTimeUs;
    public final MediaChunk mediaChunk;
    public final long rejectedSampleTimeUs;

    public UnexpectedSampleTimestampException(MediaChunk mediaChunk2, long j, long j2) {
        super("Unexpected sample timestamp: " + C.usToMs(j2) + " in chunk [" + mediaChunk2.startTimeUs + ", " + mediaChunk2.endTimeUs + "]");
        this.mediaChunk = mediaChunk2;
        this.lastAcceptedSampleTimeUs = j;
        this.rejectedSampleTimeUs = j2;
    }
}
