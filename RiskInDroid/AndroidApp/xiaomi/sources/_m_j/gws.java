package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public final class gws extends gwp {

    /* renamed from: O000000o  reason: collision with root package name */
    public volatile boolean f18427O000000o = false;
    public String O00000Oo;
    public String O00000o;
    public String O00000o0;
    public String O00000oO;
    private long O00000oo = -1;
    private List<Integer> O0000O0o = new ArrayList();
    private Runnable O0000OOo = new Runnable() {
        /* class _m_j.gws.AnonymousClass1 */

        public final void run() {
            gws.this.f18427O000000o = false;
        }
    };

    public gws() {
        this.O0000O0o.add(0);
        this.O0000O0o.add(1);
        this.O0000O0o.add(2);
    }

    public static String O000000o(Context context, String str) {
        String[] O00000Oo2 = gwu.O00000Oo(context, str);
        return (O00000Oo2 == null || O00000Oo2.length < 3) ? "" : O000000o(context, O00000Oo2[0], O00000Oo2[1], O00000Oo2[2]);
    }

    public static String O000000o(Context context, String str, String str2, String str3) {
        if (!TextUtils.equals(str, str2)) {
            if (TextUtils.equals(str2, str3)) {
                return str3;
            }
            return str2 + context.getString(R.string.area_center_dot) + str3;
        } else if (TextUtils.equals(str, str3) || TextUtils.equals(str2, str3)) {
            return str3;
        } else {
            return str2 + context.getString(R.string.area_center_dot) + str3;
        }
    }

    public final String O000000o() {
        return this.O00000Oo;
    }

    public final String O00000Oo() {
        return this.O00000o0;
    }

    public final String O00000o0() {
        return this.O00000o;
    }

    public final String O00000o() {
        return gqb.O0000O0o(this.O00000oO);
    }
}
