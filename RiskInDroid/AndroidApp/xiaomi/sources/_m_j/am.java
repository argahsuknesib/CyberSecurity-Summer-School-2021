package _m_j;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

public final class am {
    private static final am O00000Oo = O000000o(new Locale[0]);

    /* renamed from: O000000o  reason: collision with root package name */
    public ao f12449O000000o;

    private am(ao aoVar) {
        this.f12449O000000o = aoVar;
    }

    public static am O000000o(LocaleList localeList) {
        return new am(new ap(localeList));
    }

    public static am O000000o(Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return O000000o(new LocaleList(localeArr));
        }
        return new am(new an(localeArr));
    }

    static Locale O000000o(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (!str.contains("_")) {
            return new Locale(str);
        } else {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public final boolean equals(Object obj) {
        return (obj instanceof am) && this.f12449O000000o.equals(((am) obj).f12449O000000o);
    }

    public final int hashCode() {
        return this.f12449O000000o.hashCode();
    }

    public final String toString() {
        return this.f12449O000000o.toString();
    }
}
