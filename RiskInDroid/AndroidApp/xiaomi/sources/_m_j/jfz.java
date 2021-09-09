package _m_j;

final class jfz {
    static jfz O0000Oo;
    static jfz O0000OoO;
    static jfz O0000Ooo;

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f1809O000000o = true;
    boolean O00000Oo = true;
    boolean O00000o = false;
    boolean O00000o0 = false;
    boolean O00000oO = false;
    boolean O00000oo = true;
    boolean O0000O0o = true;
    boolean O0000OOo = true;
    int O0000Oo0;

    jfz() {
    }

    static {
        jfz jfz = new jfz();
        O0000Oo = jfz;
        jfz.f1809O000000o = true;
        jfz jfz2 = O0000Oo;
        jfz2.O00000Oo = false;
        jfz2.O00000o0 = false;
        jfz2.O00000o = false;
        jfz2.O00000oO = true;
        jfz2.O00000oo = false;
        jfz2.O0000O0o = false;
        jfz2.O0000Oo0 = 0;
        jfz jfz3 = new jfz();
        O0000OoO = jfz3;
        jfz3.f1809O000000o = true;
        jfz jfz4 = O0000OoO;
        jfz4.O00000Oo = true;
        jfz4.O00000o0 = false;
        jfz4.O00000o = false;
        jfz4.O00000oO = false;
        O0000Oo.O0000Oo0 = 1;
        jfz jfz5 = new jfz();
        O0000Ooo = jfz5;
        jfz5.f1809O000000o = false;
        jfz jfz6 = O0000Ooo;
        jfz6.O00000Oo = true;
        jfz6.O00000o0 = false;
        jfz6.O00000o = true;
        jfz6.O00000oO = false;
        jfz6.O0000OOo = false;
        jfz6.O0000Oo0 = 2;
    }

    static String O000000o(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(lastIndexOf + 1);
    }

    private static String O00000Oo(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(lastIndexOf + 1);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.lang.String.replace(char, char):java.lang.String}
     arg types: [int, int]
     candidates:
      ClspMth{java.lang.String.replace(java.lang.CharSequence, java.lang.CharSequence):java.lang.String}
      ClspMth{java.lang.String.replace(char, char):java.lang.String} */
    /* access modifiers changed from: package-private */
    public final String O000000o(Class cls, String str, boolean z) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(O000000o(componentType, componentType.getName(), z));
            stringBuffer.append("[]");
            return stringBuffer.toString();
        } else if (z) {
            return O00000Oo(str).replace('$', '.');
        } else {
            return str.replace('$', '.');
        }
    }

    public final String O000000o(Class cls) {
        return O000000o(cls, cls.getName(), this.f1809O000000o);
    }

    public final void O000000o(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(O000000o(clsArr[i]));
        }
    }
}
