package _m_j;

import com.drew.imaging.png.PngProcessingException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipException;

public final class wu {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Set<ws> f2585O000000o;
    private static Charset O00000Oo = xf.O00000o0;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add(ws.f2583O000000o);
        hashSet.add(ws.O00000Oo);
        hashSet.add(ws.O0000Ooo);
        hashSet.add(ws.O00000oO);
        hashSet.add(ws.O0000Oo0);
        hashSet.add(ws.O00000oo);
        hashSet.add(ws.O0000O0o);
        hashSet.add(ws.O0000Oo);
        hashSet.add(ws.O0000o);
        hashSet.add(ws.O0000oO0);
        hashSet.add(ws.O0000o0o);
        hashSet.add(ws.O0000o0O);
        hashSet.add(ws.O0000o00);
        hashSet.add(ws.O0000OOo);
        f2585O000000o = Collections.unmodifiableSet(hashSet);
    }

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
    public static xu O000000o(InputStream inputStream) throws PngProcessingException, IOException {
        byte[] bArr;
        byte[] bArr2;
        new wr();
        Iterable<wq> O000000o2 = wr.O000000o(new xn(inputStream), f2585O000000o);
        xu xuVar = new xu();
        for (wq next : O000000o2) {
            try {
                ws wsVar = next.f2581O000000o;
                byte[] bArr3 = next.O00000Oo;
                if (wsVar.equals(ws.f2583O000000o)) {
                    wt wtVar = new wt(bArr3);
                    agv agv = new agv(ws.f2583O000000o);
                    agv.O000000o(1, wtVar.f2584O000000o);
                    agv.O000000o(2, wtVar.O00000Oo);
                    agv.O000000o(3, (int) wtVar.O00000o0);
                    agv.O000000o(4, wtVar.O00000o.getNumericValue());
                    agv.O000000o(5, (int) (wtVar.O00000oO & 255));
                    agv.O000000o(6, (int) wtVar.O00000oo);
                    agv.O000000o(7, (int) wtVar.O0000O0o);
                    xuVar.O000000o(agv);
                } else if (wsVar.equals(ws.O00000Oo)) {
                    agv agv2 = new agv(ws.O00000Oo);
                    agv2.O000000o(8, bArr3.length / 3);
                    xuVar.O000000o(agv2);
                } else if (wsVar.equals(ws.O0000Ooo)) {
                    agv agv3 = new agv(ws.O0000Ooo);
                    agv3.O000000o(9, 1);
                    xuVar.O000000o(agv3);
                } else if (wsVar.equals(ws.O0000Oo0)) {
                    byte b = bArr3[0];
                    agv agv4 = new agv(ws.O0000Oo0);
                    agv4.O000000o(10, (int) b);
                    xuVar.O000000o(agv4);
                } else if (wsVar.equals(ws.O00000oO)) {
                    wp wpVar = new wp(bArr3);
                    agt agt = new agt();
                    agt.O000000o(1, wpVar.f2580O000000o);
                    agt.O000000o(2, wpVar.O00000Oo);
                    agt.O000000o(3, wpVar.O00000o0);
                    agt.O000000o(4, wpVar.O00000o);
                    agt.O000000o(5, wpVar.O00000oO);
                    agt.O000000o(6, wpVar.O00000oo);
                    agt.O000000o(7, wpVar.O0000O0o);
                    agt.O000000o(8, wpVar.O0000OOo);
                    xuVar.O000000o(agt);
                } else if (wsVar.equals(ws.O00000oo)) {
                    byte b2 = ((bArr3[0] << 24) & -16777216) | ((bArr3[1] << 16) & 16711680) | ((bArr3[2] << 8) & 65280) | (bArr3[3] & 255);
                    new xl(bArr3).O0000OOo();
                    agv agv5 = new agv(ws.O00000oo);
                    double d = (double) b2;
                    Double.isNaN(d);
                    agv5.O000000o(11, d / 100000.0d);
                    xuVar.O000000o(agv5);
                } else if (wsVar.equals(ws.O0000O0o)) {
                    xl xlVar = new xl(bArr3);
                    byte[] O00000o0 = xlVar.O00000o0(80);
                    agv agv6 = new agv(ws.O0000O0o);
                    agv6.O000000o(12, new xv(O00000o0, O00000Oo));
                    if (xlVar.O00000Oo() == 0) {
                        try {
                            InflaterInputStream inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(xlVar.O000000o(bArr3.length - ((O00000o0.length + 1) + 1))));
                            new acd();
                            acd.O000000o(new xk(inflaterInputStream), xuVar, agv6);
                            inflaterInputStream.close();
                        } catch (ZipException e) {
                            agv6.O000000o(String.format("Exception decompressing PNG iCCP chunk : %s", e.getMessage()));
                            xuVar.O000000o(agv6);
                        }
                    } else {
                        agv6.O000000o("Invalid compression method value");
                    }
                    xuVar.O000000o(agv6);
                } else if (wsVar.equals(ws.O0000Oo)) {
                    agv agv7 = new agv(ws.O0000Oo);
                    agv7.O000000o(15, bArr3);
                    xuVar.O000000o(agv7);
                } else if (wsVar.equals(ws.O0000o)) {
                    xl xlVar2 = new xl(bArr3);
                    xv O00000o02 = xlVar2.O00000o0(80, O00000Oo);
                    String xvVar = O00000o02.toString();
                    xv O00000o03 = xlVar2.O00000o0(bArr3.length - (O00000o02.f2600O000000o.length + 1), O00000Oo);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new xi(xvVar, O00000o03));
                    agv agv8 = new agv(ws.O0000o);
                    agv8.O000000o(13, arrayList);
                    xuVar.O000000o(agv8);
                } else if (wsVar.equals(ws.O0000oO0)) {
                    xl xlVar3 = new xl(bArr3);
                    xv O00000o04 = xlVar3.O00000o0(80, O00000Oo);
                    String xvVar2 = O00000o04.toString();
                    byte O00000Oo2 = xlVar3.O00000Oo();
                    int length = bArr3.length - ((O00000o04.f2600O000000o.length + 1) + 1);
                    if (O00000Oo2 == 0) {
                        try {
                            bArr2 = xo.O000000o(new InflaterInputStream(new ByteArrayInputStream(bArr3, bArr3.length - length, length)));
                        } catch (ZipException e2) {
                            agv agv9 = new agv(ws.O0000oO0);
                            agv9.O000000o(String.format("Exception decompressing PNG zTXt chunk with keyword \"%s\": %s", xvVar2, e2.getMessage()));
                            xuVar.O000000o(agv9);
                        }
                    } else {
                        agv agv10 = new agv(ws.O0000oO0);
                        agv10.O000000o("Invalid compression method value");
                        xuVar.O000000o(agv10);
                        bArr2 = null;
                    }
                    if (bArr2 != null) {
                        if (xvVar2.equals("XML:com.adobe.xmp")) {
                            new ahf();
                            ahf.O000000o(bArr2, xuVar, (xr) null);
                        } else {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(new xi(xvVar2, new xv(bArr2, O00000Oo)));
                            agv agv11 = new agv(ws.O0000oO0);
                            agv11.O000000o(13, arrayList2);
                            xuVar.O000000o(agv11);
                        }
                    }
                } else if (wsVar.equals(ws.O0000o0o)) {
                    xl xlVar4 = new xl(bArr3);
                    xv O00000o05 = xlVar4.O00000o0(80, O00000Oo);
                    String xvVar3 = O00000o05.toString();
                    byte O00000Oo3 = xlVar4.O00000Oo();
                    byte O00000Oo4 = xlVar4.O00000Oo();
                    int length2 = bArr3.length - (((((((O00000o05.f2600O000000o.length + 1) + 1) + 1) + xlVar4.O00000o0(bArr3.length).length) + 1) + xlVar4.O00000o0(bArr3.length).length) + 1);
                    if (O00000Oo3 == 0) {
                        bArr = xlVar4.O00000o0(length2);
                    } else {
                        if (O00000Oo3 != 1) {
                            agv agv12 = new agv(ws.O0000o0o);
                            agv12.O000000o("Invalid compression flag value");
                            xuVar.O000000o(agv12);
                        } else if (O00000Oo4 == 0) {
                            try {
                                bArr = xo.O000000o(new InflaterInputStream(new ByteArrayInputStream(bArr3, bArr3.length - length2, length2)));
                            } catch (ZipException e3) {
                                agv agv13 = new agv(ws.O0000o0o);
                                agv13.O000000o(String.format("Exception decompressing PNG iTXt chunk with keyword \"%s\": %s", xvVar3, e3.getMessage()));
                                xuVar.O000000o(agv13);
                            }
                        } else {
                            agv agv14 = new agv(ws.O0000o0o);
                            agv14.O000000o("Invalid compression method value");
                            xuVar.O000000o(agv14);
                        }
                        bArr = null;
                    }
                    if (bArr != null) {
                        if (xvVar3.equals("XML:com.adobe.xmp")) {
                            new ahf();
                            ahf.O000000o(bArr, xuVar, (xr) null);
                        } else {
                            ArrayList arrayList3 = new ArrayList();
                            arrayList3.add(new xi(xvVar3, new xv(bArr, O00000Oo)));
                            agv agv15 = new agv(ws.O0000o0o);
                            agv15.O000000o(13, arrayList3);
                            xuVar.O000000o(agv15);
                        }
                    }
                } else if (wsVar.equals(ws.O0000o0O)) {
                    xl xlVar5 = new xl(bArr3);
                    int O00000oO = xlVar5.O00000oO();
                    short O00000o = xlVar5.O00000o();
                    short O00000o2 = xlVar5.O00000o();
                    short O00000o3 = xlVar5.O00000o();
                    short O00000o4 = xlVar5.O00000o();
                    short O00000o5 = xlVar5.O00000o();
                    agv agv16 = new agv(ws.O0000o0O);
                    if (!xg.O000000o(O00000oO, O00000o - 1, O00000o2) || !xg.O00000Oo(O00000o3, O00000o4, O00000o5)) {
                        agv16.O000000o(String.format("PNG tIME data describes an invalid date/time: year=%d month=%d day=%d hour=%d minute=%d second=%d", Integer.valueOf(O00000oO), Integer.valueOf(O00000o), Integer.valueOf(O00000o2), Integer.valueOf(O00000o3), Integer.valueOf(O00000o4), Integer.valueOf(O00000o5)));
                    } else {
                        agv16.O000000o(14, String.format("%04d:%02d:%02d %02d:%02d:%02d", Integer.valueOf(O00000oO), Integer.valueOf(O00000o), Integer.valueOf(O00000o2), Integer.valueOf(O00000o3), Integer.valueOf(O00000o4), Integer.valueOf(O00000o5)));
                    }
                    xuVar.O000000o(agv16);
                } else if (wsVar.equals(ws.O0000o00)) {
                    xl xlVar6 = new xl(bArr3);
                    int O0000OOo = xlVar6.O0000OOo();
                    int O0000OOo2 = xlVar6.O0000OOo();
                    byte O00000Oo5 = xlVar6.O00000Oo();
                    agv agv17 = new agv(ws.O0000o00);
                    agv17.O000000o(16, O0000OOo);
                    agv17.O000000o(17, O0000OOo2);
                    agv17.O000000o(18, (int) O00000Oo5);
                    xuVar.O000000o(agv17);
                } else if (wsVar.equals(ws.O0000OOo)) {
                    agv agv18 = new agv(ws.O0000OOo);
                    agv18.O000000o(19, bArr3);
                    xuVar.O000000o(agv18);
                }
            } catch (Exception e4) {
                e4.printStackTrace(System.err);
            }
        }
        return xuVar;
    }
}
