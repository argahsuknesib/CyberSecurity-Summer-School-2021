package ss;

import _m_j.iql;
import _m_j.jqp;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class q {
    private static final char[] O00000oO = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f15491O000000o;
    public final String O00000Oo;
    public final List<String> O00000o;
    public final int O00000o0;
    private final String O00000oo;
    private final String O0000O0o;
    private final List<String> O0000OOo;
    private final String O0000Oo;
    private final String O0000Oo0;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ss.q.O000000o(java.lang.String, boolean):java.lang.String
     arg types: [java.lang.String, int]
     candidates:
      ss.q.O000000o(java.util.List<java.lang.String>, boolean):java.util.List<java.lang.String>
      ss.q.O000000o(java.lang.StringBuilder, java.util.List<java.lang.String>):void
      ss.q.O000000o(java.lang.String, boolean):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ss.q.O000000o(java.util.List<java.lang.String>, boolean):java.util.List<java.lang.String>
     arg types: [java.util.List<java.lang.String>, int]
     candidates:
      ss.q.O000000o(java.lang.String, boolean):java.lang.String
      ss.q.O000000o(java.lang.StringBuilder, java.util.List<java.lang.String>):void
      ss.q.O000000o(java.util.List<java.lang.String>, boolean):java.util.List<java.lang.String> */
    private q(a aVar) {
        this.f15491O000000o = aVar.f15492O000000o;
        this.O00000oo = O000000o(aVar.O00000Oo, false);
        this.O0000O0o = O000000o(aVar.O00000o0, false);
        this.O00000Oo = aVar.O00000o;
        this.O00000o0 = aVar.O000000o();
        this.O0000OOo = O000000o(aVar.O00000oo, false);
        String str = null;
        this.O00000o = aVar.O0000O0o != null ? O000000o(aVar.O0000O0o, true) : null;
        this.O0000Oo0 = aVar.O0000OOo != null ? O000000o(aVar.O0000OOo, false) : str;
        this.O0000Oo = aVar.toString();
    }

    /* synthetic */ q(a aVar, byte b) {
        this(aVar);
    }

    static int O000000o(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    public static int O000000o(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    static String O000000o(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                iql iql = new iql();
                iql.O000000o(str, i, i3);
                O000000o(iql, str, i3, i2, z);
                return iql.O0000o00();
            }
        }
        return str.substring(i, i2);
    }

    static String O000000o(String str, String str2, boolean z, boolean z2, boolean z3) {
        return O000000o(str, 0, str.length(), str2, true, z, z2, z3);
    }

    private static String O000000o(String str, boolean z) {
        return O000000o(str, 0, str.length(), z);
    }

    private static List<String> O000000o(List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            arrayList.add(next != null ? O000000o(next, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static void O000000o(iql iql, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37 && (i3 = i + 2) < i2) {
                int O000000o2 = O000000o(str.charAt(i + 1));
                int O000000o3 = O000000o(str.charAt(i3));
                if (!(O000000o2 == -1 || O000000o3 == -1)) {
                    iql.O0000OOo((O000000o2 << 4) + O000000o3);
                    i = i3;
                    i += Character.charCount(codePointAt);
                }
            } else if (codePointAt == 43 && z) {
                iql.O0000OOo(32);
                i += Character.charCount(codePointAt);
            }
            iql.O000000o(codePointAt);
            i += Character.charCount(codePointAt);
        }
    }

    static void O000000o(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    private static boolean O000000o(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && O000000o(str.charAt(i + 1)) != -1 && O000000o(str.charAt(i3)) != -1;
    }

    static List<String> O00000Oo(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                str2 = null;
            } else {
                arrayList.add(str.substring(i, indexOf2));
                str2 = str.substring(indexOf2 + 1, indexOf);
            }
            arrayList.add(str2);
            i = indexOf + 1;
        }
        return arrayList;
    }

    public static void O00000Oo(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    public static q O00000o(String str) {
        a aVar = new a();
        if (aVar.O000000o(null, str) == a.C0105a.SUCCESS) {
            return aVar.O00000Oo();
        }
        return null;
    }

    public final boolean O00000Oo() {
        return this.f15491O000000o.equals("https");
    }

    public final String O00000o() {
        if (this.O0000O0o.isEmpty()) {
            return "";
        }
        int indexOf = this.O0000Oo.indexOf(64);
        return this.O0000Oo.substring(this.O0000Oo.indexOf(58, this.f15491O000000o.length() + 3) + 1, indexOf);
    }

    public final String O00000o0() {
        if (this.O00000oo.isEmpty()) {
            return "";
        }
        int length = this.f15491O000000o.length() + 3;
        String str = this.O0000Oo;
        return this.O0000Oo.substring(length, jqp.O000000o(str, length, str.length(), ":@"));
    }

    public final String O00000oO() {
        int indexOf = this.O0000Oo.indexOf(47, this.f15491O000000o.length() + 3);
        String str = this.O0000Oo;
        return this.O0000Oo.substring(indexOf, jqp.O000000o(str, indexOf, str.length(), "?#"));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jqp.O000000o(java.lang.String, int, int, char):int
     arg types: [java.lang.String, int, int, int]
     candidates:
      _m_j.jqp.O000000o(java.lang.String, int, int, java.lang.String):int
      _m_j.jqp.O000000o(java.lang.String, int, int, char):int */
    public final List<String> O00000oo() {
        int indexOf = this.O0000Oo.indexOf(47, this.f15491O000000o.length() + 3);
        String str = this.O0000Oo;
        int O000000o2 = jqp.O000000o(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < O000000o2) {
            int i = indexOf + 1;
            int O000000o3 = jqp.O000000o(this.O0000Oo, i, O000000o2, '/');
            arrayList.add(this.O0000Oo.substring(i, O000000o3));
            indexOf = O000000o3;
        }
        return arrayList;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jqp.O000000o(java.lang.String, int, int, char):int
     arg types: [java.lang.String, int, int, int]
     candidates:
      _m_j.jqp.O000000o(java.lang.String, int, int, java.lang.String):int
      _m_j.jqp.O000000o(java.lang.String, int, int, char):int */
    public final String O0000O0o() {
        if (this.O00000o == null) {
            return null;
        }
        int indexOf = this.O0000Oo.indexOf(63) + 1;
        String str = this.O0000Oo;
        return this.O0000Oo.substring(indexOf, jqp.O000000o(str, indexOf + 1, str.length(), '#'));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof q) && ((q) obj).O0000Oo.equals(this.O0000Oo);
    }

    public final int hashCode() {
        return this.O0000Oo.hashCode();
    }

    public final String toString() {
        return this.O0000Oo;
    }

    public static final class a {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f15492O000000o;
        String O00000Oo = "";
        public String O00000o;
        String O00000o0 = "";
        public int O00000oO = -1;
        final List<String> O00000oo = new ArrayList();
        List<String> O0000O0o;
        String O0000OOo;

        /* renamed from: ss.q$a$a  reason: collision with other inner class name */
        enum C0105a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            this.O00000oo.add("");
        }

        public static String O000000o(String str, int i, int i2) {
            String O000000o2 = q.O000000o(str, i, i2, false);
            if (!O000000o2.contains(":")) {
                return jqp.O00000Oo(O000000o2);
            }
            InetAddress O00000oo2 = (!O000000o2.startsWith("[") || !O000000o2.endsWith("]")) ? O00000oo(O000000o2, 0, O000000o2.length()) : O00000oo(O000000o2, 1, O000000o2.length() - 1);
            if (O00000oo2 == null) {
                return null;
            }
            byte[] address = O00000oo2.getAddress();
            if (address.length == 16) {
                return O000000o(address);
            }
            throw new AssertionError();
        }

        private static String O000000o(byte[] bArr) {
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            while (i2 < bArr.length) {
                int i5 = i2;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i2;
                if (i6 > i4) {
                    i3 = i2;
                    i4 = i6;
                }
                i2 = i5 + 2;
            }
            iql iql = new iql();
            while (i < bArr.length) {
                if (i == i3) {
                    iql.O0000OOo(58);
                    i += i4;
                    if (i == 16) {
                        iql.O0000OOo(58);
                    }
                } else {
                    if (i > 0) {
                        iql.O0000OOo(58);
                    }
                    iql.O0000Oo0((long) (((bArr[i] & 255) << 8) | (bArr[i + 1] & 255)));
                    i += 2;
                }
            }
            return iql.O0000o00();
        }

        private static int O00000o(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        private static int O00000o0(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                        if (charAt2 == ':') {
                            return i;
                        }
                    }
                }
            }
            return -1;
        }

        private static int O00000oO(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i >= i2) {
                            break;
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private static int O0000O0o(String str, int i, int i2) {
            try {
                int parseInt = Integer.parseInt(q.O000000o(str, i, i2, "", false, false, false, true));
                if (parseInt <= 0 || parseInt > 65535) {
                    return -1;
                }
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }

        /* access modifiers changed from: package-private */
        public final int O000000o() {
            int i = this.O00000oO;
            return i != -1 ? i : q.O000000o(this.f15492O000000o);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.jqp.O000000o(java.lang.String, int, int, char):int
         arg types: [java.lang.String, int, int, int]
         candidates:
          _m_j.jqp.O000000o(java.lang.String, int, int, java.lang.String):int
          _m_j.jqp.O000000o(java.lang.String, int, int, char):int */
        /* access modifiers changed from: package-private */
        public final C0105a O000000o(q qVar, String str) {
            int O000000o2;
            int i;
            String str2 = str;
            int O000000o3 = jqp.O000000o(str2, 0, str.length());
            int O00000Oo2 = jqp.O00000Oo(str2, O000000o3, str.length());
            if (O00000o0(str2, O000000o3, O00000Oo2) != -1) {
                if (str.regionMatches(true, O000000o3, "https:", 0, 6)) {
                    this.f15492O000000o = "https";
                    O000000o3 += 6;
                } else if (!str.regionMatches(true, O000000o3, "http:", 0, 5)) {
                    return C0105a.UNSUPPORTED_SCHEME;
                } else {
                    this.f15492O000000o = "http";
                    O000000o3 += 5;
                }
            } else if (qVar == null) {
                return C0105a.MISSING_SCHEME;
            } else {
                this.f15492O000000o = qVar.f15491O000000o;
            }
            int O00000o2 = O00000o(str2, O000000o3, O00000Oo2);
            char c = '?';
            char c2 = '#';
            if (O00000o2 >= 2 || qVar == null || !qVar.f15491O000000o.equals(this.f15492O000000o)) {
                int i2 = O000000o3 + O00000o2;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    O000000o2 = jqp.O000000o(str2, i2, O00000Oo2, "@/\\?#");
                    char charAt = O000000o2 != O00000Oo2 ? str2.charAt(O000000o2) : 65535;
                    if (charAt == 65535 || charAt == c2 || charAt == '/' || charAt == '\\' || charAt == c) {
                        int i3 = O000000o2;
                        int O00000oO2 = O00000oO(str2, i2, i3);
                        int i4 = O00000oO2 + 1;
                    } else if (charAt == '@') {
                        if (!z) {
                            int O000000o4 = jqp.O000000o(str2, i2, O000000o2, ':');
                            int i5 = O000000o4;
                            String str3 = "%40";
                            i = O000000o2;
                            String O000000o5 = q.O000000o(str, i2, O000000o4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            if (z2) {
                                O000000o5 = this.O00000Oo + str3 + O000000o5;
                            }
                            this.O00000Oo = O000000o5;
                            if (i5 != i) {
                                this.O00000o0 = q.O000000o(str, i5 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = O000000o2;
                            this.O00000o0 += "%40" + q.O000000o(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                        }
                        i2 = i + 1;
                        c = '?';
                        c2 = '#';
                    }
                }
                int i32 = O000000o2;
                int O00000oO22 = O00000oO(str2, i2, i32);
                int i42 = O00000oO22 + 1;
                if (i42 < i32) {
                    this.O00000o = O000000o(str2, i2, O00000oO22);
                    this.O00000oO = O0000O0o(str2, i42, i32);
                    if (this.O00000oO == -1) {
                        return C0105a.INVALID_PORT;
                    }
                } else {
                    this.O00000o = O000000o(str2, i2, O00000oO22);
                    this.O00000oO = q.O000000o(this.f15492O000000o);
                }
                if (this.O00000o == null) {
                    return C0105a.INVALID_HOST;
                }
                O000000o3 = i32;
            } else {
                this.O00000Oo = qVar.O00000o0();
                this.O00000o0 = qVar.O00000o();
                this.O00000o = qVar.O00000Oo;
                this.O00000oO = qVar.O00000o0;
                this.O00000oo.clear();
                this.O00000oo.addAll(qVar.O00000oo());
                if (O000000o3 == O00000Oo2 || str2.charAt(O000000o3) == '#') {
                    O000000o(qVar.O0000O0o());
                }
            }
            int O000000o6 = jqp.O000000o(str2, O000000o3, O00000Oo2, "?#");
            O00000Oo(str2, O000000o3, O000000o6);
            if (O000000o6 < O00000Oo2 && str2.charAt(O000000o6) == '?') {
                int O000000o7 = jqp.O000000o(str2, O000000o6, O00000Oo2, '#');
                this.O0000O0o = q.O00000Oo(q.O000000o(str, O000000o6 + 1, O000000o7, " \"'<>#", true, false, true, true));
                O000000o6 = O000000o7;
            }
            if (O000000o6 < O00000Oo2 && str2.charAt(O000000o6) == '#') {
                this.O0000OOo = q.O000000o(str, 1 + O000000o6, O00000Oo2, "", true, false, false, false);
            }
            return C0105a.SUCCESS;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ss.q.O000000o(java.lang.String, java.lang.String, boolean, boolean, boolean):java.lang.String
         arg types: [java.lang.String, java.lang.String, int, int, int]
         candidates:
          ss.q.O000000o(_m_j.iql, java.lang.String, int, int, boolean):void
          ss.q.O000000o(java.lang.String, java.lang.String, boolean, boolean, boolean):java.lang.String */
        public final a O000000o(String str) {
            this.O0000O0o = str != null ? q.O00000Oo(q.O000000o(str, " \"'<>#", false, true, true)) : null;
            return this;
        }

        public final q O00000Oo() {
            if (this.f15492O000000o == null) {
                throw new IllegalStateException("scheme == null");
            } else if (this.O00000o != null) {
                return new q(this, (byte) 0);
            } else {
                throw new IllegalStateException("host == null");
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f15492O000000o);
            sb.append("://");
            if (!this.O00000Oo.isEmpty() || !this.O00000o0.isEmpty()) {
                sb.append(this.O00000Oo);
                if (!this.O00000o0.isEmpty()) {
                    sb.append(':');
                    sb.append(this.O00000o0);
                }
                sb.append('@');
            }
            if (this.O00000o.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.O00000o);
                sb.append(']');
            } else {
                sb.append(this.O00000o);
            }
            int O000000o2 = O000000o();
            if (O000000o2 != q.O000000o(this.f15492O000000o)) {
                sb.append(':');
                sb.append(O000000o2);
            }
            q.O000000o(sb, this.O00000oo);
            if (this.O0000O0o != null) {
                sb.append('?');
                q.O00000Oo(sb, this.O0000O0o);
            }
            if (this.O0000OOo != null) {
                sb.append('#');
                sb.append(this.O0000OOo);
            }
            return sb.toString();
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00da A[SYNTHETIC] */
        private void O00000Oo(java.lang.String r13, int r14, int r15) {
            /*
                r12 = this;
                if (r14 != r15) goto L_0x0003
                return
            L_0x0003:
                char r0 = r13.charAt(r14)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L_0x001e
                r1 = 92
                if (r0 != r1) goto L_0x0013
                goto L_0x001e
            L_0x0013:
                java.util.List<java.lang.String> r0 = r12.O00000oo
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L_0x002a
            L_0x001e:
                java.util.List<java.lang.String> r0 = r12.O00000oo
                r0.clear()
                java.util.List<java.lang.String> r0 = r12.O00000oo
                r0.add(r2)
                goto L_0x00d6
            L_0x002a:
                r5 = r14
                if (r5 >= r15) goto L_0x00da
                java.lang.String r14 = "/\\"
                int r14 = _m_j.jqp.O000000o(r13, r5, r15, r14)
                r0 = 0
                if (r14 >= r15) goto L_0x0038
                r1 = 1
                goto L_0x0039
            L_0x0038:
                r1 = 0
            L_0x0039:
                r8 = 1
                r9 = 0
                r10 = 0
                r11 = 1
                java.lang.String r7 = " \"<>^`{}|/\\?#"
                r4 = r13
                r6 = r14
                java.lang.String r4 = ss.q.O000000o(r4, r5, r6, r7, r8, r9, r10, r11)
                java.lang.String r5 = "."
                boolean r5 = r4.equals(r5)
                if (r5 != 0) goto L_0x0058
                java.lang.String r5 = "%2e"
                boolean r5 = r4.equalsIgnoreCase(r5)
                if (r5 == 0) goto L_0x0056
                goto L_0x0058
            L_0x0056:
                r5 = 0
                goto L_0x0059
            L_0x0058:
                r5 = 1
            L_0x0059:
                if (r5 != 0) goto L_0x00d4
                java.lang.String r5 = ".."
                boolean r5 = r4.equals(r5)
                if (r5 != 0) goto L_0x007b
                java.lang.String r5 = "%2e."
                boolean r5 = r4.equalsIgnoreCase(r5)
                if (r5 != 0) goto L_0x007b
                java.lang.String r5 = ".%2e"
                boolean r5 = r4.equalsIgnoreCase(r5)
                if (r5 != 0) goto L_0x007b
                java.lang.String r5 = "%2e%2e"
                boolean r5 = r4.equalsIgnoreCase(r5)
                if (r5 == 0) goto L_0x007c
            L_0x007b:
                r0 = 1
            L_0x007c:
                if (r0 == 0) goto L_0x00aa
                java.util.List<java.lang.String> r0 = r12.O00000oo
                int r4 = r0.size()
                int r4 = r4 - r3
                java.lang.Object r0 = r0.remove(r4)
                java.lang.String r0 = (java.lang.String) r0
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x00a4
                java.util.List<java.lang.String> r0 = r12.O00000oo
                boolean r0 = r0.isEmpty()
                if (r0 != 0) goto L_0x00a4
                java.util.List<java.lang.String> r0 = r12.O00000oo
                int r4 = r0.size()
                int r4 = r4 - r3
                r0.set(r4, r2)
                goto L_0x00d4
            L_0x00a4:
                java.util.List<java.lang.String> r0 = r12.O00000oo
                r0.add(r2)
                goto L_0x00d4
            L_0x00aa:
                java.util.List<java.lang.String> r0 = r12.O00000oo
                int r5 = r0.size()
                int r5 = r5 - r3
                java.lang.Object r0 = r0.get(r5)
                java.lang.String r0 = (java.lang.String) r0
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x00c8
                java.util.List<java.lang.String> r0 = r12.O00000oo
                int r5 = r0.size()
                int r5 = r5 - r3
                r0.set(r5, r4)
                goto L_0x00cd
            L_0x00c8:
                java.util.List<java.lang.String> r0 = r12.O00000oo
                r0.add(r4)
            L_0x00cd:
                if (r1 == 0) goto L_0x00d4
                java.util.List<java.lang.String> r0 = r12.O00000oo
                r0.add(r2)
            L_0x00d4:
                if (r1 == 0) goto L_0x002a
            L_0x00d6:
                int r14 = r14 + 1
                goto L_0x002a
            L_0x00da:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: ss.q.a.O00000Oo(java.lang.String, int, int):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0097, code lost:
            r5 = 0;
         */
        private static InetAddress O00000oo(String str, int i, int i2) {
            String str2 = str;
            int i3 = i2;
            int i4 = 16;
            byte[] bArr = new byte[16];
            int i5 = -1;
            int i6 = 0;
            int i7 = i;
            int i8 = 0;
            int i9 = -1;
            int i10 = -1;
            while (true) {
                if (i7 >= i3) {
                    break;
                } else if (i8 == i4) {
                    return null;
                } else {
                    int i11 = i7 + 2;
                    if (i11 > i3 || !str2.regionMatches(i7, "::", i6, 2)) {
                        if (i8 != 0) {
                            if (str2.regionMatches(i7, ":", i6, 1)) {
                                i7++;
                            } else if (!str2.regionMatches(i7, ".", i6, 1)) {
                                return null;
                            } else {
                                int i12 = i8 - 2;
                                int i13 = i12;
                                loop1:
                                while (true) {
                                    if (i10 < i3) {
                                        if (i13 == i4) {
                                            break;
                                        }
                                        if (i13 != i12) {
                                            if (str2.charAt(i10) != '.') {
                                                break;
                                            }
                                            i10++;
                                        }
                                        int i14 = i10;
                                        int i15 = 0;
                                        while (true) {
                                            if (i14 < i3) {
                                                char charAt = str2.charAt(i14);
                                                if (charAt >= '0' && charAt <= '9') {
                                                    if ((i15 == 0 && i10 != i14) || (i15 = ((i15 * 10) + charAt) - 48) > 255) {
                                                        break loop1;
                                                    }
                                                    i14++;
                                                } else {
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                        if (i14 - i10 == 0) {
                                            break;
                                        }
                                        bArr[i13] = (byte) i15;
                                        i13++;
                                        i10 = i14;
                                        i4 = 16;
                                        i6 = 0;
                                    } else if (i13 == i12 + 4) {
                                        i6 = 1;
                                    }
                                }
                                if (i6 == 0) {
                                    return null;
                                }
                                i8 += 2;
                            }
                        }
                        i10 = i7;
                    } else if (i9 != i5) {
                        return null;
                    } else {
                        i8 += 2;
                        if (i11 == i3) {
                            i9 = i8;
                            break;
                        }
                        i9 = i8;
                        i10 = i11;
                    }
                    i7 = i10;
                    int i16 = 0;
                    while (i7 < i3) {
                        int O000000o2 = q.O000000o(str2.charAt(i7));
                        if (O000000o2 == -1) {
                            break;
                        }
                        i16 = (i16 << 4) + O000000o2;
                        i7++;
                    }
                    int i17 = i7 - i10;
                    if (i17 == 0 || i17 > 4) {
                        return null;
                    }
                    int i18 = i8 + 1;
                    bArr[i8] = (byte) ((i16 >>> 8) & 255);
                    i8 = i18 + 1;
                    bArr[i18] = (byte) (i16 & 255);
                    i4 = 16;
                    i5 = -1;
                    i6 = 0;
                }
            }
            if (i8 != 16) {
                if (i9 == -1) {
                    return null;
                }
                int i19 = i8 - i9;
                System.arraycopy(bArr, i9, bArr, 16 - i19, i19);
                Arrays.fill(bArr, i9, (16 - i8) + i9, (byte) 0);
            }
            try {
                return InetAddress.getByAddress(bArr);
            } catch (UnknownHostException unused) {
                throw new AssertionError();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ss.q.O000000o(java.lang.String, java.lang.String, boolean, boolean, boolean):java.lang.String
     arg types: [java.lang.String, java.lang.String, int, int, int]
     candidates:
      ss.q.O000000o(_m_j.iql, java.lang.String, int, int, boolean):void
      ss.q.O000000o(java.lang.String, java.lang.String, boolean, boolean, boolean):java.lang.String */
    public final URI O000000o() {
        a aVar = new a();
        aVar.f15492O000000o = this.f15491O000000o;
        aVar.O00000Oo = O00000o0();
        aVar.O00000o0 = O00000o();
        aVar.O00000o = this.O00000Oo;
        aVar.O00000oO = this.O00000o0 != O000000o(this.f15491O000000o) ? this.O00000o0 : -1;
        aVar.O00000oo.clear();
        aVar.O00000oo.addAll(O00000oo());
        aVar.O000000o(O0000O0o());
        aVar.O0000OOo = this.O0000Oo0 == null ? null : this.O0000Oo.substring(this.O0000Oo.indexOf(35) + 1);
        int size = aVar.O00000oo.size();
        for (int i = 0; i < size; i++) {
            aVar.O00000oo.set(i, O000000o(aVar.O00000oo.get(i), "[]", true, false, true));
        }
        if (aVar.O0000O0o != null) {
            int size2 = aVar.O0000O0o.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String str = aVar.O0000O0o.get(i2);
                if (str != null) {
                    aVar.O0000O0o.set(i2, O000000o(str, "\\^`{|}", true, true, true));
                }
            }
        }
        if (aVar.O0000OOo != null) {
            aVar.O0000OOo = O000000o(aVar.O0000OOo, " \"#<>\\^`{|}", true, false, false);
        }
        String aVar2 = aVar.toString();
        try {
            return new URI(aVar2);
        } catch (URISyntaxException e) {
            try {
                return URI.create(aVar2.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public final q O00000o0(String str) {
        a aVar = new a();
        if (aVar.O000000o(this, str) != a.C0105a.SUCCESS) {
            aVar = null;
        }
        if (aVar != null) {
            return aVar.O00000Oo();
        }
        return null;
    }

    static String O000000o(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        String str3 = str;
        int i3 = i2;
        String str4 = str2;
        int i4 = i;
        while (i4 < i3) {
            int codePointAt = str3.codePointAt(i4);
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z4) || str4.indexOf(codePointAt) != -1 || ((codePointAt == 37 && (!z || (z2 && !O000000o(str3, i4, i3)))) || (codePointAt == 43 && z3)))) {
                iql iql = new iql();
                iql.O000000o(str3, i, i4);
                iql iql2 = null;
                while (i4 < i3) {
                    int codePointAt2 = str3.codePointAt(i4);
                    if (!z || !(codePointAt2 == 9 || codePointAt2 == 10 || codePointAt2 == 12 || codePointAt2 == 13)) {
                        if (codePointAt2 == 43 && z3) {
                            iql.O00000Oo(z ? "+" : "%2B");
                        } else if (codePointAt2 < 32 || codePointAt2 == 127 || ((codePointAt2 >= 128 && z4) || str4.indexOf(codePointAt2) != -1 || (codePointAt2 == 37 && (!z || (z2 && !O000000o(str3, i4, i3)))))) {
                            if (iql2 == null) {
                                iql2 = new iql();
                            }
                            iql2.O000000o(codePointAt2);
                            while (!iql2.O00000o()) {
                                byte O00000oo2 = iql2.O00000oo() & 255;
                                iql.O0000OOo(37);
                                iql.O0000OOo((int) O00000oO[(O00000oo2 >> 4) & 15]);
                                iql.O0000OOo((int) O00000oO[O00000oo2 & 15]);
                            }
                        } else {
                            iql.O000000o(codePointAt2);
                        }
                    }
                    i4 += Character.charCount(codePointAt2);
                }
                return iql.O0000o00();
            }
            i4 += Character.charCount(codePointAt);
        }
        return str.substring(i, i2);
    }
}
