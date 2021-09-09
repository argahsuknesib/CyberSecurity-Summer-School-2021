package _m_j;

public final class cph implements cpb {

    /* renamed from: O000000o  reason: collision with root package name */
    private final int f14182O000000o;
    private final int O00000Oo;
    private final cpd O00000o;
    private final boolean O00000o0;
    private final String O00000oO;

    public /* synthetic */ cph(O000000o o000000o, byte b) {
        this(o000000o);
    }

    private cph(O000000o o000000o) {
        cpj.O000000o(o000000o);
        this.f14182O000000o = o000000o.f14183O000000o;
        this.O00000Oo = o000000o.O00000Oo;
        this.O00000o0 = o000000o.O00000o0;
        this.O00000o = o000000o.O00000o;
        this.O00000oO = o000000o.O00000oO;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0079  */
    public final void O000000o(int i, String str, String str2) {
        String str3;
        int length;
        int length2;
        cpj.O000000o((Object) str2);
        if (!cpj.O000000o((CharSequence) str)) {
            String str4 = this.O00000oO;
            boolean z = true;
            if (str4 != str) {
                if (str4 != null && str != null && (length2 = str4.length()) == str.length()) {
                    if (!(str4 instanceof String) || !(str instanceof String)) {
                        int i2 = 0;
                        while (true) {
                            if (i2 < length2) {
                                if (str4.charAt(i2) != str.charAt(i2)) {
                                    break;
                                }
                                i2++;
                            } else {
                                break;
                            }
                        }
                    } else {
                        z = str4.equals(str);
                    }
                }
                z = false;
            }
            if (!z) {
                str3 = this.O00000oO + "-" + str;
                O00000o0(i, str3, "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
                O000000o(i, str3, this.f14182O000000o);
                byte[] bytes = str2.getBytes();
                length = bytes.length;
                if (length > 4000) {
                    if (this.f14182O000000o > 0) {
                        O00000Oo(i, str3);
                    }
                    O00000Oo(i, str3, str2);
                    O000000o(i, str3);
                    return;
                }
                if (this.f14182O000000o > 0) {
                    O00000Oo(i, str3);
                }
                for (int i3 = 0; i3 < length; i3 += 4000) {
                    O00000Oo(i, str3, new String(bytes, i3, Math.min(length - i3, 4000)));
                }
                O000000o(i, str3);
                return;
            }
        }
        str3 = this.O00000oO;
        O00000o0(i, str3, "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        O000000o(i, str3, this.f14182O000000o);
        byte[] bytes2 = str2.getBytes();
        length = bytes2.length;
        if (length > 4000) {
        }
    }

    private void O000000o(int i, String str, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (this.O00000o0) {
            O00000o0(i, str, "│ Thread: " + Thread.currentThread().getName());
            O00000Oo(i, str);
        }
        int O000000o2 = O000000o(stackTrace) + this.O00000Oo;
        if (i2 + O000000o2 > stackTrace.length) {
            i2 = (stackTrace.length - O000000o2) - 1;
        }
        String str2 = "";
        while (i2 > 0) {
            int i3 = i2 + O000000o2;
            if (i3 < stackTrace.length) {
                StringBuilder sb = new StringBuilder();
                sb.append(9474);
                sb.append(' ');
                sb.append(str2);
                String className = stackTrace[i3].getClassName();
                cpj.O000000o((Object) className);
                sb.append(className.substring(className.lastIndexOf(".") + 1));
                sb.append(".");
                sb.append(stackTrace[i3].getMethodName());
                sb.append("  (");
                sb.append(stackTrace[i3].getFileName());
                sb.append(":");
                sb.append(stackTrace[i3].getLineNumber());
                sb.append(")");
                str2 = str2 + "   ";
                O00000o0(i, str, sb.toString());
            }
            i2--;
        }
    }

    private void O000000o(int i, String str) {
        O00000o0(i, str, "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    private void O00000Oo(int i, String str) {
        O00000o0(i, str, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
    }

    private void O00000Oo(int i, String str, String str2) {
        cpj.O000000o((Object) str2);
        for (String valueOf : str2.split(System.getProperty("line.separator"))) {
            O00000o0(i, str, "│ ".concat(String.valueOf(valueOf)));
        }
    }

    private void O00000o0(int i, String str, String str2) {
        cpj.O000000o((Object) str2);
        this.O00000o.O000000o(i, str, str2);
    }

    private static int O000000o(StackTraceElement[] stackTraceElementArr) {
        cpj.O000000o(stackTraceElementArr);
        for (int i = 5; i < stackTraceElementArr.length; i++) {
            String className = stackTraceElementArr[i].getClassName();
            if (!className.equals(cpg.class.getName()) && !className.equals(cpf.class.getName())) {
                return i - 1;
            }
        }
        return -1;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f14183O000000o;
        int O00000Oo;
        public cpd O00000o;
        boolean O00000o0;
        public String O00000oO;

        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
            this.f14183O000000o = 2;
            this.O00000Oo = 0;
            this.O00000o0 = true;
            this.O00000oO = "PRETTY_LOGGER";
        }
    }
}
