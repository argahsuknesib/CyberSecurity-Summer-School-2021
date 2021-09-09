package _m_j;

import _m_j.jnr;

final class jnq extends jnr implements Comparable<jnq> {

    /* renamed from: O000000o  reason: collision with root package name */
    int f1977O000000o = -1;
    int O00000Oo = -1;
    int O00000o0 = 0;

    public final /* synthetic */ int compareTo(Object obj) {
        jnq jnq = (jnq) obj;
        int i = this.O00000o0;
        int i2 = jnq.O00000o0;
        if (i > i2) {
            return -1;
        }
        if (i < i2) {
            return 1;
        }
        if (this.O00000oo < jnq.O00000oo) {
            return -1;
        }
        if (this.O00000oo > jnq.O00000oo) {
            return 1;
        }
        if (O00000oO() > jnq.O00000oO()) {
            return -1;
        }
        if (O00000oO() < jnq.O00000oO()) {
            return 1;
        }
        int i3 = this.O00000Oo;
        int i4 = jnq.O00000Oo;
        if (i3 > i4) {
            return -1;
        }
        if (i3 < i4) {
            return 1;
        }
        if (O00000oo() > jnq.O00000oo()) {
            return -1;
        }
        if (O00000oo() < jnq.O00000oo()) {
            return 1;
        }
        if (O0000O0o() > jnq.O0000O0o()) {
            return -1;
        }
        if (O0000O0o() < jnq.O0000O0o()) {
            return 1;
        }
        return 0;
    }

    jnq() {
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(jnp jnp) {
        if (O00000o()) {
            O00000o0(jnp);
            this.f1977O000000o = jnp.f1976O000000o;
            this.O00000Oo = jnp.f1976O000000o + jnp.O00000Oo;
            this.O00000o0 += jnp.O00000Oo;
            return true;
        } else if (!O00000Oo(jnp)) {
            return false;
        } else {
            O00000o0(jnp);
            if (jnp.f1976O000000o + jnp.O00000Oo > this.O00000Oo) {
                this.O00000Oo = jnp.f1976O000000o + jnp.O00000Oo;
            }
            this.O00000o0 = this.O00000Oo - this.f1977O000000o;
            return true;
        }
    }

    private int O00000oO() {
        return this.O00000Oo - this.f1977O000000o;
    }

    /* access modifiers changed from: package-private */
    public final jnq O000000o() {
        jnq jnq = new jnq();
        jnq.f1977O000000o = this.f1977O000000o;
        jnq.O00000Oo = this.O00000Oo;
        jnq.O00000o0 = this.O00000o0;
        jnr.O000000o o000000o = this.O00000o;
        while (o000000o != null && o000000o.O00000o0 != null) {
            jnq.O00000o0(o000000o.O00000o0);
            o000000o = o000000o.O00000Oo;
        }
        return jnq;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("pathBegin  : ");
        stringBuffer.append(this.f1977O000000o);
        stringBuffer.append("\r\n");
        stringBuffer.append("pathEnd  : ");
        stringBuffer.append(this.O00000Oo);
        stringBuffer.append("\r\n");
        stringBuffer.append("payloadLength  : ");
        stringBuffer.append(this.O00000o0);
        stringBuffer.append("\r\n");
        for (jnr.O000000o o000000o = this.O00000o; o000000o != null; o000000o = o000000o.O00000Oo) {
            stringBuffer.append("lexeme : ");
            stringBuffer.append(o000000o.O00000o0);
            stringBuffer.append("\r\n");
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000Oo(jnp jnp) {
        if (jnp.f1976O000000o < this.f1977O000000o || jnp.f1976O000000o >= this.O00000Oo) {
            return this.f1977O000000o >= jnp.f1976O000000o && this.f1977O000000o < jnp.f1976O000000o + jnp.O00000Oo;
        }
        return true;
    }

    private int O00000oo() {
        jnr.O000000o o000000o = this.O00000o;
        int i = 1;
        while (o000000o != null && o000000o.O00000o0 != null) {
            i *= o000000o.O00000o0.O00000Oo;
            o000000o = o000000o.O00000Oo;
        }
        return i;
    }

    private int O0000O0o() {
        jnr.O000000o o000000o = this.O00000o;
        int i = 0;
        int i2 = 0;
        while (o000000o != null && o000000o.O00000o0 != null) {
            i++;
            i2 += o000000o.O00000o0.O00000Oo * i;
            o000000o = o000000o.O00000Oo;
        }
        return i2;
    }
}
