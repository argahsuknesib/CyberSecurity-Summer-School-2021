package _m_j;

import java.io.IOException;

public final class wo {
    public static void O000000o(xn xnVar, long j, wn wnVar) {
        while (true) {
            if (j != -1) {
                try {
                    if (xnVar.O00000Oo >= j) {
                        return;
                    }
                } catch (IOException e) {
                    wnVar.O000000o(e.getMessage());
                    return;
                }
            }
            afd afd = new afd(xnVar);
            if (wnVar.O00000Oo(afd)) {
                O000000o(xnVar, (afd.O00000o + xnVar.O00000Oo) - 8, wnVar.O00000o0(afd));
            } else if (wnVar.O000000o(afd)) {
                wnVar = wnVar.O000000o(afd, xnVar.O000000o(((int) afd.O00000o) - 8));
            } else if (afd.O00000oo != null) {
                xnVar.O000000o(afd.O00000o - 24);
            } else if (afd.O00000o > 1) {
                xnVar.O000000o(afd.O00000o - 8);
            } else if (afd.O00000o == -1) {
                return;
            }
        }
    }
}
