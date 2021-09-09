package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.DefaultExtractorInput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.source.chunk.ChunkExtractorWrapper;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class InitializationChunk extends Chunk {
    private static final PositionHolder DUMMY_POSITION_HOLDER = new PositionHolder();
    private final ChunkExtractorWrapper extractorWrapper;
    private volatile boolean loadCanceled;
    private long nextLoadPosition;
    private ChunkExtractorWrapper.TrackOutputProvider trackOutputProvider;

    public InitializationChunk(DataSource dataSource, DataSpec dataSpec, Format format, int i, Object obj, ChunkExtractorWrapper chunkExtractorWrapper) {
        super(dataSource, dataSpec, 2, format, i, obj, -9223372036854775807L, -9223372036854775807L);
        this.extractorWrapper = chunkExtractorWrapper;
    }

    public final void init(ChunkExtractorWrapper.TrackOutputProvider trackOutputProvider2) {
        this.trackOutputProvider = trackOutputProvider2;
    }

    public final void cancelLoad() {
        this.loadCanceled = true;
    }

    public final void load() throws IOException {
        DefaultExtractorInput defaultExtractorInput;
        if (this.nextLoadPosition == 0) {
            this.extractorWrapper.init(this.trackOutputProvider, -9223372036854775807L, -9223372036854775807L);
        }
        try {
            DataSpec subrange = this.dataSpec.subrange(this.nextLoadPosition);
            defaultExtractorInput = new DefaultExtractorInput(this.dataSource, subrange.position, this.dataSource.open(subrange));
            Extractor extractor = this.extractorWrapper.extractor;
            int i = 0;
            while (i == 0 && !this.loadCanceled) {
                i = extractor.read(defaultExtractorInput, DUMMY_POSITION_HOLDER);
            }
            boolean z = true;
            if (i == 1) {
                z = false;
            }
            Assertions.checkState(z);
            this.nextLoadPosition = defaultExtractorInput.getPosition() - this.dataSpec.position;
            Util.closeQuietly(this.dataSource);
        } catch (Throwable th) {
            Util.closeQuietly(this.dataSource);
            throw th;
        }
    }
}
