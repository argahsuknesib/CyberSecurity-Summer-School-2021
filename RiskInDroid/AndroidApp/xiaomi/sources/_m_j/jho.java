package _m_j;

import _m_j.jhf;
import _m_j.jhp;
import java.util.Hashtable;
import java.util.StringTokenizer;

public final class jho {
    static Hashtable O00000oO;
    static Class O00000oo;
    private static Object[] O0000O0o = new Object[0];

    /* renamed from: O000000o  reason: collision with root package name */
    Class f1836O000000o;
    ClassLoader O00000Oo;
    int O00000o = 0;
    String O00000o0;

    static {
        Hashtable hashtable = new Hashtable();
        O00000oO = hashtable;
        hashtable.put("void", Void.TYPE);
        O00000oO.put("boolean", Boolean.TYPE);
        O00000oO.put("byte", Byte.TYPE);
        O00000oO.put("char", Character.TYPE);
        O00000oO.put("short", Short.TYPE);
        O00000oO.put("int", Integer.TYPE);
        O00000oO.put("long", Long.TYPE);
        O00000oO.put("float", Float.TYPE);
        O00000oO.put("double", Double.TYPE);
    }

    static Class O000000o(String str, ClassLoader classLoader) {
        if (str.equals("*")) {
            return null;
        }
        Class cls = (Class) O00000oO.get(str);
        if (cls != null) {
            return cls;
        }
        if (classLoader != null) {
            return Class.forName(str, false, classLoader);
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            Class cls2 = O00000oo;
            if (cls2 != null) {
                return cls2;
            }
            Class O000000o2 = O000000o("java.lang.ClassNotFoundException");
            O00000oo = O000000o2;
            return O000000o2;
        }
    }

    private static Class O000000o(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public jho(String str, Class cls) {
        this.O00000o0 = str;
        this.f1836O000000o = cls;
        this.O00000Oo = cls.getClassLoader();
    }

    public final jhf.O000000o O000000o(String str, jhh jhh, int i) {
        int i2 = this.O00000o;
        this.O00000o = i2 + 1;
        return new jhp.O000000o(i2, str, jhh, new jht(this.f1836O000000o, this.O00000o0, i));
    }

    public static jhf O000000o(jhf.O000000o o000000o, Object obj, Object obj2) {
        return new jhp(o000000o, obj, obj2, O0000O0o);
    }

    public static jhf O000000o(jhf.O000000o o000000o, Object obj, Object obj2, Object obj3) {
        return new jhp(o000000o, obj, obj2, new Object[]{obj3});
    }

    public static jhf O000000o(jhf.O000000o o000000o, Object obj, Object obj2, Object obj3, Object obj4) {
        return new jhp(o000000o, obj, obj2, new Object[]{obj3, obj4});
    }

    public static jhf O000000o(jhf.O000000o o000000o, Object obj, Object obj2, Object[] objArr) {
        return new jhp(o000000o, obj, obj2, objArr);
    }

    public final jhk O000000o(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int parseInt = Integer.parseInt(str, 16);
        Class O000000o2 = O000000o(str3, this.O00000Oo);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i = 0; i < countTokens; i++) {
            clsArr[i] = O000000o(stringTokenizer.nextToken(), this.O00000Oo);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str5, ":");
        int countTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[countTokens2];
        for (int i2 = 0; i2 < countTokens2; i2++) {
            strArr[i2] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str6, ":");
        int countTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[countTokens3];
        for (int i3 = 0; i3 < countTokens3; i3++) {
            clsArr2[i3] = O000000o(stringTokenizer3.nextToken(), this.O00000Oo);
        }
        return new jhr(parseInt, str2, O000000o2, clsArr, strArr, clsArr2, O000000o(str7, this.O00000Oo));
    }
}
