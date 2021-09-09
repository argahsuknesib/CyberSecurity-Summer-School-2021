package _m_j;

import java.util.Iterator;

public final class xp {
    public static String O000000o(Iterable<? extends CharSequence> iterable, String str) {
        int length = str.length();
        Iterator<? extends CharSequence> it = iterable.iterator();
        int i = 0;
        if (it.hasNext()) {
            i = 0 + ((CharSequence) it.next()).length() + length;
        }
        StringBuilder sb = new StringBuilder(i);
        Iterator<? extends CharSequence> it2 = iterable.iterator();
        if (it2.hasNext()) {
            sb.append((CharSequence) it2.next());
            while (it2.hasNext()) {
                sb.append(str);
                sb.append((CharSequence) it2.next());
            }
        }
        return sb.toString();
    }
}
