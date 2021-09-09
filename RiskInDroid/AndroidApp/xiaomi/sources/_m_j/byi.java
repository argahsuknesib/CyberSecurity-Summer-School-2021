package _m_j;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class byi {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final List<String> f13408O000000o = new LinkedList();
    private static final List<String> O00000Oo = new LinkedList();

    static {
        f13408O000000o.addAll(bxw.O00000Oo().O00000o0());
        if (bxw.O00000Oo().O00000Oo() != null) {
            O00000Oo.addAll(bxw.O00000Oo().O00000Oo());
        }
        if (O00000Oo.isEmpty()) {
            O00000Oo.add(byg.O000000o());
        }
    }

    public static String O000000o(bye bye) {
        String str;
        Iterator<String> it = bye.O0000o0O.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (Character.isLetter(next.charAt(0))) {
                String[] split = next.split("\r\n");
                for (String str2 : split) {
                    Iterator<String> it2 = O00000Oo.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (str2.startsWith(it2.next())) {
                                str = O000000o(str2);
                                break;
                            }
                        } else {
                            str = null;
                            break;
                        }
                    }
                    if (str != null) {
                        return str;
                    }
                }
                return O000000o(split[0]);
            }
        }
        return "";
    }

    public static boolean O00000Oo(bye bye) {
        if (!(!TextUtils.isEmpty(bye.O0000OoO)) || bye.O0000Oo0 < 0) {
            return false;
        }
        return true;
    }

    public static boolean O00000o0(bye bye) {
        Iterator<String> it = bye.O0000o0O.iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            String next = it.next();
            if (Character.isLetter(next.charAt(0))) {
                for (String str : next.split("\r\n")) {
                    for (String startsWith : f13408O000000o) {
                        if (str.startsWith(startsWith)) {
                            return true;
                        }
                    }
                }
                continue;
            }
        }
    }

    public static List<String> O000000o() {
        return O00000Oo;
    }

    private static String O000000o(String str) {
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(41);
        return (indexOf < 0 || indexOf2 < 0) ? str : str.substring(indexOf + 1, indexOf2);
    }
}
