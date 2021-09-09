package _m_j;

import android.util.Pair;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class epo {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Vector<Pair<String, Long>> f15706O000000o = new Vector<>();
    private static ConcurrentHashMap<String, Long> O00000Oo = new ConcurrentHashMap<>();

    public static String O000000o() {
        StringBuilder sb = new StringBuilder();
        synchronized (f15706O000000o) {
            for (int i = 0; i < f15706O000000o.size(); i++) {
                Pair elementAt = f15706O000000o.elementAt(i);
                sb.append((String) elementAt.first);
                sb.append(":");
                sb.append(elementAt.second);
                if (i < f15706O000000o.size() - 1) {
                    sb.append(";");
                }
            }
            f15706O000000o.clear();
        }
        return sb.toString();
    }
}
