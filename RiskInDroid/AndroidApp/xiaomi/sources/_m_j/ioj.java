package _m_j;

import android.content.Context;
import com.yanzhenjie.yp_permission.source.ContextSource;
import java.util.List;

public final class ioj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ipa f1517O000000o = new iph();

    public static iok O000000o(Context context) {
        return new iok(new ContextSource(context));
    }

    public static boolean O000000o(Context context, List<String> list) {
        ContextSource contextSource = new ContextSource(context);
        for (String O000000o2 : list) {
            if (!contextSource.O000000o(O000000o2)) {
                return true;
            }
        }
        return false;
    }
}
