package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import java.nio.ByteBuffer;

public class BitWriterBuffer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private ByteBuffer buffer;
    int initialPos;
    int position = 0;

    public BitWriterBuffer(ByteBuffer byteBuffer) {
        this.buffer = byteBuffer;
        this.initialPos = byteBuffer.position();
    }

    public void writeBool(boolean z) {
        writeBits(z ? 1 : 0, 1);
    }

    public void writeBits(int i, int i2) {
        int i3 = this.position;
        int i4 = 8 - (i3 % 8);
        int i5 = 1;
        if (i2 <= i4) {
            int i6 = this.buffer.get(this.initialPos + (i3 / 8));
            if (i6 < 0) {
                i6 += 256;
            }
            int i7 = i6 + (i << (i4 - i2));
            ByteBuffer byteBuffer = this.buffer;
            int i8 = this.initialPos + (this.position / 8);
            if (i7 > 127) {
                i7 -= 256;
            }
            byteBuffer.put(i8, (byte) i7);
            this.position += i2;
        } else {
            int i9 = i2 - i4;
            writeBits(i >> i9, i4);
            writeBits(i & ((1 << i9) - 1), i9);
        }
        ByteBuffer byteBuffer2 = this.buffer;
        int i10 = this.initialPos;
        int i11 = this.position;
        int i12 = i10 + (i11 / 8);
        if (i11 % 8 <= 0) {
            i5 = 0;
        }
        byteBuffer2.position(i12 + i5);
    }
}
