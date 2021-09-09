package _m_j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class brk {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final List<String> f13219O000000o;

    private static boolean O00000Oo(String str, String str2, int i) {
        try {
            if (str.length() > i) {
                str = str.substring(0, i);
            }
            return str.equals(new String(str.getBytes(str2), str2));
        } catch (Throwable unused) {
            return false;
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        f13219O000000o = arrayList;
        arrayList.add("ISO-8859-1");
        f13219O000000o.add("GB2312");
        f13219O000000o.add("GBK");
        f13219O000000o.add("GB18030");
        f13219O000000o.add("US-ASCII");
        f13219O000000o.add("ASCII");
        f13219O000000o.add("ISO-2022-KR");
        f13219O000000o.add("ISO-8859-2");
        f13219O000000o.add("ISO-2022-JP");
        f13219O000000o.add("ISO-2022-JP-2");
        f13219O000000o.add("UTF-8");
    }

    public static String O000000o(String str, String str2, int i) {
        String str3 = "ISO-8859-1";
        try {
            Iterator<String> it = f13219O000000o.iterator();
            while (true) {
                if (it.hasNext()) {
                    String next = it.next();
                    if (O00000Oo(str, next, i)) {
                        str3 = next;
                        break;
                    }
                } else {
                    break;
                }
            }
            return new String(str.getBytes(str3), str2);
        } catch (Throwable th) {
            brm.O000000o(th);
            return str;
        }
    }
}
