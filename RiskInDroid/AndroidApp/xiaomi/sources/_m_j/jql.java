package _m_j;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public final class jql implements HostnameVerifier {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final jql f2059O000000o = new jql();

    private jql() {
    }

    public static List<String> O000000o(X509Certificate x509Certificate) {
        List<String> O000000o2 = O000000o(x509Certificate, 7);
        List<String> O000000o3 = O000000o(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(O000000o2.size() + O000000o3.size());
        arrayList.addAll(O000000o2);
        arrayList.addAll(O000000o3);
        return arrayList;
    }

    private static List<String> O000000o(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List next : subjectAlternativeNames) {
                if (!(next == null || next.size() < 2 || (num = (Integer) next.get(0)) == null || num.intValue() != i || (str = (String) next.get(1)) == null)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    private static boolean O000000o(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String substring = lowerCase.substring(1);
            if (!str.endsWith(substring)) {
                return false;
            }
            int length = str.length() - substring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }

    public final boolean verify(String str, SSLSession sSLSession) {
        try {
            X509Certificate x509Certificate = (X509Certificate) sSLSession.getPeerCertificates()[0];
            if (jqp.O00000o0(str)) {
                List<String> O000000o2 = O000000o(x509Certificate, 7);
                int size = O000000o2.size();
                for (int i = 0; i < size; i++) {
                    if (str.equalsIgnoreCase(O000000o2.get(i))) {
                        return true;
                    }
                }
                return false;
            }
            String lowerCase = str.toLowerCase(Locale.US);
            List<String> O000000o3 = O000000o(x509Certificate, 2);
            int size2 = O000000o3.size();
            int i2 = 0;
            boolean z = false;
            while (i2 < size2) {
                if (O000000o(lowerCase, O000000o3.get(i2))) {
                    return true;
                }
                i2++;
                z = true;
            }
            if (!z) {
                jqk jqk = new jqk(x509Certificate.getSubjectX500Principal());
                jqk.O00000o0 = 0;
                jqk.O00000o = 0;
                jqk.O00000oO = 0;
                jqk.O00000oo = 0;
                jqk.O0000O0o = jqk.f2058O000000o.toCharArray();
                String O000000o4 = jqk.O000000o();
                String str2 = null;
                if (O000000o4 != null) {
                    while (true) {
                        String str3 = "";
                        if (jqk.O00000o0 == jqk.O00000Oo) {
                            break;
                        }
                        char c = jqk.O0000O0o[jqk.O00000o0];
                        if (c == '\"') {
                            jqk.O00000o0++;
                            jqk.O00000o = jqk.O00000o0;
                            jqk.O00000oO = jqk.O00000o;
                            while (jqk.O00000o0 != jqk.O00000Oo) {
                                if (jqk.O0000O0o[jqk.O00000o0] == '\"') {
                                    while (true) {
                                        jqk.O00000o0++;
                                        if (jqk.O00000o0 >= jqk.O00000Oo || jqk.O0000O0o[jqk.O00000o0] != ' ') {
                                            str3 = new String(jqk.O0000O0o, jqk.O00000o, jqk.O00000oO - jqk.O00000o);
                                        }
                                    }
                                    str3 = new String(jqk.O0000O0o, jqk.O00000o, jqk.O00000oO - jqk.O00000o);
                                } else {
                                    if (jqk.O0000O0o[jqk.O00000o0] == '\\') {
                                        jqk.O0000O0o[jqk.O00000oO] = jqk.O00000o();
                                    } else {
                                        jqk.O0000O0o[jqk.O00000oO] = jqk.O0000O0o[jqk.O00000o0];
                                    }
                                    jqk.O00000o0++;
                                    jqk.O00000oO++;
                                }
                            }
                            throw new IllegalStateException("Unexpected end of DN: " + jqk.f2058O000000o);
                        } else if (c == '#') {
                            str3 = jqk.O00000Oo();
                        } else if (!(c == '+' || c == ',' || c == ';')) {
                            str3 = jqk.O00000o0();
                        }
                        if ("cn".equalsIgnoreCase(O000000o4)) {
                            str2 = str3;
                            break;
                        } else if (jqk.O00000o0 >= jqk.O00000Oo) {
                            break;
                        } else {
                            if (jqk.O0000O0o[jqk.O00000o0] != ',') {
                                if (jqk.O0000O0o[jqk.O00000o0] != ';') {
                                    if (jqk.O0000O0o[jqk.O00000o0] != '+') {
                                        throw new IllegalStateException("Malformed DN: " + jqk.f2058O000000o);
                                    }
                                }
                            }
                            jqk.O00000o0++;
                            O000000o4 = jqk.O000000o();
                            if (O000000o4 == null) {
                                throw new IllegalStateException("Malformed DN: " + jqk.f2058O000000o);
                            }
                        }
                    }
                }
                if (str2 != null) {
                    return O000000o(lowerCase, str2);
                }
            }
            return false;
        } catch (SSLException unused) {
        }
    }
}
