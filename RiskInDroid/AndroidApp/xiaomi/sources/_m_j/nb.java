package _m_j;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public final class nb implements mm {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f2192O000000o = 0;
    private int O00000Oo = 0;
    private int O00000o = 0;
    private int O00000o0 = 0;
    private int O00000oO = 0;
    private int O00000oo = 0;
    private TimeZone O0000O0o = null;
    private int O0000OOo;
    private boolean O0000Oo = false;
    private boolean O0000Oo0 = false;
    private boolean O0000OoO = false;

    public nb() {
    }

    public nb(Calendar calendar) {
        Date time = calendar.getTime();
        TimeZone timeZone = calendar.getTimeZone();
        GregorianCalendar gregorianCalendar = (GregorianCalendar) Calendar.getInstance(Locale.US);
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        gregorianCalendar.setTimeZone(timeZone);
        gregorianCalendar.setTime(time);
        this.f2192O000000o = gregorianCalendar.get(1);
        this.O00000Oo = gregorianCalendar.get(2) + 1;
        this.O00000o0 = gregorianCalendar.get(5);
        this.O00000o = gregorianCalendar.get(11);
        this.O00000oO = gregorianCalendar.get(12);
        this.O00000oo = gregorianCalendar.get(13);
        this.O0000OOo = gregorianCalendar.get(14) * 1000000;
        this.O0000O0o = gregorianCalendar.getTimeZone();
        this.O0000OoO = true;
        this.O0000Oo = true;
        this.O0000Oo0 = true;
    }

    public final int O000000o() {
        return this.f2192O000000o;
    }

    public final void O000000o(int i) {
        this.f2192O000000o = Math.min(Math.abs(i), 9999);
        this.O0000Oo0 = true;
    }

    public final void O000000o(TimeZone timeZone) {
        this.O0000O0o = timeZone;
        this.O0000Oo = true;
        this.O0000OoO = true;
    }

    public final int O00000Oo() {
        return this.O00000Oo;
    }

    public final void O00000Oo(int i) {
        if (i <= 0) {
            this.O00000Oo = 1;
        } else if (i > 12) {
            this.O00000Oo = 12;
        } else {
            this.O00000Oo = i;
        }
        this.O0000Oo0 = true;
    }

    public final int O00000o() {
        return this.O00000o;
    }

    public final void O00000o(int i) {
        this.O00000o = Math.min(Math.abs(i), 23);
        this.O0000Oo = true;
    }

    public final int O00000o0() {
        return this.O00000o0;
    }

    public final void O00000o0(int i) {
        if (i <= 0) {
            this.O00000o0 = 1;
        } else if (i > 31) {
            this.O00000o0 = 31;
        } else {
            this.O00000o0 = i;
        }
        this.O0000Oo0 = true;
    }

    public final int O00000oO() {
        return this.O00000oO;
    }

    public final void O00000oO(int i) {
        this.O00000oO = Math.min(Math.abs(i), 59);
        this.O0000Oo = true;
    }

    public final int O00000oo() {
        return this.O00000oo;
    }

    public final void O00000oo(int i) {
        this.O00000oo = Math.min(Math.abs(i), 59);
        this.O0000Oo = true;
    }

    public final int O0000O0o() {
        return this.O0000OOo;
    }

    public final void O0000O0o(int i) {
        this.O0000OOo = i;
        this.O0000Oo = true;
    }

    public final TimeZone O0000OOo() {
        return this.O0000O0o;
    }

    public final boolean O0000Oo() {
        return this.O0000Oo;
    }

    public final boolean O0000Oo0() {
        return this.O0000Oo0;
    }

    public final boolean O0000OoO() {
        return this.O0000OoO;
    }

    public final Calendar O0000Ooo() {
        GregorianCalendar gregorianCalendar = (GregorianCalendar) Calendar.getInstance(Locale.US);
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        if (this.O0000OoO) {
            gregorianCalendar.setTimeZone(this.O0000O0o);
        }
        gregorianCalendar.set(1, this.f2192O000000o);
        gregorianCalendar.set(2, this.O00000Oo - 1);
        gregorianCalendar.set(5, this.O00000o0);
        gregorianCalendar.set(11, this.O00000o);
        gregorianCalendar.set(12, this.O00000oO);
        gregorianCalendar.set(13, this.O00000oo);
        gregorianCalendar.set(14, this.O0000OOo / 1000000);
        return gregorianCalendar;
    }

    public final int compareTo(Object obj) {
        mm mmVar = (mm) obj;
        long timeInMillis = O0000Ooo().getTimeInMillis() - mmVar.O0000Ooo().getTimeInMillis();
        if (timeInMillis == 0) {
            timeInMillis = (long) (this.O0000OOo - mmVar.O0000O0o());
        }
        return (int) Math.signum((float) timeInMillis);
    }

    public final String toString() {
        return mv.O000000o(this);
    }
}
