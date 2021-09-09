package org.mp4parser.boxes.sampleentry;

import _m_j.jgz;
import _m_j.jkv;
import _m_j.jky;
import _m_j.jla;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class Ovc1VisualSampleEntryImpl extends AbstractSampleEntry {
    private byte[] vc1Content = new byte[0];

    public Ovc1VisualSampleEntryImpl() {
        super("ovc1");
    }

    public byte[] getVc1Content() {
        return this.vc1Content;
    }

    public void setVc1Content(byte[] bArr) {
        this.vc1Content = bArr;
    }

    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, jgz jgz) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(jkv.O000000o(j));
        readableByteChannel.read(allocate);
        allocate.position(6);
        this.dataReferenceIndex = jky.O00000o0(allocate);
        this.vc1Content = new byte[allocate.remaining()];
        allocate.get(this.vc1Content);
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.position(6);
        jla.O00000Oo(allocate, this.dataReferenceIndex);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writableByteChannel.write(ByteBuffer.wrap(this.vc1Content));
    }

    public long getSize() {
        int i = 16;
        if (!this.largeBox && ((long) (this.vc1Content.length + 16)) < 4294967296L) {
            i = 8;
        }
        return ((long) i) + ((long) this.vc1Content.length) + 8;
    }
}
