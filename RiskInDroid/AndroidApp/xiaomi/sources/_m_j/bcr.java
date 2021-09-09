package _m_j;

import java.util.List;
import java.util.Objects;

public final class bcr implements bcj {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f12869O000000o;
    public final int O00000Oo;
    public final String O00000o;
    public final String O00000o0;
    public final String O00000oO;
    private final List<String> O00000oo;
    private final bcp O0000O0o;
    private final float O0000OOo;
    private final String O0000Oo0;

    public /* synthetic */ bcr(int i, int i2, List list, bcp bcp, float f, String str, String str2, String str3, String str4, byte b) {
        this(i, i2, list, bcp, f, str, str2, str3, str4);
    }

    private bcr(int i, int i2, List<String> list, bcp bcp, float f, String str, String str2, String str3, String str4) {
        this.f12869O000000o = i;
        this.O00000Oo = i2;
        this.O00000oo = list;
        this.O0000O0o = bcp;
        this.O0000OOo = f;
        this.O00000o0 = str;
        this.O0000Oo0 = str2;
        this.O00000o = str3;
        this.O00000oO = str4;
    }

    public final int O000000o() {
        return this.f12869O000000o;
    }

    public final boolean O00000Oo() {
        return this.O00000Oo != -1;
    }

    public final int O00000o0() {
        return this.O00000Oo;
    }

    public final boolean O00000o() {
        return this.O00000oo != null;
    }

    public final List<String> O00000oO() {
        return this.O00000oo;
    }

    public final boolean O00000oo() {
        return this.O0000O0o != null;
    }

    public final bcp O0000O0o() {
        return this.O0000O0o;
    }

    public final boolean O0000OOo() {
        return !Float.isNaN(this.O0000OOo);
    }

    public final float O0000Oo0() {
        return this.O0000OOo;
    }

    public final boolean O0000Oo() {
        return this.O0000Oo0 != null;
    }

    public final String O0000OoO() {
        return this.O0000Oo0;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f12869O000000o), Integer.valueOf(this.O00000Oo), this.O00000oo, this.O0000O0o, Float.valueOf(this.O0000OOo), this.O00000o0, this.O0000Oo0, this.O00000o, this.O00000oO);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bcr)) {
            return false;
        }
        bcr bcr = (bcr) obj;
        if (this.f12869O000000o != bcr.f12869O000000o || this.O00000Oo != bcr.O00000Oo || !Objects.equals(this.O00000oo, bcr.O00000oo) || !Objects.equals(this.O0000O0o, bcr.O0000O0o) || !Objects.equals(Float.valueOf(this.O0000OOo), Float.valueOf(bcr.O0000OOo)) || !Objects.equals(this.O00000o0, bcr.O00000o0) || !Objects.equals(this.O0000Oo0, bcr.O0000Oo0) || !Objects.equals(this.O00000o, bcr.O00000o) || !Objects.equals(this.O00000oO, bcr.O00000oO)) {
            return false;
        }
        return true;
    }

    public static class O000000o implements bcs {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f12870O000000o = -1;
        public int O00000Oo = -1;
        public bcp O00000o;
        public List<String> O00000o0;
        public float O00000oO = Float.NaN;
        public String O00000oo;
        public String O0000O0o;
        public String O0000OOo;
        public String O0000Oo0;

        public final /* bridge */ /* synthetic */ bcs O000000o(String str) {
            this.O0000O0o = str;
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
            this.f12870O000000o = i;
            return this;
        }
    }
}
