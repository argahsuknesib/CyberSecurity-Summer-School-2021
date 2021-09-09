package _m_j;

import _m_j.eov;
import _m_j.eqb;
import com.xiaomi.push.service.az;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public final class epz implements eqm {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f15716O000000o = false;
    /* access modifiers changed from: private */
    public SimpleDateFormat O00000Oo = new SimpleDateFormat("hh:mm:ss aaa");
    /* access modifiers changed from: private */
    public O000000o O00000o = null;
    /* access modifiers changed from: private */
    public eqb O00000o0 = null;
    private O000000o O00000oO = null;
    private eqe O00000oo = null;
    private final String O0000O0o = "[Slim] ";

    class O000000o implements eqg, eqn {

        /* renamed from: O000000o  reason: collision with root package name */
        String f15717O000000o;
        private boolean O00000o0 = true;

        O000000o(boolean z) {
            this.O00000o0 = z;
            this.f15717O000000o = z ? " RCV " : " Sent ";
        }

        /* renamed from: a  reason: collision with other method in class */
        public final boolean m603a(eqr eqr) {
            return true;
        }

        public final void a(eqr eqr) {
            if (epz.f15716O000000o) {
                duv.O00000o0("[Slim] " + epz.this.O00000Oo.format(new Date()) + this.f15717O000000o + " PKT " + eqr.O00000Oo());
                return;
            }
            duv.O00000o0("[Slim] " + epz.this.O00000Oo.format(new Date()) + this.f15717O000000o + " PKT [" + eqr.O0000oOO + "," + eqr.O00000o() + "]");
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b
         arg types: [java.lang.String, java.lang.String]
         candidates:
          com.xiaomi.push.service.az.a(android.content.Context, int):void
          com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):void
          com.xiaomi.push.service.az.a(java.lang.String, java.lang.String):com.xiaomi.push.service.az$b */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0125  */
        /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        public final void a(epq epq) {
            epq epq2;
            if (epz.f15716O000000o) {
                duv.O00000o0("[Slim] " + epz.this.O00000Oo.format(new Date()) + this.f15717O000000o + epq.toString());
            } else {
                duv.O00000o0("[Slim] " + epz.this.O00000Oo.format(new Date()) + this.f15717O000000o + " Blob [" + epq.f15708O000000o.O00000oo + "," + epq.f15708O000000o.f15684O000000o + "," + epq.O000000o() + "]");
            }
            if (epq != null && epq.f15708O000000o.f15684O000000o == 99999) {
                String str = epq.f15708O000000o.O00000oo;
                if (!this.O00000o0) {
                    if ("BIND".equals(str)) {
                        duv.O000000o("build binded result for loopback.");
                        eov.O00000o o00000o = new eov.O00000o();
                        o00000o.O000000o(true);
                        o00000o.O00000o0("login success.");
                        o00000o.O00000Oo("success");
                        o00000o.O000000o("success");
                        epq epq3 = new epq();
                        epq3.O000000o(o00000o.O00000o0(), (String) null);
                        epq3.O00000Oo = 2;
                        epq3.O000000o(99999);
                        epq3.O000000o("BIND", (String) null);
                        epq3.O000000o(epq.O000000o());
                        epq3.O00000o0 = null;
                        epq3.O00000Oo(epq.O00000Oo());
                        epq2 = epq3;
                    } else if (!"UBND".equals(str) && "SECMSG".equals(str)) {
                        epq2 = new epq();
                        epq2.O000000o(99999);
                        epq2.O000000o("SECMSG", (String) null);
                        epq2.O00000Oo(epq.O00000Oo());
                        epq2.O000000o(epq.O000000o());
                        epq2.O00000Oo = epq.O00000Oo;
                        epq2.O00000o0 = epq.O00000o0;
                        epq2.O000000o(epq.O00000o0(az.a().a("99999", epq.O00000Oo()).h), (String) null);
                    }
                    if (epq2 == null) {
                        for (Map.Entry next : epz.this.O00000o0.O0000OOo().entrySet()) {
                            if (epz.this.O00000o != next.getKey()) {
                                ((eqb.O000000o) next.getValue()).O000000o(epq2);
                            }
                        }
                        return;
                    }
                    return;
                }
                epq2 = null;
                if (epq2 == null) {
                }
            }
        }
    }

    public epz(eqb eqb) {
        this.O00000o0 = eqb;
        this.O00000o = new O000000o(true);
        this.O00000oO = new O000000o(false);
        eqb eqb2 = this.O00000o0;
        O000000o o000000o = this.O00000o;
        eqb2.O000000o(o000000o, o000000o);
        eqb eqb3 = this.O00000o0;
        O000000o o000000o2 = this.O00000oO;
        eqb3.O00000Oo(o000000o2, o000000o2);
        this.O00000oo = new eqa(this);
    }
}
