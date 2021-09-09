package _m_j;

import android.content.Context;
import android.util.Log;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class fps {
    public static List<String> O000000o(Context context) {
        try {
            return new ArrayList(context.getSharedPreferences(O00000Oo(context), 0).getAll().keySet());
        } catch (Exception e) {
            gsy.O000000o(5, "ChooseDeviceRecentSearh", "getRecentHistory: " + Log.getStackTraceString(e));
            return Collections.emptyList();
        }
    }

    public static String O00000Oo(Context context) {
        Locale O00000o0 = ftn.O00000o0(context);
        ServerBean O000000o2 = ftn.O000000o(context);
        String O0000o0 = CoreApi.O000000o().O0000o0();
        return "spfs_key_choose_text_search_history_".concat(String.valueOf(gpp.O00000Oo(flk.O000000o(O00000o0) + O000000o2 + O0000o0)));
    }
}
