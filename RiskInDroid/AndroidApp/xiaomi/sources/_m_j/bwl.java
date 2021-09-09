package _m_j;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class bwl {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ThreadLocal<Charset> f13338O000000o = new ThreadLocal<Charset>() {
        /* class _m_j.bwl.AnonymousClass2 */

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object initialValue() {
            return Charset.forName("UTF-8");
        }
    };
    private static final ThreadLocal<CharsetDecoder> O00000o = new ThreadLocal<CharsetDecoder>() {
        /* class _m_j.bwl.AnonymousClass1 */

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object initialValue() {
            return Charset.forName("UTF-8").newDecoder();
        }
    };
    private static final ThreadLocal<CharBuffer> O00000oO = new ThreadLocal<>();
    public int O00000Oo;
    public ByteBuffer O00000o0;

    /* access modifiers changed from: protected */
    public final int O00000o(int i) {
        return i + this.O00000o0.getInt(i);
    }

    /* access modifiers changed from: protected */
    public final int O00000o0(int i) {
        int i2 = this.O00000Oo;
        int i3 = i2 - this.O00000o0.getInt(i2);
        if (i < this.O00000o0.getShort(i3)) {
            return this.O00000o0.getShort(i3 + i);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public final int O00000oO(int i) {
        int i2 = i + this.O00000Oo;
        return this.O00000o0.getInt(i2 + this.O00000o0.getInt(i2));
    }

    /* access modifiers changed from: protected */
    public final int O00000oo(int i) {
        int i2 = i + this.O00000Oo;
        return i2 + this.O00000o0.getInt(i2) + 4;
    }
}
