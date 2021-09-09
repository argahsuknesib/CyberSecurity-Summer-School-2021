package _m_j;

import java.util.HashMap;

public final class cpk implements Comparable<cpk> {

    /* renamed from: O000000o  reason: collision with root package name */
    static final HashMap<String, cpk> f14184O000000o = new HashMap<>(16);
    final int O00000Oo;
    final int O00000o0;

    public final /* synthetic */ int compareTo(Object obj) {
        cpk cpk = (cpk) obj;
        if (equals(cpk)) {
            return 0;
        }
        return O000000o() - cpk.O000000o() > 0.0f ? 1 : -1;
    }

    public static cpk O000000o(String str) {
        String[] split = str.split(":");
        if (split.length == 2) {
            return O000000o(Integer.valueOf(split[0]).intValue(), Integer.valueOf(split[1]).intValue());
        }
        throw new NumberFormatException("Illegal AspectRatio string. Must be x:y");
    }

    private cpk(int i, int i2) {
        this.O00000Oo = i;
        this.O00000o0 = i2;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof cpk) {
            cpk cpk = (cpk) obj;
            return this.O00000Oo == cpk.O00000Oo && this.O00000o0 == cpk.O00000o0;
        }
    }

    public final String toString() {
        return this.O00000Oo + ":" + this.O00000o0;
    }

    public final float O000000o() {
        return ((float) this.O00000Oo) / ((float) this.O00000o0);
    }

    public final int hashCode() {
        int i = this.O00000o0;
        int i2 = this.O00000Oo;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public static cpk O000000o(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        while (i4 != 0) {
            int i5 = i3 % i4;
            i3 = i4;
            i4 = i5;
        }
        int i6 = i / i3;
        int i7 = i2 / i3;
        String str = i6 + ":" + i7;
        cpk cpk = f14184O000000o.get(str);
        if (cpk != null) {
            return cpk;
        }
        cpk cpk2 = new cpk(i6, i7);
        f14184O000000o.put(str, cpk2);
        return cpk2;
    }
}
