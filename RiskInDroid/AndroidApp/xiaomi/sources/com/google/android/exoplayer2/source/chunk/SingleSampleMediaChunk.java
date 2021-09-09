package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class SingleSampleMediaChunk extends BaseMediaChunk {
    private boolean loadCompleted;
    private long nextLoadPosition;
    private final Format sampleFormat;
    private final int trackType;

    public final void cancelLoad() {
    }

    public SingleSampleMediaChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, long j, long j2, long j3, int i2, Format format2) {
        super(dataSource, dataSpec, format, i, obj, j, j2, -9223372036854775807L, -9223372036854775807L, j3);
        this.trackType = i2;
        this.sampleFormat = format2;
    }

    public final boolean isLoadCompleted() {
        return this.loadCompleted;
    }

    /* JADX INFO: finally extract failed */
    public final void load() throws IOException {
        BaseMediaChunkOutput output = getOutput();
        output.setSampleOffsetUs(0);
        TrackOutput track = output.track(0, this.trackType);
        track.format(this.sampleFormat);
        try {
            long open = this.dataSource.open(this.dataSpec.subrange(this.nextLoadPosition));
            if (open != -1) {
                open += this.nextLoadPosition;
            }
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(this.dataSource, this.nextLoadPosition, open);
            for (int i = 0; i != -1; i = track.sampleData(defaultExtractorInput, Integer.MAX_VALUE, true)) {
                this.nextLoadPosition += (long) i;
            }
            track.sampleMetadata(this.startTimeUs, 1, (int) this.nextLoadPosition, 0, null);
            Util.closeQuietly(this.dataSource);
            this.loadCompleted = true;
        } catch (Throwable th) {
            Util.closeQuietly(this.dataSource);
            throw th;
        }
    }
}
