package _m_j;

import com.fasterxml.jackson.core.util.BufferRecycler;
import java.io.Writer;

public final class aiz extends Writer {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final ajo f12397O000000o;

    public final void close() {
    }

    public final void flush() {
    }

    public aiz(BufferRecycler bufferRecycler) {
        this.f12397O000000o = new ajo(bufferRecycler);
    }

    public final Writer append(char c) {
        write(c);
        return this;
    }

    public final Writer append(CharSequence charSequence) {
        String obj = charSequence.toString();
        this.f12397O000000o.O000000o(obj, 0, obj.length());
        return this;
    }

    public final Writer append(CharSequence charSequence, int i, int i2) {
        String obj = charSequence.subSequence(i, i2).toString();
        this.f12397O000000o.O000000o(obj, 0, obj.length());
        return this;
    }

    public final void write(char[] cArr) {
        this.f12397O000000o.O00000o0(cArr, 0, cArr.length);
    }

    public final void write(char[] cArr, int i, int i2) {
        this.f12397O000000o.O00000o0(cArr, i, i2);
    }

    public final void write(int i) {
        ajo ajo = this.f12397O000000o;
        char c = (char) i;
        if (ajo.O00000o0 >= 0) {
            ajo.O000000o(16);
        }
        ajo.O0000OOo = null;
        ajo.O0000Oo0 = null;
        char[] cArr = ajo.O00000oo;
        if (ajo.O0000O0o >= cArr.length) {
            ajo.O00000Oo(1);
            cArr = ajo.O00000oo;
        }
        int i2 = ajo.O0000O0o;
        ajo.O0000O0o = i2 + 1;
        cArr[i2] = c;
    }

    public final void write(String str) {
        this.f12397O000000o.O000000o(str, 0, str.length());
    }

    public final void write(String str, int i, int i2) {
        this.f12397O000000o.O000000o(str, 0, str.length());
    }

    public final String O000000o() {
        String O00000oo = this.f12397O000000o.O00000oo();
        this.f12397O000000o.O000000o();
        return O00000oo;
    }
}
