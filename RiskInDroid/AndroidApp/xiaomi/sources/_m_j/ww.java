package _m_j;

import java.io.IOException;

public final class ww {
    public static void O000000o(xn xnVar, long j, wv wvVar) {
        while (true) {
            if (j != -1) {
                try {
                    if (xnVar.O00000Oo >= j) {
                        return;
                    }
                } catch (IOException e) {
                    wvVar.O000000o(e.getMessage());
                    return;
                }
            }
            adh adh = new adh(xnVar);
            if (wvVar.O00000Oo(adh)) {
                O000000o(xnVar, (adh.f12357O000000o + xnVar.O00000Oo) - 8, wvVar.O00000o0(adh));
            } else if (wvVar.O000000o(adh)) {
                wvVar = wvVar.O000000o(adh, xnVar.O000000o(((int) adh.f12357O000000o) - 8));
            } else if (adh.f12357O000000o > 1) {
                xnVar.O000000o(adh.f12357O000000o - 8);
            } else if (adh.f12357O000000o == -1) {
                return;
            }
        }
    }
}
