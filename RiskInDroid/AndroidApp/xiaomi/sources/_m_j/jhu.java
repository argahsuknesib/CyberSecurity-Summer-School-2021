package _m_j;

final class jhu {
    static jhu O0000Oo;
    static jhu O0000OoO;
    static jhu O0000Ooo;

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f1842O000000o = true;
    boolean O00000Oo = true;
    boolean O00000o = false;
    boolean O00000o0 = false;
    boolean O00000oO = false;
    boolean O00000oo = true;
    boolean O0000O0o = true;
    boolean O0000OOo = true;
    int O0000Oo0;

    jhu() {
    }

    static {
        jhu jhu = new jhu();
        O0000Oo = jhu;
        jhu.f1842O000000o = true;
        jhu jhu2 = O0000Oo;
        jhu2.O00000Oo = false;
        jhu2.O00000o0 = false;
        jhu2.O00000o = false;
        jhu2.O00000oO = true;
        jhu2.O00000oo = false;
        jhu2.O0000O0o = false;
        jhu2.O0000Oo0 = 0;
        jhu jhu3 = new jhu();
        O0000OoO = jhu3;
        jhu3.f1842O000000o = true;
        jhu jhu4 = O0000OoO;
        jhu4.O00000Oo = true;
        jhu4.O00000o0 = false;
        jhu4.O00000o = false;
        jhu4.O00000oO = false;
        O0000Oo.O0000Oo0 = 1;
        jhu jhu5 = new jhu();
        O0000Ooo = jhu5;
        jhu5.f1842O000000o = false;
        jhu jhu6 = O0000Ooo;
        jhu6.O00000Oo = true;
        jhu6.O00000o0 = false;
        jhu6.O00000o = true;
        jhu6.O00000oO = false;
        jhu6.O0000OOo = false;
        jhu6.O0000Oo0 = 2;
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
        return O000000o(cls, cls.getName(), this.f1842O000000o);
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
