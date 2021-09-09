package org.mp4parser.boxes.iso14496.part30;

import _m_j.jgz;
import _m_j.jky;
import _m_j.jla;
import _m_j.jlc;
import _m_j.jli;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import org.mp4parser.boxes.sampleentry.AbstractSampleEntry;

public class XMLSubtitleSampleEntry extends AbstractSampleEntry {
    private String auxiliaryMimeTypes = "";
    private String namespace = "";
    private String schemaLocation = "";

    public XMLSubtitleSampleEntry() {
        super("stpp");
    }

    public long getSize() {
        int i = 8;
        long containerSize = getContainerSize() + ((long) (this.namespace.length() + 8 + this.schemaLocation.length() + this.auxiliaryMimeTypes.length() + 3));
        if (this.largeBox || 8 + containerSize >= 4294967296L) {
            i = 16;
        }
        return containerSize + ((long) i);
    }

    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, jgz jgz) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(8);
        readableByteChannel.read((ByteBuffer) allocate.rewind());
        allocate.position(6);
        this.dataReferenceIndex = jky.O00000o0(allocate);
        byte[] bArr = new byte[0];
        while (true) {
            int read = Channels.newInputStream(readableByteChannel).read();
            if (read == 0) {
                break;
            }
            bArr = jlc.O000000o(bArr, (byte) read);
        }
        this.namespace = jli.O000000o(bArr);
        byte[] bArr2 = new byte[0];
        while (true) {
            int read2 = Channels.newInputStream(readableByteChannel).read();
            if (read2 == 0) {
                break;
            }
            bArr2 = jlc.O000000o(bArr2, (byte) read2);
        }
        this.schemaLocation = jli.O000000o(bArr2);
        byte[] bArr3 = new byte[0];
        while (true) {
            int read3 = Channels.newInputStream(readableByteChannel).read();
            if (read3 == 0) {
                this.auxiliaryMimeTypes = jli.O000000o(bArr3);
                initContainer(readableByteChannel, j - ((long) ((((byteBuffer.remaining() + this.namespace.length()) + this.schemaLocation.length()) + this.auxiliaryMimeTypes.length()) + 3)), jgz);
                return;
            }
            bArr3 = jlc.O000000o(bArr3, (byte) read3);
        }
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(this.namespace.length() + 8 + this.schemaLocation.length() + this.auxiliaryMimeTypes.length() + 3);
        allocate.position(6);
        jla.O00000Oo(allocate, this.dataReferenceIndex);
        jla.O00000Oo(allocate, this.namespace);
        jla.O00000Oo(allocate, this.schemaLocation);
        jla.O00000Oo(allocate, this.auxiliaryMimeTypes);
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writeContainer(writableByteChannel);
    }

    public String getNamespace() {
        return this.namespace;
    }

    public void setNamespace(String str) {
        this.namespace = str;
    }

    public String getSchemaLocation() {
        return this.schemaLocation;
    }

    public void setSchemaLocation(String str) {
        this.schemaLocation = str;
    }

    public String getAuxiliaryMimeTypes() {
        return this.auxiliaryMimeTypes;
    }

    public void setAuxiliaryMimeTypes(String str) {
        this.auxiliaryMimeTypes = str;
    }
}
