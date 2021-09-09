package org.mp4parser.boxes.samplegrouping;

import _m_j.jkx;
import java.nio.ByteBuffer;

public class UnknownEntry extends GroupEntry {
    private ByteBuffer content;
    private String type;

    public UnknownEntry(String str) {
        this.type = str;
    }

    public String getType() {
        return this.type;
    }

    public ByteBuffer getContent() {
        return this.content;
    }

    public void setContent(ByteBuffer byteBuffer) {
        this.content = (ByteBuffer) byteBuffer.duplicate().rewind();
    }

    public void parse(ByteBuffer byteBuffer) {
        this.content = (ByteBuffer) byteBuffer.duplicate().rewind();
    }

    public ByteBuffer get() {
        return this.content.duplicate();
    }

    public String toString() {
        ByteBuffer duplicate = this.content.duplicate();
        duplicate.rewind();
        byte[] bArr = new byte[duplicate.limit()];
        duplicate.get(bArr);
        return "UnknownEntry{content=" + jkx.O000000o(bArr) + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UnknownEntry unknownEntry = (UnknownEntry) obj;
        ByteBuffer byteBuffer = this.content;
        return byteBuffer == null ? unknownEntry.content == null : byteBuffer.equals(unknownEntry.content);
    }

    public int hashCode() {
        ByteBuffer byteBuffer = this.content;
        if (byteBuffer != null) {
            return byteBuffer.hashCode();
        }
        return 0;
    }
}
