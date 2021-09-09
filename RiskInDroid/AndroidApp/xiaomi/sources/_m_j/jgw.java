package _m_j;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Logger;

public abstract class jgw implements jgz {
    private static Logger O00000Oo = Logger.getLogger(jgw.class.getName());

    /* renamed from: O000000o  reason: collision with root package name */
    ThreadLocal<ByteBuffer> f1831O000000o = new ThreadLocal<ByteBuffer>() {
        /* class _m_j.jgw.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object initialValue() {
            return ByteBuffer.allocate(32);
        }
    };

    public abstract jhd O000000o(String str, byte[] bArr, String str2);

    public final jhd O000000o(ReadableByteChannel readableByteChannel, String str) throws IOException {
        int read;
        long j;
        byte[] bArr;
        long j2;
        ReadableByteChannel readableByteChannel2 = readableByteChannel;
        this.f1831O000000o.get().rewind().limit(8);
        int i = 0;
        do {
            read = readableByteChannel2.read(this.f1831O000000o.get());
            i += read;
            if (i >= 8) {
                this.f1831O000000o.get().rewind();
                long O000000o2 = jky.O000000o(this.f1831O000000o.get());
                if (O000000o2 >= 8 || O000000o2 <= 1) {
                    String O0000OoO = jky.O0000OoO(this.f1831O000000o.get());
                    if (O000000o2 == 1) {
                        this.f1831O000000o.get().limit(16);
                        readableByteChannel2.read(this.f1831O000000o.get());
                        this.f1831O000000o.get().position(8);
                        j = jky.O00000oo(this.f1831O000000o.get()) - 16;
                    } else {
                        if (O000000o2 != 0) {
                            j2 = O000000o2 - 8;
                        } else if (readableByteChannel2 instanceof FileChannel) {
                            FileChannel fileChannel = (FileChannel) readableByteChannel2;
                            j2 = fileChannel.size() - fileChannel.position();
                        } else {
                            j = 3;
                        }
                        j = j2;
                    }
                    if ("uuid".equals(O0000OoO)) {
                        this.f1831O000000o.get().limit(this.f1831O000000o.get().limit() + 16);
                        readableByteChannel2.read(this.f1831O000000o.get());
                        bArr = new byte[16];
                        for (int position = this.f1831O000000o.get().position() - 16; position < this.f1831O000000o.get().position(); position++) {
                            bArr[position - (this.f1831O000000o.get().position() - 16)] = this.f1831O000000o.get().get(position);
                        }
                        j -= 16;
                    } else {
                        bArr = null;
                    }
                    long j3 = j;
                    jhd O000000o3 = O000000o(O0000OoO, bArr, str);
                    this.f1831O000000o.get().rewind();
                    if (j3 > 524288000) {
                        civ.O00000o("g711", "OOM size ".concat(String.valueOf(j3)));
                        return null;
                    }
                    O000000o3.parse(readableByteChannel, this.f1831O000000o.get(), j3, this);
                    return O000000o3;
                }
                O00000Oo.severe("Plausibility check failed: size < 8 (size = " + O000000o2 + "). Stop parsing!");
                return null;
            }
        } while (read >= 0);
        throw new EOFException();
    }
}
