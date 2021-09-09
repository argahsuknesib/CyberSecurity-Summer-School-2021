package org.mp4parser.boxes.iso14496.part12;

import _m_j.jgz;
import _m_j.jko;
import _m_j.jky;
import _m_j.jla;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class MetaBox extends jko {
    private int flags;
    private int version;

    public MetaBox() {
        super("meta");
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public int getFlags() {
        return this.flags;
    }

    public void setFlags(int i) {
        this.flags = i;
    }

    /* access modifiers changed from: protected */
    public final void writeVersionAndFlags(ByteBuffer byteBuffer) {
        jla.O00000o(byteBuffer, this.version);
        jla.O000000o(byteBuffer, this.flags);
    }

    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, jgz jgz) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        readableByteChannel.read(allocate);
        parseVersionAndFlags((ByteBuffer) allocate.rewind());
        initContainer(readableByteChannel, j - 4, jgz);
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(4);
        writeVersionAndFlags(allocate);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writeContainer(writableByteChannel);
    }

    public long getSize() {
        long containerSize = getContainerSize() + 4;
        return containerSize + ((long) ((this.largeBox || containerSize >= 4294967296L) ? 16 : 8));
    }

    /* access modifiers changed from: protected */
    public final long parseVersionAndFlags(ByteBuffer byteBuffer) {
        this.version = jky.O000000o(byteBuffer.get());
        this.flags = jky.O00000Oo(byteBuffer);
        return 4;
    }
}
