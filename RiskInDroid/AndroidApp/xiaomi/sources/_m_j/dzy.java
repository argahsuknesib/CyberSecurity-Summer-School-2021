package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.ff;
import com.xiaomi.push.iq;
import com.xiaomi.push.iw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class dzy {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Map<String, b.a> f15110O000000o = new HashMap();
    private static Map<String, Long> O00000Oo = new HashMap();

    public static void O000000o(iw iwVar) {
        eab.O000000o(ff.b.f30a, null, iwVar.f6448a, iwVar.d, null);
    }

    public static void O000000o(Context context, iq iqVar) {
        b.a aVar;
        String str = iqVar.g;
        if (iqVar.f148a == 0 && (aVar = f15110O000000o.get(str)) != null) {
            String str2 = iqVar.e;
            String str3 = iqVar.f;
            aVar.O00000o0 = str2;
            aVar.O00000o = str3;
            aVar.O00000oo = erv.O0000Oo0(aVar.O0000Ooo);
            aVar.O00000oO = aVar.O00000Oo();
            aVar.O0000Oo0 = true;
            b O000000o2 = b.O000000o(context);
            O000000o2.O00000o0.put(str, aVar);
            b.O00000Oo(O000000o2.f6053O000000o).edit().putString("hybrid_app_info_".concat(String.valueOf(str)), b.a.O000000o(aVar)).commit();
        }
        ArrayList arrayList = null;
        if (!TextUtils.isEmpty(iqVar.e)) {
            arrayList = new ArrayList();
            arrayList.add(iqVar.e);
        }
        eab.O000000o(ff.f6377a.f30a, arrayList, iqVar.f148a, iqVar.d, null);
    }
}
