package _m_j;

import gK.f;

public final class jqw {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final f f2071O000000o = f.O000000o(":status");
    public static final f O00000Oo = f.O000000o(":method");
    public static final f O00000o = f.O000000o(":scheme");
    public static final f O00000o0 = f.O000000o(":path");
    public static final f O00000oO = f.O000000o(":authority");
    public static final f O00000oo = f.O000000o(":host");
    public static final f O0000O0o = f.O000000o(":version");
    public final f O0000OOo;
    final int O0000Oo;
    public final f O0000Oo0;

    public jqw(f fVar, String str) {
        this(fVar, f.O000000o(str));
    }

    public jqw(String str, String str2) {
        this(f.O000000o(str), f.O000000o(str2));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof jqw) {
            jqw jqw = (jqw) obj;
            return this.O0000OOo.equals(jqw.O0000OOo) && this.O0000Oo0.equals(jqw.O0000Oo0);
        }
    }

    public final int hashCode() {
        return ((this.O0000OOo.hashCode() + 527) * 31) + this.O0000Oo0.hashCode();
    }

    public final String toString() {
        return String.format("%s: %s", this.O0000OOo.O000000o(), this.O0000Oo0.O000000o());
    }

    public jqw(f fVar, f fVar2) {
        this.O0000OOo = fVar;
        this.O0000Oo0 = fVar2;
        this.O0000Oo = fVar.c.length + 32 + fVar2.c.length;
    }
}
