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

public class ItemProtectionBox extends jko implements jhb {
    private int flags;
    private int version;

    public ItemProtectionBox() {
        super("ipro");
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

    public SchemeInformationBox getItemProtectionScheme() {
        if (!getBoxes(SchemeInformationBox.class).isEmpty()) {
            return (SchemeInformationBox) getBoxes(SchemeInformationBox.class).get(0);
        }
        return null;
    }

    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, jgz jgz) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(6);
        readableByteChannel.read(allocate);
        allocate.rewind();
        this.version = jky.O000000o(allocate.get());
        this.flags = jky.O00000Oo(allocate);
        initContainer(readableByteChannel, j - 6, jgz);
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        ByteBuffer allocate = ByteBuffer.allocate(6);
        jla.O00000o(allocate, this.version);
        jla.O000000o(allocate, this.flags);
        jla.O00000Oo(allocate, getBoxes().size());
        writableByteChannel.write((ByteBuffer) allocate.rewind());
        writeContainer(writableByteChannel);
    }

    public long getSize() {
        long containerSize = getContainerSize() + 6;
        return containerSize + ((long) ((this.largeBox || containerSize >= 4294967296L) ? 16 : 8));
    }
}
