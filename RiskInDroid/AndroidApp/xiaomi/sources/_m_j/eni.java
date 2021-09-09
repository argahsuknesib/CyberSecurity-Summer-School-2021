package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.ht;
import java.text.SimpleDateFormat;

public final class eni {

    /* renamed from: O000000o  reason: collision with root package name */
    private static SimpleDateFormat f15651O000000o;
    private static String O00000Oo;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f15651O000000o = simpleDateFormat;
        O00000Oo = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static ht O000000o(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ht htVar = new ht();
        htVar.d = "category_push_stat";
        htVar.f52a = "push_sdk_stat_channel";
        htVar.O000000o(1);
        htVar.f56b = str;
        htVar.O000000o(true);
        htVar.O00000Oo(System.currentTimeMillis());
        htVar.g = emr.O000000o(context).O00000Oo;
        htVar.e = "com.xiaomi.xmsf";
        htVar.f = "";
        htVar.c = "push_stat";
        return htVar;
    }
}
