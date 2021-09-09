package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import _m_j.jkx;
import java.io.IOException;
import java.nio.ByteBuffer;

@Descriptor(tags = {19})
public class ExtensionProfileLevelDescriptor extends BaseDescriptor {
    byte[] bytes;

    public ExtensionProfileLevelDescriptor() {
        this.tag = 19;
    }

    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        if (getSize() > 0) {
            this.bytes = new byte[getSize()];
            byteBuffer.get(this.bytes);
        }
    }

    public ByteBuffer serialize() {
        throw new RuntimeException("Not Implemented");
    }

    /* access modifiers changed from: package-private */
    public int getContentSize() {
        throw new RuntimeException("Not Implemented");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExtensionDescriptor");
        sb.append("{bytes=");
        byte[] bArr = this.bytes;
        sb.append(bArr == null ? "null" : jkx.O000000o(bArr));
        sb.append('}');
        return sb.toString();
    }
}
