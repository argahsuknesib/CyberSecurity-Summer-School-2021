package com.typesafe.config.impl;

import _m_j.dsi;
import _m_j.dst;
import _m_j.dtj;
import _m_j.dtn;
import _m_j.dto;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigSyntax;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class Tokenizer {

    static class ProblemException extends Exception {
        private static final long serialVersionUID = 1;
        final dtn problem;

        ProblemException(dtn dtn) {
            this.problem = dtn;
        }
    }

    public static String O000000o(int i) {
        if (i == 10) {
            return "newline";
        }
        if (i == 9) {
            return "tab";
        }
        if (i == -1) {
            return "end of file";
        }
        if (Character.isISOControl(i)) {
            return String.format("control character 0x%x", Integer.valueOf(i));
        }
        return String.format("%c", Integer.valueOf(i));
    }

    public static Iterator<dtn> O000000o(dsi dsi, Reader reader, ConfigSyntax configSyntax) {
        return new O000000o(dsi, reader, configSyntax != ConfigSyntax.JSON);
    }

    static class O000000o implements Iterator<dtn> {

        /* renamed from: O000000o  reason: collision with root package name */
        private final dtj f5929O000000o;
        private final Reader O00000Oo;
        private int O00000o = 1;
        private final LinkedList<Integer> O00000o0 = new LinkedList<>();
        private dsi O00000oO = this.f5929O000000o.O000000o(this.O00000o);
        private final Queue<dtn> O00000oo = new LinkedList();
        private final C0052O000000o O0000O0o;
        private final boolean O0000OOo;

        /* renamed from: com.typesafe.config.impl.Tokenizer$O000000o$O000000o  reason: collision with other inner class name */
        static class C0052O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            StringBuilder f5930O000000o = new StringBuilder();
            boolean O00000Oo = false;

            C0052O000000o() {
            }

            /* access modifiers changed from: package-private */
            public final dtn O000000o(dtn dtn, dsi dsi, int i) {
                if (O000000o.O000000o(dtn)) {
                    return O000000o(dsi, i);
                }
                O000000o();
                return null;
            }

            private void O000000o() {
                this.O00000Oo = false;
                this.f5930O000000o.setLength(0);
            }

            private dtn O000000o(dsi dsi, int i) {
                if (!this.O00000Oo) {
                    this.O00000Oo = true;
                    this.f5930O000000o.setLength(0);
                    return null;
                } else if (this.f5930O000000o.length() <= 0) {
                    return null;
                } else {
                    dtn O00000Oo2 = dto.O00000Oo(O000000o.O000000o(dsi, i), this.f5930O000000o.toString());
                    this.f5930O000000o.setLength(0);
                    return O00000Oo2;
                }
            }
        }

        O000000o(dsi dsi, Reader reader, boolean z) {
            this.f5929O000000o = (dtj) dsi;
            this.O00000Oo = reader;
            this.O0000OOo = z;
            this.O00000oo.add(dto.f14930O000000o);
            this.O0000O0o = new C0052O000000o();
        }

        private int O000000o() {
            if (!this.O00000o0.isEmpty()) {
                return this.O00000o0.pop().intValue();
            }
            try {
                return this.O00000Oo.read();
            } catch (IOException e) {
                dtj dtj = this.f5929O000000o;
                throw new ConfigException.IO(dtj, "read error: " + e.getMessage(), e);
            }
        }

        private void O000000o(int i) {
            if (this.O00000o0.size() <= 2) {
                this.O00000o0.push(Integer.valueOf(i));
                return;
            }
            throw new ConfigException.BugOrBroken("bug: putBack() three times, undesirable look-ahead");
        }

        private boolean O00000Oo(int i) {
            if (i != -1 && this.O0000OOo) {
                if (i == 35) {
                    return true;
                }
                if (i == 47) {
                    int O000000o2 = O000000o();
                    O000000o(O000000o2);
                    if (O000000o2 == 47) {
                        return true;
                    }
                }
            }
            return false;
        }

        private int O000000o(C0052O000000o o000000o) {
            while (true) {
                int O000000o2 = O000000o();
                if (O000000o2 == -1) {
                    return -1;
                }
                if (!(O000000o2 != 10 && dst.O000000o(O000000o2))) {
                    return O000000o2;
                }
                if (o000000o.O00000Oo) {
                    o000000o.f5930O000000o.appendCodePoint(O000000o2);
                }
            }
        }

        private ProblemException O000000o(String str) {
            return O000000o("", str, null);
        }

        private ProblemException O000000o(String str, String str2, Throwable th) {
            return O000000o(this.O00000oO, str, str2, th);
        }

        private static ProblemException O000000o(dsi dsi, String str, String str2, Throwable th) {
            return O000000o(dsi, str, str2, false, th);
        }

        private static ProblemException O000000o(dsi dsi, String str, String str2, boolean z, Throwable th) {
            if (str != null && str2 != null) {
                return new ProblemException(dto.O000000o(dsi, str, str2, z, th));
            }
            throw new ConfigException.BugOrBroken("internal error, creating bad ProblemException");
        }

        public static dsi O000000o(dsi dsi, int i) {
            return ((dtj) dsi).O000000o(i);
        }

        private dtn O00000o0(int i) {
            int O000000o2;
            if (i != 47 || O000000o() == 47) {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    O000000o2 = O000000o();
                    if (O000000o2 == -1 || O000000o2 == 10) {
                        O000000o(O000000o2);
                    } else {
                        sb.appendCodePoint(O000000o2);
                    }
                }
                O000000o(O000000o2);
                return dto.O000000o(this.O00000oO, sb.toString());
            }
            throw new ConfigException.BugOrBroken("called pullComment but // not seen");
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.dto.O000000o(_m_j.dsi, boolean):_m_j.dtn
         arg types: [_m_j.dsi, int]
         candidates:
          _m_j.dto.O000000o(_m_j.dsi, java.lang.String):_m_j.dtn
          _m_j.dto.O000000o(_m_j.dtn, com.typesafe.config.ConfigValueType):boolean
          _m_j.dto.O000000o(_m_j.dsi, boolean):_m_j.dtn */
        private dtn O00000Oo() {
            dsi dsi = this.O00000oO;
            StringBuilder sb = new StringBuilder();
            int O000000o2 = O000000o();
            while (O000000o2 != -1 && "$\"{}[]:=,+#`^?!@*&\\".indexOf(O000000o2) < 0 && !dst.O000000o(O000000o2) && !O00000Oo(O000000o2)) {
                sb.appendCodePoint(O000000o2);
                if (sb.length() == 4) {
                    String sb2 = sb.toString();
                    if (sb2.equals("true")) {
                        return dto.O000000o(dsi, true);
                    }
                    if (sb2.equals("null")) {
                        return dto.O00000Oo(dsi);
                    }
                } else if (sb.length() == 5 && sb.toString().equals("false")) {
                    return dto.O000000o(dsi, false);
                }
                O000000o2 = O000000o();
            }
            O000000o(O000000o2);
            return dto.O00000Oo(dsi, sb.toString());
        }

        private dtn O00000o(int i) throws ProblemException {
            StringBuilder sb = new StringBuilder();
            sb.appendCodePoint(i);
            int O000000o2 = O000000o();
            int i2 = 0;
            boolean z = false;
            while (O000000o2 != -1 && "0123456789eE+-.".indexOf(O000000o2) >= 0) {
                if (O000000o2 == 46 || O000000o2 == 101 || O000000o2 == 69) {
                    z = true;
                }
                sb.appendCodePoint(O000000o2);
                O000000o2 = O000000o();
            }
            O000000o(O000000o2);
            String sb2 = sb.toString();
            if (!z) {
                return dto.O000000o(this.O00000oO, Long.parseLong(sb2), sb2);
            }
            try {
                return dto.O000000o(this.O00000oO, Double.parseDouble(sb2), sb2);
            } catch (NumberFormatException unused) {
                char[] charArray = sb2.toCharArray();
                int length = charArray.length;
                while (i2 < length) {
                    char c = charArray[i2];
                    if ("$\"{}[]:=,+#`^?!@*&\\".indexOf(c) < 0) {
                        i2++;
                    } else {
                        String O000000o3 = Tokenizer.O000000o(c);
                        throw O000000o(O000000o3, "Reserved character '" + Tokenizer.O000000o(c) + "' is not allowed outside quotes");
                    }
                }
                return dto.O00000Oo(this.O00000oO, sb2);
            }
        }

        private void O000000o(StringBuilder sb) throws ProblemException {
            int O000000o2 = O000000o();
            if (O000000o2 == -1) {
                throw O000000o("End of input but backslash in string had nothing after it");
            } else if (O000000o2 == 34) {
                sb.append('\"');
            } else if (O000000o2 == 47) {
                sb.append('/');
            } else if (O000000o2 == 92) {
                sb.append('\\');
            } else if (O000000o2 == 98) {
                sb.append(8);
            } else if (O000000o2 == 102) {
                sb.append(12);
            } else if (O000000o2 == 110) {
                sb.append(10);
            } else if (O000000o2 == 114) {
                sb.append(13);
            } else if (O000000o2 == 116) {
                sb.append(9);
            } else if (O000000o2 == 117) {
                char[] cArr = new char[4];
                int i = 0;
                while (i < 4) {
                    int O000000o3 = O000000o();
                    if (O000000o3 != -1) {
                        cArr[i] = (char) O000000o3;
                        i++;
                    } else {
                        throw O000000o("End of input but expecting 4 hex digits for \\uXXXX escape");
                    }
                }
                String str = new String(cArr);
                try {
                    sb.appendCodePoint(Integer.parseInt(str, 16));
                } catch (NumberFormatException e) {
                    throw O000000o(str, String.format("Malformed hex digits after \\u escape in string: '%s'", str), e);
                }
            } else {
                throw O000000o(Tokenizer.O000000o(O000000o2), String.format("backslash followed by '%s', this is not a valid escape sequence (quoted strings use JSON escaping, so use double-backslash \\\\ for literal backslash)", Tokenizer.O000000o(O000000o2)), null);
            }
        }

        private void O00000Oo(StringBuilder sb) throws ProblemException {
            int i = 0;
            while (true) {
                int O000000o2 = O000000o();
                if (O000000o2 == 34) {
                    i++;
                } else if (i >= 3) {
                    sb.setLength(sb.length() - 3);
                    O000000o(O000000o2);
                    return;
                } else if (O000000o2 != -1) {
                    if (O000000o2 == 10) {
                        this.O00000o++;
                        this.O00000oO = this.f5929O000000o.O000000o(this.O00000o);
                    }
                    i = 0;
                } else {
                    throw O000000o("End of input but triple-quoted string was still open");
                }
                sb.appendCodePoint(O000000o2);
            }
        }

        private dtn O00000o0() throws ProblemException {
            int O000000o2;
            StringBuilder sb = new StringBuilder();
            do {
                O000000o2 = O000000o();
                if (O000000o2 == -1) {
                    throw O000000o("End of input but string quote was still open");
                } else if (O000000o2 == 92) {
                    O000000o(sb);
                    continue;
                } else if (O000000o2 == 34) {
                    continue;
                } else if (!Character.isISOControl(O000000o2)) {
                    sb.appendCodePoint(O000000o2);
                    continue;
                } else {
                    String O000000o3 = Tokenizer.O000000o(O000000o2);
                    throw O000000o(O000000o3, "JSON does not allow unescaped " + Tokenizer.O000000o(O000000o2) + " in quoted strings, use a backslash escape", null);
                }
            } while (O000000o2 != 34);
            if (sb.length() == 0) {
                int O000000o4 = O000000o();
                if (O000000o4 == 34) {
                    O00000Oo(sb);
                } else {
                    O000000o(O000000o4);
                }
            }
            return dto.O00000o0(this.O00000oO, sb.toString());
        }

        private dtn O00000o() throws ProblemException {
            int O000000o2 = O000000o();
            if (O000000o2 == 61) {
                return dto.O0000Oo;
            }
            String O000000o3 = Tokenizer.O000000o(O000000o2);
            throw O000000o(O000000o3, "'+' not followed by =, '" + Tokenizer.O000000o(O000000o2) + "' not allowed after '+'");
        }

        private dtn O00000oO() throws ProblemException {
            dsi dsi = this.O00000oO;
            int O000000o2 = O000000o();
            if (O000000o2 == 123) {
                boolean z = false;
                int O000000o3 = O000000o();
                if (O000000o3 == 63) {
                    z = true;
                } else {
                    O000000o(O000000o3);
                }
                C0052O000000o o000000o = new C0052O000000o();
                ArrayList arrayList = new ArrayList();
                while (true) {
                    dtn O00000Oo2 = O00000Oo(o000000o);
                    if (O00000Oo2 == dto.O0000O0o) {
                        return dto.O000000o(dsi, z, arrayList);
                    }
                    if (O00000Oo2 != dto.O00000Oo) {
                        dtn O000000o4 = o000000o.O000000o(O00000Oo2, dsi, this.O00000o);
                        if (O000000o4 != null) {
                            arrayList.add(O000000o4);
                        }
                        arrayList.add(O00000Oo2);
                    } else {
                        throw O000000o(dsi, "", "Substitution ${ was not closed with a }", null);
                    }
                }
            } else {
                String O000000o5 = Tokenizer.O000000o(O000000o2);
                throw O000000o(O000000o5, "'$' not followed by {, '" + Tokenizer.O000000o(O000000o2) + "' not allowed after '$'");
            }
        }

        private dtn O00000Oo(C0052O000000o o000000o) throws ProblemException {
            dtn dtn;
            dtn dtn2;
            int O000000o2 = O000000o(o000000o);
            if (O000000o2 == -1) {
                return dto.O00000Oo;
            }
            if (O000000o2 == 10) {
                dtn O000000o3 = dto.O000000o(this.O00000oO);
                this.O00000o++;
                this.O00000oO = this.f5929O000000o.O000000o(this.O00000o);
                return O000000o3;
            }
            if (O00000Oo(O000000o2)) {
                dtn = O00000o0(O000000o2);
            } else {
                if (O000000o2 == 34) {
                    dtn2 = O00000o0();
                } else if (O000000o2 == 36) {
                    dtn2 = O00000oO();
                } else if (O000000o2 == 58) {
                    dtn2 = dto.O00000oO;
                } else if (O000000o2 == 61) {
                    dtn2 = dto.O00000o;
                } else if (O000000o2 == 91) {
                    dtn2 = dto.O0000OOo;
                } else if (O000000o2 == 93) {
                    dtn2 = dto.O0000Oo0;
                } else if (O000000o2 == 123) {
                    dtn2 = dto.O00000oo;
                } else if (O000000o2 == 125) {
                    dtn2 = dto.O0000O0o;
                } else if (O000000o2 != 43) {
                    dtn2 = O000000o2 != 44 ? null : dto.O00000o0;
                } else {
                    dtn2 = O00000o();
                }
                if (dtn2 != null) {
                    dtn = dtn2;
                } else if ("0123456789-".indexOf(O000000o2) >= 0) {
                    dtn = O00000o(O000000o2);
                } else if ("$\"{}[]:=,+#`^?!@*&\\".indexOf(O000000o2) < 0) {
                    O000000o(O000000o2);
                    dtn = O00000Oo();
                } else {
                    throw O000000o(Tokenizer.O000000o(O000000o2), "Reserved character '" + Tokenizer.O000000o(O000000o2) + "' is not allowed outside quotes");
                }
            }
            if (dtn != null) {
                return dtn;
            }
            throw new ConfigException.BugOrBroken("bug: failed to generate next token");
        }

        public static boolean O000000o(dtn dtn) {
            return dto.O0000Ooo(dtn) || dto.O0000Oo(dtn) || dto.O000000o(dtn);
        }

        public final boolean hasNext() {
            return !this.O00000oo.isEmpty();
        }

        /* access modifiers changed from: private */
        /* renamed from: O00000oo */
        public dtn next() {
            dtn remove = this.O00000oo.remove();
            if (this.O00000oo.isEmpty() && remove != dto.O00000Oo) {
                try {
                    dtn O00000Oo2 = O00000Oo(this.O0000O0o);
                    dtn O000000o2 = this.O0000O0o.O000000o(O00000Oo2, this.f5929O000000o, this.O00000o);
                    if (O000000o2 != null) {
                        this.O00000oo.add(O000000o2);
                    }
                    this.O00000oo.add(O00000Oo2);
                } catch (ProblemException e) {
                    this.O00000oo.add(e.problem);
                }
                if (this.O00000oo.isEmpty()) {
                    throw new ConfigException.BugOrBroken("bug: tokens queue should not be empty here");
                }
            }
            return remove;
        }

        public final void remove() {
            throw new UnsupportedOperationException("Does not make sense to remove items from token stream");
        }

        private ProblemException O000000o(String str, String str2) {
            return O000000o(this.O00000oO, str, str2, true, null);
        }
    }
}
