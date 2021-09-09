package org.mp4parser.boxes.iso14496.part12;

import _m_j.jgz;
import _m_j.jha;
import _m_j.jhd;
import _m_j.jkv;
import _m_j.jla;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.LinkedList;
import java.util.List;

public class FreeBox implements jhd {
    ByteBuffer data;
    private long offset;
    private jha parent;
    List<jhd> replacers;

    public String getType() {
        return "free";
    }

    public FreeBox() {
        this.replacers = new LinkedList();
        this.data = ByteBuffer.wrap(new byte[0]);
    }

    public FreeBox(int i) {
        this.replacers = new LinkedList();
        this.data = ByteBuffer.allocate(i);
    }

    public ByteBuffer getData() {
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            return (ByteBuffer) byteBuffer.duplicate().rewind();
        }
        return null;
    }

    public void setData(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        for (jhd box : this.replacers) {
            box.getBox(writableByteChannel);
        }
        ByteBuffer allocate = ByteBuffer.allocate(8);
        jla.O00000Oo(allocate, (long) (this.data.limit() + 8));
        allocate.put("free".getBytes());
        allocate.rewind();
        writableByteChannel.write(allocate);
        allocate.rewind();
        this.data.rewind();
        writableByteChannel.write(this.data);
        this.data.rewind();
    }

    public long getSize() {
        long j = 8;
        for (jhd size : this.replacers) {
            j += size.getSize();
        }
        return j + ((long) this.data.limit());
    }

    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, jgz jgz) throws IOException {
        this.data = ByteBuffer.allocate(jkv.O000000o(j));
        int i = 0;
        do {
            i += readableByteChannel.read(this.data);
        } while (((long) i) < j);
    }

    public void addAndReplace(jhd jhd) {
        this.data.position(jkv.O000000o(jhd.getSize()));
        this.data = this.data.slice();
        this.replacers.add(jhd);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FreeBox freeBox = (FreeBox) obj;
        return getData() == null ? freeBox.getData() == null : getData().equals(freeBox.getData());
    }

    public int hashCode() {
        ByteBuffer byteBuffer = this.data;
        if (byteBuffer != null) {
            return byteBuffer.hashCode();
        }
        return 0;
    }
}
