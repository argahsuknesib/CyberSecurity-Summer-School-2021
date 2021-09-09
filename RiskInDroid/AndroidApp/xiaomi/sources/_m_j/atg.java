package _m_j;

public final class atg extends anu {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final anm f12588O000000o;
    protected final String O00000Oo;

    public final boolean O00000Oo() {
        return false;
    }

    public atg(anm anm) {
        this(anm, anm.O00000Oo());
    }

    public atg(anm anm, String str) {
        this.f12588O000000o = anm;
        this.O00000Oo = str;
    }

    public final String O000000o() {
        return this.O00000Oo;
    }

    public final boolean O00000o() {
        return O0000OOo() != null;
    }

    public final boolean O00000oO() {
        return O0000Oo0() != null;
    }

    public final boolean O00000oo() {
        return this.f12588O000000o instanceof anl;
    }

    public final boolean O0000O0o() {
        return this.f12588O000000o instanceof anp;
    }

    public final ann O0000OOo() {
        anm anm = this.f12588O000000o;
        if (!(anm instanceof ann) || ((ann) anm).O0000OOo() != 0) {
            return null;
        }
        return (ann) this.f12588O000000o;
    }

    public final ann O0000Oo0() {
        anm anm = this.f12588O000000o;
        if (!(anm instanceof ann) || ((ann) anm).O0000OOo() != 1) {
            return null;
        }
        return (ann) this.f12588O000000o;
    }

    public final anl O0000Oo() {
        anm anm = this.f12588O000000o;
        if (anm instanceof anl) {
            return (anl) anm;
        }
        return null;
    }

    public final anm O0000OoO() {
        ann O0000OOo = O0000OOo();
        return O0000OOo == null ? O0000Oo() : O0000OOo;
    }

    public final anm O0000Ooo() {
        anm anm = this.f12588O000000o;
        anp anp = anm instanceof anp ? (anp) anm : null;
        if (anp != null) {
            return anp;
        }
        ann O0000Oo0 = O0000Oo0();
        return O0000Oo0 == null ? O0000Oo() : O0000Oo0;
    }
}
