package _m_j;

import java.util.List;

public final class apv {
    private static final apt[] O0000OOo = new apt[0];

    /* renamed from: O000000o  reason: collision with root package name */
    protected final ajq f12517O000000o;
    protected List<apt> O00000Oo;
    protected apq O00000o;
    protected apt[] O00000o0;
    protected Object O00000oO;
    protected anm O00000oo;
    protected aqn O0000O0o;

    public apv(ajq ajq) {
        this.f12517O000000o = ajq;
    }

    public final void O000000o(List<apt> list) {
        this.O00000Oo = list;
    }

    public final void O000000o(apt[] aptArr) {
        this.O00000o0 = aptArr;
    }

    public final void O000000o(apq apq) {
        this.O00000o = apq;
    }

    public final void O000000o(Object obj) {
        this.O00000oO = obj;
    }

    public final void O000000o(anm anm) {
        if (this.O00000oo == null) {
            this.O00000oo = anm;
            return;
        }
        throw new IllegalArgumentException("Multiple type ids specified with " + this.O00000oo + " and " + anm);
    }

    public final void O000000o(aqn aqn) {
        this.O0000O0o = aqn;
    }

    public final List<apt> O000000o() {
        return this.O00000Oo;
    }

    public final apq O00000Oo() {
        return this.O00000o;
    }

    public final Object O00000o0() {
        return this.O00000oO;
    }

    public final anm O00000o() {
        return this.O00000oo;
    }

    public final aqn O00000oO() {
        return this.O0000O0o;
    }

    public final ajz<?> O00000oo() {
        apt[] aptArr;
        List<apt> list = this.O00000Oo;
        if (list != null && !list.isEmpty()) {
            List<apt> list2 = this.O00000Oo;
            aptArr = (apt[]) list2.toArray(new apt[list2.size()]);
        } else if (this.O00000o == null) {
            return null;
        } else {
            aptArr = O0000OOo;
        }
        return new apu(this.f12517O000000o.O000000o(), this, aptArr, this.O00000o0);
    }

    public final apu O0000O0o() {
        return apu.O000000o(this.f12517O000000o.O000000o());
    }
}
