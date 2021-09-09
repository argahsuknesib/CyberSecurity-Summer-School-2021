package _m_j;

import com.xiaomi.push.service.XMPushService;

final class eqk extends XMPushService.j {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ int f15725O000000o;
    final /* synthetic */ Exception O00000Oo;
    final /* synthetic */ eqi O00000o0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    eqk(eqi eqi, int i, Exception exc) {
        super(2);
        this.O00000o0 = eqi;
        this.f15725O000000o = i;
        this.O00000Oo = exc;
    }

    public final String a() {
        return "shutdown the connection. " + this.f15725O000000o + ", " + this.O00000Oo;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final void m608a() {
        this.O00000o0.O0000oOo.a(this.f15725O000000o, this.O00000Oo);
    }
}
