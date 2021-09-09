package _m_j;

import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public final class gxu {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f18484O000000o;
    public int O00000Oo;
    public long O00000o;
    public String O00000o0;
    public ArrayList<gxs> O00000oO = new ArrayList<>();

    public final void O000000o(long j) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(j);
        this.f18484O000000o = gregorianCalendar.get(5);
        this.O00000Oo = gregorianCalendar.get(2) + 1;
        this.O00000o0 = O000000o(gregorianCalendar.get(7));
        this.O00000o = j;
    }

    public static String O000000o(int i) {
        return ServiceApplication.getAppContext().getResources().getStringArray(R.array.weekday)[i - 1];
    }
}
