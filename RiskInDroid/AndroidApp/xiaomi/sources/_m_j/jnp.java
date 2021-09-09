package _m_j;

public final class jnp implements Comparable<jnp> {

    /* renamed from: O000000o  reason: collision with root package name */
    int f1976O000000o;
    int O00000Oo;
    int O00000o;
    public String O00000o0;
    private int O00000oO;

    public jnp(int i, int i2, int i3, int i4) {
        this.O00000oO = i;
        this.f1976O000000o = i2;
        if (i3 >= 0) {
            this.O00000Oo = i3;
            this.O00000o = i4;
            return;
        }
        throw new IllegalArgumentException("length < 0");
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof jnp) {
            jnp jnp = (jnp) obj;
            return this.O00000oO == jnp.O00000oO && this.f1976O000000o == jnp.f1976O000000o && this.O00000Oo == jnp.O00000Oo;
        }
    }

    public final int hashCode() {
        int O000000o2 = O000000o();
        int O00000Oo2 = O00000Oo();
        return (O000000o2 * 37) + (O00000Oo2 * 31) + (((O000000o2 * O00000Oo2) % this.O00000Oo) * 11);
    }

    /* renamed from: O000000o */
    public final int compareTo(jnp jnp) {
        int i = this.f1976O000000o;
        int i2 = jnp.f1976O000000o;
        if (i < i2) {
            return -1;
        }
        if (i == i2) {
            int i3 = this.O00000Oo;
            int i4 = jnp.O00000Oo;
            if (i3 > i4) {
                return -1;
            }
            if (i3 == i4) {
                return 0;
            }
        }
        return 1;
    }

    private int O000000o() {
        return this.O00000oO + this.f1976O000000o;
    }

    private int O00000Oo() {
        return this.O00000oO + this.f1976O000000o + this.O00000Oo;
    }

    public final boolean O000000o(jnp jnp, int i) {
        if (jnp == null || O00000Oo() != jnp.O000000o()) {
            return false;
        }
        this.O00000Oo += jnp.O00000Oo;
        this.O00000o = i;
        return true;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(O000000o());
        stringBuffer.append("-");
        stringBuffer.append(O00000Oo());
        stringBuffer.append(" : ");
        stringBuffer.append(this.O00000o0);
        stringBuffer.append(" : \t");
        int i = this.O00000o;
        if (i == 0) {
            stringBuffer.append("UNKONW");
        } else if (i == 1) {
            stringBuffer.append("ENGLISH");
        } else if (i == 2) {
            stringBuffer.append("ARABIC");
        } else if (i == 3) {
            stringBuffer.append("LETTER");
        } else if (i == 4) {
            stringBuffer.append("CN_WORD");
        } else if (i == 8) {
            stringBuffer.append("OTHER_CJK");
        } else if (i == 16) {
            stringBuffer.append("CN_NUM");
        } else if (i == 32) {
            stringBuffer.append("COUNT");
        } else if (i == 48) {
            stringBuffer.append("CN_QUAN");
        } else if (i == 64) {
            stringBuffer.append("CN_CHAR");
        }
        return stringBuffer.toString();
    }
}
