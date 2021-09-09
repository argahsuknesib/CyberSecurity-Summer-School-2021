package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.upstream.DataSpec;
import java.util.NoSuchElementException;

public interface MediaChunkIterator {
    public static final MediaChunkIterator EMPTY = new MediaChunkIterator() {
        /* class com.google.android.exoplayer2.source.chunk.MediaChunkIterator.AnonymousClass1 */

        public final boolean isEnded() {
            return true;
        }

        public final boolean next() {
            return false;
        }

        public final void reset() {
        }

        public final DataSpec getDataSpec() {
            throw new NoSuchElementException();
        }

        public final long getChunkStartTimeUs() {
            throw new NoSuchElementException();
        }

        public final long getChunkEndTimeUs() {
            throw new NoSuchElementException();
        }
    };

    long getChunkEndTimeUs();

    long getChunkStartTimeUs();

    DataSpec getDataSpec();

    boolean isEnded();

    boolean next();

    void reset();
}
