package _m_j;

import com.mi.global.shop.widget.ptr.PtrFrameLayout;

public final class ccg implements ccf {

    /* renamed from: O000000o  reason: collision with root package name */
    private ccf f13619O000000o;
    private ccg O00000Oo;

    private boolean O000000o(ccf ccf) {
        ccf ccf2 = this.f13619O000000o;
        return ccf2 != null && ccf2 == ccf;
    }

    public final boolean O000000o() {
        return this.f13619O000000o != null;
    }

    public static void O000000o(ccg ccg, ccf ccf) {
        if (ccf != null && ccg != null) {
            if (ccg.f13619O000000o == null) {
                ccg.f13619O000000o = ccf;
                return;
            }
            while (!ccg.O000000o(ccf)) {
                ccg ccg2 = ccg.O00000Oo;
                if (ccg2 != null) {
                    ccg = ccg2;
                } else {
                    ccg ccg3 = new ccg();
                    ccg3.f13619O000000o = ccf;
                    ccg.O00000Oo = ccg3;
                    return;
                }
            }
        }
    }

    public final void O000000o(PtrFrameLayout ptrFrameLayout) {
        ccg ccg = this;
        do {
            ccf ccf = ccg.f13619O000000o;
            if (ccf != null) {
                ccf.O000000o(ptrFrameLayout);
            }
            ccg = ccg.O00000Oo;
        } while (ccg != null);
    }

    public final void O00000Oo(PtrFrameLayout ptrFrameLayout) {
        ccg ccg = this;
        do {
            ccf ccf = ccg.f13619O000000o;
            if (ccf != null) {
                ccf.O00000Oo(ptrFrameLayout);
            }
            ccg = ccg.O00000Oo;
        } while (ccg != null);
    }

    public final void O00000o0(PtrFrameLayout ptrFrameLayout) {
        ccg ccg = this;
        do {
            ccf ccf = ccg.f13619O000000o;
            if (ccf != null) {
                ccf.O00000o0(ptrFrameLayout);
            }
            ccg = ccg.O00000Oo;
        } while (ccg != null);
    }

    public final void O00000o(PtrFrameLayout ptrFrameLayout) {
        ccg ccg = this;
        do {
            ccf ccf = ccg.f13619O000000o;
            if (ccf != null) {
                ccf.O00000o(ptrFrameLayout);
            }
            ccg = ccg.O00000Oo;
        } while (ccg != null);
    }

    public final void O000000o(PtrFrameLayout ptrFrameLayout, boolean z, byte b, int i, int i2, float f, float f2) {
        ccg ccg = this;
        do {
            ccf ccf = ccg.f13619O000000o;
            if (ccf != null) {
                ccf.O000000o(ptrFrameLayout, z, b, i, i2, f, f2);
            }
            ccg = ccg.O00000Oo;
        } while (ccg != null);
    }
}
