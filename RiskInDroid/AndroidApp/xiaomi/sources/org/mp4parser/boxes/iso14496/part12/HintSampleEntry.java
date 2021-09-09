package org.mp4parser.boxes.iso14496.part12;

import _m_j.jgz;
import _m_j.jkv;
import _m_j.jky;
import _m_j.jla;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import org.mp4parser.boxes.sampleentry.AbstractSampleEntry;

public class HintSampleEntry extends AbstractSampleEntry {
    protected byte[] data;

    public HintSampleEntry(String str) {
        super(str);
    }

    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, jgz jgz) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        readableByteChannel.read(allocate);
        allocate.position(6);
        this.dataReferenceIndex = jky.O00000o0(allocate);
        this.data = new byte[jkv.O000000o(j - 8)];
        readableByteChannel.read(ByteBuffer.wrap(this.data));
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.position(6);
        jla.O00000Oo(allocate, this.dataReferenceIndex);
        allocate.rewind();
        writableByteChannel.write(allocate);
        writableByteChannel.write(ByteBuffer.wrap(this.data));
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public long getSize() {
        int i = 8;
        long length = (long) (this.data.length + 8);
        if (this.largeBox || 8 + length >= 4294967296L) {
            i = 16;
        }
        return length + ((long) i);
    }
}
