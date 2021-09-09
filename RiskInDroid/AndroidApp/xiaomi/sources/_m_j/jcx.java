package _m_j;

import java.io.PrintStream;
import java.util.ArrayList;

public final class jcx {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f1769O000000o = O00000o0("awt.toolkit");
    public static final String O00000Oo = O00000o0("file.encoding");
    public static final String O00000o = O00000o0("java.awt.fonts");
    public static final String O00000o0 = O00000o0("file.separator");
    public static final String O00000oO = O00000o0("java.awt.graphicsenv");
    public static final String O00000oo = O00000o0("java.awt.headless");
    public static final String O0000O0o = O00000o0("java.awt.printerjob");
    public static final String O0000OOo = O00000o0("java.class.path");
    public static final String O0000Oo = O00000o0("java.compiler");
    public static final String O0000Oo0 = O00000o0("java.class.version");
    public static final String O0000OoO = O00000o0("java.endorsed.dirs");
    public static final String O0000Ooo = O00000o0("java.ext.dirs");
    public static final String O0000o = O00000o0("java.runtime.version");
    public static final String O0000o0 = O00000o0("java.io.tmpdir");
    public static final String O0000o00 = O00000o0("java.home");
    public static final String O0000o0O = O00000o0("java.library.path");
    public static final String O0000o0o = O00000o0("java.runtime.name");
    public static final String O0000oO = O00000o0("java.specification.vendor");
    public static final String O0000oO0 = O00000o0("java.specification.name");
    public static final String O0000oOO = O00000o0("java.specification.version");
    public static final String O0000oOo = O00000o0("java.util.prefs.PreferencesFactory");
    public static final String O0000oo = O00000o0("java.vendor.url");
    public static final String O0000oo0 = O00000o0("java.vendor");
    public static final String O0000ooO = O00000o0("java.version");
    public static final String O0000ooo = O00000o0("java.vm.info");
    public static final String O000O00o = O00000o0("java.vm.specification.vendor");
    public static final String O000O0OO = O00000o0("java.vm.specification.version");
    public static final String O000O0Oo = O00000o0("java.vm.vendor");
    public static final String O000O0o = O00000o0("os.arch");
    public static final String O000O0o0 = O00000o0("line.separator");
    public static final String O000O0oO = O00000o0("os.name");
    public static final String O000O0oo = O00000o0("os.version");
    public static final String O000OO = O00000o0("user.dir");
    public static final String O000OO00 = O00000o0("path.separator");
    public static final String O000OO0o;
    public static final String O000OOOo = O00000o0("user.home");
    public static final String O000OOo = O00000o0("user.name");
    public static final String O000OOo0 = O00000o0("user.language");
    public static final String O000OOoO = O00000o0("user.timezone");
    public static final String O000OOoo;
    public static final int O000Oo0;
    public static final float O000Oo00 = O000000o(O00000o(O0000ooO));
    public static final boolean O000Oo0O = O000000o("1.1");
    public static final boolean O000Oo0o = O000000o("1.2");
    public static final boolean O000OoO = O000000o("1.5");
    public static final boolean O000OoO0 = O000000o("1.3");
    public static final boolean O000OoOO = O000000o("1.6");
    public static final boolean O000OoOo = O000000o("1.7");
    public static final boolean O000Ooo = O00000Oo("HP-UX");
    public static final boolean O000Ooo0 = O00000Oo("AIX");
    public static final boolean O000OooO = O00000Oo("Irix");
    public static final boolean O000Oooo = (O00000Oo("Linux") || O00000Oo("LINUX"));
    public static final boolean O000o = O000000o("Windows", "5.1");
    public static final boolean O000o0 = O00000Oo("SunOS");
    public static final boolean O000o00 = O00000Oo("Mac OS X");
    public static final boolean O000o000 = O00000Oo("Mac");
    public static final boolean O000o00O = O00000Oo("OS/2");
    public static final boolean O000o00o = O00000Oo("Solaris");
    public static final boolean O000o0O = O00000Oo("Windows");
    public static final boolean O000o0O0;
    public static final boolean O000o0OO = O000000o("Windows", "5.0");
    public static final boolean O000o0Oo = O000000o("Windows 9", "4.0");
    public static final boolean O000o0o = O000000o("Windows", "4.9");
    public static final boolean O000o0o0 = O000000o("Windows 9", "4.1");
    public static final boolean O000o0oo = O00000Oo("Windows NT");
    public static final boolean O000oO0 = O000000o("Windows", "6.1");
    public static final boolean O000oO00 = O000000o("Windows", "6.0");
    public static final boolean O00O0Oo = O000000o("1.4");
    public static final String O00oOoOo = O00000o0("java.vm.version");
    public static final String O00oOooO = O00000o0("java.vm.name");
    public static final String O00oOooo = O00000o0("java.vm.specification.name");

    static {
        String str;
        int i;
        String str2 = "user.country";
        if (O00000o0(str2) == null) {
            str2 = "user.region";
        }
        O000OO0o = O00000o0(str2);
        boolean z = false;
        if (O0000ooO != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= O0000ooO.length()) {
                    break;
                }
                char charAt = O0000ooO.charAt(i2);
                if (charAt >= '0' && charAt <= '9') {
                    str = O0000ooO.substring(i2);
                    break;
                }
                i2++;
            }
        }
        str = null;
        O000OOoo = str;
        int[] O00000o2 = O00000o(O0000ooO);
        if (O00000o2 == null) {
            i = 0;
        } else {
            int length = O00000o2.length;
            i = length > 0 ? O00000o2[0] * 100 : 0;
            if (length >= 2) {
                i += O00000o2[1] * 10;
            }
            if (length >= 3) {
                i += O00000o2[2];
            }
        }
        O000Oo0 = i;
        if (O000Ooo0 || O000Ooo || O000OooO || O000Oooo || O000o00 || O000o00o || O000o0) {
            z = true;
        }
        O000o0O0 = z;
    }

    private static boolean O000000o(String str) {
        String str2 = O000OOoo;
        if (str2 == null) {
            return false;
        }
        return str2.startsWith(str);
    }

    private static boolean O000000o(String str, String str2) {
        String str3 = O000O0oO;
        String str4 = O000O0oo;
        return str3 != null && str4 != null && str3.startsWith(str) && str4.startsWith(str2);
    }

    private static boolean O00000Oo(String str) {
        String str2 = O000O0oO;
        if (str2 == null) {
            return false;
        }
        return str2.startsWith(str);
    }

    private static String O00000o0(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer("Caught a SecurityException reading the system property '");
            stringBuffer.append(str);
            stringBuffer.append("'; the SystemUtils property value will default to null.");
            printStream.println(stringBuffer.toString());
            return null;
        }
    }

    private static int[] O00000o(String str) {
        String[] strArr;
        if (str == null) {
            return jcv.O00000oo;
        }
        if (str == null) {
            strArr = null;
        } else {
            int length = str.length();
            if (length == 0) {
                strArr = jcv.O00000o0;
            } else {
                ArrayList arrayList = new ArrayList();
                int i = 0;
                boolean z = false;
                int i2 = 0;
                int i3 = 1;
                while (i < length) {
                    if ("._- ".indexOf(str.charAt(i)) >= 0) {
                        if (z) {
                            int i4 = i3 + 1;
                            if (i3 == -1) {
                                i = length;
                            }
                            arrayList.add(str.substring(i2, i));
                            i3 = i4;
                            z = false;
                        }
                        i2 = i + 1;
                        i = i2;
                    } else {
                        i++;
                        z = true;
                    }
                }
                if (z) {
                    arrayList.add(str.substring(i2, i));
                }
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
        }
        int[] iArr = new int[Math.min(3, strArr.length)];
        int i5 = 0;
        for (int i6 = 0; i6 < strArr.length && i5 < 3; i6++) {
            String str2 = strArr[i6];
            if (str2.length() > 0) {
                try {
                    iArr[i5] = Integer.parseInt(str2);
                    i5++;
                } catch (Exception unused) {
                }
            }
        }
        if (iArr.length <= i5) {
            return iArr;
        }
        int[] iArr2 = new int[i5];
        System.arraycopy(iArr, 0, iArr2, 0, i5);
        return iArr2;
    }

    private static float O000000o(int[] iArr) {
        if (!(iArr == null || iArr.length == 0)) {
            if (iArr.length == 1) {
                return (float) iArr[0];
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(iArr[0]);
            stringBuffer.append('.');
            for (int i = 1; i < iArr.length; i++) {
                stringBuffer.append(iArr[i]);
            }
            try {
                return Float.parseFloat(stringBuffer.toString());
            } catch (Exception unused) {
            }
        }
        return 0.0f;
    }
}
