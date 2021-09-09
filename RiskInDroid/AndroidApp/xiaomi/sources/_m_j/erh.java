package _m_j;

import _m_j.erk;
import _m_j.erm;
import com.xiaomi.push.fg;
import com.xiaomi.push.fh;
import com.xiaomi.push.gg;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.az;

final class erh implements az.b.a {

    /* renamed from: O000000o  reason: collision with root package name */
    XMPushService f15743O000000o;
    az.b O00000Oo;
    private az.c O00000o;
    eqb O00000o0;
    private int O00000oO;
    private boolean O00000oo = false;

    erh(XMPushService xMPushService, az.b bVar) {
        this.f15743O000000o = xMPushService;
        this.O00000o = az.c.b;
        this.O00000Oo = bVar;
    }

    public final void a(az.c cVar, az.c cVar2, int i) {
        if (!this.O00000oo && cVar == az.c.b) {
            this.O00000o = cVar2;
            this.O00000oO = i;
            this.O00000oo = true;
        }
        this.f15743O000000o.a(new eri(this));
    }

    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    static /* synthetic */ void O000000o(erh erh) {
        fg fgVar;
        fg fgVar2;
        erh.O00000Oo.b(erh);
        if (erh.O00000oo && erh.O00000oO != 11) {
            fh O00000o02 = erm.O000000o.f15749O000000o.O00000o0();
            int i = erj.f15745O000000o[erh.O00000o.ordinal()];
            if (i != 1) {
                if (i != 2 && i == 3) {
                    fgVar2 = fg.H;
                }
                if (O00000o02 == null) {
                    O00000o02.f36b = erh.O00000o0.O00000oO();
                    O00000o02.f38d = erh.O00000Oo.f277b;
                    O00000o02.b = 1;
                    try {
                        O00000o02.O000000o((byte) Integer.parseInt(erh.O00000Oo.g));
                    } catch (NumberFormatException unused) {
                    }
                    erm.O000000o.f15749O000000o.O000000o(O00000o02);
                    return;
                }
                return;
            }
            int i2 = erh.O00000oO;
            if (i2 == 17) {
                fgVar2 = fg.L;
            } else if (i2 == 21) {
                fgVar2 = fg.S;
            } else {
                try {
                    Exception exc = erm.O000000o().O00000o0;
                    erk.O000000o(exc);
                    boolean z = exc instanceof gg;
                    Throwable th = exc;
                    if (z) {
                        Throwable a2 = ((gg) exc).a();
                        th = exc;
                        if (a2 != null) {
                            th = ((gg) exc).a();
                        }
                    }
                    erk.O000000o o000000o = new erk.O000000o();
                    String message = th.getMessage();
                    if (th.getCause() != null) {
                        message = th.getCause().getMessage();
                    }
                    int O000000o2 = eqd.O000000o(th);
                    String str = th.getClass().getSimpleName() + ":" + message;
                    if (O000000o2 == 105) {
                        fgVar = fg.L;
                    } else if (O000000o2 == 199) {
                        fgVar = fg.O;
                    } else if (O000000o2 != 499) {
                        fgVar = O000000o2 != 109 ? O000000o2 != 110 ? fg.P : fg.N : fg.M;
                    } else {
                        o000000o.f15746O000000o = fg.R;
                        if (message.startsWith("Terminal binding condition encountered: item-not-found")) {
                            fgVar = fg.Q;
                        }
                        if (o000000o.f15746O000000o == fg.O || o000000o.f15746O000000o == fg.P || o000000o.f15746O000000o == fg.R) {
                            o000000o.O00000Oo = str;
                        }
                        O00000o02.f33a = o000000o.f15746O000000o.a();
                        O00000o02.f37c = o000000o.O00000Oo;
                        if (O00000o02 == null) {
                        }
                    }
                    o000000o.f15746O000000o = fgVar;
                    o000000o.O00000Oo = str;
                    O00000o02.f33a = o000000o.f15746O000000o.a();
                    O00000o02.f37c = o000000o.O00000Oo;
                } catch (NullPointerException unused2) {
                    O00000o02 = null;
                }
                if (O00000o02 == null) {
                }
            }
            O00000o02.f33a = fgVar2.a();
            if (O00000o02 == null) {
            }
        }
    }
}
