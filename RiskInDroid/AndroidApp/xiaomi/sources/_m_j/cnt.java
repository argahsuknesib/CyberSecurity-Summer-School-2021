package _m_j;

import android.graphics.Bitmap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public final class cnt implements cns {

    /* renamed from: O000000o  reason: collision with root package name */
    private final cns f14153O000000o;
    private final Comparator<String> O00000Oo;

    public cnt(cns cns, Comparator<String> comparator) {
        this.f14153O000000o = cns;
        this.O00000Oo = comparator;
    }

    public final boolean O000000o(String str, Bitmap bitmap) {
        synchronized (this.f14153O000000o) {
            String str2 = null;
            Iterator<String> it = this.f14153O000000o.O000000o().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (this.O00000Oo.compare(str, next) == 0) {
                    str2 = next;
                    break;
                }
            }
            if (str2 != null) {
                this.f14153O000000o.O00000Oo(str2);
            }
        }
        return this.f14153O000000o.O000000o(str, bitmap);
    }

    public final Bitmap O000000o(String str) {
        return this.f14153O000000o.O000000o(str);
    }

    public final Bitmap O00000Oo(String str) {
        return this.f14153O000000o.O00000Oo(str);
    }

    public final Collection<String> O000000o() {
        return this.f14153O000000o.O000000o();
    }
}
