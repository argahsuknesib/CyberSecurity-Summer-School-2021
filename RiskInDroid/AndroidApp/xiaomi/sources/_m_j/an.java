package _m_j;

import java.util.HashSet;
import java.util.Locale;

final class an implements ao {
    private static final Locale O00000o = new Locale("en", "XA");
    private static final Locale[] O00000o0 = new Locale[0];
    private static final Locale O00000oO = new Locale("ar", "XB");
    private static final Locale O00000oo = am.O000000o("en-Latn");

    /* renamed from: O000000o  reason: collision with root package name */
    private final Locale[] f12475O000000o;
    private final String O00000Oo;

    public final Object O000000o() {
        return null;
    }

    public final Locale O000000o(int i) {
        Locale[] localeArr = this.f12475O000000o;
        if (localeArr.length > 0) {
            return localeArr[0];
        }
        return null;
    }

    public final boolean O00000Oo() {
        return this.f12475O000000o.length == 0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof an)) {
            return false;
        }
        Locale[] localeArr = ((an) obj).f12475O000000o;
        if (this.f12475O000000o.length != localeArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            Locale[] localeArr2 = this.f12475O000000o;
            if (i >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
            i++;
        }
    }

    public final int hashCode() {
        int i = 1;
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.f12475O000000o;
            if (i2 >= localeArr.length) {
                return i;
            }
            i = (i * 31) + localeArr[i2].hashCode();
            i2++;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i = 0;
        while (true) {
            Locale[] localeArr = this.f12475O000000o;
            if (i < localeArr.length) {
                sb.append(localeArr[i]);
                if (i < this.f12475O000000o.length - 1) {
                    sb.append(',');
                }
                i++;
            } else {
                sb.append("]");
                return sb.toString();
            }
        }
    }

    an(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f12475O000000o = O00000o0;
            this.O00000Oo = "";
            return;
        }
        Locale[] localeArr2 = new Locale[localeArr.length];
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < localeArr.length) {
            Locale locale = localeArr[i];
            if (locale == null) {
                throw new NullPointerException("list[" + i + "] is null");
            } else if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                localeArr2[i] = locale2;
                sb.append(locale2.getLanguage());
                String country = locale2.getCountry();
                if (country != null && !country.isEmpty()) {
                    sb.append('-');
                    sb.append(locale2.getCountry());
                }
                if (i < localeArr.length - 1) {
                    sb.append(',');
                }
                hashSet.add(locale2);
                i++;
            } else {
                throw new IllegalArgumentException("list[" + i + "] is a repetition");
            }
        }
        this.f12475O000000o = localeArr2;
        this.O00000Oo = sb.toString();
    }
}
