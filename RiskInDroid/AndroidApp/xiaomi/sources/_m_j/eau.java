package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.io;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public final class eau {
    /* access modifiers changed from: private */
    public static String O00000o0(List<String> list) {
        String str = "";
        if (elj.O000000o(list)) {
            return str;
        }
        ArrayList<String> arrayList = new ArrayList<>(list);
        Collections.sort(arrayList, Collator.getInstance(Locale.CHINA));
        for (String str2 : arrayList) {
            if (!TextUtils.isEmpty(str)) {
                str = str + ",";
            }
            str = str + str2;
        }
        return str;
    }

    public static void O000000o(Context context, boolean z) {
        elo.O000000o(context).O000000o(new eav(context, z), 0);
    }

    public static void O000000o(Context context, io ioVar) {
        duv.O000000o("need to update local info with: " + ioVar.f133a);
        String str = ioVar.f133a.get("accept_time");
        if (str != null) {
            dzs.O0000ooO(context);
            String[] split = str.split("-");
            if (split.length == 2) {
                dzs.O00000Oo(context, split[0], split[1]);
                if (!"00:00".equals(split[0]) || !"00:00".equals(split[1])) {
                    b.O000000o(context).O000000o(false);
                } else {
                    b.O000000o(context).O000000o(true);
                }
            }
        }
        String str2 = ioVar.f133a.get("aliases");
        if (str2 != null) {
            dzs.O0000oOo(context);
            if (!"".equals(str2)) {
                for (String O00000o : str2.split(",")) {
                    dzs.O00000o(context, O00000o);
                }
            }
        }
        String str3 = ioVar.f133a.get("topics");
        if (str3 != null) {
            dzs.O0000oo(context);
            if (!"".equals(str3)) {
                for (String O0000OOo : str3.split(",")) {
                    dzs.O0000OOo(context, O0000OOo);
                }
            }
        }
        String str4 = ioVar.f133a.get("user_accounts");
        if (str4 != null) {
            dzs.O0000oo0(context);
            if (!"".equals(str4)) {
                for (String O00000oo : str4.split(",")) {
                    dzs.O00000oo(context, O00000oo);
                }
            }
        }
    }

    static /* synthetic */ String O000000o(List list) {
        String O000000o2 = eml.O000000o(O00000o0(list));
        return (TextUtils.isEmpty(O000000o2) || O000000o2.length() <= 4) ? "" : O000000o2.substring(0, 4).toLowerCase();
    }
}
