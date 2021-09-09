package _m_j;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class jpk {
    private static final Pattern O00000Oo = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern O00000o0 = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f2022O000000o;
    private final String O00000o;
    private final String O00000oO;
    private final String O00000oo;

    private jpk(String str, String str2, String str3, String str4) {
        this.O00000o = str;
        this.O00000oO = str2;
        this.O00000oo = str3;
        this.f2022O000000o = str4;
    }

    public static jpk O000000o(String str) {
        Matcher matcher = O00000Oo.matcher(str);
        if (!matcher.lookingAt()) {
            return null;
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        Matcher matcher2 = O00000o0.matcher(str);
        String str2 = null;
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                return null;
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase("charset")) {
                String group2 = matcher2.group(2) != null ? matcher2.group(2) : matcher2.group(3);
                if (str2 == null || group2.equalsIgnoreCase(str2)) {
                    str2 = group2;
                } else {
                    throw new IllegalArgumentException("Multiple different charsets: ".concat(String.valueOf(str)));
                }
            }
        }
        return new jpk(str, lowerCase, lowerCase2, str2);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof jpk) && ((jpk) obj).O00000o.equals(this.O00000o);
    }

    public final int hashCode() {
        return this.O00000o.hashCode();
    }

    public final String toString() {
        return this.O00000o;
    }
}
