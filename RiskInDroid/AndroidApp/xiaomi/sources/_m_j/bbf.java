package _m_j;

import com.iheartradio.m3u8.ParseException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

abstract class bbf implements bbj {

    /* renamed from: O000000o  reason: collision with root package name */
    static final bbj f12764O000000o = new bbf() {
        /* class _m_j.bbf.AnonymousClass1 */

        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            return false;
        }

        public final String O00000Oo() {
            return "EXTM3U";
        }
    };
    static final bbj O00000Oo = new bbf() {
        /* class _m_j.bbf.AnonymousClass2 */

        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            return true;
        }

        public final String O00000Oo() {
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0039 A[LOOP:0: B:13:0x0033->B:15:0x0039, LOOP_END] */
        public final void O000000o(bcc bcc, bcn bcn) throws IOException {
            List<String> list;
            if (bcn.O000000o()) {
                if (bcn.f12862O000000o.O00000o.size() > 0) {
                    list = bcn.f12862O000000o.O00000o;
                    for (String O000000o2 : list) {
                        bcc.O000000o(O000000o2);
                    }
                }
            }
            if (!bcn.O00000Oo.O00000Oo.isEmpty()) {
                list = bcn.O00000Oo.O00000Oo;
            } else {
                list = Collections.emptyList();
            }
            while (r4.hasNext()) {
            }
        }
    };
    static final bbj O00000o0 = new bbf() {
        /* class _m_j.bbf.AnonymousClass3 */

        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            return true;
        }

        public final String O00000Oo() {
            return "EXT-X-VERSION";
        }

        public final void O000000o(bcc bcc, bcn bcn) throws IOException {
            bcc.O000000o("EXT-X-VERSION", Integer.toString(bcn.O00000o));
        }
    };

    /* access modifiers changed from: package-private */
    public abstract boolean O000000o();

    bbf() {
    }

    public void O000000o(bcc bcc, bcn bcn) throws IOException, ParseException {
        if (!O000000o()) {
            bcc.O00000Oo(O00000Oo());
        }
    }

    /* access modifiers changed from: package-private */
    public final <T> void O000000o(bcc bcc, T t, Map<String, ? extends bbb<T>> map) throws IOException, ParseException {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : map.entrySet()) {
            bbb bbb = (bbb) next.getValue();
            String str = (String) next.getKey();
            if (bbb.O00000Oo(t)) {
                String O000000o2 = bbb.O000000o(t);
                sb.append(str);
                sb.append("=");
                sb.append(O000000o2);
                sb.append(bbd.O00000Oo);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        bcc.O000000o(O00000Oo(), sb.toString());
    }
}
