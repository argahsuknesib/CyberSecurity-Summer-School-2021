package _m_j;

import android.os.LocaleList;
import java.util.Locale;

final class ap implements ao {

    /* renamed from: O000000o  reason: collision with root package name */
    private final LocaleList f12511O000000o;

    ap(LocaleList localeList) {
        this.f12511O000000o = localeList;
    }

    public final Object O000000o() {
        return this.f12511O000000o;
    }

    public final Locale O000000o(int i) {
        return this.f12511O000000o.get(0);
    }

    public final boolean O00000Oo() {
        return this.f12511O000000o.isEmpty();
    }

    public final boolean equals(Object obj) {
        return this.f12511O000000o.equals(((ao) obj).O000000o());
    }

    public final int hashCode() {
        return this.f12511O000000o.hashCode();
    }

    public final String toString() {
        return this.f12511O000000o.toString();
    }
}
