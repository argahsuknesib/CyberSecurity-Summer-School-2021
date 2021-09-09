package _m_j;

import com.adobe.xmp.XMPException;
import java.util.Iterator;

public class ng {

    /* renamed from: O000000o  reason: collision with root package name */
    static final /* synthetic */ boolean f2200O000000o = (!ng.class.desiredAssertionStatus());

    private ng() {
    }

    static nf O000000o(nf nfVar, String str, boolean z) throws XMPException {
        return O000000o(nfVar, str, (String) null, z);
    }

    static nf O000000o(nf nfVar, String str, String str2, boolean z) throws XMPException {
        if (f2200O000000o || nfVar.O00000o0 == null) {
            nf O000000o2 = nfVar.O000000o(str);
            if (O000000o2 == null && z) {
                O000000o2 = new nf(str, new nr().O0000o0());
                O000000o2.O0000O0o = true;
                String O000000o3 = mp.O000000o().O000000o(str);
                if (O000000o3 == null) {
                    if (str2 == null || str2.length() == 0) {
                        throw new XMPException("Unregistered schema namespace URI", 101);
                    }
                    O000000o3 = mp.O000000o().O000000o(str, str2);
                }
                O000000o2.O00000Oo = O000000o3;
                nfVar.O000000o(O000000o2);
            }
            return O000000o2;
        }
        throw new AssertionError();
    }

    static nf O00000Oo(nf nfVar, String str, boolean z) throws XMPException {
        if (!nfVar.O0000OOo().O0000o00() && !nfVar.O0000OOo().O00000o0()) {
            if (!nfVar.O0000O0o) {
                throw new XMPException("Named children only allowed for schemas and structs", 102);
            } else if (nfVar.O0000OOo().O00000o()) {
                throw new XMPException("Named children not allowed for arrays", 102);
            } else if (z) {
                nfVar.O0000OOo().O00000o(true);
            }
        }
        nf O000000o2 = nfVar.O000000o(str);
        if (O000000o2 == null && z) {
            nf nfVar2 = new nf(str, new nr());
            nfVar2.O0000O0o = true;
            nfVar.O000000o(nfVar2);
            O000000o2 = nfVar2;
        }
        if (f2200O000000o || O000000o2 != null || !z) {
            return O000000o2;
        }
        throw new AssertionError();
    }

    static nf O000000o(nf nfVar, nk nkVar, boolean z, nr nrVar) throws XMPException {
        nf nfVar2;
        int i;
        if (nkVar == null || nkVar.O000000o() == 0) {
            throw new XMPException("Empty XMPPath", 102);
        }
        nf O000000o2 = O000000o(nfVar, nkVar.O000000o(0).f2206O000000o, (String) null, z);
        if (O000000o2 == null) {
            return null;
        }
        if (O000000o2.O0000O0o) {
            O000000o2.O0000O0o = false;
            nfVar2 = O000000o2;
        } else {
            nfVar2 = null;
        }
        nf nfVar3 = nfVar2;
        nf nfVar4 = O000000o2;
        int i2 = 1;
        while (i2 < nkVar.O000000o()) {
            try {
                nm O000000o3 = nkVar.O000000o(i2);
                int i3 = O000000o3.O00000Oo;
                if (i3 == 1) {
                    nfVar4 = O00000Oo(nfVar4, O000000o3.f2206O000000o, z);
                } else if (i3 == 2) {
                    String substring = O000000o3.f2206O000000o.substring(1);
                    if (!f2200O000000o) {
                        if (substring.startsWith("?")) {
                            throw new AssertionError();
                        }
                    }
                    nf O00000Oo = nfVar4.O00000Oo(substring);
                    if (O00000Oo == null && z) {
                        O00000Oo = new nf(substring, null);
                        O00000Oo.O0000O0o = true;
                        nfVar4.O00000o(O00000Oo);
                    }
                    nfVar4 = O00000Oo;
                } else if (nfVar4.O0000OOo().O00000o()) {
                    if (i3 == 3) {
                        i = O00000o0(nfVar4, O000000o3.f2206O000000o, z);
                    } else if (i3 == 4) {
                        i = nfVar4.O00000Oo();
                    } else if (i3 == 6) {
                        String[] O00000Oo2 = na.O00000Oo(O000000o3.f2206O000000o);
                        i = O00000o0(nfVar4, O00000Oo2[0], O00000Oo2[1]);
                    } else if (i3 == 5) {
                        String[] O00000Oo3 = na.O00000Oo(O000000o3.f2206O000000o);
                        i = O000000o(nfVar4, O00000Oo3[0], O00000Oo3[1], O000000o3.O00000o);
                    } else {
                        throw new XMPException("Unknown array indexing step in FollowXPathStep", 9);
                    }
                    nfVar4 = (i <= 0 || i > nfVar4.O00000Oo()) ? null : nfVar4.O000000o(i);
                } else {
                    throw new XMPException("Indexing applied to non-array", 102);
                }
                if (nfVar4 == null) {
                    if (z) {
                        O00000Oo(nfVar3);
                    }
                    return null;
                }
                if (nfVar4.O0000O0o) {
                    nfVar4.O0000O0o = false;
                    if (i2 == 1 && nkVar.O000000o(i2).O00000o0 && nkVar.O000000o(i2).O00000o != 0) {
                        nfVar4.O0000OOo().O000000o(nkVar.O000000o(i2).O00000o, true);
                    } else if (i2 < nkVar.O000000o() - 1 && nkVar.O000000o(i2).O00000Oo == 1 && !nfVar4.O0000OOo().O0000o0O()) {
                        nfVar4.O0000OOo().O00000o(true);
                    }
                    if (nfVar3 == null) {
                        nfVar3 = nfVar4;
                    }
                }
                i2++;
            } catch (XMPException e) {
                if (nfVar3 != null) {
                    O00000Oo(nfVar3);
                }
                throw e;
            }
        }
        if (nfVar3 != null) {
            nfVar4.O0000OOo().O000000o(nrVar);
            nfVar4.O00000oo = nfVar4.O0000OOo();
        }
        return nfVar4;
    }

    private static void O00000Oo(nf nfVar) {
        nf nfVar2 = nfVar.O00000o0;
        if (nfVar.O0000OOo().O000000o()) {
            nfVar2.O00000oO(nfVar);
        } else {
            nfVar2.O00000o0(nfVar);
        }
        if (!nfVar2.O00000o() && nfVar2.O0000OOo().O0000o00()) {
            nfVar2.O00000o0.O00000o0(nfVar2);
        }
    }

    static nr O000000o(nr nrVar) throws XMPException {
        if (nrVar == null) {
            nrVar = new nr();
        }
        if (nrVar.O0000OoO()) {
            nrVar.O0000Oo();
        }
        if (nrVar.O0000Oo0()) {
            nrVar.O0000OOo();
        }
        if (nrVar.O0000O0o()) {
            nrVar.O00000oo();
        }
        nrVar.O00000o0(nrVar.f2207O000000o);
        return nrVar;
    }

    private static int O00000o0(nf nfVar, String str, boolean z) throws XMPException {
        try {
            int parseInt = Integer.parseInt(str.substring(1, str.length() - 1));
            if (parseInt > 0) {
                if (z && parseInt == nfVar.O00000Oo() + 1) {
                    nf nfVar2 = new nf("[]", null);
                    nfVar2.O0000O0o = true;
                    nfVar.O000000o(nfVar2);
                }
                return parseInt;
            }
            throw new XMPException("Array index must be larger than zero", 102);
        } catch (NumberFormatException unused) {
            throw new XMPException("Array index not digits.", 102);
        }
    }

    private static int O00000o0(nf nfVar, String str, String str2) throws XMPException {
        int i = 1;
        int i2 = -1;
        while (i <= nfVar.O00000Oo() && i2 < 0) {
            nf O000000o2 = nfVar.O000000o(i);
            if (O000000o2.O0000OOo().O00000o0()) {
                int i3 = 1;
                while (true) {
                    if (i3 > O000000o2.O00000Oo()) {
                        break;
                    }
                    nf O000000o3 = O000000o2.O000000o(i3);
                    if (str.equals(O000000o3.f2198O000000o) && str2.equals(O000000o3.O00000Oo)) {
                        i2 = i;
                        break;
                    }
                    i3++;
                }
                i++;
            } else {
                throw new XMPException("Field selector must be used on array of struct", 102);
            }
        }
        return i2;
    }

    private static int O000000o(nf nfVar, String str, String str2, int i) throws XMPException {
        if ("xml:lang".equals(str)) {
            int O000000o2 = O000000o(nfVar, na.O000000o(str2));
            if (O000000o2 >= 0 || (i & 4096) <= 0) {
                return O000000o2;
            }
            nf nfVar2 = new nf("[]", null);
            nfVar2.O00000o(new nf("xml:lang", "x-default", null));
            nfVar.O00000Oo(nfVar2);
            return 1;
        }
        for (int i2 = 1; i2 < nfVar.O00000Oo(); i2++) {
            Iterator O0000O0o = nfVar.O000000o(i2).O0000O0o();
            while (O0000O0o.hasNext()) {
                nf nfVar3 = (nf) O0000O0o.next();
                if (str.equals(nfVar3.f2198O000000o) && str2.equals(nfVar3.O00000Oo)) {
                    return i2;
                }
            }
        }
        return -1;
    }

    static void O000000o(nf nfVar) {
        if (nfVar.O0000OOo().O0000Oo0() && nfVar.O00000o()) {
            boolean z = false;
            Iterator O00000oO = nfVar.O00000oO();
            while (true) {
                if (O00000oO.hasNext()) {
                    if (((nf) O00000oO.next()).O0000OOo().O00000Oo()) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (z) {
                nfVar.O0000OOo().O0000Ooo();
                if (nfVar.O0000OOo().O0000OoO()) {
                    int i = 2;
                    while (i <= nfVar.O00000Oo()) {
                        nf O000000o2 = nfVar.O000000o(i);
                        if (!O000000o2.O00000oo() || !"x-default".equals(O000000o2.O00000Oo(1).O00000Oo)) {
                            i++;
                        } else {
                            try {
                                nfVar.O0000Oo0().remove(i - 1);
                                nfVar.O000000o();
                                nfVar.O00000Oo(O000000o2);
                            } catch (XMPException unused) {
                                if (!f2200O000000o) {
                                    throw new AssertionError();
                                }
                            }
                            if (i == 2) {
                                nfVar.O000000o(2).O00000Oo = O000000o2.O00000Oo;
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }
    }

    static void O000000o(nf nfVar, String str, String str2) throws XMPException {
        nf nfVar2 = new nf("[]", str2, null);
        nf nfVar3 = new nf("xml:lang", str, null);
        nfVar2.O00000o(nfVar3);
        if (!"x-default".equals(nfVar3.O00000Oo)) {
            nfVar.O000000o(nfVar2);
        } else {
            nfVar.O00000Oo(nfVar2);
        }
    }

    static Object[] O00000Oo(nf nfVar, String str, String str2) throws XMPException {
        if (!nfVar.O0000OOo().O0000OoO()) {
            throw new XMPException("Localized text array is not alt-text", 102);
        } else if (!nfVar.O00000o()) {
            return new Object[]{0, null};
        } else {
            Iterator O00000oO = nfVar.O00000oO();
            nf nfVar2 = null;
            nf nfVar3 = null;
            int i = 0;
            while (O00000oO.hasNext()) {
                nf nfVar4 = (nf) O00000oO.next();
                if (nfVar4.O0000OOo().O0000o0O()) {
                    throw new XMPException("Alt-text array item is not simple", 102);
                } else if (!nfVar4.O00000oo() || !"xml:lang".equals(nfVar4.O00000Oo(1).f2198O000000o)) {
                    throw new XMPException("Alt-text array item has no language qualifier", 102);
                } else {
                    String str3 = nfVar4.O00000Oo(1).O00000Oo;
                    if (str2.equals(str3)) {
                        return new Object[]{1, nfVar4};
                    } else if (str != null && str3.startsWith(str)) {
                        if (nfVar2 == null) {
                            nfVar2 = nfVar4;
                        }
                        i++;
                    } else if ("x-default".equals(str3)) {
                        nfVar3 = nfVar4;
                    }
                }
            }
            if (i == 1) {
                return new Object[]{2, nfVar2};
            } else if (i > 1) {
                return new Object[]{3, nfVar2};
            } else if (nfVar3 != null) {
                return new Object[]{4, nfVar3};
            } else {
                return new Object[]{5, nfVar.O000000o(1)};
            }
        }
    }

    static int O000000o(nf nfVar, String str) throws XMPException {
        if (nfVar.O0000OOo().O00000o()) {
            for (int i = 1; i <= nfVar.O00000Oo(); i++) {
                nf O000000o2 = nfVar.O000000o(i);
                if (O000000o2.O00000oo() && "xml:lang".equals(O000000o2.O00000Oo(1).f2198O000000o) && str.equals(O000000o2.O00000Oo(1).O00000Oo)) {
                    return i;
                }
            }
            return -1;
        }
        throw new XMPException("Language item must be used on array", 102);
    }
}
