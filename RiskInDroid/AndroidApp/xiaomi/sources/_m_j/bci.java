package _m_j;

import java.util.List;
import java.util.Objects;

public final class bci implements bcj {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f12854O000000o;
    public final int O00000Oo;
    private final List<String> O00000o;
    public final String O00000o0;
    private final bcp O00000oO;
    private final float O00000oo;
    private final String O0000O0o;

    public /* synthetic */ bci(int i, int i2, List list, bcp bcp, float f, String str, String str2, byte b) {
        this(i, i2, list, bcp, f, str, str2);
    }

    private bci(int i, int i2, List<String> list, bcp bcp, float f, String str, String str2) {
        this.f12854O000000o = i;
        this.O00000Oo = i2;
        this.O00000o = list;
        this.O00000oO = bcp;
        this.O00000oo = f;
        this.O0000O0o = str;
        this.O00000o0 = str2;
    }

    public final int O000000o() {
        return this.f12854O000000o;
    }

    public final boolean O00000Oo() {
        return this.O00000Oo != -1;
    }

    public final int O00000o0() {
        return this.O00000Oo;
    }

    public final boolean O00000o() {
        return this.O00000o != null;
    }

    public final List<String> O00000oO() {
        return this.O00000o;
    }

    public final boolean O00000oo() {
        return this.O00000oO != null;
    }

    public final bcp O0000O0o() {
        return this.O00000oO;
    }

    public final boolean O0000OOo() {
        return !Float.isNaN(this.O00000oo);
    }

    public final float O0000Oo0() {
        return this.O00000oo;
    }

    public final boolean O0000Oo() {
        return this.O0000O0o != null;
    }

    public final String O0000OoO() {
        return this.O0000O0o;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f12854O000000o), Integer.valueOf(this.O00000Oo), this.O00000o, this.O00000oO, Float.valueOf(this.O00000oo), this.O0000O0o, this.O00000o0);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bci)) {
            return false;
        }
        bci bci = (bci) obj;
        if (this.f12854O000000o != bci.f12854O000000o || this.O00000Oo != bci.O00000Oo || !Objects.equals(this.O00000o, bci.O00000o) || !Objects.equals(this.O00000oO, bci.O00000oO) || !Objects.equals(Float.valueOf(this.O00000oo), Float.valueOf(bci.O00000oo)) || !Objects.equals(this.O0000O0o, bci.O0000O0o) || !Objects.equals(this.O00000o0, bci.O00000o0)) {
            return false;
        }
        return true;
    }

    public static class O000000o implements bcs {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f12855O000000o = -1;
        public int O00000Oo = -1;
        public bcp O00000o;
        public List<String> O00000o0;
        public float O00000oO = Float.NaN;
        public String O00000oo;
        public String O0000O0o;

        public final /* bridge */ /* synthetic */ bcs O000000o(String str) {
            this.O00000oo = str;
            return this;
        }

        public final /* bridge */ /* synthetic */ bcs O000000o(float f) {
            this.O00000oO = f;
            return this;
        }

        public final /* bridge */ /* synthetic */ bcs O000000o(bcp bcp) {
            this.O00000o = bcp;
            return this;
        }

        public final /* bridge */ /* synthetic */ bcs O000000o(List list) {
            this.O00000o0 = list;
            return this;
        }

        public final /* bridge */ /* synthetic */ bcs O000000o(int i) {
            this.O00000Oo = i;
            return this;
        }

        public final /* bridge */ /* synthetic */ bcs O00000Oo(int i) {
            this.f12855O000000o = i;
            return this;
        }
    }
}
