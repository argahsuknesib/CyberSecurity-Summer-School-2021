package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.util.Locale;

public final class ftl {
    public static String O000000o() {
        ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
        if (O0000ooO != null) {
            return O0000ooO.O00000Oo;
        }
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo != null) {
            return O00oOooo.getCountry();
        }
        return Locale.getDefault().getCountry();
    }

    public static boolean O00000Oo() {
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo == null) {
            O00oOooo = Locale.getDefault();
        }
        return TextUtils.equals(Locale.SIMPLIFIED_CHINESE.getCountry(), O00oOooo.getCountry()) && TextUtils.equals(Locale.SIMPLIFIED_CHINESE.getLanguage(), O00oOooo.getLanguage());
    }
}
