package _m_j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

public final class jif implements jie {

    /* renamed from: O000000o  reason: collision with root package name */
    private final long f1849O000000o = -1;
    private final long O00000Oo;
    private ByteBuffer[] O00000o0;

    public jif(ByteBuffer[] byteBufferArr) {
        int i = 0;
        for (ByteBuffer remaining : byteBufferArr) {
            i += remaining.remaining();
        }
        this.O00000Oo = (long) i;
        this.O00000o0 = byteBufferArr;
    }

    public final void O000000o(WritableByteChannel writableByteChannel) throws IOException {
        for (ByteBuffer duplicate : this.O00000o0) {
            writableByteChannel.write(duplicate.duplicate());
        }
    }

    public final long O000000o() {
        return this.O00000Oo;
    }

    public final ByteBuffer O00000Oo() {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[jkv.O000000o(this.O00000Oo)]);
        for (ByteBuffer duplicate : this.O00000o0) {
            wrap.put(duplicate.duplicate());
        }
        wrap.rewind();
        return wrap;
    }

    public final String toString() {
        return "SampleImpl" + "{offset=" + this.f1849O000000o + "{size=" + this.O00000Oo + '}';
    }
}
