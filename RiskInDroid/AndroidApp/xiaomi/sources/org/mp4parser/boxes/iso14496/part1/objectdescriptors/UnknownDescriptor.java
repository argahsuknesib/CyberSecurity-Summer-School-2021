package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Logger;

public class UnknownDescriptor extends BaseDescriptor {
    private static Logger log = Logger.getLogger(UnknownDescriptor.class.getName());
    private ByteBuffer data;

    public void parseDetail(ByteBuffer byteBuffer) throws IOException {
        this.data = byteBuffer.slice();
    }

    public String toString() {
        return "UnknownDescriptor" + "{tag=" + this.tag + ", sizeOfInstance=" + this.sizeOfInstance + ", data=" + this.data + '}';
    }

    public ByteBuffer serialize() {
        throw new RuntimeException("sdjlhfl");
    }

    /* access modifiers changed from: package-private */
    public int getContentSize() {
        throw new RuntimeException("sdjlhfl");
    }
}
