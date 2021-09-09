package _m_j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ss.q;

public final class jpd {
    private static final Pattern O00000o = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern O00000o0 = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern O00000oO = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern O00000oo = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f2015O000000o;
    public final String O00000Oo;
    private final long O0000O0o;
    private final String O0000OOo;
    private final boolean O0000Oo;
    private final String O0000Oo0;
    private final boolean O0000OoO;
    private final boolean O0000Ooo;
    private final boolean O0000o00;

    private jpd(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f2015O000000o = str;
        this.O00000Oo = str2;
        this.O0000O0o = j;
        this.O0000OOo = str3;
        this.O0000Oo0 = str4;
        this.O0000Oo = z;
        this.O0000OoO = z2;
        this.O0000o00 = z3;
        this.O0000Ooo = z4;
    }

    private static int O000000o(String str, int i, int i2, boolean z) {
        while (i < i2) {
            char charAt = str.charAt(i);
            if (((charAt < ' ' && charAt != 9) || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static long O000000o(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof jpd)) {
            return false;
        }
        jpd jpd = (jpd) obj;
        return jpd.f2015O000000o.equals(this.f2015O000000o) && jpd.O00000Oo.equals(this.O00000Oo) && jpd.O0000OOo.equals(this.O0000OOo) && jpd.O0000Oo0.equals(this.O0000Oo0) && jpd.O0000O0o == this.O0000O0o && jpd.O0000Oo == this.O0000Oo && jpd.O0000OoO == this.O0000OoO && jpd.O0000Ooo == this.O0000Ooo && jpd.O0000o00 == this.O0000o00;
    }

    public final int hashCode() {
        long j = this.O0000O0o;
        return ((((((((((((((((this.f2015O000000o.hashCode() + 527) * 31) + this.O00000Oo.hashCode()) * 31) + this.O0000OOo.hashCode()) * 31) + this.O0000Oo0.hashCode()) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + (this.O0000Oo ^ true ? 1 : 0)) * 31) + (this.O0000OoO ^ true ? 1 : 0)) * 31) + (this.O0000Ooo ^ true ? 1 : 0)) * 31) + (this.O0000o00 ^ true ? 1 : 0);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2015O000000o);
        sb.append('=');
        sb.append(this.O00000Oo);
        if (this.O0000Ooo) {
            if (this.O0000O0o == Long.MIN_VALUE) {
                str = "; max-age=0";
            } else {
                sb.append("; expires=");
                str = jpx.O000000o(new Date(this.O0000O0o));
            }
            sb.append(str);
        }
        if (!this.O0000o00) {
            sb.append("; domain=");
            sb.append(this.O0000OOo);
        }
        sb.append("; path=");
        sb.append(this.O0000Oo0);
        if (this.O0000Oo) {
            sb.append("; secure");
        }
        if (this.O0000OoO) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jqp.O000000o(java.lang.String, int, int, char):int
     arg types: [java.lang.String, int, int, int]
     candidates:
      _m_j.jqp.O000000o(java.lang.String, int, int, java.lang.String):int
      _m_j.jqp.O000000o(java.lang.String, int, int, char):int */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x025c, code lost:
        if (r1 > 253402300799999L) goto L_0x0264;
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x02bc  */
    private static jpd O000000o(long j, q qVar, String str) {
        long j2;
        String str2;
        String str3;
        String str4;
        String str5;
        int lastIndexOf;
        q qVar2 = qVar;
        String str6 = str;
        int length = str.length();
        char c = ';';
        boolean z = false;
        int O000000o2 = jqp.O000000o(str6, 0, length, ';');
        char c2 = '=';
        int O000000o3 = jqp.O000000o(str6, 0, O000000o2, '=');
        if (O000000o3 == O000000o2) {
            return null;
        }
        String O00000o02 = jqp.O00000o0(str6, 0, O000000o3);
        if (O00000o02.isEmpty()) {
            return null;
        }
        boolean z2 = true;
        String O00000o03 = jqp.O00000o0(str6, O000000o3 + 1, O000000o2);
        int i = O000000o2 + 1;
        String str7 = null;
        String str8 = null;
        long j3 = -1;
        long j4 = 253402300799999L;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = false;
        while (i < length) {
            int O000000o4 = jqp.O000000o(str6, i, length, c);
            int O000000o5 = jqp.O000000o(str6, i, O000000o4, c2);
            String O00000o04 = jqp.O00000o0(str6, i, O000000o5);
            String O00000o05 = O000000o5 < O000000o4 ? jqp.O00000o0(str6, O000000o5 + 1, O000000o4) : "";
            if (O00000o04.equalsIgnoreCase("expires")) {
                try {
                    int length2 = O00000o05.length();
                    int O000000o6 = O000000o(O00000o05, z ? 1 : 0, length2, z);
                    Matcher matcher = O00000oo.matcher(O00000o05);
                    int i2 = -1;
                    int i3 = -1;
                    int i4 = -1;
                    int i5 = -1;
                    int i6 = -1;
                    int i7 = -1;
                    while (O000000o6 < length2) {
                        int O000000o7 = O000000o(O00000o05, O000000o6 + 1, length2, z2);
                        matcher.region(O000000o6, O000000o7);
                        if (i3 != -1 || !matcher.usePattern(O00000oo).matches()) {
                            int i8 = i5;
                            if (i8 != -1 || !matcher.usePattern(O00000oO).matches()) {
                                int i9 = i4;
                                int i10 = -1;
                                if (i9 == -1) {
                                    if (matcher.usePattern(O00000o).matches()) {
                                        i4 = O00000o.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                                    } else {
                                        i10 = -1;
                                    }
                                }
                                if (i2 == i10 && matcher.usePattern(O00000o0).matches()) {
                                    i2 = Integer.parseInt(matcher.group(1));
                                }
                                i5 = i8;
                                i4 = i9;
                            } else {
                                i8 = Integer.parseInt(matcher.group(1));
                            }
                            i5 = i8;
                        } else {
                            i3 = Integer.parseInt(matcher.group(z2 ? 1 : 0));
                            i6 = Integer.parseInt(matcher.group(2));
                            i7 = Integer.parseInt(matcher.group(3));
                        }
                        O000000o6 = O000000o(O00000o05, O000000o7 + 1, length2, false);
                        z2 = true;
                    }
                    int i11 = i4;
                    int i12 = i5;
                    if (i2 >= 70 && i2 <= 99) {
                        i2 += 1900;
                    }
                    if (i2 >= 0 && i2 <= 69) {
                        i2 += 2000;
                    }
                    if (i2 < 1601) {
                        throw new IllegalArgumentException();
                    } else if (i11 == -1) {
                        throw new IllegalArgumentException();
                    } else if (i12 <= 0 || i12 > 31) {
                        throw new IllegalArgumentException();
                    } else if (i3 < 0 || i3 > 23) {
                        throw new IllegalArgumentException();
                    } else {
                        int i13 = i6;
                        if (i13 >= 0) {
                            if (i13 <= 59) {
                                int i14 = i7;
                                if (i14 < 0 || i14 > 59) {
                                    throw new IllegalArgumentException();
                                }
                                try {
                                    GregorianCalendar gregorianCalendar = new GregorianCalendar(jqp.O00000o);
                                    gregorianCalendar.setLenient(false);
                                    gregorianCalendar.set(1, i2);
                                    gregorianCalendar.set(2, i11 - 1);
                                    gregorianCalendar.set(5, i12);
                                    gregorianCalendar.set(11, i3);
                                    gregorianCalendar.set(12, i13);
                                    gregorianCalendar.set(13, i14);
                                    gregorianCalendar.set(14, 0);
                                    j4 = gregorianCalendar.getTimeInMillis();
                                } catch (IllegalArgumentException unused) {
                                }
                            }
                        }
                        throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException unused2) {
                }
            } else if (O00000o04.equalsIgnoreCase("max-age")) {
                j3 = O000000o(O00000o05);
            } else {
                if (O00000o04.equalsIgnoreCase("domain")) {
                    if (!O00000o05.endsWith(".")) {
                        if (O00000o05.startsWith(".")) {
                            O00000o05 = O00000o05.substring(1);
                        }
                        String O00000Oo2 = jqp.O00000Oo(O00000o05);
                        if (O00000Oo2 != null) {
                            str7 = O00000Oo2;
                            z5 = false;
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else if (O00000o04.equalsIgnoreCase("path")) {
                    str8 = O00000o05;
                } else if (O00000o04.equalsIgnoreCase("secure")) {
                    z3 = true;
                } else if (O00000o04.equalsIgnoreCase("httponly")) {
                    z4 = true;
                }
                i = O000000o4 + 1;
                str6 = str;
                c = ';';
                z = false;
                c2 = '=';
                z2 = true;
            }
            z6 = true;
            i = O000000o4 + 1;
            str6 = str;
            c = ';';
            z = false;
            c2 = '=';
            z2 = true;
        }
        long j5 = Long.MIN_VALUE;
        if (j3 != Long.MIN_VALUE) {
            if (j3 != -1) {
                j5 = j + (j3 <= 9223372036854775L ? j3 * 1000 : Long.MAX_VALUE);
                long j6 = j5 >= j ? 253402300799999L : 253402300799999L;
                j2 = j6;
            } else {
                j2 = j4;
            }
            if (str7 != null) {
                str2 = qVar2.O00000Oo;
            } else {
                String str9 = qVar2.O00000Oo;
                if (!(str9.equals(str7) || (str9.endsWith(str7) && str9.charAt((str9.length() - str7.length()) - 1) == '.' && !jqp.O00000o0(str9)))) {
                    return null;
                }
                str2 = str7;
            }
            str3 = "/";
            str4 = str8;
            if (str4 != null || !str4.startsWith(str3)) {
                String O00000oO2 = qVar.O00000oO();
                lastIndexOf = O00000oO2.lastIndexOf(47);
                if (lastIndexOf != 0) {
                    str3 = O00000oO2.substring(0, lastIndexOf);
                }
                str5 = str3;
            } else {
                str5 = str4;
            }
            return new jpd(O00000o02, O00000o03, j2, str2, str5, z3, z4, z5, z6);
        }
        j2 = j5;
        if (str7 != null) {
        }
        str3 = "/";
        str4 = str8;
        if (str4 != null) {
        }
        String O00000oO22 = qVar.O00000oO();
        lastIndexOf = O00000oO22.lastIndexOf(47);
        if (lastIndexOf != 0) {
        }
        str5 = str3;
        return new jpd(O00000o02, O00000o03, j2, str2, str5, z3, z4, z5, z6);
    }

    public static List<jpd> O000000o(q qVar, jpi jpi) {
        int length = jpi.f2020O000000o.length / 2;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        for (int i = 0; i < length; i++) {
            if ("Set-Cookie".equalsIgnoreCase(jpi.O000000o(i))) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(2);
                }
                arrayList2.add(jpi.O00000Oo(i));
            }
        }
        List unmodifiableList = arrayList2 != null ? Collections.unmodifiableList(arrayList2) : Collections.emptyList();
        int size = unmodifiableList.size();
        for (int i2 = 0; i2 < size; i2++) {
            jpd O000000o2 = O000000o(System.currentTimeMillis(), qVar, (String) unmodifiableList.get(i2));
            if (O000000o2 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(O000000o2);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }
}
