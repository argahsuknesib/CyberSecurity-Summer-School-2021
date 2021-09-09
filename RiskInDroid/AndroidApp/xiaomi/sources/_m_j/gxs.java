package _m_j;

import java.util.GregorianCalendar;

public final class gxs {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f18483O000000o;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;

    public static gxs O000000o(long j, String str, String str2, String str3) {
        gxs gxs = new gxs();
        gxs.f18483O000000o = j;
        gxs.O00000o0 = str;
        gxs.O00000o = str2;
        gxs.O00000oO = str3;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(j);
        gxs.O00000Oo = gregorianCalendar.get(11) + ":" + gregorianCalendar.get(12);
        return gxs;
    }
}
