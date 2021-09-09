package _m_j;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class clw {
    private static clw O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    private SimpleDateFormat f14115O000000o = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmssSSS");
    private SimpleDateFormat O00000Oo = new SimpleDateFormat("'VID'_yyyyMMdd_HHmmss");

    private clw() {
    }

    public static synchronized clw O000000o() {
        clw clw;
        synchronized (clw.class) {
            if (O00000o0 == null) {
                O00000o0 = new clw();
            }
            clw = O00000o0;
        }
        return clw;
    }

    public final synchronized String O000000o(long j, boolean z) {
        String str;
        Date date = new Date(j);
        if (z) {
            str = this.O00000Oo.format(date);
        } else {
            str = this.f14115O000000o.format(date);
        }
        return str;
    }

    public final long O000000o(String str, boolean z) {
        if (!z) {
            return this.f14115O000000o.parse(str).getTime();
        }
        try {
            return this.O00000Oo.parse(str).getTime();
        } catch (Exception unused) {
            return 0;
        }
    }
}
