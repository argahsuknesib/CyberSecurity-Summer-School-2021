package _m_j;

import android.os.Handler;
import java.util.HashSet;
import java.util.Set;

public final class ckj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static ckj f13968O000000o = new ckj();
    private Set<String> O00000Oo = new HashSet();

    public static ckj O000000o() {
        return f13968O000000o;
    }

    public final void O000000o(Object obj, String str) {
        O000000o(obj.getClass().getSimpleName() + obj.hashCode(), str);
    }

    public final void O000000o(String str, String str2) {
        if (ckh.O00000o) {
            Set<String> set = this.O00000Oo;
            if (set.contains(str + str2)) {
                cki.O00000Oo(str, str2);
                return;
            }
            Set<String> set2 = this.O00000Oo;
            set2.add(str + str2);
            cki.O00000o(str, str2);
        }
    }

    public final void O00000Oo(String str, String str2) {
        if (ckh.O00000o && !this.O00000Oo.isEmpty()) {
            new Handler().postDelayed(new Runnable(str, str2) {
                /* class _m_j.$$Lambda$ckj$F7JZ7bYHe9HAu2pxPLRkpPSDVQ */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    ckj.this.O00000o0(this.f$1, this.f$2);
                }
            }, 1000);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(String str, String str2) {
        this.O00000Oo.clear();
        cki.O00000o(str, str2 + "clear");
    }
}
