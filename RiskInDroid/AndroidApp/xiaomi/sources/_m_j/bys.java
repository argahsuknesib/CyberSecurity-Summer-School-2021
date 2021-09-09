package _m_j;

import _m_j.cej;
import android.content.Context;
import com.google.gson.Gson;

public final class bys {
    public static void O000000o(Context context, String str, Object obj) {
        cej.O00000Oo.O000000o(context, str, new Gson().toJson(obj));
    }

    public static <T> T O000000o(Context context, String str, Class cls) {
        return new Gson().fromJson(cej.O00000Oo.O00000Oo(context, str, ""), cls);
    }
}
