package _m_j;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;

final class byc extends bxt {
    private static final LinkedHashMap<Long, String> O00000o = new LinkedHashMap<>();
    private int O00000oO;
    private Thread O00000oo;

    public byc(Thread thread, long j) {
        this(thread, j, (byte) 0);
    }

    private byc(Thread thread, long j, byte b) {
        super(j);
        this.O00000oO = 100;
        this.O00000oo = thread;
        this.O00000oO = 100;
    }

    public static ArrayList<String> O000000o(long j, long j2) {
        ArrayList<String> arrayList = new ArrayList<>();
        synchronized (O00000o) {
            for (Long next : O00000o.keySet()) {
                if (j < next.longValue() && next.longValue() < j2) {
                    arrayList.add(O00000o.get(next) + "\r\n");
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public final void O00000o0() {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : this.O00000oo.getStackTrace()) {
            if (!TextUtils.isEmpty(stackTraceElement.toString())) {
                sb.append(stackTraceElement.toString());
                sb.append("\r\n");
            }
        }
        synchronized (O00000o) {
            if (O00000o.size() == this.O00000oO && this.O00000oO > 0) {
                LinkedHashMap<Long, String> linkedHashMap = O00000o;
                linkedHashMap.remove(linkedHashMap.keySet().iterator().next());
            }
            O00000o.put(Long.valueOf(System.currentTimeMillis()), sb.toString());
        }
    }
}
