package org.mp4parser.boxes.samplegrouping;

import java.nio.ByteBuffer;

public class VisualRandomAccessEntry extends GroupEntry {
    private short numLeadingSamples;
    private boolean numLeadingSamplesKnown;

    public String getType() {
        return "rap ";
    }

    public boolean isNumLeadingSamplesKnown() {
        return this.numLeadingSamplesKnown;
    }

    public void setNumLeadingSamplesKnown(boolean z) {
        this.numLeadingSamplesKnown = z;
    }

    public short getNumLeadingSamples() {
        return this.numLeadingSamples;
    }

    public void setNumLeadingSamples(short s) {
        this.numLeadingSamples = s;
    }

    public void parse(ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        this.numLeadingSamplesKnown = (b & 128) == 128;
        this.numLeadingSamples = (short) (b & Byte.MAX_VALUE);
    }

    public ByteBuffer get() {
        ByteBuffer allocate = ByteBuffer.allocate(1);
        allocate.put((byte) ((this.numLeadingSamplesKnown ? (short) 128 : 0) | (this.numLeadingSamples & 127)));
        allocate.rewind();
        return allocate;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VisualRandomAccessEntry visualRandomAccessEntry = (VisualRandomAccessEntry) obj;
        return this.numLeadingSamples == visualRandomAccessEntry.numLeadingSamples && this.numLeadingSamplesKnown == visualRandomAccessEntry.numLeadingSamplesKnown;
    }

    public int hashCode() {
        return ((this.numLeadingSamplesKnown ? 1 : 0) * true) + this.numLeadingSamples;
    }

    public String toString() {
        return "VisualRandomAccessEntry" + "{numLeadingSamplesKnown=" + this.numLeadingSamplesKnown + ", numLeadingSamples=" + ((int) this.numLeadingSamples) + '}';
    }
}
