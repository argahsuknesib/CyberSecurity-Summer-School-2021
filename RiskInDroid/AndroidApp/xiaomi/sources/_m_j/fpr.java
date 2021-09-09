package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public final class fpr {

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f16885O000000o;
        public long O00000Oo;
    }

    public static List<String> O000000o(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(O00000Oo(context), 0);
            ArrayList<String> arrayList = new ArrayList<>(sharedPreferences.getAll().keySet());
            ArrayList<O000000o> arrayList2 = new ArrayList<>();
            for (String str : arrayList) {
                O000000o o000000o = new O000000o();
                o000000o.f16885O000000o = str;
                String string = sharedPreferences.getString(str, "");
                if (TextUtils.isEmpty(string)) {
                    o000000o.O00000Oo = 0;
                } else {
                    o000000o.O00000Oo = Long.parseLong(string);
                }
                arrayList2.add(o000000o);
            }
            Collections.sort(arrayList2, new Comparator<O000000o>() {
                /* class _m_j.fpr.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    O000000o o000000o = (O000000o) obj;
                    O000000o o000000o2 = (O000000o) obj2;
                    if (o000000o.O00000Oo > o000000o2.O00000Oo) {
                        return -1;
                    }
                    return o000000o.O00000Oo == o000000o2.O00000Oo ? 0 : 1;
                }
            });
            arrayList.clear();
            for (O000000o o000000o2 : arrayList2) {
                arrayList.add(o000000o2.f16885O000000o);
            }
            return arrayList;
        } catch (Exception e) {
            gsy.O000000o(5, "ChooseDeviceRecentSearh", "getRecentHistory: " + Log.getStackTraceString(e));
            return Collections.emptyList();
        }
    }

    public static String O00000Oo(Context context) {
        Locale O00000o0 = ftn.O00000o0(context);
        ServerBean O000000o2 = ftn.O000000o(context);
        String O0000o0 = CoreApi.O000000o().O0000o0();
        return "spfs_key_choose_device_search_history_".concat(String.valueOf(gpp.O00000Oo(flk.O000000o(O00000o0) + O000000o2 + O0000o0)));
    }
}
