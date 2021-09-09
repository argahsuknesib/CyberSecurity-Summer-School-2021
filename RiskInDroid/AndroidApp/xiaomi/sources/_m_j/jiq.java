package _m_j;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.mp4parser.boxes.iso14496.part12.CompositionTimeToSample;
import org.mp4parser.boxes.iso14496.part12.SampleDependencyTypeBox;

public abstract class jiq extends jhv {
    public static int O00000o = 67107840;
    protected long[] O00000oO;
    protected List<CompositionTimeToSample.Entry> O00000oo;
    protected List<SampleDependencyTypeBox.Entry> O0000O0o;
    protected List<Integer> O0000OOo;
    boolean O0000Oo;
    protected jih O0000Oo0;
    private jhx O0000OoO;

    private jiq(jhx jhx) {
        super(jhx.toString());
        this.O00000oo = new ArrayList();
        this.O0000O0o = new ArrayList();
        this.O0000OOo = new ArrayList();
        this.O0000Oo0 = new jih();
        this.O0000Oo = true;
        this.O0000OoO = jhx;
        this.O0000Oo = true;
    }

    public jiq(jhx jhx, byte b) {
        this(jhx);
    }

    public static InputStream O000000o(InputStream inputStream) {
        return new jis(inputStream);
    }

    public final jih O0000Ooo() {
        return this.O0000Oo0;
    }

    protected static jie O000000o(List<? extends ByteBuffer> list) {
        byte[] bArr = new byte[(list.size() * 4)];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        for (ByteBuffer remaining : list) {
            wrap.putInt(remaining.remaining());
        }
        ByteBuffer[] byteBufferArr = new ByteBuffer[(list.size() * 2)];
        for (int i = 0; i < list.size(); i++) {
            int i2 = i * 2;
            byteBufferArr[i2] = ByteBuffer.wrap(bArr, i * 4, 4);
            byteBufferArr[i2 + 1] = (ByteBuffer) list.get(i);
        }
        return new jif(byteBufferArr);
    }

    public final long[] O0000Oo() {
        return this.O00000oO;
    }

    public final List<CompositionTimeToSample.Entry> O000000o() {
        return this.O00000oo;
    }

    public final long[] O00000Oo() {
        long[] jArr = new long[this.O0000OOo.size()];
        for (int i = 0; i < this.O0000OOo.size(); i++) {
            jArr[i] = (long) this.O0000OOo.get(i).intValue();
        }
        return jArr;
    }

    public final List<SampleDependencyTypeBox.Entry> O00000o0() {
        return this.O0000O0o;
    }

    public void close() throws IOException {
        this.O0000OoO.close();
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        long f1863O000000o = 0;
        int O00000Oo = 0;
        ByteBuffer O00000o;
        jhx O00000o0;
        long O00000oO;

        public O000000o(jhx jhx) throws IOException {
            this.O00000o0 = jhx;
            O00000Oo();
        }

        private void O00000Oo() throws IOException {
            jhx jhx = this.O00000o0;
            this.O00000o = jhx.O000000o(this.f1863O000000o, Math.min(jhx.O000000o() - this.f1863O000000o, (long) jiq.O00000o));
        }

        public final boolean O000000o(boolean z) throws IOException {
            while (true) {
                int limit = this.O00000o.limit();
                int i = this.O00000Oo;
                if (limit - i >= 3) {
                    return this.O00000o.get(i) == 0 && this.O00000o.get(this.O00000Oo + 1) == 0 && ((this.O00000o.get(this.O00000Oo + 2) == 0 && z) || this.O00000o.get(this.O00000Oo + 2) == 1);
                }
                if (this.f1863O000000o + ((long) i) + 3 > this.O00000o0.O000000o()) {
                    return this.f1863O000000o + ((long) this.O00000Oo) == this.O00000o0.O000000o();
                }
                this.f1863O000000o = this.O00000oO;
                this.O00000Oo = 0;
                O00000Oo();
            }
        }

        public final void O000000o() {
            this.O00000Oo++;
        }
    }

    /* access modifiers changed from: protected */
    public final ByteBuffer O000000o(O000000o o000000o) throws IOException {
        while (true) {
            try {
                boolean z = false;
                if (o000000o.O00000o.limit() - o000000o.O00000Oo >= 3) {
                    if (o000000o.O00000o.get(o000000o.O00000Oo) == 0 && o000000o.O00000o.get(o000000o.O00000Oo + 1) == 0 && o000000o.O00000o.get(o000000o.O00000Oo + 2) == 1) {
                        z = true;
                    }
                } else if (o000000o.f1863O000000o + ((long) o000000o.O00000Oo) + 3 >= o000000o.O00000o0.O000000o()) {
                    throw new EOFException();
                }
                if (!z) {
                    o000000o.O000000o();
                } else {
                    o000000o.O00000Oo += 3;
                    o000000o.O00000oO = o000000o.f1863O000000o + ((long) o000000o.O00000Oo);
                    while (!o000000o.O000000o(this.O0000Oo)) {
                        o000000o.O000000o();
                    }
                    if (o000000o.O00000oO >= o000000o.f1863O000000o) {
                        o000000o.O00000o.position((int) (o000000o.O00000oO - o000000o.f1863O000000o));
                        ByteBuffer slice = o000000o.O00000o.slice();
                        slice.limit((int) (((long) o000000o.O00000Oo) - (o000000o.O00000oO - o000000o.f1863O000000o)));
                        return slice;
                    }
                    throw new RuntimeException("damn! NAL exceeds buffer");
                }
            } catch (EOFException unused) {
                return null;
            }
        }
    }
}
