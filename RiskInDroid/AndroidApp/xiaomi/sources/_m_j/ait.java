package _m_j;

import com.fasterxml.jackson.core.util.BufferRecycler;

public final class ait {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final Object f12393O000000o;
    protected final boolean O00000Oo;
    protected byte[] O00000o = null;
    protected final BufferRecycler O00000o0;
    protected byte[] O00000oO = null;
    protected char[] O00000oo = null;
    protected char[] O0000O0o = null;
    protected char[] O0000OOo = null;

    public ait(BufferRecycler bufferRecycler, Object obj, boolean z) {
        this.O00000o0 = bufferRecycler;
        this.f12393O000000o = obj;
        this.O00000Oo = z;
    }

    public final Object O000000o() {
        return this.f12393O000000o;
    }

    public final boolean O00000Oo() {
        return this.O00000Oo;
    }

    public final ajo O00000o0() {
        return new ajo(this.O00000o0);
    }

    public final char[] O00000o() {
        if (this.O00000oo == null) {
            this.O00000oo = this.O00000o0.O000000o(BufferRecycler.CharBufferType.TOKEN_BUFFER);
            return this.O00000oo;
        }
        throw new IllegalStateException("Trying to call allocTokenBuffer() second time");
    }

    public final char[] O00000oO() {
        if (this.O0000O0o == null) {
            this.O0000O0o = this.O00000o0.O000000o(BufferRecycler.CharBufferType.CONCAT_BUFFER);
            return this.O0000O0o;
        }
        throw new IllegalStateException("Trying to call allocConcatBuffer() second time");
    }

    public final char[] O000000o(int i) {
        if (this.O0000OOo == null) {
            this.O0000OOo = this.O00000o0.O000000o(BufferRecycler.CharBufferType.NAME_COPY_BUFFER, i);
            return this.O0000OOo;
        }
        throw new IllegalStateException("Trying to call allocNameCopyBuffer() second time");
    }

    public final void O000000o(char[] cArr) {
        if (cArr == null) {
            return;
        }
        if (cArr == this.O00000oo) {
            this.O00000oo = null;
            this.O00000o0.O000000o(BufferRecycler.CharBufferType.TOKEN_BUFFER, cArr);
            return;
        }
        throw new IllegalArgumentException("Trying to release buffer not owned by the context");
    }

    public final void O00000Oo(char[] cArr) {
        if (cArr == null) {
            return;
        }
        if (cArr == this.O0000O0o) {
            this.O0000O0o = null;
            this.O00000o0.O000000o(BufferRecycler.CharBufferType.CONCAT_BUFFER, cArr);
            return;
        }
        throw new IllegalArgumentException("Trying to release buffer not owned by the context");
    }

    public final void O00000o0(char[] cArr) {
        if (cArr == null) {
            return;
        }
        if (cArr == this.O0000OOo) {
            this.O0000OOo = null;
            this.O00000o0.O000000o(BufferRecycler.CharBufferType.NAME_COPY_BUFFER, cArr);
            return;
        }
        throw new IllegalArgumentException("Trying to release buffer not owned by the context");
    }
}
