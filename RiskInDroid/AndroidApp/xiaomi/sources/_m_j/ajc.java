package _m_j;

public final class ajc extends aik {
    protected String O00000o;
    protected final ajc O00000o0;
    protected ajc O00000oO = null;

    private ajc(int i, ajc ajc) {
        this.f12390O000000o = i;
        this.O00000o0 = ajc;
        this.O00000Oo = -1;
    }

    public static ajc O0000O0o() {
        return new ajc(0, null);
    }

    private final ajc O000000o(int i) {
        this.f12390O000000o = i;
        this.O00000Oo = -1;
        this.O00000o = null;
        return this;
    }

    public final ajc O0000OOo() {
        ajc ajc = this.O00000oO;
        if (ajc != null) {
            return ajc.O000000o(1);
        }
        ajc ajc2 = new ajc(1, this);
        this.O00000oO = ajc2;
        return ajc2;
    }

    public final ajc O0000Oo0() {
        ajc ajc = this.O00000oO;
        if (ajc != null) {
            return ajc.O000000o(2);
        }
        ajc ajc2 = new ajc(2, this);
        this.O00000oO = ajc2;
        return ajc2;
    }

    public final ajc O0000Oo() {
        return this.O00000o0;
    }

    public final int O000000o(String str) {
        if (this.f12390O000000o != 2 || this.O00000o != null) {
            return 4;
        }
        this.O00000o = str;
        return this.O00000Oo < 0 ? 0 : 1;
    }

    public final int O0000OoO() {
        if (this.f12390O000000o == 2) {
            if (this.O00000o == null) {
                return 5;
            }
            this.O00000o = null;
            this.O00000Oo++;
            return 2;
        } else if (this.f12390O000000o == 1) {
            int i = this.O00000Oo;
            this.O00000Oo++;
            if (i < 0) {
                return 0;
            }
            return 1;
        } else {
            this.O00000Oo++;
            if (this.O00000Oo == 0) {
                return 0;
            }
            return 3;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        if (this.f12390O000000o == 2) {
            sb.append('{');
            if (this.O00000o != null) {
                sb.append('\"');
                sb.append(this.O00000o);
                sb.append('\"');
            } else {
                sb.append('?');
            }
            sb.append('}');
        } else if (this.f12390O000000o == 1) {
            sb.append('[');
            sb.append(O00000oo());
            sb.append(']');
        } else {
            sb.append("/");
        }
        return sb.toString();
    }
}
