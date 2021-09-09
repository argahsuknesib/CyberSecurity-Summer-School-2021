package org.mp4parser.boxes.sampleentry;

import _m_j.jgz;
import _m_j.jha;
import _m_j.jky;
import _m_j.jla;
import _m_j.jli;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public final class VisualSampleEntry extends AbstractSampleEntry implements jha {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private String compressorname = "";
    private int depth = 24;
    private int frameCount = 1;
    private int height;
    private double horizresolution = 72.0d;
    private long[] predefined = new long[3];
    private double vertresolution = 72.0d;
    private int width;

    public VisualSampleEntry() {
        super("avc1");
    }

    public VisualSampleEntry(String str) {
        super(str);
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final double getHorizresolution() {
        return this.horizresolution;
    }

    public final void setHorizresolution(double d) {
        this.horizresolution = d;
    }

    public final double getVertresolution() {
        return this.vertresolution;
    }

    public final void setVertresolution(double d) {
        this.vertresolution = d;
    }

    public final int getFrameCount() {
        return this.frameCount;
    }

    public final void setFrameCount(int i) {
        this.frameCount = i;
    }

    public final String getCompressorname() {
        return this.compressorname;
    }

    public final void setCompressorname(String str) {
        this.compressorname = str;
    }

    public final int getDepth() {
        return this.depth;
    }

    public final void setDepth(int i) {
        this.depth = i;
    }

    public final void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, jgz jgz) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(78);
        readableByteChannel.read(allocate);
        allocate.position(6);
        this.dataReferenceIndex = jky.O00000o0(allocate);
        jky.O00000o0(allocate);
        jky.O00000o0(allocate);
        this.predefined[0] = jky.O000000o(allocate);
        this.predefined[1] = jky.O000000o(allocate);
        this.predefined[2] = jky.O000000o(allocate);
        this.width = jky.O00000o0(allocate);
        this.height = jky.O00000o0(allocate);
        this.horizresolution = jky.O0000O0o(allocate);
        this.vertresolution = jky.O0000O0o(allocate);
        jky.O000000o(allocate);
        this.frameCount = jky.O00000o0(allocate);
        int O000000o2 = jky.O000000o(allocate.get());
        if (O000000o2 > 31) {
            O000000o2 = 31;
        }
        byte[] bArr = new byte[O000000o2];
        allocate.get(bArr);
        this.compressorname = jli.O000000o(bArr);
        if (O000000o2 < 31) {
            allocate.get(new byte[(31 - O000000o2)]);
        }
        this.depth = jky.O00000o0(allocate);
        jky.O00000o0(allocate);
        initContainer(readableByteChannel, j - 78, jgz);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jla.O00000Oo(java.nio.ByteBuffer, long):void
     arg types: [java.nio.ByteBuffer, int]
     candidates:
      _m_j.jla.O00000Oo(java.nio.ByteBuffer, double):void
      _m_j.jla.O00000Oo(java.nio.ByteBuffer, int):void
      _m_j.jla.O00000Oo(java.nio.ByteBuffer, java.lang.String):void
      _m_j.jla.O00000Oo(java.nio.ByteBuffer, long):void */
    public final void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(78);
        allocate.position(6);
        jla.O00000Oo(allocate, this.dataReferenceIndex);
        jla.O00000Oo(allocate, 0);
        jla.O00000Oo(allocate, 0);
        jla.O00000Oo(allocate, this.predefined[0]);
        jla.O00000Oo(allocate, this.predefined[1]);
        jla.O00000Oo(allocate, this.predefined[2]);
        jla.O00000Oo(allocate, getWidth());
        jla.O00000Oo(allocate, getHeight());
        jla.O000000o(allocate, getHorizresolution());
        jla.O000000o(allocate, getVertresolution());
        jla.O00000Oo(allocate, 0L);
        jla.O00000Oo(allocate, getFrameCount());
        jla.O00000o(allocate, jli.O00000Oo(getCompressorname()));
        allocate.put(jli.O000000o(getCompressorname()));
        int O00000Oo = jli.O00000Oo(getCompressorname());
        while (O00000Oo < 31) {
            O00000Oo++;
            allocate.put((byte) 0);
        }
        jla.O00000Oo(allocate, getDepth());
        jla.O00000Oo(allocate, 65535);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writeContainer(writableByteChannel);
    }

    public final long getSize() {
        long containerSize = getContainerSize() + 78;
        return containerSize + ((long) ((this.largeBox || 8 + containerSize >= 4294967296L) ? 16 : 8));
    }
}
