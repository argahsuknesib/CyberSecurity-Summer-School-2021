package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.R;

public final class fug {
    public static String O000000o(String str, Context context) {
        int i = 0;
        for (String equals : context.getResources().getStringArray(R.array.city_timezone)) {
            if (equals.equals(str)) {
                return context.getResources().getStringArray(R.array.timezone_city_name)[i];
            }
            i++;
        }
        return "";
    }
}
