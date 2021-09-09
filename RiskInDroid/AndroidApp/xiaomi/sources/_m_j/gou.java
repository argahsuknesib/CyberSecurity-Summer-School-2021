package _m_j;

import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class gou {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Calendar f18098O000000o;
    private static Calendar O00000Oo;

    private static synchronized void O000000o() {
        synchronized (gou.class) {
            if (f18098O000000o == null) {
                f18098O000000o = Calendar.getInstance();
                f18098O000000o.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                O00000Oo = Calendar.getInstance();
            }
        }
    }

    private static long O000000o(long j, int i, int i2) {
        O000000o();
        f18098O000000o.setTimeInMillis(j + (((long) i) * 86400000));
        f18098O000000o.set(11, i2);
        f18098O000000o.set(12, 0);
        return f18098O000000o.getTimeInMillis();
    }

    private static boolean O000000o(long j, long j2, int i) {
        O000000o();
        if (j2 <= O000000o(j, i, 0) || j2 >= O000000o(j, i, 24)) {
            return false;
        }
        return true;
    }

    public static String O000000o(long j) {
        long j2;
        O000000o();
        TimeZone timeZone = f18098O000000o.getTimeZone();
        TimeZone timeZone2 = O00000Oo.getTimeZone();
        if (timeZone == null || timeZone2 == null || timeZone.hasSameRules(timeZone2)) {
            j2 = j;
        } else {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            j2 = ((long) (timeZone.getOffset(currentTimeMillis) - timeZone2.getOffset(currentTimeMillis))) + j;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        Locale locale = CoreApi.O000000o().O00oOooo() == null ? Locale.getDefault() : CoreApi.O000000o().O00oOooo();
        if (!(locale == null || locale.equals(Locale.CHINA))) {
            if (O000000o(currentTimeMillis2, j2, 0)) {
                return new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(new Timestamp(j));
            }
            return new SimpleDateFormat(gwc.O00000Oo(locale)).format(new Timestamp(j));
        } else if (O000000o(currentTimeMillis2, j2, 0)) {
            return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Timestamp(j));
        } else {
            if (O000000o(currentTimeMillis2, j2, -1)) {
                return gqb.O000000o(CommonApplication.getAppContext(), (int) R.string.yesterday);
            }
            if (O000000o(currentTimeMillis2, j2, -2)) {
                return gqb.O000000o(CommonApplication.getAppContext(), (int) R.string.before_yesterday);
            }
            Date date = new Date(j);
            Calendar instance = Calendar.getInstance();
            instance.setTime(date);
            f18098O000000o.setTime(new Date(currentTimeMillis2));
            if (instance.get(1) != f18098O000000o.get(1)) {
                return new SimpleDateFormat(gwc.O00000Oo(locale)).format(new Timestamp(j));
            }
            return (instance.get(2) + 1) + gqb.O000000o(CommonApplication.getAppContext(), (int) R.string.month) + instance.get(5) + gqb.O000000o(CommonApplication.getAppContext(), (int) R.string.day2);
        }
    }

    public static String O00000Oo(long j) {
        O000000o();
        String format = new SimpleDateFormat(gwc.O00000Oo(CoreApi.O000000o().O00oOooo())).format(new Timestamp(j));
        f18098O000000o.setTimeInMillis(j);
        return format + " " + (f18098O000000o.get(11) + ":" + f18098O000000o.get(12) + ":" + f18098O000000o.get(13));
    }

    public static String O00000o0(long j) {
        O000000o();
        long currentTimeMillis = System.currentTimeMillis();
        if (O000000o(currentTimeMillis, j, 0)) {
            return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Timestamp(j));
        }
        if (O000000o(currentTimeMillis, j, -1)) {
            String O000000o2 = gqb.O000000o(CommonApplication.getAppContext(), (int) R.string.yesterday);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.CHINA);
            return O000000o2 + " " + simpleDateFormat.format(new Timestamp(j));
        } else if (!O000000o(currentTimeMillis, j, -2)) {
            return new SimpleDateFormat("MM/dd HH:mm", Locale.CHINA).format(new Timestamp(j));
        } else {
            String O000000o3 = gqb.O000000o(CommonApplication.getAppContext(), (int) R.string.before_yesterday);
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm", Locale.CHINA);
            return O000000o3 + " " + simpleDateFormat2.format(new Timestamp(j));
        }
    }

    public static String[] O00000o(long j) {
        O000000o();
        long currentTimeMillis = System.currentTimeMillis();
        if (O000000o(currentTimeMillis, j, 0)) {
            return new String[]{new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Timestamp(j))};
        } else if (O000000o(currentTimeMillis, j, -1)) {
            return new String[]{gqb.O000000o(CommonApplication.getAppContext(), (int) R.string.yesterday), new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Timestamp(j))};
        } else {
            return new String[]{new SimpleDateFormat(gwc.O00000Oo(CoreApi.O000000o().O00oOooo())).format(new Timestamp(j)), new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Timestamp(j))};
        }
    }
}
