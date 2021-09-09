package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ftj {
    public static void O000000o(Context context) {
        String O0000o0 = CoreApi.O000000o().O0000o0();
        SharedPreferences sharedPreferences = context.getSharedPreferences("sp_login_list_recent", 0);
        ArrayList<String> O00000Oo = O00000Oo(context);
        if (O00000Oo.contains(O0000o0)) {
            if (O00000Oo.size() != 1) {
                Collections.swap(O00000Oo, O00000Oo.indexOf(O0000o0), 0);
            }
        } else if (O00000Oo.size() >= 4) {
            O00000Oo.remove(0);
            O00000Oo.add(O0000o0);
            sharedPreferences.edit().putString("user.recently.mid", O000000o(O00000Oo)).apply();
        } else {
            O00000Oo.add(O0000o0);
            sharedPreferences.edit().putString("user.recently.mid", O000000o(O00000Oo)).apply();
        }
    }

    private static ArrayList<String> O00000Oo(Context context) {
        String string = context.getSharedPreferences("sp_login_list_recent", 0).getString("user.recently.mid", "");
        if (TextUtils.isEmpty(string)) {
            return new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(string.split(":")));
    }

    private static String O000000o(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(":");
            }
        }
        return sb.toString();
    }
}
