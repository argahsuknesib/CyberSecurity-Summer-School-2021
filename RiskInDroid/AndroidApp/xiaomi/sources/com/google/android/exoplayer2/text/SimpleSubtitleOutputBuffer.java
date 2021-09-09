package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.decoder.OutputBuffer;

final class SimpleSubtitleOutputBuffer extends SubtitleOutputBuffer {
    private final OutputBuffer.Owner<SubtitleOutputBuffer> owner;

    public SimpleSubtitleOutputBuffer(OutputBuffer.Owner<SubtitleOutputBuffer> owner2) {
        this.owner = owner2;
    }

    public final void release() {
        this.owner.releaseOutputBuffer(this);
    }
}
