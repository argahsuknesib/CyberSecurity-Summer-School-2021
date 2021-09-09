package _m_j;

import android.text.TextUtils;
import java.util.List;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public final class gsu {
    public static String O000000o(String str, List<gkw> list) {
        if (list == null || list.isEmpty()) {
            return str;
        }
        String O000000o2 = gkx.O000000o(list, "UTF-8");
        if (!str.contains("?")) {
            return str + "?" + O000000o2;
        }
        return str + "&" + O000000o2;
    }

    public static RequestBody O000000o(List<gkw> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        FormBody.Builder builder = new FormBody.Builder();
        for (gkw next : list) {
            String O000000o2 = next.O000000o();
            String O00000Oo = next.O00000Oo();
            if (!TextUtils.isEmpty(O000000o2) && O00000Oo != null) {
                builder.add(O000000o2, O00000Oo);
            }
        }
        return builder.build();
    }
}
