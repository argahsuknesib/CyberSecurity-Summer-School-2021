package _m_j;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

public final class az {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Locale f12718O000000o = new Locale("", "");

    public static int O000000o(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
        if (locale != null && !locale.equals(f12718O000000o)) {
            String O000000o2 = aw.O000000o(locale);
            if (O000000o2 == null) {
                byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
                if (directionality == 1 || directionality == 2) {
                    return 1;
                }
                return 0;
            } else if (O000000o2.equalsIgnoreCase("Arab") || O000000o2.equalsIgnoreCase("Hebr")) {
                return 1;
            }
        }
        return 0;
    }
}
