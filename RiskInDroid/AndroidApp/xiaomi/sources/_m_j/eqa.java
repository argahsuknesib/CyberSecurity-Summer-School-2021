package _m_j;

import java.util.Date;

final class eqa implements eqe {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ epz f15719O000000o;

    eqa(epz epz) {
        this.f15719O000000o = epz;
    }

    public final void a(eqb eqb) {
        duv.O00000o0("[Slim] " + this.f15719O000000o.O00000Oo.format(new Date()) + " Connection started (" + this.f15719O000000o.O00000o0.hashCode() + ")");
    }

    public final void a(eqb eqb, int i, Exception exc) {
        duv.O00000o0("[Slim] " + this.f15719O000000o.O00000Oo.format(new Date()) + " Connection closed (" + this.f15719O000000o.O00000o0.hashCode() + ")");
    }

    public final void a(eqb eqb, Exception exc) {
        duv.O00000o0("[Slim] " + this.f15719O000000o.O00000Oo.format(new Date()) + " Reconnection failed due to an exception (" + this.f15719O000000o.O00000o0.hashCode() + ")");
        exc.printStackTrace();
    }

    public final void b(eqb eqb) {
        duv.O00000o0("[Slim] " + this.f15719O000000o.O00000Oo.format(new Date()) + " Connection reconnected (" + this.f15719O000000o.O00000o0.hashCode() + ")");
    }
}
