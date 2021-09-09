package _m_j;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public final class jia implements jid {

    /* renamed from: O000000o  reason: collision with root package name */
    private RandomAccessFile f1847O000000o;

    public jia(RandomAccessFile randomAccessFile) {
        this.f1847O000000o = randomAccessFile;
    }

    public final ByteBuffer O000000o(long j, long j2) throws IOException {
        byte[] bArr = new byte[jkv.O000000o(j2)];
        this.f1847O000000o.seek(j);
        this.f1847O000000o.read(bArr);
        return ByteBuffer.wrap(bArr);
    }

    public final void close() throws IOException {
        this.f1847O000000o.close();
    }
}
