package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import _m_j.jkx;
import _m_j.jla;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

@Descriptor(tags = {5})
public class DecoderSpecificInfo extends BaseDescriptor {
    byte[] bytes;

    public DecoderSpecificInfo() {
        this.tag = 5;
    }

    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        this.bytes = new byte[byteBuffer.remaining()];
        byteBuffer.get(this.bytes);
    }

    public void setData(byte[] bArr) {
        this.bytes = bArr;
    }

    /* access modifiers changed from: package-private */
    public int getContentSize() {
        return this.bytes.length;
    }

    public ByteBuffer serialize() {
        ByteBuffer allocate = ByteBuffer.allocate(getSize());
        jla.O00000o(allocate, this.tag);
        writeSize(allocate, getContentSize());
        allocate.put(this.bytes);
        return (ByteBuffer) allocate.rewind();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DecoderSpecificInfo");
        sb.append("{bytes=");
        byte[] bArr = this.bytes;
        sb.append(bArr == null ? "null" : jkx.O000000o(bArr));
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && Arrays.equals(this.bytes, ((DecoderSpecificInfo) obj).bytes);
    }

    public int hashCode() {
        byte[] bArr = this.bytes;
        if (bArr != null) {
            return Arrays.hashCode(bArr);
        }
        return 0;
    }
}
