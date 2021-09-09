package _m_j;

import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.imaging.tiff.TiffProcessingException;
import com.drew.lang.BufferBoundsException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

public class yw extends agw {

    /* renamed from: O000000o  reason: collision with root package name */
    static final /* synthetic */ boolean f2606O000000o = (!yw.class.desiredAssertionStatus());

    public yw(xu xuVar, xr xrVar) {
        super(xuVar, xrVar);
    }

    public final void O000000o(int i) throws TiffProcessingException {
        if (i != 42) {
            if (i == 85) {
                O000000o(zc.class);
                return;
            } else if (!(i == 20306 || i == 21330)) {
                throw new TiffProcessingException(String.format("Unexpected TIFF marker: 0x%X", Integer.valueOf(i)));
            }
        }
        O000000o(ym.class);
    }

    public final boolean O00000Oo(int i) {
        if (i == 330) {
            O000000o(yt.class);
            return true;
        }
        if ((this.O00000Oo instanceof ym) || (this.O00000Oo instanceof zc)) {
            if (i == 34665) {
                O000000o(yt.class);
                return true;
            } else if (i == 34853) {
                O000000o(yy.class);
                return true;
            }
        }
        if ((this.O00000Oo instanceof yt) && i == 40965) {
            O000000o(yq.class);
            return true;
        } else if (!(this.O00000Oo instanceof aao)) {
            return false;
        } else {
            if (i == 8208) {
                O000000o(aai.class);
                return true;
            } else if (i == 8224) {
                O000000o(aag.class);
                return true;
            } else if (i == 8256) {
                O000000o(aam.class);
                return true;
            } else if (i == 8272) {
                O000000o(aak.class);
                return true;
            } else if (i == 12288) {
                O000000o(aau.class);
                return true;
            } else if (i == 16384) {
                O000000o(aao.class);
                return true;
            } else if (i == 8240) {
                O000000o(aas.class);
                return true;
            } else if (i != 8241) {
                return false;
            } else {
                O000000o(aaq.class);
                return true;
            }
        }
    }

    public final boolean O000000o() {
        if ((this.O00000Oo instanceof ym) || (this.O00000Oo instanceof yo)) {
            if (this.O00000Oo.O000000o(297)) {
                O000000o(yo.class);
            } else {
                O000000o(yv.class);
            }
            return true;
        } else if (this.O00000Oo instanceof yv) {
            return true;
        } else {
            return false;
        }
    }

    public final Long O000000o(int i, long j) {
        if (i == 13) {
            return Long.valueOf(j * 4);
        }
        return i == 0 ? 0L : null;
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
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.xr.O000000o(int, int):void
     arg types: [int, byte]
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
    public boolean O000000o(int i, Set<Integer> set, int i2, xj xjVar, int i3, int i4) throws IOException {
        boolean z;
        String str;
        String str2;
        String str3;
        Integer num;
        int i5 = i;
        Set<Integer> set2 = set;
        int i6 = i2;
        xj xjVar2 = xjVar;
        int i7 = i3;
        int i8 = i4;
        if (f2606O000000o || this.O00000Oo != null) {
            if (i7 == 0) {
                if (this.O00000Oo.O000000o(i7)) {
                    return false;
                }
                if (i8 == 0) {
                    return true;
                }
            }
            if (i7 != 37500 || !(this.O00000Oo instanceof yt)) {
                if (i7 != 33723 || !(this.O00000Oo instanceof ym)) {
                    if (i7 != 700 || !(this.O00000Oo instanceof ym)) {
                        xr xrVar = this.O00000Oo;
                        if (i7 != 50341 && (i7 != 3584 || (!(xrVar instanceof zq) && !(xrVar instanceof zw) && !(xrVar instanceof aae) && !(xrVar instanceof aao) && !(xrVar instanceof aaw) && !(xrVar instanceof aay) && !(xrVar instanceof abe) && !(xrVar instanceof abi) && !(xrVar instanceof abm)))) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            zi ziVar = new zi();
                            ziVar.O00000oO = this.O00000Oo;
                            this.O00000o0.O000000o(ziVar);
                            O000000o(ziVar, i5, xjVar2, i8);
                            return true;
                        }
                        if (this.O00000Oo instanceof aao) {
                            if (i7 == 8208) {
                                O000000o(aai.class);
                                xb.O000000o(this, xjVar2, set2, i5, i6);
                                return true;
                            } else if (i7 == 8224) {
                                O000000o(aag.class);
                                xb.O000000o(this, xjVar2, set2, i5, i6);
                                return true;
                            } else if (i7 == 8256) {
                                O000000o(aam.class);
                                xb.O000000o(this, xjVar2, set2, i5, i6);
                                return true;
                            } else if (i7 == 8272) {
                                O000000o(aak.class);
                                xb.O000000o(this, xjVar2, set2, i5, i6);
                                return true;
                            } else if (i7 == 12288) {
                                O000000o(aau.class);
                                xb.O000000o(this, xjVar2, set2, i5, i6);
                                return true;
                            } else if (i7 == 16384) {
                                O000000o(aao.class);
                                xb.O000000o(this, xjVar2, set2, i5, i6);
                                return true;
                            } else if (i7 == 8240) {
                                O000000o(aas.class);
                                xb.O000000o(this, xjVar2, set2, i5, i6);
                                return true;
                            } else if (i7 == 8241) {
                                O000000o(aaq.class);
                                xb.O000000o(this, xjVar2, set2, i5, i6);
                                return true;
                            }
                        }
                        if (this.O00000Oo instanceof zc) {
                            if (i7 == 19) {
                                zg zgVar = new zg();
                                zgVar.O00000oO = this.O00000Oo;
                                this.O00000o0.O000000o(zgVar);
                                O000000o(zgVar, i, xjVar, i4, Boolean.FALSE, 2);
                                return true;
                            } else if (i7 == 39) {
                                ze zeVar = new ze();
                                zeVar.O00000oO = this.O00000Oo;
                                this.O00000o0.O000000o(zeVar);
                                O000000o(zeVar, i, xjVar, i4, Boolean.FALSE, 3);
                                return true;
                            } else if (i7 == 281) {
                                za zaVar = new za();
                                zaVar.O00000oO = this.O00000Oo;
                                this.O00000o0.O000000o(zaVar);
                                O000000o(zaVar, i, xjVar, i4, Boolean.TRUE, 1);
                                return true;
                            }
                        }
                        if (i7 != 46 || !(this.O00000Oo instanceof zc)) {
                            return false;
                        }
                        try {
                            for (xr xrVar2 : wj.O000000o(new ByteArrayInputStream(xjVar2.O00000o0(i5, i8))).f2599O000000o) {
                                xrVar2.O00000oO = this.O00000Oo;
                                this.O00000o0.O000000o(xrVar2);
                            }
                            return true;
                        } catch (JpegProcessingException e) {
                            this.O00000Oo.O000000o("Error processing JpgFromRaw: " + e.getMessage());
                            return false;
                        } catch (IOException e2) {
                            this.O00000Oo.O000000o("Error reading JpgFromRaw: " + e2.getMessage());
                            return false;
                        }
                    } else {
                        new ahf();
                        ahf.O000000o(xjVar2.O00000o(i5, i8), this.O00000o0, this.O00000Oo);
                        return true;
                    }
                } else if (xjVar2.O00000o(i5) != 28) {
                    return false;
                } else {
                    byte[] O00000o0 = xjVar2.O00000o0(i5, i8);
                    new acj();
                    acj.O000000o(new xl(O00000o0), this.O00000o0, (long) O00000o0.length, this.O00000Oo);
                    return true;
                }
            } else if (f2606O000000o || this.O00000Oo != null) {
                xr O000000o2 = this.O00000o0.O000000o(ym.class);
                if (O000000o2 == null) {
                    str = null;
                } else {
                    str = O000000o2.O0000o0(271);
                }
                String O000000o3 = O000000o(xjVar2, i5, 2);
                String O000000o4 = O000000o(xjVar2, i5, 3);
                String O000000o5 = O000000o(xjVar2, i5, 4);
                String O000000o6 = O000000o(xjVar2, i5, 5);
                String O000000o7 = O000000o(xjVar2, i5, 6);
                String O000000o8 = O000000o(xjVar2, i5, 7);
                String O000000o9 = O000000o(xjVar2, i5, 8);
                String O000000o10 = O000000o(xjVar2, i5, 9);
                String O000000o11 = O000000o(xjVar2, i5, 10);
                String str4 = O000000o10;
                String O000000o12 = O000000o(xjVar2, i5, 12);
                boolean z2 = xjVar2.f2594O000000o;
                if ("OLYMP\u0000".equals(O000000o7) || "EPSON".equals(O000000o6) || "AGFA".equals(O000000o5)) {
                    O000000o(aao.class);
                    xb.O000000o(this, xjVar2, set2, i5 + 8, i6);
                } else if ("OLYMPUS\u0000II".equals(O000000o11)) {
                    O000000o(aao.class);
                    xb.O000000o(this, xjVar2, set2, i5 + 12, i5);
                } else {
                    if (str != null) {
                        str2 = O000000o11;
                        if (str.toUpperCase().startsWith("MINOLTA")) {
                            O000000o(aao.class);
                            xb.O000000o(this, xjVar2, set2, i5, i6);
                        }
                    } else {
                        str2 = O000000o11;
                    }
                    if (str == null || !str.trim().toUpperCase().startsWith("NIKON")) {
                        if ("SONY CAM".equals(O000000o9) || "SONY DSC".equals(O000000o9)) {
                            O000000o(abm.class);
                            xb.O000000o(this, xjVar2, set2, i5 + 12, i6);
                        } else {
                            if (str == null || !str.startsWith("SONY")) {
                                str3 = O000000o3;
                            } else {
                                str3 = O000000o3;
                                if (!Arrays.equals(xjVar2.O00000o0(i5, 2), new byte[]{1, 0})) {
                                    O000000o(abm.class);
                                    xb.O000000o(this, xjVar2, set2, i5, i6);
                                }
                            }
                            if ("SEMC MS\u0000\u0000\u0000\u0000\u0000".equals(O000000o12)) {
                                xjVar2.f2594O000000o = true;
                                O000000o(abo.class);
                                xb.O000000o(this, xjVar2, set2, i5 + 20, i6);
                            } else if ("SIGMA\u0000\u0000\u0000".equals(O000000o9) || "FOVEON\u0000\u0000".equals(O000000o9)) {
                                O000000o(abk.class);
                                xb.O000000o(this, xjVar2, set2, i5 + 10, i6);
                            } else if ("KDK".equals(O000000o4)) {
                                xjVar2.f2594O000000o = O000000o8.equals("KDK INFO");
                                zu zuVar = new zu();
                                this.O00000o0.O000000o(zuVar);
                                int i9 = i5 + 8;
                                try {
                                    zuVar.O000000o(0, new xv(xjVar2.O00000o0(i9, 8), xf.f2590O000000o));
                                    zuVar.O000000o(9, (int) xjVar2.O00000o0(i9 + 9));
                                    zuVar.O000000o(10, (int) xjVar2.O00000o0(i9 + 10));
                                    zuVar.O000000o(12, xjVar2.O00000oO(i9 + 12));
                                    zuVar.O000000o(14, xjVar2.O00000oO(i9 + 14));
                                    zuVar.O000000o(16, xjVar2.O00000oO(i9 + 16));
                                    zuVar.O000000o(18, xjVar2.O00000o0(i9 + 18, 2));
                                    zuVar.O000000o(20, xjVar2.O00000o0(i9 + 20, 4));
                                    zuVar.O000000o(24, xjVar2.O00000oO(i9 + 24));
                                    zuVar.O000000o(27, (int) xjVar2.O00000o0(i9 + 27));
                                    zuVar.O000000o(28, (int) xjVar2.O00000o0(i9 + 28));
                                    zuVar.O000000o(29, (int) xjVar2.O00000o0(i9 + 29));
                                    zuVar.O000000o(30, xjVar2.O00000oO(i9 + 30));
                                    zuVar.O000000o(32, xjVar2.O0000OOo(i9 + 32));
                                    zuVar.O000000o(36, (int) xjVar2.O00000oo(i9 + 36));
                                    zuVar.O000000o(56, (int) xjVar2.O00000o0(i9 + 56));
                                    zuVar.O000000o(64, (int) xjVar2.O00000o0(i9 + 64));
                                    zuVar.O000000o(92, (int) xjVar2.O00000o0(i9 + 92));
                                    zuVar.O000000o(93, (int) xjVar2.O00000o0(i9 + 93));
                                    zuVar.O000000o(94, xjVar2.O00000oO(i9 + 94));
                                    zuVar.O000000o(96, xjVar2.O00000oO(i9 + 96));
                                    zuVar.O000000o(98, xjVar2.O00000oO(i9 + 98));
                                    zuVar.O000000o(100, xjVar2.O00000oO(i9 + 100));
                                    zuVar.O000000o(102, xjVar2.O00000oO(i9 + 102));
                                    zuVar.O000000o(104, xjVar2.O00000oO(i9 + 104));
                                    zuVar.O000000o(107, (int) xjVar2.O00000o(i9 + 107));
                                } catch (IOException e3) {
                                    zuVar.O000000o("Error processing Kodak makernote data: " + e3.getMessage());
                                }
                            } else if ("Canon".equalsIgnoreCase(str)) {
                                O000000o(zm.class);
                                xb.O000000o(this, xjVar2, set2, i5, i6);
                            } else if (str == null || !str.toUpperCase().startsWith("CASIO")) {
                                if ("FUJIFILM".equals(O000000o9) || "Fujifilm".equalsIgnoreCase(str)) {
                                    xjVar2.f2594O000000o = false;
                                    O000000o(zs.class);
                                    xb.O000000o(this, xjVar2, set2, xjVar2.O0000Oo0(i5 + 8) + i5, i5);
                                } else if ("KYOCERA".equals(O000000o8)) {
                                    O000000o(zw.class);
                                    xb.O000000o(this, xjVar2, set2, i5 + 22, i6);
                                } else if ("LEICA".equals(O000000o6)) {
                                    xjVar2.f2594O000000o = false;
                                    if ("LEICA\u0000\u0001\u0000".equals(O000000o9) || "LEICA\u0000\u0004\u0000".equals(O000000o9) || "LEICA\u0000\u0005\u0000".equals(O000000o9) || "LEICA\u0000\u0006\u0000".equals(O000000o9) || "LEICA\u0000\u0007\u0000".equals(O000000o9)) {
                                        O000000o(aaa.class);
                                        xb.O000000o(this, xjVar2, set2, i5 + 8, i5);
                                    } else if ("Leica Camera AG".equals(str)) {
                                        O000000o(zy.class);
                                        xb.O000000o(this, xjVar2, set2, i5 + 8, i6);
                                    } else if (!"LEICA".equals(str)) {
                                        return false;
                                    } else {
                                        O000000o(aaw.class);
                                        xb.O000000o(this, xjVar2, set2, i5 + 8, i6);
                                    }
                                } else if ("Panasonic\u0000\u0000\u0000".equals(O000000o12)) {
                                    O000000o(aaw.class);
                                    xb.O000000o(this, xjVar2, set2, i5 + 12, i6);
                                } else if ("AOC\u0000".equals(O000000o5)) {
                                    O000000o(zq.class);
                                    xb.O000000o(this, xjVar2, set2, i5 + 6, i5);
                                } else if (str != null && (str.toUpperCase().startsWith("PENTAX") || str.toUpperCase().startsWith("ASAHI"))) {
                                    O000000o(aay.class);
                                    xb.O000000o(this, xjVar2, set2, i5, i5);
                                } else if ("SANYO\u0000\u0001\u0000".equals(O000000o9)) {
                                    O000000o(abi.class);
                                    xb.O000000o(this, xjVar2, set2, i5 + 8, i5);
                                } else if (str == null || !str.toLowerCase().startsWith("ricoh")) {
                                    if (str2.equals("Apple iOS\u0000")) {
                                        boolean z3 = xjVar2.f2594O000000o;
                                        xjVar2.f2594O000000o = true;
                                        O000000o(zk.class);
                                        xb.O000000o(this, xjVar2, set2, i5 + 14, i5);
                                        xjVar2.f2594O000000o = z3;
                                    } else if (xjVar2.O00000oO(i5) == 61697) {
                                        aba aba = new aba();
                                        this.O00000o0.O000000o(aba);
                                        aba.O000000o(0, Integer.valueOf(xjVar2.O00000oO(i5)));
                                        int i10 = i5 + 2;
                                        int O00000oO = xjVar2.O00000oO(i10);
                                        int O00000oO2 = xjVar2.O00000oO(i10 + 2);
                                        int O00000oO3 = xjVar2.O00000oO(i10 + 4);
                                        String str5 = String.format("%04X", Integer.valueOf(xjVar2.O00000oO(i10 + 6))) + String.format("%04X", Integer.valueOf(xjVar2.O00000oO(i10 + 8)));
                                        try {
                                            num = Integer.valueOf(Integer.parseInt(str5));
                                        } catch (NumberFormatException unused) {
                                            num = null;
                                        }
                                        if (num != null) {
                                            aba.O000000o(2, String.format("%d.%d.%d.%s", Integer.valueOf(O00000oO), Integer.valueOf(O00000oO2), Integer.valueOf(O00000oO3), num));
                                        } else {
                                            aba.O000000o(2, String.format("%d.%d.%d", Integer.valueOf(O00000oO), Integer.valueOf(O00000oO2), Integer.valueOf(O00000oO3)));
                                            aba.O000000o("Error processing Reconyx HyperFire makernote data: build '" + str5 + "' is not in the expected format and will be omitted from Firmware Version.");
                                        }
                                        aba.O000000o(12, String.valueOf((char) xjVar2.O00000oO(i5 + 12)));
                                        int i11 = i5 + 14;
                                        aba.O00000Oo(14, new int[]{xjVar2.O00000oO(i11), xjVar2.O00000oO(i11 + 2)});
                                        int i12 = i5 + 18;
                                        aba.O000000o(18, (xjVar2.O00000oO(i12) << 16) + xjVar2.O00000oO(i12 + 2));
                                        int i13 = i5 + 22;
                                        int O00000oO4 = xjVar2.O00000oO(i13);
                                        int O00000oO5 = xjVar2.O00000oO(i13 + 2);
                                        int O00000oO6 = xjVar2.O00000oO(i13 + 4);
                                        int O00000oO7 = xjVar2.O00000oO(i13 + 6);
                                        int O00000oO8 = xjVar2.O00000oO(i13 + 8);
                                        int O00000oO9 = xjVar2.O00000oO(i13 + 10);
                                        if (O00000oO4 < 0 || O00000oO4 >= 60 || O00000oO5 < 0 || O00000oO5 >= 60 || O00000oO6 < 0 || O00000oO6 >= 24 || O00000oO7 <= 0 || O00000oO7 >= 13 || O00000oO8 <= 0 || O00000oO8 >= 32 || O00000oO9 <= 0 || O00000oO9 > 9999) {
                                            aba.O000000o("Error processing Reconyx HyperFire makernote data: Date/Time Original " + O00000oO9 + "-" + O00000oO7 + "-" + O00000oO8 + " " + O00000oO6 + ":" + O00000oO5 + ":" + O00000oO4 + " is not a valid date/time.");
                                        } else {
                                            aba.O000000o(22, String.format("%4d:%2d:%2d %2d:%2d:%2d", Integer.valueOf(O00000oO9), Integer.valueOf(O00000oO7), Integer.valueOf(O00000oO8), Integer.valueOf(O00000oO6), Integer.valueOf(O00000oO5), Integer.valueOf(O00000oO4)));
                                        }
                                        aba.O000000o(36, xjVar2.O00000oO(i5 + 36));
                                        aba.O000000o(38, (int) xjVar2.O00000oo(i5 + 38));
                                        aba.O000000o(40, (int) xjVar2.O00000oo(i5 + 40));
                                        aba.O000000o(42, new xv(xjVar2.O00000o0(i5 + 42, 28), xf.O00000oo));
                                        aba.O000000o(72, xjVar2.O00000oO(i5 + 72));
                                        aba.O000000o(74, xjVar2.O00000oO(i5 + 74));
                                        aba.O000000o(76, xjVar2.O00000oO(i5 + 76));
                                        aba.O000000o(78, xjVar2.O00000oO(i5 + 78));
                                        aba.O000000o(80, xjVar2.O00000oO(i5 + 80));
                                        aba.O000000o(82, xjVar2.O00000oO(i5 + 82));
                                        double O00000oO10 = (double) xjVar2.O00000oO(i5 + 84);
                                        Double.isNaN(O00000oO10);
                                        aba.O000000o(84, O00000oO10 / 1000.0d);
                                        aba.O000000o(86, xjVar2.O00000Oo(i5 + 86, 44, xf.f2590O000000o));
                                    } else if (str4.equalsIgnoreCase("RECONYXUF")) {
                                        abc abc = new abc();
                                        this.O00000o0.O000000o(abc);
                                        abc.O000000o(0, xjVar2.O000000o(i5, 9, xf.f2590O000000o));
                                        abc.O000000o(52, xjVar2.O000000o(i5 + 52, 1, xf.f2590O000000o));
                                        int i14 = i5 + 53;
                                        abc.O00000Oo(53, new int[]{xjVar2.O000000o(i14), xjVar2.O000000o(i14 + 1)});
                                        int i15 = i5 + 59;
                                        xjVar2.O000000o(i15);
                                        xjVar2.O000000o(i15 + 1);
                                        xjVar2.O000000o(i15 + 2);
                                        xjVar2.O000000o(i15 + 3);
                                        xjVar2.O000000o(i15 + 4);
                                        abc.O000000o(67, (int) xjVar2.O000000o(i5 + 67));
                                        abc.O000000o(72, (int) xjVar2.O000000o(i5 + 72));
                                        abc.O000000o(75, new xv(xjVar2.O00000o0(i5 + 75, 14), xf.f2590O000000o));
                                        abc.O000000o(80, xjVar2.O00000Oo(i5 + 80, 20, xf.f2590O000000o));
                                    } else if (!"SAMSUNG".equals(str)) {
                                        return false;
                                    } else {
                                        O000000o(abg.class);
                                        xb.O000000o(this, xjVar2, set2, i5, i6);
                                    }
                                } else if (str3.equals("Rv") || O000000o4.equals("Rev")) {
                                    return false;
                                } else {
                                    if (O000000o6.equalsIgnoreCase("Ricoh")) {
                                        xjVar2.f2594O000000o = true;
                                        O000000o(abe.class);
                                        xb.O000000o(this, xjVar2, set2, i5 + 8, i5);
                                    }
                                }
                            } else if ("QVC\u0000\u0000\u0000".equals(O000000o7)) {
                                O000000o(zq.class);
                                xb.O000000o(this, xjVar2, set2, i5 + 6, i6);
                            } else {
                                O000000o(zo.class);
                                xb.O000000o(this, xjVar2, set2, i5, i6);
                            }
                        }
                    } else if ("Nikon".equals(O000000o6)) {
                        short O00000o02 = xjVar2.O00000o0(i5 + 6);
                        if (O00000o02 == 1) {
                            O000000o(aac.class);
                            xb.O000000o(this, xjVar2, set2, i5 + 8, i6);
                        } else if (O00000o02 != 2) {
                            this.O00000Oo.O000000o("Unsupported Nikon makernote data ignored.");
                        } else {
                            O000000o(aae.class);
                            xb.O000000o(this, xjVar2, set2, i5 + 18, i5 + 10);
                        }
                    } else {
                        O000000o(aae.class);
                        xb.O000000o(this, xjVar2, set2, i5, i6);
                    }
                }
                xjVar2.f2594O000000o = z2;
                return true;
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    private static void O000000o(xr xrVar, int i, xj xjVar, int i2, Boolean bool, int i3) throws IOException {
        int i4 = 0;
        while (i4 < i2) {
            if (xrVar.O0000oO0(i4)) {
                if (i4 >= i2 - 1 || !xrVar.O0000oO0(i4 + 1)) {
                    if (bool.booleanValue()) {
                        short[] sArr = new short[i3];
                        for (int i5 = 0; i5 < sArr.length; i5++) {
                            sArr[i5] = xjVar.O00000oo(((i4 + i5) * 2) + i);
                        }
                        xrVar.O00000Oo(i4, sArr);
                    } else {
                        int[] iArr = new int[i3];
                        for (int i6 = 0; i6 < iArr.length; i6++) {
                            iArr[i6] = xjVar.O00000oO(((i4 + i6) * 2) + i);
                        }
                        xrVar.O00000Oo(i4, iArr);
                    }
                    i4 += i3 - 1;
                } else if (bool.booleanValue()) {
                    xrVar.O000000o(i4, Short.valueOf(xjVar.O00000oo((i4 * 2) + i)));
                } else {
                    xrVar.O000000o(i4, Integer.valueOf(xjVar.O00000oO((i4 * 2) + i)));
                }
            }
            i4++;
        }
    }

    private static String O000000o(xj xjVar, int i, int i2) throws IOException {
        try {
            return xjVar.O000000o(i, i2, xf.f2590O000000o);
        } catch (BufferBoundsException unused) {
            return "";
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.xr.O000000o(int, java.lang.Object):void
     arg types: [int, java.lang.String]
     candidates:
      _m_j.xr.O000000o(int, double):void
      _m_j.xr.O000000o(int, float):void
      _m_j.xr.O000000o(int, int):void
      _m_j.xr.O000000o(int, long):void
      _m_j.xr.O000000o(int, _m_j.xv):void
      _m_j.xr.O000000o(int, java.lang.String):void
      _m_j.xr.O000000o(int, boolean):void
      _m_j.xr.O000000o(int, byte[]):void
      _m_j.xr.O000000o(int, java.lang.Object):void */
    private static void O000000o(zi ziVar, int i, xj xjVar, int i2) throws IOException {
        Boolean bool;
        int i3;
        if (i2 == 0) {
            ziVar.O000000o("Empty PrintIM data");
        } else if (i2 <= 15) {
            ziVar.O000000o("Bad PrintIM data");
        } else {
            String O000000o2 = xjVar.O000000o(i, 12, xf.f2590O000000o);
            if (!O000000o2.startsWith("PrintIM")) {
                ziVar.O000000o("Invalid PrintIM header");
                return;
            }
            int i4 = i + 14;
            int O00000oO = xjVar.O00000oO(i4);
            if (i2 < (O00000oO * 6) + 16) {
                Boolean valueOf = Boolean.valueOf(xjVar.f2594O000000o);
                xjVar.f2594O000000o = !xjVar.f2594O000000o;
                i3 = xjVar.O00000oO(i4);
                if (i2 < (i3 * 6) + 16) {
                    ziVar.O000000o("Bad PrintIM size");
                    return;
                }
                bool = valueOf;
            } else {
                bool = null;
                i3 = O00000oO;
            }
            ziVar.O000000o(0, (Object) O000000o2.substring(8, 12));
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = i + 16 + (i5 * 6);
                ziVar.O000000o(xjVar.O00000oO(i6), Long.valueOf(xjVar.O0000OOo(i6 + 2)));
            }
            if (bool != null) {
                xjVar.f2594O000000o = bool.booleanValue();
            }
        }
    }
}
