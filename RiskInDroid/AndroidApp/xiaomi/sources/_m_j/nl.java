package _m_j;

import com.adobe.xmp.XMPException;

public final class nl {
    private static nm O000000o(nj njVar) throws XMPException {
        njVar.O00000Oo = njVar.O00000o;
        while (njVar.O00000oO < njVar.f2204O000000o.length() && "/[*".indexOf(njVar.f2204O000000o.charAt(njVar.O00000oO)) < 0) {
            njVar.O00000oO++;
        }
        njVar.O00000o0 = njVar.O00000oO;
        if (njVar.O00000oO != njVar.O00000o) {
            return new nm(njVar.f2204O000000o.substring(njVar.O00000o, njVar.O00000oO), 1);
        }
        throw new XMPException("Empty XMPPath segment", 102);
    }

    private static void O000000o(String str) throws XMPException {
        int indexOf = str.indexOf(58);
        if (indexOf > 0) {
            String substring = str.substring(0, indexOf);
            if (na.O00000oO(substring)) {
                if (mp.O000000o().O00000Oo(substring) == null) {
                    throw new XMPException("Unknown namespace prefix for qualified name", 102);
                }
                return;
            }
        }
        throw new XMPException("Ill-formed qualified name", 102);
    }

    private static void O000000o(String str, nj njVar) throws XMPException {
        if (str.charAt(njVar.O00000o) == '/') {
            njVar.O00000o++;
            if (njVar.O00000o >= str.length()) {
                throw new XMPException("Empty XMPPath segment", 102);
            }
        }
        if (str.charAt(njVar.O00000o) == '*') {
            njVar.O00000o++;
            if (njVar.O00000o >= str.length() || str.charAt(njVar.O00000o) != '[') {
                throw new XMPException("Missing '[' after '*'", 102);
            }
        }
    }

    private static String O00000Oo(String str, String str2) throws XMPException {
        if (str == null || str.length() == 0) {
            throw new XMPException("Schema namespace URI is required", 101);
        } else if (str2.charAt(0) == '?' || str2.charAt(0) == '@') {
            throw new XMPException("Top level name must not be a qualifier", 102);
        } else if (str2.indexOf(47) >= 0 || str2.indexOf(91) >= 0) {
            throw new XMPException("Top level name must be simple", 102);
        } else {
            String O000000o2 = mp.O000000o().O000000o(str);
            if (O000000o2 != null) {
                int indexOf = str2.indexOf(58);
                if (indexOf < 0) {
                    O00000Oo(str2);
                    return O000000o2 + str2;
                }
                O00000Oo(str2.substring(0, indexOf));
                O00000Oo(str2.substring(indexOf));
                String substring = str2.substring(0, indexOf + 1);
                String O000000o3 = mp.O000000o().O000000o(str);
                if (O000000o3 == null) {
                    throw new XMPException("Unknown schema namespace prefix", 101);
                } else if (substring.equals(O000000o3)) {
                    return str2;
                } else {
                    throw new XMPException("Schema namespace URI and prefix mismatch", 101);
                }
            } else {
                throw new XMPException("Unregistered schema namespace URI", 101);
            }
        }
    }

    private static void O00000Oo(String str) throws XMPException {
        if (!na.O00000o(str)) {
            throw new XMPException("Bad XML name", 102);
        }
    }

    public static nk O000000o(String str, String str2) throws XMPException {
        if (str == null || str2 == null) {
            throw new XMPException("Parameter must not be null", 4);
        }
        nk nkVar = new nk();
        nj njVar = new nj();
        njVar.f2204O000000o = str2;
        O000000o(str, njVar, nkVar);
        while (njVar.O00000oO < str2.length()) {
            njVar.O00000o = njVar.O00000oO;
            O000000o(str2, njVar);
            njVar.O00000oO = njVar.O00000o;
            nm O000000o2 = str2.charAt(njVar.O00000o) != '[' ? O000000o(njVar) : O00000Oo(njVar);
            if (O000000o2.O00000Oo == 1) {
                if (O000000o2.f2206O000000o.charAt(0) == '@') {
                    O000000o2.f2206O000000o = "?" + O000000o2.f2206O000000o.substring(1);
                    if (!"?xml:lang".equals(O000000o2.f2206O000000o)) {
                        throw new XMPException("Only xml:lang allowed with '@'", 102);
                    }
                }
                if (O000000o2.f2206O000000o.charAt(0) == '?') {
                    njVar.O00000Oo++;
                    O000000o2.O00000Oo = 2;
                }
                O000000o(njVar.f2204O000000o.substring(njVar.O00000Oo, njVar.O00000o0));
            } else if (O000000o2.O00000Oo != 6) {
                continue;
            } else {
                if (O000000o2.f2206O000000o.charAt(1) == '@') {
                    O000000o2.f2206O000000o = "[?" + O000000o2.f2206O000000o.substring(2);
                    if (!O000000o2.f2206O000000o.startsWith("[?xml:lang=")) {
                        throw new XMPException("Only xml:lang allowed with '@'", 102);
                    }
                }
                if (O000000o2.f2206O000000o.charAt(1) == '?') {
                    njVar.O00000Oo++;
                    O000000o2.O00000Oo = 5;
                    O000000o(njVar.f2204O000000o.substring(njVar.O00000Oo, njVar.O00000o0));
                }
            }
            nkVar.O000000o(O000000o2);
        }
        return nkVar;
    }

    private static nm O00000Oo(nj njVar) throws XMPException {
        nm nmVar;
        njVar.O00000oO++;
        if ('0' > njVar.f2204O000000o.charAt(njVar.O00000oO) || njVar.f2204O000000o.charAt(njVar.O00000oO) > '9') {
            while (njVar.O00000oO < njVar.f2204O000000o.length() && njVar.f2204O000000o.charAt(njVar.O00000oO) != ']' && njVar.f2204O000000o.charAt(njVar.O00000oO) != '=') {
                njVar.O00000oO++;
            }
            if (njVar.O00000oO >= njVar.f2204O000000o.length()) {
                throw new XMPException("Missing ']' or '=' for array index", 102);
            } else if (njVar.f2204O000000o.charAt(njVar.O00000oO) != ']') {
                njVar.O00000Oo = njVar.O00000o + 1;
                njVar.O00000o0 = njVar.O00000oO;
                njVar.O00000oO++;
                char charAt = njVar.f2204O000000o.charAt(njVar.O00000oO);
                if (charAt == '\'' || charAt == '\"') {
                    while (true) {
                        njVar.O00000oO++;
                        if (njVar.O00000oO < njVar.f2204O000000o.length()) {
                            if (njVar.f2204O000000o.charAt(njVar.O00000oO) == charAt) {
                                if (njVar.O00000oO + 1 >= njVar.f2204O000000o.length() || njVar.f2204O000000o.charAt(njVar.O00000oO + 1) != charAt) {
                                    break;
                                }
                                njVar.O00000oO++;
                            }
                        } else {
                            break;
                        }
                    }
                    if (njVar.O00000oO < njVar.f2204O000000o.length()) {
                        njVar.O00000oO++;
                        nmVar = new nm(null, 6);
                    } else {
                        throw new XMPException("No terminating quote for array selector", 102);
                    }
                } else {
                    throw new XMPException("Invalid quote in array selector", 102);
                }
            } else if ("[last()".equals(njVar.f2204O000000o.substring(njVar.O00000o, njVar.O00000oO))) {
                nmVar = new nm(null, 4);
            } else {
                throw new XMPException("Invalid non-numeric array index", 102);
            }
        } else {
            while (njVar.O00000oO < njVar.f2204O000000o.length() && '0' <= njVar.f2204O000000o.charAt(njVar.O00000oO) && njVar.f2204O000000o.charAt(njVar.O00000oO) <= '9') {
                njVar.O00000oO++;
            }
            nmVar = new nm(null, 3);
        }
        if (njVar.O00000oO >= njVar.f2204O000000o.length() || njVar.f2204O000000o.charAt(njVar.O00000oO) != ']') {
            throw new XMPException("Missing ']' for array index", 102);
        }
        njVar.O00000oO++;
        nmVar.f2206O000000o = njVar.f2204O000000o.substring(njVar.O00000o, njVar.O00000oO);
        return nmVar;
    }

    private static void O000000o(String str, nj njVar, nk nkVar) throws XMPException {
        while (njVar.O00000oO < njVar.f2204O000000o.length() && "/[*".indexOf(njVar.f2204O000000o.charAt(njVar.O00000oO)) < 0) {
            njVar.O00000oO++;
        }
        if (njVar.O00000oO != njVar.O00000o) {
            String O00000Oo = O00000Oo(str, njVar.f2204O000000o.substring(njVar.O00000o, njVar.O00000oO));
            ns O00000o0 = mp.O000000o().O00000o0(O00000Oo);
            if (O00000o0 == null) {
                nkVar.O000000o(new nm(str, Integer.MIN_VALUE));
                nkVar.O000000o(new nm(O00000Oo, 1));
                return;
            }
            nkVar.O000000o(new nm(O00000o0.O000000o(), Integer.MIN_VALUE));
            nm nmVar = new nm(O00000Oo(O00000o0.O000000o(), O00000o0.O00000o0()), 1);
            nmVar.O00000o0 = true;
            nmVar.O00000o = O00000o0.O00000o().f2207O000000o;
            nkVar.O000000o(nmVar);
            if (O00000o0.O00000o().O00000o0()) {
                nm nmVar2 = new nm("[?xml:lang='x-default']", 5);
                nmVar2.O00000o0 = true;
                nmVar2.O00000o = O00000o0.O00000o().f2207O000000o;
                nkVar.O000000o(nmVar2);
            } else if (O00000o0.O00000o().O00000Oo()) {
                nm nmVar3 = new nm("[1]", 3);
                nmVar3.O00000o0 = true;
                nmVar3.O00000o = O00000o0.O00000o().f2207O000000o;
                nkVar.O000000o(nmVar3);
            }
        } else {
            throw new XMPException("Empty initial XMPPath step", 102);
        }
    }
}
