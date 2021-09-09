package _m_j;

class jnr {
    O000000o O00000o;
    O000000o O00000oO;
    int O00000oo = 0;

    jnr() {
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000o0(jnp jnp) {
        O000000o o000000o = new O000000o(jnp);
        int i = this.O00000oo;
        if (i == 0) {
            this.O00000o = o000000o;
            this.O00000oO = o000000o;
            this.O00000oo = i + 1;
            return true;
        } else if (this.O00000oO.compareTo(o000000o) == 0) {
            return false;
        } else {
            if (this.O00000oO.compareTo(o000000o) < 0) {
                O000000o o000000o2 = this.O00000oO;
                o000000o2.O00000Oo = o000000o;
                o000000o.f1978O000000o = o000000o2;
                this.O00000oO = o000000o;
                this.O00000oo++;
                return true;
            } else if (this.O00000o.compareTo(o000000o) > 0) {
                O000000o o000000o3 = this.O00000o;
                o000000o3.f1978O000000o = o000000o;
                o000000o.O00000Oo = o000000o3;
                this.O00000o = o000000o;
                this.O00000oo++;
                return true;
            } else {
                O000000o o000000o4 = this.O00000oO;
                while (o000000o4 != null && o000000o4.compareTo(o000000o) > 0) {
                    o000000o4 = o000000o4.f1978O000000o;
                }
                if (o000000o4.compareTo(o000000o) == 0 || o000000o4.compareTo(o000000o) >= 0) {
                    return false;
                }
                o000000o.f1978O000000o = o000000o4;
                o000000o.O00000Oo = o000000o4.O00000Oo;
                o000000o4.O00000Oo.f1978O000000o = o000000o;
                o000000o4.O00000Oo = o000000o;
                this.O00000oo++;
                return true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final jnp O00000Oo() {
        int i = this.O00000oo;
        if (i == 1) {
            jnp jnp = this.O00000o.O00000o0;
            this.O00000o = null;
            this.O00000oO = null;
            this.O00000oo--;
            return jnp;
        } else if (i <= 1) {
            return null;
        } else {
            jnp jnp2 = this.O00000o.O00000o0;
            this.O00000o = this.O00000o.O00000Oo;
            this.O00000oo--;
            return jnp2;
        }
    }

    /* access modifiers changed from: package-private */
    public final jnp O00000o0() {
        O000000o o000000o = this.O00000oO;
        if (o000000o != null) {
            return o000000o.O00000o0;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000o() {
        return this.O00000oo == 0;
    }

    class O000000o implements Comparable<O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public O000000o f1978O000000o;
        public O000000o O00000Oo;
        public jnp O00000o0;

        O000000o(jnp jnp) {
            if (jnp != null) {
                this.O00000o0 = jnp;
                return;
            }
            throw new IllegalArgumentException("lexeme must not be null");
        }

        /* renamed from: O000000o */
        public final int compareTo(O000000o o000000o) {
            return this.O00000o0.compareTo(o000000o.O00000o0);
        }
    }
}
