package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import java.net.URLEncoder;

public final class fln {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile String f16580O000000o;
    private static Object O00000Oo = new Object();

    private static boolean O000000o(char c) {
        return c > 31 && c < 127;
    }

    public static void O000000o() {
        synchronized (O00000Oo) {
            f16580O000000o = null;
        }
    }

    public static String O000000o(Context context) {
        synchronized (O00000Oo) {
            if (f16580O000000o == null) {
                boolean O0000O0o = ftn.O0000O0o(context);
                grr.O000000o();
                String O000000o2 = grr.O000000o(context);
                ServerBean O000000o3 = ftn.O000000o(context);
                String str = O000000o3 != null ? O000000o3.O00000Oo : "";
                StringBuilder sb = new StringBuilder();
                grr.O000000o();
                sb.append(grr.O0000O0o().replace("-", ""));
                sb.append("-");
                grr.O000000o();
                sb.append(grr.O0000Oo0().replace("-", ""));
                sb.append("-");
                grr.O000000o();
                sb.append(grr.O00000Oo(context).replace("-", ""));
                sb.append("-");
                grr.O000000o();
                sb.append(grr.O0000OoO().replace("-", ""));
                sb.append("-");
                grr.O000000o();
                sb.append(grr.O0000Oo().replace("-", ""));
                sb.append("-");
                grr.O000000o();
                sb.append(grr.O0000o00().replace("-", ""));
                sb.append("-");
                grr.O000000o();
                sb.append(grr.O000000o(context, O0000O0o).replace("-", ""));
                sb.append("-");
                sb.append(str.replace("-", ""));
                sb.append("-");
                sb.append((O0000O0o ? grw.O00000Oo(O000000o2) : gqb.O00000oO(O000000o2)).replace("-", ""));
                sb.append("-");
                sb.append(gqb.O00000oO(fcn.O000000o().O00000Oo()));
                sb.append("-SmartHome-");
                sb.append(gfr.O0000o0O);
                sb.append("-");
                sb.append(wb.O000000o(context));
                f16580O000000o = O000000o(sb.toString());
            }
        }
        return f16580O000000o;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0029 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A[SYNTHETIC, Splitter:B:14:0x002a] */
    private static String O000000o(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (!O000000o(str.charAt(i))) {
                    z = false;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                return str;
            }
            try {
                StringBuilder sb = new StringBuilder(str.length());
                int length2 = str.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    char charAt = str.charAt(i2);
                    if (!O000000o(charAt)) {
                        sb.append(URLEncoder.encode(String.valueOf(charAt), "UTF-8"));
                    } else {
                        sb.append(charAt);
                    }
                }
                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return str;
            }
        }
        z = true;
        if (!z) {
        }
    }
}
