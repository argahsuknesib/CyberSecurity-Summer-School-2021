package _m_j;

import com.xiaomi.smarthome.application.ServiceApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public final class ges {

    /* renamed from: O000000o  reason: collision with root package name */
    public static ges f17603O000000o;
    public Map<String, List<guu>> O00000Oo = new WeakHashMap();
    public Map<String, gus> O00000o0 = new WeakHashMap();

    public static ges O000000o() {
        if (f17603O000000o == null) {
            f17603O000000o = new ges();
        }
        return f17603O000000o;
    }

    private ges() {
    }

    public final void O000000o(String str) {
        this.O00000o0.remove(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r3.O00000Oo.get(r4);
     */
    public final void O00000Oo(final String str) {
        final List list;
        if (this.O00000Oo.containsKey(str) && list != null) {
            ServiceApplication.getGlobalHandler().post(new Runnable() {
                /* class _m_j.ges.AnonymousClass1 */

                public final void run() {
                    gus gus;
                    boolean z = false;
                    for (int i = 0; i < list.size(); i++) {
                        guu guu = (guu) list.get(i);
                        if (guu != null) {
                            z |= guu.O000000o(str);
                        }
                    }
                    if (ges.this.O00000o0.containsKey(str) && (gus = ges.this.O00000o0.get(str)) != null) {
                        gus.showRedPoint(z);
                    }
                }
            });
        }
    }

    public final void O000000o(String str, guu guu) {
        List list = this.O00000Oo.get(str);
        if (list == null) {
            list = new ArrayList();
        }
        list.add(guu);
        this.O00000Oo.put(str, list);
        O00000Oo(str);
    }
}
