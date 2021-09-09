package _m_j;

import java.io.IOException;

public final class acg {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.xr.O000000o(int, int):void
     arg types: [int, short]
     candidates:
      _m_j.xr.O000000o(int, double):void
      _m_j.xr.O000000o(int, float):void
      _m_j.xr.O000000o(int, long):void
      _m_j.xr.O000000o(int, _m_j.xv):void
      _m_j.xr.O000000o(int, java.lang.Object):void
      _m_j.xr.O000000o(int, java.lang.String):void
      _m_j.xr.O000000o(int, boolean):void
      _m_j.xr.O000000o(int, byte[]):void
      _m_j.xr.O000000o(int, int):void */
    public static void O000000o(xm xmVar, xu xuVar) {
        xmVar.f2595O000000o = false;
        try {
            if (xmVar.O00000oO() != 0) {
                acf acf = new acf();
                acf.O000000o("Invalid header bytes");
                xuVar.O000000o(acf);
                return;
            }
            int O00000oO = xmVar.O00000oO();
            if (O00000oO == 1 || O00000oO == 2) {
                int O00000oO2 = xmVar.O00000oO();
                if (O00000oO2 == 0) {
                    acf acf2 = new acf();
                    acf2.O000000o("Image count cannot be zero");
                    xuVar.O000000o(acf2);
                    return;
                }
                for (int i = 0; i < O00000oO2; i++) {
                    acf acf3 = new acf();
                    try {
                        acf3.O000000o(1, O00000oO);
                        acf3.O000000o(2, (int) xmVar.O00000o());
                        acf3.O000000o(3, (int) xmVar.O00000o());
                        acf3.O000000o(4, (int) xmVar.O00000o());
                        xmVar.O00000o();
                        if (O00000oO == 1) {
                            acf3.O000000o(5, xmVar.O00000oO());
                            acf3.O000000o(7, xmVar.O00000oO());
                        } else {
                            acf3.O000000o(6, xmVar.O00000oO());
                            acf3.O000000o(8, xmVar.O00000oO());
                        }
                        acf3.O000000o(9, xmVar.O0000O0o());
                        acf3.O000000o(10, xmVar.O0000O0o());
                    } catch (IOException e) {
                        acf3.O000000o("Exception reading ICO file metadata: " + e.getMessage());
                    }
                    xuVar.O000000o(acf3);
                }
                return;
            }
            acf acf4 = new acf();
            acf4.O000000o("Invalid type " + O00000oO + " -- expecting 1 or 2");
            xuVar.O000000o(acf4);
        } catch (IOException e2) {
            acf acf5 = new acf();
            acf5.O000000o("Exception reading ICO file metadata: " + e2.getMessage());
            xuVar.O000000o(acf5);
        }
    }
}
