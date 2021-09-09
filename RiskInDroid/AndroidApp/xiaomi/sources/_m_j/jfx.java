package _m_j;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;

abstract class jfx implements jfm {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f1806O000000o = true;
    static String[] O0000OoO = new String[0];
    static Class[] O0000Ooo = new Class[0];
    private String O00000Oo;
    int O00000oO = -1;
    String O00000oo;
    String O0000O0o;
    Class O0000OOo;
    ClassLoader O0000Oo = null;
    O000000o O0000Oo0;

    interface O000000o {
        String O000000o(int i);

        void O000000o(int i, String str);
    }

    /* access modifiers changed from: protected */
    public abstract String O000000o(jfz jfz);

    jfx(int i, String str, Class cls) {
        this.O00000oO = i;
        this.O00000oo = str;
        this.O0000OOo = cls;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0026  */
    public final String O00000Oo(jfz jfz) {
        String str;
        if (f1806O000000o) {
            O000000o o000000o = this.O0000Oo0;
            if (o000000o == null) {
                try {
                    this.O0000Oo0 = new O00000Oo();
                } catch (Throwable unused) {
                    f1806O000000o = false;
                }
            } else {
                str = o000000o.O000000o(jfz.O0000Oo0);
                if (str == null) {
                    str = O000000o(jfz);
                }
                if (f1806O000000o) {
                    this.O0000Oo0.O000000o(jfz.O0000Oo0, str);
                }
                return str;
            }
        }
        str = null;
        if (str == null) {
        }
        if (f1806O000000o) {
        }
        return str;
    }

    public final String toString() {
        return O00000Oo(jfz.O0000OoO);
    }

    public final Class O00000o0() {
        if (this.O0000OOo == null) {
            this.O0000OOo = O00000Oo(2);
        }
        return this.O0000OOo;
    }

    private ClassLoader O000000o() {
        if (this.O0000Oo == null) {
            this.O0000Oo = getClass().getClassLoader();
        }
        return this.O0000Oo;
    }

    /* access modifiers changed from: package-private */
    public final String O000000o(int i) {
        int indexOf = this.O00000Oo.indexOf(45);
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.O00000Oo.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.O00000Oo.length();
        }
        return this.O00000Oo.substring(i2, indexOf);
    }

    /* access modifiers changed from: package-private */
    public final Class O00000Oo(int i) {
        return jft.O000000o(O000000o(i), O000000o());
    }

    /* access modifiers changed from: package-private */
    public final Class[] O00000o0(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(O000000o(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = jft.O000000o(stringTokenizer.nextToken(), O000000o());
        }
        return clsArr;
    }

    static final class O00000Oo implements O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private SoftReference f1807O000000o;

        public O00000Oo() {
            O00000Oo();
        }

        public final String O000000o(int i) {
            String[] O000000o2 = O000000o();
            if (O000000o2 == null) {
                return null;
            }
            return O000000o2[i];
        }

        public final void O000000o(int i, String str) {
            String[] O000000o2 = O000000o();
            if (O000000o2 == null) {
                O000000o2 = O00000Oo();
            }
            O000000o2[i] = str;
        }

        private String[] O000000o() {
            return (String[]) this.f1807O000000o.get();
        }

        private String[] O00000Oo() {
            String[] strArr = new String[3];
            this.f1807O000000o = new SoftReference(strArr);
            return strArr;
        }
    }
}
