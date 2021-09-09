package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class mi {

    /* renamed from: O000000o  reason: collision with root package name */
    private static SimpleDateFormat f2183O000000o = new SimpleDateFormat("MM-dd HH:mm:ss");
    private static SimpleDateFormat O00000Oo = new SimpleDateFormat("HH:mm:ss");
    private static SimpleDateFormat O00000o = new SimpleDateFormat(gkv.f17949O000000o.getResources().getString(R.string.month_day_format));
    private static SimpleDateFormat O00000o0 = new SimpleDateFormat("MM/dd");
    private static TimeZone O00000oO = TimeZone.getDefault();

    public static TimeZone O000000o() {
        return TimeZone.getDefault();
    }

    public static String O000000o(long j) {
        return O00000Oo.format(Long.valueOf(j));
    }

    public static String O00000Oo(long j) {
        return f2183O000000o.format(new Date(j));
    }

    public static String O00000o0(long j) {
        return O00000o0.format(new Date(j));
    }

    public static String O00000o(long j) {
        return O00000o.format(new Date(j));
    }

    public static void O00000Oo() {
        TimeZone timeZone = TimeZone.getDefault();
        if (!O00000oO.getID().equals(timeZone)) {
            f2183O000000o = new SimpleDateFormat("MM-dd HH:mm:ss");
            O00000Oo = new SimpleDateFormat("HH:mm:ss");
            O00000o0 = new SimpleDateFormat("MM/dd");
            O00000oO = timeZone;
        }
    }

    public static String O00000oO(long j) {
        String language = gkv.f17949O000000o.getResources().getConfiguration().locale.getLanguage();
        if (TextUtils.isEmpty(language) || !"zh".equalsIgnoreCase(language)) {
            return O00000o(j);
        }
        return new SimpleDateFormat("MM月dd日").format(Long.valueOf(j));
    }
}
