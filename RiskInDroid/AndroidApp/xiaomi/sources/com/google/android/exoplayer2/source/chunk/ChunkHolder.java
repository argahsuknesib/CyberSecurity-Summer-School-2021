package com.google.android.exoplayer2.source.chunk;

public final class ChunkHolder {
    public Chunk chunk;
    public boolean endOfStream;

    public final void clear() {
        this.chunk = null;
        this.endOfStream = false;
    }
}
