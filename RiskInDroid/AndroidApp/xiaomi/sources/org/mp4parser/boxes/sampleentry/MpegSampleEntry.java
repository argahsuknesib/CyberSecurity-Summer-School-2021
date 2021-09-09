package org.mp4parser.boxes.sampleentry;

import _m_j.jgz;
import _m_j.jky;
import _m_j.jla;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class MpegSampleEntry extends AbstractSampleEntry {
    public MpegSampleEntry() {
        super("mp4s");
    }

    public MpegSampleEntry(String str) {
        super(str);
    }

    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, jgz jgz) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        readableByteChannel.read(allocate);
        allocate.position(6);
        this.dataReferenceIndex = jky.O00000o0(allocate);
        initContainer(readableByteChannel, j - 8, jgz);
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.position(6);
        jla.O00000Oo(allocate, this.dataReferenceIndex);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writeContainer(writableByteChannel);
    }

    public String toString() {
        return "MpegSampleEntry" + getBoxes();
    }

    public long getSize() {
        long containerSize = getContainerSize() + 8;
        return containerSize + ((long) ((this.largeBox || containerSize >= 4294967296L) ? 16 : 8));
    }
}
