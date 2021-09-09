package _m_j;

import com.adobe.xmp.XMPException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class nh {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Map f2201O000000o = new HashMap();

    private static void O00000Oo(nf nfVar) {
        Iterator O00000oO = nfVar.O00000oO();
        while (O00000oO.hasNext()) {
            if (!((nf) O00000oO.next()).O00000o()) {
                O00000oO.remove();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ng.O000000o(_m_j.nf, java.lang.String, boolean):_m_j.nf
     arg types: [_m_j.nf, java.lang.String, int]
     candidates:
      _m_j.ng.O000000o(_m_j.nf, java.lang.String, java.lang.String):void
      _m_j.ng.O000000o(_m_j.nf, java.lang.String, boolean):_m_j.nf */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ng.O00000Oo(_m_j.nf, java.lang.String, boolean):_m_j.nf
     arg types: [_m_j.nf, java.lang.String, int]
     candidates:
      _m_j.ng.O00000Oo(_m_j.nf, java.lang.String, java.lang.String):java.lang.Object[]
      _m_j.ng.O00000Oo(_m_j.nf, java.lang.String, boolean):_m_j.nf */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ng.O000000o(_m_j.nf, java.lang.String, java.lang.String, boolean):_m_j.nf
     arg types: [_m_j.nf, java.lang.String, ?[OBJECT, ARRAY], int]
     candidates:
      _m_j.ng.O000000o(_m_j.nf, java.lang.String, java.lang.String, int):int
      _m_j.ng.O000000o(_m_j.nf, _m_j.nk, boolean, _m_j.nr):_m_j.nf
      _m_j.ng.O000000o(_m_j.nf, java.lang.String, java.lang.String, boolean):_m_j.nf */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.nh.O000000o(_m_j.nf, _m_j.nf, boolean):void
     arg types: [_m_j.nf, _m_j.nf, int]
     candidates:
      _m_j.nh.O000000o(java.util.Iterator, _m_j.nf, _m_j.nf):void
      _m_j.nh.O000000o(_m_j.nf, _m_j.nf, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ng.O000000o(_m_j.nf, _m_j.nk, boolean, _m_j.nr):_m_j.nf
     arg types: [_m_j.nf, _m_j.nk, int, ?[OBJECT, ARRAY]]
     candidates:
      _m_j.ng.O000000o(_m_j.nf, java.lang.String, java.lang.String, int):int
      _m_j.ng.O000000o(_m_j.nf, java.lang.String, java.lang.String, boolean):_m_j.nf
      _m_j.ng.O000000o(_m_j.nf, _m_j.nk, boolean, _m_j.nr):_m_j.nf */
    static mo O000000o(nd ndVar, nq nqVar) throws XMPException {
        nf nfVar;
        boolean z;
        nf O00000Oo;
        nf nfVar2;
        nd ndVar2 = ndVar;
        nf nfVar3 = ndVar2.f2196O000000o;
        boolean z2 = true;
        ng.O000000o(ndVar2.f2196O000000o, "http://purl.org/dc/elements/1.1/", true);
        Iterator O00000oO = ndVar2.f2196O000000o.O00000oO();
        while (O00000oO.hasNext()) {
            nf nfVar4 = (nf) O00000oO.next();
            if ("http://purl.org/dc/elements/1.1/".equals(nfVar4.f2198O000000o)) {
                for (int i = 1; i <= nfVar4.O00000Oo(); i++) {
                    nf O000000o2 = nfVar4.O000000o(i);
                    nr nrVar = (nr) f2201O000000o.get(O000000o2.f2198O000000o);
                    if (nrVar != null) {
                        if ((O000000o2.O0000OOo().f2207O000000o & 768) == 0) {
                            nf nfVar5 = new nf(O000000o2.f2198O000000o, nrVar);
                            O000000o2.f2198O000000o = "[]";
                            nfVar5.O000000o(O000000o2);
                            nfVar5.O00000o0 = nfVar4;
                            nfVar4.O0000Oo0().set(i - 1, nfVar5);
                            if (nrVar.O0000OoO() && !O000000o2.O0000OOo().O00000Oo()) {
                                O000000o2.O00000o(new nf("xml:lang", "x-default", null));
                            }
                        } else {
                            O000000o2.O0000OOo().O000000o(7680, false);
                            O000000o2.O0000OOo().O000000o(nrVar);
                            if (nrVar.O0000OoO()) {
                                O000000o(O000000o2);
                            }
                        }
                    }
                }
            } else if ("http://ns.adobe.com/exif/1.0/".equals(nfVar4.f2198O000000o)) {
                nf O00000Oo2 = ng.O00000Oo(nfVar4, "exif:GPSTimeStamp", false);
                if (O00000Oo2 != null) {
                    try {
                        mm O000000o3 = mr.O000000o(O00000Oo2.O00000Oo);
                        if (O000000o3.O000000o() == 0 && O000000o3.O00000Oo() == 0) {
                            if (O000000o3.O00000o0() == 0) {
                                nf O00000Oo3 = ng.O00000Oo(nfVar4, "exif:DateTimeOriginal", false);
                                if (O00000Oo3 == null) {
                                    O00000Oo3 = ng.O00000Oo(nfVar4, "exif:DateTimeDigitized", false);
                                }
                                mm O000000o4 = mr.O000000o(O00000Oo3.O00000Oo);
                                Calendar O0000Ooo = O000000o3.O0000Ooo();
                                O0000Ooo.set(z2, O000000o4.O000000o());
                                O0000Ooo.set(2, O000000o4.O00000Oo());
                                O0000Ooo.set(5, O000000o4.O00000o0());
                                O00000Oo2.O00000Oo = mv.O000000o(new nb(O0000Ooo));
                            }
                        }
                    } catch (XMPException unused) {
                    }
                }
                nf O00000Oo4 = ng.O00000Oo(nfVar4, "exif:UserComment", false);
                if (O00000Oo4 != null) {
                    O000000o(O00000Oo4);
                }
            } else {
                if ("http://ns.adobe.com/xmp/1.0/DynamicMedia/".equals(nfVar4.f2198O000000o)) {
                    nf O00000Oo5 = ng.O00000Oo(nfVar4, "xmpDM:copyright", false);
                    if (O00000Oo5 != null) {
                        try {
                            nf O000000o5 = ng.O000000o(ndVar2.f2196O000000o, "http://purl.org/dc/elements/1.1/", z2);
                            String str = O00000Oo5.O00000Oo;
                            nf O00000Oo6 = ng.O00000Oo(O000000o5, "dc:rights", false);
                            if (O00000Oo6 != null) {
                                if (O00000Oo6.O00000o()) {
                                    int O000000o6 = ng.O000000o(O00000Oo6, "x-default");
                                    if (O000000o6 < 0) {
                                        nfVar2 = O00000Oo6;
                                        ndVar.O000000o("http://purl.org/dc/elements/1.1/", "rights", "", "x-default", O00000Oo6.O000000o(z2 ? 1 : 0).O00000Oo);
                                        O000000o6 = ng.O000000o(nfVar2, "x-default");
                                    } else {
                                        nfVar2 = O00000Oo6;
                                    }
                                    nf O000000o7 = nfVar2.O000000o(O000000o6);
                                    String str2 = O000000o7.O00000Oo;
                                    int indexOf = str2.indexOf("\n\n");
                                    if (indexOf >= 0) {
                                        int i2 = indexOf + 2;
                                        if (!str2.substring(i2).equals(str)) {
                                            O000000o7.O00000Oo = str2.substring(0, i2) + str;
                                        }
                                    } else if (!str.equals(str2)) {
                                        O000000o7.O00000Oo = str2 + "\n\n" + str;
                                    }
                                    O00000Oo5.O00000o0.O00000o0(O00000Oo5);
                                }
                            }
                            ndVar.O000000o("http://purl.org/dc/elements/1.1/", "rights", "", "x-default", "\n\n" + str);
                            O00000Oo5.O00000o0.O00000o0(O00000Oo5);
                        } catch (XMPException unused2) {
                        }
                    }
                } else if ("http://ns.adobe.com/xap/1.0/rights/".equals(nfVar4.f2198O000000o) && (O00000Oo = ng.O00000Oo(nfVar4, "xmpRights:UsageTerms", false)) != null) {
                    O000000o(O00000Oo);
                }
                z2 = true;
            }
        }
        if (nfVar3.O0000OOo) {
            nfVar3.O0000OOo = false;
            boolean O00000Oo7 = nqVar.O00000Oo();
            for (nf nfVar6 : Collections.unmodifiableList(new ArrayList(nfVar3.O0000Oo0()))) {
                if (nfVar6.O0000OOo) {
                    Iterator O00000oO2 = nfVar6.O00000oO();
                    while (O00000oO2.hasNext()) {
                        nf nfVar7 = (nf) O00000oO2.next();
                        if (nfVar7.O0000Oo0) {
                            nfVar7.O0000Oo0 = false;
                            ns O00000o0 = mp.O000000o().O00000o0(nfVar7.f2198O000000o);
                            if (O00000o0 != null) {
                                nf O000000o8 = ng.O000000o(nfVar3, O00000o0.O000000o(), (String) null, true);
                                O000000o8.O0000O0o = false;
                                nf O00000Oo8 = ng.O00000Oo(O000000o8, O00000o0.O00000Oo() + O00000o0.O00000o0(), false);
                                if (O00000Oo8 != null) {
                                    if (!O00000o0.O00000o().O000000o()) {
                                        if (O00000o0.O00000o().O00000o0()) {
                                            int O000000o9 = ng.O000000o(O00000Oo8, "x-default");
                                            nfVar = O000000o9 != -1 ? O00000Oo8.O000000o(O000000o9) : null;
                                            z = true;
                                        } else if (O00000Oo8.O00000o()) {
                                            z = true;
                                            nfVar = O00000Oo8.O000000o(1);
                                        } else {
                                            z = true;
                                            nfVar = null;
                                        }
                                        if (nfVar != null) {
                                            if (O00000Oo7) {
                                                O000000o(nfVar7, nfVar, z);
                                            }
                                        }
                                    } else if (O00000Oo7) {
                                        O000000o(nfVar7, O00000Oo8, true);
                                    }
                                    O00000oO2.remove();
                                } else if (O00000o0.O00000o().O000000o()) {
                                    nfVar7.f2198O000000o = O00000o0.O00000Oo() + O00000o0.O00000o0();
                                    O000000o8.O000000o(nfVar7);
                                    O00000oO2.remove();
                                } else {
                                    O00000Oo8 = new nf(O00000o0.O00000Oo() + O00000o0.O00000o0(), O00000o0.O00000o().O00000o());
                                    O000000o8.O000000o(O00000Oo8);
                                }
                                O000000o(O00000oO2, nfVar7, O00000Oo8);
                            }
                        }
                    }
                    nfVar6.O0000OOo = false;
                }
            }
        }
        if (nfVar3.f2198O000000o != null && nfVar3.f2198O000000o.length() >= 36) {
            String lowerCase = nfVar3.f2198O000000o.toLowerCase();
            if (lowerCase.startsWith("uuid:")) {
                lowerCase = lowerCase.substring(5);
            }
            if (na.O00000o0(lowerCase)) {
                nf O000000o10 = ng.O000000o(nfVar3, nl.O000000o("http://ns.adobe.com/xap/1.0/mm/", "InstanceID"), true, (nr) null);
                if (O000000o10 != null) {
                    O000000o10.O00000oo = null;
                    O000000o10.O00000Oo = "uuid:".concat(String.valueOf(lowerCase));
                    O000000o10.O00000o = null;
                    nr O0000OOo = O000000o10.O0000OOo();
                    O0000OOo.O000000o(false);
                    O0000OOo.O00000Oo(false);
                    O0000OOo.O00000o0(false);
                    O000000o10.O00000oO = null;
                    nfVar3.f2198O000000o = null;
                } else {
                    throw new XMPException("Failure creating xmpMM:InstanceID", 9);
                }
            }
        }
        O00000Oo(nfVar3);
        return ndVar2;
    }

    private static void O000000o(nf nfVar) throws XMPException {
        if (nfVar != null && nfVar.O0000OOo().O00000o()) {
            nfVar.O0000OOo().O0000OOo().O0000Oo().O0000Ooo();
            Iterator O00000oO = nfVar.O00000oO();
            while (O00000oO.hasNext()) {
                nf nfVar2 = (nf) O00000oO.next();
                if (nfVar2.O0000OOo().O0000o0O()) {
                    O00000oO.remove();
                } else if (!nfVar2.O0000OOo().O00000Oo()) {
                    String str = nfVar2.O00000Oo;
                    if (str == null || str.length() == 0) {
                        O00000oO.remove();
                    } else {
                        nfVar2.O00000o(new nf("xml:lang", "x-repair", null));
                    }
                }
            }
        }
    }

    private static void O000000o(Iterator it, nf nfVar, nf nfVar2) throws XMPException {
        if (nfVar2.O0000OOo().O0000OoO()) {
            if (!nfVar.O0000OOo().O00000Oo()) {
                nfVar.O00000o(new nf("xml:lang", "x-default", null));
            } else {
                throw new XMPException("Alias to x-default already has a language qualifier", 203);
            }
        }
        it.remove();
        nfVar.f2198O000000o = "[]";
        nfVar2.O000000o(nfVar);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.nh.O000000o(_m_j.nf, _m_j.nf, boolean):void
     arg types: [_m_j.nf, _m_j.nf, int]
     candidates:
      _m_j.nh.O000000o(java.util.Iterator, _m_j.nf, _m_j.nf):void
      _m_j.nh.O000000o(_m_j.nf, _m_j.nf, boolean):void */
    private static void O000000o(nf nfVar, nf nfVar2, boolean z) throws XMPException {
        if (!nfVar.O00000Oo.equals(nfVar2.O00000Oo) || nfVar.O00000Oo() != nfVar2.O00000Oo()) {
            throw new XMPException("Mismatch between alias and base nodes", 203);
        } else if (z || (nfVar.f2198O000000o.equals(nfVar2.f2198O000000o) && nfVar.O0000OOo().equals(nfVar2.O0000OOo()) && nfVar.O00000o0() == nfVar2.O00000o0())) {
            Iterator O00000oO = nfVar.O00000oO();
            Iterator O00000oO2 = nfVar2.O00000oO();
            while (O00000oO.hasNext() && O00000oO2.hasNext()) {
                O000000o((nf) O00000oO.next(), (nf) O00000oO2.next(), false);
            }
            Iterator O0000O0o = nfVar.O0000O0o();
            Iterator O0000O0o2 = nfVar2.O0000O0o();
            while (O0000O0o.hasNext() && O0000O0o2.hasNext()) {
                O000000o((nf) O0000O0o.next(), (nf) O0000O0o2.next(), false);
            }
        } else {
            throw new XMPException("Mismatch between alias and base nodes", 203);
        }
    }

    static {
        nr nrVar = new nr();
        nrVar.O00000oo();
        f2201O000000o.put("dc:contributor", nrVar);
        f2201O000000o.put("dc:language", nrVar);
        f2201O000000o.put("dc:publisher", nrVar);
        f2201O000000o.put("dc:relation", nrVar);
        f2201O000000o.put("dc:subject", nrVar);
        f2201O000000o.put("dc:type", nrVar);
        nr nrVar2 = new nr();
        nrVar2.O00000oo();
        nrVar2.O0000OOo();
        f2201O000000o.put("dc:creator", nrVar2);
        f2201O000000o.put("dc:date", nrVar2);
        nr nrVar3 = new nr();
        nrVar3.O00000oo();
        nrVar3.O0000OOo();
        nrVar3.O0000Oo();
        nrVar3.O0000Ooo();
        f2201O000000o.put("dc:description", nrVar3);
        f2201O000000o.put("dc:rights", nrVar3);
        f2201O000000o.put("dc:title", nrVar3);
    }
}
