package _m_j;

import _m_j.adw;
import java.io.IOException;
import java.util.ArrayList;

public final class aeo extends adf<aen> {
    public final String O00000Oo() {
        return "tcmi";
    }

    public final void O00000o0(xm xmVar, adh adh) throws IOException {
    }

    public aeo(xu xuVar) {
        super(xuVar);
    }

    public final void O000000o(xm xmVar, adh adh) throws IOException {
        adw adw = new adw(xmVar, adh);
        aen aen = (aen) this.O00000Oo;
        ArrayList arrayList = adw.O00000oo;
        boolean z = false;
        adw.O000000o o000000o = (adw.O000000o) arrayList.get(0);
        aen.O000000o(1, (o000000o.f12363O000000o & 1) == 1);
        aen.O000000o(2, (o000000o.f12363O000000o & 2) == 2);
        aen.O000000o(3, (o000000o.f12363O000000o & 4) == 4);
        if ((o000000o.f12363O000000o & 8) == 8) {
            z = true;
        }
        aen.O000000o(4, z);
    }

    public final void O00000Oo(xm xmVar, adh adh) throws IOException {
        adv adv = new adv(xmVar, adh);
        aen aen = (aen) this.O00000Oo;
        aen.O000000o(5, adv.O00000oO);
        int i = adv.O00000oo;
        if (i == 1) {
            aen.O000000o(6, "Bold");
        } else if (i == 2) {
            aen.O000000o(6, "Italic");
        } else if (i == 4) {
            aen.O000000o(6, "Underline");
        } else if (i == 8) {
            aen.O000000o(6, "Outline");
        } else if (i == 16) {
            aen.O000000o(6, "Shadow");
        } else if (i == 32) {
            aen.O000000o(6, "Condense");
        } else if (i == 64) {
            aen.O000000o(6, "Extend");
        }
        aen.O000000o(7, adv.O0000O0o);
        aen.O00000Oo(8, adv.O0000OOo);
        aen.O00000Oo(9, adv.O0000Oo0);
        aen.O000000o(10, adv.O0000Oo);
    }

    public final /* synthetic */ add O000000o() {
        return new aen();
    }
}
