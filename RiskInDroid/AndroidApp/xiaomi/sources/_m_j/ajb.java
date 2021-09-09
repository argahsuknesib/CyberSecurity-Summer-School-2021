package _m_j;

import com.fasterxml.jackson.core.JsonLocation;

public final class ajb extends aik {
    protected int O00000o;
    protected final ajb O00000o0;
    protected int O00000oO;
    protected String O00000oo;
    protected ajb O0000O0o = null;

    public ajb(ajb ajb, int i, int i2, int i3) {
        this.f12390O000000o = i;
        this.O00000o0 = ajb;
        this.O00000o = i2;
        this.O00000oO = i3;
        this.O00000Oo = -1;
    }

    private void O000000o(int i, int i2, int i3) {
        this.f12390O000000o = i;
        this.O00000Oo = -1;
        this.O00000o = i2;
        this.O00000oO = i3;
        this.O00000oo = null;
    }

    public static ajb O0000O0o() {
        return new ajb(null, 0, -1, -1);
    }

    public final ajb O000000o(int i, int i2) {
        ajb ajb = this.O0000O0o;
        if (ajb == null) {
            ajb ajb2 = new ajb(this, 1, i, i2);
            this.O0000O0o = ajb2;
            return ajb2;
        }
        ajb.O000000o(1, i, i2);
        return ajb;
    }

    public final ajb O00000Oo(int i, int i2) {
        ajb ajb = this.O0000O0o;
        if (ajb == null) {
            ajb ajb2 = new ajb(this, 2, i, i2);
            this.O0000O0o = ajb2;
            return ajb2;
        }
        ajb.O000000o(2, i, i2);
        return ajb;
    }

    public final String O0000OOo() {
        return this.O00000oo;
    }

    public final ajb O0000Oo0() {
        return this.O00000o0;
    }

    public final JsonLocation O000000o(Object obj) {
        return new JsonLocation(obj, -1, this.O00000o, this.O00000oO);
    }

    public final boolean O0000Oo() {
        int i = this.O00000Oo + 1;
        this.O00000Oo = i;
        if (this.f12390O000000o == 0 || i <= 0) {
            return false;
        }
        return true;
    }

    public final void O000000o(String str) {
        this.O00000oo = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(64);
        int i = this.f12390O000000o;
        if (i == 0) {
            sb.append("/");
        } else if (i == 1) {
            sb.append('[');
            sb.append(O00000oo());
            sb.append(']');
        } else if (i == 2) {
            sb.append('{');
            if (this.O00000oo != null) {
                sb.append('\"');
                air.O000000o(sb, this.O00000oo);
                sb.append('\"');
            } else {
                sb.append('?');
            }
            sb.append('}');
        }
        return sb.toString();
    }
}
