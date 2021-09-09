package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.SeekParameters;
import java.io.IOException;
import java.util.List;

public interface ChunkSource {
    long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters);

    void getNextChunk(long j, long j2, List<? extends MediaChunk> list, ChunkHolder chunkHolder);

    int getPreferredQueueSize(long j, List<? extends MediaChunk> list);

    void maybeThrowError() throws IOException;

    void onChunkLoadCompleted(Chunk chunk);

    boolean onChunkLoadError(Chunk chunk, boolean z, Exception exc, long j);
}
