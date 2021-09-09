package org.mp4parser.boxes.sampleentry;

import _m_j.jgz;
import _m_j.jko;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public abstract class AbstractSampleEntry extends jko implements SampleEntry {
    protected int dataReferenceIndex = 1;

    public abstract void getBox(WritableByteChannel writableByteChannel) throws IOException;

    public abstract void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, jgz jgz) throws IOException;

    protected AbstractSampleEntry(String str) {
        super(str);
    }

    public int getDataReferenceIndex() {
        return this.dataReferenceIndex;
    }

    public void setDataReferenceIndex(int i) {
        this.dataReferenceIndex = i;
    }
}
