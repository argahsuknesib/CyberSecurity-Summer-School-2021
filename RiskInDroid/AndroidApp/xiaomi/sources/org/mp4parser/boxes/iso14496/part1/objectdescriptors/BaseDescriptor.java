package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import _m_j.jky;
import java.io.IOException;
import java.nio.ByteBuffer;

@Descriptor(tags = {0})
public abstract class BaseDescriptor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    int sizeBytes;
    int sizeOfInstance;
    int tag;

    /* access modifiers changed from: package-private */
    public abstract int getContentSize();

    public abstract void parseDetail(ByteBuffer byteBuffer) throws IOException;

    public abstract ByteBuffer serialize();

    public int getTag() {
        return this.tag;
    }

    public void writeSize(ByteBuffer byteBuffer, int i) {
        int position = byteBuffer.position();
        int i2 = 0;
        while (true) {
            if (i > 0 || i2 < this.sizeBytes) {
                i2++;
                if (i > 0) {
                    byteBuffer.put((getSizeSize() + position) - i2, (byte) (i & 127));
                } else {
                    byteBuffer.put((getSizeSize() + position) - i2, Byte.MIN_VALUE);
                }
                i >>>= 7;
            } else {
                byteBuffer.position(position + getSizeSize());
                return;
            }
        }
    }

    public int getSizeSize() {
        int contentSize = getContentSize();
        int i = 0;
        while (true) {
            if (contentSize <= 0 && i >= this.sizeBytes) {
                return i;
            }
            contentSize >>>= 7;
            i++;
        }
    }

    public int getSize() {
        return getContentSize() + getSizeSize() + 1;
    }

    public final void parse(int i, ByteBuffer byteBuffer) throws IOException {
        this.tag = i;
        int O000000o2 = jky.O000000o(byteBuffer.get());
        this.sizeOfInstance = O000000o2 & 127;
        int i2 = 1;
        while ((O000000o2 >>> 7) == 1) {
            O000000o2 = jky.O000000o(byteBuffer.get());
            i2++;
            this.sizeOfInstance = (this.sizeOfInstance << 7) | (O000000o2 & 127);
        }
        this.sizeBytes = i2;
        ByteBuffer slice = byteBuffer.slice();
        slice.limit(this.sizeOfInstance);
        parseDetail(slice);
        byteBuffer.position(byteBuffer.position() + this.sizeOfInstance);
    }

    public String toString() {
        return "BaseDescriptor" + "{tag=" + this.tag + ", sizeOfInstance=" + this.sizeOfInstance + '}';
    }
}
