package _m_j;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.i;

final class eqj extends XMPushService.j {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ long f15724O000000o;
    final /* synthetic */ long O00000Oo;
    final /* synthetic */ eqi O00000o0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    eqj(eqi eqi, long j, long j2) {
        super(13);
        this.O00000o0 = eqi;
        this.f15724O000000o = j;
        this.O00000Oo = j2;
    }

    public final String a() {
        return "check the ping-pong." + this.O00000Oo;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final void m607a() {
        Thread.yield();
        if (this.O00000o0.O0000Oo() && !this.O00000o0.O000000o(this.f15724O000000o)) {
            i.a(this.O00000o0.O0000oOo).m208b();
            this.O00000o0.O0000oOo.a(22, (Exception) null);
        }
    }
}
