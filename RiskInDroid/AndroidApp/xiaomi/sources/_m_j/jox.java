package _m_j;

import java.util.concurrent.TimeUnit;

public final class jox {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final jox f2005O000000o;
    public static final jox O00000Oo;
    public final boolean O00000o;
    public final boolean O00000o0;
    public final int O00000oO;
    public final boolean O00000oo;
    public final boolean O0000O0o;
    public final boolean O0000OOo;
    public final int O0000Oo;
    public final int O0000Oo0;
    public final boolean O0000OoO;
    String O0000Ooo;
    private final boolean O0000o0;
    private final int O0000o00;

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f2006O000000o;
        boolean O00000Oo;
        int O00000o = -1;
        int O00000o0 = -1;
        int O00000oO = -1;
        boolean O00000oo;
        boolean O0000O0o;

        public final jox O000000o() {
            return new jox(this, (byte) 0);
        }
    }

    private jox(O000000o o000000o) {
        this.O00000o0 = o000000o.f2006O000000o;
        this.O00000o = o000000o.O00000Oo;
        this.O00000oO = o000000o.O00000o0;
        this.O0000o00 = -1;
        this.O00000oo = false;
        this.O0000O0o = false;
        this.O0000OOo = false;
        this.O0000Oo0 = o000000o.O00000o;
        this.O0000Oo = o000000o.O00000oO;
        this.O0000OoO = o000000o.O00000oo;
        this.O0000o0 = o000000o.O0000O0o;
    }

    /* synthetic */ jox(O000000o o000000o, byte b) {
        this(o000000o);
    }

    private jox(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, String str) {
        this.O00000o0 = z;
        this.O00000o = z2;
        this.O00000oO = i;
        this.O0000o00 = i2;
        this.O00000oo = z3;
        this.O0000O0o = z4;
        this.O0000OOo = z5;
        this.O0000Oo0 = i3;
        this.O0000Oo = i4;
        this.O0000OoO = z6;
        this.O0000o0 = z7;
        this.O0000Ooo = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
    public static jox O000000o(jpi jpi) {
        int i;
        String str;
        int i2;
        char charAt;
        jpi jpi2 = jpi;
        int length = jpi2.f2020O000000o.length / 2;
        int i3 = 0;
        boolean z = true;
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i4 = -1;
        int i5 = -1;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i6 = -1;
        int i7 = -1;
        boolean z7 = false;
        boolean z8 = false;
        while (i3 < length) {
            String O000000o2 = jpi2.O000000o(i3);
            String O00000Oo2 = jpi2.O00000Oo(i3);
            if (O000000o2.equalsIgnoreCase("Cache-Control")) {
                if (str2 == null) {
                    str2 = O00000Oo2;
                    for (i = 0; i < O00000Oo2.length(); i = i2) {
                        int O000000o3 = jpu.O000000o(O00000Oo2, i, "=,;");
                        String trim = O00000Oo2.substring(i, O000000o3).trim();
                        if (O000000o3 == O00000Oo2.length() || O00000Oo2.charAt(O000000o3) == ',' || O00000Oo2.charAt(O000000o3) == ';') {
                            i2 = O000000o3 + 1;
                            str = null;
                        } else {
                            while (true) {
                                O000000o3++;
                                if (O000000o3 >= O00000Oo2.length() || !((charAt = O00000Oo2.charAt(O000000o3)) == ' ' || charAt == 9)) {
                                }
                            }
                            if (O000000o3 >= O00000Oo2.length() || O00000Oo2.charAt(O000000o3) != '\"') {
                                i2 = jpu.O000000o(O00000Oo2, O000000o3, ",;");
                                str = O00000Oo2.substring(O000000o3, i2).trim();
                            } else {
                                int i8 = O000000o3 + 1;
                                int O000000o4 = jpu.O000000o(O00000Oo2, i8, jdn.f1779O000000o);
                                str = O00000Oo2.substring(i8, O000000o4);
                                i2 = O000000o4 + 1;
                            }
                        }
                        if ("no-cache".equalsIgnoreCase(trim)) {
                            z2 = true;
                        } else if ("no-store".equalsIgnoreCase(trim)) {
                            z3 = true;
                        } else if ("max-age".equalsIgnoreCase(trim)) {
                            i4 = jpu.O000000o(str, -1);
                        } else if ("s-maxage".equalsIgnoreCase(trim)) {
                            i5 = jpu.O000000o(str, -1);
                        } else if ("private".equalsIgnoreCase(trim)) {
                            z4 = true;
                        } else if ("public".equalsIgnoreCase(trim)) {
                            z5 = true;
                        } else if ("must-revalidate".equalsIgnoreCase(trim)) {
                            z6 = true;
                        } else if ("max-stale".equalsIgnoreCase(trim)) {
                            i6 = jpu.O000000o(str, Integer.MAX_VALUE);
                        } else if ("min-fresh".equalsIgnoreCase(trim)) {
                            i7 = jpu.O000000o(str, -1);
                        } else if ("only-if-cached".equalsIgnoreCase(trim)) {
                            z7 = true;
                        } else if ("no-transform".equalsIgnoreCase(trim)) {
                            z8 = true;
                        }
                    }
                    i3++;
                    jpi2 = jpi;
                }
            } else if (!O000000o2.equalsIgnoreCase("Pragma")) {
                i3++;
                jpi2 = jpi;
            }
            z = false;
            while (i < O00000Oo2.length()) {
            }
            i3++;
            jpi2 = jpi;
        }
        return new jox(z2, z3, i4, i5, z4, z5, z6, i6, i7, z7, z8, !z ? null : str2);
    }

    public final String toString() {
        String str;
        String str2 = this.O0000Ooo;
        if (str2 != null) {
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        if (this.O00000o0) {
            sb.append("no-cache, ");
        }
        if (this.O00000o) {
            sb.append("no-store, ");
        }
        if (this.O00000oO != -1) {
            sb.append("max-age=");
            sb.append(this.O00000oO);
            sb.append(", ");
        }
        if (this.O0000o00 != -1) {
            sb.append("s-maxage=");
            sb.append(this.O0000o00);
            sb.append(", ");
        }
        if (this.O00000oo) {
            sb.append("private, ");
        }
        if (this.O0000O0o) {
            sb.append("public, ");
        }
        if (this.O0000OOo) {
            sb.append("must-revalidate, ");
        }
        if (this.O0000Oo0 != -1) {
            sb.append("max-stale=");
            sb.append(this.O0000Oo0);
            sb.append(", ");
        }
        if (this.O0000Oo != -1) {
            sb.append("min-fresh=");
            sb.append(this.O0000Oo);
            sb.append(", ");
        }
        if (this.O0000OoO) {
            sb.append("only-if-cached, ");
        }
        if (this.O0000o0) {
            sb.append("no-transform, ");
        }
        if (sb.length() == 0) {
            str = "";
        } else {
            sb.delete(sb.length() - 2, sb.length());
            str = sb.toString();
        }
        this.O0000Ooo = str;
        return str;
    }

    static {
        O000000o o000000o = new O000000o();
        o000000o.f2006O000000o = true;
        f2005O000000o = o000000o.O000000o();
        O000000o o000000o2 = new O000000o();
        o000000o2.O00000oo = true;
        long seconds = TimeUnit.SECONDS.toSeconds(2147483647L);
        o000000o2.O00000o = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
        O00000Oo = o000000o2.O000000o();
    }
}
