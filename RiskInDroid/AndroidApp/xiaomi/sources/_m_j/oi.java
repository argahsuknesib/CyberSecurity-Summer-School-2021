package _m_j;

import _m_j.qk;
import android.content.Context;

public final class oi {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f2346O000000o;
    private oh O00000Oo;
    private oj O00000o;
    private ox O00000o0;
    private qk O00000oO;
    private boolean O00000oo;

    public static String O00000o0() {
        return "v74";
    }

    public final synchronized void O00000Oo() {
        if (this.O00000oo) {
            this.O00000o.O00000Oo();
            this.O00000o = new oj(this.f2346O000000o, this.O00000Oo, this.O00000o0);
            this.O00000o.O000000o();
        }
    }

    public final synchronized void O000000o(Context context, oh ohVar, ox oxVar) {
        if (!this.O00000oo) {
            this.O00000oo = true;
            this.f2346O000000o = context.getApplicationContext();
            this.O00000Oo = ohVar;
            this.O00000o0 = oxVar;
            this.O00000oO = new qk(this.f2346O000000o, this.O00000Oo, this.O00000o0, new qk.O000000o() {
                /* class _m_j.oi.AnonymousClass1 */

                public final void O000000o() {
                    oi.this.O00000Oo();
                }
            });
            qk qkVar = this.O00000oO;
            qkVar.O00000o0 = qm.O000000o();
            qkVar.O00000o0.O000000o(qkVar.O00000oO);
            if (oh.O000000o() == 4) {
                sm smVar = new sm();
                smVar.O00000Oo = oh.O000000o();
                smVar.O00000o0 = oh.O00000o0();
                smVar.O00000oO = oh.O00000o();
                smVar.O00000o = oh.O00000oO();
                smVar.O000000o(qkVar.O00000Oo.O00000oo());
                smVar.O00000Oo(ol.O000000o());
                smVar.O0000O0o = qkVar.O00000o;
                qkVar.O00000o0.O000000o(qkVar.f2398O000000o, smVar);
            }
            this.O00000o = new oj(this.f2346O000000o, this.O00000Oo, oxVar);
            this.O00000o.O000000o();
        }
    }

    public final synchronized void O000000o() {
        if (this.O00000oo) {
            qk qkVar = this.O00000oO;
            qkVar.O00000o0.O00000Oo(qkVar.O00000oO);
            if (oh.O000000o() == 4) {
                qkVar.O00000o0.O00000Oo();
            }
            this.O00000o.O00000Oo();
            this.O00000oo = false;
        }
    }
}
