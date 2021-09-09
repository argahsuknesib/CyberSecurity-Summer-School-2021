package _m_j;

import java.io.IOException;

public class agr {

    /* renamed from: O000000o  reason: collision with root package name */
    static final /* synthetic */ boolean f12381O000000o = (!agr.class.desiredAssertionStatus());

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    public static void O000000o(xm xmVar, xu xuVar) {
        agq agq = new agq();
        xuVar.O000000o(agq);
        try {
            if (xmVar.O0000OOo() != 943870035) {
                agq.O000000o("Invalid PSD file signature");
                return;
            }
            int O00000oO = xmVar.O00000oO();
            if (O00000oO == 1 || O00000oO == 2) {
                xmVar.O000000o(6L);
                agq.O000000o(1, xmVar.O00000oO());
                agq.O000000o(2, xmVar.O0000OOo());
                agq.O000000o(3, xmVar.O0000OOo());
                agq.O000000o(4, xmVar.O00000oO());
                agq.O000000o(5, xmVar.O00000oO());
                try {
                    xmVar.O000000o(xmVar.O0000O0o());
                    long O0000O0o = xmVar.O0000O0o();
                    if (!f12381O000000o) {
                        if (O0000O0o > 2147483647L) {
                            throw new AssertionError();
                        }
                    }
                    new agn();
                    agn.O000000o(xmVar, (int) O0000O0o, xuVar);
                } catch (IOException unused) {
                }
            } else {
                agq.O000000o("Invalid PSD file version (must be 1 or 2)");
            }
        } catch (IOException unused2) {
            agq.O000000o("Unable to read PSD header");
        }
    }
}
