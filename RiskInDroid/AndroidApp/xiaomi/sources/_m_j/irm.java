package _m_j;

import _m_j.irr;
import _m_j.ise;
import _m_j.isf;
import io.realm.internal.OsObject;
import io.realm.internal.UncheckedRow;
import java.util.List;

public final class irm<E extends irr> implements isf.O000000o {
    private static O000000o O0000OOo = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f1590O000000o = true;
    isi O00000Oo;
    List<String> O00000o;
    irf O00000o0;
    private E O00000oO;
    private OsObject O00000oo;
    private ise<OsObject.O00000Oo> O0000O0o = new ise<>();

    static class O000000o implements ise.O000000o<OsObject.O00000Oo> {
        public final /* bridge */ /* synthetic */ void O000000o(ise.O00000Oo o00000Oo, Object obj) {
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    public irm() {
    }

    public irm(E e) {
        this.O00000oO = e;
    }

    public final void O000000o(isi isi) {
        this.O00000Oo = isi;
        this.O0000O0o.O000000o((ise.O000000o<OsObject.O00000Oo>) O0000OOo);
        if (isi.isAttached() && this.O00000o0.O00000oO != null && !this.O00000o0.O00000oO.isClosed() && this.O00000Oo.isAttached() && this.O00000oo == null) {
            this.O00000oo = new OsObject(this.O00000o0.O00000oO, (UncheckedRow) this.O00000Oo);
            this.O00000oo.setObserverPairs(this.O0000O0o);
            this.O0000O0o = null;
        }
    }
}
