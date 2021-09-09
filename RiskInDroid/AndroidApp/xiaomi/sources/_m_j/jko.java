package _m_j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class jko extends jgx implements jhd {
    protected boolean largeBox;
    jha parent;
    protected String type;

    public jko(String str) {
        this.type = str;
    }

    public void setParent(jha jha) {
        this.parent = jha;
    }

    public long getSize() {
        long containerSize = getContainerSize();
        return containerSize + ((long) ((this.largeBox || 8 + containerSize >= 4294967296L) ? 16 : 8));
    }

    public String getType() {
        return this.type;
    }

    /* access modifiers changed from: protected */
    public ByteBuffer getHeader() {
        ByteBuffer byteBuffer;
        if (this.largeBox || getSize() >= 4294967296L) {
            byte[] bArr = new byte[16];
            bArr[3] = 1;
            bArr[4] = this.type.getBytes()[0];
            bArr[5] = this.type.getBytes()[1];
            bArr[6] = this.type.getBytes()[2];
            bArr[7] = this.type.getBytes()[3];
            byteBuffer = ByteBuffer.wrap(bArr);
            byteBuffer.position(8);
            jla.O000000o(byteBuffer, getSize());
        } else {
            byte[] bArr2 = new byte[8];
            bArr2[4] = this.type.getBytes()[0];
            bArr2[5] = this.type.getBytes()[1];
            bArr2[6] = this.type.getBytes()[2];
            bArr2[7] = this.type.getBytes()[3];
            byteBuffer = ByteBuffer.wrap(bArr2);
            jla.O00000Oo(byteBuffer, getSize());
        }
        byteBuffer.rewind();
        return byteBuffer;
    }

    public void parse(ReadableByteChannel readableByteChannel, ByteBuffer byteBuffer, long j, jgz jgz) throws IOException {
        this.largeBox = byteBuffer.remaining() == 16;
        initContainer(readableByteChannel, j, jgz);
    }

    public void getBox(WritableByteChannel writableByteChannel) throws IOException {
        writableByteChannel.write(getHeader());
        writeContainer(writableByteChannel);
    }
}
