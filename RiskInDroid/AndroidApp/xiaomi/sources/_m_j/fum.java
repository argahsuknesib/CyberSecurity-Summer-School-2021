package _m_j;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public final class fum {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f17191O000000o;
    public long O00000Oo;
    public String O00000o;
    public long O00000o0;

    public fum(long j, long j2, long j3, String str) {
        this.f17191O000000o = j;
        this.O00000Oo = j2;
        this.O00000o0 = j3;
        this.O00000o = str;
    }

    public static String O000000o(long j) {
        SimpleDateFormat simpleDateFormat;
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j * 1000);
        if (Locale.getDefault().equals(Locale.CHINA)) {
            simpleDateFormat = new SimpleDateFormat("MM月dd日HH:mm", Locale.CHINA);
        } else {
            simpleDateFormat = new SimpleDateFormat("HH:mm MM/dd", Locale.UK);
        }
        return simpleDateFormat.format(instance.getTime());
    }
}
