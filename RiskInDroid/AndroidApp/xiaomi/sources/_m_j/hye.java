package _m_j;

import android.os.Handler;
import android.util.Log;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.stat.report.StatLogCache;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class hye {
    private static volatile FileWriter O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    public StatLogCache f975O000000o;
    public ConcurrentLinkedQueue<String> O00000Oo;
    public AtomicInteger O00000o;
    public volatile boolean O00000o0;
    private Runnable O00000oo;

    public static final String O000000o(String str, String str2) {
        if (gfr.O0000OOo) {
            gsy.O000000o(4, str, str2);
            if (O00000oO == null) {
                String O000000o2 = StatLogCache.O000000o(CommonApplication.getAppContext());
                File file = new File(O000000o2 + "stat_temp.log");
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    synchronized (hye.class) {
                        if (O00000oO == null) {
                            O00000oO = new FileWriter(file);
                        }
                    }
                } catch (Exception e) {
                    Log.e("STAT-ERROR", "Failed to create temp file for stat log", e);
                }
            }
            if (O00000oO != null) {
                synchronized (hye.class) {
                    if (O00000oO != null) {
                        try {
                            O00000oO.append((CharSequence) str).append((CharSequence) ":").append((CharSequence) str2).append((CharSequence) "\r\n").flush();
                        } catch (Exception e2) {
                            Log.e("STAT-ERROR", "Failed to write temp file for stat log", e2);
                        }
                    }
                }
            }
        }
        return str2;
    }

    public hye() {
        this.f975O000000o = null;
        this.O00000Oo = new ConcurrentLinkedQueue<>();
        this.O00000o0 = false;
        this.O00000oo = new Runnable() {
            /* class _m_j.hye.AnonymousClass1 */

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
                if (r9.f976O000000o.O00000Oo.isEmpty() != false) goto L_0x0035;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
                r0 = r9.f976O000000o.O00000Oo.poll();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:14:0x002f, code lost:
                if (r0 == null) goto L_0x001b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
                r3.add(r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:16:0x0035, code lost:
                r2 = r3.isEmpty();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
                if (r2 == false) goto L_0x0044;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x003b, code lost:
                r0 = com.xiaomi.smarthome.stat.report.StatLogCache.O00000o0();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:19:0x003f, code lost:
                if (r0 == null) goto L_0x0044;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0041, code lost:
                r3.addAll(r0);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0049, code lost:
                if (r3.isEmpty() == false) goto L_0x005a;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x004b, code lost:
                r0 = r9.f976O000000o.f975O000000o.O000000o();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x0053, code lost:
                if (r0 != null) goto L_0x005b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:25:0x0055, code lost:
                r9.f976O000000o.O00000o0 = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:26:0x0059, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:27:0x005a, code lost:
                r0 = null;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:28:0x005b, code lost:
                r5 = r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:29:0x0060, code lost:
                if (r3.isEmpty() == false) goto L_0x0077;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:30:0x0062, code lost:
                r0 = ((_m_j.hyf) r5.second).O00000oO[((java.lang.Integer) r5.first).intValue()].O000000o();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:31:0x0077, code lost:
                r0 = _m_j.hye.O000000o(r3);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:32:0x007b, code lost:
                r7 = r0;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:33:0x0080, code lost:
                if (android.text.TextUtils.isEmpty(r7) == false) goto L_0x0087;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:34:0x0082, code lost:
                r9.f976O000000o.O00000o0 = false;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:35:0x0086, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:37:0x008f, code lost:
                if (r9.f976O000000o.O00000o.get() >= 0) goto L_0x00bd;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:38:0x0091, code lost:
                if (r2 != false) goto L_?;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:40:0x0097, code lost:
                if (r3.isEmpty() == false) goto L_0x009a;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:41:0x009a, code lost:
                r0 = r9.f976O000000o.f975O000000o.O00000Oo();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a2, code lost:
                if (r0 == null) goto L_?;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a4, code lost:
                r1 = r3.iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ac, code lost:
                if (r1.hasNext() == false) goto L_0x00bc;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ae, code lost:
                r0.O000000o(com.xiaomi.smarthome.application.CommonApplication.getAppContext(), (java.lang.String) r1.next());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
                r4 = r7;
                _m_j.fle.O000000o().O000000o(com.xiaomi.smarthome.application.CommonApplication.getAppContext(), r7, new _m_j.hye.AnonymousClass1.AnonymousClass1(r1));
             */
            /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d0, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d1, code lost:
                r0 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d2, code lost:
                r9.f976O000000o.O00000o0 = false;
                _m_j.hye.O000000o("STAT-FAILED-ERR", r0.getMessage() + "\r\n" + r7);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f3, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
                return;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
                return;
             */
            public final void run() {
                final LinkedList linkedList = new LinkedList();
                if (!hye.this.O00000o0) {
                    synchronized (this) {
                        if (!hye.this.O00000o0) {
                            hye.this.O00000o0 = true;
                        }
                    }
                }
            }
        };
        this.O00000o = new AtomicInteger(3);
        this.f975O000000o = new StatLogCache(CommonApplication.getAppContext());
        this.O00000oo.run();
    }

    public final void O000000o(String str) {
        if (str != null && str.length() > 2) {
            this.O00000Oo.offer(str);
            O000000o("STAT-SERVICE", str);
        }
        this.O00000oo.run();
    }

    public final void O000000o() {
        new Handler().postDelayed(this.O00000oo, 10);
    }

    public static String O000000o(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String next : list) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(next);
        }
        return sb.toString();
    }
}
