package _m_j;

import com.drew.metadata.MetadataException;
import com.drew.metadata.bmp.BmpHeaderDirectory;
import java.io.IOException;

public final class yf {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.yf.O000000o(_m_j.xm, _m_j.xu, boolean):void
     arg types: [_m_j.xm, _m_j.xu, int]
     candidates:
      _m_j.yf.O000000o(_m_j.xm, com.drew.metadata.bmp.BmpHeaderDirectory, _m_j.xu):void
      _m_j.yf.O000000o(_m_j.xm, _m_j.xu, boolean):void */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0093  */
    public void O000000o(xm xmVar, xu xuVar, boolean z) {
        BmpHeaderDirectory bmpHeaderDirectory;
        try {
            int O00000oO = xmVar.O00000oO();
            if (O00000oO != 16706) {
                if (O00000oO == 17225 || O00000oO == 18755 || O00000oO == 19778 || O00000oO == 20547 || O00000oO == 21584) {
                    bmpHeaderDirectory = new BmpHeaderDirectory();
                    try {
                        xuVar.O000000o(bmpHeaderDirectory);
                        bmpHeaderDirectory.O000000o(-2, O00000oO);
                        xmVar.O000000o(12L);
                        O000000o(xmVar, bmpHeaderDirectory, xuVar);
                    } catch (IOException unused) {
                        if (bmpHeaderDirectory != null) {
                            O000000o("Unable to read BMP file header", xuVar);
                        } else {
                            bmpHeaderDirectory.O000000o("Unable to read BMP file header");
                        }
                    }
                } else {
                    try {
                        xuVar.O000000o(new xs("Invalid BMP magic number 0x" + Integer.toHexString(O00000oO)));
                    } catch (IOException unused2) {
                        bmpHeaderDirectory = null;
                        if (bmpHeaderDirectory != null) {
                        }
                    }
                }
            } else if (!z) {
                O000000o("Invalid bitmap file - nested arrays not allowed", xuVar);
            } else {
                xmVar.O000000o(4L);
                long O0000O0o = xmVar.O0000O0o();
                xmVar.O000000o(4L);
                O000000o(xmVar, xuVar, false);
                if (O0000O0o != 0) {
                    if (xmVar.O000000o() > O0000O0o) {
                        O000000o("Invalid next header offset", xuVar);
                        return;
                    }
                    xmVar.O000000o(O0000O0o - xmVar.O000000o());
                    O000000o(xmVar, xuVar, true);
                }
            }
        } catch (IOException e) {
            xuVar.O000000o(new xs("Couldn't determine bitmap type: " + e.getMessage()));
        }
    }

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
    private static void O000000o(xm xmVar, BmpHeaderDirectory bmpHeaderDirectory, xu xuVar) {
        xm xmVar2 = xmVar;
        BmpHeaderDirectory bmpHeaderDirectory2 = bmpHeaderDirectory;
        try {
            int O00000Oo = bmpHeaderDirectory2.O00000Oo(-2);
            long O000000o2 = xmVar.O000000o();
            int O0000OOo = xmVar.O0000OOo();
            bmpHeaderDirectory2.O000000o(-1, O0000OOo);
            if (O0000OOo == 12 && O00000Oo == 19778) {
                bmpHeaderDirectory2.O000000o(2, (int) xmVar.O00000oo());
                bmpHeaderDirectory2.O000000o(1, (int) xmVar.O00000oo());
                bmpHeaderDirectory2.O000000o(3, xmVar.O00000oO());
                bmpHeaderDirectory2.O000000o(4, xmVar.O00000oO());
            } else if (O0000OOo == 12) {
                bmpHeaderDirectory2.O000000o(2, xmVar.O00000oO());
                bmpHeaderDirectory2.O000000o(1, xmVar.O00000oO());
                bmpHeaderDirectory2.O000000o(3, xmVar.O00000oO());
                bmpHeaderDirectory2.O000000o(4, xmVar.O00000oO());
            } else {
                if (O0000OOo != 16) {
                    if (O0000OOo != 64) {
                        if (!(O0000OOo == 40 || O0000OOo == 52 || O0000OOo == 56 || O0000OOo == 108)) {
                            if (O0000OOo != 124) {
                                bmpHeaderDirectory2.O000000o("Unexpected DIB header size: ".concat(String.valueOf(O0000OOo)));
                                return;
                            }
                        }
                        bmpHeaderDirectory2.O000000o(2, xmVar.O0000OOo());
                        bmpHeaderDirectory2.O000000o(1, xmVar.O0000OOo());
                        bmpHeaderDirectory2.O000000o(3, xmVar.O00000oO());
                        bmpHeaderDirectory2.O000000o(4, xmVar.O00000oO());
                        bmpHeaderDirectory2.O000000o(5, xmVar.O0000OOo());
                        xmVar2.O000000o(4L);
                        bmpHeaderDirectory2.O000000o(6, xmVar.O0000OOo());
                        bmpHeaderDirectory2.O000000o(7, xmVar.O0000OOo());
                        bmpHeaderDirectory2.O000000o(8, xmVar.O0000OOo());
                        bmpHeaderDirectory2.O000000o(9, xmVar.O0000OOo());
                        if (O0000OOo != 40) {
                            bmpHeaderDirectory2.O000000o(12, xmVar.O0000O0o());
                            bmpHeaderDirectory2.O000000o(13, xmVar.O0000O0o());
                            bmpHeaderDirectory2.O000000o(14, xmVar.O0000O0o());
                            if (O0000OOo != 52) {
                                bmpHeaderDirectory2.O000000o(15, xmVar.O0000O0o());
                                if (O0000OOo != 56) {
                                    long O0000O0o = xmVar.O0000O0o();
                                    bmpHeaderDirectory2.O000000o(16, O0000O0o);
                                    xmVar2.O000000o(36L);
                                    bmpHeaderDirectory2.O000000o(17, xmVar.O0000O0o());
                                    bmpHeaderDirectory2.O000000o(18, xmVar.O0000O0o());
                                    bmpHeaderDirectory2.O000000o(19, xmVar.O0000O0o());
                                    if (O0000OOo != 108) {
                                        bmpHeaderDirectory2.O000000o(20, xmVar.O0000OOo());
                                        if (O0000O0o != BmpHeaderDirectory.ColorSpaceType.PROFILE_EMBEDDED.getValue()) {
                                            if (O0000O0o != BmpHeaderDirectory.ColorSpaceType.PROFILE_LINKED.getValue()) {
                                                xmVar2.O000000o(12L);
                                                return;
                                            }
                                        }
                                        long O0000O0o2 = xmVar.O0000O0o();
                                        int O0000OOo2 = xmVar.O0000OOo();
                                        long j = O000000o2 + O0000O0o2;
                                        if (xmVar.O000000o() > j) {
                                            bmpHeaderDirectory2.O000000o("Invalid profile data offset 0x" + Long.toHexString(j));
                                            return;
                                        }
                                        xmVar2.O000000o(j - xmVar.O000000o());
                                        if (O0000O0o == BmpHeaderDirectory.ColorSpaceType.PROFILE_LINKED.getValue()) {
                                            bmpHeaderDirectory2.O000000o(21, xmVar2.O00000Oo(O0000OOo2, xf.O0000O0o));
                                            return;
                                        }
                                        xc xcVar = new xc(xmVar2.O000000o(O0000OOo2));
                                        new acd();
                                        acd.O000000o(xcVar, xuVar, bmpHeaderDirectory2);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                bmpHeaderDirectory2.O000000o(2, xmVar.O0000OOo());
                bmpHeaderDirectory2.O000000o(1, xmVar.O0000OOo());
                bmpHeaderDirectory2.O000000o(3, xmVar.O00000oO());
                bmpHeaderDirectory2.O000000o(4, xmVar.O00000oO());
                if (O0000OOo > 16) {
                    bmpHeaderDirectory2.O000000o(5, xmVar.O0000OOo());
                    xmVar2.O000000o(4L);
                    bmpHeaderDirectory2.O000000o(6, xmVar.O0000OOo());
                    bmpHeaderDirectory2.O000000o(7, xmVar.O0000OOo());
                    bmpHeaderDirectory2.O000000o(8, xmVar.O0000OOo());
                    bmpHeaderDirectory2.O000000o(9, xmVar.O0000OOo());
                    xmVar2.O000000o(6L);
                    bmpHeaderDirectory2.O000000o(10, xmVar.O00000oO());
                    xmVar2.O000000o(8L);
                    bmpHeaderDirectory2.O000000o(11, xmVar.O0000OOo());
                    xmVar2.O000000o(4L);
                }
            }
        } catch (IOException unused) {
            bmpHeaderDirectory2.O000000o("Unable to read BMP header");
        } catch (MetadataException unused2) {
            bmpHeaderDirectory2.O000000o("Internal error");
        }
    }

    private static void O000000o(String str, xu xuVar) {
        xs xsVar = (xs) xuVar.O000000o(xs.class);
        if (xsVar == null) {
            xuVar.O000000o(new xs(str));
        } else {
            xsVar.O000000o(str);
        }
    }
}
