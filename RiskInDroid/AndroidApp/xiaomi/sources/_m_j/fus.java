package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;

public final class fus {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f17207O000000o = new Object();
    private static String O00000Oo;

    public static void O000000o() {
        synchronized (f17207O000000o) {
            O00000Oo = null;
        }
    }

    public static String O00000Oo() {
        String str;
        synchronized (f17207O000000o) {
            if (O00000Oo == null) {
                Context appContext = CommonApplication.getAppContext();
                boolean O0000O0o = ftn.O0000O0o(appContext);
                grr.O000000o();
                String O000000o2 = grr.O000000o(appContext);
                StringBuilder sb = new StringBuilder();
                grr.O000000o();
                sb.append(grr.O0000O0o().replace("-", ""));
                sb.append("-");
                grr.O000000o();
                sb.append(grr.O0000Oo0().replace("-", ""));
                sb.append("-");
                grr.O000000o();
                sb.append(grr.O00000Oo(appContext).replace("-", ""));
                sb.append("-");
                grr.O000000o();
                sb.append(grr.O0000Oo().replace("-", ""));
                sb.append("-");
                grr.O000000o();
                sb.append(grr.O0000o00().replace("-", ""));
                sb.append("-");
                grr.O000000o();
                sb.append(grr.O000000o(appContext, O0000O0o).replace("-", ""));
                sb.append("-");
                sb.append((O0000O0o ? grw.O00000Oo(O000000o2) : gqb.O00000oO(O000000o2)).replace("-", ""));
                sb.append("-");
                sb.append(CoreApi.O000000o().O0000o0());
                O00000Oo = sb.toString();
            }
            str = O00000Oo;
        }
        return str;
    }
}
