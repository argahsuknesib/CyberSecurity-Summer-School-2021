package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.decoder.OutputBuffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class SimpleOutputBuffer extends OutputBuffer {
    public ByteBuffer data;
    private final OutputBuffer.Owner<SimpleOutputBuffer> owner;

    public SimpleOutputBuffer(OutputBuffer.Owner<SimpleOutputBuffer> owner2) {
        this.owner = owner2;
    }

    public ByteBuffer init(long j, int i) {
        this.timeUs = j;
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer == null || byteBuffer.capacity() < i) {
            this.data = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        }
        this.data.position(0);
        this.data.limit(i);
        return this.data;
    }

    public void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public void release() {
        this.owner.releaseOutputBuffer(this);
    }
}
