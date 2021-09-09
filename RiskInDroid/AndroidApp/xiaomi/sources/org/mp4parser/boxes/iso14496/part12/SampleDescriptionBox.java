package org.mp4parser.boxes.iso14496.part12;

import _m_j.jgz;
import _m_j.jhb;
import _m_j.jko;
import _m_j.jky;
import _m_j.jla;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import org.mp4parser.boxes.sampleentry.AbstractSampleEntry;

public class SampleDescriptionBox extends jko implements jhb {
    private int flags;
    private int version;

    public SampleDescriptionBox() {
        super("stsd");
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

    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, jgz jgz) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        readableByteChannel.read(allocate);
        allocate.rewind();
        this.version = jky.O000000o(allocate.get());
        this.flags = jky.O00000Oo(allocate);
        initContainer(readableByteChannel, j - 8, jgz);
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(8);
        jla.O00000o(allocate, this.version);
        jla.O000000o(allocate, this.flags);
        jla.O00000Oo(allocate, (long) getBoxes().size());
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writeContainer(writableByteChannel);
    }

    public AbstractSampleEntry getSampleEntry() {
        Iterator it = getBoxes(AbstractSampleEntry.class).iterator();
        if (it.hasNext()) {
            return (AbstractSampleEntry) it.next();
        }
        return null;
    }

    public long getSize() {
        long containerSize = getContainerSize() + 8;
        return containerSize + ((long) ((this.largeBox || 8 + containerSize >= 4294967296L) ? 16 : 8));
    }
}
