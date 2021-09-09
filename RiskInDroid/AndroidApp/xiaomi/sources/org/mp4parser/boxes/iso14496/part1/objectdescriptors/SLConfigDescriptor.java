package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import _m_j.jky;
import _m_j.jla;
import java.io.IOException;
import java.nio.ByteBuffer;

@Descriptor(tags = {6})
public class SLConfigDescriptor extends BaseDescriptor {
    int predefined;

    /* access modifiers changed from: package-private */
    public int getContentSize() {
        return 1;
    }

    public SLConfigDescriptor() {
        this.tag = 6;
    }

    public int getPredefined() {
        return this.predefined;
    }

    public void setPredefined(int i) {
        this.predefined = i;
    }

    public ByteBuffer serialize() {
        ByteBuffer allocate = ByteBuffer.allocate(getSize());
        jla.O00000o(allocate, 6);
        writeSize(allocate, getContentSize());
        jla.O00000o(allocate, this.predefined);
        return allocate;
    }

    public String toString() {
        return "SLConfigDescriptor" + "{predefined=" + this.predefined + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.predefined == ((SLConfigDescriptor) obj).predefined;
    }

    public int hashCode() {
        return this.predefined;
    }

    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        this.predefined = jky.O000000o(byteBuffer.get());
    }
}
