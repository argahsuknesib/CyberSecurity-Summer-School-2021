package _m_j;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;

public final class jju implements jjj {

    /* renamed from: O000000o  reason: collision with root package name */
    private ByteBuffer f1887O000000o;
    private long O00000Oo;
    private HashMap<Class<? extends jji>, jji> O00000o0 = new HashMap<>();

    public jju(ByteBuffer byteBuffer) {
        this.f1887O000000o = byteBuffer.duplicate();
        this.O00000Oo = 1024;
    }

    public jju(byte[] bArr, long j) {
        this.O00000Oo = j;
        this.f1887O000000o = ByteBuffer.wrap(bArr);
    }

    public jju(List<ByteBuffer> list, long j) {
        this.O00000Oo = j;
        int i = 0;
        for (ByteBuffer limit : list) {
            i = i + 4 + limit.limit();
        }
        this.f1887O000000o = ByteBuffer.allocate(i);
        for (ByteBuffer next : list) {
            this.f1887O000000o.put((byte) ((next.limit() & -16777216) >> 24));
            this.f1887O000000o.put((byte) ((next.limit() & 16711680) >> 16));
            this.f1887O000000o.put((byte) ((next.limit() & 65280) >> 8));
            this.f1887O000000o.put((byte) (next.limit() & 255));
            this.f1887O000000o.put((ByteBuffer) next.rewind());
        }
    }

    public final ByteBuffer O000000o() {
        return this.f1887O000000o;
    }

    public final long O00000Oo() {
        return this.O00000Oo;
    }

    public final <T extends jji> T O000000o(Class<T> cls) {
        return (jji) this.O00000o0.get(cls);
    }

    public final void O000000o(jji jji) {
        this.O00000o0.put(jji.getClass(), jji);
    }

    public final <T extends jji> T O00000Oo(Class<T> cls) {
        return (jji) this.O00000o0.remove(cls);
    }
}
