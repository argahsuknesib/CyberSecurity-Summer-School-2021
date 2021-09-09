package _m_j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class jhz implements jhx {
    private static jks O00000o0 = jks.O000000o(jhz.class);

    /* renamed from: O000000o  reason: collision with root package name */
    FileChannel f1846O000000o;
    String O00000Oo;

    public jhz(String str) throws FileNotFoundException {
        File file = new File(str);
        this.f1846O000000o = new FileInputStream(file).getChannel();
        this.O00000Oo = file.getName();
    }

    public final synchronized int O000000o(ByteBuffer byteBuffer) throws IOException {
        return this.f1846O000000o.read(byteBuffer);
    }

    public final synchronized long O000000o() throws IOException {
        return this.f1846O000000o.size();
    }

    public final synchronized long O00000Oo() throws IOException {
        return this.f1846O000000o.position();
    }

    public final synchronized void O000000o(long j) throws IOException {
        this.f1846O000000o.position(j);
    }

    public final synchronized long O000000o(long j, long j2, WritableByteChannel writableByteChannel) throws IOException {
        return this.f1846O000000o.transferTo(j, j2, writableByteChannel);
    }

    public final synchronized ByteBuffer O000000o(long j, long j2) throws IOException {
        jks jks = O00000o0;
        jks.O000000o(j + " " + j2);
        return this.f1846O000000o.map(FileChannel.MapMode.READ_ONLY, j, j2);
    }

    public void close() throws IOException {
        this.f1846O000000o.close();
    }

    public String toString() {
        return this.O00000Oo;
    }
}
